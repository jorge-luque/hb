package p163cz.msebera.android.httpclient.p178e0;

import admost.sdk.base.AdMost;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Locale;
import p163cz.msebera.android.httpclient.C5908w;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.d */
/* compiled from: EnglishReasonPhraseCatalog */
public class C5700d implements C5908w {

    /* renamed from: a */
    public static final C5700d f14722a = new C5700d();

    /* renamed from: b */
    private static final String[][] f14723b = {null, new String[3], new String[8], new String[8], new String[25], new String[8]};

    static {
        m18160a(200, "OK");
        m18160a(201, "Created");
        m18160a(202, "Accepted");
        m18160a(204, "No Content");
        m18160a((int) AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN, "Moved Permanently");
        m18160a((int) AdMost.AD_ERROR_TAG_PASSIVE, "Moved Temporarily");
        m18160a((int) AdMost.AD_ERROR_ZONE_TIMEOUT, "Not Modified");
        m18160a(400, "Bad Request");
        m18160a((int) AdMost.AD_ERROR_WATERFALL_EMPTY, "Unauthorized");
        m18160a((int) AdMost.AD_ERROR_NOT_CACHABLE, "Forbidden");
        m18160a(404, "Not Found");
        m18160a(500, "Internal Server Error");
        m18160a((int) AdMost.AD_ERROR_TOO_MANY_REQUEST, "Not Implemented");
        m18160a(502, "Bad Gateway");
        m18160a(503, "Service Unavailable");
        m18160a(100, "Continue");
        m18160a(307, "Temporary Redirect");
        m18160a(405, "Method Not Allowed");
        m18160a(409, "Conflict");
        m18160a((int) FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, "Precondition Failed");
        m18160a(413, "Request Too Long");
        m18160a(414, "Request-URI Too Long");
        m18160a(415, "Unsupported Media Type");
        m18160a((int) AdMost.AD_ERROR_FREQ_CAP, "Multiple Choices");
        m18160a((int) AdMost.AD_ERROR_ZONE_PASSIVE, "See Other");
        m18160a((int) AdMost.AD_ERROR_FAILED_TO_SHOW, "Use Proxy");
        m18160a((int) AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID, "Payment Required");
        m18160a(406, "Not Acceptable");
        m18160a(407, "Proxy Authentication Required");
        m18160a(408, "Request Timeout");
        m18160a(101, "Switching Protocols");
        m18160a(203, "Non Authoritative Information");
        m18160a(205, "Reset Content");
        m18160a(206, "Partial Content");
        m18160a(504, "Gateway Timeout");
        m18160a(505, "Http Version Not Supported");
        m18160a(410, "Gone");
        m18160a(411, "Length Required");
        m18160a(416, "Requested Range Not Satisfiable");
        m18160a(417, "Expectation Failed");
        m18160a(102, "Processing");
        m18160a(207, "Multi-Status");
        m18160a(422, "Unprocessable Entity");
        m18160a(419, "Insufficient Space On Resource");
        m18160a(420, "Method Failure");
        m18160a(423, "Locked");
        m18160a(507, "Insufficient Storage");
        m18160a(424, "Failed Dependency");
    }

    protected C5700d() {
    }

    /* renamed from: a */
    public String mo33201a(int i, Locale locale) {
        boolean z = i >= 100 && i < 600;
        C5886a.m18896a(z, "Unknown category for status code " + i);
        int i2 = i / 100;
        int i3 = i - (i2 * 100);
        String[][] strArr = f14723b;
        if (strArr[i2].length > i3) {
            return strArr[i2][i3];
        }
        return null;
    }

    /* renamed from: a */
    private static void m18160a(int i, String str) {
        int i2 = i / 100;
        f14723b[i2][i - (i2 * 100)] = str;
    }
}
