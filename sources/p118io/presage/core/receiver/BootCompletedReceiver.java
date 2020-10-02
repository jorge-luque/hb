package p118io.presage.core.receiver;

import admost.sdk.base.AdMost;
import android.content.Context;
import android.content.Intent;
import p118io.presage.core.C6354s2;
import p118io.presage.core.IIIIlIll;

/* renamed from: io.presage.core.receiver.BootCompletedReceiver */
public class BootCompletedReceiver extends C6354s2 {
    public int IIIIIIII() {
        return AdMost.AD_ERROR_TAG_PASSIVE;
    }

    public void onReceive(Context context, Intent intent) {
        IIIIlIll.IIIIIIIl(context, IIIIIIII());
    }
}
