package com.example.mygame.controle;

import com.example.mygame.modele.Question;
import com.example.mygame.modele.QuestionData;

import java.util.List;

public class GameManager {
    private List<Question> listQuestions;
    private int indexQuestion;
    private QuestionData questionData;
    private Boolean playerCurrentAnswer;
    private int modif;

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
        if (indexQuestion <= listQuestions.size()) {
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
    public void checkAnswer() {
        Boolean currentQuestionAnswer = listQuestions.get(indexQuestion).getAnswer();
        if (currentQuestionAnswer == getPlayerCurrentAnswer()){
            modif++;
        } else {
            modif--;
        }
    }
    public int getScoreModif() {
        return modif;
    }
    public Boolean getPlayerCurrentAnswer() {
        return playerCurrentAnswer;
    }

    public void setPlayerCurrentAnswer(Boolean playerCurrentAnswer) {
        this.playerCurrentAnswer = playerCurrentAnswer;
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
