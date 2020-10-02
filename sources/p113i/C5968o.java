package p113i;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: i.o */
/* compiled from: Dns */
public interface C5968o {

    /* renamed from: a */
    public static final C5968o f15253a = new C5969a();

    /* renamed from: i.o$a */
    /* compiled from: Dns */
    class C5969a implements C5968o {
        C5969a() {
        }

        /* renamed from: a */
        public List<InetAddress> mo33781a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            } else {
                throw new UnknownHostException("hostname == null");
            }
        }
    }

    /* renamed from: a */
    List<InetAddress> mo33781a(String str) throws UnknownHostException;
}
