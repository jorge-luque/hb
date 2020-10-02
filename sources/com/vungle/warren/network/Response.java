package com.vungle.warren.network;

import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3537r;
import p113i.C3548y;
import p113i.C5972w;

public final class Response<T> {
    private final T body;
    private final C3484b0 errorBody;
    private final C3480a0 rawResponse;

    private Response(C3480a0 a0Var, T t, C3484b0 b0Var) {
        this.rawResponse = a0Var;
        this.body = t;
        this.errorBody = b0Var;
    }

    public static <T> Response<T> error(int i, C3484b0 b0Var) {
        if (i >= 400) {
            C3480a0.C3481a aVar = new C3480a0.C3481a();
            aVar.mo19293a(i);
            aVar.mo19301a("Response.error()");
            aVar.mo19299a(C5972w.HTTP_1_1);
            C3548y.C3549a aVar2 = new C3548y.C3549a();
            aVar2.mo19618b("http://localhost/");
            aVar.mo19300a(aVar2.mo19616a());
            return error(b0Var, aVar.mo19303a());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> Response<T> success(T t) {
        C3480a0.C3481a aVar = new C3480a0.C3481a();
        aVar.mo19293a(200);
        aVar.mo19301a("OK");
        aVar.mo19299a(C5972w.HTTP_1_1);
        C3548y.C3549a aVar2 = new C3548y.C3549a();
        aVar2.mo19618b("http://localhost/");
        aVar.mo19300a(aVar2.mo19616a());
        return success(t, aVar.mo19303a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.mo19288v();
    }

    public C3484b0 errorBody() {
        return this.errorBody;
    }

    public C3537r headers() {
        return this.rawResponse.mo19290x();
    }

    public boolean isSuccessful() {
        return this.rawResponse.mo19291y();
    }

    public String message() {
        return this.rawResponse.mo19292z();
    }

    public C3480a0 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(T t, C3480a0 a0Var) {
        if (a0Var.mo19291y()) {
            return new Response<>(a0Var, t, (C3484b0) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> error(C3484b0 b0Var, C3480a0 a0Var) {
        if (!a0Var.mo19291y()) {
            return new Response<>(a0Var, (Object) null, b0Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }
}
