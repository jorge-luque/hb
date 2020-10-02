package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.p018d.C0785a;
import androidx.core.p019e.C0795h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.core.widget.i */
/* compiled from: TextViewCompat */
public final class C0879i {
    /* renamed from: a */
    public static ActionMode.Callback m2936a(TextView textView, ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof C0880a)) ? callback : new C0880a(callback, textView);
    }

    /* renamed from: b */
    public static void m2942b(TextView textView, int i) {
        int i2;
        C0795h.m2502a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* renamed from: c */
    public static void m2944c(TextView textView, int i) {
        C0795h.m2502a(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    /* renamed from: d */
    public static C0785a.C0786a m2945d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new C0785a.C0786a(textView.getTextMetricsParams());
        }
        C0785a.C0786a.C0787a aVar = new C0785a.C0786a.C0787a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            aVar.mo4065a(textView.getBreakStrategy());
            aVar.mo4068b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            aVar.mo4066a(m2943c(textView));
        }
        return aVar.mo4067a();
    }

    /* renamed from: a */
    public static void m2937a(TextView textView, int i) {
        int i2;
        C0795h.m2502a(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* renamed from: c */
    private static TextDirectionHeuristic m2943c(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    /* renamed from: b */
    public static int m2941b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: a */
    public static int m2935a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: a */
    public static void m2940a(TextView textView, C0785a aVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(aVar.mo4045b());
        } else if (m2945d(textView).mo4058a(aVar.mo4044a())) {
            textView.setText(aVar);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    /* renamed from: a */
    public static void m2938a(TextView textView, ColorStateList colorStateList) {
        C0795h.m2503a(textView);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof C0882k) {
            ((C0882k) textView).mo3078a(colorStateList);
        }
    }

    /* renamed from: androidx.core.widget.i$a */
    /* compiled from: TextViewCompat */
    private static class C0880a implements ActionMode.Callback {

        /* renamed from: a */
        private final ActionMode.Callback f2168a;

        /* renamed from: b */
        private final TextView f2169b;

        /* renamed from: c */
        private Class<?> f2170c;

        /* renamed from: d */
        private Method f2171d;

        /* renamed from: e */
        private boolean f2172e;

        /* renamed from: f */
        private boolean f2173f = false;

        C0880a(ActionMode.Callback callback, TextView textView) {
            this.f2168a = callback;
            this.f2169b = textView;
        }

        /* renamed from: a */
        private void m2949a(Menu menu) {
            Method method;
            Context context = this.f2169b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2173f) {
                this.f2173f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2170c = cls;
                    this.f2171d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f2172e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f2170c = null;
                    this.f2171d = null;
                    this.f2172e = false;
                }
            }
            try {
                if (!this.f2172e || !this.f2170c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f2171d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> a = m2948a(context, packageManager);
                for (int i = 0; i < a.size(); i++) {
                    ResolveInfo resolveInfo = a.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(m2947a(resolveInfo, this.f2169b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2168a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2168a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2168a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            m2949a(menu);
            return this.f2168a.onPrepareActionMode(actionMode, menu);
        }

        /* renamed from: a */
        private List<ResolveInfo> m2948a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(m2946a(), 0)) {
                if (m2950a(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private boolean m2950a(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        private Intent m2947a(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = m2946a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m2951a(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        /* renamed from: a */
        private boolean m2951a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: a */
        private Intent m2946a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    /* renamed from: a */
    public static void m2939a(TextView textView, PorterDuff.Mode mode) {
        C0795h.m2503a(textView);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof C0882k) {
            ((C0882k) textView).mo3079a(mode);
        }
    }
}
