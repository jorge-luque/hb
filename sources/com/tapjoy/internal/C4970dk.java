package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.internal.C4967di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dk */
public final class C4970dk implements C4967di {

    /* renamed from: a */
    private final C4967di f13507a;

    public C4970dk(C4967di diVar) {
        this.f13507a = diVar;
    }

    /* renamed from: a */
    public final JSONObject mo31065a(View view) {
        return C4972dm.m16841a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public final void mo31066a(View view, JSONObject jSONObject, C4967di.C4968a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        C4959dd a = C4959dd.m16817a();
        if (a != null) {
            Collection<C4955cz> unmodifiableCollection = Collections.unmodifiableCollection(a.f13485b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (C4955cz c : unmodifiableCollection) {
                View c2 = c.mo31040c();
                if (c2 != null && C4976dp.m16857b(c2) && (rootView = c2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C4976dp.m16856a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C4976dp.m16856a((View) arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar.mo31067a((View) it.next(), this.f13507a, jSONObject);
        }
    }
}
