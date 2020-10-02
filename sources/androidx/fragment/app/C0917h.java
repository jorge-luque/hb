package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: androidx.fragment.app.h */
/* compiled from: FragmentManager */
public abstract class C0917h {

    /* renamed from: b */
    static final C0915f f2326b = new C0915f();

    /* renamed from: a */
    private C0915f f2327a = null;

    /* renamed from: androidx.fragment.app.h$a */
    /* compiled from: FragmentManager */
    public static abstract class C0918a {
        public void onFragmentActivityCreated(C0917h hVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(C0917h hVar, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(C0917h hVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentDetached(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentPaused(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentPreAttached(C0917h hVar, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(C0917h hVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(C0917h hVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentStopped(C0917h hVar, Fragment fragment) {
        }

        public void onFragmentViewCreated(C0917h hVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(C0917h hVar, Fragment fragment) {
        }
    }

    /* renamed from: androidx.fragment.app.h$b */
    /* compiled from: FragmentManager */
    public interface C0919b {
        /* renamed from: a */
        void mo4801a();
    }

    /* renamed from: a */
    public abstract Fragment mo4777a(String str);

    /* renamed from: a */
    public abstract C0937k mo4778a();

    /* renamed from: a */
    public abstract void mo4779a(int i, int i2);

    /* renamed from: a */
    public void mo4780a(C0915f fVar) {
        this.f2327a = fVar;
    }

    /* renamed from: a */
    public abstract void mo4781a(C0918a aVar);

    /* renamed from: a */
    public abstract void mo4782a(C0918a aVar, boolean z);

    /* renamed from: a */
    public abstract void mo4783a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public C0915f mo4784b() {
        if (this.f2327a == null) {
            this.f2327a = f2326b;
        }
        return this.f2327a;
    }

    /* renamed from: c */
    public abstract List<Fragment> mo4785c();

    /* renamed from: d */
    public abstract boolean mo4786d();
}
