package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.C0382c;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.C0696a;
import androidx.core.app.C0744n;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0971i;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.C0987t;
import androidx.loader.p025a.C0988a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p075d.p080b.C3205h;

/* renamed from: androidx.fragment.app.c */
/* compiled from: FragmentActivity */
public class C0911c extends ComponentActivity implements C0696a.C0698b, C0696a.C0700d {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0971i mFragmentLifecycleRegistry = new C0971i(this);
    final C0914e mFragments = C0914e.m3130a((C0916g<?>) new C0912a());
    int mNextCandidateRequestIndex;
    C3205h<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;

    /* renamed from: androidx.fragment.app.c$a */
    /* compiled from: FragmentActivity */
    class C0912a extends C0916g<C0911c> implements C0987t, C0382c {
        public C0912a() {
            super(C0911c.this);
        }

        /* renamed from: a */
        public void mo4740a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            C0911c.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* renamed from: b */
        public boolean mo4742b(Fragment fragment) {
            return !C0911c.this.isFinishing();
        }

        /* renamed from: f */
        public LayoutInflater mo4744f() {
            return C0911c.this.getLayoutInflater().cloneInContext(C0911c.this);
        }

        /* renamed from: g */
        public int mo4745g() {
            Window window = C0911c.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public C0965e getLifecycle() {
            return C0911c.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return C0911c.this.getOnBackPressedDispatcher();
        }

        public C0986s getViewModelStore() {
            return C0911c.this.getViewModelStore();
        }

        /* renamed from: h */
        public boolean mo4746h() {
            return C0911c.this.getWindow() != null;
        }

        /* renamed from: i */
        public void mo4747i() {
            C0911c.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: a */
        public void mo4737a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            C0911c.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        /* renamed from: e */
        public C0911c m3122e() {
            return C0911c.this;
        }

        /* renamed from: a */
        public void mo4738a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            C0911c.this.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* renamed from: a */
        public void mo4739a(Fragment fragment, String[] strArr, int i) {
            C0911c.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        /* renamed from: a */
        public boolean mo4741a(String str) {
            return C0696a.m2195a((Activity) C0911c.this, str);
        }

        /* renamed from: a */
        public void mo4736a(Fragment fragment) {
            C0911c.this.onAttachFragment(fragment);
        }

        /* renamed from: a */
        public View mo4650a(int i) {
            return C0911c.this.findViewById(i);
        }

        /* renamed from: a */
        public boolean mo4651a() {
            Window window = C0911c.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public C0911c() {
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.mo18825b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.mo18826b(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.mo18829c(i, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void checkForValidRequestCode(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), C0965e.C0967b.CREATED));
    }

    private static boolean markState(C0917h hVar, C0965e.C0967b bVar) {
        boolean z = false;
        for (Fragment next : hVar.mo4785c()) {
            if (next != null) {
                if (next.getLifecycle().mo4995a().mo4998a(C0965e.C0967b.STARTED)) {
                    next.mLifecycleRegistry.mo5001b(bVar);
                    z = true;
                }
                if (next.getHost() != null) {
                    z |= markState(next.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mo4749a(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            C0988a.m3506a(this).mo5023a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mo4770j().mo4783a(str, fileDescriptor, printWriter, strArr);
    }

    public C0917h getSupportFragmentManager() {
        return this.mFragments.mo4770j();
    }

    @Deprecated
    public C0988a getSupportLoaderManager() {
        return C0988a.m3506a(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.mo4771k();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a = this.mPendingFragmentActivityResults.mo18822a(i4);
            this.mPendingFragmentActivityResults.mo18831d(i4);
            if (a == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.mo4750a(a);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + a);
                return;
            }
            a2.onActivityResult(i & 65535, i2, intent);
            return;
        }
        C0696a.C0699c a3 = C0696a.m2189a();
        if (a3 == null || !a3.onActivityResult(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.mo4771k();
        this.mFragments.mo4752a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mFragments.mo4755a((Fragment) null);
        if (bundle != null) {
            this.mFragments.mo4753a(bundle.getParcelable(FRAGMENTS_TAG));
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C3205h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.mo18829c(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C3205h<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_CREATE);
        this.mFragments.mo4759b();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.mo4757a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.mo4763c();
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mo4764d();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.mo4762b(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.mo4758a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mo4756a(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.mo4771k();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.mo4754a(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.mo4765e();
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mo4760b(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.mo4761b(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.mo4771k();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a = this.mPendingFragmentActivityResults.mo18822a(i3);
            this.mPendingFragmentActivityResults.mo18831d(i3);
            if (a == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.mo4750a(a);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + a);
                return;
            }
            a2.onRequestPermissionsResult(i & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.mo4771k();
        this.mFragments.mo4769i();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_RESUME);
        this.mFragments.mo4766f();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_STOP);
        Parcelable l = this.mFragments.mo4772l();
        if (l != null) {
            bundle.putParcelable(FRAGMENTS_TAG, l);
        }
        if (this.mPendingFragmentActivityResults.mo18825b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.mo18825b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.mo18825b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.mo18825b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.mo18828c(i);
                strArr[i] = this.mPendingFragmentActivityResults.mo18832e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mo4751a();
        }
        this.mFragments.mo4771k();
        this.mFragments.mo4769i();
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_START);
        this.mFragments.mo4767g();
    }

    public void onStateNotSaved() {
        this.mFragments.mo4771k();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.mo4768h();
        this.mFragmentLifecycleRegistry.mo4999a(C0965e.C0966a.ON_STOP);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            C0696a.m2194a(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0696a.m2194a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    public void setEnterSharedElementCallback(C0744n nVar) {
        C0696a.m2193a((Activity) this, nVar);
    }

    public void setExitSharedElementCallback(C0744n nVar) {
        C0696a.m2197b(this, nVar);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                C0696a.m2192a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0696a.m2192a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i5 & 65535), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        C0696a.m2196b(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        C0696a.m2198c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0696a.m2200e(this);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0696a.m2191a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0696a.m2191a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public C0911c(int i) {
        super(i);
    }
}
