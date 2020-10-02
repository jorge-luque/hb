package org.cocos2dx.cpp;

import admost.sdk.base.AdMost;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.core.content.FileProvider;
import com.android.vending.billing.IInAppBillingService;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.facebook.messenger.MessengerUtils;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.C3833g;
import com.google.firebase.remoteconfig.C3834h;
import com.loopj.android.http.C4250c;
import com.masomo.headball2.C6880R$xml;
import com.miniclip.framework.ActivityListener;
import com.miniclip.framework.Miniclip;
import com.miniclip.framework.MiniclipFacilitator;
import com.miniclip.framework.ThreadingContext;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.C4505f1;
import com.onesignal.C4512g1;
import com.onesignal.C4564n1;
import com.onesignal.C4697w0;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.Cocos2dxHelper;
import org.json.JSONException;
import org.json.JSONObject;
import p093e.p094a.p095a.C3297e;
import p093e.p094a.p095a.C3303h;
import p118io.branch.indexing.BranchUniversalObject;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C5993d;
import p118io.branch.referral.util.LinkProperties;
import p118io.fabric.sdk.android.C6059c;

public class AppActivity extends Cocos2dxActivity implements C4505f1, MiniclipFacilitator {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f17467h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static boolean f17468i;

    /* renamed from: j */
    private static boolean f17469j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static IInAppBillingService f17470k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static ArrayList<String> f17471l = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static ArrayList<String> f17472m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static String f17473n = "";
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static String f17474o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static int f17475p = 0;

    /* renamed from: q */
    private static String f17476q = "com.facebook.katana";

    /* renamed from: r */
    private static String f17477r = "com.facebook.lite";

    /* renamed from: s */
    private static String f17478s = MessengerUtils.PACKAGE_NAME;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static String f17479t = "com.twitter.android";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static String f17480u = "com.instagram.android";
    /* access modifiers changed from: private */

    /* renamed from: v */
    public static String f17481v = "com.whatsapp";

    /* renamed from: w */
    static int f17482w = 993;

    /* renamed from: a */
    private LinkedHashSet<ActivityListener> f17483a = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f17484b = false;

    /* renamed from: c */
    public boolean f17485c = false;

    /* renamed from: d */
    ServiceConnection f17486d = new C6682l();

    /* renamed from: e */
    private Context f17487e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f17488f = false;

    /* renamed from: g */
    FirebaseAnalytics f17489g;

    /* renamed from: org.cocos2dx.cpp.AppActivity$a */
    static class C6646a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f17490a;

        C6646a(boolean z) {
            this.f17490a = z;
        }

