package com.google.protobuf;

/* renamed from: com.google.protobuf.r */
/* compiled from: LazyFieldLite */
public class C4051r {

    /* renamed from: a */
    private C3995f f10857a;

    /* renamed from: b */
    private C4018k f10858b;

    /* renamed from: c */
    protected volatile C4054u f10859c;

    /* renamed from: d */
    private volatile C3995f f10860d;

    static {
        C4018k.m13414a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f10859c = r4;
        r3.f10860d = com.google.protobuf.C3995f.f10759b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo28247a(com.google.protobuf.C4054u r4) {
        /*
            r3 = this;
            com.google.protobuf.u r0 = r3.f10859c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.u r0 = r3.f10859c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.protobuf.f r0 = r3.f10857a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.x r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.f r1 = r3.f10857a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.k r2 = r3.f10858b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.mo28065a((com.google.protobuf.C3995f) r1, (com.google.protobuf.C4018k) r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.u r0 = (com.google.protobuf.C4054u) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f10859c = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.f r0 = r3.f10857a     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f10860d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f10859c = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.f r0 = com.google.protobuf.C3995f.f10759b     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f10860d = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f10859c = r4     // Catch:{ all -> 0x0034 }
            com.google.protobuf.f r4 = com.google.protobuf.C3995f.f10759b     // Catch:{ all -> 0x0034 }
            r3.f10860d = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4051r.mo28247a(com.google.protobuf.u):void");
    }

    /* renamed from: b */
    public C4054u mo28248b(C4054u uVar) {
        mo28247a(uVar);
        return this.f10859c;
    }

    /* renamed from: c */
    public C4054u mo28249c(C4054u uVar) {
        C4054u uVar2 = this.f10859c;
        this.f10857a = null;
        this.f10859c = uVar;
        return uVar2;
    }
}
