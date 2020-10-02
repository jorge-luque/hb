package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* renamed from: androidx.core.widget.e */
/* compiled from: ImageViewCompat */
public class C0875e {
    /* renamed from: a */
    public static ColorStateList m2924a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof C0883l) {
            return ((C0883l) imageView).mo2976a();
        }
        return null;
    }

    /* renamed from: b */
    public static PorterDuff.Mode m2927b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof C0883l) {
            return ((C0883l) imageView).mo2979c();
        }
        return null;
    }

    /* renamed from: a */
    public static void m2925a(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21 && (drawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof C0883l) {
            ((C0883l) imageView).mo2977a(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2926a(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21 && (drawable = imageView.getDrawable()) != null && imageView.getImageTintList() != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView instanceof C0883l) {
            ((C0883l) imageView).mo2978a(mode);
        }
    }
}
