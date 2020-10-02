package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzbaa implements zzazn {
    private final String zzbft;

    public zzbaa() {
        this((String) null);
    }

    public final void zzeq(String str) {
        HttpURLConnection httpURLConnection;
        try {
            String valueOf = String.valueOf(str);
            zzazw.zzed(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzvj.zzpr();
            zzazm.zza(true, httpURLConnection, this.zzbft);
            zzazq zzazq = new zzazq();
            zzazq.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzazq.zza(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                zzazw.zzfc(sb.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            zzazw.zzfc(sb2.toString());
        } catch (IOException e2) {
            String message2 = e2.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
            sb3.append("Error while pinging URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message2);
            zzazw.zzfc(sb3.toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
            sb4.append("Error while pinging URL: ");
            sb4.append(str);
            sb4.append(". ");
            sb4.append(message3);
            zzazw.zzfc(sb4.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public zzbaa(String str) {
        this.zzbft = str;
    }
}
