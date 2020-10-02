package admost.sdk.listener;

import admost.sdk.interfaces.AdMostFullScreenInterface;

public interface AdMostFullScreenInterfaceListener {
    void onClick(AdMostFullScreenInterface adMostFullScreenInterface);

    void onComplete(AdMostFullScreenInterface adMostFullScreenInterface);

    void onDismiss(AdMostFullScreenInterface adMostFullScreenInterface);

    void onFail(AdMostFullScreenInterface adMostFullScreenInterface);

    void onFailToShow(AdMostFullScreenInterface adMostFullScreenInterface);

    void onReady(AdMostFullScreenInterface adMostFullScreenInterface);
}
