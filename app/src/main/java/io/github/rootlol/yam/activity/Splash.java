/*
 * Copyright © 2020. Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.account.AccountUtils;

public class Splash extends AppCompatActivity {

    private AccountManager mAccountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAccountManager = AccountManager.get(this);
        mAccountManager.getAuthTokenByFeatures(AccountUtils.ACCOUNT_TYPE, AccountUtils.AUTH_TOKEN_TYPE, null, this, null, null, new GetAuthTokenCallback(), null);
    }

    private class GetAuthTokenCallback implements AccountManagerCallback<Bundle> {

        private static final int REQ_SIGNUP = 1;

        @Override
        public void run(AccountManagerFuture<Bundle> result) {
            Bundle bundle;
            try {
                bundle = result.getResult();

                //intent не равно null когда есть множество акаунтов
                final Intent intent = (Intent) bundle.get(AccountManager.KEY_INTENT);

                if (null != intent) {
                    startActivityForResult(intent, REQ_SIGNUP);
                } else {
                    //здесь получем имя аккаунта который выбрал пользователь
                    //если аккаунтов нет он вернёт null
                    final String accountName = bundle.getString(AccountManager.KEY_ACCOUNT_NAME);

                    //получем сам акаунт и сохраняем
                    App.getInstance().setAccount(AccountUtils.getAccount(Splash.this, accountName));

                    startActivity(new Intent(Splash.this, Main.class));
                    finish();
                }
            } catch (AuthenticatorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (OperationCanceledException e) {
                finish();
            }
        }
    }
}
