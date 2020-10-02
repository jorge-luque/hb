package admost.sdk.model;

import org.json.JSONObject;

public class AdMostNetworkItem {
    public static final int NUMBER_OF_ITEM = 17;
    public static final int TYPE_BID_FAIL_TO_LOAD = 16;
    public static final int TYPE_BID_FILL = 14;
    public static final int TYPE_BID_PRICE_FILL = 15;
    public static final int TYPE_BID_PRICE_IMP = 8;
    public static final int TYPE_BID_REQUEST = 11;
    public static final int TYPE_BID_TIMEOUT = 13;
    public static final int TYPE_BID_WON = 12;
    public static final int TYPE_BID_WON_ZONE = 17;
    public static final int TYPE_CLICK = 4;
    public static final int TYPE_COMPLETE = 9;
    public static final int TYPE_FAIL_TO_SHOW = 7;
    public static final int TYPE_FILLED = 3;
    public static final int TYPE_IMPRESSION = 2;
    public static final int TYPE_NO_FILL = 5;
    public static final int TYPE_REQUEST = 1;
    public static final int TYPE_REWARD = 10;
    public static final int TYPE_WEIGHT = 6;
    public int BID_FAIL_TO_LOAD = 0;
    public int BID_FILL = 0;
    public int BID_PRICE_FILL = 0;
    public int BID_PRICE_IMP = 0;
    public int BID_REQUEST = 0;
    public int BID_TIMEOUT = 0;
    public int BID_WON = 0;
    public int BID_WON_ZONE = 0;
    public int CLICK = 0;
    public int COMPLETE = 0;
    public int FAIL_TO_SHOW = 0;
    public int FILLED = 0;
    public int IMPRESSION = 0;
    public int NO_FILL = 0;
    public int REQUEST = 0;
    public int REWARD = 0;
    public int WEIGHT = 0;

    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im", this.IMPRESSION);
            jSONObject.put("rq", this.REQUEST);
            jSONObject.put("cl", this.CLICK);
            jSONObject.put("fl", this.FILLED);
            jSONObject.put("nfl", this.NO_FILL);
            jSONObject.put("w", this.WEIGHT);
            jSONObject.put("fts", this.FAIL_TO_SHOW);
            jSONObject.put("bp", this.BID_PRICE_IMP);
            jSONObject.put("bpf", this.BID_PRICE_FILL);
            jSONObject.put("cmp", this.COMPLETE);
            jSONObject.put("rew", this.REWARD);
            jSONObject.put("br", this.BID_REQUEST);
            jSONObject.put("bw", this.BID_WON);
            jSONObject.put("bwz", this.BID_WON_ZONE);
            jSONObject.put("bt", this.BID_TIMEOUT);
            jSONObject.put("bf", this.BID_FILL);
            jSONObject.put("bftl", this.BID_FAIL_TO_LOAD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void setData(JSONObject jSONObject) {
        try {
            this.IMPRESSION = jSONObject.optInt("im", 0);
            this.REQUEST = jSONObject.optInt("rq", 0);
            this.CLICK = jSONObject.optInt("cl", 0);
            this.FILLED = jSONObject.optInt("fl", 0);
            this.NO_FILL = jSONObject.optInt("nfl", 0);
            this.WEIGHT = jSONObject.optInt("w", 0);
            this.FAIL_TO_SHOW = jSONObject.optInt("fts", 0);
            this.BID_PRICE_IMP = jSONObject.optInt("bp", 0);
            this.BID_PRICE_FILL = jSONObject.optInt("bpf", 0);
            this.COMPLETE = jSONObject.optInt("cmp", 0);
            this.REWARD = jSONObject.optInt("rew", 0);
            this.BID_REQUEST = jSONObject.optInt("br", 0);
            this.BID_WON = jSONObject.optInt("bw", 0);
            this.BID_WON_ZONE = jSONObject.optInt("bwz", 0);
            this.BID_TIMEOUT = jSONObject.optInt("bt", 0);
            this.BID_FILL = jSONObject.optInt("bf", 0);
            this.BID_FAIL_TO_LOAD = jSONObject.optInt("bftl", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
