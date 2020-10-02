package admost.sdk.model;

import admost.sdk.base.AdMostAdNetwork;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostAdNetworkMeta implements Cloneable {
    private JSONObject BidConfig;
    private NetworkFloorPriceConfig FloorPrice;
    private boolean ForceInit;
    private boolean GoogleCertified = true;
    private int InitDuration;
    private String[] InitIds;
    private boolean IsExtraBoosterNetwork = true;
    private int MaxRequestCountPerWaterfall;
    private String Name;
    private boolean ShowConsentWindow;
    private boolean SoundMuted;
    private int UpCountOnPreCache;

    public class NetworkFloorPriceConfig implements Cloneable {
        public boolean Enabled;
        public int PlacementCount;

        public NetworkFloorPriceConfig(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.Enabled = jSONObject.optBoolean("Enabled", false);
                    this.PlacementCount = jSONObject.optInt("PlacementCount", 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void enrichWithExperimentJSON(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.Enabled = jSONObject.optBoolean("Enabled", this.Enabled);
                    this.PlacementCount = jSONObject.optInt("PlacementCount", this.PlacementCount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public AdMostAdNetworkMeta(JSONObject jSONObject) {
        try {
            this.Name = jSONObject.optString("Network", "");
            JSONArray jSONArray = jSONObject.getJSONArray("InitIDs");
            if (jSONArray != null && jSONArray.length() > 0) {
                this.InitIds = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.InitIds[i] = jSONArray.getString(i);
                }
            }
            this.ForceInit = jSONObject.optBoolean("ForcePreload", false);
            this.InitDuration = jSONObject.optInt("InitDuration", 0);
            this.ShowConsentWindow = jSONObject.optBoolean("ShowConsentWindow", false);
            this.MaxRequestCountPerWaterfall = jSONObject.optInt("MaxRequest", AdMostAdNetwork.hasBaseNetworkAdapter(AdMostAdNetwork.ADMOB, this.Name) ? 3 : 0);
            this.FloorPrice = new NetworkFloorPriceConfig(jSONObject.optJSONObject("FPConfig"));
            this.SoundMuted = jSONObject.optBoolean("SoundMuted", false);
            this.GoogleCertified = jSONObject.optBoolean("GoogleCertified", true);
            this.UpCountOnPreCache = jSONObject.optInt("UpCountOnPreCache", 0);
            this.IsExtraBoosterNetwork = jSONObject.optBoolean("IsExtraBoosterNetwork", true);
            this.BidConfig = jSONObject.optJSONObject("BidConfig");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        AdMostAdNetworkMeta adMostAdNetworkMeta = (AdMostAdNetworkMeta) super.clone();
        adMostAdNetworkMeta.FloorPrice = (NetworkFloorPriceConfig) this.FloorPrice.clone();
        if (this.BidConfig != null) {
            try {
                adMostAdNetworkMeta.BidConfig = new JSONObject(this.BidConfig.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adMostAdNetworkMeta;
    }

    public void enrichWithExperimentJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("InitIDs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.InitIds = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.InitIds[i] = optJSONArray.getString(i);
                    }
                }
                this.ForceInit = jSONObject.optBoolean("ForcePreload", this.ForceInit);
                this.InitDuration = jSONObject.optInt("InitDuration", this.InitDuration);
                this.ShowConsentWindow = jSONObject.optBoolean("ShowConsentWindow", this.ShowConsentWindow);
                this.MaxRequestCountPerWaterfall = jSONObject.optInt("MaxRequest", this.MaxRequestCountPerWaterfall);
                if (jSONObject.has("FPConfig")) {
                    this.FloorPrice.enrichWithExperimentJSON(jSONObject.optJSONObject("FPConfig"));
                }
                this.SoundMuted = jSONObject.optBoolean("SoundMuted", this.SoundMuted);
                this.GoogleCertified = jSONObject.optBoolean("GoogleCertified", this.GoogleCertified);
                this.UpCountOnPreCache = jSONObject.optInt("UpCountOnPreCache", this.UpCountOnPreCache);
                this.IsExtraBoosterNetwork = jSONObject.optBoolean("IsExtraBoosterNetwork", this.IsExtraBoosterNetwork);
                if (jSONObject.has("BidConfig")) {
                    this.BidConfig = jSONObject.optJSONObject("BidConfig");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject getBidConfig() {
        return this.BidConfig;
    }

    public NetworkFloorPriceConfig getFloorPrice() {
        return this.FloorPrice;
    }

    public String[] getInitIds() {
        return this.InitIds;
    }

    public int getMaxRequestCountPerWaterfall() {
        return this.MaxRequestCountPerWaterfall;
    }

    public String getName() {
        return this.Name;
    }

    public int getUpCountOnPreCache() {
        return this.UpCountOnPreCache;
    }

    public boolean isExtraBoosterNetwork() {
        return this.IsExtraBoosterNetwork;
    }

    public boolean isFloorPriceEnabled() {
        return this.FloorPrice.Enabled;
    }

    public boolean isForceInit() {
        return this.ForceInit;
    }

    public boolean isGoogleCertified() {
        return this.GoogleCertified;
    }

    public boolean isShowConsentWindow() {
        return this.ShowConsentWindow;
    }

    public boolean isSoundMuted() {
        return this.SoundMuted;
    }
}
