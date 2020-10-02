package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* renamed from: androidx.media.b */
/* compiled from: AudioAttributesImplApi21 */
class C1010b implements C1009a {

    /* renamed from: a */
    AudioAttributes f2579a;

    /* renamed from: b */
    int f2580b = -1;

    C1010b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1010b)) {
            return false;
        }
        return this.f2579a.equals(((C1010b) obj).f2579a);
    }

    public int hashCode() {
        return this.f2579a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2579a;
    }
}
