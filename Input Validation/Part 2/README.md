## Input Validation Part 2


#### The vulnerability

When this activity started, a text form pops out, telling you that it will show you any url page that you type inside

![URL](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Input%20Validation/Part%202/Screenshot_1571356492.jpg)


Heres the code:

            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_input_validation2_urischeme);
                WebView wview = (WebView) findViewById(R.id.ivi2wview);
                WebSettings wset = wview.getSettings();
                wset.setJavaScriptEnabled(true);

            }

            public void get(View view) {
                EditText uriText = (EditText) findViewById(R.id.ivi2uri);
                WebView wview = (WebView) findViewById(R.id.ivi2wview);

                wview.loadUrl(uriText.getText().toString());
            }
        }


so basically, the url typed into the form is not being processed, meaning that we will be able to access personal files inside 
the phone by typing url starting wtih "file://"

#### The exploit

So Im just gonna type in the url for the .uinfo file we found just now 

![oh yeah](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Input%20Validation/Part%202/Screenshot_1571356952.jpg)

### THERE YOU GO!

