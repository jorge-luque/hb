package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.core.app.i */
/* compiled from: NotificationCompat */
public class C0725i {

    /* renamed from: androidx.core.app.i$a */
    /* compiled from: NotificationCompat */
    public static class C0726a {

        /* renamed from: a */
        final Bundle f1807a;

        /* renamed from: b */
        private IconCompat f1808b;

        /* renamed from: c */
        private final C0743m[] f1809c;

        /* renamed from: d */
        private final C0743m[] f1810d;

        /* renamed from: e */
        private boolean f1811e;

        /* renamed from: f */
        boolean f1812f;

        /* renamed from: g */
        private final int f1813g;

        /* renamed from: h */
        private final boolean f1814h;
        @Deprecated

        /* renamed from: i */
        public int f1815i;

        /* renamed from: j */
        public CharSequence f1816j;

        /* renamed from: k */
        public PendingIntent f1817k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public C0726a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.m2792a((Resources) null, "", i) : null, charSequence, pendingIntent);
        }

        /* renamed from: a */
        public PendingIntent mo3901a() {
            return this.f1817k;
        }

        /* renamed from: b */
        public boolean mo3902b() {
            return this.f1811e;
        }

        /* renamed from: c */
        public C0743m[] mo3903c() {
            return this.f1810d;
        }

        /* renamed from: d */
        public Bundle mo3904d() {
            return this.f1807a;
        }

        @Deprecated
        /* renamed from: e */
        public int mo3905e() {
            return this.f1815i;
        }

        /* renamed from: f */
        public IconCompat mo3906f() {
            int i;
            if (this.f1808b == null && (i = this.f1815i) != 0) {
                this.f1808b = IconCompat.m2792a((Resources) null, "", i);
            }
            return this.f1808b;
        }

        /* renamed from: g */
        public C0743m[] mo3907g() {
            return this.f1809c;
        }

        /* renamed from: h */
        public int mo3908h() {
            return this.f1813g;
        }

        /* renamed from: i */
        public boolean mo3909i() {
            return this.f1812f;
        }

        /* renamed from: j */
        public CharSequence mo3910j() {
            return this.f1816j;
        }

        /* renamed from: k */
        public boolean mo3911k() {
            return this.f1814h;
        }

        public C0726a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (C0743m[]) null, (C0743m[]) null, true, 0, true, false);
        }

        C0726a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C0743m[] mVarArr, C0743m[] mVarArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f1812f = true;
            this.f1808b = iconCompat;
            if (iconCompat != null && iconCompat.mo4223c() == 2) {
                this.f1815i = iconCompat.mo4220a();
            }
            this.f1816j = C0730e.m2264d(charSequence);
            this.f1817k = pendingIntent;
            this.f1807a = bundle == null ? new Bundle() : bundle;
            this.f1809c = mVarArr;
            this.f1810d = mVarArr2;
            this.f1811e = z;
            this.f1813g = i;
            this.f1812f = z2;
            this.f1814h = z3;
        }
    }

    /* renamed from: androidx.core.app.i$c */
    /* compiled from: NotificationCompat */
    public static class C0728c extends C0733h {

        /* renamed from: e */
        private CharSequence f1821e;

        /* renamed from: a */
        public C0728c mo3916a(CharSequence charSequence) {
            this.f1821e = C0730e.m2264d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo3914a(C0724h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(hVar.mo3900a()).setBigContentTitle(this.f1867b).bigText(this.f1821e);
                if (this.f1869d) {
                    bigText.setSummaryText(this.f1868c);
                }
            }
        }
    }

    /* renamed from: androidx.core.app.i$d */
    /* compiled from: NotificationCompat */
    public static final class C0729d {
        /* renamed from: a */
        public static Notification.BubbleMetadata m2260a(C0729d dVar) {
            if (dVar == null) {
                return null;
            }
            new Notification.BubbleMetadata.Builder();
            dVar.mo3917a();
            throw null;
        }

        /* renamed from: a */
        public boolean mo3917a() {
            throw null;
        }
    }

    /* renamed from: androidx.core.app.i$e */
    /* compiled from: NotificationCompat */
    public static class C0730e {

        /* renamed from: A */
        String f1822A;

        /* renamed from: B */
        Bundle f1823B;

        /* renamed from: C */
        int f1824C;

        /* renamed from: D */
        int f1825D;

        /* renamed from: E */
        Notification f1826E;

        /* renamed from: F */
        RemoteViews f1827F;

        /* renamed from: G */
        RemoteViews f1828G;

        /* renamed from: H */
        RemoteViews f1829H;

        /* renamed from: I */
        String f1830I;

        /* renamed from: J */
        int f1831J;

        /* renamed from: K */
        String f1832K;

        /* renamed from: L */
        long f1833L;

        /* renamed from: M */
        int f1834M;

        /* renamed from: N */
        boolean f1835N;

        /* renamed from: O */
        C0729d f1836O;

        /* renamed from: P */
        Notification f1837P;
        @Deprecated

        /* renamed from: Q */
        public ArrayList<String> f1838Q;

        /* renamed from: a */
        public Context f1839a;

        /* renamed from: b */
        public ArrayList<C0726a> f1840b;

        /* renamed from: c */
        ArrayList<C0726a> f1841c;

        /* renamed from: d */
        CharSequence f1842d;

        /* renamed from: e */
        CharSequence f1843e;

        /* renamed from: f */
        PendingIntent f1844f;

        /* renamed from: g */
        PendingIntent f1845g;

        /* renamed from: h */
        RemoteViews f1846h;

        /* renamed from: i */
        Bitmap f1847i;

        /* renamed from: j */
        CharSequence f1848j;

        /* renamed from: k */
        int f1849k;

        /* renamed from: l */
        int f1850l;

        /* renamed from: m */
        boolean f1851m;

        /* renamed from: n */
        boolean f1852n;

        /* renamed from: o */
        C0733h f1853o;

        /* renamed from: p */
        CharSequence f1854p;

        /* renamed from: q */
        CharSequence[] f1855q;

        /* renamed from: r */
        int f1856r;

        /* renamed from: s */
        int f1857s;

        /* renamed from: t */
        boolean f1858t;

        /* renamed from: u */
        String f1859u;

        /* renamed from: v */
        boolean f1860v;

        /* renamed from: w */
        String f1861w;

        /* renamed from: x */
        boolean f1862x;

        /* renamed from: y */
        boolean f1863y;

        /* renamed from: z */
        boolean f1864z;

        public C0730e(Context context, String str) {
            this.f1840b = new ArrayList<>();
            this.f1841c = new ArrayList<>();
            this.f1851m = true;
            this.f1862x = false;
            this.f1824C = 0;
            this.f1825D = 0;
            this.f1831J = 0;
            this.f1834M = 0;
            Notification notification = new Notification();
            this.f1837P = notification;
            this.f1839a = context;
            this.f1830I = str;
            notification.when = System.currentTimeMillis();
            this.f1837P.audioStreamType = -1;
            this.f1850l = 0;
            this.f1838Q = new ArrayList<>();
            this.f1835N = true;
        }

        /* renamed from: a */
        public C0730e mo3922a(long j) {
            this.f1837P.when = j;
            return this;
        }

        /* renamed from: b */
        public C0730e mo3936b(CharSequence charSequence) {
            this.f1842d = m2264d(charSequence);
            return this;
        }

        /* renamed from: c */
        public C0730e mo3940c(CharSequence charSequence) {
            this.f1837P.tickerText = m2264d(charSequence);
            return this;
        }

        /* renamed from: d */
        public C0730e mo3942d(int i) {
            this.f1849k = i;
            return this;
        }

        /* renamed from: e */
        public C0730e mo3945e(boolean z) {
            this.f1851m = z;
            return this;
        }

        /* renamed from: f */
        public C0730e mo3946f(int i) {
            this.f1837P.icon = i;
            return this;
        }

        /* renamed from: g */
        public C0730e mo3947g(int i) {
            this.f1825D = i;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3929a(CharSequence charSequence) {
            this.f1843e = m2264d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0730e mo3935b(PendingIntent pendingIntent) {
            this.f1837P.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: c */
        public C0730e mo3941c(boolean z) {
            this.f1862x = z;
            return this;
        }

        /* renamed from: d */
        public C0730e mo3943d(boolean z) {
            m2262a(8, z);
            return this;
        }

        /* renamed from: e */
        public C0730e mo3944e(int i) {
            this.f1850l = i;
            return this;
        }

        /* renamed from: b */
        private Bitmap m2263b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f1839a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d);
            Double.isNaN(max);
            double d2 = d / max;
            double d3 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d3);
            Double.isNaN(max2);
            double min = Math.min(d2, d3 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        /* renamed from: d */
        protected static CharSequence m2264d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: a */
        public C0730e mo3926a(RemoteViews remoteViews) {
            this.f1837P.contentView = remoteViews;
            return this;
        }

        /* renamed from: c */
        public C0730e mo3939c(int i) {
            this.f1834M = i;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3923a(PendingIntent pendingIntent) {
            this.f1844f = pendingIntent;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3924a(Bitmap bitmap) {
            this.f1847i = m2263b(bitmap);
            return this;
        }

        /* renamed from: a */
        public C0730e mo3925a(Uri uri) {
            Notification notification = this.f1837P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* renamed from: a */
        public C0730e mo3932a(long[] jArr) {
            this.f1837P.vibrate = jArr;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3920a(int i, int i2, int i3) {
            Notification notification = this.f1837P;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            int i4 = (i2 == 0 || i3 == 0) ? 0 : 1;
            Notification notification2 = this.f1837P;
            notification2.flags = i4 | (notification2.flags & -2);
            return this;
        }

        /* renamed from: b */
        public C0730e mo3934b(int i) {
            Notification notification = this.f1837P;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @Deprecated
        public C0730e(Context context) {
            this(context, (String) null);
        }

        /* renamed from: a */
        public C0730e mo3931a(boolean z) {
            m2262a(16, z);
            return this;
        }

        /* renamed from: b */
        public C0730e mo3937b(String str) {
            this.f1859u = str;
            return this;
        }

        /* renamed from: a */
        private void m2262a(int i, boolean z) {
            if (z) {
                Notification notification = this.f1837P;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.f1837P;
            notification2.flags = (i ^ -1) & notification2.flags;
        }

        /* renamed from: b */
        public C0730e mo3938b(boolean z) {
            this.f1860v = z;
            return this;
        }

        /* renamed from: b */
        public Bundle mo3933b() {
            if (this.f1823B == null) {
                this.f1823B = new Bundle();
            }
            return this.f1823B;
        }

        /* renamed from: a */
        public C0730e mo3921a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1840b.add(new C0726a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public C0730e mo3928a(C0733h hVar) {
            if (this.f1853o != hVar) {
                this.f1853o = hVar;
                if (hVar != null) {
                    hVar.mo3952a(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public C0730e mo3919a(int i) {
            this.f1824C = i;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3930a(String str) {
            this.f1830I = str;
            return this;
        }

        /* renamed from: a */
        public C0730e mo3927a(C0731f fVar) {
            fVar.mo3948a(this);
            return this;
        }

        /* renamed from: a */
        public Notification mo3918a() {
            return new C0734j(this).mo3956b();
        }
    }

    /* renamed from: androidx.core.app.i$f */
    /* compiled from: NotificationCompat */
    public interface C0731f {
        /* renamed from: a */
        C0730e mo3948a(C0730e eVar);
    }

    /* renamed from: androidx.core.app.i$g */
    /* compiled from: NotificationCompat */
    public static class C0732g extends C0733h {

        /* renamed from: e */
        private ArrayList<CharSequence> f1865e = new ArrayList<>();

        /* renamed from: a */
        public C0732g mo3949a(CharSequence charSequence) {
            this.f1865e.add(C0730e.m2264d(charSequence));
            return this;
        }

        /* renamed from: b */
        public C0732g mo3950b(CharSequence charSequence) {
            this.f1867b = C0730e.m2264d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo3914a(C0724h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(hVar.mo3900a()).setBigContentTitle(this.f1867b);
                if (this.f1869d) {
                    bigContentTitle.setSummaryText(this.f1868c);
                }
                Iterator<CharSequence> it = this.f1865e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }
    }

    /* renamed from: androidx.core.app.i$h */
    /* compiled from: NotificationCompat */
    public static abstract class C0733h {

        /* renamed from: a */
        protected C0730e f1866a;

        /* renamed from: b */
        CharSequence f1867b;

        /* renamed from: c */
        CharSequence f1868c;

        /* renamed from: d */
        boolean f1869d = false;

        /* renamed from: a */
        public void mo3951a(Bundle bundle) {
        }

        /* renamed from: a */
        public abstract void mo3914a(C0724h hVar);

        /* renamed from: a */
        public void mo3952a(C0730e eVar) {
            if (this.f1866a != eVar) {
                this.f1866a = eVar;
                if (eVar != null) {
                    eVar.mo3928a(this);
                }
            }
        }

        /* renamed from: b */
        public RemoteViews mo3953b(C0724h hVar) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews mo3954c(C0724h hVar) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews mo3955d(C0724h hVar) {
            return null;
        }
    }

    /* renamed from: a */
    public static Bundle m2241a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return C0735k.m2311a(notification);
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m2242b(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            if ((notification.flags & 512) != 0) {
                return true;
            }
            return false;
        } else if (i >= 19) {
            return notification.extras.getBoolean("android.support.isGroupSummary");
        } else {
            if (i >= 16) {
                return C0735k.m2311a(notification).getBoolean("android.support.isGroupSummary");
            }
            return false;
        }
    }

    /* renamed from: androidx.core.app.i$b */
    /* compiled from: NotificationCompat */
    public static class C0727b extends C0733h {

        /* renamed from: e */
        private Bitmap f1818e;

        /* renamed from: f */
        private Bitmap f1819f;

        /* renamed from: g */
        private boolean f1820g;

        /* renamed from: a */
        public C0727b mo3913a(CharSequence charSequence) {
            this.f1868c = C0730e.m2264d(charSequence);
            this.f1869d = true;
            return this;
        }

        /* renamed from: b */
        public C0727b mo3915b(Bitmap bitmap) {
            this.f1818e = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0727b mo3912a(Bitmap bitmap) {
            this.f1819f = bitmap;
            this.f1820g = true;
            return this;
        }

        /* renamed from: a */
        public void mo3914a(C0724h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(hVar.mo3900a()).setBigContentTitle(this.f1867b).bigPicture(this.f1818e);
                if (this.f1820g) {
                    bigPicture.bigLargeIcon(this.f1819f);
                }
                if (this.f1869d) {
                    bigPicture.setSummaryText(this.f1868c);
                }
            }
        }
    }
}
