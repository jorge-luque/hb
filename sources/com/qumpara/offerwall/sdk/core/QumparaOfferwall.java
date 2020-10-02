package com.qumpara.offerwall.sdk.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.drive.DriveFile;
import com.qumpara.analytics.BuildConfig;
import com.qumpara.analytics.QumparaAnalytics;
import com.qumpara.offerwall.sdk.core.QumparaGenericRequest;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallAdvertisingIdListener;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallInitListener;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallListener;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallVirtualCurrencyListener;
import java.net.URLEncoder;
import java.util.Observable;
import java.util.Observer;

public class QumparaOfferwall extends QumparaOfferwallAPI {
    public static final int AD_ERR_ENGAGEMENT_FAIL = 1005;
    public static final int AD_ERR_FAIL_TO_SHOW = 1002;
    public static final int AD_ERR_INIT_PARAMETERS = 1009;
    public static final int AD_ERR_ITEM_DETAIL_FAIL = 1004;
    public static final int AD_ERR_LOCAL_SDK = 100;
    public static final int AD_ERR_NO_ADVERTISING_ID = 1006;
    public static final int AD_ERR_NO_FILL = 1000;
    public static final int AD_ERR_NO_INTERNET = 1003;
    public static final int AD_ERR_OFFERWALL_NOT_ENGAGED_REDEEMED_BEFORE = 1012;
    public static final int AD_ERR_OFFERWALL_NOT_OPENED_BEFORE = 1011;
    public static final int AD_ERR_REDEEM_FAIL = 1007;
    public static final int AD_ERR_REQUEST_FAILED = 1001;
    public static final int AD_ERR_SPEND_VIRTUAL_CURRENCY = 1008;
    public static final int AD_ERR_TOO_FREQUENT_VIRTUAL_CURRENCY_CALL = 1010;
    public static final int AD_ERR_UNKNOWN = 999;
    public static final String MESSAGE_AD_ERR_ENGAGEMENT_FAIL = "Error: Engagement failed.";
    public static final String MESSAGE_AD_ERR_FAIL_TO_SHOW = "Error: Ad failed to show.";
    public static final String MESSAGE_AD_ERR_ITEM_DETAIL_FAIL = "Error: Item detail failed.";
    public static final String MESSAGE_AD_ERR_LOCAL_SDK = "Error: Local SDK error.";
    public static final String MESSAGE_AD_ERR_NO_ADVERTISING_ID = "Error: No Google Advertising Id available. Can not load offerwall.";
    public static final String MESSAGE_AD_ERR_NO_FILL = "Error: No fill error.";
    public static final String MESSAGE_AD_ERR_NO_FILL_SSV_CONSTRAINT = "Error: Setting application user is mandatory for SSV enabled applications.";
    public static final String MESSAGE_AD_ERR_NO_INTERNET = "Error: No Internet.";
    public static final String MESSAGE_AD_ERR_REDEEM_FAIL = "Error: Redeem code failed.";
    public static final String MESSAGE_AD_ERR_REQUEST_FAILED = "Error: Request failed.";
    public static final String MESSAGE_AD_ERR_SPEND_VIRTUAL_CURRENCY = "Error: Spend virtual currency failed.";
    public static final String MESSAGE_ERR_INIT_PARAMETERS = "Error: Init parameters are wrong to load ad!";
    public static final String MESSAGE_ERR_OFFERWALL_NOT_ENGAGED_REDEEMED_BEFORE = "Error: Neither engage nor redeem code called before for this client.";
    public static final String MESSAGE_ERR_OFFERWALL_NOT_OPENED_BEFORE = "Error: Offerwall has not been opened for this client. You need to show it at least once.";
    public static final String MESSAGE_ERR_TOO_FREQUENT_VIRTUAL_CURRENCY_CALL = "Error: Spend virtual currency called too frequently.";
    public static final String MESSAGE_UNKNOWN_ERROR = "Error: Unknown.";
    /* access modifiers changed from: private */
    public static Context mContext;
    /* access modifiers changed from: private */
    public static boolean mHasInitParameterError;
    private static QumparaOfferwallModels.Identifiers mIdentifiers;
    /* access modifiers changed from: private */
    public static boolean mInitResponseReturned;
    /* access modifiers changed from: private */
    public static boolean mIsInitialized;
    /* access modifiers changed from: private */
    public static Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Observer mCallbackObserver;
    private boolean mIsLoaded;
    /* access modifiers changed from: private */
    public QumparaOfferwallListener mListener;

