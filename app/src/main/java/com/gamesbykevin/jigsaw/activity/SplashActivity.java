package com.gamesbykevin.jigsaw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gamesbykevin.jigsaw.R;

import static com.gamesbykevin.jigsaw.services.BaseGameActivity.BYPASS_LOGIN;

public class SplashActivity extends BaseActivity {

    /**
     * The amount of time to display the splash screen (in milliseconds)
     */
    public static final long SPLASH_DELAY = 2500L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //call parent
        super.onCreate(savedInstanceState);

        //assign our layout
        setContentView(R.layout.activity_splash);

        //if auto login is set to false, then bypass login will be set to true
        if (!getBooleanValue(R.string.google_play_auto_login_file_key))
            BYPASS_LOGIN = true;
    }

    @Override
    public void onResume() {

        //call parent
        super.onResume();

        //delay a couple seconds before going to main page
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //start the new activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                //close the activity
                finish();

            }

        }, SPLASH_DELAY);
    }

    @Override
    public void onBackPressed() {

        //don't allow user to press back button
        return;
    }
}