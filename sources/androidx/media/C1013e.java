package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* renamed from: androidx.media.e */
/* compiled from: MediaSessionManager */
public final class C1013e {

    /* renamed from: a */
    C1014f f2585a;

    public C1013e(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2585a = new C1015g(str, i, i2);
        } else {
            this.f2585a = new C1016h(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1013e)) {
            return false;
        }
        return this.f2585a.equals(((C1013e) obj).f2585a);
    }

    public int hashCode() {
        return this.f2585a.hashCode();
    }

    public C1013e(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f2585a = new C1015g(remoteUserInfo);
    }
}
