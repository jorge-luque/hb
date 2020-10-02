package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C1152a();

    /* renamed from: a */
    private final C1154b f3172a;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$a */
    static class C1152a implements Parcelable.Creator<ParcelImpl> {
        C1152a() {
        }

        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    protected ParcelImpl(Parcel parcel) {
        this.f3172a = new C1153a(parcel).mo6172j();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new C1153a(parcel).mo6145a(this.f3172a);
    }
}
