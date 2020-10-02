package androidx.fragment.app;

import androidx.core.p019e.C0789b;
import androidx.fragment.app.C0920i;
import androidx.fragment.app.C0937k;
import androidx.fragment.app.Fragment;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a */
/* compiled from: BackStackRecord */
final class C0908a extends C0937k implements C0920i.C0932k {

    /* renamed from: r */
    final C0920i f2314r;

    /* renamed from: s */
    boolean f2315s;

    /* renamed from: t */
    int f2316t = -1;

    public C0908a(C0920i iVar) {
        this.f2314r = iVar;
    }

    /* renamed from: a */
    public void mo4671a(String str, PrintWriter printWriter) {
        mo4672a(str, printWriter, true);
    }

    /* renamed from: b */
    public int mo4675b() {
        return mo4665a(true);
    }

    /* renamed from: c */
    public void mo4679c() {
        mo4920d();
        this.f2314r.mo4835b((C0920i.C0932k) this, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4680e() {
        int size = this.f2400a.size();
        for (int i = 0; i < size; i++) {
            C0937k.C0938a aVar = this.f2400a.get(i);
            Fragment fragment = aVar.f2418b;
            if (fragment != null) {
                fragment.setNextTransition(this.f2405f, this.f2406g);
            }
            switch (aVar.f2417a) {
                case 1:
                    fragment.setNextAnim(aVar.f2419c);
                    this.f2314r.mo4819a(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f2420d);
                    this.f2314r.mo4871o(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f2420d);
                    this.f2314r.mo4856h(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f2419c);
                    this.f2314r.mo4883t(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f2420d);
                    this.f2314r.mo4843d(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f2419c);
                    this.f2314r.mo4831b(fragment);
                    break;
                case 8:
                    this.f2314r.mo4881s(fragment);
                    break;
                case 9:
                    this.f2314r.mo4881s((Fragment) null);
                    break;
                case 10:
                    this.f2314r.mo4818a(fragment, aVar.f2424h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2417a);
            }
            if (!(this.f2415p || aVar.f2417a == 1 || fragment == null)) {
                this.f2314r.mo4865l(fragment);
            }
        }
        if (!this.f2415p) {
            C0920i iVar = this.f2314r;
            iVar.mo4808a(iVar.f2351p, true);
        }
    }

    /* renamed from: f */
    public String mo4681f() {
        return this.f2408i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo4682g() {
        for (int i = 0; i < this.f2400a.size(); i++) {
            if (m3091b(this.f2400a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public void mo4683h() {
        if (this.f2416q != null) {
            for (int i = 0; i < this.f2416q.size(); i++) {
                this.f2416q.get(i).run();
            }
            this.f2416q = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2316t >= 0) {
            sb.append(" #");
            sb.append(this.f2316t);
        }
        if (this.f2408i != null) {
            sb.append(" ");
            sb.append(this.f2408i);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo4672a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2408i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2316t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2315s);
            if (this.f2405f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2405f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f2406g));
            }
            if (!(this.f2401b == 0 && this.f2402c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2401b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2402c));
            }
            if (!(this.f2403d == 0 && this.f2404e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2403d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2404e));
            }
            if (!(this.f2409j == 0 && this.f2410k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2409j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2410k);
            }
            if (!(this.f2411l == 0 && this.f2412m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2411l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2412m);
            }
        }
        if (!this.f2400a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2400a.size();
            for (int i = 0; i < size; i++) {
                C0937k.C0938a aVar = this.f2400a.get(i);
                switch (aVar.f2417a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2417a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2418b);
                if (z) {
                    if (!(aVar.f2419c == 0 && aVar.f2420d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2419c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2420d));
                    }
                    if (aVar.f2421e != 0 || aVar.f2422f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2421e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2422f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4678b(int i) {
        int size = this.f2400a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f2400a.get(i2).f2418b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4677b(boolean z) {
        for (int size = this.f2400a.size() - 1; size >= 0; size--) {
            C0937k.C0938a aVar = this.f2400a.get(size);
            Fragment fragment = aVar.f2418b;
            if (fragment != null) {
                fragment.setNextTransition(C0920i.m3209e(this.f2405f), this.f2406g);
            }
            switch (aVar.f2417a) {
                case 1:
                    fragment.setNextAnim(aVar.f2422f);
                    this.f2314r.mo4871o(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f2421e);
                    this.f2314r.mo4819a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f2421e);
                    this.f2314r.mo4883t(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f2422f);
                    this.f2314r.mo4856h(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f2421e);
                    this.f2314r.mo4831b(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f2422f);
                    this.f2314r.mo4843d(fragment);
                    break;
                case 8:
                    this.f2314r.mo4881s((Fragment) null);
                    break;
                case 9:
                    this.f2314r.mo4881s(fragment);
                    break;
                case 10:
                    this.f2314r.mo4818a(fragment, aVar.f2423g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2417a);
            }
            if (!(this.f2415p || aVar.f2417a == 3 || fragment == null)) {
                this.f2314r.mo4865l(fragment);
            }
        }
        if (!this.f2415p && z) {
            C0920i iVar = this.f2314r;
            iVar.mo4808a(iVar.f2351p, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Fragment mo4676b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f2400a.size() - 1; size >= 0; size--) {
            C0937k.C0938a aVar = this.f2400a.get(size);
            int i = aVar.f2417a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f2418b;
                            break;
                        case 10:
                            aVar.f2424h = aVar.f2423g;
                            break;
                    }
                }
                arrayList.add(aVar.f2418b);
            }
            arrayList.remove(aVar.f2418b);
        }
        return fragment;
    }

    /* renamed from: b */
    private static boolean m3091b(C0937k.C0938a aVar) {
        Fragment fragment = aVar.f2418b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4669a(int i, Fragment fragment, String str, int i2) {
        super.mo4669a(i, fragment, str, i2);
        fragment.mFragmentManager = this.f2314r;
    }

    /* renamed from: a */
    public C0937k mo4667a(Fragment fragment) {
        C0920i iVar = fragment.mFragmentManager;
        if (iVar == null || iVar == this.f2314r) {
            super.mo4667a(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4668a(int i) {
        if (this.f2407h) {
            if (C0920i.f2328H) {
                "Bump nesting in " + this + " by " + i;
            }
            int size = this.f2400a.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0937k.C0938a aVar = this.f2400a.get(i2);
                Fragment fragment = aVar.f2418b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (C0920i.f2328H) {
                        "Bump nesting of " + aVar.f2418b + " to " + aVar.f2418b.mBackStackNesting;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public int mo4664a() {
        return mo4665a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo4665a(boolean z) {
        if (!this.f2315s) {
            if (C0920i.f2328H) {
                "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new C0789b("FragmentManager"));
                mo4671a("  ", printWriter);
                printWriter.close();
            }
            this.f2315s = true;
            if (this.f2407h) {
                this.f2316t = this.f2314r.mo4828b(this);
            } else {
                this.f2316t = -1;
            }
            this.f2314r.mo4823a((C0920i.C0932k) this, z);
            return this.f2316t;
        }
        throw new IllegalStateException("commit already called");
    }

    /* renamed from: a */
    public boolean mo4674a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2) {
        if (C0920i.f2328H) {
            "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f2407h) {
            return true;
        }
        this.f2314r.mo4820a(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4673a(ArrayList<C0908a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f2400a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f2400a.get(i4).f2418b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0908a aVar = arrayList.get(i6);
                    int size2 = aVar.f2400a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f2400a.get(i7).f2418b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Fragment mo4666a(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f2400a.size()) {
            C0937k.C0938a aVar = this.f2400a.get(i);
            int i2 = aVar.f2417a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = aVar.f2418b;
                    int i3 = fragment3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f2400a.add(i, new C0937k.C0938a(9, fragment4));
                                    i++;
                                    fragment2 = null;
                                }
                                C0937k.C0938a aVar2 = new C0937k.C0938a(3, fragment4);
                                aVar2.f2419c = aVar.f2419c;
                                aVar2.f2421e = aVar.f2421e;
                                aVar2.f2420d = aVar.f2420d;
                                aVar2.f2422f = aVar.f2422f;
                                this.f2400a.add(i, aVar2);
                                arrayList2.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f2400a.remove(i);
                        i--;
                    } else {
                        aVar.f2417a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList2.remove(aVar.f2418b);
                    Fragment fragment5 = aVar.f2418b;
                    if (fragment5 == fragment2) {
                        this.f2400a.add(i, new C0937k.C0938a(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f2400a.add(i, new C0937k.C0938a(9, fragment2));
                        i++;
                        fragment2 = aVar.f2418b;
                    }
                }
                i++;
            }
            arrayList2.add(aVar.f2418b);
            i++;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4670a(Fragment.C0905e eVar) {
        for (int i = 0; i < this.f2400a.size(); i++) {
            C0937k.C0938a aVar = this.f2400a.get(i);
            if (m3091b(aVar)) {
                aVar.f2418b.setOnStartEnterTransitionListener(eVar);
            }
        }
    }
}
