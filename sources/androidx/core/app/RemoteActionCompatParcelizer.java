package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.C1154b;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1750a = (IconCompat) versionedParcel.mo6139a(remoteActionCompat.f1750a, 1);
        remoteActionCompat.f1751b = versionedParcel.mo6141a(remoteActionCompat.f1751b, 2);
        remoteActionCompat.f1752c = versionedParcel.mo6141a(remoteActionCompat.f1752c, 3);
        remoteActionCompat.f1753d = (PendingIntent) versionedParcel.mo6138a(remoteActionCompat.f1753d, 4);
        remoteActionCompat.f1754e = versionedParcel.mo6153a(remoteActionCompat.f1754e, 5);
        remoteActionCompat.f1755f = versionedParcel.mo6153a(remoteActionCompat.f1755f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.mo6150a(false, false);
        versionedParcel.mo6159b((C1154b) remoteActionCompat.f1750a, 1);
        versionedParcel.mo6160b(remoteActionCompat.f1751b, 2);
        versionedParcel.mo6160b(remoteActionCompat.f1752c, 3);
        versionedParcel.mo6158b((Parcelable) remoteActionCompat.f1753d, 4);
        versionedParcel.mo6162b(remoteActionCompat.f1754e, 5);
        versionedParcel.mo6162b(remoteActionCompat.f1755f, 6);
    }
}
