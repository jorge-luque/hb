package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzra {
    @VisibleForTesting
    private ByteArrayOutputStream zzbrn = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
    @VisibleForTesting
    private Base64OutputStream zzbro = new Base64OutputStream(this.zzbrn, 10);

    public final String toString() {
        try {
            this.zzbro.close();
        } catch (IOException e) {
            zzazw.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbrn.close();
            return this.zzbrn.toString();
        } catch (IOException e2) {
            zzazw.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.zzbrn = null;
            this.zzbro = null;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbro.write(bArr);
    }
}
