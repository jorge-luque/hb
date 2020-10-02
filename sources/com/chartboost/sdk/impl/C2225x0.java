package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.chartboost.sdk.C2099a;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.google.android.gms.drive.DriveFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.impl.x0 */
public class C2225x0 {

    /* renamed from: a */
    private final Executor f7491a;

    /* renamed from: b */
    private final C2218v0 f7492b;

    /* renamed from: c */
    final C2222w0 f7493c;

    /* renamed from: d */
    final Handler f7494d;

    /* renamed from: com.chartboost.sdk.impl.x0$a */
    class C2226a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f7495a;

        /* renamed from: b */
        final /* synthetic */ C2088c f7496b;

        /* renamed from: c */
        final /* synthetic */ C2128c1 f7497c;

        /* renamed from: com.chartboost.sdk.impl.x0$a$a */
        class C2227a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f7499a;

            C2227a(String str) {
                this.f7499a = str;
            }

            public void run() {
                try {
                    C2225x0.this.mo9557c(C2226a.this.f7496b, this.f7499a, C2226a.this.f7497c);
                } catch (Exception e) {
                    C2098a.m8288a(C2225x0.class, "open openOnUiThread Runnable.run", e);
                }
            }
        }

        C2226a(String str, C2088c cVar, C2128c1 c1Var) {
            this.f7495a = str;
            this.f7496b = cVar;
            this.f7497c = c1Var;
        }

        /* renamed from: a */
        private void m8819a(String str) {
            C2225x0.this.f7494d.post(new C2227a(str));
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[SYNTHETIC, Splitter:B:22:0x0046] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[Catch:{ Exception -> 0x0056 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = r6.f7495a     // Catch:{ Exception -> 0x0056 }
                com.chartboost.sdk.impl.x0 r1 = com.chartboost.sdk.impl.C2225x0.this     // Catch:{ Exception -> 0x0056 }
                com.chartboost.sdk.impl.w0 r1 = r1.f7493c     // Catch:{ Exception -> 0x0056 }
                boolean r1 = r1.mo9539c()     // Catch:{ Exception -> 0x0056 }
                if (r1 == 0) goto L_0x0052
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
                java.lang.String r3 = r6.f7495a     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
                r1 = 0
                r2.setInstanceFollowRedirects(r1)     // Catch:{ Exception -> 0x0035 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0035 }
                r2.setReadTimeout(r1)     // Catch:{ Exception -> 0x0035 }
                java.lang.String r1 = "Location"
                java.lang.String r1 = r2.getHeaderField(r1)     // Catch:{ Exception -> 0x0035 }
                if (r1 == 0) goto L_0x002f
                r0 = r1
            L_0x002f:
                if (r2 == 0) goto L_0x0052
                r2.disconnect()     // Catch:{ Exception -> 0x0056 }
                goto L_0x0052
            L_0x0035:
                r1 = move-exception
                goto L_0x003d
            L_0x0037:
                r0 = move-exception
                goto L_0x004c
            L_0x0039:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
            L_0x003d:
                java.lang.String r3 = "CBURLOpener"
                java.lang.String r4 = "Exception raised while opening a HTTP Conection"
                com.chartboost.sdk.Libraries.CBLogging.m8153a(r3, r4, r1)     // Catch:{ all -> 0x004a }
                if (r2 == 0) goto L_0x0052
                r2.disconnect()     // Catch:{ Exception -> 0x0056 }
                goto L_0x0052
            L_0x004a:
                r0 = move-exception
                r1 = r2
            L_0x004c:
                if (r1 == 0) goto L_0x0051
                r1.disconnect()     // Catch:{ Exception -> 0x0056 }
            L_0x0051:
                throw r0     // Catch:{ Exception -> 0x0056 }
            L_0x0052:
                r6.m8819a(r0)     // Catch:{ Exception -> 0x0056 }
                goto L_0x005e
            L_0x0056:
                r0 = move-exception
                java.lang.Class<com.chartboost.sdk.impl.x0> r1 = com.chartboost.sdk.impl.C2225x0.class
                java.lang.String r2 = "open followTask"
                com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r1, (java.lang.String) r2, (java.lang.Exception) r0)
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2225x0.C2226a.run():void");
        }
    }

    public C2225x0(Executor executor, C2218v0 v0Var, C2222w0 w0Var, Handler handler) {
        this.f7491a = executor;
        this.f7492b = v0Var;
        this.f7493c = w0Var;
        this.f7494d = handler;
    }

    /* renamed from: a */
    public void mo9554a(C2088c cVar, boolean z, String str, CBError.CBClickError cBClickError, C2128c1 c1Var) {
        C2128c1 c1Var2;
        if (cVar != null) {
            cVar.f6918B = false;
            if (cVar.mo9144u()) {
                cVar.f6922b = 4;
            }
        }
        if (!z) {
            C2099a aVar = C2242k.f7604d;
            if (aVar != null) {
                aVar.didFailToRecordClick(str, cBClickError);
            }
        } else if (cVar != null && (c1Var2 = cVar.f6944x) != null) {
            this.f7492b.mo9524a(c1Var2);
        } else if (c1Var != null) {
            this.f7492b.mo9524a(c1Var);
        }
    }

    /* renamed from: b */
    public void mo9556b(C2088c cVar, String str, C2128c1 c1Var) {
        try {
            String scheme = new URI(str).getScheme();
            if (scheme == null) {
                mo9554a(cVar, false, str, CBError.CBClickError.URI_INVALID, c1Var);
            } else if (scheme.equals("http") || scheme.equals("https")) {
                this.f7491a.execute(new C2226a(str, cVar, c1Var));
            } else {
                mo9557c(cVar, str, c1Var);
            }
        } catch (URISyntaxException unused) {
            mo9554a(cVar, false, str, CBError.CBClickError.URI_INVALID, c1Var);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9557c(C2088c cVar, String str, C2128c1 c1Var) {
        if (cVar != null && cVar.mo9144u()) {
            cVar.f6922b = 5;
        }
        Context context = C2242k.f7612l;
        if (context == null) {
            mo9554a(cVar, false, str, CBError.CBClickError.NO_HOST_ACTIVITY, c1Var);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (Exception unused) {
            if (str.startsWith("market://")) {
                try {
                    str = "http://market.android.com/" + str.substring(9);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(DriveFile.MODE_READ_ONLY);
                    }
                    intent2.setData(Uri.parse(str));
                    context.startActivity(intent2);
                } catch (Exception e) {
                    CBLogging.m8153a("CBURLOpener", "Exception raised openeing an inavld playstore URL", e);
                    mo9554a(cVar, false, str, CBError.CBClickError.URI_UNRECOGNIZED, c1Var);
                    return;
                }
            } else {
                mo9554a(cVar, false, str, CBError.CBClickError.URI_UNRECOGNIZED, c1Var);
            }
        }
        mo9554a(cVar, true, str, (CBError.CBClickError) null, c1Var);
    }

    /* renamed from: a */
    public boolean mo9555a(String str) {
        try {
            Context context = C2242k.f7612l;
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            intent.setData(Uri.parse(str));
            if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            CBLogging.m8153a("CBURLOpener", "Cannot open URL", e);
            C2098a.m8288a(C2225x0.class, "canOpenURL", e);
            return false;
        }
    }

    /* renamed from: a */
    public void mo9553a(C2088c cVar, String str, C2128c1 c1Var) {
        mo9556b(cVar, str, c1Var);
    }
}
