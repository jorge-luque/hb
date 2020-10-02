package admost.sdk.model;

import org.json.JSONObject;

public class FpDefaultItem {
    public String Placement;
    public String Status;
    public long UpdateTime;
    public int Weight;

    public FpDefaultItem(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Placement = jSONObject.optString("placement", "");
                this.Status = jSONObject.optString("status", "");
                this.Weight = jSONObject.optInt("weight", 0);
                this.UpdateTime = jSONObject.optLong("time", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
