package p163cz.msebera.android.httpclient.cookie;

import java.util.List;
import p163cz.msebera.android.httpclient.C5691d;

/* renamed from: cz.msebera.android.httpclient.cookie.h */
/* compiled from: CookieSpec */
public interface C5684h {
    /* renamed from: a */
    C5691d mo33143a();

    /* renamed from: a */
    List<C5679c> mo33144a(C5691d dVar, C5682f fVar) throws MalformedCookieException;

    /* renamed from: a */
    List<C5691d> mo33145a(List<C5679c> list);

    /* renamed from: a */
    void mo33146a(C5679c cVar, C5682f fVar) throws MalformedCookieException;

    /* renamed from: b */
    boolean mo33147b(C5679c cVar, C5682f fVar);

    int getVersion();
}
