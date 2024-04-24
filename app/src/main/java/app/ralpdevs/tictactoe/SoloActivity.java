package app.ralpdevs.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SoloActivity extends AppCompatActivity {

    private ImageView button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private TextView scoreX, scoreO;
    private String startGame = "X";
    private int mor1 = 5, mor2 = 5, mor3 = 5, mor4 = 5, mor5 = 5, mor6 = 5, mor7 = 5, mor8 = 5, mor9 = 5, xCount = 0, oCount, i = 0;
    private Button clearButton;
    private AdView banner;
    private boolean isPlayerTurn = true;
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

        clearButton = findViewById(R.id.clearButton_solo);

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
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[0] = "X";
                    buttonClickable[0] = false;

                    computerMove();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[1]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[1] = "X";
                    buttonClickable[1] = false;

                    computerMove();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[2]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[2] = "X";
                    buttonClickable[2] = false;

                    computerMove();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[3]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[3] = "X";
                    buttonClickable[3] = false;

                    computerMove();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[4]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[4] = "X";
                    buttonClickable[4] = false;

                    computerMove();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[5]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[5] = "X";
                    buttonClickable[5] = false;

                    computerMove();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[6]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[6] = "X";
                    buttonClickable[6] = false;

                    computerMove();
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[7]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[7] = "X";
                    buttonClickable[7] = false;

                    computerMove();
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickable[8]) {
                    button1.setImageResource(R.drawable.cross);
                    gameBoard[8] = "X";
                    buttonClickable[8] = false;

                    computerMove();
                }
            }
        });




    }

    private void computerMove() {
        // Basit bir yapay zeka algoritması kullanarak, boş bir yere "O" koymayı seçin
        Random random = new Random();
        int randomIndex;
        do {
            randomIndex = random.nextInt(9);
        } while (!buttonClickable[randomIndex]); // Boş olan bir yeri seçene kadar tekrarlayın
        // Boş yere "O" koyun
        switch (randomIndex) {
            case 0:
                button1.setImageResource(R.drawable.circle);
                gameBoard[0] = "O";
                buttonClickable[0] = false;
                break;
            case 1:
                button2.setImageResource(R.drawable.circle);
                gameBoard[1] = "O";
                buttonClickable[1] = false;
                break;
            case 2:
                button3.setImageResource(R.drawable.circle);
                gameBoard[2] = "O";
                buttonClickable[2] = false;
                break;
            case 3:
                button4.setImageResource(R.drawable.circle);
                gameBoard[3] = "O";
                buttonClickable[3] = false;
                break;
            case 4:
                button5.setImageResource(R.drawable.circle);
                gameBoard[4] = "O";
                buttonClickable[4] = false;
                break;
            case 5:
                button6.setImageResource(R.drawable.circle);
                gameBoard[5] = "O";
                buttonClickable[5] = false;
                break;
            case 6:
                button7.setImageResource(R.drawable.circle);
                gameBoard[6] = "O";
                buttonClickable[6] = false;
                break;
            case 7:
                button8.setImageResource(R.drawable.circle);
                gameBoard[7] = "O";
                buttonClickable[7] = false;
                break;
            case 8:
                button9.setImageResource(R.drawable.circle);
                gameBoard[8] = "O";
                buttonClickable[8] = false;
                break;

        }
        choosePlayer();
        winningGame();
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


    private void initializeAd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

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
