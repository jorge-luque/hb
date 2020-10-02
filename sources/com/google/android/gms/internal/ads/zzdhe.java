package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdhe {
    public final zzum zzbmp;
    public final zzaci zzdhc;
    public final zzahm zzdno;
    public final int zzgkg;
    public final boolean zzglu;
    public final zzwn zzguu;
    public final zzze zzguv;
    public final zzuj zzguw;
    public final String zzgux;
    public final ArrayList<String> zzguy;
    public final ArrayList<String> zzguz;
    public final zzut zzgva;
    public final PublisherAdViewOptions zzgvb;
    public final zzwh zzgvc;
    public final zzdgr zzgvd;

    private zzdhe(zzdhg zzdhg) {
        zzze zzze;
        zzaci zzaci;
        this.zzbmp = zzdhg.zzbmp;
        this.zzgux = zzdhg.zzgux;
        this.zzguu = zzdhg.zzguu;
        this.zzguw = new zzuj(zzdhg.zzguw.versionCode, zzdhg.zzguw.zzceg, zzdhg.zzguw.extras, zzdhg.zzguw.zzceh, zzdhg.zzguw.zzcei, zzdhg.zzguw.zzcej, zzdhg.zzguw.zzacq, zzdhg.zzguw.zzbli || zzdhg.zzbli, zzdhg.zzguw.zzcek, zzdhg.zzguw.zzcel, zzdhg.zzguw.zzmp, zzdhg.zzguw.zzcem, zzdhg.zzguw.zzcen, zzdhg.zzguw.zzceo, zzdhg.zzguw.zzcep, zzdhg.zzguw.zzceq, zzdhg.zzguw.zzcer, zzdhg.zzguw.zzces, zzdhg.zzguw.zzceu, zzdhg.zzguw.zzacr, zzdhg.zzguw.zzacs, zzdhg.zzguw.zzcet);
        if (zzdhg.zzguv != null) {
            zzze = zzdhg.zzguv;
        } else {
            zzze = zzdhg.zzdhc != null ? zzdhg.zzdhc.zzcyu : null;
        }
        this.zzguv = zzze;
        this.zzguy = zzdhg.zzguy;
        this.zzguz = zzdhg.zzguz;
        if (zzdhg.zzguy == null) {
            zzaci = null;
        } else if (zzdhg.zzdhc == null) {
            zzaci = new zzaci(new NativeAdOptions.Builder().build());
        } else {
            zzaci = zzdhg.zzdhc;
        }
        this.zzdhc = zzaci;
        this.zzgva = zzdhg.zzgva;
        this.zzgkg = zzdhg.zzgkg;
        this.zzgvb = zzdhg.zzgvb;
        this.zzgvc = zzdhg.zzgvc;
        this.zzdno = zzdhg.zzdno;
        this.zzgvd = new zzdgr(zzdhg.zzgve);
        this.zzglu = zzdhg.zzglu;
    }

    public final zzaem zzarx() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzgvb;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzju();
    }
}
