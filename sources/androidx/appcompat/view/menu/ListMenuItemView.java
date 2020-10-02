package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0499n;
import androidx.appcompat.widget.C0598g0;
import androidx.core.p020f.C0839t;

public class ListMenuItemView extends LinearLayout implements C0499n.C0500a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    private C0486i f727a;

    /* renamed from: b */
    private ImageView f728b;

    /* renamed from: c */
    private RadioButton f729c;

    /* renamed from: d */
    private TextView f730d;

    /* renamed from: e */
    private CheckBox f731e;

    /* renamed from: f */
    private TextView f732f;

    /* renamed from: g */
    private ImageView f733g;

    /* renamed from: h */
    private ImageView f734h;

    /* renamed from: i */
    private LinearLayout f735i;

    /* renamed from: j */
    private Drawable f736j;

    /* renamed from: k */
    private int f737k;

    /* renamed from: l */
    private Context f738l;

    /* renamed from: m */
    private boolean f739m;

    /* renamed from: n */
    private Drawable f740n;

    /* renamed from: o */
    private boolean f741o;

    /* renamed from: p */
    private LayoutInflater f742p;

    /* renamed from: q */
    private boolean f743q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    /* renamed from: d */
    private void m819d(boolean z) {
        ImageView imageView = this.f733g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: e */
    private void m820e() {
        ImageView imageView = (ImageView) m817b().inflate(R$layout.abc_list_menu_item_icon, this, false);
        this.f728b = imageView;
        m816a((View) imageView, 0);
    }

    /* renamed from: f */
    private void m821f() {
        RadioButton radioButton = (RadioButton) m817b().inflate(R$layout.abc_list_menu_item_radio, this, false);
        this.f729c = radioButton;
        m815a((View) radioButton);
    }

    /* renamed from: a */
    public void mo2367a(C0486i iVar, int i) {
        this.f727a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        mo2387a(iVar.mo2591a((C0499n.C0500a) this));
        mo2388a(iVar.isCheckable());
        mo2389a(iVar.mo2626l(), iVar.mo2597c());
        mo2386a(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        m819d(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f734h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f734h.getLayoutParams();
            rect.top += this.f734h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    /* renamed from: b */
    public void mo2391b(boolean z) {
        this.f743q = z;
        this.f739m = z;
    }

    /* renamed from: c */
    public void mo2392c(boolean z) {
        ImageView imageView = this.f734h;
        if (imageView != null) {
            imageView.setVisibility((this.f741o || !z) ? 8 : 0);
        }
    }

    /* renamed from: c */
    public boolean mo2370c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C0839t.m2696a((View) this, this.f736j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f730d = textView;
        int i = this.f737k;
        if (i != -1) {
            textView.setTextAppearance(this.f738l, i);
        }
        this.f732f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f733g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f740n);
        }
        this.f734h = (ImageView) findViewById(R$id.group_divider);
        this.f735i = (LinearLayout) findViewById(R$id.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f728b != null && this.f739m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f728b.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0598g0 a = C0598g0.m1610a(getContext(), attributeSet, R$styleable.MenuView, i, 0);
        this.f736j = a.mo3437b(R$styleable.MenuView_android_itemBackground);
        this.f737k = a.mo3446g(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f739m = a.mo3435a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f738l = context;
        this.f740n = a.mo3437b(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.f741o = obtainStyledAttributes.hasValue(0);
        a.mo3434a();
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private LayoutInflater m817b() {
        if (this.f742p == null) {
            this.f742p = LayoutInflater.from(getContext());
        }
        return this.f742p;
    }

    /* renamed from: d */
    private void m818d() {
        CheckBox checkBox = (CheckBox) m817b().inflate(R$layout.abc_list_menu_item_checkbox, this, false);
        this.f731e = checkBox;
        m815a((View) checkBox);
    }

    /* renamed from: a */
    private void m815a(View view) {
        m816a(view, -1);
    }

    /* renamed from: a */
    private void m816a(View view, int i) {
        LinearLayout linearLayout = this.f735i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    /* renamed from: a */
    public void mo2387a(CharSequence charSequence) {
        if (charSequence != null) {
            this.f730d.setText(charSequence);
            if (this.f730d.getVisibility() != 0) {
                this.f730d.setVisibility(0);
            }
        } else if (this.f730d.getVisibility() != 8) {
            this.f730d.setVisibility(8);
        }
    }

    /* renamed from: a */
    public C0486i mo2363a() {
        return this.f727a;
    }

    /* renamed from: a */
    public void mo2388a(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f729c != null || this.f731e != null) {
            if (this.f727a.mo2617h()) {
                if (this.f729c == null) {
                    m821f();
                }
                compoundButton2 = this.f729c;
                compoundButton = this.f731e;
            } else {
                if (this.f731e == null) {
                    m818d();
                }
                compoundButton2 = this.f731e;
                compoundButton = this.f729c;
            }
            if (z) {
                compoundButton2.setChecked(this.f727a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f731e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f729c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void mo2389a(boolean z, char c) {
        int i = (!z || !this.f727a.mo2626l()) ? 8 : 0;
        if (i == 0) {
            this.f732f.setText(this.f727a.mo2599d());
        }
        if (this.f732f.getVisibility() != i) {
            this.f732f.setVisibility(i);
        }
    }

    /* renamed from: a */
    public void mo2386a(Drawable drawable) {
        boolean z = this.f727a.mo2625k() || this.f743q;
        if (!z && !this.f739m) {
            return;
        }
        if (this.f728b != null || drawable != null || this.f739m) {
            if (this.f728b == null) {
                m820e();
            }
            if (drawable != null || this.f739m) {
                ImageView imageView = this.f728b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f728b.getVisibility() != 0) {
                    this.f728b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f728b.setVisibility(8);
        }
    }
}
