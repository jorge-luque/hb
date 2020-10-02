package p118io.presage.core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: io.presage.core.llllIlII */
public class llllIlII {
    public byte[] IIIIIIII;
    public byte[] IIIIIIIl;

    public llllIlII(String str, String str2) {
        this.IIIIIIII = str.getBytes();
        this.IIIIIIIl = str2.getBytes();
    }

    public byte[] IIIIIIII() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C6345q1());
        byte[] bArr = this.IIIIIIIl;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            byte[] IIIIIIlI = ((C6357t1) it.next()).IIIIIIlI(bArr);
            bArr = Arrays.copyOf(IIIIIIlI, IIIIIIlI.length);
        }
        return bArr;
    }

    public byte[] IIIIIIIl() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C6345q1());
        byte[] bArr = this.IIIIIIII;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            byte[] IIIIIIlI = ((C6357t1) it.next()).IIIIIIlI(bArr);
            bArr = Arrays.copyOf(IIIIIIlI, IIIIIIlI.length);
        }
        return new C6377y1().IIIIIIII(1).IIIIIIII(new C6353s1().IIIIIIII(2).IIIIIIII(1).IIIIIIlI(String.valueOf(bArr.length).getBytes()).IIIIIIII(this.IIIIIIII)).getBytes();
    }
}
