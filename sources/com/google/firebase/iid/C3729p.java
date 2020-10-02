package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.iid.p */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
abstract class C3729p<T> {

    /* renamed from: a */
    final int f10358a;

    /* renamed from: b */
    final TaskCompletionSource<T> f10359b = new TaskCompletionSource<>();

    /* renamed from: c */
    final int f10360c;

    /* renamed from: d */
    final Bundle f10361d;

    C3729p(int i, int i2, Bundle bundle) {
        this.f10358a = i;
        this.f10360c = i2;
        this.f10361d = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo27354a(Bundle bundle);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27359a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            sb.toString();
        }
        this.f10359b.setResult(t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo27355a();

    public String toString() {
        int i = this.f10360c;
        int i2 = this.f10358a;
        boolean a = mo27355a();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(a);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27358a(zzam zzam) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzam);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            sb.toString();
        }
        this.f10359b.setException(zzam);
    }
}
