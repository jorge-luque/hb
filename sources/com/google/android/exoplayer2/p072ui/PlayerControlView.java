package com.google.android.exoplayer2.p072ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C3033a;
import com.google.android.exoplayer2.C3034b;
import com.google.android.exoplayer2.C3035c;
import com.google.android.exoplayer2.C3037e;
import com.google.android.exoplayer2.C3039g;
import com.google.android.exoplayer2.C3040h;
import com.google.android.exoplayer2.C3042i;
import com.google.android.exoplayer2.p072ui.C3066c;
import com.google.android.exoplayer2.util.C3070b;
import com.google.android.exoplayer2.util.C3071c;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.ui.PlayerControlView */
public class PlayerControlView extends FrameLayout {

    /* renamed from: A */
    private boolean f8506A;

    /* renamed from: B */
    private boolean f8507B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f8508C;

    /* renamed from: D */
    private int f8509D;

    /* renamed from: E */
    private int f8510E;

    /* renamed from: F */
    private int f8511F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f8512G;

    /* renamed from: H */
    private boolean f8513H;

    /* renamed from: I */
    private long f8514I;

    /* renamed from: J */
    private long[] f8515J;

    /* renamed from: K */
    private boolean[] f8516K;

    /* renamed from: L */
    private long[] f8517L;

    /* renamed from: M */
    private boolean[] f8518M;

    /* renamed from: N */
    private final Runnable f8519N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public final Runnable f8520O;

    /* renamed from: a */
    private final C3059c f8521a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f8522b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f8523c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f8524d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final View f8525e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final View f8526f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final View f8527g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ImageView f8528h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final View f8529i;

    /* renamed from: j */
    private final TextView f8530j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final TextView f8531k;

    /* renamed from: l */
    private final C3066c f8532l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final StringBuilder f8533m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Formatter f8534n;

    /* renamed from: o */
    private final C3042i.C3044b f8535o;

    /* renamed from: p */
    private final C3042i.C3045c f8536p;

    /* renamed from: q */
    private final Drawable f8537q;

    /* renamed from: r */
    private final Drawable f8538r;

    /* renamed from: s */
    private final Drawable f8539s;

    /* renamed from: t */
    private final String f8540t;

    /* renamed from: u */
    private final String f8541u;

    /* renamed from: v */
    private final String f8542v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C3040h f8543w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C3034b f8544x;

    /* renamed from: y */
    private C3060d f8545y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C3039g f8546z;

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$a */
    class C3057a implements Runnable {
        C3057a() {
        }

