package io.github.rootlol.yam.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

public class AccountUtils {
    public static final String ACCOUNT_TYPE = "io.github.rootlol.yam";
    public static final String AUTH_TOKEN_TYPE = "io.github.rootlol.yam.aaa";

    public static Account getAccount(Context context, String accountName) {
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccountsByType(ACCOUNT_TYPE);
        for (Account account : accounts) {
            if (account.name.equalsIgnoreCase(accountName)) {
                return account;
            }
        }
        return null;
    }

}
