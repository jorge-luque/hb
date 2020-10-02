package admost.adserver.videocache.p001q;

import admost.adserver.videocache.C0081m;
import android.text.TextUtils;

/* renamed from: admost.adserver.videocache.q.f */
/* compiled from: Md5FileNameGenerator */
public class C0093f implements C0087c {
    /* renamed from: b */
    private String m281b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    /* renamed from: a */
    public String mo150a(String str) {
        String b = m281b(str);
        String a = C0081m.m251a(str);
        if (TextUtils.isEmpty(b)) {
            return a;
        }
        return a + "." + b;
    }
}
