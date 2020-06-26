/*
 * Copyright © 2020. Lorem Popov Vasily.
 * Licensed under the GNU GPL, Version 3
 */

package io.github.rootlol.yam.activity;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import io.github.rootlol.yam.App;
import io.github.rootlol.yam.R;
import io.github.rootlol.yam.account.AccountUtils;
import io.github.rootlol.yam.account.YaMAccount;
import io.github.rootlol.yandexoauth.ApiOauth;
import io.github.rootlol.yandexoauth.pojo.ApiPojoToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.provider.Settings;

public class Login extends AccountAuthenticatorActivity {

    public static final String ARG_ACCOUNT_TYPE = "accountType";
    public static final String ARG_AUTH_TOKEN_TYPE = "authTokenType";
    public static final String ARG_IS_ADDING_NEW_ACCOUNT = "isAddingNewAccount";
    public static final String PARAM_USER_PASSWORD = "password";

    private AccountManager mAccountManager;
    private EditText mLogin;
    private EditText mPassword;
    private Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = (EditText) findViewById(R.id.a_login_te_login);
        mPassword = (EditText) findViewById(R.id.a_login_tep_password);
        mSignInButton = (Button) findViewById(R.id.a_login_b_singin);

        mAccountManager = AccountManager.get(this);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mLogin.getText())) {
                    mLogin.setError(getString(R.string.m_error_empty_login));
                } else if (TextUtils.isEmpty(mPassword.getText())) {
                    mPassword.setError(getString(R.string.m_error_empty_password));
                } else {
                    Map<String, String> LoginPostBody = new HashMap<>();
                    LoginPostBody.put("grant_type", "password");
                    LoginPostBody.put("client_id", "23cabbbdc6cd418abb4b39c32c41195d");
                    LoginPostBody.put("client_secret", "53bc75238f0c4d08a118e51fe9203300");
                    LoginPostBody.put("username", mLogin.getText().toString());
                    LoginPostBody.put("password", mPassword.getText().toString());
                    ApiOauth.getInstance().login(LoginPostBody).enqueue(new Callback<ApiPojoToken>() {
                        @Override
                        public void onResponse(Call<ApiPojoToken> call, Response<ApiPojoToken> response) {
                            if (response.body() != null && response.body().getAccessToken() != null) {
                                final Intent res = new Intent();

                                res.putExtra(AccountManager.KEY_ACCOUNT_NAME, mLogin.getText().toString());
                                res.putExtra(AccountManager.KEY_ACCOUNT_TYPE, AccountUtils.ACCOUNT_TYPE);
                                res.putExtra(AccountManager.KEY_AUTHTOKEN, "OAuth " + response.body().getAccessToken());
                                res.putExtra(PARAM_USER_PASSWORD, mPassword.getText().toString());

                                finishLogin(res);


                            } else {
                                Toast.makeText(getApplicationContext(), "hyu", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ApiPojoToken> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), R.string.m_error_not_connect_net, Toast.LENGTH_LONG).show();
                        }

                        private void finishLogin(Intent intent) {
                            final String accountName = intent.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                            final String accountPassword = intent.getStringExtra(PARAM_USER_PASSWORD);
                            final Account account = new Account(accountName, intent.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE));
                            String authToken = intent.getStringExtra(AccountManager.KEY_AUTHTOKEN);

                            if (getIntent().getBooleanExtra(ARG_IS_ADDING_NEW_ACCOUNT, false)) {
                                // Creating the account on the device and setting the auth token we got
                                // (Not setting the auth token will cause another call to the server to authenticate the user)
                                mAccountManager.addAccountExplicitly(account, accountPassword, null);
                                mAccountManager.setAuthToken(account, AccountUtils.AUTH_TOKEN_TYPE, authToken);
                            } else {
                                mAccountManager.setPassword(account, accountPassword);
                            }

                            setAccountAuthenticatorResult(intent.getExtras());
                            setResult(AccountAuthenticatorActivity.RESULT_OK, intent);

                            finish();
                        }
                    });
                }
            }
        });
    }

}

