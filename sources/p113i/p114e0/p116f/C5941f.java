package p113i.p114e0.p116f;

import com.android.volley.toolbox.HttpClientStack;

/* renamed from: i.e0.f.f */
/* compiled from: HttpMethod */
public final class C5941f {
    /* renamed from: a */
    public static boolean m19041a(String str) {
        return str.equals("POST") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m19042b(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    /* renamed from: c */
    public static boolean m19043c(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m19044d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m19045e(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
