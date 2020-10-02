package p118io.presage.core;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import p118io.presage.core.C6369w1;

/* renamed from: io.presage.core.y1 */
public class C6377y1 {
    public LinkedList<C6369w1> IIIIIIII = new LinkedList<>();

    public C6377y1 IIIIIIII(int i) {
        Object obj;
        LinkedList<C6369w1> linkedList = this.IIIIIIII;
        if (i == 0) {
            obj = new C6381z1();
        } else if (i == 1) {
            obj = new C6282a2();
        } else {
            throw new NoSuchAlgorithmException();
        }
        linkedList.add(obj);
        return this;
    }

    public String IIIIIIII(String str) {
        if (str == null) {
            return null;
        }
        return IIIIIIII(str.getBytes());
    }

    public String IIIIIIII(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Iterator it = this.IIIIIIII.iterator();
        while (it.hasNext()) {
            C6369w1 w1Var = (C6369w1) it.next();
            if (bArr == null) {
                bArr = null;
            } else {
                Iterator it2 = w1Var.IIIIIIII.iterator();
                while (it2.hasNext()) {
                    C6369w1.IIIIIIII iiiiiiii = (C6369w1.IIIIIIII) it2.next();
                    if (bArr == null) {
                        bArr = null;
                    } else if (iiiiiiii != null) {
                        int i = iiiiiiii.IIIIIIIl;
                        if (i == 0) {
                            byte[] bArr2 = new byte[(bArr.length + iiiiiiii.IIIIIIII.length)];
                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                            byte[] bArr3 = iiiiiiii.IIIIIIII;
                            System.arraycopy(bArr3, 0, bArr2, bArr.length, bArr3.length);
                            bArr = bArr2;
                        } else if (i == 1) {
                            byte[] bArr4 = iiiiiiii.IIIIIIII;
                            byte[] bArr5 = new byte[(bArr4.length + bArr.length)];
                            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
                            System.arraycopy(bArr, 0, bArr5, iiiiiiii.IIIIIIII.length, bArr.length);
                            bArr = bArr5;
                        }
                    }
                }
            }
            bArr = w1Var.IIIIIIII(bArr).getBytes();
        }
        return new String(bArr);
    }

    public C6377y1 IIIIIIII(byte[] bArr, int i) {
        C6369w1 last = this.IIIIIIII.getLast();
        last.IIIIIIII.add(new C6369w1.IIIIIIII(last, bArr, i));
        return this;
    }
}
