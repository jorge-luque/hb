package admost.sdk.model;

import org.json.JSONObject;

public class AdMostAdPolicyItem {
    public int ActionDetail;
    public String ActionType;
    public long ActiveUntil;
    public String ItemId;

    public AdMostAdPolicyItem(JSONObject jSONObject) {
        this.ItemId = jSONObject.optString("Zone", jSONObject.optString("Tag", ""));
        this.ActionType = jSONObject.optString("ActionType");
        this.ActionDetail = jSONObject.optInt("ActionDetail");
        this.ActiveUntil = jSONObject.optLong("ActiveUntil", System.currentTimeMillis());
    }
}
