package p118io.presage.core;

import admost.sdk.base.AdMost;
import android.content.Context;
import android.os.Bundle;

/* renamed from: io.presage.core.Core */
public class Core {
    public static String getVersion() {
        return "4.3.12";
    }

    public static void initialize(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("0f902406", str);
        bundle.putInt("c133dd6f", AdMost.AD_ERROR_FREQ_CAP);
        IIIIlIll.IIIIIIII(context.getApplicationContext(), "80437a44", bundle);
    }
}
