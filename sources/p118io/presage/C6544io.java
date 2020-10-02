package p118io.presage;

import java.util.Iterator;

/* renamed from: io.presage.io */
class C6544io extends C6543in {

    /* renamed from: io.presage.io$CamembertauCalvados */
    public static final class CamembertauCalvados implements C6520hr, Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ C6538ii f17073a;

        public CamembertauCalvados(C6538ii iiVar) {
            this.f17073a = iiVar;
        }

        public final Iterator<T> iterator() {
            return this.f17073a.mo35540a();
        }
    }

    /* renamed from: a */
    public static final <T> Iterable<T> m21464a(C6538ii<? extends T> iiVar) {
        return new CamembertauCalvados(iiVar);
    }
}
