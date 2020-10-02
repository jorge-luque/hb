package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tapjoy.internal.hj */
public final class C5159hj {

    /* renamed from: A */
    public final C5265o f14109A = new C5265o(this.f14114b, QumparaOfferwallUtil.COLUMN_IDFA);

    /* renamed from: B */
    public final C5142h f14110B = new C5142h(this.f14114b, "idfa.optout");

    /* renamed from: C */
    final C5142h f14111C = new C5142h(this.f14114b, "push.optout");

    /* renamed from: D */
    final C5265o f14112D = new C5265o(this.f14114b, "appId");

    /* renamed from: a */
    final Context f14113a;

    /* renamed from: b */
    final SharedPreferences f14114b;

    /* renamed from: c */
    final C5265o f14115c;

    /* renamed from: d */
    final C5265o f14116d = new C5265o(this.f14114b, "ir");

    /* renamed from: e */
    final C5251k f14117e = new C5251k(this.f14114b, "fql", 0);

    /* renamed from: f */
    final C5251k f14118f = new C5251k(this.f14114b, "fq", 0);

    /* renamed from: g */
    final C5265o f14119g = new C5265o(this.f14114b, "push");

    /* renamed from: h */
    final C5251k f14120h = new C5251k(this.f14114b, "ss", 0);

    /* renamed from: i */
    final C5262l f14121i = new C5262l(this.f14114b, "std");

    /* renamed from: j */
    final C5262l f14122j = new C5262l(this.f14114b, "slt");

    /* renamed from: k */
    final C5262l f14123k = new C5262l(this.f14114b, "sld");

    /* renamed from: l */
    final C5265o f14124l = new C5265o(this.f14114b, "ptc");

    /* renamed from: m */
    final C5251k f14125m = new C5251k(this.f14114b, "pc", 0);

    /* renamed from: n */
    final C5184i f14126n = new C5184i(this.f14114b, "ptp");

    /* renamed from: o */
    final C5262l f14127o = new C5262l(this.f14114b, "lpt");

    /* renamed from: p */
    final C5184i f14128p = new C5184i(this.f14114b, "plp");

    /* renamed from: q */
    final C5265o f14129q = new C5265o(this.f14114b, "adv");

    /* renamed from: r */
    final C5265o f14130r = new C5265o(this.f14114b, "ui");

    /* renamed from: s */
    final C5251k f14131s = new C5251k(this.f14114b, "ul", -1);

    /* renamed from: t */
    final C5251k f14132t = new C5251k(this.f14114b, "uf", -1);

    /* renamed from: u */
    final C5265o f14133u = new C5265o(this.f14114b, TapjoyConstants.TJC_USER_VARIABLE_1);

    /* renamed from: v */
    final C5265o f14134v = new C5265o(this.f14114b, TapjoyConstants.TJC_USER_VARIABLE_2);

    /* renamed from: w */
    final C5265o f14135w = new C5265o(this.f14114b, TapjoyConstants.TJC_USER_VARIABLE_3);

    /* renamed from: x */
    final C5265o f14136x = new C5265o(this.f14114b, TapjoyConstants.TJC_USER_VARIABLE_4);

    /* renamed from: y */
    final C5265o f14137y = new C5265o(this.f14114b, TapjoyConstants.TJC_USER_VARIABLE_5);

    /* renamed from: z */
    final C5265o f14138z = new C5265o(this.f14114b, "utags");

    private C5159hj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f14113a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("fiverocks", 0);
        this.f14114b = sharedPreferences;
        this.f14115c = new C5265o(sharedPreferences, "sdk");
    }

    /* renamed from: a */
    public static C5159hj m17376a(Context context) {
        return new C5159hj(context);
    }

    /* renamed from: b */
    public final String mo31336b() {
        String string = this.f14114b.getString("ir", (String) null);
        if (string == null) {
            File file = new File(C3145gz.m10326c(this.f14113a), TapjoyConstants.TJC_REFERRER);
            if (file.exists()) {
                try {
                    string = C3124bg.m10225a(file, C4888ak.f13355c);
                } catch (IOException unused) {
                }
            }
            this.f14114b.edit().putString("ir", string != null ? string : "").apply();
            if (string == null || string.length() <= 0) {
                return null;
            }
            return string;
        } else if (string.length() > 0) {
            return string;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SharedPreferences.Editor mo31334a() {
        return this.f14114b.edit();
    }

    /* renamed from: a */
    public final void mo31335a(boolean z) {
        C5264n.m17649a(this.f14114b, "gcm.onServer", z);
    }
}
