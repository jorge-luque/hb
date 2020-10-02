package com.qumpara.analytics;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.qumpara.analytics.QumparaAnalyticsRequest;
import com.qumpara.analytics.model.QumparaAnalyticsError;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

public class QumparaAnalytics {
    public static final int AD_ERR_BAD_REQUEST = 400;
    public static final int AD_ERR_LOCAL_SDK = 100;
    public static final String EVENT_TYPE_OW_CLOSE = "ow_close";
    public static final String EVENT_TYPE_OW_DETAIL_CLOSE = "ow_detail_close";
    public static final String EVENT_TYPE_OW_DETAIL_OPEN = "ow_detail_open";
    public static final String EVENT_TYPE_OW_OPEN = "ow_open";
    public static final String EVENT_TYPE_OW_REDEEM = "ow_redeem";
    public static final String EVENT_TYPE_OW_REDIRECT = "ow_redirect";
    public static final String EVENT_TYPE_OW_REDIRECT_STORE = "ow_redirect_store";
    public static final String EVENT_TYPE_QP_DETAIL = "qp_detail";
    public static final String EVENT_TYPE_QP_INSTALL = "qp_install";
    public static final String EVENT_TYPE_QP_REGISTER = "qp_register";
    public static final String EVENT_TYPE_QP_SEND_RECEIPT = "qp_send_receipt";
    public static final String LOG_TAG = "QUMPARA_ANALYTICS";
    public static final String MESSAGE_AD_ERR_LOCAL_SDK = "Error: Local SDK error.";
    private static final Object lock = new Object();
    private static QumparaAnalytics qumparaAnalytics;
    /* access modifiers changed from: private */
    public static final AtomicBoolean requestStarted = new AtomicBoolean();
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(20));

    public static class Util {
        static final String charset = "UTF-8";
        static final String encriptionAlgorithm = "AES";
        static final String encriptionAlgorithmFull = "AES/CBC/PKCS5PADDING";
        static final int flag = 8;

        public static String decrypt(String str, String str2, String str3) {
            if (str != null) {
                try {
                    if (!str.equals("") && str3 != null && !str3.equals("") && str2 != null) {
                        if (!str2.equals("")) {
                            String decode = URLDecoder.decode(str, "UTF-8");
                            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes("UTF-8"));
                            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), encriptionAlgorithm);
                            Cipher instance = Cipher.getInstance(encriptionAlgorithmFull);
                            instance.init(2, secretKeySpec, ivParameterSpec);
                            return new String(instance.doFinal(Base64.decode(decode, 8)), "UTF-8");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return "";
        }

        public static String encrypt(String str, String str2, String str3) {
            if (str != null) {
                try {
                    if (!str.equals("") && str2 != null && !str2.equals("") && str3 != null) {
                        if (!str3.equals("")) {
                            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes("UTF-8"));
                            SecretKeySpec secretKeySpec = new SecretKeySpec((str2.substring(0, 8) + str3.substring(0, 8)).getBytes("UTF-8"), encriptionAlgorithm);
                            Cipher instance = Cipher.getInstance(encriptionAlgorithmFull);
                            instance.init(1, secretKeySpec, ivParameterSpec);
                            byte[] doFinal = instance.doFinal(str.getBytes("UTF-8"));
                            return str3 + URLEncoder.encode(Base64.encodeToString(doFinal, 8), "UTF-8");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return "";
        }

        public static String getAlphaNumericString16() {
            StringBuilder sb = new StringBuilder(16);
            for (int i = 0; i < 16; i++) {
                double d = (double) 61;
                double random = Math.random();
                Double.isNaN(d);
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".charAt((int) (d * random)));
            }
            return sb.toString();
        }
    }

    private QumparaAnalytics() {
    }

    public static QumparaAnalytics getInstance() {
        if (qumparaAnalytics == null) {
            synchronized (lock) {
                if (qumparaAnalytics == null) {
                    qumparaAnalytics = new QumparaAnalytics();
                }
            }
        }
        return qumparaAnalytics;
    }

    /* access modifiers changed from: package-private */
    public ThreadPoolExecutor getExecutor() {
        return this.executor;
    }

    public void sendEventsToServer(final Context context) {
        if (requestStarted.compareAndSet(false, true)) {
            final JSONArray allPostData = QumparaAnalyticsPreferences.getInstance(context).getAllPostData();
            if (allPostData == null || allPostData.length() == 0) {
                requestStarted.set(false);
                return;
            }
            " : Total [" + allPostData.length() + "] QUMPARA events will be posted to server...";
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("events", allPostData);
                new QumparaAnalyticsRequest(QumparaAnalyticsRequest.RequestType.POST_EVENT_DATA, new QumparaAnalyticsResponseListener<JSONObject>() {
                    public void onError(QumparaAnalyticsError qumparaAnalyticsError) {
                        Log.w(QumparaAnalytics.LOG_TAG, " : Total [" + allPostData.length() + "] QUMPARA events did not send. Will try later");
                        Log.w(QumparaAnalytics.LOG_TAG, qumparaAnalyticsError.toString());
                        if (qumparaAnalyticsError.getCode() == 400) {
                            QumparaAnalyticsPreferences.getInstance(context).removePostData(jSONObject);
                        }
                        QumparaAnalytics.requestStarted.set(false);
                    }

                    public void onResponse(JSONObject jSONObject) {
                        " : Total [" + allPostData.length() + "] QUMPARA events sent successfully!";
                        QumparaAnalyticsPreferences.getInstance(context).removePostData(jSONObject);
                        QumparaAnalytics.requestStarted.set(false);
                    }
                }).mo30057go(jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void trackEvent(Context context, String str, String str2, String str3, String str4) {
        trackEvent(context, str, str2, str3, str4, (String) null);
    }

    public void trackEvent(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context != null && str != null && str2 != null && str3 != null) {
            JSONObject jSONObject = new JSONObject();
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            int i = (int) (currentTimeMillis / 1000.0d);
            try {
                jSONObject.put("type", str);
                jSONObject.put("timestamp", i);
                jSONObject.put("unique_client_key", System.currentTimeMillis());
                jSONObject.put("ei", Util.encrypt(str2, str3.substring(0, 16), Util.getAlphaNumericString16()));
                jSONObject.put("ow_app_id", str3);
                jSONObject.put("campaign_id", str4);
                if (str5 != null) {
                    jSONObject.put("qumpara_campaign_id", str5);
                }
                QumparaAnalyticsPreferences.getInstance(context).keepPostData(jSONObject);
                sendEventsToServer(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
