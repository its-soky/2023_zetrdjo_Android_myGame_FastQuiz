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
    private Button bp1; //Bouton J1
    private Button bp2; //Bouton J2
    private Button restart;
    private Button menu;
    private TextView score1;
    private TextView score2;
    private TextView question1;
    private TextView question2;

    GameManager manager;
    Timer timer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        manager = new GameManager(this);

        //Afficher nom joueur
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

        bp1.setOnClickListener(v -> manager.setBP1clicked(1));

        bp2.setOnClickListener(v -> manager.setBP2clicked(1));

        menu.setOnClickListener(v -> finish());
        restart.setOnClickListener(v -> {
            manager.reset();
            recreate();
            timer();
        });
    }

    /**
     * Affiche les questions
     * @return "Fin du jeu" quand il n'y a plus de questions dans la liste
     */
    public boolean showQuestions() {
        String question = manager.nextQuestion();
        question1.setText(question);
        question2.setText(question);
        return question.equals("Fin du jeu.");
    }

    /**
     * Apres un certain temps, il verifie la réponse du joueur, recalcule le score des joueurs et affiche la prochaine question
     * delay : determine le temps d'attente avant que la fonction commence
     * period: determine le temps d'attente entre chaque itération
     */
    public void timer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    manager.checkAnswer();
                    showScore();
                    if (showQuestions()) {
                        timer.cancel();
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
