package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.C0768a;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.core.app.o */
/* compiled from: TaskStackBuilder */
public final class C0746o implements Iterable<Intent> {

    /* renamed from: a */
    private final ArrayList<Intent> f1908a = new ArrayList<>();

    /* renamed from: b */
    private final Context f1909b;

    /* renamed from: androidx.core.app.o$a */
    /* compiled from: TaskStackBuilder */
    public interface C0747a {
        /* renamed from: a */
        Intent mo1984a();
    }

    private C0746o(Context context) {
        this.f1909b = context;
    }

    /* renamed from: a */
    public static C0746o m2348a(Context context) {
        return new C0746o(context);
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1908a.iterator();
    }

    /* renamed from: a */
    public C0746o mo3980a(Intent intent) {
        this.f1908a.add(intent);
        return this;
    }

    /* renamed from: a */
    public C0746o mo3978a(Activity activity) {
        Intent a = activity instanceof C0747a ? ((C0747a) activity).mo1984a() : null;
        if (a == null) {
            a = C0723g.m2234a(activity);
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f1909b.getPackageManager());
            }
            mo3979a(component);
            mo3980a(a);
        }
        return this;
    }

    /* renamed from: a */
    public C0746o mo3979a(ComponentName componentName) {
        int size = this.f1908a.size();
        try {
            Intent a = C0723g.m2235a(this.f1909b, componentName);
            while (a != null) {
                this.f1908a.add(size, a);
                a = C0723g.m2235a(this.f1909b, a.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public void mo3981a() {
        mo3982a((Bundle) null);
    }

    /* renamed from: a */
    public void mo3982a(Bundle bundle) {
        if (!this.f1908a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1908a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!C0768a.m2407a(this.f1909b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(DriveFile.MODE_READ_ONLY);
                this.f1909b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
