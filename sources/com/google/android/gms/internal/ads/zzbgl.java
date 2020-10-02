package com.google.android.gms.internal.ads;

import admost.sdk.base.AdMostBannerResponseFailReason;
import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.games.Notifications;
import com.ogury.p159cm.OguryChoiceManager;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbgl extends WebViewClient {
    private static final String[] zzelq = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", AdMostBannerResponseFailReason.TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzelr = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzbgs zzels;

    public final void onLoadResource(WebView webView, String str) {
        if (str != null) {
            String valueOf = String.valueOf(str);
            zzawr.zzeg(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
            zzb(new zzbgo(str));
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (str != null) {
            zzbgo zzbgo = new zzbgo(str);
            zzbgs zzbgs = this.zzels;
            if (zzbgs != null) {
                zzbgs.zza(zzbgo);
            } else {
                zza(zzbgo);
            }
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (i >= 0 || (-i) - 1 >= zzelq.length) {
            String.valueOf(i);
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError < 0 || primaryError >= zzelr.length) {
                String.valueOf(primaryError);
            }
            sslError.getUrl();
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str == null) {
            return null;
        }
        return zzd(new zzbgo(str));
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case Notifications.NOTIFICATION_TYPES_ALL:
                    case OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE /*128*/:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        return zzc(new zzbgo(str));
    }

    public void zza(zzbgo zzbgo) {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbgs zzbgs) {
        this.zzels = zzbgs;
    }

    public void zzb(zzbgo zzbgo) {
    }

    public boolean zzc(zzbgo zzbgo) {
        return false;
    }

    public WebResourceResponse zzd(zzbgo zzbgo) {
        return null;
    }

    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzd(new zzbgo(webResourceRequest));
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return false;
        }
        return zzc(new zzbgo(webResourceRequest));
    }
}
