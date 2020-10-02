package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
    }
}
