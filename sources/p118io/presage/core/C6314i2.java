package p118io.presage.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.drive.DriveFile;
import p118io.presage.core.receiver.AlarmReceiver;

/* renamed from: io.presage.core.i2 */
public class C6314i2 extends C6350r2 {
    public C6306g2 IIIIIIll;

    public C6314i2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
        if (C6306g2.IIIIIIll == null) {
            C6306g2.IIIIIIll = new C6306g2(context);
        }
        this.IIIIIIll = C6306g2.IIIIIIll;
        long j = 60;
        Object[] objArr2 = this.IIIIIIlI;
        if (objArr2 != null && objArr2.length >= 1 && objArr2[0] != null && (objArr2[0] instanceof Number) && ((Long) objArr2[0]).longValue() >= 15 && ((Long) this.IIIIIIlI[0]).longValue() <= 86400) {
            j = ((Long) this.IIIIIIlI[0]).longValue();
        }
        this.IIIIIIll.IIIIIIII(j, true);
    }

    public int IIIIIIII() {
        return 5;
    }

    public void IIIIIIIl() {
        this.IIIIIIll.IIIIIIII();
        C6306g2 g2Var = this.IIIIIIll;
        g2Var.IIIIIIIl().putBoolean("3ea3f980", false);
        g2Var.IIIIIIIl().apply();
    }

    public void IIIIIIlI() {
        C6306g2 g2Var = this.IIIIIIll;
        g2Var.IIIIIIIl().putBoolean("3ea3f980", true);
        g2Var.IIIIIIIl().apply();
        C6306g2 g2Var2 = this.IIIIIIll;
        if (g2Var2.IIIIIIll().getBoolean("3ea3f980", false)) {
            g2Var2.IIIIIIlI();
            try {
                Intent intent = new Intent(g2Var2.IIIIIIII, AlarmReceiver.class);
                if (PendingIntent.getBroadcast(g2Var2.IIIIIIII, 0, intent, DriveFile.MODE_WRITE_ONLY) == null) {
                    PendingIntent broadcast = PendingIntent.getBroadcast(g2Var2.IIIIIIII, 0, intent, 0);
                    AlarmManager alarmManager = (AlarmManager) g2Var2.IIIIIIII.getSystemService("alarm");
                    if (Build.VERSION.SDK_INT >= 19) {
                        alarmManager.setExact(3, SystemClock.elapsedRealtime() + g2Var2.IIIIIIlI(), broadcast);
                    } else {
                        alarmManager.set(3, SystemClock.elapsedRealtime() + g2Var2.IIIIIIlI(), broadcast);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
