package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

@TargetApi(14)
/* renamed from: com.adcolony.sdk.l0 */
class C1364l0 extends TextureView implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f4282A;

    /* renamed from: B */
    private boolean f4283B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f4284C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f4285D;

    /* renamed from: E */
    private boolean f4286E;

    /* renamed from: F */
    private String f4287F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f4288G;

    /* renamed from: H */
    private FileInputStream f4289H;

    /* renamed from: I */
    private C1454x f4290I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C1205c f4291J;

    /* renamed from: K */
    private Surface f4292K;

    /* renamed from: L */
    private SurfaceTexture f4293L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public RectF f4294M = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: N */
    public C1374j f4295N;

    /* renamed from: O */
    private ProgressBar f4296O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public MediaPlayer f4297P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public JSONObject f4298Q = C1437s.m5599b();

    /* renamed from: R */
    private ExecutorService f4299R = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C1454x f4300S;

    /* renamed from: a */
    private float f4301a;

    /* renamed from: b */
    private float f4302b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f4303c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f4304d;

    /* renamed from: e */
    private float f4305e;

    /* renamed from: f */
    private float f4306f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f4307g;

    /* renamed from: h */
    private boolean f4308h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Paint f4309i = new Paint();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Paint f4310j = new Paint(1);

    /* renamed from: k */
    private int f4311k;

    /* renamed from: l */
    private int f4312l;

    /* renamed from: m */
    private int f4313m;

    /* renamed from: n */
    private int f4314n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f4315o;

    /* renamed from: p */
    private int f4316p;

    /* renamed from: q */
    private int f4317q;

    /* renamed from: r */
    private int f4318r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public double f4319s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public double f4320t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f4321u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f4322v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f4323w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f4324x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f4325y;

    /* renamed from: z */
    private boolean f4326z;

    /* renamed from: com.adcolony.sdk.l0$a */
    class C1365a implements C1458z {
        C1365a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                C1364l0.this.mo6686i();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$b */
    class C1366b implements C1458z {
        C1366b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                C1364l0.this.m5361c(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$c */
    class C1367c implements C1458z {
        C1367c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                C1364l0.this.m5363d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$d */
    class C1368d implements C1458z {
        C1368d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                C1364l0.this.mo6685h();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$e */
    class C1369e implements C1458z {
        C1369e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                boolean unused = C1364l0.this.m5358b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$f */
    class C1370f implements C1458z {
        C1370f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1364l0.this.m5353a(xVar)) {
                boolean unused = C1364l0.this.m5368e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$g */
    class C1371g implements Runnable {
        C1371g() {
        }

        public void run() {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (C1364l0.this.f4300S != null) {
                JSONObject b = C1437s.m5599b();
                C1437s.m5602b(b, "id", C1364l0.this.f4315o);
                C1437s.m5592a(b, "ad_session_id", C1364l0.this.f4288G);
                C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
                C1364l0.this.f4300S.mo6829a(b).mo6834d();
                C1454x unused = C1364l0.this.f4300S = null;
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$h */
    class C1372h implements Runnable {
        C1372h() {
        }

        public void run() {
            long unused = C1364l0.this.f4321u = 0;
            while (!C1364l0.this.f4322v && !C1364l0.this.f4325y && C1199a.m4881d()) {
                Context b = C1199a.m4878b();
                if (!C1364l0.this.f4322v && !C1364l0.this.f4282A && b != null && (b instanceof Activity)) {
                    if (C1364l0.this.f4297P.isPlaying()) {
                        if (C1364l0.this.f4321u == 0 && C1199a.f3339d) {
                            long unused2 = C1364l0.this.f4321u = System.currentTimeMillis();
                        }
                        boolean unused3 = C1364l0.this.f4324x = true;
                        C1364l0 l0Var = C1364l0.this;
                        double currentPosition = (double) l0Var.f4297P.getCurrentPosition();
                        Double.isNaN(currentPosition);
                        double unused4 = l0Var.f4319s = currentPosition / 1000.0d;
                        C1364l0 l0Var2 = C1364l0.this;
                        double duration = (double) l0Var2.f4297P.getDuration();
                        Double.isNaN(duration);
                        double unused5 = l0Var2.f4320t = duration / 1000.0d;
                        if (System.currentTimeMillis() - C1364l0.this.f4321u > 1000 && !C1364l0.this.f4285D && C1199a.f3339d) {
                            if (C1364l0.this.f4319s == 0.0d) {
                                new C1439u.C1440a().mo6801a("getCurrentPosition() not working, firing ").mo6801a("AdSession.on_error").mo6803a(C1439u.f4517j);
                                C1364l0.this.m5371g();
                            } else {
                                boolean unused6 = C1364l0.this.f4285D = true;
                            }
                        }
                        if (C1364l0.this.f4284C) {
                            C1364l0.this.mo6683e();
                        }
                    }
                    if (C1364l0.this.f4324x && !C1364l0.this.f4322v && !C1364l0.this.f4325y) {
                        C1437s.m5602b(C1364l0.this.f4298Q, "id", C1364l0.this.f4315o);
                        C1437s.m5602b(C1364l0.this.f4298Q, "container_id", C1364l0.this.f4291J.mo6410c());
                        C1437s.m5592a(C1364l0.this.f4298Q, "ad_session_id", C1364l0.this.f4288G);
                        C1437s.m5590a(C1364l0.this.f4298Q, "elapsed", C1364l0.this.f4319s);
                        C1437s.m5590a(C1364l0.this.f4298Q, "duration", C1364l0.this.f4320t);
                        new C1454x("VideoView.on_progress", C1364l0.this.f4291J.mo6428k(), C1364l0.this.f4298Q).mo6834d();
                    }
                    if (C1364l0.this.f4323w || ((Activity) b).isFinishing()) {
                        boolean unused7 = C1364l0.this.f4323w = false;
                        C1364l0.this.mo6687j();
                        return;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException unused8) {
                        C1364l0.this.m5371g();
                        new C1439u.C1440a().mo6801a("InterruptedException in ADCVideoView's update thread.").mo6803a(C1439u.f4516i);
                    }
                } else {
                    return;
                }
            }
            if (C1364l0.this.f4323w) {
                C1364l0.this.mo6687j();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.l0$i */
    class C1373i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f4335a;

        C1373i(Context context) {
            this.f4335a = context;
        }

        public void run() {
            C1374j unused = C1364l0.this.f4295N = new C1374j(this.f4335a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (C1364l0.this.f4303c * 4.0f), (int) (C1364l0.this.f4303c * 4.0f));
            layoutParams.setMargins(0, C1364l0.this.f4291J.mo6406b() - ((int) (C1364l0.this.f4303c * 4.0f)), 0, 0);
            layoutParams.gravity = 0;
            C1364l0.this.f4291J.addView(C1364l0.this.f4295N, layoutParams);
        }
    }

    /* renamed from: com.adcolony.sdk.l0$j */
    private class C1374j extends View {
        C1374j(Context context) {
            super(context);
            setWillNotDraw(false);
            try {
                Class<?> cls = getClass();
                cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
            } catch (Exception unused) {
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(C1364l0.this.f4294M, 270.0f, C1364l0.this.f4304d, false, C1364l0.this.f4309i);
            float centerX = C1364l0.this.f4294M.centerX();
            double centerY = (double) C1364l0.this.f4294M.centerY();
            double d = (double) C1364l0.this.f4310j.getFontMetrics().bottom;
            Double.isNaN(d);
            Double.isNaN(centerY);
            canvas.drawText("" + C1364l0.this.f4307g, centerX, (float) (centerY + (d * 1.35d)), C1364l0.this.f4310j);
            invalidate();
        }
    }

    private C1364l0(Context context) {
        super(context);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f4322v = true;
        this.f4319s = this.f4320t;
        C1437s.m5602b(this.f4298Q, "id", this.f4315o);
        C1437s.m5602b(this.f4298Q, "container_id", this.f4291J.mo6410c());
        C1437s.m5592a(this.f4298Q, "ad_session_id", this.f4288G);
        C1437s.m5590a(this.f4298Q, "elapsed", this.f4319s);
        C1437s.m5590a(this.f4298Q, "duration", this.f4320t);
        new C1454x("VideoView.on_progress", this.f4291J.mo6428k(), this.f4298Q).mo6834d();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        m5371g();
        C1439u.C1440a aVar = new C1439u.C1440a();
        aVar.mo6801a("MediaPlayer error: " + i + "," + i2).mo6803a(C1439u.f4516i);
        return true;
    }

    public void onMeasure(int i, int i2) {
        m5377l();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f4326z = true;
        if (this.f4286E) {
            this.f4291J.removeView(this.f4296O);
        }
        if (this.f4283B) {
            this.f4316p = mediaPlayer.getVideoWidth();
            this.f4317q = mediaPlayer.getVideoHeight();
            m5377l();
            new C1439u.C1440a().mo6801a("MediaPlayer getVideoWidth = ").mo6799a(mediaPlayer.getVideoWidth()).mo6803a(C1439u.f4513f);
            new C1439u.C1440a().mo6801a("MediaPlayer getVideoHeight = ").mo6799a(mediaPlayer.getVideoHeight()).mo6803a(C1439u.f4513f);
        }
        JSONObject b = C1437s.m5599b();
        C1437s.m5602b(b, "id", this.f4315o);
        C1437s.m5602b(b, "container_id", this.f4291J.mo6410c());
        C1437s.m5592a(b, "ad_session_id", this.f4288G);
        new C1454x("VideoView.on_ready", this.f4291J.mo6428k(), b).mo6834d();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ExecutorService executorService = this.f4299R;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.f4299R.submit(new C1371g());
            } catch (RejectedExecutionException unused) {
                m5371g();
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture == null || this.f4282A) {
            new C1439u.C1440a().mo6801a("Null texture provided by system's onSurfaceTextureAvailable or ").mo6801a("MediaPlayer has been destroyed.").mo6803a(C1439u.f4517j);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.f4292K = surface;
        try {
            this.f4297P.setSurface(surface);
        } catch (IllegalStateException unused) {
            new C1439u.C1440a().mo6801a("IllegalStateException thrown when calling MediaPlayer.setSurface()").mo6803a(C1439u.f4516i);
            m5371g();
        }
        this.f4293L = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f4293L = surfaceTexture;
        if (!this.f4282A) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f4293L = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f4293L = surfaceTexture;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        C1290h c = C1199a.m4880c();
        C1222d b = c.mo6530b();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5602b(b2, "view_id", this.f4315o);
        C1437s.m5592a(b2, "ad_session_id", this.f4288G);
        C1437s.m5602b(b2, "container_x", this.f4311k + x);
        C1437s.m5602b(b2, "container_y", this.f4312l + y);
        C1437s.m5602b(b2, "view_x", x);
        C1437s.m5602b(b2, "view_y", y);
        C1437s.m5602b(b2, "id", this.f4291J.mo6410c());
        if (action == 0) {
            new C1454x("AdContainer.on_touch_began", this.f4291J.mo6428k(), b2).mo6834d();
        } else if (action == 1) {
            if (!this.f4291J.mo6435p()) {
                c.mo6521a(b.mo6458b().get(this.f4288G));
            }
            new C1454x("AdContainer.on_touch_ended", this.f4291J.mo6428k(), b2).mo6834d();
        } else if (action == 2) {
            new C1454x("AdContainer.on_touch_moved", this.f4291J.mo6428k(), b2).mo6834d();
        } else if (action == 3) {
            new C1454x("AdContainer.on_touch_cancelled", this.f4291J.mo6428k(), b2).mo6834d();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action2)) + this.f4311k);
            C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action2)) + this.f4312l);
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action2));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action2));
            new C1454x("AdContainer.on_touch_began", this.f4291J.mo6428k(), b2).mo6834d();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action3)) + this.f4311k);
            C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action3)) + this.f4312l);
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action3));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action3));
            if (!this.f4291J.mo6435p()) {
                c.mo6521a(b.mo6458b().get(this.f4288G));
            }
            new C1454x("AdContainer.on_touch_ended", this.f4291J.mo6428k(), b2).mo6834d();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m5371g() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", this.f4288G);
        new C1454x("AdSession.on_error", this.f4291J.mo6428k(), b).mo6834d();
        this.f4322v = true;
    }

    /* renamed from: l */
    private void m5377l() {
        double d = (double) this.f4313m;
        double d2 = (double) this.f4316p;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) this.f4314n;
        double d5 = (double) this.f4317q;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d3 > d6) {
            d3 = d6;
        }
        double d7 = (double) this.f4316p;
        Double.isNaN(d7);
        int i = (int) (d7 * d3);
        double d8 = (double) this.f4317q;
        Double.isNaN(d8);
        int i2 = (int) (d8 * d3);
        new C1439u.C1440a().mo6801a("setMeasuredDimension to ").mo6799a(i).mo6801a(" by ").mo6799a(i2).mo6803a(C1439u.f4513f);
        setMeasuredDimension(i, i2);
        if (this.f4283B) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    /* renamed from: m */
    private void m5380m() {
        try {
            this.f4299R.submit(new C1372h());
        } catch (RejectedExecutionException unused) {
            m5371g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo6685h() {
        if (!this.f4326z) {
            new C1439u.C1440a().mo6801a("ADCVideoView pause() called while MediaPlayer is not prepared.").mo6803a(C1439u.f4515h);
            return false;
        } else if (!this.f4324x) {
            return false;
        } else {
            this.f4318r = this.f4297P.getCurrentPosition();
            this.f4320t = (double) this.f4297P.getDuration();
            this.f4297P.pause();
            this.f4325y = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo6686i() {
        if (!this.f4326z) {
            return false;
        }
        if (!this.f4325y && C1199a.f3339d) {
            this.f4297P.start();
            m5380m();
        } else if (!this.f4322v && C1199a.f3339d) {
            this.f4297P.start();
            this.f4325y = false;
            if (!this.f4299R.isShutdown()) {
                m5380m();
            }
            C1374j jVar = this.f4295N;
            if (jVar != null) {
                jVar.invalidate();
            }
        }
        setWillNotDraw(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6687j() {
        new C1439u.C1440a().mo6801a("MediaPlayer stopped and released.").mo6803a(C1439u.f4513f);
        try {
            if (!this.f4322v && this.f4326z && this.f4297P.isPlaying()) {
                this.f4297P.stop();
            }
        } catch (IllegalStateException unused) {
            new C1439u.C1440a().mo6801a("Caught IllegalStateException when calling stop on MediaPlayer").mo6803a(C1439u.f4515h);
        }
        ProgressBar progressBar = this.f4296O;
        if (progressBar != null) {
            this.f4291J.removeView(progressBar);
        }
        this.f4322v = true;
        this.f4326z = false;
        this.f4297P.release();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo6688k() {
        this.f4323w = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6682d() {
        Context b;
        JSONObject b2 = this.f4290I.mo6830b();
        this.f4288G = C1437s.m5613h(b2, "ad_session_id");
        this.f4311k = C1437s.m5611f(b2, "x");
        this.f4312l = C1437s.m5611f(b2, "y");
        this.f4313m = C1437s.m5611f(b2, "width");
        this.f4314n = C1437s.m5611f(b2, "height");
        this.f4284C = C1437s.m5608d(b2, "enable_timer");
        this.f4286E = C1437s.m5608d(b2, "enable_progress");
        this.f4287F = C1437s.m5613h(b2, "filepath");
        this.f4316p = C1437s.m5611f(b2, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_WIDTH);
        this.f4317q = C1437s.m5611f(b2, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_HEIGHT);
        this.f4306f = C1199a.m4880c().mo6542h().mo6630n();
        new C1439u.C1440a().mo6801a("Original video dimensions = ").mo6799a(this.f4316p).mo6801a("x").mo6799a(this.f4317q).mo6803a(C1439u.f4511d);
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f4313m, this.f4314n);
        layoutParams.setMargins(this.f4311k, this.f4312l, 0, 0);
        layoutParams.gravity = 0;
        this.f4291J.addView(this, layoutParams);
        if (this.f4286E && (b = C1199a.m4878b()) != null) {
            ProgressBar progressBar = new ProgressBar(b);
            this.f4296O = progressBar;
            C1205c cVar = this.f4291J;
            int i = (int) (this.f4306f * 100.0f);
            cVar.addView(progressBar, new FrameLayout.LayoutParams(i, i, 17));
        }
        this.f4297P = new MediaPlayer();
        this.f4326z = false;
        try {
            if (!this.f4287F.startsWith("http")) {
                FileInputStream fileInputStream = new FileInputStream(this.f4287F);
                this.f4289H = fileInputStream;
                this.f4297P.setDataSource(fileInputStream.getFD());
            } else {
                this.f4283B = true;
                this.f4297P.setDataSource(this.f4287F);
            }
            this.f4297P.setOnErrorListener(this);
            this.f4297P.setOnPreparedListener(this);
            this.f4297P.setOnCompletionListener(this);
            this.f4297P.prepareAsync();
        } catch (IOException e) {
            new C1439u.C1440a().mo6801a("Failed to create/prepare MediaPlayer: ").mo6801a(e.toString()).mo6803a(C1439u.f4516i);
            m5371g();
        }
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.play", (C1458z) new C1365a(), true));
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.set_bounds", (C1458z) new C1366b(), true));
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.set_visible", (C1458z) new C1367c(), true));
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.pause", (C1458z) new C1368d(), true));
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.seek_to_time", (C1458z) new C1369e(), true));
        this.f4291J.mo6424i().add(C1199a.m4873a("VideoView.set_volume", (C1458z) new C1370f(), true));
        this.f4291J.mo6426j().add("VideoView.play");
        this.f4291J.mo6426j().add("VideoView.set_bounds");
        this.f4291J.mo6426j().add("VideoView.set_visible");
        this.f4291J.mo6426j().add("VideoView.pause");
        this.f4291J.mo6426j().add("VideoView.seek_to_time");
        this.f4291J.mo6426j().add("VideoView.set_volume");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6683e() {
        if (this.f4308h) {
            this.f4305e = (float) (360.0d / this.f4320t);
            this.f4310j.setColor(-3355444);
            this.f4310j.setShadowLayer((float) ((int) (this.f4306f * 2.0f)), 0.0f, 0.0f, -16777216);
            this.f4310j.setTextAlign(Paint.Align.CENTER);
            this.f4310j.setLinearText(true);
            this.f4310j.setTextSize(this.f4306f * 12.0f);
            this.f4309i.setStyle(Paint.Style.STROKE);
            float f = this.f4306f * 2.0f;
            if (f > 6.0f) {
                f = 6.0f;
            }
            if (f < 4.0f) {
                f = 4.0f;
            }
            this.f4309i.setStrokeWidth(f);
            this.f4309i.setShadowLayer((float) ((int) (this.f4306f * 3.0f)), 0.0f, 0.0f, -16777216);
            this.f4309i.setColor(-3355444);
            Rect rect = new Rect();
            this.f4310j.getTextBounds("0123456789", 0, 9, rect);
            this.f4303c = (float) rect.height();
            Context b = C1199a.m4878b();
            if (b != null) {
                C1359k0.m5309a((Runnable) new C1373i(b));
            }
            this.f4308h = false;
        }
        this.f4307g = (int) (this.f4320t - this.f4319s);
        float f2 = this.f4303c;
        float f3 = (float) ((int) f2);
        this.f4301a = f3;
        float f4 = (float) ((int) (3.0f * f2));
        this.f4302b = f4;
        float f5 = f2 / 2.0f;
        float f6 = f2 * 2.0f;
        this.f4294M.set(f3 - f5, f4 - f6, f3 + f6, f4 + f5);
        double d = (double) this.f4305e;
        Double.isNaN(d);
        this.f4304d = (float) (d * (this.f4320t - this.f4319s));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6684f() {
        return this.f4322v;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5361c(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4311k = C1437s.m5611f(b, "x");
        this.f4312l = C1437s.m5611f(b, "y");
        this.f4313m = C1437s.m5611f(b, "width");
        this.f4314n = C1437s.m5611f(b, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f4311k, this.f4312l, 0, 0);
        layoutParams.width = this.f4313m;
        layoutParams.height = this.f4314n;
        setLayoutParams(layoutParams);
        if (this.f4284C && this.f4295N != null) {
            int i = (int) (this.f4303c * 4.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.setMargins(0, this.f4291J.mo6406b() - ((int) (this.f4303c * 4.0f)), 0, 0);
            layoutParams2.gravity = 0;
            this.f4295N.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m5358b(C1454x xVar) {
        if (!this.f4326z) {
            return false;
        }
        if (this.f4322v) {
            this.f4322v = false;
        }
        this.f4300S = xVar;
        int f = C1437s.m5611f(xVar.mo6830b(), "time");
        int duration = this.f4297P.getDuration() / 1000;
        this.f4297P.setOnSeekCompleteListener(this);
        this.f4297P.seekTo(f * 1000);
        if (duration == f) {
            this.f4322v = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6679a() {
        if (this.f4293L != null) {
            this.f4282A = true;
        }
        this.f4299R.shutdown();
    }

    C1364l0(Context context, C1454x xVar, int i, C1205c cVar) {
        super(context);
        this.f4291J = cVar;
        this.f4290I = xVar;
        this.f4315o = i;
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5353a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "id") == this.f4315o && C1437s.m5611f(b, "container_id") == this.f4291J.mo6410c() && C1437s.m5613h(b, "ad_session_id").equals(this.f4291J.mo6400a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public MediaPlayer mo6680b() {
        return this.f4297P;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6681c() {
        return this.f4297P != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m5368e(C1454x xVar) {
        boolean z = false;
        if (!this.f4326z) {
            return false;
        }
        float e = (float) C1437s.m5609e(xVar.mo6830b(), "volume");
        AdColonyInterstitial d = C1199a.m4880c().mo6536d();
        if (d != null) {
            if (((double) e) <= 0.0d) {
                z = true;
            }
            d.mo6326b(z);
        }
        this.f4297P.setVolume(e, e);
        JSONObject b = C1437s.m5599b();
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
        xVar.mo6829a(b).mo6834d();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5363d(C1454x xVar) {
        C1374j jVar;
        C1374j jVar2;
        if (C1437s.m5608d(xVar.mo6830b(), TJAdUnitConstants.String.VISIBLE)) {
            setVisibility(0);
            if (this.f4284C && (jVar2 = this.f4295N) != null) {
                jVar2.setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(4);
        if (this.f4284C && (jVar = this.f4295N) != null) {
            jVar.setVisibility(4);
        }
    }
}
