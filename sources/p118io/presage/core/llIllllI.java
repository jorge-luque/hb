package p118io.presage.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import java.io.InputStream;

/* renamed from: io.presage.core.llIllllI */
public class llIllllI {

    /* renamed from: io.presage.core.llIllllI$IIIIIIII */
    public class IIIIIIII extends IIlllIlI<Void, Boolean> {
        public InputStream IIIIIIIl;
        public boolean IIIIIIlI;
        public Bitmap IIIIIIll;
        public Exception IIIIIlII;
        public IIIIIIIl IIIIIlIl;

        public IIIIIIII(InputStream inputStream, boolean z, IIIIIIIl iIIIIIIl) {
            this.IIIIIIIl = inputStream;
            this.IIIIIIlI = z;
            this.IIIIIlIl = iIIIIIIl;
        }

        public Object IIIIIIII(Object[] objArr) {
            boolean z;
            Void[] voidArr = (Void[]) objArr;
            try {
                this.IIIIIIll = BitmapFactory.decodeStream(this.IIIIIIIl);
                if (this.IIIIIIlI) {
                    this.IIIIIIIl.close();
                }
                z = true;
            } catch (Exception e) {
                this.IIIIIlII = e;
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public void IIIIIIII(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                llIllllI.this.IIIIIIII(this.IIIIIlIl, this.IIIIIIll);
            } else {
                llIllllI.this.IIIIIIII(this.IIIIIlIl, this.IIIIIlII);
            }
        }
    }

    /* renamed from: io.presage.core.llIllllI$IIIIIIIl */
    public interface IIIIIIIl {
        void IIIIIIII(Bitmap bitmap);

        void IIIIIIII(Exception exc);
    }

    /* renamed from: io.presage.core.llIllllI$IIIIIIlI */
    public class IIIIIIlI extends IIlllIlI<Void, Boolean> {
        public Context IIIIIIIl;
        public Bitmap IIIIIIlI;
        public Exception IIIIIIll;
        public IIIIIIIl IIIIIlII;

        public IIIIIIlI(Context context, IIIIIIIl iIIIIIIl) {
            this.IIIIIIIl = context;
            this.IIIIIlII = iIIIIIIl;
        }

        public Object IIIIIIII(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            try {
                Drawable applicationIcon = this.IIIIIIIl.getPackageManager().getApplicationIcon(this.IIIIIIIl.getPackageName());
                if (Build.VERSION.SDK_INT >= 26 && (applicationIcon instanceof AdaptiveIconDrawable)) {
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{((AdaptiveIconDrawable) applicationIcon).getBackground(), ((AdaptiveIconDrawable) applicationIcon).getForeground()});
                    this.IIIIIIlI = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.IIIIIIlI);
                    layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    layerDrawable.draw(canvas);
                } else if (Build.VERSION.SDK_INT < 21 || !(applicationIcon instanceof VectorDrawable)) {
                    this.IIIIIIlI = ((BitmapDrawable) applicationIcon).getBitmap();
                } else {
                    this.IIIIIIlI = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(this.IIIIIIlI);
                    applicationIcon.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
                    applicationIcon.draw(canvas2);
                }
                return true;
            } catch (Exception e) {
                this.IIIIIIll = e;
                return false;
            }
        }

        public void IIIIIIII(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                llIllllI.this.IIIIIIII(this.IIIIIlII, this.IIIIIIlI);
            } else {
                llIllllI.this.IIIIIIII(this.IIIIIlII, this.IIIIIIll);
            }
        }
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, InputStream inputStream, boolean z2, IIIIIIIl iIIIIIIl) {
        try {
            new IIIIIIII(inputStream, z2, iIIIIIIl).IIIIIIII(iIllllII, z, new Void[0]);
        } catch (IIlllIII e) {
            if (iIIIIIIl != null) {
                iIIIIIIl.IIIIIIII((Exception) e);
            }
        }
    }

    public final void IIIIIIII(IIIIIIIl iIIIIIIl, Bitmap bitmap) {
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(bitmap);
        }
    }

    public final void IIIIIIII(IIIIIIIl iIIIIIIl, Exception exc) {
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(exc);
        }
    }
}
