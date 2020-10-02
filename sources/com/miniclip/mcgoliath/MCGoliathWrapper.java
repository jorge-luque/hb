package com.miniclip.mcgoliath;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.miniclip.framework.AbstractActivityListener;
import com.miniclip.framework.Miniclip;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class MCGoliathWrapper extends AbstractActivityListener {
    private static String goliathFile = "mcgoliath_info.goliath";
    private static MCGoliathWrapper instance = new MCGoliathWrapper();
    private static final String uninitialized = "none";
    /* access modifiers changed from: private */
    public String advertisingID = uninitialized;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public boolean isLimitAdTrackingEnabled = false;

    /* renamed from: com.miniclip.mcgoliath.MCGoliathWrapper$a */
    class C4273a implements Runnable {
        C4273a() {
        }

        public void run() {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(MCGoliathWrapper.this.context);
                String unused = MCGoliathWrapper.this.advertisingID = advertisingIdInfo.getId();
                boolean unused2 = MCGoliathWrapper.this.isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception e) {
                Log.e("MCGoliathWrapper", "Failed to get advertising info!");
                String unused3 = MCGoliathWrapper.this.advertisingID = "";
                e.printStackTrace();
            }
        }
    }

    private MCGoliathWrapper() {
    }

    public static String advertisingID() {
        MCGoliathWrapper mCGoliathWrapper = instance;
        if (mCGoliathWrapper.context != null) {
            return mCGoliathWrapper.advertisingID;
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return "";
    }

    public static boolean advertisingTrackingEnabled() {
        return !instance.isLimitAdTrackingEnabled;
    }

    public static String applicationVersion() {
        Context context2 = instance.context;
        if (context2 == null) {
            Log.e("MCGoliathWrapper", "Context not initialized");
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(instance.context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String deviceArchitecture() {
        return System.getProperty("os.arch");
    }

    public static String deviceName() {
        return Build.MODEL;
    }

    public static String deviceType() {
        if (instance.context != null) {
            return isTablet() ? "Tablet" : "Phone";
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return "";
    }

    public static int displayHeight() {
        Context context2 = instance.context;
        if (context2 != null) {
            return context2.getResources().getDisplayMetrics().heightPixels;
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return 0;
    }

    public static String displayLanguage() {
        return Locale.getDefault().toString().split(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR)[0];
    }

    public static int displayWidth() {
        Context context2 = instance.context;
        if (context2 != null) {
            return context2.getResources().getDisplayMetrics().widthPixels;
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return 0;
    }

    private void init() {
        setContext(Miniclip.getActivity());
        Miniclip.addListener(this);
        if ("Amazon".equals(Build.MANUFACTURER)) {
            ContentResolver contentResolver = this.context.getContentResolver();
            int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i == 0) {
                this.advertisingID = Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
                this.isLimitAdTrackingEnabled = false;
            } else if (i == 2) {
                this.advertisingID = Settings.Secure.getString(this.context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
                this.isLimitAdTrackingEnabled = true;
            } else {
                this.advertisingID = Settings.Secure.getString(this.context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
                this.isLimitAdTrackingEnabled = true;
            }
        } else if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.context) == 0) {
            new Thread(new C4273a()).start();
        } else {
            this.advertisingID = "";
            Log.e("MCGoliathWrapper", "Google Play Services is not available in the device!");
        }
    }

    private static void initWrapper() {
        sharedInstance().init();
    }

    public static boolean isAdvertisingInitialized() {
        if (instance.context == null || advertisingID() == uninitialized) {
            return false;
        }
        return true;
    }

    public static boolean isTablet() {
        Context context2 = instance.context;
        if (context2 == null) {
            Log.e("MCGoliathWrapper", "Context not initialized");
            return false;
        }
        boolean z = (context2.getResources().getConfiguration().screenLayout & 15) == 4;
        boolean z2 = (instance.context.getResources().getConfiguration().screenLayout & 15) == 3;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public static String osVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String packageName() {
        Context context2 = instance.context;
        if (context2 != null) {
            return context2.getPackageName();
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return "";
    }

    private static String pathForSaveFile() {
        if (instance.context != null) {
            return new File(instance.context.getCacheDir(), goliathFile).getPath();
        }
        Log.e("MCGoliathWrapper", "Context not initialized");
        return "";
    }

    private void setContext(Context context2) {
        this.context = context2;
    }

    private static MCGoliathWrapper sharedInstance() {
        return instance;
    }

    private static native void startMCGoliathWrapperAndroid();

    private static native void stopMCGoliathWrapperAndroid();

    public static String timezone() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    public void onStart() {
        startMCGoliathWrapperAndroid();
    }

    public void onStop() {
        stopMCGoliathWrapperAndroid();
    }
}
