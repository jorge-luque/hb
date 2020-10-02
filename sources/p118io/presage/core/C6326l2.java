package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.CarrierConfigChangedReceiver;

/* renamed from: io.presage.core.l2 */
public class C6326l2 extends C6342p2 {
    public C6326l2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 2;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, CarrierConfigChangedReceiver.class);
    }
}