    public QumparaOfferwall(Context context, QumparaOfferwallListener qumparaOfferwallListener) {
        this.mListener = qumparaOfferwallListener;
        if (context != null) {
            mContext = context.getApplicationContext();
        }
    }

    public static String getApplicationUserId() {
        return QumparaOfferwallModels.Identifiers.getInstance().getApplicationUserId();
    }

    public static Context getContext() {
        return mContext;
    }

    public static QumparaOfferwallModels.Identifiers getIdentifiers() {
        return mIdentifiers;
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static boolean hasInitParameterError() {
        return mHasInitParameterError;
    }

    public static boolean isSDKInitialized() {
        return mIsInitialized;
    }

    /* access modifiers changed from: private */
    public void observeEvents(int i, String[] strArr) {
        String[] strArr2 = strArr;
        switch (i) {
            case 2:
                this.mIsLoaded = true;
                this.mListener.onReady();
                return;
            case 3:
                this.mIsLoaded = false;
                if (strArr2 == null || strArr2.length != 2) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 2");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                this.mListener.onFail(Integer.valueOf(strArr2[0]).intValue(), strArr2[1]);
                return;
            case 4:
                this.mListener.onClicked();
                return;
            case 5:
                this.mIsLoaded = false;
                this.mListener.onDismiss();
                QumparaOfferwallObservable.getInstance().deleteObserver(this.mCallbackObserver);
                this.mCallbackObserver = null;
                QumparaAnalytics.getInstance().trackEvent(getContext(), QumparaAnalytics.EVENT_TYPE_OW_CLOSE, getIdentifiers().getIdfa(), getIdentifiers().getApplicationId(), "");
                return;
            case 6:
                this.mListener.onFail(1002, MESSAGE_AD_ERR_FAIL_TO_SHOW);
                return;
            case 7:
                this.mListener.onShown();
                return;
            case 10:
                if (strArr2 == null || strArr2.length != 5) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 5");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                String str = strArr2[0];
                String str2 = strArr2[1];
                String str3 = strArr2[2];
                String str4 = strArr2[3];
                String str5 = strArr2[4];
                QumparaImpressionManager.getInstance().incrementCountData(3, str, str3);
                openQumparaApplication(str, str2, str4, str5);
                QumparaOfferwallModels.OfferwallStatus instance = QumparaOfferwallModels.OfferwallStatus.getInstance();
                if (!instance.isEngagedBefore()) {
                    instance.setEngagedBefore(true);
                    QumparaOfferwallModels.OfferwallStatus.putInstance(instance);
                }
                this.mListener.onEngageSuccess(str, str2);
                return;
            case 11:
                if (strArr2 == null || strArr2.length != 3) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 3");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                this.mListener.onEngageFail(strArr2[0], Integer.valueOf(strArr2[1]).intValue(), strArr2[2]);
                return;
            case 12:
                if (strArr2 == null || strArr2.length != 1) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 1");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                this.mListener.onEngageClicked(strArr2[0]);
                return;
            case 13:
                if (strArr2 == null || strArr2.length <= 2) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 3");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                QumparaOfferwallModels.OfferwallStatus instance2 = QumparaOfferwallModels.OfferwallStatus.getInstance();
                if (!instance2.isRedeemedBefore()) {
                    instance2.setRedeemedBefore(true);
                    QumparaOfferwallModels.OfferwallStatus.putInstance(instance2);
                }
                String str6 = strArr2[0];
                String str7 = strArr2[1];
                QumparaImpressionManager.getInstance().incrementCountData(4, str7, strArr2[2]);
                QumparaAnalytics.getInstance().trackEvent(getContext(), QumparaAnalytics.EVENT_TYPE_OW_REDEEM, getIdentifiers().getIdfa(), getIdentifiers().getApplicationId(), str7);
                this.mListener.onRedeemSuccess(str6);
                return;
            case 14:
                if (strArr2 == null || strArr2.length != 3) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 3");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                this.mListener.onRedeemFail(strArr2[0], Integer.valueOf(strArr2[1]).intValue(), strArr2[2]);
                return;
            case 15:
                if (strArr2 == null || strArr2.length != 1) {
                    QumparaOfferwallLog.allError("SDK ERROR: arguments.length != 1");
                    this.mListener.onFail(AD_ERR_UNKNOWN, MESSAGE_UNKNOWN_ERROR);
                    return;
                }
                this.mListener.onRedeemClicked(strArr2[0]);
                return;
            default:
                return;
        }
    }

    private void openQumparaApplication(String str, String str2, String str3, String str4) {
        if (QumparaOfferwallUtil.isAppInstalled(getContext(), "com.qumpara")) {
            QumparaOfferwallUtil.openInBrowser(getContext(), str2);
            QumparaAnalytics.getInstance().trackEvent(getContext(), QumparaAnalytics.EVENT_TYPE_OW_REDIRECT, getIdentifiers().getIdfa(), getIdentifiers().getApplicationId(), str);
            return;
        }
        try {
            QumparaAnalytics.getInstance().trackEvent(getContext(), QumparaAnalytics.EVENT_TYPE_OW_REDIRECT_STORE, getIdentifiers().getIdfa(), getIdentifiers().getApplicationId(), str);
            if (str3 != null) {
                if (str3.length() > 0) {
                    String replace = str3.replace("{ei}", QumparaAnalytics.Util.encrypt(getIdentifiers().getIdfa(), getIdentifiers().getApplicationId().substring(0, 16), QumparaAnalytics.Util.getAlphaNumericString16()));
                    QumparaOfferwallLog.m16490i("redirect url : " + replace);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(replace));
                    intent.setFlags(268566528);
                    getContext().startActivity(intent);
                    return;
                }
            }
            String encode = URLEncoder.encode("utm_source=offerwall&offerwall_campaign=" + str);
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.qumpara&referrer=" + encode));
            intent2.setFlags(268566528);
            getContext().startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
        if (r0 == null) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers readAndUpdateQumparaAppUser(com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers r9) {
        /*
            r0 = 0
            android.net.Uri r1 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.BASE_CONTENT_URI     // Catch:{ Exception -> 0x0064 }
            android.net.Uri$Builder r1 = r1.buildUpon()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = "user"
            android.net.Uri$Builder r1 = r1.appendPath(r2)     // Catch:{ Exception -> 0x0064 }
            r1.build()     // Catch:{ Exception -> 0x0064 }
            android.content.Context r1 = getContext()     // Catch:{ Exception -> 0x0064 }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x0064 }
            android.net.Uri r3 = com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil.CONTENT_URI     // Catch:{ Exception -> 0x0064 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x005a
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x0057
            java.lang.String r1 = "adjust_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = r0.getString(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r1 = "admost_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r0.getString(r1)     // Catch:{ Exception -> 0x0064 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r1 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers     // Catch:{ Exception -> 0x0064 }
            java.lang.String r3 = r9.getApplicationId()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r9.getIdfa()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r7 = r9.getApplicationUserId()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r8 = r9.getApplicationAdMostId()     // Catch:{ Exception -> 0x0064 }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0064 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers.updateInstance(r1)     // Catch:{ Exception -> 0x0064 }
        L_0x0057:
            if (r0 == 0) goto L_0x0085
            goto L_0x0082
        L_0x005a:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = "Null cursor"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0064 }
            throw r1     // Catch:{ Exception -> 0x0064 }
        L_0x0062:
            r9 = move-exception
            goto L_0x00a2
        L_0x0064:
            if (r0 != 0) goto L_0x006d
            java.lang.String r1 = "Qumpara Application is not present for this device!"
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16494w(r1)     // Catch:{ all -> 0x0062 }
            goto L_0x0072
        L_0x006d:
            java.lang.String r1 = "Error while getting identifiers from Qumpara app!"
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16494w(r1)     // Catch:{ all -> 0x0062 }
        L_0x0072:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r1 = com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers.getInstance()     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = r9.getIdfa()     // Catch:{ all -> 0x0062 }
            r1.setIdfa(r2)     // Catch:{ all -> 0x0062 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers.updateInstance(r1)     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0085
        L_0x0082:
            r0.close()
        L_0x0085:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers r0 = com.qumpara.offerwall.sdk.core.QumparaOfferwallModels.Identifiers.getInstance()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Identifiers: "
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16490i(r0)
            return r9
        L_0x00a2:
            if (r0 == 0) goto L_0x00a7
            r0.close()
        L_0x00a7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwall.readAndUpdateQumparaAppUser(com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers):com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$Identifiers");
    }

    public static Handler runOnUIThread() {
        return mMainHandler;
    }

    public static void setApplicationAdMostId(String str) {
        updateIdentifiers("", "", "", str);
    }

    public static void setApplicationUserId(String str) {
        updateIdentifiers("", "", str, "");
    }

    public static void setHasInitParameterError(boolean z) {
        mHasInitParameterError = z;
    }

    private void setOfferwallObserver() {
        if (this.mCallbackObserver == null) {
            this.mCallbackObserver = new Observer() {
                public void update(Observable observable, final Object obj) {
                    if (QumparaOfferwall.mMainHandler == null) {
                        Handler unused = QumparaOfferwall.mMainHandler = new Handler(Looper.getMainLooper());
                    }
                    QumparaOfferwall.mMainHandler.post(new Runnable() {
                        public void run() {
                            Object obj;
                            if (QumparaOfferwall.this.mListener == null || (obj = obj) == null || !(obj instanceof Object[])) {
                                QumparaOfferwallLog.allError("SDK ERROR: mListener == null || arg == null || !(arg instanceof Object[])");
                            } else if (((Object[]) obj).length < 1) {
                                QumparaOfferwallLog.allError("SDK ERROR: (Object[])arg).length < 1");
                            } else {
                                Object[] objArr = (Object[]) obj;
                                int intValue = ((Integer) objArr[0]).intValue();
                                String[] strArr = null;
                                if (objArr.length > 1 && (objArr[1] instanceof String[])) {
                                    strArr = (String[]) objArr[1];
                                }
                                QumparaOfferwall.this.observeEvents(intValue, strArr);
                            }
                        }
                    });
                }
            };
            QumparaOfferwallObservable.getInstance().addObserver(this.mCallbackObserver);
        }
    }

    public static void spendVirtualCurrency(QumparaOfferwallVirtualCurrencyListener qumparaOfferwallVirtualCurrencyListener) {
        if (qumparaOfferwallVirtualCurrencyListener == null) {
            QumparaOfferwallLog.allError("Listener should not be null for spendVirtualCurrency(listener) method");
        } else if (!isSDKInitialized()) {
            QumparaOfferwallLog.allError("Qumpara Offerwall SDK should be initialized first to call spendVirtualCurrency!");
        } else if (QumparaOfferwallUtil.isNullOrEmpty(QumparaOfferwallModels.Identifiers.getInstance().getApplicationId())) {
            QumparaOfferwallLog.allError("Application id should not be null to call spendVirtualCurrency!");
        } else if (QumparaOfferwallUtil.isNullOrEmpty(QumparaOfferwallModels.Identifiers.getInstance().getIdfa())) {
            qumparaOfferwallVirtualCurrencyListener.fail(1006, MESSAGE_AD_ERR_NO_ADVERTISING_ID);
        } else {
            QumparaOfferwallAPI.postSpendVirtualCurrency(QumparaOfferwallModels.Identifiers.getInstance().getApplicationId(), QumparaOfferwallModels.Identifiers.getInstance().getIdfa(), qumparaOfferwallVirtualCurrencyListener);
        }
    }

    /* access modifiers changed from: private */
    public static void updateIdentifiers(String str, String str2, String str3, String str4) {
        mIdentifiers = QumparaOfferwallModels.Identifiers.getInstance();
        if (str != null && !str.equals("")) {
            mIdentifiers.setApplicationId(str);
        }
        if (str2 != null && !str2.equals("")) {
            mIdentifiers.setIdfa(str2);
        }
        if (str3 != null && !str3.equals("")) {
            mIdentifiers.setApplicationUserId(str3);
        }
        if (str4 != null && !str4.equals("")) {
            mIdentifiers.setApplicationAdMost(str4);
        }
        QumparaOfferwallModels.Identifiers.updateInstance(mIdentifiers);
    }

    public void destroy() {
        this.mListener = null;
        this.mIsLoaded = false;
    }

    public long getBestOfferAmount() {
        if (isLoaded()) {
            return QumparaOfferwallAPI.bestOfferAmount;
        }
        return 0;
    }

    public boolean isLoaded() {
        return this.mIsLoaded;
    }

    public void load() {
        setOfferwallObserver();
        if (hasInitParameterError()) {
            QumparaOfferwallLog.m16487e(MESSAGE_ERR_INIT_PARAMETERS);
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1009), MESSAGE_ERR_INIT_PARAMETERS);
            return;
        }
        final QumparaOfferwallModels.Identifiers instance = QumparaOfferwallModels.Identifiers.getInstance();
        if (!isSDKInitialized()) {
            QumparaOfferwallLog.m16490i("load() call is waiting for SDK init!");
            QumparaOfferwallObservable.getInstance().addObserver(new Observer() {
                private Observer instance = this;

                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        QumparaOfferwallLog.m16490i("load() call is now continuing after SDK init.");
                        QumparaOfferwallModels.Identifiers identifiers = instance;
                        if (identifiers == null || QumparaOfferwallUtil.isNullOrEmpty(identifiers.getIdfa())) {
                            QumparaOfferwallLog.m16487e("Google advertising id is required to load offerwall!");
                            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1006), QumparaOfferwall.MESSAGE_AD_ERR_NO_ADVERTISING_ID);
                        } else {
                            QumparaOfferwallAPI.getCampaigns();
                        }
                        QumparaOfferwallObservable.getInstance().deleteObserver(this.instance);
                    }
                }
            });
        } else if (instance == null || QumparaOfferwallUtil.isNullOrEmpty(instance.getIdfa())) {
            QumparaOfferwallLog.m16487e("Google advertising id is required to load offerwall!");
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1006), MESSAGE_AD_ERR_NO_ADVERTISING_ID);
        } else {
            QumparaOfferwallAPI.getCampaigns();
        }
    }

    public void show() {
        if (!isLoaded()) {
            QumparaOfferwallLog.m16487e("Ad has to be loaded before show!");
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1002), MESSAGE_AD_ERR_FAIL_TO_SHOW);
            return;
        }
        QumparaOfferwallModels.Identifiers instance = QumparaOfferwallModels.Identifiers.getInstance();
        if (instance == null || QumparaOfferwallUtil.isNullOrEmpty(instance.getIdfa())) {
            QumparaOfferwallLog.m16487e("Google advertising id is required to show offerwall!");
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1006), MESSAGE_AD_ERR_NO_ADVERTISING_ID);
            return;
        }
        if (QumparaOfferwallResponseCache.getFromCache(QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST, QumparaOfferwallModels.Identifiers.getInstance().getApplicationId()) == null) {
            QumparaOfferwallLog.m16487e("Ad has to be loaded before show!");
            QumparaOfferwallObservable.getInstance().onReceive(3, String.valueOf(1002), MESSAGE_AD_ERR_FAIL_TO_SHOW);
            return;
        }
        Intent intent = new Intent(mContext, QumparaOfferwallRVActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        mContext.startActivity(intent);
        QumparaOfferwallObservable.getInstance().onReceive(7, new String[0]);
        QumparaImpressionManager.getInstance().incrementCountData(2, (String) null, (String) null);
        QumparaAnalytics.getInstance().trackEvent(getContext(), QumparaAnalytics.EVENT_TYPE_OW_OPEN, getIdentifiers().getIdfa(), getIdentifiers().getApplicationId(), "");
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String appId;
        private Context context;
        /* access modifiers changed from: private */
        public QumparaOfferwallInitListener initListener;

        public Builder(Context context2, String str) {
            this.context = context2.getApplicationContext();
            this.appId = str;
        }

        public void init(QumparaOfferwallInitListener qumparaOfferwallInitListener) {
            this.initListener = qumparaOfferwallInitListener;
            init();
        }

        public Builder setDebug() {
            QumparaOfferwallUtil.QUMPARA_BASE = "https://test-tr-api.fisicek.com/v2.1/ow/";
            return this;
        }

        public void init() {
            if (QumparaOfferwall.mIsInitialized) {
                boolean unused = QumparaOfferwall.mHasInitParameterError = false;
                QumparaOfferwallLog.m16494w("Qumpara Offerwall SDK is already initialized!");
                return;
            }
            String str = this.appId;
            if (str == null || str.equals("")) {
                boolean unused2 = QumparaOfferwall.mHasInitParameterError = true;
                QumparaOfferwallInitListener qumparaOfferwallInitListener = this.initListener;
                if (qumparaOfferwallInitListener != null) {
                    qumparaOfferwallInitListener.fail("appId must not be null or empty!");
                }
                QumparaOfferwallLog.allError("appId must not be null or empty!");
                this.initListener = null;
            } else if (this.context == null) {
                boolean unused3 = QumparaOfferwall.mHasInitParameterError = true;
                QumparaOfferwallInitListener qumparaOfferwallInitListener2 = this.initListener;
                if (qumparaOfferwallInitListener2 != null) {
                    qumparaOfferwallInitListener2.fail("context must not be null!");
                }
                this.initListener = null;
                QumparaOfferwallLog.allError("context must not be null!");
            } else {
                boolean unused4 = QumparaOfferwall.mHasInitParameterError = false;
                QumparaOfferwallObservable.getInstance().addObserver(new Observer() {
                    public void update(Observable observable, Object obj) {
                        int intValue = ((Integer) ((Object[]) obj)[0]).intValue();
                        if (intValue == 1) {
                            if (Builder.this.initListener != null) {
                                Builder.this.initListener.success();
                            }
                            QumparaOfferwallLog.m16490i("Qumpara Offerwall SDK is initialized");
                            QumparaImpressionManager.getInstance().start(QumparaOfferwall.getContext());
                            QumparaOfferwallInitListener unused = Builder.this.initListener = null;
                            QumparaImpressionManager.getInstance().incrementCountData(5, (String) null, (String) null);
                        } else if (intValue == 16) {
                            if (Builder.this.initListener != null) {
                                Builder.this.initListener.fail("Error getting advertising id!");
                            }
                            QumparaOfferwallLog.m16490i("Qumpara Offerwall SDK is initialized but advertising id is null");
                            QumparaOfferwallInitListener unused2 = Builder.this.initListener = null;
                        }
                    }
                });
                boolean unused5 = QumparaOfferwall.mIsInitialized = true;
                Context unused6 = QumparaOfferwall.mContext = this.context;
                if (QumparaOfferwallModels.Identifiers.getInstance().getIdfa() != null && !QumparaOfferwallModels.Identifiers.getInstance().getIdfa().equals("")) {
                    QumparaOfferwallObservable.getInstance().onReceive(1, new String[0]);
                    boolean unused7 = QumparaOfferwall.mInitResponseReturned = true;
                }
                new QumparaOfferwallAdvertisingIdTask(new QumparaOfferwallAdvertisingIdListener() {
                    public void fail(Exception exc, String str) {
                        QumparaOfferwall.updateIdentifiers(Builder.this.appId, "", "", "");
                        if (!QumparaOfferwall.mInitResponseReturned) {
                            QumparaOfferwallObservable.getInstance().onReceive(16, new String[0]);
                        }
                    }

                    public void success(String str) {
                        QumparaOfferwall.updateIdentifiers(Builder.this.appId, str, "", "");
                        if (!QumparaOfferwall.mInitResponseReturned) {
                            QumparaOfferwallObservable.getInstance().onReceive(1, new String[0]);
                        }
                    }
                }).execute(new Void[0]);
            }
        }
    }
}
