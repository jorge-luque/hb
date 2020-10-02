package com.miniclip.info;

import android.app.Activity;
import android.net.ConnectivityManager;
import com.miniclip.framework.Miniclip;

public class NetworkInfo {
    public static boolean isNetworkAvailable() {
        android.net.NetworkInfo activeNetworkInfo;
        Activity activity = Miniclip.getActivity();
        if (activity == null || (activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }
}
