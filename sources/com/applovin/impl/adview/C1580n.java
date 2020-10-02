package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.C1565i;
import com.applovin.impl.adview.C1630u;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1924e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p048a.C1805b;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p049ad.C1833h;
import com.applovin.impl.sdk.p049ad.C1834i;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C1985b;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2026p;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C2057R;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.n */
public abstract class C1580n extends Activity implements C1569j, C1924e.C1926a {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile C1615o lastKnownWrapper;

    /* renamed from: A */
    private boolean f4942A;

    /* renamed from: B */
    private final Handler f4943B = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final Handler f4944C = new Handler(Looper.getMainLooper());

    /* renamed from: D */
    private FrameLayout f4945D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C1563h f4946E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public View f4947F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C1563h f4948G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f4949H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public C1560f f4950I;

    /* renamed from: J */
    private ImageView f4951J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public WeakReference<MediaPlayer> f4952K = new WeakReference<>((Object) null);

    /* renamed from: L */
    private C1805b f4953L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public C1629t f4954M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public ProgressBar f4955N;

    /* renamed from: O */
    private C1630u.C1631a f4956O;

    /* renamed from: P */
    private C1515a f4957P;

    /* renamed from: Q */
    private C2026p f4958Q;

    /* renamed from: R */
    private C1984a f4959R;

    /* renamed from: S */
    private AppLovinBroadcastManager.Receiver f4960S;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1579m f4961a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1615o f4962b;

    /* renamed from: c */
    private volatile boolean f4963c = false;
    protected int computedLengthSeconds = 0;
    protected C1565i countdownManager;
    public volatile C1827g currentAd;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1854d f4964d;

    /* renamed from: e */
    private volatile boolean f4965e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f4966f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f4967g = false;

    /* renamed from: h */
    private volatile boolean f4968h = false;

    /* renamed from: i */
    private volatile boolean f4969i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f4970j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile boolean f4971k = false;

    /* renamed from: l */
    private boolean f4972l = false;
    public C1977q logger;

    /* renamed from: m */
    private volatile boolean f4973m = false;

    /* renamed from: n */
    private boolean f4974n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f4975o = false;

    /* renamed from: p */
    private long f4976p = 0;
    protected volatile boolean postitialWasDisplayed = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f4977q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f4978r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f4979s = 0;
    public C1941j sdk;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public long f4980t = -2;

    /* renamed from: u */
    private int f4981u = 0;

    /* renamed from: v */
    private int f4982v = Integer.MIN_VALUE;
    protected volatile boolean videoMuted = false;
    public AppLovinVideoView videoView;

    /* renamed from: w */
    private AtomicBoolean f4983w = new AtomicBoolean(false);

    /* renamed from: x */
    private AtomicBoolean f4984x = new AtomicBoolean(false);

    /* renamed from: y */
    private AtomicBoolean f4985y = new AtomicBoolean(false);

