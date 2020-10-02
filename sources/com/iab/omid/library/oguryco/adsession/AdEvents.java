package com.iab.omid.library.oguryco.adsession;

import com.iab.omid.library.oguryco.adsession.media.VastProperties;
import com.iab.omid.library.oguryco.p152d.C4221e;

public final class AdEvents {
    private final C4199a adSession;

    private AdEvents(C4199a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        C4199a aVar = (C4199a) adSession2;
        C4221e.m14230a((Object) adSession2, "AdSession is null");
        C4221e.m14235d(aVar);
        C4221e.m14233b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo28767a(adEvents);
        return adEvents;
    }

    public final void impressionOccurred() {
        C4221e.m14233b(this.adSession);
        C4221e.m14237f(this.adSession);
        if (!this.adSession.mo28664e()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.mo28664e()) {
            this.adSession.mo28661b();
        }
    }

    public final void loaded() {
        C4221e.m14234c(this.adSession);
        C4221e.m14237f(this.adSession);
        this.adSession.mo28662c();
    }

    public final void loaded(VastProperties vastProperties) {
        C4221e.m14234c(this.adSession);
        C4221e.m14237f(this.adSession);
        this.adSession.mo28660a(vastProperties.mo28686a());
    }
}
