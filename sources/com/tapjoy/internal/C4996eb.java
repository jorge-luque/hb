package com.tapjoy.internal;

import com.tapjoy.internal.C4979ds;
import com.tapjoy.internal.C4990dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.eb */
public final class C4996eb extends C4989dx {
    public C4996eb(C4990dy.C4992b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        int i;
        C4959dd a = C4959dd.m16817a();
        if (a != null) {
            for (C4955cz czVar : Collections.unmodifiableCollection(a.f13484a)) {
                if (this.f13548a.contains(czVar.f13468f)) {
                    C4979ds dsVar = czVar.f13465c;
                    if (this.f13550c >= dsVar.f13518e && dsVar.f13517d != (i = C4979ds.C4980a.f13521c)) {
                        dsVar.f13517d = i;
                        C4964dg.m16825a().mo31063b(dsVar.mo31075c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.f13549b.toString();
    }
}
