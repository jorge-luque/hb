package com.iab.omid.library.adcolony.walking.p148a;

import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p144b.C4150a;
import com.iab.omid.library.adcolony.walking.p148a.C4184b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.e */
public class C4189e extends C4183a {
    public C4189e(C4184b.C4186b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m14090b(String str) {
        C4150a a = C4150a.m13906a();
        if (a != null) {
            for (C4148a next : a.mo28505b()) {
                if (this.f11245a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo28565b(str, this.f11247c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f11246b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m14090b(str);
        super.onPostExecute(str);
    }
}
