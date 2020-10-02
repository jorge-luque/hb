package okhttp3.internal.http2;

import com.ogury.p159cm.OguryChoiceManager;
import java.util.Arrays;

/* renamed from: okhttp3.internal.http2.l */
/* compiled from: Settings */
public final class C6645l {

    /* renamed from: a */
    private int f17457a;

    /* renamed from: b */
    private final int[] f17458b = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35747a() {
        this.f17457a = 0;
        Arrays.fill(this.f17458b, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo35749b() {
        if ((this.f17457a & 2) != 0) {
            return this.f17458b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo35752c(int i) {
        return (this.f17457a & 32) != 0 ? this.f17458b[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo35754d(int i) {
        return ((1 << i) & this.f17457a) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo35750b(int i) {
        return (this.f17457a & 16) != 0 ? this.f17458b[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo35751c() {
        if ((this.f17457a & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0) {
            return this.f17458b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo35753d() {
        return Integer.bitCount(this.f17457a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C6645l mo35746a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f17458b;
            if (i < iArr.length) {
                this.f17457a = (1 << i) | this.f17457a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo35745a(int i) {
        return this.f17458b[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35748a(C6645l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.mo35754d(i)) {
                mo35746a(i, lVar.mo35745a(i));
            }
        }
    }
}
