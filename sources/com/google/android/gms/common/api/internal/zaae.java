package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import p075d.p080b.C3193b;

public class zaae extends zal {
    private GoogleApiManager zabm;
    private final C3193b<zai<?>> zafp = new C3193b<>();

    private zaae(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zaa(Activity activity, GoogleApiManager googleApiManager, zai<?> zai) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaae = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaae == null) {
            zaae = new zaae(fragment);
        }
        zaae.zabm = googleApiManager;
        Preconditions.checkNotNull(zai, "ApiKey cannot be null");
        zaae.zafp.add(zai);
        googleApiManager.zaa(zaae);
    }

    private final void zaak() {
        if (!this.zafp.isEmpty()) {
            this.zabm.zaa(this);
        }
    }

    public void onResume() {
        super.onResume();
        zaak();
    }

    public void onStart() {
        super.onStart();
        zaak();
    }

    public void onStop() {
        super.onStop();
        this.zabm.zab(this);
    }

    /* access modifiers changed from: package-private */
    public final C3193b<zai<?>> zaaj() {
        return this.zafp;
    }

    /* access modifiers changed from: protected */
    public final void zao() {
        this.zabm.zao();
    }

    /* access modifiers changed from: protected */
    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zabm.zaa(connectionResult, i);
    }
}
