package com.criteo.publisher.model;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;

/* renamed from: com.criteo.publisher.model.a */
abstract class C2435a extends C2453n {

    /* renamed from: a */
    private final String f7852a;

    /* renamed from: b */
    private final String f7853b;

    /* renamed from: c */
    private final Boolean f7854c;

    /* renamed from: d */
    private final Boolean f7855d;

    /* renamed from: e */
    private final Collection<String> f7856e;

    C2435a(String str, String str2, Boolean bool, Boolean bool2, Collection<String> collection) {
        if (str != null) {
            this.f7852a = str;
            if (str2 != null) {
                this.f7853b = str2;
                this.f7854c = bool;
                this.f7855d = bool2;
                if (collection != null) {
                    this.f7856e = collection;
                    return;
                }
                throw new NullPointerException("Null getSizes");
            }
            throw new NullPointerException("Null getPlacementId");
        }
        throw new NullPointerException("Null getImpressionId");
    }

    @SerializedName("impId")
    /* renamed from: a */
    public String mo10319a() {
        return this.f7852a;
    }

    @SerializedName("placementId")
    /* renamed from: b */
    public String mo10320b() {
        return this.f7853b;
    }

    @SerializedName("sizes")
    /* renamed from: c */
    public Collection<String> mo10321c() {
        return this.f7856e;
    }

    @SerializedName("interstitial")
    /* renamed from: d */
    public Boolean mo10322d() {
        return this.f7855d;
    }

    @SerializedName("isNative")
    /* renamed from: e */
    public Boolean mo10323e() {
        return this.f7854c;
    }

    public boolean equals(Object obj) {
        Boolean bool;
        Boolean bool2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2453n)) {
            return false;
        }
        C2453n nVar = (C2453n) obj;
        if (!this.f7852a.equals(nVar.mo10319a()) || !this.f7853b.equals(nVar.mo10320b()) || ((bool = this.f7854c) != null ? !bool.equals(nVar.mo10323e()) : nVar.mo10323e() != null) || ((bool2 = this.f7855d) != null ? !bool2.equals(nVar.mo10322d()) : nVar.mo10322d() != null) || !this.f7856e.equals(nVar.mo10321c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((this.f7852a.hashCode() ^ 1000003) * 1000003) ^ this.f7853b.hashCode()) * 1000003;
        Boolean bool = this.f7854c;
        int i = 0;
        int hashCode2 = (hashCode ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Boolean bool2 = this.f7855d;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.f7856e.hashCode();
    }

    public String toString() {
        return "CdbRequestSlot{getImpressionId=" + this.f7852a + ", getPlacementId=" + this.f7853b + ", isNativeAd=" + this.f7854c + ", isInterstitial=" + this.f7855d + ", getSizes=" + this.f7856e + "}";
    }
}
