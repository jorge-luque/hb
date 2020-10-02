package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.b */
/* compiled from: AlertDialog */
public class C0402b extends C0427g implements DialogInterface {

    /* renamed from: c */
    final AlertController f407c = new AlertController(getContext(), this, getWindow());

    /* renamed from: androidx.appcompat.app.b$a */
    /* compiled from: AlertDialog */
    public static class C0403a {

        /* renamed from: a */
        private final AlertController.C0390f f408a;

        /* renamed from: b */
        private final int f409b;

        public C0403a(Context context) {
            this(context, C0402b.m395a(context, 0));
        }

        /* renamed from: a */
        public C0403a mo1981a(CharSequence charSequence) {
            this.f408a.f363f = charSequence;
            return this;
        }

        /* renamed from: b */
        public Context mo1983b() {
            return this.f408a.f358a;
        }

        public C0403a(Context context, int i) {
            this.f408a = new AlertController.C0390f(new ContextThemeWrapper(context, C0402b.m395a(context, i)));
            this.f409b = i;
        }

        /* renamed from: a */
        public C0403a mo1978a(View view) {
            this.f408a.f364g = view;
            return this;
        }

        /* renamed from: a */
        public C0403a mo1977a(Drawable drawable) {
            this.f408a.f361d = drawable;
            return this;
        }

        /* renamed from: a */
        public C0403a mo1976a(DialogInterface.OnKeyListener onKeyListener) {
            this.f408a.f378u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public C0403a mo1980a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0390f fVar = this.f408a;
            fVar.f380w = listAdapter;
            fVar.f381x = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0403a mo1979a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0390f fVar = this.f408a;
            fVar.f380w = listAdapter;
            fVar.f381x = onClickListener;
            fVar.f351I = i;
            fVar.f350H = true;
            return this;
        }

        /* renamed from: a */
        public C0402b mo1982a() {
            C0402b bVar = new C0402b(this.f408a.f358a, this.f409b);
            this.f408a.mo1928a(bVar.f407c);
            bVar.setCancelable(this.f408a.f375r);
            if (this.f408a.f375r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f408a.f376s);
            bVar.setOnDismissListener(this.f408a.f377t);
            DialogInterface.OnKeyListener onKeyListener = this.f408a.f378u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }
    }

    protected C0402b(Context context, int i) {
        super(context, m395a(context, i));
    }

    /* renamed from: a */
    static int m395a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: b */
    public ListView mo1971b() {
        return this.f407c.mo1908a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f407c.mo1915b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f407c.mo1914a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f407c.mo1919b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f407c.mo1918b(charSequence);
    }
}
