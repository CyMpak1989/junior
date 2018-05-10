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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Calendar date = Calendar.getInstance();
        boolean resault = users.addNewUser(new User(name, login, email, date));
        if (resault) {
            resp.sendRedirect(String.format("%s/createtrue.jsp", req.getContextPath()));
        } else {
            resp.sendRedirect(String.format("%s/createfalse.jsp", req.getContextPath()));
        }
    }
}
