package p118io.presage;

import android.content.Context;
import android.os.Build;

/* renamed from: io.presage.s */
public final class C6573s implements C6571q {

    /* renamed from: a */
    public static final C6573s f17133a = new C6573s();

    /* renamed from: b */
    private static C6572r f17134b;

    private C6573s() {
    }

    /* renamed from: b */
    private static C6572r m21566b(Context context) {
        if (f17134b == null) {
            Context applicationContext = context.getApplicationContext();
            C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
            f17134b = m21567c(applicationContext);
        }
        C6572r rVar = f17134b;
        if (rVar == null) {
            C6514hl.m21413a();
        }
        return rVar;
    }

    /* renamed from: c */
    private static C6572r m21567c(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C6569o(context);
        }
        return new C6570p(context);
    }

    /* renamed from: a */
    public final void mo35603a(Context context) {
        m21566b(context).mo35601a();
    }

    /* renamed from: a */
    public final void mo35604a(Context context, long j) {
        C6572r b = m21566b(context);
        b.mo35601a();
        b.mo35602a(j);
    }
}
