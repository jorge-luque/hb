package p118io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: io.presage.core.IlIlIIII */
public class IlIlIIII extends IIllllll {
    public BroadcastReceiver IIIIlllI;

    /* renamed from: io.presage.core.IlIlIIII$IIIIIIII */
    public class IIIIIIII extends BroadcastReceiver {

        /* renamed from: io.presage.core.IlIlIIII$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6855IIIIIIII implements Runnable {
            public final /* synthetic */ Context IIIIIIII;

            public C6855IIIIIIII(Context context) {
                this.IIIIIIII = context;
            }

            public void run() {
                IlIlIIII.this.IIIIIIII((IIIlIIlI) new IIIllllI(C6325l1.IIIIIIII(), llllIlIl.IIIIIIIl(this.IIIIIIII)));
            }
        }

        public IIIIIIII() {
        }

        public void onReceive(Context context, Intent intent) {
            IlIlIIII.this.IIIIIIII((Runnable) new C6855IIIIIIII(context));
        }
    }

    public IlIlIIII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 2;
    }

    public Object IIIIIIll() {
        return IlIlIIII.class;
    }

    public void IIIIIlIl() {
        BroadcastReceiver broadcastReceiver = this.IIIIlllI;
        if (broadcastReceiver != null) {
            try {
                this.IIIIIIlI.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.IIIIlllI = null;
        }
        this.IIIIlllI = new IIIIIIII();
        this.IIIIIIlI.registerReceiver(this.IIIIlllI, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void IIIIIllI() {
        BroadcastReceiver broadcastReceiver = this.IIIIlllI;
        if (broadcastReceiver != null) {
            try {
                this.IIIIIIlI.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.IIIIlllI = null;
        }
    }
}
