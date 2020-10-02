package androidx.core.content.p017c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* renamed from: androidx.core.content.c.f */
/* compiled from: ResourcesCompat */
public final class C0780f {
    /* renamed from: a */
    public static Drawable m2463a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    /* renamed from: androidx.core.content.c.f$a */
    /* compiled from: ResourcesCompat */
    public static abstract class C0781a {

        /* renamed from: androidx.core.content.c.f$a$a */
        /* compiled from: ResourcesCompat */
        class C0782a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Typeface f1979a;

            C0782a(Typeface typeface) {
                this.f1979a = typeface;
            }

            public void run() {
                C0781a.this.mo3533a(this.f1979a);
            }
        }

        /* renamed from: androidx.core.content.c.f$a$b */
        /* compiled from: ResourcesCompat */
        class C0783b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1981a;

            C0783b(int i) {
                this.f1981a = i;
            }

            public void run() {
                C0781a.this.mo3532a(this.f1981a);
            }
        }

        /* renamed from: a */
        public abstract void mo3532a(int i);

        /* renamed from: a */
        public abstract void mo3533a(Typeface typeface);

        /* renamed from: a */
        public final void mo4041a(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new C0782a(typeface));
        }

        /* renamed from: a */
        public final void mo4040a(int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new C0783b(i));
        }
    }

    /* renamed from: a */
    public static Typeface m2460a(Context context, int i, TypedValue typedValue, int i2, C0781a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m2461a(context, i, typedValue, i2, aVar, (Handler) null, true);
    }

    /* renamed from: a */
    private static Typeface m2461a(Context context, int i, TypedValue typedValue, int i2, C0781a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = m2462a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a != null || aVar != null) {
            return a;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface m2462a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.p017c.C0780f.C0781a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00a7
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L_0x0026
            if (r9 == 0) goto L_0x0025
            r9.mo4040a((int) r14, (android.os.Handler) r10)
        L_0x0025:
            return r13
        L_0x0026:
            android.graphics.Typeface r1 = androidx.core.p013a.C0684c.m2122b((android.content.res.Resources) r0, (int) r4, (int) r5)
            if (r1 == 0) goto L_0x0032
            if (r9 == 0) goto L_0x0031
            r9.mo4041a((android.graphics.Typeface) r1, (android.os.Handler) r10)
        L_0x0031:
            return r1
        L_0x0032:
            java.lang.String r1 = r12.toLowerCase()     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            if (r1 == 0) goto L_0x0065
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            androidx.core.content.c.c$a r2 = androidx.core.content.p017c.C0772c.m2436a((org.xmlpull.v1.XmlPullParser) r1, (android.content.res.Resources) r0)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            if (r2 != 0) goto L_0x0053
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            if (r9 == 0) goto L_0x0052
            r9.mo4040a((int) r14, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
        L_0x0052:
            return r13
        L_0x0053:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = androidx.core.p013a.C0684c.m2119a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            return r0
        L_0x0065:
            r1 = r15
            android.graphics.Typeface r0 = androidx.core.p013a.C0684c.m2116a(r15, r0, r4, r12, r5)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            if (r9 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0072
            r9.mo4041a((android.graphics.Typeface) r0, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
            goto L_0x0075
        L_0x0072:
            r9.mo4040a((int) r14, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008c, IOException -> 0x0076 }
        L_0x0075:
            return r0
        L_0x0076:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto L_0x00a1
        L_0x008c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        L_0x00a1:
            if (r9 == 0) goto L_0x00a6
            r9.mo4040a((int) r14, (android.os.Handler) r10)
        L_0x00a6:
            return r13
        L_0x00a7:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p017c.C0780f.m2462a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.c.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
