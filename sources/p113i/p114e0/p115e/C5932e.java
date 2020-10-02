package p113i.p114e0.p115e;

import java.io.IOException;
import p119j.C3577c;
import p119j.C3585t;
import p119j.C6583h;

/* renamed from: i.e0.e.e */
/* compiled from: FaultHidingSink */
class C5932e extends C6583h {

    /* renamed from: b */
    private boolean f15175b;

    C5932e(C3585t tVar) {
        super(tVar);
    }

    /* renamed from: a */
    public void mo19670a(C3577c cVar, long j) throws IOException {
        if (this.f15175b) {
            cVar.skip(j);
            return;
        }
        try {
            super.mo19670a(cVar, j);
        } catch (IOException e) {
            this.f15175b = true;
            mo19399a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19399a(IOException iOException) {
        throw null;
    }

    public void close() throws IOException {
        if (!this.f15175b) {
            try {
                super.close();
            } catch (IOException e) {
                this.f15175b = true;
                mo19399a(e);
            }
        }
    }

    public void flush() throws IOException {
        if (!this.f15175b) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f15175b = true;
                mo19399a(e);
            }
        }
    }
}
