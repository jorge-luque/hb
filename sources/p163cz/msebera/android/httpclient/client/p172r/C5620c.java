package p163cz.msebera.android.httpclient.client.p172r;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.conn.p176t.C5676a;

/* renamed from: cz.msebera.android.httpclient.client.r.c */
/* compiled from: URIBuilder */
public class C5620c {

    /* renamed from: a */
    private String f14603a;

    /* renamed from: b */
    private String f14604b;

    /* renamed from: c */
    private String f14605c;

    /* renamed from: d */
    private String f14606d;

    /* renamed from: e */
    private String f14607e;

    /* renamed from: f */
    private String f14608f;

    /* renamed from: g */
    private int f14609g;

    /* renamed from: h */
    private String f14610h;

    /* renamed from: i */
    private String f14611i;

    /* renamed from: j */
    private String f14612j;

    /* renamed from: k */
    private List<C5906u> f14613k;

    /* renamed from: l */
    private String f14614l;

    /* renamed from: m */
    private Charset f14615m;

    /* renamed from: n */
    private String f14616n;

    /* renamed from: o */
    private String f14617o;

    public C5620c(URI uri) {
        m17871a(uri);
    }

    /* renamed from: b */
    private String m17872b(List<C5906u> list) {
        Charset charset = this.f14615m;
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return C5622e.m17899a((Iterable<? extends C5906u>) list, charset);
    }

    /* renamed from: f */
    private String m17873f(String str) {
        Charset charset = this.f14615m;
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return C5622e.m17905b(str, charset);
    }

    /* renamed from: g */
    private String m17874g() {
        StringBuilder sb = new StringBuilder();
        String str = this.f14603a;
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        String str2 = this.f14604b;
        if (str2 != null) {
            sb.append(str2);
        } else {
            if (this.f14605c != null) {
                sb.append("//");
                sb.append(this.f14605c);
            } else if (this.f14608f != null) {
                sb.append("//");
                String str3 = this.f14607e;
                if (str3 != null) {
                    sb.append(str3);
                    sb.append("@");
                } else {
                    String str4 = this.f14606d;
                    if (str4 != null) {
                        sb.append(m17876h(str4));
                        sb.append("@");
                    }
                }
                if (C5676a.m18080b(this.f14608f)) {
                    sb.append("[");
                    sb.append(this.f14608f);
                    sb.append("]");
                } else {
                    sb.append(this.f14608f);
                }
                if (this.f14609g >= 0) {
                    sb.append(":");
                    sb.append(this.f14609g);
                }
            }
            String str5 = this.f14611i;
            if (str5 != null) {
                sb.append(m17877i(str5));
            } else {
                String str6 = this.f14610h;
                if (str6 != null) {
                    sb.append(m17873f(m17877i(str6)));
                }
            }
            if (this.f14612j != null) {
                sb.append("?");
                sb.append(this.f14612j);
            } else if (this.f14613k != null) {
                sb.append("?");
                sb.append(m17872b(this.f14613k));
            } else if (this.f14614l != null) {
                sb.append("?");
                sb.append(m17875g(this.f14614l));
            }
        }
        if (this.f14617o != null) {
            sb.append("#");
            sb.append(this.f14617o);
        } else if (this.f14616n != null) {
            sb.append("#");
            sb.append(m17875g(this.f14616n));
        }
        return sb.toString();
    }

    /* renamed from: h */
    private String m17876h(String str) {
        Charset charset = this.f14615m;
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return C5622e.m17907d(str, charset);
    }

    /* renamed from: i */
    private static String m17877i(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    /* renamed from: a */
    public C5620c mo32990a(Charset charset) {
        this.f14615m = charset;
        return this;
    }

    /* renamed from: c */
    public C5620c mo32995c(String str) {
        this.f14610h = str;
        this.f14604b = null;
        this.f14611i = null;
        return this;
    }

    /* renamed from: d */
    public C5620c mo32997d(String str) {
        this.f14603a = str;
        return this;
    }

    /* renamed from: e */
    public C5620c mo32999e(String str) {
        this.f14606d = str;
        this.f14604b = null;
        this.f14605c = null;
        this.f14607e = null;
        return this;
    }

    public String toString() {
        return m17874g();
    }

    /* renamed from: a */
    private List<C5906u> m17870a(String str, Charset charset) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return C5622e.m17909f(str, charset);
    }

    /* renamed from: b */
    public C5620c mo32994b(String str) {
        this.f14608f = str;
        this.f14604b = null;
        this.f14605c = null;
        return this;
    }

    /* renamed from: d */
    public String mo32998d() {
        return this.f14610h;
    }

    /* renamed from: f */
    public String mo33001f() {
        return this.f14606d;
    }

    /* renamed from: a */
    public URI mo32992a() throws URISyntaxException {
        return new URI(m17874g());
    }

    /* renamed from: c */
    public String mo32996c() {
        return this.f14608f;
    }

    /* renamed from: a */
    private void m17871a(URI uri) {
        this.f14603a = uri.getScheme();
        this.f14604b = uri.getRawSchemeSpecificPart();
        this.f14605c = uri.getRawAuthority();
        this.f14608f = uri.getHost();
        this.f14609g = uri.getPort();
        this.f14607e = uri.getRawUserInfo();
        this.f14606d = uri.getUserInfo();
        this.f14611i = uri.getRawPath();
        this.f14610h = uri.getPath();
        this.f14612j = uri.getRawQuery();
        String rawQuery = uri.getRawQuery();
        Charset charset = this.f14615m;
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        this.f14613k = m17870a(rawQuery, charset);
        this.f14617o = uri.getRawFragment();
        this.f14616n = uri.getFragment();
    }

    /* renamed from: b */
    public C5620c mo32993b() {
        this.f14613k = null;
        this.f14612j = null;
        this.f14604b = null;
        return this;
    }

    /* renamed from: e */
    public List<C5906u> mo33000e() {
        if (this.f14613k != null) {
            return new ArrayList(this.f14613k);
        }
        return new ArrayList();
    }

    /* renamed from: a */
    public C5620c mo32988a(int i) {
        if (i < 0) {
            i = -1;
        }
        this.f14609g = i;
        this.f14604b = null;
        this.f14605c = null;
        return this;
    }

    /* renamed from: a */
    public C5620c mo32991a(List<C5906u> list) {
        if (this.f14613k == null) {
            this.f14613k = new ArrayList();
        }
        this.f14613k.addAll(list);
        this.f14612j = null;
        this.f14604b = null;
        this.f14614l = null;
        return this;
    }

    /* renamed from: a */
    public C5620c mo32989a(String str) {
        this.f14616n = str;
        this.f14617o = null;
        return this;
    }

    /* renamed from: g */
    private String m17875g(String str) {
        Charset charset = this.f14615m;
        if (charset == null) {
            charset = C5563b.f14520a;
        }
        return C5622e.m17906c(str, charset);
    }
}
