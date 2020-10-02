package admost.sdk.base;

import admost.sdk.model.AdMostBannerResponseBase;
import admost.sdk.model.AdMostBannerResponseType1;
import admost.sdk.model.AdMostBannerResponseType2;
import org.json.JSONObject;

public class AdMostWaterfallStrategyManager {
    private static final Object lock = new Object();
    private static AdMostWaterfallStrategyManager waterfallStrategyManagerInstance;

    public static AdMostWaterfallStrategyManager getInstance() {
        if (waterfallStrategyManagerInstance == null) {
            synchronized (lock) {
                if (waterfallStrategyManagerInstance == null) {
                    waterfallStrategyManagerInstance = new AdMostWaterfallStrategyManager();
                }
            }
        }
        return waterfallStrategyManagerInstance;
    }

    public synchronized AdMostBannerResponseBase getBannerResponseObject(JSONObject jSONObject, boolean z, boolean z2) {
        AdMostBannerResponseBase adMostBannerResponseBase;
        try {
            JSONObject algorithmParams = AdMostExperimentManager.getInstance().getAlgorithmParams(jSONObject);
            boolean optBoolean = algorithmParams.optBoolean("isFirstRequestForZone");
            JSONObject jSONObject2 = algorithmParams.getJSONObject("updatedData");
            if (algorithmParams.optInt(AdMostExperimentManager.TYPE_ALGORITHM, 1) == 2) {
                adMostBannerResponseBase = new AdMostBannerResponseType2(jSONObject2, optBoolean, z2);
            } else {
                adMostBannerResponseBase = new AdMostBannerResponseType1(jSONObject2, optBoolean, z2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return adMostBannerResponseBase;
    }
}
