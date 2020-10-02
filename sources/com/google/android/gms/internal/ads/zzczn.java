package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzczn implements zzdnx {
    private final String zzdcd;

    zzczn(String str) {
        this.zzdcd = str;
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        String valueOf = String.valueOf(this.zzdcd);
        zzazw.zzfa(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
        return null;
    }
}
