package com.iab.omid.library.adcolony.adsession;

import android.view.View;
import com.iab.omid.library.adcolony.p146d.C4170e;
import com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C4170e.m13998a();
        C4170e.m14001a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C4170e.m14001a((Object) adSessionContext, "AdSessionContext is null");
        return new C4148a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    public abstract void error(ErrorType errorType, String str);

    public abstract void finish();

    public abstract String getAdSessionId();

    public abstract AdSessionStatePublisher getAdSessionStatePublisher();

    public abstract void registerAdView(View view);

    public abstract void removeAllFriendlyObstructions();

    public abstract void removeFriendlyObstruction(View view);

    public abstract void start();
}
