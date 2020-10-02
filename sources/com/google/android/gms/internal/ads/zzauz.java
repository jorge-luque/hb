package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzauz implements zzavh {
    static final zzavh zzdtc = new zzauz();

    private zzauz() {
    }

    public final Object zzb(zzbgr zzbgr) {
        String currentScreenName = zzbgr.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbgr.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
