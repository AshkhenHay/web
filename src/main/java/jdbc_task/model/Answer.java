package jdbc_task.model;

public class Answer {
    private long id;

    private String text;

    private int weight;

    public Answer(long id, String text, int weight) {
        this.id = id;
        this.text = text;
        this.weight = weight;
    }

    public Answer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", weight=" + weight +
                '}';
    }
}
