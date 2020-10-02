package admost.adserver.core;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: admost.adserver.core.f */
/* compiled from: AdmostImageCache */
public class C0058f extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public C0058f(int i) {
        super(i);
    }

    /* renamed from: a */
    public static int m159a() {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int sizeOf(String str, Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS;
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }

    public C0058f() {
        this(m159a());
    }
}
