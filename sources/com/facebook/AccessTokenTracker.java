package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import p075d.p090g.p091a.C3218a;

public abstract class AccessTokenTracker {
    /* access modifiers changed from: private */
    public static final String TAG = "AccessTokenTracker";
    private final C3218a broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    private class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        private CurrentAccessTokenBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED.equals(intent.getAction())) {
                Utility.logd(AccessTokenTracker.TAG, "AccessTokenChanged");
                AccessTokenTracker.this.onCurrentAccessTokenChanged((AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_OLD_ACCESS_TOKEN), (AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_NEW_ACCESS_TOKEN));
            }
        }
    }

    public AccessTokenTracker() {
        Validate.sdkInitialized();
        this.receiver = new CurrentAccessTokenBroadcastReceiver();
        this.broadcastManager = C3218a.m10641a(FacebookSdk.getApplicationContext());
        startTracking();
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        this.broadcastManager.mo18871a(this.receiver, intentFilter);
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    /* access modifiers changed from: protected */
    public abstract void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2);

    public void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.mo18870a(this.receiver);
            this.isTracking = false;
        }
    }
}
