package p118io.presage;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: io.presage.CarreMirabelle */
public final class CarreMirabelle {

    /* renamed from: a */
    private List<String> f16440a = new ArrayList();

    /* renamed from: b */
    private List<String> f16441b = new ArrayList();

    /* renamed from: c */
    private final C6421e f16442c;

    /* renamed from: d */
    private final Class<? extends Activity> f16443d;

    public CarreMirabelle(C6421e eVar, Class<? extends Activity> cls) {
        this.f16442c = eVar;
        this.f16443d = cls;
        m20299b();
        m20297a();
    }

    /* renamed from: a */
    public final void mo34510a(List<String> list) {
        if (this.f16442c.mo35420c()) {
            this.f16440a.addAll(list);
        }
    }

    /* renamed from: b */
    public final void mo34511b(List<? extends Class<? extends Activity>> list) {
        if (this.f16442c.mo35422d()) {
            for (Class canonicalName : list) {
                List<String> list2 = this.f16441b;
                String canonicalName2 = canonicalName.getCanonicalName();
                C6514hl.m21414a((Object) canonicalName2, "it.canonicalName");
                list2.add(canonicalName2);
            }
        }
    }

    /* renamed from: a */
    public final void mo34509a(Activity activity) {
        if (this.f16442c.mo35418b()) {
            this.f16440a.add(Coulommiers.m20338a(activity));
        }
    }

    /* renamed from: b */
    private final void m20299b() {
        if (!this.f16442c.mo35424f().isEmpty()) {
            this.f16441b.addAll(this.f16442c.mo35424f());
        }
    }

    /* renamed from: a */
    private final void m20297a() {
        if (!this.f16442c.mo35423e().isEmpty()) {
            this.f16440a.addAll(this.f16442c.mo35423e());
        }
    }

    /* renamed from: b */
    public final boolean mo34512b(Activity activity) {
        if (activity instanceof Livarot) {
            return false;
        }
        if ((this.f16442c.mo35390a() || !(!C6514hl.m21416a((Object) activity.getClass(), (Object) this.f16443d))) && !m20298a(Coulommiers.m20339a((Object) activity)) && m20300b(Coulommiers.m20339a((Object) activity))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m20298a(String str) {
        List<String> list = this.f16441b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String b : list) {
            if (C6561je.m21509a(str, b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m20300b(String str) {
        List<String> list = this.f16440a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String b : list) {
            if (C6561je.m21509a(str, b)) {
                return true;
            }
        }
        return false;
    }
}
