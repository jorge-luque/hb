package com.vungle.warren;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

public class AdConfig {
    public static final int APK_DIRECT_DOWNLOAD = 32;
    public static final int AUTO_ROTATE = 2;
    public static final String FLAG_DIRECT_DOWNLOAD = "direct_download";
    public static final int IMMEDIATE_BACK = 2;
    public static final int IMMERSIVE = 4;
    public static final int LANDSCAPE = 1;
    public static final int MATCH_VIDEO = 3;
    public static final int MUTED = 1;
    public static final int PORTRAIT = 0;
    public static final int TRANSITION_ANIMATE = 8;
    @SerializedName("adOrientation")
    @Orientation
    private int adOrientation = 2;
    @SerializedName("adSize")
    private AdSize adSize = AdSize.VUNGLE_DEFAULT;
    @SerializedName("flexviewCloseSec")
    private int flexviewCloseSec;
    @SerializedName("ordinal")
    private int ordinal;
    @SerializedName("settings")
    private int settings;

    public @interface Orientation {
    }

    public @interface Settings {
    }

    @Keep
    public enum AdSize {
        VUNGLE_MREC("mrec", AdMost.AD_ERROR_FREQ_CAP, AdMostManager.AD_MEDIUM_RECTANGLE),
        VUNGLE_DEFAULT("default", -1, -1),
        BANNER("banner", 320, 50),
        BANNER_SHORT("banner_short", AdMost.AD_ERROR_FREQ_CAP, 50),
        BANNER_LEADERBOARD("banner_leaderboard", 728, 90);
        
        private final int height;
        private final String name;
        private final int width;

        private AdSize(String str, int i, int i2) {
            this.width = i;
            this.height = i2;
            this.name = str;
        }

        public static AdSize fromName(String str) {
            for (AdSize adSize : values()) {
                if (adSize.name.equals(str)) {
                    return adSize;
                }
            }
            return VUNGLE_DEFAULT;
        }

        public static boolean isBannerAdSize(AdSize adSize) {
            return adSize == BANNER || adSize == BANNER_LEADERBOARD || adSize == BANNER_SHORT;
        }

        public static boolean isDefaultAdSize(AdSize adSize) {
            return adSize == VUNGLE_DEFAULT || adSize == VUNGLE_MREC;
        }

        public int getHeight() {
            return this.height;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }
    }

    @Orientation
    public int getAdOrientation() {
        return this.adOrientation;
    }

    public AdSize getAdSize() {
        AdSize adSize2 = this.adSize;
        return adSize2 == null ? AdSize.VUNGLE_DEFAULT : adSize2;
    }

    public int getFlexViewCloseTime() {
        return this.flexviewCloseSec;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public int getSettings() {
        return this.settings;
    }

    public void setAdOrientation(@Orientation int i) {
        this.adOrientation = i;
    }

    public void setAdSize(AdSize adSize2) {
        this.adSize = adSize2;
    }

    public void setBackButtonImmediatelyEnabled(boolean z) {
        if (z) {
            this.settings |= 2;
        } else {
            this.settings &= -3;
        }
    }

    public void setFlexViewCloseTime(int i) {
        this.flexviewCloseSec = i;
    }

    public void setImmersiveMode(boolean z) {
        if (z) {
            this.settings |= 4;
        } else {
            this.settings &= -5;
        }
    }

    public void setMuted(boolean z) {
        if (z) {
            this.settings |= 1;
        } else {
            this.settings &= -2;
        }
    }

    public void setOrdinal(int i) {
        this.ordinal = i;
    }

    public void setTransitionAnimationEnabled(boolean z) {
        if (z) {
            this.settings |= 8;
        } else {
            this.settings &= -9;
        }
    }
}
