package jdbc_task.dao;

import jdbc_task.db.DBConnectionProvider;
import jdbc_task.model.Poll;
import jdbc_task.model.Question;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class QuestionDAO {


    public QuestionDAO() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    private Connection connection;
    private AnswerDAO answerDAO = new AnswerDAO();

    public Question findById(long id) {
        String sql = "SELECT * FROM question WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getQuestionFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Question> findALL() {
        List<Question> questionList = new LinkedList<>();
        String sql = "SELECT * FROM question ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                questionList.add(getQuestionFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;

    }


        public List<Question> findByPollId(Poll poll) {
            List<Question> questionList = new LinkedList<>();
            String sql = "SELECT * FROM question WHERE poll_id=? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, poll.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    questionList.add(getQuestionFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return questionList;

        }
    private Question getQuestionFromResultSet(ResultSet resultSet) {
        Question question = new Question();
        try {
            question.setId(resultSet.getLong(1));
            question.setText(resultSet.getString(2));
            question.setAnswer(answerDAO.findById(resultSet.getLong(3)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return question;
    }




}
