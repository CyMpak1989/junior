package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.model.UserBuilder;
import ru.job4j.service.Validate;
import ru.job4j.service.ValidateService;
import ru.job4j.service.ValidateStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 01.08.2018.
 * @version 1.0.
 * @since 0.1.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserDeleteServletTest {
    @Test()
    public void deleteUser() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        validate.addValidate(new UserBuilder().setName("Petr Arsentev").build());
        mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("1");
        new UserDeleteServlet().doPost(req, resp);
        assertThat(validate.findAllValidate().iterator().hasNext(), is(false));

    }

}