package com.example.mygame.controle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mygame.modele.FastQuizSQLiteOpenHelper;
import com.example.mygame.modele.Question;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Question> listQuestions;
    private int indexQuestion;
    private int score_1;
    private int score_2;
    private int BP1clicked;// Bouton J1
    private int BP2clicked;// Bouton J2
    private Context context;
    private enum Player {
        PLAYER1,
        PLAYER2
    }

    public GameManager(Context context) {
        this.context = context;
        listQuestions = initQuestionList(context);
    }

    /**
     * Charge une liste de question depuis la DB.
     * @param context Le contexte de l'application pour passer la query
     * @return Une arraylist charger de Question
     */
    private ArrayList<Question> initQuestionList(Context context){
        FastQuizSQLiteOpenHelper helper = new FastQuizSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(true,"quiz",new String[]{"idQuiz","question","reponse"},null,null,null,null,"idquiz",null);
        ArrayList<Question> listQuestion = new ArrayList<>();
        while(cursor.moveToNext()){
            listQuestion.add(new Question(cursor));
        }

        cursor.close();
        db.close();
        return listQuestion;
    }

    /**
     * Prends une question aléatoire dans la liste et la retourne
     * @return une question
     */
    public String nextQuestion() {
        if (listQuestions.isEmpty()) {
            return "Fin du jeu.";
        }
        indexQuestion = (int)(Math.random() * listQuestions.size());
        return listQuestions.get(indexQuestion).getTitle();
    }

    /**
     * Vérifie si la réponse des joueurs et augmente ou descends leur score en fonction de leur réponse
     */
    public void checkAnswer() {
        if (isBP1clicked() == getCurrentAnswer()) {
            increaseScore(getPlayer1());
        } else {
            decreaseScore(getPlayer1());
        }
        setBP1clicked(0);

        if (isBP2clicked() == getCurrentAnswer()) {
            increaseScore(getPlayer2());
        } else {
            decreaseScore(getPlayer2());
        }
        setBP2clicked(0);
        listQuestions.remove(indexQuestion);
    }

    /**
     * Augmente le score du joueur
     * @param player Le joueur
     */
    public void increaseScore (Player player){
        if (player == Player.PLAYER1) {
            score_1++;
        } else if (player == Player.PLAYER2){
            score_2++;
        }
    }

    /**
     * Diminue le score du joueur
     * @param player Le joueur
     */
    public void decreaseScore (Player player){
        if (player == Player.PLAYER1 && score_1 > 0) {
            score_1--;
        }
        if (player == Player.PLAYER2 && score_2 > 0) {
            score_2--;
        }
    }

    /**
     * reinitialise la liste et le score
     */
    public void reset() {
        listQuestions = initQuestionList(context);
        score_1 = 0;
        score_2 = 0;
    }

    //Getter et setter
    public int getScore_1() {
        return score_1;
    }
    public int getScore_2() {
        return score_2;
    }
    public Player getPlayer1() {
        return Player.PLAYER1;
    }
    public Player getPlayer2() {
        return Player.PLAYER2;
    }
    public int getCurrentAnswer() {
        return listQuestions.get(indexQuestion).getAnswer();
    }
    public void setBP1clicked(int BP1clicked) {
        this.BP1clicked = BP1clicked;
    }
    public int isBP1clicked() {
        return BP1clicked;
    }
    public int isBP2clicked() {
        return BP2clicked;
    }
    public void setBP2clicked(int BP2clicked) {
        this.BP2clicked = BP2clicked;
    }
}
