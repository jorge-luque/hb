package p208k.p209a.p210a.p211c;

import android.util.Log;
import com.huawei.android.hwgamesdk.C4139a;
import com.huawei.android.hwgamesdk.NoExtAPIException;
import p208k.p209a.p210a.C6599b;

/* renamed from: k.a.a.c.a */
/* compiled from: EngineDataManagerHuawei */
public class C6602a implements C6599b {

    /* renamed from: c */
    private static /* synthetic */ int[] f17181c;

    /* renamed from: a */
    private C4139a f17182a = new C4139a();

    /* renamed from: b */
    private C4139a.C4140a f17183b = new C6603a(this);

    /* renamed from: k.a.a.c.a$a */
    /* compiled from: EngineDataManagerHuawei */
    class C6603a implements C4139a.C4140a {
        C6603a(C6602a aVar) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|10|11|12|13|(2:14|15)|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] m21690b() {
        /*
            int[] r0 = f17181c
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            k.a.a.b$a[] r0 = p208k.p209a.p210a.C6599b.C6600a.m21689a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.INVALID     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.IN_SCENE     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.LAUNCH_BEGIN     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.LAUNCH_END     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.SCENE_CHANGE_BEGIN     // Catch:{ NoSuchFieldError -> 0x0039 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
        L_0x0039:
            k.a.a.b$a r1 = p208k.p209a.p210a.C6599b.C6600a.SCENE_CHANGE_END     // Catch:{ NoSuchFieldError -> 0x0042 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
        L_0x0042:
            f17181c = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p208k.p209a.p210a.p211c.C6602a.m21690b():int[]");
    }

    /* renamed from: a */
    public void mo35634a(C6599b.C6600a aVar, int i, int i2) {
        C4139a.C4141b bVar;
        try {
            int i3 = m21690b()[aVar.ordinal()];
            if (i3 == 1) {
                bVar = C4139a.C4141b.GAME_LAUNCH_BEGIN;
            } else if (i3 == 2) {
                bVar = C4139a.C4141b.GAME_LAUNCH_END;
            } else if (i3 == 3) {
                bVar = C4139a.C4141b.GAME_SCENECHANGE_BEGIN;
            } else if (i3 == 4) {
                bVar = C4139a.C4141b.GAME_SCENECHANGE_END;
            } else if (i3 != 5) {
                Log.e("EngineDataManagerHuawei", "error type: " + aVar);
                return;
            } else {
                bVar = C4139a.C4141b.GAME_INSCENE;
            }
            this.f17182a.mo28428a(bVar, i, i2);
            throw null;
        } catch (NoExtAPIException unused) {
        }
    }

    public void destroy() {
    }

    public void pause() {
    }

    public void resume() {
    }

    /* renamed from: a */
    public void mo35633a(int i, int i2, int i3) {
        try {
            this.f17182a.mo28427a(i, i2, i3);
            throw null;
        } catch (NoExtAPIException unused) {
        }
    }

    /* renamed from: a */
    public void mo35632a(int i, float f, int i2) {
        try {
            this.f17182a.mo28426a(i, f, i2);
            throw null;
        } catch (NoExtAPIException unused) {
        }
    }

    /* renamed from: a */
    public void mo35631a(float f, float f2) {
        try {
            this.f17182a.mo28425a(f, f2);
            throw null;
        } catch (NoExtAPIException unused) {
        }
    }

    /* renamed from: a */
    public String mo35630a() {
        this.f17182a.mo28424a();
        throw null;
    }

    /* renamed from: a */
    public boolean mo35635a(C6599b.C6601b bVar) {
        if (bVar == null) {
            return false;
        }
        try {
            this.f17182a.mo28424a();
            throw null;
        } catch (NoExtAPIException | NoSuchMethodError unused) {
            return false;
        }
    }
}
