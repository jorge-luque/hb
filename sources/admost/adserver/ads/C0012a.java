package admost.adserver.ads;

import admost.adserver.core.AdMostInterstitialAdActivity;
import admost.adserver.core.C0049a;
import admost.adserver.core.C0050b;
import admost.adserver.core.C0051c;
import admost.adserver.core.C0055e;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.drive.DriveFile;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;
import p030c.p031a.p032a.C1179b;
import p030c.p031a.p032a.C1180c;

/* renamed from: admost.adserver.ads.a */
/* compiled from: AdMostFullScreenAd */
public class C0012a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f24a;

    /* renamed from: b */
    private Hashtable<String, Object> f25b;

    /* renamed from: c */
    private boolean f26c;

    /* renamed from: d */
    private boolean f27d;

    /* renamed from: e */
    private String f28e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1179b f29f;

    /* renamed from: g */
    private Object f30g;

    /* renamed from: h */
    private Context f31h;

    /* renamed from: admost.adserver.ads.a$a */
    /* compiled from: AdMostFullScreenAd */
    class C0013a implements Observer {
        C0013a() {
        }

        public void update(Observable observable, Object obj) {
            Object[] objArr = (Object[]) obj;
            int intValue = ((Integer) objArr[0]).intValue();
            String str = (String) objArr[2];
            if (!((String) objArr[1]).equals(C0012a.this.f24a)) {
                return;
            }
            if (intValue == 2) {
                C0012a.this.f29f.onClicked(str);
            } else if (intValue == 3) {
                C0012a.this.f29f.onComplete();
            } else if (intValue == 5) {
                C0012a.this.f29f.onFail(102);
            } else if (intValue == 6) {
                C0012a.this.f29f.onShown();
            } else if (intValue == 4) {
                C0012a.this.f29f.onDismiss();
                C0050b.m130a().deleteObserver(this);
            }
        }
    }

    /* renamed from: admost.adserver.ads.a$b */
    /* compiled from: AdMostFullScreenAd */
    class C0014b implements C1180c<JSONObject> {
        C0014b() {
        }

        /* renamed from: a */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null) {
                C0012a.this.f29f.onFail(100);
                return;
            }
            try {
                if (jSONObject.optInt("Type", 0) != 1) {
                    C0012a.this.f29f.onFail(100);
                } else {
                    C0012a.this.m22a((Object) jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
                C0012a.this.f29f.onFail(101);
            }
        }

        public void onError(String str, Exception exc) {
            exc.printStackTrace();
            C0012a.this.f29f.onFail(101);
        }
    }

    /* renamed from: admost.adserver.ads.a$c */
    /* compiled from: AdMostFullScreenAd */
    class C0015c implements C1180c<String> {
        C0015c() {
        }

        /* renamed from: a */
        public void onResponse(String str) {
            if (str == null || str.startsWith("//NO_BANNER_FOUND")) {
                C0012a.this.f29f.onFail(100);
                return;
            }
            try {
                C0012a.this.m22a((Object) str);
            } catch (Exception e) {
                e.printStackTrace();
                C0012a.this.f29f.onFail(101);
            }
        }

        public void onError(String str, Exception exc) {
            C0012a.this.f29f.onFail(101);
        }
    }

    public C0012a(Context context, String str, boolean z, C1179b bVar, Hashtable<String, Object> hashtable) {
        this.f24a = str;
        this.f25b = hashtable;
        this.f29f = bVar;
        this.f27d = z;
        this.f31h = context;
    }

    /* renamed from: d */
    private void m25d(String str) {
        new C0051c(C0051c.C0053b.CP_RESPONSE, "", new C0015c()).mo91a(this.f31h, str + "&nojs=1&ei=" + C0055e.m151a(this.f28e, "admostcrosspromo", C0055e.m154b()));
    }

    /* renamed from: c */
    public void mo27c() {
        C0050b.m130a().addObserver(new C0013a());
        if (this.f27d) {
            m20a(4, ((JSONObject) this.f30g).toString());
        } else if (!this.f26c) {
            JSONObject jSONObject = (JSONObject) this.f30g;
            m20a(jSONObject.has("Script") ^ true ? 1 : 0, jSONObject.toString());
        } else {
            m20a(3, (String) this.f30g);
        }
    }

    /* renamed from: b */
    public void mo26b(String str) {
        this.f26c = true;
        this.f28e = str;
    }

    /* renamed from: a */
    public void mo24a(String str) {
        this.f28e = str;
    }

    /* renamed from: a */
    private void m20a(int i, String str) {
        Intent intent = new Intent(this.f31h, AdMostInterstitialAdActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra("MODE", i);
        intent.putExtra("AD_PLACE_ID", this.f24a);
        intent.putExtra("DATA", str);
        this.f31h.startActivity(intent);
    }

    /* renamed from: b */
    public void mo25b() {
        String str;
        StringBuilder sb = new StringBuilder("?k=" + this.f24a);
        sb.append("&uId=");
        sb.append(C0049a.m124a(this.f31h).mo88b());
        sb.append("&w=1");
        sb.append("&channel=3");
        sb.append("&device_model=");
        sb.append(C0055e.m148a());
        sb.append("&os_version=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&gsm_op=");
        sb.append(C0055e.m157d(this.f31h));
        sb.append("&version=");
        sb.append(C0055e.m149a(this.f31h));
        Hashtable<String, Object> hashtable = this.f25b;
        if (hashtable != null && hashtable.size() > 0) {
            try {
                for (Map.Entry next : this.f25b.entrySet()) {
                    Object value = next.getValue();
                    String str2 = "";
                    if (value != null) {
                        if (value instanceof String) {
                            str = URLEncoder.encode((String) value, "UTF8");
                        } else if (value instanceof Integer) {
                            str = value + str2;
                        }
                        str2 = str;
                    }
                    sb.append("&");
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.f26c) {
            m24c(sb.toString());
        } else {
            m25d(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo23a() {
        this.f24a = null;
        this.f25b = null;
        this.f29f = null;
        this.f30g = null;
        this.f31h = null;
    }

    /* renamed from: c */
    private void m24c(String str) {
        new C0051c(C0051c.C0053b.ADMOST_ADSERVER_RESPONSE, "", new C0014b()).mo91a(this.f31h, str + "&ei=" + C0055e.m151a(this.f28e, "admostcrosspromo", C0055e.m154b()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m22a(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r5.f27d
            if (r0 == 0) goto L_0x0096
            r0 = 0
            boolean r1 = r6 instanceof org.json.JSONObject
            java.lang.String r2 = "Url"
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x001a
            r0 = r6
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r3 = r0.optString(r2, r3)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0032
        L_0x0015:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0032
        L_0x001a:
            boolean r1 = r6 instanceof java.lang.String
            if (r1 == 0) goto L_0x0032
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x002e }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x002e }
            r1.<init>(r6)     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = r1.optString(r2, r3)     // Catch:{ Exception -> 0x002b }
            r0 = r1
            goto L_0x0032
        L_0x002b:
            r6 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r6 = move-exception
        L_0x002f:
            r6.printStackTrace()
        L_0x0032:
            r6 = 103(0x67, float:1.44E-43)
            if (r3 == 0) goto L_0x0090
            int r1 = r3.length()
            if (r1 <= 0) goto L_0x0090
            java.lang.String r1 = "/"
            boolean r2 = r3.contains(r1)
            if (r2 == 0) goto L_0x0090
            java.lang.String r2 = "\\/"
            java.lang.String[] r2 = r3.split(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r5.f31h
            java.io.File r4 = r4.getCacheDir()
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = "AdMost"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r5.f24a
            r3.append(r1)
            java.lang.String r1 = "_"
            r3.append(r1)
            int r1 = r2.length
            int r1 = r1 + -1
            r1 = r2[r1]
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "FileName"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0086 }
            r5.f30g = r0     // Catch:{ Exception -> 0x0086 }
            c.a.a.b r6 = r5.f29f
            r6.onReady()
            goto L_0x009d
        L_0x0086:
            r0 = move-exception
            r0.printStackTrace()
            c.a.a.b r0 = r5.f29f
            r0.onFail(r6)
            return
        L_0x0090:
            c.a.a.b r0 = r5.f29f
            r0.onFail(r6)
            return
        L_0x0096:
            r5.f30g = r6
            c.a.a.b r6 = r5.f29f
            r6.onReady()
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.ads.C0012a.m22a(java.lang.Object):void");
    }
}
