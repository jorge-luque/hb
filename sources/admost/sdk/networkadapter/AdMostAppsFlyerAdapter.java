package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import com.appsflyer.AppsFlyerLib;

public class AdMostAppsFlyerAdapter {
    private String mAppsFlyerId;

    public String getAppsFlyerUID() {
        try {
            this.mAppsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(AdMost.getInstance().getContext());
        } catch (Exception unused) {
        }
        return this.mAppsFlyerId;
    }
}
