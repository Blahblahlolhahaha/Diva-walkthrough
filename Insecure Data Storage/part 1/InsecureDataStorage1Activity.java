/*
 * Decompiled with CFR <Could not determine version>.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.text.Editable
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.Toast
 */
package jakhar.aseem.diva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsecureDataStorage1Activity
extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968611);
    }

    public void saveCredentials(View view) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)this).edit();
        view = (EditText)this.findViewById(2131493000);
        EditText editText = (EditText)this.findViewById(2131493001);
        editor.putString("user", view.getText().toString());
        editor.putString("password", editText.getText().toString());
        editor.commit();
        Toast.makeText((Context)this, (CharSequence)"3rd party credentials saved successfully!", (int)0).show();
    }
}

