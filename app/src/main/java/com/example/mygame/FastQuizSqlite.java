package com.example.mygame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FastQuizSqlite extends SQLiteOpenHelper {
    static String DB_name = "FastQuizz.db";
    static int DB_version = 1;

    public FastQuizSqlite(@Nullable Context context) {
        super(context, DB_name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateDataTable = "CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, question TEXT, reponse INTEGER;";
        db.execSQL(sqlCreateDataTable);
        db.execSQL("INSERT INTO quiz VALUES (null, \"La terre est plate\", 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
