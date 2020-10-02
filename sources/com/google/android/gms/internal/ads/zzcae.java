package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import p075d.p080b.C3204g;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcae {
    public static final zzcae zzfsw = new zzcag().zzals();
    private final zzadx zzfsp;
    private final zzads zzfsq;
    private final zzael zzfsr;
    private final zzaeg zzfss;
    private final zzahu zzfst;
    private final C3204g<String, zzaed> zzfsu;
    private final C3204g<String, zzady> zzfsv;

    private zzcae(zzcag zzcag) {
        this.zzfsp = zzcag.zzfsp;
        this.zzfsq = zzcag.zzfsq;
        this.zzfsr = zzcag.zzfsr;
        this.zzfsu = new C3204g<>(zzcag.zzfsu);
        this.zzfsv = new C3204g<>(zzcag.zzfsv);
        this.zzfss = zzcag.zzfss;
        this.zzfst = zzcag.zzfst;
    }

    public final zzadx zzall() {
        return this.zzfsp;
    }

    public final zzads zzalm() {
        return this.zzfsq;
    }

    public final zzael zzaln() {
        return this.zzfsr;
    }

    public final zzaeg zzalo() {
        return this.zzfss;
    }

    public final zzahu zzalp() {
        return this.zzfst;
    }

    public final ArrayList<String> zzalq() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfsr != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfsp != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzfsq != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfsu.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfst != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzalr() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfsu.size());
        for (int i = 0; i < this.zzfsu.size(); i++) {
            arrayList.add(this.zzfsu.mo18803b(i));
        }
        return arrayList;
    }

    public final zzaed zzgb(String str) {
        return this.zzfsu.get(str);
    }

    public final zzady zzgc(String str) {
        return this.zzfsv.get(str);
    }
}
