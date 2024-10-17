package com.example.quiz.model;

public class Question {
    private String str;
    private boolean answer;





    public Question(String str, boolean isTrue) {
        this.str = str;
        this.answer = isTrue;
    }

    public String getStr() {
        return str;
    }

    public boolean isAnswer() {                // Стандарт для нейминга логических методов
        return answer;
    }
}
