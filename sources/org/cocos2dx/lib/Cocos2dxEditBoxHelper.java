package org.cocos2dx.lib;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.drive.MetadataChangeSet;

public class Cocos2dxEditBoxHelper {
    /* access modifiers changed from: private */
    public static final String TAG = "Cocos2dxEditBoxHelper";
    /* access modifiers changed from: private */
    public static Cocos2dxActivity mCocos2dxActivity = null;
    /* access modifiers changed from: private */
    public static SparseArray<Cocos2dxEditBox> mEditBoxArray = null;
    /* access modifiers changed from: private */
    public static ResizeLayout mFrameLayout = null;
    private static float mPadding = 5.0f;
    private static int mViewTag;

    public Cocos2dxEditBoxHelper(ResizeLayout resizeLayout) {
        mFrameLayout = resizeLayout;
        mCocos2dxActivity = (Cocos2dxActivity) Cocos2dxActivity.getContext();
        mEditBoxArray = new SparseArray<>();
    }

    public static void __editBoxEditingChanged(int i, String str) {
        editBoxEditingChanged(i, str);
    }

    public static void __editBoxEditingDidBegin(int i) {
        editBoxEditingDidBegin(i);
    }

    public static void __editBoxEditingDidEnd(int i, String str, int i2) {
        editBoxEditingDidEnd(i, str, i2);
    }

