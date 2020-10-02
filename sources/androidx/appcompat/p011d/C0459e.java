package androidx.appcompat.p011d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.d.e */
/* compiled from: StandaloneActionMode */
public class C0459e extends C0455b implements C0482g.C0483a {

    /* renamed from: c */
    private Context f650c;

    /* renamed from: d */
    private ActionBarContextView f651d;

    /* renamed from: e */
    private C0455b.C0456a f652e;

    /* renamed from: f */
    private WeakReference<View> f653f;

    /* renamed from: g */
    private boolean f654g;

    /* renamed from: h */
    private C0482g f655h;

    public C0459e(Context context, ActionBarContextView actionBarContextView, C0455b.C0456a aVar, boolean z) {
        this.f650c = context;
        this.f651d = actionBarContextView;
        this.f652e = aVar;
        C0482g gVar = new C0482g(actionBarContextView.getContext());
        gVar.mo2546c(1);
        this.f655h = gVar;
        gVar.mo2522a((C0482g.C0483a) this);
    }

    /* renamed from: a */
    public void mo2153a(CharSequence charSequence) {
        this.f651d.mo2796a(charSequence);
    }

    /* renamed from: b */
    public void mo2157b(CharSequence charSequence) {
        this.f651d.mo2799b(charSequence);
    }

    /* renamed from: c */
    public Menu mo2158c() {
        return this.f655h;
    }

    /* renamed from: d */
    public MenuInflater mo2159d() {
        return new C0462g(this.f651d.getContext());
    }

    /* renamed from: e */
    public CharSequence mo2160e() {
        return this.f651d.mo2798b();
    }

    /* renamed from: g */
    public CharSequence mo2161g() {
        return this.f651d.mo2800c();
    }

    /* renamed from: i */
    public void mo2162i() {
        this.f652e.mo2093b(this, this.f655h);
    }

    /* renamed from: j */
    public boolean mo2163j() {
        return this.f651d.mo2801d();
    }

    /* renamed from: a */
    public void mo2151a(int i) {
        mo2153a((CharSequence) this.f650c.getString(i));
    }

    /* renamed from: b */
    public void mo2156b(int i) {
        mo2157b((CharSequence) this.f650c.getString(i));
    }

    /* renamed from: a */
    public void mo2154a(boolean z) {
        super.mo2154a(z);
        this.f651d.mo2797a(z);
    }

    /* renamed from: b */
    public View mo2155b() {
        WeakReference<View> weakReference = this.f653f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public void mo2152a(View view) {
        this.f651d.mo2794a(view);
        this.f653f = view != null ? new WeakReference<>(view) : null;
    }

    /* renamed from: a */
    public void mo2150a() {
        if (!this.f654g) {
            this.f654g = true;
            this.f651d.sendAccessibilityEvent(32);
            this.f652e.mo2090a(this);
        }
    }

    /* renamed from: a */
    public boolean mo2055a(C0482g gVar, MenuItem menuItem) {
        return this.f652e.mo2092a((C0455b) this, menuItem);
    }

    /* renamed from: a */
    public void mo2052a(C0482g gVar) {
        mo2162i();
        this.f651d.mo2803f();
    }
}
