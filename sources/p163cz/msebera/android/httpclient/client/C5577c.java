package p163cz.msebera.android.httpclient.client;

import java.util.Map;
import java.util.Queue;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.auth.C5547a;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: cz.msebera.android.httpclient.client.c */
/* compiled from: AuthenticationStrategy */
public interface C5577c {
    /* renamed from: a */
    Map<String, C5691d> mo32913a(C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException;

    /* renamed from: a */
    Queue<C5547a> mo32914a(Map<String, C5691d> map, C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException;

    /* renamed from: a */
    void mo32915a(C5896l lVar, C5549c cVar, C5875e eVar);

    /* renamed from: b */
    void mo32916b(C5896l lVar, C5549c cVar, C5875e eVar);

    /* renamed from: b */
    boolean mo32917b(C5896l lVar, C5901q qVar, C5875e eVar);
}
