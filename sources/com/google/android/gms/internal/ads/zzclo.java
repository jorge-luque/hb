package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzclo extends zzaqz {
    private final Executor zzfhi;
    private final zzasa zzgci;
    private final zzarx zzgcj;
    private final zzbjv zzgck;
    private final HashMap<String, zzcmd> zzgcl;
    private final Context zzvf;

    public zzclo(Context context, Executor executor, zzasa zzasa, zzbjv zzbjv, zzarx zzarx, HashMap<String, zzcmd> hashMap) {
        zzzz.initialize(context);
        this.zzvf = context;
        this.zzfhi = executor;
        this.zzgci = zzasa;
        this.zzgcj = zzarx;
        this.zzgck = zzbjv;
        this.zzgcl = hashMap;
    }

    private static zzdri<JSONObject> zza(zzarj zzarj, zzdku zzdku, zzdbc zzdbc) {
        zzcls zzcls = new zzcls(zzdbc);
        return zzdku.zza(zzdkr.GMS_SIGNALS, zzdqw.zzag(zzarj.zzdpe)).zza(zzcls).zzb(zzclv.zzgaz).zzaud();
    }

    public final zzaqw zza(zzaqu zzaqu) throws RemoteException {
        return null;
    }

    public final void zza(zzaqu zzaqu, zzarb zzarb) throws RemoteException {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaou() {
        zzbaf.zza(this.zzgcj.zzvc(), "persistFlags");
    }

    public final zzdri<InputStream> zzb(zzarj zzarj, int i) {
        zzakp zza = zzq.zzlj().zza(this.zzvf, zzazz.zzyi());
        zzdbc zza2 = this.zzgck.zza(zzarj, i);
        zzakh<I, O> zza3 = zza.zza("google.afma.response.normalize", zzcmc.zzgct, zzakk.zzddv);
        zzcmh zzcmh = new zzcmh(this.zzvf, zzarj.zzdls.zzbnd, this.zzgci, zzarj.zzdms);
        zzdku zzaex = zza2.zzaex();
        zzcmd zzcmd = null;
        if (!zzabo.zzcxc.get().booleanValue()) {
            String str = zzarj.zzdpi;
            if (str != null && !str.isEmpty()) {
                zzawr.zzeg("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzarj.zzdpi;
            if (str2 != null && !str2.isEmpty() && (zzcmd = this.zzgcl.remove(zzarj.zzdpi)) == null) {
                zzawr.zzeg("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzcmd == null) {
            zzdri<JSONObject> zza4 = zza(zzarj, zzaex, zza2);
            zzdri<zzarp> zza5 = zza(zza4, zzaex, zza);
            zzdkd zzaud = zzaex.zza(zzdkr.HTTP, (zzdri<?>[]) new zzdri[]{zza5, zza4}).zzb(new zzclr(zza4, zza5)).zzb(zzcmh).zzaud();
            return zzaex.zza(zzdkr.PRE_PROCESS, (zzdri<?>[]) new zzdri[]{zza4, zza5, zzaud}).zzb(new zzclq(zzaud, zza4, zza5)).zza(zza3).zzaud();
        }
        zzdkd zzaud2 = zzaex.zza(zzdkr.HTTP, zzdqw.zzag(new zzcmg(zzcmd.zzgcr, zzcmd.zzgcs))).zzb(zzcmh).zzaud();
        zzdri zzag = zzdqw.zzag(zzcmd);
        return zzaex.zza(zzdkr.PRE_PROCESS, (zzdri<?>[]) new zzdri[]{zzaud2, zzag}).zzb(new zzclt(zzaud2, zzag)).zza(zza3).zzaud();
    }

    public final zzdri<InputStream> zzc(zzarj zzarj, int i) {
        if (!zzabo.zzcxc.get().booleanValue()) {
            return zzdqw.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdir zzdir = zzarj.zzdph;
        if (zzdir == null) {
            return zzdqw.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdir.zzgwv == 0 || zzdir.zzgww == 0) {
            return zzdqw.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzakp zza = zzq.zzlj().zza(this.zzvf, zzazz.zzyi());
        zzdbc zza2 = this.zzgck.zza(zzarj, i);
        zzdku zzaex = zza2.zzaex();
        zzdri<JSONObject> zza3 = zza(zzarj, zzaex, zza2);
        zzdri<zzarp> zza4 = zza(zza3, zzaex, zza);
        return zzaex.zza(zzdkr.GET_URL_AND_CACHE_KEY, (zzdri<?>[]) new zzdri[]{zza3, zza4}).zzb(new zzclw(this, zza4, zza3)).zzaud();
    }

    public final zzdri<InputStream> zzgl(String str) {
        if (!zzabo.zzcxc.get().booleanValue()) {
            return zzdqw.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcmb zzcmb = new zzcmb(this);
        if (this.zzgcl.remove(str) != null) {
            return zzdqw.zzag(zzcmb);
        }
        String valueOf = String.valueOf(str);
        return zzdqw.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    private static zzdri<zzarp> zza(zzdri<JSONObject> zzdri, zzdku zzdku, zzakp zzakp) {
        return zzdku.zza(zzdkr.BUILD_URL, zzdri).zza(zzakp.zza("AFMA_getAdDictionary", zzakk.zzddu, zzclu.zzddw)).zzaud();
    }

    public final void zza(zzarj zzarj, zzard zzard) {
        zzdri<InputStream> zzb = zzb(zzarj, Binder.getCallingUid());
        zza(zzb, zzard);
        zzb.addListener(new zzclx(this), this.zzfhi);
    }

    public final void zza(String str, zzard zzard) {
        zza(zzgl(str), zzard);
    }

    public final void zzc(zzarj zzarj, zzard zzard) {
        zza(zzc(zzarj, Binder.getCallingUid()), zzard);
    }

    private final void zza(zzdri<InputStream> zzdri, zzard zzard) {
        zzdqw.zza(zzdqw.zzb(zzdri, new zzcly(this), (Executor) zzbab.zzdzr), new zzcma(this, zzard), zzbab.zzdzw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzdri zzdri, zzdri zzdri2) throws Exception {
        String zzva = ((zzarp) zzdri.get()).zzva();
        this.zzgcl.put(zzva, new zzcmd((zzarp) zzdri.get(), (JSONObject) zzdri2.get()));
        return new ByteArrayInputStream(zzva.getBytes(zzdnv.UTF_8));
    }

    public final void zzb(zzarj zzarj, zzard zzard) {
        zzdri zzdri;
        int callingUid = Binder.getCallingUid();
        zzakp zza = zzq.zzlj().zza(this.zzvf, zzazz.zzyi());
        if (!zzabu.zzcxu.get().booleanValue()) {
            zzdri = zzdqw.immediateFailedFuture(new Exception("Signal collection disabled."));
        } else {
            zzdbc zza2 = this.zzgck.zza(zzarj, callingUid);
            zzdaj<JSONObject> zzaew = zza2.zzaew();
            zzdri = zza2.zzaex().zza(zzdkr.GET_SIGNALS, zzdqw.zzag(zzarj.zzdpe)).zza(new zzclz(zzaew)).zzw(zzdkr.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzakk.zzddu, zzakk.zzddv)).zzaud();
        }
        zza((zzdri<InputStream>) zzdri, zzard);
    }
}
