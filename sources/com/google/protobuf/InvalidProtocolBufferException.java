package com.google.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    public InvalidProtocolBufferException(String str) {
        super(str);
    }

    /* renamed from: a */
    static InvalidProtocolBufferException m13210a() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: b */
    static InvalidProtocolBufferException m13211b() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: c */
    static InvalidProtocolBufferException m13212c() {
        return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }

    /* renamed from: d */
    static InvalidProtocolBufferException m13213d() {
        return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    /* renamed from: e */
    static InvalidProtocolBufferException m13214e() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: f */
    static InvalidProtocolBufferException m13215f() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: g */
    static InvalidProtocolBufferException m13216g() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: h */
    static InvalidProtocolBufferException m13217h() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* renamed from: i */
    static InvalidProtocolBufferException m13218i() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: a */
    public InvalidProtocolBufferException mo28001a(C4054u uVar) {
        return this;
    }
}
