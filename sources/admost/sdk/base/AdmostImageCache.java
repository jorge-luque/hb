package admost.sdk.base;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader;
import com.ogury.p159cm.OguryChoiceManager;

public class AdmostImageCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public AdmostImageCache(int i) {
        super(i);
    }

    public static int getDefaultLruCacheSize() {
        return 1;
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }

    public AdmostImageCache() {
        this(getDefaultLruCacheSize());
    }

    /* access modifiers changed from: protected */
    public int sizeOf(String str, Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
    }
}
