package jdbc_task.model;

import java.util.List;

public class Poll {
    private long id;

    private String name;

    private String description;

    private List<Question> questions;

    private List<Result> results;

    public Poll(long id, String name, String description, List<Question> question, List<Result> result) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questions = question;
        this.results = result;
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

    public List<Question> getQuestion() {
        return questions;
    }

    public void setQuestion(List<Question> question) {
        this.questions = question;
    }

    public List<Result> getResult() {
        return results;
    }

    public void setResult(List<Result> result) {
        this.results = result;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                ", results=" + results +
                '}';
    }
}
