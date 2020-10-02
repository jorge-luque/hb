package p113i.p114e0.p116f;

import java.io.IOException;
import java.net.ProtocolException;
import p113i.C5972w;

/* renamed from: i.e0.f.k */
/* compiled from: StatusLine */
public final class C5945k {

    /* renamed from: a */
    public final C5972w f15198a;

    /* renamed from: b */
    public final int f15199b;

    /* renamed from: c */
    public final String f15200c;

    public C5945k(C5972w wVar, int i, String str) {
        this.f15198a = wVar;
        this.f15199b = i;
        this.f15200c = str;
    }

    /* renamed from: a */
    public static C5945k m19069a(String str) throws IOException {
        C5972w wVar;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                wVar = C5972w.HTTP_1_0;
            } else if (charAt == 1) {
                wVar = C5972w.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            wVar = C5972w.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new C5945k(wVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15198a == C5972w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f15199b);
        if (this.f15200c != null) {
            sb.append(' ');
            sb.append(this.f15200c);
        }
        return sb.toString();
    }
}
