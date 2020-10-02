package androidx.loader.p025a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.p019e.C0788a;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0977m;
import androidx.lifecycle.C0978n;
import androidx.lifecycle.C0982q;
import androidx.lifecycle.C0983r;
import androidx.lifecycle.C0986s;
import androidx.loader.p025a.C0988a;
import androidx.loader.p026b.C0997b;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import p075d.p080b.C3205h;

/* renamed from: androidx.loader.a.b */
/* compiled from: LoaderManagerImpl */
class C0990b extends C0988a {

    /* renamed from: c */
    static boolean f2539c = false;

    /* renamed from: a */
    private final C0970h f2540a;

    /* renamed from: b */
    private final C0993c f2541b;

    /* renamed from: androidx.loader.a.b$c */
    /* compiled from: LoaderManagerImpl */
    static class C0993c extends C0982q {

        /* renamed from: d */
        private static final C0983r.C0984a f2551d = new C0994a();

        /* renamed from: b */
        private C3205h<C0991a> f2552b = new C3205h<>();

        /* renamed from: c */
        private boolean f2553c = false;

        /* renamed from: androidx.loader.a.b$c$a */
        /* compiled from: LoaderManagerImpl */
        static class C0994a implements C0983r.C0984a {
            C0994a() {
            }

            /* renamed from: a */
            public <T extends C0982q> T mo4916a(Class<T> cls) {
                return new C0993c();
            }
        }

        C0993c() {
        }

