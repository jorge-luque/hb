package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.adcolony.sdk.C1439u;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.adcolony.sdk.y */
class C1455y {

    /* renamed from: a */
    private ArrayList<C1201a0> f4559a = new ArrayList<>();

    /* renamed from: b */
    private HashMap<Integer, C1201a0> f4560b = new HashMap<>();

    /* renamed from: c */
    private int f4561c = 2;

    /* renamed from: d */
    private HashMap<String, ArrayList<C1458z>> f4562d = new HashMap<>();

    /* renamed from: e */
    private JSONArray f4563e = C1437s.m5579a();

    /* renamed from: f */
    private int f4564f = 1;

    /* renamed from: com.adcolony.sdk.y$a */
    class C1456a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f4565a;

        C1456a(Context context) {
            this.f4565a = context;
        }

        public void run() {
            JSONObject b = C1199a.m4880c().mo6552r().mo6272b();
            JSONObject b2 = C1437s.m5599b();
            C1437s.m5592a(b, "os_name", "android");
            C1437s.m5592a(b2, "filepath", C1199a.m4880c().mo6555v().mo6509a() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            C1437s.m5594a(b2, TJAdUnitConstants.String.VIDEO_INFO, b);
            C1437s.m5602b(b2, "m_origin", 0);
            C1437s.m5602b(b2, "m_id", C1455y.m5673a(C1455y.this));
            C1437s.m5592a(b2, "m_type", "Controller.create");
            try {
                new C1379m0(this.f4565a, 1, false).mo6712a(true, new C1454x(b2));
            } catch (RuntimeException e) {
                C1439u.C1440a aVar = new C1439u.C1440a();
                aVar.mo6801a(e.toString() + ": during WebView initialization.").mo6801a(" Disabling AdColony.").mo6803a(C1439u.f4516i);
                AdColony.disable();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.y$b */
    class C1457b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4567a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f4568b;

        C1457b(String str, JSONObject jSONObject) {
            this.f4567a = str;
            this.f4568b = jSONObject;
        }

        public void run() {
            C1455y.this.mo6839a(this.f4567a, this.f4568b);
        }
    }

    C1455y() {
    }

    /* renamed from: a */
    static /* synthetic */ int m5673a(C1455y yVar) {
        int i = yVar.f4564f;
        yVar.f4564f = i + 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6842b(String str, C1458z zVar) {
        synchronized (this.f4562d) {
            ArrayList arrayList = this.f4562d.get(str);
            if (arrayList != null) {
                arrayList.remove(zVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashMap<Integer, C1201a0> mo6843c() {
        return this.f4560b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo6844d() {
        int i = this.f4561c;
        this.f4561c = i + 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo6845e() {
        synchronized (this.f4559a) {
            for (int size = this.f4559a.size() - 1; size >= 0; size--) {
                this.f4559a.get(size).mo6386a();
            }
        }
        JSONArray jSONArray = null;
        if (this.f4563e.length() > 0) {
            jSONArray = this.f4563e;
            this.f4563e = C1437s.m5579a();
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("m_type");
                    if (jSONObject.getInt("m_origin") >= 2) {
                        C1359k0.m5309a((Runnable) new C1457b(string, jSONObject));
                    } else {
                        mo6839a(string, jSONObject);
                    }
                } catch (JSONException e) {
                    new C1439u.C1440a().mo6801a("JSON error from message dispatcher's updateModules(): ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6838a(String str, C1458z zVar) {
        ArrayList arrayList = this.f4562d.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f4562d.put(str, arrayList);
        }
        arrayList.add(zVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<C1201a0> mo6841b() {
        return this.f4559a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6837a() {
        Context b;
        C1290h c = C1199a.m4880c();
        if (!c.mo6516A() && !c.mo6517B() && (b = C1199a.m4878b()) != null) {
            C1359k0.m5309a((Runnable) new C1456a(b));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1201a0 mo6836a(C1201a0 a0Var) {
        synchronized (this.f4559a) {
            int c = a0Var.mo6389c();
            if (c <= 0) {
                c = a0Var.mo6390d();
            }
            this.f4559a.add(a0Var);
            this.f4560b.put(Integer.valueOf(c), a0Var);
        }
        return a0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1201a0 mo6835a(int i) {
        synchronized (this.f4559a) {
            C1201a0 a0Var = this.f4560b.get(Integer.valueOf(i));
            if (a0Var == null) {
                return null;
            }
            this.f4559a.remove(a0Var);
            this.f4560b.remove(Integer.valueOf(i));
            a0Var.mo6388b();
            return a0Var;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6839a(String str, JSONObject jSONObject) {
        synchronized (this.f4562d) {
            ArrayList arrayList = this.f4562d.get(str);
            if (arrayList != null) {
                C1454x xVar = new C1454x(jSONObject);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((C1458z) it.next()).mo6395a(xVar);
                    } catch (RuntimeException e) {
                        new C1439u.C1440a().mo6800a((Object) e).mo6803a(C1439u.f4517j);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6840a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("m_id")) {
                int i = this.f4564f;
                this.f4564f = i + 1;
                jSONObject.put("m_id", i);
            }
            if (!jSONObject.has("m_origin")) {
                jSONObject.put("m_origin", 0);
            }
            int i2 = jSONObject.getInt("m_target");
            if (i2 == 0) {
                synchronized (this) {
                    this.f4563e.put(jSONObject);
                }
                return;
            }
            C1201a0 a0Var = this.f4560b.get(Integer.valueOf(i2));
            if (a0Var != null) {
                a0Var.mo6387a(jSONObject);
            }
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a("JSON error in ADCMessageDispatcher's sendMessage(): ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
        }
    }
}
