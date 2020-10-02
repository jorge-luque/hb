package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.appcompat.widget.C0633w;
import androidx.core.p013a.C0680a;

/* renamed from: androidx.appcompat.widget.g */
/* compiled from: AppCompatDrawableManager */
public final class C0596g {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PorterDuff.Mode f1434b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private static C0596g f1435c;

    /* renamed from: a */
    private C0633w f1436a;

    /* renamed from: androidx.appcompat.widget.g$a */
    /* compiled from: AppCompatDrawableManager */
    static class C0597a implements C0633w.C0638e {

        /* renamed from: a */
        private final int[] f1437a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b */
        private final int[] f1438b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c */
        private final int[] f1439c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl_dark, R$drawable.abc_text_select_handle_middle_mtrl_dark, R$drawable.abc_text_select_handle_right_mtrl_dark, R$drawable.abc_text_select_handle_left_mtrl_light, R$drawable.abc_text_select_handle_middle_mtrl_light, R$drawable.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d */
        private final int[] f1440d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e */
        private final int[] f1441e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f */
        private final int[] f1442f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        C0597a() {
        }

        /* renamed from: a */
        private ColorStateList m1596a(Context context) {
            return m1600b(context, 0);
        }

        /* renamed from: b */
        private ColorStateList m1599b(Context context) {
            return m1600b(context, C0575b0.m1509b(context, R$attr.colorAccent));
        }

        /* renamed from: c */
        private ColorStateList m1601c(Context context) {
            return m1600b(context, C0575b0.m1509b(context, R$attr.colorButtonNormal));
        }

