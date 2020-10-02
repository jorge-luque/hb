package com.loopj.android.http;

import java.io.IOException;
import java.net.URI;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5901q;

/* renamed from: com.loopj.android.http.n */
/* compiled from: ResponseHandlerInterface */
public interface C4264n {
    boolean getUsePoolThread();

    boolean getUseSynchronousMode();

    void onPostProcessResponse(C4264n nVar, C5901q qVar);

    void onPreProcessResponse(C4264n nVar, C5901q qVar);

    void sendCancelMessage();

    void sendFailureMessage(int i, C5691d[] dVarArr, byte[] bArr, Throwable th);

    void sendFinishMessage();

    void sendResponseMessage(C5901q qVar) throws IOException;

    void sendRetryMessage(int i);

    void sendStartMessage();

    void setRequestHeaders(C5691d[] dVarArr);

    void setRequestURI(URI uri);
}
