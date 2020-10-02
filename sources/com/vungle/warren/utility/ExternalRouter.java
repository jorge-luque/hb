package com.vungle.warren.utility;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

public class ExternalRouter {
    public static final String TAG = "ExternalRouter";

    public static boolean launch(String str, Context context) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(DriveFile.MODE_READ_ONLY);
                if (parseUri.resolveActivity(context.getPackageManager()) != null) {
                    ActivityManager.startWhenForeground(context, parseUri);
                    return true;
                }
            } catch (Exception e) {
                Log.e(TAG, "Error while opening url" + e.getLocalizedMessage());
            }
            "Cannot open url " + str + str;
        }
        return false;
    }
}
