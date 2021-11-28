package srevlet;

import jdbc_task.dao.PollDAO;
import jdbc_task.model.Poll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/poll")
public class PollServlet extends HttpServlet {
    private PollDAO pollDao=new PollDAO();



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Poll> pollList = pollDao.findALL();
        req.setAttribute("pollList",pollList);
        req.getRequestDispatcher("WEB-INF/poll.jsp").forward(req,resp);
    }
}
