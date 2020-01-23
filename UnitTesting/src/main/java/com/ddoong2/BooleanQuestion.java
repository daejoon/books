package com.ddoong2;

public class BooleanQuestion implements Question {
    private final int seq;
    private final String question;

    public BooleanQuestion(int seq, String question) {
        this.seq = seq;
        this.question = question;
    }

    @Override
    public String getText() {
        return this.question;
    }
}