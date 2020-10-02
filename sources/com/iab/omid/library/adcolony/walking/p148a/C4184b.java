package com.iab.omid.library.adcolony.walking.p148a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.b */
public abstract class C4184b extends AsyncTask<Object, Void, String> {

    /* renamed from: d */
    protected final C4186b f11248d;

    /* renamed from: e */
    private C4185a f11249e;

    /* renamed from: com.iab.omid.library.adcolony.walking.a.b$a */
    public interface C4185a {
        /* renamed from: a */
        void mo28604a(C4184b bVar);
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.a.b$b */
    public interface C4186b {
        /* renamed from: a */
        void mo28605a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo28606b();
    }

    public C4184b(C4186b bVar) {
        this.f11248d = bVar;
    }

    /* renamed from: a */
    public void mo28600a(C4185a aVar) {
        this.f11249e = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C4185a aVar = this.f11249e;
        if (aVar != null) {
            aVar.mo28604a(this);
        }
    }

    /* renamed from: a */
    public void mo28602a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
