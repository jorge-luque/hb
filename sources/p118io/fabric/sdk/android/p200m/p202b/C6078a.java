package p118io.fabric.sdk.android.p200m.p202b;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: io.fabric.sdk.android.m.b.a */
/* compiled from: AbstractSpiCall */
public abstract class C6078a {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final int DEFAULT_TIMEOUT = 10000;
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final C6069h kit;
    private final C6199c method;
    private final String protocolAndHostOverride;
    private final C6200d requestFactory;
    private final String url;

    public C6078a(C6069h hVar, String str, String str2, C6200d dVar, C6199c cVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (dVar != null) {
            this.kit = hVar;
            this.protocolAndHostOverride = str;
            this.url = overrideProtocolAndHost(str2);
            this.requestFactory = dVar;
            this.method = cVar;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    private String overrideProtocolAndHost(String str) {
        return !C6090i.m19743b(this.protocolAndHostOverride) ? PROTOCOL_AND_HOST_PATTERN.matcher(str).replaceFirst(this.protocolAndHostOverride) : str;
    }

    /* access modifiers changed from: protected */
    public HttpRequest getHttpRequest() {
        return getHttpRequest(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public HttpRequest getHttpRequest(Map<String, String> map) {
        HttpRequest a = this.requestFactory.mo34369a(this.method, getUrl(), map);
        a.mo34334a(false);
        a.mo34323a((int) DEFAULT_TIMEOUT);
        a.mo34341c(HEADER_USER_AGENT, CRASHLYTICS_USER_AGENT + this.kit.getVersion());
        a.mo34341c(HEADER_DEVELOPER_TOKEN, CLS_ANDROID_SDK_DEVELOPER_TOKEN);
        return a;
    }
}
