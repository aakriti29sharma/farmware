package com.infinitefarmer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Bundle bundle = getIntent().getExtras();

      if (bundle != null && PrefManager.isLoggedIn(this) && bundle.getString("type") != null) {
            try {
                switch (PrefManager.getUserType(this)) {
                    case "farmer":
                        startActivity(new Intent(this, ImageUploadActivity.class).putExtras(bundle));
                        finish();
                        break;
                    case "buyer":
                        startActivity(new Intent(this, MainActivity.class).putExtras(bundle));

                    default:
                        Toast.makeText(this, "Check your internet connection!", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(SplashActivity.this, SignUpOne.class));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            final Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    } finally {
                        Intent intent;
                        setUpLocale();
                        if (PrefManager.isLoggedIn(SplashActivity.this)) {
                            //Handle Returning User
                            intent = new Intent(SplashActivity.this, ImageUploadActivity.class);
                            startActivity(intent);

                        } else {
                            //Handle new or logged out user
                            intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                        }


                    }
                }


            };
            timer.start();
        }
    }

    private void setUpLocale() {
        Locale locale = new Locale(PrefManager.getLanguage(SplashActivity.this));
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }



    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
