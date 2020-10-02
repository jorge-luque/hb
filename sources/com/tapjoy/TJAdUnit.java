package com.tapjoy;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.google.android.gms.drive.DriveFile;
import com.loopj.android.http.C4250c;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3137gf;
import com.tapjoy.internal.C3166jq;
import com.tapjoy.internal.C5086fm;
import com.tapjoy.internal.C5162hn;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class TJAdUnit implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    public static TJVideoListener f8647a;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f8648A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f8649B;

    /* renamed from: C */
    private int f8650C = -1;

    /* renamed from: D */
    private int f8651D;

    /* renamed from: E */
    private int f8652E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f8653F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f8654G;

    /* renamed from: H */
    private C5086fm f8655H;

    /* renamed from: I */
    private final Runnable f8656I = new Runnable() {
        public final void run() {
            int streamVolume = TJAdUnit.this.f8676s.getStreamVolume(3);
            if (TJAdUnit.this.f8677t != streamVolume) {
                int unused = TJAdUnit.this.f8677t = streamVolume;
                TJAdUnit.this.f8659b.onVolumeChanged();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public final Runnable f8657J = new Runnable() {
        public final void run() {
            if (TJAdUnit.this.f8662e.getCurrentPosition() != 0) {
                if (!TJAdUnit.this.f8673p) {
                    boolean unused = TJAdUnit.this.f8673p = true;
                }
                TJAdUnit.this.f8659b.onVideoStarted(TJAdUnit.this.f8671n);
                TJAdUnit.this.f8658K.run();
            } else if (!TJAdUnit.this.f8653F) {
                TJAdUnit.this.f8666i.postDelayed(TJAdUnit.this.f8657J, 200);
            } else {
                boolean unused2 = TJAdUnit.this.f8654G = true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public final Runnable f8658K = new Runnable() {
        public final void run() {
            TJAdUnit.this.f8659b.onVideoProgress(TJAdUnit.this.f8662e.getCurrentPosition());
            TJAdUnit.this.f8666i.postDelayed(TJAdUnit.this.f8658K, 500);
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: b */
    public TJAdUnitJSBridge f8659b;
    /* access modifiers changed from: package-private */

    /* renamed from: c */
    public TJWebView f8660c;
    /* access modifiers changed from: package-private */

    /* renamed from: d */
    public TJWebView f8661d;

    /* renamed from: e */
    VideoView f8662e;

    /* renamed from: f */
    volatile boolean f8663f;

    /* renamed from: g */
    WebViewClient f8664g = new WebViewClient() {
        /* renamed from: a */
        private boolean m10210a(String str) {
            if (!TJAdUnit.this.m10189e() || !URLUtil.isValidUrl(str)) {
                if (TJAdUnit.this.f8669l != null) {
                    TJAdUnit.this.f8669l.showErrorDialog();
                }
                return true;
            } else if (TJAdUnit.m10183b(str)) {
                return false;
            } else {
                if (TJAdUnit.this.f8659b.allowRedirect) {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                    if (TJAdUnit.this.f8661d.getContext() != null) {
                        try {
                            TJAdUnit.this.f8661d.getContext().startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            TapjoyLog.m16651e("TJAdUnit", "Exception in loading URL. " + e.getMessage());
                        }
                    }
                } else if (str.startsWith("javascript:") && Build.VERSION.SDK_INT >= 19) {
                    try {
                        TJAdUnit.this.f8661d.evaluateJavascript(str.replaceFirst("javascript:", ""), (ValueCallback) null);
                        return true;
                    } catch (Exception e2) {
                        TapjoyLog.m16651e("TJAdUnit", "Exception in evaluateJavascript. Device not supported. " + e2.toString());
                    }
                }
                return false;
            }
        }

        public final void onLoadResource(WebView webView, String str) {
        }

        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.m16649d("TJAdUnit", "onPageFinished: " + str);
            if (TJAdUnit.this.f8669l != null) {
                TJAdUnit.this.f8669l.setProgressSpinnerVisibility(false);
            }
            boolean unused = TJAdUnit.this.f8649B = true;
            if (TJAdUnit.this.f8682y) {
                TJAdUnit.this.f8659b.display();
            }
            TJAdUnit.this.f8659b.flushMessageQueue();
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            TapjoyLog.m16649d("TJAdUnit", "onPageStarted: " + str);
            if (TJAdUnit.this.f8659b != null) {
                TJAdUnit.this.f8659b.allowRedirect = true;
                TJAdUnit.this.f8659b.customClose = false;
                TJAdUnit.this.f8659b.closeRequested = false;
                TJAdUnit.this.m10175a();
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            TapjoyLog.m16649d("TJAdUnit", "error:" + str);
            if (TJAdUnit.this.f8669l != null) {
                TJAdUnit.this.f8669l.showErrorDialog();
            }
            super.onReceivedError(webView, i, str, str2);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            TapjoyCachedAssetData cachedDataForURL;
            WebResourceResponse a;
            if (TapjoyCache.getInstance() == null || (cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(str)) == null || (a = m10209a(cachedDataForURL)) == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            TapjoyLog.m16649d("TJAdUnit", "Reading request for " + str + " from cache -- localPath: " + cachedDataForURL.getLocalFilePath());
            return a;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return m10210a(str);
        }

        @TargetApi(24)
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return m10210a(webResourceRequest.getUrl().toString());
        }

        /* renamed from: a */
        private static WebResourceResponse m10209a(TapjoyCachedAssetData tapjoyCachedAssetData) {
            if (tapjoyCachedAssetData == null) {
                return null;
            }
            try {
                return new WebResourceResponse(tapjoyCachedAssetData.getMimeType(), C4250c.DEFAULT_CHARSET, new FileInputStream(tapjoyCachedAssetData.getLocalFilePath()));
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* renamed from: h */
    WebChromeClient f8665h = new WebChromeClient() {
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (TJAdUnit.this.f8659b.closeRequested) {
                int i = 0;
                String[] strArr = {"Uncaught", "uncaught", "Error", "error", "not defined"};
                if (TJAdUnit.this.f8669l != null) {
                    while (true) {
                        if (i >= 5) {
                            break;
                        }
                        if (consoleMessage.message().contains(strArr[i])) {
                            TJAdUnit.this.f8669l.handleClose();
                            break;
                        }
                        i++;
                    }
                }
            }
            return true;
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            TapjoyLog.m16649d("TJAdUnit", str2);
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f8666i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private TJAdUnitWebViewListener f8667j;

    /* renamed from: k */
    private TJAdUnitVideoListener f8668k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TJAdUnitActivity f8669l;

    /* renamed from: m */
    private MediaPlayer f8670m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f8671n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f8672o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f8673p;

    /* renamed from: q */
    private boolean f8674q;
    @Nullable

    /* renamed from: r */
    private ScheduledFuture f8675r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public AudioManager f8676s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f8677t = 0;

    /* renamed from: u */
    private int f8678u;

    /* renamed from: v */
    private boolean f8679v;

    /* renamed from: w */
    private boolean f8680w;

    /* renamed from: x */
    private boolean f8681x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f8682y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f8683z;

    public interface TJAdUnitVideoListener {
        void onVideoCompleted();

        void onVideoError(String str);

        void onVideoStart();
    }

    public interface TJAdUnitWebViewListener {
        void onClick();

        void onClosed();

        void onContentReady();
    }

    /* renamed from: a */
    private static boolean m10176a(int i) {
        return i == 0 || i == 8 || i == 6 || i == 11;
    }

    /* renamed from: b */
    private static boolean m10181b(int i) {
        return i == 1 || i == 9 || i == 7 || i == 12;
    }

    public void attachVolumeListener(boolean z, int i) {
        TJAdUnitActivity tJAdUnitActivity;
        TapjoyLog.m16649d("TJAdUnit", "attachVolumeListener: isAttached=" + z + "; interval=" + i);
        m10175a();
        if (z && (tJAdUnitActivity = this.f8669l) != null) {
            AudioManager audioManager = (AudioManager) tJAdUnitActivity.getSystemService("audio");
            this.f8676s = audioManager;
            this.f8677t = audioManager.getStreamVolume(3);
            this.f8678u = this.f8676s.getStreamMaxVolume(3);
            long j = (long) i;
            this.f8675r = C5162hn.f14145a.scheduleWithFixedDelay(this.f8656I, j, j, TimeUnit.MILLISECONDS);
        }
    }

    public void clearVideo(final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner, final boolean z) {
        if (this.f8662e != null) {
            m10184c();
            TapjoyUtil.runOnMainThread(new Runnable() {
                public final void run() {
                    TJAdUnit.this.f8662e.setVisibility(z ? 0 : 4);
                    TJAdUnit.this.f8662e.stopPlayback();
                    boolean unused = TJAdUnit.this.f8673p = false;
                    boolean unused2 = TJAdUnit.this.f8672o = false;
                    int unused3 = TJAdUnit.this.f8671n = 0;
                    adUnitAsyncTaskListner.onComplete(true);
                }
            });
            return;
        }
        adUnitAsyncTaskListner.onComplete(false);
    }

    public void closeRequested(boolean z) {
        this.f8659b.closeRequested(Boolean.valueOf(z));
    }

    public void destroy() {
        this.f8659b.destroy();
        m10184c();
        TJWebView tJWebView = this.f8660c;
        if (tJWebView != null) {
            tJWebView.removeAllViews();
            this.f8660c = null;
        }
        TJWebView tJWebView2 = this.f8661d;
        if (tJWebView2 != null) {
            tJWebView2.removeAllViews();
            this.f8661d = null;
        }
        this.f8663f = false;
        this.f8682y = false;
        setAdUnitActivity((TJAdUnitActivity) null);
        m10175a();
        this.f8670m = null;
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f8667j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        resetContentLoadState();
    }

    public void endAdContentTracking(String str, JSONObject jSONObject) {
        if (this.f8655H != null) {
            m10188d();
            this.f8655H.mo31246b(str, jSONObject);
        }
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f8667j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnClick() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f8667j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClick();
        }
    }

    public void fireOnVideoComplete() {
        TapjoyLog.m16653v("TJAdUnit", "Firing onVideoComplete");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoComplete();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f8668k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public void fireOnVideoError(String str) {
        TapjoyLog.m16651e("TJAdUnit", "Firing onVideoError with error: " + str);
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoError(3);
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f8668k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoError(str);
        }
    }

    public void fireOnVideoStart() {
        TapjoyLog.m16653v("TJAdUnit", "Firing onVideoStart");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoStart();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f8668k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoStart();
        }
    }

    public TJWebView getBackgroundWebView() {
        return this.f8660c;
    }

    public boolean getCloseRequested() {
        return this.f8659b.closeRequested;
    }

    public int getLockedOrientation() {
        return this.f8650C;
    }

    public TJVideoListener getPublisherVideoListener() {
        return f8647a;
    }

    public int getScreenHeight() {
        return this.f8652E;
    }

    public String getScreenOrientationString() {
        return m10176a(m10179b()) ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    public int getScreenWidth() {
        return this.f8651D;
    }

    public int getVideoSeekTime() {
        return this.f8671n;
    }

    public VideoView getVideoView() {
        return this.f8662e;
    }

    public float getVolume() {
        return ((float) this.f8677t) / ((float) this.f8678u);
    }

    public TJWebView getWebView() {
        return this.f8661d;
    }

    public boolean hasCalledLoad() {
        return this.f8683z;
    }

    public void invokeBridgeCallback(String str, Object... objArr) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f8659b;
        if (tJAdUnitJSBridge != null && str != null) {
            tJAdUnitJSBridge.invokeJSCallback(str, objArr);
        }
    }

    public boolean isLockedOrientation() {
        return this.f8681x;
    }

    public boolean isMuted() {
        return this.f8680w;
    }

    public boolean isPrerendered() {
        return this.f8648A;
    }

    public boolean isVideoComplete() {
        return this.f8674q;
    }

    public void load(final TJPlacementData tJPlacementData, final boolean z, final Context context) {
        this.f8683z = false;
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                TJAdUnit tJAdUnit = TJAdUnit.this;
                Context context = context;
                boolean z = true;
                if (Looper.myLooper() == Looper.getMainLooper() && !tJAdUnit.f8663f && context != null) {
                    TapjoyLog.m16649d("TJAdUnit", "Constructing ad unit");
                    tJAdUnit.f8663f = true;
                    TJWebView tJWebView = new TJWebView(context);
                    tJAdUnit.f8660c = tJWebView;
                    tJWebView.loadDataWithBaseURL((String) null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", (String) null);
                    TJWebView tJWebView2 = new TJWebView(context);
                    tJAdUnit.f8661d = tJWebView2;
                    tJWebView2.setWebViewClient(tJAdUnit.f8664g);
                    tJAdUnit.f8661d.setWebChromeClient(tJAdUnit.f8665h);
                    VideoView videoView = new VideoView(context);
                    tJAdUnit.f8662e = videoView;
                    videoView.setOnCompletionListener(tJAdUnit);
                    tJAdUnit.f8662e.setOnErrorListener(tJAdUnit);
                    tJAdUnit.f8662e.setOnPreparedListener(tJAdUnit);
                    tJAdUnit.f8662e.setVisibility(4);
                    tJAdUnit.f8659b = new TJAdUnitJSBridge(context, tJAdUnit);
                    if (context instanceof TJAdUnitActivity) {
                        tJAdUnit.setAdUnitActivity((TJAdUnitActivity) context);
                    }
                }
                if (tJAdUnit.f8663f) {
                    TapjoyLog.m16652i("TJAdUnit", "Loading ad unit content");
                    boolean unused = TJAdUnit.this.f8683z = true;
                    if (!C3166jq.m10436c(tJPlacementData.getRedirectURL())) {
                        if (tJPlacementData.isPreloadDisabled()) {
                            TJAdUnit.this.f8661d.postUrl(tJPlacementData.getRedirectURL(), (byte[]) null);
                        } else {
                            TJAdUnit.this.f8661d.loadUrl(tJPlacementData.getRedirectURL());
                        }
                    } else if (tJPlacementData.getBaseURL() == null || tJPlacementData.getHttpResponse() == null) {
                        TapjoyLog.m16650e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                        boolean unused2 = TJAdUnit.this.f8683z = false;
                    } else {
                        TJAdUnit.this.f8661d.loadDataWithBaseURL(tJPlacementData.getBaseURL(), tJPlacementData.getHttpResponse(), "text/html", "utf-8", (String) null);
                    }
                    TJAdUnit tJAdUnit2 = TJAdUnit.this;
                    if (!tJAdUnit2.f8683z || !z) {
                        z = false;
                    }
                    boolean unused3 = tJAdUnit2.f8648A = z;
                }
            }
        });
    }

    public void loadVideoUrl(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                if (TJAdUnit.this.f8662e != null) {
                    TapjoyLog.m16652i("TJAdUnit", "loadVideoUrl: " + str);
                    TJAdUnit.this.f8662e.setVideoPath(str);
                    TJAdUnit.this.f8662e.setVisibility(0);
                    TJAdUnit.this.f8662e.seekTo(0);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                adUnitAsyncTaskListner.onComplete(false);
            }
        });
    }

    public void notifyOrientationChanged() {
        this.f8659b.notifyOrientationChanged(getScreenOrientationString(), this.f8651D, this.f8652E);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        TapjoyLog.m16652i("TJAdUnit", "video -- onCompletion");
        m10184c();
        this.f8674q = true;
        if (!this.f8672o) {
            this.f8659b.onVideoCompletion();
        }
        this.f8672o = false;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        TapjoyLog.m16650e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating the VideoView: " + i + " - " + i2));
        this.f8672o = true;
        m10184c();
        String str2 = (i != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED") + " -- ";
        if (i2 == -1010) {
            str = str2 + "MEDIA_ERROR_UNSUPPORTED";
        } else if (i2 == -1007) {
            str = str2 + "MEDIA_ERROR_MALFORMED";
        } else if (i2 == -1004) {
            str = str2 + "MEDIA_ERROR_IO";
        } else if (i2 != -110) {
            str = str2 + "MEDIA_ERROR_EXTRA_UNKNOWN";
        } else {
            str = str2 + "MEDIA_ERROR_TIMED_OUT";
        }
        this.f8659b.onVideoError(str);
        if (i == 1 || i2 == -1004) {
            return true;
        }
        return false;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        if (i == 3) {
            str = "MEDIA_INFO_VIDEO_RENDERING_START";
        } else if (i != 801) {
            switch (i) {
                case 700:
                    str = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                    break;
                case 701:
                    str = "MEDIA_INFO_BUFFERING_START";
                    break;
                case 702:
                    str = "MEDIA_INFO_BUFFERING_END";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "MEDIA_INFO_NOT_SEEKABLE";
        }
        this.f8659b.onVideoInfo(str);
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.m16652i("TJAdUnit", "video -- onPrepared");
        final int duration = this.f8662e.getDuration();
        final int measuredWidth = this.f8662e.getMeasuredWidth();
        final int measuredHeight = this.f8662e.getMeasuredHeight();
        this.f8670m = mediaPlayer;
        boolean z = this.f8679v;
        if (z) {
            mo18396a(z);
        }
        if (this.f8671n <= 0 || this.f8662e.getCurrentPosition() == this.f8671n) {
            this.f8659b.onVideoReady(duration, measuredWidth, measuredHeight);
        } else {
            this.f8670m.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    TJAdUnit.this.f8659b.onVideoReady(duration, measuredWidth, measuredHeight);
                }
            });
        }
        this.f8670m.setOnInfoListener(this);
    }

    public void pause() {
        this.f8653F = true;
        this.f8659b.setEnabled(false);
        pauseVideo();
    }

    public boolean pauseVideo() {
        m10184c();
        VideoView videoView = this.f8662e;
        if (videoView == null || !videoView.isPlaying()) {
            return false;
        }
        this.f8662e.pause();
        this.f8671n = this.f8662e.getCurrentPosition();
        TapjoyLog.m16652i("TJAdUnit", "Video paused at: " + this.f8671n);
        this.f8659b.onVideoPaused(this.f8671n);
        return true;
    }

    public boolean playVideo() {
        TapjoyLog.m16652i("TJAdUnit", "playVideo");
        VideoView videoView = this.f8662e;
        if (videoView == null) {
            return false;
        }
        videoView.start();
        this.f8674q = false;
        this.f8666i.postDelayed(this.f8657J, 200);
        return true;
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (this.f8683z || !tJPlacementData.isPrerenderingRequested() || !TJPlacementManager.canPreRenderPlacement() || TapjoyConnectCore.isViewOpen()) {
            fireContentReady();
            return false;
        }
        TapjoyLog.m16652i("TJAdUnit", "Pre-rendering ad unit for placement: " + tJPlacementData.getPlacementName());
        TJPlacementManager.incrementPlacementPreRenderCount();
        load(tJPlacementData, true, context);
        return true;
    }

    public void resetContentLoadState() {
        this.f8683z = false;
        this.f8649B = false;
        this.f8648A = false;
        this.f8650C = -1;
        this.f8681x = false;
        this.f8679v = false;
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        if (this.f8659b.didLaunchOtherActivity) {
            TapjoyLog.m16649d("TJAdUnit", "onResume bridge.didLaunchOtherActivity callbackID: " + this.f8659b.otherActivityCallbackID);
            TJAdUnitJSBridge tJAdUnitJSBridge = this.f8659b;
            tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.otherActivityCallbackID, Boolean.TRUE);
            this.f8659b.didLaunchOtherActivity = false;
        }
        this.f8653F = false;
        this.f8659b.setEnabled(true);
        if (tJAdUnitSaveStateData != null) {
            int i = tJAdUnitSaveStateData.seekTime;
            this.f8671n = i;
            this.f8662e.seekTo(i);
            if (this.f8670m != null) {
                this.f8679v = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.f8654G) {
            this.f8654G = false;
            this.f8666i.postDelayed(this.f8657J, 200);
        }
    }

    public void sendAdContentTracking(String str, JSONObject jSONObject) {
        if (this.f8655H != null) {
            m10188d();
            C5086fm fmVar = this.f8655H;
            Map a = C5086fm.m17196a(jSONObject);
            C3137gf.m10291e(str).mo18525a(fmVar.f13945a).mo18525a(a).mo18528b(C5086fm.m17197b(jSONObject)).mo18529c();
        }
    }

    public void setAdContentTracker(C5086fm fmVar) {
        this.f8655H = fmVar;
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.f8669l = tJAdUnitActivity;
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f8659b;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setAdUnitActivity(tJAdUnitActivity);
        }
    }

    public void setBackgroundColor(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    TapjoyLog.m16649d("TJAdUnit", "setBackgroundColor: " + str);
                    TJAdUnit.this.f8660c.setBackgroundColor(Color.parseColor(str));
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.m16649d("TJAdUnit", "Error setting background color. backgroundWebView: " + TJAdUnit.this.f8660c + ", hexColor: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setBackgroundContent(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    TapjoyLog.m16649d("TJAdUnit", "setBackgroundContent: " + str);
                    TJAdUnit.this.f8660c.loadDataWithBaseURL((String) null, str, "text/html", "utf-8", (String) null);
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.m16649d("TJAdUnit", "Error setting background content. backgroundWebView: " + TJAdUnit.this.f8660c + ", content: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setOrientation(int i) {
        TJAdUnitActivity tJAdUnitActivity = this.f8669l;
        if (tJAdUnitActivity != null) {
            int b = m10179b();
            int i2 = this.f8650C;
            if (i2 != -1) {
                b = i2;
            }
            if ((m10176a(b) && m10176a(i)) || (m10181b(b) && m10181b(i))) {
                i = b;
            }
            tJAdUnitActivity.setRequestedOrientation(i);
            this.f8650C = i;
            this.f8681x = true;
        }
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.f8668k = tJAdUnitVideoListener;
    }

    public void setVisible(boolean z) {
        this.f8659b.notifyOrientationChanged(getScreenOrientationString(), this.f8651D, this.f8652E);
        this.f8682y = z;
        if (z && this.f8649B) {
            this.f8659b.display();
        }
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.f8667j = tJAdUnitWebViewListener;
    }

    public void startAdContentTracking(String str, JSONObject jSONObject) {
        C5086fm fmVar = this.f8655H;
        if (fmVar != null) {
            fmVar.mo31245a(str, jSONObject);
        }
    }

    public void unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.f8669l;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setRequestedOrientation(-1);
        }
        this.f8650C = -1;
        this.f8681x = false;
    }

    /* renamed from: c */
    private void m10184c() {
        this.f8666i.removeCallbacks(this.f8657J);
        this.f8666i.removeCallbacks(this.f8658K);
    }

    /* renamed from: d */
    private void m10188d() {
        C5086fm fmVar = this.f8655H;
        if (fmVar != null) {
            fmVar.mo31258a("prerendered", Boolean.valueOf(this.f8648A));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10189e() {
        NetworkInfo activeNetworkInfo;
        try {
            if (this.f8661d.getContext() == null || (activeNetworkInfo = ((ConnectivityManager) this.f8661d.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            TapjoyLog.m16649d("TJAdUnit", "Exception getting NetworkInfo: " + e.getLocalizedMessage());
        }
        return false;
    }

    /* renamed from: b */
    private int m10179b() {
        TJAdUnitActivity tJAdUnitActivity = this.f8669l;
        if (tJAdUnitActivity == null) {
            return -1;
        }
        int rotation = tJAdUnitActivity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        tJAdUnitActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f8651D = displayMetrics.widthPixels;
        this.f8652E = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && this.f8652E > this.f8651D) || ((rotation == 1 || rotation == 3) && this.f8651D > this.f8652E)) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            return 1;
                        }
                        return 8;
                    }
                }
                return 0;
            }
            return 1;
        }
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation == 2) {
                    return 8;
                }
                if (rotation != 3) {
                    TapjoyLog.m16654w("TJAdUnit", "Unknown screen orientation. Defaulting to landscape.");
                }
            }
            return 1;
        }
        return 0;
        return 9;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10175a() {
        TapjoyLog.m16649d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = this.f8675r;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f8675r = null;
        }
        this.f8676s = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18396a(boolean z) {
        MediaPlayer mediaPlayer = this.f8670m;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (this.f8680w != z) {
                this.f8680w = z;
                this.f8659b.onVolumeChanged();
                return;
            }
            return;
        }
        this.f8679v = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m10183b(String str) {
        try {
            String host = new URL(TapjoyConfig.TJC_SERVICE_URL).getHost();
            if ((host == null || !str.contains(host)) && !str.contains(TapjoyConnectCore.getRedirectDomain()) && !str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()))) {
                return false;
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
