package com.tapjoy.internal;

import android.os.AsyncTask;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dy */
public abstract class C4990dy extends AsyncTask {

    /* renamed from: d */
    C4991a f13551d;

    /* renamed from: e */
    protected final C4992b f13552e;

    /* renamed from: com.tapjoy.internal.dy$a */
    public interface C4991a {
        /* renamed from: a */
        void mo31084a();
    }

    /* renamed from: com.tapjoy.internal.dy$b */
    public interface C4992b {
        /* renamed from: a */
        JSONObject mo31085a();

        /* renamed from: a */
        void mo31086a(JSONObject jSONObject);
    }

    public C4990dy(C4992b bVar) {
        this.f13552e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C4991a aVar = this.f13551d;
        if (aVar != null) {
            aVar.mo31084a();
        }
    }
}
