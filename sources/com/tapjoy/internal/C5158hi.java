package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tapjoy.internal.hi */
public final class C5158hi {

    /* renamed from: a */
    final C5265o f14106a;

    /* renamed from: b */
    public final C5265o f14107b = new C5265o(this.f14108c, "noMoreToday.actionIds");

    /* renamed from: c */
    private final SharedPreferences f14108c;

    public C5158hi(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        this.f14108c = sharedPreferences;
        this.f14106a = new C5265o(sharedPreferences, "noMoreToday.date");
        mo31333b();
    }

    /* renamed from: a */
    static String m17374a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    /* renamed from: b */
    public final void mo31333b() {
        String a = this.f14106a.mo31485a();
        if (a != null && !m17374a().equals(a)) {
            this.f14106a.mo31486a((String) null);
            this.f14107b.mo31486a((String) null);
        }
    }
}
