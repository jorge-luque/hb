package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.p020f.C0797a;
import androidx.core.p020f.C0827h;
import androidx.core.p020f.C0828i;
import androidx.core.p020f.C0829j;
import androidx.core.p020f.C0831l;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0848u;
import androidx.core.p020f.p021c0.C0806b;
import androidx.core.p020f.p021c0.C0807c;
import androidx.core.p022os.C0864b;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.C1077a;
import androidx.recyclerview.widget.C1080b;
import androidx.recyclerview.widget.C1099e;
import androidx.recyclerview.widget.C1109i;
import androidx.recyclerview.widget.C1113l;
import androidx.recyclerview.widget.C1116m;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements C0828i, C0829j {

    /* renamed from: A0 */
    static final boolean f2663A0;

    /* renamed from: B0 */
    static final boolean f2664B0 = (Build.VERSION.SDK_INT >= 23);

    /* renamed from: C0 */
    static final boolean f2665C0 = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: D0 */
    static final boolean f2666D0 = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: E0 */
    private static final boolean f2667E0 = (Build.VERSION.SDK_INT <= 15);

    /* renamed from: F0 */
    private static final boolean f2668F0 = (Build.VERSION.SDK_INT <= 15);

    /* renamed from: G0 */
    private static final Class<?>[] f2669G0;

    /* renamed from: H0 */
    static final Interpolator f2670H0 = new C1038c();

    /* renamed from: z0 */
    private static final int[] f2671z0 = {16843830};

    /* renamed from: A */
    boolean f2672A;

    /* renamed from: B */
    private final AccessibilityManager f2673B;

    /* renamed from: C */
    private List<C1060q> f2674C;

    /* renamed from: D */
    boolean f2675D;

    /* renamed from: E */
    boolean f2676E;

    /* renamed from: F */
    private int f2677F;

    /* renamed from: G */
    private int f2678G;

    /* renamed from: H */
    private C1047k f2679H;

    /* renamed from: I */
    private EdgeEffect f2680I;

    /* renamed from: J */
    private EdgeEffect f2681J;

    /* renamed from: K */
    private EdgeEffect f2682K;

    /* renamed from: L */
    private EdgeEffect f2683L;

    /* renamed from: M */
    C1048l f2684M;

    /* renamed from: N */
    private int f2685N;

    /* renamed from: O */
    private int f2686O;

    /* renamed from: P */
    private VelocityTracker f2687P;

    /* renamed from: Q */
    private int f2688Q;

    /* renamed from: R */
    private int f2689R;

    /* renamed from: S */
    private int f2690S;

    /* renamed from: U */
    private int f2691U;

    /* renamed from: V */
    private int f2692V;

    /* renamed from: W */
    private C1061r f2693W;

    /* renamed from: a */
    private final C1068x f2694a;

    /* renamed from: a0 */
    private final int f2695a0;

    /* renamed from: b */
    final C1066v f2696b;

    /* renamed from: b0 */
    private final int f2697b0;

    /* renamed from: c */
    private SavedState f2698c;

    /* renamed from: c0 */
    private float f2699c0;

    /* renamed from: d */
    C1077a f2700d;

    /* renamed from: d0 */
    private float f2701d0;

    /* renamed from: e */
    C1080b f2702e;

    /* renamed from: e0 */
    private boolean f2703e0;

    /* renamed from: f */
    final C1116m f2704f;

    /* renamed from: f0 */
    final C1037b0 f2705f0;

    /* renamed from: g */
    boolean f2706g;

    /* renamed from: g0 */
    C1099e f2707g0;

    /* renamed from: h */
    final Runnable f2708h;

    /* renamed from: h0 */
    C1099e.C1101b f2709h0;

    /* renamed from: i */
    final Rect f2710i;

    /* renamed from: i0 */
    final C1070z f2711i0;

    /* renamed from: j */
    private final Rect f2712j;

    /* renamed from: j0 */
    private C1063t f2713j0;

    /* renamed from: k */
    final RectF f2714k;

    /* renamed from: k0 */
    private List<C1063t> f2715k0;

    /* renamed from: l */
    C1043g f2716l;

    /* renamed from: l0 */
    boolean f2717l0;

    /* renamed from: m */
    C1054o f2718m;

    /* renamed from: m0 */
    boolean f2719m0;

    /* renamed from: n */
    C1067w f2720n;

    /* renamed from: n0 */
    private C1048l.C1050b f2721n0;

    /* renamed from: o */
    final ArrayList<C1053n> f2722o;

    /* renamed from: o0 */
    boolean f2723o0;

    /* renamed from: p */
    private final ArrayList<C1062s> f2724p;

    /* renamed from: p0 */
    C1109i f2725p0;

    /* renamed from: q */
    private C1062s f2726q;

    /* renamed from: q0 */
    private C1046j f2727q0;

    /* renamed from: r */
    boolean f2728r;

    /* renamed from: r0 */
    private final int[] f2729r0;

    /* renamed from: s */
    boolean f2730s;

    /* renamed from: s0 */
    private C0831l f2731s0;

    /* renamed from: t */
    boolean f2732t;

    /* renamed from: t0 */
    private final int[] f2733t0;

    /* renamed from: u */
    boolean f2734u;

    /* renamed from: u0 */
    private final int[] f2735u0;

    /* renamed from: v */
    private int f2736v;

    /* renamed from: v0 */
    final int[] f2737v0;

    /* renamed from: w */
    boolean f2738w;

    /* renamed from: w0 */
    final List<C1039c0> f2739w0;

    /* renamed from: x */
    boolean f2740x;

    /* renamed from: x0 */
    private Runnable f2741x0;

    /* renamed from: y */
    private boolean f2742y;

    /* renamed from: y0 */
    private final C1116m.C1118b f2743y0;

    /* renamed from: z */
    private int f2744z;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    class C1034a implements Runnable {
        C1034a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2734u && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f2728r) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.f2740x) {
                    recyclerView2.f2738w = true;
                } else {
                    recyclerView2.mo5276b();
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a0 */
    public static abstract class C1035a0 {
        /* renamed from: a */
        public abstract View mo5390a(C1066v vVar, int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    class C1036b implements Runnable {
        C1036b() {
        }

        public void run() {
            C1048l lVar = RecyclerView.this.f2684M;
            if (lVar != null) {
                lVar.mo5526i();
            }
            RecyclerView.this.f2723o0 = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    static class C1038c implements Interpolator {
        C1038c() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c0 */
    public static abstract class C1039c0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        C1066v mScrapContainer = null;
        C1039c0 mShadowedHolder = null;
        C1039c0 mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public C1039c0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && C0839t.m2733v(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.mo5274b(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !C0839t.m2733v(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((C1059p) this.itemView.getLayoutParams()).f2793c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = C0839t.m2723l(this.itemView);
            }
            recyclerView.mo5272a(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.mo5272a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.m3774e(this);
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ -1));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(C1066v vVar, boolean z) {
            this.mScrapContainer = vVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.mo5677c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    class C1040d implements C1116m.C1118b {
        C1040d() {
        }

        /* renamed from: a */
        public void mo5439a(C1039c0 c0Var, C1048l.C1051c cVar, C1048l.C1051c cVar2) {
            RecyclerView.this.mo5257a(c0Var, cVar, cVar2);
        }

        /* renamed from: b */
        public void mo5440b(C1039c0 c0Var, C1048l.C1051c cVar, C1048l.C1051c cVar2) {
            RecyclerView.this.f2696b.mo5677c(c0Var);
            RecyclerView.this.mo5279b(c0Var, cVar, cVar2);
        }

        /* renamed from: c */
        public void mo5441c(C1039c0 c0Var, C1048l.C1051c cVar, C1048l.C1051c cVar2) {
            c0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2675D) {
                if (recyclerView.f2684M.mo5511a(c0Var, c0Var, cVar, cVar2)) {
                    RecyclerView.this.mo5380v();
                }
            } else if (recyclerView.f2684M.mo5519c(c0Var, cVar, cVar2)) {
                RecyclerView.this.mo5380v();
            }
        }

        /* renamed from: a */
        public void mo5438a(C1039c0 c0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2718m.mo5548a(c0Var.itemView, recyclerView.f2696b);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    class C1041e implements C1080b.C1082b {
        C1041e() {
        }

        /* renamed from: a */
        public int mo5442a() {
            return RecyclerView.this.getChildCount();
        }

        public void addView(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.mo5255a(view);
        }

        /* renamed from: b */
        public int mo5447b(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        /* renamed from: c */
        public void mo5451c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.mo5278b(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        /* renamed from: d */
        public void mo5452d(View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l != null) {
                l.onLeftHiddenState(RecyclerView.this);
            }
        }

        /* renamed from: a */
        public View mo5443a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        /* renamed from: b */
        public void mo5448b() {
            int a = mo5442a();
            for (int i = 0; i < a; i++) {
                View a2 = mo5443a(i);
                RecyclerView.this.mo5278b(a2);
                a2.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        /* renamed from: a */
        public void mo5445a(View view, int i, ViewGroup.LayoutParams layoutParams) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l != null) {
                if (l.isTmpDetached() || l.shouldIgnore()) {
                    l.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + l + RecyclerView.this.mo5335i());
                }
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        /* renamed from: c */
        public C1039c0 mo5450c(View view) {
            return RecyclerView.m3777l(view);
        }

        /* renamed from: b */
        public void mo5449b(int i) {
            C1039c0 l;
            View a = mo5443a(i);
            if (!(a == null || (l = RecyclerView.m3777l(a)) == null)) {
                if (!l.isTmpDetached() || l.shouldIgnore()) {
                    l.addFlags(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + l + RecyclerView.this.mo5335i());
                }
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        /* renamed from: a */
        public void mo5444a(View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l != null) {
                l.onEnteredHiddenState(RecyclerView.this);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    public static abstract class C1043g<VH extends C1039c0> {
        private boolean mHasStableIds = false;
        private final C1044h mObservable = new C1044h();

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            C0864b.m2832a("RV OnBindView");
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof C1059p) {
                ((C1059p) layoutParams).f2793c = true;
            }
            C0864b.m2831a();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                C0864b.m2832a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                C0864b.m2831a();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.mo5493a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.mo5494b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.mo5495b(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.mo5496c(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.mo5491a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.mo5495b(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.mo5496c(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.mo5497d(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.mo5497d(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(C1045i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(C1045i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.mo5492a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.mo5492a(i, i2, obj);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    static class C1044h extends Observable<C1045i> {
        C1044h() {
        }

        /* renamed from: a */
        public boolean mo5493a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: b */
        public void mo5494b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1045i) this.mObservers.get(size)).mo5498a();
            }
        }

        /* renamed from: c */
        public void mo5496c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1045i) this.mObservers.get(size)).mo5502b(i, i2);
            }
        }

        /* renamed from: d */
        public void mo5497d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1045i) this.mObservers.get(size)).mo5503c(i, i2);
            }
        }

        /* renamed from: a */
        public void mo5492a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1045i) this.mObservers.get(size)).mo5501a(i, i2, obj);
            }
        }

        /* renamed from: b */
        public void mo5495b(int i, int i2) {
            mo5492a(i, i2, (Object) null);
        }

        /* renamed from: a */
        public void mo5491a(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1045i) this.mObservers.get(size)).mo5500a(i, i2, 1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    public static abstract class C1045i {
        /* renamed from: a */
        public void mo5498a() {
        }

        /* renamed from: a */
        public void mo5499a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo5500a(int i, int i2, int i3) {
        }

        /* renamed from: a */
        public void mo5501a(int i, int i2, Object obj) {
            mo5499a(i, i2);
        }

        /* renamed from: b */
        public void mo5502b(int i, int i2) {
        }

        /* renamed from: c */
        public void mo5503c(int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    public interface C1046j {
        /* renamed from: a */
        int mo5504a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$k */
    public static class C1047k {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public EdgeEffect mo5505a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$l */
    public static abstract class C1048l {

        /* renamed from: a */
        private C1050b f2758a = null;

        /* renamed from: b */
        private ArrayList<C1049a> f2759b = new ArrayList<>();

        /* renamed from: c */
        private long f2760c = 120;

        /* renamed from: d */
        private long f2761d = 120;

        /* renamed from: e */
        private long f2762e = 250;

        /* renamed from: f */
        private long f2763f = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$a */
        public interface C1049a {
            /* renamed from: a */
            void mo5527a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$b */
        interface C1050b {
            /* renamed from: a */
            void mo5528a(C1039c0 c0Var);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$c */
        public static class C1051c {

            /* renamed from: a */
            public int f2764a;

            /* renamed from: b */
            public int f2765b;

            /* renamed from: a */
            public C1051c mo5529a(C1039c0 c0Var) {
                mo5530a(c0Var, 0);
                return this;
            }

            /* renamed from: a */
            public C1051c mo5530a(C1039c0 c0Var, int i) {
                View view = c0Var.itemView;
                this.f2764a = view.getLeft();
                this.f2765b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5509a(C1050b bVar) {
            this.f2758a = bVar;
        }

        /* renamed from: a */
        public abstract boolean mo5510a(C1039c0 c0Var);

        /* renamed from: a */
        public abstract boolean mo5511a(C1039c0 c0Var, C1039c0 c0Var2, C1051c cVar, C1051c cVar2);

        /* renamed from: a */
        public abstract boolean mo5512a(C1039c0 c0Var, C1051c cVar, C1051c cVar2);

        /* renamed from: b */
        public abstract void mo5514b();

        /* renamed from: b */
        public final void mo5515b(C1039c0 c0Var) {
            mo5521d(c0Var);
            C1050b bVar = this.f2758a;
            if (bVar != null) {
                bVar.mo5528a(c0Var);
            }
        }

        /* renamed from: b */
        public abstract boolean mo5516b(C1039c0 c0Var, C1051c cVar, C1051c cVar2);

        /* renamed from: c */
        public long mo5517c() {
            return this.f2760c;
        }

        /* renamed from: c */
        public abstract void mo5518c(C1039c0 c0Var);

        /* renamed from: c */
        public abstract boolean mo5519c(C1039c0 c0Var, C1051c cVar, C1051c cVar2);

        /* renamed from: d */
        public long mo5520d() {
            return this.f2763f;
        }

        /* renamed from: d */
        public void mo5521d(C1039c0 c0Var) {
        }

        /* renamed from: e */
        public long mo5522e() {
            return this.f2762e;
        }

        /* renamed from: f */
        public long mo5523f() {
            return this.f2761d;
        }

        /* renamed from: g */
        public abstract boolean mo5524g();

        /* renamed from: h */
        public C1051c mo5525h() {
            return new C1051c();
        }

        /* renamed from: i */
        public abstract void mo5526i();

        /* renamed from: e */
        static int m3916e(C1039c0 c0Var) {
            int i = c0Var.mFlags & 14;
            if (c0Var.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = c0Var.getOldPosition();
            int adapterPosition = c0Var.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        /* renamed from: a */
        public C1051c mo5507a(C1070z zVar, C1039c0 c0Var, int i, List<Object> list) {
            C1051c h = mo5525h();
            h.mo5529a(c0Var);
            return h;
        }

        /* renamed from: a */
        public C1051c mo5506a(C1070z zVar, C1039c0 c0Var) {
            C1051c h = mo5525h();
            h.mo5529a(c0Var);
            return h;
        }

        /* renamed from: a */
        public boolean mo5513a(C1039c0 c0Var, List<Object> list) {
            return mo5510a(c0Var);
        }

        /* renamed from: a */
        public final void mo5508a() {
            int size = this.f2759b.size();
            for (int i = 0; i < size; i++) {
                this.f2759b.get(i).mo5527a();
            }
            this.f2759b.clear();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$m */
    private class C1052m implements C1048l.C1050b {
        C1052m() {
        }

        /* renamed from: a */
        public void mo5528a(C1039c0 c0Var) {
            c0Var.setIsRecyclable(true);
            if (c0Var.mShadowedHolder != null && c0Var.mShadowingHolder == null) {
                c0Var.mShadowedHolder = null;
            }
            c0Var.mShadowingHolder = null;
            if (!c0Var.shouldBeKeptAsChild() && !RecyclerView.this.mo5343j(c0Var.itemView) && c0Var.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(c0Var.itemView, false);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$n */
    public static abstract class C1053n {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C1070z zVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1070z zVar) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1070z zVar) {
            getItemOffsets(rect, ((C1059p) view.getLayoutParams()).mo5633a(), recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    public static abstract class C1054o {

        /* renamed from: a */
        C1080b f2767a;

        /* renamed from: b */
        RecyclerView f2768b;

        /* renamed from: c */
        private final C1113l.C1115b f2769c = new C1055a();

        /* renamed from: d */
        private final C1113l.C1115b f2770d = new C1056b();

        /* renamed from: e */
        C1113l f2771e = new C1113l(this.f2769c);

        /* renamed from: f */
        C1113l f2772f = new C1113l(this.f2770d);

        /* renamed from: g */
        C1069y f2773g;

        /* renamed from: h */
        boolean f2774h = false;

        /* renamed from: i */
        boolean f2775i = false;

        /* renamed from: j */
        boolean f2776j = false;

        /* renamed from: k */
        private boolean f2777k = true;

        /* renamed from: l */
        private boolean f2778l = true;

        /* renamed from: m */
        int f2779m;

        /* renamed from: n */
        boolean f2780n;

        /* renamed from: o */
        private int f2781o;

        /* renamed from: p */
        private int f2782p;

        /* renamed from: q */
        private int f2783q;

        /* renamed from: r */
        private int f2784r;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$a */
        class C1055a implements C1113l.C1115b {
            C1055a() {
            }

            /* renamed from: a */
            public View mo5629a(int i) {
                return C1054o.this.mo5578c(i);
            }

            /* renamed from: b */
            public int mo5630b() {
                return C1054o.this.mo5619q() - C1054o.this.mo5616o();
            }

            /* renamed from: a */
            public int mo5627a() {
                return C1054o.this.mo5614n();
            }

            /* renamed from: b */
            public int mo5631b(View view) {
                return C1054o.this.mo5605i(view) + ((C1059p) view.getLayoutParams()).rightMargin;
            }

            /* renamed from: a */
            public int mo5628a(View view) {
                return C1054o.this.mo5595f(view) - ((C1059p) view.getLayoutParams()).leftMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$b */
        class C1056b implements C1113l.C1115b {
            C1056b() {
            }

            /* renamed from: a */
            public View mo5629a(int i) {
                return C1054o.this.mo5578c(i);
            }

            /* renamed from: b */
            public int mo5630b() {
                return C1054o.this.mo5602h() - C1054o.this.mo5612m();
            }

            /* renamed from: a */
            public int mo5627a() {
                return C1054o.this.mo5618p();
            }

            /* renamed from: a */
            public int mo5628a(View view) {
                return C1054o.this.mo5607j(view) - ((C1059p) view.getLayoutParams()).topMargin;
            }

            /* renamed from: b */
            public int mo5631b(View view) {
                return C1054o.this.mo5592e(view) + ((C1059p) view.getLayoutParams()).bottomMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$c */
        public interface C1057c {
            /* renamed from: a */
            void mo5632a(int i, int i2);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$d */
        public static class C1058d {

            /* renamed from: a */
            public int f2787a;

            /* renamed from: b */
            public int f2788b;

            /* renamed from: c */
            public boolean f2789c;

            /* renamed from: d */
            public boolean f2790d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public boolean mo5190A() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public void mo5537B() {
            C1069y yVar = this.f2773g;
            if (yVar != null) {
                yVar.mo5696d();
            }
        }

        /* renamed from: C */
        public boolean mo5151C() {
            return false;
        }

        /* renamed from: a */
        public int mo5152a(int i, C1066v vVar, C1070z zVar) {
            return 0;
        }

        /* renamed from: a */
        public int mo5200a(C1070z zVar) {
            return 0;
        }

        /* renamed from: a */
        public View mo5154a(View view, int i, C1066v vVar, C1070z zVar) {
            return null;
        }

        /* renamed from: a */
        public void mo5203a(int i, int i2, C1070z zVar, C1057c cVar) {
        }

        /* renamed from: a */
        public void mo5204a(int i, C1057c cVar) {
        }

        /* renamed from: a */
        public void mo5158a(Rect rect, int i, int i2) {
            mo5580c(m3943a(i, rect.width() + mo5614n() + mo5616o(), mo5610l()), m3943a(i2, rect.height() + mo5618p() + mo5612m(), mo5608k()));
        }

        /* renamed from: a */
        public void mo5205a(Parcelable parcelable) {
        }

        /* renamed from: a */
        public void mo5551a(C1043g gVar, C1043g gVar2) {
        }

        /* renamed from: a */
        public void mo5163a(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: a */
        public void mo5164a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: a */
        public boolean mo5210a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo5166a(C1059p pVar) {
            return pVar != null;
        }

        /* renamed from: a */
        public boolean mo5563a(C1066v vVar, C1070z zVar, View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: a */
        public boolean mo5568a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: b */
        public int mo5167b(int i, C1066v vVar, C1070z zVar) {
            return 0;
        }

        /* renamed from: b */
        public int mo5169b(C1070z zVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5570b(int i, int i2) {
            this.f2783q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.f2781o = mode;
            if (mode == 0 && !RecyclerView.f2664B0) {
                this.f2783q = 0;
            }
            this.f2784r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f2782p = mode2;
            if (mode2 == 0 && !RecyclerView.f2664B0) {
                this.f2784r = 0;
            }
        }

        /* renamed from: b */
        public void mo5575b(RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void mo5170b(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: b */
        public boolean mo5214b() {
            return false;
        }

        /* renamed from: c */
        public int mo5577c(C1066v vVar, C1070z zVar) {
            return 0;
        }

        /* renamed from: c */
        public int mo5172c(C1070z zVar) {
            return 0;
        }

        /* renamed from: c */
        public View mo5579c(View view) {
            View c;
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView == null || (c = recyclerView.mo5285c(view)) == null || this.f2767a.mo5809c(c)) {
                return null;
            }
            return c;
        }

        /* renamed from: c */
        public abstract C1059p mo5173c();

        @Deprecated
        /* renamed from: c */
        public void mo5583c(RecyclerView recyclerView) {
        }

        /* renamed from: c */
        public void mo5584c(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public int mo5585d() {
            return -1;
        }

        /* renamed from: d */
        public int mo5216d(C1070z zVar) {
            return 0;
        }

        /* renamed from: d */
        public View mo5587d(View view, int i) {
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5589d(int i, int i2) {
            int e = mo5591e();
            if (e == 0) {
                this.f2768b.mo5288c(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < e; i7++) {
                View c = mo5578c(i7);
                Rect rect = this.f2768b.f2710i;
                mo5573b(c, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.f2768b.f2710i.set(i5, i6, i3, i4);
            mo5158a(this.f2768b.f2710i, i, i2);
        }

        /* renamed from: d */
        public void mo5174d(RecyclerView recyclerView) {
        }

        /* renamed from: d */
        public boolean mo5590d(C1066v vVar, C1070z zVar) {
            return false;
        }

        /* renamed from: e */
        public int mo5175e(C1070z zVar) {
            return 0;
        }

        /* renamed from: e */
        public void mo5176e(C1066v vVar, C1070z zVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* renamed from: f */
        public int mo5178f(C1070z zVar) {
            return 0;
        }

        /* renamed from: f */
        public void mo5596f(int i) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5597f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2768b = null;
                this.f2767a = null;
                this.f2783q = 0;
                this.f2784r = 0;
            } else {
                this.f2768b = recyclerView;
                this.f2767a = recyclerView.f2702e;
                this.f2783q = recyclerView.getWidth();
                this.f2784r = recyclerView.getHeight();
            }
            this.f2781o = 1073741824;
            this.f2782p = 1073741824;
        }

        /* renamed from: g */
        public void mo5601g(int i) {
            if (mo5578c(i) != null) {
                this.f2767a.mo5812e(i);
            }
        }

        /* renamed from: g */
        public void mo5179g(C1070z zVar) {
        }

        /* renamed from: h */
        public int mo5602h() {
            return this.f2784r;
        }

        /* renamed from: i */
        public int mo5604i() {
            return this.f2782p;
        }

        /* renamed from: j */
        public int mo5606j() {
            return C0839t.m2725n(this.f2768b);
        }

        /* renamed from: k */
        public int mo5609k(View view) {
            return ((C1059p) view.getLayoutParams()).f2792b.left;
        }

        /* renamed from: l */
        public int mo5611l(View view) {
            return ((C1059p) view.getLayoutParams()).mo5633a();
        }

        /* renamed from: m */
        public int mo5612m() {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        /* renamed from: n */
        public int mo5614n() {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        /* renamed from: o */
        public void mo5617o(View view) {
            this.f2767a.mo5811d(view);
        }

        /* renamed from: p */
        public int mo5618p() {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* renamed from: q */
        public int mo5619q() {
            return this.f2783q;
        }

        /* renamed from: r */
        public int mo5620r() {
            return this.f2781o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public boolean mo5621s() {
            int e = mo5591e();
            for (int i = 0; i < e; i++) {
                ViewGroup.LayoutParams layoutParams = mo5578c(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: t */
        public boolean mo5622t() {
            return this.f2775i;
        }

        /* renamed from: u */
        public boolean mo5221u() {
            return this.f2776j;
        }

        /* renamed from: v */
        public final boolean mo5623v() {
            return this.f2778l;
        }

        /* renamed from: w */
        public boolean mo5624w() {
            C1069y yVar = this.f2773g;
            return yVar != null && yVar.mo5695c();
        }

        /* renamed from: x */
        public Parcelable mo5222x() {
            return null;
        }

        /* renamed from: y */
        public void mo5625y() {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        /* renamed from: z */
        public void mo5626z() {
            this.f2774h = true;
        }

        /* renamed from: e */
        public int mo5591e() {
            C1080b bVar = this.f2767a;
            if (bVar != null) {
                return bVar.mo5798a();
            }
            return 0;
        }

        /* renamed from: h */
        public int mo5603h(View view) {
            Rect rect = ((C1059p) view.getLayoutParams()).f2792b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* renamed from: i */
        public int mo5605i(View view) {
            return view.getRight() + mo5613m(view);
        }

        /* renamed from: j */
        public int mo5607j(View view) {
            return view.getTop() - mo5615n(view);
        }

        /* renamed from: k */
        public int mo5608k() {
            return C0839t.m2726o(this.f2768b);
        }

        /* renamed from: l */
        public int mo5610l() {
            return C0839t.m2727p(this.f2768b);
        }

        /* renamed from: m */
        public int mo5613m(View view) {
            return ((C1059p) view.getLayoutParams()).f2792b.right;
        }

        /* renamed from: n */
        public int mo5615n(View view) {
            return ((C1059p) view.getLayoutParams()).f2792b.top;
        }

        /* renamed from: o */
        public int mo5616o() {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* renamed from: e */
        public void mo5593e(int i) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                recyclerView.mo5299d(i);
            }
        }

        /* renamed from: g */
        public View mo5600g() {
            View focusedChild;
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f2767a.mo5809c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* renamed from: c */
        public void mo5581c(View view, int i) {
            mo5545a(view, i, (C1059p) view.getLayoutParams());
        }

        /* renamed from: c */
        public View mo5578c(int i) {
            C1080b bVar = this.f2767a;
            if (bVar != null) {
                return bVar.mo5807c(i);
            }
            return null;
        }

        /* renamed from: e */
        public int mo5592e(View view) {
            return view.getBottom() + mo5586d(view);
        }

        /* renamed from: a */
        public static int m3943a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5582c(C1066v vVar) {
            int e = vVar.mo5681e();
            for (int i = e - 1; i >= 0; i--) {
                View c = vVar.mo5673c(i);
                C1039c0 l = RecyclerView.m3777l(c);
                if (!l.shouldIgnore()) {
                    l.setIsRecyclable(false);
                    if (l.isTmpDetached()) {
                        this.f2768b.removeDetachedView(c, false);
                    }
                    C1048l lVar = this.f2768b.f2684M;
                    if (lVar != null) {
                        lVar.mo5518c(l);
                    }
                    l.setIsRecyclable(true);
                    vVar.mo5663a(c);
                }
            }
            vVar.mo5674c();
            if (e > 0) {
                this.f2768b.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5594e(RecyclerView recyclerView) {
            mo5570b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* renamed from: g */
        public int mo5599g(View view) {
            Rect rect = ((C1059p) view.getLayoutParams()).f2792b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* renamed from: b */
        public void mo5213b(RecyclerView recyclerView, C1066v vVar) {
            mo5583c(recyclerView);
        }

        /* renamed from: a */
        public void mo5208a(String str) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                recyclerView.mo5266a(str);
            }
        }

        /* renamed from: b */
        public void mo5571b(View view) {
            mo5572b(view, -1);
        }

        /* renamed from: b */
        public void mo5572b(View view, int i) {
            m3947a(view, i, false);
        }

        /* renamed from: f */
        public boolean mo5598f() {
            RecyclerView recyclerView = this.f2768b;
            return recyclerView != null && recyclerView.f2706g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5556a(RecyclerView recyclerView) {
            this.f2775i = true;
            mo5575b(recyclerView);
        }

        /* renamed from: b */
        public View mo5211b(int i) {
            int e = mo5591e();
            for (int i2 = 0; i2 < e; i2++) {
                View c = mo5578c(i2);
                C1039c0 l = RecyclerView.m3777l(c);
                if (l != null && l.getLayoutPosition() == i && !l.shouldIgnore() && (this.f2768b.f2711i0.mo5702d() || !l.isRemoved())) {
                    return c;
                }
            }
            return null;
        }

        /* renamed from: d */
        public void mo5588d(int i) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                recyclerView.mo5287c(i);
            }
        }

        /* renamed from: f */
        public int mo5595f(View view) {
            return view.getLeft() - mo5609k(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5557a(RecyclerView recyclerView, C1066v vVar) {
            this.f2775i = false;
            mo5213b(recyclerView, vVar);
        }

        /* renamed from: d */
        public int mo5586d(View view) {
            return ((C1059p) view.getLayoutParams()).f2792b.bottom;
        }

        /* renamed from: d */
        private boolean m3951d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n = mo5614n();
            int p = mo5618p();
            int q = mo5619q() - mo5616o();
            int h = mo5602h() - mo5612m();
            Rect rect = this.f2768b.f2710i;
            mo5573b(focusedChild, rect);
            if (rect.left - i >= q || rect.right - i <= n || rect.top - i2 >= h || rect.bottom - i2 <= p) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo5569a(Runnable runnable) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo5576b(View view, int i, int i2, C1059p pVar) {
            return !this.f2777k || !m3949b(view.getMeasuredWidth(), i, pVar.width) || !m3949b(view.getMeasuredHeight(), i2, pVar.height);
        }

        /* renamed from: a */
        public C1059p mo5157a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof C1059p) {
                return new C1059p((C1059p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new C1059p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new C1059p(layoutParams);
        }

        /* renamed from: c */
        private int[] m3950c(View view, Rect rect) {
            int[] iArr = new int[2];
            int n = mo5614n();
            int p = mo5618p();
            int q = mo5619q() - mo5616o();
            int h = mo5602h() - mo5612m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - n;
            int min = Math.min(0, i);
            int i2 = top - p;
            int min2 = Math.min(0, i2);
            int i3 = width - q;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - h);
            if (mo5606j() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        /* renamed from: b */
        private static boolean m3949b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* renamed from: b */
        public void mo5573b(View view, Rect rect) {
            RecyclerView.m3760a(view, rect);
        }

        /* renamed from: a */
        public C1059p mo5156a(Context context, AttributeSet attributeSet) {
            return new C1059p(context, attributeSet);
        }

        /* renamed from: b */
        public void mo5574b(C1066v vVar) {
            for (int e = mo5591e() - 1; e >= 0; e--) {
                if (!RecyclerView.m3777l(mo5578c(e)).shouldIgnore()) {
                    mo5540a(e, vVar);
                }
            }
        }

        /* renamed from: a */
        public void mo5541a(View view) {
            mo5542a(view, -1);
        }

        /* renamed from: a */
        public void mo5542a(View view, int i) {
            m3947a(view, i, true);
        }

        /* renamed from: a */
        private void m3947a(View view, int i, boolean z) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (z || l.isRemoved()) {
                this.f2768b.f2704f.mo5925a(l);
            } else {
                this.f2768b.f2704f.mo5936g(l);
            }
            C1059p pVar = (C1059p) view.getLayoutParams();
            if (l.wasReturnedFromScrap() || l.isScrap()) {
                if (l.isScrap()) {
                    l.unScrap();
                } else {
                    l.clearReturnedFromScrapFlag();
                }
                this.f2767a.mo5801a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f2768b) {
                int b = this.f2767a.mo5805b(view);
                if (i == -1) {
                    i = this.f2767a.mo5798a();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2768b.indexOfChild(view) + this.f2768b.mo5335i());
                } else if (b != i) {
                    this.f2768b.f2718m.mo5539a(b, i);
                }
            } else {
                this.f2767a.mo5802a(view, i, false);
                pVar.f2793c = true;
                C1069y yVar = this.f2773g;
                if (yVar != null && yVar.mo5695c()) {
                    this.f2773g.mo5693a(view);
                }
            }
            if (pVar.f2794d) {
                l.itemView.invalidate();
                pVar.f2794d = false;
            }
        }

        /* renamed from: b */
        public int mo5168b(C1066v vVar, C1070z zVar) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView == null || recyclerView.f2716l == null || !mo5214b()) {
                return 1;
            }
            return this.f2768b.f2716l.getItemCount();
        }

        /* renamed from: c */
        public void mo5580c(int i, int i2) {
            this.f2768b.setMeasuredDimension(i, i2);
        }

        /* renamed from: a */
        public void mo5538a(int i) {
            m3946a(i, mo5578c(i));
        }

        /* renamed from: a */
        private void m3946a(int i, View view) {
            this.f2767a.mo5799a(i);
        }

        /* renamed from: a */
        public void mo5545a(View view, int i, C1059p pVar) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l.isRemoved()) {
                this.f2768b.f2704f.mo5925a(l);
            } else {
                this.f2768b.f2704f.mo5936g(l);
            }
            this.f2767a.mo5801a(view, i, pVar, l.isRemoved());
        }

        /* renamed from: a */
        public void mo5539a(int i, int i2) {
            View c = mo5578c(i);
            if (c != null) {
                mo5538a(i);
                mo5581c(c, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f2768b.toString());
        }

        /* renamed from: a */
        public void mo5548a(View view, C1066v vVar) {
            mo5617o(view);
            vVar.mo5671b(view);
        }

        /* renamed from: a */
        public void mo5540a(int i, C1066v vVar) {
            View c = mo5578c(i);
            mo5601g(i);
            vVar.mo5671b(c);
        }

        /* renamed from: a */
        public void mo5552a(C1066v vVar) {
            for (int e = mo5591e() - 1; e >= 0; e--) {
                m3948a(vVar, e, mo5578c(e));
            }
        }

        /* renamed from: a */
        private void m3948a(C1066v vVar, int i, View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (!l.shouldIgnore()) {
                if (!l.isInvalid() || l.isRemoved() || this.f2768b.f2716l.hasStableIds()) {
                    mo5538a(i);
                    vVar.mo5676c(view);
                    this.f2768b.f2704f.mo5933d(l);
                    return;
                }
                mo5601g(i);
                vVar.mo5672b(l);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5559a(View view, int i, int i2, C1059p pVar) {
            return view.isLayoutRequested() || !this.f2777k || !m3949b(view.getWidth(), i, pVar.width) || !m3949b(view.getHeight(), i2, pVar.height);
        }

        /* renamed from: a */
        public void mo5543a(View view, int i, int i2) {
            C1059p pVar = (C1059p) view.getLayoutParams();
            Rect g = this.f2768b.mo5320g(view);
            int i3 = i + g.left + g.right;
            int i4 = i2 + g.top + g.bottom;
            int a = m3944a(mo5619q(), mo5620r(), mo5614n() + mo5616o() + pVar.leftMargin + pVar.rightMargin + i3, pVar.width, mo5210a());
            int a2 = m3944a(mo5602h(), mo5604i(), mo5618p() + mo5612m() + pVar.topMargin + pVar.bottomMargin + i4, pVar.height, mo5214b());
            if (mo5559a(view, a, a2, pVar)) {
                view.measure(a, a2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int m3944a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1054o.m3944a(int, int, int, int, boolean):int");
        }

        /* renamed from: a */
        public void mo5544a(View view, int i, int i2, int i3, int i4) {
            C1059p pVar = (C1059p) view.getLayoutParams();
            Rect rect = pVar.f2792b;
            view.layout(i + rect.left + pVar.leftMargin, i2 + rect.top + pVar.topMargin, (i3 - rect.right) - pVar.rightMargin, (i4 - rect.bottom) - pVar.bottomMargin);
        }

        /* renamed from: a */
        public void mo5549a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C1059p) view.getLayoutParams()).f2792b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f2768b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f2768b.f2714k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* renamed from: a */
        public void mo5546a(View view, Rect rect) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.mo5320g(view));
            }
        }

        /* renamed from: a */
        public boolean mo5564a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return mo5565a(recyclerView, view, rect, z, false);
        }

        /* renamed from: a */
        public boolean mo5565a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] c = m3950c(view, rect);
            int i = c[0];
            int i2 = c[1];
            if ((z2 && !m3951d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.mo5336i(i, i2);
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo5561a(View view, boolean z, boolean z2) {
            boolean z3 = this.f2771e.mo5916a(view, 24579) && this.f2772f.mo5916a(view, 24579);
            return z ? z3 : !z3;
        }

        @Deprecated
        /* renamed from: a */
        public boolean mo5566a(RecyclerView recyclerView, View view, View view2) {
            return mo5624w() || recyclerView.mo5362q();
        }

        /* renamed from: a */
        public boolean mo5567a(RecyclerView recyclerView, C1070z zVar, View view, View view2) {
            return mo5566a(recyclerView, view, view2);
        }

        /* renamed from: a */
        public void mo5165a(RecyclerView recyclerView, int i, int i2, Object obj) {
            mo5584c(recyclerView, i, i2);
        }

        /* renamed from: a */
        public void mo5553a(C1066v vVar, C1070z zVar, int i, int i2) {
            this.f2768b.mo5288c(i, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5550a(C0807c cVar) {
            RecyclerView recyclerView = this.f2768b;
            mo5555a(recyclerView.f2696b, recyclerView.f2711i0, cVar);
        }

        /* renamed from: a */
        public void mo5555a(C1066v vVar, C1070z zVar, C0807c cVar) {
            if (this.f2768b.canScrollVertically(-1) || this.f2768b.canScrollHorizontally(-1)) {
                cVar.mo4110a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
                cVar.mo4148j(true);
            }
            if (this.f2768b.canScrollVertically(1) || this.f2768b.canScrollHorizontally(1)) {
                cVar.mo4110a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
                cVar.mo4148j(true);
            }
            cVar.mo4116a((Object) C0807c.C0809b.m2619a(mo5168b(vVar, zVar), mo5153a(vVar, zVar), mo5590d(vVar, zVar), mo5577c(vVar, zVar)));
        }

        /* renamed from: a */
        public void mo5206a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2768b;
            mo5554a(recyclerView.f2696b, recyclerView.f2711i0, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo5554a(C1066v vVar, C1070z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f2768b.canScrollVertically(-1) && !this.f2768b.canScrollHorizontally(-1) && !this.f2768b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                C1043g gVar = this.f2768b.f2716l;
                if (gVar != null) {
                    accessibilityEvent.setItemCount(gVar.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5547a(View view, C0807c cVar) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l != null && !l.isRemoved() && !this.f2767a.mo5809c(l.itemView)) {
                RecyclerView recyclerView = this.f2768b;
                mo5159a(recyclerView.f2696b, recyclerView.f2711i0, view, cVar);
            }
        }

        /* renamed from: a */
        public void mo5159a(C1066v vVar, C1070z zVar, View view, C0807c cVar) {
            cVar.mo4124b((Object) C0807c.C0810c.m2620a(mo5214b() ? mo5611l(view) : 0, 1, mo5210a() ? mo5611l(view) : 0, 1, false, false));
        }

        /* renamed from: a */
        public int mo5153a(C1066v vVar, C1070z zVar) {
            RecyclerView recyclerView = this.f2768b;
            if (recyclerView == null || recyclerView.f2716l == null || !mo5210a()) {
                return 1;
            }
            return this.f2768b.f2716l.getItemCount();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5558a(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f2768b;
            return mo5562a(recyclerView.f2696b, recyclerView.f2711i0, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo5562a(androidx.recyclerview.widget.RecyclerView.C1066v r8, androidx.recyclerview.widget.RecyclerView.C1070z r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.f2768b
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.mo5602h()
                int r11 = r7.mo5618p()
                int r8 = r8 - r11
                int r11 = r7.mo5612m()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.f2768b
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.mo5619q()
                int r11 = r7.mo5614n()
                int r10 = r10 - r11
                int r11 = r7.mo5616o()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.mo5602h()
                int r10 = r7.mo5618p()
                int r8 = r8 - r10
                int r10 = r7.mo5612m()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.f2768b
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.mo5619q()
                int r11 = r7.mo5614n()
                int r10 = r10 - r11
                int r11 = r7.mo5616o()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.f2768b
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.mo5250a((int) r2, (int) r3, (android.view.animation.Interpolator) r4, (int) r5, (boolean) r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1054o.mo5562a(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5560a(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f2768b;
            return mo5563a(recyclerView.f2696b, recyclerView.f2711i0, view, i, bundle);
        }

        /* renamed from: a */
        public static C1058d m3945a(Context context, AttributeSet attributeSet, int i, int i2) {
            C1058d dVar = new C1058d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
            dVar.f2787a = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            dVar.f2788b = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            dVar.f2789c = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            dVar.f2790d = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    public interface C1060q {
        /* renamed from: a */
        void mo5637a(View view);

        /* renamed from: b */
        void mo5638b(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    public static abstract class C1061r {
        /* renamed from: a */
        public abstract boolean mo5639a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    public interface C1062s {
        /* renamed from: a */
        void mo5640a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: a */
        void mo5641a(boolean z);

        /* renamed from: b */
        boolean mo5642b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    public static abstract class C1063t {
        /* renamed from: a */
        public void mo5643a(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public void mo5644a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    public final class C1066v {

        /* renamed from: a */
        final ArrayList<C1039c0> f2801a = new ArrayList<>();

        /* renamed from: b */
        ArrayList<C1039c0> f2802b = null;

        /* renamed from: c */
        final ArrayList<C1039c0> f2803c = new ArrayList<>();

        /* renamed from: d */
        private final List<C1039c0> f2804d = Collections.unmodifiableList(this.f2801a);

        /* renamed from: e */
        private int f2805e = 2;

        /* renamed from: f */
        int f2806f = 2;

        /* renamed from: g */
        C1064u f2807g;

        /* renamed from: h */
        private C1035a0 f2808h;

        public C1066v() {
        }

        /* renamed from: e */
        private void m4116e(C1039c0 c0Var) {
            if (RecyclerView.this.mo5361p()) {
                View view = c0Var.itemView;
                if (C0839t.m2723l(view) == 0) {
                    C0839t.m2716f(view, 1);
                }
                C1109i iVar = RecyclerView.this.f2725p0;
                if (iVar != null) {
                    C0797a b = iVar.mo5895b();
                    if (b instanceof C1109i.C1110a) {
                        ((C1109i.C1110a) b).mo5898d(view);
                    }
                    C0839t.m2697a(view, b);
                }
            }
        }

        /* renamed from: a */
        public void mo5660a() {
            this.f2801a.clear();
            mo5686i();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public View mo5667b(int i, boolean z) {
            return mo5658a(i, z, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5676c(View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (!l.hasAnyOfTheFlags(12) && l.isUpdated() && !RecyclerView.this.mo5271a(l)) {
                if (this.f2802b == null) {
                    this.f2802b = new ArrayList<>();
                }
                l.setScrapContainer(this, true);
                this.f2802b.add(l);
            } else if (!l.isInvalid() || l.isRemoved() || RecyclerView.this.f2716l.hasStableIds()) {
                l.setScrapContainer(this, false);
                this.f2801a.add(l);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.mo5335i());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5680d(C1039c0 c0Var) {
            if (c0Var.isRemoved()) {
                return RecyclerView.this.f2711i0.mo5702d();
            }
            int i = c0Var.mPosition;
            if (i < 0 || i >= RecyclerView.this.f2716l.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0Var + RecyclerView.this.mo5335i());
            } else if (!RecyclerView.this.f2711i0.mo5702d() && RecyclerView.this.f2716l.getItemViewType(c0Var.mPosition) != c0Var.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.f2716l.hasStableIds() || c0Var.getItemId() == RecyclerView.this.f2716l.getItemId(c0Var.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        /* renamed from: f */
        public List<C1039c0> mo5683f() {
            return this.f2804d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo5684g() {
            int size = this.f2803c.size();
            for (int i = 0; i < size; i++) {
                C1059p pVar = (C1059p) this.f2803c.get(i).itemView.getLayoutParams();
                if (pVar != null) {
                    pVar.f2793c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo5685h() {
            int size = this.f2803c.size();
            for (int i = 0; i < size; i++) {
                C1039c0 c0Var = this.f2803c.get(i);
                if (c0Var != null) {
                    c0Var.addFlags(6);
                    c0Var.addChangePayload((Object) null);
                }
            }
            C1043g gVar = RecyclerView.this.f2716l;
            if (gVar == null || !gVar.hasStableIds()) {
                mo5686i();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo5686i() {
            for (int size = this.f2803c.size() - 1; size >= 0; size--) {
                mo5682e(size);
            }
            this.f2803c.clear();
            if (RecyclerView.f2666D0) {
                RecyclerView.this.f2709h0.mo5868a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo5687j() {
            C1054o oVar = RecyclerView.this.f2718m;
            this.f2806f = this.f2805e + (oVar != null ? oVar.f2779m : 0);
            for (int size = this.f2803c.size() - 1; size >= 0 && this.f2803c.size() > this.f2806f; size--) {
                mo5682e(size);
            }
        }

        /* renamed from: f */
        private void m4117f(C1039c0 c0Var) {
            View view = c0Var.itemView;
            if (view instanceof ViewGroup) {
                m4114a((ViewGroup) view, false);
            }
        }

        /* renamed from: b */
        public void mo5671b(View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            if (l.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (l.isScrap()) {
                l.unScrap();
            } else if (l.wasReturnedFromScrap()) {
                l.clearReturnedFromScrapFlag();
            }
            mo5672b(l);
            if (RecyclerView.this.f2684M != null && !l.isRecyclable()) {
                RecyclerView.this.f2684M.mo5518c(l);
            }
        }

        /* renamed from: a */
        private boolean m4115a(C1039c0 c0Var, int i, int i2, long j) {
            c0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = c0Var.getItemViewType();
            long k = RecyclerView.this.mo5344k();
            if (j != Long.MAX_VALUE && !this.f2807g.mo5651a(itemViewType, k, j)) {
                return false;
            }
            RecyclerView.this.f2716l.bindViewHolder(c0Var, i);
            this.f2807g.mo5648a(c0Var.getItemViewType(), RecyclerView.this.mo5344k() - k);
            m4116e(c0Var);
            if (!RecyclerView.this.f2711i0.mo5702d()) {
                return true;
            }
            c0Var.mPreLayoutPosition = i2;
            return true;
        }

        /* renamed from: d */
        public View mo5678d(int i) {
            return mo5667b(i, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5682e(int i) {
            mo5665a(this.f2803c.get(i), true);
            this.f2803c.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5672b(C1039c0 c0Var) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (c0Var.isScrap() || c0Var.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c0Var.isScrap());
                sb.append(" isAttached:");
                if (c0Var.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.mo5335i());
                throw new IllegalArgumentException(sb.toString());
            } else if (c0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0Var + RecyclerView.this.mo5335i());
            } else if (!c0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = c0Var.doesTransientStatePreventRecycling();
                C1043g gVar = RecyclerView.this.f2716l;
                if ((gVar != null && doesTransientStatePreventRecycling && gVar.onFailedToRecycleView(c0Var)) || c0Var.isRecyclable()) {
                    if (this.f2806f <= 0 || c0Var.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f2803c.size();
                        if (size >= this.f2806f && size > 0) {
                            mo5682e(0);
                            size--;
                        }
                        if (RecyclerView.f2666D0 && size > 0 && !RecyclerView.this.f2709h0.mo5870a(c0Var.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.f2709h0.mo5870a(this.f2803c.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f2803c.add(size, c0Var);
                        z = true;
                    }
                    if (!z) {
                        mo5665a(c0Var, true);
                        z2 = z;
                        RecyclerView.this.f2704f.mo5937h(c0Var);
                        if (!z2 && !z3 && doesTransientStatePreventRecycling) {
                            c0Var.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    z2 = z;
                }
                z3 = false;
                RecyclerView.this.f2704f.mo5937h(c0Var);
                if (!z2) {
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.mo5335i());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public C1064u mo5679d() {
            if (this.f2807g == null) {
                this.f2807g = new C1064u();
            }
            return this.f2807g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5677c(C1039c0 c0Var) {
            if (c0Var.mInChangeScrap) {
                this.f2802b.remove(c0Var);
            } else {
                this.f2801a.remove(c0Var);
            }
            c0Var.mScrapContainer = null;
            c0Var.mInChangeScrap = false;
            c0Var.clearReturnedFromScrapFlag();
        }

        /* renamed from: a */
        public int mo5656a(int i) {
            if (i < 0 || i >= RecyclerView.this.f2711i0.mo5697a()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f2711i0.mo5697a() + RecyclerView.this.mo5335i());
            } else if (!RecyclerView.this.f2711i0.mo5702d()) {
                return i;
            } else {
                return RecyclerView.this.f2700d.mo5785b(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo5681e() {
            return this.f2801a.size();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x020c  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.C1039c0 mo5658a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x022f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f2711i0
                int r1 = r1.mo5697a()
                if (r3 >= r1) goto L_0x022f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f2711i0
                boolean r1 = r1.mo5702d()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r16.mo5668b((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r16.mo5657a((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.mo5680d((androidx.recyclerview.widget.RecyclerView.C1039c0) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.mo5672b((androidx.recyclerview.widget.RecyclerView.C1039c0) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0181
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f2700d
                int r5 = r5.mo5785b((int) r3)
                if (r5 < 0) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$g r9 = r9.f2716l
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$g r9 = r9.f2716l
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$g r10 = r10.f2716l
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$g r1 = r1.f2716l
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r6.mo5659a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$a0 r0 = r6.f2808h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.mo5390a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r1.mo5315f((android.view.View) r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo5335i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo5335i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView$u r0 = r16.mo5679d()
                androidx.recyclerview.widget.RecyclerView$c0 r0 = r0.mo5646a((int) r9)
                if (r0 == 0) goto L_0x0101
                r0.resetInternal()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f2663A0
                if (r1 == 0) goto L_0x0101
                r6.m4117f(r0)
            L_0x0101:
                r1 = r0
            L_0x0102:
                if (r1 != 0) goto L_0x0181
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.mo5344k()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                androidx.recyclerview.widget.RecyclerView$u r10 = r6.f2807g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.mo5654b(r11, r12, r14)
                if (r5 != 0) goto L_0x0120
                return r2
            L_0x0120:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$g r5 = r2.f2716l
                androidx.recyclerview.widget.RecyclerView$c0 r2 = r5.createViewHolder(r2, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f2666D0
                if (r5 == 0) goto L_0x013b
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.m3775k(r5)
                if (r5 == 0) goto L_0x013b
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013b:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.mo5344k()
                androidx.recyclerview.widget.RecyclerView$u r5 = r6.f2807g
                long r10 = r10 - r0
                r5.mo5653b(r9, r10)
                r9 = r2
                goto L_0x0182
            L_0x0149:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f2711i0
                int r2 = r2.mo5697a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo5335i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0181:
                r9 = r1
            L_0x0182:
                r10 = r4
                if (r10 == 0) goto L_0x01bb
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f2711i0
                boolean r0 = r0.mo5702d()
                if (r0 != 0) goto L_0x01bb
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01bb
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f2711i0
                boolean r0 = r0.f2821k
                if (r0 == 0) goto L_0x01bb
                int r0 = androidx.recyclerview.widget.RecyclerView.C1048l.m3916e(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$l r2 = r1.f2684M
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f2711i0
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$l$c r0 = r2.mo5507a((androidx.recyclerview.widget.RecyclerView.C1070z) r1, (androidx.recyclerview.widget.RecyclerView.C1039c0) r9, (int) r0, (java.util.List<java.lang.Object>) r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.mo5256a((androidx.recyclerview.widget.RecyclerView.C1039c0) r9, (androidx.recyclerview.widget.RecyclerView.C1048l.C1051c) r0)
            L_0x01bb:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f2711i0
                boolean r0 = r0.mo5702d()
                if (r0 == 0) goto L_0x01ce
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01ce
                r9.mPreLayoutPosition = r3
                goto L_0x01e1
            L_0x01ce:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01e3
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x01e3
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x01e1
                goto L_0x01e3
            L_0x01e1:
                r0 = 0
                goto L_0x01f6
            L_0x01e3:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f2700d
                int r2 = r0.mo5785b((int) r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.m4115a(r1, r2, r3, r4)
            L_0x01f6:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x020c
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.C1059p) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0224
            L_0x020c:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0222
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.C1059p) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0224
            L_0x0222:
                androidx.recyclerview.widget.RecyclerView$p r1 = (androidx.recyclerview.widget.RecyclerView.C1059p) r1
            L_0x0224:
                r1.f2791a = r9
                if (r10 == 0) goto L_0x022b
                if (r0 == 0) goto L_0x022b
                goto L_0x022c
            L_0x022b:
                r7 = 0
            L_0x022c:
                r1.f2794d = r7
                return r9
            L_0x022f:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f2711i0
                int r2 = r2.mo5697a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.mo5335i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1066v.mo5658a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$c0");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public View mo5673c(int i) {
            return this.f2801a.get(i).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5674c() {
            this.f2801a.clear();
            ArrayList<C1039c0> arrayList = this.f2802b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5675c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f2803c.size() - 1; size >= 0; size--) {
                C1039c0 c0Var = this.f2803c.get(size);
                if (c0Var != null && (i3 = c0Var.mPosition) >= i && i3 < i4) {
                    c0Var.addFlags(2);
                    mo5682e(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1039c0 mo5668b(int i) {
            int size;
            int b;
            ArrayList<C1039c0> arrayList = this.f2802b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    C1039c0 c0Var = this.f2802b.get(i3);
                    if (c0Var.wasReturnedFromScrap() || c0Var.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        c0Var.addFlags(32);
                        return c0Var;
                    }
                }
                if (RecyclerView.this.f2716l.hasStableIds() && (b = RecyclerView.this.f2700d.mo5785b(i)) > 0 && b < RecyclerView.this.f2716l.getItemCount()) {
                    long itemId = RecyclerView.this.f2716l.getItemId(b);
                    while (i2 < size) {
                        C1039c0 c0Var2 = this.f2802b.get(i2);
                        if (c0Var2.wasReturnedFromScrap() || c0Var2.getItemId() != itemId) {
                            i2++;
                        } else {
                            c0Var2.addFlags(32);
                            return c0Var2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5670b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i5 = -1;
                i4 = i;
                i3 = i2;
            } else {
                i5 = 1;
                i3 = i;
                i4 = i2;
            }
            int size = this.f2803c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C1039c0 c0Var = this.f2803c.get(i7);
                if (c0Var != null && (i6 = c0Var.mPosition) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        c0Var.offsetPosition(i2 - i, false);
                    } else {
                        c0Var.offsetPosition(i5, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5669b() {
            int size = this.f2803c.size();
            for (int i = 0; i < size; i++) {
                this.f2803c.get(i).clearOldPosition();
            }
            int size2 = this.f2801a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f2801a.get(i2).clearOldPosition();
            }
            ArrayList<C1039c0> arrayList = this.f2802b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f2802b.get(i3).clearOldPosition();
                }
            }
        }

        /* renamed from: a */
        private void m4114a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4114a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5665a(C1039c0 c0Var, boolean z) {
            RecyclerView.m3774e(c0Var);
            View view = c0Var.itemView;
            C1109i iVar = RecyclerView.this.f2725p0;
            if (iVar != null) {
                C0797a b = iVar.mo5895b();
                C0839t.m2697a(view, b instanceof C1109i.C1110a ? ((C1109i.C1110a) b).mo5897c(view) : null);
            }
            if (z) {
                mo5664a(c0Var);
            }
            c0Var.mOwnerRecyclerView = null;
            mo5679d().mo5649a(c0Var);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5663a(View view) {
            C1039c0 l = RecyclerView.m3777l(view);
            l.mScrapContainer = null;
            l.mInChangeScrap = false;
            l.clearReturnedFromScrapFlag();
            mo5672b(l);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1039c0 mo5657a(int i, boolean z) {
            View b;
            int size = this.f2801a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C1039c0 c0Var = this.f2801a.get(i3);
                if (c0Var.wasReturnedFromScrap() || c0Var.getLayoutPosition() != i || c0Var.isInvalid() || (!RecyclerView.this.f2711i0.f2818h && c0Var.isRemoved())) {
                    i3++;
                } else {
                    c0Var.addFlags(32);
                    return c0Var;
                }
            }
            if (z || (b = RecyclerView.this.f2702e.mo5806b(i)) == null) {
                int size2 = this.f2803c.size();
                while (i2 < size2) {
                    C1039c0 c0Var2 = this.f2803c.get(i2);
                    if (c0Var2.isInvalid() || c0Var2.getLayoutPosition() != i || c0Var2.isAttachedToTransitionOverlay()) {
                        i2++;
                    } else {
                        if (!z) {
                            this.f2803c.remove(i2);
                        }
                        return c0Var2;
                    }
                }
                return null;
            }
            C1039c0 l = RecyclerView.m3777l(b);
            RecyclerView.this.f2702e.mo5814f(b);
            int b2 = RecyclerView.this.f2702e.mo5805b(b);
            if (b2 != -1) {
                RecyclerView.this.f2702e.mo5799a(b2);
                mo5676c(b);
                l.addFlags(8224);
                return l;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + l + RecyclerView.this.mo5335i());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1039c0 mo5659a(long j, int i, boolean z) {
            for (int size = this.f2801a.size() - 1; size >= 0; size--) {
                C1039c0 c0Var = this.f2801a.get(size);
                if (c0Var.getItemId() == j && !c0Var.wasReturnedFromScrap()) {
                    if (i == c0Var.getItemViewType()) {
                        c0Var.addFlags(32);
                        if (c0Var.isRemoved() && !RecyclerView.this.f2711i0.mo5702d()) {
                            c0Var.setFlags(2, 14);
                        }
                        return c0Var;
                    } else if (!z) {
                        this.f2801a.remove(size);
                        RecyclerView.this.removeDetachedView(c0Var.itemView, false);
                        mo5663a(c0Var.itemView);
                    }
                }
            }
            int size2 = this.f2803c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C1039c0 c0Var2 = this.f2803c.get(size2);
                if (c0Var2.getItemId() == j && !c0Var2.isAttachedToTransitionOverlay()) {
                    if (i == c0Var2.getItemViewType()) {
                        if (!z) {
                            this.f2803c.remove(size2);
                        }
                        return c0Var2;
                    } else if (!z) {
                        mo5682e(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5664a(C1039c0 c0Var) {
            C1067w wVar = RecyclerView.this.f2720n;
            if (wVar != null) {
                wVar.mo5688a(c0Var);
            }
            C1043g gVar = RecyclerView.this.f2716l;
            if (gVar != null) {
                gVar.onViewRecycled(c0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2711i0 != null) {
                recyclerView.f2704f.mo5937h(c0Var);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5666a(C1043g gVar, C1043g gVar2, boolean z) {
            mo5660a();
            mo5679d().mo5650a(gVar, gVar2, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5661a(int i, int i2) {
            int size = this.f2803c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1039c0 c0Var = this.f2803c.get(i3);
                if (c0Var != null && c0Var.mPosition >= i) {
                    c0Var.offsetPosition(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5662a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2803c.size() - 1; size >= 0; size--) {
                C1039c0 c0Var = this.f2803c.get(size);
                if (c0Var != null) {
                    int i4 = c0Var.mPosition;
                    if (i4 >= i3) {
                        c0Var.offsetPosition(-i2, z);
                    } else if (i4 >= i) {
                        c0Var.addFlags(8);
                        mo5682e(size);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    public interface C1067w {
        /* renamed from: a */
        void mo5688a(C1039c0 c0Var);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$y */
    public static abstract class C1069y {
        /* renamed from: a */
        public abstract int mo5690a();

        /* renamed from: a */
        public abstract void mo5691a(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo5692a(int i, int i2);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5693a(View view);

        /* renamed from: b */
        public abstract boolean mo5694b();

        /* renamed from: c */
        public abstract boolean mo5695c();

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public final void mo5696d() {
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            f2671z0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 18
            if (r1 == r2) goto L_0x001c
            r2 = 19
            if (r1 == r2) goto L_0x001c
            r2 = 20
            if (r1 != r2) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x001d
        L_0x001c:
            r1 = 1
        L_0x001d:
            f2663A0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            f2664B0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r1 < r2) goto L_0x0032
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            f2665C0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x003d
            r1 = 1
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            f2666D0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 15
            if (r1 > r2) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            f2667E0 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 > r2) goto L_0x0051
            r1 = 1
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            f2668F0 = r1
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            f2669G0 = r1
            androidx.recyclerview.widget.RecyclerView$c r0 = new androidx.recyclerview.widget.RecyclerView$c
            r0.<init>()
            f2670H0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: B */
    private void m3738B() {
        m3753Q();
        mo5317f(0);
    }

    /* renamed from: C */
    private void m3739C() {
        int i = this.f2744z;
        this.f2744z = 0;
        if (i != 0 && mo5361p()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0806b.m2548a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    /* renamed from: D */
    private void m3740D() {
        boolean z = true;
        this.f2711i0.mo5698a(1);
        mo5264a(this.f2711i0);
        this.f2711i0.f2820j = false;
        mo5384z();
        this.f2704f.mo5923a();
        mo5378t();
        m3749M();
        m3754R();
        C1070z zVar = this.f2711i0;
        if (!zVar.f2821k || !this.f2719m0) {
            z = false;
        }
        zVar.f2819i = z;
        this.f2719m0 = false;
        this.f2717l0 = false;
        C1070z zVar2 = this.f2711i0;
        zVar2.f2818h = zVar2.f2822l;
        zVar2.f2816f = this.f2716l.getItemCount();
        m3767a(this.f2729r0);
        if (this.f2711i0.f2821k) {
            int a = this.f2702e.mo5798a();
            for (int i = 0; i < a; i++) {
                C1039c0 l = m3777l(this.f2702e.mo5807c(i));
                if (!l.shouldIgnore() && (!l.isInvalid() || this.f2716l.hasStableIds())) {
                    this.f2704f.mo5931c(l, this.f2684M.mo5507a(this.f2711i0, l, C1048l.m3916e(l), l.getUnmodifiedPayloads()));
                    if (this.f2711i0.f2819i && l.isUpdated() && !l.isRemoved() && !l.shouldIgnore() && !l.isInvalid()) {
                        this.f2704f.mo5924a(mo5284c(l), l);
                    }
                }
            }
        }
        if (this.f2711i0.f2822l) {
            mo5383y();
            C1070z zVar3 = this.f2711i0;
            boolean z2 = zVar3.f2817g;
            zVar3.f2817g = false;
            this.f2718m.mo5176e(this.f2696b, zVar3);
            this.f2711i0.f2817g = z2;
            for (int i2 = 0; i2 < this.f2702e.mo5798a(); i2++) {
                C1039c0 l2 = m3777l(this.f2702e.mo5807c(i2));
                if (!l2.shouldIgnore() && !this.f2704f.mo5932c(l2)) {
                    int e = C1048l.m3916e(l2);
                    boolean hasAnyOfTheFlags = l2.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!hasAnyOfTheFlags) {
                        e |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                    }
                    C1048l.C1051c a2 = this.f2684M.mo5507a(this.f2711i0, l2, e, l2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        mo5256a(l2, a2);
                    } else {
                        this.f2704f.mo5926a(l2, a2);
                    }
                }
            }
            mo5244a();
        } else {
            mo5244a();
        }
        mo5379u();
        mo5301d(false);
        this.f2711i0.f2815e = 2;
    }

    /* renamed from: E */
    private void m3741E() {
        mo5384z();
        mo5378t();
        this.f2711i0.mo5698a(6);
        this.f2700d.mo5786b();
        this.f2711i0.f2816f = this.f2716l.getItemCount();
        C1070z zVar = this.f2711i0;
        zVar.f2814d = 0;
        zVar.f2818h = false;
        this.f2718m.mo5176e(this.f2696b, zVar);
        C1070z zVar2 = this.f2711i0;
        zVar2.f2817g = false;
        this.f2698c = null;
        zVar2.f2821k = zVar2.f2821k && this.f2684M != null;
        this.f2711i0.f2815e = 4;
        mo5379u();
        mo5301d(false);
    }

    /* renamed from: F */
    private void m3742F() {
        this.f2711i0.mo5698a(4);
        mo5384z();
        mo5378t();
        C1070z zVar = this.f2711i0;
        zVar.f2815e = 1;
        if (zVar.f2821k) {
            for (int a = this.f2702e.mo5798a() - 1; a >= 0; a--) {
                C1039c0 l = m3777l(this.f2702e.mo5807c(a));
                if (!l.shouldIgnore()) {
                    long c = mo5284c(l);
                    C1048l.C1051c a2 = this.f2684M.mo5506a(this.f2711i0, l);
                    C1039c0 a3 = this.f2704f.mo5922a(c);
                    if (a3 == null || a3.shouldIgnore()) {
                        this.f2704f.mo5929b(l, a2);
                    } else {
                        boolean b = this.f2704f.mo5930b(a3);
                        boolean b2 = this.f2704f.mo5930b(l);
                        if (!b || a3 != l) {
                            C1048l.C1051c f = this.f2704f.mo5935f(a3);
                            this.f2704f.mo5929b(l, a2);
                            C1048l.C1051c e = this.f2704f.mo5934e(l);
                            if (f == null) {
                                m3758a(c, l, a3);
                            } else {
                                m3762a(a3, l, f, e, b, b2);
                            }
                        } else {
                            this.f2704f.mo5929b(l, a2);
                        }
                    }
                }
            }
            this.f2704f.mo5927a(this.f2743y0);
        }
        this.f2718m.mo5582c(this.f2696b);
        C1070z zVar2 = this.f2711i0;
        zVar2.f2813c = zVar2.f2816f;
        this.f2675D = false;
        this.f2676E = false;
        zVar2.f2821k = false;
        zVar2.f2822l = false;
        this.f2718m.f2774h = false;
        ArrayList<C1039c0> arrayList = this.f2696b.f2802b;
        if (arrayList != null) {
            arrayList.clear();
        }
        C1054o oVar = this.f2718m;
        if (oVar.f2780n) {
            oVar.f2779m = 0;
            oVar.f2780n = false;
            this.f2696b.mo5687j();
        }
        this.f2718m.mo5179g(this.f2711i0);
        mo5379u();
        mo5301d(false);
        this.f2704f.mo5923a();
        int[] iArr = this.f2729r0;
        if (m3776k(iArr[0], iArr[1])) {
            mo5300d(0, 0);
        }
        m3750N();
        m3752P();
    }

    /* renamed from: G */
    private View m3743G() {
        C1039c0 b;
        int i = this.f2711i0.f2823m;
        if (i == -1) {
            i = 0;
        }
        int a = this.f2711i0.mo5697a();
        int i2 = i;
        while (i2 < a) {
            C1039c0 b2 = mo5275b(i2);
            if (b2 == null) {
                break;
            } else if (b2.itemView.hasFocusable()) {
                return b2.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(a, i);
        while (true) {
            min--;
            if (min < 0 || (b = mo5275b(min)) == null) {
                return null;
            }
            if (b.itemView.hasFocusable()) {
                return b.itemView;
            }
        }
    }

    /* renamed from: H */
    private C0831l m3744H() {
        if (this.f2731s0 == null) {
            this.f2731s0 = new C0831l(this);
        }
        return this.f2731s0;
    }

    /* renamed from: I */
    private boolean m3745I() {
        int a = this.f2702e.mo5798a();
        for (int i = 0; i < a; i++) {
            C1039c0 l = m3777l(this.f2702e.mo5807c(i));
            if (l != null && !l.shouldIgnore() && l.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: J */
    private void m3746J() {
        if (C0839t.m2724m(this) == 0) {
            C0839t.m2718g(this, 8);
        }
    }

    /* renamed from: K */
    private void m3747K() {
        this.f2702e = new C1080b(new C1041e());
    }

    /* renamed from: L */
    private boolean m3748L() {
        return this.f2684M != null && this.f2718m.mo5151C();
    }

    /* renamed from: M */
    private void m3749M() {
        if (this.f2675D) {
            this.f2700d.mo5793f();
            if (this.f2676E) {
                this.f2718m.mo5174d(this);
            }
        }
        if (m3748L()) {
            this.f2700d.mo5792e();
        } else {
            this.f2700d.mo5786b();
        }
        boolean z = false;
        boolean z2 = this.f2717l0 || this.f2719m0;
        this.f2711i0.f2821k = this.f2734u && this.f2684M != null && (this.f2675D || z2 || this.f2718m.f2774h) && (!this.f2675D || this.f2716l.hasStableIds());
        C1070z zVar = this.f2711i0;
        if (zVar.f2821k && z2 && !this.f2675D && m3748L()) {
            z = true;
        }
        zVar.f2822l = z;
    }

    /* renamed from: N */
    private void m3750N() {
        View findViewById;
        if (this.f2703e0 && this.f2716l != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!f2668F0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f2702e.mo5809c(focusedChild)) {
                            return;
                        }
                    } else if (this.f2702e.mo5798a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                C1039c0 a = (this.f2711i0.f2824n == -1 || !this.f2716l.hasStableIds()) ? null : mo5243a(this.f2711i0.f2824n);
                if (a != null && !this.f2702e.mo5809c(a.itemView) && a.itemView.hasFocusable()) {
                    view = a.itemView;
                } else if (this.f2702e.mo5798a() > 0) {
                    view = m3743G();
                }
                if (view != null) {
                    int i = this.f2711i0.f2825o;
                    if (!(((long) i) == -1 || (findViewById = view.findViewById(i)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    /* renamed from: O */
    private void m3751O() {
        boolean z;
        EdgeEffect edgeEffect = this.f2680I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f2680I.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f2681J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f2681J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f2682K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f2682K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f2683L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f2683L.isFinished();
        }
        if (z) {
            C0839t.m2682A(this);
        }
    }

    /* renamed from: P */
    private void m3752P() {
        C1070z zVar = this.f2711i0;
        zVar.f2824n = -1;
        zVar.f2823m = -1;
        zVar.f2825o = -1;
    }

    /* renamed from: Q */
    private void m3753Q() {
        VelocityTracker velocityTracker = this.f2687P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        mo5322g(0);
        m3751O();
    }

    /* renamed from: R */
    private void m3754R() {
        int i;
        C1039c0 c0Var = null;
        View focusedChild = (!this.f2703e0 || !hasFocus() || this.f2716l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            c0Var = mo5297d(focusedChild);
        }
        if (c0Var == null) {
            m3752P();
            return;
        }
        this.f2711i0.f2824n = this.f2716l.hasStableIds() ? c0Var.getItemId() : -1;
        C1070z zVar = this.f2711i0;
        if (this.f2675D) {
            i = -1;
        } else if (c0Var.isRemoved()) {
            i = c0Var.mOldPosition;
        } else {
            i = c0Var.getAdapterPosition();
        }
        zVar.f2823m = i;
        this.f2711i0.f2825o = m3778m(c0Var.itemView);
    }

    /* renamed from: S */
    private void m3755S() {
        this.f2705f0.mo5395b();
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5537B();
        }
    }

    /* renamed from: d */
    private void m3773d(C1039c0 c0Var) {
        View view = c0Var.itemView;
        boolean z = view.getParent() == this;
        this.f2696b.mo5677c(mo5315f(view));
        if (c0Var.isTmpDetached()) {
            this.f2702e.mo5801a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f2702e.mo5803a(view, true);
        } else {
            this.f2702e.mo5800a(view);
        }
    }

    /* renamed from: k */
    private boolean m3776k(int i, int i2) {
        m3767a(this.f2729r0);
        int[] iArr = this.f2729r0;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* renamed from: m */
    private int m3778m(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* renamed from: A */
    public void mo5241A() {
        mo5317f(0);
        m3755S();
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C1054o oVar = this.f2718m;
        if (oVar == null || !oVar.mo5568a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* renamed from: b */
    public void mo5280b(C1053n nVar) {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5208a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f2722o.remove(nVar);
        if (this.f2722o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        mo5363r();
        requestLayout();
    }

    @Deprecated
    /* renamed from: c */
    public void mo5289c(boolean z) {
        suppressLayout(z);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C1059p) && this.f2718m.mo5166a((C1059p) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5210a()) {
            return this.f2718m.mo5200a(this.f2711i0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5210a()) {
            return this.f2718m.mo5169b(this.f2711i0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5210a()) {
            return this.f2718m.mo5172c(this.f2711i0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5214b()) {
            return this.f2718m.mo5216d(this.f2711i0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5214b()) {
            return this.f2718m.mo5175e(this.f2711i0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        C1054o oVar = this.f2718m;
        if (oVar != null && oVar.mo5214b()) {
            return this.f2718m.mo5178f(this.f2711i0);
        }
        return 0;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return m3744H().mo4179a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return m3744H().mo4178a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m3744H().mo4183a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return m3744H().mo4182a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.f2722o.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.f2722o.get(i).onDrawOver(canvas, this, this.f2711i0);
        }
        EdgeEffect edgeEffect = this.f2680I;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f2706g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.f2680I;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f2681J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f2706g) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f2681J;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f2682K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2706g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.f2682K;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f2683L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2706g) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.f2683L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.f2684M == null || this.f2722o.size() <= 0 || !this.f2684M.mo5524g()) {
            z3 = z;
        }
        if (z3) {
            C0839t.m2682A(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: e */
    public void mo5313e(int i) {
    }

    /* renamed from: e */
    public boolean mo5314e(int i, int i2) {
        C1054o oVar = this.f2718m;
        int i3 = 0;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f2740x) {
            return false;
        } else {
            boolean a = oVar.mo5210a();
            boolean b = this.f2718m.mo5214b();
            if (!a || Math.abs(i) < this.f2695a0) {
                i = 0;
            }
            if (!b || Math.abs(i2) < this.f2695a0) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = a || b;
                dispatchNestedFling(f, f2, z);
                C1061r rVar = this.f2693W;
                if (rVar != null && rVar.mo5639a(i, i2)) {
                    return true;
                }
                if (z) {
                    if (a) {
                        i3 = 1;
                    }
                    if (b) {
                        i3 |= 2;
                    }
                    mo5342j(i3, 1);
                    int i4 = this.f2697b0;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.f2697b0;
                    this.f2705f0.mo5393a(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5317f(int i) {
        if (i != this.f2685N) {
            this.f2685N = i;
            if (i != 2) {
                m3755S();
            }
            mo5245a(i);
        }
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View d = this.f2718m.mo5587d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = true;
        boolean z3 = this.f2716l != null && this.f2718m != null && !mo5362q() && !this.f2740x;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                mo5276b();
                if (mo5285c(view) == null) {
                    return null;
                }
                mo5384z();
                view2 = this.f2718m.mo5154a(view, i, this.f2696b, this.f2711i0);
                mo5301d(false);
            }
        } else {
            if (this.f2718m.mo5214b()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (f2667E0) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f2718m.mo5210a()) {
                int i3 = (this.f2718m.mo5606j() == 1) ^ (i == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i3) != null) {
                    z2 = false;
                }
                if (f2667E0) {
                    i = i3;
                }
                z = z2;
            }
            if (z) {
                mo5276b();
                if (mo5285c(view) == null) {
                    return null;
                }
                mo5384z();
                this.f2718m.mo5154a(view, i, this.f2696b, this.f2711i0);
                mo5301d(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            return m3769a(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        m3761a(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5321g() {
        if (this.f2682K == null) {
            EdgeEffect a = this.f2679H.mo5505a(this, 2);
            this.f2682K = a;
            if (this.f2706g) {
                a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            return oVar.mo5173c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo5335i());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            return oVar.mo5156a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo5335i());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public int getBaseline() {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            return oVar.mo5585d();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        C1046j jVar = this.f2727q0;
        if (jVar == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return jVar.mo5504a(i, i2);
    }

    public boolean getClipToPadding() {
        return this.f2706g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5331h() {
        if (this.f2681J == null) {
            EdgeEffect a = this.f2679H.mo5505a(this, 1);
            this.f2681J = a;
            if (this.f2706g) {
                a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* renamed from: h */
    public void mo5332h(int i, int i2) {
    }

    /* renamed from: h */
    public void mo5333h(View view) {
    }

    public boolean hasNestedScrollingParent() {
        return m3744H().mo4177a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo5335i() {
        return " " + super.toString() + ", adapter:" + this.f2716l + ", layout:" + this.f2718m + ", context:" + getContext();
    }

    /* renamed from: i */
    public void mo5337i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.f2728r;
    }

    public final boolean isLayoutSuppressed() {
        return this.f2740x;
    }

    public boolean isNestedScrollingEnabled() {
        return m3744H().mo4185b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo5343j(View view) {
        mo5384z();
        boolean e = this.f2702e.mo5813e(view);
        if (e) {
            C1039c0 l = m3777l(view);
            this.f2696b.mo5677c(l);
            this.f2696b.mo5672b(l);
        }
        mo5301d(!e);
        return e;
    }

    /* renamed from: l */
    public int mo5345l() {
        return this.f2685N;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo5347n() {
        this.f2700d = new C1077a(new C1042f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo5348o() {
        this.f2683L = null;
        this.f2681J = null;
        this.f2682K = null;
        this.f2680I = null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2677F = 0;
        boolean z = true;
        this.f2728r = true;
        if (!this.f2734u || isLayoutRequested()) {
            z = false;
        }
        this.f2734u = z;
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5556a(this);
        }
        this.f2723o0 = false;
        if (f2666D0) {
            C1099e eVar = C1099e.f2988e.get();
            this.f2707g0 = eVar;
            if (eVar == null) {
                this.f2707g0 = new C1099e();
                Display i = C0839t.m2720i(this);
                float f = 60.0f;
                if (!isInEditMode() && i != null) {
                    float refreshRate = i.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                C1099e eVar2 = this.f2707g0;
                eVar2.f2992c = (long) (1.0E9f / f);
                C1099e.f2988e.set(eVar2);
            }
            this.f2707g0.mo5862a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C1099e eVar;
        super.onDetachedFromWindow();
        C1048l lVar = this.f2684M;
        if (lVar != null) {
            lVar.mo5514b();
        }
        mo5241A();
        this.f2728r = false;
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5557a(this, this.f2696b);
        }
        this.f2739w0.clear();
        removeCallbacks(this.f2741x0);
        this.f2704f.mo5928b();
        if (f2666D0 && (eVar = this.f2707g0) != null) {
            eVar.mo5864b(this);
            this.f2707g0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f2722o.size();
        for (int i = 0; i < size; i++) {
            this.f2722o.get(i).onDraw(canvas, this, this.f2711i0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.f2718m != null && !this.f2740x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.f2718m.mo5214b() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f2718m.mo5210a()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == 0.0f && f == 0.0f)) {
                        mo5268a((int) (f * this.f2699c0), (int) (f2 * this.f2701d0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f2718m.mo5214b()) {
                        f2 = -axisValue;
                    } else if (this.f2718m.mo5210a()) {
                        f = axisValue;
                        f2 = 0.0f;
                        mo5268a((int) (f * this.f2699c0), (int) (f2 * this.f2701d0), motionEvent);
                    }
                }
                f2 = 0.0f;
            }
            f = 0.0f;
            mo5268a((int) (f * this.f2699c0), (int) (f2 * this.f2701d0), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f2740x) {
            return false;
        }
        this.f2726q = null;
        if (m3771b(motionEvent)) {
            m3738B();
            return true;
        }
        C1054o oVar = this.f2718m;
        if (oVar == null) {
            return false;
        }
        boolean a = oVar.mo5210a();
        boolean b = this.f2718m.mo5214b();
        if (this.f2687P == null) {
            this.f2687P = VelocityTracker.obtain();
        }
        this.f2687P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f2742y) {
                this.f2742y = false;
            }
            this.f2686O = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f2690S = x;
            this.f2688Q = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f2691U = y;
            this.f2689R = y;
            if (this.f2685N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                mo5317f(1);
                mo5322g(1);
            }
            int[] iArr = this.f2735u0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = a ? 1 : 0;
            if (b) {
                i |= 2;
            }
            mo5342j(i, 0);
        } else if (actionMasked == 1) {
            this.f2687P.clear();
            mo5322g(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f2686O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f2686O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.f2685N != 1) {
                int i2 = x2 - this.f2688Q;
                int i3 = y2 - this.f2689R;
                if (!a || Math.abs(i2) <= this.f2692V) {
                    z = false;
                } else {
                    this.f2690S = x2;
                    z = true;
                }
                if (b && Math.abs(i3) > this.f2692V) {
                    this.f2691U = y2;
                    z = true;
                }
                if (z) {
                    mo5317f(1);
                }
            }
        } else if (actionMasked == 3) {
            m3738B();
        } else if (actionMasked == 5) {
            this.f2686O = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f2690S = x3;
            this.f2688Q = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f2691U = y3;
            this.f2689R = y3;
        } else if (actionMasked == 6) {
            m3772c(motionEvent);
        }
        if (this.f2685N == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0864b.m2832a("RV OnLayout");
        mo5286c();
        C0864b.m2831a();
        this.f2734u = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C1054o oVar = this.f2718m;
        if (oVar == null) {
            mo5288c(i, i2);
            return;
        }
        boolean z = false;
        if (oVar.mo5221u()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f2718m.mo5553a(this.f2696b, this.f2711i0, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.f2716l != null) {
                if (this.f2711i0.f2815e == 1) {
                    m3740D();
                }
                this.f2718m.mo5570b(i, i2);
                this.f2711i0.f2820j = true;
                m3741E();
                this.f2718m.mo5589d(i, i2);
                if (this.f2718m.mo5190A()) {
                    this.f2718m.mo5570b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f2711i0.f2820j = true;
                    m3741E();
                    this.f2718m.mo5589d(i, i2);
                }
            }
        } else if (this.f2730s) {
            this.f2718m.mo5553a(this.f2696b, this.f2711i0, i, i2);
        } else {
            if (this.f2672A) {
                mo5384z();
                mo5378t();
                m3749M();
                mo5379u();
                C1070z zVar = this.f2711i0;
                if (zVar.f2822l) {
                    zVar.f2818h = true;
                } else {
                    this.f2700d.mo5786b();
                    this.f2711i0.f2818h = false;
                }
                this.f2672A = false;
                mo5301d(false);
            } else if (this.f2711i0.f2822l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            C1043g gVar = this.f2716l;
            if (gVar != null) {
                this.f2711i0.f2816f = gVar.getItemCount();
            } else {
                this.f2711i0.f2816f = 0;
            }
            mo5384z();
            this.f2718m.mo5553a(this.f2696b, this.f2711i0, i, i2);
            mo5301d(false);
            this.f2711i0.f2818h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (mo5362q()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f2698c = savedState;
        super.onRestoreInstanceState(savedState.mo4406a());
        C1054o oVar = this.f2718m;
        if (oVar != null && (parcelable2 = this.f2698c.f2745c) != null) {
            oVar.mo5205a(parcelable2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f2698c;
        if (savedState2 != null) {
            savedState.mo5385a(savedState2);
        } else {
            C1054o oVar = this.f2718m;
            if (oVar != null) {
                savedState.f2745c = oVar.mo5222x();
            } else {
                savedState.f2745c = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            mo5348o();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.f2740x
            r8 = 0
            if (r0 != 0) goto L_0x01e8
            boolean r0 = r6.f2742y
            if (r0 == 0) goto L_0x000f
            goto L_0x01e8
        L_0x000f:
            boolean r0 = r17.m3768a((android.view.MotionEvent) r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.m3738B()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$o r0 = r6.f2718m
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.mo5210a()
            androidx.recyclerview.widget.RecyclerView$o r0 = r6.f2718m
            boolean r11 = r0.mo5214b()
            android.view.VelocityTracker r0 = r6.f2687P
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f2687P = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.f2735u0
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.f2735u0
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01b7
            if (r0 == r9) goto L_0x0175
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01dd
        L_0x0066:
            r17.m3772c((android.view.MotionEvent) r18)
            goto L_0x01dd
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.f2686O = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f2690S = r0
            r6.f2688Q = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f2691U = r0
            r6.f2689R = r0
            goto L_0x01dd
        L_0x0087:
            r17.m3738B()
            goto L_0x01dd
        L_0x008c:
            int r0 = r6.f2686O
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.f2686O
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.f2690S
            int r0 = r0 - r13
            int r1 = r6.f2691U
            int r1 = r1 - r14
            int r2 = r6.f2685N
            if (r2 == r9) goto L_0x00fb
            if (r10 == 0) goto L_0x00df
            if (r0 <= 0) goto L_0x00d4
            int r2 = r6.f2692V
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00db
        L_0x00d4:
            int r2 = r6.f2692V
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00db:
            if (r0 == 0) goto L_0x00df
            r2 = 1
            goto L_0x00e0
        L_0x00df:
            r2 = 0
        L_0x00e0:
            if (r11 == 0) goto L_0x00f6
            if (r1 <= 0) goto L_0x00ec
            int r3 = r6.f2692V
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00f3
        L_0x00ec:
            int r3 = r6.f2692V
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00f3:
            if (r1 == 0) goto L_0x00f6
            r2 = 1
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r6.mo5317f((int) r9)
        L_0x00fb:
            r15 = r0
            r16 = r1
            int r0 = r6.f2685N
            if (r0 != r9) goto L_0x01dd
            int[] r0 = r6.f2737v0
            r0[r8] = r8
            r0[r9] = r8
            if (r10 == 0) goto L_0x010c
            r1 = r15
            goto L_0x010d
        L_0x010c:
            r1 = 0
        L_0x010d:
            if (r11 == 0) goto L_0x0112
            r2 = r16
            goto L_0x0113
        L_0x0112:
            r2 = 0
        L_0x0113:
            int[] r3 = r6.f2737v0
            int[] r4 = r6.f2733t0
            r5 = 0
            r0 = r17
            boolean r0 = r0.mo5269a((int) r1, (int) r2, (int[]) r3, (int[]) r4, (int) r5)
            if (r0 == 0) goto L_0x0142
            int[] r0 = r6.f2737v0
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.f2735u0
            r1 = r0[r8]
            int[] r2 = r6.f2733t0
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0142:
            r0 = r16
            int[] r1 = r6.f2733t0
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.f2690S = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.f2691U = r14
            if (r10 == 0) goto L_0x0154
            r1 = r15
            goto L_0x0155
        L_0x0154:
            r1 = 0
        L_0x0155:
            if (r11 == 0) goto L_0x0159
            r2 = r0
            goto L_0x015a
        L_0x0159:
            r2 = 0
        L_0x015a:
            boolean r1 = r6.mo5268a((int) r1, (int) r2, (android.view.MotionEvent) r7)
            if (r1 == 0) goto L_0x0167
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0167:
            androidx.recyclerview.widget.e r1 = r6.f2707g0
            if (r1 == 0) goto L_0x01dd
            if (r15 != 0) goto L_0x016f
            if (r0 == 0) goto L_0x01dd
        L_0x016f:
            androidx.recyclerview.widget.e r1 = r6.f2707g0
            r1.mo5863a((androidx.recyclerview.widget.RecyclerView) r6, (int) r15, (int) r0)
            goto L_0x01dd
        L_0x0175:
            android.view.VelocityTracker r0 = r6.f2687P
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.f2687P
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.f2697b0
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0191
            android.view.VelocityTracker r1 = r6.f2687P
            int r2 = r6.f2686O
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0192
        L_0x0191:
            r1 = 0
        L_0x0192:
            if (r11 == 0) goto L_0x019e
            android.view.VelocityTracker r2 = r6.f2687P
            int r3 = r6.f2686O
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x019f
        L_0x019e:
            r2 = 0
        L_0x019f:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01a7
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01af
        L_0x01a7:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.mo5314e(r0, r1)
            if (r0 != 0) goto L_0x01b2
        L_0x01af:
            r6.mo5317f((int) r8)
        L_0x01b2:
            r17.m3753Q()
            r8 = 1
            goto L_0x01dd
        L_0x01b7:
            int r0 = r7.getPointerId(r8)
            r6.f2686O = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f2690S = r0
            r6.f2688Q = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f2691U = r0
            r6.f2689R = r0
            if (r10 == 0) goto L_0x01d5
            r0 = 1
            goto L_0x01d6
        L_0x01d5:
            r0 = 0
        L_0x01d6:
            if (r11 == 0) goto L_0x01da
            r0 = r0 | 2
        L_0x01da:
            r6.mo5342j(r0, r8)
        L_0x01dd:
            if (r8 != 0) goto L_0x01e4
            android.view.VelocityTracker r0 = r6.f2687P
            r0.addMovement(r12)
        L_0x01e4:
            r12.recycle()
            return r9
        L_0x01e8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo5361p() {
        AccessibilityManager accessibilityManager = this.f2673B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* renamed from: q */
    public boolean mo5362q() {
        return this.f2677F > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo5363r() {
        int b = this.f2702e.mo5804b();
        for (int i = 0; i < b; i++) {
            ((C1059p) this.f2702e.mo5810d(i).getLayoutParams()).f2793c = true;
        }
        this.f2696b.mo5684g();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        C1039c0 l = m3777l(view);
        if (l != null) {
            if (l.isTmpDetached()) {
                l.clearTmpDetachFlag();
            } else if (!l.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + l + mo5335i());
            }
        }
        view.clearAnimation();
        mo5278b(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2718m.mo5567a(this, this.f2711i0, view, view2) && view2 != null) {
            m3761a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f2718m.mo5564a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f2724p.size();
        for (int i = 0; i < size; i++) {
            this.f2724p.get(i).mo5641a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f2736v != 0 || this.f2740x) {
            this.f2738w = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo5369s() {
        int b = this.f2702e.mo5804b();
        for (int i = 0; i < b; i++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i));
            if (l != null && !l.shouldIgnore()) {
                l.addFlags(6);
            }
        }
        mo5363r();
        this.f2696b.mo5685h();
    }

    public void scrollBy(int i, int i2) {
        C1054o oVar = this.f2718m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f2740x) {
            boolean a = oVar.mo5210a();
            boolean b = this.f2718m.mo5214b();
            if (a || b) {
                if (!a) {
                    i = 0;
                }
                if (!b) {
                    i2 = 0;
                }
                mo5268a(i, i2, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!mo5270a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f2706g) {
            mo5348o();
        }
        this.f2706g = z;
        super.setClipToPadding(z);
        if (this.f2734u) {
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z) {
        m3744H().mo4176a(z);
    }

    public boolean startNestedScroll(int i) {
        return m3744H().mo4186b(i);
    }

    public void stopNestedScroll() {
        m3744H().mo4187c();
    }

    public final void suppressLayout(boolean z) {
        if (z != this.f2740x) {
            mo5266a("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.f2740x = false;
                if (!(!this.f2738w || this.f2718m == null || this.f2716l == null)) {
                    requestLayout();
                }
                this.f2738w = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f2740x = true;
            this.f2742y = true;
            mo5241A();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo5378t() {
        this.f2677F++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo5379u() {
        mo5267a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo5380v() {
        if (!this.f2723o0 && this.f2728r) {
            C0839t.m2699a((View) this, this.f2741x0);
            this.f2723o0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo5381w() {
        C1048l lVar = this.f2684M;
        if (lVar != null) {
            lVar.mo5514b();
        }
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5574b(this.f2696b);
            this.f2718m.mo5582c(this.f2696b);
        }
        this.f2696b.mo5660a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo5382x() {
        C1039c0 c0Var;
        int a = this.f2702e.mo5798a();
        for (int i = 0; i < a; i++) {
            View c = this.f2702e.mo5807c(i);
            C1039c0 f = mo5315f(c);
            if (!(f == null || (c0Var = f.mShadowingHolder) == null)) {
                View view = c0Var.itemView;
                int left = c.getLeft();
                int top = c.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo5383y() {
        int b = this.f2702e.mo5804b();
        for (int i = 0; i < b; i++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i));
            if (!l.shouldIgnore()) {
                l.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public void mo5384z() {
        int i = this.f2736v + 1;
        this.f2736v = i;
        if (i == 1 && !this.f2740x) {
            this.f2738w = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    class C1042f implements C1077a.C1078a {
        C1042f() {
        }

        /* renamed from: a */
        public C1039c0 mo5453a(int i) {
            C1039c0 a = RecyclerView.this.mo5242a(i, true);
            if (a != null && !RecyclerView.this.f2702e.mo5809c(a.itemView)) {
                return a;
            }
            return null;
        }

        /* renamed from: b */
        public void mo5457b(int i, int i2) {
            RecyclerView.this.mo5252a(i, i2, false);
            RecyclerView.this.f2717l0 = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5460c(C1077a.C1079b bVar) {
            int i = bVar.f2892a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f2718m.mo5163a(recyclerView, bVar.f2893b, bVar.f2895d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f2718m.mo5170b(recyclerView2, bVar.f2893b, bVar.f2895d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f2718m.mo5165a(recyclerView3, bVar.f2893b, bVar.f2895d, bVar.f2894c);
            } else if (i == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f2718m.mo5164a(recyclerView4, bVar.f2893b, bVar.f2895d, 1);
            }
        }

        /* renamed from: d */
        public void mo5461d(int i, int i2) {
            RecyclerView.this.mo5252a(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2717l0 = true;
            recyclerView.f2711i0.f2814d += i2;
        }

        /* renamed from: a */
        public void mo5455a(int i, int i2, Object obj) {
            RecyclerView.this.mo5251a(i, i2, obj);
            RecyclerView.this.f2719m0 = true;
        }

        /* renamed from: b */
        public void mo5458b(C1077a.C1079b bVar) {
            mo5460c(bVar);
        }

        /* renamed from: a */
        public void mo5456a(C1077a.C1079b bVar) {
            mo5460c(bVar);
        }

        /* renamed from: a */
        public void mo5454a(int i, int i2) {
            RecyclerView.this.mo5323g(i, i2);
            RecyclerView.this.f2717l0 = true;
        }

        /* renamed from: c */
        public void mo5459c(int i, int i2) {
            RecyclerView.this.mo5318f(i, i2);
            RecyclerView.this.f2717l0 = true;
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    /* renamed from: c */
    private void m3772c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2686O) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2686O = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f2690S = x;
            this.f2688Q = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f2691U = y;
            this.f2689R = y;
        }
    }

    /* renamed from: l */
    static C1039c0 m3777l(View view) {
        if (view == null) {
            return null;
        }
        return ((C1059p) view.getLayoutParams()).f2791a;
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b0 */
    class C1037b0 implements Runnable {

        /* renamed from: a */
        private int f2748a;

        /* renamed from: b */
        private int f2749b;

        /* renamed from: c */
        OverScroller f2750c;

        /* renamed from: d */
        Interpolator f2751d = RecyclerView.f2670H0;

        /* renamed from: e */
        private boolean f2752e = false;

        /* renamed from: f */
        private boolean f2753f = false;

        C1037b0() {
            this.f2750c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f2670H0);
        }

        /* renamed from: c */
        private void m3873c() {
            RecyclerView.this.removeCallbacks(this);
            C0839t.m2699a((View) RecyclerView.this, (Runnable) this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5392a() {
            if (this.f2752e) {
                this.f2753f = true;
            } else {
                m3873c();
            }
        }

        /* renamed from: b */
        public void mo5395b() {
            RecyclerView.this.removeCallbacks(this);
            this.f2750c.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f2718m == null) {
                mo5395b();
                return;
            }
            this.f2753f = false;
            this.f2752e = true;
            recyclerView.mo5276b();
            OverScroller overScroller = this.f2750c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f2748a;
                int i4 = currY - this.f2749b;
                this.f2748a = currX;
                this.f2749b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f2737v0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.mo5269a(i3, i4, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.f2737v0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.mo5277b(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f2716l != null) {
                    int[] iArr3 = recyclerView3.f2737v0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.mo5253a(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f2737v0;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    C1069y yVar = recyclerView4.f2718m.f2773g;
                    if (yVar != null && !yVar.mo5694b() && yVar.mo5695c()) {
                        int a = RecyclerView.this.f2711i0.mo5697a();
                        if (a == 0) {
                            yVar.mo5696d();
                        } else if (yVar.mo5690a() >= a) {
                            yVar.mo5691a(a - 1);
                            yVar.mo5692a(i, i2);
                        } else {
                            yVar.mo5692a(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.f2722o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f2737v0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.mo5247a(i, i2, i3, i4, (int[]) null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.f2737v0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    RecyclerView.this.mo5300d(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                C1069y yVar2 = RecyclerView.this.f2718m.f2773g;
                if ((yVar2 != null && yVar2.mo5694b()) || !z) {
                    mo5392a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    C1099e eVar = recyclerView6.f2707g0;
                    if (eVar != null) {
                        eVar.mo5863a(recyclerView6, i, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.mo5246a(i7, currVelocity);
                    }
                    if (RecyclerView.f2666D0) {
                        RecyclerView.this.f2709h0.mo5868a();
                    }
                }
            }
            C1069y yVar3 = RecyclerView.this.f2718m.f2773g;
            if (yVar3 != null && yVar3.mo5694b()) {
                yVar3.mo5692a(0, 0);
            }
            this.f2752e = false;
            if (this.f2753f) {
                m3873c();
                return;
            }
            RecyclerView.this.mo5317f(0);
            RecyclerView.this.mo5322g(1);
        }

        /* renamed from: a */
        public void mo5393a(int i, int i2) {
            RecyclerView.this.mo5317f(2);
            this.f2749b = 0;
            this.f2748a = 0;
            Interpolator interpolator = this.f2751d;
            Interpolator interpolator2 = RecyclerView.f2670H0;
            if (interpolator != interpolator2) {
                this.f2751d = interpolator2;
                this.f2750c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f2670H0);
            }
            this.f2750c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            mo5392a();
        }

        /* renamed from: a */
        public void mo5394a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = m3872a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.f2670H0;
            }
            if (this.f2751d != interpolator) {
                this.f2751d = interpolator;
                this.f2750c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f2749b = 0;
            this.f2748a = 0;
            RecyclerView.this.mo5317f(2);
            this.f2750c.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2750c.computeScrollOffset();
            }
            mo5392a();
        }

        /* renamed from: a */
        private float m3871a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: a */
        private int m3872a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float a = f2 + (m3871a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    public static class C1064u {

        /* renamed from: a */
        SparseArray<C1065a> f2795a = new SparseArray<>();

        /* renamed from: b */
        private int f2796b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$u$a */
        static class C1065a {

            /* renamed from: a */
            final ArrayList<C1039c0> f2797a = new ArrayList<>();

            /* renamed from: b */
            int f2798b = 5;

            /* renamed from: c */
            long f2799c = 0;

            /* renamed from: d */
            long f2800d = 0;

            C1065a() {
            }
        }

        /* renamed from: a */
        public C1039c0 mo5646a(int i) {
            C1065a aVar = this.f2795a.get(i);
            if (aVar == null || aVar.f2797a.isEmpty()) {
                return null;
            }
            ArrayList<C1039c0> arrayList = aVar.f2797a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* renamed from: b */
        public void mo5652b() {
            for (int i = 0; i < this.f2795a.size(); i++) {
                this.f2795a.valueAt(i).f2797a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5655c() {
            this.f2796b--;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5653b(int i, long j) {
            C1065a b = m4102b(i);
            b.f2799c = mo5645a(b.f2799c, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo5654b(int i, long j, long j2) {
            long j3 = m4102b(i).f2799c;
            return j3 == 0 || j + j3 < j2;
        }

        /* renamed from: b */
        private C1065a m4102b(int i) {
            C1065a aVar = this.f2795a.get(i);
            if (aVar != null) {
                return aVar;
            }
            C1065a aVar2 = new C1065a();
            this.f2795a.put(i, aVar2);
            return aVar2;
        }

        /* renamed from: a */
        public void mo5649a(C1039c0 c0Var) {
            int itemViewType = c0Var.getItemViewType();
            ArrayList<C1039c0> arrayList = m4102b(itemViewType).f2797a;
            if (this.f2795a.get(itemViewType).f2798b > arrayList.size()) {
                c0Var.resetInternal();
                arrayList.add(c0Var);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo5645a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5648a(int i, long j) {
            C1065a b = m4102b(i);
            b.f2800d = mo5645a(b.f2800d, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5651a(int i, long j, long j2) {
            long j3 = m4102b(i).f2800d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5647a() {
            this.f2796b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5650a(C1043g gVar, C1043g gVar2, boolean z) {
            if (gVar != null) {
                mo5655c();
            }
            if (!z && this.f2796b == 0) {
                mo5652b();
            }
            if (gVar2 != null) {
                mo5647a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$x */
    private class C1068x extends C1045i {
        C1068x() {
        }

        /* renamed from: a */
        public void mo5498a() {
            RecyclerView.this.mo5266a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2711i0.f2817g = true;
            recyclerView.mo5283b(true);
            if (!RecyclerView.this.f2700d.mo5788c()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* renamed from: b */
        public void mo5502b(int i, int i2) {
            RecyclerView.this.mo5266a((String) null);
            if (RecyclerView.this.f2700d.mo5787b(i, i2)) {
                mo5689b();
            }
        }

        /* renamed from: c */
        public void mo5503c(int i, int i2) {
            RecyclerView.this.mo5266a((String) null);
            if (RecyclerView.this.f2700d.mo5790c(i, i2)) {
                mo5689b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5689b() {
            if (RecyclerView.f2665C0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f2730s && recyclerView.f2728r) {
                    C0839t.m2699a((View) recyclerView, recyclerView.f2708h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f2672A = true;
            recyclerView2.requestLayout();
        }

        /* renamed from: a */
        public void mo5501a(int i, int i2, Object obj) {
            RecyclerView.this.mo5266a((String) null);
            if (RecyclerView.this.f2700d.mo5784a(i, i2, obj)) {
                mo5689b();
            }
        }

        /* renamed from: a */
        public void mo5500a(int i, int i2, int i3) {
            RecyclerView.this.mo5266a((String) null);
            if (RecyclerView.this.f2700d.mo5783a(i, i2, i3)) {
                mo5689b();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2694a = new C1068x();
        this.f2696b = new C1066v();
        this.f2704f = new C1116m();
        this.f2708h = new C1034a();
        this.f2710i = new Rect();
        this.f2712j = new Rect();
        this.f2714k = new RectF();
        this.f2722o = new ArrayList<>();
        this.f2724p = new ArrayList<>();
        this.f2736v = 0;
        this.f2675D = false;
        this.f2676E = false;
        this.f2677F = 0;
        this.f2678G = 0;
        this.f2679H = new C1047k();
        this.f2684M = new C1083c();
        this.f2685N = 0;
        this.f2686O = -1;
        this.f2699c0 = Float.MIN_VALUE;
        this.f2701d0 = Float.MIN_VALUE;
        boolean z = true;
        this.f2703e0 = true;
        this.f2705f0 = new C1037b0();
        this.f2709h0 = f2666D0 ? new C1099e.C1101b() : null;
        this.f2711i0 = new C1070z();
        this.f2717l0 = false;
        this.f2719m0 = false;
        this.f2721n0 = new C1052m();
        this.f2723o0 = false;
        this.f2729r0 = new int[2];
        this.f2733t0 = new int[2];
        this.f2735u0 = new int[2];
        this.f2737v0 = new int[2];
        this.f2739w0 = new ArrayList();
        this.f2741x0 = new C1036b();
        this.f2743y0 = new C1040d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2692V = viewConfiguration.getScaledTouchSlop();
        this.f2699c0 = C0848u.m2760b(viewConfiguration, context);
        this.f2701d0 = C0848u.m2761c(viewConfiguration, context);
        this.f2695a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2697b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f2684M.mo5509a(this.f2721n0);
        mo5347n();
        m3747K();
        m3746J();
        if (C0839t.m2723l(this) == 0) {
            C0839t.m2716f(this, 1);
        }
        this.f2673B = (AccessibilityManager) getContext().getSystemService("accessibility");
        mo5265a(new C1109i(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f2706g = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.f2732t = z2;
        if (z2) {
            mo5254a((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        m3759a(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f2671z0, i, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, f2671z0, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    /* renamed from: k */
    static RecyclerView m3775k(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView k = m3775k(viewGroup.getChildAt(i));
            if (k != null) {
                return k;
            }
        }
        return null;
    }

    /* renamed from: i */
    public void mo5336i(int i, int i2) {
        mo5248a(i, i2, (Interpolator) null);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1033a();

        /* renamed from: c */
        Parcelable f2745c;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$a */
        static class C1033a implements Parcelable.ClassLoaderCreator<SavedState> {
            C1033a() {
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2745c = parcel.readParcelable(classLoader == null ? C1054o.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5385a(SavedState savedState) {
            this.f2745c = savedState.f2745c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2745c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    public static class C1059p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        C1039c0 f2791a;

        /* renamed from: b */
        final Rect f2792b = new Rect();

        /* renamed from: c */
        boolean f2793c = true;

        /* renamed from: d */
        boolean f2794d = false;

        public C1059p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        public int mo5633a() {
            return this.f2791a.getLayoutPosition();
        }

        /* renamed from: b */
        public boolean mo5634b() {
            return this.f2791a.isUpdated();
        }

        /* renamed from: c */
        public boolean mo5635c() {
            return this.f2791a.isRemoved();
        }

        /* renamed from: d */
        public boolean mo5636d() {
            return this.f2791a.isInvalid();
        }

        public C1059p(int i, int i2) {
            super(i, i2);
        }

        public C1059p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1059p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1059p(C1059p pVar) {
            super(pVar);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$z */
    public static class C1070z {

        /* renamed from: a */
        int f2811a = -1;

        /* renamed from: b */
        private SparseArray<Object> f2812b;

        /* renamed from: c */
        int f2813c = 0;

        /* renamed from: d */
        int f2814d = 0;

        /* renamed from: e */
        int f2815e = 1;

        /* renamed from: f */
        int f2816f = 0;

        /* renamed from: g */
        boolean f2817g = false;

        /* renamed from: h */
        boolean f2818h = false;

        /* renamed from: i */
        boolean f2819i = false;

        /* renamed from: j */
        boolean f2820j = false;

        /* renamed from: k */
        boolean f2821k = false;

        /* renamed from: l */
        boolean f2822l = false;

        /* renamed from: m */
        int f2823m;

        /* renamed from: n */
        long f2824n;

        /* renamed from: o */
        int f2825o;

        /* renamed from: p */
        int f2826p;

        /* renamed from: q */
        int f2827q;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5698a(int i) {
            if ((this.f2815e & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2815e));
            }
        }

        /* renamed from: b */
        public int mo5700b() {
            return this.f2811a;
        }

        /* renamed from: c */
        public boolean mo5701c() {
            return this.f2811a != -1;
        }

        /* renamed from: d */
        public boolean mo5702d() {
            return this.f2818h;
        }

        /* renamed from: e */
        public boolean mo5703e() {
            return this.f2822l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2811a + ", mData=" + this.f2812b + ", mItemCount=" + this.f2816f + ", mIsMeasuring=" + this.f2820j + ", mPreviousLayoutItemCount=" + this.f2813c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2814d + ", mStructureChanged=" + this.f2817g + ", mInPreLayout=" + this.f2818h + ", mRunSimpleAnimations=" + this.f2821k + ", mRunPredictiveAnimations=" + this.f2822l + '}';
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5699a(C1043g gVar) {
            this.f2815e = 1;
            this.f2816f = gVar.getItemCount();
            this.f2818h = false;
            this.f2819i = false;
            this.f2820j = false;
        }

        /* renamed from: a */
        public int mo5697a() {
            return this.f2818h ? this.f2813c - this.f2814d : this.f2816f;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            return oVar.mo5157a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + mo5335i());
    }

    /* renamed from: a */
    public void mo5265a(C1109i iVar) {
        this.f2725p0 = iVar;
        C0839t.m2697a((View) this, (C0797a) iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5316f() {
        if (this.f2680I == null) {
            EdgeEffect a = this.f2679H.mo5505a(this, 0);
            this.f2680I = a;
            if (this.f2706g) {
                a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* renamed from: m */
    public boolean mo5346m() {
        return !this.f2734u || this.f2675D || this.f2700d.mo5788c();
    }

    /* renamed from: a */
    private void m3759a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a = m3756a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(a, false, classLoader).asSubclass(C1054o.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(f2669G0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    mo5261a((C1054o) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e7);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5288c(int i, int i2) {
        setMeasuredDimension(C1054o.m3943a(i, getPaddingLeft() + getPaddingRight(), C0839t.m2727p(this)), C1054o.m3943a(i2, getPaddingTop() + getPaddingBottom(), C0839t.m2726o(this)));
    }

    /* renamed from: j */
    public C1054o mo5341j() {
        return this.f2718m;
    }

    /* renamed from: b */
    public void mo5282b(C1063t tVar) {
        List<C1063t> list = this.f2715k0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5301d(boolean z) {
        if (this.f2736v < 1) {
            this.f2736v = 1;
        }
        if (!z && !this.f2740x) {
            this.f2738w = false;
        }
        if (this.f2736v == 1) {
            if (z && this.f2738w && !this.f2740x && this.f2718m != null && this.f2716l != null) {
                mo5286c();
            }
            if (!this.f2740x) {
                this.f2738w = false;
            }
        }
        this.f2736v--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5323g(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int b = this.f2702e.mo5804b();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < b; i7++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i7));
            if (l != null && (i6 = l.mPosition) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    l.offsetPosition(i2 - i, false);
                } else {
                    l.offsetPosition(i5, false);
                }
                this.f2711i0.f2817g = true;
            }
        }
        this.f2696b.mo5670b(i, i2);
        requestLayout();
    }

    /* renamed from: j */
    public boolean mo5342j(int i, int i2) {
        return m3744H().mo4181a(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5276b() {
        if (!this.f2734u || this.f2675D) {
            C0864b.m2832a("RV FullInvalidate");
            mo5286c();
            C0864b.m2831a();
        } else if (this.f2700d.mo5788c()) {
            if (this.f2700d.mo5789c(4) && !this.f2700d.mo5789c(11)) {
                C0864b.m2832a("RV PartialInvalidate");
                mo5384z();
                mo5378t();
                this.f2700d.mo5792e();
                if (!this.f2738w) {
                    if (m3745I()) {
                        mo5286c();
                    } else {
                        this.f2700d.mo5779a();
                    }
                }
                mo5301d(true);
                mo5379u();
                C0864b.m2831a();
            } else if (this.f2700d.mo5788c()) {
                C0864b.m2832a("RV FullInvalidate");
                mo5286c();
                C0864b.m2831a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public long mo5344k() {
        if (f2666D0) {
            return System.nanoTime();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5318f(int i, int i2) {
        int b = this.f2702e.mo5804b();
        for (int i3 = 0; i3 < b; i3++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i3));
            if (l != null && !l.shouldIgnore() && l.mPosition >= i) {
                l.offsetPosition(i2, false);
                this.f2711i0.f2817g = true;
            }
        }
        this.f2696b.mo5661a(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5286c() {
        if (this.f2716l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f2718m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            C1070z zVar = this.f2711i0;
            zVar.f2820j = false;
            if (zVar.f2815e == 1) {
                m3740D();
                this.f2718m.mo5594e(this);
                m3741E();
            } else if (!this.f2700d.mo5791d() && this.f2718m.mo5619q() == getWidth() && this.f2718m.mo5602h() == getHeight()) {
                this.f2718m.mo5594e(this);
            } else {
                this.f2718m.mo5594e(this);
                m3741E();
            }
            m3742F();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5312e() {
        if (this.f2683L == null) {
            EdgeEffect a = this.f2679H.mo5505a(this, 3);
            this.f2683L = a;
            if (this.f2706g) {
                a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Rect mo5320g(View view) {
        C1059p pVar = (C1059p) view.getLayoutParams();
        if (!pVar.f2793c) {
            return pVar.f2792b;
        }
        if (this.f2711i0.mo5702d() && (pVar.mo5634b() || pVar.mo5636d())) {
            return pVar.f2792b;
        }
        Rect rect = pVar.f2792b;
        rect.set(0, 0, 0, 0);
        int size = this.f2722o.size();
        for (int i = 0; i < size; i++) {
            this.f2710i.set(0, 0, 0, 0);
            this.f2722o.get(i).getItemOffsets(this.f2710i, view, this, this.f2711i0);
            int i2 = rect.left;
            Rect rect2 = this.f2710i;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f2793c = false;
        return rect;
    }

    /* renamed from: d */
    public C1039c0 mo5297d(View view) {
        View c = mo5285c(view);
        if (c == null) {
            return null;
        }
        return mo5315f(c);
    }

    /* renamed from: f */
    public C1039c0 mo5315f(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m3777l(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* renamed from: d */
    public void mo5299d(int i) {
        int a = this.f2702e.mo5798a();
        for (int i2 = 0; i2 < a; i2++) {
            this.f2702e.mo5807c(i2).offsetTopAndBottom(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5300d(int i, int i2) {
        this.f2678G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        mo5332h(i, i2);
        C1063t tVar = this.f2713j0;
        if (tVar != null) {
            tVar.mo5644a(this, i, i2);
        }
        List<C1063t> list = this.f2715k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2715k0.get(size).mo5644a(this, i, i2);
            }
        }
        this.f2678G--;
    }

    /* renamed from: e */
    public int mo5311e(View view) {
        C1039c0 l = m3777l(view);
        if (l != null) {
            return l.getAdapterPosition();
        }
        return -1;
    }

    /* renamed from: e */
    static void m3774e(C1039c0 c0Var) {
        WeakReference<RecyclerView> weakReference = c0Var.mNestedRecyclerView;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != c0Var.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            c0Var.mNestedRecyclerView = null;
        }
    }

    /* renamed from: a */
    private String m3756a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo5284c(C1039c0 c0Var) {
        return this.f2716l.hasStableIds() ? c0Var.getItemId() : (long) c0Var.mPosition;
    }

    /* renamed from: c */
    public View mo5285c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* renamed from: g */
    public void mo5322g(int i) {
        m3744H().mo4188c(i);
    }

    /* renamed from: a */
    public void mo5258a(C1043g gVar) {
        mo5289c(false);
        m3763a(gVar, false, true);
        mo5283b(false);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5277b(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.f2680I;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.f2680I.onRelease();
            z = this.f2680I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f2682K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f2682K.onRelease();
            z |= this.f2682K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f2681J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.f2681J.onRelease();
            z |= this.f2681J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f2683L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f2683L.onRelease();
            z |= this.f2683L.isFinished();
        }
        if (z) {
            C0839t.m2682A(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5298d() {
        int i;
        for (int size = this.f2739w0.size() - 1; size >= 0; size--) {
            C1039c0 c0Var = this.f2739w0.get(size);
            if (c0Var.itemView.getParent() == this && !c0Var.shouldIgnore() && (i = c0Var.mPendingAccessibilityState) != -1) {
                C0839t.m2716f(c0Var.itemView, i);
                c0Var.mPendingAccessibilityState = -1;
            }
        }
        this.f2739w0.clear();
    }

    /* renamed from: c */
    public void mo5287c(int i) {
        int a = this.f2702e.mo5798a();
        for (int i2 = 0; i2 < a; i2++) {
            this.f2702e.mo5807c(i2).offsetLeftAndRight(i);
        }
    }

    /* renamed from: a */
    private void m3763a(C1043g gVar, boolean z, boolean z2) {
        C1043g gVar2 = this.f2716l;
        if (gVar2 != null) {
            gVar2.unregisterAdapterDataObserver(this.f2694a);
            this.f2716l.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            mo5381w();
        }
        this.f2700d.mo5793f();
        C1043g gVar3 = this.f2716l;
        this.f2716l = gVar;
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.f2694a);
            gVar.onAttachedToRecyclerView(this);
        }
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5551a(gVar3, this.f2716l);
        }
        this.f2696b.mo5666a(gVar3, this.f2716l, z);
        this.f2711i0.f2817g = true;
    }

    /* renamed from: b */
    public void mo5281b(C1062s sVar) {
        this.f2724p.remove(sVar);
        if (this.f2726q == sVar) {
            this.f2726q = null;
        }
    }

    /* renamed from: b */
    private boolean m3771b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f2724p.size();
        int i = 0;
        while (i < size) {
            C1062s sVar = this.f2724p.get(i);
            if (!sVar.mo5642b(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f2726q = sVar;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo5261a(C1054o oVar) {
        if (oVar != this.f2718m) {
            mo5241A();
            if (this.f2718m != null) {
                C1048l lVar = this.f2684M;
                if (lVar != null) {
                    lVar.mo5514b();
                }
                this.f2718m.mo5574b(this.f2696b);
                this.f2718m.mo5582c(this.f2696b);
                this.f2696b.mo5660a();
                if (this.f2728r) {
                    this.f2718m.mo5557a(this, this.f2696b);
                }
                this.f2718m.mo5597f((RecyclerView) null);
                this.f2718m = null;
            } else {
                this.f2696b.mo5660a();
            }
            this.f2702e.mo5808c();
            this.f2718m = oVar;
            if (oVar != null) {
                if (oVar.f2768b == null) {
                    oVar.mo5597f(this);
                    if (this.f2728r) {
                        this.f2718m.mo5556a(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f2768b.mo5335i());
                }
            }
            this.f2696b.mo5687j();
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5279b(C1039c0 c0Var, C1048l.C1051c cVar, C1048l.C1051c cVar2) {
        m3773d(c0Var);
        c0Var.setIsRecyclable(false);
        if (this.f2684M.mo5516b(c0Var, cVar, cVar2)) {
            mo5380v();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5283b(boolean z) {
        this.f2676E = z | this.f2676E;
        this.f2675D = true;
        mo5369s();
    }

    /* renamed from: b */
    public C1039c0 mo5275b(int i) {
        C1039c0 c0Var = null;
        if (this.f2675D) {
            return null;
        }
        int b = this.f2702e.mo5804b();
        for (int i2 = 0; i2 < b; i2++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i2));
            if (l != null && !l.isRemoved() && mo5274b(l) == i) {
                if (!this.f2702e.mo5809c(l.itemView)) {
                    return l;
                }
                c0Var = l;
            }
        }
        return c0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5278b(View view) {
        C1039c0 l = m3777l(view);
        mo5337i(view);
        C1043g gVar = this.f2716l;
        if (!(gVar == null || l == null)) {
            gVar.onViewDetachedFromWindow(l);
        }
        List<C1060q> list = this.f2674C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2674C.get(size).mo5637a(view);
            }
        }
    }

    /* renamed from: a */
    public void mo5260a(C1053n nVar, int i) {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5208a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f2722o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f2722o.add(nVar);
        } else {
            this.f2722o.add(i, nVar);
        }
        mo5363r();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5274b(C1039c0 c0Var) {
        if (c0Var.hasAnyOfTheFlags(524) || !c0Var.isBound()) {
            return -1;
        }
        return this.f2700d.mo5776a(c0Var.mPosition);
    }

    /* renamed from: a */
    public void mo5259a(C1053n nVar) {
        mo5260a(nVar, -1);
    }

    /* renamed from: a */
    public void mo5263a(C1063t tVar) {
        if (this.f2715k0 == null) {
            this.f2715k0 = new ArrayList();
        }
        this.f2715k0.add(tVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5253a(int i, int i2, int[] iArr) {
        mo5384z();
        mo5378t();
        C0864b.m2832a("RV Scroll");
        mo5264a(this.f2711i0);
        int a = i != 0 ? this.f2718m.mo5152a(i, this.f2696b, this.f2711i0) : 0;
        int b = i2 != 0 ? this.f2718m.mo5167b(i2, this.f2696b, this.f2711i0) : 0;
        C0864b.m2831a();
        mo5382x();
        mo5379u();
        mo5301d(false);
        if (iArr != null) {
            iArr[0] = a;
            iArr[1] = b;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5268a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        MotionEvent motionEvent2 = motionEvent;
        mo5276b();
        if (this.f2716l != null) {
            int[] iArr = this.f2737v0;
            iArr[0] = 0;
            iArr[1] = 0;
            mo5253a(i7, i8, iArr);
            int[] iArr2 = this.f2737v0;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i6 = i10;
            i5 = i9;
            i4 = i7 - i9;
            i3 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.f2722o.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f2737v0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        mo5247a(i5, i6, i4, i3, this.f2733t0, 0, iArr3);
        int[] iArr4 = this.f2737v0;
        int i11 = i4 - iArr4[0];
        int i12 = i3 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.f2690S;
        int[] iArr5 = this.f2733t0;
        this.f2690S = i13 - iArr5[0];
        this.f2691U -= iArr5[1];
        int[] iArr6 = this.f2735u0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !C0827h.m2646a(motionEvent2, 8194)) {
                m3757a(motionEvent.getX(), (float) i11, motionEvent.getY(), (float) i12);
            }
            mo5277b(i, i2);
        }
        if (!(i5 == 0 && i6 == 0)) {
            mo5300d(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z && i5 == 0 && i6 == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo5248a(int i, int i2, Interpolator interpolator) {
        mo5249a(i, i2, interpolator, Integer.MIN_VALUE);
    }

    /* renamed from: a */
    public void mo5249a(int i, int i2, Interpolator interpolator, int i3) {
        mo5250a(i, i2, interpolator, i3, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5250a(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        C1054o oVar = this.f2718m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f2740x) {
            int i4 = 0;
            if (!oVar.mo5210a()) {
                i = 0;
            }
            if (!this.f2718m.mo5214b()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        mo5342j(i4, 1);
                    }
                    this.f2705f0.mo5394a(i, i2, i3, interpolator);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3757a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.mo5316f()
            android.widget.EdgeEffect r3 = r6.f2680I
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.C0874d.m2923a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.mo5321g()
            android.widget.EdgeEffect r3 = r6.f2682K
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.C0874d.m2923a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.mo5331h()
            android.widget.EdgeEffect r9 = r6.f2681J
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.C0874d.m2923a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.mo5312e()
            android.widget.EdgeEffect r9 = r6.f2683L
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.C0874d.m2923a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.p020f.C0839t.m2682A(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m3757a(float, float, float, float):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5246a(int i, int i2) {
        if (i < 0) {
            mo5316f();
            if (this.f2680I.isFinished()) {
                this.f2680I.onAbsorb(-i);
            }
        } else if (i > 0) {
            mo5321g();
            if (this.f2682K.isFinished()) {
                this.f2682K.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            mo5331h();
            if (this.f2681J.isFinished()) {
                this.f2681J.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            mo5312e();
            if (this.f2683L.isFinished()) {
                this.f2683L.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            C0839t.m2682A(this);
        }
    }

    /* renamed from: a */
    private boolean m3769a(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || mo5285c(view2) == null) {
            return false;
        }
        if (view == null || mo5285c(view) == null) {
            return true;
        }
        this.f2710i.set(0, 0, view.getWidth(), view.getHeight());
        this.f2712j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f2710i);
        offsetDescendantRectToMyCoords(view2, this.f2712j);
        char c = 65535;
        int i3 = this.f2718m.mo5606j() == 1 ? -1 : 1;
        Rect rect = this.f2710i;
        int i4 = rect.left;
        int i5 = this.f2712j.left;
        if ((i4 < i5 || rect.right <= i5) && this.f2710i.right < this.f2712j.right) {
            i2 = 1;
        } else {
            Rect rect2 = this.f2710i;
            int i6 = rect2.right;
            int i7 = this.f2712j.right;
            i2 = ((i6 > i7 || rect2.left >= i7) && this.f2710i.left > this.f2712j.left) ? -1 : 0;
        }
        Rect rect3 = this.f2710i;
        int i8 = rect3.top;
        int i9 = this.f2712j.top;
        if ((i8 < i9 || rect3.bottom <= i9) && this.f2710i.bottom < this.f2712j.bottom) {
            c = 1;
        } else {
            Rect rect4 = this.f2710i;
            int i10 = rect4.bottom;
            int i11 = this.f2712j.bottom;
            if ((i10 <= i11 && rect4.top < i11) || this.f2710i.top <= this.f2712j.top) {
                c = 0;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i + mo5335i());
                            } else if (c > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i2 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i2 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c > 0 || (c == 0 && i2 * i3 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c < 0 || (c == 0 && i2 * i3 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private void m3761a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f2710i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C1059p) {
            C1059p pVar = (C1059p) layoutParams;
            if (!pVar.f2793c) {
                Rect rect = pVar.f2792b;
                Rect rect2 = this.f2710i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f2710i);
            offsetRectIntoDescendantCoords(view, this.f2710i);
        }
        this.f2718m.mo5565a(this, view, this.f2710i, !this.f2734u, view2 == null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5266a(String str) {
        if (mo5362q()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + mo5335i());
            }
            throw new IllegalStateException(str);
        } else if (this.f2678G > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + mo5335i()));
        }
    }

    /* renamed from: a */
    public void mo5262a(C1062s sVar) {
        this.f2724p.add(sVar);
    }

    /* renamed from: a */
    private boolean m3768a(MotionEvent motionEvent) {
        C1062s sVar = this.f2726q;
        if (sVar != null) {
            sVar.mo5640a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f2726q = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return m3771b(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5267a(boolean z) {
        int i = this.f2677F - 1;
        this.f2677F = i;
        if (i < 1) {
            this.f2677F = 0;
            if (z) {
                m3739C();
                mo5298d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5270a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!mo5362q()) {
            return false;
        }
        int a = accessibilityEvent != null ? C0806b.m2547a(accessibilityEvent) : 0;
        if (a != 0) {
            i = a;
        }
        this.f2744z |= i;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5264a(C1070z zVar) {
        if (mo5345l() == 2) {
            OverScroller overScroller = this.f2705f0.f2750c;
            zVar.f2826p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f2827q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        zVar.f2826p = 0;
        zVar.f2827q = 0;
    }

    /* renamed from: a */
    private void m3758a(long j, C1039c0 c0Var, C1039c0 c0Var2) {
        int a = this.f2702e.mo5798a();
        for (int i = 0; i < a; i++) {
            C1039c0 l = m3777l(this.f2702e.mo5807c(i));
            if (l != c0Var && mo5284c(l) == j) {
                C1043g gVar = this.f2716l;
                if (gVar == null || !gVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + l + " \n View Holder 2:" + c0Var + mo5335i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + l + " \n View Holder 2:" + c0Var + mo5335i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0Var + mo5335i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5256a(C1039c0 c0Var, C1048l.C1051c cVar) {
        c0Var.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.f2711i0.f2819i && c0Var.isUpdated() && !c0Var.isRemoved() && !c0Var.shouldIgnore()) {
            this.f2704f.mo5924a(mo5284c(c0Var), c0Var);
        }
        this.f2704f.mo5931c(c0Var, cVar);
    }

    /* renamed from: a */
    private void m3767a(int[] iArr) {
        int a = this.f2702e.mo5798a();
        if (a == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < a; i3++) {
            C1039c0 l = m3777l(this.f2702e.mo5807c(i3));
            if (!l.shouldIgnore()) {
                int layoutPosition = l.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5257a(C1039c0 c0Var, C1048l.C1051c cVar, C1048l.C1051c cVar2) {
        c0Var.setIsRecyclable(false);
        if (this.f2684M.mo5512a(c0Var, cVar, cVar2)) {
            mo5380v();
        }
    }

    /* renamed from: a */
    private void m3762a(C1039c0 c0Var, C1039c0 c0Var2, C1048l.C1051c cVar, C1048l.C1051c cVar2, boolean z, boolean z2) {
        c0Var.setIsRecyclable(false);
        if (z) {
            m3773d(c0Var);
        }
        if (c0Var != c0Var2) {
            if (z2) {
                m3773d(c0Var2);
            }
            c0Var.mShadowedHolder = c0Var2;
            m3773d(c0Var);
            this.f2696b.mo5677c(c0Var);
            c0Var2.setIsRecyclable(false);
            c0Var2.mShadowingHolder = c0Var;
        }
        if (this.f2684M.mo5511a(c0Var, c0Var2, cVar, cVar2)) {
            mo5380v();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5244a() {
        int b = this.f2702e.mo5804b();
        for (int i = 0; i < b; i++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i));
            if (!l.shouldIgnore()) {
                l.clearOldPosition();
            }
        }
        this.f2696b.mo5669b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5252a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int b = this.f2702e.mo5804b();
        for (int i4 = 0; i4 < b; i4++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i4));
            if (l != null && !l.shouldIgnore()) {
                int i5 = l.mPosition;
                if (i5 >= i3) {
                    l.offsetPosition(-i2, z);
                    this.f2711i0.f2817g = true;
                } else if (i5 >= i) {
                    l.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.f2711i0.f2817g = true;
                }
            }
        }
        this.f2696b.mo5662a(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5251a(int i, int i2, Object obj) {
        int i3;
        int b = this.f2702e.mo5804b();
        int i4 = i + i2;
        for (int i5 = 0; i5 < b; i5++) {
            View d = this.f2702e.mo5810d(i5);
            C1039c0 l = m3777l(d);
            if (l != null && !l.shouldIgnore() && (i3 = l.mPosition) >= i && i3 < i4) {
                l.addFlags(2);
                l.addChangePayload(obj);
                ((C1059p) d.getLayoutParams()).f2793c = true;
            }
        }
        this.f2696b.mo5675c(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5271a(C1039c0 c0Var) {
        C1048l lVar = this.f2684M;
        return lVar == null || lVar.mo5513a(c0Var, c0Var.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1039c0 mo5242a(int i, boolean z) {
        int b = this.f2702e.mo5804b();
        C1039c0 c0Var = null;
        for (int i2 = 0; i2 < b; i2++) {
            C1039c0 l = m3777l(this.f2702e.mo5810d(i2));
            if (l != null && !l.isRemoved()) {
                if (z) {
                    if (l.mPosition != i) {
                        continue;
                    }
                } else if (l.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.f2702e.mo5809c(l.itemView)) {
                    return l;
                }
                c0Var = l;
            }
        }
        return c0Var;
    }

    /* renamed from: a */
    public C1039c0 mo5243a(long j) {
        C1043g gVar = this.f2716l;
        C1039c0 c0Var = null;
        if (gVar != null && gVar.hasStableIds()) {
            int b = this.f2702e.mo5804b();
            for (int i = 0; i < b; i++) {
                C1039c0 l = m3777l(this.f2702e.mo5810d(i));
                if (l != null && !l.isRemoved() && l.getItemId() == j) {
                    if (!this.f2702e.mo5809c(l.itemView)) {
                        return l;
                    }
                    c0Var = l;
                }
            }
        }
        return c0Var;
    }

    /* renamed from: a */
    static void m3760a(View view, Rect rect) {
        C1059p pVar = (C1059p) view.getLayoutParams();
        Rect rect2 = pVar.f2792b;
        rect.set((view.getLeft() - rect2.left) - pVar.leftMargin, (view.getTop() - rect2.top) - pVar.topMargin, view.getRight() + rect2.right + pVar.rightMargin, view.getBottom() + rect2.bottom + pVar.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5245a(int i) {
        C1054o oVar = this.f2718m;
        if (oVar != null) {
            oVar.mo5596f(i);
        }
        mo5313e(i);
        C1063t tVar = this.f2713j0;
        if (tVar != null) {
            tVar.mo5643a(this, i);
        }
        List<C1063t> list = this.f2715k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2715k0.get(size).mo5643a(this, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5255a(View view) {
        C1039c0 l = m3777l(view);
        mo5333h(view);
        C1043g gVar = this.f2716l;
        if (!(gVar == null || l == null)) {
            gVar.onViewAttachedToWindow(l);
        }
        List<C1060q> list = this.f2674C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2674C.get(size).mo5638b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5272a(C1039c0 c0Var, int i) {
        if (mo5362q()) {
            c0Var.mPendingAccessibilityState = i;
            this.f2739w0.add(c0Var);
            return false;
        }
        C0839t.m2716f(c0Var.itemView, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5254a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + mo5335i());
        }
        Resources resources = getContext().getResources();
        new C1094d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
    }

    /* renamed from: a */
    public final void mo5247a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m3744H().mo4175a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: a */
    public boolean mo5269a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return m3744H().mo4184a(i, i2, iArr, iArr2, i3);
    }
}
