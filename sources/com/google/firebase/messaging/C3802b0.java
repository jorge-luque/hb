package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.messaging.b0 */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3802b0 {

    /* renamed from: d */
    private static final Pattern f10512d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a */
    private final String f10513a;

    /* renamed from: b */
    private final String f10514b;

    /* renamed from: c */
    private final String f10515c;

    private C3802b0(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str}));
            str3 = str2.substring(8);
        }
        if (str3 == null || !f10512d.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str3, "[a-zA-Z0-9-_.~%]{1,900}"}));
        }
        this.f10513a = str3;
        this.f10514b = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.f10515c = sb.toString();
    }

    /* renamed from: a */
    static C3802b0 m12846a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new C3802b0(split[0], split[1]);
    }

    /* renamed from: b */
    public final String mo27489b() {
        return this.f10514b;
    }

    /* renamed from: c */
    public final String mo27490c() {
        return this.f10515c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3802b0)) {
            return false;
        }
        C3802b0 b0Var = (C3802b0) obj;
        if (!this.f10513a.equals(b0Var.f10513a) || !this.f10514b.equals(b0Var.f10514b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f10514b, this.f10513a);
    }

    /* renamed from: a */
    public final String mo27488a() {
        return this.f10513a;
    }
}
