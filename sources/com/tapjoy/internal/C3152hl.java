package com.tapjoy.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hl */
public final class C3152hl implements Flushable {

    /* renamed from: a */
    final Object f8793a = this;

    /* renamed from: b */
    C4901ax f8794b;

    /* renamed from: c */
    private final File f8795c;

    public C3152hl(File file) {
        this.f8795c = file;
        try {
            this.f8794b = C4898au.m16682a((C4901ax) new C5105g(file, new C4907bd() {
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ void mo18607a(OutputStream outputStream, Object obj) {
                    C5041ev.f13657c.mo31107a(outputStream, (Object) (C5041ev) obj);
                }

                /* renamed from: b */
                public final /* synthetic */ Object mo18608b(InputStream inputStream) {
                    return (C5041ev) C5041ev.f13657c.mo31104a(inputStream);
                }
            }));
        } catch (Exception unused) {
            mo18601a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18601a() {
        this.f8795c.delete();
        C4901ax axVar = this.f8794b;
        if (axVar instanceof Closeable) {
            try {
                ((Closeable) axVar).close();
            } catch (Exception unused) {
            }
        }
        this.f8794b = new C4899av(new LinkedList());
    }

    /* renamed from: b */
    public final int mo18603b() {
        int size;
        synchronized (this.f8793a) {
            try {
                size = this.f8794b.size();
            } catch (Exception unused) {
                mo18601a();
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    /* renamed from: c */
    public final boolean mo18605c() {
        boolean isEmpty;
        synchronized (this.f8793a) {
            try {
                isEmpty = this.f8794b.isEmpty();
            } catch (Exception unused) {
                mo18601a();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return isEmpty;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void flush() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f8793a
            monitor-enter(r0)
            com.tapjoy.internal.ax r1 = r2.f8794b     // Catch:{ all -> 0x0016 }
            boolean r1 = r1 instanceof java.io.Flushable     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0014
            com.tapjoy.internal.ax r1 = r2.f8794b     // Catch:{ Exception -> 0x0011 }
            java.io.Flushable r1 = (java.io.Flushable) r1     // Catch:{ Exception -> 0x0011 }
            r1.flush()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r2.mo18601a()     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3152hl.flush():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18602a(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f8793a
            monitor-enter(r0)
            com.tapjoy.internal.ax r1 = r2.f8794b     // Catch:{ Exception -> 0x000b }
            r1.mo30932b(r3)     // Catch:{ Exception -> 0x000b }
            goto L_0x000e
        L_0x0009:
            r3 = move-exception
            goto L_0x0010
        L_0x000b:
            r2.mo18601a()     // Catch:{ all -> 0x0009 }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3152hl.mo18602a(int):void");
    }

    @Nullable
    /* renamed from: b */
    public final C5041ev mo18604b(int i) {
        C5041ev evVar;
        synchronized (this.f8793a) {
            try {
                evVar = (C5041ev) this.f8794b.mo30931a(i);
            } catch (Exception unused) {
                mo18601a();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return evVar;
    }
}
