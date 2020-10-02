package com.google.android.exoplayer2.p072ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a */
    private final int f8577a;

    /* renamed from: b */
    private final LayoutInflater f8578b;

    /* renamed from: c */
    private final CheckedTextView f8579c;

    /* renamed from: d */
    private final CheckedTextView f8580d;

    /* renamed from: e */
    private final C3063a f8581e;

    /* renamed from: f */
    private boolean f8582f;

    /* renamed from: g */
    private CheckedTextView[][] f8583g;

    /* renamed from: h */
    private boolean f8584h;

    /* renamed from: i */
    private DefaultTrackSelector$SelectionOverride f8585i;

    /* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$a */
    private class C3063a implements View.OnClickListener {
        private C3063a() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.m10098a(view);
        }

        /* synthetic */ C3063a(TrackSelectionView trackSelectionView, C3068d dVar) {
            this();
        }
    }

    public TrackSelectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: b */
    private void m10101b() {
        this.f8584h = true;
        this.f8585i = null;
    }

    /* renamed from: c */
    private void m10104c() {
        this.f8579c.setChecked(this.f8584h);
        this.f8580d.setChecked(!this.f8584h && this.f8585i == null);
        int i = 0;
        while (i < this.f8583g.length) {
            int i2 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.f8583g;
                if (i2 >= checkedTextViewArr[i].length) {
                    break;
                }
                CheckedTextView checkedTextView = checkedTextViewArr[i][i2];
                DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = this.f8585i;
                checkedTextView.setChecked(defaultTrackSelector$SelectionOverride != null && defaultTrackSelector$SelectionOverride.f8457a == i && defaultTrackSelector$SelectionOverride.mo13037a(i2));
                i2++;
            }
            i++;
        }
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10098a(View view) {
        if (view == this.f8579c) {
            m10101b();
        } else if (view == this.f8580d) {
            m10097a();
        } else {
            m10102b(view);
        }
        m10104c();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        this.f8577a = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        this.f8578b = LayoutInflater.from(context);
        this.f8581e = new C3063a(this, (C3068d) null);
        new C3064a(getResources());
        CheckedTextView checkedTextView = (CheckedTextView) this.f8578b.inflate(17367055, this, false);
        this.f8579c = checkedTextView;
        checkedTextView.setBackgroundResource(this.f8577a);
        this.f8579c.setText(R$string.exo_track_selection_none);
        this.f8579c.setEnabled(false);
        this.f8579c.setFocusable(true);
        this.f8579c.setOnClickListener(this.f8581e);
        this.f8579c.setVisibility(8);
        addView(this.f8579c);
        addView(this.f8578b.inflate(R$layout.exo_list_divider, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) this.f8578b.inflate(17367055, this, false);
        this.f8580d = checkedTextView2;
        checkedTextView2.setBackgroundResource(this.f8577a);
        this.f8580d.setText(R$string.exo_track_selection_auto);
        this.f8580d.setEnabled(false);
        this.f8580d.setFocusable(true);
        this.f8580d.setOnClickListener(this.f8581e);
        addView(this.f8580d);
    }

    /* renamed from: b */
    private void m10102b(View view) {
        this.f8584h = false;
        Pair pair = (Pair) view.getTag();
        int intValue = ((Integer) pair.first).intValue();
        int intValue2 = ((Integer) pair.second).intValue();
        DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = this.f8585i;
        if (defaultTrackSelector$SelectionOverride == null || defaultTrackSelector$SelectionOverride.f8457a != intValue || !this.f8582f) {
            this.f8585i = new DefaultTrackSelector$SelectionOverride(intValue, intValue2);
            return;
        }
        int i = defaultTrackSelector$SelectionOverride.f8459c;
        int[] iArr = defaultTrackSelector$SelectionOverride.f8458b;
        if (!((CheckedTextView) view).isChecked()) {
            this.f8585i = new DefaultTrackSelector$SelectionOverride(intValue, m10100a(iArr, intValue2));
        } else if (i == 1) {
            this.f8585i = null;
            this.f8584h = true;
        } else {
            this.f8585i = new DefaultTrackSelector$SelectionOverride(intValue, m10103b(iArr, intValue2));
        }
    }

    /* renamed from: a */
    private void m10097a() {
        this.f8584h = false;
        this.f8585i = null;
    }

    /* renamed from: a */
    private static int[] m10100a(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i;
        return copyOf;
    }

    /* renamed from: b */
    private static int[] m10103b(int[] iArr, int i) {
        int[] iArr2 = new int[(iArr.length - 1)];
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 != i) {
                iArr2[i2] = i3;
                i2++;
            }
        }
        return iArr2;
    }
}
