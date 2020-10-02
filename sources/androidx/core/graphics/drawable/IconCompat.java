package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: j */
    static final PorterDuff.Mode f2075j = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f2076a = -1;

    /* renamed from: b */
    Object f2077b;

    /* renamed from: c */
    public byte[] f2078c = null;

    /* renamed from: d */
    public Parcelable f2079d = null;

    /* renamed from: e */
    public int f2080e = 0;

    /* renamed from: f */
    public int f2081f = 0;

    /* renamed from: g */
    public ColorStateList f2082g = null;

    /* renamed from: h */
    PorterDuff.Mode f2083h = f2075j;

    /* renamed from: i */
    public String f2084i = null;

    public IconCompat() {
    }

    /* renamed from: a */
    public static IconCompat m2792a(Resources resources, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2080e = i;
            if (resources != null) {
                try {
                    iconCompat.f2077b = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2077b = str;
            }
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    /* renamed from: a */
    private static String m2793a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    /* renamed from: b */
    public String mo4222b() {
        if (this.f2076a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2794b((Icon) this.f2077b);
        }
        if (this.f2076a == 2) {
            return ((String) this.f2077b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    /* renamed from: c */
    public int mo4223c() {
        if (this.f2076a != -1 || Build.VERSION.SDK_INT < 23) {
            return this.f2076a;
        }
        return m2795c((Icon) this.f2077b);
    }

    /* renamed from: d */
    public void mo4224d() {
        this.f2083h = PorterDuff.Mode.valueOf(this.f2084i);
        int i = this.f2076a;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f2077b = this.f2078c;
                        return;
                    } else if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                    }
                }
                this.f2077b = new String(this.f2078c, Charset.forName("UTF-16"));
                return;
            }
            Parcelable parcelable = this.f2079d;
            if (parcelable != null) {
                this.f2077b = parcelable;
                return;
            }
            byte[] bArr = this.f2078c;
            this.f2077b = bArr;
            this.f2076a = 3;
            this.f2080e = 0;
            this.f2081f = bArr.length;
            return;
        }
        Parcelable parcelable2 = this.f2079d;
        if (parcelable2 != null) {
            this.f2077b = parcelable2;
            return;
        }
        throw new IllegalArgumentException("Invalid icon");
    }

    /* renamed from: e */
    public Icon mo4225e() {
        Icon icon;
        int i = this.f2076a;
        if (i == -1) {
            return (Icon) this.f2077b;
        }
        if (i == 1) {
            icon = Icon.createWithBitmap((Bitmap) this.f2077b);
        } else if (i == 2) {
            icon = Icon.createWithResource(mo4222b(), this.f2080e);
        } else if (i == 3) {
            icon = Icon.createWithData((byte[]) this.f2077b, this.f2080e, this.f2081f);
        } else if (i == 4) {
            icon = Icon.createWithContentUri((String) this.f2077b);
        } else if (i != 5) {
            throw new IllegalArgumentException("Unknown type");
        } else if (Build.VERSION.SDK_INT >= 26) {
            icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f2077b);
        } else {
            icon = Icon.createWithBitmap(m2791a((Bitmap) this.f2077b, false));
        }
        ColorStateList colorStateList = this.f2082g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2083h;
        if (mode != f2075j) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != 5) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f2076a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f2077b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f2076a
            java.lang.String r1 = m2793a((int) r1)
            r0.append(r1)
            int r1 = r4.f2076a
            r2 = 1
            if (r1 == r2) goto L_0x007a
            r3 = 2
            if (r1 == r3) goto L_0x0052
            r2 = 3
            if (r1 == r2) goto L_0x0039
            r2 = 4
            if (r1 == r2) goto L_0x002e
            r2 = 5
            if (r1 == r2) goto L_0x007a
            goto L_0x009a
        L_0x002e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f2077b
            r0.append(r1)
            goto L_0x009a
        L_0x0039:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f2080e
            r0.append(r1)
            int r1 = r4.f2081f
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f2081f
            r0.append(r1)
            goto L_0x009a
        L_0x0052:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.mo4222b()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.mo4220a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x009a
        L_0x007a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f2077b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f2077b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            r0.append(r1)
        L_0x009a:
            android.content.res.ColorStateList r1 = r4.f2082g
            if (r1 == 0) goto L_0x00a8
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f2082g
            r0.append(r1)
        L_0x00a8:
            android.graphics.PorterDuff$Mode r1 = r4.f2083h
            android.graphics.PorterDuff$Mode r2 = f2075j
            if (r1 == r2) goto L_0x00b8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f2083h
            r0.append(r1)
        L_0x00b8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    /* renamed from: c */
    private static int m2795c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e);
            return -1;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        }
    }

    /* renamed from: b */
    private static String m2794b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* renamed from: a */
    public int mo4220a() {
        if (this.f2076a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2790a((Icon) this.f2077b);
        }
        if (this.f2076a == 2) {
            return this.f2080e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    private IconCompat(int i) {
        this.f2076a = i;
    }

    /* renamed from: a */
    public void mo4221a(boolean z) {
        this.f2084i = this.f2083h.name();
        int i = this.f2076a;
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    this.f2078c = ((String) this.f2077b).getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i == 3) {
                    this.f2078c = (byte[]) this.f2077b;
                    return;
                } else if (i == 4) {
                    this.f2078c = this.f2077b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap) this.f2077b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f2078c = byteArrayOutputStream.toByteArray();
                return;
            }
            this.f2079d = (Parcelable) this.f2077b;
        } else if (!z) {
            this.f2079d = (Parcelable) this.f2077b;
        } else {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
    }

    /* renamed from: a */
    private static int m2790a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: a */
    static Bitmap m2791a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }
}
