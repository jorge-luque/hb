package com.crashlytics.android.answers;

import com.crashlytics.android.answers.AnswersEvent;
import java.util.Map;
import p118io.fabric.sdk.android.C6059c;

public abstract class AnswersEvent<T extends AnswersEvent> {
    public static final int MAX_NUM_ATTRIBUTES = 20;
    public static final int MAX_STRING_LENGTH = 100;
    final AnswersAttributes customAttributes;
    final AnswersEventValidator validator;

    public AnswersEvent() {
        AnswersEventValidator answersEventValidator = new AnswersEventValidator(20, 100, C6059c.m19632h());
        this.validator = answersEventValidator;
        this.customAttributes = new AnswersAttributes(answersEventValidator);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getCustomAttributes() {
        return this.customAttributes.attributes;
    }

    public T putCustomAttribute(String str, String str2) {
        this.customAttributes.put(str, str2);
        return this;
    }

    public T putCustomAttribute(String str, Number number) {
        this.customAttributes.put(str, number);
        return this;
    }
}
