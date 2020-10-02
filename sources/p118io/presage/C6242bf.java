package p118io.presage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import com.loopj.android.http.C4250c;
import java.io.ByteArrayInputStream;

/* renamed from: io.presage.bf */
public abstract class C6242bf extends C6222am {

    /* renamed from: a */
    public static final CamembertauCalvados f16786a = new CamembertauCalvados((byte) 0);

    /* renamed from: e */
    private static final WebResourceResponse f16787e;

    /* renamed from: b */
    private final Handler f16788b;

    /* renamed from: c */
    private C6239bc f16789c;

    /* renamed from: d */
    private SaintFelicien f16790d;

    /* renamed from: io.presage.bf$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.bf$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6242bf f16791a;

        CamembertdeNormandie(C6242bf bfVar) {
            this.f16791a = bfVar;
        }

        public final void run() {
            this.f16791a.mo34778a();
        }
    }

    /* renamed from: io.presage.bf$EcirdelAubrac */
    static final class EcirdelAubrac implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6242bf f16792a;

        /* renamed from: b */
        final /* synthetic */ String f16793b;

        EcirdelAubrac(C6242bf bfVar, String str) {
            this.f16792a = bfVar;
            this.f16793b = str;
        }

        public final void run() {
            C6220ak.m20786a(this.f16793b);
            this.f16792a.mo34780a(this.f16793b);
        }
    }

    static {
        byte[] bytes = "".getBytes(C6548is.f17074a);
        C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        f16787e = new WebResourceResponse("text/image", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(bytes));
    }

    private C6242bf() {
        this.f16790d = null;
        this.f16788b = new Handler(Looper.getMainLooper());
        this.f16789c = C6239bc.f16784a;
    }

    /* renamed from: b */
    private static boolean m20886b(String str) {
        Uri parse = Uri.parse(str);
        C6514hl.m21414a((Object) parse, ShareConstants.MEDIA_URI);
        return C6514hl.m21416a((Object) "mraid.js", (Object) parse.getLastPathSegment());
    }

    /* renamed from: a */
    public abstract void mo34778a();

    /* renamed from: a */
    public final void mo34779a(SaintFelicien saintFelicien) {
        this.f16790d = saintFelicien;
    }

    /* renamed from: a */
    public abstract void mo34780a(String str);

    /* renamed from: b */
    public boolean mo34734b(WebView webView, String str) {
        return true;
    }

    /* renamed from: a */
    public WebResourceResponse mo34732a(WebView webView, String str) {
        if (C6243bg.m20892a(str)) {
            this.f16788b.post(new EcirdelAubrac(this, str));
            return f16787e;
        } else if (m20886b(str)) {
            return m20885a(webView);
        } else {
            return null;
        }
    }

    public /* synthetic */ C6242bf(byte b) {
        this();
    }

    /* renamed from: a */
    private final WebResourceResponse m20885a(WebView webView) {
        Context context = webView.getContext();
        C6514hl.m21414a((Object) context, "view.context");
        WebResourceResponse a = C6239bc.m20881a(context, this.f16790d);
        if (a != null) {
            return a;
        }
        this.f16788b.post(new CamembertdeNormandie(this));
        return f16787e;
    }
}
