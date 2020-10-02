package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0499n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.e */
/* compiled from: ListMenuPresenter */
public class C0479e implements C0497m, AdapterView.OnItemClickListener {

    /* renamed from: a */
    Context f811a;

    /* renamed from: b */
    LayoutInflater f812b;

    /* renamed from: c */
    C0482g f813c;

    /* renamed from: d */
    ExpandedMenuView f814d;

    /* renamed from: e */
    int f815e;

    /* renamed from: f */
    int f816f;

    /* renamed from: g */
    int f817g;

    /* renamed from: h */
    private C0497m.C0498a f818h;

    /* renamed from: i */
    C0480a f819i;

    /* renamed from: androidx.appcompat.view.menu.e$a */
    /* compiled from: ListMenuPresenter */
    private class C0480a extends BaseAdapter {

        /* renamed from: a */
        private int f820a = -1;

        public C0480a() {
            mo2498a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2498a() {
            C0486i f = C0479e.this.f813c.mo2558f();
            if (f != null) {
                ArrayList<C0486i> j = C0479e.this.f813c.mo2566j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (j.get(i) == f) {
                        this.f820a = i;
                        return;
                    }
                }
            }
            this.f820a = -1;
        }

        public int getCount() {
            int size = C0479e.this.f813c.mo2566j().size() - C0479e.this.f815e;
            return this.f820a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                C0479e eVar = C0479e.this;
                view = eVar.f812b.inflate(eVar.f817g, viewGroup, false);
            }
            ((C0499n.C0500a) view).mo2367a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            mo2498a();
            super.notifyDataSetChanged();
        }

        public C0486i getItem(int i) {
            ArrayList<C0486i> j = C0479e.this.f813c.mo2566j();
            int i2 = i + C0479e.this.f815e;
            int i3 = this.f820a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return j.get(i2);
        }
    }

    public C0479e(Context context, int i) {
        this(i, 0);
        this.f811a = context;
        this.f812b = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void mo2455a(Context context, C0482g gVar) {
        if (this.f816f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f816f);
            this.f811a = contextThemeWrapper;
            this.f812b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f811a != null) {
            this.f811a = context;
            if (this.f812b == null) {
                this.f812b = LayoutInflater.from(context);
            }
        }
        this.f813c = gVar;
        C0480a aVar = this.f819i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public boolean mo2463a(C0482g gVar, C0486i iVar) {
        return false;
    }

    /* renamed from: b */
    public boolean mo2479b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2466b(C0482g gVar, C0486i iVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f813c.mo2528a((MenuItem) this.f819i.getItem(i), (C0497m) this, 0);
    }

    public C0479e(int i, int i2) {
        this.f817g = i;
        this.f816f = i2;
    }

    /* renamed from: a */
    public C0499n mo2496a(ViewGroup viewGroup) {
        if (this.f814d == null) {
            this.f814d = (ExpandedMenuView) this.f812b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f819i == null) {
                this.f819i = new C0480a();
            }
            this.f814d.setAdapter(this.f819i);
            this.f814d.setOnItemClickListener(this);
        }
        return this.f814d;
    }

    /* renamed from: a */
    public ListAdapter mo2495a() {
        if (this.f819i == null) {
            this.f819i = new C0480a();
        }
        return this.f819i;
    }

    /* renamed from: a */
    public void mo2460a(boolean z) {
        C0480a aVar = this.f819i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2459a(C0497m.C0498a aVar) {
        this.f818h = aVar;
    }

    /* renamed from: a */
    public boolean mo2464a(C0506r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new C0485h(rVar).mo2587a((IBinder) null);
        C0497m.C0498a aVar = this.f818h;
        if (aVar == null) {
            return true;
        }
        aVar.mo2089a(rVar);
        return true;
    }

    /* renamed from: a */
    public void mo2457a(C0482g gVar, boolean z) {
        C0497m.C0498a aVar = this.f818h;
        if (aVar != null) {
            aVar.mo2088a(gVar, z);
        }
    }
}
