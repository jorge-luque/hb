package p118io.presage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.places.model.PlaceFields;
import java.lang.reflect.Constructor;
import java.util.Locale;
import java.util.MissingResourceException;
import p118io.presage.C6502h;

/* renamed from: io.presage.TetedeMoine */
public final class TetedeMoine {

    /* renamed from: a */
    public static final CamembertauCalvados f16701a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final Context f16702b;

    /* renamed from: c */
    private final C6502h f16703c;

    /* renamed from: io.presage.TetedeMoine$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private TetedeMoine(Context context, C6502h hVar) {
        this.f16702b = context;
        this.f16703c = hVar;
    }

    /* renamed from: h */
    private final String m20701h() {
        try {
            Object systemService = this.f16702b.getSystemService(PlaceFields.PHONE);
            if (systemService != null) {
                return new Locale("", ((TelephonyManager) systemService).getNetworkCountryIso()).getISO3Country();
            }
            throw new C6434em("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: i */
    private final String m20702i() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Resources resources = this.f16702b.getResources();
                C6514hl.m21414a((Object) resources, "context.resources");
                Configuration configuration = resources.getConfiguration();
                C6514hl.m21414a((Object) configuration, "context.resources.configuration");
                Locale locale = configuration.getLocales().get(0);
                C6514hl.m21414a((Object) locale, "context.resources.configuration.locales[0]");
                String iSO3Country = locale.getISO3Country();
                C6514hl.m21414a((Object) iSO3Country, "context.resources.config…on.locales[0].isO3Country");
                return iSO3Country;
            }
            Resources resources2 = this.f16702b.getResources();
            C6514hl.m21414a((Object) resources2, "context.resources");
            Locale locale2 = resources2.getConfiguration().locale;
            C6514hl.m21414a((Object) locale2, "context.resources.configuration.locale");
            String iSO3Country2 = locale2.getISO3Country();
            C6514hl.m21414a((Object) iSO3Country2, "context.resources.configuration.locale.isO3Country");
            return iSO3Country2;
        } catch (MissingResourceException unused) {
            return "ZZZ";
        }
    }

    /* renamed from: a */
    public final boolean mo34703a(String str) {
        return C6214ae.m20773a(this.f16702b, str);
    }

    /* renamed from: b */
    public final String mo34704b() {
        if (Build.VERSION.SDK_INT >= 24) {
            Resources resources = this.f16702b.getResources();
            C6514hl.m21414a((Object) resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            C6514hl.m21414a((Object) configuration, "context.resources.configuration");
            Locale locale = configuration.getLocales().get(0);
            C6514hl.m21414a((Object) locale, "context.resources.configuration.locales[0]");
            String language = locale.getLanguage();
            C6514hl.m21414a((Object) language, "context.resources.config…ation.locales[0].language");
            return language;
        }
        Resources resources2 = this.f16702b.getResources();
        C6514hl.m21414a((Object) resources2, "context.resources");
        Locale locale2 = resources2.getConfiguration().locale;
        C6514hl.m21414a((Object) locale2, "context.resources.configuration.locale");
        String language2 = locale2.getLanguage();
        C6514hl.m21414a((Object) language2, "context.resources.configuration.locale.language");
        return language2;
    }

    /* renamed from: c */
    public final String mo34705c() {
        String h = m20701h();
        if (h == null || h.length() != 3) {
            return m20702i();
        }
        return h;
    }

    /* renamed from: d */
    public final String mo34706d() {
        return "3.3.9-moat/" + mo34702a() + "/" + Build.VERSION.RELEASE;
    }

    /* renamed from: e */
    public final String mo34707e() {
        String packageName = this.f16702b.getPackageName();
        C6514hl.m21414a((Object) packageName, "context.packageName");
        return packageName;
    }

    /* renamed from: f */
    public final String mo34708f() {
        String str;
        Constructor<WebSettings> declaredConstructor;
        if (Build.VERSION.SDK_INT >= 17) {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f16702b);
            C6514hl.m21414a((Object) defaultUserAgent, "WebSettings.getDefaultUserAgent(context)");
            return defaultUserAgent;
        }
        try {
            declaredConstructor = WebSettings.class.getDeclaredConstructor(new Class[]{Context.class, WebView.class});
            C6514hl.m21414a((Object) declaredConstructor, "WebSettings::class.java.…ava, WebView::class.java)");
            declaredConstructor.setAccessible(true);
            WebSettings newInstance = declaredConstructor.newInstance(new Object[]{this.f16702b, null});
            C6514hl.m21414a((Object) newInstance, "constructor.newInstance(context, null)");
            str = newInstance.getUserAgentString();
            declaredConstructor.setAccessible(false);
        } catch (Exception unused) {
            WebSettings settings = new WebView(this.f16702b).getSettings();
            C6514hl.m21414a((Object) settings, "WebView(context).settings");
            str = settings.getUserAgentString();
        } catch (Throwable th) {
            declaredConstructor.setAccessible(false);
            throw th;
        }
        C6514hl.m21414a((Object) str, "try {\n            val co…userAgentString\n        }");
        return str;
    }

    /* renamed from: g */
    public final Context mo34709g() {
        return this.f16702b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TetedeMoine(Context context) {
        this(context, C6502h.CamembertauCalvados.m21397a(context));
        C6502h.CamembertauCalvados camembertauCalvados = C6502h.f17033a;
    }

    /* renamed from: a */
    public final String mo34702a() {
        return this.f16703c.mo35513i();
    }
}
