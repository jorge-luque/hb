package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2026p;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.h */
class C1929h implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static AlertDialog f6372b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final AtomicBoolean f6373c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1935i f6374a;

    /* renamed from: d */
    private C2026p f6375d;

    /* renamed from: com.applovin.impl.sdk.h$a */
    public interface C1934a {
        /* renamed from: a */
        void mo8514a();

        /* renamed from: b */
        void mo8515b();
    }

    C1929h(C1935i iVar, C1941j jVar) {
        this.f6374a = iVar;
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo8509a(long j, final C1941j jVar, final C1934a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = f6372b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (f6373c.getAndSet(true)) {
                    if (j < this.f6375d.mo8811a()) {
                        C1977q v = jVar.mo8602v();
                        v.mo8742b("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.f6375d.mo8811a() + "ms)");
                        this.f6375d.mo8814d();
                    } else {
                        C1977q v2 = jVar.mo8602v();
                        v2.mo8745d("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.f6375d.mo8811a() + " milliseconds");
                        return;
                    }
                }
                C1977q v3 = jVar.mo8602v();
                v3.mo8742b("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
                this.f6375d = C2026p.m7968a(j, jVar, new Runnable() {
                    public void run() {
                        String str;
                        C1977q qVar;
                        if (C1929h.this.f6374a.mo8518c()) {
                            jVar.mo8602v().mo8746e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                            return;
                        }
                        Activity a = jVar.mo8565aa().mo8070a();
                        if (a == null || !C1992h.m7853a(jVar.mo8527E())) {
                            if (a == null) {
                                qVar = jVar.mo8602v();
                                str = "No parent Activity found - rescheduling consent alert...";
                            } else {
                                qVar = jVar.mo8602v();
                                str = "No internet available - rescheduling consent alert...";
                            }
                            qVar.mo8746e("ConsentAlertManager", str);
                            C1929h.f6373c.set(false);
                            C1929h.this.mo8509a(((Long) jVar.mo8549a(C1841c.f5849aw)).longValue(), jVar, aVar);
                            return;
                        }
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                AlertDialog unused = C1929h.f6372b = new AlertDialog.Builder(jVar.mo8565aa().mo8070a()).setTitle((CharSequence) jVar.mo8549a(C1841c.f5850ax)).setMessage((CharSequence) jVar.mo8549a(C1841c.f5851ay)).setCancelable(false).setPositiveButton((CharSequence) jVar.mo8549a(C1841c.f5852az), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo8514a();
                                        dialogInterface.dismiss();
                                        C1929h.f6373c.set(false);
                                    }
                                }).setNegativeButton((CharSequence) jVar.mo8549a(C1841c.f5801aA), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aVar.mo8515b();
                                        dialogInterface.dismiss();
                                        C1929h.f6373c.set(false);
                                        long longValue = ((Long) jVar.mo8549a(C1841c.f5848av)).longValue();
                                        C19301 r0 = C19301.this;
                                        C1929h.this.mo8509a(longValue, jVar, aVar);
                                    }
                                }).create();
                                C1929h.f6372b.show();
                            }
                        });
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (this.f6375d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.f6375d.mo8812b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.f6375d.mo8813c();
            }
        }
    }
}
