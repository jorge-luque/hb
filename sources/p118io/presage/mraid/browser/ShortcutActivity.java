package p118io.presage.mraid.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;
import p118io.presage.C6249bm;
import p118io.presage.C6250bn;
import p118io.presage.C6251bo;
import p118io.presage.C6252bp;
import p118io.presage.C6384cq;
import p118io.presage.C6386cs;
import p118io.presage.C6437ep;
import p118io.presage.C6481gf;
import p118io.presage.C6514hl;
import p118io.presage.C6515hm;
import p118io.presage.FourmedeMontbrison;
import p118io.presage.Livarot;

/* renamed from: io.presage.mraid.browser.ShortcutActivity */
public class ShortcutActivity extends Activity implements Livarot {

    /* renamed from: a */
    public static final CamembertauCalvados f17119a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private C6249bm f17120b;

    /* renamed from: io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados */
    public static final class CamembertauCalvados {

        /* renamed from: io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados$CamembertauCalvados  reason: collision with other inner class name */
        static final class C6865CamembertauCalvados extends C6515hm implements C6481gf<C6437ep> {

            /* renamed from: a */
            final /* synthetic */ Context f17121a;

            /* renamed from: b */
            final /* synthetic */ C6386cs f17122b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C6865CamembertauCalvados(Context context, C6386cs csVar) {
                super(0);
                this.f17121a = context;
                this.f17122b = csVar;
            }

            /* renamed from: b */
            private void m21552b() {
                new C6250bn(this.f17121a, this.f17122b).mo34810a();
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo34405a() {
                m21552b();
                return C6437ep.f17017a;
            }
        }

        /* renamed from: io.presage.mraid.browser.ShortcutActivity$CamembertauCalvados$CamembertdeNormandie */
        static final class CamembertdeNormandie extends C6515hm implements C6481gf<C6437ep> {

            /* renamed from: a */
            public static final CamembertdeNormandie f17123a = new CamembertdeNormandie();

            CamembertdeNormandie() {
                super(0);
            }

            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Object mo34405a() {
                return C6437ep.f17017a;
            }
        }

        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static void m21551a(Context context, C6386cs csVar) {
            FourmedeMontbrison.CamembertauCalvados camembertauCalvados = FourmedeMontbrison.f16513a;
            FourmedeMontbrison.CamembertauCalvados.m20398a(new C6865CamembertauCalvados(context, csVar)).mo34555a((C6481gf<C6437ep>) CamembertdeNormandie.f17123a);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.mraid.browser.ShortcutActivity$CamembertdeNormandie */
    static final class CamembertdeNormandie extends C6515hm implements C6481gf<C6437ep> {

        /* renamed from: a */
        final /* synthetic */ ShortcutActivity f17124a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertdeNormandie(ShortcutActivity shortcutActivity) {
            super(0);
            this.f17124a = shortcutActivity;
        }

        /* renamed from: b */
        private void m21555b() {
            this.f17124a.finish();
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34405a() {
            m21555b();
            return C6437ep.f17017a;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        String string;
        Bundle extras2;
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        Intent intent = getIntent();
        String str2 = "";
        if (intent == null || (extras2 = intent.getExtras()) == null || (str = extras2.getString("args", str2)) == null) {
            str = str2;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || (string = extras.getString("identifier", str2)) == null)) {
            str2 = string;
        }
        Context applicationContext = getApplicationContext();
        C6514hl.m21414a((Object) applicationContext, "this.applicationContext");
        C6249bm bmVar = new C6249bm(new C6252bp(this), this, new C6384cq(applicationContext, new C6251bo(this), new CamembertdeNormandie(this)));
        this.f17120b = bmVar;
        if (!bmVar.mo34809a(str, str2, frameLayout)) {
            Toast.makeText(this, "Invalid shortcut", 0).show();
            finish();
            return;
        }
        setContentView(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C6249bm bmVar = this.f17120b;
        if (bmVar != null) {
            bmVar.mo34808a();
        }
    }
}
