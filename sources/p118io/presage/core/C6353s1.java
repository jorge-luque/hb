package p118io.presage.core;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: io.presage.core.s1 */
public class C6353s1 {
    public LinkedList<C6357t1> IIIIIIII = new LinkedList<>();

    public C6353s1 IIIIIIII(int i) {
        Object obj;
        LinkedList<C6357t1> linkedList = this.IIIIIIII;
        if (i == 0) {
            obj = new C6365v1();
        } else if (i == 1) {
            obj = new C6361u1();
        } else if (i == 2) {
            obj = new C6345q1();
        } else {
            throw new NoSuchAlgorithmException();
        }
        linkedList.add(obj);
        return this;
    }

    public byte[] IIIIIIII(byte[] bArr) {
        Iterator it = this.IIIIIIII.iterator();
        while (it.hasNext()) {
            byte[] IIIIIIlI = ((C6357t1) it.next()).IIIIIIlI(bArr);
            bArr = Arrays.copyOf(IIIIIIlI, IIIIIIlI.length);
        }
        return bArr;
    }

    public byte[] IIIIIIIl(byte[] bArr) {
        Iterator it = this.IIIIIIII.iterator();
        while (it.hasNext()) {
            byte[] IIIIIIIl = ((C6357t1) it.next()).IIIIIIIl(bArr);
            bArr = Arrays.copyOf(IIIIIIIl, IIIIIIIl.length);
        }
        return bArr;
    }

    public C6353s1 IIIIIIlI(byte[] bArr) {
        this.IIIIIIII.getLast().IIIIIIII(bArr);
        return this;
    }
}
