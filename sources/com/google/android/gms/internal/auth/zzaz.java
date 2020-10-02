package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.loopj.android.http.C4250c;
import java.io.UnsupportedEncodingException;

public abstract class zzaz extends FastSafeParcelableJsonResponse {
    private static String zzem = "AUTH";

    public byte[] toByteArray() {
        try {
            return toString().getBytes(C4250c.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            Log.e(zzem, "Error serializing object.", e);
            return null;
        }
    }
}
