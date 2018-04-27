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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table border=\"1\">\n");
        stringBuilder.append("    <tr>\n" +
                "        <td>Id</td>\n" +
                "        <td>Login</td>\n" +
                "        <td>Name</td>\n" +
                "        <td>Email</td>\n" +
                "        <td>Date</td>\n" +
                "        <td>Edit</td>\n" +
                "        <td>Delete</td>\n" +
                "    </tr>" +
                "\n");
        for (User user : users.getAllUsers()) {
            stringBuilder.append("    <tr>\n");
            stringBuilder.append("        <td>" + user.getId() + "</td>\n");
            stringBuilder.append("        <td>" + user.getLogin() + "</td>\n");
            stringBuilder.append("        <td>" + user.getName() + "</td>\n");
            stringBuilder.append("        <td>" + user.getEmail() + "</td>\n");
            stringBuilder.append("        <td>" + user.getCreateDate().getTime() + "</td>\n");
            stringBuilder.append("        <td>\n");
            stringBuilder.append("            <form method=\"get\" action=\"" + req.getContextPath() +
                    "/edit?id=" + user.getId() + "\">\n" +
                    "                <button type=\"submit\">Edit</button>\n" +
                    "            </form>\n");
            stringBuilder.append("        </td>\n");
            stringBuilder.append("        <td>\n");
            stringBuilder.append("            <form method=\"get\" action=\"" + req.getContextPath() +
                    "/delete?id=" + user.getId() + "\">\n" +
                    "                <button type=\"submit\">Delete</button>\n" +
                    "            </form>\n");
            stringBuilder.append("        </td>\n");
            stringBuilder.append("    </tr>\n");
        }
        stringBuilder.append("</table>\n");

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
