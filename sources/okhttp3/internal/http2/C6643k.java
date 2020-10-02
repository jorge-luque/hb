package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import p119j.C3580e;

/* renamed from: okhttp3.internal.http2.k */
/* compiled from: PushObserver */
public interface C6643k {

    /* renamed from: a */
    public static final C6643k f17456a = new C6644a();

    /* renamed from: okhttp3.internal.http2.k$a */
    /* compiled from: PushObserver */
    class C6644a implements C6643k {
        C6644a() {
        }

        /* renamed from: a */
        public void mo35741a(int i, C6615a aVar) {
        }

        /* renamed from: a */
        public boolean mo35742a(int i, C3580e eVar, int i2, boolean z) throws IOException {
            eVar.skip((long) i2);
            return true;
        }

        /* renamed from: a */
        public boolean mo35743a(int i, List<C6616b> list) {
            return true;
        }

        /* renamed from: a */
        public boolean mo35744a(int i, List<C6616b> list, boolean z) {
            return true;
        }
    }

    /* renamed from: a */
    void mo35741a(int i, C6615a aVar);

    /* renamed from: a */
    boolean mo35742a(int i, C3580e eVar, int i2, boolean z) throws IOException;

    /* renamed from: a */
    boolean mo35743a(int i, List<C6616b> list);

    /* renamed from: a */
    boolean mo35744a(int i, List<C6616b> list, boolean z);
}
