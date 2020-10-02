package com.google.zxing;

public final class FormatException extends ReaderException {

    /* renamed from: c */
    private static final FormatException f10866c;

    static {
        FormatException formatException = new FormatException();
        f10866c = formatException;
        formatException.setStackTrace(ReaderException.f10868b);
    }

    private FormatException() {
    }

    /* renamed from: a */
    public static FormatException m13534a() {
        return ReaderException.f10867a ? new FormatException() : f10866c;
    }
}
