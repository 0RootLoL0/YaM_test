/*
 * Copyright © 2020 . Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.activity;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.io.IOException;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.account.AccountUtils;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

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
                        App.setAccount(AccountUtils.getAccount(getContext(), accountName));

                        startActivity(new Intent(getActivity(), Splash.class));
                                            }
                } catch (AuthenticatorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (OperationCanceledException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            Preference addUserButton = findPreference("add_user");
            addUserButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference arg0) {
                    AccountManager.get(getContext()).addAccount(AccountUtils.ACCOUNT_TYPE, AccountUtils.AUTH_TOKEN_TYPE, null, null, getActivity(),  new GetAuthTokenCallback(), null);
                    return true;
                }
            });

            Preference delUserButton = findPreference("del_user");
            delUserButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference arg0) {
                    AccountManager.get(getContext()).removeAccount(App.getAccount(), getActivity(), new GetAuthTokenCallback(), null);
                    return true;
                }
            });

        }
    }
}