package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0906a();

    /* renamed from: a */
    ArrayList<FragmentState> f2295a;

    /* renamed from: b */
    ArrayList<String> f2296b;

    /* renamed from: c */
    BackStackState[] f2297c;

    /* renamed from: d */
    String f2298d = null;

    /* renamed from: e */
    int f2299e;

    /* renamed from: androidx.fragment.app.FragmentManagerState$a */
    static class C0906a implements Parcelable.Creator<FragmentManagerState> {
        C0906a() {
        }

        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2295a);
        parcel.writeStringList(this.f2296b);
        parcel.writeTypedArray(this.f2297c, i);
        parcel.writeString(this.f2298d);
        parcel.writeInt(this.f2299e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2295a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2296b = parcel.createStringArrayList();
        this.f2297c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2298d = parcel.readString();
        this.f2299e = parcel.readInt();
    }
}
