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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 27.04.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class ListServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ListServlet.class);
    private final UserStore users = UserStore.getInstance();
    private List<User> userList = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; en");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table border=\"1\">");
        stringBuilder.append("    <tr>\n" +
                "        <td>id</td>\n" +
                "        <td>login</td>\n" +
                "        <td>name</td>\n" +
                "        <td>email</td>\n" +
                "        <td>date</td>\n" +
                "        <td>edit</td>\n" +
                "        <td>delete</td>\n" +
                "    </tr>");
        for (User user : users.getAllUsers()) {
            stringBuilder.append("<tr>");
            stringBuilder.append("<td>" + user.getId() + "</td>");
            stringBuilder.append("<td>" + user.getLogin() + "</td>");
            stringBuilder.append("<td>" + user.getName() + "</td>");
            stringBuilder.append("<td>" + user.getEmail() + "</td>");
            stringBuilder.append("<td>" + user.getCreateDate().getTime() + "</td>");
            stringBuilder.append("<td>" + "edit" + "</td>");
            stringBuilder.append("<td>" + "delete" + "</td>");
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("</table>");

        printWriter.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                stringBuilder.toString() +
                "</body>\n" +
                "</html>");
        printWriter.flush();
    }
}
