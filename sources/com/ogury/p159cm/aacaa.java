package com.ogury.p159cm;

import android.content.Context;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.ogury.cm.aacaa */
public final class aacaa extends aabcc {

    /* renamed from: com.ogury.cm.aacaa$aaaaa */
    static final class aaaaa extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ aacaa f12014a;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f12015b;

        /* renamed from: c */
        final /* synthetic */ Context f12016c;

        /* renamed from: d */
        final /* synthetic */ String f12017d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaaa(aacaa aacaa, CountDownLatch countDownLatch, Context context, String str) {
            super(0);
            this.f12014a = aacaa;
            this.f12015b = countDownLatch;
            this.f12016c = context;
            this.f12017d = str;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            this.f12015b.await();
            this.f12014a.mo29421a().mo29391a(this.f12016c, this.f12017d, this.f12015b);
            return acbba.f12137a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aacaa(aabcb aabcb) {
        super(aabcb);
        accbb.m15218b(aabcb, "requestScheduler");
    }

    /* renamed from: a */
    public final void mo29422a(Context context, String str, CountDownLatch countDownLatch) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "requestType");
        accbb.m15218b(countDownLatch, "countDownLatch");
        mo29421a().mo29392a(context, countDownLatch);
        acbca.m15204a(false, false, (ClassLoader) null, (String) null, 0, new aaaaa(this, countDownLatch, context, str), 31, (Object) null);
    }
}
