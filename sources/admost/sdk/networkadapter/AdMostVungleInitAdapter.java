package admost.sdk.networkadapter;

import admost.sdk.BuildConfig;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.vungle.warren.InitCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class AdMostVungleInitAdapter extends AdMostAdNetworkInitInterface {
    /* access modifiers changed from: private */
    public boolean isInitStarted;
    /* access modifiers changed from: private */
    public int tryCount = 0;

    public AdMostVungleInitAdapter() {
        super(true, 1, 14, true, "fullscreen_banner", "fullscreen_video");
    }

    static /* synthetic */ int access$108(AdMostVungleInitAdapter adMostVungleInitAdapter) {
        int i = adMostVungleInitAdapter.tryCount;
        adMostVungleInitAdapter.tryCount = i + 1;
        return i;
    }

    public String getAdapterVersion() {
        return BuildConfig.ADAPTER_MIN_VERSION;
    }

    public String getMinSdkVersion() {
        return "2.1.6";
    }

    public String getVersion() {
        return com.vungle.warren.BuildConfig.VERSION_NAME;
    }

    public void initialize(final Activity activity, final String[] strArr) {
        if (!this.isInitStarted) {
            setAsInitialized();
            this.isInitStarted = true;
            Vungle.init(strArr[0], AdMost.getInstance().getContext(), new InitCallback() {
                public void onAutoCacheAdAvailable(String str) {
                    if (AdMostVungleInitAdapter.this.placementListeners.containsKey(str)) {
                        AdMostVungleInitAdapter.this.placementListeners.get(str).onReady(AdMostAdNetwork.VUNGLE, 0);
                    }
                }

                public void onError(VungleException vungleException) {
                    AdMostLog.m298e("Vungle Init Error", vungleException.getCause(), false);
                    boolean unused = AdMostVungleInitAdapter.this.isInitStarted = false;
                    try {
                        if (vungleException.getExceptionCode() != 9) {
                            if (AdMostVungleInitAdapter.this.tryCount >= 1) {
                                AdMostVungleInitAdapter.this.sendFailToInitListeners();
                                return;
                            }
                        }
                        AdMostVungleInitAdapter.access$108(AdMostVungleInitAdapter.this);
                        AdMostVungleInitAdapter.this.initialize(activity, strArr);
                    } catch (ClassCastException e) {
                        e.getMessage();
                        AdMostVungleInitAdapter.this.sendFailToInitListeners();
                    }
                }

                public void onSuccess() {
                    try {
                        AdMostVungleInitAdapter.this.setUserId(AdMost.getInstance().getUserId());
                        if (AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
                            Vungle.updateConsentStatus(Vungle.Consent.OPTED_IN, com.miniclip.mcprime.BuildConfig.VERSION_NAME);
                        } else {
                            Vungle.updateConsentStatus(Vungle.Consent.OPTED_OUT, com.miniclip.mcprime.BuildConfig.VERSION_NAME);
                        }
                        if (AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
                            Vungle.updateCCPAStatus(Vungle.Consent.OPTED_IN);
                        } else {
                            Vungle.updateConsentStatus(Vungle.Consent.OPTED_OUT, com.miniclip.mcprime.BuildConfig.VERSION_NAME);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (Vungle.isInitialized()) {
                        AdMostVungleInitAdapter.this.sendSuccessToInitListeners();
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            public void run() {
                                if (Vungle.isInitialized()) {
                                    AdMostVungleInitAdapter.this.sendSuccessToInitListeners();
                                } else {
                                    AdMostVungleInitAdapter.this.sendFailToInitListeners();
                                }
                            }
                        }, 1000);
                    }
                }
            });
        }
    }

    public void setUserId(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    Vungle.setIncentivizedFields(str, (String) null, (String) null, (String) null, (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
