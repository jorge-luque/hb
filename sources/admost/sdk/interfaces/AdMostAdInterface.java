package admost.sdk.interfaces;

import admost.sdk.model.AdMostBannerResponseItem;

public interface AdMostAdInterface {
    void destroy();

    AdMostBannerResponseItem getBannerResponseItem();
}
