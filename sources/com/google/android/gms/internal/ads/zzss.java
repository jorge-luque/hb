package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzss extends PushbackInputStream {
    private final /* synthetic */ zzsn zzbtd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzss(zzsn zzsn, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbtd = zzsn;
    }

    public final synchronized void close() throws IOException {
        this.zzbtd.zzbsw.disconnect();
        super.close();
    }
}
