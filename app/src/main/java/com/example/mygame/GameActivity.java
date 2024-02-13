package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mygame.controle.GameManager;


import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    //players buttons
    private Button bp1; //
    private Button bp2;
    private Button restart;
    private Button menu;

    //Score
    private TextView score1;
    private TextView score2;

    //questions
    private TextView question1;
    private TextView question2;

    GameManager manager;
    Timer timer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        manager = new GameManager();

        //Player name
        TextView name1 = findViewById(R.id.nickname1);
        TextView name2 = findViewById(R.id.nickname2);

        Intent gameActivity = getIntent();
        String player1Name = String.valueOf(gameActivity.getStringExtra("player1Name"));
        String player2Name = String.valueOf(gameActivity.getStringExtra("player2Name"));
        name1.setText(player1Name);
        name2.setText(player2Name);

        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);

        bp1 = findViewById(R.id.buttonP1);
        bp2 = findViewById(R.id.buttonP2);
        menu = findViewById(R.id.BT_menu);
        restart = findViewById(R.id.BT_restart);

        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer();
        manager.questions();

        bp1.setOnClickListener(v -> {
            manager.setBP1clicked(false);
        });

        bp2.setOnClickListener(v -> {
            manager.setBP2clicked(false);
        });

        menu.setOnClickListener(v -> finish());
        restart.setOnClickListener(v -> {
            recreate();
            timer();
        });
    }

    /**
     * Affiche les questions
     */
    public void showQuestions() {
        String question = manager.getCurrentQuestion();
        question1.setText(question);
        question2.setText(question);
    }

    public void timer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!manager.getCurrentQuestion().equals("Fin du jeu.")) {
                            manager.checkAnswer();
                            showScore();
                            showQuestions();
                        } else {
                            timer.cancel();
                        }
                    }
                });
            }
        }, 2500, 5000);
    }

    /**
     * affiche le score du joueur
     */
    public void showScore() {
        score1.setText(String.valueOf(manager.getScore_1()));
        score2.setText(String.valueOf(manager.getScore_2()));
    }
}
