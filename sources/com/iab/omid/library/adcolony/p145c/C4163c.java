package com.iab.omid.library.adcolony.p145c;

import android.view.View;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p144b.C4150a;
import com.iab.omid.library.adcolony.p145c.C4160a;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4171f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.c.c */
public class C4163c implements C4160a {

    /* renamed from: a */
    private final C4160a f11201a;

    public C4163c(C4160a aVar) {
        this.f11201a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<View> mo28549a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C4150a a = C4150a.m13906a();
        if (a != null) {
            Collection<C4148a> c = a.mo28507c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C4148a d : c) {
                View d2 = d.mo28473d();
                if (d2 != null && C4171f.m14013c(d2) && (rootView = d2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C4171f.m14011a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C4171f.m14011a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo28544a(View view) {
        return C4166b.m13980a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo28545a(View view, JSONObject jSONObject, C4160a.C4161a aVar, boolean z) {
        Iterator<View> it = mo28549a().iterator();
        while (it.hasNext()) {
            aVar.mo28546a(it.next(), this.f11201a, jSONObject);
        }
    }
}
