package com.tapjoy.internal;

import java.util.Observable;

/* renamed from: com.tapjoy.internal.fs */
public final class C5096fs {

    /* renamed from: a */
    public static final C5097a f13948a = new C5097a();

    /* renamed from: b */
    public static final C5097a f13949b = new C5097a();

    /* renamed from: c */
    public static final C5097a f13950c = new C5097a();

    /* renamed from: d */
    public static final C5097a f13951d = new C5097a();

    /* renamed from: e */
    public static final C5097a f13952e = new C5097a();

    /* renamed from: com.tapjoy.internal.fs$a */
    public static class C5097a extends Observable {
        public final void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        public final void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }
}
