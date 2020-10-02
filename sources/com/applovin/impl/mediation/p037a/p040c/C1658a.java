package com.applovin.impl.mediation.p037a.p040c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.impl.mediation.p037a.p038a.C1648b;
import com.applovin.impl.mediation.p037a.p038a.C1649c;
import com.applovin.sdk.C2057R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.a.c.a */
public abstract class C1658a extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a */
    protected final Context f5188a;

    /* renamed from: b */
    protected final List<C1649c> f5189b = new ArrayList();

    /* renamed from: c */
    private final LayoutInflater f5190c;

    protected C1658a(Context context) {
        this.f5188a = context;
        this.f5190c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public C1649c getItem(int i) {
        return this.f5189b.get(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7679a(C1649c cVar);

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return this.f5189b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i).mo7643e();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1648b bVar;
        C1649c a = getItem(i);
        if (view == null) {
            view = this.f5190c.inflate(a.mo7644f(), viewGroup, false);
            bVar = new C1648b();
            bVar.f5141a = (TextView) view.findViewById(16908308);
            bVar.f5142b = (TextView) view.findViewById(16908309);
            bVar.f5143c = (ImageView) view.findViewById(C2057R.C2059id.imageView);
            bVar.f5144d = (ImageView) view.findViewById(C2057R.C2059id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (C1648b) view.getTag();
        }
        bVar.mo7639a(a);
        view.setEnabled(a.mo7640b());
        return view;
    }

    public int getViewTypeCount() {
        return C1649c.m6288a();
    }

    public boolean isEnabled(int i) {
        return getItem(i).mo7640b();
    }

    public void onClick(View view) {
        mo7679a(((C1648b) view.getTag()).mo7638a());
    }
}
