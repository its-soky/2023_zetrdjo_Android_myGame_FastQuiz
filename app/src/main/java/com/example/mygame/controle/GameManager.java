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
    private int index;
    private QuestionData questionData;
    private int score;


   public GameManager() {
       questionData = new QuestionData();
       listQuestions = questionData.getListQuestions();
   }

    /**
     * Prends une question, la retourne et réinitialise l'index quand toute les questions ont été posées
     * @return une question
     */
    public String getQuestion() {
        if (index <= listQuestions.size()){
            String currentQuestion = listQuestions.get(index).getTitle();
            index++;
            return currentQuestion;
        }
        index = 0;
        return "Fin du jeu";
    }

    /**
     * Vérifie si la réponse du joueur est juste ou fausse et augmente son score
     */
    public int score(Boolean userAnswer) {
        if(userAnswer == listQuestions.get(index).getAnswer()) {
            score++;
        } else {
            score--;
        }
        return score;
    }
}
