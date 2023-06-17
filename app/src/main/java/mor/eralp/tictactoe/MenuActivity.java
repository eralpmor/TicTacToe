package mor.eralp.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    ImageView googlePlay, ratingApp, soloPlay, multiPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        multiPlayActivity();
    }

    private void multiPlayActivity(){
        googlePlay = findViewById(R.id.google_play);
        ratingApp = findViewById(R.id.rating_app);
        soloPlay = findViewById(R.id.solo_play_button);
        multiPlay = findViewById(R.id.multi_play_button);

        multiPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToMulti = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intentToMulti);
                finish();
            }
        });
    }
}