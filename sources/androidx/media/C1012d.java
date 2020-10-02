package androidx.media;

import android.os.Bundle;
import android.support.p004v4.media.MediaBrowserCompat;

/* renamed from: androidx.media.d */
/* compiled from: MediaBrowserCompatUtils */
public class C1012d {
    /* renamed from: a */
    public static boolean m3565a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
            return true;
        } else {
            return false;
        }
    }
}
