package p118io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.indexing.C5980b;
import p118io.branch.referral.C6035q;

/* renamed from: io.branch.indexing.a */
/* compiled from: ContentDiscoverer */
public class C5975a {

    /* renamed from: n */
    private static C5975a f15275n;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Handler f15276a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WeakReference<Activity> f15277b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f15278c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public JSONObject f15279d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f15280e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f15281f = 15;

    /* renamed from: g */
    private final C5979d f15282g = new C5979d(this);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C5980b f15283h;

    /* renamed from: i */
    private final Map<String, WeakReference<ViewTreeObserver>> f15284i = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<String> f15285j = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Runnable f15286k = new C5976a();

    /* renamed from: l */
    private ViewTreeObserver.OnScrollChangedListener f15287l = new C5977b();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Runnable f15288m = new C5978c();

    /* renamed from: io.branch.indexing.a$a */
    /* compiled from: ContentDiscoverer */
    class C5976a implements Runnable {
        C5976a() {
        }

        public void run() {
            int a;
            try {
                C5975a.m19161b(C5975a.this);
                if (C5975a.this.f15283h.mo33806e() && C5975a.this.f15277b != null && C5975a.this.f15277b.get() != null) {
                    Activity activity = (Activity) C5975a.this.f15277b.get();
                    JSONObject unused = C5975a.this.f15279d = new JSONObject();
                    C5975a.this.f15279d.put("ts", System.currentTimeMillis());
                    if (!TextUtils.isEmpty(C5975a.this.f15278c)) {
                        C5975a.this.f15279d.put("rl", C5975a.this.f15278c);
                    }
                    String str = "/" + activity.getClass().getSimpleName();
                    C5975a.this.f15279d.put("v", str);
                    ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                    if (viewGroup != null) {
                        C5980b.C5981a a2 = C5975a.this.f15283h.mo33800a(activity);
                        boolean z = true;
                        boolean z2 = a2 != null && a2.mo33810d();
                        JSONArray jSONArray = null;
                        if (a2 != null) {
                            z2 = a2.mo33810d();
                            JSONObject g = C5975a.this.f15279d;
                            if (z2) {
                                z = false;
                            }
                            g.put("h", z);
                            jSONArray = a2.mo33808b();
                        }
                        JSONArray jSONArray2 = jSONArray;
                        boolean z3 = z2;
                        if (jSONArray2 != null) {
                            if (jSONArray2.length() > 0) {
                                JSONArray jSONArray3 = new JSONArray();
                                C5975a.this.f15279d.put("ck", jSONArray3);
                                JSONArray jSONArray4 = new JSONArray();
                                C5975a.this.f15279d.put("cd", jSONArray4);
                                C5975a.this.m19160a(jSONArray2, jSONArray4, jSONArray3, activity, z3);
                                C5975a.this.f15285j.add(str);
                                C6035q.m19395a((Context) activity).mo33954a(C5975a.this.f15279d);
                                a = C5975a.this.f15283h.mo33800a(activity).mo33807a();
                                int unused2 = C5975a.this.f15281f = C5975a.this.f15283h.mo33800a(activity).mo33809c();
                                if (C5975a.this.f15280e >= C5975a.this.f15281f && a < 500 && jSONArray2 != null && jSONArray2.length() > 0) {
                                    C5975a.this.f15276a.postDelayed(C5975a.this.f15286k, (long) a);
                                    return;
                                }
                                return;
                            }
                        }
                        if (!C5975a.this.f15285j.contains(str)) {
                            JSONArray jSONArray5 = new JSONArray();
                            C5975a.this.f15279d.put("ck", jSONArray5);
                            C5975a.this.m19155a(viewGroup, jSONArray5, activity.getResources());
                        }
                        C5975a.this.f15285j.add(str);
                        C6035q.m19395a((Context) activity).mo33954a(C5975a.this.f15279d);
                        a = C5975a.this.f15283h.mo33800a(activity).mo33807a();
                        int unused3 = C5975a.this.f15281f = C5975a.this.f15283h.mo33800a(activity).mo33809c();
                        if (C5975a.this.f15280e >= C5975a.this.f15281f && a < 500) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    /* renamed from: io.branch.indexing.a$b */
    /* compiled from: ContentDiscoverer */
    class C5977b implements ViewTreeObserver.OnScrollChangedListener {
        C5977b() {
        }

        public void onScrollChanged() {
            C5975a.this.f15276a.removeCallbacks(C5975a.this.f15288m);
            if (C5975a.this.f15281f > C5975a.this.f15280e) {
                C5975a.this.f15276a.postDelayed(C5975a.this.f15288m, 1500);
            }
        }
    }

    /* renamed from: io.branch.indexing.a$c */
    /* compiled from: ContentDiscoverer */
    class C5978c implements Runnable {
        C5978c() {
        }

        public void run() {
            C5975a.this.f15286k.run();
        }
    }

    /* renamed from: io.branch.indexing.a$d */
    /* compiled from: ContentDiscoverer */
    private class C5979d {

        /* renamed from: a */
        MessageDigest f15292a;

        C5979d(C5975a aVar) {
            try {
                this.f15292a = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo33799a(String str) {
            MessageDigest messageDigest = this.f15292a;
            if (messageDigest == null) {
                return "";
            }
            messageDigest.reset();
            this.f15292a.update(str.getBytes());
            return new String(this.f15292a.digest());
        }
    }

    private C5975a() {
    }

    /* renamed from: b */
    static /* synthetic */ int m19161b(C5975a aVar) {
        int i = aVar.f15280e;
        aVar.f15280e = i + 1;
        return i;
    }

    /* renamed from: b */
    public void mo33795b(Activity activity, String str) {
        this.f15285j = new ArrayList<>();
        mo33794a(activity, str);
    }

    /* renamed from: b */
    private void m19163b(Activity activity) {
        this.f15280e = 0;
        if (this.f15285j.size() < this.f15283h.mo33805d()) {
            this.f15276a.removeCallbacks(this.f15286k);
            this.f15277b = new WeakReference<>(activity);
            this.f15276a.postDelayed(this.f15286k, 1000);
        }
    }

    /* renamed from: a */
    public static C5975a m19150a() {
        if (f15275n == null) {
            f15275n = new C5975a();
        }
        return f15275n;
    }

    /* renamed from: b */
    private void m19162b() {
        try {
            if (this.f15279d != null) {
                this.f15279d.put("tc", System.currentTimeMillis());
            }
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public void mo33794a(Activity activity, String str) {
        C5980b a = C5980b.m19178a((Context) activity);
        this.f15283h = a;
        this.f15278c = str;
        C5980b.C5981a a2 = a.mo33800a(activity);
        if (a2 != null) {
            if (!a2.mo33811e()) {
                m19163b(activity);
            }
        } else if (!TextUtils.isEmpty(this.f15278c)) {
            m19163b(activity);
        }
    }

    /* renamed from: a */
    public void mo33793a(Activity activity) {
        WeakReference<Activity> weakReference = this.f15277b;
        if (!(weakReference == null || weakReference.get() == null || !((Activity) this.f15277b.get()).getClass().getName().equals(activity.getClass().getName()))) {
            this.f15276a.removeCallbacks(this.f15286k);
            this.f15277b = null;
        }
        m19162b();
        for (WeakReference<ViewTreeObserver> weakReference2 : this.f15284i.values()) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference2.get();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f15287l);
            }
        }
        this.f15284i.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19155a(ViewGroup viewGroup, JSONArray jSONArray, Resources resources) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if ((childAt instanceof AbsListView) || childAt.getClass().getSimpleName().equals("RecyclerView")) {
                    m19154a((ViewGroup) childAt, resources, jSONArray);
                } else if (childAt instanceof ViewGroup) {
                    m19155a((ViewGroup) childAt, jSONArray, resources);
                } else if (childAt instanceof TextView) {
                    jSONArray.put(m19151a(childAt, resources));
                }
            }
        }
    }

    /* renamed from: a */
    private void m19154a(ViewGroup viewGroup, Resources resources, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (viewGroup != null && viewGroup.getChildCount() > -1) {
            int i = 1;
            if (viewGroup.getChildCount() <= 1) {
                i = 0;
            }
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONObject.put(m19151a((View) viewGroup, resources), jSONArray2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (childAt instanceof ViewGroup) {
                    m19155a((ViewGroup) childAt, jSONArray2, resources);
                } else if (childAt instanceof TextView) {
                    jSONArray2.put(m19151a(childAt, resources));
                }
                if (jSONObject.length() > 0) {
                    jSONArray.put("$" + jSONObject);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19160a(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, Activity activity, boolean z) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                String string = jSONArray.getString(i);
                if (string.startsWith("$")) {
                    m19158a(string, activity, z, jSONArray2, jSONArray3);
                } else {
                    m19159a(string, activity.findViewById(activity.getResources().getIdentifier(jSONArray.getString(i), "id", activity.getPackageName())), z, jSONArray2, jSONArray3);
                }
                i++;
            } catch (JSONException unused) {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m19158a(String str, Activity activity, boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        int i;
        String str2 = str;
        JSONObject jSONObject = new JSONObject();
        jSONArray2.put(str2);
        jSONArray.put(jSONObject);
        String replace = str2.replace("$", "");
        try {
            JSONObject jSONObject2 = new JSONObject(replace);
            if (jSONObject2.length() > 0) {
                String next = jSONObject2.keys().next();
                int identifier = activity.getResources().getIdentifier(next, "id", activity.getPackageName());
                View findViewById = activity.getCurrentFocus() != null ? activity.getCurrentFocus().findViewById(identifier) : null;
                if (findViewById == null) {
                    findViewById = activity.findViewById(identifier);
                } else {
                    Activity activity2 = activity;
                }
                if (findViewById != null && (findViewById instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) findViewById;
                    JSONArray jSONArray3 = jSONObject2.getJSONArray(next);
                    int length = jSONArray3.length();
                    int[] iArr = new int[length];
                    for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                        iArr[i2] = activity.getResources().getIdentifier(jSONArray3.getString(i2), "id", activity.getPackageName());
                    }
                    int firstVisiblePosition = viewGroup instanceof AbsListView ? ((AbsListView) viewGroup).getFirstVisiblePosition() : 0;
                    int i3 = 0;
                    while (i3 < viewGroup.getChildCount()) {
                        if (viewGroup.getChildAt(i3) != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject.put("" + (i3 + firstVisiblePosition), jSONObject3);
                            int i4 = 0;
                            while (i4 < length) {
                                if (viewGroup.getChildAt(i3) != null) {
                                    View findViewById2 = viewGroup.getChildAt(i3).findViewById(iArr[i4]);
                                    if (findViewById2 instanceof TextView) {
                                        i = firstVisiblePosition;
                                        jSONObject3.put(jSONArray3.getString(i4), m19152a(findViewById2, z));
                                        i4++;
                                        firstVisiblePosition = i;
                                    }
                                }
                                i = firstVisiblePosition;
                                boolean z2 = z;
                                i4++;
                                firstVisiblePosition = i;
                            }
                        }
                        int i5 = firstVisiblePosition;
                        boolean z3 = z;
                        i3++;
                        firstVisiblePosition = i5;
                    }
                    if ((jSONObject2.has("bnc_esw") && jSONObject2.getBoolean("bnc_esw")) && !this.f15284i.containsKey(replace)) {
                        viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f15287l);
                        this.f15284i.put(replace, new WeakReference(viewGroup.getViewTreeObserver()));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m19151a(View view, Resources resources) {
        try {
            return resources.getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return String.valueOf(view.getId());
        }
    }

    /* renamed from: a */
    private String m19152a(View view, boolean z) {
        TextView textView = (TextView) view;
        if (textView.getText() == null) {
            return null;
        }
        String substring = textView.getText().toString().substring(0, Math.min(textView.getText().toString().length(), this.f15283h.mo33804c()));
        return z ? substring : this.f15282g.mo33799a(substring);
    }

    /* renamed from: a */
    private void m19159a(String str, View view, boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (view instanceof TextView) {
            jSONArray.put(m19152a(view, z));
            jSONArray2.put(str);
        }
    }

    /* renamed from: a */
    public JSONObject mo33792a(Context context) {
        JSONObject jSONObject;
        JSONObject g = C6035q.m19395a(context).mo33971g();
        if (g.length() <= 0 || g.toString().length() >= this.f15283h.mo33803b()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("mv", C5980b.m19178a(context).mo33801a()).put("e", g);
                if (context != null) {
                    jSONObject.put("p", context.getPackageName());
                    jSONObject.put("p", context.getPackageName());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        C6035q.m19395a(context).mo33948a();
        return jSONObject;
    }
}
