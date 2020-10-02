package p118io.presage.core;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import p118io.presage.core.llIllllI;

/* renamed from: io.presage.core.lIIlIllI */
public class lIIlIllI implements llIllllI.IIIIIIIl {
    public final /* synthetic */ lIIlIlll IIIIIIII;

    public lIIlIllI(lIIlIlll liililll) {
        this.IIIIIIII = liililll;
    }

    public void IIIIIIII(Bitmap bitmap) {
        this.IIIIIIII.IIIIIlII = System.currentTimeMillis();
        long j = this.IIIIIIII.IIIIIlII;
        lIIlIlll liililll = this.IIIIIIII;
        Context context = liililll.IIIIIIII;
        lIIlIIll liiliill = liililll.IIIIIIlI;
        String str = liiliill.IIIIIIlI;
        String str2 = liiliill.IIIIIIll;
        NotificationChannel IIIIIIII2 = lIIlIlII.IIIIIIII(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Notification.Builder builder = new Notification.Builder(context);
        if (str != null && !str.isEmpty()) {
            builder.setContentTitle(str);
        }
        if (str2 != null && !str.isEmpty()) {
            builder.setContentText(str2);
        }
        if (bitmap != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setSmallIcon(Icon.createWithBitmap(bitmap));
            } else {
                builder.setLargeIcon(bitmap);
            }
        }
        builder.setOngoing(false);
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setCategory("service");
            builder.setPriority(-2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId(IIIIIIII2.getId());
        }
        notificationManager.notify(879824, Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification());
    }

    public void IIIIIIII(Exception exc) {
    }
}
