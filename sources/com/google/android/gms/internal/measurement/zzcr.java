package com.google.android.gms.internal.measurement;

import android.net.Uri;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzcr {
    private static final C3191a<String, Uri> zza = new C3191a<>();

    public static synchronized Uri zza(String str) {
        Uri uri;
        synchronized (zzcr.class) {
            uri = zza.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                zza.put(str, uri);
            }
        }
        return uri;
    }
}
