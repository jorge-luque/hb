package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public interface zzjl {
    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    int zzad(int i) throws IOException, InterruptedException;

    void zzae(int i) throws IOException, InterruptedException;

    void zzaf(int i) throws IOException, InterruptedException;

    void zzgp();
}
