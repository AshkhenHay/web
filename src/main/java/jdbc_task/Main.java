package jdbc_task;

import jdbc_task.dao.AnswerDAO;
import jdbc_task.dao.PollDAO;
import jdbc_task.dao.QuestionDAO;
import jdbc_task.dao.ResultDAO;
import jdbc_task.model.Answer;
import jdbc_task.model.Poll;
import jdbc_task.model.Question;
import jdbc_task.model.Result;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PollDAO pollDAO=new PollDAO();
        ResultDAO resultDAO= new ResultDAO();
        AnswerDAO answerDAO= new AnswerDAO();
        QuestionDAO questionDAO=new QuestionDAO();

        Poll pollId = pollDAO.findById(3);
        Result resultId = resultDAO.findById(2);
        Question questionId = questionDAO.findById(1);
        Answer answerId = answerDAO.findById(2);
//        System.out.println(answerId);
//        System.out.println(resultId);
        System.out.println(answerDAO.findByQuestionId(questionId));
        System.out.println(pollId);
//        System.out.println(resultDAO.findALL());
//       System.out.println(resultDAO.findByPollId(pollId));

    }

}
