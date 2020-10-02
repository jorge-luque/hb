package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import org.json.JSONException;

/* renamed from: com.google.firebase.remoteconfig.internal.l */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3854l {

    /* renamed from: a */
    private final C3842e f10648a;

    /* renamed from: b */
    private final C3842e f10649b;

    static {
        Charset.forName(C4250c.DEFAULT_CHARSET);
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public C3854l(C3842e eVar, C3842e eVar2) {
        this.f10648a = eVar;
        this.f10649b = eVar2;
    }

    /* renamed from: a */
    public String mo27584a(String str) {
        String a = m13043a(this.f10648a, str);
        if (a != null) {
            return a;
        }
        String a2 = m13043a(this.f10649b, str);
        if (a2 != null) {
            return a2;
        }
        m13044a(str, "String");
        return "";
    }

    /* renamed from: a */
    private static String m13043a(C3842e eVar, String str) {
        C3845f a = m13042a(eVar);
        if (a == null) {
            return null;
        }
        try {
            return a.mo27569b().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static C3845f m13042a(C3842e eVar) {
        return eVar.mo27566c();
    }

    /* renamed from: a */
    private static void m13044a(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", new Object[]{str2, str}));
    }
}
