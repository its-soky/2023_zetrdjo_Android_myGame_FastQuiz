package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    //Player name
    private TextView name1;
    private TextView name2;

    //players buttons
    private Button BP1;
    private Button BP2;
    private Button Restart;
    private Button Menu;

    //Score
    private TextView score1;
    private TextView score2;

    //questions
    private TextView question1;
    private TextView question2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        name1 = findViewById(R.id.nickname1);
        name2 = findViewById(R.id.nickname2);

        Intent gameActivity = getIntent();
        String player1Name = String.valueOf(gameActivity.getStringExtra("player1Name"));
        String player2Name = String.valueOf(gameActivity.getStringExtra("player2Name"));

        name1.setText(player1Name);
        name2.setText(player2Name);

        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);


    }
}