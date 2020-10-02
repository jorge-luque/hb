package admost.sdk.model;

import org.json.JSONObject;

public class FloorPriceConfig implements Cloneable {
    public FirstRequestConfig FirstRequest;
    public int HeadIndexOnNoFill;
    public int LowerGap;
    public int TailIndexOnFill;
    public int UpperGap;

    public static class FirstRequestConfig implements Cloneable {
        public int Gap;
        public int TailIndexDefault;

        public FirstRequestConfig(JSONObject jSONObject) {
            if (jSONObject != null) {
                int i = 1;
                try {
                    this.TailIndexDefault = jSONObject.optInt("TailIndexDefault", 1);
                    int optInt = jSONObject.optInt("Gap", 3);
                    this.Gap = optInt;
                    if (optInt != 0) {
                        i = optInt;
                    }
                    this.Gap = i;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void enrichWithExperimentJSON(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.TailIndexDefault = jSONObject.optInt("TailIndexDefault", this.TailIndexDefault);
                    int optInt = jSONObject.optInt("Gap", this.Gap);
                    this.Gap = optInt;
                    if (optInt == 0) {
                        optInt = 1;
                    }
                    this.Gap = optInt;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FloorPriceConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            int i = 1;
            try {
                this.TailIndexOnFill = jSONObject.optInt("TailIndexOnFill", 1);
                this.HeadIndexOnNoFill = jSONObject.optInt("HeadIndexOnNoFill", 1);
                this.FirstRequest = new FirstRequestConfig(jSONObject.optJSONObject("FirstRequest"));
                this.UpperGap = jSONObject.optInt("UpperGap", 3);
                this.LowerGap = jSONObject.optInt("LowerGap", 2);
                this.UpperGap = this.UpperGap == 0 ? 1 : this.UpperGap;
                if (this.LowerGap != 0) {
                    i = this.LowerGap;
                }
                this.LowerGap = i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        FloorPriceConfig floorPriceConfig = (FloorPriceConfig) super.clone();
        floorPriceConfig.FirstRequest = (FirstRequestConfig) this.FirstRequest.clone();
        return floorPriceConfig;
    }

    public void enrichWithExperimentJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TailIndexOnFill = jSONObject.optInt("TailIndexOnFill", this.TailIndexOnFill);
                this.HeadIndexOnNoFill = jSONObject.optInt("HeadIndexOnNoFill", this.HeadIndexOnNoFill);
                this.FirstRequest.enrichWithExperimentJSON(jSONObject.optJSONObject("FirstRequest"));
                this.UpperGap = jSONObject.optInt("UpperGap", this.UpperGap);
                this.LowerGap = jSONObject.optInt("LowerGap", this.LowerGap);
                int i = 1;
                this.UpperGap = this.UpperGap == 0 ? 1 : this.UpperGap;
                if (this.LowerGap != 0) {
                    i = this.LowerGap;
                }
                this.LowerGap = i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
