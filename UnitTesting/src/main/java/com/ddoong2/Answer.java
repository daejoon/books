package com.ddoong2;

public class Answer {
    private final Question question;
    private final boolean isCorrect;

    public Answer(Question question, boolean isCorrect) {
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public String getQuestionText() {
        return question.getText();
    }

    public boolean match(Answer answer) {
        throw new UnsupportedOperationException();
    }
}
