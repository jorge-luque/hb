package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.f */
/* compiled from: BasicHeaderValueFormatter */
public class C5736f {

    /* renamed from: a */
    public static final C5736f f14810a = new C5736f();

    static {
        new C5736f();
    }

    /* renamed from: a */
    public C5889d mo33322a(C5889d dVar, C5696e eVar, boolean z) {
        C5886a.m18894a(eVar, "Header element");
        int a = mo33319a(eVar);
        if (dVar == null) {
            dVar = new C5889d(a);
        } else {
            dVar.mo33667a(a);
        }
        dVar.mo33670a(eVar.getName());
        String value = eVar.getValue();
        if (value != null) {
            dVar.mo33666a('=');
            mo33325a(dVar, value, z);
        }
        int a2 = eVar.mo33176a();
        if (a2 > 0) {
            for (int i = 0; i < a2; i++) {
                dVar.mo33670a("; ");
                mo33323a(dVar, eVar.mo33177a(i), z);
            }
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33327b(char c) {
        return "\"\\".indexOf(c) >= 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33319a(C5696e eVar) {
        if (eVar == null) {
            return 0;
        }
        int length = eVar.getName().length();
        String value = eVar.getValue();
        if (value != null) {
            length += value.length() + 3;
        }
        int a = eVar.mo33176a();
        if (a > 0) {
            for (int i = 0; i < a; i++) {
                length += mo33320a(eVar.mo33177a(i)) + 2;
            }
        }
        return length;
    }

    /* renamed from: a */
    public C5889d mo33324a(C5889d dVar, C5906u[] uVarArr, boolean z) {
        C5886a.m18894a(uVarArr, "Header parameter array");
        int a = mo33321a(uVarArr);
        if (dVar == null) {
            dVar = new C5889d(a);
        } else {
            dVar.mo33667a(a);
        }
        for (int i = 0; i < uVarArr.length; i++) {
            if (i > 0) {
                dVar.mo33670a("; ");
            }
            mo33323a(dVar, uVarArr[i], z);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33321a(C5906u[] uVarArr) {
        if (uVarArr == null || uVarArr.length < 1) {
            return 0;
        }
        int length = (uVarArr.length - 1) * 2;
        for (C5906u a : uVarArr) {
            length += mo33320a(a);
        }
        return length;
    }

    /* renamed from: a */
    public C5889d mo33323a(C5889d dVar, C5906u uVar, boolean z) {
        C5886a.m18894a(uVar, "Name / value pair");
        int a = mo33320a(uVar);
        if (dVar == null) {
            dVar = new C5889d(a);
        } else {
            dVar.mo33667a(a);
        }
        dVar.mo33670a(uVar.getName());
        String value = uVar.getValue();
        if (value != null) {
            dVar.mo33666a('=');
            mo33325a(dVar, value, z);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33320a(C5906u uVar) {
        if (uVar == null) {
            return 0;
        }
        int length = uVar.getName().length();
        String value = uVar.getValue();
        return value != null ? length + value.length() + 3 : length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33325a(C5889d dVar, String str, boolean z) {
        if (!z) {
            for (int i = 0; i < str.length() && !z; i++) {
                z = mo33326a(str.charAt(i));
            }
        }
        if (z) {
            dVar.mo33666a('\"');
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (mo33327b(charAt)) {
                dVar.mo33666a('\\');
            }
            dVar.mo33666a(charAt);
        }
        if (z) {
            dVar.mo33666a('\"');
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33326a(char c) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(c) >= 0;
    }
}
