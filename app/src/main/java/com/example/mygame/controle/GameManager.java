package com.example.mygame.controle;

import android.widget.Button;
import android.widget.TextView;

import com.example.mygame.R;
import com.example.mygame.modele.Question;
import com.example.mygame.modele.QuestionData;

import java.nio.Buffer;
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
        if (indexQuestion <= listQuestions.size()){
            String currentQuestion = listQuestions.get(indexQuestion).getTitle();
            indexQuestion++;
            return currentQuestion;
        }
        indexQuestion = 0;
        return "Fin du jeu";
    }
}

