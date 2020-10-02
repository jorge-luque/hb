package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
abstract class zzdpy<I, O, F, T> extends zzdqq<O> implements Runnable {
    @NullableDecl
    private zzdri<? extends I> zzhgj;
    @NullableDecl
    private F zzhha;

    zzdpy(zzdri<? extends I> zzdri, F f) {
        this.zzhgj = (zzdri) zzdoj.checkNotNull(zzdri);
        this.zzhha = zzdoj.checkNotNull(f);
    }

    static <I, O> zzdri<O> zza(zzdri<I> zzdri, zzdqj<? super I, ? extends O> zzdqj, Executor executor) {
        zzdoj.checkNotNull(executor);
        zzdqb zzdqb = new zzdqb(zzdri, zzdqj);
        zzdri.addListener(zzdqb, zzdrk.zza(executor, zzdqb));
        return zzdqb;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhgj);
        this.zzhgj = null;
        this.zzhha = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzdri<? extends I> zzdri = this.zzhgj;
        F f = this.zzhha;
        String pendingToString = super.pendingToString();
        if (zzdri != null) {
            String valueOf = String.valueOf(zzdri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }

    public final void run() {
        zzdri<? extends I> zzdri = this.zzhgj;
        F f = this.zzhha;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzdri == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzhgj = null;
            if (zzdri.isCancelled()) {
                setFuture(zzdri);
                return;
            }
            try {
                try {
                    Object zzc = zzc(f, zzdqw.zza(zzdri));
                    this.zzhha = null;
                    setResult(zzc);
                } catch (Throwable th) {
                    this.zzhha = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzc(F f, @NullableDecl I i) throws Exception;

    static <I, O> zzdri<O> zza(zzdri<I> zzdri, zzdnx<? super I, ? extends O> zzdnx, Executor executor) {
        zzdoj.checkNotNull(zzdnx);
        zzdqa zzdqa = new zzdqa(zzdri, zzdnx);
        zzdri.addListener(zzdqa, zzdrk.zza(executor, zzdqa));
        return zzdqa;
    }
}
