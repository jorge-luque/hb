package com.iab.omid.library.oguryco.p151c;

import android.view.View;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p150b.C4201a;
import com.iab.omid.library.oguryco.p151c.C4211a;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4222f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.c.c */
public class C4214c implements C4211a {

    /* renamed from: a */
    private final C4211a f11322a;

    public C4214c(C4211a aVar) {
        this.f11322a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<View> mo28763a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C4201a a = C4201a.m14135a();
        if (a != null) {
            Collection<C4199a> c = a.mo28721c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C4199a d : c) {
                View d2 = d.mo28663d();
                if (d2 != null && C4222f.m14242c(d2) && (rootView = d2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C4222f.m14240a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C4222f.m14240a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo28758a(View view) {
        return C4217b.m14209a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo28759a(View view, JSONObject jSONObject, C4211a.C4212a aVar, boolean z) {
        Iterator<View> it = mo28763a().iterator();
        while (it.hasNext()) {
            aVar.mo28760a(it.next(), this.f11322a, jSONObject);
        }
    }
}
