package p093e.p101c.p102a.p103a.p104i.p107v;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3006a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3012e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3030s;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: e.c.a.a.i.v.h */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class C3427h {
    /* renamed from: a */
    static C3030s m11395a(Context context, C3435c cVar, C3014g gVar, C3469a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C3012e(context, cVar, gVar);
        }
        return new C3006a(context, cVar, aVar, gVar);
    }
}
