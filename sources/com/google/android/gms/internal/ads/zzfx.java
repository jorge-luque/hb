package com.google.android.gms.internal.ads;

import com.loopj.android.http.C4250c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzfx {
    private static final String TAG = "zzfx";
    private final String className;
    private final String zzaau;
    private final int zzaav = 2;
    private volatile Method zzaaw = null;
    private final Class<?>[] zzaax;
    private CountDownLatch zzaay = new CountDownLatch(1);
    private final zzeo zzvp;

    public zzfx(zzeo zzeo, String str, String str2, Class<?>... clsArr) {
        this.zzvp = zzeo;
        this.className = str;
        this.zzaau = str2;
        this.zzaax = clsArr;
        zzeo.zzch().submit(new zzga(this));
    }

    private final String zzb(byte[] bArr, String str) throws zzdy, UnsupportedEncodingException {
        return new String(this.zzvp.zzcj().zza(bArr, str), C4250c.DEFAULT_CHARSET);
    }

    /* access modifiers changed from: private */
    public final void zzdb() {
        try {
            Class loadClass = this.zzvp.zzci().loadClass(zzb(this.zzvp.zzck(), this.className));
            if (loadClass != null) {
                this.zzaaw = loadClass.getMethod(zzb(this.zzvp.zzck(), this.zzaau), this.zzaax);
                if (this.zzaaw == null) {
                    this.zzaay.countDown();
                } else {
                    this.zzaay.countDown();
                }
            }
        } catch (zzdy unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzaay.countDown();
        }
    }

    public final Method zzdc() {
        if (this.zzaaw != null) {
            return this.zzaaw;
        }
        try {
            if (!this.zzaay.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzaaw;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
