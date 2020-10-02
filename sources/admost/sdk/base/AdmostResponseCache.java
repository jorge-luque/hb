package admost.sdk.base;

import admost.sdk.base.AdMostGenericRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class AdmostResponseCache {
    private int duration;
    private long expireAt;
    private JSONObject jsonObject;
    private AdMostGenericRequest.RequestType requestType;
    private int status = 1;

    AdmostResponseCache(JSONObject jSONObject, long j, AdMostGenericRequest.RequestType requestType2, int i) {
        this.jsonObject = jSONObject;
        try {
            this.expireAt = j;
            this.requestType = requestType2;
            this.duration = i;
            jSONObject.put("expireAt", j);
            this.jsonObject.put("requestType", requestType2.name());
            this.jsonObject.put("status", 1);
            this.jsonObject.put("cacheDuration", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public int getCacheDuration() {
        return this.duration;
    }

    /* access modifiers changed from: package-private */
    public long getExpireAt() {
        return this.expireAt;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    /* access modifiers changed from: package-private */
    public AdMostGenericRequest.RequestType getRequestType() {
        return this.requestType;
    }

    /* access modifiers changed from: package-private */
    public int getStatus() {
        return this.status;
    }

    /* access modifiers changed from: package-private */
    public void setStatus(int i) {
        this.status = i;
    }

    AdmostResponseCache(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.jsonObject = jSONObject;
            this.expireAt = jSONObject.optLong("expireAt", 0);
            this.status = this.jsonObject.optInt("status", 1);
            this.requestType = AdMostGenericRequest.RequestType.valueOf(this.jsonObject.optString("requestType"));
            this.duration = this.jsonObject.optInt("cacheDuration", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
