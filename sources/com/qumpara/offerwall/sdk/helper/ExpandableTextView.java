package com.qumpara.offerwall.sdk.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

public class ExpandableTextView extends TextView {
    public static int DEFAULT_TRIM_LENGTH = 200;
    private static final String ELLIPSIS = ".....";
    private TextView.BufferType bufferType;
    private boolean isFullText;
    private CharSequence originalText;
    private int trimLength;
    private CharSequence trimmedText;

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private CharSequence getDisplayableText() {
        return this.isFullText ? this.originalText : this.trimmedText;
    }

    private CharSequence getTrimmedText(CharSequence charSequence) {
        CharSequence charSequence2 = this.originalText;
        if (charSequence2 == null || charSequence2.length() <= this.trimLength) {
            return this.originalText;
        }
        return new SpannableStringBuilder(this.originalText, 0, this.trimLength + 1).append(ELLIPSIS);
    }

    public static void setDefaultTrimLength(int i) {
        if (i > 0) {
            DEFAULT_TRIM_LENGTH = i;
        }
    }

    private void setText() {
        super.setText(getDisplayableText(), this.bufferType);
    }

    public CharSequence getOriginalText() {
        return this.originalText;
    }

    public int getTrimLength() {
        return this.trimLength;
    }

    public void inverseActions() {
        this.isFullText = !this.isFullText;
        setText();
    }

    public boolean isFullText() {
        return this.isFullText;
    }

    public void setTrimLength(int i) {
        this.trimLength = i;
        this.trimmedText = getTrimmedText(this.originalText);
        setText();
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFullText = false;
        this.trimLength = DEFAULT_TRIM_LENGTH;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType2) {
        this.originalText = charSequence;
        this.trimmedText = getTrimmedText(charSequence);
        this.bufferType = bufferType2;
        setText();
    }
}
