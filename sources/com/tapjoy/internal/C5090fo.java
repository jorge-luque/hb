package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.TapjoyUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.fo */
public final class C5090fo {

    /* renamed from: a */
    public final C3134a f13933a;

    /* renamed from: b */
    public final String f13934b;

    /* renamed from: c */
    public final String f13935c;

    /* renamed from: d */
    public final String f13936d;

    /* renamed from: e */
    private final String f13937e;

    /* renamed from: f */
    private final int f13938f;

    /* renamed from: com.tapjoy.internal.fo$a */
    public enum C3134a {
        SDK_ANDROID((byte) 2),
        RPC_ANALYTICS((byte) 49);
        

        /* renamed from: a */
        public byte f8723a;

        private C3134a(byte b) {
            this.f8723a = b;
        }

        @Nullable
        /* renamed from: a */
        public static C3134a m10277a(byte b) {
            for (C3134a aVar : values()) {
                if (aVar.f8723a == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C5090fo(String str) {
        int length = str.length();
        if (!str.matches("[A-Za-z0-9\\-_]*") || length < 60 || (length & 3) != 0) {
            throw new IllegalArgumentException("The given API key was malformed.");
        }
        try {
            byte[] decode = Base64.decode(str, 8);
            int length2 = decode.length;
            ByteBuffer wrap = ByteBuffer.wrap(decode);
            wrap.order(ByteOrder.BIG_ENDIAN);
            int length3 = decode.length - 4;
            int i = wrap.getInt(length3);
            CRC32 crc32 = new CRC32();
            crc32.update(decode, 0, length3);
            if (i == ((int) crc32.getValue())) {
                this.f13937e = str;
                this.f13934b = new UUID(wrap.getLong(0), wrap.getLong(8)).toString();
                this.f13938f = wrap.get(16);
                this.f13933a = C3134a.m10277a(wrap.get(17));
                this.f13935c = str.substring(24, 44);
                int i2 = this.f13938f;
                if (i2 == 1) {
                    this.f13936d = null;
                } else if (i2 != 2 || this.f13933a != C3134a.SDK_ANDROID) {
                    throw new IllegalArgumentException("The given API key was not supported.");
                } else if (length2 >= 57) {
                    byte[] bArr = new byte[12];
                    System.arraycopy(decode, 33, bArr, 0, 12);
                    this.f13936d = TapjoyUtil.convertToHex(bArr);
                } else {
                    throw new IllegalArgumentException("The given API key was invalid.");
                }
            } else {
                throw new IllegalArgumentException("The given API key was invalid.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The given API key was malformed.", e);
        }
    }

    /* renamed from: a */
    public static String m17202a(String str) {
        if (str.regionMatches(13, "-8000-8000-", 0, 11)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 8));
            stringBuffer.append(str.substring(24, 30));
            stringBuffer.append(str.substring(9, 13));
            stringBuffer.append(str.substring(30));
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C5090fo) {
            return this.f13937e.equals(((C5090fo) obj).f13937e);
        }
        return false;
    }

    public final String toString() {
        return this.f13937e;
    }
}
