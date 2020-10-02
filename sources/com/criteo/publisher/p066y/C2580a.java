package com.criteo.publisher.p066y;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.criteo.publisher.p054a0.C2343r;
import com.criteo.publisher.p066y.p067b.C2584c;
import com.criteo.publisher.p066y.p067b.C2585d;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.criteo.publisher.y.a */
public class C2580a {

    /* renamed from: d */
    private static final Pattern f8147d = Pattern.compile("^1(Y|N|-|y|n){3}$");

    /* renamed from: e */
    private static final List<String> f8148e = Arrays.asList(new String[]{"1ynn", "1yny", "1---", "", "1yn-", "1-n-"});

    /* renamed from: f */
    private static final List<String> f8149f = Arrays.asList(new String[]{"explicit_no", "potential_whitelist", "dnt"});

    /* renamed from: a */
    private final C2343r f8150a;

    /* renamed from: b */
    private final SharedPreferences f8151b;

    /* renamed from: c */
    private C2585d f8152c;

    public C2580a(Context context) {
        this(PreferenceManager.getDefaultSharedPreferences(context), new C2585d(context));
    }

    /* renamed from: g */
    private boolean m9681g() {
        return !Boolean.parseBoolean(mo10633d());
    }

    /* renamed from: h */
    private boolean m9682h() {
        String b = mo10631b();
        return !f8147d.matcher(b).matches() || f8148e.contains(b.toLowerCase(Locale.ROOT));
    }

    /* renamed from: a */
    public C2584c mo10628a() {
        return this.f8152c.mo10645a();
    }

    /* renamed from: b */
    public String mo10631b() {
        return this.f8150a.mo10165a("IABUSPrivacy_String", "");
    }

    /* renamed from: c */
    public String mo10632c() {
        return this.f8150a.mo10165a("MoPubConsent_String", "");
    }

    /* renamed from: d */
    public String mo10633d() {
        return this.f8150a.mo10165a("USPrivacy_Optout", "");
    }

    /* renamed from: e */
    public boolean mo10634e() {
        if (mo10631b().isEmpty()) {
            return m9681g();
        }
        return m9682h();
    }

    /* renamed from: f */
    public boolean mo10635f() {
        return !f8149f.contains(mo10632c().toLowerCase(Locale.ROOT));
    }

    /* renamed from: a */
    public void mo10630a(boolean z) {
        SharedPreferences.Editor edit = this.f8151b.edit();
        edit.putString("USPrivacy_Optout", String.valueOf(z));
        edit.apply();
    }

    C2580a(SharedPreferences sharedPreferences, C2585d dVar) {
        this.f8151b = sharedPreferences;
        this.f8150a = new C2343r(sharedPreferences);
        this.f8152c = dVar;
    }

    /* renamed from: a */
    public void mo10629a(String str) {
        SharedPreferences.Editor edit = this.f8151b.edit();
        edit.putString("MoPubConsent_String", str);
        edit.apply();
    }
}
