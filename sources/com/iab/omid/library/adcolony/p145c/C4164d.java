package com.iab.omid.library.adcolony.p145c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.adcolony.p145c.C4160a;
import com.iab.omid.library.adcolony.p146d.C4166b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.c.d */
public class C4164d implements C4160a {

    /* renamed from: a */
    private final int[] f11202a = new int[2];

    /* renamed from: a */
    private void m13971a(ViewGroup viewGroup, JSONObject jSONObject, C4160a.C4161a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo28546a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m13972b(ViewGroup viewGroup, JSONObject jSONObject, C4160a.C4161a aVar) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo28546a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo28544a(View view) {
        if (view == null) {
            return C4166b.m13980a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f11202a);
        int[] iArr = this.f11202a;
        return C4166b.m13980a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo28545a(View view, JSONObject jSONObject, C4160a.C4161a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m13971a(viewGroup, jSONObject, aVar);
            } else {
                m13972b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