        /* renamed from: d */
        private ColorStateList m1602d(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList c = C0575b0.m1510c(context, R$attr.colorSwitchThumbNormal);
            if (c == null || !c.isStateful()) {
                iArr[0] = C0575b0.f1359b;
                iArr2[0] = C0575b0.m1506a(context, R$attr.colorSwitchThumbNormal);
                iArr[1] = C0575b0.f1362e;
                iArr2[1] = C0575b0.m1509b(context, R$attr.colorControlActivated);
                iArr[2] = C0575b0.f1363f;
                iArr2[2] = C0575b0.m1509b(context, R$attr.colorSwitchThumbNormal);
            } else {
                iArr[0] = C0575b0.f1359b;
                iArr2[0] = c.getColorForState(iArr[0], 0);
                iArr[1] = C0575b0.f1362e;
                iArr2[1] = C0575b0.m1509b(context, R$attr.colorControlActivated);
                iArr[2] = C0575b0.f1363f;
                iArr2[2] = c.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        /* renamed from: a */
        public Drawable mo3427a(C0633w wVar, Context context, int i) {
            if (i != R$drawable.abc_cab_background_top_material) {
                return null;
            }
            return new LayerDrawable(new Drawable[]{wVar.mo3580a(context, R$drawable.abc_cab_background_internal_bg), wVar.mo3580a(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
        }

        /* renamed from: b */
        private ColorStateList m1600b(Context context, int i) {
            int b = C0575b0.m1509b(context, R$attr.colorControlHighlight);
            int a = C0575b0.m1506a(context, R$attr.colorButtonNormal);
            return new ColorStateList(new int[][]{C0575b0.f1359b, C0575b0.f1361d, C0575b0.f1360c, C0575b0.f1363f}, new int[]{a, C0680a.m2099b(b, i), C0680a.m2099b(b, i), i});
        }

        /* renamed from: a */
        private void m1597a(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (C0621q.m1807a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0596g.f1434b;
            }
            drawable.setColorFilter(C0596g.m1588a(i, mode));
        }

        /* renamed from: a */
        private boolean m1598a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public ColorStateList mo3425a(Context context, int i) {
            if (i == R$drawable.abc_edit_text_material) {
                return C0383a.m322b(context, R$color.abc_tint_edittext);
            }
            if (i == R$drawable.abc_switch_track_mtrl_alpha) {
                return C0383a.m322b(context, R$color.abc_tint_switch_track);
            }
            if (i == R$drawable.abc_switch_thumb_material) {
                return m1602d(context);
            }
            if (i == R$drawable.abc_btn_default_mtrl_shape) {
                return m1601c(context);
            }
            if (i == R$drawable.abc_btn_borderless_material) {
                return m1596a(context);
            }
            if (i == R$drawable.abc_btn_colored_material) {
                return m1599b(context);
            }
            if (i == R$drawable.abc_spinner_mtrl_am_alpha || i == R$drawable.abc_spinner_textfield_background_material) {
                return C0383a.m322b(context, R$color.abc_tint_spinner);
            }
            if (m1598a(this.f1438b, i)) {
                return C0575b0.m1510c(context, R$attr.colorControlNormal);
            }
            if (m1598a(this.f1441e, i)) {
                return C0383a.m322b(context, R$color.abc_tint_default);
            }
            if (m1598a(this.f1442f, i)) {
                return C0383a.m322b(context, R$color.abc_tint_btn_checkable);
            }
            if (i == R$drawable.abc_seekbar_thumb_material) {
                return C0383a.m322b(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* renamed from: b */
        public boolean mo3429b(Context context, int i, Drawable drawable) {
            if (i == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m1597a(layerDrawable.findDrawableByLayerId(16908288), C0575b0.m1509b(context, R$attr.colorControlNormal), C0596g.f1434b);
                m1597a(layerDrawable.findDrawableByLayerId(16908303), C0575b0.m1509b(context, R$attr.colorControlNormal), C0596g.f1434b);
                m1597a(layerDrawable.findDrawableByLayerId(16908301), C0575b0.m1509b(context, R$attr.colorControlActivated), C0596g.f1434b);
                return true;
            } else if (i != R$drawable.abc_ratingbar_material && i != R$drawable.abc_ratingbar_indicator_material && i != R$drawable.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m1597a(layerDrawable2.findDrawableByLayerId(16908288), C0575b0.m1506a(context, R$attr.colorControlNormal), C0596g.f1434b);
                m1597a(layerDrawable2.findDrawableByLayerId(16908303), C0575b0.m1509b(context, R$attr.colorControlActivated), C0596g.f1434b);
                m1597a(layerDrawable2.findDrawableByLayerId(16908301), C0575b0.m1509b(context, R$attr.colorControlActivated), C0596g.f1434b);
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo3428a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0596g.f1434b
                int[] r1 = r6.f1437a
                boolean r1 = r6.m1598a((int[]) r1, (int) r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = androidx.appcompat.R$attr.colorControlNormal
            L_0x0014:
                r8 = -1
            L_0x0015:
                r1 = 1
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f1439c
                boolean r1 = r6.m1598a((int[]) r1, (int) r8)
                if (r1 == 0) goto L_0x0022
                int r2 = androidx.appcompat.R$attr.colorControlActivated
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f1440d
                boolean r1 = r6.m1598a((int[]) r1, (int) r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = -1
                r1 = 0
                r2 = 0
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.C0621q.m1807a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.C0575b0.m1509b(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.C0596g.m1588a((int) r7, (android.graphics.PorterDuff.Mode) r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0596g.C0597a.mo3428a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        /* renamed from: a */
        public PorterDuff.Mode mo3426a(int i) {
            if (i == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    /* renamed from: b */
    public static synchronized C0596g m1590b() {
        C0596g gVar;
        synchronized (C0596g.class) {
            if (f1435c == null) {
                m1591c();
            }
            gVar = f1435c;
        }
        return gVar;
    }

    /* renamed from: c */
    public static synchronized void m1591c() {
        synchronized (C0596g.class) {
            if (f1435c == null) {
                C0596g gVar = new C0596g();
                f1435c = gVar;
                gVar.f1436a = C0633w.m1854a();
                f1435c.f1436a.mo3584a((C0633w.C0638e) new C0597a());
            }
        }
    }

    /* renamed from: a */
    public synchronized Drawable mo3421a(Context context, int i) {
        return this.f1436a.mo3580a(context, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo3422a(Context context, int i, boolean z) {
        return this.f1436a.mo3581a(context, i, z);
    }

    /* renamed from: a */
    public synchronized void mo3423a(Context context) {
        this.f1436a.mo3583a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized ColorStateList mo3424b(Context context, int i) {
        return this.f1436a.mo3586b(context, i);
    }

    /* renamed from: a */
    static void m1589a(Drawable drawable, C0593e0 e0Var, int[] iArr) {
        C0633w.m1856a(drawable, e0Var, iArr);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m1588a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a;
        synchronized (C0596g.class) {
            a = C0633w.m1850a(i, mode);
        }
        return a;
    }
}
