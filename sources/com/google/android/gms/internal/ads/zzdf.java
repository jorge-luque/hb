package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdf implements zzdj {
    private static zzdf zzve;
    private final Context zzvf;
    private final zzdnc zzvg;
    private final zzdnj zzvh;
    private final zzej zzvi;
    /* access modifiers changed from: private */
    public final zzdlk zzvj;
    private final Executor zzvk;
    private final zzgb zzvl;
    private volatile long zzvm = 0;
    /* access modifiers changed from: private */
    public final Object zzvn = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzvo;

    private zzdf(Context context, zzdlk zzdlk, zzdnc zzdnc, zzdnj zzdnj, zzej zzej, Executor executor, zzgb zzgb) {
        this.zzvf = context;
        this.zzvj = zzdlk;
        this.zzvg = zzdnc;
        this.zzvh = zzdnj;
        this.zzvi = zzej;
        this.zzvk = executor;
        this.zzvl = zzgb;
    }

    public static synchronized zzdf zza(String str, Context context, boolean z) {
        zzdf zzdf;
        synchronized (zzdf.class) {
            if (zzve == null) {
                zzdlo zzaue = zzdlo.zzauh().zzgy(str).zzbq(z).zzaue();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdf zza = zza(context, zzdlk.zza(context, newCachedThreadPool), zzaue, (Executor) newCachedThreadPool);
                zzve = zza;
                zza.zzbr();
                zzve.zzbu();
            }
            zzdf = zzve;
        }
        return zzdf;
    }

    /* access modifiers changed from: private */
    public final void zzbt() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        zzdmz zzeb = this.zzvg.zzeb(zzdnh.zzhdc);
        if (zzeb != null) {
            String zzdh = zzeb.zzava().zzdh();
            str = zzeb.zzava().zzdi();
            str2 = zzdh;
        } else {
            str2 = null;
            str = null;
        }
        try {
            zzdng zza = zzdlw.zza(this.zzvf, 1, this.zzvl, str2, str, "1", this.zzvj);
            if (zza.zzhdb != null) {
                if (zza.zzhdb.length != 0) {
                    zzgd zza2 = zzgd.zza(zzeaq.zzu(zza.zzhdb), zzebq.zzbed());
                    boolean z = false;
                    if (!zza2.zzdd().zzdh().isEmpty() && !zza2.zzdd().zzdi().isEmpty()) {
                        if (zza2.zzdf().toByteArray().length != 0) {
                            zzdmz zzeb2 = this.zzvg.zzeb(zzdnh.zzhdc);
                            if (zzeb2 != null) {
                                zzgh zzava = zzeb2.zzava();
                                if (zzava != null) {
                                    if (zza2.zzdd().zzdh().equals(zzava.zzdh())) {
                                        if (!zza2.zzdd().zzdi().equals(zzava.zzdi())) {
                                        }
                                    }
                                }
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        this.zzvj.zzg(5010, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    } else if (!this.zzvg.zza(zza2, (zzdni) null)) {
                        this.zzvj.zzg(4009, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    } else {
                        this.zzvh.zzb(this.zzvg.zzeb(zzdnh.zzhdc));
                        this.zzvm = System.currentTimeMillis() / 1000;
                        return;
                    }
                }
            }
            this.zzvj.zzg(5009, System.currentTimeMillis() - currentTimeMillis);
        } catch (zzeco e) {
            this.zzvj.zza((int) GamesStatusCodes.STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE, System.currentTimeMillis() - currentTimeMillis, (Exception) e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzbu() {
        /*
            r6 = this;
            boolean r0 = r6.zzvo
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.zzvn
            monitor-enter(r0)
            boolean r1 = r6.zzvo     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zzvm     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzdnj r1 = r6.zzvh     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdmz r1 = r1.zzavl()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzfg(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zzbs()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdf.zzbu():void");
    }

    public final void zza(int i, int i2, int i3) {
    }

    public final void zzb(View view) {
        this.zzvi.zzc(view);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzbr() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdmz zzeb = this.zzvg.zzeb(zzdnh.zzhdc);
        if (zzeb == null || zzeb.zza()) {
            this.zzvj.zzg(4013, System.currentTimeMillis() - currentTimeMillis);
        } else {
            this.zzvh.zzb(zzeb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbs() {
        this.zzvk.execute(new zzdi(this));
    }

    public final String zzb(Context context) {
        zzbu();
        zzdlq zzavk = this.zzvh.zzavk();
        if (zzavk == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzu = zzavk.zzu(context, (String) null);
        this.zzvj.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzu, (Map<String, String>) null);
        return zzu;
    }

    static zzdf zza(Context context, zzdlk zzdlk, zzdlo zzdlo) {
        return zza(context, zzdlk, zzdlo, (Executor) Executors.newCachedThreadPool());
    }

    private static zzdf zza(Context context, zzdlk zzdlk, zzdlo zzdlo, Executor executor) {
        zzdma zzdma = new zzdma(context, executor, zzdlk, zzdlo);
        zzem zzem = new zzem(context);
        zzej zzej = new zzej(zzdlo, zzdma, new zzev(context, zzem), zzem);
        zzgb zzauw = new zzdmq(context, zzdlk).zzauw();
        return new zzdf(context, zzdlk, new zzdnc(context, zzauw), new zzdnj(context, zzej, zzdlk), zzej, executor, zzauw);
    }

    public final void zza(MotionEvent motionEvent) {
        zzdlq zzavk = this.zzvh.zzavk();
        if (zzavk != null) {
            try {
                zzavk.zza((String) null, motionEvent);
            } catch (zzdnk e) {
                this.zzvj.zza(e.zzavm(), -1, (Exception) e);
            }
        }
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        zzbu();
        zzdlq zzavk = this.zzvh.zzavk();
        if (zzavk == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzavk.zza(context, (String) null, str, view, activity);
        this.zzvj.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, (Map<String, String>) null);
        return zza;
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, View view, Activity activity) {
        zzbu();
        zzdlq zzavk = this.zzvh.zzavk();
        if (zzavk == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzavk.zzb(context, (String) null, view, activity);
        this.zzvj.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, (Map<String, String>) null);
        return zzb;
    }
}
