package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.service.Validate;
import ru.job4j.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 13.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class UserServlet extends HttpServlet{
    private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    private final Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action") == "add") {
            logic.addValidate(req.getParameter("name"));
            //Вернуть что-то пользователю
        } else if (req.getParameter("action") == "update") {
            logic.updateValidate(Integer.parseInt(req.getParameter("id")), req.getParameter("name"));
            //Вернуть что-то пользователю
        } else if (req.getParameter("action") == "delete") {
            logic.deleteValidate(Integer.parseInt(req.getParameter("id")));
            //Вернуть что-то пользователю

        }
    }
}
