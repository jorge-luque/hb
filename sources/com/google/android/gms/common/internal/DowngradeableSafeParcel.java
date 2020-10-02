package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zzdo = new Object();
    private static ClassLoader zzdp;
    private static Integer zzdq;
    private boolean zzdr = false;

    @KeepForSdk
    protected static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }

    @KeepForSdk
    protected static Integer getUnparcelClientVersion() {
        synchronized (zzdo) {
        }
        return null;
    }

    private static ClassLoader zzp() {
        synchronized (zzdo) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract boolean prepareForClientVersion(int i);

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.zzdr = z;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzdr;
    }
}
