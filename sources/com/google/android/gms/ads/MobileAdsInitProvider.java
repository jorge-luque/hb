package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzyc;

@KeepForSdkWithMembers
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzyc zzacp = new zzyc();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzacp.attachInfo(context, providerInfo);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.zzacp.delete(uri, str, strArr);
    }

    public String getType(Uri uri) {
        return this.zzacp.getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.zzacp.insert(uri, contentValues);
    }

    public boolean onCreate() {
        return this.zzacp.onCreate();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzacp.query(uri, strArr, str, strArr2, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzacp.update(uri, contentValues, str, strArr);
    }
}
