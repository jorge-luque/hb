package p118io.presage;

import android.widget.FrameLayout;
import p118io.presage.C6246bj;
import p118io.presage.mraid.browser.ShortcutActivity;

/* renamed from: io.presage.bm */
public final class C6249bm {

    /* renamed from: a */
    private C6246bj f16822a;

    /* renamed from: b */
    private final C6252bp f16823b;

    /* renamed from: c */
    private final ShortcutActivity f16824c;

    /* renamed from: d */
    private final C6384cq f16825d;

    /* renamed from: e */
    private final C6254br f16826e;

    /* renamed from: f */
    private final C6246bj.CamembertauCalvados f16827f;

    private C6249bm(C6252bp bpVar, ShortcutActivity shortcutActivity, C6384cq cqVar, C6254br brVar, C6246bj.CamembertauCalvados camembertauCalvados) {
        this.f16823b = bpVar;
        this.f16824c = shortcutActivity;
        this.f16825d = cqVar;
        this.f16826e = brVar;
        this.f16827f = camembertauCalvados;
    }

    /* renamed from: a */
    public final boolean mo34809a(String str, String str2, FrameLayout frameLayout) {
        C6253bq a;
        String b = this.f16823b.mo34813b(str2);
        if (b.length() > 0) {
            str = b;
        }
        if ((str.length() == 0) || (a = C6254br.m20992a(str)) == null) {
            return false;
        }
        if (!this.f16823b.mo34812a(a.mo34823c()) && !this.f16823b.mo34814c(a.mo34823c())) {
            return false;
        }
        m20948a(frameLayout, a);
        return true;
    }

    public /* synthetic */ C6249bm(C6252bp bpVar, ShortcutActivity shortcutActivity, C6384cq cqVar) {
        this(bpVar, shortcutActivity, cqVar, C6254br.f16850a, C6246bj.f16797a);
    }

    /* renamed from: a */
    private final void m20948a(FrameLayout frameLayout, C6253bq bqVar) {
        PontlEveque pontlEveque = new PontlEveque();
        pontlEveque.mo34626h("http://ogury.io");
        C6246bj a = C6246bj.CamembertauCalvados.m20926a(this.f16824c, pontlEveque, frameLayout, this.f16825d);
        this.f16822a = a;
        if (a != null) {
            a.mo34786a(bqVar);
        }
    }

    /* renamed from: a */
    public final void mo34808a() {
        C6246bj bjVar = this.f16822a;
        if (bjVar != null) {
            bjVar.mo34796d();
        }
    }
}
