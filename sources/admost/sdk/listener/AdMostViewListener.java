package admost.sdk.listener;

import android.view.View;

public interface AdMostViewListener {
    void onClick(String str);

    void onFail(int i);

    void onReady(String str, int i, View view);
}
