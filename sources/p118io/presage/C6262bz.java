package p118io.presage;

import android.content.Context;
import java.util.List;

/* renamed from: io.presage.bz */
public final class C6262bz {

    /* renamed from: a */
    public static final CamembertauCalvados f16876a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final Context f16877b;

    /* renamed from: c */
    private final C6261by f16878c;

    /* renamed from: d */
    private C6276cm f16879d;

    /* renamed from: e */
    private final C6267cd f16880e;

    /* renamed from: f */
    private final C6565k f16881f;

    /* renamed from: g */
    private long f16882g;

    /* renamed from: io.presage.bz$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6262bz m21035a(Context context) {
            return new C6262bz(context, C6261by.f16869a);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private C6262bz(Context context, C6261by byVar, C6276cm cmVar, C6267cd cdVar, C6565k kVar) {
        this.f16878c = byVar;
        this.f16879d = cmVar;
        this.f16880e = cdVar;
        this.f16881f = kVar;
        this.f16882g = 80000;
        this.f16877b = context.getApplicationContext();
    }

    /* renamed from: b */
    private final C6396db m21032b(PontlEveque pontlEveque) {
        Context context = this.f16877b;
        C6514hl.m21414a((Object) context, "context");
        C6396db a = C6399de.m21251a(context, pontlEveque);
        if (a != null) {
            C6223an.m20791a(a);
        }
        return a;
    }

    /* renamed from: a */
    public final void mo34853a(C6265cb cbVar, List<PontlEveque> list, C6264ca caVar) {
        m21031a(caVar, cbVar);
        for (PontlEveque next : list) {
            Context context = this.f16877b;
            C6514hl.m21414a((Object) context, "context");
            C6396db a = C6399de.m21251a(context, next);
            if (a != null) {
                this.f16880e.mo34858a(a);
                C6223an.m20791a(a);
                this.f16879d.mo34873a((C6275cl) new C6269cf(a, next, this.f16878c, cbVar));
                if (next.mo34643s().length() > 0) {
                    m21030a(next);
                }
            } else {
                caVar.mo34443b();
                return;
            }
        }
        this.f16879d.mo34872a(this.f16880e, this.f16882g, list.size());
    }

    public /* synthetic */ C6262bz(Context context, C6261by byVar) {
        this(context, byVar, new C6276cm(), new C6267cd(), C6565k.f17116a);
    }

    /* renamed from: a */
    private final void m21031a(C6264ca caVar, C6265cb cbVar) {
        this.f16879d.mo34871a(caVar);
        this.f16879d.mo34874b();
        C6261by.m21021a(cbVar);
        m21029a();
    }

    /* renamed from: a */
    private final void m21029a() {
        Context context = this.f16877b;
        C6514hl.m21414a((Object) context, "context");
        C6556j a = C6565k.m21538a(context);
        if (a != null) {
            this.f16882g = a.mo35590k();
        }
    }

    /* renamed from: a */
    private final void m21030a(PontlEveque pontlEveque) {
        C6396db b = m21032b(pontlEveque);
        if (b != null) {
            C6245bi.m20900a(b);
            this.f16879d.mo34873a((C6275cl) new C6271ch(b, pontlEveque));
        }
    }

    /* renamed from: a */
    public final void mo34852a(C6265cb cbVar) {
        this.f16879d.mo34871a((C6264ca) null);
        this.f16879d.mo34874b();
        C6261by.m21021a(cbVar);
    }
}
