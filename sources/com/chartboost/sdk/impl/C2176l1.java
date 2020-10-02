package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2184n1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.l1 */
public class C2176l1 extends SurfaceView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, C2184n1.C2185a {

    /* renamed from: a */
    private Uri f7332a;

    /* renamed from: b */
    private int f7333b;

    /* renamed from: c */
    private int f7334c = 0;

    /* renamed from: d */
    private int f7335d = 0;

    /* renamed from: e */
    private SurfaceHolder f7336e = null;

    /* renamed from: f */
    private MediaPlayer f7337f = null;

    /* renamed from: g */
    private int f7338g;

    /* renamed from: h */
    private int f7339h;

    /* renamed from: i */
    private int f7340i;

    /* renamed from: j */
    private int f7341j;

    /* renamed from: k */
    private MediaPlayer.OnCompletionListener f7342k;

    /* renamed from: l */
    private MediaPlayer.OnPreparedListener f7343l;

    /* renamed from: m */
    private MediaPlayer.OnErrorListener f7344m;

    /* renamed from: n */
    private int f7345n;

    public C2176l1(Context context) {
        super(context);
        m8638f();
    }

    /* renamed from: f */
    private void m8638f() {
        this.f7338g = 0;
        this.f7339h = 0;
        getHolder().addCallback(this);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f7334c = 0;
        this.f7335d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f7334c;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8639g() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f7337f
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f7334c
            r2 = -1
            if (r0 == r2) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            if (r0 == r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2176l1.m8639g():boolean");
    }

    /* renamed from: h */
    private void m8640h() {
        if (this.f7332a != null && this.f7336e != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m8637a(false);
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f7337f = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this);
                this.f7337f.setOnVideoSizeChangedListener(this);
                this.f7333b = -1;
                this.f7337f.setOnCompletionListener(this);
                this.f7337f.setOnErrorListener(this);
                this.f7337f.setOnBufferingUpdateListener(this);
                this.f7337f.setDisplay(this.f7336e);
                this.f7337f.setAudioStreamType(3);
                this.f7337f.setScreenOnWhilePlaying(true);
                FileInputStream fileInputStream = new FileInputStream(new File(this.f7332a.toString()));
                this.f7337f.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f7337f.prepareAsync();
                this.f7334c = 1;
            } catch (IOException e) {
                CBLogging.m8157c("VideoSurfaceView", "Unable to open content: " + this.f7332a, e);
                this.f7334c = -1;
                this.f7335d = -1;
                onError(this.f7337f, 1, 0);
            } catch (IllegalArgumentException e2) {
                CBLogging.m8157c("VideoSurfaceView", "Unable to open content: " + this.f7332a, e2);
                this.f7334c = -1;
                this.f7335d = -1;
                onError(this.f7337f, 1, 0);
            }
        }
    }

    /* renamed from: a */
    public void mo9398a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo9402a(Uri uri) {
        mo9403a(uri, (Map<String, String>) null);
    }

    /* renamed from: b */
    public int mo9404b() {
        if (m8639g()) {
            int i = this.f7333b;
            if (i > 0) {
                return i;
            }
            int duration = this.f7337f.getDuration();
            this.f7333b = duration;
            return duration;
        }
        this.f7333b = -1;
        return -1;
    }

    /* renamed from: c */
    public boolean mo9405c() {
        return m8639g() && this.f7337f.isPlaying();
    }

    /* renamed from: d */
    public int mo9406d() {
        if (m8639g()) {
            return this.f7337f.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: e */
    public void mo9407e() {
        if (m8639g() && this.f7337f.isPlaying()) {
            this.f7337f.pause();
            this.f7334c = 4;
        }
        this.f7335d = 4;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f7335d = 5;
        if (this.f7334c != 5) {
            this.f7334c = 5;
            MediaPlayer.OnCompletionListener onCompletionListener = this.f7342k;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.f7337f);
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CBLogging.m8152a("VideoSurfaceView", "Error: " + i + "," + i2);
        this.f7334c = -1;
        this.f7335d = -1;
        MediaPlayer.OnErrorListener onErrorListener = this.f7344m;
        if (onErrorListener == null || onErrorListener.onError(this.f7337f, i, i2)) {
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(0, i);
        int defaultSize2 = SurfaceView.getDefaultSize(0, i2);
        int i4 = this.f7338g;
        if (i4 > 0 && (i3 = this.f7339h) > 0) {
            int min = Math.min(defaultSize2, Math.round((((float) i3) / ((float) i4)) * ((float) defaultSize)));
            defaultSize = Math.min(defaultSize, Math.round((((float) this.f7338g) / ((float) this.f7339h)) * ((float) defaultSize2)));
            defaultSize2 = min;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f7334c = 2;
        this.f7338g = mediaPlayer.getVideoWidth();
        this.f7339h = mediaPlayer.getVideoHeight();
        MediaPlayer.OnPreparedListener onPreparedListener = this.f7343l;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.f7337f);
        }
        int i = this.f7345n;
        if (i != 0) {
            mo9397a(i);
        }
        if (this.f7338g != 0 && this.f7339h != 0) {
            getHolder().setFixedSize(this.f7338g, this.f7339h);
            if (this.f7340i == this.f7338g && this.f7341j == this.f7339h && this.f7335d == 3) {
                mo9396a();
            }
        } else if (this.f7335d == 3) {
            mo9396a();
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f7338g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f7339h = videoHeight;
        if (this.f7338g != 0 && videoHeight != 0) {
            getHolder().setFixedSize(this.f7338g, this.f7339h);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f7340i = i2;
        this.f7341j = i3;
        boolean z = true;
        boolean z2 = this.f7335d == 3;
        if (!(this.f7338g == i2 && this.f7339h == i3)) {
            z = false;
        }
        if (this.f7337f != null && z2 && z) {
            int i4 = this.f7345n;
            if (i4 != 0) {
                mo9397a(i4);
            }
            mo9396a();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f7336e = surfaceHolder;
        m8640h();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f7336e = null;
        m8637a(true);
    }

    /* renamed from: a */
    public void mo9403a(Uri uri, Map<String, String> map) {
        this.f7332a = uri;
        this.f7345n = 0;
        m8640h();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void mo9401a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f7343l = onPreparedListener;
    }

    /* renamed from: a */
    public void mo9399a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f7342k = onCompletionListener;
    }

    /* renamed from: a */
    public void mo9400a(MediaPlayer.OnErrorListener onErrorListener) {
        this.f7344m = onErrorListener;
    }

    /* renamed from: a */
    private void m8637a(boolean z) {
        MediaPlayer mediaPlayer = this.f7337f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f7337f.release();
            this.f7337f = null;
            this.f7334c = 0;
            if (z) {
                this.f7335d = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo9396a() {
        if (m8639g()) {
            this.f7337f.start();
            this.f7334c = 3;
        }
        this.f7335d = 3;
    }

    /* renamed from: a */
    public void mo9397a(int i) {
        if (m8639g()) {
            this.f7337f.seekTo(i);
            this.f7345n = 0;
            return;
        }
        this.f7345n = i;
    }
}
