package p118io.presage;

import java.util.Map;

/* renamed from: io.presage.dl */
public final class C6406dl {

    /* renamed from: a */
    private static final C6405dk f16989a = new CamembertauCalvados();

    /* renamed from: io.presage.dl$CamembertauCalvados */
    public static final class CamembertauCalvados implements C6405dk {
        CamembertauCalvados() {
        }

        /* renamed from: a */
        public final Map<String, String> mo34587a() {
            return C6465fq.m21349a();
        }
    }

    /* renamed from: a */
    public static final boolean m21262a(C6405dk dkVar) {
        return C6514hl.m21416a((Object) dkVar.mo34587a().get("Content-Encoding"), (Object) "gzip");
    }
}
