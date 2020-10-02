package com.criteo.publisher.p065x;

import android.content.Context;
import android.os.AsyncTask;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.p054a0.C2324d;
import com.criteo.publisher.p054a0.C2338m;
import com.criteo.publisher.p064w.C2571a;
import com.criteo.publisher.p064w.C2572b;
import com.criteo.publisher.p066y.C2580a;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.x.a */
public class C2573a extends AsyncTask<Object, Void, JSONObject> {

    /* renamed from: a */
    private final C2571a f8123a = C2572b.m9650b(C2573a.class);

    /* renamed from: b */
    private final Context f8124b;

    /* renamed from: c */
    private final C2324d f8125c;

    /* renamed from: d */
    private final C2338m f8126d;

    /* renamed from: e */
    private final C2579d f8127e;

    /* renamed from: f */
    private final C2456q f8128f;

    /* renamed from: g */
    private final C2580a f8129g;

    public C2573a(Context context, C2324d dVar, C2338m mVar, C2579d dVar2, C2456q qVar, C2580a aVar) {
        this.f8124b = context;
        this.f8125c = dVar;
        this.f8126d = mVar;
        this.f8127e = dVar2;
        this.f8128f = qVar;
        this.f8129g = aVar;
    }

    /* renamed from: a */
    private JSONObject m9652a(Object[] objArr) throws Exception {
        int e = this.f8126d.mo10159e();
        String b = this.f8126d.mo10156b();
        String packageName = this.f8124b.getPackageName();
        JSONObject a = this.f8127e.mo10626a(2379, packageName, b, objArr[0], e, this.f8128f.mo10295a().get(), this.f8129g.mo10628a());
        this.f8123a.mo10611a("App event response: %s", a);
        return a;
    }

    /* renamed from: b */
    private void m9653b(JSONObject jSONObject) {
        super.onPostExecute(jSONObject);
        if (jSONObject == null || !jSONObject.has("throttleSec")) {
            this.f8125c.mo10111a(0);
        } else {
            this.f8125c.mo10111a(jSONObject.optInt("throttleSec", 0));
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject doInBackground(Object... objArr) {
        try {
            return m9652a(objArr);
        } catch (Throwable th) {
            this.f8123a.mo10613b("Internal AET exec error.", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(JSONObject jSONObject) {
        try {
            m9653b(jSONObject);
        } catch (Throwable th) {
            this.f8123a.mo10613b("Internal AET PostExec error.", th);
        }
    }
}
