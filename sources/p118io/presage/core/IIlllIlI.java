package p118io.presage.core;

import android.os.AsyncTask;

/* renamed from: io.presage.core.IIlllIlI */
public abstract class IIlllIlI<Params, Result> {
    public IIIIIIII IIIIIIII;

    /* renamed from: io.presage.core.IIlllIlI$IIIIIIII */
    public static class IIIIIIII<Params, Result> extends AsyncTask<Params, Void, Result> {
        public IIlllIlI<Params, Result> IIIIIIII;
        public IIllllII IIIIIIIl;
        public boolean IIIIIIlI;

        public IIIIIIII(IIlllIlI<Params, Result> iIlllIlI, IIllllII iIllllII, boolean z) {
            this.IIIIIIII = iIlllIlI;
            this.IIIIIIIl = iIllllII;
            this.IIIIIIlI = z;
        }

        public Result doInBackground(Params... paramsArr) {
            return this.IIIIIIII.IIIIIIII(paramsArr);
        }

        public void onPostExecute(Result result) {
            this.IIIIIIIl.IIIIIIIl();
            if (this.IIIIIIlI) {
                IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIIIl);
            }
            this.IIIIIIII.IIIIIIII(result);
        }
    }

    public abstract Result IIIIIIII(Params... paramsArr);

    public void IIIIIIII(IIllllII iIllllII, boolean z, Params... paramsArr) {
        try {
            if (!iIllllII.IIIIIIII.isShutdown()) {
                if (this.IIIIIIII == null) {
                    this.IIIIIIII = new IIIIIIII(this, iIllllII, z);
                }
                this.IIIIIIII.executeOnExecutor(iIllllII, paramsArr);
                return;
            }
            throw new IIlllIII();
        } catch (Exception e) {
            throw new IIlllIII(e);
        }
    }

    public abstract void IIIIIIII(Result result);
}
