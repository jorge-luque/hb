package p118io.fabric.sdk.android;

import android.util.Log;

/* renamed from: io.fabric.sdk.android.b */
/* compiled from: DefaultLogger */
public class C6058b implements C6072k {

    /* renamed from: a */
    private int f15958a;

    public C6058b(int i) {
        this.f15958a = i;
    }

    /* renamed from: a */
    public boolean mo34088a(String str, int i) {
        return this.f15958a <= i || Log.isLoggable(str, i);
    }

    /* renamed from: b */
    public void mo34090b(String str, String str2, Throwable th) {
        if (mo34088a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: c */
    public void mo34092c(String str, String str2, Throwable th) {
        boolean a = mo34088a(str, 3);
    }

    /* renamed from: d */
    public void mo34094d(String str, String str2, Throwable th) {
        boolean a = mo34088a(str, 4);
    }

    /* renamed from: e */
    public void mo34096e(String str, String str2, Throwable th) {
        boolean a = mo34088a(str, 2);
    }

    /* renamed from: a */
    public void mo34087a(String str, String str2, Throwable th) {
        if (mo34088a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: c */
    public void mo34091c(String str, String str2) {
        mo34096e(str, str2, (Throwable) null);
    }

    /* renamed from: d */
    public void mo34093d(String str, String str2) {
        mo34092c(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo34095e(String str, String str2) {
        mo34094d(str, str2, (Throwable) null);
    }

    public C6058b() {
        this.f15958a = 4;
    }

    /* renamed from: b */
    public void mo34089b(String str, String str2) {
        mo34090b(str, str2, (Throwable) null);
    }

    /* renamed from: a */
    public void mo34086a(String str, String str2) {
        mo34087a(str, str2, (Throwable) null);
    }

    /* renamed from: a */
    public void mo34084a(int i, String str, String str2) {
        mo34085a(i, str, str2, false);
    }

    /* renamed from: a */
    public void mo34085a(int i, String str, String str2, boolean z) {
        if (z || mo34088a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
