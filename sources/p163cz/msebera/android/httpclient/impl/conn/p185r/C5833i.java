package p163cz.msebera.android.httpclient.impl.conn.p185r;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.i */
/* compiled from: WaitingThreadAborter */
public class C5833i {

    /* renamed from: a */
    private C5832h f15067a;

    /* renamed from: b */
    private boolean f15068b;

    /* renamed from: a */
    public void mo33611a() {
        this.f15068b = true;
        C5832h hVar = this.f15067a;
        if (hVar != null) {
            hVar.mo33608a();
        }
    }

    /* renamed from: a */
    public void mo33612a(C5832h hVar) {
        this.f15067a = hVar;
        if (this.f15068b) {
            hVar.mo33608a();
        }
    }
}
