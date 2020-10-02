package p118io.presage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: io.presage.u */
public final class C6575u {

    /* renamed from: a */
    public static final CamembertauCalvados f17135a = new CamembertauCalvados((byte) 0);

    /* renamed from: io.presage.u$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static Bitmap m21572a(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        Bitmap bitmap = null;
        try {
            httpURLConnection2 = m21574b(str);
            try {
                inputStream = httpURLConnection2.getInputStream();
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    options.inSampleSize = m21571a(options, C6215af.m20776b(48), C6215af.m20776b(48));
                    options.inJustDecodeBounds = false;
                    httpURLConnection = m21574b(str);
                    try {
                        inputStream2 = httpURLConnection.getInputStream();
                        try {
                            bitmap = BitmapFactory.decodeStream(inputStream2, (Rect) null, options);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        inputStream2 = null;
                    }
                } catch (Throwable unused3) {
                    httpURLConnection = null;
                    inputStream2 = null;
                }
            } catch (Throwable unused4) {
                httpURLConnection = null;
                inputStream = null;
                inputStream2 = inputStream;
                m21573a(httpURLConnection2, inputStream);
                m21573a(httpURLConnection, inputStream2);
                return bitmap;
            }
        } catch (Throwable unused5) {
            httpURLConnection = null;
            httpURLConnection2 = null;
            inputStream = null;
            inputStream2 = inputStream;
            m21573a(httpURLConnection2, inputStream);
            m21573a(httpURLConnection, inputStream2);
            return bitmap;
        }
        m21573a(httpURLConnection2, inputStream);
        m21573a(httpURLConnection, inputStream2);
        return bitmap;
    }

    /* renamed from: b */
    private static HttpURLConnection m21574b(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.connect();
            return httpURLConnection;
        }
        throw new C6434em("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    /* renamed from: a */
    private static int m21571a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: a */
    private static void m21573a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
                return;
            }
        }
        if (inputStream != null) {
            C6401dg.m21255a(inputStream);
        }
    }
}
