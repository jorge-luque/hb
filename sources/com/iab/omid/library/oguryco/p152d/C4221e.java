package com.iab.omid.library.oguryco.p152d;

import android.text.TextUtils;
import com.iab.omid.library.oguryco.Omid;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.adsession.CreativeType;
import com.iab.omid.library.oguryco.adsession.ImpressionType;
import com.iab.omid.library.oguryco.adsession.Owner;

/* renamed from: com.iab.omid.library.oguryco.d.e */
public class C4221e {
    /* renamed from: a */
    public static void m14227a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m14228a(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: a */
    public static void m14229a(C4199a aVar) {
        if (aVar.mo28665f()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m14230a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m14231a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m14232a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m14233b(C4199a aVar) {
        if (aVar.mo28666g()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m14234c(C4199a aVar) {
        m14239h(aVar);
        m14233b(aVar);
    }

    /* renamed from: d */
    public static void m14235d(C4199a aVar) {
        if (aVar.getAdSessionStatePublisher().mo28780c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m14236e(C4199a aVar) {
        if (aVar.getAdSessionStatePublisher().mo28781d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m14237f(C4199a aVar) {
        if (!aVar.mo28667h()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m14238g(C4199a aVar) {
        if (!aVar.mo28668i()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m14239h(C4199a aVar) {
        if (!aVar.mo28665f()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
