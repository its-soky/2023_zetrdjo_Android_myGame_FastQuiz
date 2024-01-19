package com.example.mygame.modele;

public class Question {
    private String title;
    private Boolean answer;

    public Question(String title, Boolean answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
