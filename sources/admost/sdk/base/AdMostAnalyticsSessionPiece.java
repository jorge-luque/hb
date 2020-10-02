package admost.sdk.base;

import com.facebook.appevents.UserDataStore;
import java.util.Locale;
import org.json.JSONObject;

public class AdMostAnalyticsSessionPiece {
    public long StartTime;
    public long StopTime;

    public AdMostAnalyticsSessionPiece() {
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{\"sr\":%d,\"st\":%d}", new Object[]{Long.valueOf(this.StartTime), Long.valueOf(this.StopTime)});
    }

    public String toString2nd() {
        return String.format(Locale.ENGLISH, "%d_%d", new Object[]{Long.valueOf(this.StartTime), Long.valueOf(this.StopTime)});
    }

    public AdMostAnalyticsSessionPiece(JSONObject jSONObject) {
        this.StartTime = jSONObject.optLong("StartTime", jSONObject.optLong("sr"));
        this.StopTime = jSONObject.optLong("StopTime", jSONObject.optLong(UserDataStore.STATE));
    }

    public AdMostAnalyticsSessionPiece(String str) {
        this.StartTime = Long.parseLong(str.split("\\_")[0]);
        this.StopTime = Long.parseLong(str.split("\\_")[1]);
    }
}
