package org.cocos2dx.lib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import java.io.FileInputStream;

public class Cocos2dxMusic {
    private static final String TAG = "Cocos2dxMusic";
    private MediaPlayer mBackgroundMediaPlayer;
    private final Context mContext;
    private String mCurrentPath;
    private boolean mIsAudioFocus = true;
    private boolean mIsLoop = false;
    private float mLeftVolume;
    private boolean mManualPaused = false;
    private boolean mPaused;
    private float mRightVolume;

    public Cocos2dxMusic(Context context) {
        this.mContext = context;
        initData();
    }

    private MediaPlayer createMediaPlayer(String str) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            if (str.startsWith("/")) {
                FileInputStream fileInputStream = new FileInputStream(str);
                mediaPlayer.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
            } else if (Cocos2dxHelper.getObbFile() != null) {
                AssetFileDescriptor assetFileDescriptor = Cocos2dxHelper.getObbFile().getAssetFileDescriptor(str);
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            } else {
                AssetFileDescriptor openFd = this.mContext.getAssets().openFd(str);
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            }
            mediaPlayer.prepare();
            mediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
            return mediaPlayer;
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "error: " + e.getMessage(), e);
            return null;
        }
    }

    private void initData() {
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
        this.mBackgroundMediaPlayer = null;
        this.mPaused = false;
        this.mCurrentPath = null;
    }

    public void end() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        initData();
    }

    public float getBackgroundVolume() {
        if (this.mBackgroundMediaPlayer != null) {
            return (this.mLeftVolume + this.mRightVolume) / 2.0f;
        }
        return 0.0f;
    }

    public boolean isBackgroundMusicPlaying() {
        try {
            if (this.mBackgroundMediaPlayer == null) {
                return false;
            }
            return this.mBackgroundMediaPlayer.isPlaying();
        } catch (IllegalStateException unused) {
            Log.e(TAG, "isBackgroundMusicPlaying, IllegalStateException was triggered!");
            return false;
        }
    }

    public void onEnterBackground() {
        try {
            if (this.mBackgroundMediaPlayer != null && this.mBackgroundMediaPlayer.isPlaying()) {
                this.mBackgroundMediaPlayer.pause();
                this.mPaused = true;
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "onEnterBackground, IllegalStateException was triggered!");
        }
    }

    public void onEnterForeground() {
        try {
            if (!this.mManualPaused && this.mBackgroundMediaPlayer != null && this.mPaused) {
                this.mBackgroundMediaPlayer.start();
                this.mPaused = false;
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "onEnterForeground, IllegalStateException was triggered!");
        }
    }

    public void pauseBackgroundMusic() {
        try {
            if (this.mBackgroundMediaPlayer != null && this.mBackgroundMediaPlayer.isPlaying()) {
                this.mBackgroundMediaPlayer.pause();
                this.mPaused = true;
                this.mManualPaused = true;
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "pauseBackgroundMusic, IllegalStateException was triggered!");
        }
    }

    public void playBackgroundMusic(String str, boolean z) {
        String str2 = this.mCurrentPath;
        if (str2 == null) {
            this.mBackgroundMediaPlayer = createMediaPlayer(str);
            this.mCurrentPath = str;
        } else if (!str2.equals(str)) {
            MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            this.mBackgroundMediaPlayer = createMediaPlayer(str);
            this.mCurrentPath = str;
        }
        MediaPlayer mediaPlayer2 = this.mBackgroundMediaPlayer;
        if (mediaPlayer2 == null) {
            Log.e(TAG, "playBackgroundMusic: background media player is null");
            return;
        }
        try {
            if (this.mPaused) {
                mediaPlayer2.seekTo(0);
                this.mBackgroundMediaPlayer.start();
            } else if (mediaPlayer2.isPlaying()) {
                this.mBackgroundMediaPlayer.seekTo(0);
            } else {
                this.mBackgroundMediaPlayer.start();
            }
            this.mBackgroundMediaPlayer.setLooping(z);
            this.mPaused = false;
            this.mIsLoop = z;
        } catch (Exception unused) {
            Log.e(TAG, "playBackgroundMusic: error state");
        }
    }

    public void preloadBackgroundMusic(String str) {
        String str2 = this.mCurrentPath;
        if (str2 == null || !str2.equals(str)) {
            MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            this.mBackgroundMediaPlayer = createMediaPlayer(str);
            this.mCurrentPath = str;
        }
    }

    public void resumeBackgroundMusic() {
        try {
            if (this.mBackgroundMediaPlayer != null && this.mPaused) {
                this.mBackgroundMediaPlayer.start();
                this.mPaused = false;
                this.mManualPaused = false;
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "resumeBackgroundMusic, IllegalStateException was triggered!");
        }
    }

    public void rewindBackgroundMusic() {
        if (this.mBackgroundMediaPlayer != null) {
            playBackgroundMusic(this.mCurrentPath, this.mIsLoop);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAudioFocus(boolean z) {
        this.mIsAudioFocus = z;
        if (this.mBackgroundMediaPlayer != null) {
            float f = 0.0f;
            float f2 = z ? this.mLeftVolume : 0.0f;
            if (this.mIsAudioFocus) {
                f = this.mRightVolume;
            }
            this.mBackgroundMediaPlayer.setVolume(f2, f);
        }
    }

    public void setBackgroundVolume(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.mRightVolume = f;
        this.mLeftVolume = f;
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null && this.mIsAudioFocus) {
            mediaPlayer.setVolume(f, f);
        }
    }

    public void stopBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mBackgroundMediaPlayer = createMediaPlayer(this.mCurrentPath);
            this.mPaused = false;
        }
    }

    public boolean willPlayBackgroundMusic() {
        return !((AudioManager) this.mContext.getSystemService("audio")).isMusicActive();
    }
}
