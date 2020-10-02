package p093e.p097b.p098a.p099a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.List;
import p093e.p097b.p098a.p100b.C3376a;
import p093e.p101c.p102a.p111b.p112a.C3476a;

/* renamed from: e.b.a.a.b */
/* compiled from: InstallReferrerClientImpl */
class C3371b extends C3368a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f9431a = 0;

    /* renamed from: b */
    private final Context f9432b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C3476a f9433c;

    /* renamed from: d */
    private ServiceConnection f9434d;

    /* renamed from: e.b.a.a.b$b */
    /* compiled from: InstallReferrerClientImpl */
    private final class C3373b implements ServiceConnection {

        /* renamed from: a */
        private final C3374c f9435a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C3376a.m11255a("InstallReferrerClient", "Install Referrer service connected.");
            C3476a unused = C3371b.this.f9433c = C3476a.C3477a.m11526a(iBinder);
            int unused2 = C3371b.this.f9431a = 2;
            this.f9435a.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C3376a.m11256b("InstallReferrerClient", "Install Referrer service disconnected.");
            C3476a unused = C3371b.this.f9433c = null;
            int unused2 = C3371b.this.f9431a = 0;
            this.f9435a.onInstallReferrerServiceDisconnected();
        }

        private C3373b(C3374c cVar) {
            if (cVar != null) {
                this.f9435a = cVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    public C3371b(Context context) {
        this.f9432b = context.getApplicationContext();
    }

    /* renamed from: c */
    private boolean m11248c() {
        try {
            if (this.f9432b.getPackageManager().getPackageInfo("com.android.vending", OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo19133b() {
        return (this.f9431a != 2 || this.f9433c == null || this.f9434d == null) ? false : true;
    }

    /* renamed from: a */
    public void mo19131a(C3374c cVar) {
        ServiceInfo serviceInfo;
        if (mo19133b()) {
            C3376a.m11255a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f9431a;
        if (i == 1) {
            C3376a.m11256b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
        } else if (i == 3) {
            C3376a.m11256b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
        } else {
            C3376a.m11255a("InstallReferrerClient", "Starting install referrer service setup.");
            this.f9434d = new C3373b(cVar);
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f9432b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null) {
                this.f9431a = 0;
                C3376a.m11255a("InstallReferrerClient", "Install Referrer service unavailable on device.");
                cVar.onInstallReferrerSetupFinished(2);
                return;
            }
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null || !m11248c()) {
                C3376a.m11256b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.f9431a = 0;
                cVar.onInstallReferrerSetupFinished(2);
                return;
            }
            if (this.f9432b.bindService(new Intent(intent), this.f9434d, 1)) {
                C3376a.m11255a("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            C3376a.m11256b("InstallReferrerClient", "Connection to service is blocked.");
            this.f9431a = 0;
            cVar.onInstallReferrerSetupFinished(1);
        }
    }

    /* renamed from: a */
    public C3375d mo19130a() throws RemoteException {
        if (mo19133b()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f9432b.getPackageName());
            try {
                return new C3375d(this.f9433c.mo19257a(bundle));
            } catch (RemoteException e) {
                C3376a.m11256b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f9431a = 0;
                throw e;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }
}
