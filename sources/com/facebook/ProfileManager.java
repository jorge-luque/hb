package com.facebook;

import android.content.Intent;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import p075d.p090g.p091a.C3218a;

public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final C3218a localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(C3218a aVar, ProfileCache profileCache2) {
        Validate.notNull(aVar, "localBroadcastManager");
        Validate.notNull(profileCache2, "profileCache");
        this.localBroadcastManager = aVar;
        this.profileCache = profileCache2;
    }

    static ProfileManager getInstance() {
        if (instance == null) {
            synchronized (ProfileManager.class) {
                if (instance == null) {
                    instance = new ProfileManager(C3218a.m10641a(FacebookSdk.getApplicationContext()), new ProfileCache());
                }
            }
        }
        return instance;
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.mo18872a(intent);
    }

    /* access modifiers changed from: package-private */
    public Profile getCurrentProfile() {
        return this.currentProfile;
    }

    /* access modifiers changed from: package-private */
    public boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }
}
