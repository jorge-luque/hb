package admost.sdk.listener;

public interface AdMostAdListener {
    public static final int CLICKED = 165;
    public static final int CLOSED = 164;
    public static final int COMPLETED = 162;
    public static final int FAILED = 161;
    public static final int LOADED = 163;
    public static final int STATUS_CHANGED = 166;

    void onClicked(String str);

    void onComplete(String str);

    void onDismiss(String str);

    void onFail(int i);

    void onReady(String str, int i);

    void onShown(String str);

    void onStatusChanged(int i);
}
