package com.criteo.publisher.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.criteo.publisher.model.c */
abstract class C2437c extends C2464v {

    /* renamed from: a */
    private final Boolean f7861a;

    /* renamed from: b */
    private final String f7862b;

    /* renamed from: c */
    private final String f7863c;

    /* renamed from: d */
    private final String f7864d;

    /* renamed from: e */
    private final String f7865e;

    /* renamed from: f */
    private final Boolean f7866f;

    C2437c(Boolean bool, String str, String str2, String str3, String str4, Boolean bool2) {
        this.f7861a = bool;
        this.f7862b = str;
        this.f7863c = str2;
        this.f7864d = str3;
        this.f7865e = str4;
        this.f7866f = bool2;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagDataMacro")
    /* renamed from: a */
    public String mo10334a() {
        return this.f7864d;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagDataMode")
    /* renamed from: b */
    public String mo10335b() {
        return this.f7865e;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagUrlMode")
    /* renamed from: c */
    public String mo10336c() {
        return this.f7863c;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidDisplayUrlMacro")
    /* renamed from: d */
    public String mo10337d() {
        return this.f7862b;
    }

    /* renamed from: e */
    public Boolean mo10338e() {
        return this.f7866f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2464v)) {
            return false;
        }
        C2464v vVar = (C2464v) obj;
        Boolean bool = this.f7861a;
        if (bool != null ? bool.equals(vVar.mo10340f()) : vVar.mo10340f() == null) {
            String str = this.f7862b;
            if (str != null ? str.equals(vVar.mo10337d()) : vVar.mo10337d() == null) {
                String str2 = this.f7863c;
                if (str2 != null ? str2.equals(vVar.mo10336c()) : vVar.mo10336c() == null) {
                    String str3 = this.f7864d;
                    if (str3 != null ? str3.equals(vVar.mo10334a()) : vVar.mo10334a() == null) {
                        String str4 = this.f7865e;
                        if (str4 != null ? str4.equals(vVar.mo10335b()) : vVar.mo10335b() == null) {
                            Boolean bool2 = this.f7866f;
                            if (bool2 == null) {
                                if (vVar.mo10338e() == null) {
                                    return true;
                                }
                            } else if (bool2.equals(vVar.mo10338e())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public Boolean mo10340f() {
        return this.f7861a;
    }

    public int hashCode() {
        Boolean bool = this.f7861a;
        int i = 0;
        int hashCode = ((bool == null ? 0 : bool.hashCode()) ^ 1000003) * 1000003;
        String str = this.f7862b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f7863c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7864d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f7865e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Boolean bool2 = this.f7866f;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode5 ^ i;
    }

    public String toString() {
        return "RemoteConfigResponse{killSwitch=" + this.f7861a + ", androidDisplayUrlMacro=" + this.f7862b + ", androidAdTagUrlMode=" + this.f7863c + ", androidAdTagDataMacro=" + this.f7864d + ", androidAdTagDataMode=" + this.f7865e + ", csmEnabled=" + this.f7866f + "}";
    }
}
