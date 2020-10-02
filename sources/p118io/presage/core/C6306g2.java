package p118io.presage.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.android.gms.drive.DriveFile;
import p118io.presage.core.receiver.AlarmReceiver;

/* renamed from: io.presage.core.g2 */
public class C6306g2 {
    public static C6306g2 IIIIIIll;
    public Context IIIIIIII;
    public SharedPreferences IIIIIIIl;
    public SharedPreferences.Editor IIIIIIlI;

    public C6306g2(Context context) {
        this.IIIIIIII = context;
    }

    public void IIIIIIII() {
        try {
            Intent intent = new Intent(this.IIIIIIII, AlarmReceiver.class);
            if (PendingIntent.getBroadcast(this.IIIIIIII, 0, intent, DriveFile.MODE_WRITE_ONLY) != null) {
                ((AlarmManager) this.IIIIIIII.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this.IIIIIIII, 0, intent, 0));
            }
        } catch (Exception unused) {
        }
    }

    public void IIIIIIII(long j, boolean z) {
        IIIIIIIl().putLong("84f4675c", j * 1000);
        if (z) {
            IIIIIIIl().apply();
        }
    }

    public final SharedPreferences.Editor IIIIIIIl() {
        if (this.IIIIIIlI == null) {
            this.IIIIIIlI = IIIIIIll().edit();
        }
        return this.IIIIIIlI;
    }

    public long IIIIIIlI() {
        return IIIIIIll().getLong("84f4675c", 0);
    }

    public final SharedPreferences IIIIIIll() {
        if (this.IIIIIIIl == null) {
            this.IIIIIIIl = this.IIIIIIII.getSharedPreferences("3554edaf", 0);
        }
        return this.IIIIIIIl;
    }
}
