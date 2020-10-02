package admost.sdk.base;

import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBannerResponseItem;
import admost.sdk.model.AdMostWaterfallLog;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import org.json.JSONObject;

public class AdMostAdStatsManager {
    private static AdMostAdStatsManager instance;
    private static final Object lock = new Object();
    private boolean initialized;
    private boolean isAdStatsEnabled;
    private final Vector<AdMostAdStatsPlacement> placementList = new Vector<>();
    /* access modifiers changed from: private */
    public boolean sendingData = false;
    private final Vector<AdMostAdStatsZone> zoneList = new Vector<>();
    private final Vector<AdMostAdStatsZoneShow> zoneShowList = new Vector<>();

    private static class AdMostAdStatsPlacement {
        private String fillType;
        private boolean isBiddingPlacement;
        /* access modifiers changed from: private */
        public boolean isFirstRequest;
        /* access modifiers changed from: private */
        public boolean isFirstSessionRequest;
        private String network;
        private String placementId;
        private long requestTime;
        private int weight;
        private String zoneId;

        AdMostAdStatsPlacement(AdMostBannerResponseItem adMostBannerResponseItem, String str, long j, boolean z, boolean z2, String str2) {
            this.fillType = str;
            this.isFirstRequest = z;
            this.isFirstSessionRequest = z2;
            this.requestTime = j;
            this.placementId = adMostBannerResponseItem.PlacementId;
            this.network = adMostBannerResponseItem.Network;
            this.weight = adMostBannerResponseItem.Weight;
            this.isBiddingPlacement = adMostBannerResponseItem.IsBiddingItem;
            this.zoneId = str2;
        }

        public String getHistogramIndex() {
            long j = this.requestTime;
            if (j < 51) {
                return "1";
            }
            if (j < 501) {
                return TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE;
            }
            if (j < 1001) {
                return "3";
            }
            if (j < 2001) {
                return "4";
            }
            if (j < 3001) {
                return "5";
            }
            if (j < 5001) {
                return "6";
            }
            if (j < 7501) {
                return "7";
            }
            return j < 10001 ? "8" : "9";
        }

        public String getJSONKey() {
            return String.format(Locale.ENGLISH, "\"PlacementID\": \"%s\",\"Network\": \"%s\",\"Weight\": %d,\"Type\": \"%s\",\"IsBidItem\": %b, \"ZoneId\": \"%s\"", new Object[]{this.placementId, this.network, Integer.valueOf(this.weight), this.fillType, Boolean.valueOf(this.isBiddingPlacement), this.zoneId});
        }
    }

    private static class AdMostAdStatsZone {
        private long WFResponseTime;
        private long bidResponseTime;

        /* renamed from: id */
        private String f250id;
        private boolean isFirstRequest;
        private boolean isFirstSessionRequest;
        private int networkReqCount;
        private long responseTime;
        private int totalReqCount;
        private String winnerNetwork;
        private String winnerPlacement;
        private int winnerWeight;
        private String wonType;
        private String zone;

        AdMostAdStatsZone(String str, String str2, AdMostBannerResponseItem adMostBannerResponseItem, boolean z, boolean z2, int i, int i2, long j, long j2, long j3) {
            this.isFirstRequest = z;
            this.f250id = str2;
            this.isFirstSessionRequest = z2;
            this.totalReqCount = i;
            this.networkReqCount = i2;
            this.responseTime = j;
            this.WFResponseTime = j2;
            this.bidResponseTime = j3;
            String str3 = "";
            this.winnerNetwork = adMostBannerResponseItem != null ? adMostBannerResponseItem.Network : str3;
            this.winnerPlacement = adMostBannerResponseItem != null ? adMostBannerResponseItem.PlacementId : str3;
            this.wonType = adMostBannerResponseItem != null ? adMostBannerResponseItem.IsBiddingItem ? "Bid" : "WF" : str3;
            this.winnerWeight = adMostBannerResponseItem != null ? adMostBannerResponseItem.Weight : 0;
            this.zone = str;
        }

