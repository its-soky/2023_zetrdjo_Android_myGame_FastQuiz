package com.example.mygame.modele;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    private List<Question> listQuestions = new ArrayList<>();
    public void questionData() {
        listQuestions.add(new Question("La terre est plate.", false));
        listQuestions.add(new Question("L'afrique est un pays.", false));
        listQuestions.add(new Question("La Terre tourne autour du soleil.", true));
        listQuestions.add(new Question("La Turquie est en asie.", true));
        listQuestions.add(new Question("La reine Elisabeth est encore vivante.", false));
        listQuestions.add(new Question("La banane est un fruit.", true));
        listQuestions.add(new Question("La Tomate est un légume.", false));
        listQuestions.add(new Question("NordVPN te protège des virus.", false));
        listQuestions.add(new Question("Donald Trump est noir.", false));
        listQuestions.add(new Question("Le Pascal a été inventé par Niklaus Wirth.",true));
    }
    public List<Question> getListQuestions() {
        questionData();
        return listQuestions;
    }
}
