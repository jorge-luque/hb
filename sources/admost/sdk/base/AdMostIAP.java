package admost.sdk.base;

import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdMostIAPListener;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostInAppPurchaseItem;
import admost.sdk.model.AdMostServerException;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class AdMostIAP {
    private static AdMostIAP INSTANCE;
    /* access modifiers changed from: private */
    public final AtomicBoolean requestStarted = new AtomicBoolean();

    private AdMostIAP() {
    }

    private Set<String> getAllFromLocalStorage() {
        return AdMostPreferences.getInstance().getInAppPurchases();
    }

    public static AdMostIAP getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdMostIAP();
        }
        return INSTANCE;
    }

    /* access modifiers changed from: private */
    public void removeFromLocalStorage(String str) {
        AdMostPreferences.getInstance().removeInAppPurchase(str);
    }

    private void requestPostIAPDataToServer(final String str, final AdMostIAPListener adMostIAPListener, final String str2) {
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.IAP_TRACK, "", new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                Log.e(AdMostAdNetwork.ADMOST, "Something wrong while sending IAP data:" + str);
                if (exc == null) {
                    AdMostLog.m296e("Something wrong while sending IAP data:" + str);
                } else if (exc instanceof AdMostServerException) {
                    AdMostServerException adMostServerException = (AdMostServerException) exc;
                    if (adMostServerException.ErrorCode.equals("5")) {
                        AdMostLog.m298e("Public key for this app not entered on ADMOST dashboard" + str, exc, true);
                        adMostIAPListener.onException(str2);
                    } else if (adMostServerException.ErrorCode.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        AdMostLog.m298e("Couldn't insert in app record, will try it again" + str, exc, true);
                        adMostIAPListener.onException(str2);
                    } else {
                        AdMostLog.m298e("Something wrong while sending IAP data:" + str, exc, true);
                        adMostIAPListener.onValidationFail(str2, adMostServerException);
                    }
                } else {
                    adMostIAPListener.onException(str2);
                }
            }

            public void onResponse(JSONObject jSONObject) {
                Class<AdMostIAP> cls = AdMostIAP.class;
                AdMostLog.m299i(cls.getSimpleName() + ": [RESPONSE of TrackPurchase] onResponse = " + jSONObject.toString());
                try {
                    if (jSONObject.has("Country")) {
                        AdMostPreferences.getInstance().setCountry(jSONObject.getString("Country"));
                    }
                    if (jSONObject.has("ServerTime")) {
                        AdMostAnalyticsManager.getInstance().storeDeltaTime(jSONObject.getLong("ServerTime"));
                        adMostIAPListener.onValidationSuccess(str2);
                        AdMostPolicyManager.getInstance().setPolicyData(jSONObject);
                        return;
                    }
                    adMostIAPListener.onException(str2);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cls.getSimpleName());
                    sb.append(": trackPurchase : ");
                    sb.append(str);
                    sb.append(" response : ");
                    sb.append(jSONObject != null ? jSONObject.toString() : "");
                    AdMostLog.m298e(sb.toString(), e, true);
                    adMostIAPListener.onException(str2);
                }
            }
        }).mo611go(str);
    }

    private void requestPostSendIAPDataToServer(final String str, final AdmostResponseListener<JSONObject> admostResponseListener) {
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.IAP_SEND, "", new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                Log.e(AdMostAdNetwork.ADMOST, "Something wrong while sending IAP_SEND data:" + str);
                if (exc == null) {
                    AdMostLog.m296e("Something wrong while sending IAP data:" + str);
                    AdmostResponseListener admostResponseListener = admostResponseListener;
                    admostResponseListener.onError("Something wrong while sending IAP data : " + str, exc);
                } else if (exc instanceof AdMostServerException) {
                    String str2 = ((AdMostServerException) exc).ErrorCode;
                    if (str2.equals("3") || str2.equals("4")) {
                        AdMostLog.m298e("Something wrong while sending IAP data:" + str, exc, true);
                        admostResponseListener.onResponse(new JSONObject());
                        return;
                    }
                    AdMostLog.m298e("errorCode : " + str2 + " - " + str, exc, true);
                    AdmostResponseListener admostResponseListener2 = admostResponseListener;
                    admostResponseListener2.onError("errorCode : " + str2 + " - " + str, exc);
                } else {
                    admostResponseListener.onError(str, exc);
                }
            }

            public void onResponse(JSONObject jSONObject) {
                Class<AdMostIAP> cls = AdMostIAP.class;
                AdMostLog.m299i(cls.getSimpleName() + ": [RESPONSE of IAP_SEND] onResponse = " + jSONObject.toString());
                try {
                    if (jSONObject.has("Country")) {
                        AdMostPreferences.getInstance().setCountry(jSONObject.getString("Country"));
                    }
                    if (jSONObject.has("ServerTime")) {
                        AdMostAnalyticsManager.getInstance().storeDeltaTime(jSONObject.getLong("ServerTime"));
                        admostResponseListener.onResponse(jSONObject);
                        AdMostPolicyManager.getInstance().setPolicyData(jSONObject);
                        return;
                    }
                    admostResponseListener.onError("ServerTime not exists in request, will try again", (Exception) null);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cls.getSimpleName());
                    sb.append(": trackPurchase : ");
                    sb.append(str);
                    sb.append(" response : ");
                    sb.append(jSONObject != null ? jSONObject.toString() : "");
                    AdMostLog.m298e(sb.toString(), e, true);
                    admostResponseListener.onError("Response data is not in the correct format, will try again", e);
                }
            }
        }).mo611go(str);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendInAppPurchasesToServer() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.requestStarted
            r2 = 0
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x008a
            java.util.Set r1 = r8.getAllFromLocalStorage()
            if (r1 == 0) goto L_0x0085
            int r3 = r1.size()
            if (r3 != 0) goto L_0x0019
            goto L_0x0085
        L_0x0019:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Class<admost.sdk.base.AdMostIAP> r4 = admost.sdk.base.AdMostIAP.class
            java.lang.String r4 = r4.getSimpleName()
            r3.append(r4)
            java.lang.String r4 = " : Total ["
            r3.append(r4)
            int r4 = r1.size()
            r3.append(r4)
            java.lang.String r4 = "] IAP will be posted to server..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            admost.sdk.base.AdMostLog.m299i(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0043:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x008a
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = "IapTrackId"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = "IsValidationDisabled"
            java.lang.String r7 = "0"
            java.lang.String r4 = r4.optString(r6, r7)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = "1"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0071
        L_0x0069:
            r4 = move-exception
            goto L_0x006d
        L_0x006b:
            r4 = move-exception
            r5 = r0
        L_0x006d:
            r4.printStackTrace()
            r4 = 0
        L_0x0071:
            if (r4 == 0) goto L_0x007c
            admost.sdk.base.AdMostIAP$1 r4 = new admost.sdk.base.AdMostIAP$1
            r4.<init>(r3)
            r8.requestPostSendIAPDataToServer(r3, r4)
            goto L_0x0043
        L_0x007c:
            admost.sdk.base.AdMostIAP$2 r4 = new admost.sdk.base.AdMostIAP$2
            r4.<init>(r3)
            r8.requestPostIAPDataToServer(r3, r4, r5)
            goto L_0x0043
        L_0x0085:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.requestStarted
            r0.set(r2)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostIAP.sendInAppPurchasesToServer():void");
    }

    /* access modifiers changed from: package-private */
    public void storeInLocalStorage(AdMostInAppPurchaseItem adMostInAppPurchaseItem) {
        AdMostPreferences.getInstance().addInAppPurchase(adMostInAppPurchaseItem);
    }
}
