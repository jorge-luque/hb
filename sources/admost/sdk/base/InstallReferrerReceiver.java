package admost.sdk.base;

import admost.sdk.AdMostInstallReferrer;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdmostResponseListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class InstallReferrerReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static AtomicBoolean requestStarted = new AtomicBoolean();

    private static boolean isValidTrack() {
        if (AdMost.getInstance().getConfiguration() == null) {
            AdMostLog.m303w("Init not ready yet");
            return false;
        } else if (!AdMost.getInstance().getConfiguration().hasCampaign()) {
            AdMostLog.m301v("hasCampaign false");
            return false;
        } else if (!AdMost.getInstance().getConfiguration().isAdvertisingIdReady()) {
            AdMostLog.m303w("isAdvertisingIdReady false");
            return false;
        } else if (AdMostPreferences.getInstance().campaignAlreadySent()) {
            AdMostLog.m299i("Campaign already sent");
            return false;
        } else if (AdMostAnalyticsManager.getInstance().getInstallDateLong() + 259200000 >= System.currentTimeMillis()) {
            return true;
        } else {
            AdMostLog.m303w("Install date not suitable : " + AdMostAnalyticsManager.getInstance().getInstallDateLong());
            return false;
        }
    }

    private static void sendTrackRequest(final String str) {
        new AdMostGenericRequest(AdMostGenericRequest.RequestType.CAMPAIGN_TRACK, "", new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                if (exc != null) {
                    exc.printStackTrace();
                }
                InstallReferrerReceiver.requestStarted.set(false);
            }

            public void onResponse(JSONObject jSONObject) {
                AdMostLog.m299i("Campaign Track Response : " + jSONObject.toString());
                try {
                    if (jSONObject.has("Campaign")) {
                        AdMostPreferences.getInstance().setCampaignId(jSONObject.optString("Campaign", "invalid"));
                        AdMostAnalyticsManager.getInstance().update();
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CampaignTrackRequest : ");
                    sb.append(str);
                    sb.append(" value : ");
                    sb.append(jSONObject != null ? jSONObject.toString() : "");
                    AdMostLog.m298e(sb.toString(), e, true);
                }
                InstallReferrerReceiver.requestStarted.set(false);
            }
        }).mo611go(str);
    }

    static void trackCampaign() {
        AdMostPreferences.getInstance().overrideCampaignIdByClient();
        if (AdMostPreferences.getInstance().isUserRegistered()) {
            AdMostAnalyticsManager.getInstance().update();
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        AdMostLog.m299i("Install Referrer noticed");
        if (extras != null) {
            str = extras.getString(TapjoyConstants.TJC_REFERRER);
            AdMostInstallReferrer.getInstance().onReceive(context, intent, str);
        } else {
            str = "";
        }
        AdMostPreferences.newInstance(context);
        AdMostPreferences instance = AdMostPreferences.getInstance();
        instance.setInstallReferrer(str + "&amr_camp_tracked");
        trackCampaign(false);
    }

    static void trackCampaign(boolean z) {
        String str;
        String str2;
        if (isValidTrack() && requestStarted.compareAndSet(false, true)) {
            String installReferrer = AdMostPreferences.getInstance().getInstallReferrer();
            if (z || !AdMostUtil.isInstalledFromPlayStore(AdMost.getInstance().getActivity()) || !installReferrer.equals("") || !AdMost.getInstance().getConfiguration().hasInstallReferrerReceiver()) {
                if (installReferrer != null) {
                    try {
                        String[] split = installReferrer.split("&");
                        str2 = "";
                        str = str2;
                        int i = 0;
                        while (i < split.length) {
                            try {
                                String[] split2 = split[i].split("=");
                                if (split2.length == 2) {
                                    if (split2[0].equals("c_id")) {
                                        str2 = split2[1];
                                    } else if (split2[0].equals("cam_id")) {
                                        str = split2[1];
                                    }
                                }
                                i++;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                Locale locale = Locale.ENGLISH;
                                String format = String.format(locale, "{\"Click\":\"%s\",\"Campaign\":\"%s\",\"Platform\":\"%s\",\"OSVersion\":\"%s\",\"EI\":\"%s\",\"Timezone\":%f,\"Device\":{\"Brand\":\"%s\",\"Model\":\"%s\"}}", new Object[]{str2, str, "android", Build.VERSION.SDK_INT + "", AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), Double.valueOf(AdMostUtil.timeZone()), Build.BRAND, Build.MODEL});
                                AdMostLog.m299i("Campaign Track : " + format);
                                sendTrackRequest(format);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str2 = "";
                        str = str2;
                        e.printStackTrace();
                        Locale locale2 = Locale.ENGLISH;
                        String format2 = String.format(locale2, "{\"Click\":\"%s\",\"Campaign\":\"%s\",\"Platform\":\"%s\",\"OSVersion\":\"%s\",\"EI\":\"%s\",\"Timezone\":%f,\"Device\":{\"Brand\":\"%s\",\"Model\":\"%s\"}}", new Object[]{str2, str, "android", Build.VERSION.SDK_INT + "", AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), Double.valueOf(AdMostUtil.timeZone()), Build.BRAND, Build.MODEL});
                        AdMostLog.m299i("Campaign Track : " + format2);
                        sendTrackRequest(format2);
                        return;
                    }
                } else {
                    str2 = "";
                    str = str2;
                }
                Locale locale22 = Locale.ENGLISH;
                String format22 = String.format(locale22, "{\"Click\":\"%s\",\"Campaign\":\"%s\",\"Platform\":\"%s\",\"OSVersion\":\"%s\",\"EI\":\"%s\",\"Timezone\":%f,\"Device\":{\"Brand\":\"%s\",\"Model\":\"%s\"}}", new Object[]{str2, str, "android", Build.VERSION.SDK_INT + "", AdMostUtil.encrypt(AdMostPreferences.getInstance().getAdvId(), AdMost.getInstance().getAppId().substring(0, 16), AdMostUtil.getAlphaNumericString16(), false), Double.valueOf(AdMostUtil.timeZone()), Build.BRAND, Build.MODEL});
                AdMostLog.m299i("Campaign Track : " + format22);
                sendTrackRequest(format22);
                return;
            }
            AdMostLog.m303w("Referrer is not ready yet");
            requestStarted.set(false);
        }
    }
}
