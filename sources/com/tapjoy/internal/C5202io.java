package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.io */
public final class C5202io extends RelativeLayout {

    /* renamed from: a */
    private C5166hr f14279a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C5205a f14280b;

    /* renamed from: c */
    private C4874aa f14281c = C4874aa.UNSPECIFIED;

    /* renamed from: d */
    private int f14282d = 0;

    /* renamed from: e */
    private int f14283e = 0;

    /* renamed from: f */
    private C5185ia f14284f = null;

    /* renamed from: g */
    private ArrayList f14285g = null;

    /* renamed from: h */
    private ArrayList f14286h = null;

    /* renamed from: com.tapjoy.internal.io$a */
    public interface C5205a {
        /* renamed from: a */
        void mo31313a();

        /* renamed from: a */
        void mo31314a(C5182hz hzVar);
    }

    public C5202io(Context context, C5166hr hrVar, C5205a aVar) {
        super(context);
        this.f14279a = hrVar;
        this.f14280b = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14280b.mo31313a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            int r1 = android.view.View.MeasureSpec.getSize(r17)
            int r2 = android.view.View.MeasureSpec.getSize(r18)
            if (r1 < r2) goto L_0x0018
            com.tapjoy.internal.aa r3 = r0.f14281c
            com.tapjoy.internal.aa r4 = com.tapjoy.internal.C4874aa.LANDSCAPE
            if (r3 == r4) goto L_0x0023
            r0.f14281c = r4
            r16.m17464a()
            goto L_0x0023
        L_0x0018:
            com.tapjoy.internal.aa r3 = r0.f14281c
            com.tapjoy.internal.aa r4 = com.tapjoy.internal.C4874aa.PORTRAIT
            if (r3 == r4) goto L_0x0023
            r0.f14281c = r4
            r16.m17464a()
        L_0x0023:
            int r3 = r0.f14282d
            if (r3 != r1) goto L_0x002b
            int r3 = r0.f14283e
            if (r3 == r2) goto L_0x00f1
        L_0x002b:
            r0.f14282d = r1
            r0.f14283e = r2
            float r1 = (float) r1
            float r2 = (float) r2
            com.tapjoy.internal.ia r3 = r0.f14284f
            r4 = 0
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 == 0) goto L_0x005d
            android.graphics.PointF r3 = r3.f14211b
            if (r3 == 0) goto L_0x005d
            float r6 = r3.y
            float r7 = r1 * r6
            float r3 = r3.x
            float r7 = r7 / r3
            float r7 = r7 / r2
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 >= 0) goto L_0x0052
            float r6 = r6 * r1
            float r6 = r6 / r3
            float r2 = r2 - r6
            float r2 = r2 / r5
            r3 = r2
            r2 = r6
            goto L_0x005e
        L_0x0052:
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x005d
            float r3 = r3 * r2
            float r3 = r3 / r6
            float r1 = r1 - r3
            float r1 = r1 / r5
            r4 = r1
            r1 = r3
        L_0x005d:
            r3 = 0
        L_0x005e:
            java.lang.Iterable r6 = com.tapjoy.internal.C4876ac.m16662a(r16)
            java.util.Iterator r6 = r6.iterator()
        L_0x0066:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f1
            java.lang.Object r7 = r6.next()
            android.view.View r7 = (android.view.View) r7
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
            java.lang.Object r7 = r7.getTag()
            com.tapjoy.internal.hz r7 = (com.tapjoy.internal.C5182hz) r7
            com.tapjoy.internal.ib r9 = r7.f14195a
            float r9 = r9.mo31351a(r1, r2)
            com.tapjoy.internal.ib r10 = r7.f14196b
            float r10 = r10.mo31351a(r1, r2)
            com.tapjoy.internal.ib r11 = r7.f14197c
            float r11 = r11.mo31351a(r1, r2)
            com.tapjoy.internal.ib r12 = r7.f14198d
            float r12 = r12.mo31351a(r1, r2)
            int r13 = r7.f14199e
            int r7 = r7.f14200f
            r14 = 14
            if (r13 != r14) goto L_0x00a4
            float r13 = r1 - r11
            float r13 = r13 / r5
            float r9 = r9 + r13
            r13 = 9
        L_0x00a4:
            r14 = 15
            r15 = 10
            if (r7 != r14) goto L_0x00b0
            float r7 = r2 - r12
            float r7 = r7 / r5
            float r10 = r10 + r7
            r7 = 10
        L_0x00b0:
            r14 = -1
            r8.addRule(r13, r14)
            r8.addRule(r7, r14)
            int r11 = java.lang.Math.round(r11)
            r8.width = r11
            int r11 = java.lang.Math.round(r12)
            r8.height = r11
            r11 = 9
            if (r13 != r11) goto L_0x00cf
            float r9 = r9 + r4
            int r9 = java.lang.Math.round(r9)
            r8.leftMargin = r9
            goto L_0x00da
        L_0x00cf:
            r11 = 11
            if (r13 != r11) goto L_0x00da
            float r9 = r9 + r4
            int r9 = java.lang.Math.round(r9)
            r8.rightMargin = r9
        L_0x00da:
            if (r7 != r15) goto L_0x00e4
            float r10 = r10 + r3
            int r7 = java.lang.Math.round(r10)
            r8.topMargin = r7
            goto L_0x0066
        L_0x00e4:
            r9 = 12
            if (r7 != r9) goto L_0x0066
            float r10 = r10 + r3
            int r7 = java.lang.Math.round(r10)
            r8.bottomMargin = r7
            goto L_0x0066
        L_0x00f1:
            super.onMeasure(r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5202io.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            ArrayList arrayList = this.f14286h;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C5191ig igVar = (C5191ig) ((WeakReference) it.next()).get();
                    if (igVar != null) {
                        igVar.setVisibility(4);
                        igVar.mo31356b();
                    }
                }
            }
            ArrayList arrayList2 = this.f14285g;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    C5191ig igVar2 = (C5191ig) ((WeakReference) it2.next()).get();
                    if (igVar2 != null) {
                        igVar2.setVisibility(0);
                        igVar2.mo31354a();
                    }
                }
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.f14285g;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                C5191ig igVar3 = (C5191ig) ((WeakReference) it3.next()).get();
                if (igVar3 != null) {
                    igVar3.mo31356b();
                }
            }
        }
        ArrayList arrayList4 = this.f14286h;
        if (arrayList4 != null) {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                C5191ig igVar4 = (C5191ig) ((WeakReference) it4.next()).get();
                if (igVar4 != null) {
                    igVar4.mo31356b();
                }
            }
        }
    }

    /* renamed from: a */
    private void m17464a() {
        C5191ig igVar;
        C5191ig igVar2;
        Iterator it = this.f14279a.f14153a.iterator();
        C5185ia iaVar = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C5185ia iaVar2 = (C5185ia) it.next();
            C4874aa aaVar = iaVar2.f14210a;
            if (aaVar == this.f14281c) {
                iaVar = iaVar2;
                break;
            } else if (aaVar == C4874aa.UNSPECIFIED) {
                iaVar = iaVar2;
            }
        }
        removeAllViews();
        ArrayList arrayList = this.f14285g;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C5191ig igVar3 = (C5191ig) ((WeakReference) it2.next()).get();
                if (igVar3 != null) {
                    igVar3.mo31357c();
                }
            }
            this.f14285g.clear();
        }
        ArrayList arrayList2 = this.f14286h;
        if (arrayList2 != null) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                C5191ig igVar4 = (C5191ig) ((WeakReference) it3.next()).get();
                if (igVar4 != null) {
                    igVar4.mo31357c();
                }
            }
            this.f14286h.clear();
        }
        if (iaVar != null) {
            this.f14284f = iaVar;
            Context context = getContext();
            Iterator it4 = iaVar.f14212c.iterator();
            while (it4.hasNext()) {
                C5182hz hzVar = (C5182hz) it4.next();
                RelativeLayout relativeLayout = new RelativeLayout(context);
                if (hzVar.f14206l.f14187c != null) {
                    C5191ig igVar5 = new C5191ig(context);
                    igVar5.setScaleType(ImageView.ScaleType.FIT_XY);
                    C5178hx hxVar = hzVar.f14206l;
                    igVar5.mo31355a(hxVar.f14188d, hxVar.f14187c);
                    if (this.f14285g == null) {
                        this.f14285g = new ArrayList();
                    }
                    this.f14285g.add(new WeakReference(igVar5));
                    igVar = igVar5;
                } else {
                    igVar = null;
                }
                C5178hx hxVar2 = hzVar.f14207m;
                if (hxVar2 == null || hxVar2.f14187c == null) {
                    igVar2 = null;
                } else {
                    C5191ig igVar6 = new C5191ig(context);
                    igVar6.setScaleType(ImageView.ScaleType.FIT_XY);
                    C5178hx hxVar3 = hzVar.f14207m;
                    igVar6.mo31355a(hxVar3.f14188d, hxVar3.f14187c);
                    if (this.f14286h == null) {
                        this.f14286h = new ArrayList();
                    }
                    this.f14286h.add(new WeakReference(igVar6));
                    igVar2 = igVar6;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                Bitmap bitmap = hzVar.f14206l.f14186b;
                C5178hx hxVar4 = hzVar.f14207m;
                Bitmap bitmap2 = hxVar4 != null ? hxVar4.f14186b : null;
                final BitmapDrawable bitmapDrawable = bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null;
                final BitmapDrawable bitmapDrawable2 = bitmap2 != null ? new BitmapDrawable((Resources) null, bitmap2) : null;
                if (bitmapDrawable != null) {
                    C4875ab.m16661a(relativeLayout, bitmapDrawable);
                }
                if (igVar != null) {
                    relativeLayout.addView(igVar, layoutParams2);
                    igVar.mo31354a();
                }
                if (igVar2 != null) {
                    relativeLayout.addView(igVar2, layoutParams2);
                    igVar2.setVisibility(4);
                }
                final C5191ig igVar7 = igVar2;
                final C5191ig igVar8 = igVar;
                relativeLayout.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        C5191ig igVar;
                        if (motionEvent.getAction() == 0) {
                            if (!(igVar7 == null && bitmapDrawable2 == null)) {
                                C5191ig igVar2 = igVar8;
                                if (igVar2 != null) {
                                    igVar2.mo31356b();
                                    igVar8.setVisibility(4);
                                }
                                C4875ab.m16661a(view, (Drawable) null);
                            }
                            BitmapDrawable bitmapDrawable = bitmapDrawable2;
                            if (bitmapDrawable != null) {
                                C4875ab.m16661a(view, bitmapDrawable);
                            } else {
                                C5191ig igVar3 = igVar7;
                                if (igVar3 != null) {
                                    igVar3.setVisibility(0);
                                    igVar7.mo31354a();
                                }
                            }
                        } else {
                            boolean z = true;
                            if (motionEvent.getAction() == 1) {
                                float x = motionEvent.getX();
                                float y = motionEvent.getY();
                                if (x >= 0.0f && x < ((float) view.getWidth()) && y >= 0.0f && y < ((float) view.getHeight())) {
                                    z = false;
                                }
                                if (z) {
                                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                    if (bitmapDrawable2 != null) {
                                        C4875ab.m16661a(view, bitmapDrawable2);
                                    } else if (bitmapDrawable2 != null) {
                                        C4875ab.m16661a(view, (Drawable) null);
                                    }
                                }
                                C5191ig igVar4 = igVar7;
                                if (igVar4 != null) {
                                    igVar4.mo31356b();
                                    igVar7.setVisibility(4);
                                }
                                if (!((igVar7 == null && bitmapDrawable2 == null) || (igVar = igVar8) == null || !z)) {
                                    igVar.setVisibility(0);
                                    igVar8.mo31354a();
                                }
                            }
                        }
                        return false;
                    }
                });
                final RelativeLayout relativeLayout2 = relativeLayout;
                final C5182hz hzVar2 = hzVar;
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        C5191ig igVar = igVar7;
                        if (igVar != null) {
                            igVar.mo31356b();
                            relativeLayout2.removeView(igVar7);
                        }
                        C5191ig igVar2 = igVar8;
                        if (igVar2 != null) {
                            igVar2.mo31356b();
                            relativeLayout2.removeView(igVar8);
                        }
                        C5202io.this.f14280b.mo31314a(hzVar2);
                    }
                });
                relativeLayout.setTag(hzVar);
                addView(relativeLayout, layoutParams);
            }
        }
    }
}
