package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.onesignal.C4564n1;
import com.onesignal.C4717x0;
import com.onesignal.C4739z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.x */
/* compiled from: NotificationBundleProcessor */
class C4714x {

    /* renamed from: com.onesignal.x$a */
    /* compiled from: NotificationBundleProcessor */
    static class C4715a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f12801a;

        C4715a(Bundle bundle) {
            this.f12801a = bundle;
        }

        public void run() {
            C4564n1.m15817b(C4714x.m16417c(this.f12801a), false, false);
        }
    }

    /* renamed from: com.onesignal.x$b */
    /* compiled from: NotificationBundleProcessor */
    static class C4716b {

        /* renamed from: a */
        boolean f12802a;

        /* renamed from: b */
        boolean f12803b;

        /* renamed from: c */
        boolean f12804c;

        /* renamed from: d */
        boolean f12805d;

        C4716b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo30027a() {
            return !this.f12802a || this.f12803b || this.f12804c || this.f12805d;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x011e A[SYNTHETIC, Splitter:B:53:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128 A[SYNTHETIC, Splitter:B:59:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m16415b(com.onesignal.C4467a0 r14, boolean r15) {
        /*
            java.lang.String r0 = "grp"
            java.lang.String r1 = "collapse_key"
            java.lang.String r2 = "Error closing transaction! "
            android.content.Context r3 = r14.f12267a
            org.json.JSONObject r4 = r14.f12268b
            org.json.JSONObject r5 = m16413b((org.json.JSONObject) r4)     // Catch:{ JSONException -> 0x0133 }
            android.content.Context r6 = r14.f12267a     // Catch:{ JSONException -> 0x0133 }
            com.onesignal.t1 r6 = com.onesignal.C4655t1.m16157a((android.content.Context) r6)     // Catch:{ JSONException -> 0x0133 }
            r7 = 0
            android.database.sqlite.SQLiteDatabase r6 = r6.mo29967t()     // Catch:{ Exception -> 0x0114 }
            r6.beginTransaction()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            boolean r8 = r14.mo29704g()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r9 = "notification"
            r10 = 1
            if (r8 == 0) goto L_0x004e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.<init>()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r11 = "android_notification_id = "
            r8.append(r11)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            int r11 = r14.mo29699b()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.append(r11)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r11.<init>()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r12 = "dismissed"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r11.put(r12, r13)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r6.update(r9, r11, r8, r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.onesignal.C4521i.m15558a((android.database.sqlite.SQLiteDatabase) r6, (android.content.Context) r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x004e:
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.<init>()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r11 = "notification_id"
            java.lang.String r12 = "i"
            java.lang.String r5 = r5.optString(r12)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r11, r5)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            boolean r5 = r4.has(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r5 == 0) goto L_0x006d
            java.lang.String r5 = "group_id"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r5, r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x006d:
            boolean r0 = r4.has(r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 == 0) goto L_0x0088
            java.lang.String r0 = "do_not_collapse"
            java.lang.String r5 = r4.optString(r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 != 0) goto L_0x0088
            java.lang.String r0 = "collapse_id"
            java.lang.String r1 = r4.optString(r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x0088:
            java.lang.String r0 = "opened"
            if (r15 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r10 = 0
        L_0x008e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r15 != 0) goto L_0x00a4
            java.lang.String r0 = "android_notification_id"
            int r1 = r14.mo29699b()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x00a4:
            java.lang.CharSequence r0 = r14.mo29702e()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = "title"
            java.lang.CharSequence r1 = r14.mo29702e()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x00b7:
            java.lang.CharSequence r0 = r14.mo29701d()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = "message"
            java.lang.CharSequence r14 = r14.mo29701d()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r0, r14)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x00ca:
            java.lang.String r14 = "google.sent_time"
            long r0 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r0 = r4.optLong(r14, r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r10 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r10
            java.lang.String r14 = "google.ttl"
            r5 = 259200(0x3f480, float:3.63217E-40)
            int r14 = r4.optInt(r14, r5)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r10 = (long) r14     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r0 = r0 + r10
            java.lang.String r14 = "expire_time"
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r14, r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r14 = "full_data"
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r8.put(r14, r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r6.insertOrThrow(r9, r7, r8)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r15 != 0) goto L_0x00fc
            com.onesignal.C4521i.m15558a((android.database.sqlite.SQLiteDatabase) r6, (android.content.Context) r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
        L_0x00fc:
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r6 == 0) goto L_0x0137
            r6.endTransaction()     // Catch:{ all -> 0x0105 }
            goto L_0x0137
        L_0x0105:
            r14 = move-exception
            com.onesignal.n1$a0 r15 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ JSONException -> 0x0133 }
        L_0x0108:
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r15, (java.lang.String) r2, (java.lang.Throwable) r14)     // Catch:{ JSONException -> 0x0133 }
            goto L_0x0137
        L_0x010c:
            r14 = move-exception
            r7 = r6
            goto L_0x0126
        L_0x010f:
            r14 = move-exception
            r7 = r6
            goto L_0x0115
        L_0x0112:
            r14 = move-exception
            goto L_0x0126
        L_0x0114:
            r14 = move-exception
        L_0x0115:
            com.onesignal.n1$a0 r15 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = "Error saving notification record! "
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r15, (java.lang.String) r0, (java.lang.Throwable) r14)     // Catch:{ all -> 0x0112 }
            if (r7 == 0) goto L_0x0137
            r7.endTransaction()     // Catch:{ all -> 0x0122 }
            goto L_0x0137
        L_0x0122:
            r14 = move-exception
            com.onesignal.n1$a0 r15 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ JSONException -> 0x0133 }
            goto L_0x0108
        L_0x0126:
            if (r7 == 0) goto L_0x0132
            r7.endTransaction()     // Catch:{ all -> 0x012c }
            goto L_0x0132
        L_0x012c:
            r15 = move-exception
            com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ JSONException -> 0x0133 }
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r2, (java.lang.Throwable) r15)     // Catch:{ JSONException -> 0x0133 }
        L_0x0132:
            throw r14     // Catch:{ JSONException -> 0x0133 }
        L_0x0133:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4714x.m16415b(com.onesignal.a0, boolean):void");
    }

    /* renamed from: c */
    private static boolean m16418c(C4467a0 a0Var) {
        if (a0Var.f12270d && Build.VERSION.SDK_INT <= 18) {
            return false;
        }
        if (a0Var.mo29703f() || m16411a(a0Var.f12268b.optString("alert"))) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    static JSONArray m16419d(JSONObject jSONObject) {
        return new JSONArray().put(jSONObject);
    }

    /* renamed from: e */
    private static void m16421e(Bundle bundle) {
        JSONObject jSONObject;
        String str;
        if (bundle.containsKey("o")) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString("custom"));
                if (jSONObject2.has("a")) {
                    jSONObject = jSONObject2.getJSONObject("a");
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString("o"));
                bundle.remove("o");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put(ViewHierarchyConstants.TEXT_KEY, string);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put("actionSelected", "__DEFAULT__");
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", jSONObject);
                }
                bundle.putString("custom", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static void m16405a(Context context, C4528j jVar, C4739z.C4740a aVar) {
        C4564n1.m15865k(context);
        try {
            String string = jVar.getString("json_payload");
            if (string == null) {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
                C4564n1.m15789a(a0Var, "json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: " + jVar);
                return;
            }
            C4467a0 a0Var2 = new C4467a0(context);
            boolean z = false;
            a0Var2.f12269c = jVar.getBoolean("restoring", false);
            a0Var2.f12272f = jVar.mo29790a("timestamp");
            JSONObject jSONObject = new JSONObject(string);
            a0Var2.f12268b = jSONObject;
            if (m16416c(jSONObject) != null) {
                z = true;
            }
            a0Var2.f12270d = z;
            if (a0Var2.f12269c || z || !C4564n1.m15803a(context, a0Var2.f12268b)) {
                if (jVar.mo29796c("android_notif_id")) {
                    if (aVar == null) {
                        aVar = new C4739z.C4740a();
                    }
                    aVar.f12866b = jVar.mo29795b("android_notif_id");
                }
                a0Var2.f12279m = aVar;
                m16400a(a0Var2);
                if (a0Var2.f12269c) {
                    C4536k1.m15631b(100);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    static boolean m16420d(Bundle bundle) {
        return m16410a(bundle, "licon") || m16410a(bundle, "bicon") || bundle.getString("bg_img", (String) null) != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static JSONArray m16417c(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m16412b(bundle));
        return jSONArray;
    }

    /* renamed from: c */
    static String m16416c(JSONObject jSONObject) {
        try {
            JSONObject b = m16413b(jSONObject);
            if (!b.has("a")) {
                return null;
            }
            JSONObject optJSONObject = b.optJSONObject("a");
            if (optJSONObject.has("os_in_app_message_preview_id")) {
                return optJSONObject.optString("os_in_app_message_preview_id");
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    static int m16400a(C4467a0 a0Var) {
        a0Var.f12271e = C4564n1.m15880v() && C4564n1.m15769S();
        m16414b(a0Var);
        if (m16418c(a0Var)) {
            C4631r.m16044a(a0Var);
        }
        if (!a0Var.f12269c && !a0Var.f12270d) {
            m16406a(a0Var, false);
            try {
                JSONObject jSONObject = new JSONObject(a0Var.f12268b.toString());
                jSONObject.put("notificationId", a0Var.mo29697a());
                C4564n1.m15817b(m16419d(jSONObject), true, a0Var.f12271e);
            } catch (Throwable unused) {
            }
        }
        return a0Var.mo29697a().intValue();
    }

    /* renamed from: a */
    private static void m16404a(Context context, Bundle bundle, boolean z, int i) {
        C4467a0 a0Var = new C4467a0(context);
        a0Var.f12268b = m16412b(bundle);
        C4739z.C4740a aVar = new C4739z.C4740a();
        a0Var.f12279m = aVar;
        aVar.f12866b = Integer.valueOf(i);
        m16406a(a0Var, z);
    }

    /* renamed from: a */
    static void m16406a(C4467a0 a0Var, boolean z) {
        m16415b(a0Var, z);
        if (a0Var.mo29704g()) {
            String c = a0Var.mo29700c();
            C4513g2.m15543b(c);
            C4481c1.m15439a().mo29735a(c);
        }
    }

    /* renamed from: a */
    static C4717x0 m16402a(JSONObject jSONObject) {
        C4717x0 x0Var = new C4717x0();
        try {
            JSONObject b = m16413b(jSONObject);
            x0Var.f12806a = b.optString("i");
            x0Var.f12808c = b.optString("ti");
            x0Var.f12807b = b.optString("tn");
            jSONObject.toString();
            x0Var.f12810e = b.optJSONObject("a");
            b.optString("u", (String) null);
            jSONObject.optString("alert", (String) null);
            x0Var.f12809d = jSONObject.optString("title", (String) null);
            jSONObject.optString("sicon", (String) null);
            jSONObject.optString("bicon", (String) null);
            jSONObject.optString("licon", (String) null);
            jSONObject.optString("sound", (String) null);
            jSONObject.optString("grp", (String) null);
            jSONObject.optString("grp_msg", (String) null);
            jSONObject.optString("bgac", (String) null);
            jSONObject.optString("ledc", (String) null);
            String optString = jSONObject.optString("vis", (String) null);
            if (optString != null) {
                Integer.parseInt(optString);
            }
            jSONObject.optString("from", (String) null);
            jSONObject.optInt("pri", 0);
            boolean equals = "do_not_collapse".equals(jSONObject.optString("collapse_key", (String) null));
            m16407a(x0Var);
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error assigning OSNotificationPayload values!", th);
        }
        try {
            m16408a(x0Var, jSONObject);
        } catch (Throwable th2) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error assigning OSNotificationPayload.backgroundImageLayout values!", th2);
        }
        return x0Var;
    }

    /* renamed from: b */
    static JSONObject m16412b(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
                C4564n1.m15790a(a0Var, "bundleAsJSONObject error for key: " + str, (Throwable) e);
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m16414b(C4467a0 a0Var) {
        if (!a0Var.f12269c && a0Var.f12268b.has("collapse_key") && !"do_not_collapse".equals(a0Var.f12268b.optString("collapse_key"))) {
            String optString = a0Var.f12268b.optString("collapse_key");
            Cursor cursor = null;
            try {
                cursor = C4655t1.m16157a(a0Var.f12267a).mo29963d().query("notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{optString}, (String) null, (String) null, (String) null);
                if (cursor.moveToFirst()) {
                    a0Var.mo29698a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("android_notification_id"))));
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
        }
    }

    /* renamed from: b */
    static JSONObject m16413b(JSONObject jSONObject) throws JSONException {
        return new JSONObject(jSONObject.optString("custom"));
    }

    /* renamed from: a */
    private static void m16407a(C4717x0 x0Var) throws Throwable {
        JSONObject jSONObject = x0Var.f12810e;
        if (jSONObject != null && jSONObject.has("actionButtons")) {
            JSONArray jSONArray = x0Var.f12810e.getJSONArray("actionButtons");
            x0Var.f12811f = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                C4717x0.C4718a aVar = new C4717x0.C4718a();
                jSONObject2.optString("id", (String) null);
                jSONObject2.optString(ViewHierarchyConstants.TEXT_KEY, (String) null);
                jSONObject2.optString("icon", (String) null);
                x0Var.f12811f.add(aVar);
            }
            x0Var.f12810e.remove("actionSelected");
            x0Var.f12810e.remove("actionButtons");
        }
    }

    /* renamed from: a */
    private static void m16408a(C4717x0 x0Var, JSONObject jSONObject) throws Throwable {
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            x0Var.f12812g = new C4717x0.C4719b();
            jSONObject2.optString("img");
            x0Var.f12812g.f12813a = jSONObject2.optString("tc");
            x0Var.f12812g.f12814b = jSONObject2.optString("bc");
        }
    }

    /* renamed from: a */
    static C4716b m16401a(Context context, Bundle bundle) {
        C4716b bVar = new C4716b();
        if (C4564n1.m15782a(bundle) == null) {
            return bVar;
        }
        bVar.f12802a = true;
        m16421e(bundle);
        JSONObject b = m16412b(bundle);
        String c = m16416c(b);
        if (c != null) {
            if (C4564n1.m15769S()) {
                bVar.f12805d = true;
                C4548m0.m15715h().mo29834a(c);
            }
            return bVar;
        } else if (m16409a(context, bundle, bVar)) {
            return bVar;
        } else {
            boolean a = C4564n1.m15803a(context, b);
            bVar.f12804c = a;
            if (!a && !m16411a(bundle.getString("alert"))) {
                m16404a(context, bundle, true, -1);
                new Thread(new C4715a(bundle), "OS_PROC_BUNDLE").start();
            }
            return bVar;
        }
    }

    /* renamed from: a */
    private static boolean m16409a(Context context, Bundle bundle, C4716b bVar) {
        Intent a = C4739z.m16456a(context);
        boolean z = false;
        if (a == null) {
            return false;
        }
        a.putExtra("json_payload", m16412b(bundle).toString());
        a.putExtra("timestamp", System.currentTimeMillis() / 1000);
        if (Integer.parseInt(bundle.getString("pri", AppEventsConstants.EVENT_PARAM_VALUE_NO)) > 9) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            JobIntentService.m15345a(context, a.getComponent(), 2071862121, a, z);
        } else {
            context.startService(a);
        }
        bVar.f12803b = true;
        return true;
    }

    /* renamed from: a */
    static boolean m16411a(String str) {
        boolean z = str != null && !"".equals(str);
        boolean v = C4564n1.m15880v();
        boolean S = C4564n1.m15769S();
        if (!z || (!C4564n1.m15883y() && !v && S)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m16410a(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        return trim.startsWith("http://") || trim.startsWith("https://");
    }
}
