/*
 * Copyright © 2020. Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam;

import android.accounts.Account;
import android.app.Application;

public class App extends Application {
    public static String APP_ID = "YaM";

    public static App instance;
    private Account account;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
