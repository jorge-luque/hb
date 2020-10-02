package androidx.core.p020f;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.f.d */
/* compiled from: KeyEventDispatcher */
public class C0822d {

    /* renamed from: a */
    private static boolean f2030a = false;

    /* renamed from: b */
    private static Method f2031b = null;

    /* renamed from: c */
    private static boolean f2032c = false;

    /* renamed from: d */
    private static Field f2033d;

    /* renamed from: androidx.core.f.d$a */
    /* compiled from: KeyEventDispatcher */
    public interface C0823a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    /* renamed from: a */
    public static boolean m2630a(View view, KeyEvent keyEvent) {
        return C0839t.m2706b(view, keyEvent);
    }

    /* renamed from: a */
    public static boolean m2631a(C0823a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return m2628a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return m2629a((Dialog) callback, keyEvent);
        }
        if ((view == null || !C0839t.m2702a(view, keyEvent)) && !aVar.superDispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m2627a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2030a) {
            try {
                f2031b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2030a = true;
        }
        Method method = f2031b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2628a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m2627a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0839t.m2702a(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: a */
    private static DialogInterface.OnKeyListener m2626a(Dialog dialog) {
        if (!f2032c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f2033d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2032c = true;
        }
        Field field = f2033d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m2629a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener a = m2626a(dialog);
        if (a != null && a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0839t.m2702a(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
