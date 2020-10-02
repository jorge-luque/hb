package p118io.presage;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.loopj.android.http.C4250c;
import java.io.ByteArrayInputStream;

/* renamed from: io.presage.dd */
public final class C6398dd extends C6242bf {

    /* renamed from: b */
    private C6397dc f16985b;

    /* renamed from: c */
    private final C6396db f16986c;

    public C6398dd(C6396db dbVar) {
        super((byte) 0);
        this.f16986c = dbVar;
    }

    /* renamed from: a */
    public final void mo35364a(C6397dc dcVar) {
        this.f16985b = dcVar;
    }

    /* renamed from: b */
    public final boolean mo34734b(WebView webView, String str) {
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            return dcVar.mo34798a();
        }
        return super.mo34734b(webView, str);
    }

    public final void onPageFinished(WebView webView, String str) {
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            dcVar.mo34799b(webView, str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            dcVar.mo34797a(webView, str);
        }
    }

    /* renamed from: a */
    public final void mo34733a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder("onReceivedError ");
        sb.append(i);
        sb.append(" description ");
        sb.append(str);
        sb.append(" ulr ");
        sb.append(str2);
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            dcVar.mo34866c();
        }
    }

    /* renamed from: b */
    private static WebResourceResponse m21244b() {
        byte[] bytes = "".getBytes(C6548is.f17074a);
        C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new WebResourceResponse("text/image", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(bytes));
    }

    /* renamed from: a */
    public final void mo34780a(String str) {
        this.f16986c.mo35334a(str);
    }

    /* renamed from: a */
    public final WebResourceResponse mo34732a(WebView webView, String str) {
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            dcVar.mo34800c(webView, str);
        }
        C6397dc dcVar2 = this.f16985b;
        if (dcVar2 == null || !dcVar2.mo34857a(str)) {
            return super.mo34732a(webView, str);
        }
        return m21244b();
    }

    /* renamed from: a */
    public final void mo34778a() {
        C6397dc dcVar = this.f16985b;
        if (dcVar != null) {
            dcVar.mo34866c();
        }
    }
}
