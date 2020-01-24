package iloveyouboss;

public enum Weight {
    MustMatch(1), DontCare(2);

    private final int score;

    Weight(int score) {
        this.score = score;
    }

    public int getValue() {
        return this.score;
    }
}
