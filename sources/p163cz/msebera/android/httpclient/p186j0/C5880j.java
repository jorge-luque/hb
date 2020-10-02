package p163cz.msebera.android.httpclient.p186j0;

import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.j */
/* compiled from: RequestContent */
public class C5880j implements C5900p {

    /* renamed from: a */
    private final boolean f15111a;

    public C5880j() {
        this(false);
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        if (oVar instanceof C5885k) {
            if (this.f15111a) {
                oVar.removeHeaders("Transfer-Encoding");
                oVar.removeHeaders("Content-Length");
            } else if (oVar.containsHeader("Transfer-Encoding")) {
                throw new ProtocolException("Transfer-encoding header already present");
            } else if (oVar.containsHeader("Content-Length")) {
                throw new ProtocolException("Content-Length header already present");
            }
            C5907v protocolVersion = oVar.getRequestLine().getProtocolVersion();
            C5870j entity = ((C5885k) oVar).getEntity();
            if (entity == null) {
                oVar.addHeader("Content-Length", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                return;
            }
            if (!entity.mo32895e() && entity.mo28849h() >= 0) {
                oVar.addHeader("Content-Length", Long.toString(entity.mo28849h()));
            } else if (!protocolVersion.mo33701c(C5905t.f15129e)) {
                oVar.addHeader("Transfer-Encoding", "chunked");
            } else {
                throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
            }
            if (entity.mo32889a() != null && !oVar.containsHeader("Content-Type")) {
                oVar.mo33293a(entity.mo32889a());
            }
            if (entity.mo32894c() != null && !oVar.containsHeader("Content-Encoding")) {
                oVar.mo33293a(entity.mo32894c());
            }
        }
    }

    public C5880j(boolean z) {
        this.f15111a = z;
    }
}
