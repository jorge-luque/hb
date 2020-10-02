package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hg */
public abstract class C3151hg {

    /* renamed from: c */
    long f8788c;

    /* renamed from: d */
    boolean f8789d;

    /* renamed from: e */
    public C5132gs f8790e;

    /* renamed from: f */
    public String f8791f;

    /* renamed from: g */
    C5093fq f8792g;

    /* renamed from: a */
    static void m10393a(Context context, @Nullable String str) {
        if (!C3166jq.m10436c(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public abstract void mo18598a(C5143ha haVar, C5100fw fwVar);

    /* renamed from: b */
    public abstract void mo18599b();

    /* renamed from: c */
    public boolean mo18600c() {
        return true;
    }
}
