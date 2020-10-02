package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zzbe;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.zzbe = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.zzbe);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
