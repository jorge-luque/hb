package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.y */
/* compiled from: RtlSpacingHelper */
class C0641y {

    /* renamed from: a */
    private int f1585a = 0;

    /* renamed from: b */
    private int f1586b = 0;

    /* renamed from: c */
    private int f1587c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f1588d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f1589e = 0;

    /* renamed from: f */
    private int f1590f = 0;

    /* renamed from: g */
    private boolean f1591g = false;

    /* renamed from: h */
    private boolean f1592h = false;

    C0641y() {
    }

    /* renamed from: a */
    public int mo3633a() {
        return this.f1591g ? this.f1585a : this.f1586b;
    }

    /* renamed from: b */
    public int mo3636b() {
        return this.f1591g ? this.f1586b : this.f1585a;
    }

    /* renamed from: a */
    public void mo3634a(int i, int i2) {
        this.f1592h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1589e = i;
            this.f1585a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1590f = i2;
            this.f1586b = i2;
        }
    }

    /* renamed from: b */
    public void mo3637b(int i, int i2) {
        this.f1587c = i;
        this.f1588d = i2;
        this.f1592h = true;
        if (this.f1591g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1585a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1586b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1585a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1586b = i2;
        }
    }

    /* renamed from: a */
    public void mo3635a(boolean z) {
        if (z != this.f1591g) {
            this.f1591g = z;
            if (!this.f1592h) {
                this.f1585a = this.f1589e;
                this.f1586b = this.f1590f;
            } else if (z) {
                int i = this.f1588d;
                if (i == Integer.MIN_VALUE) {
                    i = this.f1589e;
                }
                this.f1585a = i;
                int i2 = this.f1587c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f1590f;
                }
                this.f1586b = i2;
            } else {
                int i3 = this.f1587c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f1589e;
                }
                this.f1585a = i3;
                int i4 = this.f1588d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f1590f;
                }
                this.f1586b = i4;
            }
        }
    }
}
