package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.BootCompletedReceiver;

/* renamed from: io.presage.core.k2 */
public class C6322k2 extends C6342p2 {
    public C6322k2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 1;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, BootCompletedReceiver.class);
    }
}
