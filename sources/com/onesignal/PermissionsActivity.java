package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.drive.MetadataChangeSet;
import com.onesignal.C4461a;

public class PermissionsActivity extends Activity {

    /* renamed from: a */
    private static final String f12249a = PermissionsActivity.class.getCanonicalName();

    /* renamed from: b */
    static boolean f12250b;

    /* renamed from: c */
    static boolean f12251c;

    /* renamed from: d */
    private static C4461a.C4463b f12252d;

    /* renamed from: com.onesignal.PermissionsActivity$a */
    class C4459a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int[] f12253a;

        C4459a(int[] iArr) {
            this.f12253a = iArr;
        }

        public void run() {
            int[] iArr = this.f12253a;
            boolean z = false;
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            C4686w.m16322a(true, z);
            if (z) {
                C4686w.m16335j();
            } else {
                C4686w.m16330e();
            }
        }
    }

    /* renamed from: com.onesignal.PermissionsActivity$b */
    static class C4460b extends C4461a.C4463b {
        C4460b() {
        }

        /* renamed from: a */
        public void mo29683a(Activity activity) {
            if (!activity.getClass().equals(PermissionsActivity.class)) {
                Intent intent = new Intent(activity, PermissionsActivity.class);
                intent.setFlags(MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES);
                activity.startActivity(intent);
                activity.overridePendingTransition(R$anim.onesignal_fade_in, R$anim.onesignal_fade_out);
            }
        }
    }

    /* renamed from: a */
    private void m15366a() {
        if (Build.VERSION.SDK_INT < 23) {
            finish();
            overridePendingTransition(R$anim.onesignal_fade_in, R$anim.onesignal_fade_out);
        } else if (!f12250b) {
            f12250b = true;
            C4494e.m15479a(this, new String[]{C4686w.f12739c}, 2);
        }
    }

    /* renamed from: b */
    static void m15367b() {
        if (!f12250b && !f12251c) {
            C4460b bVar = new C4460b();
            f12252d = bVar;
            C4461a.m15376a(f12249a, (C4461a.C4463b) bVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4564n1.m15865k(this);
        if (bundle == null || !bundle.getBoolean("android:hasCurrentPermissionsRequest", false)) {
            m15366a();
        } else {
            f12250b = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (C4564n1.m15772V()) {
            m15366a();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f12251c = true;
        f12250b = false;
        if (i == 2) {
            new Handler().postDelayed(new C4459a(iArr), 500);
        }
        C4461a.m15375a(f12249a);
        finish();
        overridePendingTransition(R$anim.onesignal_fade_in, R$anim.onesignal_fade_out);
    }
}
