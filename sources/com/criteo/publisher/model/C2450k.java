package com.criteo.publisher.model;

import com.criteo.publisher.p054a0.C2321a;

/* renamed from: com.criteo.publisher.model.k */
public final class C2450k {

    /* renamed from: a */
    private final String f7891a;

    /* renamed from: b */
    private final AdSize f7892b;

    /* renamed from: c */
    private final C2321a f7893c;

    public C2450k(AdSize adSize, String str, C2321a aVar) {
        this.f7892b = adSize;
        this.f7891a = str;
        this.f7893c = aVar;
    }

    /* renamed from: a */
    public C2321a mo10365a() {
        return this.f7893c;
    }

    /* renamed from: b */
    public String mo10366b() {
        return this.f7891a;
    }

    /* renamed from: c */
    public AdSize mo10367c() {
        return this.f7892b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2450k.class != obj.getClass()) {
            return false;
        }
        C2450k kVar = (C2450k) obj;
        String str = this.f7891a;
        if (str == null ? kVar.f7891a != null : !str.equals(kVar.f7891a)) {
            return false;
        }
        AdSize adSize = this.f7892b;
        if (adSize == null ? kVar.f7892b != null : !adSize.equals(kVar.f7892b)) {
            return false;
        }
        if (this.f7893c == kVar.f7893c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f7891a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AdSize adSize = this.f7892b;
        int hashCode2 = (hashCode + (adSize != null ? adSize.hashCode() : 0)) * 31;
        C2321a aVar = this.f7893c;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CacheAdUnit{placementId='" + this.f7891a + '\'' + ", adSize=" + this.f7892b + ", adUnitType= " + this.f7893c + '}';
    }
}
