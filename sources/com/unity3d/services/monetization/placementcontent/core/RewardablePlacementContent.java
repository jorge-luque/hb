package com.unity3d.services.monetization.placementcontent.core;

import admost.sdk.AdMostInterstitial;
import java.util.Map;

public class RewardablePlacementContent extends PlacementContent {
    private boolean isRewarded;
    private String rewardId;

    public RewardablePlacementContent(String str, Map<String, Object> map) {
        super(str, map);
        if (map.containsKey(AdMostInterstitial.ZONE_TYPE_REWARDED)) {
            this.isRewarded = ((Boolean) map.get(AdMostInterstitial.ZONE_TYPE_REWARDED)).booleanValue();
        }
        if (map.containsKey("rewardId")) {
            this.rewardId = (String) map.get("rewardId");
        }
    }

    public String getRewardId() {
        return this.rewardId;
    }

    public boolean isRewarded() {
        return this.isRewarded;
    }
}
