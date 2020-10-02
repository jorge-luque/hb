package p118io.presage;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: io.presage.PaletdeBourgogne */
public class PaletdeBourgogne implements C6405dk {

    /* renamed from: a */
    private final Context f16602a;

    /* renamed from: b */
    private final TetedeMoine f16603b;

    /* renamed from: c */
    private final TommeMarcdeRaisin f16604c;

    public PaletdeBourgogne(Context context, TetedeMoine tetedeMoine, TommeMarcdeRaisin tommeMarcdeRaisin) {
        this.f16602a = context;
        this.f16603b = tetedeMoine;
        this.f16604c = tommeMarcdeRaisin;
    }

    /* renamed from: a */
    public Map<String, String> mo34587a() {
        C6263c a = TommeMarcdeRaisin.m20712a(this.f16602a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Content-Type", C6078a.ACCEPT_JSON_VALUE);
        linkedHashMap.put("Accept-Encoding", "gzip");
        linkedHashMap.put("Content-Encoding", "gzip");
        linkedHashMap.put("Device-OS", "android");
        linkedHashMap.put("User", a.mo34854a());
        linkedHashMap.put(C6078a.HEADER_USER_AGENT, this.f16603b.mo34706d());
        linkedHashMap.put("Package-Name", this.f16603b.mo34707e());
        return linkedHashMap;
    }

    public /* synthetic */ PaletdeBourgogne(Context context) {
        this(context, new TetedeMoine(context), TommeMarcdeRaisin.f16705a);
    }
}
