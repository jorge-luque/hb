package p118io.presage.core;

import android.content.ComponentName;
import android.content.Context;
import p118io.presage.core.receiver.PackageFullyRemovedReceiver;

/* renamed from: io.presage.core.o2 */
public class C6338o2 extends C6342p2 {
    public C6338o2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
    }

    public int IIIIIIII() {
        return 9;
    }

    public ComponentName IIIIIIll() {
        return new ComponentName(this.IIIIIIII, PackageFullyRemovedReceiver.class);
    }
}
