package com.iab.omid.library.adcolony;

import android.content.Context;
import com.iab.omid.library.adcolony.p144b.C4151b;
import com.iab.omid.library.adcolony.p144b.C4155d;
import com.iab.omid.library.adcolony.p144b.C4158f;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4170e;

/* renamed from: com.iab.omid.library.adcolony.b */
public class C4149b {

    /* renamed from: a */
    private boolean f11165a;

    /* renamed from: b */
    private void m13901b(Context context) {
        C4170e.m14001a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo28500a() {
        return "1.3.4-Adcolony";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28501a(Context context) {
        m13901b(context);
        if (!mo28503b()) {
            mo28502a(true);
            C4158f.m13949a().mo28540a(context);
            C4151b.m13913a().mo28510a(context);
            C4166b.m13981a(context);
            C4155d.m13929a().mo28521a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28502a(boolean z) {
        this.f11165a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo28503b() {
        return this.f11165a;
    }
}
