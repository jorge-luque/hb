package com.loopj.android.http;

import android.os.Looper;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.client.HttpResponseException;

/* renamed from: com.loopj.android.http.d */
/* compiled from: BinaryHttpResponseHandler */
public abstract class C4252d extends C4250c {
    private static final String LOG_TAG = "BinaryHttpRH";
    private String[] mAllowedContentTypes = {"application/octet-stream", "image/jpeg", "image/png", "image/gif"};

    public C4252d() {
    }

    public String[] getAllowedContentTypes() {
        return this.mAllowedContentTypes;
    }

    public abstract void onFailure(int i, C5691d[] dVarArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, C5691d[] dVarArr, byte[] bArr);

    public final void sendResponseMessage(C5901q qVar) throws IOException {
        C5910y a = qVar.mo33335a();
        C5691d[] headers = qVar.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage(a.mo33371a(), qVar.getAllHeaders(), (byte[]) null, new HttpResponseException(a.mo33371a(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        C5691d dVar = headers[0];
        boolean z = false;
        for (String str : getAllowedContentTypes()) {
            try {
                if (Pattern.matches(str, dVar.getValue())) {
                    z = true;
                }
            } catch (PatternSyntaxException e) {
                C4244a.f11381j.mo28908b(LOG_TAG, "Given pattern is not valid: " + str, e);
            }
        }
        if (!z) {
            sendFailureMessage(a.mo33371a(), qVar.getAllHeaders(), (byte[]) null, new HttpResponseException(a.mo33371a(), "Content-Type (" + dVar.getValue() + ") not allowed!"));
            return;
        }
        super.sendResponseMessage(qVar);
    }

    public C4252d(String[] strArr) {
        if (strArr != null) {
            this.mAllowedContentTypes = strArr;
        } else {
            C4244a.f11381j.mo28907b(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }

    public C4252d(String[] strArr, Looper looper) {
        super(looper);
        if (strArr != null) {
            this.mAllowedContentTypes = strArr;
        } else {
            C4244a.f11381j.mo28907b(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }
}
