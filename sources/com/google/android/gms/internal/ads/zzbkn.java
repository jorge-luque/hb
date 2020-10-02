package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbkn implements zzaki<zzbkr> {
    private final zzpu zzfhc;
    private final Context zzvf;
    private final PowerManager zzzp;

    public zzbkn(Context context, zzpu zzpu) {
        this.zzvf = context;
        this.zzfhc = zzpu;
        this.zzzp = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbkr zzbkr) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzqa zzqa = zzbkr.zzfhu;
        if (zzqa == null) {
            jSONObject = new JSONObject();
        } else if (this.zzfhc.zzks() != null) {
            boolean z2 = zzqa.zzbpc;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzfhc.zzkr()).put("activeViewJSON", this.zzfhc.zzks()).put("timestamp", zzbkr.timestamp).put("adFormat", this.zzfhc.zzkq()).put("hashCode", this.zzfhc.zzkt()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbkr.zzfhr).put("isNative", this.zzfhc.isNative());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.zzzp.isInteractive();
            } else {
                z = this.zzzp.isScreenOn();
            }
            put.put("isScreenOn", z).put("appMuted", zzq.zzlb().zzqc()).put("appVolume", (double) zzq.zzlb().zzqb()).put("deviceVolume", (double) zzaxs.zzbg(this.zzvf.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zzvf.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqa.zzzw).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put("top", zzqa.zzbpd.top).put(TJAdUnitConstants.String.BOTTOM, zzqa.zzbpd.bottom).put("left", zzqa.zzbpd.left).put(TJAdUnitConstants.String.RIGHT, zzqa.zzbpd.right)).put("adBox", new JSONObject().put("top", zzqa.zzbpe.top).put(TJAdUnitConstants.String.BOTTOM, zzqa.zzbpe.bottom).put("left", zzqa.zzbpe.left).put(TJAdUnitConstants.String.RIGHT, zzqa.zzbpe.right)).put("globalVisibleBox", new JSONObject().put("top", zzqa.zzbpf.top).put(TJAdUnitConstants.String.BOTTOM, zzqa.zzbpf.bottom).put("left", zzqa.zzbpf.left).put(TJAdUnitConstants.String.RIGHT, zzqa.zzbpf.right)).put("globalVisibleBoxVisible", zzqa.zzbpg).put("localVisibleBox", new JSONObject().put("top", zzqa.zzbph.top).put(TJAdUnitConstants.String.BOTTOM, zzqa.zzbph.bottom).put("left", zzqa.zzbph.left).put(TJAdUnitConstants.String.RIGHT, zzqa.zzbph.right)).put("localVisibleBoxVisible", zzqa.zzbpi).put("hitBox", new JSONObject().put("top", zzqa.zzbpj.top).put(TJAdUnitConstants.String.BOTTOM, zzqa.zzbpj.bottom).put("left", zzqa.zzbpj.left).put(TJAdUnitConstants.String.RIGHT, zzqa.zzbpj.right)).put("screenDensity", (double) this.zzvf.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbkr.zzbot);
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcmx)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzqa.zzbpl;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put(new JSONObject().put("top", next.top).put(TJAdUnitConstants.String.BOTTOM, next.bottom).put("left", next.left).put(TJAdUnitConstants.String.RIGHT, next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbkr.zzfht)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
