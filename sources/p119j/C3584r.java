package p119j;

import android.support.p004v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* renamed from: j.r */
/* compiled from: SegmentPool */
final class C3584r {
    @Nullable

    /* renamed from: a */
    static C3583q f10047a;

    /* renamed from: b */
    static long f10048b;

    private C3584r() {
    }

    /* renamed from: a */
    static C3583q m12202a() {
        synchronized (C3584r.class) {
            if (f10047a == null) {
                return new C3583q();
            }
            C3583q qVar = f10047a;
            f10047a = qVar.f10045f;
            qVar.f10045f = null;
            f10048b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return qVar;
        }
    }

    /* renamed from: a */
    static void m12203a(C3583q qVar) {
        if (qVar.f10045f != null || qVar.f10046g != null) {
            throw new IllegalArgumentException();
        } else if (!qVar.f10043d) {
            synchronized (C3584r.class) {
                if (f10048b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f10048b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    qVar.f10045f = f10047a;
                    qVar.f10042c = 0;
                    qVar.f10041b = 0;
                    f10047a = qVar;
                }
            }
        }
    }
}
