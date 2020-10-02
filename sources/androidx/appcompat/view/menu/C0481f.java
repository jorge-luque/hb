package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.C0499n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.f */
/* compiled from: MenuAdapter */
public class C0481f extends BaseAdapter {

    /* renamed from: a */
    C0482g f822a;

    /* renamed from: b */
    private int f823b = -1;

    /* renamed from: c */
    private boolean f824c;

    /* renamed from: d */
    private final boolean f825d;

    /* renamed from: e */
    private final LayoutInflater f826e;

    /* renamed from: f */
    private final int f827f;

    public C0481f(C0482g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f825d = z;
        this.f826e = layoutInflater;
        this.f822a = gVar;
        this.f827f = i;
        mo2504a();
    }

    /* renamed from: a */
    public void mo2505a(boolean z) {
        this.f824c = z;
    }

    /* renamed from: b */
    public C0482g mo2506b() {
        return this.f822a;
    }

    public int getCount() {
        ArrayList<C0486i> j = this.f825d ? this.f822a.mo2566j() : this.f822a.mo2570n();
        if (this.f823b < 0) {
            return j.size();
        }
        return j.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f826e.inflate(this.f827f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.mo2392c(this.f822a.mo2571o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        C0499n.C0500a aVar = (C0499n.C0500a) view;
        if (this.f824c) {
            listMenuItemView.mo2391b(true);
        }
        aVar.mo2367a(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        mo2504a();
        super.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2504a() {
        C0486i f = this.f822a.mo2558f();
        if (f != null) {
            ArrayList<C0486i> j = this.f822a.mo2566j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == f) {
                    this.f823b = i;
                    return;
                }
            }
        }
        this.f823b = -1;
    }

    public C0486i getItem(int i) {
        ArrayList<C0486i> j = this.f825d ? this.f822a.mo2566j() : this.f822a.mo2570n();
        int i2 = this.f823b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return j.get(i);
    }
}
