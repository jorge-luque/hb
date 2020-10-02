package com.criteo.publisher;

/* renamed from: com.criteo.publisher.h */
public class C2386h extends IllegalStateException {
    public C2386h(String str) {
        super(str + "\nDid you initialize the Criteo SDK ?\nPlease follow this step: https://publisherdocs.criteotilt.com/app/android/standalone/#sdk-initialization\n");
    }
}
