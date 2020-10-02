package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static C1011c read(VersionedParcel versionedParcel) {
        C1011c cVar = new C1011c();
        cVar.f2581a = versionedParcel.mo6137a(cVar.f2581a, 1);
        cVar.f2582b = versionedParcel.mo6137a(cVar.f2582b, 2);
        cVar.f2583c = versionedParcel.mo6137a(cVar.f2583c, 3);
        cVar.f2584d = versionedParcel.mo6137a(cVar.f2584d, 4);
        return cVar;
    }

    public static void write(C1011c cVar, VersionedParcel versionedParcel) {
        versionedParcel.mo6150a(false, false);
        versionedParcel.mo6157b(cVar.f2581a, 1);
        versionedParcel.mo6157b(cVar.f2582b, 2);
        versionedParcel.mo6157b(cVar.f2583c, 3);
        versionedParcel.mo6157b(cVar.f2584d, 4);
    }
}
