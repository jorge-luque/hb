package com.moat.analytics.mobile.ogury;

import android.os.Build;
import com.ogury.p159cm.OguryChoiceManager;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.j */
final class C4329j {

    /* renamed from: ʻ */
    private static int f11585 = 0;

    /* renamed from: ʼ */
    private static byte[] f11586 = {-37, -77, 1, 1, 105, 52, 49, 56, 48, 58, 48, 60, 53, 2, 55, 103, 53, 46, 60, 45, 54, 60, 48, 50, 55, 52, 53, 58, 55, 4, 97, 4, 104, 5, 55, 95, 10, 49, 98, 60, 2, 101, 1, 119, 122, 113, 126, 113, 122, 67, -88, 120, 114, 69, -84, 109, 122, 123, 64, -92, 73, 122, 117, 115, -90, 74, -90, 110, 126, 113, 115, 123, 116, 72, -88, 71, -97, 126, 66, -87, 65, -92, -37, 54, -37, -115, -37, 93, -37, -105, -37, 44, -37, -26};

    /* renamed from: ʽ */
    private static int f11587 = 39;

    /* renamed from: ˊॱ */
    private static int f11588 = 1;

    /* renamed from: ॱॱ */
    private static int f11589 = -1675497915;

    /* renamed from: ᐝ */
    private static int f11590 = 814200731;

    /* renamed from: ˊ */
    private boolean f11591 = false;

    /* renamed from: ˋ */
    private boolean f11592 = false;

    /* renamed from: ˎ */
    private int f11593 = 10;

    /* renamed from: ˏ */
    private boolean f11594 = false;

    /* renamed from: ॱ */
    private int f11595 = 200;

