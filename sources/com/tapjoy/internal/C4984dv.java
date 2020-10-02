package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tapjoy.internal.C4967di;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dv */
public final class C4984dv implements C4967di.C4968a {

    /* renamed from: a */
    public static Handler f13528a = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static C4984dv f13529c = new C4984dv();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f13530d = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f13531j = new Runnable() {
        public final void run() {
            C4984dv.m16875b(C4984dv.m16870a());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f13532k = new Runnable() {
        public final void run() {
            if (C4984dv.f13530d != null) {
                C4984dv.f13530d.post(C4984dv.f13531j);
                C4984dv.f13530d.postDelayed(C4984dv.f13532k, 200);
            }
        }
    };

    /* renamed from: b */
    public List f13533b = new ArrayList();

    /* renamed from: e */
    private int f13534e;

    /* renamed from: f */
    private C4969dj f13535f = new C4969dj();

    /* renamed from: g */
    private C4988dw f13536g = new C4988dw();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C4998ed f13537h = new C4998ed(new C4993dz());

    /* renamed from: i */
    private long f13538i;

    C4984dv() {
    }

    /* renamed from: a */
    public static C4984dv m16870a() {
        return f13529c;
    }

    /* renamed from: a */
    private void m16872a(long j) {
        if (this.f13533b.size() > 0) {
            Iterator it = this.f13533b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j);
            }
        }
    }

    /* renamed from: a */
    private void m16873a(View view, C4967di diVar, JSONObject jSONObject, int i) {
        diVar.mo31066a(view, jSONObject, this, i == C4999ee.f13566a);
    }

    /* renamed from: b */
    public static void m16874b() {
        if (f13530d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f13530d = handler;
            handler.post(f13531j);
            f13530d.postDelayed(f13532k, 200);
        }
    }

