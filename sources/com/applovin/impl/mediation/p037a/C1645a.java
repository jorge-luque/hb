package com.applovin.impl.mediation.p037a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.mediation.p037a.p039b.C1656a;
import com.applovin.impl.mediation.p037a.p040c.p041a.C1664b;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.mediation.MaxDebuggerActivity;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a */
public class C1645a implements C1956a.C1959c<JSONObject> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WeakReference<MaxDebuggerActivity> f5130a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final AtomicBoolean f5131b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1941j f5132c;

    /* renamed from: d */
    private final C1977q f5133d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C1664b f5134e;

    /* renamed from: f */
    private final AtomicBoolean f5135f = new AtomicBoolean();

    /* renamed from: g */
    private boolean f5136g;

    public C1645a(C1941j jVar) {
        this.f5132c = jVar;
        this.f5133d = jVar.mo8602v();
        this.f5134e = new C1664b(jVar.mo8527E());
    }

    /* renamed from: a */
    private List<C1651d> m6269a(JSONObject jSONObject, C1941j jVar) {
        JSONArray b = C1993i.m7900b(jSONObject, "networks", new JSONArray(), jVar);
        ArrayList arrayList = new ArrayList(b.length());
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1993i.m7883a(b, i, (JSONObject) null, jVar);
            if (a != null) {
                arrayList.add(new C1651d(a, jVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: e */
    private void m6275e() {
        if (this.f5135f.compareAndSet(false, true)) {
            this.f5132c.mo8533L().mo8475a((C1864a) new C1656a(this, this.f5132c), C1907s.C1909a.MEDIATION_MAIN);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m6276f() {
        WeakReference<MaxDebuggerActivity> weakReference = f5130a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    public void mo7627a(int i) {
        C1977q qVar = this.f5133d;
        qVar.mo8746e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        C1977q.m7751i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f5134e.mo7698a((List<C1651d>) null, this.f5132c);
        this.f5135f.set(false);
    }

    /* renamed from: a */
    public void mo7628a(JSONObject jSONObject, int i) {
        List<C1651d> a = m6269a(jSONObject, this.f5132c);
        this.f5134e.mo7698a(a, this.f5132c);
        StringBuilder sb = new StringBuilder(" ");
        for (C1651d n : a) {
            String sb2 = sb.toString();
            String n2 = n.mo7666n();
            if (sb2.length() + n2.length() >= ((Integer) this.f5132c.mo8549a(C1841c.f5833ag)).intValue()) {
                C1977q.m7748f("MediationDebuggerService", sb2);
                sb.setLength(1);
            }
            sb.append(n2);
        }
        sb.append("\n------------------ END ------------------");
        C1977q.m7748f("MediationDebuggerService", sb.toString());
    }

    /* renamed from: a */
    public void mo7630a(boolean z) {
        this.f5136g = z;
    }

    /* renamed from: a */
    public boolean mo7631a() {
        return this.f5136g;
    }

    /* renamed from: b */
    public void mo7632b() {
        m6275e();
        if (m6276f() || !f5131b.compareAndSet(false, true)) {
            C1977q.m7751i("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        this.f5132c.mo8565aa().mo8071a(new C1984a() {
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1977q.m7748f("AppLovinSdk", "Mediation debugger destroyed");
                    C1645a.this.f5132c.mo8565aa().mo8073b(this);
                    WeakReference unused = C1645a.f5130a = null;
                }
            }

            public void onActivityStarted(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1977q.m7748f("AppLovinSdk", "Started mediation debugger");
                    if (!C1645a.this.m6276f() || C1645a.f5130a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = C1645a.f5130a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(C1645a.this.f5134e, C1645a.this.f5132c.mo8565aa());
                    }
                    C1645a.f5131b.set(false);
                }
            }
        });
        Context E = this.f5132c.mo8527E();
        Intent intent = new Intent(E, MaxDebuggerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        C1977q.m7748f("AppLovinSdk", "Starting mediation debugger...");
        E.startActivity(intent);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f5134e + "}";
    }
}
