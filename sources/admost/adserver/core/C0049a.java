package admost.adserver.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: admost.adserver.core.a */
/* compiled from: AdMostAdServerPreferences */
public class C0049a {

    /* renamed from: d */
    private static C0049a f139d;

    /* renamed from: e */
    private static final Object f140e = new Object();

    /* renamed from: a */
    private SharedPreferences f141a;

    /* renamed from: b */
    private SharedPreferences.Editor f142b;

    /* renamed from: c */
    private ThreadPoolExecutor f143c = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(20));

    private C0049a(Context context) {
        this.f141a = context.getSharedPreferences("ADMOST_ADSERVER", 0);
    }

    /* renamed from: a */
    public static C0049a m124a(Context context) {
        C0049a aVar = f139d;
        if (aVar != null) {
            return aVar;
        }
        return m126b(context);
    }

    /* renamed from: b */
    public static C0049a m126b(Context context) {
        if (f139d == null) {
            synchronized (f140e) {
                if (f139d == null) {
                    f139d = new C0049a(context);
                }
            }
        }
        return f139d;
    }

    /* renamed from: c */
    private SharedPreferences.Editor m127c() {
        if (this.f142b == null) {
            this.f142b = this.f141a.edit();
        }
        return this.f142b;
    }

    /* renamed from: a */
    private void m125a(String str, String str2) {
        m127c().putString(str, str2);
        m127c().apply();
    }

    /* renamed from: a */
    public ThreadPoolExecutor mo87a() {
        return this.f143c;
    }

    /* renamed from: b */
    public String mo88b() {
        String string = this.f141a.getString("KEY_ID", "");
        if (string.length() >= 1) {
            return string;
        }
        String hexString = Long.toHexString(Math.abs(new Random().nextLong() % 10000000000L));
        m125a("KEY_ID", hexString);
        return hexString;
    }
}
