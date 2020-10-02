package com.miniclip.info;

import android.os.Build;
import java.util.Locale;

public class DeviceInfo {
    public static String brandName() {
        return Build.BRAND;
    }

    public static String country() {
        return Locale.getDefault().getCountry();
    }

    public static String model() {
        return Build.DEVICE;
    }

    public static String operatingSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String systemLanguage() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Locale.getDefault().toLanguageTag();
        }
        return Locale.getDefault().toString().replace('_', '-');
    }
}
