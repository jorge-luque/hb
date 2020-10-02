package com.criteo.publisher.model;

import com.criteo.publisher.C2387i;
import com.criteo.publisher.CriteoInterstitialAdDisplayListener;
import com.criteo.publisher.p054a0.C2347v;
import com.criteo.publisher.p068z.C2595d;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.model.y */
public class C2467y {

    /* renamed from: a */
    private String f7937a = "";

    /* renamed from: b */
    private C2347v f7938b = C2347v.NONE;

    /* renamed from: c */
    private final C2455p f7939c;

    public C2467y(C2455p pVar) {
        this.f7939c = pVar;
    }

    /* renamed from: a */
    public void mo10419a(String str) {
        this.f7937a = this.f7939c.mo10383b().replace(this.f7939c.mo10381a(), str);
    }

    /* renamed from: b */
    public void mo10421b() {
        this.f7938b = C2347v.LOADING;
    }

    /* renamed from: c */
    public void mo10422c() {
        this.f7938b = C2347v.LOADED;
    }

    /* renamed from: d */
    public String mo10423d() {
        return this.f7937a;
    }

    /* renamed from: e */
    public boolean mo10424e() {
        return this.f7938b == C2347v.LOADED;
    }

    /* renamed from: f */
    public boolean mo10425f() {
        return this.f7938b == C2347v.LOADING;
    }

    /* renamed from: g */
    public void mo10426g() {
        this.f7938b = C2347v.NONE;
        this.f7937a = "";
    }

    /* renamed from: a */
    public void mo10418a() {
        this.f7938b = C2347v.FAILED;
    }

    /* renamed from: a */
    public void mo10420a(String str, C2456q qVar, CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener) {
        Executor N = C2387i.m9085U().mo10261N();
        new C2595d(this, qVar, criteoInterstitialAdDisplayListener).executeOnExecutor(N, new String[]{str});
    }
}
