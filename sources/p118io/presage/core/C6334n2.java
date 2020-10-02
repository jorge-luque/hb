package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.NextAlarmClockChangedReceiver;

/* renamed from: io.presage.core.n2 */
public class C6334n2 extends C6342p2 {
    public C6334n2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 3;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, NextAlarmClockChangedReceiver.class);
    }
}
