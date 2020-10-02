package admost.sdk.interfaces;

import admost.sdk.listener.AdMostBiddingListener;

public interface AdMostBiddingInterface {
    void bid(AdMostBiddingListener adMostBiddingListener);

    double getBiddingPrice();

    void sendLossNotice(double d, int i);

    void sendWinNotice(double d);
}
