package admost.adserver.videocache;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;

/* renamed from: admost.adserver.videocache.p */
/* compiled from: StorageUtils */
final class C0084p {
    /* renamed from: a */
    private static File m260a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File a = (!z || !"mounted".equals(str)) ? null : m259a(context);
        if (a == null) {
            a = context.getCacheDir();
        }
        if (a != null) {
            return a;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w("ADMOST-VIDEO", "Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }

    /* renamed from: b */
    public static File m261b(Context context) {
        return new File(m260a(context, true), "video-cache");
    }

    /* renamed from: a */
    private static File m259a(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.w("ADMOST-VIDEO", "Unable to create external cache directory");
        return null;
    }
}
