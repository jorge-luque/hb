package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.interfaces.AdMostOfferwallSpendInterface;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import android.app.Activity;
import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyUtil;
import java.io.InputStream;
import java.util.Hashtable;

public class AdMostTapjoyInitAdapter extends AdMostAdNetworkInitInterface implements AdMostOfferwallSpendInterface {
    public AdMostTapjoyInitAdapter() {
        super(true, 1, 9, true, "fullscreen_banner", "fullscreen_video", "fullscreen_offerwall");
    }

    private void workaroundForMraidJs(Context context) {
        String str;
        try {
            InputStream openRawResource = context.getResources().openRawResource(context.getResources().getIdentifier("mraid", "raw", context.getPackageName()));
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            str = new String(bArr);
        } catch (Exception e) {
            AdMostLog.m304w("mraid.js not found for Tapjoy", e);
            str = null;
        }
        TapjoyUtil.setResource("mraid.js", str);
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        return "12.6.0";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        if (!Tapjoy.isConnected()) {
            workaroundForMraidJs(AdMost.getInstance().getContext());
            Tapjoy.connect(AdMost.getInstance().getContext(), strArr[0], (Hashtable) null, new TJConnectListener() {
                public void onConnectFailure() {
                    AdMostTapjoyInitAdapter adMostTapjoyInitAdapter = AdMostTapjoyInitAdapter.this;
                    adMostTapjoyInitAdapter.isInitFailed = true;
                    adMostTapjoyInitAdapter.isInitialized = false;
                    adMostTapjoyInitAdapter.sendFailToInitListeners();
                }

                public void onConnectSuccess() {
                    AdMostTapjoyInitAdapter adMostTapjoyInitAdapter = AdMostTapjoyInitAdapter.this;
                    adMostTapjoyInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                    adMostTapjoyInitAdapter.setUserId(AdMost.getInstance().getUserId());
                    AdMostTapjoyInitAdapter.this.sendSuccessToInitListeners();
                }
            });
        }
        TJPrivacyPolicy privacyPolicy = Tapjoy.getPrivacyPolicy();
        try {
            if (AdMost.getInstance().getConfiguration().isGDPRRequired()) {
                if (AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
                    privacyPolicy.setUserConsent("1");
                } else {
                    privacyPolicy.setUserConsent(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
            }
            if (AdMost.getInstance().isUserChild()) {
                privacyPolicy.setBelowConsentAge(true);
            }
            if (AdMost.getInstance().getConfiguration().isCCPARequired()) {
                privacyPolicy.setUSPrivacy(AdMost.getInstance().getConfiguration().getCCPAIABPrivacyString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (AdMostLog.isAdNetworkLogsEnabled()) {
            Tapjoy.setDebugEnabled(true);
        }
    }

    public void onStart(Activity activity) {
        if (!ignoreInLifeCycle(activity)) {
            Tapjoy.onActivityStart(activity);
        }
    }

    public void onStop(Activity activity) {
        if (!ignoreInLifeCycle(activity)) {
            Tapjoy.onActivityStop(activity);
        }
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    Tapjoy.setUserID(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void spendVirtualCurrency(final AdMostVirtualCurrencyListener adMostVirtualCurrencyListener) {
        AdMostLog.m299i("spendVirtualCurrency TAPJOY " + adMostVirtualCurrencyListener);
        Tapjoy.getCurrencyBalance(new TJGetCurrencyBalanceListener() {
            public void onGetCurrencyBalanceResponse(final String str, final int i) {
                AdMostLog.m299i("spendVirtualCurrency TAPJOY onGetCurrencyBalanceResponse" + str + " - " + i);
                if (i > 0) {
                    Tapjoy.spendCurrency(i, new TJSpendCurrencyListener() {
                        public void onSpendCurrencyResponse(String str, int i) {
                            int i2 = i;
                            if (i2 > 0) {
                                adMostVirtualCurrencyListener.onSuccess(AdMostAdNetwork.TAPJOY, str, (double) i2);
                            }
                        }

                        public void onSpendCurrencyResponseFailure(String str) {
                            adMostVirtualCurrencyListener.onError(AdMostAdNetwork.TAPJOY, str);
                        }
                    });
                }
            }

            public void onGetCurrencyBalanceResponseFailure(String str) {
                AdMostLog.m296e("spendVirtualCurrency TAPJOY onGetCurrencyBalanceResponseFailure" + str);
                adMostVirtualCurrencyListener.onError(AdMostAdNetwork.TAPJOY, str);
            }
        });
    }
}
