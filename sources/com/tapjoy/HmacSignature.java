package com.tapjoy;

import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature {

    /* renamed from: a */
    private String f12912a;

    /* renamed from: b */
    private String f12913b;

    public HmacSignature(String str, String str2) {
        this.f12912a = str;
        this.f12913b = str2;
    }

    /* renamed from: a */
    private static String m16536a(Map map) {
        TreeSet treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str + "=" + ((String) map.get(str)) + "&");
        }
        sb.deleteCharAt(sb.lastIndexOf("&"));
        TapjoyLog.m16653v("HmacSignature", "Unhashed String: " + sb.toString());
        return sb.toString();
    }

    public boolean matches(String str, Map map, String str2) {
        return sign(str, map).equals(str2);
    }

    public String sign(String str, Map map) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f12913b.getBytes(), this.f12912a);
            Mac instance = Mac.getInstance(this.f12912a);
            instance.init(secretKeySpec);
            Uri parse = Uri.parse(str);
            String str2 = parse.getScheme() + "://" + parse.getHost();
            if (!((parse.getScheme().equals("http") && parse.getPort() == 80) || (parse.getScheme().equals("https") && parse.getPort() == 443)) && -1 != parse.getPort()) {
                str2 = str2 + ":" + parse.getPort();
            }
            String str3 = str2.toLowerCase() + parse.getPath();
            String a = m16536a(map);
            String str4 = "POST&" + Uri.encode(str3) + "&" + Uri.encode(a);
            TapjoyLog.m16653v("HmacSignature", "Base Url: " + str4);
            byte[] doFinal = instance.doFinal(str4.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : doFinal) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
