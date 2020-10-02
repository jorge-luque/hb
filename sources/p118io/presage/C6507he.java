package p118io.presage;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* renamed from: io.presage.he */
public abstract class C6507he implements C6534ie, Serializable {

    /* renamed from: b */
    public static final Object f17038b = CamembertauCalvados.f17041a;

    /* renamed from: a */
    protected final Object f17039a;

    /* renamed from: c */
    private transient C6534ie f17040c;

    /* renamed from: io.presage.he$CamembertauCalvados */
    static class CamembertauCalvados implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final CamembertauCalvados f17041a = new CamembertauCalvados();

        private CamembertauCalvados() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f17041a;
        }
    }

    protected C6507he(Object obj) {
        this.f17039a = obj;
    }

    /* renamed from: b */
    public C6536ig mo34406b() {
        throw new AbstractMethodError();
    }

    /* renamed from: c */
    public String mo34407c() {
        throw new AbstractMethodError();
    }

    /* renamed from: d */
    public String mo34408d() {
        throw new AbstractMethodError();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract C6534ie mo35518e();

    /* renamed from: f */
    public final Object mo35519f() {
        return this.f17039a;
    }

    /* renamed from: g */
    public final C6534ie mo35520g() {
        C6534ie ieVar = this.f17040c;
        if (ieVar != null) {
            return ieVar;
        }
        C6534ie e = mo35518e();
        this.f17040c = e;
        return e;
    }
}
