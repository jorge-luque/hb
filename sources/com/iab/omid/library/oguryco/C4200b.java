package com.iab.omid.library.oguryco;

import android.content.Context;
import com.iab.omid.library.oguryco.p150b.C4202b;
import com.iab.omid.library.oguryco.p150b.C4206d;
import com.iab.omid.library.oguryco.p150b.C4209f;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4221e;

/* renamed from: com.iab.omid.library.oguryco.b */
public class C4200b {

    /* renamed from: a */
    private boolean f11286a;

    /* renamed from: b */
    private void m14129b(Context context) {
        C4221e.m14230a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo28713a() {
        return "1.3.1-Oguryco";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28714a(Context context) {
        m14129b(context);
        if (!mo28717b()) {
            mo28715a(true);
            C4209f.m14178a().mo28754a(context);
            C4202b.m14142a().mo28724a(context);
            C4217b.m14210a(context);
            C4206d.m14158a().mo28735a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28715a(boolean z) {
        this.f11286a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo28716a(String str) {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo28717b() {
        return this.f11286a;
    }
}
