package org.cocos2dx.lib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import p208k.p209a.p210a.C6598a;
import p208k.p209a.p210a.C6599b;

public class Cocos2dxEngineDataManager {
    private static final String TAG = "CCEngineDataManager";
    private static boolean sIsEnabled = true;
    private static boolean sIsInited = false;
    private static C6598a sManager = new C6598a();

    private Cocos2dxEngineDataManager() {
    }

    private static C6599b.C6600a convertIntegerToGameStatus(int i) {
        for (C6599b.C6600a aVar : C6599b.C6600a.m21689a()) {
            if (i == aVar.ordinal()) {
                return aVar;
            }
        }
        return C6599b.C6600a.INVALID;
    }

    public static void destroy() {
        if (sIsEnabled) {
            sManager.destroy();
        }
    }

    public static void disable() {
        sIsEnabled = false;
    }

    public static String getVendorInfo() {
        return sIsEnabled ? sManager.mo35630a() : "";
    }

    public static boolean init(Context context, final GLSurfaceView gLSurfaceView) {
        if (context == null) {
            Log.e(TAG, "Context is null");
            return false;
        } else if (gLSurfaceView == null) {
            Log.e(TAG, "glSurfaceView is null");
            return false;
        } else {
            C67581 r2 = new C6599b.C6601b() {
                public void onChangeContinuousFrameLostConfig(final int i, final int i2) {
                    gLSurfaceView.queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxEngineDataManager.nativeOnChangeContinuousFrameLostConfig(i, i2);
                        }
                    });
                }

                public void onChangeExpectedFps(final int i) {
                    gLSurfaceView.queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxEngineDataManager.nativeOnChangeExpectedFps(i);
                        }
                    });
                }

                public void onChangeLowFpsConfig(final int i, final float f) {
                    gLSurfaceView.queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxEngineDataManager.nativeOnChangeLowFpsConfig(i, f);
                        }
                    });
                }

                public void onChangeMuteEnabled(final boolean z) {
                    gLSurfaceView.queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxEngineDataManager.nativeOnChangeMuteEnabled(z);
                        }
                    });
                }

                public void onChangeSpecialEffectLevel(final int i) {
                    gLSurfaceView.queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxEngineDataManager.nativeOnChangeSpecialEffectLevel(i);
                        }
                    });
                }

                public void onQueryFps(int[] iArr, int[] iArr2) {
                    Cocos2dxEngineDataManager.nativeOnQueryFps(iArr, iArr2);
                }
            };
            if (sIsEnabled) {
                sIsInited = sManager.mo35635a(r2);
            }
            nativeSetSupportOptimization(sIsInited);
            return sIsInited;
        }
    }

    public static boolean isInited() {
        return sIsInited;
    }

    /* access modifiers changed from: private */
    public static native void nativeOnChangeContinuousFrameLostConfig(int i, int i2);

    /* access modifiers changed from: private */
    public static native void nativeOnChangeExpectedFps(int i);

    /* access modifiers changed from: private */
    public static native void nativeOnChangeLowFpsConfig(int i, float f);

    /* access modifiers changed from: private */
    public static native void nativeOnChangeMuteEnabled(boolean z);

    /* access modifiers changed from: private */
    public static native void nativeOnChangeSpecialEffectLevel(int i);

    /* access modifiers changed from: private */
    public static native void nativeOnQueryFps(int[] iArr, int[] iArr2);

    private static native void nativeSetSupportOptimization(boolean z);

    public static void notifyContinuousFrameLost(int i, int i2, int i3) {
        if (!sIsEnabled) {
            nativeSetSupportOptimization(false);
        } else {
            sManager.mo35633a(i, i2, i3);
        }
    }

    public static void notifyFpsChanged(float f, float f2) {
        if (!sIsEnabled) {
            nativeSetSupportOptimization(false);
        } else {
            sManager.mo35631a(f, f2);
        }
    }

    public static void notifyGameStatus(int i, int i2, int i3) {
        if (!sIsEnabled) {
            nativeSetSupportOptimization(false);
            return;
        }
        C6599b.C6600a convertIntegerToGameStatus = convertIntegerToGameStatus(i);
        if (convertIntegerToGameStatus == C6599b.C6600a.INVALID) {
            Log.e(TAG, "Invalid game status: " + i);
            return;
        }
        sManager.mo35634a(convertIntegerToGameStatus, i2, i3);
    }

    public static void notifyLowFps(int i, float f, int i2) {
        if (!sIsEnabled) {
            nativeSetSupportOptimization(false);
        } else {
            sManager.mo35632a(i, f, i2);
        }
    }

    public static void pause() {
        if (sIsEnabled) {
            sManager.pause();
        }
    }

    public static void resume() {
        if (sIsEnabled) {
            sManager.resume();
        }
    }
}
