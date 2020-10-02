package admost.adserver.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.Display;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.facebook.places.model.PlaceFields;
import com.loopj.android.http.C4250c;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p030c.p031a.p032a.C1180c;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: admost.adserver.core.e */
/* compiled from: AdMostUtil */
public class C0055e {

    /* renamed from: a */
    private static String f157a;

    /* renamed from: b */
    private static long f158b;

    /* renamed from: c */
    private static Point f159c;

    /* renamed from: admost.adserver.core.e$a */
    /* compiled from: AdMostUtil */
    class C0056a implements Response.Listener<byte[]> {

        /* renamed from: a */
        final /* synthetic */ String f160a;

        /* renamed from: b */
        final /* synthetic */ Context f161b;

        /* renamed from: c */
        final /* synthetic */ C1180c f162c;

        C0056a(String str, Context context, C1180c cVar) {
            this.f160a = str;
            this.f161b = context;
            this.f162c = cVar;
        }

        /* renamed from: a */
        public void onResponse(byte[] bArr) {
            if (bArr != null) {
                try {
                    "downloadFile onResponse: url " + this.f160a;
                    FileOutputStream fileOutputStream = new FileOutputStream(C0055e.m147a(this.f161b, this.f160a));
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    if (this.f162c != null) {
                        this.f162c.onResponse(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    C1180c cVar = this.f162c;
                    if (cVar != null) {
                        cVar.onError("Response data exception", e);
                    }
                }
            } else if (this.f162c != null) {
                this.f162c.onError("Response has no data", (Exception) null);
            }
        }
    }

    /* renamed from: admost.adserver.core.e$b */
    /* compiled from: AdMostUtil */
    class C0057b implements Response.ErrorListener {

        /* renamed from: a */
        final /* synthetic */ C1180c f163a;

        C0057b(C1180c cVar) {
            this.f163a = cVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            volleyError.printStackTrace();
            C1180c cVar = this.f163a;
            if (cVar != null) {
                cVar.onError("Request exception", (Exception) null);
            }
        }
    }

    /* renamed from: a */
    public static int m144a(int i) {
        return Math.round(((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    /* renamed from: b */
    public static String m154b() {
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            double d = (double) 61;
            double random = Math.random();
            Double.isNaN(d);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".charAt((int) (d * random)));
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m155c() {
        return "0.1.2";
    }

    /* renamed from: c */
    public static String m156c(Context context) {
        String str = f157a;
        if (str != null && str.length() > 0 && f158b > System.currentTimeMillis() - 60000) {
            return f157a;
        }
        f157a = "";
        f158b = System.currentTimeMillis();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1) {
                f157a = "&connected=wifi";
            } else {
                f157a = "&connected=gsm";
            }
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    f157a += "&network=2G";
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    f157a += "&network=3G";
                    break;
                case 13:
                    f157a += "&network=4G";
                    break;
                default:
                    f157a += "&network=unknown";
                    break;
            }
        } catch (Exception unused) {
            f157a = "&connected=problem";
        }
        return f157a;
    }

    /* renamed from: d */
    public static String m157d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager.getPhoneType() == 1) {
                return URLEncoder.encode(telephonyManager.getNetworkOperatorName(), C4250c.DEFAULT_CHARSET);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m149a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static File m153b(Context context) {
        File file = new File(context.getCacheDir(), "admostcache");
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /* renamed from: a */
    public static String m148a() {
        try {
            return URLEncoder.encode(Build.BRAND + " " + Build.MODEL, C4250c.DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @TargetApi(13)
    /* renamed from: a */
    public static Point m146a(Activity activity) {
        try {
            if (f159c != null && f159c.x > 0) {
                return f159c;
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            f159c = point;
            defaultDisplay.getSize(point);
            return f159c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m151a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.equals("") && str2 != null && !str2.equals("") && str3 != null) {
                    if (!str3.equals("")) {
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes(C4250c.DEFAULT_CHARSET));
                        SecretKeySpec secretKeySpec = new SecretKeySpec((str2.substring(0, 8) + str3.substring(0, 8)).getBytes(C4250c.DEFAULT_CHARSET), "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                        instance.init(1, secretKeySpec, ivParameterSpec);
                        byte[] doFinal = instance.doFinal(str.getBytes(C4250c.DEFAULT_CHARSET));
                        return str3 + URLEncoder.encode(Base64.encodeToString(doFinal, 8), C4250c.DEFAULT_CHARSET);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /* renamed from: a */
    private static String m150a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return "f_" + str.hashCode();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static File m147a(Context context, String str) {
        return new File(m153b(context), m150a(str));
    }

    /* renamed from: a */
    public static Bitmap m145a(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m152a(Context context, String str, C1180c<Integer> cVar) {
        if (str != null && !str.isEmpty()) {
            C0054d dVar = new C0054d(0, str, new C0056a(str, context, cVar), new C0057b(cVar), (HashMap<String, String>) null);
            dVar.setRetryPolicy(new DefaultRetryPolicy(C6078a.DEFAULT_TIMEOUT, 1, 1.0f));
            RequestQueue newRequestQueue = Volley.newRequestQueue(context, (BaseHttpStack) new HurlStack());
            dVar.setShouldCache(false);
            newRequestQueue.add(dVar);
        }
    }
}
