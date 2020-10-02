package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.C0965e;

/* renamed from: androidx.lifecycle.p */
/* compiled from: ReportFragment */
public class C0980p extends Fragment {

    /* renamed from: a */
    private C0981a f2534a;

    /* renamed from: androidx.lifecycle.p$a */
    /* compiled from: ReportFragment */
    interface C0981a {
        /* renamed from: a */
        void mo5011a();

        void onResume();

        void onStart();
    }

    /* renamed from: a */
    public static void m3489a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new C0980p(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: b */
    private void m3492b(C0981a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    /* renamed from: c */
    private void m3493c(C0981a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m3491a(this.f2534a);
        m3490a(C0965e.C0966a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        m3490a(C0965e.C0966a.ON_DESTROY);
        this.f2534a = null;
    }

    public void onPause() {
        super.onPause();
        m3490a(C0965e.C0966a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        m3492b(this.f2534a);
        m3490a(C0965e.C0966a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        m3493c(this.f2534a);
        m3490a(C0965e.C0966a.ON_START);
    }

    public void onStop() {
        super.onStop();
        m3490a(C0965e.C0966a.ON_STOP);
    }

    /* renamed from: a */
    private void m3491a(C0981a aVar) {
        if (aVar != null) {
            aVar.mo5011a();
        }
    }

    /* renamed from: a */
    private void m3490a(C0965e.C0966a aVar) {
        Activity activity = getActivity();
        if (activity instanceof C0974j) {
            ((C0974j) activity).getLifecycle().mo4999a(aVar);
        } else if (activity instanceof C0970h) {
            C0965e lifecycle = ((C0970h) activity).getLifecycle();
            if (lifecycle instanceof C0971i) {
                ((C0971i) lifecycle).mo4999a(aVar);
            }
        }
    }
}
