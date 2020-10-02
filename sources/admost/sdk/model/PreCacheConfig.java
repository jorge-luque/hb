package admost.sdk.model;

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreCacheConfig {
    public int BetterResultWaitDuration;
    public int MinimumScore;
    public int ParallelRequestCount;
    public Vector<String> Zones;

    public PreCacheConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ParallelRequestCount = jSONObject.optInt("ParallelReqCount", 0);
                this.MinimumScore = jSONObject.optInt("MinimumScore", 0);
                this.BetterResultWaitDuration = jSONObject.optInt("WaitDurationForResult", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("Zones");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.Zones = new Vector<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.Zones.add(optJSONArray.getString(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void enrichWithExperimentJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ParallelRequestCount = jSONObject.optInt("ParallelReqCount", this.ParallelRequestCount);
                this.MinimumScore = jSONObject.optInt("MinimumScore", this.MinimumScore);
                this.BetterResultWaitDuration = jSONObject.optInt("WaitDurationForResult", this.BetterResultWaitDuration);
                JSONArray optJSONArray = jSONObject.optJSONArray("Zones");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.Zones = new Vector<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.Zones.add(optJSONArray.getString(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
