package com.iab.omid.library.adcolony.walking.p148a;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p144b.C4150a;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.walking.p148a.C4184b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.f */
public class C4190f extends C4183a {
    public C4190f(C4184b.C4186b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m14093b(String str) {
        C4150a a = C4150a.m13906a();
        if (a != null) {
            for (C4148a next : a.mo28505b()) {
                if (this.f11245a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo28560a(str, this.f11247c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C4166b.m13990b(this.f11246b, this.f11248d.mo28606b())) {
            return null;
        }
        this.f11248d.mo28605a(this.f11246b);
        return this.f11246b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m14093b(str);
        }
        super.onPostExecute(str);
    }
}
