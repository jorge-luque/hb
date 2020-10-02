package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbtw extends zzbui<AppEventListener> implements zzafl {
    public zzbtw(Set<zzbvt<AppEventListener>> set) {
        super(set);
    }

    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbtv(str, str2));
    }
}
