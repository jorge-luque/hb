package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.HashSet;

/* renamed from: io.presage.core.IlIIllIl */
public class IlIIllIl extends IIllllll {
    public static final String IIIlIIII = C6291d.IIIIIIII;
    public static final String IIIlIIIl = C6291d.IIIIIIIl;
    public static final String IIIlIIlI = lllIIIll.IIIIIIII;
    public static final String IIIlIIll = lllIIIll.IIIIIIIl;
    public static final String IIIlIlII = C6291d.IIIIIIlI;
    public static final String IIIlIlIl = C6291d.IIIIIIll;
    public static final String IIIlIllI = C6291d.IIIIIlII;
    public static final String IIIlIlll = C6291d.IIIIIlIl;
    public static final String IIIllIII = C6291d.IIIIIllI;
    public static final String IIIllIIl = C6291d.IIIIIlll;
    public SharedPreferences IIIIlllI;
    public SharedPreferences.Editor IIIIllll;

    public IlIIllIl(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 19;
    }

    public Object IIIIIIll() {
        return IlIIllIl.class;
    }

    public void IIIIIlIl() {
        if (Build.VERSION.SDK_INT < 23 && IIIIlIll.IIIIIIII(this.IIIIIIlI, IIIlIIIl)) {
            HashSet hashSet = new HashSet();
            Uri parse = Uri.parse(IIIlIIII);
            if (this.IIIIlllI == null) {
                this.IIIIlllI = this.IIIIIIlI.getSharedPreferences(IIIlIIll, 0);
            }
            long j = this.IIIIlllI.getLong(IIIlIIlI, 0);
            String[] strArr = {IIIlIlII, IIIlIlIl, IIIlIllI, IIIlIlll, IIIllIII};
            Cursor query = this.IIIIIIlI.getContentResolver().query(parse, strArr, IIIlIlll + ">?", new String[]{Long.toString(j)}, IIIlIlll + " " + IIIllIIl);
            if (query != null) {
                query.moveToFirst();
                long j2 = 0;
                while (!query.isAfterLast()) {
                    IIIllIlI iIIllIlI = new IIIllIlI(query.getString(query.getColumnIndex(IIIlIlII)), query.getString(query.getColumnIndex(IIIlIlIl)), query.getString(query.getColumnIndex(IIIlIllI)), query.getString(query.getColumnIndex(IIIlIlll)), query.getString(query.getColumnIndex(IIIllIII)));
                    long j3 = query.getLong(query.getColumnIndex(IIIlIlll));
                    iIIllIlI.IIIIIlIl = j2 > 0 ? j2 - j3 : 0;
                    j2 = query.getLong(query.getColumnIndex(IIIlIlll));
                    hashSet.add(iIIllIlI);
                    j = Math.max(j, j3);
                    query.moveToNext();
                }
                query.close();
                if (this.IIIIllll == null) {
                    if (this.IIIIlllI == null) {
                        this.IIIIlllI = this.IIIIIIlI.getSharedPreferences(IIIlIIll, 0);
                    }
                    this.IIIIllll = this.IIIIlllI.edit();
                }
                this.IIIIllll.putLong(IIIlIIlI, j).apply();
            }
            if (!hashSet.isEmpty()) {
                IIIIIIII((IIIlIIlI) new IIIllIll(C6325l1.IIIIIIII(), hashSet));
            }
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
