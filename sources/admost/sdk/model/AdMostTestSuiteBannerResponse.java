package admost.sdk.model;

import admost.sdk.base.AdMostUtil;
import admost.sdk.model.AdMostBannerResponseBase;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostTestSuiteBannerResponse extends AdMostBannerResponseBase {
    public AdMostTestSuiteBannerResponse(JSONObject jSONObject, boolean z, boolean z2) throws Exception {
        super(jSONObject, z, z2);
    }

    /* access modifiers changed from: package-private */
    public void prepareWaterfall(JSONObject jSONObject) {
        try {
            this.Randomize = AdMostUtil.checkRandomizerBypass(this);
            this.NetworkList = new ArrayList<>();
            this.NetworkListInHouse = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("Data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("Placements");
                        int optInt = jSONObject2.optInt("Priority", 0);
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                AdMostBannerResponseItem adMostBannerResponseItem = new AdMostBannerResponseItem(optJSONArray2.getJSONObject(i2));
                                if (isStatusSuitable(adMostBannerResponseItem.Status, true)) {
                                    enrichResponseItemWithZoneData(adMostBannerResponseItem);
                                    arrayList.add(adMostBannerResponseItem);
                                }
                            }
                            if (arrayList.size() > 1) {
                                Collections.sort(arrayList, new AdMostBannerResponseBase.CustomComparatorWeight());
                            }
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                if (optInt > 10) {
                                    this.NetworkListInHouse.add(arrayList.get(i3));
                                } else {
                                    this.NetworkList.add(arrayList.get(i3));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