    public static void closeKeyboard(final int i) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBoxHelper.closeKeyboardOnUiThread(i);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void closeKeyboardOnUiThread(int i) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.e(TAG, "closeKeyboardOnUiThread doesn't run on UI thread!");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) Cocos2dxActivity.getContext().getSystemService("input_method");
        Cocos2dxEditBox cocos2dxEditBox = mEditBoxArray.get(i);
        if (cocos2dxEditBox != null) {
            inputMethodManager.hideSoftInputFromWindow(cocos2dxEditBox.getWindowToken(), 0);
            mCocos2dxActivity.getGLSurfaceView().setSoftKeyboardShown(false);
            mCocos2dxActivity.getGLSurfaceView().requestFocus();
            mCocos2dxActivity.hideVirtualButton();
        }
    }

    public static int createEditBox(int i, int i2, int i3, int i4, float f) {
        final int i5 = mViewTag;
        final float f2 = f;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final int i9 = i4;
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                final Cocos2dxEditBox cocos2dxEditBox = new Cocos2dxEditBox(Cocos2dxEditBoxHelper.mCocos2dxActivity);
                cocos2dxEditBox.setFocusable(true);
                cocos2dxEditBox.setFocusableInTouchMode(true);
                cocos2dxEditBox.setInputFlag(5);
                cocos2dxEditBox.setInputMode(6);
                cocos2dxEditBox.setReturnType(0);
                cocos2dxEditBox.setHintTextColor(-7829368);
                cocos2dxEditBox.setVisibility(8);
                cocos2dxEditBox.setBackgroundColor(0);
                cocos2dxEditBox.setTextColor(-1);
                cocos2dxEditBox.setSingleLine();
                cocos2dxEditBox.setOpenGLViewScaleX(f2);
                cocos2dxEditBox.setPadding(Cocos2dxEditBoxHelper.getPadding(f2), 0, 0, 0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = i6;
                layoutParams.topMargin = i7;
                layoutParams.width = i8;
                layoutParams.height = i9;
                layoutParams.gravity = 51;
                Cocos2dxEditBoxHelper.mFrameLayout.addView(cocos2dxEditBox, layoutParams);
                cocos2dxEditBox.setTag(false);
                cocos2dxEditBox.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(final Editable editable) {
                        if (!cocos2dxEditBox.getChangedTextProgrammatically().booleanValue() && ((Boolean) cocos2dxEditBox.getTag()).booleanValue()) {
                            Cocos2dxEditBoxHelper.mCocos2dxActivity.runOnGLThread(new Runnable() {
                                public void run() {
                                    Cocos2dxEditBoxHelper.__editBoxEditingChanged(i5, editable.toString());
                                }
                            });
                        }
                        cocos2dxEditBox.setChangedTextProgrammatically(false);
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }
                });
                cocos2dxEditBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View view, boolean z) {
                        cocos2dxEditBox.setTag(true);
                        cocos2dxEditBox.setChangedTextProgrammatically(false);
                        if (z) {
                            Cocos2dxEditBoxHelper.mCocos2dxActivity.runOnGLThread(new Runnable() {
                                public void run() {
                                    C67382 r0 = C67382.this;
                                    cocos2dxEditBox.endAction = 0;
                                    Cocos2dxEditBoxHelper.__editBoxEditingDidBegin(i5);
                                }
                            });
                            Cocos2dxEditBox cocos2dxEditBox = cocos2dxEditBox;
                            cocos2dxEditBox.setSelection(cocos2dxEditBox.getText().length());
                            Cocos2dxEditBoxHelper.mFrameLayout.setEnableForceDoLayout(true);
                            Cocos2dxEditBoxHelper.mCocos2dxActivity.getGLSurfaceView().setSoftKeyboardShown(true);
                            String unused = Cocos2dxEditBoxHelper.TAG;
                            return;
                        }
                        cocos2dxEditBox.setVisibility(8);
                        final String str = new String(cocos2dxEditBox.getText().toString());
                        Cocos2dxEditBoxHelper.mCocos2dxActivity.runOnGLThread(new Runnable() {
                            public void run() {
                                C67382 r0 = C67382.this;
                                Cocos2dxEditBoxHelper.__editBoxEditingDidEnd(i5, str, cocos2dxEditBox.endAction);
                            }
                        });
                        Cocos2dxEditBoxHelper.mCocos2dxActivity.hideVirtualButton();
                        Cocos2dxEditBoxHelper.mFrameLayout.setEnableForceDoLayout(false);
                        String unused2 = Cocos2dxEditBoxHelper.TAG;
                    }
                });
                cocos2dxEditBox.setOnKeyListener(new View.OnKeyListener() {
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (keyEvent.getAction() != 0 || i != 66 || (cocos2dxEditBox.getInputType() & MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES) == 131072) {
                            return false;
                        }
                        Cocos2dxEditBoxHelper.closeKeyboardOnUiThread(i5);
                        return true;
                    }
                });
                cocos2dxEditBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == 5) {
                            cocos2dxEditBox.endAction = 1;
                            Cocos2dxEditBoxHelper.closeKeyboardOnUiThread(i5);
                            return true;
                        } else if (i != 6 && i != 4 && i != 3 && i != 2) {
                            return false;
                        } else {
                            cocos2dxEditBox.endAction = 3;
                            Cocos2dxEditBoxHelper.closeKeyboardOnUiThread(i5);
                            return false;
                        }
                    }
                });
                Cocos2dxEditBoxHelper.mEditBoxArray.put(i5, cocos2dxEditBox);
            }
        });
        int i10 = mViewTag;
        mViewTag = i10 + 1;
        return i10;
    }

    private static native void editBoxEditingChanged(int i, String str);

    private static native void editBoxEditingDidBegin(int i);

    private static native void editBoxEditingDidEnd(int i, String str, int i2);

    public static int getPadding(float f) {
        return (int) (mPadding * f);
    }

    public static void openKeyboard(final int i) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBoxHelper.openKeyboardOnUiThread(i);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void openKeyboardOnUiThread(int i) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.e(TAG, "openKeyboardOnUiThread doesn't run on UI thread!");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) Cocos2dxActivity.getContext().getSystemService("input_method");
        Cocos2dxEditBox cocos2dxEditBox = mEditBoxArray.get(i);
        if (cocos2dxEditBox != null) {
            cocos2dxEditBox.requestFocus();
            mCocos2dxActivity.getGLSurfaceView().requestLayout();
            inputMethodManager.showSoftInput(cocos2dxEditBox, 0);
            mCocos2dxActivity.getGLSurfaceView().setSoftKeyboardShown(true);
        }
    }

    public static void removeEditBox(final int i) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    Cocos2dxEditBoxHelper.mEditBoxArray.remove(i);
                    Cocos2dxEditBoxHelper.mFrameLayout.removeView(cocos2dxEditBox);
                    Log.e(Cocos2dxEditBoxHelper.TAG, "remove EditBox");
                }
            }
        });
    }

    public static void setEditBoxViewRect(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final int i9 = i4;
        final int i10 = i5;
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i6);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setEditBoxViewRect(i7, i8, i9, i10);
                }
            }
        });
    }

    public static void setFont(final int i, final String str, final float f) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Typeface typeface;
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    if (str.isEmpty()) {
                        typeface = Typeface.DEFAULT;
                    } else if (str.endsWith(".ttf")) {
                        try {
                            Cocos2dxActivity unused = Cocos2dxEditBoxHelper.mCocos2dxActivity;
                            typeface = Cocos2dxTypefaces.get(Cocos2dxActivity.getContext(), str);
                        } catch (Exception unused2) {
                            Log.e(Cocos2dxEditBoxHelper.TAG, "error to create ttf type face: " + str);
                            typeface = Typeface.create(str, 0);
                        }
                    } else {
                        typeface = Typeface.create(str, 0);
                    }
                    float f = f;
                    if (f >= 0.0f) {
                        cocos2dxEditBox.setTextSize(0, f);
                    }
                    cocos2dxEditBox.setTypeface(typeface);
                }
            }
        });
    }

    public static void setFontColor(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i;
        final int i7 = i5;
        final int i8 = i2;
        final int i9 = i3;
        final int i10 = i4;
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i6);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setTextColor(Color.argb(i7, i8, i9, i10));
                }
            }
        });
    }

    public static void setInputFlag(final int i, final int i2) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setInputFlag(i2);
                }
            }
        });
    }

    public static void setInputMode(final int i, final int i2) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setInputMode(i2);
                }
            }
        });
    }

    public static void setMaxLength(final int i, final int i2) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setMaxLength(i2);
                }
            }
        });
    }

    public static void setPlaceHolderText(final int i, final String str) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setHint(str);
                }
            }
        });
    }

    public static void setPlaceHolderTextColor(int i, int i2, int i3, int i4, int i5) {
        final int i6 = i;
        final int i7 = i5;
        final int i8 = i2;
        final int i9 = i3;
        final int i10 = i4;
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i6);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setHintTextColor(Color.argb(i7, i8, i9, i10));
                }
            }
        });
    }

    public static void setReturnType(final int i, final int i2) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setReturnType(i2);
                }
            }
        });
    }

    public static void setText(final int i, final String str) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setChangedTextProgrammatically(true);
                    cocos2dxEditBox.setText(str);
                    cocos2dxEditBox.setSelection(cocos2dxEditBox.getText().length());
                }
            }
        });
    }

    public static void setTextHorizontalAlignment(final int i, final int i2) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setTextHorizontalAlignment(i2);
                }
            }
        });
    }

    public static void setVisible(final int i, final boolean z) {
        mCocos2dxActivity.runOnUiThread(new Runnable() {
            public void run() {
                Cocos2dxEditBox cocos2dxEditBox = (Cocos2dxEditBox) Cocos2dxEditBoxHelper.mEditBoxArray.get(i);
                if (cocos2dxEditBox != null) {
                    cocos2dxEditBox.setVisibility(z ? 0 : 8);
                }
            }
        });
    }
}
