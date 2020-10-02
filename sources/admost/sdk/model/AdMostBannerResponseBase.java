package admost.sdk.model;

import admost.sdk.base.AdMostExperimentManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.base.AdMostUtil;
import admost.sdk.base.AdMostZonePlacementStatus;
import admost.sdk.base.AdMostZoneType;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Comparator;
import org.json.JSONObject;

public abstract class AdMostBannerResponseBase {
    public boolean AddPlacementsAboveLastECPM;
    public String ApplicationId;
    public ArrayList<AdMostBannerResponseItem> BiddingItems;
    public int CustomNativeAdDuration;
    public int DebugUserDataPercentage;
    public long FCapLoadThreshold;
    public boolean FPEnabled;
    private String FirstRequestNetworkList;
    public boolean ForCache;
    public boolean IsFirstRequestForZone;
    public boolean IsFirstSessionRequestForZone;
    public ArrayList<AdMostBannerResponseItem> NetworkList;
    public ArrayList<AdMostBannerResponseItem> NetworkListInHouse;
    public ArrayList<AdMostBannerResponseItem> NetworkListNotInWaterfall;
    boolean Randomize;
    public int RefreshInterval;
    public long RequestInterval;
    public boolean RestrictUpper;
    public int Result;
    public boolean SSVEnabled;
    boolean SortNeeded;
    public String SubZoneType;
    public int ZoneFPResetThreshold;
    public int ZoneFcapDaily;
    public int ZoneFcapHourly;
    public String ZoneId;
    public int ZoneImpressionInterval;
    public int ZoneNffcTime;
    public int ZoneOverallTimeout;
    public int ZoneRandomizerBypassCount;
    public int ZoneRandomizerBypassInterval;
    public int ZoneRequestTimeout;
    public int ZoneResponseTimeout;
    public String ZoneSize;
    public String ZoneType;
    public String zoneName;

    public class CustomComparatorFPValue implements Comparator<AdMostBannerResponseItem> {
        public CustomComparatorFPValue() {
        }

