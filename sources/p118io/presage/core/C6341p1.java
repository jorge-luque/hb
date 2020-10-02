package p118io.presage.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: io.presage.core.p1 */
public final class C6341p1 implements ServiceConnection {
    public LinkedBlockingQueue<IBinder> IIIIIIII = new LinkedBlockingQueue<>(1);
    public boolean IIIIIIIl = false;

    public IBinder IIIIIIII() {
        if (!this.IIIIIIIl) {
            this.IIIIIIIl = true;
            return this.IIIIIIII.take();
        }
        throw new IllegalStateException();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.IIIIIIII.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
