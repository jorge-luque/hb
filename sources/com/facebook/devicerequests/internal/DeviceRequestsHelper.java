package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.zxing.C4061a;
import com.google.zxing.C4063c;
import com.google.zxing.C4067d;
import com.google.zxing.WriterException;
import com.google.zxing.p134g.C4080b;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = "com.facebook.devicerequests.internal.DeviceRequestsHelper";
    private static HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    public static void cleanUpAdvertisementService(String str) {
        cleanUpAdvertisementServiceImpl(str);
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e) {
                Utility.logd(TAG, (Exception) e);
            }
            deviceRequestsListeners.remove(str);
        }
    }

    public static Bitmap generateQRCode(String str) {
        EnumMap enumMap = new EnumMap(C4063c.class);
        enumMap.put(C4063c.MARGIN, 2);
        try {
            C4080b a = new C4067d().mo28289a(str, C4061a.QR_CODE, 200, 200, enumMap);
            int b = a.mo28331b();
            int c = a.mo28333c();
            int[] iArr = new int[(b * c)];
            for (int i = 0; i < b; i++) {
                int i2 = i * c;
                for (int i3 = 0; i3 < c; i3++) {
                    iArr[i2 + i3] = a.mo28330a(i3, i) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, c, 0, 0, c, b);
            return createBitmap;
        } catch (WriterException unused) {
            return null;
        }
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put(DEVICE_INFO_MODEL, Build.MODEL);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static boolean isAvailable() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return Build.VERSION.SDK_INT >= 16 && appSettingsWithoutQuery != null && appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled);
    }

    public static boolean startAdvertisementService(String str) {
        if (isAvailable()) {
            return startAdvertisementServiceImpl(str);
        }
        return false;
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        if (deviceRequestsListeners.containsKey(str)) {
            return true;
        }
        final String format = String.format("%s_%s_%s", new Object[]{SDK_HEADER, String.format("%s-%s", new Object[]{"android", FacebookSdk.getSdkVersion().replace('.', '|')}), str});
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType(SERVICE_TYPE);
        nsdServiceInfo.setServiceName(format);
        nsdServiceInfo.setPort(80);
        C27131 r4 = new NsdManager.RegistrationListener() {
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }

            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                if (!format.equals(nsdServiceInfo.getServiceName())) {
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                }
            }

            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            }

            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
            }
        };
        deviceRequestsListeners.put(str, r4);
        ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).registerService(nsdServiceInfo, 1, r4);
        return true;
    }
}
