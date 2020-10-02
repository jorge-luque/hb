package admost.sdk.base;

import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.FpDefaultItem;
import java.util.concurrent.ConcurrentHashMap;

public class AdMostFloorPriceManager {
    public static final String FP_ZONE_NETWORK_STATUS_FILL = "fill";
    public static final String FP_ZONE_NETWORK_STATUS_FIRST_REQUEST = "first_request";
    public static final String FP_ZONE_NETWORK_STATUS_NO_FILL = "no_fill";
    static final long PERSISTENCE_DELAY = 20000;
    private static AdMostFloorPriceManager instance;
    private static final Object lock = new Object();
    private ConcurrentHashMap<String, FpDefaultItem> persistedDefaults = new ConcurrentHashMap<>();

    public static AdMostFloorPriceManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostFloorPriceManager();
                }
            }
        }
        return instance;
    }

    public int getLastEcpmForZone(String str) {
        return AdMostPreferences.getInstance().getLastEcpmForZone(str);
    }

    public FpDefaultItem getPersistedDefault(String str, String str2) {
        String str3 = str2 + "*" + str;
        if (this.persistedDefaults.containsKey(str3)) {
            return this.persistedDefaults.get(str3);
        }
        this.persistedDefaults.put(str3, AdMostPreferences.getInstance().getFpDefaultForZone(str3));
        AdMostLog.m294d(AdMostFloorPriceManager.class.getSimpleName() + ": Persisted DEFAULT : Network: " + str + " ,Placement: " + this.persistedDefaults.get(str3).Placement + " ,Status: " + this.persistedDefaults.get(str3).Status);
        return this.persistedDefaults.get(str3);
    }

    public void removeDefaultsForZone(String str) {
        AdMostPreferences.getInstance().removeFpDefaultsForZone(str);
    }

    public void setFill(AdMostBannerResponseItem adMostBannerResponseItem) {
        int i = adMostBannerResponseItem.PureWeight;
        if (!adMostBannerResponseItem.AlwaysInWaterfall && (adMostBannerResponseItem.FPEnabledItem.equals("1") || adMostBannerResponseItem.InFPBoosterList)) {
            i = (adMostBannerResponseItem.PureWeight + adMostBannerResponseItem.FPValue) / 2;
        }
        AdMostPreferences.getInstance().setLastEcpmForZone(adMostBannerResponseItem.ZoneId, i);
        if (adMostBannerResponseItem.FPEnabledItem.equals("1") || adMostBannerResponseItem.InFPBoosterList) {
            FpDefaultItem persistedDefault = getPersistedDefault(adMostBannerResponseItem.Network, adMostBannerResponseItem.ZoneId);
            try {
                if (adMostBannerResponseItem.FPValue >= persistedDefault.Weight || persistedDefault.Status.equals(FP_ZONE_NETWORK_STATUS_NO_FILL) || persistedDefault.UpdateTime < System.currentTimeMillis() - PERSISTENCE_DELAY) {
                    setPersistedDefault(adMostBannerResponseItem.ZoneId, adMostBannerResponseItem.Network, FP_ZONE_NETWORK_STATUS_FILL, adMostBannerResponseItem.PlacementId, adMostBannerResponseItem.FPValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (adMostBannerResponseItem.ZoneFPEnabled && adMostBannerResponseItem.ZoneFPResetThreshold > 0 && AdMostPreferences.getInstance().setFPZoneFillCount(adMostBannerResponseItem.ZoneId, true) >= adMostBannerResponseItem.ZoneFPResetThreshold) {
            removeDefaultsForZone(adMostBannerResponseItem.ZoneId);
            AdMostPreferences.getInstance().setFPZoneFillCount(adMostBannerResponseItem.ZoneId, false);
            AdMostExperimentManager.getInstance().clearZoneNetworkFirstRequestMap(adMostBannerResponseItem.ZoneId);
        }
    }

    public void setNoFill(AdMostBannerResponseItem adMostBannerResponseItem) {
        if (adMostBannerResponseItem.FPEnabledItem.equals("1")) {
            FpDefaultItem persistedDefault = getPersistedDefault(adMostBannerResponseItem.Network, adMostBannerResponseItem.ZoneId);
            try {
                if (persistedDefault.Status.equals(FP_ZONE_NETWORK_STATUS_FIRST_REQUEST) || ((persistedDefault.Status.equals(FP_ZONE_NETWORK_STATUS_NO_FILL) && adMostBannerResponseItem.FPValue < persistedDefault.Weight) || (persistedDefault.Status.equals(FP_ZONE_NETWORK_STATUS_FILL) && persistedDefault.UpdateTime < System.currentTimeMillis() - PERSISTENCE_DELAY))) {
                    setPersistedDefault(adMostBannerResponseItem.ZoneId, adMostBannerResponseItem.Network, FP_ZONE_NETWORK_STATUS_NO_FILL, adMostBannerResponseItem.PlacementId, adMostBannerResponseItem.FPValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPersistedDefault(String str, String str2, String str3, String str4, int i) {
        String str5 = str + "*" + str2;
        this.persistedDefaults.put(str5, AdMostPreferences.getInstance().setFpDefaultForZone(str5, str3, str4, i));
    }
}
