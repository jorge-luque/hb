package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAnalyticsManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.interfaces.AdMostOfferwallSpendInterface;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import android.app.Activity;
import com.qumpara.offerwall.sdk.core.QumparaOfferwall;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallLog;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallInitListener;
import com.qumpara.offerwall.sdk.listener.QumparaOfferwallVirtualCurrencyListener;
import java.util.ArrayList;

public class AdMostQumparaInitAdapter extends AdMostAdNetworkInitInterface implements AdMostOfferwallSpendInterface {
    public AdMostQumparaInitAdapter() {
        super(true, 1, 14, true, "fullscreen_offerwall");
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public void initialize(Activity activity, String[] strArr) {
        setAsInitialized();
        C03211 r5 = new QumparaOfferwallInitListener() {
            public void fail(String str) {
                AdMostQumparaInitAdapter adMostQumparaInitAdapter = AdMostQumparaInitAdapter.this;
                adMostQumparaInitAdapter.hasInitializationError = true;
                adMostQumparaInitAdapter.sendFailToInitListeners();
            }

            public void success() {
                AdMostQumparaInitAdapter adMostQumparaInitAdapter = AdMostQumparaInitAdapter.this;
                adMostQumparaInitAdapter.isInitAdNetworkCompletedSuccessfully = true;
                adMostQumparaInitAdapter.setUserId(AdMost.getInstance().getUserId());
                AdMostQumparaInitAdapter.this.sendSuccessToInitListeners();
            }
        };
        if (!AdMostLog.isEnabled() || strArr.length <= 1 || strArr[1] == null || strArr[1].length() <= 10) {
            new QumparaOfferwall.Builder(AdMost.getInstance().getContext(), strArr[0]).init(r5);
        } else {
            new QumparaOfferwall.Builder(AdMost.getInstance().getContext(), strArr[1]).setDebug().init(r5);
        }
        if (AdMostLog.isAdNetworkLogsEnabled()) {
            QumparaOfferwallLog.setEnabled();
            QumparaOfferwallLog.setHTTPLogging(true);
        }
    }

    public void setUserId(String str) {
        try {
            if (QumparaOfferwall.isSDKInitialized()) {
                QumparaOfferwall.setApplicationUserId(str);
                QumparaOfferwall.setApplicationAdMostId(AdMostAnalyticsManager.getInstance().getUserId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void spendVirtualCurrency(final AdMostVirtualCurrencyListener adMostVirtualCurrencyListener) {
        QumparaOfferwall.spendVirtualCurrency(new QumparaOfferwallVirtualCurrencyListener() {
            public void fail(int i, String str) {
                adMostVirtualCurrencyListener.onError(AdMostAdNetwork.QUMPARA, str);
            }

            public void success(ArrayList<QumparaOfferwallModels.OfferwallItemPrize> arrayList) {
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        adMostVirtualCurrencyListener.onSuccess(AdMostAdNetwork.QUMPARA, arrayList.get(i).getAsset().getUnit(), Double.parseDouble(arrayList.get(i).getAsset().getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
