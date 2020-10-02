package org.cocos2dx.cpp;

/* renamed from: org.cocos2dx.cpp.b */
/* compiled from: AppManager */
public class C3597b {

    /* renamed from: c */
    private static C3597b f10091c;

    /* renamed from: a */
    public AppActivity f10092a;

    /* renamed from: b */
    public boolean f10093b = true;

    /* renamed from: a */
    public static synchronized C3597b m12267a() {
        C3597b bVar;
        synchronized (C3597b.class) {
            if (f10091c == null) {
                f10091c = new C3597b();
            }
            bVar = f10091c;
        }
        return bVar;
    }
}
