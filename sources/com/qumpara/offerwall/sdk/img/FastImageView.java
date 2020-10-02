package com.qumpara.offerwall.sdk.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qumpara.offerwall.sdk.img.FastImageLoader;
import com.qumpara.offerwall.sdk.img.FastImageTask;

public class FastImageView extends ImageView {
    private static final String LOGTAG = "QUMPARA_OFFERWALL_IMAGE";
    private static Object admostImageLoader;
    private static final Object admostImageLoaderLock = new Object();
    private FastImageTask currentTask;

    public FastImageView(Context context) {
        super(context);
    }

    public static void cancelAllTasks(Context context) {
        try {
            FastImageLoader.Core.getInstance(context).clear();
        } catch (Exception unused) {
        }
    }

    public static Object getAdMostImageLoader() {
        try {
            return Class.forName("admost.sdk.base.AdmostImageLoader").getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isAdMostAvailable() {
        try {
            Class.forName("admost.sdk.base.AdmostImageLoader");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean loadImageViaAdMost(String str, ImageView imageView, Integer num) {
        try {
            synchronized (admostImageLoaderLock) {
                if (admostImageLoader == null) {
                    admostImageLoader = getAdMostImageLoader();
                }
            }
            Class.forName("admost.sdk.base.AdmostImageLoader").getMethod("loadImage", new Class[]{String.class, ImageView.class}).invoke(admostImageLoader, new Object[]{str, imageView});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setImage(FastImage fastImage) {
        setImage(fastImage, (Integer) null, (Integer) null, (FastImageTask.OnCompleteListener) null);
    }

    public void setImageUrl(String str) {
        FastImageLoader.Core.getInstance(getContext()).DisplayImage(str, (ImageView) this, false);
    }

    public FastImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setImage(FastImage fastImage, FastImageTask.OnCompleteListener onCompleteListener) {
        setImage(fastImage, (Integer) null, (Integer) null, onCompleteListener);
    }

    public void setImageUrl(String str, FastImageTask.OnCompleteListener onCompleteListener) {
        setImage((FastImage) new WebImage(str), onCompleteListener);
    }

    public FastImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImage(FastImage fastImage, Integer num) {
        setImage(fastImage, num, (Integer) null, (FastImageTask.OnCompleteListener) null);
    }

    public void setImageUrl(String str, Integer num) {
        FastImageLoader.Core.getInstance(getContext()).DisplayImage(str, (ImageView) this, false);
    }

    public void setImage(FastImage fastImage, Integer num, FastImageTask.OnCompleteListener onCompleteListener) {
        setImage(fastImage, num, (Integer) null, onCompleteListener);
    }

    public void setImageUrl(String str, Integer num, FastImageTask.OnCompleteListener onCompleteListener) {
        setImage((FastImage) new WebImage(str), num, onCompleteListener);
    }

    public void setImage(FastImage fastImage, Integer num, Integer num2) {
        setImage(fastImage, num, (Integer) null, (FastImageTask.OnCompleteListener) null);
    }

    public void setImageUrl(String str, Integer num, Integer num2) {
        setImage((FastImage) new WebImage(str), num, num2);
    }

    public void setImage(FastImage fastImage, final Integer num, Integer num2, final FastImageTask.OnCompleteListener onCompleteListener) {
        if (num2 != null) {
            setImageResource(num2.intValue());
        }
        FastImageTask fastImageTask = this.currentTask;
        if (fastImageTask != null) {
            fastImageTask.cancel();
            this.currentTask = null;
        }
        FastImageTask fastImageTask2 = new FastImageTask(getContext(), fastImage);
        this.currentTask = fastImageTask2;
        fastImageTask2.setOnCompleteHandler(new FastImageTask.OnCompleteHandler() {
            public void onComplete(Bitmap bitmap) {
                if (bitmap != null) {
                    FastImageView.this.setImageBitmap(bitmap);
                } else {
                    Integer num = num;
                    if (num != null) {
                        FastImageView.this.setImageResource(num.intValue());
                    }
                }
                FastImageTask.OnCompleteListener onCompleteListener = onCompleteListener;
                if (onCompleteListener != null) {
                    onCompleteListener.onComplete(bitmap);
                }
            }
        });
    }

    public void setImageUrl(String str, Integer num, Integer num2, FastImageTask.OnCompleteListener onCompleteListener) {
        setImage(new WebImage(str), num, num2, onCompleteListener);
    }
}
