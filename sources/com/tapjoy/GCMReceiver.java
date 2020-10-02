package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.C3147hb;

public class GCMReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean a = C3147hb.m10351b(context).mo18636a(intent);
        if (isOrderedBroadcast()) {
            setResult(-1, (String) null, (Bundle) null);
            if (a) {
                abortBroadcast();
            }
        }
    }
}
