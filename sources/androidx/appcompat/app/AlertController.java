package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.p020f.C0839t;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.drive.MetadataChangeSet;
import java.lang.ref.WeakReference;

class AlertController {

    /* renamed from: A */
    NestedScrollView f285A;

    /* renamed from: B */
    private int f286B = 0;

    /* renamed from: C */
    private Drawable f287C;

    /* renamed from: D */
    private ImageView f288D;

    /* renamed from: E */
    private TextView f289E;

    /* renamed from: F */
    private TextView f290F;

    /* renamed from: G */
    private View f291G;

    /* renamed from: H */
    ListAdapter f292H;

    /* renamed from: I */
    int f293I = -1;

    /* renamed from: J */
    private int f294J;

    /* renamed from: K */
    private int f295K;

    /* renamed from: L */
    int f296L;

    /* renamed from: M */
    int f297M;

    /* renamed from: N */
    int f298N;

    /* renamed from: O */
    int f299O;

    /* renamed from: P */
    private boolean f300P;

    /* renamed from: Q */
    private int f301Q = 0;

    /* renamed from: R */
    Handler f302R;

    /* renamed from: S */
    private final View.OnClickListener f303S = new C0385a();

    /* renamed from: a */
    private final Context f304a;

    /* renamed from: b */
    final C0427g f305b;

    /* renamed from: c */
    private final Window f306c;

    /* renamed from: d */
    private final int f307d;

    /* renamed from: e */
    private CharSequence f308e;

    /* renamed from: f */
    private CharSequence f309f;

    /* renamed from: g */
    ListView f310g;

    /* renamed from: h */
    private View f311h;

    /* renamed from: i */
    private int f312i;

    /* renamed from: j */
    private int f313j;

    /* renamed from: k */
    private int f314k;

    /* renamed from: l */
    private int f315l;

    /* renamed from: m */
    private int f316m;

    /* renamed from: n */
    private boolean f317n = false;

    /* renamed from: o */
    Button f318o;

    /* renamed from: p */
    private CharSequence f319p;

    /* renamed from: q */
    Message f320q;

    /* renamed from: r */
    private Drawable f321r;

    /* renamed from: s */
    Button f322s;

    /* renamed from: t */
    private CharSequence f323t;

    /* renamed from: u */
    Message f324u;

    /* renamed from: v */
    private Drawable f325v;

    /* renamed from: w */
    Button f326w;

    /* renamed from: x */
    private CharSequence f327x;

    /* renamed from: y */
    Message f328y;

    /* renamed from: z */
    private Drawable f329z;

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f330a;

