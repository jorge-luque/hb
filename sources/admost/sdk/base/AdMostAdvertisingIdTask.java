package admost.sdk.base;

import admost.sdk.listener.AdmostResponseListener;
import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AdMostAdvertisingIdTask extends AsyncTask<Void, Void, JSONObject> {
    private WeakReference<Context> appContext;
    private AdmostResponseListener<JSONObject> listener;

    private void clearGC() {
        this.listener = null;
        this.appContext = null;
    }

    private static JSONObject getAmazonAdvertisingId() {
        if (Build.MANUFACTURER.equals("Amazon")) {
            try {
                ContentResolver contentResolver = AdMost.getInstance().getContext().getContentResolver();
                return getResponseObject(Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID), Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0, "amazon");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public static JSONObject getResponseObject(String str, boolean z, String str2) {
        if (str != null && !str.equals("")) {
            try {
                return new JSONObject(String.format("{\"advId\":\"%s\",\"isLimitAdTrackingEnabled\":%b,\"store\":\"%s\"}", new Object[]{str, Boolean.valueOf(z), str2}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new JSONObject();
    }

    public Context getAppContext() {
        return (Context) this.appContext.get();
    }

    public void onError(String str, Exception exc) {
        AdmostResponseListener<JSONObject> admostResponseListener = this.listener;
        if (admostResponseListener != null) {
            admostResponseListener.onError(str, exc);
        }
        clearGC();
    }

    public void onResponse(JSONObject jSONObject) {
        AdmostResponseListener<JSONObject> admostResponseListener = this.listener;
        if (admostResponseListener != null) {
            admostResponseListener.onResponse(jSONObject);
        }
        clearGC();
    }

    public void setParameters(Context context, AdmostResponseListener<JSONObject> admostResponseListener) {
        this.appContext = new WeakReference<>(context);
        this.listener = admostResponseListener;
    }

    /* access modifiers changed from: protected */
    public JSONObject doInBackground(Void... voidArr) {
        String str;
        if (AdMostUtil.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            AdvertisingIdClient.Info info = null;
            try {
                Context context = (Context) this.appContext.get();
                if (context == null) {
                    return new JSONObject();
                }
                info = AdvertisingIdClient.getAdvertisingIdInfo(context);
                boolean z = false;
                if (info != null) {
                    try {
                        z = info.isLimitAdTrackingEnabled();
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return new JSONObject();
                        }
                    }
                    str = info.getId();
                } else {
                    str = "";
                }
                return getResponseObject(str, z, "playstore");
            } catch (Exception e3) {
                JSONObject amazonAdvertisingId = getAmazonAdvertisingId();
                if (amazonAdvertisingId.has("advId")) {
                    AdMostLog.m299i("Amazon Advertising Id " + amazonAdvertisingId.optString("advId"));
                    return amazonAdvertisingId;
                }
                AdMostLog.allError("Google Play services is not available in this device. AdMost custom id should be used to become a tester instead of Google Advertising Id.", e3);
            }
        } else {
            AdMostLog.allError("AdvertisingIdClient not available ..!");
            return getAmazonAdvertisingId();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                onResponse(jSONObject);
            } catch (Exception e) {
                onError("", e);
            }
        }
    }
}
