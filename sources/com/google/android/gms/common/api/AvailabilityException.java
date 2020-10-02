package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import p075d.p080b.C3191a;

public class AvailabilityException extends Exception {
    private final C3191a<zai<?>, ConnectionResult> zaay;

    public AvailabilityException(C3191a<zai<?>, ConnectionResult> aVar) {
        this.zaay = aVar;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        zai<? extends Api.ApiOptions> zak = googleApi.zak();
        Preconditions.checkArgument(this.zaay.get(zak) != null, "The given API was not part of the availability request.");
        return this.zaay.get(zak);
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zai next : this.zaay.keySet()) {
            ConnectionResult connectionResult = this.zaay.get(next);
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String zan = next.zan();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(zan).length() + 2 + String.valueOf(valueOf).length());
            sb.append(zan);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final C3191a<zai<?>, ConnectionResult> zaj() {
        return this.zaay;
    }
}
