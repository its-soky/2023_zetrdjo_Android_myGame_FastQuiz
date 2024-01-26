package com.example.mygame.controle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;

import com.example.mygame.modele.Question;
import com.example.mygame.modele.QuestionData;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Question> listQuestions;
    private int indexQuestion;

    private QuestionData questionData;

   public GameManager() {
       questionData = new QuestionData();
       listQuestions = questionData.getListQuestions();
   }

    /**
     * Prends une question, la retourne et réinitialise l'index quand toute les questions ont été posées
     * @return une question
     */
    public String getCurrentQuestion() {
        if (indexQuestion != listQuestions.size()) {
            String currentQuestion = listQuestions.get(indexQuestion).getTitle();
            indexQuestion++;
            return currentQuestion;
        }
        return "Fin du jeu.";
    }

    /**
     * Reset l'index de la liste pour que le jeu recommence
     */
    public void resetListQuestion() {
        indexQuestion = 0;
    }

    //public Boolean playerAnswer (Boolean playerAnswer) {

    //}

    /**
     * Vérifie si la réponse du joueur est juste et augmente ou descends son score
     */
    public void checkAnswer() {
        Boolean currentAnswer = listQuestions.get(indexQuestion).getAnswer();
    }

//    /**
//     * Charge une liste de question depuis la DB.
//     * @param context Le contexte de l'application pour passer la query
//     * @return Une arraylist charger de Question
//     */
//    private ArrayList<Question> initQuestionList(Context context){
//        ArrayList<Question> listQuestion = new ArrayList<>();
//        SpeedQuizSQLiteOpenHelper helper = new SpeedQuizSQLiteOpenHelper(context);
//        SQLiteDatabase db = helper.getReadableDatabase();
//
//        Cursor cursor = db.query(true,"quiz",new String[]{"idQuiz","question","reponse"},null,null,null,null,"idquiz",null);
//
//        while(cursor.moveToNext()){
//            listQuestion.add(new Question(cursor));
//        }
//
//        cursor.close();
//        db.close();
//        return listQuestion;
//    }
}
