package com.google.zxing.p137i;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4069e;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.Map;

/* renamed from: com.google.zxing.i.o */
/* compiled from: UPCAWriter */
public final class C4112o implements C4069e {

    /* renamed from: a */
    private final C4107j f11020a = new C4107j();

    /* renamed from: a */
    public C4080b mo28289a(String str, C4061a aVar, int i, int i2, Map<C4063c, ?> map) throws WriterException {
        if (aVar == C4061a.UPC_A) {
            return this.f11020a.mo28289a(AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str)), C4061a.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
