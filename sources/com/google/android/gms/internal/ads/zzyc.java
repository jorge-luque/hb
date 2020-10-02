package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.ogury.p159cm.OguryChoiceManager;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzyc extends ContentProvider {
    private static Bundle zzg(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
        } catch (NullPointerException e) {
            zzazw.zzc("Failed to load metadata: Null pointer exception.", e);
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            zzazw.zzc("Failed to load metadata: Package name not found.", e2);
            return null;
        }
    }

    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Bundle zzg = zzg(context);
        zzalh zzte = zzalh.zzte();
        if (zzg == null) {
            zzazw.zzfa("Metadata was null.");
        } else {
            try {
                String str = (String) zzg.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) zzg.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) zzg.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            String str2 = (String) zzg.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (str == null || str.matches("^/\\d+~.+$")) {
                                if (bool == null || !bool.booleanValue()) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        String valueOf = String.valueOf(str2);
                                        zzazw.zzed(valueOf.length() != 0 ? "The Google Mobile Ads SDK is integrated by ".concat(valueOf) : new String("The Google Mobile Ads SDK is integrated by "));
                                    } else {
                                        throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                    }
                                } else if (bool2 == null || !bool2.booleanValue()) {
                                    zzte.zzl(context);
                                }
                            } else if (str.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                String valueOf2 = String.valueOf(str);
                                zzazw.zzed(valueOf2.length() != 0 ? "Publisher provided Google AdMob App ID in manifest: ".concat(valueOf2) : new String("Publisher provided Google AdMob App ID in manifest: "));
                                if (bool2 == null || !bool2.booleanValue()) {
                                    zzte.zzc(context, str);
                                }
                            } else {
                                throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                            }
                        } catch (ClassCastException e) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", e);
                        }
                    } catch (ClassCastException e2) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e2);
                    }
                } catch (ClassCastException e3) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e3);
                }
            } catch (ClassCastException e4) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e4);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
