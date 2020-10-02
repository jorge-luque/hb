package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.C3616b;
import com.google.firebase.analytics.p122a.C3619a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.firebase.abt.component.a */
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public class C3617a {

    /* renamed from: a */
    private final Map<String, C3616b> f10131a = new HashMap();

    /* renamed from: b */
    private final Context f10132b;

    /* renamed from: c */
    private final C3619a f10133c;

    protected C3617a(Context context, C3619a aVar) {
        this.f10132b = context;
        this.f10133c = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3616b mo27190a(String str) {
        return new C3616b(this.f10132b, this.f10133c, str);
    }

    /* renamed from: b */
    public synchronized C3616b mo27191b(String str) {
        if (!this.f10131a.containsKey(str)) {
            this.f10131a.put(str, mo27190a(str));
        }
        return this.f10131a.get(str);
    }
}
