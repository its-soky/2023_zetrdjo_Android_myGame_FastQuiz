package com.example.mygame.modele;

import android.database.Cursor;

public class Question {
    private String title;
    private int answer;

    public String getTitle() {
        return title;
    }
    public int getAnswer() {
        return answer;
    }

    public Question(Cursor cursor) {
        title = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        answer = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }
}
