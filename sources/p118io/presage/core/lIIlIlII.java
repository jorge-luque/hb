package p118io.presage.core;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import java.io.ByteArrayInputStream;
import p118io.presage.core.llIllllI;

/* renamed from: io.presage.core.lIIlIlII */
public class lIIlIlII {
    public static String IIIIIIII = C6356t0.IIIIIIII;
    public static String IIIIIIIl = C6356t0.IIIIIIIl;
    public static String IIIIIIlI = C6356t0.IIIIIIlI;

    public static NotificationChannel IIIIIIII(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        String str = IIIIIIII;
        String str2 = IIIIIIIl;
        String str3 = IIIIIIlI;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel == null) {
            notificationChannel = new NotificationChannel(str, str2, 1);
            notificationChannel.setDescription(str3);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationChannel.setLockscreenVisibility(-1);
        return notificationChannel;
    }

    public static void IIIIIIII(Context context, int i, IIllllII iIllllII, boolean z, llIllllI.IIIIIIIl iIIIIIIl) {
        if (i == 0) {
            C6378y2 IIIIIIII2 = C6378y2.IIIIIIII(context);
            if (IIIIIIII2.IIIIIIIl == null) {
                llIllllI llilllli = new llIllllI();
                Context context2 = IIIIIIII2.IIIIIIII;
                C6366v2 v2Var = new C6366v2(IIIIIIII2, iIIIIIIl);
                try {
                    new llIllllI.IIIIIIlI(context2, v2Var).IIIIIIII(iIllllII, z, new Void[0]);
                } catch (IIlllIII e) {
                    v2Var.IIIIIIII((Exception) e);
                }
            } else {
                if (z) {
                    IIIIlIll.IIIIIIII((IIlllIll) iIllllII);
                }
                if (iIIIIIIl != null) {
                    iIIIIIIl.IIIIIIII(IIIIIIII2.IIIIIIIl);
                }
            }
        } else if (i == 1) {
            C6378y2 IIIIIIII3 = C6378y2.IIIIIIII(context);
            if (IIIIIIII3.IIIIIIlI == null) {
                new llIllllI().IIIIIIII(iIllllII, z, new ByteArrayInputStream(C6362u2.IIIIIIII), true, new C6370w2(IIIIIIII3, iIIIIIIl));
                return;
            }
            if (z) {
                IIIIlIll.IIIIIIII((IIlllIll) iIllllII);
            }
            if (iIIIIIIl != null) {
                iIIIIIIl.IIIIIIII(IIIIIIII3.IIIIIIlI);
            }
        } else if (i == 2) {
            C6378y2 IIIIIIII4 = C6378y2.IIIIIIII(context);
            if (IIIIIIII4.IIIIIIll == null) {
                new llIllllI().IIIIIIII(iIllllII, z, new ByteArrayInputStream(C6382z2.IIIIIIII), true, new C6374x2(IIIIIIII4, iIIIIIIl));
                return;
            }
            if (z) {
                IIIIlIll.IIIIIIII((IIlllIll) iIllllII);
            }
            if (iIIIIIIl != null) {
                iIIIIIIl.IIIIIIII(IIIIIIII4.IIIIIIll);
            }
        } else if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII((Exception) new IllegalArgumentException());
        }
    }
}
