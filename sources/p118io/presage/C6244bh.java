package p118io.presage;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* renamed from: io.presage.bh */
public final class C6244bh {

    /* renamed from: a */
    private final Context f16794a;

    /* renamed from: b */
    private final FrameLayout f16795b;

    /* renamed from: c */
    private final PontlEveque f16796c;

    public C6244bh(Context context, FrameLayout frameLayout, PontlEveque pontlEveque) {
        this.f16794a = context;
        this.f16795b = frameLayout;
        this.f16796c = pontlEveque;
    }

    /* renamed from: a */
    public final C6396db mo34783a(C6253bq bqVar) {
        FrameLayout.LayoutParams b = m20893a(bqVar, (FrameLayout.LayoutParams) null);
        C6396db a = C6399de.m21251a(this.f16794a, this.f16796c);
        if (a == null) {
            return null;
        }
        a.setTag(bqVar.mo34823c());
        C6245bi.m20900a(a);
        this.f16795b.addView(a, b);
        return a;
    }

    /* renamed from: b */
    private static void m20897b(C6253bq bqVar, FrameLayout.LayoutParams layoutParams) {
        if (bqVar.mo34831g() != -1) {
            layoutParams.leftMargin = C6215af.m20776b(bqVar.mo34831g());
        }
        if (bqVar.mo34830f() != -1) {
            layoutParams.topMargin = C6215af.m20776b(bqVar.mo34830f());
        }
    }

    /* renamed from: a */
    public static void m20894a(WebView webView, C6253bq bqVar) {
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        webView.setLayoutParams(m20893a(bqVar, (FrameLayout.LayoutParams) layoutParams));
    }

    /* renamed from: a */
    public final void mo34784a(WebView webView) {
        this.f16795b.removeView(webView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static FrameLayout.LayoutParams m20893a(C6253bq bqVar, FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        m20897b(bqVar, layoutParams);
        m20895a(layoutParams, bqVar);
        return layoutParams;
    }

    /* renamed from: a */
    private static void m20895a(FrameLayout.LayoutParams layoutParams, C6253bq bqVar) {
        int i = -1;
        layoutParams.width = bqVar.mo34829e() <= 0 ? -1 : C6215af.m20776b(bqVar.mo34829e());
        if (bqVar.mo34827d() > 0) {
            i = C6215af.m20776b(bqVar.mo34827d());
        }
        layoutParams.height = i;
    }
}
