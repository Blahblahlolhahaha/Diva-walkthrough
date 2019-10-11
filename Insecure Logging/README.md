## Insecure logging

#### The vulnerability

The following code shows that the app prints out the credit card number entered into the form directly into the logs, which makes it easy for
people to obtain the credit card nnumber of the person



        public void checkout(View view) {
        
              view = (EditText)this.findViewById(2131493014);

              try {

                  this.processCC(view.getText().toString());

                  return;

              }

              catch (RuntimeException runtimeException) {

                  Log.e((String)"diva-log", (String)("Error while processing transaction with credit card: " + view.getText().toString()));

                  Toast.makeText((Context)this, (CharSequence)"An error occured. Please try again later", (int)0).show();

                  return;

              }

          }
          
          
#### The exploit
To get the credit card number, just adb logcat

![phone](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Insecure%20Logging/Screenshot%20from%202019-10-11%2002-26-15(1).jpg)

![log](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Insecure%20Logging/Screenshot%20from%202019-10-11%2002-26-15(2).jpg)
