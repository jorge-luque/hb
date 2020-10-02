package androidx.appcompat.app;

/* renamed from: androidx.appcompat.app.i */
/* compiled from: TwilightCalculator */
class C0430i {

    /* renamed from: d */
    private static C0430i f521d;

    /* renamed from: a */
    public long f522a;

    /* renamed from: b */
    public long f523b;

    /* renamed from: c */
    public int f524c;

    C0430i() {
    }

    /* renamed from: a */
    static C0430i m577a() {
        if (f521d == null) {
            f521d = new C0430i();
        }
        return f521d;
    }

    /* renamed from: a */
    public void mo2131a(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = (0.01720197f * f) + 6.24006f;
        double d3 = (double) f2;
        Double.isNaN(d3);
        double sin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin((double) (2.0f * f2)) * 3.4906598739326E-4d) + (Math.sin((double) (f2 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double d5 = (double) (f - 9.0E-4f);
        Double.isNaN(d5);
        double round = (double) (((float) Math.round(d5 - d4)) + 9.0E-4f);
        Double.isNaN(round);
        double sin2 = round + d4 + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin3 >= 1.0d) {
            this.f524c = 1;
            this.f522a = -1;
            this.f523b = -1;
        } else if (sin3 <= -1.0d) {
            this.f524c = 0;
            this.f522a = -1;
            this.f523b = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin3) / 6.283185307179586d));
            Double.isNaN(acos);
            this.f522a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            Double.isNaN(acos);
            long round2 = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f523b = round2;
            if (round2 >= j || this.f522a <= j) {
                this.f524c = 1;
            } else {
                this.f524c = 0;
            }
        }
    }
}
