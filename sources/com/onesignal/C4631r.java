package com.onesignal;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import androidx.core.app.C0725i;
import androidx.core.app.C0736l;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.onesignal.C4564n1;
import com.onesignal.C4739z;
import com.tapjoy.TJAdUnitConstants;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.r */
/* compiled from: GenerateNotification */
class C4631r {

    /* renamed from: a */
    private static Context f12626a;

    /* renamed from: b */
    private static String f12627b;

    /* renamed from: c */
    private static Resources f12628c;

    /* renamed from: d */
    private static Class<?> f12629d;

    /* renamed from: e */
    private static boolean f12630e;

    /* renamed from: com.onesignal.r$a */
    /* compiled from: GenerateNotification */
    static class C4632a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f12631a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f12632b;

        /* renamed from: c */
        final /* synthetic */ int f12633c;

        /* renamed from: com.onesignal.r$a$a */
        /* compiled from: GenerateNotification */
        class C4633a implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ List f12634a;

            /* renamed from: b */
            final /* synthetic */ Intent f12635b;

            C4633a(List list, Intent intent) {
                this.f12634a = list;
                this.f12635b = intent;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                int i2 = i + 3;
                if (this.f12634a.size() > 1) {
                    try {
                        JSONObject jSONObject = new JSONObject(C4632a.this.f12632b.toString());
                        jSONObject.put("actionSelected", this.f12634a.get(i2));
                        this.f12635b.putExtra("onesignal_data", jSONObject.toString());
                        C4485d0.m15458c(C4632a.this.f12631a, this.f12635b);
                    } catch (Throwable unused) {
                    }
                } else {
                    C4485d0.m15458c(C4632a.this.f12631a, this.f12635b);
                }
            }
        }

        /* renamed from: com.onesignal.r$a$b */
        /* compiled from: GenerateNotification */
        class C4634b implements DialogInterface.OnCancelListener {

            /* renamed from: a */
            final /* synthetic */ Intent f12637a;

            C4634b(Intent intent) {
                this.f12637a = intent;
            }

            public void onCancel(DialogInterface dialogInterface) {
                C4485d0.m15458c(C4632a.this.f12631a, this.f12637a);
            }
        }

        C4632a(Activity activity, JSONObject jSONObject, int i) {
            this.f12631a = activity;
            this.f12632b = jSONObject;
            this.f12633c = i;
        }

        public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f12631a);
            builder.setTitle(C4631r.m16071e(this.f12632b));
            builder.setMessage(this.f12632b.optString("alert"));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            C4631r.m16059b(this.f12631a, this.f12632b, arrayList, arrayList2);
            Intent a = C4631r.m16068d(this.f12633c);
            a.putExtra("action_button", true);
            a.putExtra("from_alert", true);
            a.putExtra("onesignal_data", this.f12632b.toString());
            if (this.f12632b.has("grp")) {
                a.putExtra("grp", this.f12632b.optString("grp"));
            }
            C4633a aVar = new C4633a(arrayList2, a);
            builder.setOnCancelListener(new C4634b(a));
            for (int i = 0; i < arrayList.size(); i++) {
                if (i == 0) {
                    builder.setNeutralButton((CharSequence) arrayList.get(i), aVar);
                } else if (i == 1) {
                    builder.setNegativeButton((CharSequence) arrayList.get(i), aVar);
                } else if (i == 2) {
                    builder.setPositiveButton((CharSequence) arrayList.get(i), aVar);
                }
            }
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    /* renamed from: com.onesignal.r$b */
    /* compiled from: GenerateNotification */
    private static class C4635b {

        /* renamed from: a */
        C0725i.C0730e f12639a;

        /* renamed from: b */
        boolean f12640b;

        private C4635b() {
        }

        /* synthetic */ C4635b(C4632a aVar) {
            this();
        }
    }

    /* renamed from: b */
    private static int m16054b(int i) {
        if (i > 9) {
            return 2;
        }
        if (i > 7) {
            return 1;
        }
        if (i > 4) {
            return 0;
        }
        return i > 2 ? -1 : -2;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0067 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076 A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[SYNTHETIC, Splitter:B:29:0x00a5] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.onesignal.C4631r.C4635b m16057b(com.onesignal.C4467a0 r9) {
        /*
            java.lang.String r0 = "vis"
            org.json.JSONObject r1 = r9.f12268b
            com.onesignal.r$b r2 = new com.onesignal.r$b
            r3 = 0
            r2.<init>(r3)
            java.lang.String r4 = com.onesignal.C4728y.m16434a((com.onesignal.C4467a0) r9)     // Catch:{ all -> 0x0016 }
            androidx.core.app.i$e r5 = new androidx.core.app.i$e     // Catch:{ all -> 0x0016 }
            android.content.Context r6 = f12626a     // Catch:{ all -> 0x0016 }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0016 }
            goto L_0x001d
        L_0x0016:
            androidx.core.app.i$e r5 = new androidx.core.app.i$e
            android.content.Context r4 = f12626a
            r5.<init>(r4)
        L_0x001d:
            java.lang.String r4 = "alert"
            java.lang.String r4 = r1.optString(r4, r3)
            r6 = 1
            r5.mo3931a((boolean) r6)
            int r7 = m16067d((org.json.JSONObject) r1)
            r5.mo3946f(r7)
            androidx.core.app.i$c r7 = new androidx.core.app.i$c
            r7.<init>()
            r7.mo3916a((java.lang.CharSequence) r4)
            r5.mo3928a((androidx.core.app.C0725i.C0733h) r7)
            r5.mo3929a((java.lang.CharSequence) r4)
            r5.mo3940c((java.lang.CharSequence) r4)
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 24
            if (r7 < r8) goto L_0x0053
            java.lang.String r7 = "title"
            java.lang.String r7 = r1.optString(r7)
            java.lang.String r8 = ""
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x005a
        L_0x0053:
            java.lang.CharSequence r7 = m16071e((org.json.JSONObject) r1)
            r5.mo3936b((java.lang.CharSequence) r7)
        L_0x005a:
            java.math.BigInteger r7 = m16058b((org.json.JSONObject) r1)     // Catch:{ all -> 0x0067 }
            if (r7 == 0) goto L_0x0067
            int r7 = r7.intValue()     // Catch:{ all -> 0x0067 }
            r5.mo3919a((int) r7)     // Catch:{ all -> 0x0067 }
        L_0x0067:
            boolean r7 = r1.has(r0)     // Catch:{ all -> 0x007b }
            if (r7 == 0) goto L_0x0076
            java.lang.String r0 = r1.optString(r0)     // Catch:{ all -> 0x007b }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x007b }
            goto L_0x0077
        L_0x0076:
            r0 = 1
        L_0x0077:
            r5.mo3947g(r0)     // Catch:{ all -> 0x007b }
            goto L_0x007c
        L_0x007b:
        L_0x007c:
            android.graphics.Bitmap r0 = m16063c((org.json.JSONObject) r1)
            if (r0 == 0) goto L_0x0087
            r2.f12640b = r6
            r5.mo3924a((android.graphics.Bitmap) r0)
        L_0x0087:
            java.lang.String r0 = "bicon"
            java.lang.String r0 = r1.optString(r0, r3)
            android.graphics.Bitmap r0 = m16036a((java.lang.String) r0)
            if (r0 == 0) goto L_0x00a1
            androidx.core.app.i$b r3 = new androidx.core.app.i$b
            r3.<init>()
            r3.mo3915b(r0)
            r3.mo3913a((java.lang.CharSequence) r4)
            r5.mo3928a((androidx.core.app.C0725i.C0733h) r3)
        L_0x00a1:
            java.lang.Long r9 = r9.f12272f
            if (r9 == 0) goto L_0x00b0
            long r3 = r9.longValue()     // Catch:{ all -> 0x00b0 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r6
            r5.mo3922a((long) r3)     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            m16060b((org.json.JSONObject) r1, (androidx.core.app.C0725i.C0730e) r5)
            r2.f12639a = r5
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4631r.m16057b(com.onesignal.a0):com.onesignal.r$b");
    }

    /* renamed from: c */
    private static Intent m16061c(int i) {
        Intent putExtra = new Intent(f12626a, f12629d).putExtra("notificationId", i).putExtra("dismissed", true);
        if (f12630e) {
            return putExtra;
        }
        return putExtra.addFlags(402718720);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Intent m16068d(int i) {
        Intent putExtra = new Intent(f12626a, f12629d).putExtra("notificationId", i);
        if (f12630e) {
            return putExtra;
        }
        return putExtra.addFlags(603979776);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static CharSequence m16071e(JSONObject jSONObject) {
        String optString = jSONObject.optString("title", (String) null);
        if (optString != null) {
            return optString;
        }
        return f12626a.getPackageManager().getApplicationLabel(f12626a.getApplicationInfo());
    }

    /* renamed from: f */
    private static boolean m16072f(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", (String) null);
        if ("null".equals(optString) || "nil".equals(optString)) {
            return false;
        }
        return C4564n1.m15756F();
    }

    /* renamed from: e */
    private static int m16070e(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (!C4536k1.m15627a(trim)) {
            return 0;
        }
        int d = m16066d(trim);
        if (d != 0) {
            return d;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static void m16039a(Context context) {
        f12626a = context;
        f12627b = context.getPackageName();
        f12628c = f12626a.getResources();
        PackageManager packageManager = f12626a.getPackageManager();
        Intent intent = new Intent(f12626a, NotificationOpenedReceiver.class);
        intent.setPackage(f12626a.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
            f12630e = true;
            f12629d = NotificationOpenedReceiver.class;
            return;
        }
        f12629d = C4480c0.class;
    }

    /* renamed from: d */
    static void m16069d(C4467a0 a0Var) {
        m16039a(a0Var.f12267a);
        m16047a(a0Var, (C4635b) null);
    }

    /* renamed from: c */
    private static void m16065c(C4467a0 a0Var) {
        Notification notification;
        int intValue = a0Var.mo29697a().intValue();
        JSONObject jSONObject = a0Var.f12268b;
        String optString = jSONObject.optString("grp", (String) null);
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList = C4676v1.m16252a(f12626a);
            if (optString == null && arrayList.size() >= 3) {
                optString = C4676v1.m16254b();
                C4676v1.m16253a(f12626a, arrayList);
            }
        }
        C4635b b = m16057b(a0Var);
        C0725i.C0730e eVar = b.f12639a;
        m16052a(jSONObject, eVar, intValue, (String) null);
        try {
            m16051a(jSONObject, eVar);
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Could not set background notification image!", th);
        }
        m16046a(a0Var, eVar);
        if (a0Var.f12269c) {
            m16042a(eVar);
        }
        C4476b0.m15424a(f12626a, optString != null ? 2 : 1);
        if (optString != null) {
            m16043a(eVar, jSONObject, optString, intValue);
            notification = m16055b(a0Var, eVar);
            if (Build.VERSION.SDK_INT < 24 || !optString.equals(C4676v1.m16254b())) {
                m16047a(a0Var, b);
            } else {
                m16045a(a0Var, arrayList.size() + 1);
            }
        } else {
            notification = m16030a(eVar, jSONObject, intValue);
        }
        if (optString == null || Build.VERSION.SDK_INT > 17) {
            m16048a(b, notification);
            C0736l.m2316a(f12626a).mo3959a(intValue, notification);
        }
    }

    /* renamed from: d */
    private static int m16067d(JSONObject jSONObject) {
        int e = m16070e(jSONObject.optString("sicon", (String) null));
        if (e != 0) {
            return e;
        }
        return m16053b();
    }

    /* renamed from: d */
    private static int m16066d(String str) {
        return f12628c.getIdentifier(str, "drawable", f12627b);
    }

    /* renamed from: a */
    static void m16044a(C4467a0 a0Var) {
        Activity activity;
        m16039a(a0Var.f12267a);
        if (a0Var.f12269c || !a0Var.f12271e || (activity = C4461a.f12260f) == null) {
            m16065c(a0Var);
        } else {
            m16050a(a0Var.f12268b, activity, a0Var.mo29697a().intValue());
        }
    }

    /* renamed from: a */
    private static void m16050a(JSONObject jSONObject, Activity activity, int i) {
        activity.runOnUiThread(new C4632a(activity, jSONObject, i));
    }

    /* renamed from: a */
    private static PendingIntent m16031a(int i, Intent intent) {
        if (f12630e) {
            return PendingIntent.getBroadcast(f12626a, i, intent, 134217728);
        }
        return PendingIntent.getActivity(f12626a, i, intent, 134217728);
    }

    /* renamed from: a */
    private static void m16042a(C0725i.C0730e eVar) {
        eVar.mo3943d(true);
        eVar.mo3934b(0);
        eVar.mo3925a((Uri) null);
        eVar.mo3932a((long[]) null);
        eVar.mo3940c((CharSequence) null);
    }

    /* renamed from: a */
    private static Notification m16030a(C0725i.C0730e eVar, JSONObject jSONObject, int i) {
        SecureRandom secureRandom = new SecureRandom();
        eVar.mo3923a(m16031a(secureRandom.nextInt(), m16068d(i).putExtra("onesignal_data", jSONObject.toString())));
        eVar.mo3935b(m16031a(secureRandom.nextInt(), m16061c(i)));
        return eVar.mo3918a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m16060b(org.json.JSONObject r6, androidx.core.app.C0725i.C0730e r7) {
        /*
            java.lang.String r0 = "pri"
            r1 = 6
            int r0 = r6.optInt(r0, r1)
            int r0 = m16054b((int) r0)
            r7.mo3944e((int) r0)
            r1 = 0
            r2 = 1
            if (r0 >= 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0018
            return
        L_0x0018:
            java.lang.String r0 = "ledc"
            boolean r3 = r6.has(r0)
            r4 = 4
            if (r3 == 0) goto L_0x0040
            java.lang.String r3 = "led"
            int r3 = r6.optInt(r3, r2)
            if (r3 != r2) goto L_0x0040
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r6.optString(r0)     // Catch:{ all -> 0x0040 }
            r5 = 16
            r3.<init>(r0, r5)     // Catch:{ all -> 0x0040 }
            int r0 = r3.intValue()     // Catch:{ all -> 0x0040 }
            r3 = 2000(0x7d0, float:2.803E-42)
            r5 = 5000(0x1388, float:7.006E-42)
            r7.mo3920a((int) r0, (int) r3, (int) r5)     // Catch:{ all -> 0x0040 }
            goto L_0x0041
        L_0x0040:
            r1 = 4
        L_0x0041:
            boolean r0 = com.onesignal.C4564n1.m15760J()
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "vib"
            int r0 = r6.optInt(r0, r2)
            if (r0 != r2) goto L_0x0063
            java.lang.String r0 = "vib_pt"
            boolean r0 = r6.has(r0)
            if (r0 == 0) goto L_0x0061
            long[] r0 = com.onesignal.C4536k1.m15628a((org.json.JSONObject) r6)
            if (r0 == 0) goto L_0x0063
            r7.mo3932a((long[]) r0)
            goto L_0x0063
        L_0x0061:
            r1 = r1 | 2
        L_0x0063:
            boolean r0 = m16072f(r6)
            if (r0 == 0) goto L_0x007e
            android.content.Context r0 = f12626a
            r2 = 0
            java.lang.String r3 = "sound"
            java.lang.String r6 = r6.optString(r3, r2)
            android.net.Uri r6 = com.onesignal.C4536k1.m15634c(r0, r6)
            if (r6 == 0) goto L_0x007c
            r7.mo3925a((android.net.Uri) r6)
            goto L_0x007e
        L_0x007c:
            r1 = r1 | 1
        L_0x007e:
            r7.mo3934b((int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4631r.m16060b(org.json.JSONObject, androidx.core.app.i$e):void");
    }

    /* renamed from: a */
    private static void m16043a(C0725i.C0730e eVar, JSONObject jSONObject, String str, int i) {
        SecureRandom secureRandom = new SecureRandom();
        eVar.mo3923a(m16031a(secureRandom.nextInt(), m16068d(i).putExtra("onesignal_data", jSONObject.toString()).putExtra("grp", str)));
        eVar.mo3935b(m16031a(secureRandom.nextInt(), m16061c(i).putExtra("grp", str)));
        eVar.mo3937b(str);
        try {
            eVar.mo3939c(1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static Bitmap m16063c(JSONObject jSONObject) {
        Bitmap a = m16036a(jSONObject.optString("licon"));
        if (a == null) {
            a = m16056b("ic_onesignal_large_icon_default");
        }
        if (a == null) {
            return null;
        }
        return m16035a(a);
    }

    /* renamed from: c */
    private static Bitmap m16062c(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.WARN, "Could not download image!", th);
            return null;
        }
    }

    /* renamed from: c */
    private static void m16064c(Context context, JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
        if (jSONObject2.has("a")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
            if (jSONObject3.has("actionButtons")) {
                JSONArray optJSONArray = jSONObject3.optJSONArray("actionButtons");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                    list.add(jSONObject4.optString(ViewHierarchyConstants.TEXT_KEY));
                    list2.add(jSONObject4.optString("id"));
                }
            }
        }
    }

    /* renamed from: a */
    private static void m16046a(C4467a0 a0Var, C0725i.C0730e eVar) {
        Class<C0725i.C0730e> cls = C0725i.C0730e.class;
        C4739z.C4740a aVar = a0Var.f12279m;
        if (aVar != null && aVar.f12865a != null) {
            try {
                Field declaredField = cls.getDeclaredField("P");
                declaredField.setAccessible(true);
                Notification notification = (Notification) declaredField.get(eVar);
                a0Var.f12277k = Integer.valueOf(notification.flags);
                a0Var.f12278l = notification.sound;
                eVar.mo3927a(a0Var.f12279m.f12865a);
                Notification notification2 = (Notification) declaredField.get(eVar);
                Field declaredField2 = cls.getDeclaredField("e");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("d");
                declaredField3.setAccessible(true);
                a0Var.f12273g = (CharSequence) declaredField2.get(eVar);
                a0Var.f12274h = (CharSequence) declaredField3.get(eVar);
                if (!a0Var.f12269c) {
                    a0Var.f12276j = Integer.valueOf(notification2.flags);
                    a0Var.f12275i = notification2.sound;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static Notification m16055b(C4467a0 a0Var, C0725i.C0730e eVar) {
        Uri uri;
        int i = Build.VERSION.SDK_INT;
        boolean z = i > 17 && i < 24 && !a0Var.f12269c;
        if (z && (uri = a0Var.f12275i) != null && !uri.equals(a0Var.f12278l)) {
            eVar.mo3925a((Uri) null);
        }
        Notification a = eVar.mo3918a();
        if (z) {
            eVar.mo3925a(a0Var.f12275i);
        }
        return a;
    }

    /* renamed from: b */
    private static Bitmap m16056b(String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(f12626a.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    bitmap = BitmapFactory.decodeStream(f12626a.getAssets().open(str + str2));
                    continue;
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int e = m16070e(str);
            if (e != 0) {
                return BitmapFactory.decodeResource(f12628c, e);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    /* renamed from: b */
    private static int m16053b() {
        int d = m16066d("ic_stat_onesignal_default");
        if (d != 0) {
            return d;
        }
        int d2 = m16066d("corona_statusbar_icon_default");
        if (d2 != 0) {
            return d2;
        }
        int d3 = m16066d("ic_os_notification_fallback_white_24dp");
        if (d3 != 0) {
            return d3;
        }
        return 17301598;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[Catch:{ all -> 0x0025 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.math.BigInteger m16058b(org.json.JSONObject r4) {
        /*
            java.lang.String r0 = "bgac"
            r1 = 16
            r2 = 0
            boolean r3 = r4.has(r0)     // Catch:{ all -> 0x0015 }
            if (r3 == 0) goto L_0x0015
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch:{ all -> 0x0015 }
            java.lang.String r4 = r4.optString(r0, r2)     // Catch:{ all -> 0x0015 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0015 }
            return r3
        L_0x0015:
            android.content.Context r4 = f12626a     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "com.onesignal.NotificationAccentColor.DEFAULT"
            java.lang.String r4 = com.onesignal.C4536k1.m15630b(r4, r0)     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0025
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x0025 }
            r0.<init>(r4, r1)     // Catch:{ all -> 0x0025 }
            return r0
        L_0x0025:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4631r.m16058b(org.json.JSONObject):java.math.BigInteger");
    }

    /* renamed from: a */
    private static void m16048a(C4635b bVar, Notification notification) {
        if (bVar.f12640b) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, true);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m16059b(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            m16064c(context, jSONObject, list, list2);
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == 0 || list.size() < 3) {
            list.add(C4536k1.m15620a(context, "onesignal_in_app_alert_ok_button_text", "Ok"));
            list2.add("__DEFAULT__");
        }
    }

    /* renamed from: a */
    private static void m16047a(C4467a0 a0Var, C4635b bVar) {
        JSONObject jSONObject;
        PendingIntent pendingIntent;
        Cursor query;
        String str;
        Integer num;
        JSONObject jSONObject2;
        ArrayList<SpannableString> arrayList;
        Notification notification;
        String str2;
        String str3;
        String str4;
        String str5;
        C4467a0 a0Var2 = a0Var;
        C4635b bVar2 = bVar;
        String str6 = "message";
        String str7 = "title";
        String str8 = "is_summary";
        boolean z = a0Var2.f12269c;
        JSONObject jSONObject3 = a0Var2.f12268b;
        Cursor cursor = null;
        String optString = jSONObject3.optString("grp", (String) null);
        SecureRandom secureRandom = new SecureRandom();
        PendingIntent a = m16031a(secureRandom.nextInt(), m16061c(0).putExtra("summary", optString));
        C4655t1 a2 = C4655t1.m16157a(f12626a);
        try {
            SQLiteDatabase d = a2.mo29963d();
            try {
                String[] strArr = {"android_notification_id", "full_data", str8, str7, str6};
                jSONObject = jSONObject3;
                String str9 = "group_id = ? AND dismissed = 0 AND opened = 0";
                String[] strArr2 = {optString};
                if (!z) {
                    try {
                        pendingIntent = a;
                        if (a0Var.mo29697a().intValue() != -1) {
                            str9 = str9 + " AND android_notification_id <> " + a0Var.mo29697a();
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    pendingIntent = a;
                }
                query = d.query("notification", strArr, str9, strArr2, (String) null, (String) null, "_id DESC");
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                if (num == null) {
                    num = Integer.valueOf(secureRandom.nextInt());
                    m16049a(a2, optString, num.intValue());
                }
                PendingIntent a3 = m16031a(secureRandom.nextInt(), m16033a(num.intValue(), jSONObject2, optString));
                if (arrayList == null || ((!z || arrayList.size() <= 1) && (z || arrayList.size() <= 0))) {
                    C4635b bVar3 = bVar;
                    C0725i.C0730e eVar = bVar3.f12639a;
                    eVar.f1840b.clear();
                    m16052a(jSONObject2, eVar, num.intValue(), optString);
                    eVar.mo3923a(a3);
                    eVar.mo3935b(pendingIntent);
                    eVar.mo3943d(z);
                    eVar.mo3931a(false);
                    eVar.mo3937b(optString);
                    eVar.mo3938b(true);
                    try {
                        eVar.mo3939c(1);
                    } catch (Throwable unused) {
                    }
                    notification = eVar.mo3918a();
                    m16048a(bVar3, notification);
                } else {
                    int size = arrayList.size() + (z ^ true ? 1 : 0);
                    String optString2 = jSONObject2.optString("grp_msg", (String) null);
                    if (optString2 == null) {
                        str2 = size + " new messages";
                    } else {
                        str2 = optString2.replace("$[notif_count]", str + size);
                    }
                    C0725i.C0730e eVar2 = m16057b(a0Var).f12639a;
                    if (z) {
                        m16042a(eVar2);
                    } else {
                        Uri uri = a0Var2.f12275i;
                        if (uri != null) {
                            eVar2.mo3925a(uri);
                        }
                        Integer num2 = a0Var2.f12276j;
                        if (num2 != null) {
                            eVar2.mo3934b(num2.intValue());
                        }
                    }
                    eVar2.mo3923a(a3);
                    eVar2.mo3935b(pendingIntent);
                    eVar2.mo3936b(f12626a.getPackageManager().getApplicationLabel(f12626a.getApplicationInfo()));
                    eVar2.mo3929a((CharSequence) str2);
                    eVar2.mo3942d(size);
                    eVar2.mo3946f(m16053b());
                    eVar2.mo3924a(m16034a());
                    eVar2.mo3943d(z);
                    eVar2.mo3931a(false);
                    eVar2.mo3937b(optString);
                    eVar2.mo3938b(true);
                    try {
                        eVar2.mo3939c(1);
                    } catch (Throwable unused2) {
                    }
                    if (!z) {
                        eVar2.mo3940c((CharSequence) str2);
                    }
                    C0725i.C0732g gVar = new C0725i.C0732g();
                    if (!z) {
                        String charSequence = a0Var.mo29702e() != null ? a0Var.mo29702e().toString() : null;
                        if (charSequence != null) {
                            str = charSequence + " ";
                        }
                        SpannableString spannableString = new SpannableString(str + a0Var.mo29701d().toString());
                        if (str.length() > 0) {
                            spannableString.setSpan(new StyleSpan(1), 0, str.length(), 0);
                        }
                        gVar.mo3949a((CharSequence) spannableString);
                    }
                    for (SpannableString a4 : arrayList) {
                        gVar.mo3949a((CharSequence) a4);
                    }
                    gVar.mo3950b(str2);
                    eVar2.mo3928a((C0725i.C0733h) gVar);
                    notification = eVar2.mo3918a();
                }
                C0736l.m2316a(f12626a).mo3959a(num.intValue(), notification);
                return;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                cursor.close();
                throw th;
            }
            try {
                str = "";
                if (query.moveToFirst()) {
                    ArrayList arrayList2 = new ArrayList();
                    String str10 = null;
                    num = null;
                    while (true) {
                        Integer num3 = num;
                        String str11 = str8;
                        if (query.getInt(query.getColumnIndex(str8)) == 1) {
                            num = Integer.valueOf(query.getInt(query.getColumnIndex("android_notification_id")));
                            str4 = str6;
                            str3 = str7;
                        } else {
                            String string = query.getString(query.getColumnIndex(str7));
                            if (string == null) {
                                str5 = str;
                            } else {
                                str5 = string + " ";
                            }
                            str4 = str6;
                            str3 = str7;
                            SpannableString spannableString2 = new SpannableString(str5 + query.getString(query.getColumnIndex(str6)));
                            if (str5.length() > 0) {
                                spannableString2.setSpan(new StyleSpan(1), 0, str5.length(), 0);
                            }
                            arrayList2.add(spannableString2);
                            if (str10 == null) {
                                str10 = query.getString(query.getColumnIndex("full_data"));
                            }
                            num = num3;
                        }
                        if (!query.moveToNext()) {
                            break;
                        }
                        str8 = str11;
                        str6 = str4;
                        str7 = str3;
                    }
                    if (z && str10 != null) {
                        ArrayList arrayList3 = arrayList2;
                        jSONObject2 = new JSONObject(str10);
                        arrayList = arrayList3;
                    }
                    arrayList = arrayList2;
                    jSONObject2 = jSONObject;
                } else {
                    jSONObject2 = jSONObject;
                    arrayList = null;
                    num = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                cursor.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m16045a(C4467a0 a0Var, int i) {
        JSONObject jSONObject = a0Var.f12268b;
        SecureRandom secureRandom = new SecureRandom();
        String b = C4676v1.m16254b();
        String str = i + " new messages";
        int a = C4676v1.m16250a();
        PendingIntent a2 = m16031a(secureRandom.nextInt(), m16033a(a, jSONObject, b));
        PendingIntent a3 = m16031a(secureRandom.nextInt(), m16061c(0).putExtra("summary", b));
        C0725i.C0730e eVar = m16057b(a0Var).f12639a;
        Uri uri = a0Var.f12275i;
        if (uri != null) {
            eVar.mo3925a(uri);
        }
        Integer num = a0Var.f12276j;
        if (num != null) {
            eVar.mo3934b(num.intValue());
        }
        eVar.mo3923a(a2);
        eVar.mo3935b(a3);
        eVar.mo3936b(f12626a.getPackageManager().getApplicationLabel(f12626a.getApplicationInfo()));
        eVar.mo3929a((CharSequence) str);
        eVar.mo3942d(i);
        eVar.mo3946f(m16053b());
        eVar.mo3924a(m16034a());
        eVar.mo3943d(true);
        eVar.mo3931a(false);
        eVar.mo3937b(b);
        eVar.mo3938b(true);
        try {
            eVar.mo3939c(1);
        } catch (Throwable unused) {
        }
        C0725i.C0732g gVar = new C0725i.C0732g();
        gVar.mo3950b(str);
        eVar.mo3928a((C0725i.C0733h) gVar);
        C0736l.m2316a(f12626a).mo3959a(a, eVar.mo3918a());
    }

    /* renamed from: a */
    private static Intent m16033a(int i, JSONObject jSONObject, String str) {
        return m16068d(i).putExtra("onesignal_data", jSONObject.toString()).putExtra("summary", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042 A[SYNTHETIC, Splitter:B:14:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m16049a(com.onesignal.C4655t1 r4, java.lang.String r5, int r6) {
        /*
            java.lang.String r0 = "Error closing transaction! "
            r1 = 0
            android.database.sqlite.SQLiteDatabase r4 = r4.mo29967t()     // Catch:{ all -> 0x0038 }
            r4.beginTransaction()     // Catch:{ all -> 0x0035 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0035 }
            r2.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r3 = "android_notification_id"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0035 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0035 }
            java.lang.String r6 = "group_id"
            r2.put(r6, r5)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "is_summary"
            r6 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0035 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "notification"
            r4.insertOrThrow(r5, r1, r2)     // Catch:{ all -> 0x0035 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x004c
            r4.endTransaction()     // Catch:{ all -> 0x0046 }
            goto L_0x004c
        L_0x0035:
            r5 = move-exception
            r1 = r4
            goto L_0x0039
        L_0x0038:
            r5 = move-exception
        L_0x0039:
            com.onesignal.n1$a0 r4 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x004d }
            java.lang.String r6 = "Error adding summary notification record! "
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r4, (java.lang.String) r6, (java.lang.Throwable) r5)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x004c
            r1.endTransaction()     // Catch:{ all -> 0x0046 }
            goto L_0x004c
        L_0x0046:
            r4 = move-exception
            com.onesignal.n1$a0 r5 = com.onesignal.C4564n1.C4566a0.ERROR
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r5, (java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x004c:
            return
        L_0x004d:
            r4 = move-exception
            if (r1 == 0) goto L_0x005a
            r1.endTransaction()     // Catch:{ all -> 0x0054 }
            goto L_0x005a
        L_0x0054:
            r5 = move-exception
            com.onesignal.n1$a0 r6 = com.onesignal.C4564n1.C4566a0.ERROR
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r6, (java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x005a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4631r.m16049a(com.onesignal.t1, java.lang.String, int):void");
    }

    /* renamed from: a */
    private static void m16051a(JSONObject jSONObject, C0725i.C0730e eVar) throws Throwable {
        JSONObject jSONObject2;
        Bitmap bitmap;
        String str;
        if (Build.VERSION.SDK_INT >= 16) {
            String optString = jSONObject.optString("bg_img", (String) null);
            if (optString != null) {
                jSONObject2 = new JSONObject(optString);
                bitmap = m16036a(jSONObject2.optString("img", (String) null));
            } else {
                bitmap = null;
                jSONObject2 = null;
            }
            if (bitmap == null) {
                bitmap = m16056b("onesignal_bgimage_default_image");
            }
            if (bitmap != null) {
                RemoteViews remoteViews = new RemoteViews(f12626a.getPackageName(), R$layout.onesignal_bgimage_notif_layout);
                remoteViews.setTextViewText(R$id.os_bgimage_notif_title, m16071e(jSONObject));
                remoteViews.setTextViewText(R$id.os_bgimage_notif_body, jSONObject.optString("alert"));
                m16041a(remoteViews, jSONObject2, R$id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
                m16041a(remoteViews, jSONObject2, R$id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
                if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                    int identifier = f12628c.getIdentifier("onesignal_bgimage_notif_image_align", "string", f12627b);
                    str = identifier != 0 ? f12628c.getString(identifier) : null;
                } else {
                    str = jSONObject2.getString("img_align");
                }
                if (TJAdUnitConstants.String.RIGHT.equals(str)) {
                    remoteViews.setViewPadding(R$id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                    remoteViews.setImageViewBitmap(R$id.os_bgimage_notif_bgimage_right_aligned, bitmap);
                    remoteViews.setViewVisibility(R$id.os_bgimage_notif_bgimage_right_aligned, 0);
                    remoteViews.setViewVisibility(R$id.os_bgimage_notif_bgimage, 2);
                } else {
                    remoteViews.setImageViewBitmap(R$id.os_bgimage_notif_bgimage, bitmap);
                }
                eVar.mo3926a(remoteViews);
                eVar.mo3928a((C0725i.C0733h) null);
            }
        }
    }

    /* renamed from: a */
    private static void m16041a(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        Integer a = m16038a(jSONObject, str);
        if (a != null) {
            remoteViews.setTextColor(i, a.intValue());
            return;
        }
        int identifier = f12628c.getIdentifier(str2, "color", f12627b);
        if (identifier != 0) {
            remoteViews.setTextColor(i, C4507g.m15528a(f12626a, identifier));
        }
    }

    /* renamed from: a */
    private static Integer m16038a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m16034a() {
        return m16035a(m16056b("ic_onesignal_large_icon_default"));
    }

    /* renamed from: a */
    private static Bitmap m16035a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int dimension = (int) f12628c.getDimension(17104902);
            int dimension2 = (int) f12628c.getDimension(17104901);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (((float) dimension) * (((float) width) / ((float) height)));
            } else if (width > height) {
                dimension = (int) (((float) dimension2) * (((float) height) / ((float) width)));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    /* renamed from: a */
    private static Bitmap m16036a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("http://") || trim.startsWith("https://")) {
            return m16062c(trim);
        }
        return m16056b(str);
    }

    /* renamed from: a */
    private static void m16052a(JSONObject jSONObject, C0725i.C0730e eVar, int i, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (jSONObject2.has("a")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
                if (jSONObject3.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("actionButtons");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                        Intent d = m16068d(i);
                        d.setAction("" + i2);
                        d.putExtra("action_button", true);
                        jSONObject4.put("actionSelected", optJSONObject.optString("id"));
                        d.putExtra("onesignal_data", jSONObject4.toString());
                        if (str != null) {
                            d.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            d.putExtra("grp", jSONObject.optString("grp"));
                        }
                        eVar.mo3921a(optJSONObject.has("icon") ? m16070e(optJSONObject.optString("icon")) : 0, (CharSequence) optJSONObject.optString(ViewHierarchyConstants.TEXT_KEY), m16031a(i, d));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
