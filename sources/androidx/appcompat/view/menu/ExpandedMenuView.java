package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.widget.C0598g0;

public final class ExpandedMenuView extends ListView implements C0482g.C0484b, C0499n, AdapterView.OnItemClickListener {

    /* renamed from: b */
    private static final int[] f725b = {16842964, 16843049};

    /* renamed from: a */
    private C0482g f726a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    /* renamed from: a */
    public void mo2382a(C0482g gVar) {
        this.f726a = gVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo2383a((C0486i) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0598g0 a = C0598g0.m1610a(context, attributeSet, f725b, i, 0);
        if (a.mo3447g(0)) {
            setBackgroundDrawable(a.mo3437b(0));
        }
        if (a.mo3447g(1)) {
            setDivider(a.mo3437b(1));
        }
        a.mo3434a();
    }

    /* renamed from: a */
    public boolean mo2383a(C0486i iVar) {
        return this.f726a.mo2527a((MenuItem) iVar, 0);
    }
}
