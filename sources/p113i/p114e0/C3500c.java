package p113i.p114e0;

import android.support.p004v4.media.session.PlaybackStateCompat;
import com.loopj.android.http.C4250c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.http2.C6616b;
import p113i.C3484b0;
import p113i.C3537r;
import p113i.C3539s;
import p113i.C3541u;
import p113i.C3550z;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3581f;
import p119j.C3586u;

/* renamed from: i.e0.c */
/* compiled from: Util */
public final class C3500c {

    /* renamed from: a */
    public static final byte[] f9701a;

    /* renamed from: b */
    public static final String[] f9702b = new String[0];

    /* renamed from: c */
    public static final C3484b0 f9703c;

    /* renamed from: d */
    private static final C3581f f9704d = C3581f.m12175b("efbbbf");

    /* renamed from: e */
    private static final C3581f f9705e = C3581f.m12175b("feff");

    /* renamed from: f */
    private static final C3581f f9706f = C3581f.m12175b("fffe");

    /* renamed from: g */
    private static final C3581f f9707g = C3581f.m12175b("0000ffff");

    /* renamed from: h */
    private static final C3581f f9708h = C3581f.m12175b("ffff0000");

    /* renamed from: i */
    public static final Charset f9709i = Charset.forName(C4250c.DEFAULT_CHARSET);

    /* renamed from: j */
    private static final Charset f9710j = Charset.forName("UTF-16BE");

    /* renamed from: k */
    private static final Charset f9711k = Charset.forName("UTF-16LE");

    /* renamed from: l */
    private static final Charset f9712l = Charset.forName("UTF-32BE");

    /* renamed from: m */
    private static final Charset f9713m = Charset.forName("UTF-32LE");

    /* renamed from: n */
    public static final TimeZone f9714n = TimeZone.getTimeZone("GMT");

    /* renamed from: o */
    public static final Comparator<String> f9715o = new C3501a();

    /* renamed from: p */
    private static final Method f9716p;

    /* renamed from: q */
    private static final Pattern f9717q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: i.e0.c$a */
    /* compiled from: Util */
    class C3501a implements Comparator<String> {
        C3501a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* renamed from: i.e0.c$b */
    /* compiled from: Util */
    class C3502b implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ String f9718a;

        /* renamed from: b */
        final /* synthetic */ boolean f9719b;

        C3502b(String str, boolean z) {
            this.f9718a = str;
            this.f9719b = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f9718a);
            thread.setDaemon(this.f9719b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f9701a = bArr;
        Method method = null;
        f9703c = C3484b0.create((C3541u) null, bArr);
        C3550z.create((C3541u) null, f9701a);
        Charset.forName("ISO-8859-1");
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f9716p = method;
    }

