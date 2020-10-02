package com.criteo.publisher.advancednative;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayDeque;

/* renamed from: com.criteo.publisher.advancednative.e */
public class C2358e {

    /* renamed from: com.criteo.publisher.advancednative.e$a */
    class C2359a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C2371l f7735a;

        C2359a(C2358e eVar, C2371l lVar) {
            this.f7735a = lVar;
        }

        public void onClick(View view) {
            this.f7735a.mo10205a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10212a(View view, C2371l lVar) {
        C2359a aVar = new C2359a(this, lVar);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(view);
        while (!arrayDeque.isEmpty()) {
            View view2 = (View) arrayDeque.remove();
            view2.setOnClickListener(aVar);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    arrayDeque.add(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
