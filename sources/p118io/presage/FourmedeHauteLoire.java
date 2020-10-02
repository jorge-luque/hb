package p118io.presage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: io.presage.FourmedeHauteLoire */
public final class FourmedeHauteLoire implements GorgonzolaPiccante {

    /* renamed from: a */
    public static final CamembertauCalvados f16511a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final ExecutorService f16512b;

    /* renamed from: io.presage.FourmedeHauteLoire$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public FourmedeHauteLoire() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(4, Runtime.getRuntime().availableProcessors()));
        C6514hl.m21414a((Object) newFixedThreadPool, "Executors.newFixedThreadPool(nrOfCachedThreads)");
        this.f16512b = newFixedThreadPool;
    }

    /* renamed from: a */
    public final void mo34553a(Runnable runnable) {
        this.f16512b.execute(runnable);
    }
}