    /* renamed from: a */
    public static int m11631a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static void m11650a(Throwable th, Throwable th2) {
        Method method = f9716p;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: b */
    public static boolean m11660b(C3586u uVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c = uVar.timeout().mo19776d() ? uVar.timeout().mo19775c() - nanoTime : Long.MAX_VALUE;
        uVar.timeout().mo19772a(Math.min(c, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            C3577c cVar = new C3577c();
            while (uVar.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.mo19706d();
            }
            if (c == Long.MAX_VALUE) {
                uVar.timeout().mo19771a();
            } else {
                uVar.timeout().mo19772a(nanoTime + c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c == Long.MAX_VALUE) {
                uVar.timeout().mo19771a();
            } else {
                uVar.timeout().mo19772a(nanoTime + c);
            }
            return false;
        } catch (Throwable th) {
            if (c == Long.MAX_VALUE) {
                uVar.timeout().mo19771a();
            } else {
                uVar.timeout().mo19772a(nanoTime + c);
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static int m11664c(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: d */
    public static String m11665d(String str, int i, int i2) {
        int b = m11658b(str, i, i2);
        return str.substring(b, m11664c(str, b, i2));
    }

    /* renamed from: c */
    public static int m11663c(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m11648a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m11654a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: d */
    public static boolean m11666d(String str) {
        return f9717q.matcher(str).matches();
    }

    /* renamed from: a */
    public static void m11649a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11651a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m11653a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m11652a(C3586u uVar, int i, TimeUnit timeUnit) {
        try {
            return m11660b(uVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m11643a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m11645a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: b */
    public static boolean m11662b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T> List<T> m11644a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m11646a(String str, boolean z) {
        return new C3502b(str, z);
    }

    /* renamed from: a */
    public static String[] m11656a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static int m11658b(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    private static boolean m11661b(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static C3537r m11659b(List<C6616b> list) {
        C3537r.C3538a aVar = new C3537r.C3538a();
        for (C6616b next : list) {
            C3499a.f9700a.mo19373a(aVar, next.f17334a.mo19763i(), next.f17335b.mo19763i());
        }
        return aVar.mo19511a();
    }

    /* renamed from: a */
    public static String m11637a(C3539s sVar, boolean z) {
        String str;
        if (sVar.mo19525g().contains(":")) {
            str = "[" + sVar.mo19525g() + "]";
        } else {
            str = sVar.mo19525g();
        }
        if (!z && sVar.mo19530k() == C3539s.m11857c(sVar.mo19533n())) {
            return str;
        }
        return str + ":" + sVar.mo19530k();
    }

    /* renamed from: a */
    public static boolean m11653a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m11635a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m11657a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m11633a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m11632a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m11638a(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = m11641a(str, 0, str.length());
            } else {
                inetAddress = m11641a(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return m11640a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !m11661b(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m11639a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m11642a(C3580e eVar, Charset charset) throws IOException {
        if (eVar.mo19701a(0, f9704d)) {
            eVar.skip((long) f9704d.mo19759f());
            return f9709i;
        } else if (eVar.mo19701a(0, f9705e)) {
            eVar.skip((long) f9705e.mo19759f());
            return f9710j;
        } else if (eVar.mo19701a(0, f9706f)) {
            eVar.skip((long) f9706f.mo19759f());
            return f9711k;
        } else if (eVar.mo19701a(0, f9707g)) {
            eVar.skip((long) f9707g.mo19759f());
            return f9712l;
        } else if (!eVar.mo19701a(0, f9708h)) {
            return charset;
        } else {
            eVar.skip((long) f9708h.mo19759f());
            return f9713m;
        }
    }

    /* renamed from: a */
    public static int m11634a(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || j <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public static AssertionError m11636a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    @Nullable
    /* renamed from: a */
    private static InetAddress m11641a(String str, int i, int i2) {
        byte[] bArr = new byte[16];
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            if (i >= i2) {
                break;
            } else if (i3 == 16) {
                return null;
            } else {
                int i6 = i + 2;
                if (i6 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                    if (i3 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!str.regionMatches(i, ".", 0, 1) || !m11655a(str, i5, i2, bArr, i3 - 2)) {
                            return null;
                        } else {
                            i3 += 2;
                        }
                    }
                    i5 = i;
                } else if (i4 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i4 = i3;
                    if (i6 == i2) {
                        break;
                    }
                    i5 = i6;
                }
                i = i5;
                int i7 = 0;
                while (i < i2) {
                    int a = m11631a(str.charAt(i));
                    if (a == -1) {
                        break;
                    }
                    i7 = (i7 << 4) + a;
                    i++;
                }
                int i8 = i - i5;
                if (i8 == 0 || i8 > 4) {
                    return null;
                }
                int i9 = i3 + 1;
                bArr[i3] = (byte) ((i7 >>> 8) & 255);
                i3 = i9 + 1;
                bArr[i9] = (byte) (i7 & 255);
            }
        }
        if (i3 != 16) {
            if (i4 == -1) {
                return null;
            }
            int i10 = i3 - i4;
            System.arraycopy(bArr, i4, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i4, (16 - i3) + i4, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static boolean m11655a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static String m11640a(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        C3577c cVar = new C3577c();
        while (i < bArr.length) {
            if (i == i2) {
                cVar.writeByte(58);
                i += i4;
                if (i == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i > 0) {
                    cVar.writeByte(58);
                }
                cVar.mo19716j((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                i += 2;
            }
        }
        return cVar.mo19732v();
    }

    /* renamed from: a */
    public static X509TrustManager m11647a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw m11636a("No System TLS", (Exception) e);
        }
    }
}
