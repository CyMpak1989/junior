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
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        user = users.getUserLogin(req.getParameter("login"));
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<form method=\"POST\" action=\"" + req.getContextPath() + "/edit\">\n"
                + "<input type=\"hidden\" name=\"id\" value=\"" + user.getId() + "\">\n"
                + "Login : "
                + "<input type=\"text\" name=\"login\" value=\"" + user.getLogin() + "\">\n"
                + "Name: "
                + "<input type=\"text\" name=\"name\" value=\"" + user.getName() + "\">\n"
                + "E-mail: "
                + "<input type=\"text\" name=\"email\" value=\"" + user.getEmail() + "\">\n"
                + "<button type=\"submit\">Edit</button>\n"
                + "</form>\n"
                + "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>"
                + "</body>\n"
                + "</html>");
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int resault = users.updateUserId(new User(id, name, login, email));
        if (resault == 1) {
            printWriter.append("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <title>Edit User</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h3>The user is successfully changed.</h3>"
                    + "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>"
                    + "</body>\n"
                    + "</html>");
        } else {
            printWriter.append("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <title>Edit User</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h3>The user has not edited.</h3>"
                    + "<h2><a href='" + req.getContextPath() + "/list'>Back</a></h2>"
                    + "</body>\n"
                    + "</html>");
        }
        printWriter.flush();
    }
}
