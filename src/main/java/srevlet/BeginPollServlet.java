package srevlet;

import jdbc_task.dao.PollDAO;
import jdbc_task.dao.QuestionDAO;
import jdbc_task.model.Poll;
import jdbc_task.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/poll/beginPoll")
public class BeginPollServlet extends HttpServlet {
   QuestionDAO questionDao = new QuestionDAO();
    PollDAO pollDao = new PollDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("poll_id");
        Poll byId = pollDao.findById(Long.parseLong(id));
        List<Question> questionList = questionDao.findByPollId(byId);
        req.setAttribute("questionList",questionList);
        req.setAttribute("poll",byId);
        req.getRequestDispatcher("WEB-INF/begin_poll.jsp").forward(req,resp);
    }

}
