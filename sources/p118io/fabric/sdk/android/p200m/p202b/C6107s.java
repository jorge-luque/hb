package p118io.fabric.sdk.android.p200m.p202b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.m.b.s */
/* compiled from: IdManager */
public class C6107s {

    /* renamed from: m */
    private static final Pattern f16055m = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: n */
    private static final String f16056n = Pattern.quote("/");

    /* renamed from: a */
    private final ReentrantLock f16057a = new ReentrantLock();

    /* renamed from: b */
    private final C6109t f16058b;

    /* renamed from: c */
    private final boolean f16059c;

    /* renamed from: d */
    private final boolean f16060d;

    /* renamed from: e */
    private final Context f16061e;

    /* renamed from: f */
    private final String f16062f;

    /* renamed from: g */
    private final String f16063g;

    /* renamed from: h */
    private final Collection<C6069h> f16064h;

    /* renamed from: i */
    C6080c f16065i;

    /* renamed from: j */
    C6079b f16066j;

    /* renamed from: k */
    boolean f16067k;

    /* renamed from: l */
    C6106r f16068l;

    /* renamed from: io.fabric.sdk.android.m.b.s$a */
    /* compiled from: IdManager */
    public enum C6108a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        

        /* renamed from: a */
        public final int f16076a;

        static {
            WIFI_MAC_ADDRESS = new C6108a("WIFI_MAC_ADDRESS", 0, 1);
            BLUETOOTH_MAC_ADDRESS = new C6108a("BLUETOOTH_MAC_ADDRESS", 1, 2);
            FONT_TOKEN = new C6108a("FONT_TOKEN", 2, 53);
            ANDROID_ID = new C6108a("ANDROID_ID", 3, 100);
            ANDROID_DEVICE_ID = new C6108a("ANDROID_DEVICE_ID", 4, 101);
            ANDROID_SERIAL = new C6108a("ANDROID_SERIAL", 5, 102);
            ANDROID_ADVERTISING_ID = new C6108a("ANDROID_ADVERTISING_ID", 6, 103);
        }

        private C6108a(int i) {
            this.f16076a = i;
        }
    }

    public C6107s(Context context, String str, String str2, Collection<C6069h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection != null) {
            this.f16061e = context;
            this.f16062f = str;
            this.f16063g = str2;
            this.f16064h = collection;
            this.f16058b = new C6109t();
            this.f16065i = new C6080c(context);
            this.f16068l = new C6106r();
            boolean a = C6090i.m19737a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            this.f16059c = a;
            if (!a) {
                C6072k f = C6059c.m19630f();
                f.mo34093d("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            boolean a2 = C6090i.m19737a(context, "com.crashlytics.CollectUserIdentifiers", true);
            this.f16060d = a2;
            if (!a2) {
                C6072k f2 = C6059c.m19630f();
                f2.mo34093d("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    /* renamed from: b */
    private String m19791b(String str) {
        return str.replaceAll(f16056n, "");
    }

    /* renamed from: m */
    private Boolean m19792m() {
        C6079b b = mo34190b();
        if (b != null) {
            return Boolean.valueOf(b.f16007b);
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo34189a() {
        return this.f16060d;
    }

    /* renamed from: c */
    public String mo34191c() {
        return this.f16062f;
    }

    /* renamed from: d */
    public String mo34192d() {
        String str = this.f16063g;
        if (str != null) {
            return str;
        }
        SharedPreferences i = C6090i.m19754i(this.f16061e);
        m19787a(i);
        String string = i.getString("crashlytics.installation.id", (String) null);
        return string == null ? m19790b(i) : string;
    }

    /* renamed from: e */
    public Map<C6108a, String> mo34193e() {
        HashMap hashMap = new HashMap();
        for (C6069h next : this.f16064h) {
            if (next instanceof C6099n) {
                for (Map.Entry next2 : ((C6099n) next).getDeviceIdentifiers().entrySet()) {
                    m19789a(hashMap, (C6108a) next2.getKey(), (String) next2.getValue());
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: f */
    public String mo34194f() {
        return this.f16058b.mo34201a(this.f16061e);
    }

    /* renamed from: g */
    public String mo34195g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m19791b(Build.MANUFACTURER), m19791b(Build.MODEL)});
    }

    /* renamed from: h */
    public String mo34196h() {
        return m19791b(Build.VERSION.INCREMENTAL);
    }

    /* renamed from: i */
    public String mo34197i() {
        return m19791b(Build.VERSION.RELEASE);
    }

    /* renamed from: j */
    public String mo34198j() {
        return mo34197i() + "/" + mo34196h();
    }

    /* renamed from: k */
    public Boolean mo34199k() {
        if (mo34200l()) {
            return m19792m();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo34200l() {
        return this.f16059c && !this.f16068l.mo34188e(this.f16061e);
    }

    /* renamed from: a */
    private String m19786a(String str) {
        if (str == null) {
            return null;
        }
        return f16055m.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    private String m19790b(SharedPreferences sharedPreferences) {
        this.f16057a.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", (String) null);
            if (string == null) {
                string = m19786a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f16057a.unlock();
        }
    }

    /* renamed from: a */
    private void m19787a(SharedPreferences sharedPreferences) {
        C6079b b = mo34190b();
        if (b != null) {
            m19788a(sharedPreferences, b.f16006a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    private void m19788a(SharedPreferences sharedPreferences, String str) {
        this.f16057a.lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                String string = sharedPreferences.getString("crashlytics.advertising.id", (String) null);
                if (TextUtils.isEmpty(string)) {
                    sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
                } else if (!string.equals(str)) {
                    sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
                }
                this.f16057a.unlock();
            }
        } finally {
            this.f16057a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized C6079b mo34190b() {
        if (!this.f16067k) {
            this.f16066j = this.f16065i.mo34152a();
            this.f16067k = true;
        }
        return this.f16066j;
    }

    /* renamed from: a */
    private void m19789a(Map<C6108a, String> map, C6108a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }
}
