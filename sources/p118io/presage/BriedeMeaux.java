package p118io.presage;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p118io.presage.C6388cu;

/* renamed from: io.presage.BriedeMeaux */
public final class BriedeMeaux {

    /* renamed from: a */
    public static final CamembertauCalvados f16398a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private Camembertbio f16399b = Camembertbio.f16412a;

    /* renamed from: io.presage.BriedeMeaux$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static Rect m20232a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }

    /* renamed from: b */
    public static Rect m20237b(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    /* renamed from: c */
    private static Rect m20239c(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.width() != view.getWidth()) {
            rect.right = rect.left + view.getWidth();
        }
        if (rect.height() != view.getHeight()) {
            rect.bottom = rect.top + view.getHeight();
        }
        return rect;
    }

    /* renamed from: a */
    public static List<Rect> m20236a(List<? extends View> list, Rect rect) {
        ArrayList arrayList = new ArrayList();
        for (View a : list) {
            Rect a2 = m20232a(a);
            Rect rect2 = new Rect(rect);
            if (rect2.intersect(a2)) {
                arrayList.add(rect2);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static boolean m20238b(View view, Rect rect) {
        View rootView = view.getRootView();
        C6514hl.m21414a((Object) rootView, "container.rootView");
        return ((float) rect.height()) <= ((float) rootView.getHeight()) * 0.4f;
    }

    /* renamed from: a */
    public static int m20231a(Rect rect, List<Rect> list) {
        int i = rect.right;
        int i2 = 0;
        for (int i3 = rect.left; i3 < i; i3++) {
            int i4 = rect.bottom;
            for (int i5 = rect.top; i5 < i4; i5++) {
                Iterator<Rect> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().contains(i3, i5)) {
                            i2++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static C6388cu m20235a(View view, C6388cu cuVar) {
        if (cuVar == null || view == null) {
            return null;
        }
        Rect a = cuVar.mo35315a();
        Rect c = m20239c(view);
        a.offset(c.left, c.top);
        return m20233a(view, a);
    }

    /* renamed from: a */
    public static C6388cu m20234a(View view, View view2) {
        return m20233a(view2, m20239c(view));
    }

    /* renamed from: a */
    private static C6388cu m20233a(View view, Rect rect) {
        Rect c = m20239c(view);
        if (m20238b(view, c)) {
            return null;
        }
        BriquetteduNord a = Camembertbio.m20268a(rect, c, 1.0f);
        a.mo34464b();
        a.mo34463a();
        rect.offset(-c.left, -c.top);
        C6388cu.CamembertauCalvados camembertauCalvados = C6388cu.f16950a;
        return C6388cu.CamembertauCalvados.m21209a(rect);
    }
}
