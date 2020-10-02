package p118io.presage;

import p118io.presage.C6530ia;

/* renamed from: io.presage.id */
class C6533id extends C6532ic {
    /* renamed from: a */
    public static final int m21445a(int i) {
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: a */
    public static final C6530ia m21446a(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new C6530ia(i, i2 - 1);
        }
        C6530ia.CamembertauCalvados camembertauCalvados = C6530ia.f17064b;
        return C6530ia.CamembertauCalvados.m21444a();
    }

    /* renamed from: b */
    public static final int m21447b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: c */
    public static final int m21448c(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i2 + " is less than minimum 0.");
        } else if (i < 0) {
            return 0;
        } else {
            return i > i2 ? i2 : i;
        }
    }
}