        /* renamed from: a */
        static C0993c m3528a(C0986s sVar) {
            return (C0993c) new C0983r(sVar, f2551d).mo5015a(C0993c.class);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4905b() {
            super.mo4905b();
            int b = this.f2552b.mo18825b();
            for (int i = 0; i < b; i++) {
                this.f2552b.mo18832e(i).mo5029a(true);
            }
            this.f2552b.mo18823a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5042c() {
            this.f2553c = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5043d() {
            return this.f2553c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5044e() {
            int b = this.f2552b.mo18825b();
            for (int i = 0; i < b; i++) {
                this.f2552b.mo18832e(i).mo5033f();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5045f() {
            this.f2553c = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5040a(int i, C0991a aVar) {
            this.f2552b.mo18829c(i, aVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public <D> C0991a<D> mo5039a(int i) {
            return this.f2552b.mo18822a(i);
        }

        /* renamed from: a */
        public void mo5041a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2552b.mo18825b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f2552b.mo18825b(); i++) {
                    C0991a e = this.f2552b.mo18832e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2552b.mo18828c(i));
                    printWriter.print(": ");
                    printWriter.println(e.toString());
                    e.mo5031a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    C0990b(C0970h hVar, C0986s sVar) {
        this.f2540a = hVar;
        this.f2541b = C0993c.m3528a(sVar);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private <D> C0997b<D> m3510a(int i, Bundle bundle, C0988a.C0989a<D> aVar, C0997b<D> bVar) {
        try {
            this.f2541b.mo5045f();
            C0997b<D> onCreateLoader = aVar.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                C0991a aVar2 = new C0991a(i, bundle, onCreateLoader, bVar);
                if (f2539c) {
                    "  Created new loader " + aVar2;
                }
                this.f2541b.mo5040a(i, aVar2);
                this.f2541b.mo5042c();
                return aVar2.mo5028a(this.f2540a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f2541b.mo5042c();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0788a.m2491a(this.f2540a, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: androidx.loader.a.b$b */
    /* compiled from: LoaderManagerImpl */
    static class C0992b<D> implements C0978n<D> {

        /* renamed from: a */
        private final C0997b<D> f2548a;

        /* renamed from: b */
        private final C0988a.C0989a<D> f2549b;

        /* renamed from: c */
        private boolean f2550c = false;

        C0992b(C0997b<D> bVar, C0988a.C0989a<D> aVar) {
            this.f2548a = bVar;
            this.f2549b = aVar;
        }

        /* renamed from: a */
        public void mo5003a(D d) {
            if (C0990b.f2539c) {
                "  onLoadFinished in " + this.f2548a + ": " + this.f2548a.dataToString(d);
            }
            this.f2549b.onLoadFinished(this.f2548a, d);
            this.f2550c = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5037b() {
            if (this.f2550c) {
                if (C0990b.f2539c) {
                    "  Resetting: " + this.f2548a;
                }
                this.f2549b.onLoaderReset(this.f2548a);
            }
        }

        public String toString() {
            return this.f2549b.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5036a() {
            return this.f2550c;
        }

        /* renamed from: a */
        public void mo5035a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2550c);
        }
    }

    /* renamed from: androidx.loader.a.b$a */
    /* compiled from: LoaderManagerImpl */
    public static class C0991a<D> extends C0977m<D> implements C0997b.C0999b<D> {

        /* renamed from: k */
        private final int f2542k;

        /* renamed from: l */
        private final Bundle f2543l;

        /* renamed from: m */
        private final C0997b<D> f2544m;

        /* renamed from: n */
        private C0970h f2545n;

        /* renamed from: o */
        private C0992b<D> f2546o;

        /* renamed from: p */
        private C0997b<D> f2547p;

        C0991a(int i, Bundle bundle, C0997b<D> bVar, C0997b<D> bVar2) {
            this.f2542k = i;
            this.f2543l = bundle;
            this.f2544m = bVar;
            this.f2547p = bVar2;
            bVar.registerListener(i, this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0997b<D> mo5028a(C0970h hVar, C0988a.C0989a<D> aVar) {
            C0992b<D> bVar = new C0992b<>(this.f2544m, aVar);
            mo4970a(hVar, bVar);
            C0992b<D> bVar2 = this.f2546o;
            if (bVar2 != null) {
                mo4971a(bVar2);
            }
            this.f2545n = hVar;
            this.f2546o = bVar;
            return this.f2544m;
        }

        /* renamed from: b */
        public void mo4973b(D d) {
            super.mo4973b(d);
            C0997b<D> bVar = this.f2547p;
            if (bVar != null) {
                bVar.reset();
                this.f2547p = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4975c() {
            if (C0990b.f2539c) {
                "  Starting: " + this;
            }
            this.f2544m.startLoading();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4976d() {
            if (C0990b.f2539c) {
                "  Stopping: " + this;
            }
            this.f2544m.stopLoading();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public C0997b<D> mo5032e() {
            return this.f2544m;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5033f() {
            C0970h hVar = this.f2545n;
            C0992b<D> bVar = this.f2546o;
            if (hVar != null && bVar != null) {
                super.mo4971a(bVar);
                mo4970a(hVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2542k);
            sb.append(" : ");
            C0788a.m2491a(this.f2544m, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public void mo4971a(C0978n<? super D> nVar) {
            super.mo4971a(nVar);
            this.f2545n = null;
            this.f2546o = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0997b<D> mo5029a(boolean z) {
            if (C0990b.f2539c) {
                "  Destroying: " + this;
            }
            this.f2544m.cancelLoad();
            this.f2544m.abandon();
            C0992b<D> bVar = this.f2546o;
            if (bVar != null) {
                mo4971a(bVar);
                if (z) {
                    bVar.mo5037b();
                }
            }
            this.f2544m.unregisterListener(this);
            if ((bVar == null || bVar.mo5036a()) && !z) {
                return this.f2544m;
            }
            this.f2544m.reset();
            return this.f2547p;
        }

        /* renamed from: a */
        public void mo5030a(C0997b<D> bVar, D d) {
            if (C0990b.f2539c) {
                "onLoadComplete: " + this;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo4973b(d);
                return;
            }
            if (C0990b.f2539c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo4972a(d);
        }

        /* renamed from: a */
        public void mo5031a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2542k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2543l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f2544m);
            C0997b<D> bVar = this.f2544m;
            bVar.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f2546o != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f2546o);
                C0992b<D> bVar2 = this.f2546o;
                bVar2.mo5035a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(mo5032e().dataToString(mo4968a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(mo4974b());
        }
    }

    /* renamed from: a */
    public <D> C0997b<D> mo5021a(int i, Bundle bundle, C0988a.C0989a<D> aVar) {
        if (this.f2541b.mo5043d()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C0991a a = this.f2541b.mo5039a(i);
            if (f2539c) {
                "initLoader in " + this + ": args=" + bundle;
            }
            if (a == null) {
                return m3510a(i, bundle, aVar, (C0997b) null);
            }
            if (f2539c) {
                "  Re-using existing loader " + a;
            }
            return a.mo5028a(this.f2540a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    /* renamed from: a */
    public void mo5022a() {
        this.f2541b.mo5044e();
    }

    @Deprecated
    /* renamed from: a */
    public void mo5023a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2541b.mo5041a(str, fileDescriptor, printWriter, strArr);
    }
}
