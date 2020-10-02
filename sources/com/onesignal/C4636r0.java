package com.onesignal;

import com.onesignal.C4564n1;

/* renamed from: com.onesignal.r0 */
/* compiled from: OSInAppMessagePrompt */
abstract class C4636r0 {

    /* renamed from: a */
    private boolean f12641a = false;

    C4636r0() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo29903a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo29904a(C4564n1.C4576f0 f0Var);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29936a(boolean z) {
        this.f12641a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29937b() {
        return this.f12641a;
    }

    public String toString() {
        return "OSInAppMessagePrompt{key=" + mo29903a() + " prompted=" + this.f12641a + '}';
    }
}
