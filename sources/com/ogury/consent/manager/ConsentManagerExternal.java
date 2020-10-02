package com.ogury.consent.manager;

import android.content.Context;
import com.ogury.p159cm.OguryChoiceManagerExternal;
import com.ogury.p159cm.accbb;

public final class ConsentManagerExternal {

    /* renamed from: a */
    public static final ConsentManagerExternal f12186a = new ConsentManagerExternal();

    private ConsentManagerExternal() {
    }

    public static final void setConsent(Context context, String str, String str2, String[] strArr) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(str2, "iabString");
        OguryChoiceManagerExternal.TcfV1.setConsent(context, str, str2, strArr);
    }
}
