package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

/* renamed from: com.tapjoy.internal.au */
public final class C4898au extends C4896at implements C4901ax, Closeable, Flushable {

    /* renamed from: a */
    private final C4901ax f13366a;

    /* renamed from: b */
    private final LinkedList f13367b = new LinkedList();

    /* renamed from: c */
    private final LinkedList f13368c = new LinkedList();

    /* renamed from: d */
    private int f13369d;

    /* renamed from: e */
    private boolean f13370e;

    private C4898au(C4901ax axVar) {
        this.f13366a = axVar;
        int size = axVar.size();
        this.f13369d = size;
        this.f13370e = size == 0;
    }

    /* renamed from: a */
    public static C4898au m16682a(C4901ax axVar) {
        return new C4898au(axVar);
    }

    /* renamed from: b */
    public final void mo30932b(int i) {
        if (i <= 0 || i > this.f13369d) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.f13367b.size()) {
            C4900aw.m16687a(this.f13367b, i);
            this.f13366a.mo30932b(i);
        } else {
            this.f13367b.clear();
            int size = (this.f13368c.size() + i) - this.f13369d;
            if (size < 0) {
                this.f13366a.mo30932b(i);
            } else {
                this.f13366a.clear();
                this.f13370e = true;
                if (size > 0) {
                    C4900aw.m16687a(this.f13368c, size);
                }
            }
        }
        this.f13369d -= i;
    }

    public final void close() {
        try {
            flush();
        } finally {
            C4901ax axVar = this.f13366a;
            if (axVar instanceof Closeable) {
                ((Closeable) axVar).close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        close();
        super.finalize();
    }

    public final void flush() {
        if (!this.f13368c.isEmpty()) {
            this.f13366a.addAll(this.f13368c);
            if (this.f13370e) {
                this.f13367b.addAll(this.f13368c);
            }
            this.f13368c.clear();
        }
    }

    public final boolean offer(Object obj) {
        this.f13368c.add(obj);
        this.f13369d++;
        return true;
    }

    public final Object peek() {
        if (this.f13369d <= 0) {
            return null;
        }
        if (!this.f13367b.isEmpty()) {
            return this.f13367b.element();
        }
        if (this.f13370e) {
            return this.f13368c.element();
        }
        Object peek = this.f13366a.peek();
        this.f13367b.add(peek);
        if (this.f13369d == this.f13367b.size() + this.f13368c.size()) {
            this.f13370e = true;
        }
        return peek;
    }

    public final Object poll() {
        Object obj;
        if (this.f13369d <= 0) {
            return null;
        }
        if (!this.f13367b.isEmpty()) {
            obj = this.f13367b.remove();
            this.f13366a.mo30932b(1);
        } else if (this.f13370e) {
            obj = this.f13368c.remove();
        } else {
            obj = this.f13366a.remove();
            if (this.f13369d == this.f13368c.size() + 1) {
                this.f13370e = true;
            }
        }
        this.f13369d--;
        return obj;
    }

    public final int size() {
        return this.f13369d;
    }

    /* renamed from: a */
    public final Object mo30931a(int i) {
        if (i < 0 || i >= this.f13369d) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.f13367b.size();
        if (i < size) {
            return this.f13367b.get(i);
        }
        if (this.f13370e) {
            return this.f13368c.get(i - size);
        }
        if (i >= this.f13366a.size()) {
            return this.f13368c.get(i - this.f13366a.size());
        }
        Object obj = null;
        while (size <= i) {
            obj = this.f13366a.mo30931a(size);
            this.f13367b.add(obj);
            size++;
        }
        if (i + 1 + this.f13368c.size() == this.f13369d) {
            this.f13370e = true;
        }
        return obj;
    }
}
