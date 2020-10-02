package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static C1010b read(VersionedParcel versionedParcel) {
        C1010b bVar = new C1010b();
        bVar.f2579a = (AudioAttributes) versionedParcel.mo6138a(bVar.f2579a, 1);
        bVar.f2580b = versionedParcel.mo6137a(bVar.f2580b, 2);
        return bVar;
    }

    public static void write(C1010b bVar, VersionedParcel versionedParcel) {
        versionedParcel.mo6150a(false, false);
        versionedParcel.mo6158b((Parcelable) bVar.f2579a, 1);
        versionedParcel.mo6157b(bVar.f2580b, 2);
    }
}
