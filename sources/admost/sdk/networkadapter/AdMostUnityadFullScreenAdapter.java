package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;

public class AdMostUnityadFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public boolean waitingResponseFromNetwork;

    public AdMostUnityadFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
        this.isSingletonForPlacement = true;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
        loadVideo();
    }

    public void loadVideo() {
        String str = this.mBannerResponseItem.AdSpaceId;
        AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.UNITY).setListenerForPlacement(str, new AdMostAdListenerForNetworkAdapter() {
            public void onClicked(String str) {
                AdMostUnityadFullScreenAdapter.this.onAmrClick();
            }

            public void onComplete(String str) {
                AdMostUnityadFullScreenAdapter.this.onAmrComplete();
            }

            public void onDismiss(String str) {
                AdMostUnityadFullScreenAdapter.this.onAmrDismiss();
            }

            public void onFail(int i) {
                if (AdMostUnityadFullScreenAdapter.this.waitingResponseFromNetwork) {
                    boolean unused = AdMostUnityadFullScreenAdapter.this.waitingResponseFromNetwork = false;
                    AdMostUnityadFullScreenAdapter adMostUnityadFullScreenAdapter = AdMostUnityadFullScreenAdapter.this;
                    adMostUnityadFullScreenAdapter.onAmrFail(adMostUnityadFullScreenAdapter.mBannerResponseItem, i, "onFail");
                }
            }

            public void onFailToShow(int i) {
            }

            public void onReady(String str, int i) {
                if (AdMostUnityadFullScreenAdapter.this.waitingResponseFromNetwork) {
                    boolean unused = AdMostUnityadFullScreenAdapter.this.waitingResponseFromNetwork = false;
                    AdMostUnityadFullScreenAdapter.this.onAmrReady();
                }
            }

            public void onShown(String str) {
            }
        });
        if (!UnityAds.isInitialized()) {
            this.waitingResponseFromNetwork = true;
        } else if (UnityAds.isReady(str)) {
            onAmrReady();
        } else if (UnityAds.getPlacementState(str) == UnityAds.PlacementState.NO_FILL || UnityAds.getPlacementState(str) == UnityAds.PlacementState.DISABLED) {
            onAmrFail(this.mBannerResponseItem, "placement state is not ready");
        } else {
            this.waitingResponseFromNetwork = true;
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        showVideo();
    }

    public void showVideo() {
        if (UnityAds.isReady(this.mBannerResponseItem.AdSpaceId)) {
            MediationMetaData mediationMetaData = new MediationMetaData(AdMost.getInstance().getContext());
            mediationMetaData.setOrdinal(1);
            mediationMetaData.commit();
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.UNITY).setUserId(AdMost.getInstance().getUserId());
            UnityAds.show(AdMost.getInstance().getActivity(), this.mBannerResponseItem.AdSpaceId);
            return;
        }
        MediationMetaData mediationMetaData2 = new MediationMetaData(AdMost.getInstance().getContext());
        mediationMetaData2.setMissedImpressionOrdinal(1);
        mediationMetaData2.commit();
        onAmrFailToShow(this.mBannerResponseItem, "isReady false");
    }
}
