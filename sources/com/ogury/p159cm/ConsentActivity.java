package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.internal.Utility;
import com.ogury.core.OguryError;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.ConsentActivity */
public class ConsentActivity extends Activity {

    /* renamed from: a */
    public static final aaaaa f11912a = new aaaaa((baaca) null);

    /* renamed from: b */
    private final FrameLayout.LayoutParams f11913b = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: c */
    private HashMap f11914c;

    /* renamed from: com.ogury.cm.ConsentActivity$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }

        /* renamed from: a */
        private static int m14874a(int i, int i2) {
            int i3 = i % 1;
            return i3 >= 0 ? i3 : i3 + 1;
        }

        /* renamed from: a */
        public static int m14875a(int i, int i2, int i3) {
            return i >= i2 ? i2 : i2 - m14874a(m14874a(i2, 1) - m14874a(i, 1), 1);
        }

        /* renamed from: a */
        public static /* synthetic */ long m14876a(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
            accbb.m15218b(inputStream, "receiver$0");
            accbb.m15218b(outputStream, "out");
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            int read = inputStream.read(bArr);
            long j = 0;
            while (read >= 0) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
                read = inputStream.read(bArr);
            }
            return j;
        }

        /* renamed from: a */
        private static long m14877a(Reader reader, Writer writer, int i) {
            accbb.m15218b(reader, "receiver$0");
            accbb.m15218b(writer, "out");
            char[] cArr = new char[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            int read = reader.read(cArr);
            long j = 0;
            while (read >= 0) {
                writer.write(cArr, 0, read);
                j += (long) read;
                read = reader.read(cArr);
            }
            return j;
        }

        /* renamed from: a */
        public static NetworkInfo m14878a(Context context) {
            accbb.m15218b(context, "receiver$0");
            accbb.m15218b(context, "receiver$0");
            accbb.m15218b("android.permission.ACCESS_NETWORK_STATE", "permission");
            if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
                return null;
            }
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                return ((ConnectivityManager) systemService).getActiveNetworkInfo();
            }
            throw new acbab("null cannot be cast to non-null type android.net.ConnectivityManager");
        }

        /* renamed from: a */
        public static <A, B> acbaa<A, B> m14879a(A a, B b) {
            return new acbaa<>(a, b);
        }

        /* renamed from: a */
        public static String m14880a(Reader reader) {
            accbb.m15218b(reader, "receiver$0");
            StringWriter stringWriter = new StringWriter();
            m14877a(reader, (Writer) stringWriter, (int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
            String stringWriter2 = stringWriter.toString();
            accbb.m15215a((Object) stringWriter2, "buffer.toString()");
            return stringWriter2;
        }

        /* renamed from: a */
        public static List<Object> m14881a(JSONArray jSONArray) {
            accbb.m15218b(jSONArray, "receiver$0");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.get(i));
            }
            return arrayList;
        }

        /* renamed from: a */
        public static JSONObject m14882a(String str) {
            accbb.m15218b(str, "receiver$0");
            try {
                return new JSONObject(str);
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: a */
        public static void m14883a(Closeable closeable) {
            accbb.m15218b(closeable, "receiver$0");
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }

        /* renamed from: b */
        public static JSONArray m14884b(String str) {
            accbb.m15218b(str, "receiver$0");
            try {
                return new JSONArray(str);
            } catch (Exception unused) {
                return new JSONArray();
            }
        }

        /* renamed from: b */
        public static boolean m14885b(Context context) {
            accbb.m15218b(context, "receiver$0");
            NetworkInfo a = m14878a(context);
            return a != null && a.isConnected();
        }

        /* renamed from: c */
        public static int m14886c(String str) {
            accbb.m15218b(str, "receiver$0");
            try {
                List<Number> a = acccc.m15231a((Object) m14881a(m14884b(str)));
                if (!a.isEmpty()) {
                    int i = 0;
                    for (Number intValue : a) {
                        i += intValue.intValue();
                    }
                    return i;
                }
            } catch (Exception e) {
                aaccc aaccc = aaccc.f12045a;
                aaccc.m15048a("Error in intJsonArraySum extension", e);
            }
            return 0;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f11914c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f11914c == null) {
            this.f11914c = new HashMap();
        }
        View view = (View) this.f11914c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11914c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        aaaac aaaac = aaaac.f11933a;
        if (aaaac.m14906c() != null) {
            FrameLayout frameLayout = new FrameLayout(this, (AttributeSet) null);
            frameLayout.setLayoutParams(this.f11913b);
            aaaac aaaac2 = aaaac.f11933a;
            aaaaa b = aaaac.m14905b();
            if (b != null) {
                b.mo29377a((Context) this);
            }
            aaaac aaaac3 = aaaac.f11933a;
            WebView c = aaaac.m14906c();
            if (Build.VERSION.SDK_INT < 16 && c != null) {
                c.setLayerType(1, (Paint) null);
            }
            aaaac aaaac4 = aaaac.f11933a;
            frameLayout.addView(aaaac.m14906c(), this.f11913b);
            aaaac aaaac5 = aaaac.f11933a;
            aaaac.m14897a((WebView) null);
            setContentView(frameLayout);
            return;
        }
        aaaac aaaac6 = aaaac.f11933a;
        aacbc a = aaaac.m14895a();
        if (a != null) {
            a.mo29384a(new OguryError(1003, "Cached webview has been destroyed"));
        }
        aaccc aaccc = aaccc.f12045a;
        aaccc.m15050b("Cached webview has been destroyed");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        aaaac aaaac = aaaac.f11933a;
        aaaac.m14897a((WebView) null);
        aaaac aaaac2 = aaaac.f11933a;
        aaaac.m14898a((aaaaa) null);
        super.onDestroy();
    }
}
