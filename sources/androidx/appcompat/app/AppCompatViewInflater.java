package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p011d.C0458d;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.C0591d0;
import androidx.core.p020f.C0839t;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import p075d.p080b.C3191a;

public class AppCompatViewInflater {

    /* renamed from: b */
    private static final Class<?>[] f397b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    private static final int[] f398c = {16843375};

    /* renamed from: d */
    private static final String[] f399d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e */
    private static final Map<String, Constructor<? extends View>> f400e = new C3191a();

    /* renamed from: a */
    private final Object[] f401a = new Object[2];

    /* renamed from: androidx.appcompat.app.AppCompatViewInflater$a */
    private static class C0398a implements View.OnClickListener {

        /* renamed from: a */
        private final View f402a;

        /* renamed from: b */
        private final String f403b;

        /* renamed from: c */
        private Method f404c;

        /* renamed from: d */
        private Context f405d;

        public C0398a(View view, String str) {
            this.f402a = view;
            this.f403b = str;
        }

        /* renamed from: a */
        private void m378a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f403b, new Class[]{View.class})) != null) {
                        this.f404c = method;
                        this.f405d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f402a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f402a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f403b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f402a.getClass() + str2);
        }

        public void onClick(View view) {
            if (this.f404c == null) {
                m378a(this.f402a.getContext(), this.f403b);
            }
            try {
                this.f404c.invoke(this.f405d, new Object[]{view});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo1938a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo1939a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m357a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = C0591d0.m1568b(context2);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c = 13;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view2 = mo1952m(context2, attributeSet);
                m360a(view2, str);
                break;
            case 1:
                view2 = mo1946g(context2, attributeSet);
                m360a(view2, str);
                break;
            case 2:
                view2 = mo1941b(context2, attributeSet);
                m360a(view2, str);
                break;
            case 3:
                view2 = mo1944e(context2, attributeSet);
                m360a(view2, str);
                break;
            case 4:
                view2 = mo1951l(context2, attributeSet);
                m360a(view2, str);
                break;
            case 5:
                view2 = mo1945f(context2, attributeSet);
                m360a(view2, str);
                break;
            case 6:
                view2 = mo1942c(context2, attributeSet);
                m360a(view2, str);
                break;
            case 7:
                view2 = mo1948i(context2, attributeSet);
                m360a(view2, str);
                break;
            case 8:
                view2 = mo1943d(context2, attributeSet);
                m360a(view2, str);
                break;
            case 9:
                view2 = mo1940a(context2, attributeSet);
                m360a(view2, str);
                break;
            case 10:
                view2 = mo1947h(context2, attributeSet);
                m360a(view2, str);
                break;
            case 11:
                view2 = mo1949j(context2, attributeSet);
                m360a(view2, str);
                break;
            case 12:
                view2 = mo1950k(context2, attributeSet);
                m360a(view2, str);
                break;
            case 13:
                view2 = mo1953n(context2, attributeSet);
                m360a(view2, str);
                break;
            default:
                view2 = mo1938a(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = m361b(context2, str, attributeSet);
        }
        if (view2 != null) {
            m359a(view2, attributeSet);
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public AppCompatButton mo1941b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public AppCompatCheckBox mo1942c(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public AppCompatCheckedTextView mo1943d(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public AppCompatEditText mo1944e(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public AppCompatImageButton mo1945f(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public AppCompatImageView mo1946g(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public AppCompatMultiAutoCompleteTextView mo1947h(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public AppCompatRadioButton mo1948i(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public AppCompatRatingBar mo1949j(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public AppCompatSeekBar mo1950k(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public AppCompatSpinner mo1951l(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public AppCompatTextView mo1952m(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public AppCompatToggleButton mo1953n(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    /* renamed from: b */
    private View m361b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(ViewHierarchyConstants.VIEW_KEY)) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.f401a[0] = context;
            this.f401a[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String a : f399d) {
                    View a2 = m358a(context, str, a);
                    if (a2 != null) {
                        return a2;
                    }
                }
                Object[] objArr = this.f401a;
                objArr[0] = null;
                objArr[1] = null;
                return null;
            }
            View a3 = m358a(context, str, (String) null);
            Object[] objArr2 = this.f401a;
            objArr2[0] = null;
            objArr2[1] = null;
            return a3;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr3 = this.f401a;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AppCompatAutoCompleteTextView mo1940a(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    /* renamed from: a */
    private void m360a(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(AppCompatViewInflater.class.getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* renamed from: a */
    private void m359a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || C0839t.m2732u(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f398c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0398a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private View m358a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends U> constructor = f400e.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f397b);
            f400e.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f401a);
    }

    /* renamed from: a */
    private static Context m357a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(R$styleable.View_theme, 0);
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return (!(context instanceof C0458d) || ((C0458d) context).mo2303a() != resourceId) ? new C0458d(context, resourceId) : context;
        }
        return context;
    }
}
