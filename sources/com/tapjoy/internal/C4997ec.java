package com.tapjoy.internal;

import android.text.TextUtils;
import com.tapjoy.internal.C4979ds;
import com.tapjoy.internal.C4990dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.ec */
public final class C4997ec extends C4989dx {
    public C4997ec(C4990dy.C4992b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        C4959dd a;
        if (!TextUtils.isEmpty(str) && (a = C4959dd.m16817a()) != null) {
            for (C4955cz czVar : Collections.unmodifiableCollection(a.f13484a)) {
                if (this.f13548a.contains(czVar.f13468f)) {
                    C4979ds dsVar = czVar.f13465c;
                    if (this.f13550c >= dsVar.f13518e) {
                        dsVar.f13517d = C4979ds.C4980a.f13520b;
                        C4964dg.m16825a().mo31063b(dsVar.mo31075c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (C4972dm.m16850b(this.f13549b, this.f13552e.mo31085a())) {
            return null;
        }
        this.f13552e.mo31086a(this.f13549b);
        return this.f13549b.toString();
    }
}
