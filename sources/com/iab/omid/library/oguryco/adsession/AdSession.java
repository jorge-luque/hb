package com.iab.omid.library.oguryco.adsession;

import android.view.View;
import com.iab.omid.library.oguryco.p152d.C4221e;
import com.iab.omid.library.oguryco.publisher.AdSessionStatePublisher;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C4221e.m14227a();
        C4221e.m14230a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C4221e.m14230a((Object) adSessionContext, "AdSessionContext is null");
        return new C4199a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view);

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
