package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzedy {
    private static final zzedw zziau = zzbgj();
    private static final zzedw zziav = new zzedv();

    static zzedw zzbgh() {
        return zziau;
    }

    static zzedw zzbgi() {
        return zziav;
    }

    private static zzedw zzbgj() {
        try {
            return (zzedw) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
