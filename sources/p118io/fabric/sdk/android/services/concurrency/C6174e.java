package p118io.fabric.sdk.android.services.concurrency;

/* renamed from: io.fabric.sdk.android.services.concurrency.e */
/* compiled from: Priority */
public enum C6174e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static {
        LOW = new C6174e("LOW", 0);
        NORMAL = new C6174e("NORMAL", 1);
        HIGH = new C6174e("HIGH", 2);
        IMMEDIATE = new C6174e("IMMEDIATE", 3);
    }

    /* renamed from: a */
    static <Y> int m19938a(C6180i iVar, Y y) {
        C6174e eVar;
        if (y instanceof C6180i) {
            eVar = ((C6180i) y).getPriority();
        } else {
            eVar = NORMAL;
        }
        return eVar.ordinal() - iVar.getPriority().ordinal();
    }
}
