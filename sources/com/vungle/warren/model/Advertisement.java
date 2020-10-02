package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.AdConfig;
import com.vungle.warren.analytics.AnalyticsEvent;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p113i.C3539s;

public class Advertisement {
    public static final int DONE = 3;
    public static final int ERROR = 4;
    private static final String FILE_SCHEME = "file://";
    public static final String KEY_POSTROLL = "postroll";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VIDEO = "video";
    public static final int LANDSCAPE = 1;
    public static final int NEW = 0;
    public static final int PORTRAIT = 0;
    public static final int READY = 1;
    static final String START_MUTED = "START_MUTED";
    private static final String TAG = "Advertisement";
    public static final int TYPE_VUNGLE_LOCAL = 0;
    public static final int TYPE_VUNGLE_MRAID = 1;
    private static final String UNKNOWN = "unknown";
    public static final int VIEWING = 2;
    AdConfig adConfig;
    String adMarketId;
    long adRequestStartTime;
    String adToken;
    @AdType
    int adType;
    String appID;
    long assetDownloadDuration;
    long assetDownloadStartTime;
    String bidToken;
    Map<String, Pair<String, String>> cacheableAssets = new HashMap();
    String campaign;
    List<Checkpoint> checkpoints;
    String[] clickUrls;
    String[] closeUrls;
    int countdown;
    boolean ctaClickArea = true;
    String ctaDestinationUrl;
    boolean ctaOverlayEnabled;
    String ctaUrl;
    int delay;
    boolean enableMoat;
    long expireTime;
    String identifier;
    String md5;
    String moatExtraVast;
    Map<String, String> mraidFiles = new HashMap();
    String[] muteUrls;
    String placementId;
    String[] postRollClickUrls;
    String[] postRollViewUrls;
    String postrollBundleUrl;
    boolean requiresNonMarketInstall;
    int retryCount;
    int showCloseDelay;
    int showCloseIncentivized;
    int state = 0;
    String templateId;
    Map<String, String> templateSettings;
    String templateType;
    String templateUrl;
    long ttDownload;
    String[] unmuteUrls;
    String[] videoClickUrls;
    int videoHeight;
    String videoIdentifier;
    String videoUrl;
    int videoWidth;

    public @interface AdType {
    }

    public @interface CacheKey {
    }

    public @interface Orientation {
    }

    public @interface State {
    }

    public static class Checkpoint implements Comparable<Checkpoint> {
        @SerializedName("percentage")
        private byte percentage;
        @SerializedName("urls")
        private String[] urls;

        public Checkpoint(JsonObject jsonObject) throws IllegalArgumentException {
            if (JsonUtil.hasNonNull(jsonObject, "checkpoint")) {
                this.percentage = (byte) ((int) (jsonObject.get("checkpoint").getAsFloat() * 100.0f));
                if (JsonUtil.hasNonNull(jsonObject, "urls")) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("urls");
                    this.urls = new String[asJsonArray.size()];
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        if (asJsonArray.get(i) == null || "null".equalsIgnoreCase(asJsonArray.get(i).toString())) {
                            this.urls[i] = "";
                        } else {
                            this.urls[i] = asJsonArray.get(i).getAsString();
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            throw new IllegalArgumentException("Checkpoint missing percentage!");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Checkpoint)) {
                return false;
            }
            Checkpoint checkpoint = (Checkpoint) obj;
            if (checkpoint.percentage != this.percentage || checkpoint.urls.length != this.urls.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.urls;
                if (i >= strArr.length) {
                    return true;
                }
                if (!checkpoint.urls[i].equals(strArr[i])) {
                    return false;
                }
                i++;
            }
        }

        public byte getPercentage() {
            return this.percentage;
        }

        public String[] getUrls() {
            return (String[]) this.urls.clone();
        }

        public int hashCode() {
            String[] strArr = this.urls;
            return (((this.percentage * 31) + strArr.length) * 31) + Arrays.hashCode(strArr);
        }

        public int compareTo(Checkpoint checkpoint) {
            return Float.compare((float) this.percentage, (float) checkpoint.percentage);
        }

        public Checkpoint(JsonArray jsonArray, byte b) {
            if (jsonArray.size() != 0) {
                this.urls = new String[jsonArray.size()];
                for (int i = 0; i < jsonArray.size(); i++) {
                    this.urls[i] = jsonArray.get(i).getAsString();
                }
                this.percentage = b;
                return;
            }
            throw new IllegalArgumentException("Empty URLS!");
        }
    }

    Advertisement() {
    }

