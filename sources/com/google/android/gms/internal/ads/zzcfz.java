package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcfz {
    private final zzcfu zzfxs;
    private final AtomicReference<zzalp> zzfxt = new AtomicReference<>();

    zzcfz(zzcfu zzcfu) {
        this.zzfxs = zzcfu;
    }

    private final zzalp zzanc() throws RemoteException {
        zzalp zzalp = this.zzfxt.get();
        if (zzalp != null) {
            return zzalp;
        }
        zzazw.zzfc("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzalq zze(String str, JSONObject jSONObject) throws RemoteException {
        zzalp zzanc = zzanc();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (zzanc.zzdh(jSONObject.getString("class_name"))) {
                    return zzanc.zzdg("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return zzanc.zzdg("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzazw.zzc("Invalid custom event.", e);
            }
        }
        return zzanc.zzdg(str);
    }

    public final boolean zzanb() {
        return this.zzfxt.get() != null;
    }

    public final void zzb(zzalp zzalp) {
        this.zzfxt.compareAndSet((Object) null, zzalp);
    }

    public final zzdhq zzd(String str, JSONObject jSONObject) throws zzdhk {
        zzalq zzalq;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzalq = new zzaml((MediationAdapter) new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzalq = new zzaml((MediationAdapter) new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzalq = new zzaml((MediationAdapter) new zzaol());
            } else {
                zzalq = zze(str, jSONObject);
            }
            zzdhq zzdhq = new zzdhq(zzalq);
            this.zzfxs.zza(str, zzdhq);
            return zzdhq;
        } catch (Throwable th) {
            throw new zzdhk(th);
        }
    }

    public final zzanv zzdk(String str) throws RemoteException {
        zzanv zzdk = zzanc().zzdk(str);
        this.zzfxs.zza(str, zzdk);
        return zzdk;
    }
}
