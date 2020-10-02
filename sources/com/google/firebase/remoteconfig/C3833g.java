package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.C3616b;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.internal.C3842e;
import com.google.firebase.remoteconfig.internal.C3845f;
import com.google.firebase.remoteconfig.internal.C3852k;
import com.google.firebase.remoteconfig.internal.C3854l;
import com.google.firebase.remoteconfig.internal.C3855m;
import com.google.firebase.remoteconfig.internal.C3857o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.remoteconfig.g */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3833g {

    /* renamed from: a */
    private final Context f10582a;

    /* renamed from: b */
    private final C3616b f10583b;

    /* renamed from: c */
    private final Executor f10584c;

    /* renamed from: d */
    private final C3842e f10585d;

    /* renamed from: e */
    private final C3842e f10586e;

    /* renamed from: f */
    private final C3842e f10587f;

    /* renamed from: g */
    private final C3852k f10588g;

    /* renamed from: h */
    private final C3854l f10589h;

    /* renamed from: i */
    private final C3855m f10590i;

    C3833g(Context context, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, C3616b bVar, Executor executor, C3842e eVar, C3842e eVar2, C3842e eVar3, C3852k kVar, C3854l lVar, C3855m mVar) {
        this.f10582a = context;
        this.f10583b = bVar;
        this.f10584c = executor;
        this.f10585d = eVar;
        this.f10586e = eVar2;
        this.f10587f = eVar3;
        this.f10588g = kVar;
        this.f10589h = lVar;
        this.f10590i = mVar;
    }

    /* renamed from: a */
    public static C3833g m12949a(FirebaseApp firebaseApp) {
        return ((C3862k) firebaseApp.mo27171a(C3862k.class)).mo27604a();
    }

    /* renamed from: e */
    public static C3833g m12955e() {
        return m12949a(FirebaseApp.getInstance());
    }

    /* renamed from: b */
    public Task<Void> mo27547b() {
        return this.f10588g.mo27579a().onSuccessTask(C3831e.m12942a());
    }

    /* renamed from: c */
    public Task<Boolean> mo27548c() {
        return mo27547b().onSuccessTask(this.f10584c, C3829c.m12940a(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo27549d() {
        this.f10586e.mo27565b();
        this.f10587f.mo27565b();
        this.f10585d.mo27565b();
    }

    /* renamed from: b */
    static List<Map<String, String>> m12954b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    /* renamed from: a */
    public Task<Boolean> mo27542a() {
        Task<C3845f> b = this.f10585d.mo27565b();
        Task<C3845f> b2 = this.f10586e.mo27565b();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{b, b2}).continueWithTask(this.f10584c, C3830d.m12941a(this, b, b2));
    }

    /* renamed from: a */
    static /* synthetic */ Task m12944a(C3833g gVar, Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(false);
        }
        C3845f fVar = (C3845f) task.getResult();
        if (!task2.isSuccessful() || m12953a(fVar, (C3845f) task2.getResult())) {
            return gVar.f10586e.mo27561a(fVar).continueWith(gVar.f10584c, C3828b.m12939a(gVar));
        }
        return Tasks.forResult(false);
    }

    /* renamed from: a */
    public String mo27545a(String str) {
        return this.f10589h.mo27584a(str);
    }

    /* renamed from: a */
    public Task<Void> mo27544a(C3834h hVar) {
        return Tasks.call(this.f10584c, C3832f.m12943a(this, hVar));
    }

    /* renamed from: a */
    public Task<Void> mo27543a(int i) {
        return m12948a(C3857o.m13061a(this.f10582a, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12951a(Task<C3845f> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f10585d.mo27564a();
        if (task.getResult() != null) {
            mo27546a(task.getResult().mo27568a());
            return true;
        }
        Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
        return true;
    }

    /* renamed from: a */
    private Task<Void> m12948a(Map<String, String> map) {
        try {
            C3845f.C3847b e = C3845f.m13003e();
            e.mo27575a(map);
            return this.f10587f.mo27561a(e.mo27578a()).onSuccessTask(C3827a.m12938a());
        } catch (JSONException e2) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e2);
            return Tasks.forResult(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27546a(JSONArray jSONArray) {
        if (this.f10583b != null) {
            try {
                this.f10583b.mo27188a(m12954b(jSONArray));
            } catch (JSONException e) {
                Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e);
            } catch (AbtException e2) {
                Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e2);
            }
        }
    }

    /* renamed from: a */
    private static boolean m12953a(C3845f fVar, C3845f fVar2) {
        return fVar2 == null || !fVar.mo27570c().equals(fVar2.mo27570c());
    }
}
