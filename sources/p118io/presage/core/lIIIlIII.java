package p118io.presage.core;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: io.presage.core.lIIIlIII */
public class lIIIlIII {
    public static final String IIIIIIII = lllllllI.IIIIIIII;
    public static final String IIIIIIIl = lllllllI.IIIIIIIl;

    /* renamed from: io.presage.core.lIIIlIII$IIIIIIII */
    public interface IIIIIIII {
        void IIIIIIII(lIIIlllI liiillli, lIIlIIII liiliiii);

        void IIIIIIII(lIIIlllI liiillli, Exception exc, int i);
    }

    public static /* synthetic */ void IIIIIIII(IIIIIIII iiiiiiii, lIIIlllI liiillli, Exception exc, int i) {
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(liiillli, exc, i);
        }
    }

    public static /* synthetic */ void IIIIIIII(IIIIIIII iiiiiiii, lIIIlllI liiillli, lIIlIIII liiliiii) {
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(liiillli, liiliiii);
        }
    }

    public static void IIIIIIII(IIllllII iIllllII, boolean z, lIIIlllI liiillli, IIIIIIII iiiiiiii) {
        lIIIllIl liiillil;
        lIIIlIll liiilill = new lIIIlIll();
        int i = 0;
        if (iIllllII != null) {
            try {
                new IIIIIIIl(liiilill, liiillli, iiiiiiii).IIIIIIII(iIllllII, z, new Void[0]);
            } catch (IIlllIII e) {
                if (z) {
                    IIIIlIll.IIIIIIII((IIlllIll) iIllllII);
                }
                liiillil = new lIIIllIl((Throwable) e);
                if (iiiiiiii == null) {
                }
            }
        } else {
            if (z) {
                IIIIlIll.IIIIIIII((IIlllIll) iIllllII);
            }
            liiillil = new lIIIllIl();
            i = 1;
            if (iiiiiiii == null) {
                return;
            }
            iiiiiiii.IIIIIIII(liiillli, liiillil, i);
        }
    }

    /* renamed from: io.presage.core.lIIIlIII$IIIIIIIl */
    public static class IIIIIIIl extends AsyncTask<Void, Void, Boolean> {
        public static final String IIIIlIIl = C6328m0.IIIIIIII;
        public static final String IIIIlIlI = C6328m0.IIIIIIIl;
        public lIIIlIll IIIIIIII;
        public lIIIlllI IIIIIIIl;
        public IIIIIIII IIIIIIlI;
        public int IIIIIIll;
        public HttpURLConnection IIIIIlII;
        public lIIlIIII IIIIIlIl;
        public Exception IIIIIllI;
        public IIllllII IIIIIlll;
        public boolean IIIIlIII;

        public IIIIIIIl(lIIIlIll liiilill, lIIIlllI liiillli, IIIIIIII iiiiiiii) {
            if (liiilill == null || liiillli == null) {
                lIIIlIII.IIIIIIII(iiiiiiii, liiillli, (Exception) new lIIIllIl(), 1);
            }
            this.IIIIIIII = liiilill;
            this.IIIIIIIl = liiillli;
            this.IIIIIIlI = iiiiiiii;
            this.IIIIIIll = 0;
        }

        public final void IIIIIIII() {
            OutputStream outputStream;
            lIIIlllI liiillli = this.IIIIIIIl;
            if (liiillli.IIIIIIlI != null) {
                lIIIllII liiillii = liiillli.IIIIIIll;
                if (liiillii == null || this.IIIIIlII == null) {
                    throw new lIIIllIl();
                }
                if (liiillii.IIIIIIII().containsKey(lIIIlIII.IIIIIIII)) {
                    lIIIllII liiillii2 = this.IIIIIIIl.IIIIIIll;
                    if (liiillii2.IIIIIIII.get(lIIIlIII.IIIIIIII).equals(lIIIlIII.IIIIIIIl)) {
                        outputStream = new GZIPOutputStream(this.IIIIIlII.getOutputStream());
                        IIIIlIll.IIIIIIII(this.IIIIIIIl.IIIIIIlI, outputStream, true, true);
                    }
                }
                outputStream = this.IIIIIlII.getOutputStream();
                IIIIlIll.IIIIIIII(this.IIIIIIIl.IIIIIIlI, outputStream, true, true);
            }
        }

        public final void IIIIIIIl() {
            lIIIllII liiillii;
            lIIIlllI liiillli = this.IIIIIIIl;
            if (liiillli == null || (liiillii = liiillli.IIIIIIll) == null || this.IIIIIlII == null) {
                throw new lIIIllIl();
            }
            for (Map.Entry next : liiillii.IIIIIIII().entrySet()) {
                this.IIIIIlII.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }

        public final HttpURLConnection IIIIIIlI() {
            String str;
            lIIIlllI liiillli = this.IIIIIIIl;
            if (liiillli == null || (str = liiillli.IIIIIIII) == null || liiillli.IIIIIIIl == null) {
                throw new lIIIllIl();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            this.IIIIIlII = httpURLConnection;
            httpURLConnection.setRequestProperty(IIIIlIIl, IIIIlIlI);
            this.IIIIIlII.setReadTimeout(this.IIIIIIII.IIIIIIII);
            this.IIIIIlII.setConnectTimeout(this.IIIIIIII.IIIIIIIl);
            this.IIIIIlII.setRequestMethod(this.IIIIIIIl.IIIIIIIl);
            if (this.IIIIIIIl.IIIIIIlI != null) {
                this.IIIIIlII.setDoOutput(true);
            }
            return this.IIIIIlII;
        }

        public Object doInBackground(Object[] objArr) {
            int responseCode;
            InputStream inputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            Void[] voidArr = (Void[]) objArr;
            try {
                this.IIIIIlII = IIIIIIlI();
                IIIIIIIl();
                IIIIIIII();
                int responseCode2 = this.IIIIIlII.getResponseCode();
                if (responseCode2 == -1) {
                    this.IIIIIllI = new lIIIllIl();
                    this.IIIIIIll = 0;
                    return false;
                }
                String headerField = this.IIIIIlII.getHeaderField(lIIIlIII.IIIIIIII);
                inputStream = (headerField == null || !headerField.toLowerCase().equals(lIIIlIII.IIIIIIIl)) ? this.IIIIIlII.getInputStream() : new GZIPInputStream(this.IIIIIlII.getInputStream());
                byteArrayOutputStream = new ByteArrayOutputStream();
                IIIIlIll.IIIIIIII(inputStream, byteArrayOutputStream, false, false);
                byteArrayOutputStream.close();
                inputStream.close();
                this.IIIIIlIl = new lIIlIIII(responseCode2, byteArrayOutputStream.toByteArray());
                return true;
            } catch (Exception e) {
                try {
                    if (!(this.IIIIIlII == null || (responseCode = this.IIIIIlII.getResponseCode()) == -1)) {
                        this.IIIIIlIl = new lIIlIIII(responseCode);
                        return true;
                    }
                } catch (IOException unused) {
                }
                this.IIIIIllI = e;
                this.IIIIIIll = 0;
                return false;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                inputStream.close();
                throw th;
            }
        }

        public void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            this.IIIIIlll.IIIIIIIl();
            if (this.IIIIlIII) {
                IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIlll);
            }
            if (bool.booleanValue()) {
                lIIIlIII.IIIIIIII(this.IIIIIIlI, this.IIIIIIIl, this.IIIIIlIl);
            } else {
                lIIIlIII.IIIIIIII(this.IIIIIIlI, this.IIIIIIIl, this.IIIIIllI, this.IIIIIIll);
            }
        }

        public AsyncTask<Void, Void, Boolean> IIIIIIII(IIllllII iIllllII, boolean z, Void... voidArr) {
            try {
                this.IIIIIlll = iIllllII;
                this.IIIIlIII = z;
                if (!iIllllII.IIIIIIII.isShutdown()) {
                    return super.executeOnExecutor(this.IIIIIlll, voidArr);
                }
                throw new IIlllIII();
            } catch (Exception e) {
                throw new IIlllIII(e);
            }
        }
    }
}
