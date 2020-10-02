package com.qumpara.offerwall.sdk.core;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallAdvertisingIdListener;
import com.tapjoy.TapjoyConstants;

public class QumparaOfferwallAdvertisingIdTask extends AsyncTask<Void, Void, String> {
    private QumparaOfferwallAdvertisingIdListener listener;

    QumparaOfferwallAdvertisingIdTask(QumparaOfferwallAdvertisingIdListener qumparaOfferwallAdvertisingIdListener) {
        this.listener = qumparaOfferwallAdvertisingIdListener;
    }

    private void clearGC() {
        this.listener = null;
    }

    private static String getAmazonAdvertisingId() {
        if (!Build.MANUFACTURER.equals("Amazon")) {
            return "";
        }
        try {
            ContentResolver contentResolver = QumparaOfferwall.getContext().getContentResolver();
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0) {
                return Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
            }
            return "";
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void onError(Exception exc, String str) {
        QumparaOfferwallAdvertisingIdListener qumparaOfferwallAdvertisingIdListener = this.listener;
        if (qumparaOfferwallAdvertisingIdListener != null) {
            qumparaOfferwallAdvertisingIdListener.fail(exc, str);
        }
        clearGC();
    }

    public void onResponse(String str) {
        QumparaOfferwallAdvertisingIdListener qumparaOfferwallAdvertisingIdListener = this.listener;
        if (qumparaOfferwallAdvertisingIdListener != null) {
            qumparaOfferwallAdvertisingIdListener.success(str);
        }
        clearGC();
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voidArr) {
        String str = "";
        if (QumparaOfferwallUtil.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            AdvertisingIdClient.Info info = null;
            boolean z = false;
            try {
                if (QumparaOfferwall.getContext() == null) {
                    return str;
                }
                info = AdvertisingIdClient.getAdvertisingIdInfo(QumparaOfferwall.getContext());
                if (info != null && !z) {
                    try {
                        str = info.getId();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!QumparaOfferwallLog.isEnabled()) {
                    QumparaOfferwallLog.all("To enable AMR tester mode use this id : <" + str + "> on AMR dashboard Manage Testers page...");
                } else if (z) {
                    QumparaOfferwallLog.m16490i("Amazon Advertising Id " + str);
                } else {
                    QumparaOfferwallLog.m16490i("Advertising Id " + str);
                }
                return str;
            } catch (Exception e2) {
                String amazonAdvertisingId = getAmazonAdvertisingId();
                if (amazonAdvertisingId == null || amazonAdvertisingId.equals(str)) {
                    QumparaOfferwallLog.allError("Google Play services is not available in this device. AdMost custom id should be used to become a tester instead of Google Advertising Id.", e2);
                } else {
                    z = true;
                }
                str = amazonAdvertisingId;
            }
        } else {
            String amazonAdvertisingId2 = getAmazonAdvertisingId();
            return amazonAdvertisingId2 != null ? amazonAdvertisingId2 : str;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (str != null) {
            try {
                onResponse(str);
            } catch (Exception e) {
                onError(e, "idfa is null");
            }
        }
    }
}
