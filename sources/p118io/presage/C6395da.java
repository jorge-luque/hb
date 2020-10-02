package p118io.presage;

/* renamed from: io.presage.da */
public final class C6395da implements C6392cy {

    /* renamed from: a */
    private final Taleggio f16967a;

    /* renamed from: io.presage.da$CamembertauCalvados */
    static final class CamembertauCalvados extends C6515hm implements C6481gf<C6437ep> {

        /* renamed from: a */
        final /* synthetic */ C6395da f16968a;

        /* renamed from: b */
        final /* synthetic */ C6233ax f16969b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertauCalvados(C6395da daVar, C6233ax axVar) {
            super(0);
            this.f16968a = daVar;
            this.f16969b = axVar;
        }

        /* renamed from: b */
        private void m21224b() {
            C6395da.m21222c(this.f16969b);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34405a() {
            m21224b();
            return C6437ep.f17017a;
        }
    }

    public C6395da(Taleggio taleggio) {
        this.f16967a = taleggio;
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m21222c(p118io.presage.C6233ax r6) {
        /*
            io.presage.db r0 = r6.mo34768c()
            int r1 = r0.getWidth()
            int r1 = p118io.presage.C6215af.m20775a((int) r1)
            int r2 = r0.getHeight()
            int r2 = p118io.presage.C6215af.m20775a((int) r2)
            android.view.ViewParent r3 = r0.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 != 0) goto L_0x001d
            r3 = 0
        L_0x001d:
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r0 = r3
        L_0x0023:
            float r3 = r0.getX()
            int r3 = p118io.presage.C6215af.m20774a((float) r3)
            float r0 = r0.getY()
            int r0 = p118io.presage.C6215af.m20774a((float) r0)
            io.presage.db r4 = r6.mo34768c()
            android.graphics.Rect r4 = p118io.presage.Taleggio.m20684a((android.view.View) r4)
            int r5 = r4.width()
            int r5 = p118io.presage.C6215af.m20775a((int) r5)
            int r4 = r4.height()
            int r4 = p118io.presage.C6215af.m20775a((int) r4)
            r6.mo34764b((int) r5, (int) r4)
            r6.mo34756a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6395da.m21222c(io.presage.ax):void");
    }

    /* renamed from: a */
    public final void mo35329a(C6233ax axVar) {
        C6223an.m20792a(axVar.mo34768c(), new CamembertauCalvados(this, axVar));
    }
}
