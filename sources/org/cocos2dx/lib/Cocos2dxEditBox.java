package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.internal.Utility;
import com.google.android.gms.drive.MetadataChangeSet;

public class Cocos2dxEditBox extends EditText {
    public static final int kEndActionNext = 1;
    public static final int kEndActionReturn = 3;
    public static final int kEndActionUnknown = 0;
    private static final int kTextHorizontalAlignmentCenter = 1;
    private static final int kTextHorizontalAlignmentLeft = 0;
    private static final int kTextHorizontalAlignmentRight = 2;
    private static final int kTextVerticalAlignmentBottom = 2;
    private static final int kTextVerticalAlignmentCenter = 1;
    private static final int kTextVerticalAlignmentTop = 0;
    private Boolean changedTextProgrammatically = false;
    int endAction = 0;
    private final int kEditBoxInputFlagInitialCapsAllCharacters = 4;
    private final int kEditBoxInputFlagInitialCapsSentence = 3;
    private final int kEditBoxInputFlagInitialCapsWord = 2;
    private final int kEditBoxInputFlagLowercaseAllCharacters = 5;
    private final int kEditBoxInputFlagPassword = 0;
    private final int kEditBoxInputFlagSensitive = 1;
    private final int kEditBoxInputModeAny = 0;
    private final int kEditBoxInputModeDecimal = 5;
    private final int kEditBoxInputModeEmailAddr = 1;
    private final int kEditBoxInputModeNumeric = 2;
    private final int kEditBoxInputModePhoneNumber = 3;
    private final int kEditBoxInputModeSingleLine = 6;
    private final int kEditBoxInputModeUrl = 4;
    private final int kKeyboardReturnTypeDefault = 0;
    private final int kKeyboardReturnTypeDone = 1;
    private final int kKeyboardReturnTypeGo = 4;
    private final int kKeyboardReturnTypeNext = 5;
    private final int kKeyboardReturnTypeSearch = 3;
    private final int kKeyboardReturnTypeSend = 2;
    private int mInputFlagConstraints;
    private int mInputModeConstraints;
    private int mMaxLength;
    private float mScaleX;

    public Cocos2dxEditBox(Context context) {
        super(context);
    }

    public Boolean getChangedTextProgrammatically() {
        return this.changedTextProgrammatically;
    }

    public float getOpenGLViewScaleX() {
        return this.mScaleX;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        ((Cocos2dxActivity) getContext()).getGLSurfaceView().requestFocus();
        return true;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setChangedTextProgrammatically(Boolean bool) {
        this.changedTextProgrammatically = bool;
    }

    public void setEditBoxViewRect(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.width = i3;
        layoutParams.height = i4;
        layoutParams.gravity = 51;
        setLayoutParams(layoutParams);
    }

    public void setInputFlag(int i) {
        if (i == 0) {
            this.mInputFlagConstraints = 129;
            setTypeface(Typeface.DEFAULT);
            setTransformationMethod(new PasswordTransformationMethod());
        } else if (i == 1) {
            this.mInputFlagConstraints = 524288;
        } else if (i == 2) {
            this.mInputFlagConstraints = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else if (i == 3) {
            this.mInputFlagConstraints = 16384;
        } else if (i == 4) {
            this.mInputFlagConstraints = CodedOutputStream.DEFAULT_BUFFER_SIZE;
        } else if (i == 5) {
            this.mInputFlagConstraints = 1;
        }
        setInputType(this.mInputFlagConstraints | this.mInputModeConstraints);
    }

    public void setInputMode(int i) {
        setTextHorizontalAlignment(0);
        setTextVerticalAlignment(1);
        switch (i) {
            case 0:
                setTextVerticalAlignment(0);
                this.mInputModeConstraints = 131073;
                break;
            case 1:
                this.mInputModeConstraints = 33;
                break;
            case 2:
                this.mInputModeConstraints = 4098;
                break;
            case 3:
                this.mInputModeConstraints = 3;
                break;
            case 4:
                this.mInputModeConstraints = 17;
                break;
            case 5:
                this.mInputModeConstraints = 12290;
                break;
            case 6:
                this.mInputModeConstraints = 1;
                break;
        }
        setInputType(this.mInputModeConstraints | this.mInputFlagConstraints);
    }

    public void setMaxLength(int i) {
        this.mMaxLength = i;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mMaxLength)});
    }

    public void setMultilineEnabled(boolean z) {
        this.mInputModeConstraints |= MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES;
    }

    public void setOpenGLViewScaleX(float f) {
        this.mScaleX = f;
    }

    public void setReturnType(int i) {
        if (i == 0) {
            setImeOptions(268435457);
        } else if (i == 1) {
            setImeOptions(268435462);
        } else if (i == 2) {
            setImeOptions(268435460);
        } else if (i == 3) {
            setImeOptions(268435459);
        } else if (i == 4) {
            setImeOptions(268435458);
        } else if (i != 5) {
            setImeOptions(268435457);
        } else {
            setImeOptions(268435461);
        }
    }

    public void setTextHorizontalAlignment(int i) {
        int i2;
        int gravity = getGravity();
        if (i != 0) {
            if (i == 1) {
                i2 = (gravity & -6 & -4) | 1;
            } else if (i == 2) {
                i2 = (gravity & -4) | 5;
            }
            setGravity(i2);
        }
        i2 = (gravity & -6) | 3;
        setGravity(i2);
    }

    public void setTextVerticalAlignment(int i) {
        int i2;
        int gravity = getGravity();
        int padding = Cocos2dxEditBoxHelper.getPadding(this.mScaleX);
        if (i != 0) {
            if (i == 1) {
                setPadding(padding, 0, 0, padding / 2);
            } else if (i != 2) {
                setPadding(padding, 0, 0, padding / 2);
            } else {
                i2 = (gravity & -49) | 80;
            }
            i2 = (gravity & -49 & -81) | 16;
        } else {
            setPadding(padding, (padding * 3) / 4, 0, 0);
            i2 = (gravity & -81) | 48;
        }
        setGravity(i2);
    }
}
