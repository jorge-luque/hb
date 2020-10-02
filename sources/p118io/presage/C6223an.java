package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

/* renamed from: io.presage.an */
public final class C6223an {

    /* renamed from: io.presage.an$CamembertauCalvados */
    static final class CamembertauCalvados implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6481gf f16750a;

        CamembertauCalvados(C6481gf gfVar) {
            this.f16750a = gfVar;
        }

        public final void run() {
            this.f16750a.mo34405a();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    public static final void m20791a(WebView webView) {
        webView.getSettings().setAppCacheEnabled(true);
        Context context = webView.getContext();
        C6514hl.m21414a((Object) context, "context");
        File cacheDir = context.getCacheDir();
        String absolutePath = cacheDir != null ? cacheDir.getAbsolutePath() : null;
        if (absolutePath != null) {
            webView.getSettings().setAppCachePath(absolutePath);
        }
        WebSettings settings = webView.getSettings();
        C6514hl.m21414a((Object) settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        C6514hl.m21414a((Object) settings2, "settings");
        settings2.setDomStorageEnabled(true);
    }

    /* renamed from: b */
    public static final void m20793b(WebView webView) {
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setScrollContainer(false);
    }

    /* renamed from: c */
    public static final void m20794c(WebView webView) {
        if (Build.VERSION.SDK_INT >= 17) {
            WebSettings settings = webView.getSettings();
            C6514hl.m21414a((Object) settings, "settings");
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    /* renamed from: d */
    public static final boolean m20795d(WebView webView) {
        if (Build.VERSION.SDK_INT >= 19) {
            return webView.isAttachedToWindow();
        }
        return webView.getParent() != null;
    }

    /* renamed from: e */
    public static final void m20796e(WebView webView) {
        if (!m20795d(webView)) {
            webView.destroy();
        }
    }

    /* renamed from: a */
    public static final void m20792a(WebView webView, C6481gf<C6437ep> gfVar) {
        if (webView.getHeight() > 0 || webView.getWidth() > 0) {
            gfVar.mo34405a();
        } else {
            webView.post(new CamembertauCalvados(gfVar));
        }
    }
}
