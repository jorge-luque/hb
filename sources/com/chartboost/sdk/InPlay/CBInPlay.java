package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.os.Handler;
import com.chartboost.sdk.C2101c;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2086a;
import com.chartboost.sdk.Model.C2087b;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2128c1;
import com.chartboost.sdk.impl.C2143g;
import com.chartboost.sdk.impl.C2157i;
import com.chartboost.sdk.impl.C2218v0;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2225x0;
import com.chartboost.sdk.impl.C2238z1;
import com.facebook.places.model.PlaceFields;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.io.File;
import java.util.concurrent.Executor;

public final class CBInPlay {

    /* renamed from: a */
    private final C2143g f6842a;
    public final String appName;

    /* renamed from: b */
    private final C2218v0 f6843b;

    /* renamed from: c */
    private final C2092g f6844c;

    /* renamed from: d */
    private final C2098a f6845d;

    /* renamed from: e */
    private final C2225x0 f6846e;

    /* renamed from: f */
    private final C2086a f6847f;

    /* renamed from: g */
    private Bitmap f6848g;
    public final File largeAppIconFile;
    public final String largeAppIconUrl;
    public final String location;

    private CBInPlay(C2143g gVar, C2218v0 v0Var, C2092g gVar2, C2098a aVar, C2225x0 x0Var, C2086a aVar2, String str, File file, String str2) {
        this.f6842a = gVar;
        this.f6843b = v0Var;
        this.f6844c = gVar2;
        this.f6845d = aVar;
        this.f6846e = x0Var;
        this.f6847f = aVar2;
        this.appName = aVar2.f6911q;
        this.largeAppIconUrl = str;
        this.largeAppIconFile = file;
        this.location = str2;
    }

    public static void cacheInPlay(String str) {
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("CBInPlay", "cacheInPlay location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7582p;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return;
            }
            C2093h hVar = n.f7589w.get();
            if ((!hVar.f7023w || !hVar.f7024x) && (!hVar.f7005e || !hVar.f7006f)) {
                Handler handler2 = n.f7591y;
                C2117a aVar2 = n.f7582p;
                aVar2.getClass();
                handler2.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (C2070b) null));
                return;
            }
            C2143g gVar = n.f7581o;
            gVar.getClass();
            n.f7579m.execute(new C2143g.C2145b(3, str, (C2151h) null, (CBError.CBImpressionError) null));
        }
    }

    public static CBInPlay getInPlay(String str) {
        C2239j n = C2239j.m8897n();
        CBInPlay cBInPlay = null;
        if (n != null && C2101c.m8331c()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("CBInPlay", "Inplay location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7582p;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return null;
            }
            C2093h hVar = n.f7589w.get();
            CBError.CBImpressionError cBImpressionError = CBError.CBImpressionError.NO_AD_FOUND;
            if ((hVar.f7023w && hVar.f7024x) || (hVar.f7005e && hVar.f7006f)) {
                C2086a d = n.f7581o.mo9342d(str);
                if (d != null) {
                    C2087b bVar = d.f6897c.get("lg");
                    if (bVar != null) {
                        File a = bVar.mo9117a(n.f7581o.f7170c.mo9089a().f6867a);
                        if (!a.exists()) {
                            cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
                        } else {
                            cBInPlay = new CBInPlay(n.f7581o, n.f7585s, n.f7586t, n.f7590x, n.f7566A, d, bVar.f6916c, a, str);
                        }
                    }
                    Executor executor = n.f7579m;
                    C2143g gVar = n.f7581o;
                    gVar.getClass();
                    executor.execute(new C2143g.C2145b(8, str, (C2151h) null, (CBError.CBImpressionError) null));
                }
                if (cBInPlay == null) {
                    Executor executor2 = n.f7579m;
                    C2143g gVar2 = n.f7581o;
                    gVar2.getClass();
                    executor2.execute(new C2143g.C2145b(3, str, (C2151h) null, (CBError.CBImpressionError) null));
                }
            }
            CBError.CBImpressionError cBImpressionError2 = cBImpressionError;
            if (cBInPlay == null) {
                Handler handler2 = n.f7591y;
                C2117a aVar2 = n.f7582p;
                aVar2.getClass();
                handler2.post(new C2117a.C2118a(4, str, cBImpressionError2, (C2070b) null));
            }
        }
        return cBInPlay;
    }

    public static boolean hasInPlay(String str) {
        C2239j n = C2239j.m8897n();
        if (n == null || !C2101c.m8331c()) {
            return false;
        }
        if (C2224x.m8805e().mo9549a((CharSequence) str)) {
            CBLogging.m8154b("CBInPlay", "hasInPlay location cannot be empty");
            Handler handler = n.f7591y;
            C2117a aVar = n.f7582p;
            aVar.getClass();
            handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
            return false;
        } else if (n.f7581o.mo9342d(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void click() {
        C2086a aVar = this.f6847f;
        String str = aVar.f6904j;
        String str2 = aVar.f6903i;
        String str3 = (str2.isEmpty() || !this.f6846e.mo9555a(str2)) ? str : str2;
        C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/api/click", this.f6844c, this.f6845d, 2, (C2128c1.C2129a) null);
        c1Var.mo9294a(PlaceFields.LOCATION, (Object) this.location);
        c1Var.mo9294a("to", (Object) this.f6847f.f6907m);
        c1Var.mo9294a("cgn", (Object) this.f6847f.f6901g);
        c1Var.mo9294a(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, (Object) this.f6847f.f6902h);
        c1Var.mo9294a("ad_id", (Object) this.f6847f.f6900f);
        c1Var.mo9294a("type", (Object) "native");
        if (str3 == null || str3.isEmpty()) {
            this.f6846e.mo9554a((C2088c) null, false, str3, CBError.CBClickError.URI_INVALID, c1Var);
        } else {
            this.f6846e.mo9553a((C2088c) null, str3, c1Var);
        }
    }

    public Bitmap getAppIcon() throws Exception {
        if (this.f6848g == null) {
            try {
                byte[] b = C2238z1.m8891b(this.largeAppIconFile);
                if (b != null) {
                    this.f6848g = C2224x.m8805e().mo9545a(b);
                }
                if (this.f6848g == null) {
                    CBLogging.m8154b("CBInPlay", "Error decoding inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                    if (!this.largeAppIconFile.delete()) {
                        CBLogging.m8154b("CBInPlay", "Unable to delete corrupt inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                    }
                    throw new Exception("decodeByteArrayToBitmap returned null");
                }
            } catch (OutOfMemoryError e) {
                CBLogging.m8154b("CBInPlay", "Out of memory decoding inplay bitmap " + this.largeAppIconFile.getAbsolutePath());
                throw new Exception(e);
            }
        }
        return this.f6848g;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getLocation() {
        return this.location;
    }

    public void show() {
        C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/inplay/show", this.f6844c, this.f6845d, 2, new C2157i(this.f6842a, this.location));
        c1Var.f7440i = 1;
        c1Var.mo9294a("inplay-dictionary", (Object) this.f6847f.f6895a);
        c1Var.mo9294a(PlaceFields.LOCATION, (Object) this.location);
        this.f6843b.mo9524a(c1Var);
    }
}