        /* access modifiers changed from: package-private */
        public String toJSONString() {
            return String.format(Locale.ENGLISH, "{\"Id\": \"%s\",\"Zone\": \"%s\",\"Network\": \"%s\",\"PlacementID\": \"%s\",\"IsFirstRequest\": %b,\"IsFirstSessionRequest\": %b,\"RequestCount\": %d,\"WonType\": \"%s\",\"NetworkRequestCount\": %d,\"ResponseTime\": %d,\"WFResponseTime\": %d,\"BidResponseTime\": %d,\"Weight\": %d}", new Object[]{this.f250id, this.zone, this.winnerNetwork, this.winnerPlacement, Boolean.valueOf(this.isFirstRequest), Boolean.valueOf(this.isFirstSessionRequest), Integer.valueOf(this.totalReqCount), this.wonType, Integer.valueOf(this.networkReqCount), Long.valueOf(this.responseTime), Long.valueOf(this.WFResponseTime), Long.valueOf(this.bidResponseTime), Integer.valueOf(this.winnerWeight)});
        }
    }

    private static class AdMostAdStatsZoneShow {

        /* renamed from: id */
        private String f251id;
        private String tag;
        private String zone;

        AdMostAdStatsZoneShow(String str, String str2, String str3) {
            this.zone = str;
            this.f251id = str2;
            this.tag = str3;
        }

        /* access modifiers changed from: package-private */
        public String toJSONString() {
            return String.format(Locale.ENGLISH, "{\"Id\": \"%s\",\"tag\": \"%s\"}", new Object[]{this.f251id, this.tag});
        }
    }

    private AdMostAdStatsManager() {
        initialize();
    }

