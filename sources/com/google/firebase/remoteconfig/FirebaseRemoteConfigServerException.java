package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {

    /* renamed from: a */
    private final int f10572a;

    public FirebaseRemoteConfigServerException(int i, String str) {
        super(str);
        this.f10572a = i;
    }

    /* renamed from: a */
    public int mo27540a() {
        return this.f10572a;
    }

    public FirebaseRemoteConfigServerException(int i, String str, Throwable th) {
        super(str, th);
        this.f10572a = i;
    }
}
