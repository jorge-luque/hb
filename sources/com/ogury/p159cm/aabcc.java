package com.ogury.p159cm;

import android.content.Context;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.ogury.cm.aabcc */
public abstract class aabcc {

    /* renamed from: a */
    private final aabcb f12013a;

    public aabcc(aabcb aabcb) {
        accbb.m15218b(aabcb, "requestScheduler");
        this.f12013a = aabcb;
    }

    /* renamed from: a */
    public final aabcb mo29421a() {
        return this.f12013a;
    }

    /* renamed from: a */
    public abstract void mo29422a(Context context, String str, CountDownLatch countDownLatch);
}
