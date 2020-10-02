package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.loopj.android.http.C4250c;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C5220j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReferrerReceiver extends C5220j {
    public void onReceive(Context context, Intent intent) {
        String a = C3145gz.m10323a(context, intent);
        int a2 = mo31438a(context, intent);
        if (intent.getBooleanExtra("fiverocks:verify", false) && isOrderedBroadcast()) {
            setResultCode(a2 + 1);
            if (a != null) {
                try {
                    setResultData("http://play.google.com/store/apps/details?id=" + context.getPackageName() + "&referrer=" + URLEncoder.encode(a, C4250c.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }
}
