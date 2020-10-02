package p118io.presage;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: io.presage.cd */
public final class C6267cd {

    /* renamed from: a */
    public static final CamembertauCalvados f16888a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private String f16889b = "";

    /* renamed from: c */
    private int f16890c = -1;

    /* renamed from: io.presage.cd$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: b */
    private final void m21045b() {
        int a = C6562jf.m21517a((CharSequence) this.f16889b, "chrome/", 0, true);
        if (a != -1) {
            int i = a + 7;
            try {
                String str = this.f16889b;
                int i2 = i + 2;
                if (str != null) {
                    String substring = str.substring(i, i2);
                    C6514hl.m21414a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    this.f16890c = Integer.parseInt(substring);
                    return;
                }
                throw new C6434em("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public final void mo34858a(WebView webView) {
        if (this.f16889b.length() == 0) {
            WebSettings settings = webView.getSettings();
            C6514hl.m21414a((Object) settings, "webView.settings");
            String userAgentString = settings.getUserAgentString();
            C6514hl.m21414a((Object) userAgentString, "webView.settings.userAgentString");
            this.f16889b = userAgentString;
            m21045b();
        }
    }

    /* renamed from: a */
    public final boolean mo34859a() {
        return this.f16890c <= 57;
    }
}
