package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText player1;
    private EditText player2;
    private Button BT_newPlayer;
    private Button BT_newGame;
    //Toolbar toolbar = findViewById(R.id.toolbar);(trouve pas toolbar)
    //Menu menu = toolbar.getMenu();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //MainActivity.this.startActivity(gameIntent);
        int id = item.getItemId();
        if (id == R.id.Settings){
            System.out.println("Settings open");
            return true;
        }
        if (id == R.id.Question){
            System.out.println("Question open");
            return true;
        }
        if (id == R.id.About){
            System.out.println("About open");
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //setSupportActionBar(toolbar);
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.playerName1);
        player2 = findViewById(R.id.playerName2);
        BT_newPlayer = findViewById(R.id.newPlayer);
        BT_newGame = findViewById(R.id.newGame);
    }

    @Override
    protected void onStart() {
        super.onStart();

        BT_newPlayer.setOnClickListener(v -> {
            player1.setEnabled(true);
            player1.setVisibility(View.VISIBLE);
            player1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!player1.getText().toString().isEmpty()) {
                        BT_newGame.setEnabled(true);
                        BT_newGame.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!player1.getText().toString().isEmpty()) {
                        player2.setEnabled(true);
                        player2.setVisibility(View.VISIBLE);
                    } else {
                        BT_newGame.setEnabled(false);
                        BT_newGame.setVisibility(View.INVISIBLE);
                    }
                }
            });

            player2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!player2.getText().toString().isEmpty()) {
                        BT_newGame.setEnabled(true);
                        BT_newGame.setVisibility(View.VISIBLE);
                    } else {
                        BT_newGame.setEnabled(false);
                        BT_newGame.setVisibility(View.INVISIBLE);
                    }
                }
            });
        });

        BT_newGame.setOnClickListener(v -> {
            Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
            gameIntent.putExtra("player1Name", player1.getText().toString());
            gameIntent.putExtra("player2Name", player2.getText().toString());
            MainActivity.this.startActivity(gameIntent);
        });
    }
}