        public void run() {
            C6702a.m21947j().mo35838b(this.f17490a);
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$a0 */
    static class C6647a0 implements Runnable {
        C6647a0() {
        }

        public void run() {
            C6717c.m21970e().mo35858c();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$b */
    static class C6648b implements Runnable {
        C6648b() {
        }

        public void run() {
            C6702a.m21947j().mo35833a();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$b0 */
    static class C6649b0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17491a;

        /* renamed from: b */
        final /* synthetic */ String f17492b;

        C6649b0(String str, String str2) {
            this.f17491a = str;
            this.f17492b = str2;
        }

        public void run() {
            C6717c.m21970e().mo35856a(this.f17491a, this.f17492b);
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$c */
    static class C6650c implements Runnable {
        C6650c() {
        }

        public void run() {
            C6702a.m21947j().mo35843g();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$c0 */
    private static class C6651c0 extends AsyncTask<Object, Integer, Object> {

        /* renamed from: org.cocos2dx.cpp.AppActivity$c0$a */
        class C6652a implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$c0$a$a */
            class C6653a implements Runnable {

                /* renamed from: org.cocos2dx.cpp.AppActivity$c0$a$a$a */
                class C6654a implements Runnable {
                    C6654a(C6653a aVar) {
                    }

                    public void run() {
                        new C6651c0((C6681k) null).execute(new Object[0]);
                    }
                }

                C6653a(C6652a aVar) {
                }

                public void run() {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6654a(this));
                }
            }

            C6652a(C6651c0 c0Var) {
            }

            public void run() {
                new Handler().postDelayed(new C6653a(this), 3000);
            }
        }

        private C6651c0() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            if (AppActivity.f17470k == null) {
                C3597b.m12267a().f10092a.runOnUiThread(new C6652a(this));
                return null;
            }
            try {
                Bundle purchases = AppActivity.f17470k.getPurchases(3, C3597b.m12267a().f10092a.getPackageName(), "inapp", (String) null);
                if (purchases.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = purchases.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    if (!(stringArrayList == null || stringArrayList2 == null)) {
                        if (stringArrayList3 != null) {
                            for (int i = 0; i < stringArrayList2.size(); i++) {
                                AppActivity.purchaseConcluded(stringArrayList.get(i), 1, stringArrayList3.get(i), stringArrayList2.get(i));
                            }
                        }
                    }
                }
            } catch (RemoteException unused) {
            }
            return null;
        }

        /* synthetic */ C6651c0(C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$d */
    static class C6655d implements Runnable {
        C6655d() {
        }

        public void run() {
            C6702a.m21947j().mo35844h();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$d0 */
    private static class C6656d0 extends AsyncTask<String, Integer, Object> {

        /* renamed from: org.cocos2dx.cpp.AppActivity$d0$a */
        class C6657a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f17493a;

            /* renamed from: b */
            final /* synthetic */ String f17494b;

            /* renamed from: c */
            final /* synthetic */ String f17495c;

            /* renamed from: d */
            final /* synthetic */ String f17496d;

            /* renamed from: e */
            final /* synthetic */ String f17497e;

            C6657a(C6656d0 d0Var, String str, String str2, String str3, String str4, String str5) {
                this.f17493a = str;
                this.f17494b = str2;
                this.f17495c = str3;
                this.f17496d = str4;
                this.f17497e = str5;
            }

            public void run() {
                try {
                    Iterator it = AppActivity.f17472m.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.getString("productId").equals(this.f17493a)) {
                            double parseDouble = Double.parseDouble(jSONObject.getString("price_amount_micros")) / 1000000.0d;
                            String string = jSONObject.getString("price_currency_code");
                            if (AppActivity.f17467h) {
                                AdMost.getInstance().trackPurchase(this.f17494b, this.f17495c, str);
                            }
                            C3303h hVar = new C3303h("5lq9r4");
                            hVar.mo19026a(parseDouble, string);
                            hVar.mo19027a(this.f17496d);
                            hVar.mo19028a("userid", this.f17497e);
                            hVar.mo19028a("transactionID", this.f17496d);
                            hVar.mo19028a("productName", this.f17493a);
                            C3297e.m10957a(hVar);
                            return;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        private C6656d0() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object doInBackground(String... strArr) {
            String str;
            String str2 = strArr[0];
            boolean equals = strArr[1].equals("true");
            String str3 = strArr[3];
            try {
                if (AppActivity.f17470k == null) {
                    return null;
                }
                Bundle purchases = AppActivity.f17470k.getPurchases(3, C3597b.m12267a().f10092a.getPackageName(), "inapp", (String) null);
                if (purchases.getInt("RESPONSE_CODE") != 0) {
                    return null;
                }
                ArrayList<String> stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = purchases.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                if (!(stringArrayList == null || stringArrayList2 == null)) {
                    if (stringArrayList3 != null) {
                        for (int i = 0; i < stringArrayList3.size(); i++) {
                            try {
                                if (stringArrayList3.get(i).equals(str2)) {
                                    String str4 = stringArrayList2.get(i);
                                    String str5 = stringArrayList3.get(i);
                                    String str6 = stringArrayList.get(i);
                                    JSONObject jSONObject = new JSONObject(str4);
                                    String string = jSONObject.getString("purchaseToken");
                                    if (equals) {
                                        str = string;
                                        C3597b.m12267a().f10092a.runOnUiThread(new C6657a(this, str6, str4, str5, jSONObject.getString("orderId"), str3));
                                    } else {
                                        str = string;
                                    }
                                    try {
                                        AppActivity.f17470k.consumePurchase(3, C3597b.m12267a().f10092a.getPackageName(), str);
                                        return null;
                                    } catch (JSONException unused) {
                                        continue;
                                    }
                                }
                            } catch (JSONException unused2) {
                            }
                        }
                        return null;
                    }
                }
                return null;
            } catch (RemoteException unused3) {
                return null;
            }
        }

        /* synthetic */ C6656d0(C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$e */
    static class C6658e implements Runnable {
        C6658e() {
        }

        public void run() {
            C6702a.m21947j().mo35842f();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$e0 */
    private class C6659e0 implements C4564n1.C4568b0 {
        private C6659e0() {
        }

        /* renamed from: a */
        public void mo29861a(C4697w0 w0Var) {
            JSONObject jSONObject = w0Var.f12759a.f12698a.f12810e;
            if (jSONObject != null) {
                AppActivity.openedFromNotification(jSONObject.toString());
            }
        }

        /* synthetic */ C6659e0(AppActivity appActivity, C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$f */
    static class C6660f implements Runnable {
        C6660f() {
        }

        public void run() {
            C6702a.m21947j().mo35837b();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$f0 */
    private static class C6661f0 extends AsyncTask<Object, Integer, Object> {
        private C6661f0() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C3597b.m12267a().f10092a);
                if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    return null;
                }
                String unused = AppActivity.f17473n = advertisingIdInfo.getId();
                return null;
            } catch (Exception unused2) {
            }
        }

        /* synthetic */ C6661f0(C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$g */
    static class C6662g implements Runnable {
        C6662g() {
        }

        public void run() {
            C6702a.m21947j().mo35845i();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$g0 */
    private static class C6663g0 extends AsyncTask<Object, Integer, Object> {
        private C6663g0() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            try {
                PendingIntent pendingIntent = (PendingIntent) AppActivity.f17470k.getBuyIntent(3, C3597b.m12267a().f10092a.getPackageName(), AppActivity.f17474o, "inapp", "12x73kazx0*812ia+sd1-d1ma").getParcelable("BUY_INTENT");
                if (pendingIntent != null) {
                    C3597b.m12267a().f10092a.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), 0, 0, 0);
                    return null;
                }
            } catch (Exception unused) {
            }
            AppActivity.purchaseConcluded(AppActivity.f17474o, 0, "", "");
            return null;
        }

        /* synthetic */ C6663g0(C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$h */
    static class C6664h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17499a;

        /* renamed from: b */
        final /* synthetic */ int f17500b;

        /* renamed from: c */
        final /* synthetic */ String f17501c;

        /* renamed from: d */
        final /* synthetic */ String f17502d;

        /* renamed from: e */
        final /* synthetic */ String f17503e;

        C6664h(String str, int i, String str2, String str3, String str4) {
            this.f17499a = str;
            this.f17500b = i;
            this.f17501c = str2;
            this.f17502d = str3;
            this.f17503e = str4;
        }

        public void run() {
            try {
                File file = new File(this.f17499a);
                Uri a = FileProvider.m2391a(C3597b.m12267a().f10092a, "com.masomo.headball2", file);
                if (a != null) {
                    if (this.f17500b != 1 || !AppActivity.hasShareAppInstalled(1)) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.addFlags(1);
                        intent.setDataAndType(a, C3597b.m12267a().f10092a.getContentResolver().getType(a));
                        intent.putExtra("android.intent.extra.STREAM", a);
                        intent.setType("image/jpeg");
                        if (this.f17500b == 2) {
                            if (AppActivity.hasShareAppInstalled(2)) {
                                intent.putExtra("android.intent.extra.TEXT", this.f17503e);
                                Iterator<ResolveInfo> it = C3597b.m12267a().f10092a.getPackageManager().queryIntentActivities(intent, MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ResolveInfo next = it.next();
                                    if (next.activityInfo.packageName.startsWith(AppActivity.f17479t)) {
                                        intent.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                                        C3597b.m12267a().f10092a.startActivity(intent);
                                        break;
                                    }
                                }
                            }
                        }
                        if (this.f17500b == 3 && AppActivity.hasShareAppInstalled(3)) {
                            intent.putExtra("android.intent.extra.TEXT", this.f17503e + " " + this.f17502d + " " + this.f17501c);
                            Iterator<ResolveInfo> it2 = C3597b.m12267a().f10092a.getPackageManager().queryIntentActivities(intent, MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                ResolveInfo next2 = it2.next();
                                if (next2.activityInfo.packageName.startsWith(AppActivity.f17480u)) {
                                    intent.setClassName(next2.activityInfo.packageName, next2.activityInfo.name);
                                    C3597b.m12267a().f10092a.startActivity(intent);
                                    break;
                                }
                            }
                        } else {
                            C3597b.m12267a().f10092a.startActivity(Intent.createChooser(intent, (CharSequence) null));
                        }
                    } else {
                        ShareDialog.show((Activity) C3597b.m12267a().f10092a, (ShareContent) ((SharePhotoContent.Builder) new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(BitmapFactory.decodeFile(file.getAbsolutePath(), new BitmapFactory.Options())).setCaption(this.f17501c).setUserGenerated(true).build()).setShareHashtag(new ShareHashtag.Builder().setHashtag(this.f17502d).build())).build());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                AppActivity.sharePhotoDone();
                throw th;
            }
            AppActivity.sharePhotoDone();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$h0 */
    private static class C6665h0 extends AsyncTask<Object, Integer, Object> {

        /* renamed from: org.cocos2dx.cpp.AppActivity$h0$a */
        class C6666a implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$h0$a$a */
            class C6667a implements Runnable {

                /* renamed from: org.cocos2dx.cpp.AppActivity$h0$a$a$a */
                class C6668a implements Runnable {
                    C6668a(C6667a aVar) {
                    }

                    public void run() {
                        new C6665h0((C6681k) null).execute(new Object[0]);
                    }
                }

                C6667a(C6666a aVar) {
                }

                public void run() {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6668a(this));
                }
            }

            C6666a(C6665h0 h0Var) {
            }

            public void run() {
                new Handler().postDelayed(new C6667a(this), 3000);
            }
        }

        /* renamed from: org.cocos2dx.cpp.AppActivity$h0$b */
        class C6669b implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$h0$b$a */
            class C6670a implements Runnable {

                /* renamed from: org.cocos2dx.cpp.AppActivity$h0$b$a$a */
                class C6671a implements Runnable {
                    C6671a(C6670a aVar) {
                    }

                    public void run() {
                        new C6665h0((C6681k) null).execute(new Object[0]);
                    }
                }

                C6670a(C6669b bVar) {
                }

                public void run() {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6671a(this));
                }
            }

            C6669b(C6665h0 h0Var) {
            }

            public void run() {
                new Handler().postDelayed(new C6670a(this), 3000);
            }
        }

        /* renamed from: org.cocos2dx.cpp.AppActivity$h0$c */
        class C6672c implements Runnable {
            C6672c(C6665h0 h0Var) {
            }

            public void run() {
                new C6665h0((C6681k) null).execute(new Object[0]);
            }
        }

        /* renamed from: org.cocos2dx.cpp.AppActivity$h0$d */
        class C6673d implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$h0$d$a */
            class C6674a implements Runnable {

                /* renamed from: org.cocos2dx.cpp.AppActivity$h0$d$a$a */
                class C6675a implements Runnable {
                    C6675a(C6674a aVar) {
                    }

                    public void run() {
                        new C6665h0((C6681k) null).execute(new Object[0]);
                    }
                }

                C6674a(C6673d dVar) {
                }

                public void run() {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6675a(this));
                }
            }

            C6673d(C6665h0 h0Var) {
            }

            public void run() {
                new Handler().postDelayed(new C6674a(this), 3000);
            }
        }

        /* renamed from: org.cocos2dx.cpp.AppActivity$h0$e */
        class C6676e implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$h0$e$a */
            class C6677a implements Runnable {

                /* renamed from: org.cocos2dx.cpp.AppActivity$h0$e$a$a */
                class C6678a implements Runnable {
                    C6678a(C6677a aVar) {
                    }

                    public void run() {
                        new C6665h0((C6681k) null).execute(new Object[0]);
                    }
                }

                C6677a(C6676e eVar) {
                }

                public void run() {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6678a(this));
                }
            }

            C6676e(C6665h0 h0Var) {
            }

            public void run() {
                new Handler().postDelayed(new C6677a(this), 3000);
            }
        }

        private C6665h0() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            if (AppActivity.f17470k == null) {
                C3597b.m12267a().f10092a.runOnUiThread(new C6666a(this));
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 10; i++) {
                    int access$400 = (AppActivity.f17475p * 10) + i;
                    if (AppActivity.f17471l.size() > access$400) {
                        arrayList.add(AppActivity.f17471l.get(access$400));
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                Bundle skuDetails = AppActivity.f17470k.getSkuDetails(3, C3597b.m12267a().f10092a.getPackageName(), "inapp", bundle);
                if (skuDetails == null) {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6669b(this));
                    return null;
                }
                if (skuDetails.getInt("RESPONSE_CODE") == 0) {
                    if (AppActivity.f17475p == 0) {
                        ArrayList unused = AppActivity.f17472m = skuDetails.getStringArrayList("DETAILS_LIST");
                    } else {
                        AppActivity.f17472m.addAll(0, skuDetails.getStringArrayList("DETAILS_LIST"));
                    }
                    AppActivity.access$408();
                    if (AppActivity.f17471l.size() > AppActivity.f17475p * 10) {
                        C3597b.m12267a().f10092a.runOnUiThread(new C6672c(this));
                    }
                } else {
                    C3597b.m12267a().f10092a.runOnUiThread(new C6673d(this));
                }
                return null;
            } catch (Exception unused2) {
                C3597b.m12267a().f10092a.runOnUiThread(new C6676e(this));
            }
        }

        /* synthetic */ C6665h0(C6681k kVar) {
            this();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$i */
    static class C6679i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17504a;

        /* renamed from: b */
        final /* synthetic */ String f17505b;

        /* renamed from: c */
        final /* synthetic */ int f17506c;

        C6679i(String str, String str2, int i) {
            this.f17504a = str;
            this.f17505b = str2;
            this.f17506c = i;
        }

        public void run() {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", this.f17504a + " " + this.f17505b);
                intent.setType("text/plain");
                if (!AppActivity.hasShareAppInstalled(this.f17506c)) {
                    C3597b.m12267a().f10092a.startActivity(Intent.createChooser(intent, this.f17504a));
                } else if (this.f17506c == 1) {
                    ShareDialog.show((Activity) C3597b.m12267a().f10092a, (ShareContent) ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setQuote(this.f17504a).setContentUrl(Uri.parse(this.f17505b))).build());
                } else if (this.f17506c == 2) {
                    for (ResolveInfo next : C3597b.m12267a().f10092a.getPackageManager().queryIntentActivities(intent, MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES)) {
                        if (next.activityInfo.packageName.startsWith(AppActivity.f17479t)) {
                            intent.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                            C3597b.m12267a().f10092a.startActivity(intent);
                            return;
                        }
                    }
                } else if (this.f17506c == 4) {
                    MessageDialog.show((Activity) C3597b.m12267a().f10092a, (ShareContent) ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setQuote(this.f17504a).setContentUrl(Uri.parse(this.f17505b))).build());
                } else if (this.f17506c == 5) {
                    intent.setPackage(AppActivity.f17481v);
                    C3597b.m12267a().f10092a.startActivity(Intent.createChooser(intent, this.f17504a));
                } else {
                    C3597b.m12267a().f10092a.startActivity(Intent.createChooser(intent, this.f17504a));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$j */
    class C6680j implements OnCompleteListener<GoogleSignInAccount> {
        C6680j() {
        }

        public void onComplete(Task<GoogleSignInAccount> task) {
            if (!AppActivity.this.f17484b) {
                if (task.isSuccessful()) {
                    AppActivity.this.mo35757a(task.getResult());
                } else {
                    AppActivity.this.m21911h();
                }
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$k */
    class C6681k implements Runnable {
        C6681k() {
        }

        public void run() {
            AppActivity.this.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$l */
    class C6682l implements ServiceConnection {

        /* renamed from: org.cocos2dx.cpp.AppActivity$l$a */
        class C6683a implements Runnable {

            /* renamed from: org.cocos2dx.cpp.AppActivity$l$a$a */
            class C6684a implements Runnable {
                C6684a() {
                }

                public void run() {
                    AppActivity.this.mo35756a();
                }
            }

            C6683a() {
            }

            public void run() {
                C3597b.m12267a().f10092a.runOnUiThread(new C6684a());
            }
        }

        C6682l() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean unused = AppActivity.this.f17488f = true;
            IInAppBillingService unused2 = AppActivity.f17470k = IInAppBillingService.Stub.asInterface(iBinder);
            new C6665h0((C6681k) null).execute(new Object[0]);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            IInAppBillingService unused = AppActivity.f17470k = null;
            boolean unused2 = AppActivity.this.f17488f = false;
            new Handler().postDelayed(new C6683a(), 3000);
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$m */
    static class C6685m implements Runnable {
        C6685m() {
        }

        public void run() {
            try {
                if (Build.VERSION.SDK_INT >= 16 && !C3597b.m12267a().f10092a.f17484b) {
                    boolean unused = AppActivity.f17468i = AppActivity.isGooglePlayInstalled(C3597b.m12267a().f10092a);
                    if (C3597b.m12267a().f10092a.m21910g()) {
                        C3597b.m12267a().f10092a.m21909f();
                    } else {
                        C3597b.m12267a().f10092a.m21911h();
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$n */
    class C6686n implements OnCompleteListener<Player> {
        C6686n() {
        }

        public void onComplete(Task<Player> task) {
            try {
                if (!C3597b.m12267a().f10092a.f17484b) {
                    String playerId = task.getResult().getPlayerId();
                    String displayName = task.getResult().getDisplayName();
                    if (playerId == null) {
                        playerId = "";
                    }
                    if (displayName == null) {
                        displayName = "";
                    }
                    boolean unused = C3597b.m12267a().f10092a.f17484b = true;
                    AppActivity.loggedInCallback(playerId, displayName);
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$o */
    static class C6687o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17513a;

        C6687o(String str) {
            this.f17513a = str;
        }

        public void run() {
            GoogleSignInAccount lastSignedInAccount;
            try {
                if (C3597b.m12267a().f10092a.f17484b && (lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(C3597b.m12267a().f10092a)) != null) {
                    Games.getAchievementsClient((Activity) C3597b.m12267a().f10092a, lastSignedInAccount).unlock(this.f17513a);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$p */
    static class C6688p implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f17514a;

        C6688p(int i) {
            this.f17514a = i;
        }

        public void run() {
            GoogleSignInAccount lastSignedInAccount;
            try {
                if (C3597b.m12267a().f10092a.f17484b && (lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(C3597b.m12267a().f10092a)) != null) {
                    Games.getLeaderboardsClient((Activity) C3597b.m12267a().f10092a, lastSignedInAccount).submitScore("CgkIyavZ9aYZEAIQAQ", (long) this.f17514a);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$q */
    static class C6689q implements Runnable {

        /* renamed from: org.cocos2dx.cpp.AppActivity$q$a */
        class C6690a implements OnSuccessListener<Intent> {
            C6690a(C6689q qVar) {
            }

            /* renamed from: a */
            public void onSuccess(Intent intent) {
                C3597b.m12267a().f10092a.startActivityForResult(intent, GamesStatusCodes.STATUS_VIDEO_UNEXPECTED_CAPTURE_ERROR);
            }
        }

        C6689q() {
        }

        public void run() {
            GoogleSignInAccount lastSignedInAccount;
            try {
                if (C3597b.m12267a().f10092a.f17484b && (lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(C3597b.m12267a().f10092a)) != null) {
                    Games.getLeaderboardsClient((Activity) C3597b.m12267a().f10092a, lastSignedInAccount).getLeaderboardIntent("CgkIyavZ9aYZEAIQAQ").addOnSuccessListener(new C6690a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$r */
    static class C6691r implements Runnable {

        /* renamed from: org.cocos2dx.cpp.AppActivity$r$a */
        class C6692a implements OnSuccessListener<Intent> {
            C6692a(C6691r rVar) {
            }

            /* renamed from: a */
            public void onSuccess(Intent intent) {
                C3597b.m12267a().f10092a.startActivityForResult(intent, 98);
            }
        }

        C6691r() {
        }

        public void run() {
            GoogleSignInAccount lastSignedInAccount;
            try {
                if (C3597b.m12267a().f10092a.f17484b && (lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(C3597b.m12267a().f10092a)) != null) {
                    Games.getAchievementsClient((Activity) C3597b.m12267a().f10092a, lastSignedInAccount).getAchievementsIntent().addOnSuccessListener(new C6692a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$s */
    static class C6693s implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17515a;

        C6693s(String str) {
            this.f17515a = str;
        }

        public void run() {
            String str = this.f17515a;
            ((ClipboardManager) C3597b.m12267a().f10092a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$t */
    class C6694t implements OnCompleteListener<Boolean> {
        C6694t() {
        }

        public void onComplete(Task<Boolean> task) {
            try {
                AppActivity.remoteConfigFetched(task.isSuccessful());
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$u */
    static /* synthetic */ class C6695u {

        /* renamed from: a */
        static final /* synthetic */ int[] f17517a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.miniclip.framework.ThreadingContext[] r0 = com.miniclip.framework.ThreadingContext.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17517a = r0
                com.miniclip.framework.ThreadingContext r1 = com.miniclip.framework.ThreadingContext.UiThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17517a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.miniclip.framework.ThreadingContext r1 = com.miniclip.framework.ThreadingContext.GlThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.cpp.AppActivity.C6695u.<clinit>():void");
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$v */
    class C6696v implements View.OnSystemUiVisibilityChangeListener {
        C6696v() {
        }

        public void onSystemUiVisibilityChange(int i) {
            AppActivity.this.mo35761c();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$w */
    class C6697w implements View.OnFocusChangeListener {
        C6697w() {
        }

        public void onFocusChange(View view, boolean z) {
            AppActivity.this.mo35761c();
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$x */
    class C6698x implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f17520a;

        /* renamed from: b */
        final /* synthetic */ String f17521b;

        /* renamed from: org.cocos2dx.cpp.AppActivity$x$a */
        class C6699a implements Runnable {
            C6699a() {
            }

            public void run() {
                try {
                    AppActivity.pushNotificationTokenReceived(C6698x.this.f17520a, C6698x.this.f17521b);
                    C3297e.m10958a(C6698x.this.f17520a, C3597b.m12267a().f10092a);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }

        C6698x(String str, String str2) {
            this.f17520a = str;
            this.f17521b = str2;
        }

        public void run() {
            C3597b.m12267a().f10092a.runOnUiThread(new C6699a());
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$y */
    class C6700y implements C3555b.C3562g {
        C6700y() {
        }

        /* renamed from: a */
        public void mo19656a(JSONObject jSONObject, C5993d dVar) {
        }
    }

    /* renamed from: org.cocos2dx.cpp.AppActivity$z */
    static class C6701z implements Runnable {
        C6701z() {
        }

        public void run() {
            C6717c.m21970e().mo35855a();
        }
    }

    static {
        System.loadLibrary("mcprime");
        System.loadLibrary("mcgoliathevents");
        System.loadLibrary("mcgoliath");
    }

    static /* synthetic */ int access$408() {
        int i = f17475p;
        f17475p = i + 1;
        return i;
    }

    public static native void adjustInfoAvailable(String str);

    private static void admostReportUserId(String str) {
        AdMost.getInstance().setUserId(str);
    }

    public static native void advertisementDismissed(boolean z, int i);

    public static native void advertisementShown(String str, float f);

    public static void advertisementTimedOut() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6648b());
    }

    public static void branchClearPreferences() {
        SharedPreferences.Editor edit = C3597b.m12267a().f10092a.getSharedPreferences("HB2", 0).edit();
        edit.remove("savedBranchURL");
        edit.apply();
    }

    public static String branchGetReferralId() {
        if (!C3597b.m12267a().f10093b) {
            return "";
        }
        try {
            C3555b k = C3555b.m12034k();
            if (k != null && k.mo19635d().has("userId")) {
                return k.mo19635d().getString("userId");
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String branchGetShortUrl(String str, String str2, String str3, String str4) {
        if (!C3597b.m12267a().f10093b) {
            return "-1";
        }
        if (str4 != null) {
            String string = C3597b.m12267a().f10092a.getSharedPreferences("HB2", 0).getString("shortUrlLanguage", (String) null);
            if (string != null && string.equals(str4)) {
                return "-1";
            }
            setStringKey("shortUrlLanguage", str4);
        }
        try {
            String inviteShortUrl = getInviteShortUrl(str, str2, str3);
            if (inviteShortUrl == null) {
                return "-1";
            }
            return inviteShortUrl;
        } catch (Exception unused) {
            return "-1";
        }
    }

    public static void branchSetFlagToPreferences() {
        if (C3597b.m12267a().f10093b) {
            SharedPreferences.Editor edit = C3597b.m12267a().f10092a.getSharedPreferences("HB2", 0).edit();
            edit.putBoolean("savedBranchURL", true);
            edit.apply();
        }
    }

    public static void checkForOfferwallEarnings() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6660f());
    }

    public static void checkUnfinishedTransactions() {
        new C6651c0((C6681k) null).execute(new Object[0]);
    }

    public static void connectIAP_Bridge() {
        C3597b.m12267a().f10092a.mo35756a();
    }

    public static void connectToFacebook() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6701z());
    }

    public static native void connectedToFacebook(boolean z, String str, String str2, String str3, String str4);

    public static void copyToClipboard(String str) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6693s(str));
    }

    private static void crashlyticsLog(String str) {
        Crashlytics.log(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m21909f() {
        try {
            GoogleSignIn.getClient((Activity) this, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).silentSignIn().addOnCompleteListener((Activity) this, new C6680j());
        } catch (Exception unused) {
        }
    }

    public static native void facebookFriendsInvited(int i);

    public static void finishTransaction(String str, String str2, String str3, String str4) {
        new C6656d0((C6681k) null).execute(new String[]{str, str2, str3, str4});
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m21910g() {
        try {
            return GoogleSignIn.getLastSignedInAccount(this) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getAdmostId() {
        try {
            JSONObject jSONObject = new JSONObject(AdMost.getInstance().getUserDataJSON());
            if (!jSONObject.has("UserId")) {
                return "Error retrieving Amost user ID";
            }
            try {
                return jSONObject.getString("UserId");
            } catch (JSONException unused) {
                return "";
            }
        } catch (Exception unused2) {
            return "Error: Malformed JSON string";
        }
    }

    public static String getAdvertisementID() {
        return f17473n;
    }

    public static int getConnectionType() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C3597b.m12267a().f10092a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            return activeNetworkInfo.getType() == 0 ? 2 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getCountryCode() {
        return C3597b.m12267a().f10092a.getResources().getConfiguration().locale.getCountry().toUpperCase();
    }

    public static String getDeviceInfo() {
        return System.getProperty("os.version") + " - " + Build.VERSION.SDK_INT + " - " + Build.DEVICE + " - " + Build.MODEL + " - " + Build.PRODUCT;
    }

    public static String getDownloadSource() {
        try {
            return Cocos2dxActivity.getContext().getPackageManager().getInstallerPackageName(Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(Cocos2dxActivity.getContext().getPackageName(), 0).packageName);
        } catch (Exception unused) {
            return "Error";
        }
    }

    static String getInviteShortUrl(String str, String str2, String str3) {
        BranchUniversalObject branchUniversalObject = new BranchUniversalObject();
        branchUniversalObject.mo33786b(str2);
        branchUniversalObject.mo33783a(str3);
        LinkProperties linkProperties = new LinkProperties();
        linkProperties.mo34043a("userId", str);
        return branchUniversalObject.mo33784a((Context) C3597b.m12267a().f10092a, linkProperties);
    }

    public static String getIsLowRAMDevice() {
        return f17469j ? "true" : "false";
    }

    public static String getJavaString(byte[] bArr) {
        try {
            return new String(bArr, C4250c.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String getLibraryHashCode() {
        try {
            return Cocos2dxActivity.getContext().getPackageManager().getInstallerPackageName("com.masomo.headball2");
        } catch (Exception unused) {
            return "Error";
        }
    }

    public static String getProductPrice(String str) {
        String str2;
        ArrayList<String> arrayList = f17472m;
        if (arrayList == null) {
            return "-";
        }
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject(it.next());
                if (jSONObject.getString("productId").equals(str) && jSONObject.has("price_amount_micros") && jSONObject.has("price_currency_code")) {
                    String string = jSONObject.getString("price_currency_code");
                    float parseDouble = (float) (Double.parseDouble(jSONObject.getString("price_amount_micros")) / 1000000.0d);
                    double d = (double) parseDouble;
                    if (d == Math.ceil(d)) {
                        str2 = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) parseDouble)});
                    } else {
                        str2 = String.format(Locale.getDefault(), "%.2f", new Object[]{Float.valueOf(parseDouble)});
                    }
                    return Currency.getInstance(string).getSymbol() + str2;
                }
            }
        } catch (Exception unused) {
        }
        return "-";
    }

    public static String getProductPriceCurrency(String str) {
        ArrayList<String> arrayList = f17472m;
        if (arrayList == null) {
            return "";
        }
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject(it.next());
                if (jSONObject.getString("productId").equals(str) && jSONObject.has("price_currency_code")) {
                    return jSONObject.getString("price_currency_code");
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static float getProductPriceNumber(String str) throws JSONException {
        ArrayList<String> arrayList = f17472m;
        if (arrayList == null) {
            return 0.0f;
        }
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject(it.next());
                if (jSONObject.getString("productId").equals(str) && jSONObject.has("price_amount_micros")) {
                    double parseInt = (double) Integer.parseInt(jSONObject.getString("price_amount_micros"));
                    Double.isNaN(parseInt);
                    return (float) (parseInt / 1000000.0d);
                }
            }
        } catch (Exception unused) {
        }
        return 0.0f;
    }

    public static String getProductPriceWithDiscount(String str, int i) {
        String str2;
        ArrayList<String> arrayList = f17472m;
        if (arrayList == null) {
            return "-";
        }
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = new JSONObject(it.next());
                if (jSONObject.getString("productId").equals(str) && jSONObject.has("price_amount_micros") && jSONObject.has("price_currency_code")) {
                    String string = jSONObject.getString("price_currency_code");
                    float parseDouble = (((float) (Double.parseDouble(jSONObject.getString("price_amount_micros")) / 1000000.0d)) * ((float) i)) / 100.0f;
                    double d = (double) parseDouble;
                    if (d == Math.ceil(d)) {
                        str2 = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) parseDouble)});
                    } else {
                        str2 = String.format(Locale.getDefault(), "%.2f", new Object[]{Float.valueOf(parseDouble)});
                    }
                    return Currency.getInstance(string).getSymbol() + str2;
                }
            }
        } catch (Exception unused) {
        }
        return "-";
    }

    public static String getRemoteConfig(String str) {
        try {
            return C3833g.m12955e().mo27545a(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static float getRewardedAdECPM() {
        return C6702a.m21947j().mo35841e();
    }

    public static String getVersionCode() {
        return Integer.toString(113801);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m21911h() {
        try {
            startActivityForResult(GoogleSignIn.getClient((Activity) this, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).getSignInIntent(), f17482w);
        } catch (Exception unused) {
        }
    }

    public static boolean hasShareAppInstalled(int i) {
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            Intent launchIntentForPackage = C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17476q);
            Intent launchIntentForPackage2 = C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17477r);
            if (launchIntentForPackage == null && launchIntentForPackage2 == null) {
                return false;
            }
            return true;
        } else if (i == 2) {
            if (C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17479t) != null) {
                return true;
            }
            return false;
        } else if (i == 3) {
            if (C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17480u) != null) {
                return true;
            }
            return false;
        } else if (i == 4) {
            if (C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17478s) != null) {
                return true;
            }
            return false;
        } else if (i != 5 || C3597b.m12267a().f10092a.getPackageManager().getLaunchIntentForPackage(f17481v) == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void hideNavigation_Bridge() {
        C3597b.m12267a().f10092a.mo35761c();
    }

    public static void initAdvertisement(int i) {
        if (!f17467h) {
            boolean z = true;
            f17467h = true;
            C6702a j = C6702a.m21947j();
            if (i != 1) {
                z = false;
            }
            j.mo35835a(z);
        }
    }

    public static void initIntersititialAd() {
        C6702a.m21947j().mo35839c();
    }

    public static void initRewardedAd() {
        C6702a.m21947j().mo35840d();
    }

    public static void insertInAppPurchaseProductID(String str) {
        if (!f17471l.contains(str)) {
            f17471l.add(str);
        }
    }

    public static void inviteFriends(String str, String str2) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6649b0(str, str2));
    }

    public static boolean isGooglePlayInstalled(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(GooglePlayServicesUtilLight.GOOGLE_PLAY_GAMES_PACKAGE, 0).enabled;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static native boolean isInterstitialWorthToShow(float f);

    public static String isLowEndAndroidDevice() {
        if (!Build.MODEL.equals("Discovery") && !Build.MODEL.equals("SM-T230")) {
            return "false";
        }
        return "true";
    }

    public static String isLowQualityGPU() {
        String str = Build.MODEL;
        Crashlytics.log("Model : " + str);
        if (!str.contains("i950") && !str.contains("i337") && !str.contains("i545") && !str.contains("M919") && !str.contains("L720") && !str.contains("i951") && !str.contains("Galaxy S4")) {
            return "false";
        }
        return "true";
    }

    public static native boolean isWaitingToShowAd();

    public static native void loggedInCallback(String str, String str2);

    public static native void loggedOutCallback(boolean z);

    public static void loginToGameServices() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6685m());
    }

    public static void logoutFromFacebook() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6647a0());
    }

    public static native void offerwallCallback(boolean z, boolean z2, int i, String str);

    public static native void openedFromNotification(String str);

    public static void preloadSurvey() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6658e());
    }

    public static void purchase(String str) {
        if (f17470k == null) {
            purchaseConcluded(str, 0, "", "");
            return;
        }
        f17474o = str;
        new C6663g0((C6681k) null).execute(new Object[0]);
        sendAdjustEvent("", "4dlunm", "", "", "");
    }

    public static native void purchaseConcluded(String str, int i, String str2, String str3);

    public static native void pushNotificationReceived(String str, boolean z);

    public static native void pushNotificationTokenReceived(String str, String str2);

    public static native void remoteConfigFetched(boolean z);

    public static void reportAchievement(String str) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6687o(str));
    }

    public static void reportGAIEvent(String str, String str2, String str3) {
    }

    public static void reportGAIPageView(String str) {
    }

    public static void reportScoreTaraftar(int i) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6688p(i));
    }

    private static void scheduleNotification(String str, String str2, String str3, String str4, int i, int i2) {
        C6722d.m21982a(C3597b.m12267a().f10092a, str, str2, str3, str4, i, i2);
    }

    public static void sendAdjustEvent(String str, String str2, String str3, String str4, String str5) {
        try {
            C3303h hVar = new C3303h(str2);
            Bundle bundle = new Bundle();
            if (!str3.isEmpty()) {
                hVar.mo19028a("userid", str3);
                bundle.putString("userid", str3);
            }
            if (!str4.isEmpty()) {
                hVar.mo19028a(str4, str5);
                bundle.putString(str4, str5);
            }
            C3297e.m10957a(hVar);
            if (!str.isEmpty()) {
                C3597b.m12267a().f10092a.f17489g.mo27193a(str, bundle);
            }
        } catch (Exception unused) {
        }
    }

    public static void sendTag(String str, String str2) {
        C4564n1.m15797a(str, str2);
    }

    public static void sendTags(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] split = str.split(",");
            String[] split2 = str2.split(",");
            for (int i = 0; i < split.length; i++) {
                jSONObject.put(split[i], split2[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C4564n1.m15833d(jSONObject);
    }

    public static native void setNotificationTarget(String str, String str2);

    static void setStringKey(String str, String str2) {
        SharedPreferences.Editor edit = C3597b.m12267a().f10092a.getSharedPreferences("HB2", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void setUserProperty(String str, String str2) {
        try {
            C3597b.m12267a().f10092a.f17489g.mo27194a(str, str2);
        } catch (Exception unused) {
        }
    }

    public static void shareLink(int i, String str, String str2) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6679i(str, str2, i));
    }

    public static native void sharePhotoDone();

    public static void shareScreenshot(int i, String str, String str2, String str3, String str4) {
        C3597b.m12267a().f10092a.runOnUiThread(new C6664h(str4, i, str2, str3, str));
    }

    public static void showAchievements() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6691r());
    }

    public static void showAdmostTestSuite() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6662g());
    }

    public static void showAdvertisement(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        C3597b.m12267a().f10092a.runOnUiThread(new C6646a(z));
    }

    public static void showLeaderboardTaraftar() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6689q());
    }

    public static void showOfferwall() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6650c());
    }

    public static void showSurvey() {
        C3597b.m12267a().f10092a.runOnUiThread(new C6655d());
    }

    public static native void surveyCallback(boolean z, boolean z2);

    private static void unscheduleAllNotifications() {
    }

    private static void unscheduleNotification(String str) {
        C6722d.m21981a(C3597b.m12267a().f10092a, str);
    }

    /* renamed from: a */
    public void mo35756a() {
        f17475p = 0;
        if (f17470k == null) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f17488f = this.f17487e.bindService(intent, this.f17486d, 1);
            return;
        }
        new C6665h0((C6681k) null).execute(new Object[0]);
    }

    public boolean addListener(ActivityListener activityListener) {
        return this.f17483a.add(activityListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo35759b() {
        if (!Cocos2dxHelper.getActivity().getSharedPreferences(Cocos2dxHelper.PREFS_NAME, 0).contains("logged_in_key")) {
            SharedPreferences sharedPreferences = C3597b.m12267a().f10092a.getSharedPreferences("HB2", 0);
            if (mo35758a(sharedPreferences)) {
                mo35760b(sharedPreferences);
                mo35763e();
            }
        }
    }

    /* renamed from: c */
    public void mo35761c() {
        if (Build.VERSION.SDK_INT >= 19) {
            runOnUiThread(new C6681k());
        }
    }

    /* renamed from: d */
    public void mo35762d() {
        C3834h.C3836b bVar = new C3834h.C3836b();
        bVar.mo27553a(3600);
        C3833g.m12955e().mo27544a(bVar.mo27554a());
        C3833g.m12955e().mo27543a((int) C6880R$xml.remote_config_defaults);
        C3833g.m12955e().mo27548c().addOnCompleteListener((Activity) this, new C6694t());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo35763e() {
        setUserProperty("user_sign_up", new Timestamp(System.currentTimeMillis()).toString());
    }

    public Activity getActivity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
        if (C6717c.m21970e().f17562c != null) {
            C6717c.m21970e().f17562c.onActivityResult(i, i2, intent);
        }
        if (i == f17482w) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent == null || !signInResultFromIntent.isSuccess()) {
                if (!f17468i) {
                    boolean isGooglePlayInstalled = isGooglePlayInstalled(this);
                    f17468i = isGooglePlayInstalled;
                    if (isGooglePlayInstalled) {
                        loginToGameServices();
                        return;
                    }
                }
                loggedOutCallback(f17468i);
                return;
            }
            mo35757a(signInResultFromIntent.getSignInAccount());
        } else if (i != 1001) {
        } else {
            if (i2 == -1) {
                try {
                    String stringExtra = intent.getStringExtra("INAPP_DATA_SIGNATURE");
                    String stringExtra2 = intent.getStringExtra("INAPP_PURCHASE_DATA");
                    try {
                        purchaseConcluded(new JSONObject(stringExtra2).getString("productId"), 1, stringExtra, stringExtra2);
                    } catch (JSONException unused) {
                        purchaseConcluded(f17474o, 0, "", "");
                    }
                } catch (Exception unused2) {
                    purchaseConcluded(f17474o, 0, "", "");
                }
            } else {
                purchaseConcluded(f17474o, 0, "", "");
                sendAdjustEvent("", "xih8ur", "", "", "");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C6059c.m19620a((Context) this, new Crashlytics(), new CrashlyticsNdk());
        super.onCreate(bundle);
        if (!getPackageName().equals("com.masomo.headball2")) {
            finish();
            return;
        }
        Miniclip.setFacilitator(this);
        C3597b a = C3597b.m12267a();
        C6717c.m21970e().f17560a = this;
        a.f10092a = this;
        C4564n1.C4592r m = C4564n1.m15869m(this);
        m.mo29880a(C4564n1.C4572d0.f12527a);
        m.mo29881a(true);
        m.mo29879a((C4564n1.C4568b0) new C6659e0(this, (C6681k) null));
        m.mo29882a();
        C4564n1.m15864k();
        this.f17489g = FirebaseAnalytics.getInstance(this);
        mo35759b();
        mo35762d();
        C6717c.m21970e().mo35857b();
        this.f17487e = getApplicationContext();
        getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new C6696v());
            decorView.setOnFocusChangeListener(new C6697w());
            mo35761c();
        }
        if (C4564n1.m15751A().mo29720a().mo29672b()) {
            String c = C4564n1.m15751A().mo29720a().mo29673c();
            new Handler().postDelayed(new C6698x(C4564n1.m15751A().mo29720a().mo29667a(), c), 3000);
        }
        C4564n1.m15788a((C4505f1) this);
        C4564n1.m15850g(true);
        C6722d.m21985c(getIntent().getExtras());
        new C6661f0((C6681k) null).execute(new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(2131558470);
            String string2 = getString(2131558470);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            NotificationChannel notificationChannel = new NotificationChannel("HB2_notification_default", string, 3);
            notificationChannel.setDescription(string2);
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationChannel notificationChannel2 = new NotificationChannel("HB2_notification_default_nosound", string, 3);
            notificationChannel2.setDescription(string2);
            notificationChannel2.setSound((Uri) null, (AudioAttributes) null);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) getSystemService("activity")).getMemoryInfo(memoryInfo);
        if (((((float) memoryInfo.totalMem) / 1024.0f) / 1024.0f) / 1024.0f <= 1.0f) {
            f17469j = true;
        }
    }

    public void onDestroy() {
        Context context;
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onDestroy();
        }
        super.onDestroy();
        if (f17467h) {
            AdMost.getInstance().onDestroy(this);
        }
        if (this.f17488f && f17470k != null && (context = this.f17487e) != null) {
            this.f17488f = false;
            try {
                context.unbindService(this.f17486d);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            mo35761c();
            if (getCurrentFocus() instanceof WebView) {
                WebView webView = (WebView) getCurrentFocus();
                if (webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                Cocos2dxGLSurfaceView.getInstance().requestFocus();
            }
        } else if (i == 25 || i == 24) {
            mo35761c();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        Iterator it = this.f17483a.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onLowMemory();
        }
        super.onLowMemory();
    }

    public void onNewIntent(Intent intent) {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onNewIntent(intent);
        }
        setIntent(intent);
        super.onNewIntent(intent);
    }

    public void onOSSubscriptionChanged(C4512g1 g1Var) {
        if (g1Var.mo29776a().mo29672b()) {
            try {
                pushNotificationTokenReceived(g1Var.mo29776a().mo29667a(), g1Var.mo29776a().mo29673c());
                C3297e.m10958a(g1Var.mo29776a().mo29667a(), C3597b.m12267a().f10092a);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onPause();
        }
        super.onPause();
        if (f17467h) {
            AdMost.getInstance().onPause(this);
        }
        this.f17485c = false;
        C3297e.m10961d();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Iterator it = this.f17483a.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onRequestPermissionsResult(i, strArr, iArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onRestart();
        }
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onResume();
        }
        super.onResume();
        if (f17467h) {
            AdMost.getInstance().onResume(this);
        }
        if (m21910g()) {
            m21909f();
        }
        this.f17485c = true;
        mo35761c();
        ((NotificationManager) getSystemService("notification")).cancel(111);
        C3297e.m10962e();
        if (getCurrentFocus() != Cocos2dxGLSurfaceView.getInstance()) {
            Cocos2dxGLSurfaceView.getInstance().requestFocus();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Iterator it = this.f17483a.iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        C3555b k;
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onStart();
        }
        super.onStart();
        if (f17467h) {
            AdMost.getInstance().onStart(this);
        }
        if (C3597b.m12267a().f10093b && (k = C3555b.m12034k()) != null) {
            k.mo19630a((C3555b.C3562g) new C6700y(), getIntent().getData(), (Activity) this);
        }
    }

    public void onStop() {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onStop();
        }
        super.onStop();
        if (f17467h) {
            AdMost.getInstance().onStop(this);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Iterator it = new ArrayList(this.f17483a).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onWindowFocusChanged(z);
        }
        super.onWindowFocusChanged(z);
        if (z) {
            mo35761c();
        }
    }

    public void queueEvent(ThreadingContext threadingContext, Runnable runnable) {
        if (C6695u.f17517a[threadingContext.ordinal()] != 1) {
            runOnUiThread(runnable);
        } else {
            runOnUiThread(runnable);
        }
    }

    public boolean removeListener(ActivityListener activityListener) {
        return this.f17483a.remove(activityListener);
    }

    /* renamed from: a */
    public void mo35757a(GoogleSignInAccount googleSignInAccount) {
        Games.getGamesClient((Activity) this, googleSignInAccount).setViewForPopups(getGLSurfaceView());
        try {
            if (!this.f17484b) {
                Games.getPlayersClient((Activity) this, googleSignInAccount).getCurrentPlayer().addOnCompleteListener(new C6686n());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo35760b(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("isNewUser", false);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo35758a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("isNewUser", true);
    }
}
