package p118io.presage.core;

import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.util.SparseArray;
import java.util.ArrayList;

/* renamed from: io.presage.core.IlIllIII */
public class IlIllIII extends IIllllll {
    public static final String IIIlIIII = C6300f0.IIIIIIII;
    public static final String IIIlIIIl = C6300f0.IIIIIIIl;
    public static final String IIIlIIlI = lllIlIlI.IIIIIIII;
    public static final String IIIlIIll = lllIlIlI.IIIIIIIl;
    public static SparseArray<String> IIIlIlII;
    public SharedPreferences IIIIlllI;
    public SharedPreferences.Editor IIIIllll;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        IIIlIlII = sparseArray;
        sparseArray.put(1, IIIlIIII);
        IIIlIlII.put(2, IIIlIIIl);
    }

    public IlIllIII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 24;
    }

    public Object IIIIIIll() {
        return IlIllIII.class;
    }

    public void IIIIIlIl() {
        if (Build.VERSION.SDK_INT >= 21 && IIIIlIIl()) {
            if (this.IIIIlllI == null) {
                this.IIIIlllI = this.IIIIIIlI.getSharedPreferences(IIIlIIlI, 0);
            }
            long j = this.IIIIlllI.getLong(IIIlIIll, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j != 0) {
                UsageEvents queryEvents = ((UsageStatsManager) this.IIIIIIlI.getSystemService("usagestats")).queryEvents(j, currentTimeMillis);
                UsageEvents.Event event = new UsageEvents.Event();
                ArrayList arrayList = new ArrayList();
                while (queryEvents.hasNextEvent()) {
                    queryEvents.getNextEvent(event);
                    if (IIIlIlII.get(event.getEventType()) != null) {
                        arrayList.add(new IIlIlIll(event.getPackageName(), IIIlIlII.get(event.getEventType()), event.getClassName(), event.getTimeStamp()));
                    }
                }
                IIIIIIII((IIIlIIlI) new IIlIllII(C6325l1.IIIIIIII(), arrayList));
            }
            if (this.IIIIllll == null) {
                if (this.IIIIlllI == null) {
                    this.IIIIlllI = this.IIIIIIlI.getSharedPreferences(IIIlIIlI, 0);
                }
                this.IIIIllll = this.IIIIlllI.edit();
            }
            this.IIIIllll.putLong(IIIlIIll, currentTimeMillis).apply();
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }

    public final boolean IIIIlIIl() {
        int checkOpNoThrow = ((AppOpsManager) this.IIIIIIlI.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), this.IIIIIIlI.getPackageName());
        return checkOpNoThrow != 3 ? checkOpNoThrow == 0 : this.IIIIIIlI.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0;
    }
}
