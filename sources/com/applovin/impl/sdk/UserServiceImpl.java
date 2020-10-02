package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

public class UserServiceImpl implements AppLovinUserService {

    /* renamed from: a */
    private final C1941j f5556a;

    UserServiceImpl(C1941j jVar) {
        this.f5556a = jVar;
    }

    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.f5556a.mo8538Q().mo8517a(activity, onConsentDialogDismissListener);
    }

    public String toString() {
        return "UserService{}";
    }
}
