package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import com.google.android.gms.drive.DriveFile;
import java.util.Collection;
import java.util.List;
import p118io.presage.mraid.browser.Android8AndLaterShortcutActivity;
import p118io.presage.mraid.browser.ShortcutActivity;

/* renamed from: io.presage.bn */
public final class C6250bn {

    /* renamed from: a */
    public static final CamembertauCalvados f16828a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private ShortcutInfo f16829b;

    /* renamed from: c */
    private Context f16830c;

    /* renamed from: d */
    private final C6386cs f16831d;

    /* renamed from: e */
    private final C6575u f16832e;

    /* renamed from: f */
    private C6259bw f16833f;

    /* renamed from: g */
    private C6252bp f16834g;

    /* renamed from: io.presage.bn$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private C6250bn(Context context, C6386cs csVar, C6575u uVar, C6259bw bwVar, C6252bp bpVar) {
        this.f16830c = context;
        this.f16831d = csVar;
        this.f16832e = uVar;
        this.f16833f = bwVar;
        this.f16834g = bpVar;
    }

    /* renamed from: b */
    private final Bitmap m20956b() {
        return C6575u.m21572a(this.f16831d.mo35313d());
    }

    /* renamed from: a */
    public final void mo34810a() {
        Bitmap b;
        if (!this.f16831d.mo35310a() && (b = m20956b()) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f16829b = m20952a(b);
                ShortcutManager a = C6259bw.m21014a(this.f16830c);
                ShortcutInfo shortcutInfo = this.f16829b;
                if (shortcutInfo == null) {
                    C6514hl.m21415a("shortcutInfo");
                }
                String id = shortcutInfo.getId();
                C6514hl.m21414a((Object) id, "shortcutInfo.id");
                if (m20955a(a, id)) {
                    ShortcutInfo shortcutInfo2 = this.f16829b;
                    if (shortcutInfo2 == null) {
                        C6514hl.m21415a("shortcutInfo");
                    }
                    m20958b(shortcutInfo2, a);
                } else {
                    ShortcutInfo shortcutInfo3 = this.f16829b;
                    if (shortcutInfo3 == null) {
                        C6514hl.m21415a("shortcutInfo");
                    }
                    m20953a(shortcutInfo3, a);
                }
            } else {
                if (this.f16834g.mo34812a(this.f16831d.mo35311b()) || this.f16834g.mo34814c(this.f16831d.mo35311b())) {
                    m20954a(this.f16831d.mo35312c());
                }
                m20957b(b);
            }
            this.f16834g.mo34811a(this.f16831d.mo35311b(), this.f16831d.mo35314e());
        }
    }

    public /* synthetic */ C6250bn(Context context, C6386cs csVar) {
        this(context, csVar, new C6575u(), new C6259bw(), new C6252bp(context));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static boolean m20958b(ShortcutInfo shortcutInfo, ShortcutManager shortcutManager) {
        return shortcutManager.updateShortcuts(C6446ey.m21315a(shortcutInfo));
    }

    /* renamed from: b */
    private final void m20957b(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.shortcut.INTENT", m20951a((Class<?>) ShortcutActivity.class));
        intent.putExtra("android.intent.extra.shortcut.NAME", this.f16831d.mo35312c());
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        try {
            this.f16830c.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m20955a(ShortcutManager shortcutManager, String str) {
        List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
        C6514hl.m21414a((Object) pinnedShortcuts, "shortcutManager.pinnedShortcuts");
        if ((pinnedShortcuts instanceof Collection) && pinnedShortcuts.isEmpty()) {
            return false;
        }
        for (ShortcutInfo shortcutInfo : pinnedShortcuts) {
            C6514hl.m21414a((Object) shortcutInfo, "it");
            if (C6514hl.m21416a((Object) str, (Object) shortcutInfo.getId())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private final ShortcutInfo m20952a(Bitmap bitmap) {
        ShortcutInfo build = new ShortcutInfo.Builder(this.f16830c, this.f16831d.mo35311b()).setShortLabel(this.f16831d.mo35312c()).setIcon(Icon.createWithBitmap(bitmap)).setIntent(m20951a((Class<?>) Android8AndLaterShortcutActivity.class)).build();
        C6514hl.m21414a((Object) build, "ShortcutInfo.Builder(con…va))\n            .build()");
        return build;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static void m20953a(ShortcutInfo shortcutInfo, ShortcutManager shortcutManager) {
        if (shortcutManager.isRequestPinShortcutSupported()) {
            shortcutManager.requestPinShortcut(shortcutInfo, (IntentSender) null);
        }
    }

    /* renamed from: a */
    private final Intent m20951a(Class<?> cls) {
        Intent intent = new Intent(this.f16830c.getApplicationContext(), cls);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.addFlags(32768);
        intent.putExtra("identifier", this.f16831d.mo35311b());
        intent.addFlags(8388608);
        intent.addFlags(67108864);
        intent.setAction("android.intent.action.MAIN");
        return intent;
    }

    /* renamed from: a */
    private final void m20954a(String str) {
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.shortcut.NAME", str);
        intent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        try {
            this.f16830c.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }
}
