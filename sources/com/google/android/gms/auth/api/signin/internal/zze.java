package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.p026b.C0995a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zze extends C0995a<Void> implements SignInConnectionListener {
    private Semaphore zzbg = new Semaphore(0);
    private Set<GoogleApiClient> zzbh;

    public zze(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzbh = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzf */
    public final Void loadInBackground() {
        int i = 0;
        for (GoogleApiClient maybeSignIn : this.zzbh) {
            if (maybeSignIn.maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zzbg.tryAcquire(i, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public final void onComplete() {
        this.zzbg.release();
    }

    /* access modifiers changed from: protected */
    public final void onStartLoading() {
        this.zzbg.drainPermits();
        forceLoad();
    }
}
