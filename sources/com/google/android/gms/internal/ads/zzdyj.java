package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdyj extends ThreadLocal<Cipher> {
    zzdyj() {
    }

    private static Cipher zzbbw() {
        try {
            return zzdzi.zzhrs.zzho("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zzbbw();
    }
}
