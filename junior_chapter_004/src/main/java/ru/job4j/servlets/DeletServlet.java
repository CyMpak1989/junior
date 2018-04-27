package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.db.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 27.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class DeletServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(DeletServlet.class);
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));
        users.deleteUser(req.getParameter("id"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(req.getContextPath() + "/list");
        requestDispatcher.forward(req, resp);
    }
}