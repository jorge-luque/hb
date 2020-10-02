package p118io.fabric.sdk.android.p200m.p205e;

import android.content.res.Resources;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6071j;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6116v;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: io.fabric.sdk.android.m.e.a */
/* compiled from: AbstractAppSpiCall */
abstract class C6134a extends C6078a {
    public C6134a(C6069h hVar, String str, String str2, C6200d dVar, C6199c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    /* renamed from: b */
    private HttpRequest m19869b(HttpRequest httpRequest, C6137d dVar) {
        httpRequest.mo34348e("app[identifier]", dVar.f16125b);
        httpRequest.mo34348e("app[name]", dVar.f16129f);
        httpRequest.mo34348e("app[display_version]", dVar.f16126c);
        httpRequest.mo34348e("app[build_version]", dVar.f16127d);
        httpRequest.mo34326a("app[source]", (Number) Integer.valueOf(dVar.f16130g));
        httpRequest.mo34348e("app[minimum_sdk_version]", dVar.f16131h);
        httpRequest.mo34348e("app[built_sdk_version]", dVar.f16132i);
        if (!C6090i.m19743b(dVar.f16128e)) {
            httpRequest.mo34348e("app[instance_identifier]", dVar.f16128e);
        }
        if (dVar.f16133j != null) {
            InputStream inputStream = null;
            try {
                inputStream = this.kit.getContext().getResources().openRawResource(dVar.f16133j.f16154b);
                httpRequest.mo34348e("app[icon][hash]", dVar.f16133j.f16153a);
                httpRequest.mo34331a("app[icon][data]", "icon.png", "application/octet-stream", inputStream);
                httpRequest.mo34326a("app[icon][width]", (Number) Integer.valueOf(dVar.f16133j.f16155c));
                httpRequest.mo34326a("app[icon][height]", (Number) Integer.valueOf(dVar.f16133j.f16156d));
            } catch (Resources.NotFoundException e) {
                C6072k f = C6059c.m19630f();
                f.mo34090b("Fabric", "Failed to find app icon with resource ID: " + dVar.f16133j.f16154b, e);
            } catch (Throwable th) {
                C6090i.m19733a((Closeable) inputStream, "Failed to close app icon InputStream.");
                throw th;
            }
            C6090i.m19733a((Closeable) inputStream, "Failed to close app icon InputStream.");
        }
        Collection<C6071j> collection = dVar.f16134k;
        if (collection != null) {
            for (C6071j next : collection) {
                httpRequest.mo34348e(mo34246b(next), next.mo34141c());
                httpRequest.mo34348e(mo34244a(next), next.mo34139a());
            }
        }
        return httpRequest;
    }

    /* renamed from: a */
    public boolean mo34245a(C6137d dVar) {
        HttpRequest httpRequest = getHttpRequest();
        m19868a(httpRequest, dVar);
        m19869b(httpRequest, dVar);
        C6072k f = C6059c.m19630f();
        f.mo34093d("Fabric", "Sending app info to " + getUrl());
        if (dVar.f16133j != null) {
            C6072k f2 = C6059c.m19630f();
            f2.mo34093d("Fabric", "App icon hash is " + dVar.f16133j.f16153a);
            C6072k f3 = C6059c.m19630f();
            f3.mo34093d("Fabric", "App icon size is " + dVar.f16133j.f16155c + "x" + dVar.f16133j.f16156d);
        }
        int g = httpRequest.mo34351g();
        String str = "POST".equals(httpRequest.mo34355k()) ? "Create" : "Update";
        C6072k f4 = C6059c.m19630f();
        f4.mo34093d("Fabric", str + " app request ID: " + httpRequest.mo34343c(C6078a.HEADER_REQUEST_ID));
        C6072k f5 = C6059c.m19630f();
        f5.mo34093d("Fabric", "Result was " + g);
        return C6116v.m19833a(g) == 0;
    }

    /* renamed from: a */
    private HttpRequest m19868a(HttpRequest httpRequest, C6137d dVar) {
        httpRequest.mo34341c(C6078a.HEADER_API_KEY, dVar.f16124a);
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_TYPE, "android");
        httpRequest.mo34341c(C6078a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        return httpRequest;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo34244a(C6071j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{jVar.mo34140b()});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo34246b(C6071j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{jVar.mo34140b()});
    }
}
