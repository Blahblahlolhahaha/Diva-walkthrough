/*
 * Decompiled with CFR <Could not determine version>.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.Editable
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.Toast
 */
package jakhar.aseem.diva;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HardcodeActivity
extends AppCompatActivity {
    public void access(View view) {
        if (((EditText)this.findViewById(2131492987)).getText().toString().equals("vendorsecretkey")) {
            Toast.makeText((Context)this, (CharSequence)"Access granted! See you on the other side :)", (int)0).show();
            return;
        }
        Toast.makeText((Context)this, (CharSequence)"Access denied! See you in hell :D", (int)0).show();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968607);
    }
}

