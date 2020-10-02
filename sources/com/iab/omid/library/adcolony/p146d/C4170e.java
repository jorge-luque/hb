package com.iab.omid.library.adcolony.p146d;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.adsession.CreativeType;
import com.iab.omid.library.adcolony.adsession.ImpressionType;
import com.iab.omid.library.adcolony.adsession.Owner;

/* renamed from: com.iab.omid.library.adcolony.d.e */
public class C4170e {
    /* renamed from: a */
    public static void m13998a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m13999a(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: a */
    public static void m14000a(C4148a aVar) {
        if (aVar.mo28475f()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m14001a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m14002a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m14003a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m14004b(C4148a aVar) {
        if (aVar.mo28476g()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m14005c(C4148a aVar) {
        m14010h(aVar);
        m14004b(aVar);
    }

    /* renamed from: d */
    public static void m14006d(C4148a aVar) {
        if (aVar.getAdSessionStatePublisher().mo28566c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m14007e(C4148a aVar) {
        if (aVar.getAdSessionStatePublisher().mo28567d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m14008f(C4148a aVar) {
        if (!aVar.mo28477h()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m14009g(C4148a aVar) {
        if (!aVar.mo28478i()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m14010h(C4148a aVar) {
        if (!aVar.mo28475f()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
