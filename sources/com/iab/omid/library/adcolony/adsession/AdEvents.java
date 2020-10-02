package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.adsession.media.VastProperties;
import com.iab.omid.library.adcolony.p146d.C4170e;

public final class AdEvents {

    /* renamed from: a */
    private final C4148a f11113a;

    private AdEvents(C4148a aVar) {
        this.f11113a = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession) {
        C4148a aVar = (C4148a) adSession;
        C4170e.m14001a((Object) adSession, "AdSession is null");
        C4170e.m14006d(aVar);
        C4170e.m14004b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo28553a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C4170e.m14004b(this.f11113a);
        C4170e.m14008f(this.f11113a);
        if (!this.f11113a.mo28474e()) {
            try {
                this.f11113a.start();
            } catch (Exception unused) {
            }
        }
        if (this.f11113a.mo28474e()) {
            this.f11113a.mo28471b();
        }
    }

    public void loaded() {
        C4170e.m14005c(this.f11113a);
        C4170e.m14008f(this.f11113a);
        this.f11113a.mo28472c();
    }

    public void loaded(VastProperties vastProperties) {
        C4170e.m14001a((Object) vastProperties, "VastProperties is null");
        C4170e.m14005c(this.f11113a);
        C4170e.m14008f(this.f11113a);
        this.f11113a.mo28470a(vastProperties.mo28495a());
    }
}
