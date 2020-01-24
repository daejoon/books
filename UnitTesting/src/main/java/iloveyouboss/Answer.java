package iloveyouboss;

import java.util.Objects;

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
        return answer.equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return isCorrect == answer.isCorrect &&
                Objects.equals(question, answer.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, isCorrect);
    }
}
