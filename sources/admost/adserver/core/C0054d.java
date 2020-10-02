package admost.adserver.core;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.Map;

/* renamed from: admost.adserver.core.d */
/* compiled from: AdMostInputStreamVolleyRequest */
public class C0054d extends Request<byte[]> {

    /* renamed from: a */
    private final Response.Listener<byte[]> f155a;

    /* renamed from: b */
    private Map<String, String> f156b;

    public C0054d(int i, String str, Response.Listener<byte[]> listener, Response.ErrorListener errorListener, HashMap<String, String> hashMap) {
        super(i, str, errorListener);
        setShouldCache(false);
        this.f155a = listener;
        this.f156b = hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(byte[] bArr) {
        this.f155a.onResponse(bArr);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getParams() throws AuthFailureError {
        return this.f156b;
    }

    /* access modifiers changed from: protected */
    public Response<byte[]> parseNetworkResponse(NetworkResponse networkResponse) {
        Map<String, String> map = networkResponse.headers;
        return Response.success(networkResponse.data, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
