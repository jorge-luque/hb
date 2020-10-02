package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

/* renamed from: io.presage.bi */
public final class C6245bi {
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    public static final void m20900a(WebView webView) {
        WebSettings settings = webView.getSettings();
        C6514hl.m21414a((Object) settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        C6514hl.m21414a((Object) settings2, "settings");
        settings2.setBuiltInZoomControls(true);
        WebSettings settings3 = webView.getSettings();
        C6514hl.m21414a((Object) settings3, "settings");
        settings3.setDisplayZoomControls(false);
        WebSettings settings4 = webView.getSettings();
        C6514hl.m21414a((Object) settings4, "settings");
        settings4.setUseWideViewPort(true);
        WebSettings settings5 = webView.getSettings();
        C6514hl.m21414a((Object) settings5, "settings");
        settings5.setLoadWithOverviewMode(true);
        WebSettings settings6 = webView.getSettings();
        C6514hl.m21414a((Object) settings6, "settings");
        settings6.setDomStorageEnabled(true);
        WebSettings settings7 = webView.getSettings();
        C6514hl.m21414a((Object) settings7, "settings");
        settings7.setDatabaseEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        WebSettings settings8 = webView.getSettings();
        C6514hl.m21414a((Object) settings8, "settings");
        settings8.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            WebSettings settings9 = webView.getSettings();
            C6514hl.m21414a((Object) settings9, "settings");
            settings9.setMixedContentMode(2);
        }
        if (Build.VERSION.SDK_INT <= 19) {
            WebSettings settings10 = webView.getSettings();
            C6514hl.m21414a((Object) settings10, "settings");
            File dir = webView.getContext().getDir("webviewdatabase", 0);
            C6514hl.m21414a((Object) dir, "context.getDir(WEB_DB_PATH, Context.MODE_PRIVATE)");
            settings10.setDatabasePath(dir.getPath());
        }
        if (Build.VERSION.SDK_INT <= 18) {
            WebSettings settings11 = webView.getSettings();
            C6514hl.m21414a((Object) settings11, "settings");
            settings11.setSavePassword(true);
        }
        WebSettings settings12 = webView.getSettings();
        C6514hl.m21414a((Object) settings12, "settings");
        settings12.setLoadsImagesAutomatically(true);
        if (Build.VERSION.SDK_INT >= 17) {
            WebSettings settings13 = webView.getSettings();
            C6514hl.m21414a((Object) settings13, "settings");
            settings13.setMediaPlaybackRequiresUserGesture(false);
        }
        WebSettings settings14 = webView.getSettings();
        C6514hl.m21414a((Object) settings14, "settings");
        settings14.setSaveFormData(true);
        webView.getSettings().setSupportZoom(true);
        Context context = webView.getContext();
        C6514hl.m21414a((Object) context, "this.context");
        webView.setDownloadListener(new C6257bu(context));
    }

    /* renamed from: b */
    public static final String m20901b(WebView webView) {
        Object tag = webView.getTag();
        if (!(tag instanceof String)) {
            tag = null;
        }
        String str = (String) tag;
        return str == null ? "" : str;
    }
}
