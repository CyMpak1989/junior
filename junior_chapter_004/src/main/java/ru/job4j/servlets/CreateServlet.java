package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.db.UserStore;
import ru.job4j.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 28.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class CreateServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final UserStore users = UserStore.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"POST\" action=\"" + req.getContextPath() +"/create\">\n" +
                "Login : " +
                "<input type=\"text\" name=\"login\">\n" +
                "Name: " +
                "<input type=\"text\" name=\"name\">\n" +
                "E-mail: " +
                "<input type=\"text\" name=\"email\">\n" +
                "<button type=\"submit\">Create</button>\n" +
                "</form>\n" +
                "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>" +
                "</body>\n" +
                "</html>");
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Calendar date = Calendar.getInstance();
        boolean resault = users.addNewUser(new User(name, login, email, date));
        if (resault) {
            printWriter.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h3>The user is created.</h3>" +
                    "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>" +
                    "</body>\n" +
                    "</html>");
        } else {
            printWriter.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h3>Such a user already exists.</h3>" +
                    "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>" +
                    "</body>\n" +
                    "</html>");
        }
        printWriter.flush();
    }
}
