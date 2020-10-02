package com.criteo.publisher.p057p;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.criteo.publisher.p056o.C2496a;
import com.google.android.gms.drive.DriveFile;

/* renamed from: com.criteo.publisher.p.b */
public class C2500b {

    /* renamed from: a */
    private final Context f7992a;

    /* renamed from: com.criteo.publisher.p.b$a */
    private static class C2501a extends C2496a {

        /* renamed from: a */
        private final Application f7993a;

        /* renamed from: b */
        private final ComponentName f7994b;

        /* renamed from: c */
        private C2502c f7995c;

        public C2501a(Application application, ComponentName componentName, C2502c cVar) {
            this.f7993a = application;
            this.f7994b = componentName;
            this.f7995c = cVar;
        }

        public void onActivityResumed(Activity activity) {
            C2502c cVar;
            if (this.f7994b.equals(activity.getComponentName()) && (cVar = this.f7995c) != null) {
                cVar.mo10106a();
                this.f7993a.unregisterActivityLifecycleCallbacks(this);
                this.f7995c = null;
            }
        }
    }

    public C2500b(Context context) {
        this.f7992a = context;
    }

    /* renamed from: a */
    public void mo10507a(String str, ComponentName componentName, C2502c cVar) {
        Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(DriveFile.MODE_READ_ONLY);
        if (this.f7992a.getPackageManager().queryIntentActivities(addFlags, 65536).size() > 0) {
            this.f7992a.startActivity(addFlags);
            cVar.mo10107b();
            if (componentName != null) {
                Application application = (Application) this.f7992a.getApplicationContext();
                application.registerActivityLifecycleCallbacks(new C2501a(application, componentName, cVar));
            }
        }
    }
}
