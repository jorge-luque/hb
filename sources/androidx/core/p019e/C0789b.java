package androidx.core.p019e;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.Writer;

/* renamed from: androidx.core.e.b */
/* compiled from: LogWriter */
public class C0789b extends Writer {

    /* renamed from: a */
    private final String f1994a;

    /* renamed from: b */
    private StringBuilder f1995b = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);

    public C0789b(String str) {
        this.f1994a = str;
    }

    /* renamed from: d */
    private void m2492d() {
        if (this.f1995b.length() > 0) {
            this.f1995b.toString();
            StringBuilder sb = this.f1995b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        m2492d();
    }

    public void flush() {
        m2492d();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m2492d();
            } else {
                this.f1995b.append(c);
            }
        }
    }
}
