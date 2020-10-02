package admost.adserver.core;

import java.util.Observable;

/* renamed from: admost.adserver.core.b */
/* compiled from: AdMostFullScreenAdObservable */
public class C0050b extends Observable {

    /* renamed from: a */
    private static C0050b f144a = new C0050b();

    /* renamed from: a */
    public static C0050b m130a() {
        return f144a;
    }

    /* renamed from: a */
    public void mo89a(int i, String str, String str2) {
        synchronized (this) {
            setChanged();
            notifyObservers(new Object[]{Integer.valueOf(i), str, str2});
        }
    }
}
