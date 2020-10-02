package admost.sdk.model;

import admost.sdk.base.AdMostLog;
import org.json.JSONObject;

public class AdMostBiddingException extends Exception {
    public JSONObject response;
    public int serverResponseCode;

    public AdMostBiddingException(int i, JSONObject jSONObject) {
        AdMostLog.m303w("AdMostBiddingException : " + i + " response : " + jSONObject);
        this.serverResponseCode = i;
        this.response = jSONObject;
    }
}
