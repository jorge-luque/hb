package p118io.presage;

/* renamed from: io.presage.fu */
public final class C6469fu {
    /* renamed from: a */
    private static final int m21356a(int i, int i2, int i3) {
        return m21357b(m21357b(i, 1) - m21357b(i2, 1), 1);
    }

    /* renamed from: b */
    private static final int m21357b(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: a */
    public static final int m21355a(int i, int i2) {
        return i >= i2 ? i2 : i2 - m21356a(i2, i, 1);
    }
}
