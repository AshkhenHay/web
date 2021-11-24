package jdbc_task.dao;

import jdbc_task.db.DBConnectionProvider;
import jdbc_task.model.Poll;
import jdbc_task.model.Result;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ResultDAO {


    public ResultDAO() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    private Connection connection;


    public Result findById(long id) {
        String sql = "SELECT * FROM result WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getResultFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public List<Result> findALL() {
        List<Result> resultList = new LinkedList<>();
        String sql = "SELECT * FROM result ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultList.add(getResultFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;

    }
        public List<Result> findByPollId(Poll poll) {
            List<Result> resultList = new LinkedList<>();
            String sql = "SELECT * FROM result WHERE poll_id=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, poll.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    resultList.add(getResultFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultList;

        }
        public List<Result> findByScore(int i) {
            List<Result> resultList = new LinkedList<>();
            String sql = "SELECT * FROM result WHERE min_scope=? OR max_scope=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    resultList.add(getResultFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultList;

        }
    private Result getResultFromResultSet(ResultSet resultSet) {
        Result result = new Result();
        try {
            result.setId(resultSet.getLong(1));
            result.setExplanation(resultSet.getString(2));
            result.setMinScore(resultSet.getInt(3));
            result.setMaxScore(resultSet.getInt(4));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}
