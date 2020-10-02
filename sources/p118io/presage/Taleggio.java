package p118io.presage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import com.tapjoy.TJAdUnitConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: io.presage.Taleggio */
public final class Taleggio {

    /* renamed from: a */
    public static final CamembertauCalvados f16695a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final String f16696b;

    /* renamed from: c */
    private final String f16697c;

    /* renamed from: d */
    private final Context f16698d;

    /* renamed from: e */
    private final TimeZone f16699e;

    /* renamed from: f */
    private final DisplayMetrics f16700f;

    /* renamed from: io.presage.Taleggio$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private Taleggio(Context context, TimeZone timeZone, DisplayMetrics displayMetrics) {
        this.f16698d = context;
        this.f16699e = timeZone;
        this.f16700f = displayMetrics;
        String str = Build.MANUFACTURER;
        C6514hl.m21414a((Object) str, "Build.MANUFACTURER");
        this.f16696b = str;
        this.f16697c = Build.MODEL;
    }

    /* renamed from: a */
    public static String m20685a() {
        String str = Build.VERSION.RELEASE;
        C6514hl.m21414a((Object) str, "Build.VERSION.RELEASE");
        return str;
    }

    /* renamed from: b */
    public static String m20688b() {
        String property = System.getProperty("java.vm.version");
        return property == null ? "" : property;
    }

    /* renamed from: c */
    public static String m20689c() {
        String property = System.getProperty("java.vm.name");
        return property == null ? "" : property;
    }

    /* renamed from: d */
    public static String m20690d() {
        String property = System.getProperty("os.arch");
        return property == null ? "" : property;
    }

    /* renamed from: e */
    public static String m20691e() {
        try {
            String format = new SimpleDateFormat("Z", Locale.US).format(new Date());
            StringBuilder sb = new StringBuilder();
            C6514hl.m21414a((Object) format, "formattedTime");
            if (format != null) {
                String substring = format.substring(0, 3);
                C6514hl.m21414a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append(":");
                String substring2 = format.substring(3, format.length());
                C6514hl.m21414a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                return sb.toString();
            }
            throw new C6434em("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: f */
    public final String mo34693f() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(this.f16699e);
        String format = simpleDateFormat.format(date);
        C6514hl.m21414a((Object) format, "format.format(currentLocalDate)");
        return format;
    }

    /* renamed from: g */
    public final boolean mo34694g() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                if (Build.VERSION.SDK_INT < 21) {
                    if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(this.f16698d.getContentResolver(), "install_non_market_apps", 0) != 1) {
                        return false;
                    }
                    return true;
                }
            }
            if (Settings.Secure.getInt(this.f16698d.getContentResolver(), "install_non_market_apps", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = m20687a(r2.f16696b, r0);
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo34695h() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f16697c
            if (r0 == 0) goto L_0x000c
            java.lang.String r1 = r2.f16696b
            java.lang.String r0 = m20687a(r1, r0)
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = "Unknown"
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.Taleggio.mo34695h():java.lang.String");
    }

    /* renamed from: i */
    public final String mo34696i() {
        try {
            NetworkInfo a = C6576v.m21575a(this.f16698d);
            return a != null ? m20686a(a) : "UNKNOWN";
        } catch (Exception unused) {
            return "NONE";
        }
    }

    /* renamed from: j */
    public final int mo34697j() {
        return this.f16700f.widthPixels;
    }

    /* renamed from: k */
    public final int mo34698k() {
        return this.f16700f.heightPixels;
    }

    /* renamed from: l */
    public final int mo34699l() {
        Object systemService = this.f16698d.getSystemService("audio");
        if (systemService != null) {
            return ((AudioManager) systemService).getStreamVolume(3);
        }
        throw new C6434em("null cannot be cast to non-null type android.media.AudioManager");
    }

    /* renamed from: m */
    public final String mo34700m() {
        Resources resources = this.f16698d.getResources();
        C6514hl.m21414a((Object) resources, "context.resources");
        return resources.getConfiguration().orientation == 2 ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    /* renamed from: n */
    public final float mo34701n() {
        return this.f16700f.density;
    }

    /* renamed from: a */
    private static String m20687a(String str, String str2) {
        if (C6561je.m21509a(str2, str)) {
            return str2;
        }
        return str + " " + str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private /* synthetic */ Taleggio(android.content.Context r3, java.util.TimeZone r4) {
        /*
            r2 = this;
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            java.lang.String r1 = "Resources.getSystem()"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r0, (java.lang.String) r1)
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            java.lang.String r1 = "Resources.getSystem().displayMetrics"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r0, (java.lang.String) r1)
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.Taleggio.<init>(android.content.Context, java.util.TimeZone):void");
    }

    /* renamed from: a */
    private static String m20686a(NetworkInfo networkInfo) {
        if (C6576v.m21576a(networkInfo)) {
            String typeName = networkInfo.getTypeName();
            C6514hl.m21414a((Object) typeName, "info.typeName");
            return typeName;
        }
        return networkInfo.getTypeName() + " - " + networkInfo.getSubtypeName();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Taleggio(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.lang.String r1 = "TimeZone.getTimeZone(\"UTC\")"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r0, (java.lang.String) r1)
            r2.<init>(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.Taleggio.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public static Rect m20684a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect;
    }
}
