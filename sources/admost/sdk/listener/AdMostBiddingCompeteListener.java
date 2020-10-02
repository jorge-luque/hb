package admost.sdk.listener;

import admost.sdk.interfaces.AdMostAdInterface;

public interface AdMostBiddingCompeteListener {
    void onBiddingWins(AdMostAdInterface adMostAdInterface, AdMostAdInterface adMostAdInterface2);

    void onWaterfallWins(AdMostAdInterface adMostAdInterface);
}
