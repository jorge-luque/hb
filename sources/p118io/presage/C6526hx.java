package p118io.presage;

/* renamed from: io.presage.hx */
class C6526hx extends C6525hw {
    /* renamed from: a */
    public static final int m21433a(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
