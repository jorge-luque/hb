package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.BluetoothReceiver;

/* renamed from: io.presage.core.j2 */
public class C6318j2 extends C6342p2 {
    public C6318j2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 7;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, BluetoothReceiver.class);
    }
}
