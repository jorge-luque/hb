package admost.sdk.dfp;

import admost.sdk.AdMostInterstitial;
import admost.sdk.base.AdMost;
import admost.sdk.listener.AdMostAdListener;
import android.content.Context;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import java.util.List;

public class AmrDfpCustomEventRewarded extends Adapter implements MediationRewardedAd {
    public static final int FAILED_TO_SHOW_ERR = 9991000;
    private static final String SAMPLE_AD_UNIT_KEY = "parameter";
    private AdMostInterstitial adMostRewarded;

    public VersionInfo getSDKVersionInfo() {
        String[] split = AdMost.getInstance().getVersion().split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public VersionInfo getVersionInfo() {
        String[] split = AdMost.getInstance().getVersion().split("\\.");
        return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        AdMostInterstitial adMostInterstitial = new AdMostInterstitial(AdMost.getInstance().getActivity(), mediationRewardedAdConfiguration.getServerParameters().getString("parameter"), (AdMostAdListener) null);
        this.adMostRewarded = adMostInterstitial;
        adMostInterstitial.setListener(new AmrDfpCustomRewardedEventForwarder(mediationAdLoadCallback, this));
        this.adMostRewarded.refreshAd(false);
    }

    public void showAd(Context context) {
        if (this.adMostRewarded.isLoaded()) {
            this.adMostRewarded.show();
        } else {
            this.adMostRewarded.getAdMostAdListener().onFail(FAILED_TO_SHOW_ERR);
        }
    }
}
