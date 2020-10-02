package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2551t;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.criteo.publisher.t.b */
abstract class C2515b extends C2551t {

    /* renamed from: a */
    private final List<C2551t.C2552a> f8019a;

    /* renamed from: b */
    private final String f8020b;

    /* renamed from: c */
    private final int f8021c;

    C2515b(List<C2551t.C2552a> list, String str, int i) {
        if (list != null) {
            this.f8019a = list;
            if (str != null) {
                this.f8020b = str;
                this.f8021c = i;
                return;
            }
            throw new NullPointerException("Null wrapperVersion");
        }
        throw new NullPointerException("Null feedbacks");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C2551t.C2552a> mo10544a() {
        return this.f8019a;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("profile_id")
    /* renamed from: b */
    public int mo10545b() {
        return this.f8021c;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("wrapper_version")
    /* renamed from: c */
    public String mo10546c() {
        return this.f8020b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2551t)) {
            return false;
        }
        C2551t tVar = (C2551t) obj;
        if (!this.f8019a.equals(tVar.mo10544a()) || !this.f8020b.equals(tVar.mo10546c()) || this.f8021c != tVar.mo10545b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f8019a.hashCode() ^ 1000003) * 1000003) ^ this.f8020b.hashCode()) * 1000003) ^ this.f8021c;
    }

    public String toString() {
        return "MetricRequest{feedbacks=" + this.f8019a + ", wrapperVersion=" + this.f8020b + ", profileId=" + this.f8021c + "}";
    }
}
