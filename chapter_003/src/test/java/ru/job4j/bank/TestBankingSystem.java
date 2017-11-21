package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestBankingSystem {
    @Test
    public void addUser() {
        User user = new User("Владимир", 112233);
        Actions actions = new Actions();
        actions.addUser(user);
        assertThat(actions.getClients().isEmpty(), is(false));
    }

    @Test
    public void deleteUser() {
        User user = new User("Владимир", 112233);
        Actions actions = new Actions();
        actions.deleteUser(user);
        assertThat(actions.getClients().isEmpty(), is(true));
    }

    @Test
    public void addAccountToUser() {
        User user = new User("Владимир", 112233);
        Account accountUser = new Account(1000, 00005555);
        Actions actions = new Actions();
        actions.addUser(user);
        actions.addAccountToUser(user, accountUser);
        assertThat(actions.getClients().get(user).isEmpty(), is(false));
    }

    @Test
    public void deleteAccountFromUser() {
        User user = new User("Владимир", 112233);
        Account accountUser = new Account(1000, 00005555);
        Actions actions = new Actions();
        actions.addUser(user);
        actions.addAccountToUser(user, accountUser);
        actions.deleteAccountFromUser(user, accountUser);
        assertThat(actions.getClients().get(user).isEmpty(), is(true));
    }


}
