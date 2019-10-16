## Input Validation Part 1

When this activity is started, this screen pops out asking for us to search for an username based on an input from the user

![search page]()

Based on the source code, the input is being sent into a sql query which will return all the details of the user

This means that the user details is probably stored in a sql database! Does that mean it is sql injectable?


#### The vulnerability

So, to check whether the database is sql injectable, we need to find out whether the input is santitized

        EditText srchtxt = (EditText) findViewById(R.id.ivi1search);
        Cursor cr = null;
        try {
            cr = mDB.rawQuery("SELECT * FROM sqliuser WHERE user = '" + srchtxt.getText().toString() + "'", null);
            StringBuilder strb = new StringBuilder("");
            if ((cr != null) && (cr.getCount() > 0)) {
                cr.moveToFirst();

                do {
                    strb.append("User: (" + cr.getString(0) + ") pass: (" + cr.getString(1) + ") Credit card: (" + cr.getString(2) + ")\n");
                } while (cr.moveToNext());
            }
            else {
                strb.append("User: (" + srchtxt.getText().toString() +") not found");
            }
            Toast.makeText(this, strb.toString(), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
            Log.d("Diva-sqli", "Error occurred while searching in database: " + e.getMessage());
        }

NOPE! The input is being directly inserted into the query  by the variable name cr, meaning that if I typed in a malicious input, I would be able to get all the data out from the database!!!

#### The exploit

The input is being covered by 2 single quotes, so the input Im gonna type in is 

        ' OR '1' = '1' --

The first single quote is used to closed the single quote at the start of the query, "OR '1' = '1'" is to make the whole statement true
as since 1 is always equal to 1, so the statement will always return true, allowing the query return everything in the database

"--" is to comment out unecessary commands such that they would not be execute

![exploited!!!]()


            
