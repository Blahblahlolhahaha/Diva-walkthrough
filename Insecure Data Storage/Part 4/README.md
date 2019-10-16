## Insecure Data Storage Part 4

#### The vulnerability

This time the data is stored in the external directory in a file called .uinfo.txt

        File sdir = Environment.getExternalStorageDirectory();

        try {
            File uinfo = new File(sdir.getAbsolutePath() + "/.uinfo.txt");
            uinfo.setReadable(true);
            uinfo.setWritable(true);
            FileWriter fw = new FileWriter(uinfo);
            fw.write(usr.getText().toString() + ":" + pwd.getText().toString() + "\n");
            fw.close();
            Toast.makeText(this, "3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();
            // Now you can read the temporary file where ever the credentials are required.
        }
        
To get it, simply adb then cat .uinfo.txt

        root@generic_x86_64:/storage/sdcard # ls -al
        lstat './.android_secure' failed: Permission denied
        -rwxrwx--- root     sdcard_r       33 2019-10-16 08:50 .uinfo.txt
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Alarms
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 DCIM
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Download
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 LOST.DIR
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Movies
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Music
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Notifications
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Pictures
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Podcasts
        drwxrwx--- root     sdcard_r          2019-10-16 08:25 Ringtones
        root@generic_x86_64:/storage/sdcard # cat .uinfo.txt
        Bottas:TOWHOMITMAYCONCERNFUCKYOU

### BINGO !!!!
