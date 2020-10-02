package androidx.loader.p026b;

import android.content.Context;
import androidx.core.p019e.C0788a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.loader.b.b */
/* compiled from: Loader */
public class C0997b<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    C0999b<D> mListener;
    C0998a<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    /* renamed from: androidx.loader.b.b$a */
    /* compiled from: Loader */
    public interface C0998a<D> {
        /* renamed from: a */
        void mo5092a(C0997b<D> bVar);
    }

    /* renamed from: androidx.loader.b.b$b */
    /* compiled from: Loader */
    public interface C0999b<D> {
        /* renamed from: a */
        void mo5030a(C0997b<D> bVar, D d);
    }

    public C0997b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        C0788a.m2491a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        C0998a<D> aVar = this.mOnLoadCanceledListener;
        if (aVar != null) {
            aVar.mo5092a(this);
        }
    }

    public void deliverResult(D d) {
        C0999b<D> bVar = this.mListener;
        if (bVar != null) {
            bVar.mo5030a(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        throw null;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public void registerListener(int i, C0999b<D> bVar) {
        if (this.mListener == null) {
            this.mListener = bVar;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(C0998a<D> aVar) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = aVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0788a.m2491a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(C0999b<D> bVar) {
        C0999b<D> bVar2 = this.mListener;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.mListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void unregisterOnLoadCanceledListener(C0998a<D> aVar) {
        C0998a<D> aVar2 = this.mOnLoadCanceledListener;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (aVar2 == aVar) {
            this.mOnLoadCanceledListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
