package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class AppLovinVideoViewV2 extends SurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: A */
    private final MediaPlayer.OnInfoListener f4731A = new MediaPlayer.OnInfoListener() {
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (AppLovinVideoViewV2.this.f4751q == null) {
                return true;
            }
            AppLovinVideoViewV2.this.f4751q.onInfo(mediaPlayer, i, i2);
            return true;
        }
    };

    /* renamed from: B */
    private final MediaPlayer.OnErrorListener f4732B = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C1977q a = AppLovinVideoViewV2.this.f4735a;
            a.mo8742b("AppLovinVideoView", "Media player error: " + i + ", " + i2);
            int unused = AppLovinVideoViewV2.this.f4738d = -1;
            int unused2 = AppLovinVideoViewV2.this.f4739e = -1;
            if (AppLovinVideoViewV2.this.f4750p == null || AppLovinVideoViewV2.this.f4750p.onError(AppLovinVideoViewV2.this.f4741g, i, i2)) {
            }
            return true;
        }
    };

    /* renamed from: C */
    private final MediaPlayer.OnBufferingUpdateListener f4733C = new MediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            C1977q a = AppLovinVideoViewV2.this.f4735a;
            a.mo8742b("AppLovinVideoView", "Buffered: " + i + "%");
            int unused = AppLovinVideoViewV2.this.f4749o = i;
        }
    };

    /* renamed from: D */
    private final MediaPlayer.OnSeekCompleteListener f4734D = new MediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            AppLovinVideoViewV2.this.f4735a.mo8742b("AppLovinVideoView", "Seek finished");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1977q f4735a;

    /* renamed from: b */
    private final C1827g.C1832d f4736b;

    /* renamed from: c */
    private Uri f4737c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4738d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f4739e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceHolder f4740f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaPlayer f4741g = null;

    /* renamed from: h */
    private int f4742h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f4743i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f4744j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f4745k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f4746l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MediaPlayer.OnCompletionListener f4747m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public MediaPlayer.OnPreparedListener f4748n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f4749o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public MediaPlayer.OnErrorListener f4750p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public MediaPlayer.OnInfoListener f4751q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f4752r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f4753s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f4754t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f4755u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public AudioManager f4756v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f4757w = 1;

    /* renamed from: x */
    private final MediaPlayer.OnVideoSizeChangedListener f4758x = new MediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int unused = AppLovinVideoViewV2.this.f4743i = mediaPlayer.getVideoWidth();
            int unused2 = AppLovinVideoViewV2.this.f4744j = mediaPlayer.getVideoHeight();
            if (AppLovinVideoViewV2.this.f4743i != 0 && AppLovinVideoViewV2.this.f4744j != 0) {
                AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f4743i, AppLovinVideoViewV2.this.f4744j);
                AppLovinVideoViewV2.this.requestLayout();
            }
        }
    };

    /* renamed from: y */
    private final MediaPlayer.OnPreparedListener f4759y = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            int unused = AppLovinVideoViewV2.this.f4738d = 2;
            AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
            boolean unused2 = appLovinVideoViewV2.f4753s = appLovinVideoViewV2.f4754t = appLovinVideoViewV2.f4755u = true;
            if (AppLovinVideoViewV2.this.f4748n != null) {
                AppLovinVideoViewV2.this.f4748n.onPrepared(AppLovinVideoViewV2.this.f4741g);
            }
            int unused3 = AppLovinVideoViewV2.this.f4743i = mediaPlayer.getVideoWidth();
            int unused4 = AppLovinVideoViewV2.this.f4744j = mediaPlayer.getVideoHeight();
            int g = AppLovinVideoViewV2.this.f4752r;
            if (g != 0) {
                AppLovinVideoViewV2.this.seekTo(g);
            }
            if (AppLovinVideoViewV2.this.f4743i != 0 && AppLovinVideoViewV2.this.f4744j != 0) {
                AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f4743i, AppLovinVideoViewV2.this.f4744j);
                if (!(AppLovinVideoViewV2.this.f4745k == AppLovinVideoViewV2.this.f4743i && AppLovinVideoViewV2.this.f4746l == AppLovinVideoViewV2.this.f4744j && AppLovinVideoViewV2.this.f4739e == 3)) {
                    return;
                }
            } else if (AppLovinVideoViewV2.this.f4739e != 3) {
                return;
            }
            AppLovinVideoViewV2.this.start();
        }
    };

    /* renamed from: z */
    private final MediaPlayer.OnCompletionListener f4760z = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            int unused = AppLovinVideoViewV2.this.f4738d = 5;
            int unused2 = AppLovinVideoViewV2.this.f4739e = 5;
            if (AppLovinVideoViewV2.this.f4747m != null) {
                AppLovinVideoViewV2.this.f4747m.onCompletion(AppLovinVideoViewV2.this.f4741g);
            }
            if (AppLovinVideoViewV2.this.f4757w != 0) {
                AppLovinVideoViewV2.this.f4756v.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        }
    };

    public AppLovinVideoViewV2(C1827g.C1832d dVar, Context context, C1941j jVar) {
        super(context);
        this.f4736b = dVar;
        this.f4735a = jVar.mo8602v();
        this.f4756v = (AudioManager) context.getSystemService("audio");
        getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                C1977q a = AppLovinVideoViewV2.this.f4735a;
                a.mo8742b("AppLovinVideoView", "Surface changed with format: " + i + ", width: " + i2 + ", height: " + i3);
                int unused = AppLovinVideoViewV2.this.f4745k = i2;
                int unused2 = AppLovinVideoViewV2.this.f4746l = i3;
                boolean z = false;
                boolean z2 = AppLovinVideoViewV2.this.f4739e == 3 || AppLovinVideoViewV2.this.f4739e == 4;
                if (AppLovinVideoViewV2.this.f4743i == i2 && AppLovinVideoViewV2.this.f4744j == i3) {
                    z = true;
                }
                if (AppLovinVideoViewV2.this.f4741g != null && z2 && z) {
                    if (AppLovinVideoViewV2.this.f4752r != 0) {
                        AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
                        appLovinVideoViewV2.seekTo(appLovinVideoViewV2.f4752r);
                    }
                    AppLovinVideoViewV2.this.start();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f4735a.mo8742b("AppLovinVideoView", "Surface created");
                SurfaceHolder unused = AppLovinVideoViewV2.this.f4740f = surfaceHolder;
                if (AppLovinVideoViewV2.this.f4741g != null) {
                    AppLovinVideoViewV2.this.f4741g.setSurface(surfaceHolder.getSurface());
                } else {
                    AppLovinVideoViewV2.this.m5851a();
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f4735a.mo8742b("AppLovinVideoView", "Surface destroyed");
                SurfaceHolder unused = AppLovinVideoViewV2.this.f4740f = null;
            }
        });
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4738d = 0;
        this.f4739e = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5851a() {
        this.f4735a.mo8742b("AppLovinVideoView", "Opening video");
        if (this.f4737c != null && this.f4740f != null) {
            if (this.f4741g != null) {
                this.f4735a.mo8742b("AppLovinVideoView", "Using existing MediaPlayer");
                this.f4741g.start();
                return;
            }
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f4741g = mediaPlayer;
                if (this.f4742h != 0) {
                    mediaPlayer.setAudioSessionId(this.f4742h);
                } else {
                    this.f4742h = mediaPlayer.getAudioSessionId();
                }
                this.f4741g.setOnPreparedListener(this.f4759y);
                this.f4741g.setOnVideoSizeChangedListener(this.f4758x);
                this.f4741g.setOnCompletionListener(this.f4760z);
                this.f4741g.setOnErrorListener(this.f4732B);
                this.f4741g.setOnInfoListener(this.f4731A);
                this.f4741g.setOnBufferingUpdateListener(this.f4733C);
                this.f4741g.setOnSeekCompleteListener(this.f4734D);
                this.f4749o = 0;
                this.f4741g.setDataSource(getContext(), this.f4737c, (Map) null);
                this.f4741g.setDisplay(this.f4740f);
                this.f4741g.setScreenOnWhilePlaying(true);
                this.f4741g.prepareAsync();
                this.f4738d = 1;
            } catch (Throwable th) {
                C1977q.m7747c("AppLovinVideoView", "Unable to open video: " + this.f4737c, th);
                this.f4738d = -1;
                this.f4739e = -1;
                this.f4732B.onError(this.f4741g, 1, 0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f4738d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5855b() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.f4741g
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.f4738d
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
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinVideoViewV2.m5855b():boolean");
    }

    public boolean canPause() {
        return this.f4753s;
    }

    public boolean canSeekBackward() {
        return this.f4754t;
    }

    public boolean canSeekForward() {
        return this.f4755u;
    }

    public int getAudioSessionId() {
        if (this.f4742h == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f4742h = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f4742h;
    }

    public int getBufferPercentage() {
        if (this.f4741g != null) {
            return this.f4749o;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (m5855b()) {
            return this.f4741g.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (m5855b()) {
            return this.f4741g.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        return m5855b() && this.f4741g.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = SurfaceView.getDefaultSize(this.f4743i, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.f4744j, i2);
        if (this.f4743i > 0 && this.f4744j > 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            boolean z = true;
            boolean z2 = this.f4743i * defaultSize2 < this.f4744j * defaultSize;
            if (this.f4743i * defaultSize2 <= this.f4744j * defaultSize) {
                z = false;
            }
            C1827g.C1832d dVar = this.f4736b;
            if (dVar == C1827g.C1832d.RESIZE_ASPECT) {
                if (z2) {
                    defaultSize = (this.f4743i * size2) / this.f4744j;
                    defaultSize2 = size2;
                } else {
                    if (z) {
                        defaultSize2 = (this.f4744j * size) / this.f4743i;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (dVar == C1827g.C1832d.RESIZE_ASPECT_FILL) {
                if (z2) {
                    defaultSize2 = (int) (((float) this.f4744j) * (((float) size) / ((float) this.f4743i)));
                } else {
                    if (z) {
                        defaultSize = (int) (((float) this.f4743i) * (((float) size2) / ((float) this.f4744j)));
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void pause() {
        this.f4735a.mo8742b("AppLovinVideoView", "Pausing video");
        if (m5855b() && this.f4741g.isPlaying()) {
            this.f4741g.pause();
        }
        this.f4739e = 4;
    }

    public void resume() {
        this.f4735a.mo8742b("AppLovinVideoView", "Resuming video");
        m5851a();
    }

    public void seekAndStart(long j) {
        C1977q qVar = this.f4735a;
        qVar.mo8742b("AppLovinVideoView", "Seeking and starting to " + j + "ms...");
        MediaPlayer mediaPlayer = this.f4741g;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo((int) j);
        } else {
            this.f4735a.mo8746e("AppLovinVideoView", "Media player unavailable");
        }
    }

    public void seekTo(int i) {
        C1977q qVar = this.f4735a;
        qVar.mo8742b("AppLovinVideoView", "Seeking to " + i + "ms");
        if (m5855b()) {
            this.f4741g.seekTo(i);
            i = 0;
        } else {
            this.f4735a.mo8742b("AppLovinVideoView", "Seek delayed");
        }
        this.f4752r = i;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f4747m = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f4750p = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f4751q = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f4748n = onPreparedListener;
    }

    public void setVideoURI(Uri uri) {
        C1977q qVar = this.f4735a;
        qVar.mo8742b("AppLovinVideoView", "Setting video uri: " + uri);
        this.f4737c = uri;
        this.f4752r = 0;
        m5851a();
        requestLayout();
        invalidate();
    }

    public void start() {
        this.f4735a.mo8742b("AppLovinVideoView", "Starting video");
        if (m5855b()) {
            this.f4741g.start();
        }
        this.f4739e = 3;
    }

    public void stopPlayback() {
        this.f4735a.mo8742b("AppLovinVideoView", "Stopping playback");
        MediaPlayer mediaPlayer = this.f4741g;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f4741g.release();
            this.f4741g = null;
            this.f4738d = 0;
            this.f4739e = 0;
            this.f4756v.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }
}
