package admost.sdk.listener;

import admost.sdk.interfaces.AdMostBannerInterface;

public interface AdMostBannerInterfaceListener {
    void onFail();

    void onReady(AdMostBannerInterface adMostBannerInterface);
}
