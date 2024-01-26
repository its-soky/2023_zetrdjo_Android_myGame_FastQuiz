package com.example.mygame.modele;

import android.database.Cursor;

public class Question {
    private String title;
    private Boolean answer;

    public Question(String title, Boolean answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAnswer() {
        return answer;
    }

//    public Question(Cursor cursor) {
//        title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
//        answer = cursor.getInt(cursor.getColumnIndexOrThrow("answer"));
//    }
}
