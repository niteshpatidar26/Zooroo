package com.example.admin.zooroo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {


                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();

            }
        },2000);
    }
}
