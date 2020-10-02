package com.unity3d.services.p162ar.view;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.unity3d.services.ar.view.GLSurfaceView */
public class GLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference<>(this);

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$BaseConfigChooser */
    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLSurfaceView.this.mEGLContextClientVersion != 2 && GLSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GLSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$ComponentSizeChooser */
    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$DefaultContextFactory */
    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$DefaultWindowSurfaceFactory */
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Log.e(GLSurfaceView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLConfigChooser */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLContextFactory */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EGLWindowSurfaceFactory */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$EglHelper */
    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public static String formatEglError(String str, int i) {
            return "";
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceView == null) {
                return gl;
            }
            if (gLSurfaceView.mGLWrapper != null) {
                gl = gLSurfaceView.mGLWrapper.wrap(gl);
            }
            if ((gLSurfaceView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((gLSurfaceView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gLSurfaceView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    this.mEglSurface = gLSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLSurfaceView.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public void start() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                    if (gLSurfaceView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLThread */
    static class GLThread extends Thread {
        private boolean mDidDraw;
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private Runnable mFinishDrawingRunnable = null;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mRequestSwap;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        GLThread(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* JADX WARNING: type inference failed for: r0v33, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0163, code lost:
            r2 = com.unity3d.services.p162ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0167, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            com.unity3d.services.p162ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0172, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0173, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0178, code lost:
            r2 = com.unity3d.services.p162ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x017c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p162ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0189, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0191, code lost:
            if (r14 == false) goto L_0x01cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0195, code lost:
            if (r1.mDidDraw == false) goto L_0x01cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0197, code lost:
            r1.mDidDraw = false;
            r14 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01a0, code lost:
            if (r14 == 12288) goto L_0x01c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01a4, code lost:
            if (r14 == 12302) goto L_0x01c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a6, code lost:
            com.unity3d.services.p162ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r14);
            r2 = com.unity3d.services.p162ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01b1, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p162ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01bc, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01c1, code lost:
            r16 = r3;
            r0 = false;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01c6, code lost:
            r16 = r3;
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x01c9, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x01cc, code lost:
            if (r11 == false) goto L_0x01d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01ce, code lost:
            r8 = r1.mEglHelper.createGL();
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d8, code lost:
            if (r9 == false) goto L_0x01f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x01da, code lost:
            r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x01e2, code lost:
            if (r0 == null) goto L_0x01ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x01e4, code lost:
            com.unity3d.services.p162ar.view.GLSurfaceView.access$1000(r0).onSurfaceCreated(r8, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x01ef, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x01f0, code lost:
            if (r12 == false) goto L_0x0204;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x01f2, code lost:
            r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x01fa, code lost:
            if (r0 == null) goto L_0x0203;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x01fc, code lost:
            com.unity3d.services.p162ar.view.GLSurfaceView.access$1000(r0).onSurfaceChanged(r8, r15, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0203, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0204, code lost:
            r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x020c, code lost:
            if (r0 == null) goto L_0x021e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x020e, code lost:
            com.unity3d.services.p162ar.view.GLSurfaceView.access$1000(r0).onDrawFrame(r8);
            r1.mDidDraw = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0218, code lost:
            if (r7 == null) goto L_0x021e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x021a, code lost:
            r7.run();
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0221, code lost:
            if (r1.mRenderMode != 1) goto L_0x0252;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0223, code lost:
            r0 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x022b, code lost:
            if (r0 == 12288) goto L_0x024f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x022f, code lost:
            if (r0 == 12302) goto L_0x024c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0231, code lost:
            com.unity3d.services.p162ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r0);
            r2 = com.unity3d.services.p162ar.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x023c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
            r1.mSurfaceIsBad = true;
            com.unity3d.services.p162ar.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0247, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x024c, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0250, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0253, code lost:
            if (r13 == false) goto L_0x025c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0255, code lost:
            r16 = r3;
            r0 = false;
            r5 = true;
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x025c, code lost:
            r16 = r3;
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x014e, code lost:
            if (r17 == null) goto L_0x0159;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r17.run();
            r17 = r2;
            r16 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0159, code lost:
            if (r10 == false) goto L_0x018f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0161, code lost:
            if (r1.mEglHelper.createSurface() == false) goto L_0x0178;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r19 = this;
                r1 = r19
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = new com.unity3d.services.ar.view.GLSurfaceView$EglHelper
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r1.mWantRenderNotification = r0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
            L_0x0022:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r18 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027e }
                monitor-enter(r18)     // Catch:{ all -> 0x027e }
            L_0x0027:
                boolean r2 = r1.mShouldExit     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x003c
                monitor-exit(r18)     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r2)
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x0039 }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x0039 }
                monitor-exit(r2)     // Catch:{ all -> 0x0039 }
                return
            L_0x0039:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0039 }
                throw r0
            L_0x003c:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x027b }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x027b }
                if (r2 != 0) goto L_0x0053
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x027b }
                java.lang.Object r2 = r2.remove(r0)     // Catch:{ all -> 0x027b }
                r17 = r2
                java.lang.Runnable r17 = (java.lang.Runnable) r17     // Catch:{ all -> 0x027b }
                r3 = r16
                r2 = 0
                goto L_0x014d
            L_0x0053:
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x027b }
                boolean r3 = r1.mRequestPaused     // Catch:{ all -> 0x027b }
                if (r2 == r3) goto L_0x0067
                boolean r2 = r1.mRequestPaused     // Catch:{ all -> 0x027b }
                boolean r3 = r1.mRequestPaused     // Catch:{ all -> 0x027b }
                r1.mPaused = r3     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r3 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r3.notifyAll()     // Catch:{ all -> 0x027b }
                goto L_0x0068
            L_0x0067:
                r2 = 0
            L_0x0068:
                boolean r3 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x0075
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x027b }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x027b }
                r1.mShouldReleaseEglContext = r0     // Catch:{ all -> 0x027b }
                r6 = 1
            L_0x0075:
                if (r4 == 0) goto L_0x007e
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x027b }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x027b }
                r4 = 0
            L_0x007e:
                if (r2 == 0) goto L_0x0087
                boolean r3 = r1.mHaveEglSurface     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x0087
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x027b }
            L_0x0087:
                if (r2 == 0) goto L_0x00a2
                boolean r2 = r1.mHaveEglContext     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x00a2
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x027b }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView r2 = (com.unity3d.services.p162ar.view.GLSurfaceView) r2     // Catch:{ all -> 0x027b }
                if (r2 != 0) goto L_0x0099
                r2 = 0
                goto L_0x009d
            L_0x0099:
                boolean r2 = r2.mPreserveEGLContextOnPause     // Catch:{ all -> 0x027b }
            L_0x009d:
                if (r2 != 0) goto L_0x00a2
                r19.stopEglContextLocked()     // Catch:{ all -> 0x027b }
            L_0x00a2:
                boolean r2 = r1.mHasSurface     // Catch:{ all -> 0x027b }
                if (r2 != 0) goto L_0x00bd
                boolean r2 = r1.mWaitingForSurface     // Catch:{ all -> 0x027b }
                if (r2 != 0) goto L_0x00bd
                boolean r2 = r1.mHaveEglSurface     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x00b1
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x027b }
            L_0x00b1:
                r2 = 1
                r1.mWaitingForSurface = r2     // Catch:{ all -> 0x027b }
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r2.notifyAll()     // Catch:{ all -> 0x027b }
            L_0x00bd:
                boolean r2 = r1.mHasSurface     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x00ce
                boolean r2 = r1.mWaitingForSurface     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x00ce
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r2.notifyAll()     // Catch:{ all -> 0x027b }
            L_0x00ce:
                if (r5 == 0) goto L_0x00dd
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x027b }
                r2 = 1
                r1.mRenderComplete = r2     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r2.notifyAll()     // Catch:{ all -> 0x027b }
                r5 = 0
            L_0x00dd:
                java.lang.Runnable r2 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x027b }
                if (r2 == 0) goto L_0x00e7
                java.lang.Runnable r7 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x027b }
                r2 = 0
                r1.mFinishDrawingRunnable = r2     // Catch:{ all -> 0x027b }
                goto L_0x00e8
            L_0x00e7:
                r2 = 0
            L_0x00e8:
                boolean r3 = r19.readyToDraw()     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x0263
                boolean r3 = r1.mHaveEglContext     // Catch:{ all -> 0x027b }
                if (r3 != 0) goto L_0x0110
                if (r6 == 0) goto L_0x00f6
                r6 = 0
                goto L_0x0110
            L_0x00f6:
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r3 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x0107 }
                r3.start()     // Catch:{ RuntimeException -> 0x0107 }
                r3 = 1
                r1.mHaveEglContext = r3     // Catch:{ all -> 0x027b }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r3 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r3.notifyAll()     // Catch:{ all -> 0x027b }
                r9 = 1
                goto L_0x0110
            L_0x0107:
                r0 = move-exception
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x027b }
                throw r0     // Catch:{ all -> 0x027b }
            L_0x0110:
                boolean r3 = r1.mHaveEglContext     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x011e
                boolean r3 = r1.mHaveEglSurface     // Catch:{ all -> 0x027b }
                if (r3 != 0) goto L_0x011e
                r3 = 1
                r1.mHaveEglSurface = r3     // Catch:{ all -> 0x027b }
                r10 = 1
                r11 = 1
                r12 = 1
            L_0x011e:
                boolean r3 = r1.mHaveEglSurface     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x0261
                boolean r3 = r1.mSizeChanged     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x0133
                int r15 = r1.mWidth     // Catch:{ all -> 0x027b }
                int r3 = r1.mHeight     // Catch:{ all -> 0x027b }
                r10 = 1
                r1.mWantRenderNotification = r10     // Catch:{ all -> 0x027b }
                r1.mSizeChanged = r0     // Catch:{ all -> 0x027b }
                r16 = r3
                r10 = 1
                r12 = 1
            L_0x0133:
                r1.mRequestRender = r0     // Catch:{ all -> 0x027b }
                boolean r3 = r1.mRequestSwap     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x013c
                r1.mRequestSwap = r0     // Catch:{ all -> 0x027b }
                r14 = 1
            L_0x013c:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r3 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r3.notifyAll()     // Catch:{ all -> 0x027b }
                boolean r3 = r1.mWantRenderNotification     // Catch:{ all -> 0x027b }
                if (r3 == 0) goto L_0x014b
                r3 = r16
                r13 = 1
                goto L_0x014d
            L_0x014b:
                r3 = r16
            L_0x014d:
                monitor-exit(r18)     // Catch:{ all -> 0x027b }
                if (r17 == 0) goto L_0x0159
                r17.run()     // Catch:{ all -> 0x027e }
                r17 = r2
                r16 = r3
                goto L_0x0022
            L_0x0159:
                if (r10 == 0) goto L_0x018f
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x027e }
                boolean r2 = r2.createSurface()     // Catch:{ all -> 0x027e }
                if (r2 == 0) goto L_0x0178
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027e }
                monitor-enter(r2)     // Catch:{ all -> 0x027e }
                r10 = 1
                r1.mFinishedCreatingEglSurface = r10     // Catch:{ all -> 0x0175 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r10 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0175 }
                r10.notifyAll()     // Catch:{ all -> 0x0175 }
                monitor-exit(r2)     // Catch:{ all -> 0x0175 }
                r10 = 0
                goto L_0x018f
            L_0x0175:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0175 }
                throw r0     // Catch:{ all -> 0x027e }
            L_0x0178:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027e }
                monitor-enter(r2)     // Catch:{ all -> 0x027e }
                r0 = 1
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x018c }
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x018c }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x018c }
                r0.notifyAll()     // Catch:{ all -> 0x018c }
                monitor-exit(r2)     // Catch:{ all -> 0x018c }
                goto L_0x025c
            L_0x018c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x018c }
                throw r0     // Catch:{ all -> 0x027e }
            L_0x018f:
                r2 = 12288(0x3000, float:1.7219E-41)
                if (r14 == 0) goto L_0x01cc
                boolean r0 = r1.mDidDraw     // Catch:{ all -> 0x027e }
                if (r0 == 0) goto L_0x01cc
                r0 = 0
                r1.mDidDraw = r0     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r14 = r1.mEglHelper     // Catch:{ all -> 0x027e }
                int r14 = r14.swap()     // Catch:{ all -> 0x027e }
                if (r14 == r2) goto L_0x01c6
                r2 = 12302(0x300e, float:1.7239E-41)
                if (r14 == r2) goto L_0x01c1
                java.lang.String r2 = "GLThread"
                java.lang.String r0 = "eglSwapBuffers"
                com.unity3d.services.p162ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning(r2, r0, r14)     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027e }
                monitor-enter(r2)     // Catch:{ all -> 0x027e }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x01be }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x01be }
                r0.notifyAll()     // Catch:{ all -> 0x01be }
                monitor-exit(r2)     // Catch:{ all -> 0x01be }
                goto L_0x01c6
            L_0x01be:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01be }
                throw r0     // Catch:{ all -> 0x027e }
            L_0x01c1:
                r16 = r3
                r0 = 0
                r4 = 1
                goto L_0x01c9
            L_0x01c6:
                r16 = r3
                r0 = 0
            L_0x01c9:
                r14 = 0
                goto L_0x0022
            L_0x01cc:
                if (r11 == 0) goto L_0x01d8
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x027e }
                javax.microedition.khronos.opengles.GL r0 = r0.createGL()     // Catch:{ all -> 0x027e }
                r8 = r0
                javax.microedition.khronos.opengles.GL10 r8 = (javax.microedition.khronos.opengles.GL10) r8     // Catch:{ all -> 0x027e }
                r11 = 0
            L_0x01d8:
                if (r9 == 0) goto L_0x01f0
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x027e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x027e }
                if (r0 == 0) goto L_0x01ef
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r9 = r1.mEglHelper     // Catch:{ all -> 0x027e }
                javax.microedition.khronos.egl.EGLConfig r9 = r9.mEglConfig     // Catch:{ all -> 0x027e }
                r0.onSurfaceCreated(r8, r9)     // Catch:{ all -> 0x027e }
            L_0x01ef:
                r9 = 0
            L_0x01f0:
                if (r12 == 0) goto L_0x0204
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x027e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x027e }
                if (r0 == 0) goto L_0x0203
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x027e }
                r0.onSurfaceChanged(r8, r15, r3)     // Catch:{ all -> 0x027e }
            L_0x0203:
                r12 = 0
            L_0x0204:
                java.lang.ref.WeakReference<com.unity3d.services.ar.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x027e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView r0 = (com.unity3d.services.p162ar.view.GLSurfaceView) r0     // Catch:{ all -> 0x027e }
                if (r0 == 0) goto L_0x021e
                com.unity3d.services.ar.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x027e }
                r0.onDrawFrame(r8)     // Catch:{ all -> 0x027e }
                r0 = 1
                r1.mDidDraw = r0     // Catch:{ all -> 0x027e }
                if (r7 == 0) goto L_0x021e
                r7.run()     // Catch:{ all -> 0x027e }
                r7 = 0
            L_0x021e:
                int r0 = r1.mRenderMode     // Catch:{ all -> 0x027e }
                r2 = 1
                if (r0 != r2) goto L_0x0252
                com.unity3d.services.ar.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x027e }
                int r0 = r0.swap()     // Catch:{ all -> 0x027e }
                r2 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r2) goto L_0x024f
                r2 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r2) goto L_0x024c
                java.lang.String r2 = "GLThread"
                java.lang.String r14 = "eglSwapBuffers"
                com.unity3d.services.p162ar.view.GLSurfaceView.EglHelper.logEglErrorAsWarning(r2, r14, r0)     // Catch:{ all -> 0x027e }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027e }
                monitor-enter(r2)     // Catch:{ all -> 0x027e }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0249 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r14 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0249 }
                r14.notifyAll()     // Catch:{ all -> 0x0249 }
                monitor-exit(r2)     // Catch:{ all -> 0x0249 }
                goto L_0x0250
            L_0x0249:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0249 }
                throw r0     // Catch:{ all -> 0x027e }
            L_0x024c:
                r0 = 1
                r4 = 1
                goto L_0x0250
            L_0x024f:
                r0 = 1
            L_0x0250:
                r14 = 0
                goto L_0x0253
            L_0x0252:
                r0 = 1
            L_0x0253:
                if (r13 == 0) goto L_0x025c
                r16 = r3
                r0 = 0
                r5 = 1
                r13 = 0
                goto L_0x0022
            L_0x025c:
                r16 = r3
                r0 = 0
                goto L_0x0022
            L_0x0261:
                r0 = 1
                goto L_0x0271
            L_0x0263:
                r0 = 1
                if (r7 == 0) goto L_0x0271
                java.lang.String r2 = "GLSurfaceView"
                java.lang.String r3 = "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished."
                android.util.Log.w(r2, r3)     // Catch:{ all -> 0x027b }
                r7.run()     // Catch:{ all -> 0x027b }
                r7 = 0
            L_0x0271:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x027b }
                r2.wait()     // Catch:{ all -> 0x027b }
                r0 = 0
                goto L_0x0027
            L_0x027b:
                r0 = move-exception
                monitor-exit(r18)     // Catch:{ all -> 0x027b }
                throw r0     // Catch:{ all -> 0x027e }
            L_0x027e:
                r0 = move-exception
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r2)
                r19.stopEglSurfaceLocked()     // Catch:{ all -> 0x028c }
                r19.stopEglContextLocked()     // Catch:{ all -> 0x028c }
                monitor-exit(r2)     // Catch:{ all -> 0x028c }
                throw r0
            L_0x028c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x028c }
                goto L_0x0290
            L_0x028f:
                throw r0
            L_0x0290:
                goto L_0x028f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.guardedRun():void");
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        public int getRenderMode() {
            int i;
            synchronized (GLSurfaceView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPause() {
            /*
                r2 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mRequestPaused = r1     // Catch:{ all -> 0x0029 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x002c:
                throw r1
            L_0x002d:
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.onPause():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResume() {
            /*
                r3 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.mRequestPaused = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.mRequestRender = r2     // Catch:{ all -> 0x0032 }
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0032 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                goto L_0x0036
            L_0x0035:
                throw r1
            L_0x0036:
                goto L_0x0035
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.onResume():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r2, int r3) {
            /*
                r1 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1.mWidth = r2     // Catch:{ all -> 0x0044 }
                r1.mHeight = r3     // Catch:{ all -> 0x0044 }
                r2 = 1
                r1.mSizeChanged = r2     // Catch:{ all -> 0x0044 }
                r1.mRequestRender = r2     // Catch:{ all -> 0x0044 }
                r2 = 0
                r1.mRenderComplete = r2     // Catch:{ all -> 0x0044 }
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                if (r2 != r1) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0019:
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0044 }
                r2.notifyAll()     // Catch:{ all -> 0x0044 }
            L_0x0020:
                boolean r2 = r1.mExited     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.mRenderComplete     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.ableToDraw()     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0042
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r2 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003a }
                r2.wait()     // Catch:{ InterruptedException -> 0x003a }
                goto L_0x0020
            L_0x003a:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                r2.interrupt()     // Catch:{ all -> 0x0044 }
                goto L_0x0020
            L_0x0042:
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0044:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                goto L_0x0048
            L_0x0047:
                throw r2
            L_0x0048:
                goto L_0x0047
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.onWindowResize(int, int):void");
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLSurfaceView.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLSurfaceView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestExitAndWait() {
            /*
                r2 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                goto L_0x0029
            L_0x0028:
                throw r1
            L_0x0029:
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestRender = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            synchronized (GLSurfaceView.sGLThreadManager) {
                if (Thread.currentThread() != this) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.mFinishDrawingRunnable = runnable;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                }
            }
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLSurfaceView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLSurfaceView.sGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRenderMode = i;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceCreated() {
            /*
                r2 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mHasSurface = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.mFinishedCreatingEglSurface = r1     // Catch:{ all -> 0x0030 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.mFinishedCreatingEglSurface     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                goto L_0x0034
            L_0x0033:
                throw r1
            L_0x0034:
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.surfaceCreated():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceDestroyed() {
            /*
                r2 = this;
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r0 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager r1 = com.unity3d.services.p162ar.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x002c:
                throw r1
            L_0x002d:
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.p162ar.view.GLSurfaceView.GLThread.surfaceDestroyed():void");
        }

        public void swapBuffers() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestSwap = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLThreadManager */
    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            notifyAll();
        }

        public synchronized void threadExiting(GLThread gLThread) {
            boolean unused = gLThread.mExited = true;
            notifyAll();
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$GLWrapper */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$LogWriter */
    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                this.mBuilder.toString();
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$Renderer */
    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* renamed from: com.unity3d.services.ar.view.GLSurfaceView$SimpleEGLConfigChooser */
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLSurfaceView(Context context) {
        super(context);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestRenderAndNotify(runnable);
        }
    }

    public void swapBuffers() {
        this.mGLThread.swapBuffers();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(z));
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser((EGLConfigChooser) new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }
}
