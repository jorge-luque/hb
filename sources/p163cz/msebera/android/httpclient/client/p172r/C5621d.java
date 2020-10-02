package p163cz.msebera.android.httpclient.client.p172r;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.client.r.d */
/* compiled from: URIUtils */
public class C5621d {
    /* renamed from: a */
    public static URI m17893a(URI uri, C5896l lVar, boolean z) throws URISyntaxException {
        C5886a.m18894a(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        C5620c cVar = new C5620c(uri);
        if (lVar != null) {
            cVar.mo32997d(lVar.mo33688d());
            cVar.mo32994b(lVar.mo33685b());
            cVar.mo32988a(lVar.mo33686c());
        } else {
            cVar.mo32997d((String) null);
            cVar.mo32994b((String) null);
            cVar.mo32988a(-1);
        }
        if (z) {
            cVar.mo32989a((String) null);
        }
        if (C5894i.m18944c(cVar.mo32998d())) {
            cVar.mo32995c("/");
        }
        return cVar.mo32992a();
    }

    /* renamed from: b */
    private static URI m17896b(URI uri, URI uri2) {
        String uri3 = uri.toString();
        if (uri3.indexOf(63) > -1) {
            uri3 = uri3.substring(0, uri3.indexOf(63));
        }
        return URI.create(uri3 + uri2.toString());
    }

    /* renamed from: c */
    public static URI m17897c(URI uri) throws URISyntaxException {
        C5886a.m18894a(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        C5620c cVar = new C5620c(uri);
        if (cVar.mo33001f() != null) {
            cVar.mo32999e((String) null);
        }
        if (C5894i.m18944c(cVar.mo32998d())) {
            cVar.mo32995c("/");
        }
        if (cVar.mo32996c() != null) {
            cVar.mo32994b(cVar.mo32996c().toLowerCase(Locale.ROOT));
        }
        cVar.mo32989a((String) null);
        return cVar.mo32992a();
    }

    /* renamed from: b */
    private static URI m17895b(URI uri) {
        if (uri.isOpaque() || uri.getAuthority() == null) {
            return uri;
        }
        C5886a.m18896a(uri.isAbsolute(), "Base URI must be absolute");
        String path = uri.getPath() == null ? "" : uri.getPath();
        String[] split = path.split("/");
        Stack stack = new Stack();
        for (String str : split) {
            if (!str.isEmpty() && !".".equals(str)) {
                if (!"..".equals(str)) {
                    stack.push(str);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            sb.append('/');
            sb.append((String) it.next());
        }
        if (path.lastIndexOf(47) == path.length() - 1) {
            sb.append('/');
        }
        try {
            URI uri2 = new URI(uri.getScheme().toLowerCase(Locale.ROOT), uri.getAuthority().toLowerCase(Locale.ROOT), sb.toString(), (String) null, (String) null);
            if (uri.getQuery() == null && uri.getFragment() == null) {
                return uri2;
            }
            StringBuilder sb2 = new StringBuilder(uri2.toASCIIString());
            if (uri.getQuery() != null) {
                sb2.append('?');
                sb2.append(uri.getRawQuery());
            }
            if (uri.getFragment() != null) {
                sb2.append('#');
                sb2.append(uri.getRawFragment());
            }
            return URI.create(sb2.toString());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public static URI m17894a(URI uri, URI uri2) {
        C5886a.m18894a(uri, "Base URI");
        C5886a.m18894a(uri2, "Reference URI");
        String uri3 = uri2.toString();
        if (uri3.startsWith("?")) {
            return m17896b(uri, uri2);
        }
        boolean isEmpty = uri3.isEmpty();
        if (isEmpty) {
            uri2 = URI.create("#");
        }
        URI resolve = uri.resolve(uri2);
        if (isEmpty) {
            String uri4 = resolve.toString();
            resolve = URI.create(uri4.substring(0, uri4.indexOf(35)));
        }
        return m17895b(resolve);
    }

    /* renamed from: a */
    public static C5896l m17892a(URI uri) {
        int indexOf;
        if (uri == null || !uri.isAbsolute()) {
            return null;
        }
        int port = uri.getPort();
        String host = uri.getHost();
        if (host == null && (host = uri.getAuthority()) != null) {
            int indexOf2 = host.indexOf(64);
            if (indexOf2 >= 0) {
                int i = indexOf2 + 1;
                host = host.length() > i ? host.substring(i) : null;
            }
            if (host != null && (indexOf = host.indexOf(58)) >= 0) {
                int i2 = indexOf + 1;
                int i3 = i2;
                int i4 = 0;
                while (i3 < host.length() && Character.isDigit(host.charAt(i3))) {
                    i4++;
                    i3++;
                }
                if (i4 > 0) {
                    try {
                        port = Integer.parseInt(host.substring(i2, i4 + i2));
                    } catch (NumberFormatException unused) {
                    }
                }
                host = host.substring(0, indexOf);
            }
        }
        String scheme = uri.getScheme();
        if (C5894i.m18943b(host)) {
            return null;
        }
        try {
            return new C5896l(host, port, scheme);
        } catch (IllegalArgumentException unused2) {
            return null;
        }
    }
}
