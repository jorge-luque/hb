package p118io.presage;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.DelicedesFiouves */
public final class DelicedesFiouves {

    /* renamed from: a */
    public static final CamembertauCalvados f16485a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final List<String> f16486b;

    /* renamed from: c */
    private final List<String> f16487c;

    /* renamed from: io.presage.DelicedesFiouves$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static DelicedesFiouves m20349a(Activity activity, C6475g gVar, EtivazGruyereSuisse etivazGruyereSuisse) {
            return new DelicedesFiouves(m20351a(gVar, etivazGruyereSuisse, activity), m20350a(gVar, etivazGruyereSuisse));
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }

        /* renamed from: a */
        private static List<String> m20351a(C6475g gVar, EtivazGruyereSuisse etivazGruyereSuisse, Activity activity) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(gVar.mo35423e());
            if (gVar.mo35420c()) {
                arrayList.addAll(etivazGruyereSuisse.mo34548a());
            }
            if (gVar.mo35418b()) {
                arrayList.add(Coulommiers.m20338a(activity));
            }
            return arrayList;
        }

        /* renamed from: a */
        private static List<String> m20350a(C6475g gVar, EtivazGruyereSuisse etivazGruyereSuisse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(gVar.mo35424f());
            if (gVar.mo35422d()) {
                for (Class cls : etivazGruyereSuisse.mo34550b()) {
                    String canonicalName = cls.getCanonicalName();
                    if (canonicalName == null) {
                        canonicalName = cls.getName();
                    }
                    C6514hl.m21414a((Object) canonicalName, "fullName");
                    arrayList.add(canonicalName);
                }
            }
            return arrayList;
        }
    }

    public DelicedesFiouves(List<String> list, List<String> list2) {
        this.f16486b = list;
        this.f16487c = list2;
    }

    /* renamed from: a */
    public final List<String> mo34538a() {
        return this.f16486b;
    }

    /* renamed from: b */
    public final List<String> mo34539b() {
        return this.f16487c;
    }
}
