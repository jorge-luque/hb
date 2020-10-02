package admost.sdk.base;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AdmostImageLoader {
    private static AdmostImageLoader instance;
    private ImageLoader imageLoader = new ImageLoader(this.requestQueue, new ImageLoader.ImageCache() {
        private final LruCache<String, Bitmap> mCache = AdmostImageLoader.this.lruCache;

        public Bitmap getBitmap(String str) {
            return this.mCache.get(str);
        }

        public void putBitmap(String str, Bitmap bitmap) {
            this.mCache.put(str, bitmap);
        }
    });
    /* access modifiers changed from: private */
    public AdmostImageCache lruCache = new AdmostImageCache();
    private RequestQueue requestQueue = Volley.newRequestQueue(AdMost.getInstance().getContext().getApplicationContext());

    public static class RoundedDrawable extends Drawable {
        final RectF bitmapRectF;
        final BitmapShader bitmapShader;
        final float corner;
        final int margin;
        final Paint paint;
        final RectF rectF = new RectF();

        public RoundedDrawable(Bitmap bitmap, int i, int i2) {
            this.corner = (float) i;
            this.margin = i2;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            float f = (float) i2;
            this.bitmapRectF = new RectF(f, f, (float) (bitmap.getWidth() - i2), (float) (bitmap.getHeight() - i2));
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
        }

        public void draw(Canvas canvas) {
            RectF rectF2 = this.rectF;
            float f = this.corner;
            canvas.drawRoundRect(rectF2, f, f, this.paint);
        }

        public int getOpacity() {
            return -3;
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF2 = this.rectF;
            int i = this.margin;
            rectF2.set((float) i, (float) i, (float) (rect.width() - this.margin), (float) (rect.height() - this.margin));
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.bitmapRectF, this.rectF, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        public void setAlpha(int i) {
            this.paint.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    private AdmostImageLoader() {
    }

    public static AdmostImageLoader getInstance() {
        if (instance == null) {
            instance = new AdmostImageLoader();
        }
        return instance;
    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public void loadAdCover(String str, final boolean z, ImageView imageView, final ImageView imageView2) {
        if (str != null) {
            getImageLoader().get(str, new ImageLoader.ImageListener() {
                public void onErrorResponse(VolleyError volleyError) {
                }

                public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
                    new Handler().post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
                            r0 = r4.this$1;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r4 = this;
                                com.android.volley.toolbox.ImageLoader$ImageContainer r0 = r2
                                if (r0 == 0) goto L_0x002f
                                android.graphics.Bitmap r0 = r0.getBitmap()
                                if (r0 != 0) goto L_0x000b
                                goto L_0x002f
                            L_0x000b:
                                admost.sdk.base.AdmostImageLoader$3 r0 = admost.sdk.base.AdmostImageLoader.C02373.this
                                android.widget.ImageView r1 = r5
                                if (r1 == 0) goto L_0x002f
                                boolean r0 = r3
                                if (r0 == 0) goto L_0x0026
                                admost.sdk.base.AdmostImageLoader$RoundedDrawable r0 = new admost.sdk.base.AdmostImageLoader$RoundedDrawable
                                com.android.volley.toolbox.ImageLoader$ImageContainer r2 = r2
                                android.graphics.Bitmap r2 = r2.getBitmap()
                                r3 = 20
                                r0.<init>(r2, r3, r3)
                                r1.setImageDrawable(r0)
                                goto L_0x002f
                            L_0x0026:
                                com.android.volley.toolbox.ImageLoader$ImageContainer r0 = r2
                                android.graphics.Bitmap r0 = r0.getBitmap()
                                r1.setImageBitmap(r0)
                            L_0x002f:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdmostImageLoader.C02373.C02381.run():void");
                        }
                    });
                }
            });
        }
    }

    public void loadAdIcon(String str, final boolean z, final ImageView imageView) {
        if (str != null) {
            getImageLoader().get(str, new ImageLoader.ImageListener() {
                public void onErrorResponse(VolleyError volleyError) {
                }

                public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
                    new Handler().post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
                            r0 = r5.this$1;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r5 = this;
                                com.android.volley.toolbox.ImageLoader$ImageContainer r0 = r2
                                if (r0 == 0) goto L_0x0030
                                android.graphics.Bitmap r0 = r0.getBitmap()
                                if (r0 == 0) goto L_0x0030
                                admost.sdk.base.AdmostImageLoader$2 r0 = admost.sdk.base.AdmostImageLoader.C02352.this
                                android.widget.ImageView r1 = r5
                                if (r1 != 0) goto L_0x0011
                                goto L_0x0030
                            L_0x0011:
                                boolean r0 = r4
                                if (r0 == 0) goto L_0x0027
                                admost.sdk.base.AdmostImageLoader$RoundedDrawable r0 = new admost.sdk.base.AdmostImageLoader$RoundedDrawable
                                com.android.volley.toolbox.ImageLoader$ImageContainer r2 = r2
                                android.graphics.Bitmap r2 = r2.getBitmap()
                                r3 = 20
                                r4 = 0
                                r0.<init>(r2, r3, r4)
                                r1.setImageDrawable(r0)
                                goto L_0x0030
                            L_0x0027:
                                com.android.volley.toolbox.ImageLoader$ImageContainer r0 = r2
                                android.graphics.Bitmap r0 = r0.getBitmap()
                                r1.setImageBitmap(r0)
                            L_0x0030:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdmostImageLoader.C02352.C02361.run():void");
                        }
                    });
                }
            });
        }
    }

    public void loadImage(String str, ImageView imageView) {
        try {
            getImageLoader().get(str, ImageLoader.getImageListener(imageView, 17301633, 17301624));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
