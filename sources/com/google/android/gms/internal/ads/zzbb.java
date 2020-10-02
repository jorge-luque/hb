package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbb extends ThreadLocal<ByteBuffer> {
    zzbb(zzbc zzbc) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
