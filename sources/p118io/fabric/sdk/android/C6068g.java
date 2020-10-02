package p118io.fabric.sdk.android;

import p118io.fabric.sdk.android.p200m.p202b.C6118x;
import p118io.fabric.sdk.android.services.concurrency.C6174e;
import p118io.fabric.sdk.android.services.concurrency.C6175f;
import p118io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* renamed from: io.fabric.sdk.android.g */
/* compiled from: InitializationTask */
class C6068g<Result> extends C6175f<Void, Void, Result> {

    /* renamed from: o */
    final C6069h<Result> f15989o;

    public C6068g(C6069h<Result> hVar) {
        this.f15989o = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo34124b(Result result) {
        this.f15989o.onPostExecute(result);
        this.f15989o.initializationCallback.mo34108a(result);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo34125c() {
        super.mo34125c();
        C6118x a = m19656a("onPreExecute");
        try {
            boolean onPreExecute = this.f15989o.onPreExecute();
            a.mo34216b();
            if (onPreExecute) {
                return;
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Exception e2) {
            C6059c.m19630f().mo34090b("Fabric", "Failure onPreExecute()", e2);
            a.mo34216b();
        } catch (Throwable th) {
            a.mo34216b();
            mo34266a(true);
            throw th;
        }
        mo34266a(true);
    }

    public C6174e getPriority() {
        return C6174e.HIGH;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Result mo34121a(Void... voidArr) {
        C6118x a = m19656a("doInBackground");
        Result doInBackground = !mo34268b() ? this.f15989o.doInBackground() : null;
        a.mo34216b();
        return doInBackground;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34123a(Result result) {
        this.f15989o.onCancelled(result);
        this.f15989o.initializationCallback.mo34107a((Exception) new InitializationException(this.f15989o.getIdentifier() + " Initialization was cancelled"));
    }

    /* renamed from: a */
    private C6118x m19656a(String str) {
        C6118x xVar = new C6118x(this.f15989o.getIdentifier() + "." + str, "KitInitialization");
        xVar.mo34215a();
        return xVar;
    }
}
