package com.huawei.android.hwgamesdk;

/* renamed from: com.huawei.android.hwgamesdk.a */
/* compiled from: HwGameSDK */
public class C4139a {

    /* renamed from: com.huawei.android.hwgamesdk.a$a */
    /* compiled from: HwGameSDK */
    public interface C4140a {
    }

    /* renamed from: com.huawei.android.hwgamesdk.a$b */
    /* compiled from: HwGameSDK */
    public enum C4141b {
        GAME_LAUNCH_BEGIN,
        GAME_LAUNCH_END,
        GAME_SCENECHANGE_BEGIN,
        GAME_SCENECHANGE_END,
        GAME_INSCENE;

        static {
            GAME_LAUNCH_BEGIN = new C4141b("GAME_LAUNCH_BEGIN", 0);
            GAME_LAUNCH_END = new C4141b("GAME_LAUNCH_END", 1);
            GAME_SCENECHANGE_BEGIN = new C4141b("GAME_SCENECHANGE_BEGIN", 2);
            GAME_SCENECHANGE_END = new C4141b("GAME_SCENECHANGE_END", 3);
            GAME_INSCENE = new C4141b("GAME_INSCENE", 4);
        }
    }

    /* renamed from: a */
    public int mo28424a() {
        throw new NoExtAPIException("method not supported.");
    }

    /* renamed from: a */
    public void mo28428a(C4141b bVar, int i, int i2) {
        "gameScene:" + bVar + ", cpuLevel:" + i + ", gpuLevel:" + i2;
        throw new NoExtAPIException("notifyGameScene isn't supported.");
    }

    /* renamed from: a */
    public void mo28427a(int i, int i2, int i3) {
        "notifyContinuousFpsMissed, cycle: " + i + ", maxFrameMissed:" + i2 + ", times: " + i3;
        throw new NoExtAPIException("notifyContinuousFpsMissed isn't supported.");
    }

    /* renamed from: a */
    public void mo28426a(int i, float f, int i2) {
        "notifyFpsDx, cycle: " + i + ", maxFrameDx:" + f + ", frame: " + i2;
        throw new NoExtAPIException("notifyFpsDx isn't supported.");
    }

    /* renamed from: a */
    public void mo28425a(float f, float f2) {
        "notifyFpsChanged, oldFps:" + f + ", newFps: " + f2;
        throw new NoExtAPIException("notifyFpsChanged isn't supported.");
    }
}
