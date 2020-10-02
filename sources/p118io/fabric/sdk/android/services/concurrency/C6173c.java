package p118io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p118io.fabric.sdk.android.services.concurrency.C6172b;
import p118io.fabric.sdk.android.services.concurrency.C6180i;
import p118io.fabric.sdk.android.services.concurrency.C6184l;

/* renamed from: io.fabric.sdk.android.services.concurrency.c */
/* compiled from: DependencyPriorityBlockingQueue */
public class C6173c<E extends C6172b & C6184l & C6180i> extends PriorityBlockingQueue<E> {

    /* renamed from: a */
    final Queue<E> f16219a = new LinkedList();

    /* renamed from: b */
    private final ReentrantLock f16220b = new ReentrantLock();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo34281a(int i, E e) {
        try {
            this.f16220b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.f16219a.offer(e);
        } finally {
            this.f16220b.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public E mo34284b(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        if (i == 0) {
            return (C6172b) super.take();
        }
        if (i == 1) {
            return (C6172b) super.peek();
        }
        if (i == 2) {
            return (C6172b) super.poll();
        }
        if (i != 3) {
            return null;
        }
        return (C6172b) super.poll(l.longValue(), timeUnit);
    }

    public void clear() {
        try {
            this.f16220b.lock();
            this.f16219a.clear();
            super.clear();
        } finally {
            this.f16220b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f16220b.lock();
            return super.contains(obj) || this.f16219a.contains(obj);
        } finally {
            this.f16220b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f16220b.lock();
            int drainTo = super.drainTo(collection) + this.f16219a.size();
            while (!this.f16219a.isEmpty()) {
                collection.add(this.f16219a.poll());
            }
            return drainTo;
        } finally {
            this.f16220b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f16220b.lock();
            return super.remove(obj) || this.f16219a.remove(obj);
        } finally {
            this.f16220b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f16220b.lock();
            return this.f16219a.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.f16220b.unlock();
        }
    }

    public int size() {
        try {
            this.f16220b.lock();
            return this.f16219a.size() + super.size();
        } finally {
            this.f16220b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f16220b.lock();
            return mo34283a((T[]) super.toArray(tArr), (T[]) this.f16219a.toArray(tArr));
        } finally {
            this.f16220b.unlock();
        }
    }

    public E peek() {
        try {
            return mo34279a(1, (Long) null, (TimeUnit) null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public E take() throws InterruptedException {
        return mo34279a(0, (Long) null, (TimeUnit) null);
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return mo34279a(3, Long.valueOf(j), timeUnit);
    }

    public E poll() {
        try {
            return mo34279a(2, (Long) null, (TimeUnit) null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public Object[] toArray() {
        try {
            this.f16220b.lock();
            return mo34283a((T[]) super.toArray(), (T[]) this.f16219a.toArray());
        } finally {
            this.f16220b.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public E mo34279a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E b;
        while (true) {
            b = mo34284b(i, l, timeUnit);
            if (b == null || mo34282a(b)) {
                return b;
            }
            mo34281a(i, b);
        }
        return b;
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f16220b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f16219a.isEmpty() && drainTo <= i) {
                collection.add(this.f16219a.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.f16220b.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo34282a(E e) {
        return e.areDependenciesMet();
    }

    /* renamed from: a */
    public void mo34280a() {
        try {
            this.f16220b.lock();
            Iterator it = this.f16219a.iterator();
            while (it.hasNext()) {
                C6172b bVar = (C6172b) it.next();
                if (mo34282a(bVar)) {
                    super.offer(bVar);
                    it.remove();
                }
            }
        } finally {
            this.f16220b.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> T[] mo34283a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
