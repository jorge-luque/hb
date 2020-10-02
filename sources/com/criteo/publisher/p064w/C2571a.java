package com.criteo.publisher.p064w;

import android.util.Log;
import com.criteo.publisher.p054a0.C2330h;

/* renamed from: com.criteo.publisher.w.a */
public class C2571a {

    /* renamed from: c */
    private static final Object[] f8119c = new Object[0];

    /* renamed from: a */
    private final String f8120a;

    /* renamed from: b */
    private final C2330h f8121b;

    public C2571a(Class<?> cls, C2330h hVar) {
        this.f8120a = cls.getSimpleName();
        this.f8121b = hVar;
    }

    /* renamed from: a */
    public void mo10610a(String str, Throwable th) {
        m9643a(3, str, f8119c, th);
    }

    /* renamed from: b */
    public void mo10613b(String str, Throwable th) {
        m9643a(6, str, f8119c, th);
    }

    /* renamed from: a */
    public void mo10611a(String str, Object... objArr) {
        m9643a(3, str, objArr, (Throwable) null);
    }

    /* renamed from: a */
    public void mo10612a(Throwable th) {
        m9643a(6, (String) null, f8119c, th);
    }

    /* renamed from: a */
    private void m9643a(int i, String str, Object[] objArr, Throwable th) {
        if (m9644a(i)) {
            if (str != null) {
                mo10609a(i, String.format(str, objArr));
            }
            if (th != null) {
                mo10609a(i, Log.getStackTraceString(th));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10609a(int i, String str) {
        Log.println(i, this.f8120a, str);
    }

    /* renamed from: a */
    private boolean m9644a(int i) {
        return i >= this.f8121b.mo10137j();
    }
}
