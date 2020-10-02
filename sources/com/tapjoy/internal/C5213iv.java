package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/* renamed from: com.tapjoy.internal.iv */
public final class C5213iv {

    /* renamed from: a */
    static final Logger f14317a = Logger.getLogger(C5213iv.class.getName());

    private C5213iv() {
    }

    /* renamed from: a */
    public static C5211it m17522a(C5223jc jcVar) {
        if (jcVar != null) {
            return new C5217ix(jcVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public static C5210is m17521a(C5222jb jbVar) {
        if (jbVar != null) {
            return new C5216iw(jbVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public static C5222jb m17523a(final OutputStream outputStream) {
        final C5224jd jdVar = new C5224jd();
        if (outputStream != null) {
            return new C5222jb() {
                /* renamed from: a */
                public final void mo31393a(C5209ir irVar, long j) {
                    C5226je.m17567a(irVar.f14311b, 0, j);
                    while (j > 0) {
                        jdVar.mo31439a();
                        C5218iy iyVar = irVar.f14310a;
                        int min = (int) Math.min(j, (long) (iyVar.f14330c - iyVar.f14329b));
                        outputStream.write(iyVar.f14328a, iyVar.f14329b, min);
                        int i = iyVar.f14329b + min;
                        iyVar.f14329b = i;
                        long j2 = (long) min;
                        j -= j2;
                        irVar.f14311b -= j2;
                        if (i == iyVar.f14330c) {
                            irVar.f14310a = iyVar.mo31435a();
                            C5219iz.m17549a(iyVar);
                        }
                    }
                }

                public final void close() {
                    outputStream.close();
                }

                public final void flush() {
                    outputStream.flush();
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public static C5223jc m17524a(final InputStream inputStream) {
        final C5224jd jdVar = new C5224jd();
        if (inputStream != null) {
            return new C5223jc() {
                /* renamed from: b */
                public final long mo31394b(C5209ir irVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            jdVar.mo31439a();
                            C5218iy c = irVar.mo31401c(1);
                            int read = inputStream.read(c.f14328a, c.f14330c, (int) Math.min(j, (long) (8192 - c.f14330c)));
                            if (read == -1) {
                                return -1;
                            }
                            c.f14330c += read;
                            long j2 = (long) read;
                            irVar.f14311b += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (C5213iv.m17525a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public final void close() {
                    inputStream.close();
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: a */
    static boolean m17525a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
