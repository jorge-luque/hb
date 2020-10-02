package com.chartboost.sdk.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.chartboost.sdk.impl.a1 */
public class C2120a1 {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo9279a(C2203r0<?> r0Var) throws IOException {
        return (HttpURLConnection) new URL(r0Var.f7433b).openConnection();
    }
}
