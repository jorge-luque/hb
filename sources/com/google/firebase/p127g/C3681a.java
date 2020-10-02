package com.google.firebase.p127g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.C0768a;
import com.google.firebase.p123d.C3661c;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.firebase.g.a */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class C3681a {

    /* renamed from: a */
    private final Context f10255a;

    /* renamed from: b */
    private final SharedPreferences f10256b;

    /* renamed from: c */
    private final AtomicBoolean f10257c = new AtomicBoolean(m12509b());

    public C3681a(Context context, String str, C3661c cVar) {
        this.f10255a = m12508a(context);
        this.f10256b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
    }

    /* renamed from: a */
    private static Context m12508a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || C0768a.m2413d(context)) ? context : C0768a.m2404a(context);
    }

    /* renamed from: b */
    private boolean m12509b() {
        ApplicationInfo applicationInfo;
        if (this.f10256b.contains("firebase_data_collection_default_enabled")) {
            return this.f10256b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f10255a.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f10255a.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo27286a() {
        return this.f10257c.get();
    }
}
