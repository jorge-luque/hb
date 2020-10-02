package admost.sdk.listener;

public interface AdMostErrorListener {
    void onError(Exception exc);

    void onEvent(String str, String str2, int i);
}
