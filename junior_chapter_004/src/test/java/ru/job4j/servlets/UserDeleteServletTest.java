package ru.job4j.servlets;

import org.junit.Test;
import ru.job4j.model.User;
import ru.job4j.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertNull;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 01.08.2018.
 * @version 1.0.
 * @since 0.1.
 */
public class UserDeleteServletTest {
    @Test()
    public void deleteUser() throws ServletException, IOException {
        UserDeleteServlet userDeleteServlet = new UserDeleteServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("id")).thenReturn("13");

        userDeleteServlet.doPost(request, response);

        assertNull(DbStore.getInstance().findByIdStore(13).getLogin());
    }

}