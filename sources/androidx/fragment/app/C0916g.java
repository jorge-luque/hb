package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.C0696a;
import androidx.core.p019e.C0795h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.g */
/* compiled from: FragmentHostCallback */
public abstract class C0916g<E> extends C0913d {

    /* renamed from: a */
    private final Activity f2321a;

    /* renamed from: b */
    private final Context f2322b;

    /* renamed from: c */
    private final Handler f2323c;

    /* renamed from: d */
    private final int f2324d;

    /* renamed from: e */
    final C0920i f2325e;

    C0916g(C0911c cVar) {
        this(cVar, cVar, new Handler(), 0);
    }

    /* renamed from: a */
    public View mo4650a(int i) {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4736a(Fragment fragment) {
    }

    /* renamed from: a */
    public void mo4737a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f2322b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    /* renamed from: a */
    public void mo4739a(Fragment fragment, String[] strArr, int i) {
    }

    /* renamed from: a */
    public void mo4740a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public boolean mo4651a() {
        return true;
    }

    /* renamed from: a */
    public boolean mo4741a(String str) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Activity mo4774b() {
        return this.f2321a;
    }

    /* renamed from: b */
    public boolean mo4742b(Fragment fragment) {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Context mo4775c() {
        return this.f2322b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Handler mo4776d() {
        return this.f2323c;
    }

    /* renamed from: e */
    public abstract E mo4743e();

    /* renamed from: f */
    public LayoutInflater mo4744f() {
        return LayoutInflater.from(this.f2322b);
    }

    /* renamed from: g */
    public int mo4745g() {
        return this.f2324d;
    }

    /* renamed from: h */
    public boolean mo4746h() {
        return true;
    }

    /* renamed from: i */
    public void mo4747i() {
    }

    C0916g(Activity activity, Context context, Handler handler, int i) {
        this.f2325e = new C0920i();
        this.f2321a = activity;
        C0795h.m2504a(context, "context == null");
        this.f2322b = context;
        C0795h.m2504a(handler, "handler == null");
        this.f2323c = handler;
        this.f2324d = i;
    }

    /* renamed from: a */
    public void mo4738a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            C0696a.m2192a(this.f2321a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }
}
