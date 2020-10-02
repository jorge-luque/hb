package p118io.presage;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* renamed from: io.presage.BurratadesPouilles */
public final class BurratadesPouilles {

    /* renamed from: a */
    private ImageButton f16404a = new ImageButton(this.f16407d.getContext());

    /* renamed from: b */
    private Handler f16405b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AbbayedeCiteauxentiere f16406c;

    /* renamed from: d */
    private final ViewGroup f16407d;

    /* renamed from: e */
    private final PavedAremberg f16408e;

    /* renamed from: f */
    private final String f16409f;

    /* renamed from: io.presage.BurratadesPouilles$CamembertauCalvados */
    static final class CamembertauCalvados implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BurratadesPouilles f16410a;

        CamembertauCalvados(BurratadesPouilles burratadesPouilles) {
            this.f16410a = burratadesPouilles;
        }

        public final void onClick(View view) {
            this.f16410a.f16406c.mo34399p();
            this.f16410a.m20261e();
        }
    }

    /* renamed from: io.presage.BurratadesPouilles$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ BurratadesPouilles f16411a;

        CamembertdeNormandie(BurratadesPouilles burratadesPouilles) {
            this.f16411a = burratadesPouilles;
        }

        public final void run() {
            this.f16411a.mo34466a();
        }
    }

    public BurratadesPouilles(AbbayedeCiteauxentiere abbayedeCiteauxentiere, ViewGroup viewGroup, PavedAremberg pavedAremberg, String str) {
        this.f16406c = abbayedeCiteauxentiere;
        this.f16407d = viewGroup;
        this.f16408e = pavedAremberg;
        this.f16409f = str;
        m20260d();
    }

    @SuppressLint({"RtlHardcoded"})
    /* renamed from: d */
    private final void m20260d() {
        m20262f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        this.f16404a.setLayoutParams(layoutParams);
        this.f16404a.setOnClickListener(new CamembertauCalvados(this));
        this.f16404a.setVisibility(8);
        this.f16407d.addView(this.f16404a, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m20261e() {
        if (this.f16409f.length() > 0) {
            this.f16408e.mo34598b(this.f16409f);
        }
    }

    /* renamed from: f */
    private final void m20262f() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f16404a.setBackground((Drawable) null);
        } else {
            this.f16404a.setBackgroundResource(0);
        }
        this.f16404a.setImageResource(C6206R.C6207drawable.btn_presage_mraid_close);
    }

    /* renamed from: c */
    public final void mo34469c() {
        this.f16405b.removeCallbacksAndMessages((Object) null);
    }

    /* renamed from: a */
    public final void mo34467a(long j) {
        this.f16405b.postDelayed(new CamembertdeNormandie(this), j);
    }

    /* renamed from: b */
    public final void mo34468b() {
        this.f16405b.removeCallbacksAndMessages((Object) null);
        this.f16404a.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo34466a() {
        this.f16404a.setVisibility(0);
    }
}
