package p118io.presage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.List;
import p118io.presage.Goudaauxepices;

/* renamed from: io.presage.BrieauPoivre */
public final class BrieauPoivre {

    /* renamed from: a */
    public static final CamembertauCalvados f16389a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private FourmedeRochefort f16390b;

    /* renamed from: c */
    private final ViewGroup f16391c;

    /* renamed from: d */
    private final BriedeMeaux f16392d;

    /* renamed from: e */
    private final BrillatSavarin f16393e;

    /* renamed from: io.presage.BrieauPoivre$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.BrieauPoivre$CamembertdeNormandie */
    static final class CamembertdeNormandie extends C6515hm implements C6481gf<C6231av> {

        /* renamed from: a */
        final /* synthetic */ BrieauPoivre f16394a;

        /* renamed from: b */
        final /* synthetic */ View f16395b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertdeNormandie(BrieauPoivre brieauPoivre, View view) {
            super(0);
            this.f16394a = brieauPoivre;
            this.f16395b = view;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public C6231av mo34405a() {
            return this.f16394a.m20222a((C6396db) this.f16395b);
        }
    }

    /* renamed from: io.presage.BrieauPoivre$EcirdelAubrac */
    static final class EcirdelAubrac extends C6515hm implements C6482gg<C6231av, C6437ep> {

        /* renamed from: a */
        final /* synthetic */ BrieauPoivre f16396a;

        /* renamed from: b */
        final /* synthetic */ View f16397b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        EcirdelAubrac(BrieauPoivre brieauPoivre, View view) {
            super(1);
            this.f16396a = brieauPoivre;
            this.f16397b = view;
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ Object mo34409a(Object obj) {
            m20229a((C6231av) obj);
            return C6437ep.f17017a;
        }

        /* renamed from: a */
        private void m20229a(C6231av avVar) {
            BrieauPoivre.m20224b((C6396db) this.f16397b, avVar);
        }
    }

    private BrieauPoivre(ViewGroup viewGroup, BriedeMeaux briedeMeaux, BrillatSavarin brillatSavarin) {
        this.f16391c = viewGroup;
        this.f16392d = briedeMeaux;
        this.f16393e = brillatSavarin;
        this.f16390b = new FourmedeRochefort();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20224b(C6396db dbVar, C6231av avVar) {
        if (dbVar.mo35335a() && dbVar.mo35336b()) {
            dbVar.getMraidCommandExecutor().mo34757a(avVar);
        }
    }

    public /* synthetic */ BrieauPoivre(ViewGroup viewGroup) {
        this(viewGroup, new BriedeMeaux(), new BrillatSavarin());
    }

    /* renamed from: a */
    public final void mo34460a() {
        this.f16390b.mo34556a();
        int childCount = this.f16391c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f16391c.getChildAt(i);
            if ((childAt instanceof C6396db) && ((C6396db) childAt).getContainsMraid()) {
                Goudaauxepices.CamembertauCalvados camembertauCalvados = Goudaauxepices.f16532a;
                this.f16390b.mo34560a(Goudaauxepices.CamembertauCalvados.m20425a(new CamembertdeNormandie(this, childAt)).mo34564b(new EcirdelAubrac(this, childAt)));
            }
        }
    }

    /* renamed from: b */
    public final void mo34461b() {
        this.f16390b.mo34556a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final C6231av m20222a(C6396db dbVar) {
        C6231av avVar = new C6231av();
        View rootView = this.f16391c.getRootView();
        if (rootView != null) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            Rect a = BriedeMeaux.m20232a(dbVar);
            Rect b = BriedeMeaux.m20237b(this.f16391c);
            if (!a.intersect(b)) {
                return avVar;
            }
            List<Rect> a2 = BriedeMeaux.m20236a((List<? extends View>) this.f16393e.mo34462a(viewGroup, (WebView) dbVar), a);
            int a3 = BriedeMeaux.m20231a(a, a2);
            int measuredWidth = dbVar.getMeasuredWidth() * dbVar.getMeasuredHeight();
            int a4 = measuredWidth - BriedeMelun.m20240a(a);
            if (a4 < 0) {
                a4 = 0;
            }
            float f = (float) measuredWidth;
            if (measuredWidth != 0) {
                avVar.mo34748a(100.0f - ((((float) (a3 + a4)) * 100.0f) / f));
            } else {
                avVar.mo34748a(0.0f);
            }
            if (avVar.mo34752c() != 0.0f) {
                BriedeMelun.m20242a(a2, b);
                BriedeMelun.m20241a(a, b);
                avVar.mo34750a(a2);
                avVar.mo34749a(a);
            }
            return avVar;
        }
        throw new C6434em("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
