package com.criteo.publisher.model;

import com.criteo.publisher.model.C2446i;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.criteo.publisher.model.v */
public abstract class C2464v {
    /* renamed from: a */
    public static C2464v m9307a(Boolean bool, String str, String str2, String str3, String str4, Boolean bool2) {
        return new C2446i(bool, str, str2, str3, str4, bool2);
    }

    /* renamed from: g */
    public static C2464v m9309g() {
        return m9307a((Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagDataMacro")
    /* renamed from: a */
    public abstract String mo10334a();

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagDataMode")
    /* renamed from: b */
    public abstract String mo10335b();

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidAdTagUrlMode")
    /* renamed from: c */
    public abstract String mo10336c();

    /* access modifiers changed from: package-private */
    @SerializedName("AndroidDisplayUrlMacro")
    /* renamed from: d */
    public abstract String mo10337d();

    /* renamed from: e */
    public abstract Boolean mo10338e();

    /* renamed from: f */
    public abstract Boolean mo10340f();

    /* renamed from: a */
    public C2464v mo10400a(Boolean bool) {
        return m9307a(bool, mo10337d(), mo10336c(), mo10334a(), mo10335b(), mo10338e());
    }

    /* renamed from: a */
    public static TypeAdapter<C2464v> m9308a(Gson gson) {
        return new C2446i.C2447a(gson);
    }
}
