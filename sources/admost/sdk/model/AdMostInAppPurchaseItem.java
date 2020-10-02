package admost.sdk.model;

import admost.sdk.base.AdMostAnalyticsManager;
import admost.sdk.base.AdMostLog;
import com.facebook.appevents.AppEventsConstants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class AdMostInAppPurchaseItem {
    private static final ConcurrentHashMap<String, String> CURRENCY_MAP;
    public static final String SKU_TYPE_INAPP = "INAPP";
    public static final String SKU_TYPE_SUBS = "SUBS";
    private String amount;
    private String currency;
    private String iapTrackId;
    private boolean isDebug;
    private String postData;
    private String receipt;
    private AdMostServerException serverException;
    private String signature;
    private String skuType;
    private String[] tags;
    private boolean validationDisabled;

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(11);
        CURRENCY_MAP = concurrentHashMap;
        concurrentHashMap.put("CA", "CAD");
        CURRENCY_MAP.put("JP", "JPY");
        CURRENCY_MAP.put("GB", "GBP");
        CURRENCY_MAP.put("US", "USD");
        CURRENCY_MAP.put("AU", "AUD");
        CURRENCY_MAP.put("BR", "BRL");
        CURRENCY_MAP.put("DE", "EUR");
        CURRENCY_MAP.put("ES", "EUR");
        CURRENCY_MAP.put("FR", "EUR");
        CURRENCY_MAP.put("IN", "INR");
        CURRENCY_MAP.put("IT", "EUR");
    }

    public AdMostInAppPurchaseItem(String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2, String[] strArr) {
        this.receipt = str;
        this.signature = str2;
        this.amount = str3;
        this.currency = str4;
        this.isDebug = z;
        this.skuType = str6;
        this.validationDisabled = z2;
        this.tags = strArr;
        this.iapTrackId = str5;
        setPostData("android");
    }

    private void setPostData(String str) {
        String replace = this.receipt.replace("\"", "\\\"");
        String str2 = Float.valueOf(Float.parseFloat(this.amount)) + "";
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.tags;
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str3);
                sb.append("\"");
            }
        }
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[10];
        objArr[0] = AdMostAnalyticsManager.getInstance().getUserId();
        objArr[1] = str;
        objArr[2] = replace;
        objArr[3] = this.signature;
        objArr[4] = str2;
        objArr[5] = this.currency;
        objArr[6] = this.iapTrackId;
        String str4 = "1";
        objArr[7] = this.isDebug ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (!this.validationDisabled) {
            str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        objArr[8] = str4;
        objArr[9] = sb.toString();
        this.postData = String.format(locale, "{\"Id\":\"%s\",\"Store\":\"%s\",\"Receipt\":\"%s\",\"Signature\":\"%s\",\"Amount\":%s,\"Currency\":\"%s\",\"IapTrackId\":\"%s\",\"IsDebug\":\"%s\", \"IsValidationDisabled\":\"%s\", \"tags\":[%s]}", objArr);
        AdMostLog.m299i("IAP Request: " + this.postData);
    }

    public AdMostServerException getAmazonIAPError() {
        return this.serverException;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getPostData() {
        return this.postData;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setReceipt(String str) {
        this.receipt = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:44|45|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r6.serverException = new admost.sdk.model.AdMostServerException(110, "Client : First parameter error: Price can not converted to double..");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00e5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdMostInAppPurchaseItem(org.json.JSONObject r7, org.json.JSONObject r8, org.json.JSONObject r9, java.lang.String r10, boolean r11, java.lang.String r12) {
        /*
            r6 = this;
            r6.<init>()
            r6.isDebug = r11     // Catch:{ Exception -> 0x00fd }
            r6.skuType = r12     // Catch:{ Exception -> 0x00fd }
            r6.iapTrackId = r10     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "receiptId"
            java.lang.String r7 = r7.optString(r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "price"
            java.lang.String r9 = r9.optString(r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "USER_DATA"
            org.json.JSONObject r10 = r8.optJSONObject(r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r11 = "userData"
            java.lang.String r12 = "currencyCode"
            java.lang.String r0 = "marketplace"
            java.lang.String r1 = "userId"
            java.lang.String r2 = ""
            if (r10 == 0) goto L_0x0056
            java.lang.String r3 = r10.optString(r1)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r10.optString(r0, r2)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = r10.optString(r12, r2)     // Catch:{ Exception -> 0x00fd }
            boolean r5 = r3.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r5 != 0) goto L_0x0045
            boolean r5 = r4.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r5 == 0) goto L_0x0066
            boolean r5 = r10.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r5 == 0) goto L_0x0066
        L_0x0045:
            org.json.JSONObject r8 = r8.optJSONObject(r11)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r3 = r8.optString(r1)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r8.optString(r0)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = r8.optString(r12, r2)     // Catch:{ Exception -> 0x00fd }
            goto L_0x0066
        L_0x0056:
            org.json.JSONObject r8 = r8.optJSONObject(r11)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r3 = r8.optString(r1)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r8.optString(r0)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = r8.optString(r12, r2)     // Catch:{ Exception -> 0x00fd }
        L_0x0066:
            boolean r8 = r3.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r8 != 0) goto L_0x00f1
            boolean r8 = r4.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r8 == 0) goto L_0x007a
            boolean r8 = r10.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r8 == 0) goto L_0x007a
            goto L_0x00f1
        L_0x007a:
            boolean r8 = r7.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r8 == 0) goto L_0x008c
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00fd }
            r8 = 107(0x6b, float:1.5E-43)
            java.lang.String r9 = "Client : First parameter error: Missing Data: receiptId."
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00fd }
            r6.serverException = r7     // Catch:{ Exception -> 0x00fd }
            return
        L_0x008c:
            boolean r8 = r9.equals(r2)     // Catch:{ Exception -> 0x00fd }
            if (r8 == 0) goto L_0x009e
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00fd }
            r8 = 108(0x6c, float:1.51E-43)
            java.lang.String r9 = "Client : First parameter error: Missing Data: price."
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00fd }
            r6.serverException = r7     // Catch:{ Exception -> 0x00fd }
            return
        L_0x009e:
            java.lang.String r8 = "0123456789"
            r11 = 0
            r12 = 1
            java.lang.String r11 = r9.substring(r11, r12)     // Catch:{ Exception -> 0x00e5 }
            boolean r8 = r8.contains(r11)     // Catch:{ Exception -> 0x00e5 }
            if (r8 != 0) goto L_0x00b0
            java.lang.String r9 = r9.substring(r12)     // Catch:{ Exception -> 0x00e5 }
        L_0x00b0:
            admost.sdk.model.AdMostServerException r8 = r6.serverException     // Catch:{ Exception -> 0x00e5 }
            if (r8 != 0) goto L_0x010c
            boolean r8 = r10.equals(r2)     // Catch:{ Exception -> 0x00e5 }
            if (r8 == 0) goto L_0x00c3
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r8 = CURRENCY_MAP     // Catch:{ Exception -> 0x00e5 }
            java.lang.Object r8 = r8.get(r4)     // Catch:{ Exception -> 0x00e5 }
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x00e5 }
        L_0x00c3:
            if (r10 == 0) goto L_0x00d9
            boolean r8 = r10.equals(r2)     // Catch:{ Exception -> 0x00e5 }
            if (r8 != 0) goto L_0x00d9
            r6.currency = r10     // Catch:{ Exception -> 0x00e5 }
            r6.receipt = r7     // Catch:{ Exception -> 0x00e5 }
            r6.amount = r9     // Catch:{ Exception -> 0x00e5 }
            r6.signature = r3     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r7 = "amazon"
            r6.setPostData(r7)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x010c
        L_0x00d9:
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00e5 }
            r8 = 109(0x6d, float:1.53E-43)
            java.lang.String r9 = "Client : Marketplace Error: currency not find"
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00e5 }
            r6.serverException = r7     // Catch:{ Exception -> 0x00e5 }
            goto L_0x010c
        L_0x00e5:
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00fd }
            r8 = 110(0x6e, float:1.54E-43)
            java.lang.String r9 = "Client : First parameter error: Price can not converted to double.."
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00fd }
            r6.serverException = r7     // Catch:{ Exception -> 0x00fd }
            goto L_0x010c
        L_0x00f1:
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00fd }
            r8 = 106(0x6a, float:1.49E-43)
            java.lang.String r9 = "Client : Second parameter error: Missing Data: userId or marketplace."
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x00fd }
            r6.serverException = r7     // Catch:{ Exception -> 0x00fd }
            return
        L_0x00fd:
            r7 = move-exception
            r7.printStackTrace()
            admost.sdk.model.AdMostServerException r7 = new admost.sdk.model.AdMostServerException
            r8 = 105(0x69, float:1.47E-43)
            java.lang.String r9 = "Client : Unknown Error!"
            r7.<init>(r8, r9)
            r6.serverException = r7
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.model.AdMostInAppPurchaseItem.<init>(org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, java.lang.String, boolean, java.lang.String):void");
    }
}