    private boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && C3539s.m11859e(str) != null;
    }

    public void configure(AdConfig adConfig2) {
        if (adConfig2 == null) {
            this.adConfig = new AdConfig();
        } else {
            this.adConfig = adConfig2;
        }
    }

    public JsonObject createMRAIDArgs() {
        if (this.templateSettings != null) {
            HashMap hashMap = new HashMap(this.templateSettings);
            for (Map.Entry next : this.cacheableAssets.entrySet()) {
                hashMap.put(next.getKey(), ((Pair) next.getValue()).first);
            }
            if (!this.mraidFiles.isEmpty()) {
                hashMap.putAll(this.mraidFiles);
            }
            String str = "true";
            if (!str.equalsIgnoreCase((String) hashMap.get(START_MUTED))) {
                if ((getAdConfig().getSettings() & 1) == 0) {
                    str = "false";
                }
                hashMap.put(START_MUTED, str);
            }
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
            }
            return jsonObject;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!");
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement advertisement = (Advertisement) obj;
        if (advertisement.adType != this.adType || advertisement.delay != this.delay || advertisement.showCloseDelay != this.showCloseDelay || advertisement.showCloseIncentivized != this.showCloseIncentivized || advertisement.countdown != this.countdown || advertisement.videoWidth != this.videoWidth || advertisement.videoHeight != this.videoHeight || advertisement.ctaOverlayEnabled != this.ctaOverlayEnabled || advertisement.ctaClickArea != this.ctaClickArea || advertisement.retryCount != this.retryCount || advertisement.enableMoat != this.enableMoat || advertisement.requiresNonMarketInstall != this.requiresNonMarketInstall || advertisement.state != this.state || (str = advertisement.identifier) == null || (str2 = this.identifier) == null || !str.equals(str2) || !advertisement.campaign.equals(this.campaign) || !advertisement.videoUrl.equals(this.videoUrl) || !advertisement.md5.equals(this.md5) || !advertisement.postrollBundleUrl.equals(this.postrollBundleUrl) || !advertisement.ctaDestinationUrl.equals(this.ctaDestinationUrl) || !advertisement.ctaUrl.equals(this.ctaUrl) || !advertisement.adToken.equals(this.adToken) || !advertisement.videoIdentifier.equals(this.videoIdentifier) || !advertisement.moatExtraVast.equals(this.moatExtraVast) || !advertisement.adMarketId.equals(this.adMarketId) || !advertisement.bidToken.equals(this.bidToken) || advertisement.checkpoints.size() != this.checkpoints.size()) {
            return false;
        }
        for (int i = 0; i < this.checkpoints.size(); i++) {
            if (!advertisement.checkpoints.get(i).equals(this.checkpoints.get(i))) {
                return false;
            }
        }
        if (advertisement.muteUrls.length != this.muteUrls.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.muteUrls;
            if (i2 < strArr.length) {
                if (!advertisement.muteUrls[i2].equals(strArr[i2])) {
                    return false;
                }
                i2++;
            } else if (advertisement.unmuteUrls.length != this.unmuteUrls.length) {
                return false;
            } else {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.unmuteUrls;
                    if (i3 < strArr2.length) {
                        if (!advertisement.unmuteUrls[i3].equals(strArr2[i3])) {
                            return false;
                        }
                        i3++;
                    } else if (advertisement.closeUrls.length != this.closeUrls.length) {
                        return false;
                    } else {
                        int i4 = 0;
                        while (true) {
                            String[] strArr3 = this.closeUrls;
                            if (i4 < strArr3.length) {
                                if (!advertisement.closeUrls[i4].equals(strArr3[i4])) {
                                    return false;
                                }
                                i4++;
                            } else if (advertisement.postRollClickUrls.length != this.postRollClickUrls.length) {
                                return false;
                            } else {
                                int i5 = 0;
                                while (true) {
                                    String[] strArr4 = this.postRollClickUrls;
                                    if (i5 < strArr4.length) {
                                        if (!advertisement.postRollClickUrls[i5].equals(strArr4[i5])) {
                                            return false;
                                        }
                                        i5++;
                                    } else if (advertisement.postRollViewUrls.length != this.postRollViewUrls.length) {
                                        return false;
                                    } else {
                                        int i6 = 0;
                                        while (true) {
                                            String[] strArr5 = this.postRollViewUrls;
                                            if (i6 < strArr5.length) {
                                                if (!advertisement.postRollViewUrls[i6].equals(strArr5[i6])) {
                                                    return false;
                                                }
                                                i6++;
                                            } else if (advertisement.videoClickUrls.length != this.videoClickUrls.length) {
                                                return false;
                                            } else {
                                                int i7 = 0;
                                                while (true) {
                                                    String[] strArr6 = this.videoClickUrls;
                                                    if (i7 >= strArr6.length) {
                                                        return true;
                                                    }
                                                    if (!advertisement.videoClickUrls[i7].equals(strArr6[i7])) {
                                                        return false;
                                                    }
                                                    i7++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public AdConfig getAdConfig() {
        return this.adConfig;
    }

    public String getAdMarketId() {
        return this.adMarketId;
    }

    public String getAdToken() {
        return this.adToken;
    }

    @AdType
    public int getAdType() {
        return this.adType;
    }

    public String getAdvertiserAppId() {
        String appID2 = getAppID();
        String appID3 = getAppID();
        if (appID3 != null && appID3.length() > 3) {
            try {
                JSONObject jSONObject = new JSONObject(appID3.substring(3));
                appID2 = jSONObject.isNull("app_id") ? null : jSONObject.optString("app_id", (String) null);
            } catch (JSONException e) {
                Log.e(TAG, "JsonException : ", e);
            }
        }
        return TextUtils.isEmpty(appID2) ? "unknown" : appID2;
    }

    public String getAppID() {
        return this.appID;
    }

    public long getAssetDownloadDuration() {
        return this.assetDownloadDuration;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getCTAURL(boolean z) {
        int i = this.adType;
        if (i == 0) {
            return z ? this.ctaUrl : this.ctaDestinationUrl;
        }
        if (i == 1) {
            return this.ctaUrl;
        }
        throw new IllegalArgumentException("Unknown AdType " + this.adType);
    }

    public String getCampaign() {
        return this.campaign;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCampaignId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 1
            if (r1 < r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCampaignId():java.lang.String");
    }

    public List<Checkpoint> getCheckpoints() {
        return this.checkpoints;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCreativeId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 2
            if (r1 < r2) goto L_0x0018
            r1 = 1
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCreativeId():java.lang.String");
    }

    public boolean getCtaClickArea() {
        return this.ctaClickArea;
    }

    public Map<String, String> getDownloadableUrls() {
        HashMap hashMap = new HashMap();
        int i = this.adType;
        if (i == 0) {
            hashMap.put("video", this.videoUrl);
            if (!TextUtils.isEmpty(this.postrollBundleUrl)) {
                hashMap.put(KEY_POSTROLL, this.postrollBundleUrl);
            }
        } else if (i == 1) {
            hashMap.put("template", this.templateUrl);
            for (Map.Entry<String, Pair<String, String>> value : this.cacheableAssets.entrySet()) {
                String str = (String) ((Pair) value.getValue()).first;
                if (isValidUrl(str)) {
                    hashMap.put(URLUtil.guessFileName(str, (String) null, (String) null), str);
                }
            }
        } else {
            throw new IllegalStateException("Advertisement created without adType!");
        }
        return hashMap;
    }

    public long getExpireTime() {
        return this.expireTime * 1000;
    }

    public String getId() {
        String str = this.identifier;
        return str == null ? "" : str;
    }

    public boolean getMoatEnabled() {
        return this.enableMoat;
    }

    public String getMoatVastExtra() {
        return this.moatExtraVast;
    }

    @Orientation
    public int getOrientation() {
        return this.videoWidth > this.videoHeight ? 1 : 0;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getShowCloseDelay(boolean z) {
        int i;
        if (z) {
            i = this.showCloseIncentivized;
        } else {
            i = this.showCloseDelay;
        }
        return i * 1000;
    }

    @State
    public int getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        if (r12.equals("video.mute") != false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fc, code lost:
        if (r12.equals(com.vungle.warren.analytics.AnalyticsEvent.C5464Ad.videoClose) != false) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] getTpatUrls(java.lang.String r12) {
        /*
            r11 = this;
            int r0 = r11.adType
            r1 = 4
            r2 = 6
            r3 = 2
            r4 = 3
            r5 = 5
            java.lang.String r6 = "Unknown TPAT Event "
            java.lang.String r7 = "video_click"
            r8 = -1
            r9 = 0
            r10 = 1
            if (r0 == 0) goto L_0x00e4
            if (r0 != r10) goto L_0x00dc
            java.lang.String r0 = "checkpoint"
            boolean r0 = r12.startsWith(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String[] r0 = new java.lang.String[r9]
            java.lang.String r1 = "\\."
            java.lang.String[] r12 = r12.split(r1)
            r12 = r12[r10]
            int r12 = java.lang.Integer.parseInt(r12)
            java.util.List<com.vungle.warren.model.Advertisement$Checkpoint> r1 = r11.checkpoints
            int r12 = r12 / 25
            java.lang.Object r12 = r1.get(r12)
            com.vungle.warren.model.Advertisement$Checkpoint r12 = (com.vungle.warren.model.Advertisement.Checkpoint) r12
            if (r12 == 0) goto L_0x0038
            java.lang.String[] r0 = r12.getUrls()
        L_0x0038:
            return r0
        L_0x0039:
            int r0 = r12.hashCode()
            switch(r0) {
                case -1663300692: goto L_0x007b;
                case -1293192841: goto L_0x0071;
                case -481751803: goto L_0x0067;
                case -32221499: goto L_0x005d;
                case 906443463: goto L_0x0053;
                case 1370600644: goto L_0x004b;
                case 1621415126: goto L_0x0041;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0084
        L_0x0041:
            java.lang.String r0 = "postroll.view"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            r1 = 1
            goto L_0x0085
        L_0x004b:
            boolean r0 = r12.equals(r7)
            if (r0 == 0) goto L_0x0084
            r1 = 6
            goto L_0x0085
        L_0x0053:
            java.lang.String r0 = "clickUrl"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            r1 = 3
            goto L_0x0085
        L_0x005d:
            java.lang.String r0 = "video.close"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            r1 = 0
            goto L_0x0085
        L_0x0067:
            java.lang.String r0 = "video.unmute"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            r1 = 5
            goto L_0x0085
        L_0x0071:
            java.lang.String r0 = "postroll.click"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            r1 = 2
            goto L_0x0085
        L_0x007b:
            java.lang.String r0 = "video.mute"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r1 = -1
        L_0x0085:
            switch(r1) {
                case 0: goto L_0x00d3;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00b8;
                case 4: goto L_0x00af;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009d;
                default: goto L_0x0088;
            }
        L_0x0088:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        L_0x009d:
            java.lang.String[] r12 = r11.videoClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00a6:
            java.lang.String[] r12 = r11.unmuteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00af:
            java.lang.String[] r12 = r11.muteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00b8:
            java.lang.String[] r12 = r11.clickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00c1:
            java.lang.String[] r12 = r11.postRollClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00ca:
            java.lang.String[] r12 = r11.postRollViewUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00d3:
            java.lang.String[] r12 = r11.closeUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x00dc:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unknown Advertisement Type!"
            r12.<init>(r0)
            throw r12
        L_0x00e4:
            int r0 = r12.hashCode()
            switch(r0) {
                case -1964722632: goto L_0x0125;
                case -840405966: goto L_0x011b;
                case 3363353: goto L_0x0111;
                case 109635558: goto L_0x0107;
                case 1370600644: goto L_0x00ff;
                case 1370606900: goto L_0x00f6;
                case 1666667655: goto L_0x00ec;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            goto L_0x012f
        L_0x00ec:
            java.lang.String r0 = "postroll_view"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            r1 = 0
            goto L_0x0130
        L_0x00f6:
            java.lang.String r0 = "video_close"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            goto L_0x0130
        L_0x00ff:
            boolean r0 = r12.equals(r7)
            if (r0 == 0) goto L_0x012f
            r1 = 6
            goto L_0x0130
        L_0x0107:
            java.lang.String r0 = "postroll_click"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            r1 = 1
            goto L_0x0130
        L_0x0111:
            java.lang.String r0 = "mute"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            r1 = 2
            goto L_0x0130
        L_0x011b:
            java.lang.String r0 = "unmute"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            r1 = 3
            goto L_0x0130
        L_0x0125:
            java.lang.String r0 = "click_url"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x012f
            r1 = 5
            goto L_0x0130
        L_0x012f:
            r1 = -1
        L_0x0130:
            switch(r1) {
                case 0: goto L_0x017e;
                case 1: goto L_0x0175;
                case 2: goto L_0x016c;
                case 3: goto L_0x0163;
                case 4: goto L_0x015a;
                case 5: goto L_0x0151;
                case 6: goto L_0x0148;
                default: goto L_0x0133;
            }
        L_0x0133:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        L_0x0148:
            java.lang.String[] r12 = r11.videoClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0151:
            java.lang.String[] r12 = r11.clickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x015a:
            java.lang.String[] r12 = r11.closeUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0163:
            java.lang.String[] r12 = r11.unmuteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x016c:
            java.lang.String[] r12 = r11.muteUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x0175:
            java.lang.String[] r12 = r11.postRollClickUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        L_0x017e:
            java.lang.String[] r12 = r11.postRollViewUrls
            java.lang.Object r12 = r12.clone()
            java.lang.String[] r12 = (java.lang.String[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getTpatUrls(java.lang.String):java.lang.String[]");
    }

    public long getTtDownload() {
        return this.ttDownload;
    }

    /* access modifiers changed from: package-private */
    public String getUrl() {
        return this.videoUrl;
    }

    public boolean hasPostroll() {
        return !TextUtils.isEmpty(this.postrollBundleUrl);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.adType * 31) + this.identifier.hashCode()) * 31) + this.checkpoints.hashCode()) * 31) + Arrays.hashCode(this.muteUrls)) * 31) + Arrays.hashCode(this.unmuteUrls)) * 31) + Arrays.hashCode(this.closeUrls)) * 31) + Arrays.hashCode(this.postRollClickUrls)) * 31) + Arrays.hashCode(this.postRollViewUrls)) * 31) + Arrays.hashCode(this.videoClickUrls)) * 31) + this.delay) * 31) + this.campaign.hashCode()) * 31) + this.showCloseDelay) * 31) + this.showCloseIncentivized) * 31) + this.countdown) * 31) + this.videoUrl.hashCode()) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + this.md5.hashCode()) * 31) + this.postrollBundleUrl.hashCode()) * 31) + (this.ctaOverlayEnabled ? 1 : 0)) * 31) + (this.ctaClickArea ? 1 : 0)) * 31) + this.ctaDestinationUrl.hashCode()) * 31) + this.ctaUrl.hashCode()) * 31) + this.retryCount) * 31) + this.adToken.hashCode()) * 31) + this.videoIdentifier.hashCode()) * 31) + (this.enableMoat ? 1 : 0)) * 31) + this.moatExtraVast.hashCode()) * 31) + (this.requiresNonMarketInstall ? 1 : 0)) * 31) + this.adMarketId.hashCode()) * 31) + this.bidToken.hashCode()) * 31) + this.state;
    }

    public boolean isCtaOverlayEnabled() {
        return this.ctaOverlayEnabled;
    }

    public boolean isRequiresNonMarketInstall() {
        return this.requiresNonMarketInstall;
    }

    public void setAdRequestStartTime(long j) {
        this.adRequestStartTime = j;
    }

    public void setAssetDownloadStartTime(long j) {
        this.assetDownloadStartTime = j;
    }

    public void setFinishedDownloadingTime(long j) {
        this.assetDownloadDuration = j - this.assetDownloadStartTime;
        this.ttDownload = j - this.adRequestStartTime;
    }

    public void setMraidAssetDir(File file) {
        for (Map.Entry next : this.cacheableAssets.entrySet()) {
            String str = (String) ((Pair) next.getValue()).first;
            if (isValidUrl(str)) {
                File file2 = new File(file, URLUtil.guessFileName(str, (String) null, (String) null));
                if (file2.exists()) {
                    Map<String, String> map = this.mraidFiles;
                    Object key = next.getKey();
                    map.put(key, FILE_SCHEME + file2.getPath());
                }
            }
        }
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setState(@State int i) {
        this.state = i;
    }

    public String toString() {
        return "Advertisement{adType=" + this.adType + ", identifier='" + this.identifier + '\'' + ", appID='" + this.appID + '\'' + ", expireTime=" + this.expireTime + ", checkpoints=" + this.checkpoints + ", muteUrls=" + Arrays.toString(this.muteUrls) + ", unmuteUrls=" + Arrays.toString(this.unmuteUrls) + ", closeUrls=" + Arrays.toString(this.closeUrls) + ", postRollClickUrls=" + Arrays.toString(this.postRollClickUrls) + ", postRollViewUrls=" + Arrays.toString(this.postRollViewUrls) + ", videoClickUrls=" + Arrays.toString(this.videoClickUrls) + ", clickUrls=" + Arrays.toString(this.clickUrls) + ", delay=" + this.delay + ", campaign='" + this.campaign + '\'' + ", showCloseDelay=" + this.showCloseDelay + ", showCloseIncentivized=" + this.showCloseIncentivized + ", countdown=" + this.countdown + ", videoUrl='" + this.videoUrl + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", md5='" + this.md5 + '\'' + ", postrollBundleUrl='" + this.postrollBundleUrl + '\'' + ", ctaOverlayEnabled=" + this.ctaOverlayEnabled + ", ctaClickArea=" + this.ctaClickArea + ", ctaDestinationUrl='" + this.ctaDestinationUrl + '\'' + ", ctaUrl='" + this.ctaUrl + '\'' + ", adConfig=" + this.adConfig + ", retryCount=" + this.retryCount + ", adToken='" + this.adToken + '\'' + ", videoIdentifier='" + this.videoIdentifier + '\'' + ", templateUrl='" + this.templateUrl + '\'' + ", templateSettings=" + this.templateSettings + ", mraidFiles=" + this.mraidFiles + ", cacheableAssets=" + this.cacheableAssets + ", templateId='" + this.templateId + '\'' + ", templateType='" + this.templateType + '\'' + ", enableMoat=" + this.enableMoat + ", moatExtraVast='" + this.moatExtraVast + '\'' + ", requiresNonMarketInstall=" + this.requiresNonMarketInstall + ", adMarketId='" + this.adMarketId + '\'' + ", bidToken='" + this.bidToken + '\'' + ", state=" + this.state + '}';
    }

    public Advertisement(JsonObject jsonObject) throws IllegalArgumentException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (JsonUtil.hasNonNull(jsonObject, "ad_markup")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("ad_markup");
            if (JsonUtil.hasNonNull(asJsonObject, "adType")) {
                String asString = asJsonObject.get("adType").getAsString();
                char c = 65535;
                int hashCode = asString.hashCode();
                if (hashCode != -1852456483) {
                    if (hashCode == -1851445271 && asString.equals("vungle_mraid")) {
                        c = 1;
                    }
                } else if (asString.equals("vungle_local")) {
                    c = 0;
                }
                if (c == 0) {
                    this.adType = 0;
                    if (JsonUtil.hasNonNull(asJsonObject, "postBundle")) {
                        str9 = asJsonObject.get("postBundle").getAsString();
                    } else {
                        str9 = "";
                    }
                    this.postrollBundleUrl = str9;
                    if (JsonUtil.hasNonNull(asJsonObject, "url")) {
                        str10 = asJsonObject.get("url").getAsString();
                    } else {
                        str10 = "";
                    }
                    this.templateSettings = new HashMap();
                    this.templateUrl = "";
                    this.templateId = "";
                    this.templateType = "";
                } else if (c == 1) {
                    this.adType = 1;
                    this.postrollBundleUrl = "";
                    if (JsonUtil.hasNonNull(asJsonObject, "templateSettings")) {
                        this.templateSettings = new HashMap();
                        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("templateSettings");
                        if (JsonUtil.hasNonNull(asJsonObject2, "normal_replacements")) {
                            for (Map.Entry next : asJsonObject2.getAsJsonObject("normal_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                                    this.templateSettings.put(next.getKey(), (next.getValue() == null || ((JsonElement) next.getValue()).isJsonNull()) ? null : ((JsonElement) next.getValue()).getAsString());
                                }
                            }
                        }
                        if (JsonUtil.hasNonNull(asJsonObject2, "cacheable_replacements")) {
                            str = "";
                            for (Map.Entry next2 : asJsonObject2.getAsJsonObject("cacheable_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && next2.getValue() != null && JsonUtil.hasNonNull((JsonElement) next2.getValue(), "url") && JsonUtil.hasNonNull((JsonElement) next2.getValue(), ShareConstants.MEDIA_EXTENSION)) {
                                    String asString2 = ((JsonElement) next2.getValue()).getAsJsonObject().get("url").getAsString();
                                    this.cacheableAssets.put(next2.getKey(), new Pair(asString2, ((JsonElement) next2.getValue()).getAsJsonObject().get(ShareConstants.MEDIA_EXTENSION).getAsString()));
                                    if (((String) next2.getKey()).equalsIgnoreCase("MAIN_VIDEO")) {
                                        str = asString2;
                                    }
                                }
                            }
                        } else {
                            str = "";
                        }
                        if (JsonUtil.hasNonNull(asJsonObject, "templateId")) {
                            this.templateId = asJsonObject.get("templateId").getAsString();
                            if (JsonUtil.hasNonNull(asJsonObject, MessengerShareContentUtility.TEMPLATE_TYPE)) {
                                this.templateType = asJsonObject.get(MessengerShareContentUtility.TEMPLATE_TYPE).getAsString();
                                if (JsonUtil.hasNonNull(asJsonObject, "templateURL")) {
                                    this.templateUrl = asJsonObject.get("templateURL").getAsString();
                                } else {
                                    throw new IllegalArgumentException("Template URL missing!");
                                }
                            } else {
                                throw new IllegalArgumentException("Template Type missing!");
                            }
                        } else {
                            throw new IllegalArgumentException("Missing templateID!");
                        }
                    } else {
                        throw new IllegalArgumentException("Missing template adConfig!");
                    }
                } else {
                    throw new IllegalArgumentException("Unknown Ad Type " + asString + "! Please add this ad type");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.videoUrl = str;
                } else {
                    this.videoUrl = "";
                }
                if (JsonUtil.hasNonNull(asJsonObject, "id")) {
                    this.identifier = asJsonObject.get("id").getAsString();
                    if (JsonUtil.hasNonNull(asJsonObject, "campaign")) {
                        this.campaign = asJsonObject.get("campaign").getAsString();
                        if (JsonUtil.hasNonNull(asJsonObject, "app_id")) {
                            this.appID = asJsonObject.get("app_id").getAsString();
                            if (!JsonUtil.hasNonNull(asJsonObject, "expiry") || asJsonObject.get("expiry").isJsonNull()) {
                                this.expireTime = System.currentTimeMillis() / 1000;
                            } else {
                                long asLong = asJsonObject.get("expiry").getAsLong();
                                if (asLong > 0) {
                                    this.expireTime = asLong;
                                } else {
                                    this.expireTime = System.currentTimeMillis() / 1000;
                                }
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "tpat")) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("tpat");
                                this.checkpoints = new ArrayList(5);
                                int i = this.adType;
                                if (i != 0) {
                                    if (i == 1) {
                                        for (int i2 = 0; i2 < 5; i2++) {
                                            int i3 = i2 * 25;
                                            String format = String.format(Locale.ENGLISH, "checkpoint.%d", new Object[]{Integer.valueOf(i3)});
                                            this.checkpoints.add(i2, JsonUtil.hasNonNull(asJsonObject3, format) ? new Checkpoint(asJsonObject3.getAsJsonArray(format), (byte) i3) : null);
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Unknown Ad Type!");
                                    }
                                } else if (JsonUtil.hasNonNull(asJsonObject3, "play_percentage")) {
                                    JsonArray asJsonArray = asJsonObject3.getAsJsonArray("play_percentage");
                                    for (int i4 = 0; i4 < asJsonArray.size(); i4++) {
                                        if (asJsonArray.get(i4) != null) {
                                            this.checkpoints.add(new Checkpoint(asJsonArray.get(i4).getAsJsonObject()));
                                        }
                                    }
                                    Collections.sort(this.checkpoints);
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, "clickUrl")) {
                                    JsonArray asJsonArray2 = asJsonObject3.getAsJsonArray("clickUrl");
                                    this.clickUrls = new String[asJsonArray2.size()];
                                    Iterator<JsonElement> it = asJsonArray2.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        this.clickUrls[i5] = it.next().getAsString();
                                        i5++;
                                    }
                                } else {
                                    this.clickUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, "moat")) {
                                    JsonObject asJsonObject4 = asJsonObject3.getAsJsonObject("moat");
                                    this.enableMoat = asJsonObject4.get("is_enabled").getAsBoolean();
                                    this.moatExtraVast = asJsonObject4.get("extra_vast").getAsString();
                                } else {
                                    this.enableMoat = false;
                                    this.moatExtraVast = "";
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, AnalyticsEvent.C5464Ad.videoClick)) {
                                    JsonArray asJsonArray3 = asJsonObject3.getAsJsonArray(AnalyticsEvent.C5464Ad.videoClick);
                                    this.videoClickUrls = new String[asJsonArray3.size()];
                                    for (int i6 = 0; i6 < asJsonArray3.size(); i6++) {
                                        if (asJsonArray3.get(i6) == null || "null".equalsIgnoreCase(asJsonArray3.get(i6).toString())) {
                                            this.videoClickUrls[i6] = "";
                                        } else {
                                            this.videoClickUrls[i6] = asJsonArray3.get(i6).getAsString();
                                        }
                                    }
                                } else {
                                    this.videoClickUrls = new String[0];
                                }
                                int i7 = this.adType;
                                if (i7 == 0) {
                                    str8 = AnalyticsEvent.C5464Ad.mute;
                                    str7 = AnalyticsEvent.C5464Ad.unmute;
                                    str6 = AnalyticsEvent.C5464Ad.videoClose;
                                    str5 = AnalyticsEvent.C5464Ad.postrollClick;
                                    str4 = AnalyticsEvent.C5464Ad.postrollView;
                                } else if (i7 == 1) {
                                    str8 = "video.mute";
                                    str7 = "video.unmute";
                                    str6 = "video.close";
                                    str5 = "postroll.click";
                                    str4 = "postroll.view";
                                } else {
                                    throw new IllegalArgumentException("Unknown AdType!");
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str8)) {
                                    JsonArray asJsonArray4 = asJsonObject3.getAsJsonArray(str8);
                                    this.muteUrls = new String[asJsonArray4.size()];
                                    for (int i8 = 0; i8 < asJsonArray4.size(); i8++) {
                                        if (asJsonArray4.get(i8) == null || "null".equalsIgnoreCase(asJsonArray4.get(i8).toString())) {
                                            this.muteUrls[i8] = "";
                                        } else {
                                            this.muteUrls[i8] = asJsonArray4.get(i8).getAsString();
                                        }
                                    }
                                } else {
                                    this.muteUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str7)) {
                                    JsonArray asJsonArray5 = asJsonObject3.getAsJsonArray(str7);
                                    this.unmuteUrls = new String[asJsonArray5.size()];
                                    for (int i9 = 0; i9 < asJsonArray5.size(); i9++) {
                                        if (asJsonArray5.get(i9) == null || "null".equalsIgnoreCase(asJsonArray5.get(i9).toString())) {
                                            this.unmuteUrls[i9] = "";
                                        } else {
                                            this.unmuteUrls[i9] = asJsonArray5.get(i9).getAsString();
                                        }
                                    }
                                } else {
                                    this.unmuteUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str6)) {
                                    JsonArray asJsonArray6 = asJsonObject3.getAsJsonArray(str6);
                                    this.closeUrls = new String[asJsonArray6.size()];
                                    for (int i10 = 0; i10 < asJsonArray6.size(); i10++) {
                                        if (asJsonArray6.get(i10) == null || "null".equalsIgnoreCase(asJsonArray6.get(i10).toString())) {
                                            this.closeUrls[i10] = "";
                                        } else {
                                            this.closeUrls[i10] = asJsonArray6.get(i10).getAsString();
                                        }
                                    }
                                } else {
                                    this.closeUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str5)) {
                                    JsonArray asJsonArray7 = asJsonObject3.getAsJsonArray(str5);
                                    this.postRollClickUrls = new String[asJsonArray7.size()];
                                    for (int i11 = 0; i11 < asJsonArray7.size(); i11++) {
                                        if (asJsonArray7.get(i11) == null || "null".equalsIgnoreCase(asJsonArray7.get(i11).toString())) {
                                            this.postRollClickUrls[i11] = "";
                                        } else {
                                            this.postRollClickUrls[i11] = asJsonArray7.get(i11).getAsString();
                                        }
                                    }
                                } else {
                                    this.postRollClickUrls = new String[0];
                                }
                                if (JsonUtil.hasNonNull(asJsonObject3, str4)) {
                                    JsonArray asJsonArray8 = asJsonObject3.getAsJsonArray(str4);
                                    this.postRollViewUrls = new String[asJsonArray8.size()];
                                    for (int i12 = 0; i12 < asJsonArray8.size(); i12++) {
                                        if (asJsonArray8.get(i12) == null || "null".equalsIgnoreCase(asJsonArray8.get(i12).toString())) {
                                            this.postRollViewUrls[i12] = "";
                                        } else {
                                            this.postRollViewUrls[i12] = asJsonArray8.get(i12).getAsString();
                                        }
                                    }
                                } else {
                                    this.postRollViewUrls = new String[0];
                                }
                            } else {
                                this.checkpoints = new ArrayList();
                                this.muteUrls = new String[0];
                                this.closeUrls = new String[0];
                                this.unmuteUrls = new String[0];
                                this.postRollViewUrls = new String[0];
                                this.postRollClickUrls = new String[0];
                                this.clickUrls = new String[0];
                                this.videoClickUrls = new String[0];
                                this.enableMoat = false;
                                this.moatExtraVast = "";
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY)) {
                                this.delay = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY).getAsInt();
                            } else {
                                this.delay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showClose")) {
                                this.showCloseDelay = asJsonObject.get("showClose").getAsInt();
                            } else {
                                this.showCloseDelay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showCloseIncentivized")) {
                                this.showCloseIncentivized = asJsonObject.get("showCloseIncentivized").getAsInt();
                            } else {
                                this.showCloseIncentivized = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN)) {
                                this.countdown = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN).getAsInt();
                            } else {
                                this.countdown = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, TJAdUnitConstants.String.VIDEO_WIDTH)) {
                                this.videoWidth = asJsonObject.get(TJAdUnitConstants.String.VIDEO_WIDTH).getAsInt();
                                if (JsonUtil.hasNonNull(asJsonObject, TJAdUnitConstants.String.VIDEO_HEIGHT)) {
                                    this.videoHeight = asJsonObject.get(TJAdUnitConstants.String.VIDEO_HEIGHT).getAsInt();
                                    if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5)) {
                                        this.md5 = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5).getAsString();
                                    } else {
                                        this.md5 = "";
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "cta_overlay")) {
                                        JsonObject asJsonObject5 = asJsonObject.getAsJsonObject("cta_overlay");
                                        if (JsonUtil.hasNonNull(asJsonObject5, "enabled")) {
                                            this.ctaOverlayEnabled = asJsonObject5.get("enabled").getAsBoolean();
                                        } else {
                                            this.ctaOverlayEnabled = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject5, "click_area") && !asJsonObject5.get("click_area").getAsString().isEmpty() && asJsonObject5.get("click_area").getAsDouble() == 0.0d) {
                                            this.ctaClickArea = false;
                                        }
                                    } else {
                                        this.ctaOverlayEnabled = false;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionDest")) {
                                        str2 = asJsonObject.get("callToActionDest").getAsString();
                                    } else {
                                        str2 = "";
                                    }
                                    this.ctaDestinationUrl = str2;
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionUrl")) {
                                        str3 = asJsonObject.get("callToActionUrl").getAsString();
                                    } else {
                                        str3 = "";
                                    }
                                    this.ctaUrl = str3;
                                    if (JsonUtil.hasNonNull(asJsonObject, "retryCount")) {
                                        this.retryCount = asJsonObject.get("retryCount").getAsInt();
                                    } else {
                                        this.retryCount = 1;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN)) {
                                        this.adToken = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN).getAsString();
                                        if (JsonUtil.hasNonNull(asJsonObject, "video_object_id")) {
                                            this.videoIdentifier = asJsonObject.get("video_object_id").getAsString();
                                        } else {
                                            this.videoIdentifier = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "requires_sideloading")) {
                                            this.requiresNonMarketInstall = asJsonObject.get("requires_sideloading").getAsBoolean();
                                        } else {
                                            this.requiresNonMarketInstall = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_MARKET_ID)) {
                                            this.adMarketId = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_MARKET_ID).getAsString();
                                        } else {
                                            this.adMarketId = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN)) {
                                            this.bidToken = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN).getAsString();
                                        } else {
                                            this.bidToken = "";
                                        }
                                        this.adConfig = new AdConfig();
                                        return;
                                    }
                                    throw new IllegalArgumentException("AdToken missing!");
                                }
                                throw new IllegalArgumentException("Missing video height!");
                            }
                            throw new IllegalArgumentException("Missing video width!");
                        }
                        throw new IllegalArgumentException("Missing app Id, cannot process advertisement!");
                    }
                    throw new IllegalArgumentException("Missing campaign information, cannot process advertisement!");
                }
                throw new IllegalArgumentException("Missing identifier, cannot process advertisement!");
            }
            throw new IllegalArgumentException("Advertisement did not contain an adType!");
        }
        throw new IllegalArgumentException("JSON does not contain ad markup!");
    }
}
