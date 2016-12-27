package com.codyy.lib.crash.email.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codyy.lib.crash.CrashMail;
import com.codyy.lib.crash.MailUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            MailUtils.sendMail(new CrashMail("mail.codyy.cn", "title", "log", "android@codyy.com", "运营平台2.2.0", "android", "lijian@codyy.com", "李健"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
