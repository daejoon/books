package iloveyouboss;

public class Criterion {
    private final Answer answer;
    private final Weight weight;

    public Criterion(Answer answer, Weight weight) {
        this.answer = answer;
        this.weight = weight;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Weight getWeight() {
        return weight;
    }
}
