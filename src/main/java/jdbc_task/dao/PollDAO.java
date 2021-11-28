package jdbc_task.dao;

import jdbc_task.db.DBConnectionProvider;
import jdbc_task.model.Poll;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PollDAO {


    public PollDAO() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    private Connection connection;
    private QuestionDAO questionDAO = new QuestionDAO();
    private ResultDAO resultDAO = new ResultDAO();

    public Poll findById(long id) {

        String sql = "SELECT * FROM poll WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getPollFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public List<Poll> findALL() {
        List<Poll> pollList = new LinkedList<>();
        String sql = "SELECT * FROM poll";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pollList.add(getPollFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pollList;

    }

    private Poll getPollFromResultSet(ResultSet resultSet) {
        Poll poll = new Poll();
        try {
            poll.setId(resultSet.getLong(1));

            poll.setName(resultSet.getString(2));
            poll.setDescription(resultSet.getString(3));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return poll;
    }
}
