package com.iab.omid.library.oguryco.walking.p154a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.walking.a.b */
public abstract class C4235b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C4236a f11369a;

    /* renamed from: d */
    protected final C4237b f11370d;

    /* renamed from: com.iab.omid.library.oguryco.walking.a.b$a */
    public interface C4236a {
        /* renamed from: a */
        void mo28818a(C4235b bVar);
    }

    /* renamed from: com.iab.omid.library.oguryco.walking.a.b$b */
    public interface C4237b {
        /* renamed from: a */
        void mo28819a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo28820b();
    }

    public C4235b(C4237b bVar) {
        this.f11370d = bVar;
    }

    /* renamed from: a */
    public void mo28814a(C4236a aVar) {
        this.f11369a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C4236a aVar = this.f11369a;
        if (aVar != null) {
            aVar.mo28818a(this);
        }
    }

    /* renamed from: a */
    public void mo28816a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
