package p118io.branch.referral.p199j0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TapjoyAuctionFlags;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C6028l;

/* renamed from: io.branch.referral.j0.a */
/* compiled from: DeepLinkRoutingValidator */
public class C6019a {

    /* renamed from: a */
    private static WeakReference<Activity> f15418a;

    /* renamed from: io.branch.referral.j0.a$a */
    /* compiled from: DeepLinkRoutingValidator */
    static class C6020a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JSONObject f15419a;

        C6020a(JSONObject jSONObject) {
            this.f15419a = jSONObject;
        }

        public void run() {
            C6019a.m19357b(C6019a.m19356b(this.f15419a, ""));
        }
    }

    /* renamed from: io.branch.referral.j0.a$b */
    /* compiled from: DeepLinkRoutingValidator */
    static class C6021b implements DialogInterface.OnClickListener {
        C6021b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: io.branch.referral.j0.a$c */
    /* compiled from: DeepLinkRoutingValidator */
    static class C6022c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ JSONObject f15420a;

        C6022c(JSONObject jSONObject) {
            this.f15420a = jSONObject;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C6019a.m19357b(C6019a.m19356b(this.f15420a, "r"));
        }
    }

    /* renamed from: io.branch.referral.j0.a$d */
    /* compiled from: DeepLinkRoutingValidator */
    static class C6023d implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ JSONObject f15421a;

        C6023d(JSONObject jSONObject) {
            this.f15421a = jSONObject;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C6019a.m19357b(C6019a.m19356b(this.f15421a, "g"));
        }
    }

    /* renamed from: io.branch.referral.j0.a$e */
    /* compiled from: DeepLinkRoutingValidator */
    static class C6024e implements DialogInterface.OnClickListener {
        C6024e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m19357b(String str) {
        if (f15418a.get() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).buildUpon().appendQueryParameter("$uri_redirect_mode", TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE).build());
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setPackage("com.android.chrome");
            ((Activity) f15418a.get()).getPackageManager().queryIntentActivities(intent, 0);
            try {
                ((Activity) f15418a.get()).startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage((String) null);
                ((Activity) f15418a.get()).startActivity(intent);
            }
        }
    }

    /* renamed from: a */
    public static void m19353a(WeakReference<Activity> weakReference) {
        f15418a = weakReference;
        if (!TextUtils.isEmpty(m19355b()) && weakReference != null) {
            JSONObject e = C3555b.m12034k().mo19637e();
            if (e.optInt("_branch_validate") == 60514) {
                if (e.optBoolean(C6028l.Clicked_Branch_Link.mo33920a())) {
                    m19354a(e);
                } else {
                    m19351a();
                }
            } else if (e.optBoolean("bnc_validate")) {
                new Handler().postDelayed(new C6020a(e), 500);
            }
        }
    }

    /* renamed from: a */
    private static void m19354a(JSONObject jSONObject) {
        AlertDialog.Builder builder;
        if (f15418a.get() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                builder = new AlertDialog.Builder((Context) f15418a.get(), 16974374);
            } else {
                builder = new AlertDialog.Builder((Context) f15418a.get());
            }
            builder.setTitle("Branch Deeplinking Routing").setMessage("Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton("Yes", new C6023d(jSONObject)).setNegativeButton("No", new C6022c(jSONObject)).setNeutralButton(17039360, new C6021b()).setCancelable(false).setIcon(17301651).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m19356b(JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        try {
            str7 = jSONObject.getString("~" + C6028l.ReferringLink.mo33920a()).split("\\?")[0];
        } catch (Exception unused) {
            Log.e("BRANCH SDK", "Failed to get referring link");
        }
        String str8 = str7 + "?validate=true";
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str8);
                if (jSONObject.getString(UserDataStore.CITY).equals("t1")) {
                    str2 = "&t1=" + str;
                } else {
                    str2 = "&t1=" + jSONObject.getString("t1");
                }
                sb.append(str2);
                str8 = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str8);
                if (jSONObject.getString(UserDataStore.CITY).equals("t2")) {
                    str3 = "&t2=" + str;
                } else {
                    str3 = "&t2=" + jSONObject.getString("t2");
                }
                sb2.append(str3);
                str8 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str8);
                if (jSONObject.getString(UserDataStore.CITY).equals("t3")) {
                    str4 = "&t3=" + str;
                } else {
                    str4 = "&t3=" + jSONObject.getString("t3");
                }
                sb3.append(str4);
                str8 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str8);
                if (jSONObject.getString(UserDataStore.CITY).equals("t4")) {
                    str5 = "&t4=" + str;
                } else {
                    str5 = "&t4=" + jSONObject.getString("t4");
                }
                sb4.append(str5);
                str8 = sb4.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str8);
                if (jSONObject.getString(UserDataStore.CITY).equals("t5")) {
                    str6 = "&t5=" + str;
                } else {
                    str6 = "&t5=" + jSONObject.getString("t5");
                }
                sb5.append(str6);
                str8 = sb5.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str8 + "&os=android";
    }

    /* renamed from: a */
    private static void m19351a() {
        AlertDialog.Builder builder;
        if (f15418a.get() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                builder = new AlertDialog.Builder((Context) f15418a.get(), 16974374);
            } else {
                builder = new AlertDialog.Builder((Context) f15418a.get());
            }
            builder.setTitle("Branch Deeplink Routing Support").setMessage("Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton("Got it", new C6024e()).setCancelable(false).setIcon(17301651).show();
        }
    }

    /* renamed from: b */
    private static String m19355b() {
        if (C3555b.m12034k() == null || C3555b.m12034k().mo19637e() == null) {
            return "";
        }
        JSONObject e = C3555b.m12034k().mo19637e();
        return e.optString("~" + C6028l.ReferringLink.mo33920a());
    }
}
