package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0481f;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0486i;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.v */
/* compiled from: MenuPopupWindow */
public class C0631v extends ListPopupWindow implements C0630u {

    /* renamed from: J */
    private static Method f1568J;

    /* renamed from: I */
    private C0630u f1569I;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1568J = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public C0631v(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0622r mo3157a(Context context, boolean z) {
        C0632a aVar = new C0632a(context, z);
        aVar.mo3577a(this);
        return aVar;
    }

    /* renamed from: b */
    public void mo3575b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1144E.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: c */
    public void mo3576c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1568J;
            if (method != null) {
                try {
                    method.invoke(this.f1144E, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        } else {
            this.f1144E.setTouchModal(z);
        }
    }

    /* renamed from: androidx.appcompat.widget.v$a */
    /* compiled from: MenuPopupWindow */
    public static class C0632a extends C0622r {

        /* renamed from: o */
        final int f1570o;

        /* renamed from: p */
        final int f1571p;

        /* renamed from: q */
        private C0630u f1572q;

        /* renamed from: r */
        private MenuItem f1573r;

        public C0632a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1570o = 22;
                this.f1571p = 21;
                return;
            }
            this.f1570o = 21;
            this.f1571p = 22;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            C0481f fVar;
            int pointToPosition;
            int i2;
            if (this.f1572q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    fVar = (C0481f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    fVar = (C0481f) adapter;
                }
                C0486i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < fVar.getCount()) {
                    iVar = fVar.getItem(i2);
                }
                MenuItem menuItem = this.f1573r;
                if (menuItem != iVar) {
                    C0482g b = fVar.mo2506b();
                    if (menuItem != null) {
                        this.f1572q.mo2492b(b, menuItem);
                    }
                    this.f1573r = iVar;
                    if (iVar != null) {
                        this.f1572q.mo2491a(b, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1570o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.mo2363a().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f1571p) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0481f) getAdapter()).mo2506b().mo2526a(false);
                return true;
            }
        }

        /* renamed from: a */
        public void mo3577a(C0630u uVar) {
            this.f1572q = uVar;
        }
    }

    /* renamed from: a */
    public void mo3574a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1144E.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void mo2492b(C0482g gVar, MenuItem menuItem) {
        C0630u uVar = this.f1569I;
        if (uVar != null) {
            uVar.mo2492b(gVar, menuItem);
        }
    }

    /* renamed from: a */
    public void mo3573a(C0630u uVar) {
        this.f1569I = uVar;
    }

    /* renamed from: a */
    public void mo2491a(C0482g gVar, MenuItem menuItem) {
        C0630u uVar = this.f1569I;
        if (uVar != null) {
            uVar.mo2491a(gVar, menuItem);
        }
    }
}
