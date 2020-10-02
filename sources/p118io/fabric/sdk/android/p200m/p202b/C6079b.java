package p118io.fabric.sdk.android.p200m.p202b;

/* renamed from: io.fabric.sdk.android.m.b.b */
/* compiled from: AdvertisingInfo */
class C6079b {

    /* renamed from: a */
    public final String f16006a;

    /* renamed from: b */
    public final boolean f16007b;

    C6079b(String str, boolean z) {
        this.f16006a = str;
        this.f16007b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C6079b.class != obj.getClass()) {
            return false;
        }
        C6079b bVar = (C6079b) obj;
        if (this.f16007b != bVar.f16007b) {
            return false;
        }
        String str = this.f16006a;
        String str2 = bVar.f16006a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.f16006a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f16007b ? 1 : 0);
    }
}
