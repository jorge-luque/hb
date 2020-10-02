package p118io.presage.core.receiver;

import admost.sdk.base.AdMost;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.drive.DriveFile;
import p118io.presage.core.C6306g2;
import p118io.presage.core.IIIIlIll;

/* renamed from: io.presage.core.receiver.AlarmReceiver */
public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt("c133dd6f", AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN);
        IIIIlIll.IIIIIIII(context.getApplicationContext(), "df77b6b3", bundle);
        Context applicationContext = context.getApplicationContext();
        if (C6306g2.IIIIIIll == null) {
            C6306g2.IIIIIIll = new C6306g2(applicationContext);
        }
        C6306g2 g2Var = C6306g2.IIIIIIll;
        if (g2Var.IIIIIIll().getBoolean("3ea3f980", false)) {
            g2Var.IIIIIIlI();
            try {
                PendingIntent broadcast = PendingIntent.getBroadcast(g2Var.IIIIIIII, 0, new Intent(g2Var.IIIIIIII, AlarmReceiver.class), DriveFile.MODE_READ_ONLY);
                AlarmManager alarmManager = (AlarmManager) g2Var.IIIIIIII.getSystemService("alarm");
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(3, SystemClock.elapsedRealtime() + g2Var.IIIIIIlI(), broadcast);
                } else {
                    alarmManager.set(3, SystemClock.elapsedRealtime() + g2Var.IIIIIIlI(), broadcast);
                }
            } catch (Exception unused) {
            }
        }
    }
}
