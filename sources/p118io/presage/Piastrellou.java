package p118io.presage;

import android.content.Context;
import java.util.Map;
import p118io.presage.common.SdkType;

/* renamed from: io.presage.Piastrellou */
public final class Piastrellou extends PaletdeBourgogne {

    /* renamed from: a */
    private final Context f16627a;

    /* renamed from: b */
    private final TetedeMoine f16628b;

    /* renamed from: c */
    private final Taleggio f16629c;

    /* renamed from: d */
    private final SdkType f16630d;

    /* renamed from: e */
    private final C6502h f16631e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Piastrellou(android.content.Context r8) {
        /*
            r7 = this;
            io.presage.TetedeMoine r2 = new io.presage.TetedeMoine
            r2.<init>(r8)
            io.presage.Taleggio r3 = new io.presage.Taleggio
            r3.<init>(r8)
            io.presage.TommeMarcdeRaisin r4 = p118io.presage.TommeMarcdeRaisin.f16705a
            io.presage.common.SdkType$CamembertauCalvados r0 = p118io.presage.common.SdkType.f16924a
            io.presage.common.SdkType r5 = p118io.presage.common.SdkType.CamembertauCalvados.m21155a(r8)
            io.presage.h$CamembertauCalvados r0 = p118io.presage.C6502h.f17033a
            io.presage.h r6 = p118io.presage.C6502h.CamembertauCalvados.m21397a(r8)
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.Piastrellou.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public final Map<String, String> mo34587a() {
        Map<String, String> a = super.mo34587a();
        a.put("Api-Key", "[" + this.f16628b.mo34702a() + ']');
        a.put("Sdk-Version", "[3.3.9-moat]");
        a.put("Timezone", Taleggio.m20691e());
        a.put("Connectivity", this.f16629c.mo34696i());
        a.put("Sdk-Version-Type", "ads");
        a.put("Sdk-Type", String.valueOf(this.f16630d.mo34891a()));
        Langres langres = Langres.f16542a;
        a.put("Framework", String.valueOf(Langres.m20427a()));
        a.put("Mediation", this.f16631e.mo35514j());
        return a;
    }

    private Piastrellou(Context context, TetedeMoine tetedeMoine, Taleggio taleggio, TommeMarcdeRaisin tommeMarcdeRaisin, SdkType sdkType, C6502h hVar) {
        super(context, tetedeMoine, tommeMarcdeRaisin);
        this.f16627a = context;
        this.f16628b = tetedeMoine;
        this.f16629c = taleggio;
        this.f16630d = sdkType;
        this.f16631e = hVar;
    }
}
