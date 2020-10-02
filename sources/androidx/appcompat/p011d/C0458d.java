package androidx.appcompat.p011d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* renamed from: androidx.appcompat.d.d */
/* compiled from: ContextThemeWrapper */
public class C0458d extends ContextWrapper {

    /* renamed from: a */
    private int f645a;

    /* renamed from: b */
    private Resources.Theme f646b;

    /* renamed from: c */
    private LayoutInflater f647c;

    /* renamed from: d */
    private Configuration f648d;

    /* renamed from: e */
    private Resources f649e;

    public C0458d() {
        super((Context) null);
    }

    /* renamed from: b */
    private Resources m748b() {
        if (this.f649e == null) {
            Configuration configuration = this.f648d;
            if (configuration == null) {
                this.f649e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f649e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f649e;
    }

    /* renamed from: c */
    private void m749c() {
        boolean z = this.f646b == null;
        if (z) {
            this.f646b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f646b.setTo(theme);
            }
        }
        mo2304a(this.f646b, this.f645a, z);
    }

    /* renamed from: a */
    public int mo2303a() {
        return this.f645a;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return m748b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f647c == null) {
            this.f647c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f647c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f646b;
        if (theme != null) {
            return theme;
        }
        if (this.f645a == 0) {
            this.f645a = R$style.Theme_AppCompat_Light;
        }
        m749c();
        return this.f646b;
    }

    public void setTheme(int i) {
        if (this.f645a != i) {
            this.f645a = i;
            m749c();
        }
    }

    public C0458d(Context context, int i) {
        super(context);
        this.f645a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2304a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public C0458d(Context context, Resources.Theme theme) {
        super(context);
        this.f646b = theme;
    }
}
