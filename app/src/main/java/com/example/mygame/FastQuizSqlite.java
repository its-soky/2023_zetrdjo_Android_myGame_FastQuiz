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
        db.execSQL("INSERT INTO quiz VALUES (null, \"La reine Elisabeth II est encore vivante.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La banane est un fruit.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La tomate est un légume.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"NordVPN te protège des virus.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La terre est plate\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"L'Afrique est un pays.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Terre tourne autour du Soleil.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La gravité de la Lune est plus faible que celle de la Terre.\", 1)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Donald Trump est noir.\", 0)");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le Pascal a été inventé par Niklaus Wirth.\", 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
