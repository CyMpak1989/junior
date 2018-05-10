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

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 28.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class EditServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int resault = users.updateUserId(new User(id, name, login, email));
        if (resault == 1) {
            resp.sendRedirect(String.format("%s/edittrue.jsp", req.getContextPath()));
        } else {
            resp.sendRedirect(String.format("%s/editfalse.jsp", req.getContextPath()));
        }
    }
}
