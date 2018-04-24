package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;
import ru.job4j.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 25.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class UsersServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        String login = req.getParameter("login");
        if (login != null) {
            User user = users.getUserLogin(login);
            if (user != null) {
                printWriter.append(user.toString());
            } else {
                printWriter.append("User with this login is missing.");
            }
        } else {
            printWriter.append("Option login came up empty.");
        }
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
        System.out.println(resault);
        if (resault) {
            printWriter.append("The user is successfully created.");
        } else {
            printWriter.append("This login is already busy.");
        }
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Calendar date = Calendar.getInstance();
        int resault = users.updateUser(new User(name, login, email, date));
        if (resault == 1) {
            printWriter.append("The user is successfully updated.");
        } else {
            printWriter.append("The user is not found.");
        }
        printWriter.flush();

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        String login = req.getParameter("login");
        int resault = users.daleteUser(login);
        if (resault == 1) {
            printWriter.append("The user is successfully deleted.");
        } else {
            printWriter.append("The user is not found.");
        }
        printWriter.flush();
    }
}
