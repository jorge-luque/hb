package p093e.p101c.p102a.p103a.p104i.p106u;

/* renamed from: e.c.a.a.i.u.b */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3418b {
    /* renamed from: a */
    public static <TInput, TResult, TException extends Throwable> TResult m11383a(int i, TInput tinput, C3417a<TInput, TResult, TException> aVar, C3419c<TInput, TResult> cVar) throws Throwable {
        TResult apply;
        if (i < 1) {
            return aVar.apply(tinput);
        }
        do {
            apply = aVar.apply(tinput);
            tinput = cVar.mo12942a(tinput, apply);
            if (tinput == null || i - 1 < 1) {
                return apply;
            }
            apply = aVar.apply(tinput);
            tinput = cVar.mo12942a(tinput, apply);
            break;
        } while (i - 1 < 1);
        return apply;
    }
}
