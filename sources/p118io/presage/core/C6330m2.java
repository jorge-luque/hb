package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.EventReminderReceiver;

/* renamed from: io.presage.core.m2 */
public class C6330m2 extends C6342p2 {
    public C6330m2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 8;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, EventReminderReceiver.class);
    }
}
