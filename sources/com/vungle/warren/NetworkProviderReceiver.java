package com.vungle.warren;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.vungle.warren.utility.NetworkProvider;

public class NetworkProviderReceiver extends BroadcastReceiver {
    private static final String TAG = NetworkProviderReceiver.class.getSimpleName();

    public static void enableBroadcastReceiver(Context context, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, NetworkProviderReceiver.class);
        if (hasReceiver(context)) {
            packageManager.setComponentEnabledSetting(componentName, z ? 1 : 2, 1);
        }
    }

    public static boolean hasReceiver(Context context) {
        try {
            if (context.getPackageManager().getReceiverInfo(new ComponentName(context, NetworkProviderReceiver.class), 640) != null) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isEnabledBroadcastReceiver(Context context) {
        return hasReceiver(context) && context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, NetworkProviderReceiver.class)) == 1;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkProvider.getInstance(context).onNetworkChanged();
        }
    }
}
