package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.games.GamesStatusCodes;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.onesignal.t */
/* compiled from: GooglePlayServicesUpgradePrompt */
class C4650t {

    /* renamed from: com.onesignal.t$a */
    /* compiled from: GooglePlayServicesUpgradePrompt */
    static class C4651a implements Runnable {

        /* renamed from: com.onesignal.t$a$a */
        /* compiled from: GooglePlayServicesUpgradePrompt */
        class C4652a implements DialogInterface.OnClickListener {
            C4652a(C4651a aVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C4698w1.m16355b(C4698w1.f12761a, "GT_DO_NOT_SHOW_MISSING_GPS", true);
            }
        }

        /* renamed from: com.onesignal.t$a$b */
        /* compiled from: GooglePlayServicesUpgradePrompt */
        class C4653b implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Activity f12658a;

            C4653b(C4651a aVar, Activity activity) {
                this.f12658a = activity;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C4650t.m16151a(this.f12658a);
            }
        }

        C4651a() {
        }

        public void run() {
            Activity activity = C4461a.f12260f;
            if (activity != null && !C4564n1.f12474F.f12546f) {
                String a = C4536k1.m15620a(activity, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
                String a2 = C4536k1.m15620a(activity, "onesignal_gms_missing_alert_button_update", "Update");
                String a3 = C4536k1.m15620a(activity, "onesignal_gms_missing_alert_button_skip", "Skip");
                new AlertDialog.Builder(activity).setMessage(a).setPositiveButton(a2, new C4653b(this, activity)).setNegativeButton(a3, new C4652a(this)).setNeutralButton(C4536k1.m15620a(activity, "onesignal_gms_missing_alert_button_close", "Close"), (DialogInterface.OnClickListener) null).create().show();
            }
        }
    }

    /* renamed from: a */
    static void m16150a() {
        if (!m16153b() && m16154c() && !C4698w1.m16348a(C4698w1.f12761a, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
            C4536k1.m15622a((Runnable) new C4651a());
        }
    }

    /* renamed from: c */
    private static boolean m16154c() {
        try {
            PackageManager packageManager = C4564n1.f12495e.getPackageManager();
            return !((String) packageManager.getPackageInfo("com.google.android.gms", OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).applicationInfo.loadLabel(packageManager)).equals("Market");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    static boolean m16153b() {
        try {
            return C4564n1.f12495e.getPackageManager().getPackageInfo("com.google.android.gms", OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m16151a(Activity activity) {
        try {
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            PendingIntent errorResolutionPendingIntent = instance.getErrorResolutionPendingIntent(activity, instance.isGooglePlayServicesAvailable(C4564n1.f12495e), GamesStatusCodes.STATUS_VIDEO_NOT_ACTIVE);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
