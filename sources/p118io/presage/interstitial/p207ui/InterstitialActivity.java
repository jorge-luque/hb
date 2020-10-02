package p118io.presage.interstitial.p207ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p118io.presage.AbbayedeCiteauxentiere;
import p118io.presage.AffideliceauChablis;
import p118io.presage.BleudeGex;
import p118io.presage.C6226aq;
import p118io.presage.C6237ba;
import p118io.presage.C6238bb;
import p118io.presage.C6434em;
import p118io.presage.C6514hl;
import p118io.presage.C6519hq;
import p118io.presage.CamembertdeNormandie;
import p118io.presage.Laguiole;
import p118io.presage.Livarot;
import p118io.presage.PontlEveque;
import p118io.presage.SaintNectaire;

/* renamed from: io.presage.interstitial.ui.InterstitialActivity */
public class InterstitialActivity extends Activity implements Livarot {

    /* renamed from: a */
    public static final CamembertauCalvados f17069a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private AbbayedeCiteauxentiere f17070b;

    /* renamed from: c */
    private Laguiole f17071c = Laguiole.f16541a;

    /* renamed from: d */
    private boolean f17072d;

    /* renamed from: io.presage.interstitial.ui.InterstitialActivity$CamembertauCalvados */
    public static final class CamembertauCalvados implements BleudeGex {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public final void mo34456a(Context context, String str, PontlEveque pontlEveque, List<PontlEveque> list) {
            Intent a = m21458a(pontlEveque, list, context);
            a.putExtra("mode", 1);
            a.putExtra("expand_cache_item_id", str);
            context.startActivity(a);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo34455a(Context context, PontlEveque pontlEveque, List<PontlEveque> list) {
            context.startActivity(m21458a(pontlEveque, list, context));
        }

        /* renamed from: a */
        private static Intent m21458a(PontlEveque pontlEveque, List<PontlEveque> list, Context context) {
            Intent intent = new Intent(context, m21459a(pontlEveque));
            intent.putExtra("ad", pontlEveque);
            intent.putExtra("not_displayed_ads", new ArrayList(list));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            return intent;
        }

        /* renamed from: a */
        private static Class<?> m21459a(PontlEveque pontlEveque) {
            if (m21460a()) {
                return InterstitialActivity.class;
            }
            if (pontlEveque.mo34638n()) {
                return InterstitialAndroid8TransparentActivity.class;
            }
            return InterstitialAndroid8RotableActivity.class;
        }

        /* renamed from: a */
        private static boolean m21460a() {
            return Build.VERSION.SDK_INT != 26;
        }
    }

    /* renamed from: a */
    private final PontlEveque m21452a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("ad");
        if (!(serializableExtra instanceof PontlEveque)) {
            serializableExtra = null;
        }
        return (PontlEveque) serializableExtra;
    }

    /* renamed from: a */
    private static boolean m21453a(Bundle bundle) {
        return bundle != null;
    }

    /* renamed from: b */
    private final List<PontlEveque> m21454b() {
        Serializable serializableExtra = getIntent().getSerializableExtra("not_displayed_ads");
        if (serializableExtra != null) {
            return C6519hq.m21430b(serializableExtra);
        }
        throw new C6434em("null cannot be cast to non-null type kotlin.collections.MutableList<io.presage.common.network.models.Ad>");
    }

    /* renamed from: c */
    private final void m21455c() {
        getWindow().setFlags(16777216, 16777216);
    }

    /* renamed from: d */
    private final void m21456d() {
        PontlEveque a = m21452a();
        if (a != null) {
            C6238bb bbVar = C6238bb.f16782a;
            C6238bb.m20878a(new C6237ba(a.mo34607b(), "adClosed"));
            C6238bb bbVar2 = C6238bb.f16782a;
            C6238bb.m20879a(a.mo34607b());
        }
    }

    public void onBackPressed() {
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f17070b;
        if (abbayedeCiteauxentiere != null ? abbayedeCiteauxentiere.mo34394k() : true) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m21453a(bundle)) {
            finish();
            return;
        }
        m21455c();
        try {
            List<PontlEveque> b = m21454b();
            PontlEveque a = m21452a();
            if (a != null) {
                this.f17072d = SaintNectaire.m20661a(a);
                Intent intent = getIntent();
                C6514hl.m21414a((Object) intent, "intent");
                C6226aq aqVar = new C6226aq(this, intent, a, b);
                CamembertdeNormandie a2 = aqVar.mo34742a();
                a2.setDisplayedInFullScreen(true);
                this.f17070b = aqVar.mo34743b();
                setContentView(a2);
                return;
            }
            throw new IllegalStateException("Ad not sent to interstitial activity");
        } catch (Throwable th) {
            Laguiole.m20426a(th);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f17070b;
        if (abbayedeCiteauxentiere == null) {
            m21456d();
        } else if (abbayedeCiteauxentiere != null) {
            abbayedeCiteauxentiere.mo34393j();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f17072d) {
            AffideliceauChablis affideliceauChablis = AffideliceauChablis.f16369a;
            AffideliceauChablis.m20199b(false);
        }
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f17072d) {
            AffideliceauChablis affideliceauChablis = AffideliceauChablis.f16369a;
            AffideliceauChablis.m20199b(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f17070b;
        if (abbayedeCiteauxentiere != null) {
            abbayedeCiteauxentiere.mo34392i();
        }
    }

    /* renamed from: a */
    public void mo35550a(PontlEveque pontlEveque) {
        String str = null;
        if (C6514hl.m21416a((Object) pontlEveque != null ? pontlEveque.mo34613d() : null, (Object) TJAdUnitConstants.String.LANDSCAPE)) {
            setRequestedOrientation(0);
            return;
        }
        if (pontlEveque != null) {
            str = pontlEveque.mo34613d();
        }
        if (C6514hl.m21416a((Object) str, (Object) TJAdUnitConstants.String.PORTRAIT)) {
            setRequestedOrientation(1);
        }
    }
}
