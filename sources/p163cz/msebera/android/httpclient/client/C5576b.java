package p163cz.msebera.android.httpclient.client;

import java.util.Map;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.b */
/* compiled from: AuthenticationHandler */
public interface C5576b {
    /* renamed from: a */
    C5549c mo32910a(Map<String, C5691d> map, C5901q qVar, C5875e eVar) throws AuthenticationException;

    /* renamed from: a */
    Map<String, C5691d> mo32911a(C5901q qVar, C5875e eVar) throws MalformedChallengeException;

    /* renamed from: b */
    boolean mo32912b(C5901q qVar, C5875e eVar);
}
