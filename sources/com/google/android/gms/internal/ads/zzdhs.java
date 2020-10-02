package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdhs {
    public static ParcelFileDescriptor zze(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzbab.zzdzr.execute(new zzdhr(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }
}
