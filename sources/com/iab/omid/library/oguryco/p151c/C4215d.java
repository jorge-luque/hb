package com.iab.omid.library.oguryco.p151c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.oguryco.p151c.C4211a;
import com.iab.omid.library.oguryco.p152d.C4217b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.c.d */
public class C4215d implements C4211a {

    /* renamed from: a */
    private final int[] f11323a = new int[2];

    /* renamed from: a */
    private void m14200a(ViewGroup viewGroup, JSONObject jSONObject, C4211a.C4212a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo28760a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m14201b(ViewGroup viewGroup, JSONObject jSONObject, C4211a.C4212a aVar) {
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
                aVar.mo28760a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo28758a(View view) {
        if (view == null) {
            return C4217b.m14209a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f11323a);
        int[] iArr = this.f11323a;
        return C4217b.m14209a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo28759a(View view, JSONObject jSONObject, C4211a.C4212a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m14200a(viewGroup, jSONObject, aVar);
            } else {
                m14201b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
