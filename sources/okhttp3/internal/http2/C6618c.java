package okhttp3.internal.http2;

import com.facebook.places.model.PlaceFields;
import com.google.android.gms.games.Notifications;
import com.ogury.p159cm.OguryChoiceManager;
import com.vungle.warren.model.CookieDBAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p113i.p114e0.C3500c;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3581f;
import p119j.C3586u;
import p119j.C6589n;

/* renamed from: okhttp3.internal.http2.c */
/* compiled from: Hpack */
final class C6618c {

    /* renamed from: a */
    static final C6616b[] f17337a = {new C6616b(C6616b.f17333i, ""), new C6616b(C6616b.f17330f, "GET"), new C6616b(C6616b.f17330f, "POST"), new C6616b(C6616b.f17331g, "/"), new C6616b(C6616b.f17331g, "/index.html"), new C6616b(C6616b.f17332h, "http"), new C6616b(C6616b.f17332h, "https"), new C6616b(C6616b.f17329e, "200"), new C6616b(C6616b.f17329e, "204"), new C6616b(C6616b.f17329e, "206"), new C6616b(C6616b.f17329e, "304"), new C6616b(C6616b.f17329e, "400"), new C6616b(C6616b.f17329e, "404"), new C6616b(C6616b.f17329e, "500"), new C6616b("accept-charset", ""), new C6616b("accept-encoding", "gzip, deflate"), new C6616b("accept-language", ""), new C6616b("accept-ranges", ""), new C6616b("accept", ""), new C6616b("access-control-allow-origin", ""), new C6616b("age", ""), new C6616b("allow", ""), new C6616b("authorization", ""), new C6616b("cache-control", ""), new C6616b("content-disposition", ""), new C6616b("content-encoding", ""), new C6616b("content-language", ""), new C6616b("content-length", ""), new C6616b("content-location", ""), new C6616b("content-range", ""), new C6616b("content-type", ""), new C6616b((String) CookieDBAdapter.CookieColumns.TABLE_NAME, ""), new C6616b("date", ""), new C6616b("etag", ""), new C6616b("expect", ""), new C6616b("expires", ""), new C6616b("from", ""), new C6616b("host", ""), new C6616b("if-match", ""), new C6616b("if-modified-since", ""), new C6616b("if-none-match", ""), new C6616b("if-range", ""), new C6616b("if-unmodified-since", ""), new C6616b("last-modified", ""), new C6616b("link", ""), new C6616b((String) PlaceFields.LOCATION, ""), new C6616b("max-forwards", ""), new C6616b("proxy-authenticate", ""), new C6616b("proxy-authorization", ""), new C6616b("range", ""), new C6616b("referer", ""), new C6616b("refresh", ""), new C6616b("retry-after", ""), new C6616b("server", ""), new C6616b("set-cookie", ""), new C6616b("strict-transport-security", ""), new C6616b("transfer-encoding", ""), new C6616b("user-agent", ""), new C6616b("vary", ""), new C6616b("via", ""), new C6616b("www-authenticate", "")};

    /* renamed from: b */
    static final Map<C3581f, Integer> f17338b = m21745a();

    /* renamed from: okhttp3.internal.http2.c$a */
    /* compiled from: Hpack */
    static final class C6619a {

        /* renamed from: a */
        private final List<C6616b> f17339a;

        /* renamed from: b */
        private final C3580e f17340b;

        /* renamed from: c */
        private final int f17341c;

        /* renamed from: d */
        private int f17342d;

        /* renamed from: e */
        C6616b[] f17343e;

        /* renamed from: f */
        int f17344f;

        /* renamed from: g */
        int f17345g;

        /* renamed from: h */
        int f17346h;

        C6619a(int i, C3586u uVar) {
            this(i, i, uVar);
        }

