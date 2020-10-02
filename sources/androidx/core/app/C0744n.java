package androidx.core.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.app.n */
/* compiled from: SharedElementCallback */
public abstract class C0744n {

    /* renamed from: androidx.core.app.n$a */
    /* compiled from: SharedElementCallback */
    public interface C0745a {
    }

    /* renamed from: a */
    public abstract Parcelable mo3971a(View view, Matrix matrix, RectF rectF);

    /* renamed from: a */
    public abstract View mo3972a(Context context, Parcelable parcelable);

    /* renamed from: a */
    public abstract void mo3973a(List<View> list);

    /* renamed from: a */
    public abstract void mo3974a(List<String> list, List<View> list2, C0745a aVar);

    /* renamed from: a */
    public abstract void mo3975a(List<String> list, List<View> list2, List<View> list3);

    /* renamed from: a */
    public abstract void mo3976a(List<String> list, Map<String, View> map);

    /* renamed from: b */
    public abstract void mo3977b(List<String> list, List<View> list2, List<View> list3);
}
