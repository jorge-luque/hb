package com.qumpara.offerwall.sdk.core;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QumparaOfferwallModels {

    public class ColorTypes {
        public static final int BUTTON_BACKGROUND_END = 2;
        public static final int BUTTON_BACKGROUND_START = 1;
        public static final int BUTTON_TEXT = 3;
        public static final int HEADER_BACKGROUND_END = 5;
        public static final int HEADER_BACKGROUND_START = 4;
        public static final int HEADER_TEXT = 6;

        public ColorTypes() {
        }
    }

    public static class MetaColor {
        /* access modifiers changed from: private */
        public String backgroundEnd;
        /* access modifiers changed from: private */
        public String backgroundStart;
        /* access modifiers changed from: private */
        public String foreground;

        public MetaColor(String str, String str2, String str3) {
            this.backgroundStart = str;
            this.backgroundEnd = str2;
            this.foreground = str3;
        }

        public String getBackgroundEnd() {
            return this.backgroundEnd;
        }

        public String getBackgroundStart() {
            return this.backgroundStart;
        }

        public String getForeground() {
            return this.foreground;
        }
    }

    public static class MetaData {
        private MetaColor button;
        private MetaColor header;
        private String helpUrl;
        private boolean isSSVEnabled;

        public MetaData(MetaColor metaColor, MetaColor metaColor2, String str, boolean z) {
            this.button = metaColor;
            this.header = metaColor2;
            this.helpUrl = str;
            this.isSSVEnabled = z;
        }

        public MetaColor getButton() {
            return this.button;
        }

        public MetaColor getHeader() {
            return this.header;
        }

        public String getHelpUrl() {
            return this.helpUrl;
        }

        public boolean isSSVEnabled() {
            return this.isSSVEnabled;
        }
    }

    public static class OfferwallItem {
        private String conditionText;
        private String customer;

        /* renamed from: id */
        private String f12876id;
        private String image;
        private String owDescription;
        private OfferwallItemPrize prize;
        private String redirectURL;

        public OfferwallItem(String str, String str2, String str3, String str4, String str5, OfferwallItemPrize offerwallItemPrize, String str6) {
            this.f12876id = str;
            this.conditionText = str2;
            this.image = str3;
            this.owDescription = str4;
            this.prize = offerwallItemPrize;
            this.customer = str5;
            this.redirectURL = str6;
        }

        public boolean equals(Object obj) {
            return ((OfferwallItem) obj).f12876id.equals(this.f12876id);
        }

        public String getConditionText() {
            return this.conditionText;
        }

        public String getCustomer() {
            return this.customer;
        }

        public String getId() {
            return this.f12876id;
        }

        public String getImage() {
            return this.image;
        }

        public String getOwDescription() {
            return this.owDescription;
        }

        public OfferwallItemPrize getPrize() {
            return this.prize;
        }

        public String getRedirectURL() {
            return this.redirectURL;
        }

        public void setRedirectURL(String str) {
            this.redirectURL = str;
        }
    }

    public static class OfferwallItemPrize {
        private PrizeAsset asset;
        private String headerName;

        /* renamed from: id */
        private String f12877id;
        private String image;
        private String name;

        public static class PrizeAsset {
            private String unit;
            private String value;

            public PrizeAsset(String str, String str2) {
                this.value = str;
                this.unit = str2;
            }

            public String getUnit() {
                return this.unit;
            }

            public String getValue() {
                return this.value;
            }

            public String getValueAsFormatted() {
                try {
                    return NumberFormat.getNumberInstance(Locale.US).format(Long.parseLong(this.value));
                } catch (Exception unused) {
                    return this.value;
                }
            }

            public String toString() {
                return getValueAsFormatted() + " " + this.unit;
            }
        }

        public OfferwallItemPrize(String str, String str2, String str3, String str4, PrizeAsset prizeAsset) {
            this.f12877id = str;
            this.image = str2;
            this.name = str3;
            this.headerName = str4;
            this.asset = prizeAsset;
        }

        public PrizeAsset getAsset() {
            return this.asset;
        }

        public String getHeaderName() {
            return this.headerName;
        }

        public String getId() {
            return this.f12877id;
        }

        public String getImage() {
            return this.image;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class OfferwallResponse {
        private MetaData meta;
        private ArrayList<OfferwallItem> offerwallItems;

        public OfferwallResponse(ArrayList<OfferwallItem> arrayList, MetaData metaData) {
            this.offerwallItems = arrayList;
            this.meta = metaData;
        }

        public String getColor(int i) {
            MetaColor metaColor;
            if (this.meta == null) {
                return null;
            }
            if (i == 1 || i == 2 || i == 3) {
                metaColor = this.meta.getButton();
            } else if (i == 4 || i == 5 || i == 6) {
                metaColor = this.meta.getHeader();
            } else {
                metaColor = null;
            }
            if (metaColor == null) {
                return null;
            }
            if (i == 1 || i == 4) {
                return metaColor.backgroundStart;
            }
            if (i == 2 || i == 5) {
                return metaColor.backgroundEnd;
            }
            return metaColor.foreground;
        }

        public MetaData getMeta() {
            return this.meta;
        }

        public ArrayList<OfferwallItem> getOfferwallItems() {
            return this.offerwallItems;
        }
    }

    public static class OfferwallStatus {
        public static final int VIRTUAL_CURRENCY_MIN_INTERVAL = 30000;
        private static OfferwallStatus mInstance;
        private boolean isEngagedBefore;
        private boolean isHelpClicked;
        private boolean isOfferwallOpened;
        private boolean isRedeemedBefore;
        private long lastVirtualCurrencySentAt;

        OfferwallStatus(boolean z, long j, boolean z2, boolean z3, boolean z4) {
            this.isOfferwallOpened = z;
            this.lastVirtualCurrencySentAt = j;
            this.isRedeemedBefore = z2;
            this.isEngagedBefore = z3;
            this.isHelpClicked = z4;
        }

        static synchronized OfferwallStatus getInstance() {
            synchronized (OfferwallStatus.class) {
                if (mInstance == null) {
                    String item = QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).getItem("KEY_QUMPARA_OFFERWALL_STATUS_JSON");
                    if (item != null && !item.equals("")) {
                        try {
                            JSONObject jSONObject = new JSONObject(item);
                            OfferwallStatus offerwallStatus = new OfferwallStatus(jSONObject.optBoolean("isOfferwallOpened"), jSONObject.optLong("lastVirtualCurrencySentAt"), jSONObject.optBoolean("isRedeemedBefore"), jSONObject.optBoolean("isEngagedBefore"), jSONObject.optBoolean("isHelpClicked"));
                            mInstance = offerwallStatus;
                            return offerwallStatus;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mInstance = new OfferwallStatus(false, 0, false, false, false);
                }
                OfferwallStatus offerwallStatus2 = mInstance;
                return offerwallStatus2;
            }
        }

        static synchronized boolean putInstance(OfferwallStatus offerwallStatus) {
            synchronized (OfferwallStatus.class) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isOfferwallOpened", offerwallStatus.isOfferwallOpened);
                    jSONObject.put("lastVirtualCurrencySentAt", offerwallStatus.lastVirtualCurrencySentAt);
                    jSONObject.put("isRedeemedBefore", offerwallStatus.isRedeemedBefore);
                    jSONObject.put("isEngagedBefore", offerwallStatus.isEngagedBefore);
                    jSONObject.put("isHelpClicked", offerwallStatus.isHelpClicked);
                    QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).putItem("KEY_QUMPARA_OFFERWALL_STATUS_JSON", jSONObject.toString());
                    mInstance = offerwallStatus;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }

        public static void setmInstance(OfferwallStatus offerwallStatus) {
            mInstance = offerwallStatus;
        }

        public long getLastVirtualCurrencySentAt() {
            return this.lastVirtualCurrencySentAt;
        }

        public boolean isEngagedBefore() {
            return this.isEngagedBefore;
        }

        public boolean isHelpClicked() {
            return this.isHelpClicked;
        }

        public boolean isOfferwallOpened() {
            return this.isOfferwallOpened;
        }

        public boolean isRedeemedBefore() {
            return this.isRedeemedBefore;
        }

        /* access modifiers changed from: package-private */
        public void resetStatus() {
            this.isOfferwallOpened = false;
            this.lastVirtualCurrencySentAt = 0;
            this.isRedeemedBefore = false;
            this.isEngagedBefore = false;
            this.isHelpClicked = false;
        }

        public void setEngagedBefore(boolean z) {
            this.isEngagedBefore = z;
        }

        public void setHelpClicked(boolean z) {
            this.isHelpClicked = z;
        }

        public void setLastVirtualCurrencySentAt(long j) {
            this.lastVirtualCurrencySentAt = j;
        }

        public void setOfferwallOpened(boolean z) {
            this.isOfferwallOpened = z;
        }

        public void setRedeemedBefore(boolean z) {
            this.isRedeemedBefore = z;
        }
    }

    public static class QumparaOfferwallError {
        private int code;
        private String message;

        public QumparaOfferwallError() {
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public String toString() {
            return "QumparaOfferwallError{code=" + this.code + ", message='" + this.message + '\'' + '}';
        }

        public QumparaOfferwallError(int i, String str) {
            this.message = str;
            this.code = i;
        }
    }

    public static class SpendVirtualCurrencyResponse {
        private ArrayList<OfferwallItemPrize> prizes;

        public SpendVirtualCurrencyResponse(ArrayList<OfferwallItemPrize> arrayList) {
            this.prizes = arrayList;
        }

        public static ArrayList<OfferwallItemPrize> mapJSONtoObject(JSONArray jSONArray) {
            ArrayList<OfferwallItemPrize> arrayList = new ArrayList<>();
            if (jSONArray == null) {
                return new ArrayList<>();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    String optString = jSONObject.optString(MessengerShareContentUtility.MEDIA_IMAGE, "");
                    String optString2 = jSONObject.optString("name", "");
                    String optString3 = jSONObject.optString("headerName", "");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("asset");
                    arrayList.add(new OfferwallItemPrize(string, optString, optString2, optString3, new OfferwallItemPrize.PrizeAsset(jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE), jSONObject2.getString("unit"))));
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }

        public ArrayList<OfferwallItemPrize> getPrizes() {
            return this.prizes;
        }
    }

    public static class Identifiers {
        private static Object lock = new Object();
        private static Identifiers mInstance;
        private String adjustId = "";
        private String admostId = "";
        private String applicationAdMostId = "";
        private String applicationId = "";
        private String applicationUserId = "notSet";
        private String idfa = "";

        public Identifiers(String str, String str2, String str3, String str4, String str5, String str6) {
            this.applicationId = str;
            this.adjustId = str2;
            this.admostId = str3;
            this.idfa = str4;
            this.applicationUserId = str5;
            this.applicationAdMostId = str6;
        }

        static Identifiers fromJSON(JSONObject jSONObject) {
            try {
                String optString = jSONObject.optString("applicationUserId", "notSet");
                return new Identifiers(jSONObject.optString("applicationId", ""), jSONObject.optString("adjustId", ""), jSONObject.optString("admostId", ""), jSONObject.optString(QumparaOfferwallUtil.COLUMN_IDFA, ""), optString, jSONObject.optString("applicationAdMostId", ""));
            } catch (Exception e) {
                e.printStackTrace();
                return new Identifiers();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            mInstance = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers getInstance() {
            /*
                com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = mInstance
                if (r0 != 0) goto L_0x003a
                java.lang.Object r1 = lock
                monitor-enter(r1)
                android.content.Context r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwall.getContext()     // Catch:{ Exception -> 0x002d }
                com.qumpara.offerwall.sdk.core.QumparaOfferwallPreferences r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallPreferences.getInstance(r0)     // Catch:{ Exception -> 0x002d }
                java.lang.String r2 = "KEY_OFFERWALL_IDENTIFIERS"
                java.lang.String r0 = r0.getItem(r2)     // Catch:{ Exception -> 0x002d }
                if (r0 != 0) goto L_0x001f
                com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers     // Catch:{ Exception -> 0x002d }
                r0.<init>()     // Catch:{ Exception -> 0x002d }
                mInstance = r0     // Catch:{ Exception -> 0x002d }
                goto L_0x0034
            L_0x001f:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x002d }
                r2.<init>(r0)     // Catch:{ Exception -> 0x002d }
                com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = fromJSON(r2)     // Catch:{ Exception -> 0x002d }
                mInstance = r0     // Catch:{ Exception -> 0x002d }
                goto L_0x0034
            L_0x002b:
                r0 = move-exception
                goto L_0x0038
            L_0x002d:
                com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers     // Catch:{ all -> 0x002b }
                r0.<init>()     // Catch:{ all -> 0x002b }
                mInstance = r0     // Catch:{ all -> 0x002b }
            L_0x0034:
                com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = mInstance     // Catch:{ all -> 0x002b }
                monitor-exit(r1)     // Catch:{ all -> 0x002b }
                return r0
            L_0x0038:
                monitor-exit(r1)     // Catch:{ all -> 0x002b }
                throw r0
            L_0x003a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers.getInstance():com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers");
        }

        static JSONObject toJSON(Identifiers identifiers) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("applicationUserId", identifiers.applicationUserId);
                jSONObject.put("applicationId", identifiers.applicationId);
                jSONObject.put("adjustId", identifiers.adjustId);
                jSONObject.put("admostId", identifiers.admostId);
                jSONObject.put("applicationAdMostId", identifiers.applicationAdMostId);
                jSONObject.put(QumparaOfferwallUtil.COLUMN_IDFA, identifiers.idfa);
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        static boolean updateInstance(Identifiers identifiers) {
            synchronized (lock) {
                try {
                    mInstance = identifiers;
                    QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).putItem("KEY_OFFERWALL_IDENTIFIERS", identifiers.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }

        public String getAdjustId() {
            return this.adjustId;
        }

        public String getAdmostId() {
            return this.admostId;
        }

        public String getApplicationAdMostId() {
            return this.applicationAdMostId;
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public String getApplicationUserId() {
            return this.applicationUserId;
        }

        public String getIdfa() {
            return this.idfa;
        }

        public void setApplicationAdMost(String str) {
            this.applicationAdMostId = str;
        }

        public void setApplicationId(String str) {
            this.applicationId = str;
        }

        public void setApplicationUserId(String str) {
            this.applicationUserId = str;
        }

        public void setIdfa(String str) {
            this.idfa = str;
        }

        public String toEngagementRecord(String str) {
            return String.format(Locale.ENGLISH, "{\"applicationId\":\"%s\",\"adjustId\":\"%s\",\"campaignId\":\"%s\",\"idfa\":\"%s\"}", new Object[]{this.applicationId, this.adjustId, str, this.idfa});
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("applicationUserId", this.applicationUserId);
                jSONObject.put("applicationId", this.applicationId);
                jSONObject.put("adjustId", this.adjustId);
                jSONObject.put("admostId", this.admostId);
                jSONObject.put("applicationAdMostId", this.applicationAdMostId);
                jSONObject.put(QumparaOfferwallUtil.COLUMN_IDFA, this.idfa);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject.toString();
            } catch (Throwable unused) {
                return jSONObject.toString();
            }
        }

        public Identifiers() {
        }
    }
}
