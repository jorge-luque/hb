package com.iab.omid.library.oguryco.walking.p154a;

import android.text.TextUtils;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p150b.C4201a;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.walking.p154a.C4235b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.walking.a.f */
public class C4241f extends C4234a {
    public C4241f(C4235b.C4237b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m14322b(String str) {
        C4201a a = C4201a.m14135a();
        if (a != null) {
            for (C4199a next : a.mo28719b()) {
                if (this.f11366a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo28774a(str, this.f11368c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C4217b.m14219b(this.f11367b, this.f11370d.mo28820b())) {
            return null;
        }
        this.f11370d.mo28819a(this.f11367b);
        return this.f11367b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m14322b(str);
        }
        super.onPostExecute(str);
    }
}
