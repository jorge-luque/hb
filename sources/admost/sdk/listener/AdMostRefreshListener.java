package admost.sdk.listener;

import admost.sdk.model.AdMostBannerResponseBase;

public interface AdMostRefreshListener {
    void onAdMediation(AdMostBannerResponseBase adMostBannerResponseBase);

    void onError(int i);
}
