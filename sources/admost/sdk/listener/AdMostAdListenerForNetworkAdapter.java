package admost.sdk.listener;

public interface AdMostAdListenerForNetworkAdapter {
    void onClicked(String str);

    void onComplete(String str);

    void onDismiss(String str);

    void onFail(int i);

    void onFailToShow(int i);

    void onReady(String str, int i);

    void onShown(String str);
}
