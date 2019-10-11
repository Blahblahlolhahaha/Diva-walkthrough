## Insecure Data Storage Part 2

This one is similiar to part 1, just that this time the username and password got stored in a database called ids2
        
        try {
            this.mDB = this.openOrCreateDatabase("ids2", 0, null);
            this.mDB.execSQL("CREATE TABLE IF NOT EXISTS myuser(user VARCHAR, password VARCHAR);");
        }

and

        view = (EditText)this.findViewById(2131493003);
        EditText editText = (EditText)this.findViewById(2131493004);
        try {
            SQLiteDatabase sQLiteDatabase = this.mDB;
            StringBuilder stringBuilder = new StringBuilder();
            sQLiteDatabase.execSQL(stringBuilder.append("INSERT INTO myuser VALUES ('").append(view.getText().toString()).append("', '").append(editText.getText().toString()).append("');").toString());
            this.mDB.close();
        }

To get out the data, just type these commands in the terminal

      adb root
      adb pull /data/data/jakhar.aseem.diva/databases/ids2

then open the database to get the username and password using DB browser for sqlite