    C4329j(String str) {
        int i;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(m14497(-40, (byte) 0, -814200731, 1675498030, 59).intern());
                boolean equals = string.equals(m14497(-40, (byte) 0, -814200729, 1675497968, -53).intern());
                boolean equals2 = string.equals(m14497(-40, (byte) 0, -814200689, 1675497971, -118).intern());
                if ((string.equals(m14497(-40, (byte) 0, -814200649, 1675498026, -55).intern()) || equals || equals2) && !m14495(jSONObject) && !m14498(jSONObject)) {
                    this.f11594 = true;
                    this.f11592 = equals;
                    this.f11591 = equals2;
                    if (equals2) {
                        this.f11592 = true;
                    }
                }
                if (jSONObject.has(m14497(-40, (byte) 0, -814200647, 1675498020, 120).intern()) && (i = jSONObject.getInt(m14497(-40, (byte) 0, -814200647, 1675498020, 120).intern())) >= 100 && i <= 1000) {
                    this.f11595 = i;
                }
                if (jSONObject.has(m14497(-40, (byte) 0, -814200645, 1675498016, -79).intern())) {
                    this.f11593 = jSONObject.getInt(m14497(-40, (byte) 0, -814200645, 1675498016, -79).intern());
                }
                if (m14496(jSONObject)) {
                    ((C4328i) MoatAnalytics.getInstance()).f11580 = true;
                }
            } catch (Exception e) {
                this.f11594 = false;
                this.f11592 = false;
                this.f11595 = 200;
                C4332l.m14509(e);
            }
        }
    }

    /* renamed from: ˊ */
    private static boolean m14495(JSONObject jSONObject) {
        try {
            if (16 > Build.VERSION.SDK_INT) {
                int i = f11585 + 111;
                f11588 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                int i2 = i % 2;
                int i3 = f11588 + 13;
                f11585 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                if ((i3 % 2 != 0 ? 19 : 'D') != 19) {
                    return true;
                }
                Object obj = null;
                super.hashCode();
                return true;
            }
            if (jSONObject.has(m14497(-40, (byte) 0, -814200643, 1675498026, 92).intern())) {
                int i4 = f11585 + 109;
                f11588 = i4 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                int i5 = i4 % 2;
                JSONArray jSONArray = jSONObject.getJSONArray(m14497(-40, (byte) 0, -814200643, 1675498026, 92).intern());
                int length = jSONArray.length();
                int i6 = 0;
                while (i6 < length) {
                    int i7 = f11585 + 55;
                    f11588 = i7 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                    if ((i7 % 2 == 0 ? 'S' : '*') != 'S') {
                        if ((jSONArray.getInt(i6) == Build.VERSION.SDK_INT ? 'S' : 'T') != 'S') {
                            i6++;
                        }
                    } else if (jSONArray.getInt(i6) != Build.VERSION.SDK_INT) {
                        i6++;
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: ˋ */
    private static boolean m14496(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i;
        String str;
        try {
            if (jSONObject.has(m14497(-40, (byte) 0, -814200639, 1675498012, 37).intern())) {
                int i2 = f11588 + 77;
                f11585 = i2 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                if (i2 % 2 != 0) {
                    str = C4356s.m14574().mo29190();
                    jSONArray = jSONObject.getJSONArray(m14497(-40, (byte) 0, -814200639, 1675498012, 116).intern());
                    i = jSONArray.length();
                } else {
                    String r5 = C4356s.m14574().mo29190();
                    jSONArray = jSONObject.getJSONArray(m14497(-40, (byte) 0, -814200639, 1675498012, 37).intern());
                    i = jSONArray.length();
                    str = r5;
                }
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = f11588 + 115;
                    f11585 = i4 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                    if ((i4 % 2 != 0 ? 'R' : 'P') != 'R') {
                        if (!(!jSONArray.getString(i3).contentEquals(str))) {
                            return true;
                        }
                    } else {
                        boolean contentEquals = jSONArray.getString(i3).contentEquals(str);
                        Object obj = null;
                        super.hashCode();
                        if (!(!contentEquals)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
        return false;
    }

    /* renamed from: ˏ */
    private static boolean m14498(JSONObject jSONObject) {
        try {
            if ((jSONObject.has(m14497(-40, (byte) 0, -814200641, 1675498012, -29).intern()) ? '[' : '5') == '[') {
                int i = f11585 + 63;
                f11588 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                int i2 = i % 2;
                String r6 = C4356s.m14574().mo29190();
                JSONArray jSONArray = jSONObject.getJSONArray(m14497(-40, (byte) 0, -814200641, 1675498012, -29).intern());
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    if (jSONArray.getString(i3).contentEquals(r6)) {
                        int i4 = f11588 + 97;
                        f11585 = i4 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                        int i5 = i4 % 2;
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
        int i6 = f11585 + 97;
        f11588 = i6 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (!(i6 % 2 != 0)) {
            Object obj = null;
            super.hashCode();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ */
    public final int mo29167() {
        int i = f11588 + 1;
        f11585 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        int i3 = this.f11593;
        int i4 = f11588 + 89;
        f11585 = i4 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i5 = i4 % 2;
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r3.f11594 != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return com.moat.analytics.mobile.ogury.C4346q.C4354e.f11656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if ((r3.f11594) != false) goto L_0x0023;
     */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo29169() {
        /*
            r3 = this;
            int r0 = f11585
            int r0 = r0 + 51
            int r1 = r0 % 128
            f11588 = r1
            int r0 = r0 % 2
            r1 = 37
            if (r0 != 0) goto L_0x0011
            r0 = 24
            goto L_0x0013
        L_0x0011:
            r0 = 37
        L_0x0013:
            if (r0 == r1) goto L_0x001f
            boolean r0 = r3.f11594
            if (r0 == 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0030
            goto L_0x0023
        L_0x001f:
            boolean r0 = r3.f11594
            if (r0 == 0) goto L_0x0030
        L_0x0023:
            int r0 = com.moat.analytics.mobile.ogury.C4346q.C4354e.f11657
            int r1 = f11585
            int r1 = r1 + 83
            int r2 = r1 % 128
            f11588 = r2
            int r1 = r1 % 2
            return r0
        L_0x0030:
            int r0 = com.moat.analytics.mobile.ogury.C4346q.C4354e.f11656
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4329j.mo29169():int");
    }

    /* renamed from: ˎ */
    private static String m14497(int i, byte b, int i2, int i3, short s) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        int i4 = i + f11587;
        int i5 = 0;
        if (i4 == -1) {
            int i6 = f11588 + 99;
            f11585 = i6 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i7 = i6 % 2;
            z = true;
        } else {
            z = false;
        }
        short[] sArr = null;
        if (z) {
            byte[] bArr = f11586;
            if (bArr != null) {
                i4 = (byte) (bArr[f11590 + i2] + f11587);
            } else {
                i4 = (short) (sArr[f11590 + i2] + f11587);
                int i8 = f11585 + 27;
                f11588 = i8 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                if (i8 % 2 == 0) {
                    super.hashCode();
                }
            }
        }
        if (!(i4 <= 0)) {
            int i9 = ((i2 + i4) - 2) + f11590;
            if (z) {
                int i10 = f11585 + 113;
                f11588 = i10 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
                if (!(i10 % 2 == 0)) {
                    i5 = 1;
                }
            }
            int i11 = i9 + i5;
            char c = (char) (i3 + f11589);
            sb.append(c);
            for (int i12 = 1; i12 < i4; i12++) {
                if ((f11586 != null ? 'S' : 17) != 17) {
                    c = (char) (c + (((byte) (f11586[i11] + s)) ^ b));
                    i11--;
                } else {
                    c = (char) (c + (((short) (sArr[i11] + s)) ^ b));
                    i11--;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final boolean mo29168() {
        int i = f11585 + 65;
        f11588 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (i % 2 == 0) {
        }
        boolean z = this.f11591;
        int i2 = f11588 + 43;
        f11585 = i2 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i3 = i2 % 2;
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final boolean mo29166() {
        int i = f11585 + 3;
        f11588 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        boolean z = this.f11592;
        int i3 = f11588 + 47;
        f11585 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final int mo29165() {
        int i = f11588 + 25;
        f11585 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (i % 2 != 0) {
        }
        int i2 = this.f11595;
        int i3 = f11585 + 91;
        f11588 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return i2;
    }
}
