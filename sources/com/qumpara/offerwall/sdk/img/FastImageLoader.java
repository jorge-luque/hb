package com.qumpara.offerwall.sdk.img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.ogury.p159cm.OguryChoiceManager;
import com.qumpara.lib_qumpara_ads.R$drawable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FastImageLoader {
    /* access modifiers changed from: private */
    public static int ANIMATION_DURATION = 300;
    private static final String CACHE_DIR_NAME = "qumpara_sdk_cache";
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int IMAGE_SIZE_MIN = 500;
    private static final int READ_TIMEOUT = 15000;
    /* access modifiers changed from: private */
    public static final Object singletonLock = new Object();

    /* renamed from: com.qumpara.offerwall.sdk.img.FastImageLoader$1 */
    static /* synthetic */ class C47831 {

        /* renamed from: $SwitchMap$com$qumpara$offerwall$sdk$img$FastImageLoader$Core$ImageAnimation */
        static final /* synthetic */ int[] f12878x21a09855;

        static {
            int[] iArr = new int[Core.ImageAnimation.values().length];
            f12878x21a09855 = iArr;
            try {
                iArr[Core.ImageAnimation.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class FileCache {
        private File cacheDir;

        public FileCache(Context context) {
            File file = new File(context.getCacheDir(), FastImageLoader.CACHE_DIR_NAME);
            this.cacheDir = file;
            if (!file.exists()) {
                try {
                    this.cacheDir.mkdirs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void clear(File[] fileArr) {
            if (fileArr != null) {
                for (File file : fileArr) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        public File getFile(String str) {
            return new File(this.cacheDir, String.valueOf(str.hashCode()));
        }

        public File[] getFiles() {
            if (this.cacheDir.listFiles() == null || this.cacheDir.listFiles().length <= 0) {
                return null;
            }
            return this.cacheDir.listFiles();
        }
    }

    private interface ImageListener {
        void fail(String str);

        void success(String str);
    }

    public static class MemoryCache {
        /* access modifiers changed from: private */
        public Map<String, Bitmap> cache = Collections.synchronizedMap(new LinkedHashMap(20, 1.5f, true));
        private long limit = 1000000;
        private long size = 0;

        public MemoryCache() {
            if (Build.VERSION.SDK_INT > 21) {
                setLimit(Runtime.getRuntime().maxMemory() / 4);
            } else {
                setLimit(Runtime.getRuntime().maxMemory() / 8);
            }
        }

        private void checkSize() {
            if (this.size > this.limit) {
                Iterator<Map.Entry<String, Bitmap>> it = this.cache.entrySet().iterator();
                while (it.hasNext()) {
                    this.size -= getSizeInBytes((Bitmap) it.next().getValue());
                    it.remove();
                    if (this.size <= this.limit) {
                        return;
                    }
                }
            }
        }

        public void clear() {
            try {
                if (this.cache != null) {
                    for (Map.Entry<String, Bitmap> value : this.cache.entrySet()) {
                        value.setValue((Object) null);
                    }
                    this.cache.clear();
                    this.size = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public Bitmap get(String str) {
            try {
                if (!this.cache.containsKey(str)) {
                    return null;
                }
                return this.cache.get(str);
            } catch (NullPointerException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public long getSizeInBytes(Bitmap bitmap) {
            if (bitmap == null) {
                return 0;
            }
            return (long) (bitmap.getRowBytes() * bitmap.getHeight());
        }

        public void put(String str, Bitmap bitmap) {
            try {
                if (this.cache.containsKey(str)) {
                    this.size -= getSizeInBytes(this.cache.get(str));
                }
                this.cache.put(str, bitmap);
                this.size += getSizeInBytes(bitmap);
                checkSize();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void setLimit(long j) {
            this.limit = j;
        }
    }

    /* access modifiers changed from: private */
    public static int CopyStream(InputStream inputStream, OutputStream outputStream) {
        int i = 0;
        try {
            byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
            int i2 = 0;
            while (true) {
                try {
                    int read = inputStream.read(bArr, 0, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                    if (read == -1) {
                        return i2;
                    }
                    i2 += read;
                    outputStream.write(bArr, 0, read);
                } catch (Exception e) {
                    e = e;
                    i = i2;
                    e.printStackTrace();
                    return i;
                }
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return i;
        }
    }

    public static class Core {
        protected static Core mInstance;
        protected ExecutorService executorService;
        protected FileCache fileCache;
        protected ImageListener imageListener;
        protected Map<ImageView, String> imageViews;
        protected MemoryCache memoryCache = new MemoryCache();

        class BitmapDisplayer implements Runnable {
            ImageAnimation animation;
            Bitmap bitmap;
            Context context;
            PhotoToLoad photoToLoad;

            public BitmapDisplayer(Bitmap bitmap2, PhotoToLoad photoToLoad2, ImageAnimation imageAnimation) {
                this.bitmap = bitmap2;
                this.photoToLoad = photoToLoad2;
                this.animation = imageAnimation;
                if (photoToLoad2.imageView.getContext() != null) {
                    this.context = photoToLoad2.imageView.getContext();
                }
            }

            public void run() {
                if (!Core.this.imageViewReused(this.photoToLoad)) {
                    if (this.bitmap == null || this.photoToLoad.imageView == null) {
                        Core.getInstance(this.context).imageListener.fail(this.photoToLoad.url);
                    } else {
                        Core.getInstance(this.context).imageListener.success(this.photoToLoad.url);
                    }
                }
            }
        }

        public enum ImageAnimation {
            NO_ANIMATION,
            FADE_IN
        }

        private static class PhotoToLoad {
            public ImageView imageView;
            public String url;

            public PhotoToLoad(String str, ImageView imageView2) {
                this.url = str;
                this.imageView = imageView2;
            }
        }

        class PhotosLoader implements Runnable {
            ImageAnimation animation;
            PhotoToLoad photoToLoad;

            PhotosLoader(PhotoToLoad photoToLoad2, ImageAnimation imageAnimation) {
                this.photoToLoad = photoToLoad2;
                this.animation = imageAnimation;
            }

            public void run() {
                if (!Core.this.imageViewReused(this.photoToLoad)) {
                    Bitmap access$400 = Core.this.getBitmap(this.photoToLoad.url);
                    if (this.photoToLoad.imageView.getContext() != null) {
                        if (access$400 != null) {
                            Core.this.memoryCache.put(this.photoToLoad.url, access$400);
                            Core.getInstance(this.photoToLoad.imageView.getContext()).imageListener.success(this.photoToLoad.url);
                            return;
                        }
                        Core.getInstance(this.photoToLoad.imageView.getContext()).imageListener.fail(this.photoToLoad.url);
                    }
                }
            }
        }

        private Core(Context context) {
            this.fileCache = new FileCache(context);
            this.imageViews = Collections.synchronizedMap(new WeakHashMap());
            this.executorService = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(20));
            this.imageListener = new ImageListener() {
                public void fail(String str) {
                    ImageView imageView;
                    if (!Core.this.imageViews.containsValue(str) || str == null) {
                        "fail url not found: " + str;
                        return;
                    }
                    for (Map.Entry next : Core.this.imageViews.entrySet()) {
                        String str2 = (String) next.getValue();
                        if (str.equals(next.getValue()) && (imageView = (ImageView) next.getKey()) != null) {
                            imageView.setImageResource(R$drawable.uncomplete_img);
                        }
                    }
                }

                public void success(String str) {
                    if (Core.this.imageViews.containsValue(str) && str != null) {
                        for (Map.Entry next : Core.this.imageViews.entrySet()) {
                            if (str.equals(next.getValue())) {
                                final Bitmap bitmap = Core.this.memoryCache.get(str);
                                final ImageView imageView = (ImageView) next.getKey();
                                if (!(imageView == null || bitmap == null)) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        public void run() {
                                            Core.this.imageViews.remove(imageView);
                                            imageView.setImageBitmap(bitmap);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            };
        }

        private void DisplayImage(String str, ImageView imageView) {
            this.imageViews.put(imageView, str);
            Bitmap bitmap = this.memoryCache.get(str);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else if (this.memoryCache.cache == null || !this.memoryCache.cache.containsKey(str)) {
                this.memoryCache.put(str, (Bitmap) null);
                queuePhoto(str, imageView, (ImageAnimation) null);
            }
        }

        private void animateImageView(ImageView imageView, Bitmap bitmap, ImageAnimation imageAnimation) {
            if (imageAnimation == null) {
                imageView.setImageBitmap(bitmap);
            } else if (C47831.f12878x21a09855[imageAnimation.ordinal()] != 1) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setAlpha(0.0f);
                imageView.setImageBitmap(bitmap);
                imageView.animate().setDuration((long) FastImageLoader.ANIMATION_DURATION).alpha(1.0f).start();
            }
        }

        private Bitmap decodeFile(File file) {
            try {
                if (!file.exists()) {
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i = 1;
                options.inJustDecodeBounds = true;
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                while (true) {
                    if (i2 / 2 < 500) {
                        break;
                    } else if (i3 / 2 < 500) {
                        break;
                    } else {
                        i2 /= 2;
                        i3 /= 2;
                        i *= 2;
                    }
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i;
                return BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0079 }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[Catch:{ all -> 0x0079 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap getBitmap(java.lang.String r8) {
            /*
                r7 = this;
                com.qumpara.offerwall.sdk.img.FastImageLoader$FileCache r0 = r7.fileCache
                java.io.File r0 = r0.getFile(r8)
                android.graphics.Bitmap r1 = r7.decodeFile(r0)
                if (r1 == 0) goto L_0x000d
                return r1
            L_0x000d:
                r1 = 1
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x004d }
                r3.<init>(r8)     // Catch:{ all -> 0x004d }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ all -> 0x004d }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x004d }
                r4 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r4)     // Catch:{ all -> 0x004b }
                r4 = 15000(0x3a98, float:2.102E-41)
                r3.setReadTimeout(r4)     // Catch:{ all -> 0x004b }
                r3.setDoInput(r1)     // Catch:{ all -> 0x004b }
                r3.connect()     // Catch:{ all -> 0x004b }
                int r4 = r3.getResponseCode()     // Catch:{ all -> 0x004b }
                r5 = 200(0xc8, float:2.8E-43)
                if (r4 != r5) goto L_0x0045
                java.io.InputStream r4 = r3.getInputStream()     // Catch:{ all -> 0x004b }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x004b }
                r5.<init>(r0)     // Catch:{ all -> 0x004b }
                int unused = com.qumpara.offerwall.sdk.img.FastImageLoader.CopyStream(r4, r5)     // Catch:{ all -> 0x004b }
                r5.close()     // Catch:{ all -> 0x004b }
                android.graphics.Bitmap r2 = r7.decodeFile(r0)     // Catch:{ all -> 0x004b }
            L_0x0045:
                if (r3 == 0) goto L_0x004a
                r3.disconnect()
            L_0x004a:
                return r2
            L_0x004b:
                r0 = move-exception
                goto L_0x004f
            L_0x004d:
                r0 = move-exception
                r3 = r2
            L_0x004f:
                boolean r4 = r0 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x0079 }
                if (r4 == 0) goto L_0x005d
                com.qumpara.offerwall.sdk.img.FastImageLoader$MemoryCache r4 = r7.memoryCache     // Catch:{ all -> 0x0079 }
                r4.clear()     // Catch:{ all -> 0x0079 }
                java.util.Map<android.widget.ImageView, java.lang.String> r4 = r7.imageViews     // Catch:{ all -> 0x0079 }
                r4.clear()     // Catch:{ all -> 0x0079 }
            L_0x005d:
                boolean r0 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x0079 }
                if (r0 == 0) goto L_0x0073
                java.lang.String r0 = "QUMPARA_OFFERWALL_IMAGE"
                java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0079 }
                java.lang.String r5 = "Socket timeout exception while downloading: %s"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0079 }
                r6 = 0
                r1[r6] = r8     // Catch:{ all -> 0x0079 }
                java.lang.String r8 = java.lang.String.format(r4, r5, r1)     // Catch:{ all -> 0x0079 }
                android.util.Log.w(r0, r8)     // Catch:{ all -> 0x0079 }
            L_0x0073:
                if (r3 == 0) goto L_0x0078
                r3.disconnect()
            L_0x0078:
                return r2
            L_0x0079:
                if (r3 == 0) goto L_0x007f
                r3.disconnect()
            L_0x007f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.img.FastImageLoader.Core.getBitmap(java.lang.String):android.graphics.Bitmap");
        }

        public static Core getInstance(Context context) {
            Core core;
            Core core2 = mInstance;
            if (core2 != null) {
                return core2;
            }
            synchronized (FastImageLoader.singletonLock) {
                core = new Core(context);
                mInstance = core;
            }
            return core;
        }

        private void queuePhoto(String str, ImageView imageView, ImageAnimation imageAnimation) {
            try {
                this.executorService.submit(new PhotosLoader(new PhotoToLoad(str, imageView), imageAnimation));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void clear() {
            try {
                mInstance = null;
                this.executorService.shutdown();
                this.memoryCache.clear();
                this.imageViews.clear();
                this.imageListener = null;
            } catch (Exception unused) {
            }
        }

        public void displayImageWithAnimation(String str, ImageView imageView, ImageAnimation imageAnimation) {
            try {
                this.imageViews.put(imageView, str);
                Bitmap bitmap = this.memoryCache.get(str);
                if (bitmap != null) {
                    animateImageView(imageView, bitmap, imageAnimation);
                } else {
                    queuePhoto(str, imageView, imageAnimation);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean imageViewReused(PhotoToLoad photoToLoad) {
            String str = this.imageViews.get(photoToLoad.imageView);
            if (str == null || !str.equals(photoToLoad.url)) {
                "imageView reused tag: " + str;
                return true;
            }
            "imageView not reused: " + str;
            return false;
        }

        public void DisplayImage(String str, ImageView imageView, boolean z) {
            if (z) {
                displayImageWithAnimation(str, imageView, ImageAnimation.FADE_IN);
            } else {
                DisplayImage(str, imageView);
            }
        }

        public void DisplayImage(String str, ImageView imageView, ImageAnimation imageAnimation, int i) {
            int unused = FastImageLoader.ANIMATION_DURATION = i;
            displayImageWithAnimation(str, imageView, imageAnimation);
        }

        public void DisplayImage(String str, ImageView imageView, ImageAnimation imageAnimation) {
            displayImageWithAnimation(str, imageView, imageAnimation);
        }
    }
}
