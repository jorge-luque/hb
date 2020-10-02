package androidx.vectordrawable.p028a.p029a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.p017c.C0784g;
import androidx.core.graphics.drawable.C0857a;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p075d.p080b.C3191a;

/* renamed from: androidx.vectordrawable.a.a.c */
/* compiled from: AnimatedVectorDrawableCompat */
public class C1132c extends C1141h implements C1131b {

    /* renamed from: b */
    private C1134b f3088b;

    /* renamed from: c */
    private Context f3089c;

    /* renamed from: d */
    private ArgbEvaluator f3090d;

    /* renamed from: e */
    final Drawable.Callback f3091e;

    /* renamed from: androidx.vectordrawable.a.a.c$a */
    /* compiled from: AnimatedVectorDrawableCompat */
    class C1133a implements Drawable.Callback {
        C1133a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            C1132c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            C1132c.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            C1132c.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.c$b */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1134b extends Drawable.ConstantState {

        /* renamed from: a */
        int f3093a;

        /* renamed from: b */
        C1142i f3094b;

        /* renamed from: c */
        AnimatorSet f3095c;

        /* renamed from: d */
        ArrayList<Animator> f3096d;

        /* renamed from: e */
        C3191a<Animator, String> f3097e;

        public C1134b(Context context, C1134b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f3093a = bVar.f3093a;
                C1142i iVar = bVar.f3094b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f3094b = (C1142i) constantState.newDrawable(resources);
                    } else {
                        this.f3094b = (C1142i) constantState.newDrawable();
                    }
                    C1142i iVar2 = this.f3094b;
                    iVar2.mutate();
                    C1142i iVar3 = iVar2;
                    this.f3094b = iVar3;
                    iVar3.setCallback(callback);
                    this.f3094b.setBounds(bVar.f3094b.getBounds());
                    this.f3094b.mo6042a(false);
                }
                ArrayList<Animator> arrayList = bVar.f3096d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f3096d = new ArrayList<>(size);
                    this.f3097e = new C3191a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = bVar.f3096d.get(i);
                        Animator clone = animator.clone();
                        String str = bVar.f3097e.get(animator);
                        clone.setTarget(this.f3094b.mo6041a(str));
                        this.f3096d.add(clone);
                        this.f3097e.put(clone, str);
                    }
                    mo6013a();
                }
            }
        }

        /* renamed from: a */
        public void mo6013a() {
            if (this.f3095c == null) {
                this.f3095c = new AnimatorSet();
            }
            this.f3095c.playTogether(this.f3096d);
        }

        public int getChangingConfigurations() {
            return this.f3093a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    C1132c() {
        this((Context) null, (C1134b) null, (Resources) null);
    }

    /* renamed from: a */
    public static C1132c m4629a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C1132c cVar = new C1132c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2805a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2809a(drawable);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3088b.f3094b.draw(canvas);
        if (this.f3088b.f3095c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2811b(drawable);
        }
        return this.f3088b.f3094b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3088b.f3093a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2813c(drawable);
        }
        return this.f3088b.f3094b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f3103a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C1135c(this.f3103a.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f3088b.f3094b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f3088b.f3094b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f3088b.f3094b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2806a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a = C0784g.m2472a(resources, theme, attributeSet, C1130a.f3080e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C1142i a2 = C1142i.m4662a(resources, resourceId, theme);
                        a2.mo6042a(false);
                        a2.setCallback(this.f3091e);
                        C1142i iVar = this.f3088b.f3094b;
                        if (iVar != null) {
                            iVar.setCallback((Drawable.Callback) null);
                        }
                        this.f3088b.f3094b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C1130a.f3081f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f3089c;
                        if (context != null) {
                            m4631a(string, C1137e.m4637a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f3088b.mo6013a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2815e(drawable);
        }
        return this.f3088b.f3094b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f3088b.f3095c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f3088b.f3094b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3088b.f3094b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f3088b.f3094b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f3088b.f3094b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f3088b.f3094b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2808a(drawable, z);
        } else {
            this.f3088b.f3094b.setAutoMirrored(z);
        }
    }

    public void setTint(int i) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2812b(drawable, i);
        } else {
            this.f3088b.f3094b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2804a(drawable, colorStateList);
        } else {
            this.f3088b.f3094b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2807a(drawable, mode);
        } else {
            this.f3088b.f3094b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f3088b.f3094b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f3088b.f3095c.isStarted()) {
            this.f3088b.f3095c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3088b.f3095c.end();
        }
    }

    private C1132c(Context context) {
        this(context, (C1134b) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3088b.f3094b.setColorFilter(colorFilter);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.c$c */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1135c extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f3098a;

        public C1135c(Drawable.ConstantState constantState) {
            this.f3098a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f3098a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3098a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C1132c cVar = new C1132c();
            Drawable newDrawable = this.f3098a.newDrawable();
            cVar.f3103a = newDrawable;
            newDrawable.setCallback(cVar.f3091e);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            C1132c cVar = new C1132c();
            Drawable newDrawable = this.f3098a.newDrawable(resources);
            cVar.f3103a = newDrawable;
            newDrawable.setCallback(cVar.f3091e);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1132c cVar = new C1132c();
            Drawable newDrawable = this.f3098a.newDrawable(resources, theme);
            cVar.f3103a = newDrawable;
            newDrawable.setCallback(cVar.f3091e);
            return cVar;
        }
    }

    private C1132c(Context context, C1134b bVar, Resources resources) {
        this.f3090d = null;
        this.f3091e = new C1133a();
        this.f3089c = context;
        if (bVar != null) {
            this.f3088b = bVar;
        } else {
            this.f3088b = new C1134b(context, bVar, this.f3091e, resources);
        }
    }

    /* renamed from: a */
    private void m4630a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m4630a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f3090d == null) {
                    this.f3090d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f3090d);
            }
        }
    }

    /* renamed from: a */
    private void m4631a(String str, Animator animator) {
        animator.setTarget(this.f3088b.f3094b.mo6041a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m4630a(animator);
        }
        C1134b bVar = this.f3088b;
        if (bVar.f3096d == null) {
            bVar.f3096d = new ArrayList<>();
            this.f3088b.f3097e = new C3191a<>();
        }
        this.f3088b.f3096d.add(animator);
        this.f3088b.f3097e.put(animator, str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
