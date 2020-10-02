package com.ogury.p159cm;

import android.content.Context;

/* renamed from: com.ogury.cm.acbca */
public final class acbca {

    /* renamed from: a */
    private boolean f12138a;

    /* renamed from: com.ogury.cm.acbca$aaaaa */
    public static final class aaaaa extends Thread {

        /* renamed from: a */
        final /* synthetic */ accab f12139a;

        aaaaa(accab accab) {
            this.f12139a = accab;
        }

        public final void run() {
            this.f12139a.mo29404a();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ Thread m15204a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, accab accab, int i2, Object obj) {
        accbb.m15218b(accab, "block");
        aaaaa aaaaa2 = new aaaaa(accab);
        aaaaa2.start();
        return aaaaa2;
    }

    /* renamed from: a */
    public final void mo29535a(Context context) {
        accbb.m15218b(context, "context");
        boolean z = false;
        if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0) {
            z = true;
        }
        this.f12138a = z;
    }
}
