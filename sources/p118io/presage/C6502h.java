package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import java.util.concurrent.TimeUnit;

/* renamed from: io.presage.h */
public final class C6502h {

    /* renamed from: a */
    public static final CamembertauCalvados f17033a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c */
    public static C6502h f17034c;

    /* renamed from: b */
    private final SharedPreferences f17035b;

    /* renamed from: io.presage.h$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6502h m21397a(Context context) {
            if (C6502h.f17034c == null) {
                Context applicationContext = context.getApplicationContext();
                C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
                C6502h.f17034c = new C6502h(applicationContext, (byte) 0);
            }
            C6502h k = C6502h.f17034c;
            if (k == null) {
                C6514hl.m21413a();
            }
            return k;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private C6502h(Context context) {
        this.f17035b = context.getSharedPreferences("profig", 0);
    }

    /* renamed from: b */
    public final String mo35501b() {
        SharedPreferences sharedPreferences = this.f17035b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, "md5Profig", "");
    }

    /* renamed from: c */
    public final String mo35503c() {
        SharedPreferences sharedPreferences = this.f17035b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, "aaid", "");
    }

    /* renamed from: d */
    public final String mo35505d() {
        SharedPreferences sharedPreferences = this.f17035b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, "fullProfigResponseJson", "");
    }

    /* renamed from: e */
    public final void mo35507e() {
        this.f17035b.edit().putLong("numberOfDays", System.currentTimeMillis() / TimeUnit.DAYS.toMillis(1)).apply();
    }

    /* renamed from: f */
    public final long mo35509f() {
        return this.f17035b.getLong("numberOfDays", 0);
    }

    /* renamed from: g */
    public final String mo35511g() {
        String string = this.f17035b.getString("appVersion", C6221al.m20787a());
        return string == null ? "" : string;
    }

    /* renamed from: h */
    public final long mo35512h() {
        return this.f17035b.getLong("last_profig_sync", 0);
    }

    /* renamed from: i */
    public final String mo35513i() {
        SharedPreferences sharedPreferences = this.f17035b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, TapjoyConstants.TJC_API_KEY, "");
    }

    /* renamed from: j */
    public final String mo35514j() {
        SharedPreferences sharedPreferences = this.f17035b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, "mediationName", "none");
    }

    /* renamed from: a */
    public final void mo35498a(int i) {
        this.f17035b.edit().putInt("numberOfProfigApiCalls", i).apply();
    }

    /* renamed from: b */
    public final void mo35502b(String str) {
        this.f17035b.edit().putString("aaid", str).apply();
    }

    /* renamed from: c */
    public final void mo35504c(String str) {
        this.f17035b.edit().putString("fullProfigResponseJson", str).apply();
    }

    /* renamed from: d */
    public final void mo35506d(String str) {
        this.f17035b.edit().putString("appVersion", str).apply();
    }

    /* renamed from: f */
    public final void mo35510f(String str) {
        this.f17035b.edit().putString("mediationName", str).apply();
    }

    public /* synthetic */ C6502h(Context context, byte b) {
        this(context);
    }

    /* renamed from: a */
    public final int mo35497a() {
        return this.f17035b.getInt("numberOfProfigApiCalls", 0);
    }

    /* renamed from: e */
    public final void mo35508e(String str) {
        this.f17035b.edit().putString(TapjoyConstants.TJC_API_KEY, str).apply();
    }

    /* renamed from: a */
    public final void mo35500a(String str) {
        this.f17035b.edit().putString("md5Profig", str).apply();
    }

    /* renamed from: a */
    public final void mo35499a(long j) {
        this.f17035b.edit().putLong("last_profig_sync", j).apply();
    }
}
