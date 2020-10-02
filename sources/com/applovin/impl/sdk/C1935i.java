package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import com.applovin.impl.sdk.C1929h;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.i */
public class C1935i implements C1929h.C1934a, AppLovinWebViewActivity.EventListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final AtomicBoolean f6382a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static WeakReference<AppLovinWebViewActivity> f6383b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1941j f6384c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1977q f6385d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AppLovinUserService.OnConsentDialogDismissListener f6386e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1929h f6387f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WeakReference<Activity> f6388g = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1984a f6389h;

    C1935i(C1941j jVar) {
        this.f6384c = jVar;
        this.f6385d = jVar.mo8602v();
        if (jVar.mo8528G() != null) {
            this.f6388g = new WeakReference<>(jVar.mo8528G());
        }
        jVar.mo8565aa().mo8071a(new C1984a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = C1935i.this.f6388g = new WeakReference(activity);
            }
        });
        this.f6387f = new C1929h(this, jVar);
    }

    /* renamed from: a */
    private void m7429a(boolean z, long j) {
        m7437f();
        if (z) {
            mo8516a(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7431a(C1941j jVar) {
        if (mo8518c()) {
            C1977q.m7751i("AppLovinSdk", "Consent dialog already showing");
            return false;
        } else if (!C1992h.m7853a(jVar.mo8527E())) {
            C1977q.m7751i("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        } else if (!((Boolean) jVar.mo8549a(C1841c.f5836aj)).booleanValue()) {
            this.f6385d.mo8746e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            return false;
        } else if (C2025o.m7963b((String) jVar.mo8549a(C1841c.f5837ak))) {
            return true;
        } else {
            this.f6385d.mo8746e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            return false;
        }
    }

    /* renamed from: f */
    private void m7437f() {
        this.f6384c.mo8565aa().mo8073b(this.f6389h);
        if (mo8518c()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) f6383b.get();
            f6383b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f6386e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f6386e = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8514a() {
        if (this.f6388g.get() != null) {
            final Activity activity = (Activity) this.f6388g.get();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1935i.this.mo8517a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f6384c.mo8549a(C1841c.f5839am)).longValue());
        }
    }

    /* renamed from: a */
    public void mo8516a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1935i.this.f6385d.mo8742b("ConsentDialogManager", "Scheduling repeating consent alert");
                C1935i.this.f6387f.mo8509a(j, C1935i.this.f6384c, C1935i.this);
            }
        });
    }

    /* renamed from: a */
    public void mo8517a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                C1935i iVar = C1935i.this;
                if (!iVar.m7431a(iVar.f6384c) || C1935i.f6382a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                        return;
                    }
                    return;
                }
                WeakReference unused = C1935i.this.f6388g = new WeakReference(activity);
                AppLovinUserService.OnConsentDialogDismissListener unused2 = C1935i.this.f6386e = onConsentDialogDismissListener;
                C1984a unused3 = C1935i.this.f6389h = new C1984a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!C1935i.this.mo8518c() || C1935i.f6383b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                WeakReference unused = C1935i.f6383b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) C1935i.this.f6384c.mo8549a(C1841c.f5837ak), C1935i.this);
                            }
                            C1935i.f6382a.set(false);
                        }
                    }
                };
                C1935i.this.f6384c.mo8565aa().mo8071a(C1935i.this.f6389h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, C1935i.this.f6384c.mo8599t());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) C1935i.this.f6384c.mo8549a(C1841c.f5838al));
                activity.startActivity(intent);
            }
        });
    }

    /* renamed from: b */
    public void mo8515b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo8518c() {
        WeakReference<AppLovinWebViewActivity> weakReference = f6383b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        C1941j jVar;
        C1841c cVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f6384c.mo8527E());
            m7437f();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f6384c.mo8527E());
            booleanValue = ((Boolean) this.f6384c.mo8549a(C1841c.f5840an)).booleanValue();
            jVar = this.f6384c;
            cVar = C1841c.f5845as;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f6384c.mo8549a(C1841c.f5841ao)).booleanValue();
            jVar = this.f6384c;
            cVar = C1841c.f5846at;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f6384c.mo8549a(C1841c.f5842ap)).booleanValue();
            jVar = this.f6384c;
            cVar = C1841c.f5847au;
        } else {
            return;
        }
        m7429a(booleanValue, ((Long) jVar.mo8549a(cVar)).longValue());
    }
}
