package p093e.p094a.p095a;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import com.loopj.android.http.C4250c;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: e.a.a.p0 */
/* compiled from: PackageFactory */
public class C3324p0 {
    /* renamed from: a */
    public static C3276c m11057a(String str, long j, C3294d dVar, C3301g gVar, C3345t tVar, C3361w0 w0Var) {
        String str2 = "malformed";
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(str, C4250c.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C3309k.m11002d().mo19022c("Referrer decoding failed due to UnsupportedEncodingException. Message: (%s)", e.getMessage());
        } catch (IllegalArgumentException e2) {
            C3309k.m11002d().mo19022c("Referrer decoding failed due to IllegalArgumentException. Message: (%s)", e2.getMessage());
        } catch (Exception e3) {
            C3309k.m11002d().mo19022c("Referrer decoding failed. Message: (%s)", e3.getMessage());
        }
        C3309k.m11002d().mo19024e("Referrer to parse (%s)", str2);
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.parseQuery(str2);
        C3321o0 a = m11058a(urlQuerySanitizer.getParameterList(), dVar, gVar, tVar, w0Var);
        if (a == null) {
            return null;
        }
        a.f9294k = str2;
        a.f9290g = j;
        a.f9295l = str;
        return a.mo19056b("reftag");
    }

    /* renamed from: a */
    public static C3276c m11055a(Uri uri, long j, C3294d dVar, C3301g gVar, C3345t tVar, C3361w0 w0Var) {
        String uri2;
        if (uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0) {
            return null;
        }
        C3309k.m11002d().mo19024e("Url to parse (%s)", uri);
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.parseUrl(uri2);
        C3321o0 a = m11058a(urlQuerySanitizer.getParameterList(), dVar, gVar, tVar, w0Var);
        if (a == null) {
            return null;
        }
        a.f9293j = uri.toString();
        a.f9290g = j;
        return a.mo19056b("deeplink");
    }

    /* renamed from: a */
    public static C3276c m11056a(String str, long j, long j2, C3294d dVar, C3301g gVar, C3345t tVar, C3361w0 w0Var) {
        String str2 = str;
        if (str2 == null || str.length() == 0) {
            return null;
        }
        C3321o0 o0Var = new C3321o0(gVar, tVar, dVar, w0Var, System.currentTimeMillis());
        o0Var.f9294k = str2;
        o0Var.f9289f = j;
        o0Var.f9291h = j2;
        return o0Var.mo19056b("install_referrer");
    }

    /* renamed from: a */
    private static C3321o0 m11058a(List<UrlQuerySanitizer.ParameterValuePair> list, C3294d dVar, C3301g gVar, C3345t tVar, C3361w0 w0Var) {
        if (list == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C3299f fVar = new C3299f();
        for (UrlQuerySanitizer.ParameterValuePair next : list) {
            m11060a(next.mParameter, next.mValue, linkedHashMap, fVar);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = (String) linkedHashMap.remove("reftag");
        if (dVar != null) {
            dVar.f9156k = currentTimeMillis - dVar.f9155j;
        }
        C3321o0 o0Var = new C3321o0(gVar, tVar, dVar, w0Var, currentTimeMillis);
        o0Var.f9297n = linkedHashMap;
        o0Var.f9296m = fVar;
        o0Var.f9292i = str;
        return o0Var;
    }

    /* renamed from: a */
    private static boolean m11060a(String str, String str2, Map<String, String> map, C3299f fVar) {
        if (str == null || str2 == null || !str.startsWith("adjust_")) {
            return false;
        }
        String substring = str.substring(7);
        if (substring.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (m11059a(fVar, substring, str2)) {
            return true;
        }
        map.put(substring, str2);
        return true;
    }

    /* renamed from: a */
    private static boolean m11059a(C3299f fVar, String str, String str2) {
        if (str.equals("tracker")) {
            fVar.f9176b = str2;
            return true;
        } else if (str.equals("campaign")) {
            fVar.f9178d = str2;
            return true;
        } else if (str.equals("adgroup")) {
            fVar.f9179e = str2;
            return true;
        } else if (!str.equals(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE)) {
            return false;
        } else {
            fVar.f9180f = str2;
            return true;
        }
    }
}
