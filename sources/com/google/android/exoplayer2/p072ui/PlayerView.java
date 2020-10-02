package com.google.android.exoplayer2.p072ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C3040h;
import com.google.android.exoplayer2.util.C3071c;

/* renamed from: com.google.android.exoplayer2.ui.PlayerView */
public class PlayerView extends FrameLayout {

    /* renamed from: a */
    private final AspectRatioFrameLayout f8550a;

    /* renamed from: b */
    private final View f8551b;

    /* renamed from: c */
    private final View f8552c;

    /* renamed from: d */
    private final ImageView f8553d;

    /* renamed from: e */
    private final SubtitleView f8554e;

    /* renamed from: f */
    private final View f8555f;

    /* renamed from: g */
    private final TextView f8556g;

    /* renamed from: h */
    private final PlayerControlView f8557h;

    /* renamed from: i */
    private final FrameLayout f8558i;

    /* renamed from: j */
    private C3040h f8559j;

    /* renamed from: k */
    private boolean f8560k;

    /* renamed from: l */
    private Bitmap f8561l;

    /* renamed from: m */
    private boolean f8562m;

    /* renamed from: n */
    private int f8563n;

    /* renamed from: o */
    private boolean f8564o;

    /* renamed from: p */
    private boolean f8565p;

    /* renamed from: q */
    private boolean f8566q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f8567r;

    /* renamed from: com.google.android.exoplayer2.ui.PlayerView$b */
    private final class C3062b extends C3040h.C3041a implements View.OnLayoutChangeListener {
        private C3062b() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.m10081b((TextureView) view, PlayerView.this.f8567r);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (isInEditMode()) {
            this.f8550a = null;
            this.f8551b = null;
            this.f8552c = null;
            this.f8553d = null;
            this.f8554e = null;
            this.f8555f = null;
            this.f8556g = null;
            this.f8557h = null;
            this.f8558i = null;
            ImageView imageView = new ImageView(context2);
            if (C3071c.f8625a >= 23) {
                m10080b(getResources(), imageView);
            } else {
                m10075a(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i7 = R$layout.exo_player_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerView, 0, 0);
            try {
                z2 = obtainStyledAttributes.hasValue(R$styleable.PlayerView_shutter_background_color);
                i5 = obtainStyledAttributes.getColor(R$styleable.PlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i7);
                boolean z6 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                i4 = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                z = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                i3 = obtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                i2 = obtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i8 = obtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z7 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z8 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                int i9 = resourceId;
                obtainStyledAttributes.getBoolean(R$styleable.PlayerView_show_buffering, false);
                this.f8562m = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f8562m);
                boolean z9 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z3 = z8;
                i6 = i8;
                z4 = z7;
                z5 = z9;
                i7 = i9;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z5 = true;
            z4 = true;
            i6 = 5000;
            z3 = true;
            z2 = false;
            i5 = 0;
            i4 = 0;
            z = true;
            i3 = 1;
            i2 = 0;
        }
        LayoutInflater.from(context).inflate(i7, this);
        new C3062b();
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f8550a = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            m10077a(aspectRatioFrameLayout, i2);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f8551b = findViewById;
        if (findViewById != null && z2) {
            findViewById.setBackgroundColor(i5);
        }
        if (this.f8550a == null || i3 == 0) {
            this.f8552c = null;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            View textureView = i3 == 2 ? new TextureView(context2) : new SurfaceView(context2);
            this.f8552c = textureView;
            textureView.setLayoutParams(layoutParams);
            this.f8550a.addView(this.f8552c, 0);
        }
        this.f8558i = (FrameLayout) findViewById(R$id.exo_overlay);
        this.f8553d = (ImageView) findViewById(R$id.exo_artwork);
        if (i4 != 0) {
            this.f8561l = BitmapFactory.decodeResource(context.getResources(), i4);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f8554e = subtitleView;
        if (subtitleView != null) {
            subtitleView.mo13090a();
            this.f8554e.mo13094b();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f8555f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f8556g = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R$id.exo_controller);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f8557h = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.f8557h = playerControlView2;
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(this.f8557h, indexOfChild);
        } else {
            this.f8557h = null;
        }
        this.f8563n = this.f8557h != null ? i6 : 0;
        this.f8566q = z4;
        this.f8564o = z3;
        this.f8565p = z5;
        this.f8560k = z && this.f8557h != null;
        mo13083a();
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    private boolean m10079a(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* renamed from: b */
    private void m10082b(boolean z) {
        if (this.f8560k) {
            this.f8557h.mo13068a(z ? 0 : this.f8563n);
            this.f8557h.mo13072d();
        }
    }

    /* renamed from: c */
    private boolean m10084c() {
        C3040h hVar = this.f8559j;
        if (hVar == null) {
            return true;
        }
        int playbackState = hVar.getPlaybackState();
        if (!this.f8564o || (playbackState != 1 && playbackState != 4 && this.f8559j.mo13011b())) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        C3040h hVar = this.f8559j;
        if (hVar == null || !hVar.mo13009a()) {
            boolean z = m10079a(keyEvent.getKeyCode()) && this.f8560k && !this.f8557h.mo13071c();
            m10078a(true);
            if (z || mo13084a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }
        this.f8558i.requestFocus();
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8560k || this.f8559j == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.f8557h.mo13071c()) {
            m10078a(true);
        } else if (this.f8566q) {
            this.f8557h.mo13070b();
        }
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.f8560k || this.f8559j == null) {
            return false;
        }
        m10078a(true);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f8552c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo13084a(KeyEvent keyEvent) {
        return this.f8560k && this.f8557h.mo13069a(keyEvent);
    }

    /* renamed from: b */
    private boolean m10083b() {
        C3040h hVar = this.f8559j;
        return hVar != null && hVar.mo13009a() && this.f8559j.mo13011b();
    }

    /* renamed from: a */
    public void mo13083a() {
        PlayerControlView playerControlView = this.f8557h;
        if (playerControlView != null) {
            playerControlView.mo13070b();
        }
    }

    @TargetApi(23)
    /* renamed from: b */
    private static void m10080b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, (Resources.Theme) null));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, (Resources.Theme) null));
    }

    /* renamed from: a */
    private void m10078a(boolean z) {
        if ((!m10083b() || !this.f8565p) && this.f8560k) {
            boolean z2 = this.f8557h.mo13071c() && this.f8557h.mo13067a() <= 0;
            boolean c = m10084c();
            if (z || z2 || c) {
                m10082b(c);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m10081b(TextureView textureView, int i) {
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform((Matrix) null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate((float) i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    /* renamed from: a */
    private static void m10075a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    /* renamed from: a */
    private static void m10077a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.mo13044a(i);
    }
}
