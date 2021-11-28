package srevlet;

import jdbc_task.dao.AnswerDAO;
import jdbc_task.dao.PollDAO;
import jdbc_task.dao.QuestionDAO;
import jdbc_task.dao.ResultDAO;
import jdbc_task.model.Answer;
import jdbc_task.model.Poll;
import jdbc_task.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/poll/result")
public class ResultServlet extends HttpServlet {
    private ResultDAO resultDAO = new ResultDAO();
    private QuestionDAO questionDAO = new QuestionDAO();
    private PollDAO pollDAO=new PollDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pollId = req.getParameter("poll_id");
        Poll byId = pollDAO.findById(Long.parseLong(pollId));
        int score = 0;
        for (Question question : questionDAO.findByPollId(byId)) {
            List<Answer> answers = question.getAnswers();
            for (Answer answer : answers) {
                int weight = answer.getWeight();
                score+=weight;
            }
        }
        req.setAttribute("result", resultDAO.findByScore(byId.getId(), score));
        req.getRequestDispatcher("WEB-INF/poll_result.jsp").forward(req, resp);
    }

}

