package com.google.protobuf;

public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public UninitializedMessageException(C4054u uVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    /* renamed from: a */
    public InvalidProtocolBufferException mo28002a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
