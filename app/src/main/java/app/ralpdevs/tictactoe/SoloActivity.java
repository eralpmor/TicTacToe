package app.ralpdevs.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoloActivity extends AppCompatActivity {

    private ImageView button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private String startGame = "X";
    private int mor1 = 5, mor2 = 5, mor3 = 5, mor4 = 5, mor5 = 5, mor6 = 5, mor7 = 5, mor8 = 5, mor9 = 5, xCount = 0, oCount, i = 0;
    private TextView scoreX, scoreO;
    private Button clearButton;
    private AdView banner;
    private boolean[] buttonClickable = {true, true, true, true, true, true, true, true, true};
    private String[] gameBoard = {"", "", "", "", "", "", "", "", ""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);

        initializeAd();

        initialize();

    }

    private void initialize() {
        button1 = findViewById(R.id.buttonImage1_solo);
        button2 = findViewById(R.id.buttonImage2_solo);
        button3 = findViewById(R.id.buttonImage3_solo);
        button4 = findViewById(R.id.buttonImage4_solo);
        button5 = findViewById(R.id.buttonImage5_solo);
        button6 = findViewById(R.id.buttonImage6_solo);
        button7 = findViewById(R.id.buttonImage7_solo);
        button8 = findViewById(R.id.buttonImage8_solo);
        button9 = findViewById(R.id.buttonImage9_solo);
        clearButton = findViewById(R.id.clearButton_solo);

        scoreX = findViewById(R.id.scoreX_solo);
        scoreO = findViewById(R.id.scoreY_solo);


    }







    private void initializeAd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        banner = new AdView(this);

        banner.setAdSize(AdSize.BANNER);

        banner.setAdUnitId("ca-app-pub-/7322016191");

        banner = findViewById(R.id.adView_solo);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);

    }

    @Override
    public void onBackPressed() {
        Intent intentToMenu = new Intent(SoloActivity.this, MenuActivity.class);
        startActivity(intentToMenu);
        finish();
    }

}