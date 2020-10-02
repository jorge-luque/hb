package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: androidx.cardview.widget.b */
/* compiled from: CardViewApi21Impl */
class C0661b implements C0665e {
    C0661b() {
    }

    /* renamed from: g */
    private C0666f m1933g(C0664d dVar) {
        return (C0666f) dVar.mo3680c();
    }

    /* renamed from: a */
    public void mo3682a() {
    }

    /* renamed from: a */
    public void mo3686a(C0664d dVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        dVar.mo3677a(new C0666f(colorStateList, f));
        View d = dVar.mo3681d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo3690c(dVar, f3);
    }

    /* renamed from: b */
    public float mo3687b(C0664d dVar) {
        return mo3692e(dVar) * 2.0f;
    }

    /* renamed from: c */
    public void mo3690c(C0664d dVar, float f) {
        m1933g(dVar).mo3697a(f, dVar.mo3679b(), dVar.mo3678a());
        mo3693f(dVar);
    }

    /* renamed from: d */
    public float mo3691d(C0664d dVar) {
        return m1933g(dVar).mo3695a();
    }

    /* renamed from: e */
    public float mo3692e(C0664d dVar) {
        return m1933g(dVar).mo3698b();
    }

    /* renamed from: f */
    public void mo3693f(C0664d dVar) {
        if (!dVar.mo3679b()) {
            dVar.mo3676a(0, 0, 0, 0);
            return;
        }
        float d = mo3691d(dVar);
        float e = mo3692e(dVar);
        int ceil = (int) Math.ceil((double) C0667g.m1977a(d, e, dVar.mo3678a()));
        int ceil2 = (int) Math.ceil((double) C0667g.m1981b(d, e, dVar.mo3678a()));
        dVar.mo3676a(ceil, ceil2, ceil, ceil2);
    }

    /* renamed from: b */
    public void mo3688b(C0664d dVar, float f) {
        dVar.mo3681d().setElevation(f);
    }

    /* renamed from: c */
    public void mo3689c(C0664d dVar) {
        mo3690c(dVar, mo3691d(dVar));
    }

    /* renamed from: a */
    public void mo3685a(C0664d dVar, float f) {
        m1933g(dVar).mo3696a(f);
    }

    /* renamed from: a */
    public float mo3684a(C0664d dVar) {
        return mo3692e(dVar) * 2.0f;
    }
}
