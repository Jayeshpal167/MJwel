package jwel.prime.com.mjwel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import jwel.prime.com.mjwel.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gotoAuthentication = new Intent(SplashActivity.this, Authentication.class);
                startActivity(gotoAuthentication);
                finish();
            }
        }, 2500);
    }
}
