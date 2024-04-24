package app.ralpdevs.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import app.ralpdevs.tictactoe.R;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY = 3500;
    private ImageView rLetter, aLetter, lLetter, pLetter, dLetter, eLetter, vLetter, sLetter;
    private Animation rotateR, rotateA, rotateL, rotateP, rotateD, rotateE, rotateV, rotateS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        setContentView(R.layout.activity_splash);

        initialize();

        playAnimations();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intentToMenu();
            }
        }, SPLASH_DELAY);
    }

    private void initialize(){

        rLetter = (ImageView) findViewById(R.id.letter_r);
        aLetter = (ImageView) findViewById(R.id.letter_a);
        lLetter = (ImageView) findViewById(R.id.letter_l);
        pLetter = (ImageView) findViewById(R.id.letter_p);
        dLetter = (ImageView) findViewById(R.id.letter_d);
        eLetter = (ImageView) findViewById(R.id.letter_e);
        vLetter = (ImageView) findViewById(R.id.letter_v);
        sLetter = (ImageView) findViewById(R.id.letter_s);

    }

    private void playAnimations(){
        rotateR = AnimationUtils.loadAnimation(this,R.anim.rotate_r);
        rLetter.startAnimation(rotateR);
        rotateA = AnimationUtils.loadAnimation(this,R.anim.rotate_a);
        aLetter.startAnimation(rotateA);
        rotateL = AnimationUtils.loadAnimation(this,R.anim.rotate_l);
        lLetter.startAnimation(rotateL);
        rotateP = AnimationUtils.loadAnimation(this,R.anim.rotate_p);
        pLetter.startAnimation(rotateP);
        rotateD = AnimationUtils.loadAnimation(this,R.anim.rotate_d);
        dLetter.startAnimation(rotateD);
        rotateE = AnimationUtils.loadAnimation(this,R.anim.rotate_e);
        eLetter.startAnimation(rotateE);
        rotateV = AnimationUtils.loadAnimation(this,R.anim.rotate_v);
        vLetter.startAnimation(rotateV);
        rotateS = AnimationUtils.loadAnimation(this,R.anim.rotate_s);
        sLetter.startAnimation(rotateS);
    }

    private void intentToMenu() {
        Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}