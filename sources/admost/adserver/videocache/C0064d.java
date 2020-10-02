package admost.adserver.videocache;

import android.text.TextUtils;
import com.loopj.android.http.C4250c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: admost.adserver.videocache.d */
/* compiled from: GetRequest */
class C0064d {

    /* renamed from: d */
    private static final Pattern f175d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e */
    private static final Pattern f176e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f177a;

    /* renamed from: b */
    public final long f178b;

    /* renamed from: c */
    public final boolean f179c;

    public C0064d(String str) {
        C0077k.m231a(str);
        long a = m170a(str);
        this.f178b = Math.max(0, a);
        this.f179c = a >= 0;
        this.f177a = m172b(str);
    }

    /* renamed from: a */
    public static C0064d m171a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C4250c.DEFAULT_CHARSET));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C0064d(sb.toString());
            }
            sb.append(readLine);
            sb.append(10);
        }
    }

    /* renamed from: b */
    private String m172b(String str) {
        Matcher matcher = f176e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f178b + ", partial=" + this.f179c + ", uri='" + this.f177a + '\'' + '}';
    }

    /* renamed from: a */
    private long m170a(String str) {
        Matcher matcher = f175d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1;
    }
}
