package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.impl.n1 */
public class C2184n1 extends FrameLayout {

    /* renamed from: a */
    private View f7378a;

    /* renamed from: b */
    private boolean f7379b;

    /* renamed from: com.chartboost.sdk.impl.n1$a */
    public interface C2185a {
        /* renamed from: a */
        void mo9396a();

        /* renamed from: a */
        void mo9397a(int i);

        /* renamed from: a */
        void mo9398a(int i, int i2);

        /* renamed from: a */
        void mo9399a(MediaPlayer.OnCompletionListener onCompletionListener);

        /* renamed from: a */
        void mo9400a(MediaPlayer.OnErrorListener onErrorListener);

        /* renamed from: a */
        void mo9401a(MediaPlayer.OnPreparedListener onPreparedListener);

        /* renamed from: a */
        void mo9402a(Uri uri);

        /* renamed from: b */
        int mo9404b();

        /* renamed from: c */
        boolean mo9405c();

        /* renamed from: d */
        int mo9406d();

        /* renamed from: e */
        void mo9407e();
    }

    public C2184n1(Context context) {
        super(context);
        m8690b();
    }

    /* renamed from: b */
    private void m8690b() {
        this.f7379b = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Choosing ");
        sb.append(this.f7379b ? "texture" : "surface");
        sb.append(" solution for video playback");
        CBLogging.m8156c("VideoInit", sb.toString());
        C2116i a = C2116i.m8407a();
        if (this.f7379b) {
            this.f7378a = (View) a.mo9266a(new C2180m1(getContext()));
        } else {
            this.f7378a = (View) a.mo9266a(new C2176l1(getContext()));
        }
        this.f7378a.setContentDescription("CBVideo");
        addView(this.f7378a, new FrameLayout.LayoutParams(-1, -1));
        if (!this.f7379b) {
            ((SurfaceView) this.f7378a).setZOrderMediaOverlay(true);
        }
    }

    /* renamed from: a */
    public C2185a mo9442a() {
        return (C2185a) this.f7378a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mo9442a().mo9398a(i, i2);
    }
}
