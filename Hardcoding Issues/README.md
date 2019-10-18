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
 
![proof!!!](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Hardcoding%20Issues/Screenshot%20from%202019-10-11%2002-47-21.png)






## Hardcoding issues part 2

This time, the string isnt really hardcoded into the code 

        public class Hardcode2Activity extends AppCompatActivity {

            private DivaJni djni;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_hardcode2);

                djni = new DivaJni();
            }

            public void access(View view) {
                EditText hckey = (EditText) findViewById(R.id.hc2Key);

                if (djni.access(hckey.getText().toString()) != 0) {
                    Toast.makeText(this, "Access granted! See you on the other side :)", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Access denied! See you in hell :D", Toast.LENGTH_SHORT).show();
                }
            }
        }
        
But interestingly, an instance of Divajni known as djni is created as shown in the code and whether you are granted access is based on the access method in Divajni

So lets check out!

        public class DivaJni {

            private static final String soName =  "divajni";

            static
            {
                System.loadLibrary(soName);
            }
            // Jni function
            // Returns 1 if the key specified by user is valid, 0 otherwise
            public native int access(String key);
            public native int initiateLaunchSequence(String code);
        }

So this class imports a native library known as divajni. The access method calls a function found in the library. So how to get the string out?

Lets try this in the terminal

So first extract the apk first.

Then open the terminal in the extracted folder

navigate to app/src/main/libs and choose any arch folder then you will find a file called libdivajni.so inside.

So lets try:

        strings libdivajni.so
        
Here's the output of the command 

        Android
        5594570
        __cxa_atexit
        LIBC
        libc.so
        libdivajni.so
        __cxa_finalize
        __stack_chk_fail
        JNI_OnLoad
        Java_jakhar_aseem_diva_DivaJni_access
        Java_jakhar_aseem_diva_DivaJni_initiateLaunchSequence
        memcmp
        strcpy
        strncmp
        _edata
        __bss_start
        _end
        libm.so
        libstdc++.so
        libdl.so
        olsdfgad;lh
        .dotdot
        ;*2$"
        Android (5220042 based on r346389c) clang version 8.0.7 (https://android.googlesource.com/toolchain/clang b55f2d4ebfd35bf643d27dbca1bb228957008617) (https://android.googlesource.com/toolchain/llvm 3c393fe7a7e13b0fba4ac75a01aa683d7a5b11cd) (based on LLVM 8.0.7svn)
        gold 1.12
        .shstrtab
        .note.android.ident
        .note.gnu.build-id
        .dynsym
        .dynstr
        .gnu.hash
        .gnu.version
        .gnu.version_d
        .gnu.version_r
        .rel.dyn
        .rel.plt
        .text
        .rodata
        .eh_frame
        .eh_frame_hdr
        .fini_array
        .dynamic
        .got
        .got.plt
        .data
        .comment
        .note.gnu.gold-version

Whats the possible keys? 

        olsdfgad;lh
        .dotdot
These 2 makes the most sense as they made no sense in the library so lets try!

![dotdot](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Hardcoding%20Issues/Screenshot_1571386181.png)
![correct](https://github.com/Blahblahlolhahaha/Diva-walkthrough/blob/master/Hardcoding%20Issues/Screenshot_1571387029.png)

As shown from above, it seems that its olsdfgad;lh!


