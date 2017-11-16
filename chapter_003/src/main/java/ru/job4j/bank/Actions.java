package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Actions {
    /**
     *
     */
    private Map<User, List<Account>> clients;

    /**
     *
     * @param user
     */
    public void addUser(User user) {
        clients.put(user, new ArrayList<Account>());
    }

    /**
     *
     * @param user
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }

    /**
     *
     * @param user
     * @param account
     */
    public void addAccountToUser(User user, Account account) {
        clients.get(user).add(account);
    }

    /**
     *
     * @param user
     * @param account
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> list = clients.get(user);
        for (Account a : list) {
            if (a.equals(account)) {
                list.remove(a);
            }
        }
    }

    /**
     *
     * @param user
     * @return
     */
    public List<Account> getUserAccounts(User user) {
        return clients.get(user);
    }

    /**
     *
     * @param srcUser
     * @param srcAccount
     * @param dstUser
     * @param dstAccount
     * @param amount
     * @return
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transfer = false;
        if (clients.containsKey(srcUser) && clients.containsKey(dstUser)) {
            for (Account account : clients.get(srcUser)) {
                if (account.equals(srcAccount) && account.getValue() >= amount) {
                    account.setValue(account.getValue() - amount);
                }
            }

            for (Account account : clients.get(dstUser)) {
                if (account.equals(dstAccount)) {
                    account.setValue(account.getValue() + amount);
                }
            }
            transfer = true;
        }
        return transfer;
    }
}
