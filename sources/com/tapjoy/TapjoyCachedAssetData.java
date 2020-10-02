package com.tapjoy;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData implements Serializable {

    /* renamed from: a */
    private long f13152a;

    /* renamed from: b */
    private long f13153b;

    /* renamed from: c */
    private String f13154c;

    /* renamed from: d */
    private String f13155d;

    /* renamed from: e */
    private String f13156e;

    /* renamed from: f */
    private long f13157f;

    /* renamed from: g */
    private String f13158g;

    /* renamed from: h */
    private String f13159h;

    public TapjoyCachedAssetData(String str, String str2, long j) {
        this(str, str2, j, System.currentTimeMillis() / 1000);
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject jSONObject) {
        TapjoyCachedAssetData tapjoyCachedAssetData;
        try {
            tapjoyCachedAssetData = new TapjoyCachedAssetData(jSONObject.getString("assetURL"), jSONObject.getString("localFilePath"), jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE), jSONObject.getLong("timestamp"));
            try {
                tapjoyCachedAssetData.setOfferID(jSONObject.optString("offerID"));
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            tapjoyCachedAssetData = null;
            TapjoyLog.m16652i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
            return tapjoyCachedAssetData;
        }
        return tapjoyCachedAssetData;
    }

    public static TapjoyCachedAssetData fromRawJSONString(String str) {
        try {
            return fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            TapjoyLog.m16652i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public String getAssetURL() {
        return this.f13154c;
    }

    public String getLocalFilePath() {
        return this.f13155d;
    }

    public String getLocalURL() {
        return this.f13156e;
    }

    public String getMimeType() {
        return this.f13158g;
    }

    public String getOfferId() {
        return this.f13159h;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f13157f;
    }

    public long getTimeToLiveInSeconds() {
        return this.f13153b;
    }

    public long getTimestampInSeconds() {
        return this.f13152a;
    }

    public void resetTimeToLive(long j) {
        this.f13153b = j;
        this.f13157f = (System.currentTimeMillis() / 1000) + j;
    }

    public void setAssetURL(String str) {
        this.f13154c = str;
        this.f13158g = TapjoyUtil.determineMimeType(str);
    }

    public void setLocalFilePath(String str) {
        this.f13155d = str;
        this.f13156e = "file://" + str;
    }

    public void setOfferID(String str) {
        this.f13159h = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", getTimestampInSeconds());
            jSONObject.put(TapjoyConstants.TJC_TIME_TO_LIVE, getTimeToLiveInSeconds());
            jSONObject.put("assetURL", getAssetURL());
            jSONObject.put("localFilePath", getLocalFilePath());
            jSONObject.put("offerID", getOfferId());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toRawJSONString() {
        return toJSON().toString();
    }

    public String toString() {
        return "\nURL=" + this.f13156e + "\n" + "AssetURL=" + this.f13154c + "\n" + "MimeType=" + this.f13158g + "\n" + "Timestamp=" + getTimestampInSeconds() + "\n" + "TimeOfDeath=" + this.f13157f + "\n" + "TimeToLive=" + this.f13153b + "\n";
    }

    public TapjoyCachedAssetData(String str, String str2, long j, long j2) {
        setAssetURL(str);
        setLocalFilePath(str2);
        this.f13153b = j;
        this.f13152a = j2;
        this.f13157f = j2 + j;
    }
}
