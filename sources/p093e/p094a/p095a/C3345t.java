package p093e.p094a.p095a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.places.model.PlaceFields;
import java.util.Date;
import java.util.Locale;

/* renamed from: e.a.a.t */
/* compiled from: DeviceInfo */
class C3345t {

    /* renamed from: A */
    String f9362A;

    /* renamed from: B */
    String f9363B;

    /* renamed from: C */
    String f9364C;

    /* renamed from: a */
    String f9365a;

    /* renamed from: b */
    String f9366b;

    /* renamed from: c */
    Boolean f9367c;

    /* renamed from: d */
    private boolean f9368d = false;

    /* renamed from: e */
    String f9369e;

    /* renamed from: f */
    String f9370f;

    /* renamed from: g */
    String f9371g;

    /* renamed from: h */
    String f9372h;

    /* renamed from: i */
    String f9373i;

    /* renamed from: j */
    String f9374j;

    /* renamed from: k */
    String f9375k;

    /* renamed from: l */
    String f9376l;

    /* renamed from: m */
    String f9377m;

    /* renamed from: n */
    String f9378n;

    /* renamed from: o */
    String f9379o;

    /* renamed from: p */
    String f9380p;

    /* renamed from: q */
    String f9381q;

    /* renamed from: r */
    String f9382r;

    /* renamed from: s */
    String f9383s;

    /* renamed from: t */
    String f9384t;

    /* renamed from: u */
    String f9385u;

    /* renamed from: v */
    String f9386v;

    /* renamed from: w */
    String f9387w;

    /* renamed from: x */
    String f9388x;

    /* renamed from: y */
    String f9389y;

    /* renamed from: z */
    String f9390z;

    C3345t(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale a = C3268a1.m10836a(configuration);
        int i = configuration.screenLayout;
        context.getContentResolver();
        this.f9374j = m11146g(context);
        this.f9375k = m11142e(context);
        this.f9376l = m11125a(i);
        this.f9377m = m11141e();
        this.f9378n = m11139d();
        this.f9379o = m11145g();
        this.f9380p = m11147h();
        this.f9381q = m11129b();
        this.f9382r = m11133b(a);
        this.f9383s = m11128a(a);
        this.f9384t = m11135c(i);
        this.f9385u = m11130b(i);
        this.f9386v = m11137c(displayMetrics);
        this.f9387w = m11131b(displayMetrics);
        this.f9388x = m11126a(displayMetrics);
        this.f9373i = m11127a(str);
        this.f9372h = m11144f(context);
        this.f9389y = m11143f();
        this.f9390z = m11124a();
        this.f9362A = m11134c();
        this.f9363B = m11136c(context);
        this.f9364C = m11140d(context);
    }

    /* renamed from: a */
    private String m11125a(int i) {
        int i2 = i & 15;
        if (i2 == 1 || i2 == 2) {
            return PlaceFields.PHONE;
        }
        if (i2 == 3 || i2 == 4) {
            return "tablet";
        }
        return null;
    }

    /* renamed from: b */
    private String m11130b(int i) {
        int i2 = i & 48;
        if (i2 == 16) {
            return "normal";
        }
        if (i2 != 32) {
            return null;
        }
        return "long";
    }

    /* renamed from: c */
    private String m11134c() {
        return Build.ID;
    }

    /* renamed from: c */
    private String m11135c(int i) {
        int i2 = i & 15;
        if (i2 == 1) {
            return "small";
        }
        if (i2 == 2) {
            return "normal";
        }
        if (i2 == 3) {
            return "large";
        }
        if (i2 != 4) {
            return null;
        }
        return "xlarge";
    }

    /* renamed from: d */
    private String m11139d() {
        return Build.MANUFACTURER;
    }

    /* renamed from: e */
    private String m11142e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    private String m11143f() {
        return Build.DISPLAY;
    }

    /* renamed from: g */
    private String m11145g() {
        return "android";
    }

    /* renamed from: g */
    private String m11146g(Context context) {
        return context.getPackageName();
    }

    /* renamed from: h */
    private String m11147h() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19092a(Context context) {
        if (!this.f9368d) {
            if (!C3268a1.m10840a(context, "android.permission.ACCESS_WIFI_STATE")) {
                C3309k.m11002d().mo19021b("Missing permission: ACCESS_WIFI_STATE", new Object[0]);
            }
            String c = C3268a1.m10858c(context);
            this.f9369e = m11132b(c);
            this.f9370f = m11138c(c);
            this.f9371g = C3268a1.m10829a(context);
            this.f9368d = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19093b(Context context) {
        this.f9366b = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            try {
                String a = C3354v.m11169a(context).mo19104a();
                this.f9365a = a;
                if (a != null) {
                    this.f9366b = "service";
                    break;
                }
            } catch (Exception unused) {
            }
            String g = C3268a1.m10867g(context);
            this.f9365a = g;
            if (g != null) {
                this.f9366b = "library";
                break;
            }
            i2++;
        }
        while (i < 3) {
            try {
                Boolean b = C3354v.m11169a(context).mo19105b();
                this.f9367c = b;
                if (b != null) {
                    return;
                }
            } catch (Exception unused2) {
            }
            Boolean h = C3268a1.m10868h(context);
            this.f9367c = h;
            if (h == null) {
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private String m11137c(DisplayMetrics displayMetrics) {
        int i = displayMetrics.densityDpi;
        if (i == 0) {
            return null;
        }
        if (i < 140) {
            return "low";
        }
        return i > 200 ? "high" : "medium";
    }

    /* renamed from: d */
    private String m11140d(Context context) {
        try {
            return C3268a1.f9092b.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).lastUpdateTime));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    private String m11144f(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[]{"aid"}, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return null;
            }
            if (!query.moveToFirst()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("aid"));
            query.close();
            return string;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private String m11138c(String str) {
        if (str == null) {
            return null;
        }
        return C3268a1.m10860d(str.replaceAll(":", ""));
    }

    /* renamed from: c */
    private String m11136c(Context context) {
        try {
            return C3268a1.f9092b.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).firstInstallTime));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    private String m11141e() {
        return Build.MODEL;
    }

    /* renamed from: a */
    private String m11128a(Locale locale) {
        return locale.getCountry();
    }

    /* renamed from: a */
    private String m11126a(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.heightPixels);
    }

    /* renamed from: b */
    private String m11129b() {
        return "" + Build.VERSION.SDK_INT;
    }

    /* renamed from: a */
    private String m11127a(String str) {
        if (str == null) {
            return "android4.16.0";
        }
        return C3268a1.m10834a("%s@%s", str, "android4.16.0");
    }

    /* renamed from: b */
    private String m11133b(Locale locale) {
        return locale.getLanguage();
    }

    /* renamed from: a */
    private String m11124a() {
        String[] d = C3268a1.m10861d();
        if (d == null || d.length == 0) {
            return C3268a1.m10852b();
        }
        return d[0];
    }

    /* renamed from: b */
    private String m11131b(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.widthPixels);
    }

    /* renamed from: b */
    private String m11132b(String str) {
        if (str == null) {
            return null;
        }
        return C3268a1.m10863e(str);
    }
}
