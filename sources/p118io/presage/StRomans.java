package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

/* renamed from: io.presage.StRomans */
public final class StRomans {

    /* renamed from: a */
    public static final CamembertauCalvados f16690a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d */
    public static StRomans f16691d;

    /* renamed from: b */
    private final SharedPreferences f16692b;

    /* renamed from: c */
    private final Context f16693c;

    /* renamed from: io.presage.StRomans$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static StRomans m20680a(Context context) {
            if (StRomans.f16691d == null) {
                Context applicationContext = context.getApplicationContext();
                C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
                StRomans.f16691d = new StRomans(applicationContext, (byte) 0);
            }
            StRomans c = StRomans.f16691d;
            if (c == null) {
                C6514hl.m21413a();
            }
            return c;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private StRomans(Context context) {
        this.f16693c = context;
        this.f16692b = context.getSharedPreferences("mraid", 0);
    }

    /* renamed from: b */
    public final void mo34691b(String str) {
        this.f16692b.edit().putString("mraid_download_url", str).apply();
    }

    /* renamed from: a */
    public final void mo34689a(String str) {
        StringBuilder sb = new StringBuilder();
        File filesDir = this.f16693c.getFilesDir();
        C6514hl.m21414a((Object) filesDir, "context.filesDir");
        sb.append(filesDir.getPath().toString());
        sb.append("/mraidJs.txt");
        C6476ga.m21368a(new File(sb.toString()), str, C6548is.f17074a);
    }

    public /* synthetic */ StRomans(Context context, byte b) {
        this(context);
    }

    /* renamed from: a */
    public final String mo34688a() {
        SharedPreferences sharedPreferences = this.f16692b;
        C6514hl.m21414a((Object) sharedPreferences, "sharedPref");
        return C6217ah.m20780a(sharedPreferences, "mraid_download_url", "");
    }

    /* renamed from: b */
    public final String mo34690b() {
        StringBuilder sb = new StringBuilder();
        File filesDir = this.f16693c.getFilesDir();
        C6514hl.m21414a((Object) filesDir, "context.filesDir");
        sb.append(filesDir.getPath().toString());
        sb.append("/mraidJs.txt");
        File file = new File(sb.toString());
        return file.exists() ? C6476ga.m21366a(file, C6548is.f17074a) : "";
    }
}
