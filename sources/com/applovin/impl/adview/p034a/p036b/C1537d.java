package com.applovin.impl.adview.p034a.p036b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoViewV2;
import com.applovin.impl.adview.C1515a;
import com.applovin.impl.adview.C1565i;
import com.applovin.impl.adview.C1578l;
import com.applovin.impl.adview.p034a.p035a.C1519c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p049ad.C1834i;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1871ad;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C2057R;
import com.vungle.warren.AdLoader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.applovin.impl.adview.a.b.d */
public class C1537d extends C1520a {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final ProgressBar f4830A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final C1545a f4831B = new C1545a();

    /* renamed from: C */
    private final Handler f4832C;

    /* renamed from: D */
    private final boolean f4833D;

    /* renamed from: E */
    private int f4834E;

    /* renamed from: F */
    private int f4835F;

    /* renamed from: G */
    private AtomicBoolean f4836G;

    /* renamed from: H */
    private AtomicBoolean f4837H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public long f4838I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f4839J;

    /* renamed from: q */
    protected final AppLovinVideoViewV2 f4840q;

    /* renamed from: r */
    protected final C1565i f4841r;

    /* renamed from: s */
    protected boolean f4842s;

    /* renamed from: t */
    protected long f4843t;

    /* renamed from: u */
    protected boolean f4844u;

    /* renamed from: v */
    private final C1519c f4845v = new C1519c(this.f4782a, this.f4785d, this.f4783b);
    /* access modifiers changed from: private */

    /* renamed from: w */
    public MediaPlayer f4846w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final C1515a f4847x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final C1578l f4848y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final ImageView f4849z;

    /* renamed from: com.applovin.impl.adview.a.b.d$a */
    private class C1545a implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private C1545a() {
        }

        public void onClick(View view, PointF pointF) {
            C1537d.this.mo7344a(pointF);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            C1537d.this.f4784c.mo8742b("InterActivityV2", "Video completed");
            C1537d.this.mo7349v();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C1537d dVar = C1537d.this;
            dVar.mo7345c("Video view error (" + i + "," + i2 + ")");
            C1537d.this.f4840q.start();
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C1977q qVar = C1537d.this.f4784c;
            qVar.mo8742b("InterActivityV2", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            if (i == 701) {
                if (C1537d.this.f4847x != null) {
                    C1537d.this.f4847x.mo7293a();
                }
                C1537d.this.f4786e.mo8369g();
                return false;
            }
            if (i == 3) {
                C1537d.this.f4841r.mo7441a();
                if (C1537d.this.f4848y != null) {
                    C1537d.this.m5961z();
                }
                if (C1537d.this.f4847x == null) {
                    return false;
                }
            } else if (i != 702 || C1537d.this.f4847x == null) {
                return false;
            }
            C1537d.this.f4847x.mo7294b();
            return false;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = C1537d.this.f4846w = mediaPlayer;
            mediaPlayer.setOnInfoListener(C1537d.this.f4831B);
            mediaPlayer.setOnErrorListener(C1537d.this.f4831B);
            float f = C1537d.this.f4842s ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            C1537d.this.f4843t = (long) mediaPlayer.getDuration();
            C1537d.this.mo7328q();
            C1977q qVar = C1537d.this.f4784c;
            qVar.mo8742b("InterActivityV2", "MediaPlayer prepared: " + C1537d.this.f4846w);
        }
    }

    /* renamed from: com.applovin.impl.adview.a.b.d$b */
    private class C1546b implements View.OnClickListener {
        private C1546b() {
        }

