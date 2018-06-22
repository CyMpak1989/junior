package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;
import ru.job4j.service.Validate;
import ru.job4j.service.ValidateService;
import ru.job4j.store.MemoreStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 21.06.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class UserUpdateServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UserUpdateServlet.class);
    private Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = MemoreStore.getInstance().findByIdStore(Integer.parseInt(req.getParameter("id")));
        System.out.println(user);
        resp.sendRedirect(String.format("%s/edit.jsp", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logic.updateValidate(Integer.parseInt(req.getParameter("id")), req.getParameter("name"));
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
