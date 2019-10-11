/*
 * Decompiled with CFR <Could not determine version>.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.Editable
 *  android.util.Log
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.Toast
 */
package jakhar.aseem.diva;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity
extends AppCompatActivity {
    private void processCC(String string2) {
        throw new RuntimeException();
    }

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

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968615);
    }
}

