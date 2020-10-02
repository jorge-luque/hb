package p118io.presage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.drive.DriveFile;
import java.util.GregorianCalendar;
import p118io.presage.common.profig.schedule.ProfigAlarmReceiver;

/* renamed from: io.presage.p */
public final class C6570p implements C6572r {

    /* renamed from: a */
    public static final CamembertauCalvados f17130a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private AlarmManager f17131b;

    /* renamed from: c */
    private final Context f17132c;

    /* renamed from: io.presage.p$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6570p(Context context) {
        this.f17132c = context;
        Object systemService = context.getSystemService("alarm");
        if (systemService != null) {
            this.f17131b = (AlarmManager) systemService;
            return;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.AlarmManager");
    }

    /* renamed from: a */
    public final void mo35602a(long j) {
        PendingIntent a = m21559a(this.f17132c);
        this.f17131b.cancel(a);
        long timeInMillis = new GregorianCalendar().getTimeInMillis() + j;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f17131b.setExact(0, timeInMillis, a);
        } else {
            this.f17131b.set(0, timeInMillis, a);
        }
    }

    /* renamed from: a */
    public final void mo35601a() {
        PendingIntent a = m21559a(this.f17132c);
        Object systemService = this.f17132c.getSystemService("alarm");
        if (systemService != null) {
            ((AlarmManager) systemService).cancel(a);
            a.cancel();
            return;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.AlarmManager");
    }

    /* renamed from: a */
    private static PendingIntent m21559a(Context context) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1001, new Intent(context, ProfigAlarmReceiver.class), DriveFile.MODE_READ_ONLY);
        C6514hl.m21414a((Object) broadcast, "PendingIntent.getBroadca…tent.FLAG_CANCEL_CURRENT)");
        return broadcast;
    }
}
