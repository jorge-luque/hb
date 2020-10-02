package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdyo extends ThreadLocal<Cipher> {
    zzdyo() {
    }

    private static Cipher zzbbw() {
        try {
            return zzdzi.zzhrs.zzho("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zzbbw();
    }
}
