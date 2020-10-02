package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.applovin.sdk.AppLovinEventParameters;
import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.p2 */
/* compiled from: TrackGooglePurchase */
class C4615p2 {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f12591i = -99;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static Class<?> f12592j;

    /* renamed from: a */
    private ServiceConnection f12593a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object f12594b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Method f12595c;

    /* renamed from: d */
    private Method f12596d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f12597e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<String> f12598f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f12599g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12600h;

    /* renamed from: com.onesignal.p2$a */
    /* compiled from: TrackGooglePurchase */
    class C4616a implements ServiceConnection {
        C4616a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Method a = C4615p2.m15971c((Class) Class.forName("com.android.vending.billing.IInAppBillingService$Stub"));
                a.setAccessible(true);
                Object unused = C4615p2.this.f12594b = a.invoke((Object) null, new Object[]{iBinder});
                C4615p2.this.m15966b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            int unused = C4615p2.f12591i = -99;
            Object unused2 = C4615p2.this.f12594b = null;
        }
    }

    /* renamed from: com.onesignal.p2$b */
    /* compiled from: TrackGooglePurchase */
    class C4617b implements Runnable {
        C4617b() {
        }

        public void run() {
            boolean unused = C4615p2.this.f12600h = true;
            try {
                if (C4615p2.this.f12595c == null) {
                    Method unused2 = C4615p2.this.f12595c = C4615p2.m15973d(C4615p2.f12592j);
                    C4615p2.this.f12595c.setAccessible(true);
                }
                Bundle bundle = (Bundle) C4615p2.this.f12595c.invoke(C4615p2.this.f12594b, new Object[]{3, C4615p2.this.f12597e.getPackageName(), "inapp", null});
                if (bundle.getInt("RESPONSE_CODE") == 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str = stringArrayList.get(i);
                        String string = new JSONObject(stringArrayList2.get(i)).getString("purchaseToken");
                        if (!C4615p2.this.f12598f.contains(string) && !arrayList2.contains(string)) {
                            arrayList2.add(string);
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() > 0) {
                        C4615p2.this.m15962a((ArrayList<String>) arrayList, (ArrayList<String>) arrayList2);
                    } else if (stringArrayList2.size() == 0) {
                        boolean unused3 = C4615p2.this.f12599g = false;
                        C4698w1.m16355b("GTPlayerPurchases", "ExistingPurchases", false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean unused4 = C4615p2.this.f12600h = false;
        }
    }

    /* renamed from: com.onesignal.p2$c */
    /* compiled from: TrackGooglePurchase */
    class C4618c extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ ArrayList f12603a;

        C4618c(ArrayList arrayList) {
            this.f12603a = arrayList;
        }

        /* renamed from: a */
        public void mo29737a(String str) {
            C4615p2.this.f12598f.addAll(this.f12603a);
            C4698w1.m16353b("GTPlayerPurchases", "purchaseTokens", C4615p2.this.f12598f.toString());
            C4698w1.m16355b("GTPlayerPurchases", "ExistingPurchases", true);
            boolean unused = C4615p2.this.f12599g = false;
            boolean unused2 = C4615p2.this.f12600h = false;
        }
    }

    C4615p2(Context context) {
        boolean z = false;
        this.f12600h = false;
        this.f12597e = context;
        this.f12598f = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(C4698w1.m16344a("GTPlayerPurchases", "purchaseTokens", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f12598f.add(jSONArray.get(i).toString());
            }
            z = jSONArray.length() == 0 ? true : z;
            this.f12599g = z;
            if (z) {
                this.f12599g = C4698w1.m16348a("GTPlayerPurchases", "ExistingPurchases", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mo29906a();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Method m15973d(Class cls) {
        Class<String> cls2 = String.class;
        for (Method method : cls.getMethods()) {
            Class<String>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == cls2 && parameterTypes[2] == cls2 && parameterTypes[3] == cls2) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: e */
    private static Method m15974e(Class cls) {
        Class<String> cls2 = String.class;
        for (Method method : cls.getMethods()) {
            Class<Bundle>[] parameterTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == cls2 && parameterTypes[2] == cls2 && parameterTypes[3] == Bundle.class && returnType == Bundle.class) {
                return method;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Method m15971c(Class cls) {
        for (Method method : cls.getMethods()) {
            Class<IBinder>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15966b() {
        if (!this.f12600h) {
            new Thread(new C4617b()).start();
        }
    }

    /* renamed from: a */
    static boolean m15963a(Context context) {
        if (f12591i == -99) {
            f12591i = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
        }
        try {
            if (f12591i == 0) {
                f12592j = Class.forName("com.android.vending.billing.IInAppBillingService");
            }
            if (f12591i == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            f12591i = 0;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29906a() {
        if (this.f12593a == null) {
            this.f12593a = new C4616a();
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f12597e.bindService(intent, this.f12593a, 1);
        } else if (this.f12594b != null) {
            m15966b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15962a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            if (this.f12596d == null) {
                Method e = m15974e((Class) f12592j);
                this.f12596d = e;
                e.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle2 = (Bundle) this.f12596d.invoke(this.f12594b, new Object[]{3, this.f12597e.getPackageName(), "inapp", bundle});
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                HashMap hashMap = new HashMap();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject(it.next());
                    String string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (hashMap.containsKey(next)) {
                        jSONArray.put(hashMap.get(next));
                    }
                }
                if (jSONArray.length() > 0) {
                    C4564n1.m15799a(jSONArray, this.f12599g, (C4731y1.C4738g) new C4618c(arrayList2));
                }
            }
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.WARN, "Failed to track IAP purchases", th);
        }
    }
}