        public void onClick(View view) {
            if (view == C1537d.this.f4848y) {
                if (C1537d.this.mo7327p()) {
                    C1537d.this.mo7346s();
                    C1537d.this.mo7325n();
                    C1537d.this.f4796o.mo8091b();
                    return;
                }
                C1537d.this.mo7347t();
            } else if (view == C1537d.this.f4849z) {
                C1537d.this.mo7348u();
            } else {
                C1977q qVar = C1537d.this.f4784c;
                qVar.mo8746e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C1537d(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f4832C = handler;
        this.f4841r = new C1565i(handler, this.f4783b);
        this.f4833D = this.f4782a.mo7154d();
        this.f4842s = mo7329r();
        this.f4835F = -1;
        this.f4836G = new AtomicBoolean();
        this.f4837H = new AtomicBoolean();
        this.f4838I = -2;
        this.f4839J = 0;
        if (gVar.hasVideoUrl()) {
            AppLovinVideoViewV2 appLovinVideoViewV2 = new AppLovinVideoViewV2(gVar.mo8246aP(), appLovinFullscreenActivity, jVar);
            this.f4840q = appLovinVideoViewV2;
            appLovinVideoViewV2.setOnPreparedListener(this.f4831B);
            this.f4840q.setOnCompletionListener(this.f4831B);
            this.f4840q.setOnErrorListener(this.f4831B);
            this.f4840q.setOnTouchListener(new AppLovinTouchToClickListener(jVar, C1841c.f5805aE, appLovinFullscreenActivity, this.f4831B));
            C1546b bVar = new C1546b();
            if (gVar.mo8279p() >= 0) {
                C1578l lVar = new C1578l(gVar.mo8283t(), appLovinFullscreenActivity);
                this.f4848y = lVar;
                lVar.setVisibility(8);
                this.f4848y.setOnClickListener(bVar);
            } else {
                this.f4848y = null;
            }
            if (m5951a(this.f4842s, jVar)) {
                ImageView imageView = new ImageView(appLovinFullscreenActivity);
                this.f4849z = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f4849z.setClickable(true);
                this.f4849z.setOnClickListener(bVar);
                m5956d(this.f4842s);
            } else {
                this.f4849z = null;
            }
            if (this.f4833D) {
                C1515a aVar = new C1515a(appLovinFullscreenActivity, ((Integer) jVar.mo8549a(C1841c.f5992di)).intValue(), 16842874);
                this.f4847x = aVar;
                aVar.setColor(Color.parseColor("#75FFFFFF"));
                this.f4847x.setBackgroundColor(Color.parseColor("#00000000"));
                this.f4847x.setVisibility(8);
            } else {
                this.f4847x = null;
            }
            if (gVar.mo8217Q()) {
                ProgressBar progressBar = new ProgressBar(appLovinFullscreenActivity, (AttributeSet) null, 16842872);
                this.f4830A = progressBar;
                progressBar.setMax(C6078a.DEFAULT_TIMEOUT);
                this.f4830A.setPadding(0, 0, 0, 0);
                if (C1991g.m7841d()) {
                    this.f4830A.setProgressTintList(ColorStateList.valueOf(gVar.mo8218R()));
                }
                this.f4841r.mo7442a("PROGRESS_BAR", ((Long) jVar.mo8549a(C1841c.f5987dd)).longValue(), (C1565i.C1567a) new C1565i.C1567a() {
                    /* renamed from: a */
                    public void mo7350a() {
                        C1537d dVar = C1537d.this;
                        if (dVar.f4844u) {
                            dVar.f4830A.setVisibility(8);
                            return;
                        }
                        C1537d dVar2 = C1537d.this;
                        dVar2.f4830A.setProgress((int) ((((float) dVar.f4840q.getCurrentPosition()) / ((float) dVar2.f4843t)) * 10000.0f));
                    }

                    /* renamed from: b */
                    public boolean mo7351b() {
                        return !C1537d.this.f4844u;
                    }
                });
                return;
            }
            this.f4830A = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* renamed from: A */
    private void m5946A() {
        this.f4834E = mo7354y();
        this.f4840q.stopPlayback();
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m5947B() {
        C1977q qVar;
        String str;
        if (this.f4844u) {
            qVar = this.f4784c;
            str = "Skip video resume - postitial shown";
        } else if (this.f4783b.mo8546Y().mo8846a()) {
            qVar = this.f4784c;
            str = "Skip video resume - app paused";
        } else if (this.f4835F > 0) {
            C1977q qVar2 = this.f4784c;
            qVar2.mo8742b("InterActivityV2", "Resuming video at position " + this.f4835F + "ms for MediaPlayer: " + this.f4846w);
            this.f4840q.start();
            this.f4841r.mo7441a();
            this.f4835F = -1;
            mo7306a((Runnable) new Runnable() {
                public void run() {
                    if (C1537d.this.f4847x != null) {
                        C1537d.this.f4847x.mo7293a();
                        C1537d.this.mo7306a((Runnable) new Runnable() {
                            public void run() {
                                C1537d.this.f4847x.mo7294b();
                            }
                        }, (long) AdLoader.RETRY_DELAY);
                    }
                }
            }, 250);
            return;
        } else {
            this.f4784c.mo8742b("InterActivityV2", "Invalid last video position");
            return;
        }
        qVar.mo8745d("InterActivityV2", str);
    }

    /* renamed from: a */
    private static boolean m5951a(boolean z, C1941j jVar) {
        if (!((Boolean) jVar.mo8549a(C1841c.f5926cU)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.mo8549a(C1841c.f5927cV)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) jVar.mo8549a(C1841c.f5929cX)).booleanValue();
    }

    /* renamed from: d */
    private void m5956d(boolean z) {
        if (C1991g.m7841d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f4785d.getDrawable(z ? C2057R.C2058drawable.unmute_to_mute : C2057R.C2058drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f4849z.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f4849z.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aK = z ? this.f4782a.mo8241aK() : this.f4782a.mo8242aL();
        int dpToPx = AppLovinSdkUtils.dpToPx(this.f4785d, ((Integer) this.f4783b.mo8549a(C1841c.f5931cZ)).intValue());
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        AppLovinSdkUtils.safePopulateImageView(this.f4849z, aK, dpToPx);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m5961z() {
        if (this.f4837H.compareAndSet(false, true)) {
            mo7305a(this.f4848y, this.f4782a.mo8279p(), new Runnable() {
                public void run() {
                    long unused = C1537d.this.f4838I = -1;
                    long unused2 = C1537d.this.f4839J = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: a */
    public void mo7341a() {
        this.f4784c.mo8742b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* renamed from: a */
    public void mo7301a(int i, KeyEvent keyEvent) {
        super.mo7301a(i, keyEvent);
        if ((i == 25 || i == 24) && this.f4782a.mo8250ad() && this.f4842s) {
            mo7348u();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7344a(PointF pointF) {
        if (this.f4782a.mo7169z()) {
            this.f4784c.mo8742b("InterActivityV2", "Clicking through video");
            Uri i = this.f4782a.mo7163i();
            if (i != null) {
                C1994j.m7913a(this.f4793l, (AppLovinAd) this.f4782a);
                this.f4783b.mo8594o().trackAndLaunchVideoClick(this.f4782a, this.f4787f, i, pointF);
                this.f4786e.mo8361b();
            }
        }
    }

    /* renamed from: b */
    public void mo7342b() {
        this.f4784c.mo8742b("InterActivityV2", "Skipping video from prompt");
        mo7347t();
    }

    /* renamed from: c */
    public void mo7313c() {
        this.f4845v.mo7299a(this.f4849z, this.f4848y, this.f4847x, this.f4830A, this.f4840q, this.f4787f);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        mo7309a(!this.f4833D);
        this.f4840q.setVideoURI(this.f4782a.mo7157f());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        this.f4840q.start();
        if (this.f4833D) {
            this.f4847x.mo7293a();
        }
        this.f4787f.renderAd(this.f4782a);
        this.f4786e.mo8362b(this.f4833D ? 1 : 0);
        if (this.f4848y != null) {
            this.f4783b.mo8533L().mo8477a((C1864a) new C1871ad(this.f4783b, new Runnable() {
                public void run() {
                    C1537d.this.m5961z();
                }
            }), C1907s.C1909a.MAIN, this.f4782a.mo8280q(), true);
        }
        super.mo7312b(this.f4842s);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7345c(String str) {
        C1977q qVar = this.f4784c;
        qVar.mo8746e("InterActivityV2", "Encountered media error: " + str + " for ad: " + this.f4782a);
        if (this.f4836G.compareAndSet(false, true) && this.f4782a.mo8213M()) {
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.f4794m;
            if (appLovinAdDisplayListener instanceof C1834i) {
                ((C1834i) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            mo7317f();
        }
    }

    /* renamed from: c */
    public void mo7314c(boolean z) {
        super.mo7314c(z);
        if (z) {
            mo7352w();
        } else if (!this.f4844u) {
            mo7346s();
        }
    }

    /* renamed from: f */
    public void mo7317f() {
        this.f4841r.mo7443b();
        this.f4832C.removeCallbacksAndMessages((Object) null);
        mo7323l();
        super.mo7317f();
    }

    /* renamed from: h */
    public void mo7319h() {
        this.f4784c.mo8744c("InterActivityV2", "Destroying video components");
        try {
            if (this.f4840q != null) {
                this.f4840q.pause();
                this.f4840q.stopPlayback();
            }
            if (this.f4846w != null) {
                this.f4846w.release();
            }
        } catch (Throwable th) {
            Log.e("InterActivityV2", "Unable to destroy presenter", th);
        }
        super.mo7319h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo7323l() {
        super.mo7302a(mo7354y(), this.f4833D, mo7353x(), this.f4838I);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo7327p() {
        return this.f4782a.getType() == AppLovinAdType.INCENTIVIZED && !mo7353x();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo7328q() {
        long j;
        int j2;
        long j3 = 0;
        if (this.f4782a.mo8259am() >= 0 || this.f4782a.mo8260an() >= 0) {
            int i = (this.f4782a.mo8259am() > 0 ? 1 : (this.f4782a.mo8259am() == 0 ? 0 : -1));
            C1827g gVar = this.f4782a;
            if (i >= 0) {
                j = gVar.mo8259am();
            } else {
                C1817a aVar = (C1817a) gVar;
                long j4 = this.f4843t;
                if (j4 > 0) {
                    j3 = 0 + j4;
                }
                if (aVar.mo8261ao() && ((j2 = (int) ((C1817a) this.f4782a).mo8162j()) > 0 || (j2 = (int) aVar.mo8281r()) > 0)) {
                    j3 += TimeUnit.SECONDS.toMillis((long) j2);
                }
                double d = (double) j3;
                double an = (double) this.f4782a.mo8260an();
                Double.isNaN(an);
                Double.isNaN(d);
                j = (long) (d * (an / 100.0d));
            }
            mo7303a(j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void mo7346s() {
        String str;
        C1977q qVar;
        this.f4784c.mo8742b("InterActivityV2", "Pausing video");
        if (this.f4840q.isPlaying()) {
            this.f4835F = this.f4840q.getCurrentPosition();
            this.f4840q.pause();
            this.f4841r.mo7444c();
            qVar = this.f4784c;
            str = "Paused video at position " + this.f4835F + "ms";
        } else {
            qVar = this.f4784c;
            str = "Nothing to pause";
        }
        qVar.mo8742b("InterActivityV2", str);
    }

    /* renamed from: t */
    public void mo7347t() {
        this.f4838I = SystemClock.elapsedRealtime() - this.f4839J;
        C1977q qVar = this.f4784c;
        qVar.mo8742b("InterActivityV2", "Skipping video with skip time: " + this.f4838I + "ms");
        this.f4786e.mo8368f();
        if (this.f4782a.mo8284u()) {
            mo7317f();
        } else {
            mo7349v();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo7348u() {
        MediaPlayer mediaPlayer = this.f4846w;
        if (mediaPlayer != null) {
            boolean z = !this.f4842s;
            this.f4842s = z;
            float f = z ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            m5956d(this.f4842s);
            mo7310a(this.f4842s, 0);
        }
    }

    /* renamed from: v */
    public void mo7349v() {
        this.f4784c.mo8742b("InterActivityV2", "Showing postitial...");
        m5946A();
        this.f4845v.mo7300a(this.f4788g, this.f4787f);
        mo7308a("javascript:al_onPoststitialShow();", (long) this.f4782a.mo8226Z());
        if (this.f4788g != null) {
            int i = (this.f4782a.mo8281r() > 0 ? 1 : (this.f4782a.mo8281r() == 0 ? 0 : -1));
            C1578l lVar = this.f4788g;
            if (i >= 0) {
                mo7305a(lVar, this.f4782a.mo8281r(), new Runnable() {
                    public void run() {
                        C1537d.this.f4790i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                lVar.setVisibility(0);
            }
        }
        this.f4844u = true;
    }

    /* renamed from: w */
    public void mo7352w() {
        mo7306a((Runnable) new Runnable() {
            public void run() {
                C1537d.this.m5947B();
            }
        }, 250);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo7353x() {
        return mo7354y() >= this.f4782a.mo8225Y();
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public int mo7354y() {
        long currentPosition = (long) this.f4840q.getCurrentPosition();
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f4843t)) * 100.0f) : this.f4834E;
    }
}
