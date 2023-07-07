package app.ralpdevs.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import app.ralpdevs.tictactoe.R;

public class MenuActivity extends AppCompatActivity {

    ImageView googlePlay, ratingApp, soloPlay, multiPlay;
    private InterstitialAd interstitial;
    private AdView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        interstitialAd();
        multiPlayActivity();
        mobileAds();

    }

    private void mobileAds(){
        MobileAds.initialize(MenuActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        banner = findViewById(R.id.adViewMenu);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);
    }

    private void interstitialAd(){
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                interstitial = interstitialAd;
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                interstitial = null;
                Toast.makeText(MenuActivity.this,"Reklam gösterilemedi", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void multiPlayActivity(){
        googlePlay = findViewById(R.id.google_play);
        ratingApp = findViewById(R.id.rating_app);
        soloPlay = findViewById(R.id.solo_play_button);
        multiPlay = findViewById(R.id.multi_play_button);

        multiPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitial != null){
                    interstitial.show(MenuActivity.this);
                    interstitial.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(MenuActivity.this,MainActivity.class));

                        }
                    });


                } else {
                    startActivity(new Intent(MenuActivity.this,MainActivity.class));
                    finish();
                }



            }
        });
    }
}