package admost.adserver.videocache;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: admost.adserver.videocache.m */
/* compiled from: ProxyCacheUtils */
public class C0081m {
    /* renamed from: a */
    static void m254a(byte[] bArr, long j, int i) {
        C0077k.m232a(bArr, "Buffer must be not null!");
        boolean z = true;
        C0077k.m234a(j >= 0, "Data offset must be positive!");
        if (i < 0 || i > bArr.length) {
            z = false;
        }
        C0077k.m234a(z, "Length must be in range [0..buffer.length]");
    }

    /* renamed from: b */
    static String m255b(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    /* renamed from: c */
    static String m256c(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    /* renamed from: d */
    static String m257d(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* renamed from: a */
    static void m253a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.w("ADMOST-VIDEO", "Error closing resource", e);
            }
        }
    }

    /* renamed from: a */
    public static String m251a(String str) {
        try {
            return m252a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: a */
    private static String m252a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }
}
