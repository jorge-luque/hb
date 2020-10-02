package com.miniclip.utils;

public class NativeRunnable implements Runnable {

    /* renamed from: id */
    private long f11469id = 0;

    public NativeRunnable(long j) {
        this.f11469id = j;
    }

    private static native void runNative(long j);

    public void run() {
        runNative(this.f11469id);
    }
}
