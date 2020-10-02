package admost.sdk.listener;

import admost.sdk.AdMostCustomView;
import android.view.View;

public abstract class AdMostCustomViewListener {
    public abstract void onClick(AdMostCustomView.Data data);

    public abstract void onFail(int i, String str);

    public abstract void onReady(AdMostCustomView.Data data, View view);
}