    /* renamed from: z */
    private int f4986z = C1924e.f6359a;

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m6049A() {
        if (m6054C()) {
            m6068M();
            pauseReportRewardTask();
            this.logger.mo8742b("InterActivity", "Prompting incentivized ad close warning");
            this.f4953L.mo8091b();
            return;
        }
        skipVideo();
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m6052B() {
        C1548c adWebView;
        if (this.currentAd.mo8249ac() && (adWebView = ((AdViewControllerImpl) this.f4961a.getAdViewController()).getAdWebView()) != null) {
            adWebView.mo7372a("javascript:al_onCloseButtonTapped();");
        }
        if (m6055D()) {
            this.logger.mo8742b("InterActivity", "Prompting incentivized non-video ad close warning");
            this.f4953L.mo8092c();
            return;
        }
        dismiss();
    }

    /* renamed from: C */
    private boolean m6054C() {
        return m6062G() && !isFullyWatched() && ((Boolean) this.sdk.mo8549a(C1841c.f5864bK)).booleanValue() && this.f4953L != null;
    }

    /* renamed from: D */
    private boolean m6055D() {
        return m6063H() && !m6060F() && ((Boolean) this.sdk.mo8549a(C1841c.f5869bP)).booleanValue() && this.f4953L != null;
    }

    /* renamed from: E */
    private int m6057E() {
        if (!(this.currentAd instanceof C1817a)) {
            return 0;
        }
        float j = ((C1817a) this.currentAd).mo8162j();
        if (j <= 0.0f) {
            j = (float) this.currentAd.mo8281r();
        }
        double a = C2029r.m7984a(System.currentTimeMillis() - this.f4976p);
        double d = (double) j;
        Double.isNaN(d);
        return (int) Math.min((a / d) * 100.0d, 100.0d);
    }

    /* renamed from: F */
    private boolean m6060F() {
        return m6057E() >= this.currentAd.mo8225Y();
    }

    /* renamed from: G */
    private boolean m6062G() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    /* renamed from: H */
    private boolean m6063H() {
        return !this.currentAd.hasVideoUrl() && m6062G();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r1 > 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0098, code lost:
        if (r1 > 0) goto L_0x008a;
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6064I() {
        /*
            r7 = this;
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            if (r0 == 0) goto L_0x00df
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            long r0 = r0.mo8259am()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0018
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            int r0 = r0.mo8260an()
            if (r0 < 0) goto L_0x00df
        L_0x0018:
            com.applovin.impl.sdk.utils.p r0 = r7.f4958Q
            if (r0 != 0) goto L_0x00df
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            long r0 = r0.mo8259am()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002e
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            long r0 = r0.mo8259am()
            goto L_0x00af
        L_0x002e:
            boolean r0 = r7.isVastAd()
            if (r0 == 0) goto L_0x0069
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            com.applovin.impl.a.a r0 = (com.applovin.impl.p033a.C1476a) r0
            com.applovin.impl.a.j r1 = r0.mo7165k()
            if (r1 == 0) goto L_0x0051
            int r4 = r1.mo7219b()
            if (r4 <= 0) goto L_0x0051
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            int r1 = r1.mo7219b()
            long r5 = (long) r1
            long r4 = r4.toMillis(r5)
            long r2 = r2 + r4
            goto L_0x005b
        L_0x0051:
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x005b
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x005b:
            boolean r1 = r0.mo8261ao()
            if (r1 == 0) goto L_0x009b
            long r0 = r0.mo8281r()
            int r1 = (int) r0
            if (r1 <= 0) goto L_0x009b
            goto L_0x008a
        L_0x0069:
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p049ad.C1817a
            if (r0 == 0) goto L_0x009b
            com.applovin.impl.sdk.ad.g r0 = r7.currentAd
            com.applovin.impl.sdk.ad.a r0 = (com.applovin.impl.sdk.p049ad.C1817a) r0
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L_0x007d
            long r4 = (long) r1
            long r2 = r2 + r4
        L_0x007d:
            boolean r1 = r0.mo8261ao()
            if (r1 == 0) goto L_0x009b
            float r1 = r0.mo8162j()
            int r1 = (int) r1
            if (r1 <= 0) goto L_0x0093
        L_0x008a:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r1
            long r0 = r0.toMillis(r4)
            long r2 = r2 + r0
            goto L_0x009b
        L_0x0093:
            long r0 = r0.mo8281r()
            int r1 = (int) r0
            if (r1 <= 0) goto L_0x009b
            goto L_0x008a
        L_0x009b:
            double r0 = (double) r2
            com.applovin.impl.sdk.ad.g r2 = r7.currentAd
            int r2 = r2.mo8260an()
            double r2 = (double) r2
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            long r0 = (long) r0
        L_0x00af:
            com.applovin.impl.sdk.q r2 = r7.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Scheduling report reward in "
            r3.append(r4)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r4.toSeconds(r0)
            r3.append(r4)
            java.lang.String r4 = " seconds..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "InterActivity"
            r2.mo8742b(r4, r3)
            com.applovin.impl.sdk.j r2 = r7.sdk
            com.applovin.impl.adview.n$17 r3 = new com.applovin.impl.adview.n$17
            r3.<init>()
            com.applovin.impl.sdk.utils.p r0 = com.applovin.impl.sdk.utils.C2026p.m7968a(r0, r2, r3)
            r7.f4958Q = r0
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1580n.m6064I():void");
    }

    /* renamed from: J */
    private void m6065J() {
        View view;
        String str;
        StringBuilder sb;
        C1977q qVar;
        C1579m mVar = this.f4961a;
        if (mVar != null) {
            mVar.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adDisplayed(AppLovinAd appLovinAd) {
                    if (!C1580n.this.f4966f) {
                        C1580n.this.m6083a(appLovinAd);
                    }
                }

                public void adHidden(AppLovinAd appLovinAd) {
                    C1580n.this.m6097b(appLovinAd);
                }
            });
            this.f4961a.setAdClickListener(new AppLovinAdClickListener() {
                public void adClicked(AppLovinAd appLovinAd) {
                    C1994j.m7913a(C1580n.this.f4962b.mo7522e(), appLovinAd);
                }
            });
            this.currentAd = this.f4962b.mo7519b();
            if (this.f4984x.compareAndSet(false, true)) {
                this.sdk.mo8594o().trackImpression(this.currentAd);
                this.currentAd.setHasShown(true);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = new FrameLayout(this);
            this.f4945D = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            this.f4945D.setBackgroundColor(this.currentAd.mo8208H());
            this.countdownManager = new C1565i(this.f4943B, this.sdk);
            m6121j();
            if (this.currentAd.isVideoAd()) {
                this.f4973m = this.currentAd.mo7154d();
                if (this.f4973m) {
                    qVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing stream for ";
                } else {
                    qVar = this.logger;
                    sb = new StringBuilder();
                    str = "Preparing cached video playback for ";
                }
                sb.append(str);
                sb.append(this.currentAd.mo7157f());
                qVar.mo8742b("InterActivity", sb.toString());
                C1854d dVar = this.f4964d;
                if (dVar != null) {
                    dVar.mo8362b(this.f4973m ? 1 : 0);
                }
            }
            this.videoMuted = m6120i();
            Uri f = this.currentAd.mo7157f();
            m6078a(f);
            if (f == null) {
                m6064I();
            }
            this.f4946E.bringToFront();
            if (m6130n() && (view = this.f4947F) != null) {
                view.bringToFront();
            }
            C1563h hVar = this.f4948G;
            if (hVar != null) {
                hVar.bringToFront();
            }
            if (((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue()) {
                this.f4945D.addView(this.f4961a);
                this.f4961a.setVisibility(4);
            }
            this.f4961a.renderAd(this.currentAd);
            if (!this.currentAd.hasVideoUrl()) {
                if (m6063H() && ((Boolean) this.sdk.mo8549a(C1841c.f5874bU)).booleanValue()) {
                    m6110d((AppLovinAd) this.currentAd);
                }
                showPostitial();
                return;
            }
            return;
        }
        exitWithError("AdView was null");
    }

    /* renamed from: K */
    private void m6066K() {
        if (this.videoView != null) {
            this.f4981u = getVideoPercentViewed();
            this.videoView.stopPlayback();
        }
    }

    /* renamed from: L */
    private boolean m6067L() {
        return this.videoMuted;
    }

    /* renamed from: M */
    private void m6068M() {
        AppLovinVideoView appLovinVideoView = this.videoView;
        this.sdk.mo8556a(C1843e.f6107u, Integer.valueOf(appLovinVideoView != null ? appLovinVideoView.getCurrentPosition() : 0));
        this.sdk.mo8556a(C1843e.f6108v, true);
        try {
            this.countdownManager.mo7444c();
        } catch (Throwable th) {
            this.logger.mo8743b("InterActivity", "Unable to pause countdown timers", th);
        }
        AppLovinVideoView appLovinVideoView2 = this.videoView;
        if (appLovinVideoView2 != null) {
            appLovinVideoView2.pause();
        }
    }

    /* renamed from: N */
    private void m6069N() {
        long max = Math.max(0, ((Long) this.sdk.mo8549a(C1841c.f5990dg)).longValue());
        if (max > 0) {
            C1977q v = this.sdk.mo8602v();
            v.mo8742b("InterActivity", "Resuming video with delay of " + max);
            this.f4944C.postDelayed(new Runnable() {
                public void run() {
                    C1580n.this.m6070O();
                }
            }, max);
            return;
        }
        this.sdk.mo8602v().mo8742b("InterActivity", "Resuming video immediately");
        m6070O();
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m6070O() {
        AppLovinVideoView appLovinVideoView;
        if (!this.postitialWasDisplayed && (appLovinVideoView = this.videoView) != null && !appLovinVideoView.isPlaying()) {
            this.videoView.seekTo(((Integer) this.sdk.mo8574b(C1843e.f6107u, Integer.valueOf(this.videoView.getDuration()))).intValue());
            this.videoView.start();
            this.countdownManager.mo7441a();
        }
    }

    /* renamed from: P */
    private void m6071P() {
        if (!this.f4969i) {
            boolean z = true;
            this.f4969i = true;
            try {
                int videoPercentViewed = getVideoPercentViewed();
                if (this.currentAd.hasVideoUrl()) {
                    m6084a((AppLovinAd) this.currentAd, (double) videoPercentViewed, isFullyWatched());
                    if (this.f4964d != null) {
                        this.f4964d.mo8364c((long) videoPercentViewed);
                    }
                } else if ((this.currentAd instanceof C1817a) && m6063H() && ((Boolean) this.sdk.mo8549a(C1841c.f5874bU)).booleanValue()) {
                    int E = m6057E();
                    C1977q qVar = this.logger;
                    qVar.mo8742b("InterActivity", "Rewarded playable engaged at " + E + " percent");
                    C1827g gVar = this.currentAd;
                    double d = (double) E;
                    if (E < this.currentAd.mo8225Y()) {
                        z = false;
                    }
                    m6084a((AppLovinAd) gVar, d, z);
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f4976p;
                this.sdk.mo8594o().trackVideoEnd(this.currentAd, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), videoPercentViewed, this.f4973m);
                this.sdk.mo8594o().trackFullScreenAdClosed(this.currentAd, SystemClock.elapsedRealtime() - this.f4978r, this.f4980t, this.f4942A, this.f4986z);
            } catch (Throwable th) {
                C1977q qVar2 = this.logger;
                if (qVar2 != null) {
                    qVar2.mo8743b("InterActivity", "Failed to notify end listener.", th);
                }
            }
        }
    }

    /* renamed from: a */
    private int m6072a(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: a */
    private int m6073a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m6076a(long j, final C1563h hVar) {
        this.f4944C.postDelayed(new Runnable() {
            public void run() {
                if (hVar.equals(C1580n.this.f4946E)) {
                    C1580n.this.m6127m();
                } else if (hVar.equals(C1580n.this.f4948G)) {
                    C1580n.this.m6131o();
                }
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6077a(PointF pointF) {
        if (!this.currentAd.mo7169z() || this.currentAd.mo7163i() == null) {
            m6111e();
            m6113f();
            return;
        }
        this.sdk.mo8602v().mo8742b("InterActivity", "Clicking through video...");
        clickThroughFromVideo(pointF);
    }

    /* renamed from: a */
    private void m6078a(Uri uri) {
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(this, this.sdk);
        this.videoView = appLovinVideoView;
        if (uri != null) {
            appLovinVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    WeakReference unused = C1580n.this.f4952K = new WeakReference(mediaPlayer);
                    float f = C1580n.this.m6120i() ^ true ? 1.0f : 0.0f;
                    mediaPlayer.setVolume(f, f);
                    int videoWidth = mediaPlayer.getVideoWidth();
                    int videoHeight = mediaPlayer.getVideoHeight();
                    C1580n.this.computedLengthSeconds = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
                    C1580n.this.videoView.setVideoSize(videoWidth, videoHeight);
                    SurfaceHolder holder = C1580n.this.videoView.getHolder();
                    if (holder.getSurface() != null) {
                        mediaPlayer.setDisplay(holder);
                    }
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                            C1580n.this.f4944C.post(new Runnable() {
                                public void run() {
                                    C1580n nVar = C1580n.this;
                                    nVar.handleMediaError("Media player error (" + i + "," + i2 + ")");
                                }
                            });
                            return true;
                        }
                    });
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            if (i != 3) {
                                if (i == 701) {
                                    C1580n.this.m6151y();
                                    if (C1580n.this.f4964d == null) {
                                        return false;
                                    }
                                    C1580n.this.f4964d.mo8369g();
                                    return false;
                                } else if (i != 702) {
                                    return false;
                                }
                            }
                            C1580n.this.m6154z();
                            return false;
                        }
                    });
                    if (C1580n.this.f4977q == 0) {
                        C1580n.this.m6136q();
                        C1580n.this.m6123k();
                        C1580n.this.m6145v();
                        C1580n.this.m6144u();
                        C1580n.this.playVideo();
                        C1580n.this.m6064I();
                    }
                }
            });
            this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    C1580n.this.m6118h();
                }
            });
            this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                    C1580n.this.f4944C.post(new Runnable() {
                        public void run() {
                            C1580n nVar = C1580n.this;
                            nVar.handleMediaError("Video view error (" + i + "," + i2 + ")");
                        }
                    });
                    return true;
                }
            });
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.videoView.setVideoURI(uri);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, this, new AppLovinTouchToClickListener.OnClickListener() {
            public void onClick(View view, PointF pointF) {
                C1580n.this.m6077a(pointF);
            }
        }));
        this.f4945D.addView(this.videoView);
        setContentView(this.f4945D);
        m6133p();
        m6149x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6079a(final View view, final boolean z, long j) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (!z) {
                    view.setVisibility(4);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6083a(AppLovinAd appLovinAd) {
        C1994j.m7914a(this.f4962b.mo7521d(), appLovinAd);
        this.f4966f = true;
        this.sdk.mo8547Z().mo8731a((Object) appLovinAd);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C1580n nVar = C1580n.this;
                nVar.m6099b(nVar.videoMuted);
            }
        }, ((Long) this.sdk.mo8549a(C1841c.f5994dk)).longValue());
    }

    /* renamed from: a */
    private void m6084a(AppLovinAd appLovinAd, double d, boolean z) {
        C1994j.m7919a(this.f4962b.mo7520c(), appLovinAd, d, z);
    }

    /* renamed from: a */
    private void m6085a(final String str) {
        C1615o oVar = this.f4962b;
        if (oVar != null) {
            final AppLovinAdDisplayListener d = oVar.mo7521d();
            if ((d instanceof C1834i) && this.f4985y.compareAndSet(false, true)) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        ((C1834i) d).onAdDisplayFailed(str);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m6086a(final String str, long j) {
        if (j >= 0) {
            this.f4944C.postDelayed(new Runnable() {
                public void run() {
                    C1548c adWebView = ((AdViewControllerImpl) C1580n.this.f4961a.getAdViewController()).getAdWebView();
                    if (adWebView != null && C2025o.m7963b(str)) {
                        adWebView.mo7372a(str);
                    }
                }
            }, j);
        }
    }

    /* renamed from: a */
    private void m6087a(boolean z) {
        if (((Boolean) this.sdk.mo8549a(C1841c.f5925cT)).booleanValue() && C1991g.m7841d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(z ? C2057R.C2058drawable.unmute_to_mute : C2057R.C2058drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f4951J.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f4951J.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aK = z ? this.currentAd.mo8241aK() : this.currentAd.mo8242aL();
        int a = m6072a(((Integer) this.sdk.mo8549a(C1841c.f5931cZ)).intValue());
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        AppLovinSdkUtils.safePopulateImageView(this.f4951J, aK, a);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private boolean m6088a() {
        int identifier = getResources().getIdentifier((String) this.sdk.mo8549a(C1841c.f5922cQ), "bool", "android");
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: b */
    public void m6092b() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: b */
    private void m6093b(int i) {
        try {
            setRequestedOrientation(i);
        } catch (Throwable th) {
            this.sdk.mo8602v().mo8743b("InterActivity", "Failed to set requested orientation", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r7 == 2) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        if (r7 == 1) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r7 == 1) goto L_0x0028;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6094b(int r7, boolean r8) {
        /*
            r6 = this;
            com.applovin.impl.sdk.j r0 = r6.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1841c.f5920cO
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.applovin.impl.adview.o r1 = r6.f4962b
            com.applovin.impl.sdk.ad.g$b r1 = r1.mo7523f()
            com.applovin.impl.sdk.ad.g$b r2 = com.applovin.impl.sdk.p049ad.C1827g.C1830b.ACTIVITY_PORTRAIT
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L_0x003e
            r1 = 9
            if (r8 == 0) goto L_0x002c
            if (r7 == r5) goto L_0x0024
            if (r7 == r3) goto L_0x0024
            goto L_0x0030
        L_0x0024:
            if (r0 == 0) goto L_0x0068
            if (r7 != r5) goto L_0x0032
        L_0x0028:
            r6.m6093b((int) r1)
            goto L_0x0068
        L_0x002c:
            if (r7 == 0) goto L_0x0036
            if (r7 == r4) goto L_0x0036
        L_0x0030:
            r6.f4963c = r5
        L_0x0032:
            r6.m6093b((int) r5)
            goto L_0x0068
        L_0x0036:
            if (r0 == 0) goto L_0x0068
            if (r7 != 0) goto L_0x003b
            goto L_0x0032
        L_0x003b:
            r5 = 9
            goto L_0x0032
        L_0x003e:
            com.applovin.impl.adview.o r1 = r6.f4962b
            com.applovin.impl.sdk.ad.g$b r1 = r1.mo7523f()
            com.applovin.impl.sdk.ad.g$b r2 = com.applovin.impl.sdk.p049ad.C1827g.C1830b.ACTIVITY_LANDSCAPE
            if (r1 != r2) goto L_0x0068
            r1 = 8
            r2 = 0
            if (r8 == 0) goto L_0x0059
            if (r7 == 0) goto L_0x0052
            if (r7 == r4) goto L_0x0052
            goto L_0x005d
        L_0x0052:
            if (r0 == 0) goto L_0x0068
            if (r7 != r4) goto L_0x0057
            goto L_0x0028
        L_0x0057:
            r1 = 0
            goto L_0x0028
        L_0x0059:
            if (r7 == r5) goto L_0x0063
            if (r7 == r3) goto L_0x0063
        L_0x005d:
            r6.f4963c = r5
            r6.m6093b((int) r2)
            goto L_0x0068
        L_0x0063:
            if (r0 == 0) goto L_0x0068
            if (r7 != r5) goto L_0x0028
            goto L_0x0057
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1580n.m6094b(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6097b(AppLovinAd appLovinAd) {
        dismiss();
        m6102c(appLovinAd);
    }

    /* renamed from: b */
    private void m6098b(String str) {
        C1827g gVar = this.currentAd;
        if (gVar != null && gVar.mo8251ae()) {
            m6086a(str, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6099b(boolean z) {
        C1548c adWebView;
        if (this.currentAd.mo8248ab() && (adWebView = ((AdViewControllerImpl) this.f4961a.getAdViewController()).getAdWebView()) != null) {
            try {
                adWebView.mo7372a(z ? "javascript:al_mute();" : "javascript:al_unmute();");
            } catch (Throwable th) {
                this.logger.mo8743b("InterActivity", "Unable to forward mute setting to template.", th);
            }
        }
    }

    /* renamed from: c */
    private void m6102c(AppLovinAd appLovinAd) {
        if (!this.f4967g) {
            this.f4967g = true;
            C1615o oVar = this.f4962b;
            if (oVar != null) {
                C1994j.m7925b(oVar.mo7521d(), appLovinAd);
            }
            this.sdk.mo8547Z().mo8734b((Object) appLovinAd);
        }
    }

    /* renamed from: c */
    private void m6103c(boolean z) {
        this.videoMuted = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f4952K.get();
        if (mediaPlayer != null) {
            float f = (float) (z ? 0 : 1);
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
                C1977q qVar = this.logger;
                qVar.mo8743b("InterActivity", "Failed to set MediaPlayer muted: " + z, e);
            }
        }
    }

    /* renamed from: c */
    private boolean m6104c() {
        C1941j jVar;
        if (this.f4962b == null || (jVar = this.sdk) == null || ((Boolean) jVar.mo8549a(C1841c.f5914cI)).booleanValue()) {
            return true;
        }
        if (!((Boolean) this.sdk.mo8549a(C1841c.f5915cJ)).booleanValue() || !this.f4970j) {
            return ((Boolean) this.sdk.mo8549a(C1841c.f5916cK)).booleanValue() && this.postitialWasDisplayed;
        }
        return true;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: d */
    private void m6108d() {
        int i;
        if (this.sdk == null || !isFinishing()) {
            if (!(this.currentAd == null || (i = this.f4982v) == Integer.MIN_VALUE)) {
                m6093b(i);
            }
            finish();
        }
    }

    /* renamed from: d */
    private void m6110d(AppLovinAd appLovinAd) {
        if (!this.f4968h) {
            this.f4968h = true;
            C1994j.m7918a(this.f4962b.mo7520c(), appLovinAd);
        }
    }

    /* renamed from: e */
    private void m6111e() {
        C1560f fVar;
        if (((Boolean) this.sdk.mo8549a(C1841c.f5923cR)).booleanValue() && (fVar = this.f4950I) != null && fVar.getVisibility() != 8) {
            m6079a((View) this.f4950I, this.f4950I.getVisibility() == 4, 750);
        }
    }

    /* renamed from: f */
    private void m6113f() {
        C1629t tVar;
        C1628s y = this.currentAd.mo8288y();
        if (y != null && y.mo7542e() && !this.postitialWasDisplayed && (tVar = this.f4954M) != null) {
            m6079a((View) this.f4954M, tVar.getVisibility() == 4, y.mo7544f());
        }
    }

    /* renamed from: g */
    private void m6116g() {
        C1941j jVar = this.sdk;
        if (jVar != null) {
            jVar.mo8556a(C1843e.f6108v, false);
            this.sdk.mo8556a(C1843e.f6107u, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6118h() {
        this.f4965e = true;
        showPostitial();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m6120i() {
        return ((Integer) this.sdk.mo8574b(C1843e.f6107u, 0)).intValue() > 0 ? this.videoMuted : ((Boolean) this.sdk.mo8549a(C1841c.f5930cY)).booleanValue() ? this.sdk.mo8591l().isMuted() : ((Boolean) this.sdk.mo8549a(C1841c.f5928cW)).booleanValue();
    }

    /* renamed from: j */
    private void m6121j() {
        C1563h a = C1563h.m6016a(this.currentAd.mo8282s(), this);
        this.f4946E = a;
        a.setVisibility(8);
        this.f4946E.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1580n.this.m6052B();
            }
        });
        int a2 = m6072a(this.currentAd.mo8253ag());
        int i = 3;
        int i2 = (this.currentAd.mo8256aj() ? 3 : 5) | 48;
        if (!this.currentAd.mo8257ak()) {
            i = 5;
        }
        int i3 = i | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2, i2 | 48);
        this.f4946E.mo7436a(a2);
        int a3 = m6072a(this.currentAd.mo8254ah());
        int a4 = m6072a(this.currentAd.mo8255ai());
        layoutParams.setMargins(a4, a3, a4, a3);
        this.f4945D.addView(this.f4946E, layoutParams);
        C1563h a5 = C1563h.m6016a(this.currentAd.mo8283t(), this);
        this.f4948G = a5;
        a5.setVisibility(8);
        this.f4948G.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1580n.this.m6049A();
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a2, i3);
        layoutParams2.setMargins(a4, a3, a4, a3);
        this.f4948G.mo7436a(a2);
        this.f4945D.addView(this.f4948G, layoutParams2);
        this.f4948G.bringToFront();
        if (m6130n()) {
            int a6 = m6072a(((Integer) this.sdk.mo8549a(C1841c.f5876bW)).intValue());
            View view = new View(this);
            this.f4947F = view;
            view.setBackgroundColor(0);
            this.f4947F.setVisibility(8);
            View view2 = new View(this);
            this.f4949H = view2;
            view2.setBackgroundColor(0);
            this.f4949H.setVisibility(8);
            int i4 = a2 + a6;
            int a7 = a3 - m6072a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i4, i4, i2);
            layoutParams3.setMargins(a7, a7, a7, a7);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, i4, i3);
            layoutParams4.setMargins(a7, a7, a7, a7);
            this.f4947F.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1580n.this.f4946E.performClick();
                }
            });
            this.f4949H.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1580n.this.f4948G.performClick();
                }
            });
            this.f4945D.addView(this.f4947F, layoutParams3);
            this.f4947F.bringToFront();
            this.f4945D.addView(this.f4949H, layoutParams4);
            this.f4949H.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m6123k() {
        if (this.f4951J == null) {
            try {
                this.videoMuted = m6120i();
                this.f4951J = new ImageView(this);
                if (!m6126l()) {
                    int a = m6072a(((Integer) this.sdk.mo8549a(C1841c.f5931cZ)).intValue());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a, ((Integer) this.sdk.mo8549a(C1841c.f5985db)).intValue());
                    this.f4951J.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    int a2 = m6072a(((Integer) this.sdk.mo8549a(C1841c.f5984da)).intValue());
                    layoutParams.setMargins(a2, a2, a2, a2);
                    if ((this.videoMuted ? this.currentAd.mo8241aK() : this.currentAd.mo8242aL()) != null) {
                        C1977q v = this.sdk.mo8602v();
                        v.mo8742b("InterActivity", "Added mute button with params: " + layoutParams);
                        m6087a(this.videoMuted);
                        this.f4951J.setClickable(true);
                        this.f4951J.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                C1580n.this.toggleMute();
                            }
                        });
                        this.f4945D.addView(this.f4951J, layoutParams);
                        this.f4951J.bringToFront();
                        return;
                    }
                    this.sdk.mo8602v().mo8746e("InterActivity", "Attempting to add mute button but could not find uri");
                    return;
                }
                this.sdk.mo8602v().mo8742b("InterActivity", "Mute button should be hidden");
            } catch (Exception e) {
                this.sdk.mo8602v().mo8741a("InterActivity", "Failed to attach mute button", (Throwable) e);
            }
        }
    }

    /* renamed from: l */
    private boolean m6126l() {
        if (!((Boolean) this.sdk.mo8549a(C1841c.f5926cU)).booleanValue()) {
            return true;
        }
        if (!((Boolean) this.sdk.mo8549a(C1841c.f5927cV)).booleanValue() || m6120i()) {
            return false;
        }
        return !((Boolean) this.sdk.mo8549a(C1841c.f5929cX)).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m6127m() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C1580n.this.f4970j) {
                        C1580n.this.f4946E.setVisibility(0);
                        return;
                    }
                    long unused = C1580n.this.f4978r = SystemClock.elapsedRealtime();
                    boolean unused2 = C1580n.this.f4970j = true;
                    if (C1580n.this.m6130n() && C1580n.this.f4947F != null) {
                        C1580n.this.f4947F.setVisibility(0);
                        C1580n.this.f4947F.bringToFront();
                    }
                    C1580n.this.f4946E.setVisibility(0);
                    C1580n.this.f4946E.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(400);
                    alphaAnimation.setRepeatCount(0);
                    C1580n.this.f4946E.startAnimation(alphaAnimation);
                } catch (Throwable unused3) {
                    C1580n.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m6130n() {
        return ((Integer) this.sdk.mo8549a(C1841c.f5876bW)).intValue() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6131o() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (!C1580n.this.f4971k && C1580n.this.f4948G != null) {
                        long unused = C1580n.this.f4980t = -1;
                        long unused2 = C1580n.this.f4979s = SystemClock.elapsedRealtime();
                        boolean unused3 = C1580n.this.f4971k = true;
                        C1580n.this.f4948G.setVisibility(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(400);
                        alphaAnimation.setRepeatCount(0);
                        C1580n.this.f4948G.startAnimation(alphaAnimation);
                        if (C1580n.this.m6130n() && C1580n.this.f4949H != null) {
                            C1580n.this.f4949H.setVisibility(0);
                            C1580n.this.f4949H.bringToFront();
                        }
                    }
                } catch (Throwable th) {
                    C1977q qVar = C1580n.this.logger;
                    qVar.mo8745d("InterActivity", "Unable to show skip button: " + th);
                }
            }
        });
    }

    /* renamed from: p */
    private void m6133p() {
        C1563h hVar;
        if (this.currentAd.mo8279p() >= 0) {
            if (!this.f4972l || (hVar = this.f4948G) == null) {
                hVar = this.f4946E;
            }
            m6076a(C2029r.m8023b((float) this.currentAd.mo8279p()), hVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m6136q() {
        boolean z = ((Boolean) this.sdk.mo8549a(C1841c.f5913cH)).booleanValue() && m6141t() > 0;
        if (this.f4950I == null && z) {
            this.f4950I = new C1560f(this);
            int G = this.currentAd.mo8207G();
            this.f4950I.setTextColor(G);
            this.f4950I.setTextSize((float) ((Integer) this.sdk.mo8549a(C1841c.f5912cG)).intValue());
            this.f4950I.setFinishedStrokeColor(G);
            this.f4950I.setFinishedStrokeWidth((float) ((Integer) this.sdk.mo8549a(C1841c.f5911cF)).intValue());
            this.f4950I.setMax(m6141t());
            this.f4950I.setProgress(m6141t());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m6072a(((Integer) this.sdk.mo8549a(C1841c.f5910cE)).intValue()), m6072a(((Integer) this.sdk.mo8549a(C1841c.f5910cE)).intValue()), ((Integer) this.sdk.mo8549a(C1841c.f5909cD)).intValue());
            int a = m6072a(((Integer) this.sdk.mo8549a(C1841c.f5908cC)).intValue());
            layoutParams.setMargins(a, a, a, a);
            this.f4945D.addView(this.f4950I, layoutParams);
            this.f4950I.bringToFront();
            this.f4950I.setVisibility(0);
            final long s = m6139s();
            this.countdownManager.mo7442a("COUNTDOWN_CLOCK", 1000, (C1565i.C1567a) new C1565i.C1567a() {
                /* renamed from: a */
                public void mo7350a() {
                    if (C1580n.this.f4950I != null) {
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(s - ((long) C1580n.this.videoView.getCurrentPosition()));
                        if (seconds <= 0) {
                            C1580n.this.f4950I.setVisibility(8);
                            boolean unused = C1580n.this.f4975o = true;
                        } else if (C1580n.this.m6138r()) {
                            C1580n.this.f4950I.setProgress((int) seconds);
                        }
                    }
                }

                /* renamed from: b */
                public boolean mo7351b() {
                    return C1580n.this.m6138r();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m6138r() {
        return !this.f4975o && !this.postitialWasDisplayed && this.videoView.isPlaying();
    }

    /* renamed from: s */
    private long m6139s() {
        return TimeUnit.SECONDS.toMillis((long) m6141t());
    }

    /* renamed from: t */
    private int m6141t() {
        int F = this.currentAd.mo8206F();
        return (F <= 0 && ((Boolean) this.sdk.mo8549a(C1841c.f5993dj)).booleanValue()) ? this.computedLengthSeconds + 1 : F;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: u */
    public void m6144u() {
        if (this.f4955N == null && this.currentAd.mo8217Q()) {
            this.logger.mo8744c("InterActivity", "Attaching video progress bar...");
            ProgressBar progressBar = new ProgressBar(this, (AttributeSet) null, 16842872);
            this.f4955N = progressBar;
            progressBar.setMax(((Integer) this.sdk.mo8549a(C1841c.f5988de)).intValue());
            this.f4955N.setPadding(0, 0, 0, 0);
            if (C1991g.m7841d()) {
                try {
                    this.f4955N.setProgressTintList(ColorStateList.valueOf(this.currentAd.mo8218R()));
                } catch (Throwable th) {
                    this.logger.mo8743b("InterActivity", "Unable to update progress bar color.", th);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.mo8549a(C1841c.f5989df)).intValue());
            this.f4945D.addView(this.f4955N, layoutParams);
            this.f4955N.bringToFront();
            this.countdownManager.mo7442a("PROGRESS_BAR", ((Long) this.sdk.mo8549a(C1841c.f5987dd)).longValue(), (C1565i.C1567a) new C1565i.C1567a() {
                /* renamed from: a */
                public void mo7350a() {
                    if (C1580n.this.f4955N == null) {
                        return;
                    }
                    if (C1580n.this.shouldContinueFullLengthVideoCountdown()) {
                        C1580n.this.f4955N.setProgress((int) ((((float) C1580n.this.videoView.getCurrentPosition()) / ((float) C1580n.this.videoView.getDuration())) * ((float) ((Integer) C1580n.this.sdk.mo8549a(C1841c.f5988de)).intValue())));
                        return;
                    }
                    C1580n.this.f4955N.setVisibility(8);
                }

                /* renamed from: b */
                public boolean mo7351b() {
                    return C1580n.this.shouldContinueFullLengthVideoCountdown();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6145v() {
        final C1628s y = this.currentAd.mo8288y();
        if (C2025o.m7963b(this.currentAd.mo8287x()) && y != null && this.f4954M == null) {
            this.logger.mo8744c("InterActivity", "Attaching video button...");
            this.f4954M = m6148w();
            double a = (double) y.mo7538a();
            Double.isNaN(a);
            double b = (double) y.mo7539b();
            Double.isNaN(b);
            int width = this.videoView.getWidth();
            int height = this.videoView.getHeight();
            double d = (double) width;
            Double.isNaN(d);
            double d2 = (double) height;
            Double.isNaN(d2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((a / 100.0d) * d), (int) ((b / 100.0d) * d2), y.mo7541d());
            int a2 = m6072a(y.mo7540c());
            layoutParams.setMargins(a2, a2, a2, a2);
            this.f4945D.addView(this.f4954M, layoutParams);
            this.f4954M.bringToFront();
            if (y.mo7548i() > 0.0f) {
                this.f4954M.setVisibility(4);
                this.f4944C.postDelayed(new Runnable() {
                    public void run() {
                        long g = y.mo7545g();
                        C1580n nVar = C1580n.this;
                        nVar.m6079a((View) nVar.f4954M, true, g);
                        C1580n.this.f4954M.bringToFront();
                    }
                }, C2029r.m8023b(y.mo7548i()));
            }
            if (y.mo7549j() > 0.0f) {
                this.f4944C.postDelayed(new Runnable() {
                    public void run() {
                        long h = y.mo7546h();
                        C1580n nVar = C1580n.this;
                        nVar.m6079a((View) nVar.f4954M, false, h);
                    }
                }, C2029r.m8023b(y.mo7549j()));
            }
        }
    }

    /* renamed from: w */
    private C1629t m6148w() {
        C1977q qVar = this.logger;
        qVar.mo8742b("InterActivity", "Create video button with HTML = " + this.currentAd.mo8287x());
        C1630u uVar = new C1630u(this.sdk);
        this.f4956O = new C1630u.C1631a() {
            /* renamed from: a */
            public void mo7489a(C1629t tVar) {
                C1580n.this.logger.mo8742b("InterActivity", "Clicking through from video button...");
                C1580n.this.clickThroughFromVideo(tVar.getAndClearLastClickLocation());
            }

            /* renamed from: b */
            public void mo7490b(C1629t tVar) {
                C1580n.this.logger.mo8742b("InterActivity", "Closing ad from video button...");
                C1580n.this.dismiss();
            }

            /* renamed from: c */
            public void mo7491c(C1629t tVar) {
                C1580n.this.logger.mo8742b("InterActivity", "Skipping video from video button...");
                C1580n.this.skipVideo();
            }
        };
        uVar.mo7552a(new WeakReference(this.f4956O));
        C1629t a = C1629t.m6208a(this.sdk, uVar, getApplicationContext());
        a.mo7551a(this.currentAd.mo8287x());
        return a;
    }

    /* renamed from: x */
    private void m6149x() {
        if (this.f4973m && this.currentAd.mo8219S()) {
            C1515a aVar = new C1515a(this, ((Integer) this.sdk.mo8549a(C1841c.f5992di)).intValue(), this.currentAd.mo8221U());
            this.f4957P = aVar;
            aVar.setColor(this.currentAd.mo8222V());
            this.f4957P.setBackgroundColor(this.currentAd.mo8223W());
            this.f4957P.setVisibility(8);
            this.f4945D.addView(this.f4957P, new FrameLayout.LayoutParams(-1, -1, 17));
            this.f4945D.bringChildToFront(this.f4957P);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m6151y() {
        C1515a aVar = this.f4957P;
        if (aVar != null) {
            aVar.mo7293a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m6154z() {
        C1515a aVar = this.f4957P;
        if (aVar != null) {
            aVar.mo7294b();
        }
    }

    public void clickThroughFromVideo(PointF pointF) {
        try {
            this.sdk.mo8594o().trackAndLaunchVideoClick(this.currentAd, this.f4961a, this.currentAd.mo7163i(), pointF);
            C1994j.m7913a(this.f4962b.mo7522e(), (AppLovinAd) this.currentAd);
            if (this.f4964d != null) {
                this.f4964d.mo8361b();
            }
        } catch (Throwable th) {
            this.sdk.mo8602v().mo8743b("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    public void continueVideo() {
        m6070O();
    }

    public void dismiss() {
        long currentTimeMillis = System.currentTimeMillis() - this.f4976p;
        C1977q.m7748f("InterActivity", "Dismissing ad after " + currentTimeMillis + " milliseconds elapsed");
        C1941j jVar = this.sdk;
        if (jVar != null) {
            if (((Boolean) jVar.mo8549a(C1841c.f5924cS)).booleanValue()) {
                stopService(new Intent(getBaseContext(), AppKilledService.class));
                this.sdk.mo8570af().unregisterReceiver(this.f4960S);
            }
            this.sdk.mo8569ae().mo8502b((C1924e.C1926a) this);
        }
        m6116g();
        m6071P();
        if (this.f4962b != null) {
            if (this.currentAd != null) {
                m6102c((AppLovinAd) this.currentAd);
                C1854d dVar = this.f4964d;
                if (dVar != null) {
                    dVar.mo8363c();
                    this.f4964d = null;
                }
                m6086a("javascript:al_onPoststitialDismiss();", (long) this.currentAd.mo8247aa());
            }
            this.f4962b.mo7524g();
        }
        lastKnownWrapper = null;
        m6108d();
    }

    public void exitWithError(String str) {
        m6085a(str);
        try {
            C1977q.m7747c("InterActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + C1615o.f5036b + "; CleanedUp = " + C1615o.f5037c));
            m6102c((AppLovinAd) new C1833h(this.currentAd != null ? this.currentAd.getAdZone() : C1821d.m6859a(str, this.sdk), this.sdk));
        } catch (Exception e) {
            C1977q.m7747c("InterActivity", "Failed to show a video ad due to error:", e);
        }
        dismiss();
    }

    public boolean getPostitialWasDisplayed() {
        return this.postitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f4965e) {
            return 100;
        }
        AppLovinVideoView appLovinVideoView = this.videoView;
        if (appLovinVideoView != null) {
            int duration = appLovinVideoView.getDuration();
            if (duration <= 0) {
                return this.f4981u;
            }
            double currentPosition = (double) this.videoView.getCurrentPosition();
            double d = (double) duration;
            Double.isNaN(currentPosition);
            Double.isNaN(d);
            return (int) ((currentPosition / d) * 100.0d);
        }
        this.logger.mo8746e("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError(String str) {
        this.logger.mo8746e("InterActivity", str);
        if (this.f4983w.compareAndSet(false, true) && this.currentAd.mo8213M()) {
            m6085a(str);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFullyWatched() {
        return getVideoPercentViewed() >= this.currentAd.mo8225Y();
    }

    /* access modifiers changed from: protected */
    public boolean isVastAd() {
        return this.currentAd instanceof C1476a;
    }

    public void onBackPressed() {
        C1563h hVar;
        if (this.currentAd != null) {
            if (this.currentAd.mo8239aI() && !this.postitialWasDisplayed) {
                return;
            }
            if (this.currentAd.mo8240aJ() && this.postitialWasDisplayed) {
                return;
            }
        }
        if (m6104c()) {
            this.logger.mo8742b("InterActivity", "Back button was pressed; forwarding to Android for handling...");
        } else {
            try {
                if (!this.postitialWasDisplayed && this.f4972l && this.f4948G != null && this.f4948G.getVisibility() == 0 && this.f4948G.getAlpha() > 0.0f) {
                    this.logger.mo8742b("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                    hVar = this.f4948G;
                } else if (this.f4946E == null || this.f4946E.getVisibility() != 0 || this.f4946E.getAlpha() <= 0.0f) {
                    this.logger.mo8742b("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
                    m6098b("javascript:al_onBackPressed();");
                    return;
                } else {
                    this.logger.mo8742b("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                    hVar = this.f4946E;
                }
                hVar.performClick();
                m6098b("javascript:al_onBackPressed();");
                return;
            } catch (Exception unused) {
            }
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            java.lang.String r0 = "InterActivity"
            super.onCreate(r9)
            if (r9 == 0) goto L_0x0012
            java.lang.String r1 = "instance_impression_tracked"
            boolean r1 = r9.getBoolean(r1)
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.f4984x
            r2.set(r1)
        L_0x0012:
            r1 = 1
            r8.requestWindowFeature(r1)
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x01aa }
            java.lang.String r3 = "com.applovin.interstitial.wrapper_id"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ all -> 0x01aa }
            if (r2 == 0) goto L_0x01a7
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x01aa }
            if (r3 != 0) goto L_0x01a7
            com.applovin.impl.adview.o r2 = com.applovin.impl.adview.C1615o.m6164a((java.lang.String) r2)     // Catch:{ all -> 0x01aa }
            r8.f4962b = r2     // Catch:{ all -> 0x01aa }
            if (r2 != 0) goto L_0x003c
            com.applovin.impl.adview.o r2 = lastKnownWrapper     // Catch:{ all -> 0x01aa }
            if (r2 == 0) goto L_0x003c
            com.applovin.impl.adview.o r2 = lastKnownWrapper     // Catch:{ all -> 0x01aa }
            r8.f4962b = r2     // Catch:{ all -> 0x01aa }
        L_0x003c:
            com.applovin.impl.adview.o r2 = r8.f4962b     // Catch:{ all -> 0x01aa }
            if (r2 == 0) goto L_0x0193
            com.applovin.impl.adview.o r2 = r8.f4962b     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.ad.g r2 = r2.mo7519b()     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.o r3 = r8.f4962b     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r3 = r3.mo7516a()     // Catch:{ all -> 0x01aa }
            r8.sdk = r3     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.o r3 = r8.f4962b     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r3 = r3.mo7516a()     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.q r3 = r3.mo8602v()     // Catch:{ all -> 0x01aa }
            r8.logger = r3     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r3 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r4 = com.applovin.impl.sdk.p050b.C1841c.f5924cS     // Catch:{ all -> 0x01aa }
            java.lang.Object r3 = r3.mo8549a(r4)     // Catch:{ all -> 0x01aa }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01aa }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x01aa }
            if (r3 == 0) goto L_0x0091
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x01aa }
            android.content.Context r4 = r8.getBaseContext()     // Catch:{ all -> 0x01aa }
            java.lang.Class<com.applovin.impl.sdk.utils.AppKilledService> r5 = com.applovin.impl.sdk.utils.AppKilledService.class
            r3.<init>(r4, r5)     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.n$1 r4 = new com.applovin.impl.adview.n$1     // Catch:{ all -> 0x01aa }
            r4.<init>(r2, r3)     // Catch:{ all -> 0x01aa }
            r8.f4960S = r4     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r4 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.AppLovinBroadcastManager r4 = r4.mo8570af()     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver r5 = r8.f4960S     // Catch:{ all -> 0x01aa }
            android.content.IntentFilter r6 = new android.content.IntentFilter     // Catch:{ all -> 0x01aa }
            java.lang.String r7 = "com.applovin.app_killed"
            r6.<init>(r7)     // Catch:{ all -> 0x01aa }
            r4.registerReceiver(r5, r6)     // Catch:{ all -> 0x01aa }
            r8.startService(r3)     // Catch:{ all -> 0x01aa }
        L_0x0091:
            if (r2 == 0) goto L_0x018d
            com.applovin.impl.sdk.c.d r3 = new com.applovin.impl.sdk.c.d     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r4 = r8.sdk     // Catch:{ all -> 0x01aa }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x01aa }
            r8.f4964d = r3     // Catch:{ all -> 0x01aa }
            boolean r3 = r2.mo8267au()     // Catch:{ all -> 0x01aa }
            if (r3 == 0) goto L_0x00ab
            com.applovin.impl.sdk.j r3 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.e r3 = r3.mo8569ae()     // Catch:{ all -> 0x01aa }
            r3.mo8501a((com.applovin.impl.sdk.C1924e.C1926a) r8)     // Catch:{ all -> 0x01aa }
        L_0x00ab:
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r8.findViewById(r3)     // Catch:{ all -> 0x01aa }
            if (r3 == 0) goto L_0x00c7
            boolean r4 = r2.hasVideoUrl()     // Catch:{ all -> 0x01aa }
            if (r4 == 0) goto L_0x00c2
            int r4 = r2.mo8208H()     // Catch:{ all -> 0x01aa }
        L_0x00be:
            r3.setBackgroundColor(r4)     // Catch:{ all -> 0x01aa }
            goto L_0x00c7
        L_0x00c2:
            int r4 = r2.mo8209I()     // Catch:{ all -> 0x01aa }
            goto L_0x00be
        L_0x00c7:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01aa }
            r8.f4976p = r3     // Catch:{ all -> 0x01aa }
            boolean r3 = r2.mo8201A()     // Catch:{ all -> 0x01aa }
            if (r3 == 0) goto L_0x00dc
            android.view.Window r3 = r8.getWindow()     // Catch:{ all -> 0x01aa }
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            r3.setFlags(r4, r4)     // Catch:{ all -> 0x01aa }
        L_0x00dc:
            boolean r3 = r2.mo8202B()     // Catch:{ all -> 0x01aa }
            if (r3 == 0) goto L_0x00eb
            android.view.Window r3 = r8.getWindow()     // Catch:{ all -> 0x01aa }
            r4 = 128(0x80, float:1.794E-43)
            r3.addFlags(r4)     // Catch:{ all -> 0x01aa }
        L_0x00eb:
            int r3 = com.applovin.impl.sdk.utils.C2029r.m8034d((android.content.Context) r8)     // Catch:{ all -> 0x01aa }
            boolean r4 = com.applovin.sdk.AppLovinSdkUtils.isTablet(r8)     // Catch:{ all -> 0x01aa }
            int r5 = r8.m6073a((int) r3, (boolean) r4)     // Catch:{ all -> 0x01aa }
            if (r9 != 0) goto L_0x00fc
            r8.f4982v = r5     // Catch:{ all -> 0x01aa }
            goto L_0x0104
        L_0x00fc:
            java.lang.String r6 = "original_orientation"
            int r9 = r9.getInt(r6, r5)     // Catch:{ all -> 0x01aa }
            r8.f4982v = r9     // Catch:{ all -> 0x01aa }
        L_0x0104:
            boolean r9 = r2.mo8205E()     // Catch:{ all -> 0x01aa }
            if (r9 == 0) goto L_0x0132
            r9 = -1
            if (r5 == r9) goto L_0x0127
            com.applovin.impl.sdk.q r9 = r8.logger     // Catch:{ all -> 0x01aa }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01aa }
            r2.<init>()     // Catch:{ all -> 0x01aa }
            java.lang.String r3 = "Locking activity orientation to current orientation: "
            r2.append(r3)     // Catch:{ all -> 0x01aa }
            r2.append(r5)     // Catch:{ all -> 0x01aa }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01aa }
            r9.mo8742b(r0, r2)     // Catch:{ all -> 0x01aa }
            r8.m6093b((int) r5)     // Catch:{ all -> 0x01aa }
            goto L_0x013a
        L_0x0127:
            com.applovin.impl.sdk.q r9 = r8.logger     // Catch:{ all -> 0x01aa }
            java.lang.String r2 = "Unable to detect current orientation. Locking to targeted orientation..."
            r9.mo8746e(r0, r2)     // Catch:{ all -> 0x01aa }
        L_0x012e:
            r8.m6094b((int) r3, (boolean) r4)     // Catch:{ all -> 0x01aa }
            goto L_0x013a
        L_0x0132:
            com.applovin.impl.sdk.q r9 = r8.logger     // Catch:{ all -> 0x01aa }
            java.lang.String r2 = "Locking activity orientation to targeted orientation..."
            r9.mo8742b(r0, r2)     // Catch:{ all -> 0x01aa }
            goto L_0x012e
        L_0x013a:
            com.applovin.impl.adview.m r9 = new com.applovin.impl.adview.m     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r2 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.sdk.AppLovinSdk r2 = r2.mo8540S()     // Catch:{ all -> 0x01aa }
            com.applovin.sdk.AppLovinAdSize r3 = com.applovin.sdk.AppLovinAdSize.INTERSTITIAL     // Catch:{ all -> 0x01aa }
            r9.<init>(r2, r3, r8)     // Catch:{ all -> 0x01aa }
            r8.f4961a = r9     // Catch:{ all -> 0x01aa }
            com.applovin.adview.AdViewController r9 = r9.getAdViewController()     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.AdViewControllerImpl r9 = (com.applovin.impl.adview.AdViewControllerImpl) r9     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.c.d r2 = r8.f4964d     // Catch:{ all -> 0x01aa }
            r9.setStatsManagerHelper(r2)     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.o r9 = r8.f4962b     // Catch:{ all -> 0x01aa }
            r9.mo7517a((com.applovin.impl.adview.C1569j) r8)     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r9 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f5991dh     // Catch:{ all -> 0x01aa }
            java.lang.Object r9 = r9.mo8549a(r2)     // Catch:{ all -> 0x01aa }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x01aa }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x01aa }
            r8.f4972l = r9     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.a.b r9 = new com.applovin.impl.sdk.a.b     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r2 = r8.sdk     // Catch:{ all -> 0x01aa }
            r9.<init>(r8, r2)     // Catch:{ all -> 0x01aa }
            r8.f4953L = r9     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.n$12 r2 = new com.applovin.impl.adview.n$12     // Catch:{ all -> 0x01aa }
            r2.<init>()     // Catch:{ all -> 0x01aa }
            r9.mo8090a((com.applovin.impl.sdk.p048a.C1805b.C1813a) r2)     // Catch:{ all -> 0x01aa }
            com.applovin.impl.adview.n$23 r9 = new com.applovin.impl.adview.n$23     // Catch:{ all -> 0x01aa }
            r9.<init>()     // Catch:{ all -> 0x01aa }
            r8.f4959R = r9     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.j r9 = r8.sdk     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.a r9 = r9.mo8565aa()     // Catch:{ all -> 0x01aa }
            com.applovin.impl.sdk.utils.a r2 = r8.f4959R     // Catch:{ all -> 0x01aa }
            r9.mo8071a(r2)     // Catch:{ all -> 0x01aa }
            goto L_0x01bb
        L_0x018d:
            java.lang.String r9 = "No current ad found."
        L_0x018f:
            r8.exitWithError(r9)     // Catch:{ all -> 0x01aa }
            goto L_0x01bb
        L_0x0193:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01aa }
            r9.<init>()     // Catch:{ all -> 0x01aa }
            java.lang.String r2 = "Wrapper is null; initialized state: "
            r9.append(r2)     // Catch:{ all -> 0x01aa }
            boolean r2 = com.applovin.impl.adview.C1615o.f5036b     // Catch:{ all -> 0x01aa }
            r9.append(r2)     // Catch:{ all -> 0x01aa }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01aa }
            goto L_0x018f
        L_0x01a7:
            java.lang.String r9 = "Wrapper ID is null"
            goto L_0x018f
        L_0x01aa:
            r9 = move-exception
            com.applovin.impl.sdk.q r2 = r8.logger     // Catch:{ all -> 0x01cc }
            if (r2 == 0) goto L_0x01b6
            com.applovin.impl.sdk.q r2 = r8.logger     // Catch:{ all -> 0x01cc }
            java.lang.String r3 = "Encountered error during onCreate."
            r2.mo8743b(r0, r3, r9)     // Catch:{ all -> 0x01cc }
        L_0x01b6:
            java.lang.String r9 = "An error was encountered during interstitial ad creation."
            r8.exitWithError(r9)     // Catch:{ all -> 0x01cc }
        L_0x01bb:
            android.os.StrictMode.setThreadPolicy(r1)
            r8.m6116g()
            com.applovin.impl.sdk.c.d r9 = r8.f4964d
            if (r9 == 0) goto L_0x01c8
            r9.mo8359a()
        L_0x01c8:
            r8.m6065J()
            return
        L_0x01cc:
            r9 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)
            goto L_0x01d2
        L_0x01d1:
            throw r9
        L_0x01d2:
            goto L_0x01d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1580n.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r4.currentAd != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r4.currentAd == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        m6071P();
        m6102c((com.applovin.sdk.AppLovinAd) r4.currentAd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        super.onDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0084, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r4 = this;
            com.applovin.impl.adview.m r0 = r4.f4961a     // Catch:{ all -> 0x0067 }
            r1 = 0
            if (r0 == 0) goto L_0x001d
            com.applovin.impl.adview.m r0 = r4.f4961a     // Catch:{ all -> 0x0067 }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ all -> 0x0067 }
            boolean r2 = r0 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0016
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0067 }
            com.applovin.impl.adview.m r2 = r4.f4961a     // Catch:{ all -> 0x0067 }
            r0.removeView(r2)     // Catch:{ all -> 0x0067 }
        L_0x0016:
            com.applovin.impl.adview.m r0 = r4.f4961a     // Catch:{ all -> 0x0067 }
            r0.destroy()     // Catch:{ all -> 0x0067 }
            r4.f4961a = r1     // Catch:{ all -> 0x0067 }
        L_0x001d:
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x002b
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch:{ all -> 0x0067 }
            r0.pause()     // Catch:{ all -> 0x0067 }
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch:{ all -> 0x0067 }
            r0.stopPlayback()     // Catch:{ all -> 0x0067 }
        L_0x002b:
            com.applovin.impl.sdk.j r0 = r4.sdk     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0047
            java.lang.ref.WeakReference<android.media.MediaPlayer> r0 = r4.f4952K     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0067 }
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x003c
            r0.release()     // Catch:{ all -> 0x0067 }
        L_0x003c:
            com.applovin.impl.sdk.j r0 = r4.sdk     // Catch:{ all -> 0x0067 }
            com.applovin.impl.sdk.a r0 = r0.mo8565aa()     // Catch:{ all -> 0x0067 }
            com.applovin.impl.sdk.utils.a r2 = r4.f4959R     // Catch:{ all -> 0x0067 }
            r0.mo8073b(r2)     // Catch:{ all -> 0x0067 }
        L_0x0047:
            com.applovin.impl.adview.i r0 = r4.countdownManager     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0050
            com.applovin.impl.adview.i r0 = r4.countdownManager     // Catch:{ all -> 0x0067 }
            r0.mo7443b()     // Catch:{ all -> 0x0067 }
        L_0x0050:
            android.os.Handler r0 = r4.f4944C     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0059
            android.os.Handler r0 = r4.f4944C     // Catch:{ all -> 0x0067 }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0067 }
        L_0x0059:
            android.os.Handler r0 = r4.f4943B     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0062
            android.os.Handler r0 = r4.f4943B     // Catch:{ all -> 0x0067 }
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0067 }
        L_0x0062:
            com.applovin.impl.sdk.ad.g r0 = r4.currentAd
            if (r0 == 0) goto L_0x0081
            goto L_0x0079
        L_0x0067:
            r0 = move-exception
            com.applovin.impl.sdk.q r1 = r4.logger     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0075
            com.applovin.impl.sdk.q r1 = r4.logger     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = "InterActivity"
            java.lang.String r3 = "Unable to destroy video view"
            r1.mo8741a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0085 }
        L_0x0075:
            com.applovin.impl.sdk.ad.g r0 = r4.currentAd
            if (r0 == 0) goto L_0x0081
        L_0x0079:
            r4.m6071P()
            com.applovin.impl.sdk.ad.g r0 = r4.currentAd
            r4.m6102c((com.applovin.sdk.AppLovinAd) r0)
        L_0x0081:
            super.onDestroy()
            return
        L_0x0085:
            r0 = move-exception
            com.applovin.impl.sdk.ad.g r1 = r4.currentAd
            if (r1 == 0) goto L_0x0092
            r4.m6071P()
            com.applovin.impl.sdk.ad.g r1 = r4.currentAd
            r4.m6102c((com.applovin.sdk.AppLovinAd) r1)
        L_0x0092:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1580n.onDestroy():void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 25 || i == 24) && this.currentAd.mo8250ad() && m6067L()) {
            toggleMute();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.logger.mo8742b("InterActivity", "App paused...");
        this.f4977q = System.currentTimeMillis();
        if (this.postitialWasDisplayed) {
            m6068M();
        }
        this.f4953L.mo8089a();
        pauseReportRewardTask();
        m6098b("javascript:al_onAppPaused();");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (r0 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a5, code lost:
        if (r2 == false) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()
            com.applovin.impl.sdk.q r0 = r5.logger
            java.lang.String r1 = "InterActivity"
            java.lang.String r2 = "App resumed..."
            r0.mo8742b(r1, r2)
            boolean r0 = r5.f4974n
            if (r0 != 0) goto L_0x00ae
            com.applovin.impl.sdk.c.d r0 = r5.f4964d
            if (r0 == 0) goto L_0x001e
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r5.f4977q
            long r1 = r1 - r3
            r0.mo8366d(r1)
        L_0x001e:
            com.applovin.impl.sdk.j r0 = r5.sdk
            com.applovin.impl.sdk.b.e<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1843e.f6108v
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.mo8574b(r1, r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 0
            if (r0 == 0) goto L_0x0070
            com.applovin.impl.sdk.a.b r0 = r5.f4953L
            boolean r0 = r0.mo8093d()
            if (r0 != 0) goto L_0x0070
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto L_0x0070
            r5.m6069N()
            r5.m6151y()
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.sdk.j r0 = r5.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1841c.f5907cB
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            boolean r0 = r0.mo8204D()
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r5.f4972l
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.adview.h r0 = r5.f4948G
            if (r0 == 0) goto L_0x00aa
            goto L_0x00a7
        L_0x0070:
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p049ad.C1817a
            if (r0 == 0) goto L_0x0081
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            com.applovin.impl.sdk.ad.a r0 = (com.applovin.impl.sdk.p049ad.C1817a) r0
            boolean r0 = r0.mo8163k()
            if (r0 == 0) goto L_0x0081
            r2 = 1
        L_0x0081:
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.sdk.j r0 = r5.sdk
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1841c.f5907cB
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            boolean r0 = r0.mo8203C()
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r5.postitialWasDisplayed
            if (r0 == 0) goto L_0x00aa
            com.applovin.impl.adview.h r0 = r5.f4946E
            if (r0 == 0) goto L_0x00aa
            if (r2 != 0) goto L_0x00aa
        L_0x00a7:
            r5.m6076a((long) r3, (com.applovin.impl.adview.C1563h) r0)
        L_0x00aa:
            r5.resumeReportRewardTask()
            goto L_0x00c9
        L_0x00ae:
            com.applovin.impl.sdk.a.b r0 = r5.f4953L
            boolean r0 = r0.mo8093d()
            if (r0 != 0) goto L_0x00c9
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto L_0x00c9
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            if (r0 == 0) goto L_0x00c9
            com.applovin.impl.sdk.ad.g r0 = r5.currentAd
            boolean r0 = r0.mo8220T()
            if (r0 == 0) goto L_0x00c9
            r5.m6151y()
        L_0x00c9:
            java.lang.String r0 = "javascript:al_onAppResumed();"
            r5.m6098b((java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1580n.onResume():void");
    }

    public void onRingerModeChanged(int i) {
        String str;
        if (this.f4986z != C1924e.f6359a) {
            this.f4942A = true;
        }
        C1548c adWebView = ((AdViewControllerImpl) this.f4961a.getAdViewController()).getAdWebView();
        if (adWebView != null) {
            if (C1924e.m7397a(i) && !C1924e.m7397a(this.f4986z)) {
                str = "javascript:al_muteSwitchOn();";
            } else if (i == 2) {
                str = "javascript:al_muteSwitchOff();";
            }
            adWebView.mo7372a(str);
        }
        this.f4986z = i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("instance_impression_tracked", this.f4984x.get());
        bundle.putInt("original_orientation", this.f4982v);
    }

    public void onWindowFocusChanged(boolean z) {
        String str;
        super.onWindowFocusChanged(z);
        C1941j jVar = this.sdk;
        if (z) {
            if (jVar != null) {
                this.logger.mo8742b("InterActivity", "Window gained focus");
                try {
                    if (!C1991g.m7840c() || !((Boolean) this.sdk.mo8549a(C1841c.f5986dc)).booleanValue() || !m6088a()) {
                        getWindow().setFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                    } else {
                        m6092b();
                        if (((Long) this.sdk.mo8549a(C1841c.f5917cL)).longValue() > 0) {
                            this.f4944C.postDelayed(new Runnable() {
                                public void run() {
                                    C1580n.this.m6092b();
                                }
                            }, ((Long) this.sdk.mo8549a(C1841c.f5917cL)).longValue());
                        }
                    }
                    if (((Boolean) this.sdk.mo8549a(C1841c.f5918cM)).booleanValue() && !this.postitialWasDisplayed) {
                        m6069N();
                        resumeReportRewardTask();
                    }
                } catch (Throwable th) {
                    this.logger.mo8743b("InterActivity", "Setting window flags failed.", th);
                }
                this.f4974n = false;
                m6098b("javascript:al_onWindowFocusChanged( " + z + " );");
            }
            str = "Window gained focus. SDK is null.";
        } else if (jVar != null) {
            this.logger.mo8742b("InterActivity", "Window lost focus");
            if (((Boolean) this.sdk.mo8549a(C1841c.f5918cM)).booleanValue() && !this.postitialWasDisplayed) {
                m6068M();
                pauseReportRewardTask();
            }
            this.f4974n = false;
            m6098b("javascript:al_onWindowFocusChanged( " + z + " );");
        } else {
            str = "Window lost focus. SDK is null.";
        }
        C1977q.m7748f("InterActivity", str);
        this.f4974n = false;
        m6098b("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void pauseReportRewardTask() {
        C2026p pVar = this.f4958Q;
        if (pVar != null) {
            pVar.mo8812b();
        }
    }

    /* access modifiers changed from: protected */
    public void playVideo() {
        m6110d((AppLovinAd) this.currentAd);
        this.videoView.start();
        this.countdownManager.mo7441a();
    }

    public void resumeReportRewardTask() {
        C2026p pVar = this.f4958Q;
        if (pVar != null) {
            pVar.mo8813c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldContinueFullLengthVideoCountdown() {
        return !this.f4965e && !this.postitialWasDisplayed;
    }

    public void showPostitial() {
        try {
            m6066K();
            if (this.f4961a != null) {
                ViewParent parent = this.f4961a.getParent();
                if ((parent instanceof ViewGroup) && (!((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue() || parent != this.f4945D)) {
                    ((ViewGroup) parent).removeView(this.f4961a);
                }
                FrameLayout frameLayout = ((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue() ? this.f4945D : new FrameLayout(this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.currentAd.mo8209I());
                if (((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue()) {
                    this.f4961a.setVisibility(0);
                } else {
                    frameLayout.addView(this.f4961a);
                }
                if (this.f4945D != null) {
                    if (((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue()) {
                        C1985b.m7817a(this.f4945D, this.f4961a);
                    } else {
                        this.f4945D.removeAllViewsInLayout();
                    }
                }
                if (m6130n() && this.f4947F != null) {
                    if (this.f4947F.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f4947F.getParent()).removeView(this.f4947F);
                    }
                    frameLayout.addView(this.f4947F);
                    this.f4947F.bringToFront();
                }
                if (this.f4946E != null) {
                    ViewParent parent2 = this.f4946E.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f4946E);
                    }
                    frameLayout.addView(this.f4946E);
                    this.f4946E.bringToFront();
                }
                if (!((Boolean) this.sdk.mo8549a(C1841c.f6032eW)).booleanValue()) {
                    setContentView(frameLayout);
                }
                if (((Boolean) this.sdk.mo8549a(C1841c.f6026eQ)).booleanValue()) {
                    this.f4961a.setVisibility(4);
                    this.f4961a.setVisibility(0);
                }
                m6086a("javascript:al_onPoststitialShow();", (long) this.currentAd.mo8226Z());
            }
            if ((this.currentAd instanceof C1817a) && ((C1817a) this.currentAd).mo8163k()) {
                this.logger.mo8742b("InterActivity", "Skip showing of close button");
            } else if (this.currentAd.mo8281r() >= 0) {
                m6076a(C2029r.m8023b((float) this.currentAd.mo8281r()), this.f4946E);
            } else if (this.currentAd.mo8281r() == -2) {
                this.f4946E.setVisibility(0);
            } else {
                m6076a(0, this.f4946E);
            }
            this.postitialWasDisplayed = true;
        } catch (Throwable th) {
            this.logger.mo8743b("InterActivity", "Encountered error while showing postitial. Dismissing...", th);
            dismiss();
        }
    }

    public void skipVideo() {
        this.f4980t = SystemClock.elapsedRealtime() - this.f4979s;
        C1854d dVar = this.f4964d;
        if (dVar != null) {
            dVar.mo8368f();
        }
        if (this.currentAd.mo8284u()) {
            dismiss();
        } else {
            showPostitial();
        }
    }

    public void toggleMute() {
        boolean z = !m6067L();
        try {
            m6103c(z);
            m6087a(z);
            m6099b(z);
        } catch (Throwable th) {
            this.logger.mo8743b("InterActivity", "Unable to set volume to " + z, th);
        }
    }
}
