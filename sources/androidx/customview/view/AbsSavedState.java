package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new C0889a();

    /* renamed from: b */
    public static final AbsSavedState f2198b = new AbsSavedState() {
    };

    /* renamed from: a */
    private final Parcelable f2199a;

    /* renamed from: androidx.customview.view.AbsSavedState$a */
    static class C0889a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        C0889a() {
        }

        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }

        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f2198b;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }
    }

    /* renamed from: a */
    public final Parcelable mo4406a() {
        return this.f2199a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2199a, i);
    }

    private AbsSavedState() {
        this.f2199a = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2199a = parcelable == f2198b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2199a = readParcelable == null ? f2198b : readParcelable;
    }
}
