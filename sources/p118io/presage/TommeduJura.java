package p118io.presage;

import org.json.JSONObject;

/* renamed from: io.presage.TommeduJura */
public final class TommeduJura {

    /* renamed from: a */
    public static final CamembertauCalvados f16727a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private JSONObject f16728b;

    /* renamed from: c */
    private String f16729c;

    /* renamed from: d */
    private final String f16730d;

    /* renamed from: e */
    private final C6556j f16731e;

    /* renamed from: f */
    private final C6263c f16732f;

    /* renamed from: g */
    private final C6502h f16733g;

    /* renamed from: h */
    private final boolean f16734h;

    /* renamed from: io.presage.TommeduJura$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public TommeduJura(TommedeSavoie tommedeSavoie, C6263c cVar, C6502h hVar, boolean z) {
        this.f16732f = cVar;
        this.f16733g = hVar;
        this.f16734h = z;
        JSONObject a = tommedeSavoie.mo34712a(cVar);
        this.f16728b = a;
        TommeCrayeuse tommeCrayeuse = TommeCrayeuse.f16704a;
        String jSONObject = a.toString();
        C6514hl.m21414a((Object) jSONObject, "generatedProfig.toString()");
        this.f16729c = TommeCrayeuse.m20711a(jSONObject);
        String d = this.f16733g.mo35505d();
        this.f16730d = d;
        C6566l lVar = C6566l.f17118a;
        this.f16731e = C6566l.m21541a(d);
    }

    /* renamed from: c */
    private final boolean m20745c() {
        return this.f16731e != null ? this.f16733g.mo35497a() >= this.f16731e.mo35583f() : this.f16733g.mo35497a() >= 10;
    }

    /* renamed from: d */
    private final boolean m20746d() {
        C6556j jVar = this.f16731e;
        if (jVar != null) {
            return jVar.mo35568a();
        }
        return true;
    }

    /* renamed from: e */
    private final boolean m20747e() {
        return C6514hl.m21416a((Object) this.f16733g.mo35511g(), (Object) C6221al.m20787a());
    }

    /* renamed from: f */
    private final boolean m20748f() {
        C6556j jVar = this.f16731e;
        return this.f16733g.mo35512h() + (jVar != null ? jVar.mo35585g() : 0) > System.currentTimeMillis();
    }

    /* renamed from: g */
    private final boolean m20749g() {
        return !C6514hl.m21416a((Object) this.f16733g.mo35501b(), (Object) this.f16729c);
    }

    /* renamed from: h */
    private final boolean m20750h() {
        return !C6514hl.m21416a((Object) this.f16733g.mo35503c(), (Object) this.f16732f.mo34854a());
    }

    /* renamed from: i */
    private final JSONObject m20751i() {
        if (this.f16734h || m20749g()) {
            return this.f16728b;
        }
        return new JSONObject();
    }

    /* renamed from: j */
    private final boolean m20752j() {
        return (this.f16730d.length() == 0) || C6514hl.m21416a((Object) this.f16730d, (Object) "{}");
    }

    /* renamed from: a */
    public final C6556j mo34721a() {
        return this.f16731e;
    }

    /* renamed from: b */
    public final TommedeYenne mo34722b() {
        C6556j jVar = this.f16731e;
        long g = jVar != null ? jVar.mo35585g() : 43200000;
        boolean d = m20746d();
        boolean z = !d;
        boolean c = m20745c();
        boolean z2 = true;
        boolean z3 = !m20748f();
        boolean z4 = !m20747e();
        boolean z5 = z && z4;
        if (!d || c || !z3 || (!this.f16734h && !m20749g() && !z4 && !z3)) {
            z2 = false;
        }
        if ((this.f16734h || m20752j()) && !c) {
            return new TommedeYenne(true, g, this.f16728b, d, this.f16729c);
        }
        if (!z2 && !z5 && !m20750h()) {
            return new TommedeYenne(g, new JSONObject(), d);
        }
        String str = null;
        if (m20749g()) {
            str = this.f16729c;
        }
        return new TommedeYenne(true, g, m20751i(), d, str);
    }
}
