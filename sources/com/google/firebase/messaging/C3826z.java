package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.messaging.z */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3826z {

    /* renamed from: a */
    private final SharedPreferences f10567a;

    /* renamed from: b */
    private final String f10568b;

    /* renamed from: c */
    private final String f10569c;

    /* renamed from: d */
    private final ArrayDeque<String> f10570d = new ArrayDeque<>();

    /* renamed from: e */
    private final Executor f10571e;

    private C3826z(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f10567a = sharedPreferences;
        this.f10568b = str;
        this.f10569c = str2;
        this.f10571e = executor;
    }

    /* renamed from: a */
    static C3826z m12931a(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        C3826z zVar = new C3826z(sharedPreferences, str, str2, executor);
        synchronized (zVar.f10570d) {
            zVar.f10570d.clear();
            String string = zVar.f10567a.getString(zVar.f10568b, "");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains(zVar.f10569c)) {
                    String[] split = string.split(zVar.f10569c, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str3 : split) {
                        if (!TextUtils.isEmpty(str3)) {
                            zVar.f10570d.add(str3);
                        }
                    }
                }
            }
        }
        return zVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo27532b() {
        synchronized (this.f10570d) {
            SharedPreferences.Editor edit = this.f10567a.edit();
            String str = this.f10568b;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f10570d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(this.f10569c);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }

    /* renamed from: a */
    private final boolean m12932a(boolean z) {
        if (z) {
            this.f10571e.execute(new C3825y(this));
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo27531a(Object obj) {
        boolean remove;
        synchronized (this.f10570d) {
            remove = this.f10570d.remove(obj);
            m12932a(remove);
        }
        return remove;
    }

    /* renamed from: a */
    public final String mo27530a() {
        String peek;
        synchronized (this.f10570d) {
            peek = this.f10570d.peek();
        }
        return peek;
    }
}
