package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.p011d.C0455b;
import androidx.core.p020f.C0822d;

/* renamed from: androidx.appcompat.app.g */
/* compiled from: AppCompatDialog */
public class C0427g extends Dialog implements C0405d {

    /* renamed from: a */
    private C0406e f510a;

    /* renamed from: b */
    private final C0822d.C0823a f511b = new C0428a();

    /* renamed from: androidx.appcompat.app.g$a */
    /* compiled from: AppCompatDialog */
    class C0428a implements C0822d.C0823a {
        C0428a() {
        }

        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return C0427g.this.mo2120a(keyEvent);
        }
    }

    public C0427g(Context context, int i) {
        super(context, m565a(context, i));
        C0406e a = mo2118a();
        a.mo2039d(m565a(context, i));
        a.mo2027a((Bundle) null);
    }

    /* renamed from: a */
    public C0455b mo1985a(C0455b.C0456a aVar) {
        return null;
    }

    /* renamed from: a */
    public void mo1988a(C0455b bVar) {
    }

    /* renamed from: a */
    public boolean mo2119a(int i) {
        return mo2118a().mo2034b(i);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo2118a().mo2029a(view, layoutParams);
    }

    /* renamed from: b */
    public void mo1993b(C0455b bVar) {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0822d.m2631a(this.f511b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return mo2118a().mo2024a(i);
    }

    public void invalidateOptionsMenu() {
        mo2118a().mo2040e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        mo2118a().mo2038d();
        super.onCreate(bundle);
        mo2118a().mo2027a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo2118a().mo2044i();
    }

    public void setContentView(int i) {
        mo2118a().mo2036c(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        mo2118a().mo2030a(charSequence);
    }

    /* renamed from: a */
    public C0406e mo2118a() {
        if (this.f510a == null) {
            this.f510a = C0406e.m423a((Dialog) this, (C0405d) this);
        }
        return this.f510a;
    }

    public void setContentView(View view) {
        mo2118a().mo2028a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo2118a().mo2033b(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        mo2118a().mo2030a((CharSequence) getContext().getString(i));
    }

    /* renamed from: a */
    private static int m565a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2120a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
