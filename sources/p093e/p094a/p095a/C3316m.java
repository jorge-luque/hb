package p093e.p094a.p095a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyConstants;

/* renamed from: e.a.a.m */
/* compiled from: AdjustReferrerReceiver */
public class C3316m extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_REFERRER);
        if (stringExtra != null) {
            C3297e.m10959b().mo19038a(stringExtra, context);
        }
    }
}
