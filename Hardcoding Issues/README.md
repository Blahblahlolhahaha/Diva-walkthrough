## Hardcoding issues part 1

### The vulnerability

The password is being hardcoded in the source codes as shown below

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

### The exploit

password is vendorsecretkey
