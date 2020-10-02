package com.iab.omid.library.oguryco.walking.p154a;

import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p150b.C4201a;
import com.iab.omid.library.oguryco.walking.p154a.C4235b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.walking.a.e */
public class C4240e extends C4234a {
    public C4240e(C4235b.C4237b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m14319b(String str) {
        C4201a a = C4201a.m14135a();
        if (a != null) {
            for (C4199a next : a.mo28719b()) {
                if (this.f11366a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo28779b(str, this.f11368c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f11367b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m14319b(str);
        super.onPostExecute(str);
    }
}
