package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbbk extends FrameLayout implements zzbbf {
    private final zzbbx zzebj;
    private final FrameLayout zzebk;
    private final zzaam zzebl;
    private final zzbbz zzebm;
    private final long zzebn;
    private zzbbi zzebo;
    private boolean zzebp;
    private boolean zzebq;
    private boolean zzebr;
    private boolean zzebs;
    private long zzebt;
    private long zzebu;
    private String zzebv;
    private String[] zzebw;
    private Bitmap zzebx;
    private ImageView zzeby;
    private boolean zzebz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbbk(Context context, zzbbx zzbbx, int i, boolean z, zzaam zzaam, zzbby zzbby) {
        super(context);
        Context context2 = context;
        zzbbx zzbbx2 = zzbbx;
        this.zzebj = zzbbx2;
        zzaam zzaam2 = zzaam;
        this.zzebl = zzaam2;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzebk = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbbx.zzzi());
        zzbbi zza = zzbbx.zzzi().zzblq.zza(context, zzbbx2, i, z, zzaam2, zzbby);
        this.zzebo = zza;
        if (zza != null) {
            this.zzebk.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcjp)).booleanValue()) {
                zzyw();
            }
        }
        this.zzeby = new ImageView(context);
        this.zzebn = ((Long) zzvj.zzpv().zzd(zzzz.zzcjt)).longValue();
        boolean booleanValue = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcjr)).booleanValue();
        this.zzebs = booleanValue;
        zzaam zzaam3 = this.zzebl;
        if (zzaam3 != null) {
            zzaam3.zzh("spinner_used", booleanValue ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.zzebm = new zzbbz(this);
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.zza(this);
        }
        if (this.zzebo == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbbx zzbbx, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbbx.zza("onVideoEvent", hashMap);
    }

    public static void zzb(zzbbx zzbbx) {
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, "no_video_view");
        zzbbx.zza("onVideoEvent", hashMap);
    }

    private final boolean zzyy() {
        return this.zzeby.getParent() != null;
    }

    private final void zzyz() {
        if (this.zzebj.zzzh() != null && this.zzebq && !this.zzebr) {
            this.zzebj.zzzh().getWindow().clearFlags(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            this.zzebq = false;
        }
    }

    public final void destroy() {
        this.zzebm.pause();
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.stop();
        }
        zzyz();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzebm.pause();
            if (this.zzebo != null) {
                zzbbi zzbbi = this.zzebo;
                zzdrh zzdrh = zzbab.zzdzv;
                zzbbi.getClass();
                zzdrh.execute(zzbbj.zza(zzbbi));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onPaused() {
        zzd("pause", new String[0]);
        zzyz();
        this.zzebp = false;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzebm.resume();
        } else {
            this.zzebm.pause();
            this.zzebu = this.zzebt;
        }
        zzaxa.zzdwf.post(new zzbbm(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzebm.resume();
            z = true;
        } else {
            this.zzebm.pause();
            this.zzebu = this.zzebt;
            z = false;
        }
        zzaxa.zzdwf.post(new zzbbn(this, z));
    }

    public final void pause() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.pause();
        }
    }

    public final void play() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.play();
        }
    }

    public final void seekTo(int i) {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.seekTo(i);
        }
    }

    public final void setVolume(float f) {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.zzebh.setVolume(f);
            zzbbi.zzyo();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzau(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzc(String str, String[] strArr) {
        this.zzebv = str;
        this.zzebw = strArr;
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzebk.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzde(int i) {
        this.zzebo.zzde(i);
    }

    public final void zzdf(int i) {
        this.zzebo.zzdf(i);
    }

    public final void zzdg(int i) {
        this.zzebo.zzdg(i);
    }

    public final void zzdh(int i) {
        this.zzebo.zzdh(i);
    }

    public final void zzdi(int i) {
        this.zzebo.zzdi(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzfa() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null && this.zzebu == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzbbi.getDuration()) / 1000.0f), TJAdUnitConstants.String.VIDEO_WIDTH, String.valueOf(this.zzebo.getVideoWidth()), TJAdUnitConstants.String.VIDEO_HEIGHT, String.valueOf(this.zzebo.getVideoHeight()));
        }
    }

    public final void zzhx() {
        if (this.zzebo != null) {
            if (!TextUtils.isEmpty(this.zzebv)) {
                this.zzebo.zzb(this.zzebv, this.zzebw);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    public final void zzk(int i, int i2) {
        if (this.zzebs) {
            int max = Math.max(i / ((Integer) zzvj.zzpv().zzd(zzzz.zzcjs)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzvj.zzpv().zzd(zzzz.zzcjs)).intValue(), 1);
            Bitmap bitmap = this.zzebx;
            if (bitmap == null || bitmap.getWidth() != max || this.zzebx.getHeight() != max2) {
                this.zzebx = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzebz = false;
            }
        }
    }

    public final void zzm(String str, String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    public final void zzyp() {
        this.zzebm.resume();
        zzaxa.zzdwf.post(new zzbbl(this));
    }

    public final void zzyq() {
        if (this.zzebj.zzzh() != null && !this.zzebq) {
            boolean z = (this.zzebj.zzzh().getWindow().getAttributes().flags & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0;
            this.zzebr = z;
            if (!z) {
                this.zzebj.zzzh().getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                this.zzebq = true;
            }
        }
        this.zzebp = true;
    }

    public final void zzyr() {
        zzd("ended", new String[0]);
        zzyz();
    }

    public final void zzys() {
        if (this.zzebz && this.zzebx != null && !zzyy()) {
            this.zzeby.setImageBitmap(this.zzebx);
            this.zzeby.invalidate();
            this.zzebk.addView(this.zzeby, new FrameLayout.LayoutParams(-1, -1));
            this.zzebk.bringChildToFront(this.zzeby);
        }
        this.zzebm.pause();
        this.zzebu = this.zzebt;
        zzaxa.zzdwf.post(new zzbbo(this));
    }

    public final void zzyt() {
        if (this.zzebp && zzyy()) {
            this.zzebk.removeView(this.zzeby);
        }
        if (this.zzebx != null) {
            long elapsedRealtime = zzq.zzld().elapsedRealtime();
            if (this.zzebo.getBitmap(this.zzebx) != null) {
                this.zzebz = true;
            }
            long elapsedRealtime2 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            if (zzawr.zzwo()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzawr.zzeg(sb.toString());
            }
            if (elapsedRealtime2 > this.zzebn) {
                zzazw.zzfc("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzebs = false;
                this.zzebx = null;
                zzaam zzaam = this.zzebl;
                if (zzaam != null) {
                    zzaam.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzyu() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.zzebh.setMuted(true);
            zzbbi.zzyo();
        }
    }

    public final void zzyv() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.zzebh.setMuted(false);
            zzbbi.zzyo();
        }
    }

    @TargetApi(14)
    public final void zzyw() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            TextView textView = new TextView(zzbbi.getContext());
            String valueOf = String.valueOf(this.zzebo.zzyk());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.zzebk.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzebk.bringChildToFront(textView);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzyx() {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            long currentPosition = (long) zzbbi.getCurrentPosition();
            if (this.zzebt != currentPosition && currentPosition > 0) {
                zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzebt = currentPosition;
            }
        }
    }

    public static void zza(zzbbx zzbbx, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, "decoderProps");
        hashMap.put("error", str);
        zzbbx.zza("onVideoEvent", hashMap);
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzebj.zza("onVideoEvent", hashMap);
    }

    public final void zza(float f, float f2) {
        zzbbi zzbbi = this.zzebo;
        if (zzbbi != null) {
            zzbbi.zza(f, f2);
        }
    }
}
