package admost.sdk.base;

import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

public class AdMostAnalyticsSession {
    final long MAX_DURATION = 86400000;
    final long SESSION_TIMEOUT = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
    int SessionCount = 0;
    long SessionStartedAt;
    long SessionStoppedAt;
    long TotalDuration = 0;

    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("count", this.SessionCount);
            jSONObject.put("duration", this.TotalDuration);
            jSONObject.put("started_at", this.SessionStartedAt);
            jSONObject.put("stopped_at", this.SessionStoppedAt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void setData(JSONObject jSONObject) {
        try {
            this.SessionCount = jSONObject.optInt("count", 0);
            this.TotalDuration = jSONObject.optLong("duration", 0);
            this.SessionStartedAt = jSONObject.optLong("started_at", 0);
            this.SessionStoppedAt = jSONObject.optLong("stopped_at", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void startSessionAt(long j) {
        long j2 = this.SessionStoppedAt;
        if (j2 == 0 || j2 < j - TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            this.SessionCount++;
        }
        this.SessionStartedAt = j;
    }

    /* access modifiers changed from: package-private */
    public void stopSessionAt(long j) {
        long j2 = this.SessionStartedAt;
        if (j2 <= 0 || j < j2) {
            this.SessionStoppedAt = j;
            return;
        }
        long j3 = this.TotalDuration + (j - j2);
        this.TotalDuration = j3;
        if (j3 > 86400000) {
            j3 = 86400000;
        }
        this.TotalDuration = j3;
        this.SessionStoppedAt = j;
    }
}
