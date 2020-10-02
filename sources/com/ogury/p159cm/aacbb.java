package com.ogury.p159cm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import java.io.IOException;

/* renamed from: com.ogury.cm.aacbb */
public final class aacbb {

    /* renamed from: a */
    public static final aacbb f12034a = new aacbb();

    private aacbb() {
    }

    /* renamed from: a */
    public static acabb m15023a(Context context) throws Exception {
        accbb.m15218b(context, "context");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        accbb.m15215a((Object) mainLooper, "Looper.getMainLooper()");
        if (!accbb.m15217a((Object) currentThread, (Object) mainLooper.getThread())) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                return m15024b(context);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    /* renamed from: b */
    private static acabb m15024b(Context context) throws Exception {
        acabc acabc = new acabc();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, acabc, 1)) {
            try {
                acaca acaca = new acaca(acabc.mo29518a());
                acabb acabb = new acabb(acaca.mo29521a(), acaca.mo29522a(true));
                context.unbindService(acabc);
                return acabb;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                context.unbindService(acabc);
                throw th;
            }
        } else {
            throw new IOException("Google Play connection failed");
        }
    }
}
