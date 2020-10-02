package androidx.lifecycle;

import androidx.lifecycle.C0965e;

class CompositeGeneratedAdaptersObserver implements C0968f {

    /* renamed from: a */
    private final C0963c[] f2483a;

    CompositeGeneratedAdaptersObserver(C0963c[] cVarArr) {
        this.f2483a = cVarArr;
    }

    /* renamed from: a */
    public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
        C0976l lVar = new C0976l();
        for (C0963c a : this.f2483a) {
            a.mo4994a(hVar, aVar, false, lVar);
        }
        for (C0963c a2 : this.f2483a) {
            a2.mo4994a(hVar, aVar, true, lVar);
        }
    }
}
