package com.criteo.publisher.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.criteo.publisher.model.b */
abstract class C2436b extends C2462t {

    /* renamed from: a */
    private final String f7857a;

    /* renamed from: b */
    private final String f7858b;

    /* renamed from: c */
    private final String f7859c;

    /* renamed from: d */
    private final int f7860d;

    C2436b(String str, String str2, String str3, int i) {
        if (str != null) {
            this.f7857a = str;
            if (str2 != null) {
                this.f7858b = str2;
                if (str3 != null) {
                    this.f7859c = str3;
                    this.f7860d = i;
                    return;
                }
                throw new NullPointerException("Null sdkVersion");
            }
            throw new NullPointerException("Null bundleId");
        }
        throw new NullPointerException("Null criteoPublisherId");
    }

    /* renamed from: a */
    public String mo10327a() {
        return this.f7858b;
    }

    @SerializedName("cpId")
    /* renamed from: b */
    public String mo10328b() {
        return this.f7857a;
    }

    @SerializedName("rtbProfileId")
    /* renamed from: c */
    public int mo10329c() {
        return this.f7860d;
    }

    /* renamed from: d */
    public String mo10330d() {
        return this.f7859c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2462t)) {
            return false;
        }
        C2462t tVar = (C2462t) obj;
        if (!this.f7857a.equals(tVar.mo10328b()) || !this.f7858b.equals(tVar.mo10327a()) || !this.f7859c.equals(tVar.mo10330d()) || this.f7860d != tVar.mo10329c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f7857a.hashCode() ^ 1000003) * 1000003) ^ this.f7858b.hashCode()) * 1000003) ^ this.f7859c.hashCode()) * 1000003) ^ this.f7860d;
    }

    public String toString() {
        return "RemoteConfigRequest{criteoPublisherId=" + this.f7857a + ", bundleId=" + this.f7858b + ", sdkVersion=" + this.f7859c + ", profileId=" + this.f7860d + "}";
    }
}
