package com.criteo.publisher.p068z;

import android.os.AsyncTask;
import android.util.Log;
import com.criteo.publisher.CriteoErrorCode;
import com.criteo.publisher.CriteoInterstitialAdDisplayListener;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.model.C2467y;
import com.criteo.publisher.p054a0.C2344s;
import com.criteo.publisher.p054a0.C2345t;
import java.net.HttpURLConnection;
import java.net.URL;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.criteo.publisher.z.d */
public class C2595d extends AsyncTask<String, Void, String> {

    /* renamed from: a */
    private C2467y f8175a;

    /* renamed from: b */
    private final C2456q f8176b;

    /* renamed from: c */
    private CriteoInterstitialAdDisplayListener f8177c;

    public C2595d(C2467y yVar, C2456q qVar, CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener) {
        this.f8175a = yVar;
        this.f8176b = qVar;
        this.f8177c = criteoInterstitialAdDisplayListener;
    }

    /* renamed from: b */
    private String m9717b(String[] strArr) throws Exception {
        String str = strArr[0];
        String str2 = this.f8176b.mo10295a().get();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "text/plain");
        if (!C2345t.m9006a((CharSequence) str2)) {
            httpURLConnection.setRequestProperty(C6078a.HEADER_USER_AGENT, str2);
        }
        if (httpURLConnection.getResponseCode() == 200) {
            return C2344s.m9004a(httpURLConnection.getInputStream());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            return m9717b(strArr);
        } catch (Throwable th) {
            Log.e("Criteo.WVDT", "Internal WVDT exec error.", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        try {
            m9718b(str);
        } catch (Throwable th) {
            Log.e("Criteo.WVDT", "Internal WVDT PostExec error.", th);
        }
    }

    /* renamed from: b */
    private void m9718b(String str) {
        if (C2345t.m9006a((CharSequence) str)) {
            this.f8175a.mo10418a();
            CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener = this.f8177c;
            if (criteoInterstitialAdDisplayListener != null) {
                criteoInterstitialAdDisplayListener.onAdFailedToDisplay(CriteoErrorCode.ERROR_CODE_NETWORK_ERROR);
                return;
            }
            return;
        }
        this.f8175a.mo10419a(str);
        this.f8175a.mo10422c();
        CriteoInterstitialAdDisplayListener criteoInterstitialAdDisplayListener2 = this.f8177c;
        if (criteoInterstitialAdDisplayListener2 != null) {
            criteoInterstitialAdDisplayListener2.onAdReadyToDisplay();
        }
    }
}
