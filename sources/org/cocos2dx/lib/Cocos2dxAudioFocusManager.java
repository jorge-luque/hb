package org.cocos2dx.lib;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

class Cocos2dxAudioFocusManager {
    private static final int AUDIOFOCUS_GAIN = 0;
    private static final int AUDIOFOCUS_LOST = 1;
    private static final int AUDIOFOCUS_LOST_TRANSIENT = 2;
    private static final int AUDIOFOCUS_LOST_TRANSIENT_CAN_DUCK = 3;
    private static final String TAG = "AudioFocusManager";
    private static AudioManager.OnAudioFocusChangeListener sAfChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            "onAudioFocusChange: " + i + ", thread: " + Thread.currentThread().getName();
            if (i == -1) {
                Cocos2dxHelper.runOnGLThread(new Runnable() {
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(1);
                        Cocos2dxHelper.setAudioFocus(false);
                    }
                });
            } else if (i == -2) {
                Cocos2dxHelper.runOnGLThread(new Runnable() {
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(2);
                        Cocos2dxHelper.setAudioFocus(false);
                    }
                });
            } else if (i == -3) {
                Cocos2dxHelper.runOnGLThread(new Runnable() {
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(3);
                        Cocos2dxHelper.setAudioFocus(false);
                    }
                });
            } else if (i == 1) {
                Cocos2dxHelper.runOnGLThread(new Runnable() {
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
                        Cocos2dxHelper.setAudioFocus(true);
                    }
                });
            }
        }
    };

    Cocos2dxAudioFocusManager() {
    }

    /* access modifiers changed from: private */
    public static native void nativeOnAudioFocusChange(int i);

    static boolean registerAudioFocusListener(Context context) {
        if (((AudioManager) context.getSystemService("audio")).requestAudioFocus(sAfChangeListener, 3, 1) == 1) {
            return true;
        }
        Log.e(TAG, "requestAudioFocus failed!");
        return false;
    }

    static void unregisterAudioFocusListener(Context context) {
        if (((AudioManager) context.getSystemService("audio")).abandonAudioFocus(sAfChangeListener) != 1) {
            Log.e(TAG, "abandonAudioFocus failed!");
        }
        Cocos2dxHelper.runOnGLThread(new Runnable() {
            public void run() {
                Cocos2dxHelper.setAudioFocus(true);
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
            }
        });
    }
}
