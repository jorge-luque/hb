package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2184n1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.m1 */
public class C2180m1 extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, C2184n1.C2185a {

    /* renamed from: a */
    private Uri f7354a;

    /* renamed from: b */
    private int f7355b;

    /* renamed from: c */
    private int f7356c = 0;

    /* renamed from: d */
    private int f7357d = 0;

    /* renamed from: e */
    private Surface f7358e = null;

    /* renamed from: f */
    private MediaPlayer f7359f = null;

    /* renamed from: g */
    private int f7360g;

    /* renamed from: h */
    private int f7361h;

    /* renamed from: i */
    private MediaPlayer.OnCompletionListener f7362i;

    /* renamed from: j */
    private MediaPlayer.OnPreparedListener f7363j;

    /* renamed from: k */
    private MediaPlayer.OnErrorListener f7364k;

    /* renamed from: l */
    private int f7365l;

    public C2180m1(Context context) {
        super(context);
        m8665g();
    }

    /* renamed from: f */
    private void m8664f() {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f7354a.toString());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            this.f7361h = Integer.parseInt(extractMetadata);
            this.f7360g = Integer.parseInt(extractMetadata2);
        } catch (Exception e) {
            CBLogging.m8157c("play video", "read size error", e);
        }
    }

    /* renamed from: g */
    private void m8665g() {
        this.f7360g = 0;
        this.f7361h = 0;
        setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f7356c = 0;
        this.f7357d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f7356c;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8666h() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f7359f
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f7356c
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
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2180m1.m8666h():boolean");
    }

    /* renamed from: i */
    private void m8667i() {
        if (this.f7354a != null && this.f7358e != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m8663a(false);
            m8664f();
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f7359f = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this);
                this.f7359f.setOnVideoSizeChangedListener(this);
                this.f7355b = -1;
                this.f7359f.setOnCompletionListener(this);
                this.f7359f.setOnErrorListener(this);
                this.f7359f.setOnBufferingUpdateListener(this);
                FileInputStream fileInputStream = new FileInputStream(new File(this.f7354a.toString()));
                this.f7359f.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f7359f.setSurface(this.f7358e);
                this.f7359f.setAudioStreamType(3);
                this.f7359f.setScreenOnWhilePlaying(true);
                this.f7359f.prepareAsync();
                this.f7356c = 1;
            } catch (IOException e) {
                CBLogging.m8157c("VideoTextureView", "Unable to open content: " + this.f7354a, e);
                this.f7356c = -1;
                this.f7357d = -1;
                onError(this.f7359f, 1, 0);
            } catch (IllegalArgumentException e2) {
                CBLogging.m8157c("VideoTextureView", "Unable to open content: " + this.f7354a, e2);
                this.f7356c = -1;
                this.f7357d = -1;
                onError(this.f7359f, 1, 0);
            }
        }
    }

    /* renamed from: a */
    public void mo9402a(Uri uri) {
        mo9421a(uri, (Map<String, String>) null);
    }

    /* renamed from: b */
    public int mo9404b() {
        if (m8666h()) {
            int i = this.f7355b;
            if (i > 0) {
                return i;
            }
            int duration = this.f7359f.getDuration();
            this.f7355b = duration;
            return duration;
        }
        this.f7355b = -1;
        return -1;
    }

    /* renamed from: c */
    public boolean mo9405c() {
        return m8666h() && this.f7359f.isPlaying();
    }

    /* renamed from: d */
    public int mo9406d() {
        if (m8666h()) {
            return this.f7359f.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: e */
    public void mo9407e() {
        if (m8666h() && this.f7359f.isPlaying()) {
            this.f7359f.pause();
            this.f7356c = 4;
        }
        this.f7357d = 4;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f7357d = 5;
        if (this.f7356c != 5) {
            this.f7356c = 5;
            MediaPlayer.OnCompletionListener onCompletionListener = this.f7362i;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.f7359f);
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CBLogging.m8152a("VideoTextureView", "Error: " + i + "," + i2);
        if (i == 100) {
            m8667i();
            return true;
        }
        this.f7356c = -1;
        this.f7357d = -1;
        MediaPlayer.OnErrorListener onErrorListener = this.f7364k;
        if (onErrorListener == null || onErrorListener.onError(this.f7359f, i, i2)) {
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f7356c = 2;
        this.f7360g = mediaPlayer.getVideoWidth();
        this.f7361h = mediaPlayer.getVideoHeight();
        MediaPlayer.OnPreparedListener onPreparedListener = this.f7363j;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.f7359f);
        }
        int i = this.f7365l;
        if (i != 0) {
            mo9397a(i);
        }
        if (this.f7357d == 3) {
            mo9396a();
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f7358e = new Surface(surfaceTexture);
        m8667i();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f7358e = null;
        m8663a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = this.f7357d == 3;
        if (this.f7359f != null && z) {
            int i3 = this.f7365l;
            if (i3 != 0) {
                mo9397a(i3);
            }
            mo9396a();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f7360g = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f7361h = videoHeight;
        if (this.f7360g != 0 && videoHeight != 0) {
            mo9398a(getWidth(), getHeight());
        }
    }

    /* renamed from: a */
    public void mo9398a(int i, int i2) {
        int i3;
        int i4 = this.f7360g;
        if (i4 != 0 && (i3 = this.f7361h) != 0 && i != 0 && i2 != 0) {
            float f = (float) i;
            float f2 = (float) i2;
            float min = Math.min(f / ((float) i4), f2 / ((float) i3));
            float f3 = ((float) this.f7360g) * min;
            float f4 = min * ((float) this.f7361h);
            Matrix matrix = new Matrix();
            matrix.setScale(f3 / f, f4 / f2, f / 2.0f, f2 / 2.0f);
            setTransform(matrix);
        }
    }

    /* renamed from: a */
    public void mo9421a(Uri uri, Map<String, String> map) {
        this.f7354a = uri;
        this.f7365l = 0;
        m8667i();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void mo9401a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f7363j = onPreparedListener;
    }

    /* renamed from: a */
    public void mo9399a(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f7362i = onCompletionListener;
    }

    /* renamed from: a */
    public void mo9400a(MediaPlayer.OnErrorListener onErrorListener) {
        this.f7364k = onErrorListener;
    }

    /* renamed from: a */
    private void m8663a(boolean z) {
        MediaPlayer mediaPlayer = this.f7359f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f7359f.release();
            this.f7359f = null;
            this.f7356c = 0;
            if (z) {
                this.f7357d = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo9396a() {
        if (m8666h()) {
            this.f7359f.start();
            this.f7356c = 3;
        }
        this.f7357d = 3;
    }

    /* renamed from: a */
    public void mo9397a(int i) {
        if (m8666h()) {
            this.f7359f.seekTo(i);
            this.f7365l = 0;
            return;
        }
        this.f7365l = i;
    }
}
