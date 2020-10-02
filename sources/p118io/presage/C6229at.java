package p118io.presage;

import android.app.Application;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.MoatFactory;

/* renamed from: io.presage.at */
public final class C6229at {

    /* renamed from: a */
    private boolean f16767a;

    /* renamed from: b */
    private final MoatAnalytics f16768b;

    public C6229at(MoatAnalytics moatAnalytics) {
        this.f16768b = moatAnalytics;
    }

    /* renamed from: a */
    public final void mo34744a(Application application) {
        this.f16767a = true;
        this.f16768b.start(application);
    }

    /* renamed from: a */
    public static MoatFactory m20816a() {
        MoatFactory create = MoatFactory.create();
        C6514hl.m21414a((Object) create, "MoatFactory.create()");
        return create;
    }
}
