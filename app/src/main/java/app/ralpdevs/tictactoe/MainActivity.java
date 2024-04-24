package app.ralpdevs.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;

import app.ralpdevs.tictactoe.R;

public class MainActivity extends AppCompatActivity {

    ImageView button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private String startGame = "X";
    int mor1 = 5, mor2 = 5, mor3 = 5, mor4 = 5, mor5 = 5, mor6 = 5, mor7 = 5, mor8 = 5, mor9 = 5, xCount = 0, oCount, i = 0;
    private TextView scoreX, scoreO;
    private Button clearButton;
    private AdView banner;

    private boolean[] buttonClickable = {true, true, true, true, true, true, true, true, true};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdapter();
        scoreClearAdapter();
        mobileAds();


    }

    private void mobileAds() {
        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        banner = findViewById(R.id.adViewMulti);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        Intent intentToMenu = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intentToMenu);
        finish();
    }

    private void buttonAdapter() {
        button1 = findViewById(R.id.buttonImage1);
        button2 = findViewById(R.id.buttonImage2);
        button3 = findViewById(R.id.buttonImage3);
        button4 = findViewById(R.id.buttonImage4);
        button5 = findViewById(R.id.buttonImage5);
        button6 = findViewById(R.id.buttonImage6);
        button7 = findViewById(R.id.buttonImage7);
        button8 = findViewById(R.id.buttonImage8);
        button9 = findViewById(R.id.buttonImage9);

    }


    private void scoreClearAdapter() {
        scoreX = findViewById(R.id.scoreX);
        scoreO = findViewById(R.id.scoreY);

        clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);

                clearAll();

                xCount = 0;
                oCount = 0;

                scoreX.setText(": " + (xCount));
                scoreO.setText(": " + (oCount));


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[0]) {

                    if (startGame.equals("X")) {
                        button1.setImageResource(R.drawable.cross);
                        mor1 = 1;
                        i++;
                    } else {
                        button1.setImageResource(R.drawable.circle);
                        mor1 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[0] = false;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[1]) {
                    if (startGame.equals("X")) {
                        button2.setImageResource(R.drawable.cross);
                        mor2 = 1;
                        i++;
                    } else {
                        button2.setImageResource(R.drawable.circle);
                        mor2 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[1] = false;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[2]) {
                    if (startGame.equals("X")) {
                        button3.setImageResource(R.drawable.cross);
                        mor3 = 1;
                        i++;
                    } else {
                        button3.setImageResource(R.drawable.circle);
                        mor3 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[2] = false;
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[3]) {
                    if (startGame.equals("X")) {
                        button4.setImageResource(R.drawable.cross);
                        mor4 = 1;
                        i++;
                    } else {
                        button4.setImageResource(R.drawable.circle);
                        mor4 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[3] = false;
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[4]) {
                    if (startGame.equals("X")) {
                        button5.setImageResource(R.drawable.cross);
                        mor5 = 1;
                        i++;
                    } else {
                        button5.setImageResource(R.drawable.circle);
                        mor5 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[4] = false;
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[5]) {
                    if (startGame.equals("X")) {
                        button6.setImageResource(R.drawable.cross);
                        mor6 = 1;
                        i++;
                    } else {
                        button6.setImageResource(R.drawable.circle);
                        mor6 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[5] = false;
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[6]) {
                    if (startGame.equals("X")) {
                        button7.setImageResource(R.drawable.cross);
                        mor7 = 1;
                        i++;
                    } else {
                        button7.setImageResource(R.drawable.circle);
                        mor7 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[6] = false;
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[7]) {
                    if (startGame.equals("X")) {
                        button8.setImageResource(R.drawable.cross);
                        mor8 = 1;
                        i++;
                    } else {
                        button8.setImageResource(R.drawable.circle);
                        mor8 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[7] = false;
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[8]) {
                    if (startGame.equals("X")) {
                        button9.setImageResource(R.drawable.cross);
                        mor9 = 1;
                        i++;
                    } else {
                        button9.setImageResource(R.drawable.circle);
                        mor9 = 0;
                        i++;
                    }
                    choosePlayer();
                    winningGame();

                    buttonClickable[8] = false;
                }
            }
        });

    }

    private void choosePlayer() {
        if (startGame.equals("X")) {
            startGame = "O";
        } else {
            startGame = "X";
        }
    }

    private void winningGame() {
        if (mor1 == 1 && mor2 == 1 && mor3 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor4 == 1 && mor5 == 1 && mor6 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor7 == 1 && mor8 == 1 && mor9 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor1 == 1 && mor5 == 1 && mor9 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor3 == 1 && mor5 == 1 && mor7 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor1 == 1 && mor4 == 1 && mor7 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor2 == 1 && mor5 == 1 && mor8 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor3 == 1 && mor6 == 1 && mor9 == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("X Kazandı").setCancelable(false).setPositiveButton("Hamle sırası O", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scoreX.setText(": " + (xCount));
        } else if (mor1 == 0 && mor2 == 0 && mor3 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor4 == 0 && mor5 == 0 && mor6 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor7 == 0 && mor8 == 0 && mor9 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor1 == 0 && mor4 == 0 && mor7 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor2 == 0 && mor5 == 0 && mor8 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor3 == 0 && mor6 == 0 && mor9 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor1 == 0 && mor5 == 0 && mor9 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else if (mor3 == 0 && mor5 == 0 && mor7 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("O Kazandı").setCancelable(false).setPositiveButton("Hamle sırası X", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);
                    clearAll();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreO.setText(": " + (oCount));
        } else {
            if (i == 9) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Kazanan olmadı!").setCancelable(false).setPositiveButton("Devam et!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button1.setImageDrawable(null);
                        button2.setImageDrawable(null);
                        button3.setImageDrawable(null);
                        button4.setImageDrawable(null);
                        button5.setImageDrawable(null);
                        button6.setImageDrawable(null);
                        button7.setImageDrawable(null);
                        button8.setImageDrawable(null);
                        button9.setImageDrawable(null);
                        clearAll();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }


    }

    private void clearAll() {
        mor1 = 5;
        mor2 = 5;
        mor3 = 5;
        mor4 = 5;
        mor5 = 5;
        mor6 = 5;
        mor7 = 5;
        mor8 = 5;
        mor9 = 5;
        i = 0;

        Arrays.fill(buttonClickable, true);
    }
}