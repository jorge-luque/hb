package com.ogury.p159cm;

import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.ogury.cm.ababa */
public abstract class ababa {

    /* renamed from: a */
    private OguryChoiceManager.Answer f12050a = OguryChoiceManager.Answer.NO_ANSWER;

    /* renamed from: b */
    private String f12051b = "";

    /* renamed from: c */
    private boolean f12052c;

    /* renamed from: d */
    private boolean f12053d = true;

    /* renamed from: f */
    public static <T extends ababa> T m15062f() {
        aacca aacca = aacca.f12035a;
        T b = aacca.m15034b();
        if (b != null) {
            return b;
        }
        throw new acbab("null cannot be cast to non-null type T");
    }

    /* renamed from: a */
    public final OguryChoiceManager.Answer mo29430a() {
        return this.f12050a;
    }

    /* renamed from: a */
    public final void mo29431a(OguryChoiceManager.Answer answer) {
        accbb.m15218b(answer, "<set-?>");
        this.f12050a = answer;
    }

    /* renamed from: a */
    public final void mo29432a(String str) {
        accbb.m15218b(str, "<set-?>");
        this.f12051b = str;
    }

    /* renamed from: a */
    public final void mo29433a(boolean z) {
        this.f12052c = z;
    }

    /* renamed from: b */
    public final String mo29434b() {
        return this.f12051b;
    }

    /* renamed from: b */
    public final void mo29435b(boolean z) {
        this.f12053d = z;
    }

    /* renamed from: c */
    public final boolean mo29436c() {
        return this.f12052c;
    }

    /* renamed from: d */
    public final boolean mo29437d() {
        return this.f12053d;
    }

    /* renamed from: e */
    public abstract int mo29438e();
}
