package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.p019e.C0795h;

/* renamed from: androidx.appcompat.widget.l */
/* compiled from: AppCompatTextClassifierHelper */
final class C0611l {

    /* renamed from: a */
    private TextView f1501a;

    /* renamed from: b */
    private TextClassifier f1502b;

    C0611l(TextView textView) {
        C0795h.m2503a(textView);
        this.f1501a = textView;
    }

    /* renamed from: a */
    public void mo3508a(TextClassifier textClassifier) {
        this.f1502b = textClassifier;
    }

    /* renamed from: a */
    public TextClassifier mo3507a() {
        TextClassifier textClassifier = this.f1502b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1501a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