    public static AdMostAdStatsManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostAdStatsManager();
                }
            }
        }
        return instance;
    }

    private void initialize() {
        if (!this.initialized && AdMost.getInstance().isInitCompleted()) {
            this.isAdStatsEnabled = AdMost.getInstance().getConfiguration().isAdStatsEnabled();
            this.initialized = true;
        }
    }

    private boolean isStateAvailable() {
        if (!this.initialized) {
            initialize();
        }
        return this.initialized && this.isAdStatsEnabled;
    }

    private Hashtable preparePlacementJSON() {
        Hashtable hashtable = new Hashtable();
        Iterator<AdMostAdStatsPlacement> it = this.placementList.iterator();
        while (it.hasNext()) {
            AdMostAdStatsPlacement next = it.next();
            String jSONKey = next.getJSONKey();
            if (!hashtable.containsKey(jSONKey)) {
                hashtable.put(jSONKey, new Hashtable());
            }
            Hashtable hashtable2 = (Hashtable) hashtable.get(jSONKey);
            String str = (!next.isFirstRequest || !next.isFirstSessionRequest) ? next.isFirstSessionRequest ? "FirstNetworkSession" : "NetworkSession" : "FirstNetwork";
            if (!hashtable2.containsKey(str)) {
                hashtable2.put(str, new Hashtable());
            }
            Hashtable hashtable3 = (Hashtable) hashtable2.get(str);
            String histogramIndex = next.getHistogramIndex();
            if (!hashtable3.containsKey(histogramIndex)) {
                hashtable3.put(histogramIndex, 1);
            } else {
                hashtable3.put(histogramIndex, Integer.valueOf(((Integer) hashtable3.get(histogramIndex)).intValue() + 1));
            }
        }
        return hashtable;
    }

    public void sendData() {
        Hashtable preparePlacementJSON;
        if (isStateAvailable() && !this.sendingData) {
            this.sendingData = true;
            if (this.zoneList.size() > 0 || this.placementList.size() > 0 || this.zoneShowList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                synchronized (this.zoneList) {
                    Iterator<AdMostAdStatsZone> it = this.zoneList.iterator();
                    while (it.hasNext()) {
                        AdMostAdStatsZone next = it.next();
                        if (sb.length() > 1) {
                            sb.append(",");
                        }
                        sb.append(next.toJSONString());
                    }
                    this.zoneList.clear();
                }
                StringBuilder sb2 = new StringBuilder();
                synchronized (this.placementList) {
                    preparePlacementJSON = preparePlacementJSON();
                    this.placementList.clear();
                }
                String str = "";
                for (String str2 : preparePlacementJSON.keySet()) {
                    sb2.append(str);
                    sb2.append("{");
                    sb2.append(str2);
                    sb2.append(",");
                    Hashtable hashtable = (Hashtable) preparePlacementJSON.get(str2);
                    for (String str3 : hashtable.keySet()) {
                        sb2.append("\"");
                        sb2.append(str3);
                        sb2.append("\":{");
                        Hashtable hashtable2 = (Hashtable) hashtable.get(str3);
                        for (String str4 : hashtable2.keySet()) {
                            int intValue = ((Integer) hashtable2.get(str4)).intValue();
                            sb2.append("\"");
                            sb2.append(str4);
                            sb2.append("\":");
                            sb2.append(intValue);
                            sb2.append(",");
                        }
                        if (sb2.lastIndexOf(",") == sb2.length() - 1) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        sb2.append("},");
                    }
                    if (sb2.lastIndexOf(",") == sb2.length() - 1) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    sb2.append("}");
                    str = ",";
                }
                StringBuilder sb3 = new StringBuilder();
                synchronized (this.zoneShowList) {
                    Iterator<AdMostAdStatsZoneShow> it2 = this.zoneShowList.iterator();
                    while (it2.hasNext()) {
                        AdMostAdStatsZoneShow next2 = it2.next();
                        if (sb3.length() > 1) {
                            sb3.append(",");
                        }
                        sb3.append(next2.toJSONString());
                    }
                    this.zoneShowList.clear();
                }
                String format = String.format(Locale.ENGLISH, "{\"UserId\":\"%s\", \"AppId\":\"%s\", \"Country\":\"%s\", \"DateTime\":%d, \"Zones\":[%s],\"Placements\":[%s],\"Impressions\":[%s]}", new Object[]{AdMostAnalyticsManager.getInstance().getUserId(), AdMost.getInstance().getAppId(), AdMostPreferences.getInstance().getCountry(), Long.valueOf(AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer() / 1000), sb.toString(), sb2.toString(), sb3.toString()});
                new AdMostGenericRequest(AdMostGenericRequest.RequestType.TIMING_STATS, "", new AdmostResponseListener<JSONObject>() {
                    public void onError(String str, Exception exc) {
                        boolean unused = AdMostAdStatsManager.this.sendingData = false;
                    }

                    public void onResponse(JSONObject jSONObject) {
                        boolean unused = AdMostAdStatsManager.this.sendingData = false;
                    }
                }).mo611go(format);
                return;
            }
            this.sendingData = false;
        }
    }

    public void setPlacementRequestData(AdMostBannerResponseItem adMostBannerResponseItem, String str, boolean z, boolean z2, String str2) {
        if (isStateAvailable()) {
            long currentTimeMillis = System.currentTimeMillis();
            AdMostWaterfallLog adMostWaterfallLog = adMostBannerResponseItem.WaterFallLogItem;
            long j = currentTimeMillis - adMostWaterfallLog.triedAt;
            if (adMostWaterfallLog.requestCount > 1 && adMostWaterfallLog.responseCount > 1) {
                j = System.currentTimeMillis() - adMostBannerResponseItem.WaterFallLogItem.triedAt2;
            }
            AdMostAdStatsPlacement adMostAdStatsPlacement = new AdMostAdStatsPlacement(adMostBannerResponseItem, str, j, z, z2, str2);
            synchronized (this.placementList) {
                this.placementList.add(adMostAdStatsPlacement);
            }
        }
    }

    public void setZoneRequestData(String str, String str2, AdMostBannerResponseItem adMostBannerResponseItem, boolean z, boolean z2, int i, int i2, long j, long j2, long j3) {
        if (isStateAvailable()) {
            AdMostAdStatsZone adMostAdStatsZone = new AdMostAdStatsZone(str, str2, adMostBannerResponseItem, z, z2, i, i2, j, j2, j3);
            synchronized (this.zoneList) {
                this.zoneList.add(adMostAdStatsZone);
            }
        }
    }

    public void setZoneShowData(String str, String str2, String str3) {
        if (isStateAvailable()) {
            AdMostAdStatsZoneShow adMostAdStatsZoneShow = new AdMostAdStatsZoneShow(str, str2, str3);
            synchronized (this.zoneShowList) {
                this.zoneShowList.add(adMostAdStatsZoneShow);
            }
        }
    }
}
