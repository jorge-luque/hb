package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.C0911c;
import androidx.fragment.app.C0917h;
import androidx.fragment.app.C0937k;
import androidx.fragment.app.Fragment;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.common.C2707R;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity extends C0911c {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment singleFragment;

    private void handlePassThroughError() {
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), (Bundle) null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    /* access modifiers changed from: protected */
    public Fragment getFragment() {
        Intent intent = getIntent();
        C0917h supportFragmentManager = getSupportFragmentManager();
        Fragment a = supportFragmentManager.mo4777a(FRAGMENT_TAG);
        if (a != null) {
            return a;
        }
        if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            return facebookDialogFragment;
        } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
            DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
            deviceShareDialogFragment.setRetainInstance(true);
            deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra(AppLovinEventTypes.USER_VIEWED_CONTENT));
            deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            return deviceShareDialogFragment;
        } else {
            LoginFragment loginFragment = new LoginFragment();
            loginFragment.setRetainInstance(true);
            C0937k a2 = supportFragmentManager.mo4778a();
            a2.mo4917a(C2707R.C2709id.com_facebook_fragment_container, loginFragment, FRAGMENT_TAG);
            a2.mo4664a();
            return loginFragment;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.singleFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(C2707R.layout.com_facebook_activity_layout);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
        } else {
            this.singleFragment = getFragment();
        }
    }
}
