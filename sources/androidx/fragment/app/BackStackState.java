package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.C0937k;
import androidx.lifecycle.C0965e;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0898a();

    /* renamed from: a */
    final int[] f2256a;

    /* renamed from: b */
    final ArrayList<String> f2257b;

    /* renamed from: c */
    final int[] f2258c;

    /* renamed from: d */
    final int[] f2259d;

    /* renamed from: e */
    final int f2260e;

    /* renamed from: f */
    final int f2261f;

    /* renamed from: g */
    final String f2262g;

    /* renamed from: h */
    final int f2263h;

    /* renamed from: i */
    final int f2264i;

    /* renamed from: j */
    final CharSequence f2265j;

    /* renamed from: k */
    final int f2266k;

    /* renamed from: l */
    final CharSequence f2267l;

    /* renamed from: m */
    final ArrayList<String> f2268m;

    /* renamed from: n */
    final ArrayList<String> f2269n;

    /* renamed from: o */
    final boolean f2270o;

    /* renamed from: androidx.fragment.app.BackStackState$a */
    static class C0898a implements Parcelable.Creator<BackStackState> {
        C0898a() {
        }

        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0908a aVar) {
        int size = aVar.f2400a.size();
        this.f2256a = new int[(size * 5)];
        if (aVar.f2407h) {
            this.f2257b = new ArrayList<>(size);
            this.f2258c = new int[size];
            this.f2259d = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                C0937k.C0938a aVar2 = aVar.f2400a.get(i);
                int i3 = i2 + 1;
                this.f2256a[i2] = aVar2.f2417a;
                ArrayList<String> arrayList = this.f2257b;
                Fragment fragment = aVar2.f2418b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f2256a;
                int i4 = i3 + 1;
                iArr[i3] = aVar2.f2419c;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f2420d;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f2421e;
                iArr[i6] = aVar2.f2422f;
                this.f2258c[i] = aVar2.f2423g.ordinal();
                this.f2259d[i] = aVar2.f2424h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.f2260e = aVar.f2405f;
            this.f2261f = aVar.f2406g;
            this.f2262g = aVar.f2408i;
            this.f2263h = aVar.f2316t;
            this.f2264i = aVar.f2409j;
            this.f2265j = aVar.f2410k;
            this.f2266k = aVar.f2411l;
            this.f2267l = aVar.f2412m;
            this.f2268m = aVar.f2413n;
            this.f2269n = aVar.f2414o;
            this.f2270o = aVar.f2415p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /* renamed from: a */
    public C0908a mo4474a(C0920i iVar) {
        C0908a aVar = new C0908a(iVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f2256a.length) {
            C0937k.C0938a aVar2 = new C0937k.C0938a();
            int i3 = i + 1;
            aVar2.f2417a = this.f2256a[i];
            if (C0920i.f2328H) {
                "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f2256a[i3];
            }
            String str = this.f2257b.get(i2);
            if (str != null) {
                aVar2.f2418b = iVar.f2342g.get(str);
            } else {
                aVar2.f2418b = null;
            }
            aVar2.f2423g = C0965e.C0967b.m3457a()[this.f2258c[i2]];
            aVar2.f2424h = C0965e.C0967b.m3457a()[this.f2259d[i2]];
            int[] iArr = this.f2256a;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            aVar2.f2419c = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            aVar2.f2420d = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar2.f2421e = i9;
            int i10 = iArr[i8];
            aVar2.f2422f = i10;
            aVar.f2401b = i5;
            aVar.f2402c = i7;
            aVar.f2403d = i9;
            aVar.f2404e = i10;
            aVar.mo4919a(aVar2);
            i2++;
            i = i8 + 1;
        }
        aVar.f2405f = this.f2260e;
        aVar.f2406g = this.f2261f;
        aVar.f2408i = this.f2262g;
        aVar.f2316t = this.f2263h;
        aVar.f2407h = true;
        aVar.f2409j = this.f2264i;
        aVar.f2410k = this.f2265j;
        aVar.f2411l = this.f2266k;
        aVar.f2412m = this.f2267l;
        aVar.f2413n = this.f2268m;
        aVar.f2414o = this.f2269n;
        aVar.f2415p = this.f2270o;
        aVar.mo4668a(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2256a);
        parcel.writeStringList(this.f2257b);
        parcel.writeIntArray(this.f2258c);
        parcel.writeIntArray(this.f2259d);
        parcel.writeInt(this.f2260e);
        parcel.writeInt(this.f2261f);
        parcel.writeString(this.f2262g);
        parcel.writeInt(this.f2263h);
        parcel.writeInt(this.f2264i);
        TextUtils.writeToParcel(this.f2265j, parcel, 0);
        parcel.writeInt(this.f2266k);
        TextUtils.writeToParcel(this.f2267l, parcel, 0);
        parcel.writeStringList(this.f2268m);
        parcel.writeStringList(this.f2269n);
        parcel.writeInt(this.f2270o ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2256a = parcel.createIntArray();
        this.f2257b = parcel.createStringArrayList();
        this.f2258c = parcel.createIntArray();
        this.f2259d = parcel.createIntArray();
        this.f2260e = parcel.readInt();
        this.f2261f = parcel.readInt();
        this.f2262g = parcel.readString();
        this.f2263h = parcel.readInt();
        this.f2264i = parcel.readInt();
        this.f2265j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2266k = parcel.readInt();
        this.f2267l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2268m = parcel.createStringArrayList();
        this.f2269n = parcel.createStringArrayList();
        this.f2270o = parcel.readInt() != 0;
    }
}
