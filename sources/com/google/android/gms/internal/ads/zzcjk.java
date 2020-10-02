package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzcjk extends Exception {
    private final int errorCode;

    public zzcjk(int i) {
        this.errorCode = i;
    }

    public static int zzd(Throwable th) {
        if (th instanceof zzcjk) {
            return ((zzcjk) th).errorCode;
        }
        if (th instanceof zzayd) {
            return ((zzayd) th).getErrorCode();
        }
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public zzcjk(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public zzcjk(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = 0;
    }
}