    /* renamed from: c */
    public static void m16876c() {
        Handler handler = f13530d;
        if (handler != null) {
            handler.removeCallbacks(f13532k);
            f13530d = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31067a(android.view.View r7, com.tapjoy.internal.C4967di r8, org.json.JSONObject r9) {
        /*
            r6 = this;
            java.lang.String r0 = com.tapjoy.internal.C4976dp.m16858c(r7)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            com.tapjoy.internal.dw r0 = r6.f13536g
            java.util.HashSet r3 = r0.f13543d
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto L_0x001b
            int r0 = com.tapjoy.internal.C4999ee.f13566a
            goto L_0x0024
        L_0x001b:
            boolean r0 = r0.f13547h
            if (r0 == 0) goto L_0x0022
            int r0 = com.tapjoy.internal.C4999ee.f13567b
            goto L_0x0024
        L_0x0022:
            int r0 = com.tapjoy.internal.C4999ee.f13568c
        L_0x0024:
            int r3 = com.tapjoy.internal.C4999ee.f13568c
            if (r0 != r3) goto L_0x0029
            return
        L_0x0029:
            org.json.JSONObject r3 = r8.mo31065a(r7)
            com.tapjoy.internal.C4972dm.m16847a((org.json.JSONObject) r9, (org.json.JSONObject) r3)
            com.tapjoy.internal.dw r9 = r6.f13536g
            java.util.HashMap r4 = r9.f13540a
            int r4 = r4.size()
            r5 = 0
            if (r4 != 0) goto L_0x003d
            r4 = r5
            goto L_0x004c
        L_0x003d:
            java.util.HashMap r4 = r9.f13540a
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x004c
            java.util.HashMap r9 = r9.f13540a
            r9.remove(r7)
        L_0x004c:
            if (r4 == 0) goto L_0x0056
            com.tapjoy.internal.C4972dm.m16844a((org.json.JSONObject) r3, (java.lang.String) r4)
            com.tapjoy.internal.dw r9 = r6.f13536g
            r9.f13547h = r2
            r1 = 1
        L_0x0056:
            if (r1 != 0) goto L_0x007e
            com.tapjoy.internal.dw r9 = r6.f13536g
            java.util.HashMap r1 = r9.f13542c
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0063
            goto L_0x0076
        L_0x0063:
            java.util.HashMap r1 = r9.f13542c
            java.lang.Object r1 = r1.get(r7)
            r5 = r1
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 == 0) goto L_0x0076
            java.util.HashMap r9 = r9.f13542c
            r9.remove(r7)
            java.util.Collections.sort(r5)
        L_0x0076:
            if (r5 == 0) goto L_0x007b
            com.tapjoy.internal.C4972dm.m16846a((org.json.JSONObject) r3, (java.util.List) r5)
        L_0x007b:
            r6.m16873a(r7, r8, r3, r0)
        L_0x007e:
            int r7 = r6.f13534e
            int r7 = r7 + r2
            r6.f13534e = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4984dv.mo31067a(android.view.View, com.tapjoy.internal.di, org.json.JSONObject):void");
    }

    /* renamed from: b */
    static /* synthetic */ void m16875b(C4984dv dvVar) {
        String str;
        dvVar.f13534e = 0;
        dvVar.f13538i = System.nanoTime();
        C4988dw dwVar = dvVar.f13536g;
        C4959dd a = C4959dd.m16817a();
        if (a != null) {
            for (C4955cz czVar : Collections.unmodifiableCollection(a.f13485b)) {
                View c = czVar.mo31040c();
                if (czVar.mo31041d()) {
                    String str2 = czVar.f13468f;
                    if (c != null) {
                        if (!c.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = c;
                            while (true) {
                                if (view == null) {
                                    dwVar.f13543d.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String c2 = C4976dp.m16858c(view);
                                if (c2 != null) {
                                    str = c2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            dwVar.f13544e.add(str2);
                            dwVar.f13540a.put(c, str2);
                            dwVar.mo31081a(czVar);
                        } else {
                            dwVar.f13545f.add(str2);
                            dwVar.f13541b.put(str2, c);
                            dwVar.f13546g.put(str2, str);
                        }
                    } else {
                        dwVar.f13545f.add(str2);
                        dwVar.f13546g.put(str2, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        C4970dk dkVar = dvVar.f13535f.f13506b;
        if (dvVar.f13536g.f13545f.size() > 0) {
            Iterator it = dvVar.f13536g.f13545f.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                JSONObject a2 = dkVar.mo31065a((View) null);
                View view2 = (View) dvVar.f13536g.f13541b.get(str3);
                C4971dl dlVar = dvVar.f13535f.f13505a;
                String str4 = (String) dvVar.f13536g.f13546g.get(str3);
                if (str4 != null) {
                    JSONObject a3 = dlVar.mo31065a(view2);
                    C4972dm.m16844a(a3, str3);
                    C4972dm.m16849b(a3, str4);
                    C4972dm.m16847a(a2, a3);
                }
                C4972dm.m16843a(a2);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(str3);
                C4998ed edVar = dvVar.f13537h;
                edVar.f13564a.mo31087a(new C4996eb(edVar, hashSet2, a2, nanoTime));
            }
        }
        if (dvVar.f13536g.f13544e.size() > 0) {
            JSONObject a4 = dkVar.mo31065a((View) null);
            dvVar.m16873a((View) null, dkVar, a4, C4999ee.f13566a);
            C4972dm.m16843a(a4);
            C4998ed edVar2 = dvVar.f13537h;
            edVar2.f13564a.mo31087a(new C4997ec(edVar2, dvVar.f13536g.f13544e, a4, nanoTime));
        } else {
            dvVar.f13537h.mo31091b();
        }
        C4988dw dwVar2 = dvVar.f13536g;
        dwVar2.f13540a.clear();
        dwVar2.f13541b.clear();
        dwVar2.f13542c.clear();
        dwVar2.f13543d.clear();
        dwVar2.f13544e.clear();
        dwVar2.f13545f.clear();
        dwVar2.f13546g.clear();
        dwVar2.f13547h = false;
        dvVar.m16872a(System.nanoTime() - dvVar.f13538i);
    }
}
