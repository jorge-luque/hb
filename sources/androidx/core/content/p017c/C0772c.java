package androidx.core.content.p017c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.p016c.C0751a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.core.content.c.c */
/* compiled from: FontResourcesParserCompat */
public class C0772c {

    /* renamed from: androidx.core.content.c.c$a */
    /* compiled from: FontResourcesParserCompat */
    public interface C0773a {
    }

    /* renamed from: androidx.core.content.c.c$b */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0774b implements C0773a {

        /* renamed from: a */
        private final C0775c[] f1967a;

        public C0774b(C0775c[] cVarArr) {
            this.f1967a = cVarArr;
        }

        /* renamed from: a */
        public C0775c[] mo4030a() {
            return this.f1967a;
        }
    }

    /* renamed from: androidx.core.content.c.c$c */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0775c {

        /* renamed from: a */
        private final String f1968a;

        /* renamed from: b */
        private int f1969b;

        /* renamed from: c */
        private boolean f1970c;

        /* renamed from: d */
        private String f1971d;

        /* renamed from: e */
        private int f1972e;

        /* renamed from: f */
        private int f1973f;

        public C0775c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1968a = str;
            this.f1969b = i;
            this.f1970c = z;
            this.f1971d = str2;
            this.f1972e = i2;
            this.f1973f = i3;
        }

        /* renamed from: a */
        public String mo4031a() {
            return this.f1968a;
        }

        /* renamed from: b */
        public int mo4032b() {
            return this.f1973f;
        }

        /* renamed from: c */
        public int mo4033c() {
            return this.f1972e;
        }

        /* renamed from: d */
        public String mo4034d() {
            return this.f1971d;
        }

        /* renamed from: e */
        public int mo4035e() {
            return this.f1969b;
        }

        /* renamed from: f */
        public boolean mo4036f() {
            return this.f1970c;
        }
    }

    /* renamed from: androidx.core.content.c.c$d */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0776d implements C0773a {

        /* renamed from: a */
        private final C0751a f1974a;

        /* renamed from: b */
        private final int f1975b;

        /* renamed from: c */
        private final int f1976c;

        public C0776d(C0751a aVar, int i, int i2) {
            this.f1974a = aVar;
            this.f1976c = i;
            this.f1975b = i2;
        }

        /* renamed from: a */
        public int mo4037a() {
            return this.f1976c;
        }

        /* renamed from: b */
        public C0751a mo4038b() {
            return this.f1974a;
        }

        /* renamed from: c */
        public int mo4039c() {
            return this.f1975b;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    public static androidx.core.content.p017c.C0772c.C0773a m2436a(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.c.c$a r3 = m2440b(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            goto L_0x001b
        L_0x001a:
            throw r3
        L_0x001b:
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p017c.C0772c.m2436a(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.c.c$a");
    }

    /* renamed from: b */
    private static C0773a m2440b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m2441c(xmlPullParser, resources);
        }
        m2439a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    private static C0773a m2441c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(m2442d(xmlPullParser, resources));
                    } else {
                        m2439a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new C0774b((C0775c[]) arrayList.toArray(new C0775c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            m2439a(xmlPullParser);
        }
        return new C0776d(new C0751a(string, string2, string3, m2437a(resources, resourceId)), integer, integer2);
    }

    /* renamed from: d */
    private static C0775c m2442d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m2439a(xmlPullParser);
        }
        return new C0775c(string2, i, z, string, i3, resourceId);
    }

    /* renamed from: a */
    private static int m2435a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /* renamed from: a */
    public static List<List<byte[]>> m2437a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m2435a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m2438a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m2438a(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* renamed from: a */
    private static List<byte[]> m2438a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m2439a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
