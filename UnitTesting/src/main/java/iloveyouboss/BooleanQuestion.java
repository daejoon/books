package iloveyouboss;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanQuestion that = (BooleanQuestion) o;
        return seq == that.seq &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq, question);
    }
}