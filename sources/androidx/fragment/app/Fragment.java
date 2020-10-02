package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.C0744n;
import androidx.core.p019e.C0788a;
import androidx.core.p020f.C0824e;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0968f;
import androidx.lifecycle.C0969g;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0971i;
import androidx.lifecycle.C0977m;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.C0987t;
import androidx.lifecycle.LiveData;
import androidx.loader.p025a.C0988a;
import androidx.savedstate.C1122a;
import androidx.savedstate.C1123b;
import androidx.savedstate.SavedStateRegistry;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, C0970h, C0987t, C1123b {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    C0904d mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    C0920i mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    C0920i mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    C0916g mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    C0971i mLifecycleRegistry;
    C0965e.C0967b mMaxState;
    boolean mMenuVisible;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C1122a mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    C0954o mViewLifecycleOwner;
    C0977m<C0970h> mViewLifecycleOwnerLiveData;
    String mWho;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0900a();

        /* renamed from: a */
        final Bundle f2272a;

        /* renamed from: androidx.fragment.app.Fragment$SavedState$a */
        static class C0900a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0900a() {
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f2272a = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f2272a);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$a */
    class C0901a implements Runnable {
        C0901a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$b */
    class C0902b implements Runnable {
        C0902b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$d */
    static class C0904d {

        /* renamed from: a */
        View f2276a;

        /* renamed from: b */
        Animator f2277b;

        /* renamed from: c */
        int f2278c;

        /* renamed from: d */
        int f2279d;

        /* renamed from: e */
        int f2280e;

        /* renamed from: f */
        int f2281f;

        /* renamed from: g */
        Object f2282g = null;

        /* renamed from: h */
        Object f2283h;

        /* renamed from: i */
        Object f2284i;

        /* renamed from: j */
        Object f2285j;

        /* renamed from: k */
        Object f2286k;

        /* renamed from: l */
        Object f2287l;

        /* renamed from: m */
        Boolean f2288m;

        /* renamed from: n */
        Boolean f2289n;

        /* renamed from: o */
        C0744n f2290o;

        /* renamed from: p */
        C0744n f2291p;

        /* renamed from: q */
        boolean f2292q;

        /* renamed from: r */
        C0905e f2293r;

        /* renamed from: s */
        boolean f2294s;

        C0904d() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f2283h = obj;
            this.f2284i = null;
            this.f2285j = obj;
            this.f2286k = null;
            this.f2287l = obj;
            this.f2290o = null;
            this.f2291p = null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$e */
    interface C0905e {
        /* renamed from: a */
        void mo4652a();

        /* renamed from: b */
        void mo4653b();
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new C0920i();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new C0901a();
        this.mMaxState = C0965e.C0967b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new C0977m<>();
        initLifecycle();
    }

    private C0904d ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0904d();
        }
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new C0971i(this);
        this.mSavedStateRegistryController = C1122a.m4589a((C1123b) this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.mo4996a((C0969g) new C0968f() {
                /* renamed from: a */
                public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
                    View view;
                    if (aVar == C0965e.C0966a.ON_STOP && (view = Fragment.this.mView) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public void callStartTransitionListener() {
        C0904d dVar = this.mAnimationInfo;
        C0905e eVar = null;
        if (dVar != null) {
            dVar.f2292q = false;
            C0905e eVar2 = dVar.f2293r;
            dVar.f2293r = null;
            eVar = eVar2;
        }
        if (eVar != null) {
            eVar.mo4653b();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            C0988a.m3506a(this).mo5023a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        C0920i iVar = this.mChildFragmentManager;
        iVar.mo4783a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.mo4829b(str);
    }

    public final C0911c getActivity() {
        C0916g gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return (C0911c) gVar.mo4774b();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null || (bool = dVar.f2289n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null || (bool = dVar.f2288m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public View getAnimatingAway() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2276a;
    }

    /* access modifiers changed from: package-private */
    public Animator getAnimator() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2277b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final C0917h getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        C0916g gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return gVar.mo4775c();
    }

    public Object getEnterTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2282g;
    }

    /* access modifiers changed from: package-private */
    public C0744n getEnterTransitionCallback() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2290o;
    }

    public Object getExitTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2284i;
    }

    /* access modifiers changed from: package-private */
    public C0744n getExitTransitionCallback() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2291p;
    }

    public final C0917h getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        C0916g gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return gVar.mo4743e();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater((Bundle) null) : layoutInflater;
    }

    public C0965e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public C0988a getLoaderManager() {
        return C0988a.m3506a(this);
    }

    /* access modifiers changed from: package-private */
    public int getNextAnim() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2279d;
    }

    /* access modifiers changed from: package-private */
    public int getNextTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2280e;
    }

    /* access modifiers changed from: package-private */
    public int getNextTransitionStyle() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2281f;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f2285j;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f2283h;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mo5943a();
    }

    public Object getSharedElementEnterTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        return dVar.f2286k;
    }

    public Object getSharedElementReturnTransition() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f2287l;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    /* access modifiers changed from: package-private */
    public int getStateAfterAnimating() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2278c;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        C0920i iVar = this.mFragmentManager;
        if (iVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return iVar.f2342g.get(str);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public C0970h getViewLifecycleOwner() {
        C0954o oVar = this.mViewLifecycleOwner;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<C0970h> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public C0986s getViewModelStore() {
        C0920i iVar = this.mFragmentManager;
        if (iVar != null) {
            return iVar.mo4852g(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new C0920i();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return false;
        }
        return dVar.f2294s;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    /* access modifiers changed from: package-private */
    public boolean isPostponed() {
        C0904d dVar = this.mAnimationInfo;
        if (dVar == null) {
            return false;
        }
        return dVar.f2292q;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isStateSaved() {
        C0920i iVar = this.mFragmentManager;
        if (iVar == null) {
            return false;
        }
        return iVar.mo4887w();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r1.mView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVisible() {
        /*
            r1 = this;
            boolean r0 = r1.isAdded()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.isHidden()
            if (r0 != 0) goto L_0x0020
            android.view.View r0 = r1.mView
            if (r0 == 0) goto L_0x0020
            android.os.IBinder r0 = r0.getWindowToken()
            if (r0 == 0) goto L_0x0020
            android.view.View r0 = r1.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.isVisible():boolean");
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.mo4888x();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        C0916g gVar = this.mHost;
        Activity b = gVar == null ? null : gVar.mo4774b();
        if (b != null) {
            this.mCalled = false;
            onAttach(b);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.mo4842c(1)) {
            this.mChildFragmentManager.mo4853g();
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        C0916g gVar = this.mHost;
        Activity b = gVar == null ? null : gVar.mo4774b();
        if (b != null) {
            this.mCalled = false;
            onInflate(b, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.mo4888x();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.mChildFragmentManager.mo4850f();
            return;
        }
        throw new C0955p("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void performAttach() {
        this.mChildFragmentManager.mo4822a(this.mHost, (C0913d) new C0903c(), this);
        this.mCalled = false;
        onAttach(this.mHost.mo4775c());
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.mo4809a(configuration);
    }

    /* access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!onContextItemSelected(menuItem) && !this.mChildFragmentManager.mo4826a(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.mo4888x();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.mo5944a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_CREATE);
            return;
        }
        throw new C0955p("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.mo4825a(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.mo4888x();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new C0954o();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.mo4963a();
            this.mViewLifecycleOwnerLiveData.mo4973b(this.mViewLifecycleOwner);
        } else if (!this.mViewLifecycleOwner.mo4965b()) {
            this.mViewLifecycleOwner = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.mo4855h();
        this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.mo4858i();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            C0988a.m3506a(this).mo5022a();
            this.mPerformedCreateView = false;
            return;
        }
        throw new C0955p("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.mChildFragmentManager.mo4886v()) {
            this.mChildFragmentManager.mo4855h();
            this.mChildFragmentManager = new C0920i();
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.mo4860j();
    }

    /* access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.mo4824a(z);
    }

    /* access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if ((!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) && !this.mChildFragmentManager.mo4838b(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.mo4812a(menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.mo4862k();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_PAUSE);
        }
        this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.mo4836b(z);
    }

    /* access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.mo4837b(menu);
    }

    /* access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean i = this.mFragmentManager.mo4859i(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != i) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(i);
            onPrimaryNavigationFragmentChanged(i);
            this.mChildFragmentManager.mo4864l();
        }
    }

    /* access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.mo4888x();
        this.mChildFragmentManager.mo4877q();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_RESUME);
            }
            this.mChildFragmentManager.mo4866m();
            this.mChildFragmentManager.mo4877q();
            return;
        }
        throw new C0955p("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.mo5945b(bundle);
        Parcelable z = this.mChildFragmentManager.mo4890z();
        if (z != null) {
            bundle.putParcelable("android:support:fragments", z);
        }
    }

    /* access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.mo4888x();
        this.mChildFragmentManager.mo4877q();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_START);
            }
            this.mChildFragmentManager.mo4868n();
            return;
        }
        throw new C0955p("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.mo4870o();
        if (this.mView != null) {
            this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_STOP);
        }
        this.mLifecycleRegistry.mo4999a(C0965e.C0966a.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f2292q = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            gVar.mo4739a(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final C0911c requireActivity() {
        C0911c activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final C0917h requireFragmentManager() {
        C0917h fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.mo4811a(parcelable);
            this.mChildFragmentManager.mo4853g();
        }
    }

    /* access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new C0955p("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.mo4964a(C0965e.C0966a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2289n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f2288m = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f2276a = view;
    }

    /* access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f2277b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(C0744n nVar) {
        ensureAnimationInfo().f2290o = nVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f2282g = obj;
    }

    public void setExitSharedElementCallback(C0744n nVar) {
        ensureAnimationInfo().f2291p = nVar;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f2284i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.mo4747i();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().f2294s = z;
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (savedState == null || (bundle = savedState.f2272a) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo4747i();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().f2279d = i;
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo != null || i != 0 || i2 != 0) {
            ensureAnimationInfo();
            C0904d dVar = this.mAnimationInfo;
            dVar.f2280e = i;
            dVar.f2281f = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(C0905e eVar) {
        ensureAnimationInfo();
        C0905e eVar2 = this.mAnimationInfo.f2293r;
        if (eVar != eVar2) {
            if (eVar == null || eVar2 == null) {
                C0904d dVar = this.mAnimationInfo;
                if (dVar.f2292q) {
                    dVar.f2293r = eVar;
                }
                if (eVar != null) {
                    eVar.mo4652a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f2285j = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        C0920i iVar = this.mFragmentManager;
        if (iVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            iVar.mo4813a(this);
        } else {
            iVar.mo4875p(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f2283h = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f2286k = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f2287l = obj;
    }

    /* access modifiers changed from: package-private */
    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f2278c = i;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        C0917h fragmentManager = getFragmentManager();
        C0917h fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (fragment2 != this) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            }
            this.mTargetRequestCode = i;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.mo4869n(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            return gVar.mo4741a(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, (Bundle) null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, (Bundle) null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            gVar.mo4738a(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        C0920i iVar = this.mFragmentManager;
        if (iVar == null || iVar.f2352q == null) {
            ensureAnimationInfo().f2292q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.f2352q.mo4776d().getLooper()) {
            this.mFragmentManager.f2352q.mo4776d().postAtFrontOfQueue(new C0902b());
        } else {
            callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        C0788a.m2491a(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) C0915f.m3157d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().f2292q = true;
        C0920i iVar = this.mFragmentManager;
        if (iVar != null) {
            handler = iVar.f2352q.mo4776d();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            gVar.mo4737a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            gVar.mo4737a(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* renamed from: androidx.fragment.app.Fragment$c */
    class C0903c extends C0913d {
        C0903c() {
        }

        /* renamed from: a */
        public View mo4650a(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        /* renamed from: a */
        public boolean mo4651a() {
            return Fragment.this.mView != null;
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        C0916g gVar = this.mHost;
        if (gVar != null) {
            LayoutInflater f = gVar.mo4744f();
            C0920i iVar = this.mChildFragmentManager;
            iVar.mo4880s();
            C0824e.m2633b(f, iVar);
            return f;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
