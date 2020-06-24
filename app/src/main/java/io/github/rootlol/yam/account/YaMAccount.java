package io.github.rootlol.yam.account;

import android.accounts.Account;
import android.os.Parcel;

public class YaMAccount extends Account {

    public static final String TYPE = "io.github.rootlol.yam";

    public static final String TOKEN_FULL_ACCESS = "io.github.rootlol.yam.TOKEN_FULL_ACCESS";

    public static final String KEY_PASSWORD = "io.github.rootlol.yam.KEY_PASSWORD";


    public YaMAccount(String name) {
        super(name, TYPE);
    }
    public YaMAccount(Parcel in) {
        super(in);
    }
}
