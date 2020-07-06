/*
 * Copyright © 2020. Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam;

import android.accounts.Account;
import android.app.Application;

import androidx.paging.PagedList;

/**
 * производим инициализацию и хранение данных
 *
 *
 */

public class App extends Application {
    public static String APP_ID = "YaM";

    public static App instance;
    private Account account;
    private PagedList.Config config;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(getSharedPreferences("settings", MODE_PRIVATE).getInt("LIMIT", 10))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static Account getAccount() {
        return instance.account;
    }

    public static void setAccount(Account account) {
        instance.account = account;
    }

    public static PagedList.Config getConfig() {
        return instance.config;
    }

}
