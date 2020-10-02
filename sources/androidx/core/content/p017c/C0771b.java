package androidx.core.content.p017c;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.core.content.c.b */
/* compiled from: ComplexColorCompat */
public final class C0771b {

    /* renamed from: a */
    private final Shader f1964a;

    /* renamed from: b */
    private final ColorStateList f1965b;

    /* renamed from: c */
    private int f1966c;

    private C0771b(Shader shader, ColorStateList colorStateList, int i) {
        this.f1964a = shader;
        this.f1965b = colorStateList;
        this.f1966c = i;
    }

    /* renamed from: a */
    static C0771b m2425a(Shader shader) {
        return new C0771b(shader, (ColorStateList) null, 0);
    }

    /* renamed from: b */
    static C0771b m2426b(int i) {
        return new C0771b((Shader) null, (ColorStateList) null, i);
    }

    /* renamed from: c */
    public boolean mo4027c() {
        return this.f1964a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f1965b;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4028d() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f1964a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f1965b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p017c.C0771b.mo4028d():boolean");
    }

    /* renamed from: e */
    public boolean mo4029e() {
        return mo4027c() || this.f1966c != 0;
    }

    /* renamed from: a */
    static C0771b m2423a(ColorStateList colorStateList) {
        return new C0771b((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: b */
    public Shader mo4026b() {
        return this.f1964a;
    }

    /* renamed from: b */
    public static C0771b m2427b(Resources resources, int i, Resources.Theme theme) {
        try {
            return m2424a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* renamed from: a */
    public int mo4023a() {
        return this.f1966c;
    }

    /* renamed from: a */
    public void mo4024a(int i) {
        this.f1966c = i;
    }

    /* renamed from: a */
    public boolean mo4025a(int[] iArr) {
        if (mo4028d()) {
            ColorStateList colorStateList = this.f1965b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1966c) {
                this.f1966c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C0771b m2424a(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
            } else if (name.equals("gradient")) {
                c = 1;
            }
            if (c == 0) {
                return m2423a(C0770a.m2420a(resources, (XmlPullParser) xml, asAttributeSet, theme));
            }
            if (c == 1) {
                return m2425a(C0777d.m2454a(resources, xml, asAttributeSet, theme));
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        throw new XmlPullParserException("No start tag found");
    }
}
