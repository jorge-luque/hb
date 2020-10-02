package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdnk extends Exception {
    private final int zzhdj;

    public zzdnk(int i, String str) {
        super(str);
        this.zzhdj = i;
    }

    public final int zzavm() {
        return this.zzhdj;
    }

    public zzdnk(int i, Throwable th) {
        super(th);
        this.zzhdj = i;
    }
}
