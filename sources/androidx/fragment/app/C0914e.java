package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p019e.C0795h;
import androidx.lifecycle.C0987t;

/* renamed from: androidx.fragment.app.e */
/* compiled from: FragmentController */
public class C0914e {

    /* renamed from: a */
    private final C0916g<?> f2319a;

    private C0914e(C0916g<?> gVar) {
        this.f2319a = gVar;
    }

    /* renamed from: a */
    public static C0914e m3130a(C0916g<?> gVar) {
        C0795h.m2504a(gVar, "callbacks == null");
        return new C0914e(gVar);
    }

    /* renamed from: b */
    public void mo4759b() {
        this.f2319a.f2325e.mo4853g();
    }

    /* renamed from: c */
    public void mo4763c() {
        this.f2319a.f2325e.mo4855h();
    }

    /* renamed from: d */
    public void mo4764d() {
        this.f2319a.f2325e.mo4860j();
    }

    /* renamed from: e */
    public void mo4765e() {
        this.f2319a.f2325e.mo4862k();
    }

    /* renamed from: f */
    public void mo4766f() {
        this.f2319a.f2325e.mo4866m();
    }

    /* renamed from: g */
    public void mo4767g() {
        this.f2319a.f2325e.mo4868n();
    }

    /* renamed from: h */
    public void mo4768h() {
        this.f2319a.f2325e.mo4870o();
    }

    /* renamed from: i */
    public boolean mo4769i() {
        return this.f2319a.f2325e.mo4877q();
    }

    /* renamed from: j */
    public C0917h mo4770j() {
        return this.f2319a.f2325e;
    }

    /* renamed from: k */
    public void mo4771k() {
        this.f2319a.f2325e.mo4888x();
    }

    /* renamed from: l */
    public Parcelable mo4772l() {
        return this.f2319a.f2325e.mo4890z();
    }

    /* renamed from: a */
    public Fragment mo4750a(String str) {
        return this.f2319a.f2325e.mo4829b(str);
    }

    /* renamed from: b */
    public void mo4760b(boolean z) {
        this.f2319a.f2325e.mo4836b(z);
    }

    /* renamed from: a */
    public void mo4755a(Fragment fragment) {
        C0916g<?> gVar = this.f2319a;
        gVar.f2325e.mo4822a((C0916g) gVar, (C0913d) gVar, fragment);
    }

    /* renamed from: b */
    public boolean mo4761b(Menu menu) {
        return this.f2319a.f2325e.mo4837b(menu);
    }

    /* renamed from: a */
    public View mo4749a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2319a.f2325e.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: b */
    public boolean mo4762b(MenuItem menuItem) {
        return this.f2319a.f2325e.mo4838b(menuItem);
    }

    /* renamed from: a */
    public void mo4753a(Parcelable parcelable) {
        C0916g<?> gVar = this.f2319a;
        if (gVar instanceof C0987t) {
            gVar.f2325e.mo4811a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    /* renamed from: a */
    public void mo4751a() {
        this.f2319a.f2325e.mo4850f();
    }

    /* renamed from: a */
    public void mo4756a(boolean z) {
        this.f2319a.f2325e.mo4824a(z);
    }

    /* renamed from: a */
    public void mo4752a(Configuration configuration) {
        this.f2319a.f2325e.mo4809a(configuration);
    }

    /* renamed from: a */
    public boolean mo4757a(Menu menu, MenuInflater menuInflater) {
        return this.f2319a.f2325e.mo4825a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean mo4758a(MenuItem menuItem) {
        return this.f2319a.f2325e.mo4826a(menuItem);
    }

    /* renamed from: a */
    public void mo4754a(Menu menu) {
        this.f2319a.f2325e.mo4812a(menu);
    }
}
