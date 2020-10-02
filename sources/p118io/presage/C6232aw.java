package p118io.presage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.drive.DriveFile;

/* renamed from: io.presage.aw */
public final class C6232aw {

    /* renamed from: a */
    public static final C6232aw f16774a = new C6232aw();

    private C6232aw() {
    }

    /* renamed from: a */
    public static void m20830a(Context context, String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                Uri parse = Uri.parse(str);
                C6514hl.m21414a((Object) parse, ShareConstants.MEDIA_URI);
                m20829a(context, parse);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static boolean m20832b(Context context, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            C6514hl.m21414a((Object) parseUri, "intent");
            if (m20831b(context, parseUri)) {
                m20828a(context, parseUri);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m20833c(Context context, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            C6514hl.m21414a((Object) parseUri, "intent");
            return m20831b(context, parseUri);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m20829a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (m20831b(context, intent)) {
            m20828a(context, intent);
        }
    }

    /* renamed from: b */
    private static boolean m20831b(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: a */
    private static void m20828a(Context context, Intent intent) {
        if (m20831b(context, intent)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
    }
}
