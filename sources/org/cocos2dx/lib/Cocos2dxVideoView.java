package org.cocos2dx.lib;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.IOException;
import java.util.Map;

public class Cocos2dxVideoView extends SurfaceView implements MediaController.MediaPlayerControl {
    private static final String AssetResourceRoot = "assets/";
    private static final int EVENT_COMPLETED = 3;
    private static final int EVENT_PAUSED = 1;
    private static final int EVENT_PLAYING = 0;
    private static final int EVENT_STOPPED = 2;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    /* access modifiers changed from: private */
    public String TAG = "Cocos2dxVideoView";
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            int unused = Cocos2dxVideoView.this.mCurrentBufferPercentage = i;
        }
    };
    protected Cocos2dxActivity mCocos2dxActivity = null;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            int unused = Cocos2dxVideoView.this.mCurrentState = 5;
            int unused2 = Cocos2dxVideoView.this.mTargetState = 5;
            Cocos2dxVideoView.this.release(true);
            if (Cocos2dxVideoView.this.mOnVideoEventListener != null) {
                Cocos2dxVideoView.this.mOnVideoEventListener.onVideoEvent(Cocos2dxVideoView.this.mViewTag, 3);
            }
        }
    };
    /* access modifiers changed from: private */
    public int mCurrentBufferPercentage;
    /* access modifiers changed from: private */
    public int mCurrentState = 0;
    private int mDuration;
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            int i3;
            String unused = Cocos2dxVideoView.this.TAG;
            "Error: " + i + "," + i2;
            int unused2 = Cocos2dxVideoView.this.mCurrentState = -1;
            int unused3 = Cocos2dxVideoView.this.mTargetState = -1;
            if ((Cocos2dxVideoView.this.mOnErrorListener == null || !Cocos2dxVideoView.this.mOnErrorListener.onError(Cocos2dxVideoView.this.mMediaPlayer, i, i2)) && Cocos2dxVideoView.this.getWindowToken() != null) {
                Resources resources = Cocos2dxVideoView.this.mCocos2dxActivity.getResources();
                if (i == 200) {
                    i3 = resources.getIdentifier("VideoView_error_text_invalid_progressive_playback", "string", "android");
                } else {
                    i3 = resources.getIdentifier("VideoView_error_text_unknown", "string", "android");
                }
                new AlertDialog.Builder(Cocos2dxVideoView.this.mCocos2dxActivity).setTitle(resources.getString(resources.getIdentifier("VideoView_error_title", "string", "android"))).setMessage(i3).setPositiveButton(resources.getString(resources.getIdentifier("VideoView_error_button", "string", "android")), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (Cocos2dxVideoView.this.mOnVideoEventListener != null) {
                            Cocos2dxVideoView.this.mOnVideoEventListener.onVideoEvent(Cocos2dxVideoView.this.mViewTag, 3);
                        }
                    }
                }).setCancelable(false).show();
            }
            return true;
        }
    };
    protected boolean mFullScreenEnabled = false;
    protected int mFullScreenHeight = 0;
    protected int mFullScreenWidth = 0;
    private boolean mIsAssetRouse = false;
    private boolean mKeepRatio = false;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer = null;
    private boolean mNeedResume = false;
    /* access modifiers changed from: private */
    public MediaPlayer.OnErrorListener mOnErrorListener;
    /* access modifiers changed from: private */
    public MediaPlayer.OnPreparedListener mOnPreparedListener;
    /* access modifiers changed from: private */
    public OnVideoEventListener mOnVideoEventListener;
    MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            int unused = Cocos2dxVideoView.this.mCurrentState = 2;
            if (Cocos2dxVideoView.this.mOnPreparedListener != null) {
                Cocos2dxVideoView.this.mOnPreparedListener.onPrepared(Cocos2dxVideoView.this.mMediaPlayer);
            }
            int unused2 = Cocos2dxVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            int unused3 = Cocos2dxVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            int access$500 = Cocos2dxVideoView.this.mSeekWhenPrepared;
            if (access$500 != 0) {
                Cocos2dxVideoView.this.seekTo(access$500);
            }
            if (!(Cocos2dxVideoView.this.mVideoWidth == 0 || Cocos2dxVideoView.this.mVideoHeight == 0)) {
                Cocos2dxVideoView.this.fixSize();
            }
            if (Cocos2dxVideoView.this.mTargetState == 3) {
                Cocos2dxVideoView.this.start();
            }
        }
    };
    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            boolean z = true;
            boolean z2 = Cocos2dxVideoView.this.mTargetState == 3;
            if (!(Cocos2dxVideoView.this.mVideoWidth == i2 && Cocos2dxVideoView.this.mVideoHeight == i3)) {
                z = false;
            }
            if (Cocos2dxVideoView.this.mMediaPlayer != null && z2 && z) {
                if (Cocos2dxVideoView.this.mSeekWhenPrepared != 0) {
                    Cocos2dxVideoView cocos2dxVideoView = Cocos2dxVideoView.this;
                    cocos2dxVideoView.seekTo(cocos2dxVideoView.mSeekWhenPrepared);
                }
                Cocos2dxVideoView.this.start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceHolder unused = Cocos2dxVideoView.this.mSurfaceHolder = surfaceHolder;
            Cocos2dxVideoView.this.openVideo();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SurfaceHolder unused = Cocos2dxVideoView.this.mSurfaceHolder = null;
            Cocos2dxVideoView.this.release(true);
        }
    };
    /* access modifiers changed from: private */
    public int mSeekWhenPrepared;
    protected MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int unused = Cocos2dxVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            int unused2 = Cocos2dxVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            if (Cocos2dxVideoView.this.mVideoWidth != 0 && Cocos2dxVideoView.this.mVideoHeight != 0) {
                Cocos2dxVideoView.this.getHolder().setFixedSize(Cocos2dxVideoView.this.mVideoWidth, Cocos2dxVideoView.this.mVideoHeight);
            }
        }
    };
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder = null;
    /* access modifiers changed from: private */
    public int mTargetState = 0;
    private String mVideoFilePath = null;
    /* access modifiers changed from: private */
    public int mVideoHeight = 0;
    private Uri mVideoUri;
    /* access modifiers changed from: private */
    public int mVideoWidth = 0;
    protected int mViewHeight = 0;
    protected int mViewLeft = 0;
    /* access modifiers changed from: private */
    public int mViewTag = 0;
    protected int mViewTop = 0;
    protected int mViewWidth = 0;
    protected int mVisibleHeight = 0;
    protected int mVisibleLeft = 0;
    protected int mVisibleTop = 0;
    protected int mVisibleWidth = 0;

    public interface OnVideoEventListener {
        void onVideoEvent(int i, int i2);
    }

    public Cocos2dxVideoView(Cocos2dxActivity cocos2dxActivity, int i) {
        super(cocos2dxActivity);
        this.mViewTag = i;
        this.mCocos2dxActivity = cocos2dxActivity;
        initVideoView();
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    /* access modifiers changed from: private */
    public void openVideo() {
        if (this.mSurfaceHolder != null) {
            if (this.mIsAssetRouse) {
                if (this.mVideoFilePath == null) {
                    return;
                }
            } else if (this.mVideoUri == null) {
                return;
            }
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mCocos2dxActivity.sendBroadcast(intent);
            release(false);
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mDuration = -1;
                this.mCurrentBufferPercentage = 0;
                if (this.mIsAssetRouse) {
                    AssetFileDescriptor openFd = this.mCocos2dxActivity.getAssets().openFd(this.mVideoFilePath);
                    this.mMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                } else {
                    this.mMediaPlayer.setDataSource(this.mCocos2dxActivity, this.mVideoUri);
                }
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
            } catch (IOException e) {
                String str = this.TAG;
                Log.w(str, "Unable to open content: " + this.mVideoUri, e);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e2) {
                String str2 = this.TAG;
                Log.w(str2, "Unable to open content: " + this.mVideoUri, e2);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void release(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mVideoUri = uri;
        this.mSeekWhenPrepared = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public void fixSize() {
        if (this.mFullScreenEnabled) {
            fixSize(0, 0, this.mFullScreenWidth, this.mFullScreenHeight);
        } else {
            fixSize(this.mViewLeft, this.mViewTop, this.mViewWidth, this.mViewHeight);
        }
    }

    public int getAudioSessionId() {
        return this.mMediaPlayer.getAudioSessionId();
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            int i = this.mDuration;
            if (i > 0) {
                return i;
            }
            int duration = this.mMediaPlayer.getDuration();
            this.mDuration = duration;
            return duration;
        }
        this.mDuration = -1;
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.mCurrentState;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isInPlaybackState() {
        /*
            r3 = this;
            android.media.MediaPlayer r0 = r3.mMediaPlayer
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.mCurrentState
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
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.lib.Cocos2dxVideoView.isInPlaybackState():boolean");
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(this.mViewWidth, this.mViewHeight);
            "" + this.mViewWidth + ":" + this.mViewHeight;
            return;
        }
        setMeasuredDimension(this.mVisibleWidth, this.mVisibleHeight);
        "" + this.mVisibleWidth + ":" + this.mVisibleHeight;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            if (isPlaying()) {
                pause();
            } else if (this.mCurrentState == 4) {
                resume();
            }
        }
        return true;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
            OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
            if (onVideoEventListener != null) {
                onVideoEventListener.onVideoEvent(this.mViewTag, 1);
            }
        }
        this.mTargetState = 4;
    }

    public int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode != 1073741824) {
            return i;
        }
        return size;
    }

    public void restart() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(0);
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
            this.mTargetState = 3;
        }
    }

    public void resume() {
        if (isInPlaybackState() && this.mCurrentState == 4) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
            OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
            if (onVideoEventListener != null) {
                onVideoEventListener.onVideoEvent(this.mViewTag, 0);
            }
        }
    }

    public void seekTo(int i) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = i;
    }

    public void setFullScreenEnabled(boolean z, int i, int i2) {
        if (this.mFullScreenEnabled != z) {
            this.mFullScreenEnabled = z;
            if (!(i == 0 || i2 == 0)) {
                this.mFullScreenWidth = i;
                this.mFullScreenHeight = i2;
            }
            fixSize();
        }
    }

    public void setKeepRatio(boolean z) {
        this.mKeepRatio = z;
        fixSize();
    }

    public void setOnCompletionListener(OnVideoEventListener onVideoEventListener) {
        this.mOnVideoEventListener = onVideoEventListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setVideoFileName(String str) {
        if (str.startsWith(AssetResourceRoot)) {
            str = str.substring(7);
        }
        if (str.startsWith("/")) {
            this.mIsAssetRouse = false;
            setVideoURI(Uri.parse(str), (Map<String, String>) null);
            return;
        }
        this.mVideoFilePath = str;
        this.mIsAssetRouse = true;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVideoRect(int i, int i2, int i3, int i4) {
        this.mViewLeft = i;
        this.mViewTop = i2;
        this.mViewWidth = i3;
        this.mViewHeight = i4;
        fixSize(i, i2, i3, i4);
    }

    public void setVideoURL(String str) {
        this.mIsAssetRouse = false;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVisibility(int i) {
        if (i == 4) {
            boolean isPlaying = isPlaying();
            this.mNeedResume = isPlaying;
            if (isPlaying) {
                this.mSeekWhenPrepared = getCurrentPosition();
            }
        } else if (this.mNeedResume) {
            start();
            this.mNeedResume = false;
        }
        super.setVisibility(i);
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
            OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
            if (onVideoEventListener != null) {
                onVideoEventListener.onVideoEvent(this.mViewTag, 0);
            }
        }
        this.mTargetState = 3;
    }

    public void stop() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            stopPlayback();
            OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
            if (onVideoEventListener != null) {
                onVideoEventListener.onVideoEvent(this.mViewTag, 2);
            }
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public void suspend() {
        release(false);
    }

    public void fixSize(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = this.mVideoWidth;
        if (i6 == 0 || (i5 = this.mVideoHeight) == 0) {
            this.mVisibleLeft = i;
            this.mVisibleTop = i2;
            this.mVisibleWidth = i3;
            this.mVisibleHeight = i4;
        } else if (i3 == 0 || i4 == 0) {
            this.mVisibleLeft = i;
            this.mVisibleTop = i2;
            this.mVisibleWidth = this.mVideoWidth;
            this.mVisibleHeight = this.mVideoHeight;
        } else if (this.mKeepRatio) {
            if (i6 * i4 > i3 * i5) {
                this.mVisibleWidth = i3;
                this.mVisibleHeight = (i5 * i3) / i6;
            } else if (i6 * i4 < i3 * i5) {
                this.mVisibleWidth = (i6 * i4) / i5;
                this.mVisibleHeight = i4;
            }
            this.mVisibleLeft = i + ((i3 - this.mVisibleWidth) / 2);
            this.mVisibleTop = i2 + ((i4 - this.mVisibleHeight) / 2);
        } else {
            this.mVisibleLeft = i;
            this.mVisibleTop = i2;
            this.mVisibleWidth = i3;
            this.mVisibleHeight = i4;
        }
        getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mVisibleLeft;
        layoutParams.topMargin = this.mVisibleTop;
        layoutParams.gravity = 51;
        setLayoutParams(layoutParams);
    }
}
