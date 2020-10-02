package p118io.presage;

import android.graphics.Rect;
import java.util.Map;

/* renamed from: io.presage.cu */
public final class C6388cu {

    /* renamed from: a */
    public static final CamembertauCalvados f16950a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private boolean f16951b;

    /* renamed from: c */
    private int f16952c;

    /* renamed from: d */
    private int f16953d;

    /* renamed from: e */
    private int f16954e;

    /* renamed from: f */
    private int f16955f;

    /* renamed from: io.presage.cu$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6388cu m21210a(Map<String, String> map) {
            C6388cu cuVar = new C6388cu((byte) 0);
            String str = map.get("allowOffscreen");
            cuVar.mo35317a(str != null ? Boolean.parseBoolean(str) : true);
            try {
                cuVar.mo35316a(C6215af.m20776b(C6213ad.m20772a(map, "width")));
                cuVar.mo35318b(C6215af.m20776b(C6213ad.m20772a(map, "height")));
                cuVar.mo35321c(C6215af.m20776b(C6213ad.m20772a(map, "offsetX")));
                cuVar.mo35323d(C6215af.m20776b(C6213ad.m20772a(map, "offsetY")));
                return cuVar;
            } catch (Throwable unused) {
                return null;
            }
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }

        /* renamed from: a */
        public static C6388cu m21209a(Rect rect) {
            return m21208a(rect.left, rect.top, rect.width(), rect.height());
        }

        /* renamed from: a */
        private static C6388cu m21208a(int i, int i2, int i3, int i4) {
            C6388cu cuVar = new C6388cu((byte) 0);
            cuVar.mo35317a(false);
            cuVar.mo35321c(i);
            cuVar.mo35323d(i2);
            cuVar.mo35316a(i3);
            cuVar.mo35318b(i4);
            return cuVar;
        }
    }

    private C6388cu() {
        this.f16951b = false;
        this.f16952c = 0;
        this.f16953d = 0;
        this.f16954e = 0;
        this.f16955f = 0;
    }

    /* renamed from: a */
    public final void mo35317a(boolean z) {
        this.f16951b = z;
    }

    /* renamed from: b */
    public final boolean mo35319b() {
        return this.f16951b;
    }

    /* renamed from: c */
    public final int mo35320c() {
        return this.f16952c;
    }

    /* renamed from: d */
    public final int mo35322d() {
        return this.f16953d;
    }

    /* renamed from: e */
    public final int mo35324e() {
        return this.f16954e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6388cu)) {
            return false;
        }
        C6388cu cuVar = (C6388cu) obj;
        return this.f16951b == cuVar.f16951b && this.f16952c == cuVar.f16952c && this.f16953d == cuVar.f16953d && this.f16954e == cuVar.f16954e && this.f16955f == cuVar.f16955f;
    }

    /* renamed from: f */
    public final int mo35326f() {
        return this.f16955f;
    }

    public final int hashCode() {
        boolean z = this.f16951b;
        if (z) {
            z = true;
        }
        return ((((((((z ? 1 : 0) * true) + this.f16952c) * 31) + this.f16953d) * 31) + this.f16954e) * 31) + this.f16955f;
    }

    public final String toString() {
        return "ResizeProps(allowOffscreen=" + this.f16951b + ", width=" + this.f16952c + ", height=" + this.f16953d + ", offsetX=" + this.f16954e + ", offsetY=" + this.f16955f + ")";
    }

    public C6388cu(byte b) {
        this();
    }

    /* renamed from: a */
    public final void mo35316a(int i) {
        this.f16952c = i;
    }

    /* renamed from: b */
    public final void mo35318b(int i) {
        this.f16953d = i;
    }

    /* renamed from: c */
    public final void mo35321c(int i) {
        this.f16954e = i;
    }

    /* renamed from: d */
    public final void mo35323d(int i) {
        this.f16955f = i;
    }

    /* renamed from: a */
    public final Rect mo35315a() {
        int i = this.f16954e;
        int i2 = this.f16955f;
        return new Rect(i, i2, this.f16952c + i, this.f16953d + i2);
    }
}
