package com.criteo.publisher.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AdSize implements Parcelable {
    public static final Parcelable.Creator<AdSize> CREATOR = new C2434a();

    /* renamed from: a */
    private int f7846a;

    /* renamed from: b */
    private int f7847b;

    /* renamed from: com.criteo.publisher.model.AdSize$a */
    static class C2434a implements Parcelable.Creator<AdSize> {
        C2434a() {
        }

        public AdSize createFromParcel(Parcel parcel) {
            return new AdSize(parcel);
        }

        public AdSize[] newArray(int i) {
            return new AdSize[i];
        }
    }

    public AdSize() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdSize.class != obj.getClass()) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (this.f7847b == adSize.f7847b && this.f7846a == adSize.f7846a) {
            return true;
        }
        return false;
    }

    public String getFormattedSize() {
        return this.f7846a + "x" + this.f7847b;
    }

    public int getHeight() {
        return this.f7847b;
    }

    public int getWidth() {
        return this.f7846a;
    }

    public int hashCode() {
        return (this.f7846a * 31) + this.f7847b;
    }

    public String toString() {
        return "AdSize{width=" + this.f7846a + ", height=" + this.f7847b + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7846a);
        parcel.writeInt(this.f7847b);
    }

    protected AdSize(Parcel parcel) {
        this.f7846a = parcel.readInt();
        this.f7847b = parcel.readInt();
    }

    public AdSize(int i, int i2) {
        this.f7847b = i2;
        this.f7846a = i;
    }
}
