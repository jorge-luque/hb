package com.onesignal;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.browser.p012a.C0645b;
import androidx.browser.p012a.C0646c;
import androidx.browser.p012a.C0653d;
import androidx.browser.p012a.C0655e;
import androidx.browser.p012a.C0657f;
import com.google.android.gms.drive.DriveFile;
import java.util.List;

/* renamed from: com.onesignal.r1 */
/* compiled from: OneSignalChromeTab */
class C4637r1 {

    /* renamed from: com.onesignal.r1$a */
    /* compiled from: OneSignalChromeTab */
    private static class C4638a extends C0655e {

        /* renamed from: b */
        private String f12642b;

        /* renamed from: c */
        private boolean f12643c;

        C4638a(String str, boolean z) {
            this.f12642b = str;
            this.f12643c = z;
        }

        /* renamed from: a */
        public void mo3657a(ComponentName componentName, C0646c cVar) {
            if (cVar != null) {
                cVar.mo3648a(0);
                C0657f a = cVar.mo3647a((C0645b) null);
                if (a != null) {
                    Uri parse = Uri.parse(this.f12642b);
                    a.mo3661a(parse, (Bundle) null, (List<Bundle>) null);
                    if (this.f12643c) {
                        C0653d a2 = new C0653d.C0654a(a).mo3656a();
                        a2.f1619a.setData(parse);
                        a2.f1619a.addFlags(DriveFile.MODE_READ_ONLY);
                        if (Build.VERSION.SDK_INT >= 16) {
                            C4564n1.f12495e.startActivity(a2.f1619a, a2.f1620b);
                        } else {
                            C4564n1.f12495e.startActivity(a2.f1619a);
                        }
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    private static boolean m16077a() {
        Class<C0655e> cls = C0655e.class;
        return true;
    }

    /* renamed from: a */
    protected static boolean m16078a(String str, boolean z) {
        if (!m16077a()) {
            return false;
        }
        return C0646c.m1900a(C4564n1.f12495e, "com.android.chrome", new C4638a(str, z));
    }
}
