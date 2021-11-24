package jdbc_task.model;

public class Result {
    private long id;

    private String explanation;

    private int minScore;

    private int maxScore;

    public Result(long id, String explanation, int minScore, int maxScore) {
        this.id = id;
        this.explanation = explanation;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public Result() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                '}';
    }
}
