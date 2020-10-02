package p118io.presage;

import android.content.Context;
import java.util.Map;

/* renamed from: io.presage.Murol */
public final class Murol extends PaletdeBourgogne {

    /* renamed from: a */
    private final Context f16593a;

    /* renamed from: b */
    private final TetedeMoine f16594b;

    /* renamed from: c */
    private final Taleggio f16595c;

    public /* synthetic */ Murol(Context context) {
        this(context, new TetedeMoine(context), new Taleggio(context), TommeMarcdeRaisin.f16705a);
    }

    /* renamed from: a */
    public final Map<String, String> mo34587a() {
        Map<String, String> a = super.mo34587a();
        a.put("WebView-User-Agent", this.f16594b.mo34708f());
        a.put("Orientation", this.f16595c.mo34700m());
        return a;
    }

    private Murol(Context context, TetedeMoine tetedeMoine, Taleggio taleggio, TommeMarcdeRaisin tommeMarcdeRaisin) {
        super(context, tetedeMoine, tommeMarcdeRaisin);
        this.f16593a = context;
        this.f16594b = tetedeMoine;
        this.f16595c = taleggio;
    }
}
