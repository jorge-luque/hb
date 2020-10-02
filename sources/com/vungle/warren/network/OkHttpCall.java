package com.vungle.warren.network;

import android.util.Log;
import com.vungle.warren.network.converters.Converter;
import java.io.IOException;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3497e;
import p113i.C3541u;
import p113i.C5963f;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C6584i;
import p119j.C6589n;

final class OkHttpCall<T> implements Call<T> {
    /* access modifiers changed from: private */
    public static final String TAG = "OkHttpCall";
    /* access modifiers changed from: private */
    public final Converter<C3484b0, T> converter;
    private C3497e rawCall;

    static final class ExceptionCatchingResponseBody extends C3484b0 {
        private final C3484b0 delegate;
        IOException thrownException;

        ExceptionCatchingResponseBody(C3484b0 b0Var) {
            this.delegate = b0Var;
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public C3541u contentType() {
            return this.delegate.contentType();
        }

        public C3580e source() {
            return C6589n.m21610a((C3586u) new C6584i(this.delegate.source()) {
                public long read(C3577c cVar, long j) throws IOException {
                    try {
                        return super.read(cVar, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends C3484b0 {
        private final long contentLength;
        private final C3541u contentType;

        NoContentResponseBody(C3541u uVar, long j) {
            this.contentType = uVar;
            this.contentLength = j;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public C3541u contentType() {
            return this.contentType;
        }

        public C3580e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(C3497e eVar, Converter<C3484b0, T> converter2) {
        this.rawCall = eVar;
        this.converter = converter2;
    }

    /* access modifiers changed from: private */
    public Response<T> parseResponse(C3480a0 a0Var, Converter<C3484b0, T> converter2) throws IOException {
        C3484b0 d = a0Var.mo19284d();
        C3480a0.C3481a X = a0Var.mo19275X();
        X.mo19296a((C3484b0) new NoContentResponseBody(d.contentType(), d.contentLength()));
        C3480a0 a = X.mo19303a();
        int v = a.mo19288v();
        if (v < 200 || v >= 300) {
            try {
                C3577c cVar = new C3577c();
                d.source().mo19691a((C3585t) cVar);
                return Response.error(C3484b0.create(d.contentType(), d.contentLength(), cVar), a);
            } finally {
                d.close();
            }
        } else if (v == 204 || v == 205) {
            d.close();
            return Response.success(null, a);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(d);
            try {
                return Response.success(converter2.convert(exceptionCatchingResponseBody), a);
            } catch (RuntimeException e) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e;
            }
        }
    }

    public void enqueue(final Callback<T> callback) {
        this.rawCall.mo19362a(new C5963f() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Log.w(OkHttpCall.TAG, "Error on executing callback", th2);
                }
            }

            public void onFailure(C3497e eVar, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(C3497e eVar, C3480a0 a0Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(a0Var, OkHttpCall.this.converter));
                    } catch (Throwable th) {
                        Log.w(OkHttpCall.TAG, "Error on excuting callback", th);
                    }
                } catch (Throwable th2) {
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        C3497e eVar;
        synchronized (this) {
            eVar = this.rawCall;
        }
        return parseResponse(eVar.execute(), this.converter);
    }
}
