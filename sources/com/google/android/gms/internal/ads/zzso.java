package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzso extends zzbaj<InputStream> {
    private final /* synthetic */ zzsl zzbsw;

    zzso(zzsl zzsl) {
        this.zzbsw = zzsl;
    }

    public final boolean cancel(boolean z) {
        this.zzbsw.disconnect();
        return super.cancel(z);
    }
}
