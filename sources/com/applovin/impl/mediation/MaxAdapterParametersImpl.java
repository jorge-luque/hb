package com.applovin.impl.mediation;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.mediation.p045b.C1704g;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a */
    private Bundle f5101a;

    /* renamed from: b */
    private boolean f5102b;

    /* renamed from: c */
    private boolean f5103c;

    /* renamed from: d */
    private boolean f5104d;

    /* renamed from: e */
    private boolean f5105e;

    /* renamed from: f */
    private String f5106f;

    /* renamed from: g */
    private String f5107g;

    /* renamed from: h */
    private MaxAdFormat f5108h;

    private MaxAdapterParametersImpl() {
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m6241a(C1697a aVar, Context context) {
        MaxAdapterParametersImpl a = m6242a((C1701e) aVar, context);
        a.f5106f = aVar.mo7769e();
        a.f5107g = aVar.mo7768d();
        return a;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m6242a(C1701e eVar, Context context) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f5102b = eVar.mo7827a(context);
        maxAdapterParametersImpl.f5103c = eVar.mo7835b(context);
        maxAdapterParametersImpl.f5104d = eVar.mo7839c(context);
        maxAdapterParametersImpl.f5101a = eVar.mo7817I();
        maxAdapterParametersImpl.f5105e = eVar.mo7815G();
        return maxAdapterParametersImpl;
    }

    /* renamed from: a */
    static MaxAdapterParametersImpl m6243a(C1704g gVar, MaxAdFormat maxAdFormat, Context context) {
        MaxAdapterParametersImpl a = m6242a((C1701e) gVar, context);
        a.f5108h = maxAdFormat;
        return a;
    }

    public MaxAdFormat getAdFormat() {
        return this.f5108h;
    }

    public String getBidResponse() {
        return this.f5107g;
    }

    public Bundle getServerParameters() {
        return this.f5101a;
    }

    public String getThirdPartyAdPlacementId() {
        return this.f5106f;
    }

    public boolean hasUserConsent() {
        return this.f5102b;
    }

    public boolean isAgeRestrictedUser() {
        return this.f5103c;
    }

    public boolean isDoNotSell() {
        return this.f5104d;
    }

    public boolean isTesting() {
        return this.f5105e;
    }
}
