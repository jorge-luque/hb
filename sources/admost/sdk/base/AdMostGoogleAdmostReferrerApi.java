package admost.sdk.base;

import android.content.Context;
import p093e.p097b.p098a.p099a.C3368a;
import p093e.p097b.p098a.p099a.C3374c;
import p093e.p097b.p098a.p099a.C3375d;

public class AdMostGoogleAdmostReferrerApi {
    /* access modifiers changed from: private */
    public C3368a mReferrerClient;

    private boolean isSuitableToRegisterInstallReferrer() {
        if (AdMost.getInstance().getConfiguration() != null && AdMost.getInstance().getConfiguration().hasCampaign() && !AdMostPreferences.getInstance().campaignAlreadySent() && AdMostAnalyticsManager.getInstance().getInstallDateLong() + 259200000 >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setInstallReferrer() {
        if (isSuitableToRegisterInstallReferrer()) {
            C3368a a = C3368a.m11242a((Context) AdMost.getInstance().getActivity()).mo19132a();
            this.mReferrerClient = a;
            a.mo19131a((C3374c) new C3374c() {
                public void onInstallReferrerServiceDisconnected() {
                }

                public void onInstallReferrerSetupFinished(int i) {
                    if (i == 0) {
                        try {
                            C3375d a = AdMostGoogleAdmostReferrerApi.this.mReferrerClient.mo19130a();
                            AdMostPreferences.newInstance(AdMost.getInstance().getContext());
                            AdMostPreferences instance = AdMostPreferences.getInstance();
                            instance.setInstallReferrer(a.mo19137b() + "&amr_camp_tracked");
                            InstallReferrerReceiver.trackCampaign(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
