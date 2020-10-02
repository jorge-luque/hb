package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

public class Cocos2dxGLSurfaceView extends GLSurfaceView {
    private static final int HANDLER_CLOSE_IME_KEYBOARD = 3;
    private static final int HANDLER_OPEN_IME_KEYBOARD = 2;
    private static final String TAG = Cocos2dxGLSurfaceView.class.getSimpleName();
    /* access modifiers changed from: private */
    public static Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
    /* access modifiers changed from: private */
    public static Cocos2dxTextInputWrapper sCocos2dxTextInputWraper;
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public Cocos2dxEditBox mCocos2dxEditText;
    /* access modifiers changed from: private */
    public Cocos2dxRenderer mCocos2dxRenderer;
    private boolean mMultipleTouchEnabled = true;
    private boolean mSoftKeyboardShown = false;

    public Cocos2dxGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    public static void closeIMEKeyboard() {
        Message message = new Message();
        message.what = 3;
        sHandler.sendMessage(message);
    }

    private static void dumpMotionEvent(MotionEvent motionEvent) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int action = motionEvent.getAction();
        int i2 = action & 255;
        sb.append("event ACTION_");
        sb.append(new String[]{"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"}[i2]);
        if (i2 == 5 || i2 == 6) {
            sb.append("(pid ");
            sb.append(action >> 8);
            sb.append(")");
        }
        sb.append("[");
        while (i < motionEvent.getPointerCount()) {
            sb.append("#");
            sb.append(i);
            sb.append("(pid ");
            sb.append(motionEvent.getPointerId(i));
            sb.append(")=");
            sb.append((int) motionEvent.getX(i));
            sb.append(",");
            sb.append((int) motionEvent.getY(i));
            i++;
            if (i < motionEvent.getPointerCount()) {
                sb.append(";");
            }
        }
        sb.append("]");
        sb.toString();
    }

    private String getContentText() {
        return this.mCocos2dxRenderer.getContentText();
    }

    public static Cocos2dxGLSurfaceView getInstance() {
        return mCocos2dxGLSurfaceView;
    }

    public static void openIMEKeyboard() {
        Message message = new Message();
        message.what = 2;
        message.obj = mCocos2dxGLSurfaceView.getContentText();
        sHandler.sendMessage(message);
    }

    public static void queueAccelerometer(float f, float f2, float f3, long j) {
        final float f4 = f;
        final float f5 = f2;
        final float f6 = f3;
        final long j2 = j;
        mCocos2dxGLSurfaceView.queueEvent(new Runnable() {
            public void run() {
                Cocos2dxAccelerometer.onSensorChanged(f4, f5, f6, j2);
            }
        });
    }

    public void deleteBackward() {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleDeleteBackward();
            }
        });
    }

    public Cocos2dxEditBox getCocos2dxEditText() {
        return this.mCocos2dxEditText;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        setEGLContextClientVersion(2);
        setFocusableInTouchMode(true);
        mCocos2dxGLSurfaceView = this;
        sCocos2dxTextInputWraper = new Cocos2dxTextInputWrapper(this);
        sHandler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 2) {
                    if (i == 3 && Cocos2dxGLSurfaceView.this.mCocos2dxEditText != null) {
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.removeTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                        ((InputMethodManager) Cocos2dxGLSurfaceView.mCocos2dxGLSurfaceView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(Cocos2dxGLSurfaceView.this.mCocos2dxEditText.getWindowToken(), 0);
                        Cocos2dxGLSurfaceView.this.requestFocus();
                        ((Cocos2dxActivity) Cocos2dxGLSurfaceView.mCocos2dxGLSurfaceView.getContext()).hideVirtualButton();
                    }
                } else if (Cocos2dxGLSurfaceView.this.mCocos2dxEditText != null && Cocos2dxGLSurfaceView.this.mCocos2dxEditText.requestFocus()) {
                    Cocos2dxGLSurfaceView.this.mCocos2dxEditText.removeTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                    Cocos2dxGLSurfaceView.this.mCocos2dxEditText.setText("");
                    String str = (String) message.obj;
                    Cocos2dxGLSurfaceView.this.mCocos2dxEditText.append(str);
                    Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper.setOriginText(str);
                    Cocos2dxGLSurfaceView.this.mCocos2dxEditText.addTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                    ((InputMethodManager) Cocos2dxGLSurfaceView.mCocos2dxGLSurfaceView.getContext().getSystemService("input_method")).showSoftInput(Cocos2dxGLSurfaceView.this.mCocos2dxEditText, 0);
                }
            }
        };
    }

    public void insertText(final String str) {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleInsertText(str);
            }
        });
    }

    public boolean isMultipleTouchEnabled() {
        return this.mMultipleTouchEnabled;
    }

    public boolean isSoftKeyboardShown() {
        return this.mSoftKeyboardShown;
    }

    public boolean onKeyDown(final int i, KeyEvent keyEvent) {
        if (i == 4) {
            Cocos2dxVideoHelper.mVideoHandler.sendEmptyMessage(1000);
        } else if (!(i == 66 || i == 82 || i == 85)) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    break;
                default:
                    return super.onKeyDown(i, keyEvent);
            }
        }
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleKeyDown(i);
            }
        });
        return true;
    }

    public boolean onKeyUp(final int i, KeyEvent keyEvent) {
        if (!(i == 4 || i == 66 || i == 82 || i == 85)) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    break;
                default:
                    return super.onKeyUp(i, keyEvent);
            }
        }
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleKeyUp(i);
            }
        });
        return true;
    }

    public void onPause() {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnPause();
            }
        });
        setRenderMode(0);
    }

    public void onResume() {
        super.onResume();
        setRenderMode(1);
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnResume();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!isInEditMode()) {
            this.mCocos2dxRenderer.setScreenWidthAndHeight(Math.max(i, i2), Math.min(i, i2));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        final int[] iArr = new int[pointerCount];
        final float[] fArr = new float[pointerCount];
        final float[] fArr2 = new float[pointerCount];
        if (this.mSoftKeyboardShown) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(((Activity) getContext()).getCurrentFocus().getWindowToken(), 0);
            requestFocus();
            this.mSoftKeyboardShown = false;
        }
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            fArr[i] = motionEvent.getX(i);
            fArr2[i] = motionEvent.getY(i);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            final int pointerId = motionEvent.getPointerId(0);
            final float f = fArr[0];
            final float f2 = fArr2[0];
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(pointerId, f, f2);
                }
            });
        } else if (action == 1) {
            final int pointerId2 = motionEvent.getPointerId(0);
            final float f3 = fArr[0];
            final float f4 = fArr2[0];
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(pointerId2, f3, f4);
                }
            });
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int action2 = motionEvent.getAction() >> 8;
                    if (this.mMultipleTouchEnabled || action2 == 0) {
                        final int pointerId3 = motionEvent.getPointerId(action2);
                        final float x = motionEvent.getX(action2);
                        final float y = motionEvent.getY(action2);
                        queueEvent(new Runnable() {
                            public void run() {
                                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(pointerId3, x, y);
                            }
                        });
                    }
                } else if (action == 6) {
                    int action3 = motionEvent.getAction() >> 8;
                    if (this.mMultipleTouchEnabled || action3 == 0) {
                        final int pointerId4 = motionEvent.getPointerId(action3);
                        final float x2 = motionEvent.getX(action3);
                        final float y2 = motionEvent.getY(action3);
                        queueEvent(new Runnable() {
                            public void run() {
                                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(pointerId4, x2, y2);
                            }
                        });
                    }
                }
            } else if (!this.mMultipleTouchEnabled) {
                int i2 = 0;
                while (true) {
                    if (i2 >= pointerCount) {
                        break;
                    } else if (iArr[i2] == 0) {
                        final int[] iArr2 = {0};
                        final float[] fArr3 = {fArr[i2]};
                        final float[] fArr4 = {fArr2[i2]};
                        queueEvent(new Runnable() {
                            public void run() {
                                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionCancel(iArr2, fArr3, fArr4);
                            }
                        });
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionCancel(iArr, fArr, fArr2);
                    }
                });
            }
        } else if (!this.mMultipleTouchEnabled) {
            int i3 = 0;
            while (true) {
                if (i3 >= pointerCount) {
                    break;
                } else if (iArr[i3] == 0) {
                    final int[] iArr3 = {0};
                    final float[] fArr5 = {fArr[i3]};
                    final float[] fArr6 = {fArr2[i3]};
                    queueEvent(new Runnable() {
                        public void run() {
                            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionMove(iArr3, fArr5, fArr6);
                        }
                    });
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionMove(iArr, fArr, fArr2);
                }
            });
        }
        return true;
    }

    public void setCocos2dxEditText(Cocos2dxEditBox cocos2dxEditBox) {
        Cocos2dxTextInputWrapper cocos2dxTextInputWrapper;
        this.mCocos2dxEditText = cocos2dxEditBox;
        if (cocos2dxEditBox != null && (cocos2dxTextInputWrapper = sCocos2dxTextInputWraper) != null) {
            cocos2dxEditBox.setOnEditorActionListener(cocos2dxTextInputWrapper);
            requestFocus();
        }
    }

    public void setCocos2dxRenderer(Cocos2dxRenderer cocos2dxRenderer) {
        this.mCocos2dxRenderer = cocos2dxRenderer;
        setRenderer(cocos2dxRenderer);
    }

    public void setMultipleTouchEnabled(boolean z) {
        this.mMultipleTouchEnabled = z;
    }

    public void setSoftKeyboardShown(boolean z) {
        this.mSoftKeyboardShown = z;
    }

    public Cocos2dxGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
