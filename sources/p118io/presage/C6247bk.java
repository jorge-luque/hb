package p118io.presage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: io.presage.bk */
public final class C6247bk {

    /* renamed from: a */
    private final Map<String, C6396db> f16813a;

    /* renamed from: b */
    private final Map<String, C6255bs> f16814b;

    public C6247bk(Map<String, C6396db> map, Map<String, C6255bs> map2) {
        this.f16813a = map;
        this.f16814b = map2;
    }

    /* renamed from: e */
    private final List<C6396db> m20933e() {
        ArrayList arrayList = new ArrayList();
        for (C6396db next : this.f16813a.values()) {
            C6255bs bsVar = this.f16814b.get(C6245bi.m20901b(next));
            if (bsVar != null && bsVar.mo34838d()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo34801a() {
        for (C6396db d : m20933e()) {
            d.mo35338d();
        }
    }

    /* renamed from: b */
    public final void mo34803b() {
        for (C6396db a : m20933e()) {
            C6234ay ayVar = C6234ay.f16776a;
            C6399de.m21253a(a, C6234ay.m20863b());
        }
    }

    /* renamed from: c */
    public final void mo34804c() {
        for (C6396db e : m20933e()) {
            e.mo35339e();
        }
    }

    /* renamed from: d */
    public final boolean mo34805d() {
        Collection<C6255bs> values = this.f16814b.values();
        if ((values instanceof Collection) && values.isEmpty()) {
            return true;
        }
        for (C6255bs b : values) {
            if (b.mo34836b()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo34802a(String str, boolean z, boolean z2, String str2, String str3) {
        for (C6396db a : m20933e()) {
            C6234ay ayVar = C6234ay.f16776a;
            C6399de.m21253a(a, C6234ay.m20860a(str, z, z2, str2, str3));
        }
    }

    /* renamed from: a */
    public static void m20932a(C6396db dbVar, String str, String str2) {
        C6234ay ayVar = C6234ay.f16776a;
        C6399de.m21253a(dbVar, C6234ay.m20867b(str, "{webviewId:\"" + str2 + "\"}"));
    }
}
