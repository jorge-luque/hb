package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.j */
/* compiled from: ScrollbarHelper */
class C1111j {
    /* renamed from: a */
    static int m4518a(RecyclerView.C1070z zVar, C1106h hVar, View view, View view2, RecyclerView.C1054o oVar, boolean z, boolean z2) {
        int i;
        if (oVar.mo5591e() == 0 || zVar.mo5697a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.mo5611l(view), oVar.mo5611l(view2));
        int max = Math.max(oVar.mo5611l(view), oVar.mo5611l(view2));
        if (z2) {
            i = Math.max(0, (zVar.mo5697a() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(hVar.mo5880a(view2) - hVar.mo5887d(view))) / ((float) (Math.abs(oVar.mo5611l(view) - oVar.mo5611l(view2)) + 1)))) + ((float) (hVar.mo5890f() - hVar.mo5887d(view))));
    }

    /* renamed from: b */
    static int m4519b(RecyclerView.C1070z zVar, C1106h hVar, View view, View view2, RecyclerView.C1054o oVar, boolean z) {
        if (oVar.mo5591e() == 0 || zVar.mo5697a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.mo5697a();
        }
        return (int) ((((float) (hVar.mo5880a(view2) - hVar.mo5887d(view))) / ((float) (Math.abs(oVar.mo5611l(view) - oVar.mo5611l(view2)) + 1))) * ((float) zVar.mo5697a()));
    }

    /* renamed from: a */
    static int m4517a(RecyclerView.C1070z zVar, C1106h hVar, View view, View view2, RecyclerView.C1054o oVar, boolean z) {
        if (oVar.mo5591e() == 0 || zVar.mo5697a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.mo5611l(view) - oVar.mo5611l(view2)) + 1;
        }
        return Math.min(hVar.mo5892g(), hVar.mo5880a(view2) - hVar.mo5887d(view));
    }
}
