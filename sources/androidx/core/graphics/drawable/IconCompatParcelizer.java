package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2076a = versionedParcel.mo6137a(iconCompat.f2076a, 1);
        iconCompat.f2078c = versionedParcel.mo6154a(iconCompat.f2078c, 2);
        iconCompat.f2079d = versionedParcel.mo6138a(iconCompat.f2079d, 3);
        iconCompat.f2080e = versionedParcel.mo6137a(iconCompat.f2080e, 4);
        iconCompat.f2081f = versionedParcel.mo6137a(iconCompat.f2081f, 5);
        iconCompat.f2082g = (ColorStateList) versionedParcel.mo6138a(iconCompat.f2082g, 6);
        iconCompat.f2084i = versionedParcel.mo6142a(iconCompat.f2084i, 7);
        iconCompat.mo4224d();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.mo6150a(true, true);
        iconCompat.mo4221a(versionedParcel.mo6165c());
        int i = iconCompat.f2076a;
        if (-1 != i) {
            versionedParcel.mo6157b(i, 1);
        }
        byte[] bArr = iconCompat.f2078c;
        if (bArr != null) {
            versionedParcel.mo6163b(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2079d;
        if (parcelable != null) {
            versionedParcel.mo6158b(parcelable, 3);
        }
        int i2 = iconCompat.f2080e;
        if (i2 != 0) {
            versionedParcel.mo6157b(i2, 4);
        }
        int i3 = iconCompat.f2081f;
        if (i3 != 0) {
            versionedParcel.mo6157b(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f2082g;
        if (colorStateList != null) {
            versionedParcel.mo6158b((Parcelable) colorStateList, 6);
        }
        String str = iconCompat.f2084i;
        if (str != null) {
            versionedParcel.mo6161b(str, 7);
        }
    }
}
