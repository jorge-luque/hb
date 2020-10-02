package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2551t;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.criteo.publisher.t.c */
abstract class C2516c extends C2551t.C2552a {

    /* renamed from: a */
    private final List<C2551t.C2553b> f8022a;

    /* renamed from: b */
    private final Long f8023b;

    /* renamed from: c */
    private final boolean f8024c;

    /* renamed from: d */
    private final long f8025d;

    /* renamed from: e */
    private final Long f8026e;

    /* renamed from: f */
    private final String f8027f;

    C2516c(List<C2551t.C2553b> list, Long l, boolean z, long j, Long l2, String str) {
        if (list != null) {
            this.f8022a = list;
            this.f8023b = l;
            this.f8024c = z;
            this.f8025d = j;
            this.f8026e = l2;
            this.f8027f = str;
            return;
        }
        throw new NullPointerException("Null slots");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Long mo10550a() {
        return this.f8026e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo10551b() {
        return this.f8025d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Long mo10552c() {
        return this.f8023b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo10553d() {
        return this.f8027f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public List<C2551t.C2553b> mo10554e() {
        return this.f8022a;
    }

    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2551t.C2552a)) {
            return false;
        }
        C2551t.C2552a aVar = (C2551t.C2552a) obj;
        if (this.f8022a.equals(aVar.mo10554e()) && ((l = this.f8023b) != null ? l.equals(aVar.mo10552c()) : aVar.mo10552c() == null) && this.f8024c == aVar.mo10556f() && this.f8025d == aVar.mo10551b() && ((l2 = this.f8026e) != null ? l2.equals(aVar.mo10550a()) : aVar.mo10550a() == null)) {
            String str = this.f8027f;
            if (str == null) {
                if (aVar.mo10553d() == null) {
                    return true;
                }
            } else if (str.equals(aVar.mo10553d())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("isTimeout")
    /* renamed from: f */
    public boolean mo10556f() {
        return this.f8024c;
    }

    public int hashCode() {
        int hashCode = (this.f8022a.hashCode() ^ 1000003) * 1000003;
        Long l = this.f8023b;
        int i = 0;
        int hashCode2 = (hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003;
        int i2 = this.f8024c ? 1231 : 1237;
        long j = this.f8025d;
        int i3 = (((hashCode2 ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l2 = this.f8026e;
        int hashCode3 = (i3 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str = this.f8027f;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 ^ i;
    }

    public String toString() {
        return "MetricRequestFeedback{slots=" + this.f8022a + ", elapsed=" + this.f8023b + ", timeout=" + this.f8024c + ", cdbCallStartElapsed=" + this.f8025d + ", cdbCallEndElapsed=" + this.f8026e + ", requestGroupId=" + this.f8027f + "}";
    }
}