        /* renamed from: b */
        private int m21748b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f17343e.length;
                while (true) {
                    length--;
                    if (length < this.f17344f || i <= 0) {
                        C6616b[] bVarArr = this.f17343e;
                        int i3 = this.f17344f;
                        System.arraycopy(bVarArr, i3 + 1, bVarArr, i3 + 1 + i2, this.f17345g);
                        this.f17344f += i2;
                    } else {
                        C6616b[] bVarArr2 = this.f17343e;
                        i -= bVarArr2[length].f17336c;
                        this.f17346h -= bVarArr2[length].f17336c;
                        this.f17345g--;
                        i2++;
                    }
                }
                C6616b[] bVarArr3 = this.f17343e;
                int i32 = this.f17344f;
                System.arraycopy(bVarArr3, i32 + 1, bVarArr3, i32 + 1 + i2, this.f17345g);
                this.f17344f += i2;
            }
            return i2;
        }

        /* renamed from: d */
        private void m21750d() {
            int i = this.f17342d;
            int i2 = this.f17346h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m21752e();
            } else {
                m21748b(i2 - i);
            }
        }

        /* renamed from: e */
        private void m21752e() {
            Arrays.fill(this.f17343e, (Object) null);
            this.f17344f = this.f17343e.length - 1;
            this.f17345g = 0;
            this.f17346h = 0;
        }

        /* renamed from: f */
        private void m21755f(int i) throws IOException {
            m21747a(-1, new C6616b(m21749c(i), mo35677b()));
        }

        /* renamed from: g */
        private void m21757g(int i) throws IOException {
            this.f17339a.add(new C6616b(m21749c(i), mo35677b()));
        }

        /* renamed from: h */
        private void m21758h() throws IOException {
            C3581f b = mo35677b();
            C6618c.m21744a(b);
            this.f17339a.add(new C6616b(b, mo35677b()));
        }

        /* renamed from: a */
        public List<C6616b> mo35676a() {
            ArrayList arrayList = new ArrayList(this.f17339a);
            this.f17339a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo35678c() throws IOException {
            while (!this.f17340b.mo19681H()) {
                byte readByte = this.f17340b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m21753e(mo35675a((int) readByte, (int) Notifications.NOTIFICATION_TYPES_ALL) - 1);
                } else if (readByte == 64) {
                    m21756g();
                } else if ((readByte & 64) == 64) {
                    m21755f(mo35675a((int) readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a = mo35675a((int) readByte, 31);
                    this.f17342d = a;
                    if (a < 0 || a > this.f17341c) {
                        throw new IOException("Invalid dynamic table size update " + this.f17342d);
                    }
                    m21750d();
                } else if (readByte == 16 || readByte == 0) {
                    m21758h();
                } else {
                    m21757g(mo35675a((int) readByte, 15) - 1);
                }
            }
        }

        C6619a(int i, int i2, C3586u uVar) {
            this.f17339a = new ArrayList();
            C6616b[] bVarArr = new C6616b[8];
            this.f17343e = bVarArr;
            this.f17344f = bVarArr.length - 1;
            this.f17345g = 0;
            this.f17346h = 0;
            this.f17341c = i;
            this.f17342d = i2;
            this.f17340b = C6589n.m21610a(uVar);
        }

        /* renamed from: a */
        private int m21746a(int i) {
            return this.f17344f + 1 + i;
        }

        /* renamed from: a */
        private void m21747a(int i, C6616b bVar) {
            this.f17339a.add(bVar);
            int i2 = bVar.f17336c;
            if (i != -1) {
                i2 -= this.f17343e[m21746a(i)].f17336c;
            }
            int i3 = this.f17342d;
            if (i2 > i3) {
                m21752e();
                return;
            }
            int b = m21748b((this.f17346h + i2) - i3);
            if (i == -1) {
                int i4 = this.f17345g + 1;
                C6616b[] bVarArr = this.f17343e;
                if (i4 > bVarArr.length) {
                    C6616b[] bVarArr2 = new C6616b[(bVarArr.length * 2)];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f17344f = this.f17343e.length - 1;
                    this.f17343e = bVarArr2;
                }
                int i5 = this.f17344f;
                this.f17344f = i5 - 1;
                this.f17343e[i5] = bVar;
                this.f17345g++;
            } else {
                this.f17343e[i + m21746a(i) + b] = bVar;
            }
            this.f17346h += i2;
        }

        /* renamed from: d */
        private boolean m21751d(int i) {
            return i >= 0 && i <= C6618c.f17337a.length - 1;
        }

        /* renamed from: f */
        private int m21754f() throws IOException {
            return this.f17340b.readByte() & 255;
        }

        /* renamed from: g */
        private void m21756g() throws IOException {
            C3581f b = mo35677b();
            C6618c.m21744a(b);
            m21747a(-1, new C6616b(b, mo35677b()));
        }

        /* renamed from: e */
        private void m21753e(int i) throws IOException {
            if (m21751d(i)) {
                this.f17339a.add(C6618c.f17337a[i]);
                return;
            }
            int a = m21746a(i - C6618c.f17337a.length);
            if (a >= 0) {
                C6616b[] bVarArr = this.f17343e;
                if (a < bVarArr.length) {
                    this.f17339a.add(bVarArr[a]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3581f mo35677b() throws IOException {
            int f = m21754f();
            boolean z = (f & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 128;
            int a = mo35675a(f, (int) Notifications.NOTIFICATION_TYPES_ALL);
            if (z) {
                return C3581f.m12174a(C6641j.m21881b().mo35740a(this.f17340b.mo19717k((long) a)));
            }
            return this.f17340b.mo19712h((long) a);
        }

        /* renamed from: c */
        private C3581f m21749c(int i) throws IOException {
            if (m21751d(i)) {
                return C6618c.f17337a[i].f17334a;
            }
            int a = m21746a(i - C6618c.f17337a.length);
            if (a >= 0) {
                C6616b[] bVarArr = this.f17343e;
                if (a < bVarArr.length) {
                    return bVarArr[a].f17334a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo35675a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int f = m21754f();
                if ((f & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0) {
                    return i2 + (f << i4);
                }
                i2 += (f & Notifications.NOTIFICATION_TYPES_ALL) << i4;
                i4 += 7;
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.c$b */
    /* compiled from: Hpack */
    static final class C6620b {

        /* renamed from: a */
        private final C3577c f17347a;

        /* renamed from: b */
        private final boolean f17348b;

        /* renamed from: c */
        private int f17349c;

        /* renamed from: d */
        private boolean f17350d;

        /* renamed from: e */
        int f17351e;

        /* renamed from: f */
        C6616b[] f17352f;

        /* renamed from: g */
        int f17353g;

        /* renamed from: h */
        int f17354h;

        /* renamed from: i */
        int f17355i;

        C6620b(C3577c cVar) {
            this(CodedOutputStream.DEFAULT_BUFFER_SIZE, true, cVar);
        }

        /* renamed from: a */
        private void m21764a(C6616b bVar) {
            int i = bVar.f17336c;
            int i2 = this.f17351e;
            if (i > i2) {
                m21766b();
                return;
            }
            m21765b((this.f17355i + i) - i2);
            int i3 = this.f17354h + 1;
            C6616b[] bVarArr = this.f17352f;
            if (i3 > bVarArr.length) {
                C6616b[] bVarArr2 = new C6616b[(bVarArr.length * 2)];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.f17353g = this.f17352f.length - 1;
                this.f17352f = bVarArr2;
            }
            int i4 = this.f17353g;
            this.f17353g = i4 - 1;
            this.f17352f[i4] = bVar;
            this.f17354h++;
            this.f17355i += i;
        }

        /* renamed from: b */
        private void m21766b() {
            Arrays.fill(this.f17352f, (Object) null);
            this.f17353g = this.f17352f.length - 1;
            this.f17354h = 0;
            this.f17355i = 0;
        }

        C6620b(int i, boolean z, C3577c cVar) {
            this.f17349c = Integer.MAX_VALUE;
            C6616b[] bVarArr = new C6616b[8];
            this.f17352f = bVarArr;
            this.f17353g = bVarArr.length - 1;
            this.f17354h = 0;
            this.f17355i = 0;
            this.f17351e = i;
            this.f17348b = z;
            this.f17347a = cVar;
        }

        /* renamed from: b */
        private int m21765b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f17352f.length;
                while (true) {
                    length--;
                    if (length < this.f17353g || i <= 0) {
                        C6616b[] bVarArr = this.f17352f;
                        int i3 = this.f17353g;
                        System.arraycopy(bVarArr, i3 + 1, bVarArr, i3 + 1 + i2, this.f17354h);
                        C6616b[] bVarArr2 = this.f17352f;
                        int i4 = this.f17353g;
                        Arrays.fill(bVarArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                        this.f17353g += i2;
                    } else {
                        C6616b[] bVarArr3 = this.f17352f;
                        i -= bVarArr3[length].f17336c;
                        this.f17355i -= bVarArr3[length].f17336c;
                        this.f17354h--;
                        i2++;
                    }
                }
                C6616b[] bVarArr4 = this.f17352f;
                int i32 = this.f17353g;
                System.arraycopy(bVarArr4, i32 + 1, bVarArr4, i32 + 1 + i2, this.f17354h);
                C6616b[] bVarArr22 = this.f17352f;
                int i42 = this.f17353g;
                Arrays.fill(bVarArr22, i42 + 1, i42 + 1 + i2, (Object) null);
                this.f17353g += i2;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo35682a(List<C6616b> list) throws IOException {
            int i;
            int i2;
            if (this.f17350d) {
                int i3 = this.f17349c;
                if (i3 < this.f17351e) {
                    mo35680a(i3, 31, 32);
                }
                this.f17350d = false;
                this.f17349c = Integer.MAX_VALUE;
                mo35680a(this.f17351e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C6616b bVar = list.get(i4);
                C3581f g = bVar.f17334a.mo19760g();
                C3581f fVar = bVar.f17335b;
                Integer num = C6618c.f17338b.get(g);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (C3500c.m11654a((Object) C6618c.f17337a[i2 - 1].f17335b, (Object) fVar)) {
                            i = i2;
                        } else if (C3500c.m11654a((Object) C6618c.f17337a[i2].f17335b, (Object) fVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f17353g + 1;
                    int length = this.f17352f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (C3500c.m11654a((Object) this.f17352f[i5].f17334a, (Object) g)) {
                            if (C3500c.m11654a((Object) this.f17352f[i5].f17335b, (Object) fVar)) {
                                i2 = C6618c.f17337a.length + (i5 - this.f17353g);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f17353g) + C6618c.f17337a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    mo35680a(i2, Notifications.NOTIFICATION_TYPES_ALL, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                } else if (i == -1) {
                    this.f17347a.writeByte(64);
                    mo35681a(g);
                    mo35681a(fVar);
                    m21764a(bVar);
                } else if (!g.mo19753b(C6616b.f17328d) || C6616b.f17333i.equals(g)) {
                    mo35680a(i, 63, 64);
                    mo35681a(fVar);
                    m21764a(bVar);
                } else {
                    mo35680a(i, 15, 0);
                    mo35681a(fVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo35680a(int i, int i2, int i3) {
            if (i < i2) {
                this.f17347a.writeByte(i | i3);
                return;
            }
            this.f17347a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f17347a.writeByte(128 | (i4 & Notifications.NOTIFICATION_TYPES_ALL));
                i4 >>>= 7;
            }
            this.f17347a.writeByte(i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo35681a(C3581f fVar) throws IOException {
            if (!this.f17348b || C6641j.m21881b().mo35738a(fVar) >= fVar.mo19759f()) {
                mo35680a(fVar.mo19759f(), Notifications.NOTIFICATION_TYPES_ALL, 0);
                this.f17347a.mo19694a(fVar);
                return;
            }
            C3577c cVar = new C3577c();
            C6641j.m21881b().mo35739a(fVar, cVar);
            C3581f u = cVar.mo19731u();
            mo35680a(u.mo19759f(), Notifications.NOTIFICATION_TYPES_ALL, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            this.f17347a.mo19694a(u);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo35679a(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f17351e;
            if (i2 != min) {
                if (min < i2) {
                    this.f17349c = Math.min(this.f17349c, min);
                }
                this.f17350d = true;
                this.f17351e = min;
                m21763a();
            }
        }

        /* renamed from: a */
        private void m21763a() {
            int i = this.f17351e;
            int i2 = this.f17355i;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m21766b();
            } else {
                m21765b(i2 - i);
            }
        }
    }

    /* renamed from: a */
    private static Map<C3581f, Integer> m21745a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f17337a.length);
        int i = 0;
        while (true) {
            C6616b[] bVarArr = f17337a;
            if (i >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i].f17334a)) {
                linkedHashMap.put(f17337a[i].f17334a, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* renamed from: a */
    static C3581f m21744a(C3581f fVar) throws IOException {
        int f = fVar.mo19759f();
        int i = 0;
        while (i < f) {
            byte a = fVar.mo19745a(i);
            if (a < 65 || a > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.mo19763i());
            }
        }
        return fVar;
    }
}
