package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Cocos2dxBitmap {
    private static final int HORIZONTAL_ALIGN_CENTER = 3;
    private static final int HORIZONTAL_ALIGN_LEFT = 1;
    private static final int HORIZONTAL_ALIGN_RIGHT = 2;
    private static final int VERTICAL_ALIGN_BOTTOM = 2;
    private static final int VERTICAL_ALIGN_CENTER = 3;
    private static final int VERTICAL_ALIGN_TOP = 1;
    private static Context sContext;

    public static Typeface calculateShrinkTypeFace(String str, int i, int i2, Layout.Alignment alignment, float f, TextPaint textPaint, boolean z) {
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        TextPaint textPaint2 = textPaint;
        if (i3 == 0 || i4 == 0) {
            return textPaint.getTypeface();
        }
        float f3 = (float) (i3 + 1);
        float f4 = (float) (i4 + 1);
        float f5 = f2 + 1.0f;
        if (z) {
            while (true) {
                if (f4 <= ((float) i4) && f3 <= ((float) i3)) {
                    break;
                }
                float f6 = f5 - 1.0f;
                StaticLayout staticLayout = r0;
                StaticLayout staticLayout2 = new StaticLayout(str, textPaint, i, alignment, 1.0f, 0.0f, false);
                f3 = (float) staticLayout.getWidth();
                f4 = (float) staticLayout.getLineTop(staticLayout.getLineCount());
                textPaint2.setTextSize(f6);
                if (f6 <= 0.0f) {
                    textPaint2.setTextSize(f2);
                    break;
                }
                f5 = f6;
            }
        } else {
            while (true) {
                if (f3 <= ((float) i3) && f4 <= ((float) i4)) {
                    break;
                }
                f5 -= 1.0f;
                f3 = (float) ((int) Math.ceil((double) StaticLayout.getDesiredWidth(str2, textPaint2)));
                f4 = (float) getTextHeight(str2, (int) f3, f5, textPaint.getTypeface());
                textPaint2.setTextSize(f5);
                if (f5 <= 0.0f) {
                    textPaint2.setTextSize(f2);
                    break;
                }
            }
        }
        return textPaint.getTypeface();
    }

    public static boolean createTextBitmapShadowStroke(byte[] bArr, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, float f, float f2, float f3, float f4, boolean z2, int i9, int i10, int i11, int i12, float f5, boolean z3, int i13) {
        int i14;
        boolean z4;
        int i15;
        StaticLayout staticLayout;
        int i16;
        int i17;
        int i18;
        byte[] bArr2 = bArr;
        int i19 = i;
        int i20 = i7;
        int i21 = i13;
        if (bArr2 == null || bArr2.length == 0) {
            return false;
        }
        String str2 = new String(bArr2);
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int i22 = i6 & 15;
        if (i22 == 2) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else if (i22 == 3) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        TextPaint newPaint = newPaint(str, i);
        if (z2) {
            newPaint.setStyle(Paint.Style.STROKE);
            newPaint.setStrokeWidth(f5);
        }
        int ceil = i20 <= 0 ? (int) Math.ceil((double) StaticLayout.getDesiredWidth(str2, newPaint)) : i20;
        if (i21 != 1 || z3) {
            if (i21 == 2) {
                i14 = i22;
                calculateShrinkTypeFace(str2, i7, i8, alignment2, (float) i19, newPaint, z3);
            } else {
                i14 = i22;
            }
            i15 = 3;
            z4 = true;
            staticLayout = new StaticLayout(str2, newPaint, ceil, alignment2, 1.0f, 0.0f, false);
        } else {
            staticLayout = new StaticLayout(str2, newPaint, (int) Math.ceil((double) StaticLayout.getDesiredWidth(str2, newPaint)), alignment2, 1.0f, 0.0f, false);
            i14 = i22;
            i15 = 3;
            z4 = true;
        }
        int width = staticLayout.getWidth();
        int lineTop = staticLayout.getLineTop(staticLayout.getLineCount());
        int max = Math.max(width, i20);
        int i23 = i8 > 0 ? i8 : lineTop;
        if (i21 != z4 || z3 || i20 <= 0) {
            i20 = max;
        }
        if (i20 == 0 || i23 == 0) {
            return false;
        }
        if (i14 == i15) {
            i16 = 2;
            i17 = (i20 - width) / 2;
        } else {
            i16 = 2;
            i17 = i14 == 2 ? i20 - width : 0;
        }
        int i24 = (i6 >> 4) & 15;
        if (i24 != i16) {
            i18 = i24 != i15 ? 0 : (i23 - lineTop) / 2;
        } else {
            i18 = i23 - lineTop;
        }
        int i25 = i19 / 8;
        int i26 = i17 + i25;
        int i27 = i19 / 4;
        int i28 = i18 + i25;
        Bitmap createBitmap = Bitmap.createBitmap(i20 + i27, i23 + i27, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((float) i26, (float) i28);
        if (z2) {
            newPaint.setARGB(i12, i9, i10, i11);
            staticLayout.draw(canvas);
        }
        newPaint.setStyle(Paint.Style.FILL);
        newPaint.setARGB(i5, i2, i3, i4);
        staticLayout.draw(canvas);
        initNativeObject(createBitmap);
        return z4;
    }

    public static int getFontSizeAccordingHeight(int i) {
        TextPaint textPaint = new TextPaint();
        Rect rect = new Rect();
        textPaint.setTypeface(Typeface.DEFAULT);
        boolean z = false;
        int i2 = 1;
        while (!z) {
            textPaint.setTextSize((float) i2);
            textPaint.getTextBounds("SghMNy", 0, 6, rect);
            i2++;
            if (i - rect.height() <= 2) {
                z = true;
            }
        }
        return i2;
    }

    private static byte[] getPixels(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight() * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        bitmap.copyPixelsToBuffer(wrap);
        return bArr;
    }

    private static String getStringWithEllipsis(String str, float f, float f2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setTextSize(f2);
        return TextUtils.ellipsize(str, textPaint, f, TextUtils.TruncateAt.END).toString();
    }

    public static int getTextHeight(String str, int i, float f, Typeface typeface) {
        TextPaint textPaint = new TextPaint(129);
        textPaint.setTextSize(f);
        textPaint.setTypeface(typeface);
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int breakText = textPaint.breakText(str, i2, length, true, (float) i, (float[]) null);
            if (breakText == 0) {
                i2++;
            } else {
                i2 += breakText;
                i3++;
            }
        }
        return (int) Math.floor((double) (((float) i3) * (Math.abs(textPaint.ascent()) + Math.abs(textPaint.descent()))));
    }

    private static void initNativeObject(Bitmap bitmap) {
        byte[] pixels = getPixels(bitmap);
        if (pixels != null) {
            nativeInitBitmapDC(bitmap.getWidth(), bitmap.getHeight(), pixels);
        }
    }

    private static native void nativeInitBitmapDC(int i, int i2, byte[] bArr);

    private static TextPaint newPaint(String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i);
        textPaint.setAntiAlias(true);
        if (str.endsWith(".ttf")) {
            try {
                textPaint.setTypeface(Cocos2dxTypefaces.get(sContext, str));
            } catch (Exception unused) {
                Log.e("Cocos2dxBitmap", "error to create ttf type face: " + str);
                textPaint.setTypeface(Typeface.create(str, 0));
            }
        } else {
            textPaint.setTypeface(Typeface.create(str, 0));
        }
        return textPaint;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
