package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zznv {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbfm;
    public final long zzbfn;
    public final String zzcc;
    public final long zzce;

    public zznv(Uri uri2) {
        this(uri2, 0);
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbfm);
        long j = this.zzbfn;
        long j2 = this.position;
        long j3 = this.zzce;
        String str = this.zzcc;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    private zznv(Uri uri2, int i) {
        this(uri2, 0, -1, (String) null, 0);
    }

    public zznv(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zznv(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, (String) null, 0);
    }

    private zznv(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, (byte[]) null, j, j2, j3, str, i);
    }

    public zznv(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzoh.checkArgument(j >= 0);
        zzoh.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzoh.checkArgument(z);
        this.uri = uri2;
        this.zzbfm = bArr;
        this.zzbfn = j;
        this.position = j2;
        this.zzce = j3;
        this.zzcc = str;
        this.flags = i;
    }
}
