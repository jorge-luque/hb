package androidx.core.p018d;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.p019e.C0790c;

/* renamed from: androidx.core.d.a */
/* compiled from: PrecomputedTextCompat */
public class C0785a implements Spannable {

    /* renamed from: a */
    private final Spannable f1983a;

    /* renamed from: b */
    private final C0786a f1984b;

    /* renamed from: c */
    private final PrecomputedText f1985c;

    /* renamed from: androidx.core.d.a$a */
    /* compiled from: PrecomputedTextCompat */
    public static final class C0786a {

        /* renamed from: a */
        private final TextPaint f1986a;

        /* renamed from: b */
        private final TextDirectionHeuristic f1987b;

        /* renamed from: c */
        private final int f1988c;

        /* renamed from: d */
        private final int f1989d;

        /* renamed from: androidx.core.d.a$a$a */
        /* compiled from: PrecomputedTextCompat */
        public static class C0787a {

            /* renamed from: a */
            private final TextPaint f1990a;

            /* renamed from: b */
            private TextDirectionHeuristic f1991b;

            /* renamed from: c */
            private int f1992c;

            /* renamed from: d */
            private int f1993d;

            public C0787a(TextPaint textPaint) {
                this.f1990a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1992c = 1;
                    this.f1993d = 1;
                } else {
                    this.f1993d = 0;
                    this.f1992c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1991b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1991b = null;
                }
            }

            /* renamed from: a */
            public C0787a mo4065a(int i) {
                this.f1992c = i;
                return this;
            }

            /* renamed from: b */
            public C0787a mo4068b(int i) {
                this.f1993d = i;
                return this;
            }

            /* renamed from: a */
            public C0787a mo4066a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1991b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: a */
            public C0786a mo4067a() {
                return new C0786a(this.f1990a, this.f1991b, this.f1992c, this.f1993d);
            }
        }

        @SuppressLint({"NewApi"})
        C0786a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f1986a = textPaint;
            this.f1987b = textDirectionHeuristic;
            this.f1988c = i;
            this.f1989d = i2;
        }

        /* renamed from: a */
        public int mo4057a() {
            return this.f1988c;
        }

        /* renamed from: b */
        public int mo4059b() {
            return this.f1989d;
        }

        /* renamed from: c */
        public TextDirectionHeuristic mo4060c() {
            return this.f1987b;
        }

        /* renamed from: d */
        public TextPaint mo4061d() {
            return this.f1986a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0786a)) {
                return false;
            }
            C0786a aVar = (C0786a) obj;
            if (!mo4058a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f1987b == aVar.mo4060c();
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return C0790c.m2493a(Float.valueOf(this.f1986a.getTextSize()), Float.valueOf(this.f1986a.getTextScaleX()), Float.valueOf(this.f1986a.getTextSkewX()), Float.valueOf(this.f1986a.getLetterSpacing()), Integer.valueOf(this.f1986a.getFlags()), this.f1986a.getTextLocales(), this.f1986a.getTypeface(), Boolean.valueOf(this.f1986a.isElegantTextHeight()), this.f1987b, Integer.valueOf(this.f1988c), Integer.valueOf(this.f1989d));
            } else if (i >= 21) {
                return C0790c.m2493a(Float.valueOf(this.f1986a.getTextSize()), Float.valueOf(this.f1986a.getTextScaleX()), Float.valueOf(this.f1986a.getTextSkewX()), Float.valueOf(this.f1986a.getLetterSpacing()), Integer.valueOf(this.f1986a.getFlags()), this.f1986a.getTextLocale(), this.f1986a.getTypeface(), Boolean.valueOf(this.f1986a.isElegantTextHeight()), this.f1987b, Integer.valueOf(this.f1988c), Integer.valueOf(this.f1989d));
            } else if (i >= 18) {
                return C0790c.m2493a(Float.valueOf(this.f1986a.getTextSize()), Float.valueOf(this.f1986a.getTextScaleX()), Float.valueOf(this.f1986a.getTextSkewX()), Integer.valueOf(this.f1986a.getFlags()), this.f1986a.getTextLocale(), this.f1986a.getTypeface(), this.f1987b, Integer.valueOf(this.f1988c), Integer.valueOf(this.f1989d));
            } else if (i >= 17) {
                return C0790c.m2493a(Float.valueOf(this.f1986a.getTextSize()), Float.valueOf(this.f1986a.getTextScaleX()), Float.valueOf(this.f1986a.getTextSkewX()), Integer.valueOf(this.f1986a.getFlags()), this.f1986a.getTextLocale(), this.f1986a.getTypeface(), this.f1987b, Integer.valueOf(this.f1988c), Integer.valueOf(this.f1989d));
            } else {
                return C0790c.m2493a(Float.valueOf(this.f1986a.getTextSize()), Float.valueOf(this.f1986a.getTextScaleX()), Float.valueOf(this.f1986a.getTextSkewX()), Integer.valueOf(this.f1986a.getFlags()), this.f1986a.getTypeface(), this.f1987b, Integer.valueOf(this.f1988c), Integer.valueOf(this.f1989d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1986a.getTextSize());
            sb.append(", textScaleX=" + this.f1986a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1986a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1986a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1986a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f1986a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f1986a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1986a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1986a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1987b);
            sb.append(", breakStrategy=" + this.f1988c);
            sb.append(", hyphenationFrequency=" + this.f1989d);
            sb.append("}");
            return sb.toString();
        }

        /* renamed from: a */
        public boolean mo4058a(C0786a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f1988c != aVar.mo4057a() || this.f1989d != aVar.mo4059b())) || this.f1986a.getTextSize() != aVar.mo4061d().getTextSize() || this.f1986a.getTextScaleX() != aVar.mo4061d().getTextScaleX() || this.f1986a.getTextSkewX() != aVar.mo4061d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f1986a.getLetterSpacing() != aVar.mo4061d().getLetterSpacing() || !TextUtils.equals(this.f1986a.getFontFeatureSettings(), aVar.mo4061d().getFontFeatureSettings()))) || this.f1986a.getFlags() != aVar.mo4061d().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.f1986a.getTextLocales().equals(aVar.mo4061d().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f1986a.getTextLocale().equals(aVar.mo4061d().getTextLocale())) {
                return false;
            }
            if (this.f1986a.getTypeface() == null) {
                if (aVar.mo4061d().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f1986a.getTypeface().equals(aVar.mo4061d().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public C0786a(PrecomputedText.Params params) {
            this.f1986a = params.getTextPaint();
            this.f1987b = params.getTextDirection();
            this.f1988c = params.getBreakStrategy();
            this.f1989d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }
    }

    /* renamed from: a */
    public C0786a mo4044a() {
        return this.f1984b;
    }

    /* renamed from: b */
    public PrecomputedText mo4045b() {
        Spannable spannable = this.f1983a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i) {
        return this.f1983a.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.f1983a.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f1983a.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f1983a.getSpanStart(obj);
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f1985c.getSpans(i, i2, cls);
        }
        return this.f1983a.getSpans(i, i2, cls);
    }

    public int length() {
        return this.f1983a.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f1983a.nextSpanTransition(i, i2, cls);
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f1985c.removeSpan(obj);
        } else {
            this.f1983a.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f1985c.setSpan(obj, i, i2, i3);
        } else {
            this.f1983a.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f1983a.subSequence(i, i2);
    }

    public String toString() {
        return this.f1983a.toString();
    }
}
