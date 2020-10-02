package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.view.menu.k */
/* compiled from: MenuPopup */
abstract class C0494k implements C0502p, C0497m, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Rect f901a;

    C0494k() {
    }

    /* renamed from: b */
    protected static boolean m996b(C0482g gVar) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public abstract void mo2472a(int i);

    /* renamed from: a */
    public void mo2455a(Context context, C0482g gVar) {
    }

    /* renamed from: a */
    public void mo2714a(Rect rect) {
        this.f901a = rect;
    }

    /* renamed from: a */
    public abstract void mo2473a(View view);

    /* renamed from: a */
    public abstract void mo2474a(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo2475a(C0482g gVar);

    /* renamed from: a */
    public boolean mo2463a(C0482g gVar, C0486i iVar) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo2477b(int i);

    /* renamed from: b */
    public abstract void mo2478b(boolean z);

    /* renamed from: b */
    public boolean mo2466b(C0482g gVar, C0486i iVar) {
        return false;
    }

    /* renamed from: c */
    public abstract void mo2480c(int i);

    /* renamed from: c */
    public abstract void mo2481c(boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2482c() {
        return true;
    }

    /* renamed from: d */
    public Rect mo2715d() {
        return this.f901a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m995a(listAdapter).f822a.mo2528a((MenuItem) listAdapter.getItem(i), (C0497m) this, mo2482c() ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m994a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: a */
    protected static C0481f m995a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0481f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0481f) listAdapter;
    }
}
