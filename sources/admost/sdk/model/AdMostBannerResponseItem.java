package admost.sdk.model;

import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostExperimentManager;
import admost.sdk.base.AdMostZonePlacementStatus;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostBannerResponseItem implements Parcelable {
    public static final Parcelable.Creator<AdMostBannerResponseItem> CREATOR = new Parcelable.Creator<AdMostBannerResponseItem>() {
        public AdMostBannerResponseItem createFromParcel(Parcel parcel) {
            return new AdMostBannerResponseItem(parcel);
        }

        public AdMostBannerResponseItem[] newArray(int i) {
            return new AdMostBannerResponseItem[i];
        }
    };
    public int ADMLWeight;
    public int ActivePercentage;
    public int ActivePercentageOrigin;
    public String AdSpaceId;
    public boolean AlwaysInWaterfall;
    public String BaseNetwork;
    public double BidScore;
    public double BiddingPriceFromNetworkInCent;
    public boolean BypassFrequencyCappingOnSecondRun;
    public int CompletionReward;
    public ArrayList<String> ExcludedDevices;
    public StringBuilder ExcludedSdkVersions = new StringBuilder();
    public boolean FPDefault;
    public String FPEnabledItem;
    public boolean FPHead;
    public int FPValue;
    public int FcapD;
    public int FcapH;
    public int ImpressionInterval;
    public boolean InFPBoosterList;
    public boolean IsBiddingItem;
    public boolean IsBoostedItem;
    public boolean IsExtraBoosterNetwork;
    public boolean IsFirstRequestForNetwork;
    public boolean IsFirstSessionRequestForNetwork;
    public boolean IsTestItem;
    public int LifeTime;
    public int LocalCustomLayoutId;
    public boolean MarkedAsDeleted;
    public int MaxSdkVersion;
    public int MinSdkVersion;
    public int NFFcap;
    public String Network;
    public Hashtable<String, Object> NetworkData;
    public String PlacementId;
    public String PlacementName;
    public int Priority;
    public int PureWeight;
    public String Status;
    public String SubZoneType;
    public String Type;
    public AdMostWaterfallLog WaterFallLogItem = new AdMostWaterfallLog();
    public int Weight;
    public int WeightWithoutMultiplier;
    public boolean ZoneFPEnabled;
    public int ZoneFPResetThreshold;
    public String ZoneId;
    public int ZoneNFFcapTime;
    public int ZoneSize;
    public String ZoneType;

    public AdMostBannerResponseItem(JSONObject jSONObject) {
        this.ADMLWeight = jSONObject.optInt("AdMLWeight", 0);
        this.Weight = jSONObject.optInt("Weight", 0);
        this.FcapD = jSONObject.optInt("FcapD", -1);
        this.FcapH = jSONObject.optInt("FcapH", -1);
        this.ImpressionInterval = jSONObject.optInt("ImpInt", 0);
        boolean z = true;
        this.BypassFrequencyCappingOnSecondRun = jSONObject.optInt("BPFC2R", 1) == 1;
        this.Priority = jSONObject.optInt("Priority", 0);
        this.LifeTime = jSONObject.optInt("Lifetime", 30);
        this.Network = jSONObject.optString("Network");
        this.Type = jSONObject.optString("Type");
        this.PlacementId = jSONObject.optString("PlacementID");
        this.PlacementName = jSONObject.optString("PlacementName");
        this.AdSpaceId = jSONObject.optString("AdSpaceID");
        this.ZoneId = jSONObject.optString("ZoneID");
        this.ZoneType = jSONObject.optString("ZoneType");
        this.NFFcap = jSONObject.optInt("NFFcap", 0);
        this.ZoneNFFcapTime = jSONObject.optInt("NFFcapTime", 0);
        this.Status = jSONObject.optString("Status", "enabled");
        this.ZoneSize = jSONObject.optInt("ZoneSize", 50);
        this.IsTestItem = jSONObject.optBoolean("IsTestItem", false);
        this.MinSdkVersion = jSONObject.optInt("MinSdk", 0);
        this.MaxSdkVersion = jSONObject.optInt("MaxSdk", 0);
        int i = this.Weight;
        this.PureWeight = i;
        this.WeightWithoutMultiplier = i;
        this.FPEnabledItem = jSONObject.optString("FPEnabledItem", "");
        this.FPDefault = jSONObject.optBoolean("FPDefault", false);
        int optInt = jSONObject.optInt("FPValue", 0);
        this.FPValue = optInt;
        this.AlwaysInWaterfall = jSONObject.optBoolean("AlwaysInWaterfall", optInt != 0 ? false : z);
        this.ZoneFPResetThreshold = jSONObject.optInt("ZoneFPResetThreshold", 0);
        this.ZoneFPEnabled = jSONObject.optBoolean("ZoneFPEnabled", false);
        this.ActivePercentage = jSONObject.optInt("ActivePercentage", 0);
        this.ActivePercentageOrigin = jSONObject.optInt("ActivePercentageOrigin", 0);
        this.FPHead = jSONObject.optBoolean("FPHead", false);
        this.BidScore = (double) jSONObject.optInt("BidScore", 100);
        for (Map.Entry next : AdMostAdNetwork.childParentNetworkMap.entrySet()) {
            if (!this.Network.equals("") && ((String) next.getKey()).equals(this.Network)) {
                this.BaseNetwork = (String) next.getValue();
            }
        }
        if (jSONObject.has(AdMostExperimentManager.EXPERIMENT_REMOVED_PLACEMENT)) {
            this.Status = AdMostZonePlacementStatus.DISABLED;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("ExclSdks");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    StringBuilder sb = this.ExcludedSdkVersions;
                    sb.append("#");
                    sb.append(((Integer) optJSONArray.get(i2)).intValue());
                    sb.append("#");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ExclDvcs");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.ExcludedDevices = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    Object opt = optJSONArray2.opt(i3);
                    if ((opt instanceof String) && !opt.equals("")) {
                        this.ExcludedDevices.add(((String) opt).toLowerCase(Locale.ENGLISH));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.PlacementId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof admost.sdk.model.AdMostBannerResponseItem
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = r1.PlacementId
            if (r0 == 0) goto L_0x0014
            admost.sdk.model.AdMostBannerResponseItem r2 = (admost.sdk.model.AdMostBannerResponseItem) r2
            java.lang.String r2 = r2.PlacementId
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostBannerResponseItem.equals(java.lang.Object):boolean");
    }

    public String getExcludedDeviceName() {
        return (Build.BRAND + " " + Build.MODEL).toLowerCase(Locale.ENGLISH);
    }

    public boolean isExludedDevice() {
        ArrayList<String> arrayList = this.ExcludedDevices;
        if (!(arrayList == null || arrayList.size() == 0)) {
            String excludedDeviceName = getExcludedDeviceName();
            for (int i = 0; i < this.ExcludedDevices.size(); i++) {
                if (excludedDeviceName.equals(this.ExcludedDevices.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return " Network: " + this.Network + " PlacementId: " + this.PlacementId + " PlacementName: " + this.PlacementName + " Type: " + this.Type + " ZoneId: " + this.ZoneId + " Ecpm: " + this.PureWeight + " Weight_Without_Multiplier: " + this.WeightWithoutMultiplier;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ADMLWeight);
        parcel.writeInt(this.Weight);
        parcel.writeInt(this.FcapD);
        parcel.writeInt(this.FcapH);
        parcel.writeInt(this.ImpressionInterval);
        parcel.writeByte(this.BypassFrequencyCappingOnSecondRun ? (byte) 1 : 0);
        parcel.writeInt(this.Priority);
        parcel.writeInt(this.LifeTime);
        parcel.writeInt(this.NFFcap);
        parcel.writeString(this.Network);
        parcel.writeString(this.Type);
        parcel.writeString(this.PlacementId);
        parcel.writeString(this.PlacementName);
        parcel.writeString(this.AdSpaceId);
        parcel.writeString(this.ZoneId);
        parcel.writeInt(this.ZoneNFFcapTime);
        parcel.writeString(this.ZoneType);
        parcel.writeString(this.Status);
        parcel.writeInt(this.ZoneSize);
        parcel.writeByte(this.IsTestItem ? (byte) 1 : 0);
        parcel.writeInt(this.MinSdkVersion);
        parcel.writeInt(this.MaxSdkVersion);
        parcel.writeInt(this.LocalCustomLayoutId);
        parcel.writeInt(this.PureWeight);
        parcel.writeInt(this.WeightWithoutMultiplier);
        parcel.writeString(this.FPEnabledItem);
        parcel.writeByte(this.FPDefault ? (byte) 1 : 0);
        parcel.writeByte(this.AlwaysInWaterfall ? (byte) 1 : 0);
        parcel.writeInt(this.FPValue);
        parcel.writeInt(this.ZoneFPResetThreshold);
        parcel.writeByte(this.ZoneFPEnabled ? (byte) 1 : 0);
        parcel.writeInt(this.ActivePercentage);
        parcel.writeInt(this.ActivePercentageOrigin);
        parcel.writeByte(this.FPHead ? (byte) 1 : 0);
        parcel.writeByte(this.MarkedAsDeleted ? (byte) 1 : 0);
        parcel.writeByte(this.IsFirstRequestForNetwork ? (byte) 1 : 0);
        parcel.writeByte(this.IsFirstSessionRequestForNetwork ? (byte) 1 : 0);
        parcel.writeByte(this.InFPBoosterList ? (byte) 1 : 0);
        parcel.writeByte(this.IsBoostedItem ? (byte) 1 : 0);
        parcel.writeByte(this.IsExtraBoosterNetwork ? (byte) 1 : 0);
        parcel.writeParcelable(this.WaterFallLogItem, i);
        parcel.writeString(this.BaseNetwork);
        parcel.writeDouble(this.BidScore);
        parcel.writeByte(this.IsBiddingItem ? (byte) 1 : 0);
        parcel.writeDouble(this.BiddingPriceFromNetworkInCent);
    }

    protected AdMostBannerResponseItem(Parcel parcel) {
        this.ADMLWeight = parcel.readInt();
        this.Weight = parcel.readInt();
        this.FcapD = parcel.readInt();
        this.FcapH = parcel.readInt();
        this.ImpressionInterval = parcel.readInt();
        boolean z = true;
        this.BypassFrequencyCappingOnSecondRun = parcel.readByte() != 0;
        this.Priority = parcel.readInt();
        this.LifeTime = parcel.readInt();
        this.NFFcap = parcel.readInt();
        this.Network = parcel.readString();
        this.Type = parcel.readString();
        this.PlacementId = parcel.readString();
        this.PlacementName = parcel.readString();
        this.AdSpaceId = parcel.readString();
        this.ZoneId = parcel.readString();
        this.ZoneNFFcapTime = parcel.readInt();
        this.ZoneType = parcel.readString();
        this.Status = parcel.readString();
        this.ZoneSize = parcel.readInt();
        this.IsTestItem = parcel.readByte() != 0;
        this.MinSdkVersion = parcel.readInt();
        this.MaxSdkVersion = parcel.readInt();
        this.LocalCustomLayoutId = parcel.readInt();
        this.PureWeight = parcel.readInt();
        this.WeightWithoutMultiplier = parcel.readInt();
        this.FPEnabledItem = parcel.readString();
        this.FPDefault = parcel.readByte() != 0;
        this.AlwaysInWaterfall = parcel.readByte() != 0;
        this.FPValue = parcel.readInt();
        this.ZoneFPResetThreshold = parcel.readInt();
        this.ZoneFPEnabled = parcel.readByte() != 0;
        this.ActivePercentage = parcel.readInt();
        this.ActivePercentageOrigin = parcel.readInt();
        this.FPHead = parcel.readByte() != 0;
        this.MarkedAsDeleted = parcel.readByte() != 0;
        this.IsFirstRequestForNetwork = parcel.readByte() != 0;
        this.IsFirstSessionRequestForNetwork = parcel.readByte() != 0;
        this.InFPBoosterList = parcel.readByte() != 0;
        this.IsBoostedItem = parcel.readByte() != 0;
        this.IsExtraBoosterNetwork = parcel.readByte() != 0;
        this.WaterFallLogItem = (AdMostWaterfallLog) parcel.readParcelable(AdMostWaterfallLog.class.getClassLoader());
        this.BaseNetwork = parcel.readString();
        this.BidScore = parcel.readDouble();
        this.IsBiddingItem = parcel.readByte() == 0 ? false : z;
        this.BiddingPriceFromNetworkInCent = parcel.readDouble();
    }
}
