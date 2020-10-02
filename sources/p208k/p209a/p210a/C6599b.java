package p208k.p209a.p210a;

/* renamed from: k.a.a.b */
/* compiled from: IEngineDataManager */
public interface C6599b {

    /* renamed from: k.a.a.b$a */
    /* compiled from: IEngineDataManager */
    public enum C6600a {
        LAUNCH_BEGIN(0),
        LAUNCH_END(1),
        SCENE_CHANGE_BEGIN(2),
        SCENE_CHANGE_END(3),
        IN_SCENE(4),
        INVALID(5000);

        private C6600a(int i) {
        }

        /* renamed from: a */
        public static C6600a[] m21689a() {
            C6600a[] aVarArr = f17180g;
            int length = aVarArr.length;
            C6600a[] aVarArr2 = new C6600a[length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            return aVarArr2;
        }
    }

    /* renamed from: k.a.a.b$b */
    /* compiled from: IEngineDataManager */
    public interface C6601b {
    }

    /* renamed from: a */
    String mo35630a();

    /* renamed from: a */
    void mo35631a(float f, float f2);

    /* renamed from: a */
    void mo35632a(int i, float f, int i2);

    /* renamed from: a */
    void mo35633a(int i, int i2, int i3);

    /* renamed from: a */
    void mo35634a(C6600a aVar, int i, int i2);

    /* renamed from: a */
    boolean mo35635a(C6601b bVar);

    void destroy();

    void pause();

    void resume();
}
