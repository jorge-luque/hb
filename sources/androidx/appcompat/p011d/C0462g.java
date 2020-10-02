package androidx.appcompat.p011d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0486i;
import androidx.appcompat.view.menu.C0488j;
import androidx.appcompat.widget.C0598g0;
import androidx.appcompat.widget.C0621q;
import androidx.core.p014b.p015a.C0748a;
import androidx.core.p020f.C0800b;
import androidx.core.p020f.C0826g;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.d.g */
/* compiled from: SupportMenuInflater */
public class C0462g extends MenuInflater {

    /* renamed from: e */
    static final Class<?>[] f662e;

    /* renamed from: f */
    static final Class<?>[] f663f;

    /* renamed from: a */
    final Object[] f664a;

    /* renamed from: b */
    final Object[] f665b;

    /* renamed from: c */
    Context f666c;

    /* renamed from: d */
    private Object f667d;

    /* renamed from: androidx.appcompat.d.g$a */
    /* compiled from: SupportMenuInflater */
    private static class C0463a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        private static final Class<?>[] f668c = {MenuItem.class};

        /* renamed from: a */
        private Object f669a;

        /* renamed from: b */
        private Method f670b;

        public C0463a(Object obj, String str) {
            this.f669a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f670b = cls.getMethod(str, f668c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f670b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f670b.invoke(this.f669a, new Object[]{menuItem})).booleanValue();
                }
                this.f670b.invoke(this.f669a, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f662e = r0
            f663f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p011d.C0462g.<clinit>():void");
    }

    public C0462g(Context context) {
        super(context);
        this.f666c = context;
        Object[] objArr = {context};
        this.f664a = objArr;
        this.f665b = objArr;
    }

