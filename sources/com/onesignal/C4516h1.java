package com.onesignal;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.C0404c;
import androidx.fragment.app.C0909b;
import androidx.fragment.app.C0917h;
import androidx.fragment.app.Fragment;
import com.onesignal.C4564n1;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.onesignal.h1 */
/* compiled from: OSSystemConditionController */
class C4516h1 {

    /* renamed from: b */
    private static final String f12347b = "com.onesignal.h1";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C4518b f12348a;

    /* renamed from: com.onesignal.h1$a */
    /* compiled from: OSSystemConditionController */
    class C4517a extends C0917h.C0918a {

        /* renamed from: a */
        final /* synthetic */ C0917h f12349a;

        C4517a(C0917h hVar) {
            this.f12349a = hVar;
        }

        public void onFragmentDetached(C0917h hVar, Fragment fragment) {
            super.onFragmentDetached(hVar, fragment);
            if (fragment instanceof C0909b) {
                this.f12349a.mo4781a((C0917h.C0918a) this);
                C4516h1.this.f12348a.mo29782b();
            }
        }
    }

    /* renamed from: com.onesignal.h1$b */
    /* compiled from: OSSystemConditionController */
    interface C4518b {
        /* renamed from: b */
        void mo29782b();
    }

    C4516h1(C4518b bVar) {
        this.f12348a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29780a() {
        Activity activity = C4461a.f12260f;
        if (activity == null) {
            C4564n1.m15815b(C4564n1.C4566a0.WARN, "OSSystemConditionObserver curActivity null");
            return false;
        }
        try {
            if (mo29781a((Context) activity)) {
                C4564n1.m15815b(C4564n1.C4566a0.WARN, "OSSystemConditionObserver dialog fragment detected");
                return false;
            }
        } catch (NoClassDefFoundError e) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
            C4564n1.m15815b(a0Var, "AppCompatActivity is not used in this app, skipping 'isDialogFragmentShowing' check: " + e);
        }
        boolean a = C4543l1.m15665a((WeakReference<Activity>) new WeakReference(C4461a.f12260f));
        if (a) {
            C4461a.m15377a(f12347b, this.f12348a);
            C4564n1.m15815b(C4564n1.C4566a0.WARN, "OSSystemConditionObserver keyboard up detected");
        }
        return !a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29781a(Context context) throws NoClassDefFoundError {
        if (!(context instanceof C0404c)) {
            return false;
        }
        C0917h supportFragmentManager = ((C0404c) context).getSupportFragmentManager();
        supportFragmentManager.mo4782a((C0917h.C0918a) new C4517a(supportFragmentManager), true);
        List<Fragment> c = supportFragmentManager.mo4785c();
        int size = c.size();
        if (size <= 0) {
            return false;
        }
        Fragment fragment = c.get(size - 1);
        if (!fragment.isVisible() || !(fragment instanceof C0909b)) {
            return false;
        }
        return true;
    }
}
