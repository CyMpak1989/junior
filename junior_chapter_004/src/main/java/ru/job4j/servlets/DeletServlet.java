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
import java.io.PrintWriter;

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
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        printWriter.append("<!DOCTYPE html>"
                + "<html lang='en'>"
                + "<head>"
                + "    <meta charset='UTF-8'>"
                + "    <title>Delete User</title>"
                + "</head>"
                + "<body>"
                + "<h3> Do you want to remove user ID = " + id + " ?</h3>"
                + "<br>"
                + "<form method=\"POST\" action=\"" + req.getContextPath() + "/delete\">\n"
                + "<input type=\"hidden\" name=\"id\" value=\"" + id + "\">\n"
                + "<button type=\"submit\">Yes</button>\n"
                + "</form>\n"
                + "<form method=\"GET\" action=\"" + req.getContextPath() + "/list\">\n"
                + "<button type=\"submit\">No</button>\n"
                + "</form>\n"
                + "</body>"
                + "</html>");
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        users.deleteUser(req.getParameter("id"));
        printWriter.append("<!DOCTYPE html>"
                + "<html lang='en'>"
                + "<head>"
                + "    <meta charset='UTF-8'>"
                + "    <title>Delete User</title>"
                + "</head>"
                + "<body>"
                + " <h2><a href='"
                + req.getContextPath()
                + "/list'>Back.</a></h2>"
                + "<h3>The user is deleted.</h3>"
                + "</body>"
                + "</html>");
        printWriter.flush();
    }
}