        /* renamed from: b */
        private final int f331b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        /* renamed from: a */
        public void mo1921a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f330a, getPaddingRight(), z2 ? getPaddingBottom() : this.f331b);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f331b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f330a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    class C0385a implements View.OnClickListener {
        C0385a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            r3 = r0.f328y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f318o
                if (r3 != r1) goto L_0x000f
                android.os.Message r0 = r0.f320q
                if (r0 == 0) goto L_0x000f
                android.os.Message r3 = android.os.Message.obtain(r0)
                goto L_0x002e
            L_0x000f:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f322s
                if (r3 != r1) goto L_0x001e
                android.os.Message r0 = r0.f324u
                if (r0 == 0) goto L_0x001e
                android.os.Message r3 = android.os.Message.obtain(r0)
                goto L_0x002e
            L_0x001e:
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f326w
                if (r3 != r1) goto L_0x002d
                android.os.Message r3 = r0.f328y
                if (r3 == 0) goto L_0x002d
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x002e
            L_0x002d:
                r3 = 0
            L_0x002e:
                if (r3 == 0) goto L_0x0033
                r3.sendToTarget()
            L_0x0033:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.f302R
                r1 = 1
                androidx.appcompat.app.g r3 = r3.f305b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C0385a.onClick(android.view.View):void");
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    class C0386b implements NestedScrollView.C0868b {

        /* renamed from: a */
        final /* synthetic */ View f333a;

        /* renamed from: b */
        final /* synthetic */ View f334b;

        C0386b(AlertController alertController, View view, View view2) {
            this.f333a = view;
            this.f334b = view2;
        }

        /* renamed from: a */
        public void mo1923a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.m327a(nestedScrollView, this.f333a, this.f334b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    class C0387c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f335a;

        /* renamed from: b */
        final /* synthetic */ View f336b;

        C0387c(View view, View view2) {
            this.f335a = view;
            this.f336b = view2;
        }

        public void run() {
            AlertController.m327a(AlertController.this.f285A, this.f335a, this.f336b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$d */
    class C0388d implements AbsListView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ View f338a;

        /* renamed from: b */
        final /* synthetic */ View f339b;

        C0388d(AlertController alertController, View view, View view2) {
            this.f338a = view;
            this.f339b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m327a(absListView, this.f338a, this.f339b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$e */
    class C0389e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f340a;

        /* renamed from: b */
        final /* synthetic */ View f341b;

        C0389e(View view, View view2) {
            this.f340a = view;
            this.f341b = view2;
        }

        public void run() {
            AlertController.m327a(AlertController.this.f310g, this.f340a, this.f341b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$f */
    public static class C0390f {

        /* renamed from: A */
        public int f343A;

        /* renamed from: B */
        public int f344B;

        /* renamed from: C */
        public int f345C;

        /* renamed from: D */
        public int f346D;

        /* renamed from: E */
        public boolean f347E = false;

        /* renamed from: F */
        public boolean[] f348F;

        /* renamed from: G */
        public boolean f349G;

        /* renamed from: H */
        public boolean f350H;

        /* renamed from: I */
        public int f351I = -1;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f352J;

        /* renamed from: K */
        public Cursor f353K;

        /* renamed from: L */
        public String f354L;

        /* renamed from: M */
        public String f355M;

        /* renamed from: N */
        public AdapterView.OnItemSelectedListener f356N;

        /* renamed from: O */
        public C0395e f357O;

        /* renamed from: a */
        public final Context f358a;

        /* renamed from: b */
        public final LayoutInflater f359b;

        /* renamed from: c */
        public int f360c = 0;

        /* renamed from: d */
        public Drawable f361d;

        /* renamed from: e */
        public int f362e = 0;

        /* renamed from: f */
        public CharSequence f363f;

        /* renamed from: g */
        public View f364g;

        /* renamed from: h */
        public CharSequence f365h;

        /* renamed from: i */
        public CharSequence f366i;

        /* renamed from: j */
        public Drawable f367j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f368k;

        /* renamed from: l */
        public CharSequence f369l;

        /* renamed from: m */
        public Drawable f370m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f371n;

        /* renamed from: o */
        public CharSequence f372o;

        /* renamed from: p */
        public Drawable f373p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f374q;

        /* renamed from: r */
        public boolean f375r;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f376s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f377t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f378u;

        /* renamed from: v */
        public CharSequence[] f379v;

        /* renamed from: w */
        public ListAdapter f380w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f381x;

        /* renamed from: y */
        public int f382y;

        /* renamed from: z */
        public View f383z;

        /* renamed from: androidx.appcompat.app.AlertController$f$a */
        class C0391a extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f384a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0391a(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.f384a = recycleListView;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = C0390f.this.f348F;
                if (zArr != null && zArr[i]) {
                    this.f384a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$f$b */
        class C0392b extends CursorAdapter {

            /* renamed from: a */
            private final int f386a;

            /* renamed from: b */
            private final int f387b;

            /* renamed from: c */
            final /* synthetic */ RecycleListView f388c;

            /* renamed from: d */
            final /* synthetic */ AlertController f389d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0392b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f388c = recycleListView;
                this.f389d = alertController;
                Cursor cursor2 = getCursor();
                this.f386a = cursor2.getColumnIndexOrThrow(C0390f.this.f354L);
                this.f387b = cursor2.getColumnIndexOrThrow(C0390f.this.f355M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f386a));
                RecycleListView recycleListView = this.f388c;
                int position = cursor.getPosition();
                boolean z = true;
                if (cursor.getInt(this.f387b) != 1) {
                    z = false;
                }
                recycleListView.setItemChecked(position, z);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return C0390f.this.f359b.inflate(this.f389d.f297M, viewGroup, false);
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$f$c */
        class C0393c implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ AlertController f391a;

            C0393c(AlertController alertController) {
                this.f391a = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C0390f.this.f381x.onClick(this.f391a.f305b, i);
                if (!C0390f.this.f350H) {
                    this.f391a.f305b.dismiss();
                }
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$f$d */
        class C0394d implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f393a;

            /* renamed from: b */
            final /* synthetic */ AlertController f394b;

            C0394d(RecycleListView recycleListView, AlertController alertController) {
                this.f393a = recycleListView;
                this.f394b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean[] zArr = C0390f.this.f348F;
                if (zArr != null) {
                    zArr[i] = this.f393a.isItemChecked(i);
                }
                C0390f.this.f352J.onClick(this.f394b.f305b, i, this.f393a.isItemChecked(i));
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$f$e */
        public interface C0395e {
            /* renamed from: a */
            void mo1934a(ListView listView);
        }

        public C0390f(Context context) {
            this.f358a = context;
            this.f375r = true;
            this.f359b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$f$b] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$f$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m354b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f359b
                int r1 = r11.f296L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.f349G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.f353K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$f$a r9 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r10.f358a
                int r4 = r11.f297M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f379v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$f$b r9 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r10.f358a
                android.database.Cursor r4 = r10.f353K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.f350H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.f298N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.f299O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.f353K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f358a
                android.database.Cursor r5 = r10.f353K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.f354L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f380w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$h r9 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r10.f358a
                java.lang.CharSequence[] r3 = r10.f379v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$f$e r1 = r10.f357O
                if (r1 == 0) goto L_0x0072
                r1.mo1934a(r0)
            L_0x0072:
                r11.f292H = r9
                int r1 = r10.f351I
                r11.f293I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f381x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0091
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.f352J
                if (r1 == 0) goto L_0x0091
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0091:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.f356N
                if (r1 == 0) goto L_0x0098
                r0.setOnItemSelectedListener(r1)
            L_0x0098:
                boolean r1 = r10.f350H
                if (r1 == 0) goto L_0x00a0
                r0.setChoiceMode(r8)
                goto L_0x00a8
            L_0x00a0:
                boolean r1 = r10.f349G
                if (r1 == 0) goto L_0x00a8
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a8:
                r11.f310g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C0390f.m354b(androidx.appcompat.app.AlertController):void");
        }

        /* renamed from: a */
        public void mo1928a(AlertController alertController) {
            View view = this.f364g;
            if (view != null) {
                alertController.mo1911a(view);
            } else {
                CharSequence charSequence = this.f363f;
                if (charSequence != null) {
                    alertController.mo1918b(charSequence);
                }
                Drawable drawable = this.f361d;
                if (drawable != null) {
                    alertController.mo1910a(drawable);
                }
                int i = this.f360c;
                if (i != 0) {
                    alertController.mo1916b(i);
                }
                int i2 = this.f362e;
                if (i2 != 0) {
                    alertController.mo1916b(alertController.mo1907a(i2));
                }
            }
            CharSequence charSequence2 = this.f365h;
            if (charSequence2 != null) {
                alertController.mo1913a(charSequence2);
            }
            if (!(this.f366i == null && this.f367j == null)) {
                alertController.mo1909a(-1, this.f366i, this.f368k, (Message) null, this.f367j);
            }
            if (!(this.f369l == null && this.f370m == null)) {
                alertController.mo1909a(-2, this.f369l, this.f371n, (Message) null, this.f370m);
            }
            if (!(this.f372o == null && this.f373p == null)) {
                alertController.mo1909a(-3, this.f372o, this.f374q, (Message) null, this.f373p);
            }
            if (!(this.f379v == null && this.f353K == null && this.f380w == null)) {
                m354b(alertController);
            }
            View view2 = this.f383z;
            if (view2 == null) {
                int i3 = this.f382y;
                if (i3 != 0) {
                    alertController.mo1920c(i3);
                }
            } else if (this.f347E) {
                alertController.mo1912a(view2, this.f343A, this.f344B, this.f345C, this.f346D);
            } else {
                alertController.mo1917b(view2);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$g */
    private static final class C0396g extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f396a;

        public C0396g(DialogInterface dialogInterface) {
            this.f396a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f396a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$h */
    private static class C0397h extends ArrayAdapter<CharSequence> {
        public C0397h(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, C0427g gVar, Window window) {
        this.f304a = context;
        this.f305b = gVar;
        this.f306c = window;
        this.f302R = new C0396g(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f294J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.f295K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f296L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.f297M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f298N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f299O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.f300P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f307d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        gVar.mo2119a(1);
    }

    /* renamed from: a */
    private static boolean m331a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    static boolean m335c(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m335c(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m336d() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f306c.findViewById(R$id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R$id.topPanel);
        View findViewById5 = findViewById3.findViewById(R$id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        m334c(viewGroup);
        View findViewById7 = viewGroup.findViewById(R$id.topPanel);
        View findViewById8 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup a = m326a(findViewById7, findViewById4);
        ViewGroup a2 = m326a(findViewById8, findViewById5);
        ViewGroup a3 = m326a(findViewById9, findViewById6);
        m332b(a2);
        m328a(a3);
        m337d(a);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null || (findViewById2 = a2.findViewById(R$id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.f285A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f309f == null && this.f310g == null)) {
                view = a.findViewById(R$id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a2 == null || (findViewById = a2.findViewById(R$id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f310g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).mo1921a(z2, z3);
        }
        if (!z) {
            View view2 = this.f310g;
            if (view2 == null) {
                view2 = this.f285A;
            }
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m329a(a2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f310g;
        if (listView2 != null && (listAdapter = this.f292H) != null) {
            listView2.setAdapter(listAdapter);
            int i = this.f293I;
            if (i > -1) {
                listView2.setItemChecked(i, true);
                listView2.setSelection(i);
            }
        }
    }

    /* renamed from: b */
    public void mo1915b() {
        this.f305b.setContentView(m333c());
        m336d();
    }

    /* renamed from: a */
    public void mo1911a(View view) {
        this.f291G = view;
    }

    /* renamed from: b */
    public void mo1918b(CharSequence charSequence) {
        this.f308e = charSequence;
        TextView textView = this.f289E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void mo1913a(CharSequence charSequence) {
        this.f309f = charSequence;
        TextView textView = this.f290F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: c */
    private int m333c() {
        int i = this.f295K;
        if (i == 0) {
            return this.f294J;
        }
        if (this.f301Q == 1) {
            return i;
        }
        return this.f294J;
    }

    /* renamed from: b */
    public void mo1917b(View view) {
        this.f311h = view;
        this.f312i = 0;
        this.f317n = false;
    }

    /* renamed from: a */
    public void mo1912a(View view, int i, int i2, int i3, int i4) {
        this.f311h = view;
        this.f312i = 0;
        this.f317n = true;
        this.f313j = i;
        this.f314k = i2;
        this.f315l = i3;
        this.f316m = i4;
    }

    /* renamed from: b */
    public void mo1916b(int i) {
        this.f287C = null;
        this.f286B = i;
        ImageView imageView = this.f288D;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.f288D.setImageResource(this.f286B);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: c */
    public void mo1920c(int i) {
        this.f311h = null;
        this.f312i = i;
        this.f317n = false;
    }

    /* renamed from: c */
    private void m334c(ViewGroup viewGroup) {
        View view = this.f311h;
        boolean z = false;
        if (view == null) {
            view = this.f312i != 0 ? LayoutInflater.from(this.f304a).inflate(this.f312i, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m335c(view)) {
            this.f306c.setFlags(MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f306c.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f317n) {
                frameLayout.setPadding(this.f313j, this.f314k, this.f315l, this.f316m);
            }
            if (this.f310g != null) {
                ((LinearLayoutCompat.C0537a) viewGroup.getLayoutParams()).f1135a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    public void mo1909a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f302R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.f327x = charSequence;
            this.f328y = message;
            this.f329z = drawable;
        } else if (i == -2) {
            this.f323t = charSequence;
            this.f324u = message;
            this.f325v = drawable;
        } else if (i == -1) {
            this.f319p = charSequence;
            this.f320q = message;
            this.f321r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public boolean mo1919b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f285A;
        return nestedScrollView != null && nestedScrollView.mo4281a(keyEvent);
    }

    /* renamed from: b */
    private void m332b(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f306c.findViewById(R$id.scrollView);
        this.f285A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f285A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.f290F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f309f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.f285A.removeView(this.f290F);
            if (this.f310g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f285A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f285A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f310g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo1910a(Drawable drawable) {
        this.f287C = drawable;
        this.f286B = 0;
        ImageView imageView = this.f288D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.f288D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: a */
    public int mo1907a(int i) {
        TypedValue typedValue = new TypedValue();
        this.f304a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public ListView mo1908a() {
        return this.f310g;
    }

    /* renamed from: a */
    public boolean mo1914a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f285A;
        return nestedScrollView != null && nestedScrollView.mo4281a(keyEvent);
    }

    /* renamed from: a */
    private ViewGroup m326a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: d */
    private void m337d(ViewGroup viewGroup) {
        if (this.f291G != null) {
            viewGroup.addView(this.f291G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f306c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.f288D = (ImageView) this.f306c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f308e)) || !this.f300P) {
            this.f306c.findViewById(R$id.title_template).setVisibility(8);
            this.f288D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f306c.findViewById(R$id.alertTitle);
        this.f289E = textView;
        textView.setText(this.f308e);
        int i = this.f286B;
        if (i != 0) {
            this.f288D.setImageResource(i);
            return;
        }
        Drawable drawable = this.f287C;
        if (drawable != null) {
            this.f288D.setImageDrawable(drawable);
            return;
        }
        this.f289E.setPadding(this.f288D.getPaddingLeft(), this.f288D.getPaddingTop(), this.f288D.getPaddingRight(), this.f288D.getPaddingBottom());
        this.f288D.setVisibility(8);
    }

    /* renamed from: a */
    private void m329a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.f306c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f306c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            C0839t.m2691a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f309f != null) {
                this.f285A.mo4276a((NestedScrollView.C0868b) new C0386b(this, findViewById, findViewById2));
                this.f285A.post(new C0387c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f310g;
            if (listView != null) {
                listView.setOnScrollListener(new C0388d(this, findViewById, findViewById2));
                this.f310g.post(new C0389e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    /* renamed from: a */
    static void m327a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m328a(ViewGroup viewGroup) {
        boolean z;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f318o = button;
        button.setOnClickListener(this.f303S);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f319p) || this.f321r != null) {
            this.f318o.setText(this.f319p);
            Drawable drawable = this.f321r;
            if (drawable != null) {
                int i = this.f307d;
                drawable.setBounds(0, 0, i, i);
                this.f318o.setCompoundDrawables(this.f321r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f318o.setVisibility(0);
            z = true;
        } else {
            this.f318o.setVisibility(8);
            z = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f322s = button2;
        button2.setOnClickListener(this.f303S);
        if (!TextUtils.isEmpty(this.f323t) || this.f325v != null) {
            this.f322s.setText(this.f323t);
            Drawable drawable2 = this.f325v;
            if (drawable2 != null) {
                int i2 = this.f307d;
                drawable2.setBounds(0, 0, i2, i2);
                this.f322s.setCompoundDrawables(this.f325v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f322s.setVisibility(0);
            z |= true;
        } else {
            this.f322s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f326w = button3;
        button3.setOnClickListener(this.f303S);
        if (!TextUtils.isEmpty(this.f327x) || this.f329z != null) {
            this.f326w.setText(this.f327x);
            Drawable drawable3 = this.f321r;
            if (drawable3 != null) {
                int i3 = this.f307d;
                drawable3.setBounds(0, 0, i3, i3);
                this.f318o.setCompoundDrawables(this.f321r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f326w.setVisibility(0);
            z |= true;
        } else {
            this.f326w.setVisibility(8);
        }
        if (m331a(this.f304a)) {
            if (z) {
                m330a(this.f318o);
            } else if (z) {
                m330a(this.f322s);
            } else if (z) {
                m330a(this.f326w);
            }
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m330a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
