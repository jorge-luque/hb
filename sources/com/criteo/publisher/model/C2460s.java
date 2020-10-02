package com.criteo.publisher.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.model.s */
public class C2460s implements Parcelable {
    public static final Parcelable.Creator<C2460s> CREATOR = new C2461a();

    /* renamed from: a */
    private final String f7921a;

    /* renamed from: b */
    private final String f7922b;

    /* renamed from: com.criteo.publisher.model.s$a */
    static class C2461a implements Parcelable.Creator<C2460s> {
        C2461a() {
        }

        public C2460s createFromParcel(Parcel parcel) {
            return new C2460s(parcel);
        }

        public C2460s[] newArray(int i) {
            return new C2460s[i];
        }
    }

    public C2460s(Context context, String str) {
        this.f7921a = context.getPackageName();
        this.f7922b = str;
    }

    /* renamed from: a */
    public String mo10392a() {
        return this.f7921a;
    }

    /* renamed from: b */
    public String mo10393b() {
        return this.f7922b;
    }

    /* renamed from: c */
    public JSONObject mo10394c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bundleId", this.f7921a);
        if (!TextUtils.isEmpty(this.f7922b)) {
            jSONObject.put("cpId", this.f7922b);
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7921a);
        parcel.writeString(this.f7922b);
    }

    protected C2460s(Parcel parcel) {
        this.f7921a = parcel.readString();
        this.f7922b = parcel.readString();
    }
}
