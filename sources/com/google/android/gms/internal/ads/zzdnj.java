package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.google.android.gms.games.GamesStatusCodes;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdnj {
    private static final HashMap<String, Class<?>> zzhdg = new HashMap<>();
    private final zzdnm zzhcx;
    private zzdna zzhdh;
    private final Object zzhdi = new Object();
    private final Context zzvf;
    private final zzdlk zzvj;

    public zzdnj(Context context, zzdnm zzdnm, zzdlk zzdlk) {
        this.zzvf = context;
        this.zzhcx = zzdnm;
        this.zzvj = zzdlk;
    }

    private final synchronized Class<?> zza(zzdmz zzdmz) throws zzdnk {
        if (zzdmz.zzava() != null) {
            String zzdh = zzdmz.zzava().zzdh();
            Class<?> cls = zzhdg.get(zzdh);
            if (cls != null) {
                return cls;
            }
            try {
                File zzavc = zzdmz.zzavc();
                if (!zzavc.exists()) {
                    zzavc.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzdmz.zzavb().getAbsolutePath(), zzavc.getAbsolutePath(), (String) null, this.zzvf.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zzhdg.put(zzdh, loadClass);
                return loadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzdnk((int) AdError.REMOTE_ADS_SERVICE_ERROR, e);
            }
        } else {
            throw new zzdnk(4010, "mc");
        }
    }

    public final zzdlq zzavk() {
        zzdna zzdna;
        synchronized (this.zzhdi) {
            zzdna = this.zzhdh;
        }
        return zzdna;
    }

    public final zzdmz zzavl() {
        synchronized (this.zzhdi) {
            if (this.zzhdh == null) {
                return null;
            }
            zzdmz zzave = this.zzhdh.zzave();
            return zzave;
        }
    }

    public final void zzb(zzdmz zzdmz) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdna zzdna = new zzdna(zza(zza(zzdmz), zzdmz), zzdmz, this.zzhcx, this.zzvj);
            if (zzdna.zzavf()) {
                int zzavg = zzdna.zzavg();
                if (zzavg == 0) {
                    synchronized (this.zzhdi) {
                        if (this.zzhdh != null) {
                            try {
                                this.zzhdh.close();
                            } catch (zzdnk e) {
                                this.zzvj.zza(e.zzavm(), -1, (Exception) e);
                            }
                        }
                        this.zzhdh = zzdna;
                    }
                    this.zzvj.zzg(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzavg);
                throw new zzdnk((int) GamesStatusCodes.STATUS_SNAPSHOT_CREATION_FAILED, sb.toString());
            }
            throw new zzdnk((int) GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND, "init failed");
        } catch (zzdnk e2) {
            this.zzvj.zza(e2.zzavm(), System.currentTimeMillis() - currentTimeMillis, (Exception) e2);
        } catch (Exception e3) {
            this.zzvj.zza(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }

    private final Object zza(Class<?> cls, zzdmz zzdmz) throws zzdnk {
        try {
            return cls.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzvf, "msa-r", zzdmz.zzavd(), null, new Bundle(), 2});
        } catch (Exception e) {
            throw new zzdnk((int) AdError.INTERNAL_ERROR_2004, (Throwable) e);
        }
    }
}
