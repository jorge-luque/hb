package admost.sdk.model;

import admost.sdk.base.AdMostLog;
import com.facebook.appevents.AppEventsConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AdMostServerException extends Exception {
    public String ErrorCode = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String ErrorMessage = "";
    public int ServerResponseCode;

    public AdMostServerException(int i, String str) {
        AdMostLog.m303w("AdMostServerException : " + i + " response : " + str);
        this.ServerResponseCode = i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ErrorCode = jSONObject.optString("Error", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.ErrorMessage = jSONObject.optString("Message", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
