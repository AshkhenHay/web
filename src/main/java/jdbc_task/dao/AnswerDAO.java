package jdbc_task.dao;

import jdbc_task.db.DBConnectionProvider;
import jdbc_task.model.Answer;
import jdbc_task.model.Question;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AnswerDAO {


    public AnswerDAO() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    private Connection connection;


    public Answer findById(long id) {
        String sql = "SELECT * FROM answer WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getAnswerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public List<Answer> findALL() {
        List<Answer> answerList = new LinkedList<>();
        String sql = "SELECT * FROM answer ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                answerList.add(getAnswerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerList;

    }

    public List<Answer> findByQuestionId(Question question) {
        List<Answer> answerList = new LinkedList<>();
        String sql = "SELECT * FROM answer WHERE question_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, question.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                answerList.add(getAnswerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerList;

    }

    private Answer getAnswerFromResultSet(ResultSet resultSet) {
        Answer answer = new Answer();
        try {
            answer.setId(resultSet.getLong(1));
            answer.setText(resultSet.getString(2));
            answer.setWeight(resultSet.getInt(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return answer;
    }


}