        public void run() {
            PlayerControlView.this.m10054o();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$b */
    class C3058b implements Runnable {
        C3058b() {
        }

        public void run() {
            PlayerControlView.this.mo13070b();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$c */
    private final class C3059c extends C3040h.C3041a implements C3066c.C3067a, View.OnClickListener {
        private C3059c() {
        }

        /* renamed from: a */
        public void mo13078a(C3066c cVar, long j) {
            if (PlayerControlView.this.f8531k != null) {
                PlayerControlView.this.f8531k.setText(C3071c.m10126a(PlayerControlView.this.f8533m, PlayerControlView.this.f8534n, j));
            }
        }

        /* renamed from: b */
        public void mo13080b(C3066c cVar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.removeCallbacks(playerControlView.f8520O);
            boolean unused = PlayerControlView.this.f8508C = true;
        }

        public void onClick(View view) {
            if (PlayerControlView.this.f8543w != null) {
                if (PlayerControlView.this.f8523c == view) {
                    PlayerControlView.this.m10039h();
                } else if (PlayerControlView.this.f8522b == view) {
                    PlayerControlView.this.m10042i();
                } else if (PlayerControlView.this.f8526f == view) {
                    PlayerControlView.this.m10033e();
                } else if (PlayerControlView.this.f8527g == view) {
                    PlayerControlView.this.m10046k();
                } else if (PlayerControlView.this.f8524d == view) {
                    if (PlayerControlView.this.f8543w.getPlaybackState() == 1) {
                        if (PlayerControlView.this.f8546z != null) {
                            PlayerControlView.this.f8546z.mo13030a();
                        }
                    } else if (PlayerControlView.this.f8543w.getPlaybackState() == 4) {
                        PlayerControlView.this.f8544x.mo13025a(PlayerControlView.this.f8543w, PlayerControlView.this.f8543w.mo13012c(), -9223372036854775807L);
                    }
                    PlayerControlView.this.f8544x.mo13027b(PlayerControlView.this.f8543w, true);
                } else if (PlayerControlView.this.f8525e == view) {
                    PlayerControlView.this.f8544x.mo13027b(PlayerControlView.this.f8543w, false);
                } else if (PlayerControlView.this.f8528h == view) {
                    PlayerControlView.this.f8544x.mo13024a(PlayerControlView.this.f8543w, C3070b.m10122a(PlayerControlView.this.f8543w.getRepeatMode(), PlayerControlView.this.f8512G));
                } else if (PlayerControlView.this.f8529i == view) {
                    PlayerControlView.this.f8544x.mo13026a(PlayerControlView.this.f8543w, true ^ PlayerControlView.this.f8543w.mo13022h());
                }
            }
            PlayerControlView.this.m10036f();
        }

        /* synthetic */ C3059c(PlayerControlView playerControlView, C3057a aVar) {
            this();
        }

        /* renamed from: a */
        public void mo13079a(C3066c cVar, long j, boolean z) {
            boolean unused = PlayerControlView.this.f8508C = false;
            if (!z && PlayerControlView.this.f8543w != null) {
                PlayerControlView.this.m10029b(j);
            }
            PlayerControlView.this.m10036f();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$d */
    public interface C3060d {
        /* renamed from: a */
        void mo13082a(int i);
    }

    static {
        C3037e.m9965a("goog.exo.ui");
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: b */
    private static boolean m10030b(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return mo13069a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8506A = true;
        long j = this.f8514I;
        if (j != -9223372036854775807L) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                mo13070b();
            } else {
                postDelayed(this.f8520O, uptimeMillis);
            }
        } else if (mo13071c()) {
            m10036f();
        }
        m10048l();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8506A = false;
        removeCallbacks(this.f8519N);
        removeCallbacks(this.f8520O);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.f8519N = new C3057a();
        this.f8520O = new C3058b();
        int i2 = R$layout.exo_player_control_view;
        this.f8509D = 5000;
        this.f8510E = 15000;
        this.f8511F = 5000;
        this.f8512G = 0;
        this.f8514I = -9223372036854775807L;
        this.f8513H = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, 0, 0);
            try {
                this.f8509D = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_rewind_increment, this.f8509D);
                this.f8510E = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_fastforward_increment, this.f8510E);
                this.f8511F = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.f8511F);
                i2 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i2);
                this.f8512G = m10021a(obtainStyledAttributes, this.f8512G);
                this.f8513H = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.f8513H);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f8535o = new C3042i.C3044b();
        this.f8536p = new C3042i.C3045c();
        this.f8533m = new StringBuilder();
        this.f8534n = new Formatter(this.f8533m, Locale.getDefault());
        this.f8515J = new long[0];
        this.f8516K = new boolean[0];
        this.f8517L = new long[0];
        this.f8518M = new boolean[0];
        this.f8521a = new C3059c(this, (C3057a) null);
        this.f8544x = new C3035c();
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.f8530j = (TextView) findViewById(R$id.exo_duration);
        this.f8531k = (TextView) findViewById(R$id.exo_position);
        C3066c cVar = (C3066c) findViewById(R$id.exo_progress);
        this.f8532l = cVar;
        if (cVar != null) {
            cVar.mo13050a((C3066c.C3067a) this.f8521a);
        }
        View findViewById = findViewById(R$id.exo_play);
        this.f8524d = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.f8521a);
        }
        View findViewById2 = findViewById(R$id.exo_pause);
        this.f8525e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this.f8521a);
        }
        View findViewById3 = findViewById(R$id.exo_prev);
        this.f8522b = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this.f8521a);
        }
        View findViewById4 = findViewById(R$id.exo_next);
        this.f8523c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this.f8521a);
        }
        View findViewById5 = findViewById(R$id.exo_rew);
        this.f8527g = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this.f8521a);
        }
        View findViewById6 = findViewById(R$id.exo_ffwd);
        this.f8526f = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(this.f8521a);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f8528h = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.f8521a);
        }
        View findViewById7 = findViewById(R$id.exo_shuffle);
        this.f8529i = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(this.f8521a);
        }
        Resources resources = context.getResources();
        this.f8537q = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f8538r = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f8539s = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.f8540t = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f8541u = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f8542v = resources.getString(R$string.exo_controls_repeat_all_description);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10033e() {
        if (this.f8510E > 0) {
            long duration = this.f8543w.getDuration();
            long currentPosition = this.f8543w.getCurrentPosition() + ((long) this.f8510E);
            if (duration != -9223372036854775807L) {
                currentPosition = Math.min(currentPosition, duration);
            }
            m10023a(currentPosition);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10036f() {
        removeCallbacks(this.f8520O);
        if (this.f8511F > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.f8511F;
            this.f8514I = uptimeMillis + ((long) i);
            if (this.f8506A) {
                postDelayed(this.f8520O, (long) i);
                return;
            }
            return;
        }
        this.f8514I = -9223372036854775807L;
    }

    /* renamed from: g */
    private boolean m10038g() {
        C3040h hVar = this.f8543w;
        if (hVar == null || hVar.getPlaybackState() == 4 || this.f8543w.getPlaybackState() == 1 || !this.f8543w.mo13011b()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10039h() {
        C3042i f = this.f8543w.mo13015f();
        if (!f.mo13035b()) {
            int c = this.f8543w.mo13012c();
            int e = this.f8543w.mo13014e();
            if (e != -1) {
                m10022a(e, -9223372036854775807L);
            } else {
                f.mo13033a(c, this.f8536p, false);
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m10042i() {
        C3042i f = this.f8543w.mo13015f();
        if (!f.mo13035b()) {
            f.mo13032a(this.f8543w.mo13012c(), this.f8536p);
            throw null;
        }
    }

    /* renamed from: j */
    private void m10043j() {
        View view;
        View view2;
        boolean g = m10038g();
        if (!g && (view2 = this.f8524d) != null) {
            view2.requestFocus();
        } else if (g && (view = this.f8525e) != null) {
            view.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m10046k() {
        if (this.f8509D > 0) {
            m10023a(Math.max(this.f8543w.getCurrentPosition() - ((long) this.f8509D), 0));
        }
    }

    /* renamed from: l */
    private void m10048l() {
        m10052n();
        m10050m();
        m10056p();
        m10058q();
        m10054o();
    }

    /* renamed from: m */
    private void m10050m() {
        if (mo13071c() && this.f8506A) {
            C3040h hVar = this.f8543w;
            C3042i f = hVar != null ? hVar.mo13015f() : null;
            if (!(f != null && !f.mo13035b()) || this.f8543w.mo13009a()) {
                m10026a(false, this.f8522b);
                m10026a(false, this.f8523c);
                int i = this.f8510E;
                m10026a(false, this.f8526f);
                int i2 = this.f8509D;
                m10026a(false, this.f8527g);
                C3066c cVar = this.f8532l;
                if (cVar != null) {
                    cVar.setEnabled(false);
                    return;
                }
                return;
            }
            f.mo13032a(this.f8543w.mo13012c(), this.f8536p);
            throw null;
        }
    }

    /* renamed from: n */
    private void m10052n() {
        boolean z;
        if (mo13071c() && this.f8506A) {
            boolean g = m10038g();
            View view = this.f8524d;
            int i = 8;
            boolean z2 = true;
            if (view != null) {
                z = (g && view.isFocused()) | false;
                this.f8524d.setVisibility(g ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.f8525e;
            if (view2 != null) {
                if (g || !view2.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                View view3 = this.f8525e;
                if (g) {
                    i = 0;
                }
                view3.setVisibility(i);
            }
            if (z) {
                m10043j();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m10054o() {
        long j;
        long j2;
        long j3;
        if (mo13071c() && this.f8506A) {
            C3040h hVar = this.f8543w;
            long j4 = 0;
            if (hVar != null) {
                C3042i f = hVar.mo13015f();
                if (!f.mo13035b()) {
                    int c = this.f8543w.mo13012c();
                    int i = this.f8507B ? 0 : c;
                    if (i <= (this.f8507B ? f.mo13031a() - 1 : c)) {
                        f.mo13032a(i, this.f8536p);
                        throw null;
                    }
                }
                long a = C3033a.m9956a(0);
                long a2 = C3033a.m9956a(0);
                if (this.f8543w.mo13009a()) {
                    j3 = a2 + this.f8543w.mo13013d();
                    j = j3;
                } else {
                    long currentPosition = this.f8543w.getCurrentPosition() + a2;
                    long bufferedPosition = a2 + this.f8543w.getBufferedPosition();
                    j3 = currentPosition;
                    j = bufferedPosition;
                }
                if (this.f8532l != null) {
                    int length = this.f8517L.length;
                    int i2 = 0 + length;
                    long[] jArr = this.f8515J;
                    if (i2 > jArr.length) {
                        this.f8515J = Arrays.copyOf(jArr, i2);
                        this.f8516K = Arrays.copyOf(this.f8516K, i2);
                    }
                    System.arraycopy(this.f8517L, 0, this.f8515J, 0, length);
                    System.arraycopy(this.f8518M, 0, this.f8516K, 0, length);
                    this.f8532l.mo13051a(this.f8515J, this.f8516K, i2);
                }
                j2 = j3;
                j4 = a;
            } else {
                j2 = 0;
                j = 0;
            }
            TextView textView = this.f8530j;
            if (textView != null) {
                textView.setText(C3071c.m10126a(this.f8533m, this.f8534n, j4));
            }
            TextView textView2 = this.f8531k;
            if (textView2 != null && !this.f8508C) {
                textView2.setText(C3071c.m10126a(this.f8533m, this.f8534n, j2));
            }
            C3066c cVar = this.f8532l;
            if (cVar != null) {
                cVar.mo13049a(j2);
                this.f8532l.mo13053c(j);
                this.f8532l.mo13052b(j4);
            }
            removeCallbacks(this.f8519N);
            C3040h hVar2 = this.f8543w;
            int playbackState = hVar2 == null ? 1 : hVar2.getPlaybackState();
            if (playbackState != 1 && playbackState != 4) {
                long j5 = 1000;
                if (this.f8543w.mo13011b() && playbackState == 3) {
                    float f2 = this.f8543w.mo13016g().f8433a;
                    if (f2 > 0.1f) {
                        if (f2 <= 5.0f) {
                            long max = (long) (1000 / Math.max(1, Math.round(1.0f / f2)));
                            long j6 = max - (j2 % max);
                            if (j6 < max / 5) {
                                j6 += max;
                            }
                            if (f2 != 1.0f) {
                                j6 = (long) (((float) j6) / f2);
                            }
                            j5 = j6;
                        } else {
                            j5 = 200;
                        }
                    }
                }
                postDelayed(this.f8519N, j5);
            }
        }
    }

    /* renamed from: p */
    private void m10056p() {
        ImageView imageView;
        if (mo13071c() && this.f8506A && (imageView = this.f8528h) != null) {
            if (this.f8512G == 0) {
                imageView.setVisibility(8);
            } else if (this.f8543w == null) {
                m10026a(false, (View) imageView);
            } else {
                m10026a(true, (View) imageView);
                int repeatMode = this.f8543w.getRepeatMode();
                if (repeatMode == 0) {
                    this.f8528h.setImageDrawable(this.f8537q);
                    this.f8528h.setContentDescription(this.f8540t);
                } else if (repeatMode == 1) {
                    this.f8528h.setImageDrawable(this.f8538r);
                    this.f8528h.setContentDescription(this.f8541u);
                } else if (repeatMode == 2) {
                    this.f8528h.setImageDrawable(this.f8539s);
                    this.f8528h.setContentDescription(this.f8542v);
                }
                this.f8528h.setVisibility(0);
            }
        }
    }

    /* renamed from: q */
    private void m10058q() {
        View view;
        if (mo13071c() && this.f8506A && (view = this.f8529i) != null) {
            if (!this.f8513H) {
                view.setVisibility(8);
                return;
            }
            C3040h hVar = this.f8543w;
            if (hVar == null) {
                m10026a(false, view);
                return;
            }
            view.setAlpha(hVar.mo13022h() ? 1.0f : 0.3f);
            this.f8529i.setEnabled(true);
            this.f8529i.setVisibility(0);
        }
    }

    /* renamed from: b */
    public void mo13070b() {
        if (mo13071c()) {
            setVisibility(8);
            C3060d dVar = this.f8545y;
            if (dVar != null) {
                dVar.mo13082a(getVisibility());
            }
            removeCallbacks(this.f8519N);
            removeCallbacks(this.f8520O);
            this.f8514I = -9223372036854775807L;
        }
    }

    /* renamed from: c */
    public boolean mo13071c() {
        return getVisibility() == 0;
    }

    /* renamed from: d */
    public void mo13072d() {
        if (!mo13071c()) {
            setVisibility(0);
            C3060d dVar = this.f8545y;
            if (dVar != null) {
                dVar.mo13082a(getVisibility());
            }
            m10048l();
            m10043j();
        }
        m10036f();
    }

    /* renamed from: a */
    private static int m10021a(TypedArray typedArray, int i) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    /* renamed from: a */
    public int mo13067a() {
        return this.f8511F;
    }

    /* renamed from: a */
    public void mo13068a(int i) {
        this.f8511F = i;
        if (mo13071c()) {
            m10036f();
        }
    }

    /* renamed from: a */
    private void m10026a(boolean z, View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10029b(long j) {
        C3042i f = this.f8543w.mo13015f();
        if (!this.f8507B || f.mo13035b()) {
            m10022a(this.f8543w.mo13012c(), j);
            return;
        }
        f.mo13031a();
        f.mo13032a(0, this.f8536p);
        throw null;
    }

    /* renamed from: a */
    private void m10023a(long j) {
        m10022a(this.f8543w.mo13012c(), j);
    }

    /* renamed from: a */
    private void m10022a(int i, long j) {
        if (!this.f8544x.mo13025a(this.f8543w, i, j)) {
            m10054o();
        }
    }

    /* renamed from: a */
    public boolean mo13069a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f8543w == null || !m10030b(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                m10033e();
            } else if (keyCode == 89) {
                m10046k();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    C3034b bVar = this.f8544x;
                    C3040h hVar = this.f8543w;
                    bVar.mo13027b(hVar, !hVar.mo13011b());
                } else if (keyCode == 87) {
                    m10039h();
                } else if (keyCode == 88) {
                    m10042i();
                } else if (keyCode == 126) {
                    this.f8544x.mo13027b(this.f8543w, true);
                } else if (keyCode == 127) {
                    this.f8544x.mo13027b(this.f8543w, false);
                }
            }
        }
        return true;
    }
}
