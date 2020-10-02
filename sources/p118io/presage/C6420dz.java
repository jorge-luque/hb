package p118io.presage;

import android.webkit.WebView;

/* renamed from: io.presage.dz */
public final class C6420dz {

    /* renamed from: a */
    private C6418dx f17007a;

    /* renamed from: b */
    private final C6417dw f17008b;

    public /* synthetic */ C6420dz() {
        this(C6417dw.f17004a);
    }

    /* renamed from: a */
    public final void mo35388a(boolean z, WebView webView) {
        if (C6417dw.m21286a()) {
            C6418dx b = C6417dw.m21287b();
            this.f17007a = b;
            if (b != null) {
                b.mo35386a(webView, z);
            }
        }
    }

    private C6420dz(C6417dw dwVar) {
        this.f17008b = dwVar;
    }

    /* renamed from: a */
    public final void mo35387a() {
        C6418dx dxVar;
        if (C6417dw.m21286a() && (dxVar = this.f17007a) != null) {
            dxVar.mo35385a();
        }
    }
}
