package com.miniclip.info;

import android.app.Activity;
import com.miniclip.framework.Miniclip;
import java.io.PrintStream;

public class ApplicationInfo {
    public static String identifier() {
        return Miniclip.getActivity().getPackageName();
    }

    public static String versionCode() {
        try {
            Activity activity = Miniclip.getActivity();
            return String.valueOf(activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("ApplicationInfo: " + e.getMessage());
            return "";
        }
    }

    public static String versionName() {
        try {
            Activity activity = Miniclip.getActivity();
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("ApplicationInfo: " + e.getMessage());
            return "";
        }
    }
}
