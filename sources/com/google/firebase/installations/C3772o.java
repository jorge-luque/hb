package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.p129p.C3779d;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.installations.o */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
class C3772o {

    /* renamed from: a */
    public static final long f10443a = TimeUnit.HOURS.toSeconds(1);

    static {
        Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    C3772o() {
    }

    /* renamed from: a */
    public boolean mo27412a(C3779d dVar) {
        if (!TextUtils.isEmpty(dVar.mo27413a()) && dVar.mo27420g() + dVar.mo27414b() >= mo27411a() + f10443a) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public long mo27411a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}
