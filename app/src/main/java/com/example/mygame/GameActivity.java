package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mygame.controle.GameManager;


import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    //Player name
    private TextView name1;
    private TextView name2;

    //players buttons
    private Button bp1; //
    private Button bp2;
    private Button restart;
    private Button menu;

    //Score
//    private TextView score1;
//    private TextView score2;
//    private int score_1;
//    private int score_2;

    //questions
    private TextView question1;
    private TextView question2;

    GameManager manager;
    Handler handler;
    Timer timer;
    TimerTask action;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        manager = new GameManager();
        handler = new Handler();

        name1 = findViewById(R.id.nickname1);
        name2 = findViewById(R.id.nickname2);

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

        //score1 = findViewById(R.id.score1);
        //score2 = findViewById(R.id.score2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        question1.setText("Clique sur le bouton si t'es prêts.");
        question2.setText("Clique sur le bouton si t'es prêts.");
        manager.questions();

        bp1.setOnClickListener(v -> timer());

        bp2.setOnClickListener(v -> timer());

        menu.setOnClickListener(v -> {
            //Retourne au menu
            finish();
        });

        restart.setOnClickListener(v -> {
            //Reset la liste de questions et le score

        });
    }

    /**
     * Affiche les questions
     */
    public void setQuestions() {
        String question = manager.getCurrentQuestion();
        question1.setText(question);
        question2.setText(question);
    }

    public void timer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        action = new TimerTask() {
            @Override
            public void run() {
                if (!manager.getCurrentQuestion().equals("Fin du jeu.")) {
                    setQuestions();
                    manager.increaseIndex();
                } else {
                    manager.resetListQuestion();
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(action, 0, 5000);
    }

    //2eme reponse du joueur
    //3eme Checkanswer

//    /**
//     * affiche le score du joueur
//     */
//    public void setScore () {
//
//    }


}