        public int compare(AdMostBannerResponseItem adMostBannerResponseItem, AdMostBannerResponseItem adMostBannerResponseItem2) {
            try {
                return Integer.valueOf(adMostBannerResponseItem2.FPValue).compareTo(Integer.valueOf(adMostBannerResponseItem.FPValue));
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public class CustomComparatorPureWeight implements Comparator<AdMostBannerResponseItem> {
        public CustomComparatorPureWeight() {
        }

        public int compare(AdMostBannerResponseItem adMostBannerResponseItem, AdMostBannerResponseItem adMostBannerResponseItem2) {
            return Integer.valueOf(adMostBannerResponseItem2.PureWeight).compareTo(Integer.valueOf(adMostBannerResponseItem.PureWeight));
        }
    }

    public class CustomComparatorWeight implements Comparator<AdMostBannerResponseItem> {
        public CustomComparatorWeight() {
        }

        public int compare(AdMostBannerResponseItem adMostBannerResponseItem, AdMostBannerResponseItem adMostBannerResponseItem2) {
            return Integer.valueOf(adMostBannerResponseItem2.Weight).compareTo(Integer.valueOf(adMostBannerResponseItem.Weight));
        }
    }

    public AdMostBannerResponseBase() {
    }

    private void writeWaterfallLine(int i, AdMostBannerResponseItem adMostBannerResponseItem) {
        if (adMostBannerResponseItem.IsBiddingItem) {
            AdMostLog.m294d(i + "." + adMostBannerResponseItem.Network + " - " + adMostBannerResponseItem.PlacementName + " - " + adMostBannerResponseItem.PlacementId + " - bid_score : " + adMostBannerResponseItem.BidScore);
            return;
        }
        AdMostLog.m294d(i + "." + adMostBannerResponseItem.Network + " - " + adMostBannerResponseItem.PlacementName + " - " + adMostBannerResponseItem.PlacementId + " - calc_weight : " + adMostBannerResponseItem.Weight + " - pure_weight : " + adMostBannerResponseItem.PureWeight + " - floor_price : " + adMostBannerResponseItem.FPValue);
    }

    public void destroy() {
        ArrayList<AdMostBannerResponseItem> arrayList = this.NetworkList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.NetworkList = null;
        ArrayList<AdMostBannerResponseItem> arrayList2 = this.NetworkListInHouse;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.NetworkListInHouse = null;
        ArrayList<AdMostBannerResponseItem> arrayList3 = this.NetworkListNotInWaterfall;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        this.NetworkListNotInWaterfall = null;
        this.zoneName = null;
        this.ZoneId = null;
        this.ZoneType = null;
        this.ZoneSize = null;
    }

    /* access modifiers changed from: package-private */
    public void enrichResponseItemWithZoneData(AdMostBannerResponseItem adMostBannerResponseItem) {
        String str;
        try {
            adMostBannerResponseItem.ZoneId = this.ZoneId;
            adMostBannerResponseItem.ZoneNFFcapTime = this.ZoneNffcTime;
            adMostBannerResponseItem.ZoneType = this.ZoneType;
            if (this.ZoneSize != null) {
                if (!this.ZoneSize.equals("null")) {
                    str = this.ZoneSize;
                    adMostBannerResponseItem.ZoneSize = Integer.parseInt(str);
                    adMostBannerResponseItem.ZoneFPResetThreshold = this.ZoneFPResetThreshold;
                    adMostBannerResponseItem.ZoneFPEnabled = this.FPEnabled;
                    adMostBannerResponseItem.SubZoneType = this.SubZoneType;
                    adMostBannerResponseItem.IsFirstRequestForNetwork = isFirstRequestForNetwork(adMostBannerResponseItem.Network);
                }
            }
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            adMostBannerResponseItem.ZoneSize = Integer.parseInt(str);
            adMostBannerResponseItem.ZoneFPResetThreshold = this.ZoneFPResetThreshold;
            adMostBannerResponseItem.ZoneFPEnabled = this.FPEnabled;
            adMostBannerResponseItem.SubZoneType = this.SubZoneType;
            adMostBannerResponseItem.IsFirstRequestForNetwork = isFirstRequestForNetwork(adMostBannerResponseItem.Network);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdMostBannerResponseItem getRandomItem(ArrayList<AdMostBannerResponseItem> arrayList, int i, int i2) throws Exception {
        int random = (!this.Randomize || i2 > 0) ? -1 : AdMostUtil.getRandom(i);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (!arrayList.get(i5).MarkedAsDeleted) {
                AdMostBannerResponseItem adMostBannerResponseItem = arrayList.get(i5);
                i4 += adMostBannerResponseItem.Weight;
                if (random < i4) {
                    if (random >= 0) {
                        adMostBannerResponseItem.WaterFallLogItem.isRandomItem = true;
                    }
                    if (adMostBannerResponseItem.FPEnabledItem.equals("1") || !this.FPEnabled) {
                        while (i3 < i5) {
                            if (arrayList.get(i3).MarkedAsDeleted || !arrayList.get(i3).Network.equals(adMostBannerResponseItem.Network) || ((!adMostBannerResponseItem.FPEnabledItem.equals("1") || !arrayList.get(i3).FPEnabledItem.equals("1")) && this.FPEnabled)) {
                                i3++;
                            } else {
                                arrayList.get(i3).MarkedAsDeleted = true;
                                arrayList.get(i3).WaterFallLogItem.isReplacedForRandomSelectedOtherOne = true;
                                return arrayList.get(i3);
                            }
                        }
                    }
                    arrayList.get(i5).MarkedAsDeleted = true;
                    return adMostBannerResponseItem;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.NetworkListInHouse;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r1.BiddingItems;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r1 = this;
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r1.NetworkList
            if (r0 == 0) goto L_0x000a
            int r0 = r0.size()
            if (r0 > 0) goto L_0x001f
        L_0x000a:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r1.NetworkListInHouse
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            if (r0 > 0) goto L_0x001f
        L_0x0014:
            java.util.ArrayList<admost.sdk.model.AdMostBannerResponseItem> r0 = r1.BiddingItems
            if (r0 == 0) goto L_0x0021
            int r0 = r0.size()
            if (r0 > 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r0 = 0
            goto L_0x0022
        L_0x0021:
            r0 = 1
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostBannerResponseBase.isEmpty():boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstRequestForNetwork(String str) {
        String str2 = this.FirstRequestNetworkList;
        if (str2 != null) {
            if (str2.contains("*" + str + "*")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isStatusSuitable(String str, boolean z) {
        if (str.equals(AdMostZonePlacementStatus.DISABLED)) {
            return false;
        }
        if (z || str.equals("enabled")) {
            return true;
        }
        if (str.equals(AdMostZonePlacementStatus.TESTER_ONLY)) {
            return AdMostLog.isEnabled();
        }
        if (str.equals(AdMostZonePlacementStatus.LIVE_ONLY)) {
            return !AdMostLog.isEnabled();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void logWaterfall() {
        if (AdMostLog.isEnabled()) {
            AdMostLog.m294d("Waterfall for zone " + this.ZoneId);
            ArrayList<AdMostBannerResponseItem> arrayList = this.NetworkList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                int i2 = 0;
                while (i2 < this.NetworkList.size()) {
                    i2++;
                    writeWaterfallLine(i2, this.NetworkList.get(i2));
                }
            }
            ArrayList<AdMostBannerResponseItem> arrayList2 = this.NetworkListInHouse;
            if (arrayList2 != null && arrayList2.size() > 0) {
                AdMostLog.m294d("--- PRIORITY > 11 ---");
                int i3 = 0;
                while (i3 < this.NetworkListInHouse.size()) {
                    i3++;
                    writeWaterfallLine(i3, this.NetworkListInHouse.get(i3));
                }
            }
            ArrayList<AdMostBannerResponseItem> arrayList3 = this.BiddingItems;
            if (arrayList3 != null && arrayList3.size() > 0) {
                AdMostLog.m294d("--- BIDDING ITEMS ---");
                while (i < this.BiddingItems.size()) {
                    i++;
                    writeWaterfallLine(i, this.BiddingItems.get(i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void prepareWaterfall(JSONObject jSONObject);

    public AdMostBannerResponseBase(JSONObject jSONObject, boolean z, boolean z2) {
        this.IsFirstRequestForZone = z;
        this.ForCache = z2;
        try {
            this.Result = jSONObject.optInt("Result", -1);
            this.FirstRequestNetworkList = jSONObject.optString(AdMostExperimentManager.FIRST_REQUEST_FOR_NETWORK, "");
            JSONObject optJSONObject = jSONObject.optJSONObject("Zone");
            if (optJSONObject != null) {
                this.FCapLoadThreshold = optJSONObject.optLong("FCapLoadThreshold", 0);
                this.zoneName = optJSONObject.optString("Name");
                this.ZoneId = optJSONObject.optString("Id");
                this.ZoneType = optJSONObject.optString("Type");
                this.SubZoneType = optJSONObject.optString("SubType", "");
                this.ZoneNffcTime = optJSONObject.optInt("NFFcapTime", 1);
                this.ZoneFcapDaily = optJSONObject.optInt("FcapD", -1);
                this.ZoneFcapHourly = optJSONObject.optInt("FcapH", -1);
                this.ZoneImpressionInterval = optJSONObject.optInt("ImpInt", -1);
                this.ZoneRandomizerBypassCount = optJSONObject.optInt("RBC", 0);
                this.ZoneRandomizerBypassInterval = optJSONObject.optInt("RBI", 0);
                this.ZoneSize = optJSONObject.optString("Size", "");
                this.ZoneRequestTimeout = optJSONObject.optInt("ReqTimeout", 0);
                this.ZoneOverallTimeout = optJSONObject.optInt("ZoneTimeout", 0);
                this.ZoneResponseTimeout = optJSONObject.optInt("WFResponseTimeout", 5000);
                this.RequestInterval = optJSONObject.optLong("ReqInterval", 0);
                if (this.ZoneRequestTimeout < 10) {
                    this.ZoneRequestTimeout *= 1000;
                }
                if (this.ZoneOverallTimeout < 10) {
                    this.ZoneOverallTimeout *= 1000;
                }
                this.RefreshInterval = optJSONObject.optInt("RefInt", 0);
                this.FPEnabled = optJSONObject.optBoolean("FPEnabled", false);
                this.ZoneFPResetThreshold = optJSONObject.optInt("FPDefaultResetThreshold", 0);
                this.AddPlacementsAboveLastECPM = optJSONObject.optBoolean("AddPlacementsAboveLastECPM", this.ZoneType.equals(AdMostZoneType.FULLSCREEN));
                this.SSVEnabled = optJSONObject.optBoolean("SSVEnabled", false);
                this.ApplicationId = optJSONObject.optString("AppId", "");
                this.DebugUserDataPercentage = optJSONObject.optInt("DebugUserDataPercentage", 0);
                this.RestrictUpper = optJSONObject.optBoolean("RestrictUpper", true);
                this.CustomNativeAdDuration = optJSONObject.optInt("CustomNativeAdDuration", 5);
            }
            prepareWaterfall(jSONObject);
            logWaterfall();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
