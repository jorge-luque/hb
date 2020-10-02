package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzj;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.internal.firebase_messaging.zzm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.messaging.t */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3820t implements Closeable {

    /* renamed from: a */
    private final URL f10560a;

    /* renamed from: b */
    private Task<Bitmap> f10561b;

    /* renamed from: c */
    private volatile InputStream f10562c;

    private C3820t(URL url) {
        this.f10560a = url;
    }

    /* renamed from: a */
    public static C3820t m12888a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new C3820t(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    /* renamed from: u */
    private final byte[] m12889u() throws IOException {
        URLConnection openConnection = this.f10560a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.f10562c = inputStream;
                byte[] zza = zzj.zza(zzj.zza(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    int length = zza.length;
                    String valueOf = String.valueOf(this.f10560a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("Downloaded ");
                    sb.append(length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                    sb.toString();
                }
                if (zza.length <= 1048576) {
                    return zza;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                zzm.zza(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public final void close() {
        try {
            zzk.zza(this.f10562c);
        } catch (NullPointerException e) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e);
        }
    }

    /* renamed from: d */
    public final Task<Bitmap> mo27511d() {
        return (Task) Preconditions.checkNotNull(this.f10561b);
    }

    /* renamed from: t */
    public final Bitmap mo27512t() throws IOException {
        String valueOf = String.valueOf(this.f10560a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        sb.toString();
        byte[] u = m12889u();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(u, 0, u.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.f10560a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                sb2.toString();
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.f10560a);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }

    /* renamed from: a */
    public final void mo27509a(Executor executor) {
        this.f10561b = Tasks.call(executor, new C3822v(this));
    }
}
