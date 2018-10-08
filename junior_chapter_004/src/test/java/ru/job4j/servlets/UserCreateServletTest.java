package ru.job4j.servlets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.service.Validate;
import ru.job4j.service.ValidateService;
import ru.job4j.service.ValidateStub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.support.SuppressCode.suppressConstructor;

/**
 * @author Vladimir Lembikov (cympak2009@mail.ru) on 31.07.2018.
 * @version 1.0.
 * @since 0.1.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ValidateService.class})
public class UserCreateServletTest {
    private final Validate validate = ValidateStub.getInstance();
//    @Before
//    public void testSingleton() {
//        suppressConstructor(ValidateService.class);
//        mockStatic(ValidateService.class);
//    }

    @Test
    public void whenAddUserThenStoreIt() throws Exception {
//        Validate validate = new ValidateStub();
        mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn((ValidateService) validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserCreateServlet().doPost(req, resp);
        assertThat(validate.findAllValidate().iterator().next().getName(), is("Petr Arsentev"));
    }

}