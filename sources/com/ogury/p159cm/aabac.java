package com.ogury.p159cm;

/* renamed from: com.ogury.cm.aabac */
public final class aabac {

    /* renamed from: a */
    public static final aabac f12008a = new aabac();

    private aabac() {
    }

    /* renamed from: a */
    public static boolean m14995a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public static boolean m14996a(Integer[] numArr, int i) {
        int i2;
        accbb.m15218b(numArr, "container");
        if (!(!(numArr.length == 0)) || numArr.length <= (i2 = i / 32)) {
            return false;
        }
        return m14995a(numArr[i2].intValue(), (int) Math.pow(2.0d, (double) (i - (i2 * 32))));
    }
}
