package com.applovin.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2029r;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {

    /* renamed from: a */
    private static final Handler f6806a = new Handler(Looper.getMainLooper());

    public static final class Size {

        /* renamed from: a */
        private int f6807a;

        /* renamed from: b */
        private int f6808b;

        private Size() {
        }

        public Size(int i, int i2) {
            this.f6807a = i;
            this.f6808b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f6807a == size.getWidth() && this.f6808b == size.getHeight();
        }

        public int getHeight() {
            return this.f6808b;
        }

        public int getWidth() {
            return this.f6807a;
        }

        public int hashCode() {
            int i = this.f6808b;
            int i2 = this.f6807a;
            return i ^ ((i2 >>> 16) | (i2 << 16));
        }

        public String toString() {
            return this.f6807a + "x" + this.f6808b;
        }
    }

    /* renamed from: a */
    private static void m8097a(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).getBitmap().recycle();
            }
        }
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static boolean isTablet(Context context) {
        Point a = C1991g.m7836a(context);
        return Math.min(a.x, a.y) >= dpToPx(context, 600);
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i) {
        return (int) Math.ceil((double) (((float) i) / context.getResources().getDisplayMetrics().density));
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z, Runnable runnable) {
        if (z || !C2029r.m8028b()) {
            f6806a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        runOnUiThreadDelayed(runnable, j, f6806a);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j, Handler handler) {
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else if (C2029r.m8028b()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int i, int i2) {
        m8097a(imageView);
        Bitmap a = C2029r.m7989a(context, i, i2);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Bitmap bitmap) {
        m8097a(imageView);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int i) {
        m8097a(imageView);
        Bitmap a = C2029r.m7990a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return C1993i.m7879a(jSONObject);
    }
}
