package com.ogury.p159cm;

import com.facebook.share.internal.ShareConstants;
import com.ogury.core.OguryError;
import com.ogury.p159cm.ConsentActivity;
import com.ogury.p159cm.aabbb;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.ogury.cm.abacc */
public final class abacc {

    /* renamed from: a */
    public static final aaaaa f12068a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.abacc$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        com.ogury.p159cm.acbbb.m15201a(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        throw r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m15105a(java.io.InputStream r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0038
            r2 = 0
            if (r5 != 0) goto L_0x000a
            r5 = 0
            goto L_0x0010
        L_0x000a:
            java.lang.String r3 = "gzip"
            boolean r5 = r5.equalsIgnoreCase(r3)
        L_0x0010:
            if (r5 == 0) goto L_0x0038
            com.ogury.cm.abacb r5 = com.ogury.p159cm.abacb.f12067a
            java.lang.String r5 = "receiver$0"
            com.ogury.p159cm.accbb.m15218b(r4, r5)
            int r5 = r4.available()
            int r5 = java.lang.Math.max(r1, r5)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r5)
            r5 = 2
            com.ogury.p159cm.ConsentActivity.aaaaa.m14876a(r4, r1, r2, r5, r0)
            byte[] r4 = r1.toByteArray()
            java.lang.String r5 = "buffer.toByteArray()"
            com.ogury.p159cm.accbb.m15215a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = com.ogury.p159cm.abacb.m15103a((byte[]) r4)
            return r4
        L_0x0038:
            java.nio.charset.Charset r5 = com.ogury.p159cm.babaa.f12165a
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r2.<init>(r4, r5)
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r2, r1)
            java.lang.String r5 = com.ogury.p159cm.ConsentActivity.aaaaa.m14880a((java.io.Reader) r4)     // Catch:{ all -> 0x004c }
            com.ogury.p159cm.acbbb.m15201a(r4, r0)
            return r5
        L_0x004c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004e }
        L_0x004e:
            r0 = move-exception
            com.ogury.p159cm.acbbb.m15201a(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.abacc.m15105a(java.io.InputStream, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m15106a(abbaa abbaa) {
        OutputStream outputStream;
        accbb.m15218b(abbaa, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        try {
            URLConnection openConnection = new URL(abbaa.mo29465c()).openConnection();
            if (openConnection != null) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                httpsURLConnection.setReadTimeout(C6078a.DEFAULT_TIMEOUT);
                httpsURLConnection.setConnectTimeout(QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL);
                httpsURLConnection.setRequestMethod(abbaa.mo29463a());
                httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpsURLConnection.setRequestProperty(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
                httpsURLConnection.setRequestProperty("Content-Encoding", "gzip");
                httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                List<acbaa<String, String>> e = abbaa.mo29467e();
                if (e != null) {
                    for (acbaa next : e) {
                        httpsURLConnection.setRequestProperty((String) next.mo29524a(), (String) next.mo29525b());
                    }
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                outputStream = httpsURLConnection.getOutputStream();
                accbb.m15215a((Object) outputStream, "conn.outputStream");
                abacb abacb = abacb.f12067a;
                outputStream.write(abacb.m15104a(abbaa.mo29464b()));
                outputStream.flush();
                ConsentActivity.aaaaa.m14883a((Closeable) outputStream);
                int responseCode = httpsURLConnection.getResponseCode();
                aacbc d = abbaa.mo29466d();
                if (200 <= responseCode) {
                    if (299 >= responseCode) {
                        if (d != null) {
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            accbb.m15215a((Object) inputStream, "conn.inputStream");
                            d.mo29385a(m15105a(inputStream, httpsURLConnection.getContentEncoding()));
                        }
                        httpsURLConnection.disconnect();
                    }
                }
                if (d != null) {
                    aabbb.aaaaa aaaaa2 = aabbb.f12010a;
                    InputStream errorStream = httpsURLConnection.getErrorStream();
                    accbb.m15215a((Object) errorStream, "conn.errorStream");
                    d.mo29384a(aabbb.aaaaa.m15000a(m15105a(errorStream, httpsURLConnection.getContentEncoding())));
                }
                try {
                    httpsURLConnection.disconnect();
                } catch (Exception e2) {
                    aaccc aaccc = aaccc.f12045a;
                    aaccc.m15049a((Throwable) e2);
                }
            } else {
                throw new acbab("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            }
        } catch (Exception e3) {
            aacbc d2 = abbaa.mo29466d();
            if (d2 != null) {
                String message = e3.getMessage();
                if (message == null) {
                    message = "";
                }
                d2.mo29384a(new OguryError(3, message));
            }
        } catch (Throwable th) {
            ConsentActivity.aaaaa.m14883a((Closeable) outputStream);
            throw th;
        }
    }
}
