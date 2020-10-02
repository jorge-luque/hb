package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.p019e.C0790c;

/* renamed from: androidx.media.g */
/* compiled from: MediaSessionManagerImplApi28 */
final class C1015g implements C1014f {

    /* renamed from: a */
    final MediaSessionManager.RemoteUserInfo f2586a;

    C1015g(String str, int i, int i2) {
        this.f2586a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1015g)) {
            return false;
        }
        return this.f2586a.equals(((C1015g) obj).f2586a);
    }

    public int hashCode() {
        return C0790c.m2493a(this.f2586a);
    }

    C1015g(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f2586a = remoteUserInfo;
    }
}
