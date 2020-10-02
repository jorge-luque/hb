package com.tapjoy.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tapjoy.internal.dw */
public final class C4988dw {

    /* renamed from: a */
    final HashMap f13540a = new HashMap();

    /* renamed from: b */
    final HashMap f13541b = new HashMap();

    /* renamed from: c */
    final HashMap f13542c = new HashMap();

    /* renamed from: d */
    final HashSet f13543d = new HashSet();

    /* renamed from: e */
    final HashSet f13544e = new HashSet();

    /* renamed from: f */
    final HashSet f13545f = new HashSet();

    /* renamed from: g */
    final HashMap f13546g = new HashMap();

    /* renamed from: h */
    boolean f13547h;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31081a(C4955cz czVar) {
        for (C4977dq dqVar : czVar.f13464b) {
            View view = (View) dqVar.get();
            if (view != null) {
                ArrayList arrayList = (ArrayList) this.f13542c.get(view);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f13542c.put(view, arrayList);
                }
                arrayList.add(czVar.f13468f);
            }
        }
    }
}
