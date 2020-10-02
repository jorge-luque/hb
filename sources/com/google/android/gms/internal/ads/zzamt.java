package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzamt<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzalt {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdhg;
    private final NETWORK_EXTRAS zzdhh;

    public zzamt(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdhg = mediationAdapter;
        this.zzdhh = network_extras;
    }

    private static boolean zzc(zzuj zzuj) {
        if (zzuj.zzcej) {
            return true;
        }
        zzvj.zzpr();
        return zzazm.zzyd();
    }

    private final SERVER_PARAMETERS zzdn(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzazw.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzdhg.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzdhg.destroy();
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final zzxl getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdhg;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdhg).showInterstitial();
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzahc zzahc, List<zzahk> list) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzasy zzasy, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzasy zzasy, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv, zzaci zzaci, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzum, zzuj, str, (String) null, zzalv);
    }

    public final void zza(zzuj zzuj, String str) {
    }

    public final void zza(zzuj zzuj, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final IObjectWrapper zztf() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdhg;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }

    public final zzaly zztg() {
        return null;
    }

    public final zzamd zzth() {
        return null;
    }

    public final Bundle zzti() {
        return new Bundle();
    }

    public final Bundle zztj() {
        return new Bundle();
    }

    public final boolean zztk() {
        return false;
    }

    public final zzado zztl() {
        return null;
    }

    public final zzame zztm() {
        return null;
    }

    public final zzaoj zztn() {
        return null;
    }

    public final zzaoj zzto() {
        return null;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdhg;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdhg;
            zzams zzams = new zzams(zzalv);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzdn = zzdn(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzum.width && adSizeArr[i].getHeight() == zzum.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zzb.zza(zzum.width, zzum.height, zzum.zzacf));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzams, activity, zzdn, adSize, zzane.zza(zzuj, zzc(zzuj)), this.zzdhh);
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzuj, str, (String) null, zzalv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdhg;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdhg).requestInterstitialAd(new zzams(zzalv), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdn(str), zzane.zza(zzuj, zzc(zzuj)), this.zzdhh);
        } catch (Throwable th) {
            zzazw.zzc("", th);
            throw new RemoteException();
        }
    }
}
