package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class DefaultTrackSelector$SelectionOverride implements Parcelable {
    public static final Parcelable.Creator<DefaultTrackSelector$SelectionOverride> CREATOR = new C3049a();

    /* renamed from: a */
    public final int f8457a;

    /* renamed from: b */
    public final int[] f8458b;

    /* renamed from: c */
    public final int f8459c;

    /* renamed from: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride$a */
    static class C3049a implements Parcelable.Creator<DefaultTrackSelector$SelectionOverride> {
        C3049a() {
        }

        public DefaultTrackSelector$SelectionOverride createFromParcel(Parcel parcel) {
            return new DefaultTrackSelector$SelectionOverride(parcel);
        }

        public DefaultTrackSelector$SelectionOverride[] newArray(int i) {
            return new DefaultTrackSelector$SelectionOverride[i];
        }
    }

    public DefaultTrackSelector$SelectionOverride(int i, int... iArr) {
        this.f8457a = i;
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.f8458b = copyOf;
        this.f8459c = iArr.length;
        Arrays.sort(copyOf);
    }

    /* renamed from: a */
    public boolean mo13037a(int i) {
        for (int i2 : this.f8458b) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultTrackSelector$SelectionOverride.class != obj.getClass()) {
            return false;
        }
        DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride) obj;
        if (this.f8457a != defaultTrackSelector$SelectionOverride.f8457a || !Arrays.equals(this.f8458b, defaultTrackSelector$SelectionOverride.f8458b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f8457a * 31) + Arrays.hashCode(this.f8458b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8457a);
        parcel.writeInt(this.f8458b.length);
        parcel.writeIntArray(this.f8458b);
    }

    DefaultTrackSelector$SelectionOverride(Parcel parcel) {
        this.f8457a = parcel.readInt();
        int readByte = parcel.readByte();
        this.f8459c = readByte;
        int[] iArr = new int[readByte];
        this.f8458b = iArr;
        parcel.readIntArray(iArr);
    }
}
