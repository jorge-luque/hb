package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdei implements zzdqx<Void> {
    zzdei(zzded zzded) {
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        zzawr.zzeg("Notification of cache hit successful.");
    }

    public final void zzb(Throwable th) {
        zzawr.zzeg("Notification of cache hit failed.");
    }
}
