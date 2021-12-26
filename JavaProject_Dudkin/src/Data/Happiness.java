package Data;

public class Happiness {
    private int rank;
    private float score;

    public Happiness(int rank, float score) {
        this.rank = rank;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public float getScore() {
        return score;
    }

    public String toString() {
        return String.format("%s, %s", rank, score);
    }
}
