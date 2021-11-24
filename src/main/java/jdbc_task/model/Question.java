package jdbc_task.model;


public class Question {
    private long id;

    private String text;

    private Answer answer;

    public Question(long id, String text, Answer answer) {
        this.id = id;
        this.text = text;
        this.answer = answer;
    }

    public Question() {
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


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answer +
                '}';
    }
}
