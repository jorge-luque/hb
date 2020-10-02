package p118io.presage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: io.presage.VieuxLille */
public final class VieuxLille implements ServiceConnection {

    /* renamed from: a */
    private final LinkedBlockingQueue<IBinder> f16742a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    private boolean f16743b;

    /* renamed from: a */
    public final IBinder mo34727a() throws InterruptedException {
        if (!this.f16743b) {
            this.f16743b = true;
            IBinder take = this.f16742a.take();
            if (take != null) {
                return take;
            }
            throw new C6434em("null cannot be cast to non-null type android.os.IBinder");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f16742a.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
