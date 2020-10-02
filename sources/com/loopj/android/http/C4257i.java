package com.loopj.android.http;

import admost.sdk.base.AdMost;
import com.facebook.places.model.PlaceFields;
import java.net.URI;
import java.net.URISyntaxException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.client.CircularRedirectException;
import p163cz.msebera.android.httpclient.client.p172r.C5621d;
import p163cz.msebera.android.httpclient.impl.client.C5792m;
import p163cz.msebera.android.httpclient.impl.client.C5801u;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: com.loopj.android.http.i */
/* compiled from: MyRedirectHandler */
class C4257i extends C5792m {

    /* renamed from: a */
    private final boolean f11407a;

    public C4257i(boolean z) {
        this.f11407a = z;
    }

    /* renamed from: a */
    public URI mo28911a(C5901q qVar, C5875e eVar) throws ProtocolException {
        URI uri;
        if (qVar != null) {
            C5691d firstHeader = qVar.getFirstHeader(PlaceFields.LOCATION);
            if (firstHeader != null) {
                String replaceAll = firstHeader.getValue().replaceAll(" ", "%20");
                try {
                    URI uri2 = new URI(replaceAll);
                    C5759e params = qVar.getParams();
                    if (!uri2.isAbsolute()) {
                        if (!params.mo33422c("http.protocol.reject-relative-redirect")) {
                            C5896l lVar = (C5896l) eVar.mo33533a("http.target_host");
                            if (lVar != null) {
                                try {
                                    uri2 = C5621d.m17894a(C5621d.m17893a(new URI(((C5899o) eVar.mo33533a("http.request")).getRequestLine().getUri()), lVar, true), uri2);
                                } catch (URISyntaxException e) {
                                    throw new ProtocolException(e.getMessage(), e);
                                }
                            } else {
                                throw new IllegalStateException("Target host not available in the HTTP context");
                            }
                        } else {
                            throw new ProtocolException("Relative redirect location '" + uri2 + "' not allowed");
                        }
                    }
                    if (params.mo33418a("http.protocol.allow-circular-redirects")) {
                        C5801u uVar = (C5801u) eVar.mo33533a("http.protocol.redirect-locations");
                        if (uVar == null) {
                            uVar = new C5801u();
                            eVar.mo33535a("http.protocol.redirect-locations", uVar);
                        }
                        if (uri2.getFragment() != null) {
                            try {
                                uri = C5621d.m17893a(uri2, new C5896l(uri2.getHost(), uri2.getPort(), uri2.getScheme()), true);
                            } catch (URISyntaxException e2) {
                                throw new ProtocolException(e2.getMessage(), e2);
                            }
                        } else {
                            uri = uri2;
                        }
                        if (!uVar.mo33520b(uri)) {
                            uVar.mo33518a(uri);
                        } else {
                            throw new CircularRedirectException("Circular redirect to '" + uri + "'");
                        }
                    }
                    return uri2;
                } catch (URISyntaxException e3) {
                    throw new ProtocolException("Invalid redirect URI: " + replaceAll, e3);
                }
            } else {
                throw new ProtocolException("Received redirect response " + qVar.mo33335a() + " but no location header");
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }

    /* renamed from: b */
    public boolean mo28912b(C5901q qVar, C5875e eVar) {
        if (!this.f11407a) {
            return false;
        }
        if (qVar != null) {
            int a = qVar.mo33335a().mo33371a();
            if (a == 307) {
                return true;
            }
            switch (a) {
                case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                case AdMost.AD_ERROR_TAG_PASSIVE:
                case AdMost.AD_ERROR_ZONE_PASSIVE:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }
}
