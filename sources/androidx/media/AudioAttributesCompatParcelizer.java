package androidx.media;

import androidx.versionedparcelable.C1154b;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2578a = (C1009a) versionedParcel.mo6139a(audioAttributesCompat.f2578a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.mo6150a(false, false);
        versionedParcel.mo6159b((C1154b) audioAttributesCompat.f2578a, 1);
    }
}
