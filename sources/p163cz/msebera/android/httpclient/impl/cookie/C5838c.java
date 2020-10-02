package p163cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import p163cz.msebera.android.httpclient.cookie.C5689l;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.c */
/* compiled from: BasicClientCookie2 */
public class C5838c extends C5840d implements C5689l {
    private static final long serialVersionUID = -7744598295706617057L;

    /* renamed from: i */
    private int[] f15070i;

    /* renamed from: j */
    private boolean f15071j;

    public C5838c(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public int[] mo33123a() {
        return this.f15070i;
    }

    /* renamed from: b */
    public void mo33154b(boolean z) {
        this.f15071j = z;
    }

    public Object clone() throws CloneNotSupportedException {
        C5838c cVar = (C5838c) super.clone();
        int[] iArr = this.f15070i;
        if (iArr != null) {
            cVar.f15070i = (int[]) iArr.clone();
        }
        return cVar;
    }

    /* renamed from: e */
    public void mo33155e(String str) {
    }

    /* renamed from: a */
    public void mo33153a(int[] iArr) {
        this.f15070i = iArr;
    }

    /* renamed from: b */
    public boolean mo33125b(Date date) {
        return this.f15071j || super.mo33125b(date);
    }
}
