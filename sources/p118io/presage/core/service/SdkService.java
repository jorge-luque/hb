package p118io.presage.core.service;

import admost.sdk.base.AdMost;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import p118io.presage.core.C6317j1;
import p118io.presage.core.IIIIIIll;
import p118io.presage.core.IIIIlIlI;
import p118io.presage.core.IIIIlIll;

/* renamed from: io.presage.core.service.SdkService */
public class SdkService extends Service implements IIIIlIlI {
    public Context IIIIIIII;
    public IIIIIIll IIIIIIIl;
    public Handler IIIIIIlI;
    public BroadcastReceiver IIIIIIll;
    public boolean IIIIIlII;
    public boolean IIIIIlIl;

    /* renamed from: io.presage.core.service.SdkService$IIIIIIII */
    public class IIIIIIII implements C6317j1 {
        public final /* synthetic */ Intent IIIIIIII;

        /* renamed from: io.presage.core.service.SdkService$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6863IIIIIIII extends BroadcastReceiver {

            /* renamed from: io.presage.core.service.SdkService$IIIIIIII$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
            public class C6864IIIIIIII implements Runnable {
                public C6864IIIIIIII() {
                }

                public void run() {
                    SdkService sdkService = SdkService.this;
                    sdkService.IIIIIIIl.IIIIIIII(false, sdkService, AdMost.AD_ERROR_WATERFALL_EMPTY);
                }
            }

            public C6863IIIIIIII() {
            }

            public void onReceive(Context context, Intent intent) {
                intent.getAction();
                SdkService.this.IIIIIIlI.postDelayed(new C6864IIIIIIII(), 50);
            }
        }

        public IIIIIIII(Intent intent) {
            this.IIIIIIII = intent;
        }

        public void IIIIIIII(boolean z, Exception exc) {
            boolean unused = SdkService.this.IIIIIlIl = false;
            if (z) {
                SdkService sdkService = SdkService.this;
                if (!sdkService.IIIIIlII) {
                    boolean unused2 = sdkService.IIIIIlII = true;
                    SdkService sdkService2 = SdkService.this;
                    Context context = sdkService2.IIIIIIII;
                    if (IIIIIIll.IIIIIIll == null) {
                        IIIIIIll.IIIIIIll = new IIIIIIll(context);
                    }
                    sdkService2.IIIIIIIl = IIIIIIll.IIIIIIll;
                    SdkService.this.IIIIIIlI = new Handler();
                    SdkService.this.IIIIIIll = new C6863IIIIIIII();
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                    SdkService sdkService3 = SdkService.this;
                    sdkService3.registerReceiver(sdkService3.IIIIIIll, intentFilter);
                }
                String action = this.IIIIIIII.getAction();
                int i = this.IIIIIIII.getExtras() != null ? this.IIIIIIII.getExtras().getInt("c133dd6f") : -1;
                if (action.equals("80437a44")) {
                    if (this.IIIIIIII.getExtras() != null) {
                        SdkService.this.IIIIIIIl.IIIIIIII(0, SdkService.this, i, this.IIIIIIII.getExtras().getString("0f902406"));
                    }
                } else if (action.equals("2b020927")) {
                    SdkService sdkService4 = SdkService.this;
                    sdkService4.IIIIIIIl.IIIIIIII(1, sdkService4, i, new Object[0]);
                } else if (action.equals("df77b6b3")) {
                    SdkService sdkService5 = SdkService.this;
                    sdkService5.IIIIIIIl.IIIIIIII(2, sdkService5, i, new Object[0]);
                }
            }
        }
    }

    public void IIIIIIII() {
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.IIIIIlII = false;
        this.IIIIIlIl = false;
    }

    public void onDestroy() {
        try {
            if (this.IIIIIIll != null) {
                unregisterReceiver(this.IIIIIIll);
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!(intent == null || intent.getAction() == null)) {
            this.IIIIIIII = getApplicationContext();
            try {
                if (this.IIIIIlIl) {
                    return 2;
                }
                this.IIIIIlIl = true;
                IIIIlIll.IIIIIIII((C6317j1) new IIIIIIII(intent));
            } catch (Exception unused) {
            }
        }
        return 2;
    }
}