    /* renamed from: a */
    private void m775a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        C0464b bVar = new C0464b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.mo2337d();
                        } else if (name2.equals("item")) {
                            if (!bVar.mo2336c()) {
                                C0800b bVar2 = bVar.f671A;
                                if (bVar2 == null || !bVar2.mo2702a()) {
                                    bVar.mo2332a();
                                } else {
                                    bVar.mo2334b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.mo2333a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.mo2335b(attributeSet);
                    } else if (name3.equals("menu")) {
                        m775a(xmlPullParser, attributeSet, bVar.mo2334b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof C0748a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f666c.getResources().getLayout(i);
            m775a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* renamed from: androidx.appcompat.d.g$b */
    /* compiled from: SupportMenuInflater */
    private class C0464b {

        /* renamed from: A */
        C0800b f671A;

        /* renamed from: B */
        private CharSequence f672B;

        /* renamed from: C */
        private CharSequence f673C;

        /* renamed from: D */
        private ColorStateList f674D = null;

        /* renamed from: E */
        private PorterDuff.Mode f675E = null;

        /* renamed from: a */
        private Menu f677a;

        /* renamed from: b */
        private int f678b;

        /* renamed from: c */
        private int f679c;

        /* renamed from: d */
        private int f680d;

        /* renamed from: e */
        private int f681e;

        /* renamed from: f */
        private boolean f682f;

        /* renamed from: g */
        private boolean f683g;

        /* renamed from: h */
        private boolean f684h;

        /* renamed from: i */
        private int f685i;

        /* renamed from: j */
        private int f686j;

        /* renamed from: k */
        private CharSequence f687k;

        /* renamed from: l */
        private CharSequence f688l;

        /* renamed from: m */
        private int f689m;

        /* renamed from: n */
        private char f690n;

        /* renamed from: o */
        private int f691o;

        /* renamed from: p */
        private char f692p;

        /* renamed from: q */
        private int f693q;

        /* renamed from: r */
        private int f694r;

        /* renamed from: s */
        private boolean f695s;

        /* renamed from: t */
        private boolean f696t;

        /* renamed from: u */
        private boolean f697u;

        /* renamed from: v */
        private int f698v;

        /* renamed from: w */
        private int f699w;

        /* renamed from: x */
        private String f700x;

        /* renamed from: y */
        private String f701y;

        /* renamed from: z */
        private String f702z;

        public C0464b(Menu menu) {
            this.f677a = menu;
            mo2337d();
        }

        /* renamed from: a */
        public void mo2333a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0462g.this.f666c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f678b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f679c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f680d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f681e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f682f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f683g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void mo2335b(AttributeSet attributeSet) {
            C0598g0 a = C0598g0.m1609a(C0462g.this.f666c, attributeSet, R$styleable.MenuItem);
            this.f685i = a.mo3446g(R$styleable.MenuItem_android_id, 0);
            this.f686j = (a.mo3440d(R$styleable.MenuItem_android_menuCategory, this.f679c) & -65536) | (a.mo3440d(R$styleable.MenuItem_android_orderInCategory, this.f680d) & 65535);
            this.f687k = a.mo3443e(R$styleable.MenuItem_android_title);
            this.f688l = a.mo3443e(R$styleable.MenuItem_android_titleCondensed);
            this.f689m = a.mo3446g(R$styleable.MenuItem_android_icon, 0);
            this.f690n = m777a(a.mo3441d(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f691o = a.mo3440d(R$styleable.MenuItem_alphabeticModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            this.f692p = m777a(a.mo3441d(R$styleable.MenuItem_android_numericShortcut));
            this.f693q = a.mo3440d(R$styleable.MenuItem_numericModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (a.mo3447g(R$styleable.MenuItem_android_checkable)) {
                this.f694r = a.mo3435a(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f694r = this.f681e;
            }
            this.f695s = a.mo3435a(R$styleable.MenuItem_android_checked, false);
            this.f696t = a.mo3435a(R$styleable.MenuItem_android_visible, this.f682f);
            this.f697u = a.mo3435a(R$styleable.MenuItem_android_enabled, this.f683g);
            this.f698v = a.mo3440d(R$styleable.MenuItem_showAsAction, -1);
            this.f702z = a.mo3441d(R$styleable.MenuItem_android_onClick);
            this.f699w = a.mo3446g(R$styleable.MenuItem_actionLayout, 0);
            this.f700x = a.mo3441d(R$styleable.MenuItem_actionViewClass);
            String d = a.mo3441d(R$styleable.MenuItem_actionProviderClass);
            this.f701y = d;
            boolean z = d != null;
            if (z && this.f699w == 0 && this.f700x == null) {
                this.f671A = (C0800b) m778a(this.f701y, C0462g.f663f, C0462g.this.f665b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f671A = null;
            }
            this.f672B = a.mo3443e(R$styleable.MenuItem_contentDescription);
            this.f673C = a.mo3443e(R$styleable.MenuItem_tooltipText);
            if (a.mo3447g(R$styleable.MenuItem_iconTintMode)) {
                this.f675E = C0621q.m1806a(a.mo3440d(R$styleable.MenuItem_iconTintMode, -1), this.f675E);
            } else {
                this.f675E = null;
            }
            if (a.mo3447g(R$styleable.MenuItem_iconTint)) {
                this.f674D = a.mo3432a(R$styleable.MenuItem_iconTint);
            } else {
                this.f674D = null;
            }
            a.mo3434a();
            this.f684h = false;
        }

        /* renamed from: c */
        public boolean mo2336c() {
            return this.f684h;
        }

        /* renamed from: d */
        public void mo2337d() {
            this.f678b = 0;
            this.f679c = 0;
            this.f680d = 0;
            this.f681e = 0;
            this.f682f = true;
            this.f683g = true;
        }

        /* renamed from: a */
        private char m777a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private void m779a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f695s).setVisible(this.f696t).setEnabled(this.f697u).setCheckable(this.f694r >= 1).setTitleCondensed(this.f688l).setIcon(this.f689m);
            int i = this.f698v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f702z != null) {
                if (!C0462g.this.f666c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new C0463a(C0462g.this.mo2329a(), this.f702z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof C0486i;
            if (z2) {
                C0486i iVar = (C0486i) menuItem;
            }
            if (this.f694r >= 2) {
                if (z2) {
                    ((C0486i) menuItem).mo2598c(true);
                } else if (menuItem instanceof C0488j) {
                    ((C0488j) menuItem).mo2646a(true);
                }
            }
            String str = this.f700x;
            if (str != null) {
                menuItem.setActionView((View) m778a(str, C0462g.f662e, C0462g.this.f664a));
                z = true;
            }
            int i2 = this.f699w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0800b bVar = this.f671A;
            if (bVar != null) {
                C0826g.m2639a(menuItem, bVar);
            }
            C0826g.m2643a(menuItem, this.f672B);
            C0826g.m2645b(menuItem, this.f673C);
            C0826g.m2640a(menuItem, this.f690n, this.f691o);
            C0826g.m2644b(menuItem, this.f692p, this.f693q);
            PorterDuff.Mode mode = this.f675E;
            if (mode != null) {
                C0826g.m2642a(menuItem, mode);
            }
            ColorStateList colorStateList = this.f674D;
            if (colorStateList != null) {
                C0826g.m2641a(menuItem, colorStateList);
            }
        }

        /* renamed from: b */
        public SubMenu mo2334b() {
            this.f684h = true;
            SubMenu addSubMenu = this.f677a.addSubMenu(this.f678b, this.f685i, this.f686j, this.f687k);
            m779a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: a */
        public void mo2332a() {
            this.f684h = true;
            m779a(this.f677a.add(this.f678b, this.f685i, this.f686j, this.f687k));
        }

        /* renamed from: a */
        private <T> T m778a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C0462g.this.f666c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo2329a() {
        if (this.f667d == null) {
            this.f667d = m774a(this.f666c);
        }
        return this.f667d;
    }

    /* renamed from: a */
    private Object m774a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m774a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
