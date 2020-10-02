package p118io.presage.core;

import android.accounts.NetworkErrorException;
import android.util.MalformedJsonException;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.presage.core.lIIIlIII;

/* renamed from: io.presage.core.lIlIIIll */
public class lIlIIIll implements lIIIlIII.IIIIIIII {
    public final /* synthetic */ lIlIIlII IIIIIIII;

    public lIlIIIll(lIlIIlII liliilii) {
        this.IIIIIIII = liliilii;
    }

    public void IIIIIIII(lIIIlllI liiillli, lIIlIIII liiliiii) {
        lIlIIlII liliilii;
        MalformedJsonException malformedJsonException;
        lIlIIlII liliilii2;
        int i = liiliiii.IIIIIIII;
        int i2 = this.IIIIIIII.IIIIIlII;
        int i3 = liiliiii.IIIIIIII;
        if (i3 == 200) {
            try {
                String str = new String(liiliiii.IIIIIIIl);
                if (!str.isEmpty()) {
                    lIIllIll IIIIIIII2 = new lIlIIIIl(this.IIIIIIII.IIIIIIIl).IIIIIIII(new JSONObject(str));
                    if (IIIIIIII2 != null) {
                        new JSONObject(new String(liiliiii.IIIIIIIl)).toString(3);
                        String str2 = IIIIIIII2.IIIIIIII;
                        if (str2 == null || str2.isEmpty() || !IIIIIIII2.IIIIIIII.equals(this.IIIIIIII.IIIIIIll.IIIIIIIl())) {
                            this.IIIIIIII.IIIIIIII(this.IIIIIIII, new IllegalArgumentException(IIIIIIII2.IIIIIIII), 1);
                            return;
                        } else {
                            this.IIIIIIII.IIIIIIII(this.IIIIIIII, IIIIIIII2);
                            return;
                        }
                    } else {
                        liliilii = this.IIIIIIII;
                        liliilii2 = this.IIIIIIII;
                        malformedJsonException = new MalformedJsonException(str);
                    }
                } else {
                    liliilii = this.IIIIIIII;
                    liliilii2 = this.IIIIIIII;
                    malformedJsonException = new MalformedJsonException(str);
                }
                liliilii.IIIIIIII(liliilii2, malformedJsonException, 1);
            } catch (JSONException e) {
                lIlIIlII liliilii3 = this.IIIIIIII;
                liliilii3.IIIIIIII(liliilii3, new MalformedJsonException(e.getMessage()), 1);
            } catch (Exception e2) {
                lIlIIlII liliilii4 = this.IIIIIIII;
                liliilii4.IIIIIIII(liliilii4, e2, 1);
            }
        } else if (i3 < 500 || i3 >= 600) {
            lIlIIlII liliilii5 = this.IIIIIIII;
            liliilii5.IIIIIIII(liliilii5, new lIIIllIl(String.valueOf(liiliiii.IIIIIIII)), 1);
        } else {
            lIlIIlII liliilii6 = this.IIIIIIII;
            liliilii6.IIIIIIII(liliilii6, new NetworkErrorException(String.valueOf(i3)), 0);
        }
    }

    public void IIIIIIII(lIIIlllI liiillli, Exception exc, int i) {
        lIlIIlII liliilii = this.IIIIIIII;
        liliilii.IIIIIIII(liliilii, exc, i);
    }
}
