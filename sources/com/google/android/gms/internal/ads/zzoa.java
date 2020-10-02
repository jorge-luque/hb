package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzoa extends IOException {
    private final int type;
    private final zznv zzbfy;

    public zzoa(String str, zznv zznv, int i) {
        super(str);
        this.zzbfy = zznv;
        this.type = 1;
    }

    public zzoa(IOException iOException, zznv zznv, int i) {
        super(iOException);
        this.zzbfy = zznv;
        this.type = i;
    }

    public zzoa(String str, IOException iOException, zznv zznv, int i) {
        super(str, iOException);
        this.zzbfy = zznv;
        this.type = 1;
    }
}
