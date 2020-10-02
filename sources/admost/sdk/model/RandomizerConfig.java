package admost.sdk.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RandomizerConfig implements Cloneable {
    public ArrayList<RandomizerConfigParam> Parameters;

    public static class RandomizerConfigParam implements Cloneable {
        public int Multiplier;
        public int Percentage;

        public RandomizerConfigParam(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.Percentage = jSONObject.optInt("P", 0);
                    this.Multiplier = jSONObject.optInt("M", 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public RandomizerConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Parameters = new ArrayList<>();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Params");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.Parameters.add(new RandomizerConfigParam(jSONArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        RandomizerConfig randomizerConfig = (RandomizerConfig) super.clone();
        if (this.Parameters != null) {
            randomizerConfig.Parameters = new ArrayList<>();
            for (int i = 0; i < this.Parameters.size(); i++) {
                randomizerConfig.Parameters.add((RandomizerConfigParam) this.Parameters.get(i).clone());
            }
        }
        return randomizerConfig;
    }

    public void enrichWithExperimentJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Parameters = new ArrayList<>();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Params");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.Parameters.add(new RandomizerConfigParam(jSONArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
