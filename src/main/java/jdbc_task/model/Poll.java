package jdbc_task.model;

public class Poll {
    private long id;

    private String name;

    private String description;

    private Question question;

    private Result result;

    public Poll(long id, String name, String description, Question question, Result result) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.question = question;
        this.result = result;
    }

    public Poll() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + question +
                ", results=" + result +
                '}';
    }
}
