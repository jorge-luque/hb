package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ShortcutManager;

/* renamed from: io.presage.bw */
public final class C6259bw {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static ShortcutManager m21014a(Context context) {
        Object systemService = context.getSystemService(ShortcutManager.class);
        C6514hl.m21414a(systemService, "context.getSystemService…rtcutManager::class.java)");
        return (ShortcutManager) systemService;
    }
}
