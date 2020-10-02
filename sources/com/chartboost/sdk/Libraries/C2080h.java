package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.Tracking.C2098a;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.h */
public class C2080h implements C2109f.C2113c {

    /* renamed from: a */
    private C2081a f6871a;

    /* renamed from: b */
    private final C2109f f6872b;

    /* renamed from: c */
    private float f6873c = 1.0f;

    /* renamed from: com.chartboost.sdk.Libraries.h$a */
    public static class C2081a {

        /* renamed from: a */
        private int f6874a;

        /* renamed from: b */
        private final String f6875b;

        /* renamed from: c */
        private final File f6876c;

        /* renamed from: d */
        private Bitmap f6877d;

        /* renamed from: e */
        private final C2078f f6878e;

        /* renamed from: f */
        private int f6879f = -1;

        /* renamed from: g */
        private int f6880g = -1;

        public C2081a(String str, File file, C2078f fVar) {
            this.f6876c = file;
            this.f6875b = str;
            this.f6877d = null;
            this.f6874a = 1;
            this.f6878e = fVar;
        }

        /* renamed from: f */
        private void m8206f() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f6876c.getAbsolutePath(), options);
                this.f6879f = options.outWidth;
                this.f6880g = options.outHeight;
            } catch (Exception e) {
                CBLogging.m8153a("MemoryBitmap", "Error decoding file size", e);
                C2098a.m8288a(C2081a.class, "decodeSize", e);
            }
        }

        /* renamed from: a */
        public void mo9105a() {
            if (this.f6877d == null) {
                CBLogging.m8152a("MemoryBitmap", "Loading image '" + this.f6875b + "' from cache");
                byte[] b = this.f6878e.mo9093b(this.f6876c);
                if (b == null) {
                    CBLogging.m8154b("MemoryBitmap", "decode() - bitmap not found");
                    return;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(b, 0, b.length, options);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inDither = false;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                options2.inTempStorage = new byte[32768];
                options2.inSampleSize = 1;
                while (true) {
                    if (options2.inSampleSize >= 32) {
                        break;
                    }
                    try {
                        this.f6877d = BitmapFactory.decodeByteArray(b, 0, b.length, options2);
                        break;
                    } catch (OutOfMemoryError e) {
                        CBLogging.m8153a("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", e);
                        options2.inSampleSize *= 2;
                    } catch (Exception e2) {
                        CBLogging.m8153a("MemoryBitmap", "Exception raised decoding bitmap", e2);
                        C2098a.m8288a(C2081a.class, "decodeByteArray", e2);
                    }
                }
                this.f6874a = options2.inSampleSize;
            }
            return;
            if (this.f6877d == null) {
                this.f6876c.delete();
                throw new RuntimeException("Unable to decode " + this.f6875b);
            }
            this.f6874a = options2.inSampleSize;
        }

        /* renamed from: b */
        public Bitmap mo9106b() {
            if (this.f6877d == null) {
                mo9105a();
            }
            return this.f6877d;
        }

        /* renamed from: c */
        public int mo9107c() {
            Bitmap bitmap = this.f6877d;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            int i = this.f6880g;
            if (i >= 0) {
                return i;
            }
            m8206f();
            return this.f6880g;
        }

        /* renamed from: d */
        public int mo9108d() {
            Bitmap bitmap = this.f6877d;
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            int i = this.f6879f;
            if (i >= 0) {
                return i;
            }
            m8206f();
            return this.f6879f;
        }

        /* renamed from: e */
        public int mo9109e() {
            return this.f6874a;
        }
    }

    public C2080h(C2109f fVar) {
        this.f6872b = fVar;
    }

    /* renamed from: a */
    public boolean mo9099a(String str) {
        return mo9100a(this.f6872b.mo9245e(), str);
    }

    /* renamed from: b */
    public Bitmap mo9101b() {
        C2081a aVar = this.f6871a;
        if (aVar != null) {
            return aVar.mo9106b();
        }
        return null;
    }

    /* renamed from: c */
    public int mo9102c() {
        return this.f6871a.mo9107c() * this.f6871a.mo9109e();
    }

    /* renamed from: d */
    public int mo9103d() {
        return this.f6871a.mo9108d() * this.f6871a.mo9109e();
    }

    /* renamed from: e */
    public boolean mo9104e() {
        return this.f6871a != null;
    }

    /* renamed from: a */
    public boolean mo9100a(JSONObject jSONObject, String str) {
        JSONObject a = C2076e.m8185a(jSONObject, str);
        if (a == null) {
            return true;
        }
        String optString = a.optString("url");
        this.f6873c = (float) a.optDouble("scale", 1.0d);
        if (optString.isEmpty()) {
            return true;
        }
        String optString2 = a.optString("checksum");
        if (optString2.isEmpty()) {
            return false;
        }
        C2081a a2 = this.f6872b.f7073g.f6932l.mo9596a(optString2);
        this.f6871a = a2;
        if (a2 != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public float mo9098a() {
        return this.f6873c;
    }
}
