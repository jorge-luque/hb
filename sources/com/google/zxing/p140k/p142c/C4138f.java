package com.google.zxing.p140k.p142c;

import com.google.zxing.p140k.p141b.C4127a;
import com.google.zxing.p140k.p141b.C4128b;
import com.google.zxing.p140k.p141b.C4129c;

/* renamed from: com.google.zxing.k.c.f */
/* compiled from: QRCode */
public final class C4138f {

    /* renamed from: a */
    private C4128b f11096a;

    /* renamed from: b */
    private C4127a f11097b;

    /* renamed from: c */
    private C4129c f11098c;

    /* renamed from: d */
    private int f11099d = -1;

    /* renamed from: e */
    private C4133b f11100e;

    /* renamed from: b */
    public static boolean m13860b(int i) {
        return i >= 0 && i < 8;
    }

    /* renamed from: a */
    public C4133b mo28417a() {
        return this.f11100e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f11096a);
        sb.append("\n ecLevel: ");
        sb.append(this.f11097b);
        sb.append("\n version: ");
        sb.append(this.f11098c);
        sb.append("\n maskPattern: ");
        sb.append(this.f11099d);
        if (this.f11100e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f11100e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo28420a(C4128b bVar) {
        this.f11096a = bVar;
    }

    /* renamed from: a */
    public void mo28419a(C4127a aVar) {
        this.f11097b = aVar;
    }

    /* renamed from: a */
    public void mo28421a(C4129c cVar) {
        this.f11098c = cVar;
    }

    /* renamed from: a */
    public void mo28418a(int i) {
        this.f11099d = i;
    }

    /* renamed from: a */
    public void mo28422a(C4133b bVar) {
        this.f11100e = bVar;
    }
}
