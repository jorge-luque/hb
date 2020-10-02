package p163cz.msebera.android.httpclient.client.p172r;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.p166c0.C5572e;
import p163cz.msebera.android.httpclient.p182g0.C5743m;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p182g0.C5753w;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.client.r.e */
/* compiled from: URLEncodedUtils */
public class C5622e {

    /* renamed from: a */
    private static final BitSet f14618a = new BitSet(256);

    /* renamed from: b */
    private static final BitSet f14619b = new BitSet(256);

    /* renamed from: c */
    private static final BitSet f14620c = new BitSet(256);

    /* renamed from: d */
    private static final BitSet f14621d = new BitSet(256);

    /* renamed from: e */
    private static final BitSet f14622e = new BitSet(256);

    /* renamed from: f */
    private static final BitSet f14623f = new BitSet(256);

    /* renamed from: g */
    private static final BitSet f14624g = new BitSet(256);

    static {
        for (int i = 97; i <= 122; i++) {
            f14618a.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f14618a.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            f14618a.set(i3);
        }
        f14618a.set(95);
        f14618a.set(45);
        f14618a.set(46);
        f14618a.set(42);
        f14624g.or(f14618a);
        f14618a.set(33);
        f14618a.set(126);
        f14618a.set(39);
        f14618a.set(40);
        f14618a.set(41);
        f14619b.set(44);
        f14619b.set(59);
        f14619b.set(58);
        f14619b.set(36);
        f14619b.set(38);
        f14619b.set(43);
        f14619b.set(61);
        f14620c.or(f14618a);
        f14620c.or(f14619b);
        f14621d.or(f14618a);
        f14621d.set(47);
        f14621d.set(59);
        f14621d.set(58);
        f14621d.set(64);
        f14621d.set(38);
        f14621d.set(61);
        f14621d.set(43);
        f14621d.set(36);
        f14621d.set(44);
        f14623f.set(59);
        f14623f.set(47);
        f14623f.set(63);
        f14623f.set(58);
        f14623f.set(64);
        f14623f.set(38);
        f14623f.set(61);
        f14623f.set(43);
        f14623f.set(36);
        f14623f.set(44);
        f14623f.set(91);
        f14623f.set(93);
        f14622e.or(f14623f);
        f14622e.or(f14618a);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static List<C5906u> m17903a(C5870j jVar) throws IOException {
        C5572e a = C5572e.m17756a(jVar);
        if (a == null || !a.mo32904b().equalsIgnoreCase("application/x-www-form-urlencoded")) {
            return Collections.emptyList();
        }
        long h = jVar.mo28849h();
        C5886a.m18896a(h <= 2147483647L, "HTTP entity is too large");
        Charset a2 = a.mo32903a() != null ? a.mo32903a() : C5874d.f15105a;
        InputStream content = jVar.getContent();
        if (content == null) {
            return Collections.emptyList();
        }
        try {
            C5889d dVar = new C5889d(h > 0 ? (int) h : OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            InputStreamReader inputStreamReader = new InputStreamReader(content, a2);
            char[] cArr = new char[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                dVar.mo33672a(cArr, 0, read);
            }
            content.close();
            if (dVar.length() == 0) {
                return Collections.emptyList();
            }
            return m17904a(dVar, a2, '&');
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    /* renamed from: b */
    static String m17905b(String str, Charset charset) {
        return m17901a(str, charset, f14621d, false);
    }

    /* renamed from: c */
    static String m17906c(String str, Charset charset) {
        return m17901a(str, charset, f14622e, false);
    }

    /* renamed from: d */
    static String m17907d(String str, Charset charset) {
        return m17901a(str, charset, f14620c, false);
    }

    /* renamed from: e */
    private static String m17908e(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return m17901a(str, charset, f14624g, true);
    }

    /* renamed from: f */
    public static List<C5906u> m17909f(String str, Charset charset) {
        C5889d dVar = new C5889d(str.length());
        dVar.mo33670a(str);
        return m17904a(dVar, charset, '&', ';');
    }

    /* renamed from: a */
    public static List<C5906u> m17904a(C5889d dVar, Charset charset, char... cArr) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5753w wVar = C5753w.f14852a;
        BitSet bitSet = new BitSet();
        for (char c : cArr) {
            bitSet.set(c);
        }
        C5752v vVar = new C5752v(0, dVar.length());
        ArrayList arrayList = new ArrayList();
        while (!vVar.mo33405a()) {
            bitSet.set(61);
            String a = wVar.mo33409a(dVar, vVar, bitSet);
            String str = null;
            if (!vVar.mo33405a()) {
                char charAt = dVar.charAt(vVar.mo33406b());
                vVar.mo33404a(vVar.mo33406b() + 1);
                if (charAt == '=') {
                    bitSet.clear(61);
                    str = wVar.mo33413b(dVar, vVar, bitSet);
                    if (!vVar.mo33405a()) {
                        vVar.mo33404a(vVar.mo33406b() + 1);
                    }
                }
            }
            if (!a.isEmpty()) {
                arrayList.add(new C5743m(m17900a(a, charset), m17900a(str, charset)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m17899a(Iterable<? extends C5906u> iterable, Charset charset) {
        return m17898a(iterable, '&', charset);
    }

    /* renamed from: a */
    public static String m17898a(Iterable<? extends C5906u> iterable, char c, Charset charset) {
        StringBuilder sb = new StringBuilder();
        for (C5906u uVar : iterable) {
            String e = m17908e(uVar.getName(), charset);
            String e2 = m17908e(uVar.getValue(), charset);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(e);
            if (e2 != null) {
                sb.append("=");
                sb.append(e2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m17901a(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & 15, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m17902a(String str, Charset charset, boolean z) {
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            char c = wrap.get();
            if (c == '%' && wrap.remaining() >= 2) {
                char c2 = wrap.get();
                char c3 = wrap.get();
                int digit = Character.digit(c2, 16);
                int digit2 = Character.digit(c3, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put((byte) 37);
                    allocate.put((byte) c2);
                    allocate.put((byte) c3);
                } else {
                    allocate.put((byte) ((digit << 4) + digit2));
                }
            } else if (!z || c != '+') {
                allocate.put((byte) c);
            } else {
                allocate.put((byte) 32);
            }
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    /* renamed from: a */
    private static String m17900a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return m17902a(str, charset, true);
    }
}
