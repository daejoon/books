package com.ddoong2;

public class Criterion {
    private final Answer answer;
    private final Weight weight;

    public Criterion(Answer answer, Weight weight) {
        this.answer = answer;
        this.weight = weight;
    }

    public Answer getAnswer() {
        throw new UnsupportedOperationException();
    }

    public Weight getWeight() {
        throw new UnsupportedOperationException();
    }
}
