package p118io.presage.core;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Arrays;

/* renamed from: io.presage.core.IlIIlIII */
public class IlIIlIII extends IIllllll {
    public IlIIlIII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 17;
    }

    public Object IIIIIIll() {
        return IlIIlIII.class;
    }

    @SuppressLint({"MissingPermission"})
    public void IIIIIlIl() {
        AccountManager accountManager;
        Account[] accounts;
        if (IIIIlIll.IIIIIIII(this.IIIIIIlI, "android.permission.GET_ACCOUNTS") && (accountManager = (AccountManager) this.IIIIIIlI.getSystemService("account")) != null && (accounts = accountManager.getAccounts()) != null && accounts.length > 0) {
            IIIIIIII((IIIlIIlI) new IIIlIIll(System.currentTimeMillis(), Arrays.asList(accounts)));
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
