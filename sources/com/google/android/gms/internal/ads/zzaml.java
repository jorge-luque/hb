package com.google.android.gms.internal.ads;

import admost.sdk.AdMostInterstitial;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaml extends zzalt {
    /* access modifiers changed from: private */
    public final Object zzdgp;
    private zzamm zzdgq;
    private zzasy zzdgr;
    private IObjectWrapper zzdgs;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdgt;

    public zzaml(MediationAdapter mediationAdapter) {
        this.zzdgp = mediationAdapter;
    }

    private final Bundle zzd(zzuj zzuj) {
        Bundle bundle;
        Bundle bundle2 = zzuj.zzcen;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zzdgp.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    public final void destroy() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdgp;
        if (obj instanceof zzbgz) {
            return ((zzbgz) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbgz.class.getCanonicalName();
        String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazw.zzfc(sb.toString());
        return new Bundle();
    }

    public final zzxl getVideoController() {
        Object obj = this.zzdgp;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzazw.zzc("", th);
            return null;
        }
    }

    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazw.zzed("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdgp).isInitialized();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzdgr != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzdgp;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzed(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzazw.zzc("", th);
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.zzdgp instanceof MediationInterstitialAdapter) {
            zzazw.zzed("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdgp).showInterstitial();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazw.zzed("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdgp).showVideo();
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdgt;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdgs));
            } else {
                zzazw.zzfa("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzum, zzuj, str, (String) null, zzalv);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        String str2 = str;
        if (this.zzdgp instanceof Adapter) {
            zzazw.zzed("Requesting rewarded ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzalv);
                Bundle zza2 = zza(str2, zzuj2, (String) null);
                Bundle zzd = zzd(zzuj2);
                boolean zzc = zzc(zzuj);
                Location location = zzuj2.zzmp;
                int i = zzuj2.zzacq;
                int i2 = zzuj2.zzacr;
                String zza3 = zza(str2, zzuj2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdgp).loadRewardedAd(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzazw.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        String str2 = str;
        if (this.zzdgp instanceof Adapter) {
            zzazw.zzed("Requesting rewarded interstitial ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzalv);
                Bundle zza2 = zza(str2, zzuj2, (String) null);
                Bundle zzd = zzd(zzuj2);
                boolean zzc = zzc(zzuj);
                Location location = zzuj2.zzmp;
                int i = zzuj2.zzacq;
                int i2 = zzuj2.zzacr;
                String zza3 = zza(str2, zzuj2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdgp).zza(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzazw.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdgp;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdgp instanceof Adapter) {
            zzazw.zzed("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdgt;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzazw.zzfa("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final IObjectWrapper zztf() throws RemoteException {
        Object obj = this.zzdgp;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzaly zztg() {
        NativeAdMapper zztt = this.zzdgq.zztt();
        if (zztt instanceof NativeAppInstallAdMapper) {
            return new zzamo((NativeAppInstallAdMapper) zztt);
        }
        return null;
    }

    public final zzamd zzth() {
        NativeAdMapper zztt = this.zzdgq.zztt();
        if (zztt instanceof NativeContentAdMapper) {
            return new zzamr((NativeContentAdMapper) zztt);
        }
        return null;
    }

    public final Bundle zzti() {
        Object obj = this.zzdgp;
        if (obj instanceof zzbgx) {
            return ((zzbgx) obj).zzti();
        }
        String canonicalName = zzbgx.class.getCanonicalName();
        String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazw.zzfc(sb.toString());
        return new Bundle();
    }

    public final Bundle zztj() {
        return new Bundle();
    }

    public final boolean zztk() {
        return this.zzdgp instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzado zztl() {
        NativeCustomTemplateAd zztv = this.zzdgq.zztv();
        if (zztv instanceof zzadt) {
            return ((zzadt) zztv).zzsi();
        }
        return null;
    }

    public final zzame zztm() {
        UnifiedNativeAdMapper zztu = this.zzdgq.zztu();
        if (zztu != null) {
            return new zzang(zztu);
        }
        return null;
    }

    public final zzaoj zztn() {
        Object obj = this.zzdgp;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaoj.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzaoj zzto() {
        Object obj = this.zzdgp;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaoj.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        Date date;
        AdSize zza;
        zzum zzum2 = zzum;
        zzuj zzuj2 = zzuj;
        String str3 = str;
        if (this.zzdgp instanceof MediationBannerAdapter) {
            zzazw.zzed("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdgp;
                Bundle bundle = null;
                HashSet hashSet = zzuj2.zzcei != null ? new HashSet(zzuj2.zzcei) : null;
                if (zzuj2.zzceg == -1) {
                    date = null;
                } else {
                    date = new Date(zzuj2.zzceg);
                }
                zzami zzami = new zzami(date, zzuj2.zzceh, hashSet, zzuj2.zzmp, zzc(zzuj), zzuj2.zzacq, zzuj2.zzces, zzuj2.zzacr, zza(str3, zzuj2));
                if (zzuj2.zzcen != null) {
                    bundle = zzuj2.zzcen.getBundle(mediationBannerAdapter.getClass().getName());
                }
                Bundle bundle2 = bundle;
                if (zzum2.zzcfd) {
                    zza = zzb.zza(zzum2.width, zzum2.height);
                } else {
                    zza = zzb.zza(zzum2.width, zzum2.height, zzum2.zzacf);
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzamm(zzalv), zza(str3, zzuj2, str2), zza, zzami, bundle2);
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public zzaml(Adapter adapter) {
        this.zzdgp = adapter;
    }

    private static boolean zzc(zzuj zzuj) {
        if (zzuj.zzcej) {
            return true;
        }
        zzvj.zzpr();
        return zzazm.zzyd();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzuj, str, (String) null, zzalv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        Date date;
        zzuj zzuj2 = zzuj;
        String str3 = str;
        if (this.zzdgp instanceof MediationInterstitialAdapter) {
            zzazw.zzed("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdgp;
                Bundle bundle = null;
                HashSet hashSet = zzuj2.zzcei != null ? new HashSet(zzuj2.zzcei) : null;
                if (zzuj2.zzceg == -1) {
                    date = null;
                } else {
                    date = new Date(zzuj2.zzceg);
                }
                zzami zzami = new zzami(date, zzuj2.zzceh, hashSet, zzuj2.zzmp, zzc(zzuj), zzuj2.zzacq, zzuj2.zzces, zzuj2.zzacr, zza(str3, zzuj2));
                if (zzuj2.zzcen != null) {
                    bundle = zzuj2.zzcen.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzamm(zzalv), zza(str3, zzuj2, str2), zzami, bundle);
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv, zzaci zzaci, List<String> list) throws RemoteException {
        Date date;
        zzuj zzuj2 = zzuj;
        String str3 = str;
        Object obj = this.zzdgp;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                HashSet hashSet = zzuj2.zzcei != null ? new HashSet(zzuj2.zzcei) : null;
                if (zzuj2.zzceg == -1) {
                    date = null;
                } else {
                    date = new Date(zzuj2.zzceg);
                }
                zzamq zzamq = new zzamq(date, zzuj2.zzceh, hashSet, zzuj2.zzmp, zzc(zzuj), zzuj2.zzacq, zzaci, list, zzuj2.zzces, zzuj2.zzacr, zza(str3, zzuj2));
                if (zzuj2.zzcen != null) {
                    bundle = zzuj2.zzcen.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.zzdgq = new zzamm(zzalv);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdgq, zza(str3, zzuj2, str2), zzamq, bundle);
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzasy zzasy, String str2) throws RemoteException {
        Bundle bundle;
        zzami zzami;
        Date date;
        zzuj zzuj2 = zzuj;
        zzasy zzasy2 = zzasy;
        String str3 = str2;
        Object obj = this.zzdgp;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazw.zzed("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdgp;
                Bundle zza = zza(str3, zzuj2, (String) null);
                if (zzuj2 != null) {
                    HashSet hashSet = zzuj2.zzcei != null ? new HashSet(zzuj2.zzcei) : null;
                    if (zzuj2.zzceg == -1) {
                        date = null;
                    } else {
                        date = new Date(zzuj2.zzceg);
                    }
                    zzami zzami2 = new zzami(date, zzuj2.zzceh, hashSet, zzuj2.zzmp, zzc(zzuj), zzuj2.zzacq, zzuj2.zzces, zzuj2.zzacr, zza(str3, zzuj2));
                    bundle = zzuj2.zzcen != null ? zzuj2.zzcen.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzami = zzami2;
                } else {
                    zzami = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzami, str, new zzasz(zzasy2), zza, bundle);
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.zzdgs = iObjectWrapper;
            this.zzdgr = zzasy2;
            zzasy2.zzaf(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzasy zzasy, List<String> list) throws RemoteException {
        if (this.zzdgp instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzazw.zzed("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdgp;
                ArrayList arrayList = new ArrayList();
                for (String zza : list) {
                    arrayList.add(zza(zza, (zzuj) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzasz(zzasy), arrayList);
            } catch (Throwable th) {
                zzazw.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zzuj zzuj, String str) throws RemoteException {
        zza(zzuj, str, (String) null);
    }

    public final void zza(zzuj zzuj, String str, String str2) throws RemoteException {
        Date date;
        zzuj zzuj2 = zzuj;
        String str3 = str;
        Object obj = this.zzdgp;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazw.zzed("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdgp;
                Bundle bundle = null;
                HashSet hashSet = zzuj2.zzcei != null ? new HashSet(zzuj2.zzcei) : null;
                if (zzuj2.zzceg == -1) {
                    date = null;
                } else {
                    date = new Date(zzuj2.zzceg);
                }
                zzami zzami = new zzami(date, zzuj2.zzceh, hashSet, zzuj2.zzmp, zzc(zzuj), zzuj2.zzacq, zzuj2.zzces, zzuj2.zzacr, zza(str3, zzuj2));
                if (zzuj2.zzcen != null) {
                    bundle = zzuj2.zzcen.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzami, zza(str3, zzuj2, str2), bundle);
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzdgs, zzuj2, str3, new zzamp((Adapter) obj, this.zzdgr));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazw.zzfc(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzahc zzahc, List<zzahk> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdgp instanceof Adapter) {
            zzamk zzamk = new zzamk(this, zzahc);
            ArrayList arrayList = new ArrayList();
            for (zzahk next : list) {
                String str = next.zzdbk;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (str.equals("native")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -239580146:
                        if (str.equals(AdMostInterstitial.ZONE_TYPE_REWARDED)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str.equals(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    adFormat = AdFormat.BANNER;
                } else if (c == 1) {
                    adFormat = AdFormat.INTERSTITIAL;
                } else if (c == 2) {
                    adFormat = AdFormat.REWARDED;
                } else if (c == 3) {
                    adFormat = AdFormat.NATIVE;
                } else {
                    throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, next.extras));
            }
            ((Adapter) this.zzdgp).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzamk, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzalv zzalv) {
        return new zzamn(this, zzalv);
    }

    private final Bundle zza(String str, zzuj zzuj, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzazw.zzed(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzdgp instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzuj != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzuj.zzacq);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }

    private static String zza(String str, zzuj zzuj) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzuj.zzacs;
        }
    }
}
