package com.google.protobuf;

import com.loopj.android.http.C4250c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.p */
/* compiled from: Internal */
public final class C4038p {

    /* renamed from: a */
    static final Charset f10852a = Charset.forName(C4250c.DEFAULT_CHARSET);

    /* renamed from: b */
    public static final byte[] f10853b;

    /* renamed from: com.google.protobuf.p$a */
    /* compiled from: Internal */
    public interface C4039a extends C4046h<Boolean> {
        /* renamed from: c */
        C4039a mo28095c(int i);
    }

    /* renamed from: com.google.protobuf.p$b */
    /* compiled from: Internal */
    public interface C4040b extends C4046h<Double> {
        /* renamed from: c */
        C4040b mo28095c(int i);
    }

    /* renamed from: com.google.protobuf.p$c */
    /* compiled from: Internal */
    public interface C4041c {
    }

    /* renamed from: com.google.protobuf.p$d */
    /* compiled from: Internal */
    public interface C4042d<T extends C4041c> {
    }

    /* renamed from: com.google.protobuf.p$e */
    /* compiled from: Internal */
    public interface C4043e extends C4046h<Float> {
        /* renamed from: c */
        C4043e mo28095c(int i);
    }

    /* renamed from: com.google.protobuf.p$f */
    /* compiled from: Internal */
    public interface C4044f extends C4046h<Integer> {
        /* renamed from: c */
        C4044f mo28095c(int i);
    }

    /* renamed from: com.google.protobuf.p$g */
    /* compiled from: Internal */
    public interface C4045g extends C4046h<Long> {
        /* renamed from: c */
        C4045g mo28095c(int i);
    }

    /* renamed from: com.google.protobuf.p$h */
    /* compiled from: Internal */
    public interface C4046h<E> extends List<E>, RandomAccess {
        /* renamed from: c */
        C4046h<E> mo28095c(int i);

        /* renamed from: t */
        void mo28079t();

        /* renamed from: v */
        boolean mo28080v();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f10853b = bArr;
        ByteBuffer.wrap(bArr);
        C4013g.m13365a(f10853b);
    }

    /* renamed from: a */
    static int m13498a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: a */
    public static int m13499a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: a */
    public static int m13500a(boolean z) {
        return z ? 1231 : 1237;
    }
}
