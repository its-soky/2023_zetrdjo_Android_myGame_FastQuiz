package com.example.mygame.controle;

import com.example.mygame.modele.Question;
import com.example.mygame.modele.QuestionData;

import java.util.List;

public class GameManager {
    private List<Question> listQuestions;
    private int indexQuestion;
    private QuestionData questionData;
    private int score_1;
    private int score_2;
    private enum Player {
        PLAYER1,
        PLAYER2
    }

    /**
     * Initialise la liste de questions
     */
    public void questions() {
       questionData = new QuestionData();
       listQuestions = questionData.getListQuestions();
    }

    /**
     * Prends une question dans la liste et la retourne
     * @return une question
     */
    public String getCurrentQuestion() {
        if (indexQuestion < listQuestions.size()) {
            return listQuestions.get(indexQuestion).getTitle();
        }
        return "Fin du jeu.";
    }

    /**
     * Augmente l'index
     */
    public void increaseIndex(){
        indexQuestion++;
    }

    public int getListSize() {
        return listQuestions.size();
    }

    public int getIndexQuestion() {
        return indexQuestion;
    }

    /**
     * réinitialise l'index de la liste pour que le jeu recommence
     */
    public void resetListQuestion() {
        questionData = new QuestionData();
        listQuestions = questionData.getListQuestions();
        indexQuestion = 0;
    }

    /**
     * Vérifie si la réponse du joueur est juste et augmente ou descends son score en fonction de sa réponse
     */
    public void checkAnswer(Boolean playerAnswer, Player player) {
        Boolean currentQuestionAnswer = listQuestions.get(indexQuestion).getAnswer();
        if (currentQuestionAnswer == playerAnswer){
            increaseScore(player);
        } else {
            decreaseScore(player);
        }
    }

    public void increaseScore (Player player){
        if (player == Player.PLAYER1) {
            score_1++;
        } else if (player == Player.PLAYER2){
            score_2++;
        }
    }

    public void decreaseScore (Player player){
        if (player == Player.PLAYER1 && score_1 != 0) {
            score_1--;
        } else if (score_2 != 0) {
            score_2--;
        }
    }
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
