package admost.adserver.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/* renamed from: admost.adserver.core.g */
/* compiled from: AdmostImageLoader */
public class C0059g {

    /* renamed from: d */
    private static C0059g f164d;

    /* renamed from: a */
    private ImageLoader f165a = new ImageLoader(this.f166b, new C0060a());

    /* renamed from: b */
    private RequestQueue f166b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0058f f167c = new C0058f();

    /* renamed from: admost.adserver.core.g$a */
    /* compiled from: AdmostImageLoader */
    class C0060a implements ImageLoader.ImageCache {

        /* renamed from: a */
        private final LruCache<String, Bitmap> f168a = C0059g.this.f167c;

        C0060a() {
        }

        public Bitmap getBitmap(String str) {
            return this.f168a.get(str);
        }

        public void putBitmap(String str, Bitmap bitmap) {
            this.f168a.put(str, bitmap);
        }
    }

    private C0059g(Context context) {
        this.f166b = Volley.newRequestQueue(context);
    }

    /* renamed from: a */
    public static C0059g m162a(Context context) {
        if (f164d == null) {
            f164d = new C0059g(context);
        }
        return f164d;
    }

    /* renamed from: a */
    public ImageLoader mo104a() {
        return this.f165a;
    }
}
