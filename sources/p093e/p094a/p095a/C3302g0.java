package p093e.p094a.p095a;

import android.util.Log;
import java.util.Arrays;

/* renamed from: e.a.a.g0 */
/* compiled from: Logger */
public class C3302g0 implements C3364y {

    /* renamed from: d */
    private static String f9218d = "Error formating log message: %s, with params: %s";

    /* renamed from: a */
    private C3300f0 f9219a;

    /* renamed from: b */
    private boolean f9220b = false;

    /* renamed from: c */
    private boolean f9221c = false;

    public C3302g0() {
        mo19019a(C3300f0.INFO, false);
    }

    /* renamed from: a */
    public void mo19019a(C3300f0 f0Var, boolean z) {
        if (!this.f9220b) {
            this.f9219a = f0Var;
            this.f9221c = z;
        }
    }

    /* renamed from: b */
    public void mo19021b(String str, Object... objArr) {
        if (!this.f9221c && this.f9219a.f9190a <= 5) {
            try {
                Log.w("Adjust", C3268a1.m10834a(str, objArr));
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: c */
    public void mo19022c(String str, Object... objArr) {
        if (!this.f9221c && this.f9219a.f9190a <= 6) {
            try {
                Log.e("Adjust", C3268a1.m10834a(str, objArr));
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: d */
    public void mo19023d(String str, Object... objArr) {
        if (!this.f9221c && this.f9219a.f9190a <= 3) {
            try {
                C3268a1.m10834a(str, objArr);
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: e */
    public void mo19024e(String str, Object... objArr) {
        if (!this.f9221c && this.f9219a.f9190a <= 2) {
            try {
                C3268a1.m10834a(str, objArr);
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: f */
    public void mo19025f(String str, Object... objArr) {
        if (!this.f9221c && this.f9219a.f9190a <= 4) {
            try {
                C3268a1.m10834a(str, objArr);
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: a */
    public void mo19020a(String str, Object... objArr) {
        if (this.f9219a.f9190a <= 5) {
            try {
                Log.w("Adjust", C3268a1.m10834a(str, objArr));
            } catch (Exception unused) {
                Log.e("Adjust", C3268a1.m10834a(f9218d, str, Arrays.toString(objArr)));
            }
        }
    }

    /* renamed from: a */
    public void mo19018a() {
        this.f9220b = true;
    }
}
