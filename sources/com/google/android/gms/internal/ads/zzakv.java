package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzakv implements zzagi {
    private final /* synthetic */ zzakq zzdef;
    private final zzajs zzdei;
    private final zzbaj<O> zzdej;

    public zzakv(zzakq zzakq, zzajs zzajs, zzbaj<O> zzbaj) {
        this.zzdef = zzakq;
        this.zzdei = zzajs;
        this.zzdej = zzbaj;
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdej.setException(new zzake());
            } catch (IllegalStateException unused) {
                this.zzdei.release();
                return;
            } catch (Throwable th) {
                this.zzdei.release();
                throw th;
            }
        } else {
            this.zzdej.setException(new zzake(str));
        }
        this.zzdei.release();
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdej.set(this.zzdef.zzdea.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdej.setException(e);
        } finally {
            this.zzdei.release();
        }
    }
}
