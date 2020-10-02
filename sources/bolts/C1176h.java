package bolts;

/* renamed from: bolts.h */
/* compiled from: TaskCompletionSource */
public class C1176h<TResult> {

    /* renamed from: a */
    private final C1167g<TResult> f3230a = new C1167g<>();

    /* renamed from: a */
    public C1167g<TResult> mo6196a() {
        return this.f3230a;
    }

    /* renamed from: b */
    public boolean mo6201b(TResult tresult) {
        return this.f3230a.mo6184a(tresult);
    }

    /* renamed from: c */
    public boolean mo6202c() {
        return this.f3230a.mo6192f();
    }

    /* renamed from: a */
    public void mo6198a(TResult tresult) {
        if (!mo6201b(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    /* renamed from: b */
    public boolean mo6200b(Exception exc) {
        return this.f3230a.mo6183a(exc);
    }

    /* renamed from: b */
    public void mo6199b() {
        if (!mo6202c()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /* renamed from: a */
    public void mo6197a(Exception exc) {
        if (!mo6200b(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
