package p208k.p209a.p210a;

import java.util.ArrayList;
import java.util.List;
import p208k.p209a.p210a.C6599b;
import p208k.p209a.p210a.p211c.C6602a;

/* renamed from: k.a.a.a */
/* compiled from: EngineDataManager */
public class C6598a implements C6599b {

    /* renamed from: a */
    private List<C6599b> f17173a;

    public C6598a() {
        ArrayList arrayList = new ArrayList();
        this.f17173a = arrayList;
        arrayList.add(new C6602a());
    }

    /* renamed from: a */
    public String mo35630a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f17173a.size(); i++) {
            sb.append(this.f17173a.get(i).mo35630a());
            if (i < this.f17173a.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void destroy() {
        for (C6599b destroy : this.f17173a) {
            destroy.destroy();
        }
    }

    public void pause() {
        for (C6599b pause : this.f17173a) {
            pause.pause();
        }
    }

    public void resume() {
        for (C6599b resume : this.f17173a) {
            resume.resume();
        }
    }

    /* renamed from: a */
    public boolean mo35635a(C6599b.C6601b bVar) {
        boolean z = false;
        for (C6599b a : this.f17173a) {
            if (a.mo35635a(bVar)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo35634a(C6599b.C6600a aVar, int i, int i2) {
        for (C6599b a : this.f17173a) {
            a.mo35634a(aVar, i, i2);
        }
    }

    /* renamed from: a */
    public void mo35633a(int i, int i2, int i3) {
        for (C6599b a : this.f17173a) {
            a.mo35633a(i, i2, i3);
        }
    }

    /* renamed from: a */
    public void mo35632a(int i, float f, int i2) {
        for (C6599b a : this.f17173a) {
            a.mo35632a(i, f, i2);
        }
    }

    /* renamed from: a */
    public void mo35631a(float f, float f2) {
        for (C6599b a : this.f17173a) {
            a.mo35631a(f, f2);
        }
    }
}
