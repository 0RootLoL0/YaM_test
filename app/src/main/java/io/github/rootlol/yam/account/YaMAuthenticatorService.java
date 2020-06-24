package io.github.rootlol.yam.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class YaMAuthenticatorService extends Service {

    private static YaMAccountAuthenticator sAccountAuthenticator;

    @Override
    public IBinder onBind(Intent intent) {
        IBinder binder = null;
        if (intent.getAction().equals(android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT)) {
            binder = getAuthenticator().getIBinder();
        }
        return binder;
    }

    private YaMAccountAuthenticator getAuthenticator() {
        if (null == YaMAuthenticatorService.sAccountAuthenticator) {
            YaMAuthenticatorService.sAccountAuthenticator = new YaMAccountAuthenticator(this);
        }
        return YaMAuthenticatorService.sAccountAuthenticator;
    }
}
