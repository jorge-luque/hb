package com.ogury.p159cm;

import android.content.Context;
import com.ogury.core.OguryError;

/* renamed from: com.ogury.cm.aaacc */
public abstract class aaacc {

    /* renamed from: a */
    private String f12000a = "";

    /* renamed from: b */
    private String f12001b = "";

    /* renamed from: c */
    private acbbb f12002c = new acbbb();

    /* renamed from: d */
    private aacba f12003d = aacba.f12030a;

    /* renamed from: e */
    private abaca f12004e = new abaca();

    /* renamed from: com.ogury.cm.aaacc$aaaaa */
    public static final class aaaaa implements aacac {

        /* renamed from: a */
        final /* synthetic */ aaacc f12005a;

        aaaaa(aaacc aaacc) {
            this.f12005a = aaacc;
        }

        /* renamed from: a */
        public final void mo29386a(String str) {
            accbb.m15218b(str, "aaid");
            aacca aacca = aacca.f12035a;
            aacca.m15037c().mo29544b(str);
            this.f12005a.mo29418c();
        }
    }

    /* renamed from: com.ogury.cm.aaacc$aaaab */
    public static final class aaaab implements aacbc {
        aaaab() {
        }

        /* renamed from: a */
        public final void mo29384a(OguryError oguryError) {
            accbb.m15218b(oguryError, "error");
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15047a("Error while setting consent! Error code: " + oguryError.getErrorCode() + ", Error message: " + oguryError.getMessage());
        }

        /* renamed from: a */
        public final void mo29385a(String str) {
            accbb.m15218b(str, "response");
        }
    }

    /* renamed from: d */
    protected static aacbc m14981d() {
        return new aaaab();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo29413a() {
        return this.f12000a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29414a(Context context) {
        accbb.m15218b(context, "context");
        if (acbbb.m15202a(context)) {
            aacba.m15022a(context, (aacac) new aaaaa(this));
            return;
        }
        aaccc aaccc = aaccc.f12045a;
        aaccc.m15047a("Error response: No Internet connection");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29415a(String str) {
        accbb.m15218b(str, "<set-?>");
        this.f12000a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo29416b() {
        return this.f12001b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo29417b(String str) {
        accbb.m15218b(str, "<set-?>");
        this.f12001b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo29418c();
}
