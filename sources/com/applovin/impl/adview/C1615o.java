package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.o */
public class C1615o implements AppLovinInterstitialAdDialog {

    /* renamed from: b */
    public static volatile boolean f5036b = false;

    /* renamed from: c */
    public static volatile boolean f5037c = false;

    /* renamed from: d */
    private static final Map<String, C1615o> f5038d = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    protected final C1941j f5039a;

    /* renamed from: e */
    private final String f5040e;

    /* renamed from: f */
    private final WeakReference<Context> f5041f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile AppLovinAdLoadListener f5042g;

    /* renamed from: h */
    private volatile AppLovinAdDisplayListener f5043h;

    /* renamed from: i */
    private volatile AppLovinAdVideoPlaybackListener f5044i;

    /* renamed from: j */
    private volatile AppLovinAdClickListener f5045j;

    /* renamed from: k */
    private volatile C1827g f5046k;

    /* renamed from: l */
    private volatile C1827g.C1830b f5047l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile C1569j f5048m;

    C1615o(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f5039a = C2029r.m7993a(appLovinSdk);
            this.f5040e = UUID.randomUUID().toString();
            this.f5041f = new WeakReference<>(context);
            f5036b = true;
            f5037c = false;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static C1615o m6164a(String str) {
        return f5038d.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6166a(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1615o.this.f5042g != null) {
                    C1615o.this.f5042g.failedToReceiveAd(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6167a(Context context) {
        Intent intent = new Intent(context, this.f5046k.mo8277n() ? AppLovinFullscreenActivity.class : AppLovinInterstitialActivity.class);
        intent.putExtra(C1580n.KEY_WRAPPER_ID, this.f5040e);
        C1580n.lastKnownWrapper = this;
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private void m6171a(C1827g gVar, final Context context) {
        if (this.f5039a.mo8565aa().mo8072b() == null) {
            gVar.mo8274b(true);
            this.f5039a.mo8534M().mo8387a(C1859g.f6198m);
        }
        f5038d.put(this.f5040e, this);
        if (((Boolean) this.f5039a.mo8549a(C1841c.f6063fb)).booleanValue()) {
            this.f5039a.mo8533L().mo8479b().execute(new Runnable() {
                public void run() {
                    System.gc();
                }
            });
        }
        this.f5046k = gVar;
        this.f5047l = this.f5046k.mo8278o();
        final long max = Math.max(0, ((Long) this.f5039a.mo8549a(C1841c.f5919cN)).longValue());
        C1977q v = this.f5039a.mo8602v();
        v.mo8742b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        m6172a(gVar, context, new Runnable() {
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        C16183 r0 = C16183.this;
                        C1615o.this.m6167a(context);
                    }
                }, max);
            }
        });
    }

    /* renamed from: a */
    private void m6172a(C1827g gVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(gVar.mo8216P()) || !gVar.mo8263aq() || C1992h.m7853a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(gVar.mo8264ar()).setMessage(gVar.mo8265as()).setPositiveButton(gVar.mo8266at(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* renamed from: a */
    private void m6173a(AppLovinAd appLovinAd) {
        if (this.f5043h != null) {
            this.f5043h.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6175b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1615o.this.f5042g != null) {
                    C1615o.this.f5042g.adReceived(appLovinAd);
                }
            }
        });
    }

    /* renamed from: h */
    private Context m6176h() {
        WeakReference<Context> weakReference = this.f5041f;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public C1941j mo7516a() {
        return this.f5039a;
    }

    /* renamed from: a */
    public void mo7517a(C1569j jVar) {
        this.f5048m = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7518a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5039a.mo8594o().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: b */
    public C1827g mo7519b() {
        return this.f5046k;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener mo7520c() {
        return this.f5044i;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener mo7521d() {
        return this.f5043h;
    }

    public void dismiss() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C1615o.this.f5048m != null) {
                    C1615o.this.f5048m.dismiss();
                }
            }
        });
    }

    /* renamed from: e */
    public AppLovinAdClickListener mo7522e() {
        return this.f5045j;
    }

    /* renamed from: f */
    public C1827g.C1830b mo7523f() {
        return this.f5047l;
    }

    /* renamed from: g */
    public void mo7524g() {
        f5036b = false;
        f5037c = true;
        f5038d.remove(this.f5040e);
        if (this.f5046k != null && this.f5046k.mo8224X()) {
            this.f5048m = null;
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f5039a.mo8594o().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f5045j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f5043h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5042g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f5044i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        mo7518a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                C1615o.this.m6175b(appLovinAd);
                C1615o.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i) {
                C1615o.this.m6166a(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        String str;
        C1977q qVar;
        Context h = m6176h();
        if (h != null) {
            AppLovinAd a = C2029r.m7994a(appLovinAd, this.f5039a);
            if (a == null) {
                qVar = this.f5039a.mo8602v();
                str = "Failed to show ad: " + appLovinAd;
            } else if (((AppLovinAdBase) a).hasShown() && ((Boolean) this.f5039a.mo8549a(C1841c.f5950cs)).booleanValue()) {
                throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
            } else if (a instanceof C1827g) {
                m6171a((C1827g) a, h);
                return;
            } else {
                this.f5039a.mo8602v().mo8746e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + a + "'");
                m6173a(a);
                return;
            }
        } else {
            qVar = this.f5039a.mo8602v();
            str = "Failed to show interstitial: stale activity reference provided";
        }
        qVar.mo8746e("InterstitialAdDialogWrapper", str);
        m6173a(appLovinAd);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
