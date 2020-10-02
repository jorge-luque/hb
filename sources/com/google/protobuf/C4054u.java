package com.google.protobuf;

import java.io.IOException;

/* renamed from: com.google.protobuf.u */
/* compiled from: MessageLite */
public interface C4054u extends C4056v {

    /* renamed from: com.google.protobuf.u$a */
    /* compiled from: MessageLite */
    public interface C4055a extends C4056v, Cloneable {
        C4054u build();

        C4055a mergeFrom(C4054u uVar);
    }

    C4058x<? extends C4054u> getParserForType();

    int getSerializedSize();

    C4055a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
