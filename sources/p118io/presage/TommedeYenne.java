package p118io.presage;

import org.json.JSONObject;

/* renamed from: io.presage.TommedeYenne */
public final class TommedeYenne {

    /* renamed from: a */
    private final boolean f16722a;

    /* renamed from: b */
    private final long f16723b;

    /* renamed from: c */
    private final JSONObject f16724c;

    /* renamed from: d */
    private final boolean f16725d;

    /* renamed from: e */
    private final String f16726e;

    public TommedeYenne(boolean z, long j, JSONObject jSONObject, boolean z2, String str) {
        this.f16722a = z;
        this.f16723b = j;
        this.f16724c = jSONObject;
        this.f16725d = z2;
        this.f16726e = str;
    }

    /* renamed from: a */
    public final boolean mo34713a() {
        return this.f16722a;
    }

    /* renamed from: b */
    public final long mo34714b() {
        return this.f16723b;
    }

    /* renamed from: c */
    public final JSONObject mo34715c() {
        return this.f16724c;
    }

    /* renamed from: d */
    public final boolean mo34716d() {
        return this.f16725d;
    }

    /* renamed from: e */
    public final String mo34717e() {
        return this.f16726e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TommedeYenne)) {
            return false;
        }
        TommedeYenne tommedeYenne = (TommedeYenne) obj;
        return this.f16722a == tommedeYenne.f16722a && this.f16723b == tommedeYenne.f16723b && C6514hl.m21416a((Object) this.f16724c, (Object) tommedeYenne.f16724c) && this.f16725d == tommedeYenne.f16725d && C6514hl.m21416a((Object) this.f16726e, (Object) tommedeYenne.f16726e);
    }

    public final int hashCode() {
        boolean z = this.f16722a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        long j = this.f16723b;
        int i = (((z ? 1 : 0) * true) + ((int) (j ^ (j >>> 32)))) * 31;
        JSONObject jSONObject = this.f16724c;
        int i2 = 0;
        int hashCode = (i + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        boolean z3 = this.f16725d;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode + (z2 ? 1 : 0)) * 31;
        String str = this.f16726e;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "ProfigRequest(allowRequest=" + this.f16722a + ", jobScheduleWindow=" + this.f16723b + ", request=" + this.f16724c + ", profigEnabled=" + this.f16725d + ", profigHash=" + this.f16726e + ")";
    }

    public /* synthetic */ TommedeYenne(long j, JSONObject jSONObject, boolean z) {
        this(false, j, jSONObject, z, (String) null);
    }
}
