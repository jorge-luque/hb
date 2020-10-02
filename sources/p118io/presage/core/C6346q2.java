package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.TimeSetReceiver;

/* renamed from: io.presage.core.q2 */
public class C6346q2 extends C6342p2 {
    public C6346q2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 4;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, TimeSetReceiver.class);
    }
}
