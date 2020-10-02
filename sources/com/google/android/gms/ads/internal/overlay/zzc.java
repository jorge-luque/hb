package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzafj;
import com.google.android.gms.internal.ads.zzafl;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzapa;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbek;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbfw;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzrv;
import com.google.android.gms.internal.ads.zzst;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzzz;
import com.loopj.android.http.C4250c;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzc extends zzapf implements zzy {
    @VisibleForTesting
    private static final int zzdjp = Color.argb(0, 0, 0, 0);
    protected final Activity zzaad;
    @VisibleForTesting
    private boolean zzblz = false;
    @VisibleForTesting
    zzbek zzdce;
    @VisibleForTesting
    AdOverlayInfoParcel zzdjq;
    @VisibleForTesting
    private zzi zzdjr;
    @VisibleForTesting
    private zzq zzdjs;
    @VisibleForTesting
    private boolean zzdjt = false;
    @VisibleForTesting
    private FrameLayout zzdju;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdjv;
    @VisibleForTesting
    private boolean zzdjw = false;
    @VisibleForTesting
    private zzj zzdjx;
    @VisibleForTesting
    private boolean zzdjy = false;
    @VisibleForTesting
    int zzdjz = 0;
    private final Object zzdka = new Object();
    private Runnable zzdkb;
    private boolean zzdkc;
    private boolean zzdkd;
    private boolean zzdke = false;
    private boolean zzdkf = false;
    private boolean zzdkg = true;

    public zzc(Activity activity) {
        this.zzaad = activity;
    }

    private final void zzai(boolean z) {
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcqp)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdjs = new zzq(this.zzaad, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdjq.zzdkv);
        this.zzdjx.addView(this.zzdjs, layoutParams);
    }

    private final void zzaj(boolean z) throws zzg {
        if (!this.zzdkd) {
            this.zzaad.requestWindowFeature(1);
        }
        Window window = this.zzaad.getWindow();
        if (window != null) {
            zzbek zzbek = this.zzdjq.zzdce;
            zzbfw zzabj = zzbek != null ? zzbek.zzabj() : null;
            boolean z2 = false;
            boolean z3 = zzabj != null && zzabj.zzaap();
            this.zzdjy = false;
            if (z3) {
                int i = this.zzdjq.orientation;
                zzq.zzky();
                if (i == 6) {
                    if (this.zzaad.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdjy = z2;
                } else {
                    int i2 = this.zzdjq.orientation;
                    zzq.zzky();
                    if (i2 == 7) {
                        if (this.zzaad.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdjy = z2;
                    }
                }
            }
            boolean z4 = this.zzdjy;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzazw.zzed(sb.toString());
            setRequestedOrientation(this.zzdjq.orientation);
            zzq.zzky();
            window.setFlags(16777216, 16777216);
            zzazw.zzed("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzblz) {
                this.zzdjx.setBackgroundColor(-16777216);
            } else {
                this.zzdjx.setBackgroundColor(zzdjp);
            }
            this.zzaad.setContentView(this.zzdjx);
            this.zzdkd = true;
            if (z) {
                try {
                    zzq.zzkx();
                    zzbek zza = zzbes.zza(this.zzaad, this.zzdjq.zzdce != null ? this.zzdjq.zzdce.zzabh() : null, this.zzdjq.zzdce != null ? this.zzdjq.zzdce.zzabi() : null, true, z3, (zzdt) null, this.zzdjq.zzbmo, (zzaam) null, (zzi) null, this.zzdjq.zzdce != null ? this.zzdjq.zzdce.zzzi() : null, zzst.zzmz(), (zzrv) null, false);
                    this.zzdce = zza;
                    zzbfw zzabj2 = zza.zzabj();
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzdjq;
                    zzafj zzafj = adOverlayInfoParcel.zzczu;
                    zzafl zzafl = adOverlayInfoParcel.zzczw;
                    zzt zzt = adOverlayInfoParcel.zzdkx;
                    zzbek zzbek2 = adOverlayInfoParcel.zzdce;
                    zzabj2.zza((zzub) null, zzafj, (zzo) null, zzafl, zzt, true, (zzagd) null, zzbek2 != null ? zzbek2.zzabj().zzaao() : null, (zzapa) null, (zzaun) null);
                    this.zzdce.zzabj().zza((zzbfv) new zzf(this));
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdjq;
                    String str = adOverlayInfoParcel2.url;
                    if (str != null) {
                        this.zzdce.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel2.zzdkw;
                        if (str2 != null) {
                            this.zzdce.loadDataWithBaseURL(adOverlayInfoParcel2.zzdku, str2, "text/html", C4250c.DEFAULT_CHARSET, (String) null);
                        } else {
                            throw new zzg("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbek zzbek3 = this.zzdjq.zzdce;
                    if (zzbek3 != null) {
                        zzbek3.zzb(this);
                    }
                } catch (Exception e) {
                    zzazw.zzc("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                zzbek zzbek4 = this.zzdjq.zzdce;
                this.zzdce = zzbek4;
                zzbek4.zzbt(this.zzaad);
            }
            this.zzdce.zza(this);
            zzbek zzbek5 = this.zzdjq.zzdce;
            if (zzbek5 != null) {
                zzc(zzbek5.zzabn(), this.zzdjx);
            }
            ViewParent parent = this.zzdce.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdce.getView());
            }
            if (this.zzblz) {
                this.zzdce.zzabv();
            }
            zzbek zzbek6 = this.zzdce;
            Activity activity = this.zzaad;
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdjq;
            zzbek6.zza((ViewGroup) null, activity, adOverlayInfoParcel3.zzdku, adOverlayInfoParcel3.zzdkw);
            this.zzdjx.addView(this.zzdce.getView(), -1, -1);
            if (!z && !this.zzdjy) {
                zzum();
            }
            zzai(z3);
            if (this.zzdce.zzabl()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzq.zzll().zza(iObjectWrapper, view);
        }
    }

    private final void zzuj() {
        if (this.zzaad.isFinishing() && !this.zzdke) {
            this.zzdke = true;
            zzbek zzbek = this.zzdce;
            if (zzbek != null) {
                zzbek.zzdn(this.zzdjz);
                synchronized (this.zzdka) {
                    if (!this.zzdkc && this.zzdce.zzabr()) {
                        zze zze = new zze(this);
                        this.zzdkb = zze;
                        zzaxa.zzdwf.postDelayed(zze, ((Long) zzvj.zzpv().zzd(zzzz.zzclt)).longValue());
                        return;
                    }
                }
            }
            zzuk();
        }
    }

    private final void zzum() {
        this.zzdce.zzum();
    }

    public final void close() {
        this.zzdjz = 2;
        this.zzaad.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzdjz = 0;
    }

    public void onCreate(Bundle bundle) {
        this.zzaad.requestWindowFeature(1);
        this.zzdjw = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(this.zzaad.getIntent());
            this.zzdjq = zzc;
            if (zzc != null) {
                if (zzc.zzbmo.zzdzo > 7500000) {
                    this.zzdjz = 3;
                }
                if (this.zzaad.getIntent() != null) {
                    this.zzdkg = this.zzaad.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdjq.zzdla != null) {
                    this.zzblz = this.zzdjq.zzdla.zzblz;
                } else {
                    this.zzblz = false;
                }
                if (this.zzblz && this.zzdjq.zzdla.zzbme != -1) {
                    new zzl(this).zzwn();
                }
                if (bundle == null) {
                    if (this.zzdjq.zzdkt != null && this.zzdkg) {
                        this.zzdjq.zzdkt.zzua();
                    }
                    if (!(this.zzdjq.zzdky == 1 || this.zzdjq.zzceb == null)) {
                        this.zzdjq.zzceb.onAdClicked();
                    }
                }
                zzj zzj = new zzj(this.zzaad, this.zzdjq.zzdkz, this.zzdjq.zzbmo.zzbnd);
                this.zzdjx = zzj;
                zzj.setId(1000);
                zzq.zzky().zzg(this.zzaad);
                int i = this.zzdjq.zzdky;
                if (i == 1) {
                    zzaj(false);
                } else if (i == 2) {
                    this.zzdjr = new zzi(this.zzdjq.zzdce);
                    zzaj(false);
                } else if (i == 3) {
                    zzaj(true);
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzazw.zzfc(e.getMessage());
            this.zzdjz = 3;
            this.zzaad.finish();
        }
    }

    public final void onDestroy() {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            try {
                this.zzdjx.removeView(zzbek.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzuj();
    }

    public final void onPause() {
        zzuf();
        zzo zzo = this.zzdjq.zzdkt;
        if (zzo != null) {
            zzo.onPause();
        }
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue() && this.zzdce != null && (!this.zzaad.isFinishing() || this.zzdjr == null)) {
            zzq.zzky();
            zzaxf.zza(this.zzdce);
        }
        zzuj();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        zzo zzo = this.zzdjq.zzdkt;
        if (zzo != null) {
            zzo.onResume();
        }
        zza(this.zzaad.getResources().getConfiguration());
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue()) {
            zzbek zzbek = this.zzdce;
            if (zzbek == null || zzbek.isDestroyed()) {
                zzazw.zzfc("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzaxf.zzb(this.zzdce);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdjw);
    }

    public final void onStart() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue()) {
            zzbek zzbek = this.zzdce;
            if (zzbek == null || zzbek.isDestroyed()) {
                zzazw.zzfc("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzaxf.zzb(this.zzdce);
        }
    }

    public final void onStop() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqn)).booleanValue() && this.zzdce != null && (!this.zzaad.isFinishing() || this.zzdjr == null)) {
            zzq.zzky();
            zzaxf.zza(this.zzdce);
        }
        zzuj();
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaad.getApplicationInfo().targetSdkVersion >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsn)).intValue()) {
            if (this.zzaad.getApplicationInfo().targetSdkVersion <= ((Integer) zzvj.zzpv().zzd(zzzz.zzcso)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsp)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzvj.zzpv().zzd(zzzz.zzcsq)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaad.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzq.zzla().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzdjq).zzdla;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzclu
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdjq
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdla
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzbmg
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzzz.zzclv
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdjq
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzg r3 = r3.zzdla
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzbmh
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzapb r7 = new com.google.android.gms.internal.ads.zzapb
            com.google.android.gms.internal.ads.zzbek r4 = r6.zzdce
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdv(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzq r7 = r6.zzdjs
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r7.zzal(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zza(boolean, boolean):void");
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzdp() {
        this.zzdkd = true;
    }

    public final void zzuf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdjq;
        if (adOverlayInfoParcel != null && this.zzdjt) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdju != null) {
            this.zzaad.setContentView(this.zzdjx);
            this.zzdkd = true;
            this.zzdju.removeAllViews();
            this.zzdju = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdjv;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdjv = null;
        }
        this.zzdjt = false;
    }

    public final void zzug() {
        this.zzdjz = 1;
        this.zzaad.finish();
    }

    public final boolean zzuh() {
        this.zzdjz = 0;
        zzbek zzbek = this.zzdce;
        if (zzbek == null) {
            return true;
        }
        boolean zzabq = zzbek.zzabq();
        if (!zzabq) {
            this.zzdce.zza("onbackblocked", Collections.emptyMap());
        }
        return zzabq;
    }

    public final void zzui() {
        this.zzdjx.removeView(this.zzdjs);
        zzai(true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzuk() {
        zzbek zzbek;
        zzo zzo;
        if (!this.zzdkf) {
            this.zzdkf = true;
            zzbek zzbek2 = this.zzdce;
            if (zzbek2 != null) {
                this.zzdjx.removeView(zzbek2.getView());
                zzi zzi = this.zzdjr;
                if (zzi != null) {
                    this.zzdce.zzbt(zzi.zzvf);
                    this.zzdce.zzba(false);
                    ViewGroup viewGroup = this.zzdjr.parent;
                    View view = this.zzdce.getView();
                    zzi zzi2 = this.zzdjr;
                    viewGroup.addView(view, zzi2.index, zzi2.zzdkm);
                    this.zzdjr = null;
                } else if (this.zzaad.getApplicationContext() != null) {
                    this.zzdce.zzbt(this.zzaad.getApplicationContext());
                }
                this.zzdce = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdjq;
            if (!(adOverlayInfoParcel == null || (zzo = adOverlayInfoParcel.zzdkt) == null)) {
                zzo.zztz();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdjq;
            if (adOverlayInfoParcel2 != null && (zzbek = adOverlayInfoParcel2.zzdce) != null) {
                zzc(zzbek.zzabn(), this.zzdjq.zzdce.getView());
            }
        }
    }

    public final void zzul() {
        if (this.zzdjy) {
            this.zzdjy = false;
            zzum();
        }
    }

    public final void zzun() {
        this.zzdjx.zzdko = true;
    }

    public final void zzuo() {
        synchronized (this.zzdka) {
            this.zzdkc = true;
            if (this.zzdkb != null) {
                zzaxa.zzdwf.removeCallbacks(this.zzdkb);
                zzaxa.zzdwf.post(this.zzdkb);
            }
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaad);
        this.zzdju = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzdju.addView(view, -1, -1);
        this.zzaad.setContentView(this.zzdju);
        this.zzdkd = true;
        this.zzdjv = customViewCallback;
        this.zzdjt = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzdla;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzdjq
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdla
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzbma
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.gms.internal.ads.zzaxf r3 = com.google.android.gms.ads.internal.zzq.zzky()
            android.app.Activity r4 = r5.zzaad
            boolean r6 = r3.zza((android.app.Activity) r4, (android.content.res.Configuration) r6)
            boolean r3 = r5.zzblz
            r4 = 19
            if (r3 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0037
        L_0x0023:
            if (r6 != 0) goto L_0x0037
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r4) goto L_0x0038
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzdjq
            if (r6 == 0) goto L_0x0038
            com.google.android.gms.ads.internal.zzg r6 = r6.zzdla
            if (r6 == 0) goto L_0x0038
            boolean r6 = r6.zzbmf
            if (r6 == 0) goto L_0x0038
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            android.app.Activity r6 = r5.zzaad
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzclw
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0066
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0066
            android.view.View r6 = r6.getDecorView()
            r0 = 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0062
            r0 = 5380(0x1504, float:7.539E-42)
            if (r2 == 0) goto L_0x0062
            r0 = 5894(0x1706, float:8.259E-42)
        L_0x0062:
            r6.setSystemUiVisibility(r0)
            return
        L_0x0066:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0082
            r6.addFlags(r0)
            r6.clearFlags(r3)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0088
            if (r2 == 0) goto L_0x0088
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
            return
        L_0x0082:
            r6.addFlags(r3)
            r6.clearFlags(r0)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zza(android.content.res.Configuration):void");
    }
}
