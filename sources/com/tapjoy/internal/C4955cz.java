package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.cz */
public final class C4955cz extends C4948cs {

    /* renamed from: a */
    public final C4949ct f13463a;

    /* renamed from: b */
    public final List f13464b = new ArrayList();

    /* renamed from: c */
    public C4979ds f13465c;

    /* renamed from: d */
    public boolean f13466d = false;

    /* renamed from: e */
    public boolean f13467e = false;

    /* renamed from: f */
    public String f13468f;

    /* renamed from: g */
    boolean f13469g;

    /* renamed from: h */
    private final C4950cu f13470h;

    /* renamed from: i */
    private C4977dq f13471i;

    C4955cz(C4949ct ctVar, C4950cu cuVar) {
        this.f13463a = ctVar;
        this.f13470h = cuVar;
        this.f13468f = UUID.randomUUID().toString();
        m16795b((View) null);
        if (cuVar.f13448f == C4951cv.HTML) {
            this.f13465c = new C4981dt(cuVar.f13444b);
        } else {
            this.f13465c = new C4982du(Collections.unmodifiableList(cuVar.f13445c), cuVar.f13446d);
        }
        this.f13465c.mo31068a();
        C4959dd.m16817a().f13484a.add(this);
        C4979ds dsVar = this.f13465c;
        C4964dg a = C4964dg.m16825a();
        WebView c = dsVar.mo31075c();
        JSONObject jSONObject = new JSONObject();
        C4972dm.m16845a(jSONObject, "impressionOwner", ctVar.f13440a);
        C4972dm.m16845a(jSONObject, "videoEventsOwner", ctVar.f13441b);
        C4972dm.m16845a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(ctVar.f13442c));
        a.mo31062a(c, "init", jSONObject);
    }

    /* renamed from: b */
    private void m16795b(View view) {
        this.f13471i = new C4977dq(view);
    }

    /* renamed from: a */
    public final void mo31035a() {
        if (!this.f13466d) {
            this.f13466d = true;
            C4959dd a = C4959dd.m16817a();
            boolean b = a.mo31056b();
            a.f13485b.add(this);
            if (!b) {
                C4966dh a2 = C4966dh.m16831a();
                C4960de.m16819a().f13491e = a2;
                C4960de a3 = C4960de.m16819a();
                a3.f13488b = new BroadcastReceiver() {
                    public final void onReceive(
/*
Method generation error in method: com.tapjoy.internal.de.1.onReceive(android.content.Context, android.content.Intent):void, dex: classes2.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tapjoy.internal.de.1.onReceive(android.content.Context, android.content.Intent):void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                a3.f13487a.registerReceiver(a3.f13488b, intentFilter);
                a3.f13489c = true;
                a3.mo31058c();
                if (C4960de.m16819a().mo31057b()) {
                    C4984dv.m16870a();
                    C4984dv.m16874b();
                }
                C4945cp cpVar = a2.f13501b;
                cpVar.f13435b = cpVar.mo31031a();
                cpVar.mo31032b();
                cpVar.f13434a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, cpVar);
            }
            this.f13465c.mo31069a(C4966dh.m16831a().f13500a);
            this.f13465c.mo31071a(this, this.f13470h);
        }
    }

    /* renamed from: b */
    public final void mo31037b() {
        BroadcastReceiver broadcastReceiver;
        if (!this.f13467e) {
            this.f13471i.clear();
            if (!this.f13467e) {
                this.f13464b.clear();
            }
            this.f13467e = true;
            C4964dg.m16825a().mo31062a(this.f13465c.mo31075c(), "finishSession", new Object[0]);
            C4959dd a = C4959dd.m16817a();
            boolean b = a.mo31056b();
            a.f13484a.remove(this);
            a.f13485b.remove(this);
            if (b && !a.mo31056b()) {
                C4966dh a2 = C4966dh.m16831a();
                C4984dv a3 = C4984dv.m16870a();
                C4984dv.m16876c();
                a3.f13533b.clear();
                C4984dv.f13528a.post(new Runnable() {
                    public final void run(
/*
Method generation error in method: com.tapjoy.internal.dv.1.run():void, dex: classes2.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tapjoy.internal.dv.1.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
                C4960de a4 = C4960de.m16819a();
                Context context = a4.f13487a;
                if (!(context == null || (broadcastReceiver = a4.f13488b) == null)) {
                    context.unregisterReceiver(broadcastReceiver);
                    a4.f13488b = null;
                }
                a4.f13489c = false;
                a4.f13490d = false;
                a4.f13491e = null;
                C4945cp cpVar = a2.f13501b;
                cpVar.f13434a.getContentResolver().unregisterContentObserver(cpVar);
            }
            this.f13465c.mo31074b();
            this.f13465c = null;
        }
    }

    /* renamed from: c */
    public final View mo31040c() {
        return (View) this.f13471i.get();
    }

    /* renamed from: d */
    public final boolean mo31041d() {
        return this.f13466d && !this.f13467e;
    }

    /* renamed from: a */
    public final void mo31036a(View view) {
        if (!this.f13467e) {
            C4975do.m16853a((Object) view, "AdView is null");
            if (mo31040c() != view) {
                m16795b(view);
                this.f13465c.mo31076d();
                Collection<C4955cz> unmodifiableCollection = Collections.unmodifiableCollection(C4959dd.m16817a().f13484a);
                if (unmodifiableCollection != null && unmodifiableCollection.size() > 0) {
                    for (C4955cz czVar : unmodifiableCollection) {
                        if (czVar != this && czVar.mo31040c() == view) {
                            czVar.f13471i.clear();
                        }
                    }
                }
            }
        }
    }
}
