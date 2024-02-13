package com.example.mygame.modele;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    private List<Question> listQuestions = new ArrayList<>();

    /**
     * Rempli la liste de questions
     */
    public void questionData() {
        listQuestions.add(new Question("La reine Elisabeth II est encore vivante.",false));
        listQuestions.add(new Question("La banane est un fruit.",true));
        listQuestions.add(new Question("La tomate est un légume.",false));
        listQuestions.add(new Question("NordVPN te protège des virus.",false));
        listQuestions.add(new Question("La Terre est plate.",false));
        listQuestions.add(new Question("L'Afrique est un pays.",false));
        listQuestions.add(new Question("La Terre tourne autour du Soleil.",true));
        listQuestions.add(new Question("La gravité de la Lune est plus faible que celle de la Terre.",true));
        listQuestions.add(new Question("Donald Trump est noir.",false));
        listQuestions.add(new Question("Le Pascal a été inventé par Niklaus Wirth.",true));
    }

    /**
     * Rempli la liste et la retourne
     * @return une liste de questions
     */
    public List<Question> getListQuestions() {
        questionData();
        return listQuestions;
    }
}
