package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Vibrator;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.i0 */
class C1316i0 {

    /* renamed from: com.adcolony.sdk.i0$a */
    class C1317a implements C1458z {
        C1317a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6585a(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$b */
    class C1318b implements C1458z {
        C1318b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6586b(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$c */
    class C1319c implements C1458z {
        C1319c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6596n(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$d */
    class C1320d implements C1458z {
        C1320d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1316i0.this.m5177h(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$e */
    class C1321e implements C1458z {
        C1321e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1316i0.this.m5174c(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$f */
    class C1322f implements C1458z {
        C1322f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6589e(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$g */
    class C1323g implements C1458z {
        C1323g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1316i0.this.m5179p(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$h */
    class C1324h implements C1458z {
        C1324h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1316i0.this.m5178l(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$i */
    class C1325i implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: a */
        final /* synthetic */ JSONObject f4175a;

        /* renamed from: b */
        final /* synthetic */ C1454x f4176b;

        C1325i(JSONObject jSONObject, C1454x xVar) {
            this.f4175a = jSONObject;
            this.f4176b = xVar;
        }

        public void onScanCompleted(String str, Uri uri) {
            C1359k0.m5310a("Screenshot saved to Gallery!", 0);
            C1437s.m5603b(this.f4175a, GraphResponse.SUCCESS_KEY, true);
            this.f4176b.mo6829a(this.f4175a).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.i0$j */
    class C1326j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4178a;

        C1326j(String str) {
            this.f4178a = str;
        }

        public void run() {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "type", "open_hook");
            C1437s.m5592a(b, "message", this.f4178a);
            new C1454x("CustomMessage.controller_send", 0, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.i0$k */
    class C1327k implements C1458z {
        C1327k() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6593j(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$l */
    class C1328l implements C1458z {
        C1328l() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6594k(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$m */
    class C1329m implements C1458z {
        C1329m() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6597o(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$n */
    class C1330n implements C1458z {
        C1330n() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6595m(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$o */
    class C1331o implements C1458z {
        C1331o() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6598q(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$p */
    class C1332p implements C1458z {
        C1332p() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6592i(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$q */
    class C1333q implements C1458z {
        C1333q() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6591g(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$r */
    class C1334r implements C1458z {
        C1334r() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6590f(xVar);
        }
    }

    /* renamed from: com.adcolony.sdk.i0$s */
    class C1335s implements C1458z {
        C1335s() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1316i0.this.mo6588d(xVar);
        }
    }

    C1316i0() {
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m5177h(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        C1222d b2 = C1199a.m4880c().mo6530b();
        String h = C1437s.m5613h(b, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = b2.mo6453a().get(h);
        AdColonyAdView adColonyAdView = b2.mo6458b().get(h);
        if ((adColonyInterstitial == null || adColonyInterstitial.getListener() == null || adColonyInterstitial.mo6327c() == null) && (adColonyAdView == null || adColonyAdView.getListener() == null)) {
            return false;
        }
        if (adColonyAdView == null) {
            new C1454x("AdUnit.make_in_app_purchase", adColonyInterstitial.mo6327c().mo6428k()).mo6834d();
        }
        mo6584a(h);
        m5172b(h);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m5178l(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "ad_session_id");
        int f = C1437s.m5611f(b, "orientation");
        C1222d b2 = C1199a.m4880c().mo6530b();
        AdColonyAdView adColonyAdView = b2.mo6458b().get(h);
        AdColonyInterstitial adColonyInterstitial = b2.mo6453a().get(h);
        Context b3 = C1199a.m4878b();
        if (adColonyAdView != null) {
            adColonyAdView.setOrientation(f);
        } else if (adColonyInterstitial != null) {
            adColonyInterstitial.mo6317a(f);
        }
        if (adColonyInterstitial == null && adColonyAdView == null) {
            new C1439u.C1440a().mo6801a("Invalid ad session id sent with set orientation properties message: ").mo6801a(h).mo6803a(C1439u.f4517j);
            return false;
        } else if (!(b3 instanceof C1202b)) {
            return true;
        } else {
            ((C1202b) b3).mo6392a(adColonyAdView == null ? adColonyInterstitial.mo6332f() : adColonyAdView.getOrientation());
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m5179p(C1454x xVar) {
        AdColonyAdView adColonyAdView = C1199a.m4880c().mo6530b().mo6458b().get(C1437s.m5613h(xVar.mo6830b(), "ad_session_id"));
        if (adColonyAdView == null) {
            return false;
        }
        adColonyAdView.setNoCloseButton(C1437s.m5608d(xVar.mo6830b(), "use_custom_close"));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo6589e(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        Context b2 = C1199a.m4878b();
        if (b2 != null && C1199a.m4882e()) {
            String h = C1437s.m5613h(b, "ad_session_id");
            C1290h c = C1199a.m4880c();
            AdColonyAdView adColonyAdView = c.mo6530b().mo6458b().get(h);
            if (adColonyAdView != null && ((adColonyAdView.getTrustedDemandSource() || adColonyAdView.getUserInteraction()) && c.mo6539e() != adColonyAdView)) {
                adColonyAdView.setExpandMessage(xVar);
                adColonyAdView.setExpandedWidth(C1437s.m5611f(b, "width"));
                adColonyAdView.setExpandedHeight(C1437s.m5611f(b, "height"));
                adColonyAdView.setOrientation(C1437s.m5578a(b, "orientation", -1));
                adColonyAdView.setNoCloseButton(C1437s.m5608d(b, "use_custom_close"));
                c.mo6521a(adColonyAdView);
                c.mo6526a(adColonyAdView.getContainer());
                Intent intent = new Intent(b2, AdColonyAdViewActivity.class);
                if (b2 instanceof Application) {
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                }
                m5172b(h);
                mo6584a(h);
                b2.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6590f(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        String h = C1437s.m5613h(b2, "ad_session_id");
        if (C1437s.m5608d(b2, "deep_link")) {
            return mo6593j(xVar);
        }
        Context b3 = C1199a.m4878b();
        if (b3 == null) {
            return false;
        }
        if (C1359k0.m5307a(b3.getPackageManager().getLaunchIntentForPackage(C1437s.m5613h(b2, "handle")))) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h);
            mo6584a(h);
            m5172b(h);
            return true;
        }
        C1359k0.m5310a("Failed to launch external application.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo6591g(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        JSONArray c = C1437s.m5604c(b2, "recipients");
        boolean d = C1437s.m5608d(b2, TJAdUnitConstants.String.HTML);
        String h = C1437s.m5613h(b2, "subject");
        String h2 = C1437s.m5613h(b2, "body");
        String h3 = C1437s.m5613h(b2, "ad_session_id");
        String[] strArr = new String[c.length()];
        for (int i = 0; i < c.length(); i++) {
            strArr[i] = C1437s.m5607d(c, i);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!d) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", h).putExtra("android.intent.extra.TEXT", h2).putExtra("android.intent.extra.EMAIL", strArr);
        if (C1359k0.m5307a(intent)) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h3);
            mo6584a(h3);
            m5172b(h3);
            return true;
        }
        C1359k0.m5310a("Failed to send email.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo6592i(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        String h = C1437s.m5613h(b2, "url");
        String h2 = C1437s.m5613h(b2, "ad_session_id");
        AdColonyAdView adColonyAdView = C1199a.m4880c().mo6530b().mo6458b().get(h2);
        if (adColonyAdView != null && !adColonyAdView.getTrustedDemandSource() && !adColonyAdView.getUserInteraction()) {
            return false;
        }
        if (h.startsWith("browser")) {
            h = h.replaceFirst("browser", "http");
        }
        if (h.startsWith("safari")) {
            h = h.replaceFirst("safari", "http");
        }
        m5175d(h);
        if (C1359k0.m5307a(new Intent("android.intent.action.VIEW", Uri.parse(h)))) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h2);
            mo6584a(h2);
            m5172b(h2);
            return true;
        }
        C1359k0.m5310a("Failed to launch browser.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo6593j(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        String h = C1437s.m5613h(b2, "product_id");
        String h2 = C1437s.m5613h(b2, "ad_session_id");
        if (h.equals("")) {
            h = C1437s.m5613h(b2, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(h));
        m5175d(h);
        if (C1359k0.m5307a(intent)) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h2);
            mo6584a(h2);
            m5172b(h2);
            return true;
        }
        C1359k0.m5310a("Unable to open.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.adcolony.sdk.C1359k0.m5310a("Error saving screenshot.", 0);
        com.adcolony.sdk.C1437s.m5603b(r4, com.facebook.GraphResponse.SUCCESS_KEY, false);
        r13.mo6829a(r4).mo6834d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00e2, code lost:
        com.adcolony.sdk.C1359k0.m5310a("Error saving screenshot.", 0);
        com.adcolony.sdk.C1437s.m5603b(r4, com.facebook.GraphResponse.SUCCESS_KEY, false);
        r13.mo6829a(r4).mo6834d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ef, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00d4 */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6594k(com.adcolony.sdk.C1454x r13) {
        /*
            r12 = this;
            java.lang.String r0 = "success"
            java.lang.String r1 = "Error saving screenshot."
            android.content.Context r2 = com.adcolony.sdk.C1199a.m4878b()
            r3 = 0
            if (r2 == 0) goto L_0x0113
            boolean r4 = r2 instanceof android.app.Activity
            if (r4 != 0) goto L_0x0011
            goto L_0x0113
        L_0x0011:
            java.lang.String r4 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r4 = androidx.core.content.C0768a.m2403a((android.content.Context) r2, (java.lang.String) r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            if (r4 != 0) goto L_0x00f0
            org.json.JSONObject r4 = r13.mo6830b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r5 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.C1437s.m5613h(r4, r5)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r12.mo6584a((java.lang.String) r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            org.json.JSONObject r4 = com.adcolony.sdk.C1437s.m5599b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.<init>()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = "/Pictures/AdColony_Screenshots/AdColony_Screenshot_"
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r6 = ".jpg"
            r5.append(r6)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.lang.String r5 = r5.toString()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r6 = r2
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.Window r6 = r6.getWindow()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.View r6 = r6.getDecorView()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.view.View r6 = r6.getRootView()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r7 = 1
            r6.setDrawingCacheEnabled(r7)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.graphics.Bitmap r8 = r6.getDrawingCache()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r6.setDrawingCacheEnabled(r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00af }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r9.<init>()     // Catch:{ Exception -> 0x00af }
            java.io.File r10 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = r10.getPath()     // Catch:{ Exception -> 0x00af }
            r9.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = "/Pictures"
            r9.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00af }
            r6.<init>(r9)     // Catch:{ Exception -> 0x00af }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x00af }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r10.<init>()     // Catch:{ Exception -> 0x00af }
            java.io.File r11 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = r11.getPath()     // Catch:{ Exception -> 0x00af }
            r10.append(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = "/Pictures/AdColony_Screenshots"
            r10.append(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00af }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00af }
            r6.mkdirs()     // Catch:{ Exception -> 0x00af }
            r9.mkdirs()     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r10 = 90
            r8.compress(r6, r10, r9)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.flush()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r9.close()     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r6[r3] = r5     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r5 = 0
            com.adcolony.sdk.i0$i r8 = new com.adcolony.sdk.i0$i     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            r8.<init>(r4, r13)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            android.media.MediaScannerConnection.scanFile(r2, r6, r5, r8)     // Catch:{ FileNotFoundException -> 0x00e2, IOException -> 0x00d4 }
            return r7
        L_0x00d4:
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r1, (int) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r4, (java.lang.String) r0, (boolean) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.x r2 = r13.mo6829a((org.json.JSONObject) r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo6834d()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x00e2:
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r1, (int) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r4, (java.lang.String) r0, (boolean) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.x r2 = r13.mo6829a((org.json.JSONObject) r4)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo6834d()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x00f0:
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r1, (int) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            org.json.JSONObject r2 = r13.mo6830b()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r2, (java.lang.String) r0, (boolean) r3)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            com.adcolony.sdk.x r2 = r13.mo6829a((org.json.JSONObject) r2)     // Catch:{ NoClassDefFoundError -> 0x0102 }
            r2.mo6834d()     // Catch:{ NoClassDefFoundError -> 0x0102 }
            return r3
        L_0x0102:
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r1, (int) r3)
            org.json.JSONObject r1 = r13.mo6830b()
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r1, (java.lang.String) r0, (boolean) r3)
            com.adcolony.sdk.x r13 = r13.mo6829a((org.json.JSONObject) r1)
            r13.mo6834d()
        L_0x0113:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1316i0.mo6594k(com.adcolony.sdk.x):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo6595m(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        JSONObject b2 = C1437s.m5599b();
        String h = C1437s.m5613h(b, "ad_session_id");
        JSONArray c = C1437s.m5604c(b, "recipients");
        String str = "";
        for (int i = 0; i < c.length(); i++) {
            if (i != 0) {
                str = str + ";";
            }
            str = str + C1437s.m5607d(c, i);
        }
        if (C1359k0.m5307a(new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + str)).putExtra("sms_body", C1437s.m5613h(b, "body")))) {
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b2).mo6834d();
            mo6587c(h);
            mo6584a(h);
            m5172b(h);
            return true;
        }
        C1359k0.m5310a("Failed to create sms.", 0);
        C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b2).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo6596n(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        Intent putExtra = type.putExtra("android.intent.extra.TEXT", C1437s.m5613h(b2, ViewHierarchyConstants.TEXT_KEY) + " " + C1437s.m5613h(b2, "url"));
        String h = C1437s.m5613h(b2, "ad_session_id");
        if (C1359k0.m5308a(putExtra, true)) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h);
            mo6584a(h);
            m5172b(h);
            return true;
        }
        C1359k0.m5310a("Unable to create social post.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo6597o(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        JSONObject b2 = xVar.mo6830b();
        Intent intent = new Intent("android.intent.action.DIAL");
        Intent data = intent.setData(Uri.parse("tel:" + C1437s.m5613h(b2, "phone_number")));
        String h = C1437s.m5613h(b2, "ad_session_id");
        if (C1359k0.m5307a(data)) {
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
            mo6587c(h);
            mo6584a(h);
            m5172b(h);
            return true;
        }
        C1359k0.m5310a("Failed to dial number.", 0);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b).mo6834d();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo6598q(C1454x xVar) {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        int a = C1437s.m5578a(xVar.mo6830b(), "length_ms", 500);
        JSONObject b2 = C1437s.m5599b();
        JSONArray d = C1359k0.m5325d(b);
        boolean z = false;
        for (int i = 0; i < d.length(); i++) {
            if (C1437s.m5607d(d, i).equals("android.permission.VIBRATE")) {
                z = true;
            }
        }
        if (!z) {
            new C1439u.C1440a().mo6801a("No vibrate permission detected.").mo6803a(C1439u.f4514g);
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
            xVar.mo6829a(b2).mo6834d();
            return false;
        }
        try {
            Vibrator vibrator = (Vibrator) b.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate((long) a);
                C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
                xVar.mo6829a(b2).mo6834d();
                return true;
            }
        } catch (Exception unused) {
            new C1439u.C1440a().mo6801a("Vibrate command failed.").mo6803a(C1439u.f4514g);
        }
        C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, false);
        xVar.mo6829a(b2).mo6834d();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m5174c(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "ad_session_id");
        Activity activity = C1199a.m4878b() instanceof Activity ? (Activity) C1199a.m4878b() : null;
        boolean z = activity instanceof AdColonyAdViewActivity;
        if (!(activity instanceof C1202b)) {
            return false;
        }
        if (z) {
            ((AdColonyAdViewActivity) activity).mo6251b();
            return true;
        }
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", h);
        new C1454x("AdSession.on_request_close", ((C1202b) activity).f3346d, b).mo6834d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6583a() {
        C1199a.m4876a("System.open_store", (C1458z) new C1327k());
        C1199a.m4876a("System.save_screenshot", (C1458z) new C1328l());
        C1199a.m4876a("System.telephone", (C1458z) new C1329m());
        C1199a.m4876a("System.sms", (C1458z) new C1330n());
        C1199a.m4876a("System.vibrate", (C1458z) new C1331o());
        C1199a.m4876a("System.open_browser", (C1458z) new C1332p());
        C1199a.m4876a("System.mail", (C1458z) new C1333q());
        C1199a.m4876a("System.launch_app", (C1458z) new C1334r());
        C1199a.m4876a("System.create_calendar_event", (C1458z) new C1335s());
        C1199a.m4876a("System.check_app_presence", (C1458z) new C1317a());
        C1199a.m4876a("System.check_social_presence", (C1458z) new C1318b());
        C1199a.m4876a("System.social_post", (C1458z) new C1319c());
        C1199a.m4876a("System.make_in_app_purchase", (C1458z) new C1320d());
        C1199a.m4876a("System.close", (C1458z) new C1321e());
        C1199a.m4876a("System.expand", (C1458z) new C1322f());
        C1199a.m4876a("System.use_custom_close", (C1458z) new C1323g());
        C1199a.m4876a("System.set_orientation_properties", (C1458z) new C1324h());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6586b(C1454x xVar) {
        return mo6585a(xVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ed  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6588d(com.adcolony.sdk.C1454x r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            org.json.JSONObject r2 = com.adcolony.sdk.C1437s.m5599b()
            org.json.JSONObject r3 = r25.mo6830b()
            java.lang.String r4 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.C1437s.m5613h(r3, r4)
            java.lang.String r5 = "params"
            org.json.JSONObject r3 = com.adcolony.sdk.C1437s.m5612g(r3, r5)
            java.lang.String r5 = "recurrence"
            org.json.JSONObject r5 = com.adcolony.sdk.C1437s.m5612g(r3, r5)
            org.json.JSONArray r6 = com.adcolony.sdk.C1437s.m5579a()
            org.json.JSONArray r7 = com.adcolony.sdk.C1437s.m5579a()
            org.json.JSONArray r8 = com.adcolony.sdk.C1437s.m5579a()
            java.lang.String r9 = "description"
            java.lang.String r10 = com.adcolony.sdk.C1437s.m5613h(r3, r9)
            java.lang.String r11 = "location"
            com.adcolony.sdk.C1437s.m5613h(r3, r11)
            java.lang.String r11 = "start"
            java.lang.String r11 = com.adcolony.sdk.C1437s.m5613h(r3, r11)
            java.lang.String r12 = "end"
            java.lang.String r12 = com.adcolony.sdk.C1437s.m5613h(r3, r12)
            java.lang.String r13 = "summary"
            java.lang.String r3 = com.adcolony.sdk.C1437s.m5613h(r3, r13)
            java.lang.String r13 = ""
            if (r5 == 0) goto L_0x0078
            int r14 = r5.length()
            if (r14 <= 0) goto L_0x0078
            java.lang.String r6 = "expires"
            java.lang.String r6 = com.adcolony.sdk.C1437s.m5613h(r5, r6)
            java.lang.String r7 = "frequency"
            java.lang.String r7 = com.adcolony.sdk.C1437s.m5613h(r5, r7)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.toUpperCase(r8)
            java.lang.String r8 = "daysInWeek"
            org.json.JSONArray r8 = com.adcolony.sdk.C1437s.m5604c((org.json.JSONObject) r5, (java.lang.String) r8)
            java.lang.String r14 = "daysInMonth"
            org.json.JSONArray r14 = com.adcolony.sdk.C1437s.m5604c((org.json.JSONObject) r5, (java.lang.String) r14)
            java.lang.String r15 = "daysInYear"
            org.json.JSONArray r15 = com.adcolony.sdk.C1437s.m5604c((org.json.JSONObject) r5, (java.lang.String) r15)
            goto L_0x007d
        L_0x0078:
            r14 = r7
            r15 = r8
            r7 = r13
            r8 = r6
            r6 = r7
        L_0x007d:
            boolean r13 = r3.equals(r13)
            if (r13 == 0) goto L_0x0084
            r3 = r10
        L_0x0084:
            java.util.Date r11 = com.adcolony.sdk.C1359k0.m5336i(r11)
            java.util.Date r12 = com.adcolony.sdk.C1359k0.m5336i(r12)
            java.util.Date r6 = com.adcolony.sdk.C1359k0.m5336i(r6)
            java.lang.String r13 = "success"
            if (r11 == 0) goto L_0x0206
            if (r12 != 0) goto L_0x0098
            goto L_0x0206
        L_0x0098:
            long r0 = r11.getTime()
            r16 = r13
            long r12 = r12.getTime()
            r17 = 0
            if (r6 == 0) goto L_0x00b5
            long r19 = r6.getTime()
            long r21 = r11.getTime()
            long r19 = r19 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 / r21
            goto L_0x00b7
        L_0x00b5:
            r19 = r17
        L_0x00b7:
            java.lang.String r6 = "DAILY"
            boolean r6 = r7.equals(r6)
            r21 = 1
            if (r6 == 0) goto L_0x00cd
            r17 = 86400(0x15180, double:4.26873E-319)
            long r19 = r19 / r17
        L_0x00c6:
            long r17 = r19 + r21
        L_0x00c8:
            r19 = r12
            r11 = r17
            goto L_0x00f7
        L_0x00cd:
            java.lang.String r6 = "WEEKLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00db
            r17 = 604800(0x93a80, double:2.98811E-318)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00db:
            java.lang.String r6 = "MONTHLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00e9
            r17 = 2629800(0x2820a8, double:1.299294E-317)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00e9:
            java.lang.String r6 = "YEARLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00c8
            r17 = 31557600(0x1e187e0, double:1.5591526E-316)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00f7:
            java.lang.String r6 = "endTime"
            java.lang.String r13 = "beginTime"
            r17 = r4
            java.lang.String r4 = "title"
            r18 = r2
            java.lang.String r2 = "vnd.android.cursor.item/event"
            r21 = r6
            java.lang.String r6 = "android.intent.action.EDIT"
            if (r5 == 0) goto L_0x01aa
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x01aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r22 = r0
            java.lang.String r0 = "FREQ="
            r5.append(r0)
            r5.append(r7)
            java.lang.String r0 = ";COUNT="
            r5.append(r0)
            r5.append(r11)
            java.lang.String r0 = r5.toString()
            int r1 = r8.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = com.adcolony.sdk.C1359k0.m5303a((org.json.JSONArray) r8)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0148:
            int r1 = r14.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = com.adcolony.sdk.C1359k0.m5319b((org.json.JSONArray) r14)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYMONTHDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0166:
            int r1 = r15.length()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0184
            java.lang.String r1 = com.adcolony.sdk.C1359k0.m5319b((org.json.JSONArray) r15)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYYEARDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0184:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6)
            android.content.Intent r1 = r1.setType(r2)
            android.content.Intent r1 = r1.putExtra(r4, r3)
            android.content.Intent r1 = r1.putExtra(r9, r10)
            r7 = r22
            android.content.Intent r1 = r1.putExtra(r13, r7)
            r11 = r19
            r5 = r21
            android.content.Intent r1 = r1.putExtra(r5, r11)
            java.lang.String r2 = "rrule"
            android.content.Intent r0 = r1.putExtra(r2, r0)
            goto L_0x01c8
        L_0x01aa:
            r7 = r0
            r11 = r19
            r5 = r21
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            android.content.Intent r0 = r0.setType(r2)
            android.content.Intent r0 = r0.putExtra(r4, r3)
            android.content.Intent r0 = r0.putExtra(r9, r10)
            android.content.Intent r0 = r0.putExtra(r13, r7)
            android.content.Intent r0 = r0.putExtra(r5, r11)
        L_0x01c8:
            boolean r0 = com.adcolony.sdk.C1359k0.m5307a((android.content.Intent) r0)
            if (r0 == 0) goto L_0x01ed
            r0 = 1
            r2 = r16
            r1 = r18
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r0)
            r3 = r25
            com.adcolony.sdk.x r1 = r3.mo6829a((org.json.JSONObject) r1)
            r1.mo6834d()
            r4 = r24
            r1 = r17
            r4.mo6587c((java.lang.String) r1)
            r4.mo6584a((java.lang.String) r1)
            r4.m5172b((java.lang.String) r1)
            return r0
        L_0x01ed:
            r0 = 0
            r4 = r24
            r3 = r25
            r2 = r16
            r1 = r18
            java.lang.String r5 = "Unable to create Calendar Event."
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r5, (int) r0)
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r0)
            com.adcolony.sdk.x r1 = r3.mo6829a((org.json.JSONObject) r1)
            r1.mo6834d()
            return r0
        L_0x0206:
            r0 = 0
            r4 = r24
            r3 = r1
            r1 = r2
            r2 = r13
            java.lang.String r5 = "Unable to create Calendar Event"
            com.adcolony.sdk.C1359k0.m5310a((java.lang.String) r5, (int) r0)
            com.adcolony.sdk.C1437s.m5603b((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r0)
            com.adcolony.sdk.x r1 = r3.mo6829a((org.json.JSONObject) r1)
            r1.mo6834d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1316i0.mo6588d(com.adcolony.sdk.x):boolean");
    }

    /* renamed from: b */
    private boolean m5172b(String str) {
        if (C1199a.m4880c().mo6530b().mo6458b().get(str) == null) {
            return false;
        }
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "ad_session_id", str);
        new C1454x("MRAID.on_event", 1, b).mo6834d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6587c(String str) {
        C1222d b = C1199a.m4880c().mo6530b();
        AdColonyInterstitial adColonyInterstitial = b.mo6453a().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = b.mo6458b().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null) {
                listener.onLeftApplication(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onLeftApplication(adColonyInterstitial);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6585a(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        String h = C1437s.m5613h(xVar.mo6830b(), "name");
        boolean e = C1359k0.m5329e(h);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
        C1437s.m5603b(b, "result", e);
        C1437s.m5592a(b, "name", h);
        C1437s.m5592a(b, "service", h);
        xVar.mo6829a(b).mo6834d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6584a(String str) {
        C1222d b = C1199a.m4880c().mo6530b();
        AdColonyInterstitial adColonyInterstitial = b.mo6453a().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = b.mo6458b().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null) {
                listener.onClicked(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onClicked(adColonyInterstitial);
    }

    /* renamed from: d */
    private void m5175d(String str) {
        C1359k0.f4258b.execute(new C1326j(str));
    }
}
