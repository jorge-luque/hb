package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.zxing.common.reedsolomon.c */
/* compiled from: ReedSolomonEncoder */
public final class C4066c {

    /* renamed from: a */
    private final C4064a f10915a;

    /* renamed from: b */
    private final List<C4065b> f10916b;

    public C4066c(C4064a aVar) {
        this.f10915a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f10916b = arrayList;
        arrayList.add(new C4065b(aVar, new int[]{1}));
    }

    /* renamed from: a */
    private C4065b m13554a(int i) {
        if (i >= this.f10916b.size()) {
            List<C4065b> list = this.f10916b;
            C4065b bVar = list.get(list.size() - 1);
            for (int size = this.f10916b.size(); size <= i; size++) {
                C4064a aVar = this.f10915a;
                bVar = bVar.mo28285c(new C4065b(aVar, new int[]{1, aVar.mo28272a((size - 1) + aVar.mo28271a())}));
                this.f10916b.add(bVar);
            }
        }
        return this.f10916b.get(i);
    }

    /* renamed from: a */
    public void mo28288a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                C4065b a = m13554a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a2 = new C4065b(this.f10915a, iArr2).mo28280a(i, 1).mo28284b(a)[1].mo28282a();
                int length2 = i - a2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + length2, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
