package com.onesignal;

import android.content.Context;
import com.onesignal.C4519h2;
import com.onesignal.C4564n1;
import java.io.IOException;

/* renamed from: com.onesignal.j2 */
/* compiled from: PushRegistratorAbstractGoogle */
abstract class C4532j2 implements C4519h2 {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f12384d = 5;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f12385e = 10000;

    /* renamed from: a */
    private C4519h2.C4520a f12386a;

    /* renamed from: b */
    private Thread f12387b;

    /* renamed from: c */
    private boolean f12388c;

    /* renamed from: com.onesignal.j2$a */
    /* compiled from: PushRegistratorAbstractGoogle */
    class C4533a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f12389a;

        C4533a(String str) {
            this.f12389a = str;
        }

        public void run() {
            int i = 0;
            while (i < C4532j2.f12384d && !C4532j2.this.m15589a(this.f12389a, i)) {
                i++;
                C4536k1.m15631b(C4532j2.f12385e * i);
            }
        }
    }

    C4532j2() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo29805a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo29806a(String str) throws Throwable;

    /* renamed from: b */
    private void m15592b(String str) {
        try {
            if (C4650t.m16153b()) {
                m15594c(str);
                return;
            }
            C4650t.m16150a();
            C4564n1.m15789a(C4564n1.C4566a0.ERROR, "'Google Play services' app not installed or disabled on the device.");
            this.f12386a.mo29784a((String) null, -7);
        } catch (Throwable th) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
            C4564n1.m15790a(a0Var, "Could not register with " + mo29805a() + " due to an issue with your AndroidManifest.xml or with 'Google Play services'.", th);
            this.f12386a.mo29784a((String) null, -8);
        }
    }

    /* renamed from: c */
    private synchronized void m15594c(String str) {
        if (this.f12387b == null || !this.f12387b.isAlive()) {
            Thread thread = new Thread(new C4533a(str));
            this.f12387b = thread;
            thread.start();
        }
    }

    /* renamed from: a */
    public void mo29783a(Context context, String str, C4519h2.C4520a aVar) {
        this.f12386a = aVar;
        if (m15590a(str, aVar)) {
            m15592b(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15589a(String str, int i) {
        try {
            String a = mo29806a(str);
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
            C4564n1.m15789a(a0Var, "Device registered, push token = " + a);
            this.f12386a.mo29784a(a, 1);
            return true;
        } catch (IOException e) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.ERROR;
                C4564n1.m15790a(a0Var2, "Error Getting " + mo29805a() + " Token", (Throwable) e);
                if (!this.f12388c) {
                    this.f12386a.mo29784a((String) null, -11);
                }
                return true;
            } else if (i >= f12384d - 1) {
                C4564n1.C4566a0 a0Var3 = C4564n1.C4566a0.ERROR;
                C4564n1.m15790a(a0Var3, "Retry count of " + f12384d + " exceed! Could not get a " + mo29805a() + " Token.", (Throwable) e);
                return false;
            } else {
                C4564n1.C4566a0 a0Var4 = C4564n1.C4566a0.INFO;
                C4564n1.m15790a(a0Var4, "'Google Play services' returned SERVICE_NOT_AVAILABLE error. Current retry count: " + i, (Throwable) e);
                if (i != 2) {
                    return false;
                }
                this.f12386a.mo29784a((String) null, -9);
                this.f12388c = true;
                return true;
            }
        } catch (Throwable th) {
            C4564n1.C4566a0 a0Var5 = C4564n1.C4566a0.ERROR;
            C4564n1.m15790a(a0Var5, "Unknown error getting " + mo29805a() + " Token", th);
            this.f12386a.mo29784a((String) null, -12);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m15590a(String str, C4519h2.C4520a aVar) {
        boolean z;
        try {
            Float.parseFloat(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            return true;
        }
        C4564n1.m15789a(C4564n1.C4566a0.ERROR, "Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.");
        aVar.mo29784a((String) null, -6);
        return false;
    }
}
